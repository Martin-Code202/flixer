package org.chromium.net.impl;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.chromium.net.CronetException;
import org.chromium.net.InlineExecutionProhibitedException;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.chromium.net.impl.VersionSafeCallbacks;
/* access modifiers changed from: package-private */
@TargetApi(14)
public final class JavaUrlRequest extends UrlRequestBase {
    private static final String TAG = JavaUrlRequest.class.getSimpleName();
    private volatile int mAdditionalStatusDetails = -1;
    private final boolean mAllowDirectExecutor;
    private final AsyncUrlRequestCallback mCallbackAsync;
    private String mCurrentUrl;
    private HttpURLConnection mCurrentUrlConnection;
    private final Executor mExecutor;
    private String mInitialMethod;
    private OutputStreamDataSink mOutputStreamDataSink;
    private String mPendingRedirectUrl;
    private final Map<String, String> mRequestHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private ReadableByteChannel mResponseChannel;
    private final AtomicReference<State> mState = new AtomicReference<>(State.NOT_STARTED);
    private final int mTrafficStatsTag;
    private VersionSafeCallbacks.UploadDataProviderWrapper mUploadDataProvider;
    private Executor mUploadExecutor;
    private final AtomicBoolean mUploadProviderClosed = new AtomicBoolean(false);
    private final List<String> mUrlChain = new ArrayList();
    private UrlResponseInfoImpl mUrlResponseInfo;
    private final String mUserAgent;

    /* access modifiers changed from: package-private */
    public interface CheckedRunnable {
        void run();
    }

    enum SinkState {
        AWAITING_READ_RESULT,
        AWAITING_REWIND_RESULT,
        UPLOADING,
        NOT_STARTED
    }

    /* access modifiers changed from: package-private */
    public enum State {
        NOT_STARTED,
        STARTED,
        REDIRECT_RECEIVED,
        AWAITING_FOLLOW_REDIRECT,
        AWAITING_READ,
        READING,
        ERROR,
        COMPLETE,
        CANCELLED
    }

    static final class SerializingExecutor implements Executor {
        private final Runnable mRunTasks = new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.SerializingExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                synchronized (SerializingExecutor.this.mTaskQueue) {
                    if (!SerializingExecutor.this.mRunning) {
                        runnable = (Runnable) SerializingExecutor.this.mTaskQueue.pollFirst();
                        SerializingExecutor.this.mRunning = runnable != null;
                    } else {
                        return;
                    }
                }
                while (runnable != null) {
                    try {
                        runnable.run();
                        synchronized (SerializingExecutor.this.mTaskQueue) {
                            runnable = (Runnable) SerializingExecutor.this.mTaskQueue.pollFirst();
                            SerializingExecutor.this.mRunning = runnable != null;
                        }
                    } catch (Throwable th) {
                        synchronized (SerializingExecutor.this.mTaskQueue) {
                            SerializingExecutor.this.mRunning = false;
                            try {
                                SerializingExecutor.this.mUnderlyingExecutor.execute(SerializingExecutor.this.mRunTasks);
                            } catch (RejectedExecutionException e) {
                            }
                            throw th;
                        }
                    }
                }
            }
        };
        private boolean mRunning;
        private final ArrayDeque<Runnable> mTaskQueue = new ArrayDeque<>();
        private final Executor mUnderlyingExecutor;

        SerializingExecutor(Executor executor) {
            this.mUnderlyingExecutor = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            synchronized (this.mTaskQueue) {
                this.mTaskQueue.addLast(runnable);
                try {
                    this.mUnderlyingExecutor.execute(this.mRunTasks);
                } catch (RejectedExecutionException e) {
                    this.mTaskQueue.removeLast();
                }
            }
        }
    }

    JavaUrlRequest(UrlRequest.Callback callback, final Executor executor, Executor executor2, String str, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("URL is required");
        } else if (callback == null) {
            throw new NullPointerException("Listener is required");
        } else if (executor == null) {
            throw new NullPointerException("Executor is required");
        } else if (executor2 == null) {
            throw new NullPointerException("userExecutor is required");
        } else {
            this.mAllowDirectExecutor = z;
            this.mCallbackAsync = new AsyncUrlRequestCallback(callback, executor2);
            this.mTrafficStatsTag = TrafficStats.getThreadStatsTag();
            this.mExecutor = new SerializingExecutor(new Executor() { // from class: org.chromium.net.impl.JavaUrlRequest.1
                @Override // java.util.concurrent.Executor
                public void execute(final Runnable runnable) {
                    executor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int threadStatsTag = TrafficStats.getThreadStatsTag();
                            TrafficStats.setThreadStatsTag(JavaUrlRequest.this.mTrafficStatsTag);
                            try {
                                runnable.run();
                            } finally {
                                TrafficStats.setThreadStatsTag(threadStatsTag);
                            }
                        }
                    });
                }
            });
            this.mCurrentUrl = str;
            this.mUserAgent = str2;
        }
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String str) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        } else if ("OPTIONS".equalsIgnoreCase(str) || "GET".equalsIgnoreCase(str) || "HEAD".equalsIgnoreCase(str) || "POST".equalsIgnoreCase(str) || "PUT".equalsIgnoreCase(str) || "DELETE".equalsIgnoreCase(str) || "TRACE".equalsIgnoreCase(str) || "PATCH".equalsIgnoreCase(str)) {
            this.mInitialMethod = str;
        } else {
            throw new IllegalArgumentException("Invalid http method " + str);
        }
    }

    private void checkNotStarted() {
        State state = this.mState.get();
        if (state != State.NOT_STARTED) {
            throw new IllegalStateException("Request is already started. State is: " + state);
        }
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void addHeader(String str, String str2) {
        checkNotStarted();
        if (!isValidHeaderName(str) || str2.contains("\r\n")) {
            throw new IllegalArgumentException("Invalid header " + str + "=" + str2);
        }
        if (this.mRequestHeaders.containsKey(str)) {
            this.mRequestHeaders.remove(str);
        }
        this.mRequestHeaders.put(str, str2);
    }

    private boolean isValidHeaderName(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\'':
                case '(':
                case ')':
                case ',':
                case '/':
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                case '[':
                case '\\':
                case ']':
                case '{':
                case '}':
                    return false;
                default:
                    if (Character.isISOControl(charAt) || Character.isWhitespace(charAt)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        } else if (!this.mRequestHeaders.containsKey("Content-Type")) {
            throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
        } else {
            checkNotStarted();
            if (this.mInitialMethod == null) {
                this.mInitialMethod = "POST";
            }
            this.mUploadDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(uploadDataProvider);
            if (this.mAllowDirectExecutor) {
                this.mUploadExecutor = executor;
            } else {
                this.mUploadExecutor = new DirectPreventingExecutor(executor);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class OutputStreamDataSink extends UploadDataSink {
        ByteBuffer mBuffer;
        final Executor mExecutor;
        WritableByteChannel mOutputChannel;
        final AtomicBoolean mOutputChannelClosed = new AtomicBoolean(false);
        final AtomicReference<SinkState> mSinkState = new AtomicReference<>(SinkState.NOT_STARTED);
        long mTotalBytes;
        final VersionSafeCallbacks.UploadDataProviderWrapper mUploadProvider;
        final HttpURLConnection mUrlConnection;
        OutputStream mUrlConnectionOutputStream;
        final Executor mUserUploadExecutor;
        long mWrittenBytes = 0;

        OutputStreamDataSink(final Executor executor, Executor executor2, HttpURLConnection httpURLConnection, VersionSafeCallbacks.UploadDataProviderWrapper uploadDataProviderWrapper) {
            this.mUserUploadExecutor = new Executor(JavaUrlRequest.this) { // from class: org.chromium.net.impl.JavaUrlRequest.OutputStreamDataSink.1
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    try {
                        executor.execute(runnable);
                    } catch (RejectedExecutionException e) {
                        JavaUrlRequest.this.enterUploadErrorState(e);
                    }
                }
            };
            this.mExecutor = executor2;
            this.mUrlConnection = httpURLConnection;
            this.mUploadProvider = uploadDataProviderWrapper;
        }

        @Override // org.chromium.net.UploadDataSink
        @SuppressLint({"DefaultLocale"})
        public void onReadSucceeded(final boolean z) {
            if (!this.mSinkState.compareAndSet(SinkState.AWAITING_READ_RESULT, SinkState.UPLOADING)) {
                throw new IllegalStateException("Not expecting a read result, expecting: " + this.mSinkState.get());
            }
            this.mExecutor.execute(JavaUrlRequest.this.errorSetting(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.OutputStreamDataSink.2
                @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    OutputStreamDataSink.this.mBuffer.flip();
                    if (OutputStreamDataSink.this.mTotalBytes == -1 || OutputStreamDataSink.this.mTotalBytes - OutputStreamDataSink.this.mWrittenBytes >= ((long) OutputStreamDataSink.this.mBuffer.remaining())) {
                        while (OutputStreamDataSink.this.mBuffer.hasRemaining()) {
                            OutputStreamDataSink.this.mWrittenBytes += (long) OutputStreamDataSink.this.mOutputChannel.write(OutputStreamDataSink.this.mBuffer);
                        }
                        OutputStreamDataSink.this.mUrlConnectionOutputStream.flush();
                        if (OutputStreamDataSink.this.mWrittenBytes < OutputStreamDataSink.this.mTotalBytes || (OutputStreamDataSink.this.mTotalBytes == -1 && !z)) {
                            OutputStreamDataSink.this.mBuffer.clear();
                            OutputStreamDataSink.this.mSinkState.set(SinkState.AWAITING_READ_RESULT);
                            OutputStreamDataSink.this.executeOnUploadExecutor(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.OutputStreamDataSink.2.1
                                @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                                public void run() {
                                    OutputStreamDataSink.this.mUploadProvider.read(OutputStreamDataSink.this, OutputStreamDataSink.this.mBuffer);
                                }
                            });
                        } else if (OutputStreamDataSink.this.mTotalBytes == -1) {
                            OutputStreamDataSink.this.finish();
                        } else if (OutputStreamDataSink.this.mTotalBytes == OutputStreamDataSink.this.mWrittenBytes) {
                            OutputStreamDataSink.this.finish();
                        } else {
                            JavaUrlRequest.this.enterUploadErrorState(new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(OutputStreamDataSink.this.mWrittenBytes), Long.valueOf(OutputStreamDataSink.this.mTotalBytes))));
                        }
                    } else {
                        JavaUrlRequest.this.enterUploadErrorState(new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(OutputStreamDataSink.this.mWrittenBytes + ((long) OutputStreamDataSink.this.mBuffer.remaining())), Long.valueOf(OutputStreamDataSink.this.mTotalBytes))));
                    }
                }
            }));
        }

        @Override // org.chromium.net.UploadDataSink
        public void onRewindSucceeded() {
            if (!this.mSinkState.compareAndSet(SinkState.AWAITING_REWIND_RESULT, SinkState.UPLOADING)) {
                throw new IllegalStateException("Not expecting a read result");
            }
            startRead();
        }

        @Override // org.chromium.net.UploadDataSink
        public void onRewindError(Exception exc) {
            JavaUrlRequest.this.enterUploadErrorState(exc);
        }

        /* access modifiers changed from: package-private */
        public void startRead() {
            this.mExecutor.execute(JavaUrlRequest.this.errorSetting(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.OutputStreamDataSink.3
                @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    if (OutputStreamDataSink.this.mOutputChannel == null) {
                        JavaUrlRequest.this.mAdditionalStatusDetails = 10;
                        OutputStreamDataSink.this.mUrlConnection.connect();
                        JavaUrlRequest.this.mAdditionalStatusDetails = 12;
                        OutputStreamDataSink.this.mUrlConnectionOutputStream = OutputStreamDataSink.this.mUrlConnection.getOutputStream();
                        OutputStreamDataSink.this.mOutputChannel = Channels.newChannel(OutputStreamDataSink.this.mUrlConnectionOutputStream);
                    }
                    OutputStreamDataSink.this.mSinkState.set(SinkState.AWAITING_READ_RESULT);
                    OutputStreamDataSink.this.executeOnUploadExecutor(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.OutputStreamDataSink.3.1
                        @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                        public void run() {
                            OutputStreamDataSink.this.mUploadProvider.read(OutputStreamDataSink.this, OutputStreamDataSink.this.mBuffer);
                        }
                    });
                }
            }));
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void executeOnUploadExecutor(CheckedRunnable checkedRunnable) {
            try {
                this.mUserUploadExecutor.execute(JavaUrlRequest.this.uploadErrorSetting(checkedRunnable));
            } catch (RejectedExecutionException e) {
                JavaUrlRequest.this.enterUploadErrorState(e);
            }
        }

        /* access modifiers changed from: package-private */
        public void closeOutputChannel() {
            if (this.mOutputChannel != null && this.mOutputChannelClosed.compareAndSet(false, true)) {
                this.mOutputChannel.close();
            }
        }

        /* access modifiers changed from: package-private */
        public void finish() {
            closeOutputChannel();
            JavaUrlRequest.this.fireGetHeaders();
        }

        /* access modifiers changed from: package-private */
        public void start(final boolean z) {
            executeOnUploadExecutor(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.OutputStreamDataSink.4
                @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    OutputStreamDataSink.this.mTotalBytes = OutputStreamDataSink.this.mUploadProvider.getLength();
                    if (OutputStreamDataSink.this.mTotalBytes == 0) {
                        OutputStreamDataSink.this.finish();
                        return;
                    }
                    if (OutputStreamDataSink.this.mTotalBytes <= 0 || OutputStreamDataSink.this.mTotalBytes >= 8192) {
                        OutputStreamDataSink.this.mBuffer = ByteBuffer.allocateDirect(8192);
                    } else {
                        OutputStreamDataSink.this.mBuffer = ByteBuffer.allocateDirect(((int) OutputStreamDataSink.this.mTotalBytes) + 1);
                    }
                    if (OutputStreamDataSink.this.mTotalBytes > 0 && OutputStreamDataSink.this.mTotalBytes <= 2147483647L) {
                        OutputStreamDataSink.this.mUrlConnection.setFixedLengthStreamingMode((int) OutputStreamDataSink.this.mTotalBytes);
                    } else if (OutputStreamDataSink.this.mTotalBytes <= 2147483647L || Build.VERSION.SDK_INT < 19) {
                        OutputStreamDataSink.this.mUrlConnection.setChunkedStreamingMode(8192);
                    } else {
                        OutputStreamDataSink.this.mUrlConnection.setFixedLengthStreamingMode(OutputStreamDataSink.this.mTotalBytes);
                    }
                    if (z) {
                        OutputStreamDataSink.this.startRead();
                        return;
                    }
                    OutputStreamDataSink.this.mSinkState.set(SinkState.AWAITING_REWIND_RESULT);
                    OutputStreamDataSink.this.mUploadProvider.rewind(OutputStreamDataSink.this);
                }
            });
        }
    }

    @Override // org.chromium.net.UrlRequest
    public void start() {
        this.mAdditionalStatusDetails = 10;
        transitionStates(State.NOT_STARTED, State.STARTED, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mUrlChain.add(JavaUrlRequest.this.mCurrentUrl);
                JavaUrlRequest.this.fireOpenConnection();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void enterErrorState(CronetException cronetException) {
        if (setTerminalState(State.ERROR)) {
            fireDisconnect();
            fireCloseUploadDataProvider();
            this.mCallbackAsync.onFailed(this.mUrlResponseInfo, cronetException);
        }
    }

    private boolean setTerminalState(State state) {
        State state2;
        do {
            state2 = this.mState.get();
            switch (state2) {
                case NOT_STARTED:
                    throw new IllegalStateException("Can't enter error state before start");
                case ERROR:
                case COMPLETE:
                case CANCELLED:
                    return false;
            }
        } while (!this.mState.compareAndSet(state2, state));
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void enterUserErrorState(Throwable th) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", th));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void enterUploadErrorState(Throwable th) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UploadDataProvider", th));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void enterCronetErrorState(Throwable th) {
        enterErrorState(new CronetExceptionImpl("System error", th));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void transitionStates(State state, State state2, Runnable runnable) {
        if (!this.mState.compareAndSet(state, state2)) {
            State state3 = this.mState.get();
            if (state3 != State.CANCELLED && state3 != State.ERROR) {
                throw new IllegalStateException("Invalid state transition - expected " + state + " but was " + state3);
            }
            return;
        }
        runnable.run();
    }

    @Override // org.chromium.net.UrlRequest
    public void followRedirect() {
        transitionStates(State.AWAITING_FOLLOW_REDIRECT, State.STARTED, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mCurrentUrl = JavaUrlRequest.this.mPendingRedirectUrl;
                JavaUrlRequest.this.mPendingRedirectUrl = null;
                JavaUrlRequest.this.fireOpenConnection();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fireGetHeaders() {
        this.mAdditionalStatusDetails = 13;
        this.mExecutor.execute(errorSetting(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.4
            @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
            public void run() {
                if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                    ArrayList arrayList = new ArrayList();
                    String str = "http/1.1";
                    int i = 0;
                    while (true) {
                        String headerFieldKey = JavaUrlRequest.this.mCurrentUrlConnection.getHeaderFieldKey(i);
                        if (headerFieldKey == null) {
                            break;
                        }
                        if ("X-Android-Selected-Transport".equalsIgnoreCase(headerFieldKey)) {
                            str = JavaUrlRequest.this.mCurrentUrlConnection.getHeaderField(i);
                        }
                        if (!headerFieldKey.startsWith("X-Android")) {
                            arrayList.add(new AbstractMap.SimpleEntry(headerFieldKey, JavaUrlRequest.this.mCurrentUrlConnection.getHeaderField(i)));
                        }
                        i++;
                    }
                    int responseCode = JavaUrlRequest.this.mCurrentUrlConnection.getResponseCode();
                    JavaUrlRequest.this.mUrlResponseInfo = new UrlResponseInfoImpl(new ArrayList(JavaUrlRequest.this.mUrlChain), responseCode, JavaUrlRequest.this.mCurrentUrlConnection.getResponseMessage(), Collections.unmodifiableList(arrayList), false, str, "");
                    if (responseCode < 300 || responseCode >= 400) {
                        JavaUrlRequest.this.fireCloseUploadDataProvider();
                        if (responseCode >= 400) {
                            JavaUrlRequest.this.mResponseChannel = InputStreamChannel.wrap(JavaUrlRequest.this.mCurrentUrlConnection.getErrorStream());
                            JavaUrlRequest.this.mCallbackAsync.onResponseStarted(JavaUrlRequest.this.mUrlResponseInfo);
                            return;
                        }
                        JavaUrlRequest.this.mResponseChannel = InputStreamChannel.wrap(JavaUrlRequest.this.mCurrentUrlConnection.getInputStream());
                        JavaUrlRequest.this.mCallbackAsync.onResponseStarted(JavaUrlRequest.this.mUrlResponseInfo);
                        return;
                    }
                    JavaUrlRequest.this.fireRedirectReceived(JavaUrlRequest.this.mUrlResponseInfo.getAllHeaders());
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fireCloseUploadDataProvider() {
        if (this.mUploadDataProvider != null && this.mUploadProviderClosed.compareAndSet(false, true)) {
            try {
                this.mUploadExecutor.execute(uploadErrorSetting(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.5
                    @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                    public void run() {
                        JavaUrlRequest.this.mUploadDataProvider.close();
                    }
                }));
            } catch (RejectedExecutionException e) {
                Log.e(TAG, "Exception when closing uploadDataProvider", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fireRedirectReceived(final Map<String, List<String>> map) {
        transitionStates(State.STARTED, State.REDIRECT_RECEIVED, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mPendingRedirectUrl = URI.create(JavaUrlRequest.this.mCurrentUrl).resolve((String) ((List) map.get("location")).get(0)).toString();
                JavaUrlRequest.this.mUrlChain.add(JavaUrlRequest.this.mPendingRedirectUrl);
                JavaUrlRequest.this.transitionStates(State.REDIRECT_RECEIVED, State.AWAITING_FOLLOW_REDIRECT, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JavaUrlRequest.this.mCallbackAsync.onRedirectReceived(JavaUrlRequest.this.mUrlResponseInfo, JavaUrlRequest.this.mPendingRedirectUrl);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fireOpenConnection() {
        this.mExecutor.execute(errorSetting(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.7
            @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
            public void run() {
                if (JavaUrlRequest.this.mState.get() != State.CANCELLED) {
                    URL url = new URL(JavaUrlRequest.this.mCurrentUrl);
                    if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                        JavaUrlRequest.this.mCurrentUrlConnection.disconnect();
                        JavaUrlRequest.this.mCurrentUrlConnection = null;
                    }
                    JavaUrlRequest.this.mCurrentUrlConnection = (HttpURLConnection) url.openConnection();
                    JavaUrlRequest.this.mCurrentUrlConnection.setInstanceFollowRedirects(false);
                    if (!JavaUrlRequest.this.mRequestHeaders.containsKey("User-Agent")) {
                        JavaUrlRequest.this.mRequestHeaders.put("User-Agent", JavaUrlRequest.this.mUserAgent);
                    }
                    for (Map.Entry entry : JavaUrlRequest.this.mRequestHeaders.entrySet()) {
                        JavaUrlRequest.this.mCurrentUrlConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    if (JavaUrlRequest.this.mInitialMethod == null) {
                        JavaUrlRequest.this.mInitialMethod = "GET";
                    }
                    JavaUrlRequest.this.mCurrentUrlConnection.setRequestMethod(JavaUrlRequest.this.mInitialMethod);
                    if (JavaUrlRequest.this.mUploadDataProvider != null) {
                        JavaUrlRequest.this.mOutputStreamDataSink = new OutputStreamDataSink(JavaUrlRequest.this.mUploadExecutor, JavaUrlRequest.this.mExecutor, JavaUrlRequest.this.mCurrentUrlConnection, JavaUrlRequest.this.mUploadDataProvider);
                        JavaUrlRequest.this.mOutputStreamDataSink.start(JavaUrlRequest.this.mUrlChain.size() == 1);
                        return;
                    }
                    JavaUrlRequest.this.mAdditionalStatusDetails = 10;
                    JavaUrlRequest.this.mCurrentUrlConnection.connect();
                    JavaUrlRequest.this.fireGetHeaders();
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Runnable errorSetting(final CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterCronetErrorState(th);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Runnable userErrorSetting(final CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterUserErrorState(th);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Runnable uploadErrorSetting(final CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterUploadErrorState(th);
                }
            }
        };
    }

    @Override // org.chromium.net.UrlRequest
    public void read(final ByteBuffer byteBuffer) {
        Preconditions.checkDirect(byteBuffer);
        Preconditions.checkHasRemaining(byteBuffer);
        transitionStates(State.AWAITING_READ, State.READING, new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.11
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mExecutor.execute(JavaUrlRequest.this.errorSetting(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.11.1
                    @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                    public void run() {
                        JavaUrlRequest.this.processReadResult(JavaUrlRequest.this.mResponseChannel.read(byteBuffer), byteBuffer);
                    }
                }));
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processReadResult(int i, ByteBuffer byteBuffer) {
        if (i != -1) {
            this.mCallbackAsync.onReadCompleted(this.mUrlResponseInfo, byteBuffer);
            return;
        }
        this.mResponseChannel.close();
        if (this.mState.compareAndSet(State.READING, State.COMPLETE)) {
            fireDisconnect();
            this.mCallbackAsync.onSucceeded(this.mUrlResponseInfo);
        }
    }

    private void fireDisconnect() {
        this.mExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.12
            @Override // java.lang.Runnable
            public void run() {
                if (JavaUrlRequest.this.mOutputStreamDataSink != null) {
                    try {
                        JavaUrlRequest.this.mOutputStreamDataSink.closeOutputChannel();
                    } catch (IOException e) {
                        Log.e(JavaUrlRequest.TAG, "Exception when closing OutputChannel", e);
                    }
                }
                if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                    JavaUrlRequest.this.mCurrentUrlConnection.disconnect();
                    JavaUrlRequest.this.mCurrentUrlConnection = null;
                }
            }
        });
    }

    @Override // org.chromium.net.UrlRequest
    public void cancel() {
        switch (this.mState.getAndSet(State.CANCELLED)) {
            case ERROR:
            case COMPLETE:
            case CANCELLED:
            default:
                return;
            case REDIRECT_RECEIVED:
            case AWAITING_FOLLOW_REDIRECT:
            case AWAITING_READ:
            case STARTED:
            case READING:
                fireDisconnect();
                fireCloseUploadDataProvider();
                this.mCallbackAsync.onCanceled(this.mUrlResponseInfo);
                return;
        }
    }

    @Override // org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener statusListener) {
        int i;
        State state = this.mState.get();
        int i2 = this.mAdditionalStatusDetails;
        switch (state) {
            case NOT_STARTED:
            case ERROR:
            case COMPLETE:
            case CANCELLED:
                i = -1;
                break;
            case REDIRECT_RECEIVED:
            case AWAITING_FOLLOW_REDIRECT:
            case AWAITING_READ:
                i = 0;
                break;
            case STARTED:
                i = i2;
                break;
            case READING:
                i = 14;
                break;
            default:
                throw new IllegalStateException("Switch is exhaustive: " + state);
        }
        this.mCallbackAsync.sendStatus(new VersionSafeCallbacks.UrlRequestStatusListener(statusListener), i);
    }

    /* access modifiers changed from: package-private */
    public final class AsyncUrlRequestCallback {
        final VersionSafeCallbacks.UrlRequestCallback mCallback;
        final Executor mFallbackExecutor;
        final Executor mUserExecutor;

        AsyncUrlRequestCallback(UrlRequest.Callback callback, Executor executor) {
            this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(callback);
            if (JavaUrlRequest.this.mAllowDirectExecutor) {
                this.mUserExecutor = executor;
                this.mFallbackExecutor = null;
                return;
            }
            this.mUserExecutor = new DirectPreventingExecutor(executor);
            this.mFallbackExecutor = executor;
        }

        /* access modifiers changed from: package-private */
        public void sendStatus(final VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, final int i) {
            this.mUserExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    urlRequestStatusListener.onStatus(i);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void execute(CheckedRunnable checkedRunnable) {
            try {
                this.mUserExecutor.execute(JavaUrlRequest.this.userErrorSetting(checkedRunnable));
            } catch (RejectedExecutionException e) {
                JavaUrlRequest.this.enterErrorState(new CronetExceptionImpl("Exception posting task to executor", e));
            }
        }

        /* access modifiers changed from: package-private */
        public void onRedirectReceived(final UrlResponseInfo urlResponseInfo, final String str) {
            execute(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.2
                @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    AsyncUrlRequestCallback.this.mCallback.onRedirectReceived(JavaUrlRequest.this, urlResponseInfo, str);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void onResponseStarted(UrlResponseInfo urlResponseInfo) {
            execute(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.3
                @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    if (JavaUrlRequest.this.mState.compareAndSet(State.STARTED, State.AWAITING_READ)) {
                        AsyncUrlRequestCallback.this.mCallback.onResponseStarted(JavaUrlRequest.this, JavaUrlRequest.this.mUrlResponseInfo);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void onReadCompleted(final UrlResponseInfo urlResponseInfo, final ByteBuffer byteBuffer) {
            execute(new CheckedRunnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.4
                @Override // org.chromium.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    if (JavaUrlRequest.this.mState.compareAndSet(State.READING, State.AWAITING_READ)) {
                        AsyncUrlRequestCallback.this.mCallback.onReadCompleted(JavaUrlRequest.this, urlResponseInfo, byteBuffer);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void onCanceled(final UrlResponseInfo urlResponseInfo) {
            JavaUrlRequest.this.closeResponseChannel();
            this.mUserExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onCanceled(JavaUrlRequest.this, urlResponseInfo);
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onCanceled method", e);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void onSucceeded(final UrlResponseInfo urlResponseInfo) {
            this.mUserExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onSucceeded(JavaUrlRequest.this, urlResponseInfo);
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onSucceeded method", e);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void onFailed(final UrlResponseInfo urlResponseInfo, final CronetException cronetException) {
            JavaUrlRequest.this.closeResponseChannel();
            AnonymousClass7 r1 = new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onFailed(JavaUrlRequest.this, urlResponseInfo, cronetException);
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onFailed method", e);
                    }
                }
            };
            try {
                this.mUserExecutor.execute(r1);
            } catch (InlineExecutionProhibitedException e) {
                if (this.mFallbackExecutor != null) {
                    this.mFallbackExecutor.execute(r1);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void closeResponseChannel() {
        this.mExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.JavaUrlRequest.13
            @Override // java.lang.Runnable
            public void run() {
                if (JavaUrlRequest.this.mResponseChannel != null) {
                    try {
                        JavaUrlRequest.this.mResponseChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JavaUrlRequest.this.mResponseChannel = null;
                }
            }
        });
    }

    static final class DirectPreventingExecutor implements Executor {
        private final Executor mDelegate;

        DirectPreventingExecutor(Executor executor) {
            this.mDelegate = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            InlineCheckingRunnable inlineCheckingRunnable = new InlineCheckingRunnable(runnable, Thread.currentThread());
            this.mDelegate.execute(inlineCheckingRunnable);
            if (inlineCheckingRunnable.mExecutedInline != null) {
                throw inlineCheckingRunnable.mExecutedInline;
            }
            inlineCheckingRunnable.mCallingThread = null;
        }

        static final class InlineCheckingRunnable implements Runnable {
            private Thread mCallingThread;
            private final Runnable mCommand;
            private InlineExecutionProhibitedException mExecutedInline;

            private InlineCheckingRunnable(Runnable runnable, Thread thread) {
                this.mExecutedInline = null;
                this.mCommand = runnable;
                this.mCallingThread = thread;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Thread.currentThread() == this.mCallingThread) {
                    this.mExecutedInline = new InlineExecutionProhibitedException();
                } else {
                    this.mCommand.run();
                }
            }
        }
    }
}
