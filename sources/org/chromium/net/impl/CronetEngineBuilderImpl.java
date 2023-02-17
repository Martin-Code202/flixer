package org.chromium.net.impl;

import android.content.Context;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.chromium.net.ICronetEngineBuilder;
import org.chromium.net.impl.VersionSafeCallbacks;
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    private static final Pattern INVALID_PKP_HOST_NAME = Pattern.compile("^[0-9\\.]*$");
    private final Context mApplicationContext;
    private boolean mBrotiEnabled;
    private String mCertVerifierData;
    private boolean mDisableCache;
    private String mExperimentalOptions;
    private boolean mHttp2Enabled;
    private long mHttpCacheMaxSize;
    private int mHttpCacheMode;
    private VersionSafeCallbacks.LibraryLoader mLibraryLoader;
    protected long mMockCertVerifier;
    private boolean mNetworkQualityEstimatorEnabled;
    private final List<Pkp> mPkps = new LinkedList();
    private boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    private boolean mQuicEnabled;
    private final List<QuicHint> mQuicHints = new LinkedList();
    private boolean mSdchEnabled;
    private String mStoragePath;
    private int mThreadPriority = 20;
    private String mUserAgent;

    public static class Pkp {
        final Date mExpirationDate;
        final byte[][] mHashes;
        final String mHost;
        final boolean mIncludeSubdomains;
    }

    public static class QuicHint {
        final int mAlternatePort;
        final String mHost;
        final int mPort;
    }

    public CronetEngineBuilderImpl(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        enableQuic(false);
        enableHttp2(true);
        enableSdch(false);
        enableBrotli(false);
        enableHttpCache(0, 0L);
        enableNetworkQualityEstimator(false);
        enablePublicKeyPinningBypassForLocalTrustAnchors(true);
    }

    public String getDefaultUserAgent() {
        return UserAgent.from(this.mApplicationContext);
    }

    public CronetEngineBuilderImpl setUserAgent(String str) {
        this.mUserAgent = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public String getUserAgent() {
        return this.mUserAgent;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoragePath(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.mStoragePath = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public String storagePath() {
        return this.mStoragePath;
    }

    /* access modifiers changed from: package-private */
    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return this.mLibraryLoader;
    }

    public CronetEngineBuilderImpl enableQuic(boolean z) {
        this.mQuicEnabled = z;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean quicEnabled() {
        return this.mQuicEnabled;
    }

    /* access modifiers changed from: package-private */
    public String getDefaultQuicUserAgentId() {
        return this.mQuicEnabled ? UserAgent.getQuicUserAgentIdFrom(this.mApplicationContext) : "";
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttp2(boolean z) {
        this.mHttp2Enabled = z;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean http2Enabled() {
        return this.mHttp2Enabled;
    }

    public CronetEngineBuilderImpl enableSdch(boolean z) {
        this.mSdchEnabled = z;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean sdchEnabled() {
        return this.mSdchEnabled;
    }

    public CronetEngineBuilderImpl enableBrotli(boolean z) {
        this.mBrotiEnabled = z;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean brotliEnabled() {
        return this.mBrotiEnabled;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpCache(int i, long j) {
        if (i == 3 || i == 2) {
            if (storagePath() == null) {
                throw new IllegalArgumentException("Storage path must be set");
            }
        } else if (storagePath() != null) {
            throw new IllegalArgumentException("Storage path must not be set");
        }
        this.mDisableCache = i == 0 || i == 2;
        this.mHttpCacheMaxSize = j;
        switch (i) {
            case 0:
                this.mHttpCacheMode = 0;
                break;
            case 1:
                this.mHttpCacheMode = 2;
                break;
            case 2:
            case 3:
                this.mHttpCacheMode = 1;
                break;
            default:
                throw new IllegalArgumentException("Unknown cache mode");
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean cacheDisabled() {
        return this.mDisableCache;
    }

    /* access modifiers changed from: package-private */
    public long httpCacheMaxSize() {
        return this.mHttpCacheMaxSize;
    }

    /* access modifiers changed from: package-private */
    public int httpCacheMode() {
        return this.mHttpCacheMode;
    }

    /* access modifiers changed from: package-private */
    public List<QuicHint> quicHints() {
        return this.mQuicHints;
    }

    /* access modifiers changed from: package-private */
    public List<Pkp> publicKeyPins() {
        return this.mPkps;
    }

    public CronetEngineBuilderImpl enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z) {
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = z;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean publicKeyPinningBypassForLocalTrustAnchorsEnabled() {
        return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    }

    public String experimentalOptions() {
        return this.mExperimentalOptions;
    }

    /* access modifiers changed from: package-private */
    public long mockCertVerifier() {
        return this.mMockCertVerifier;
    }

    /* access modifiers changed from: package-private */
    public boolean networkQualityEstimatorEnabled() {
        return this.mNetworkQualityEstimatorEnabled;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableNetworkQualityEstimator(boolean z) {
        this.mNetworkQualityEstimatorEnabled = z;
        return this;
    }

    /* access modifiers changed from: package-private */
    public String certVerifierData() {
        return this.mCertVerifierData;
    }

    /* access modifiers changed from: package-private */
    public int threadPriority(int i) {
        return this.mThreadPriority == 20 ? i : this.mThreadPriority;
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.mApplicationContext;
    }
}
