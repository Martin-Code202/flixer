package org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
public class ProxyChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = (!ProxyChangeListener.class.desiredAssertionStatus());
    private static boolean sEnabled = true;
    private Delegate mDelegate;
    private final Handler mHandler = new Handler(this.mLooper);
    private final Looper mLooper = Looper.myLooper();
    private long mNativePtr;
    private ProxyReceiver mProxyReceiver;

    public interface Delegate {
        void proxySettingsChanged();
    }

    private native void nativeProxySettingsChanged(long j);

    private native void nativeProxySettingsChangedTo(long j, String str, int i, String str2, String[] strArr);

    /* access modifiers changed from: package-private */
    public static class ProxyConfig {
        public final String[] mExclusionList;
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;

        public ProxyConfig(String str, int i, String str2, String[] strArr) {
            this.mHost = str;
            this.mPort = i;
            this.mPacUrl = str2;
            this.mExclusionList = strArr;
        }
    }

    private ProxyChangeListener() {
    }

    @CalledByNative
    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    @CalledByNative
    public static String getProperty(String str) {
        return System.getProperty(str);
    }

    @CalledByNative
    public void start(long j) {
        assertOnThread();
        if ($assertionsDisabled || this.mNativePtr == 0) {
            this.mNativePtr = j;
            registerReceiver();
            return;
        }
        throw new AssertionError();
    }

    @CalledByNative
    public void stop() {
        assertOnThread();
        this.mNativePtr = 0;
        unregisterReceiver();
    }

    /* access modifiers changed from: package-private */
    public class ProxyReceiver extends BroadcastReceiver {
        private ProxyReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                ProxyChangeListener.this.runOnThread(new Runnable() { // from class: org.chromium.net.ProxyChangeListener.ProxyReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ProxyChangeListener.this.proxySettingsChanged(ProxyReceiver.this, ProxyReceiver.this.extractNewProxy(intent));
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private ProxyConfig extractNewProxy(Intent intent) {
            String str;
            String str2;
            String[] strArr;
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    str2 = "android.net.ProxyProperties";
                    str = "proxy";
                } else {
                    str2 = "android.net.ProxyInfo";
                    str = "android.intent.extra.PROXY_INFO";
                }
                Object obj = intent.getExtras().get(str);
                if (obj == null) {
                    return null;
                }
                Class<?> cls = Class.forName(str2);
                Method declaredMethod = cls.getDeclaredMethod("getHost", new Class[0]);
                Method declaredMethod2 = cls.getDeclaredMethod("getPort", new Class[0]);
                Method declaredMethod3 = cls.getDeclaredMethod("getExclusionList", new Class[0]);
                String str3 = (String) declaredMethod.invoke(obj, new Object[0]);
                int intValue = ((Integer) declaredMethod2.invoke(obj, new Object[0])).intValue();
                if (Build.VERSION.SDK_INT < 21) {
                    strArr = ((String) declaredMethod3.invoke(obj, new Object[0])).split(",");
                } else {
                    strArr = (String[]) declaredMethod3.invoke(obj, new Object[0]);
                }
                if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                    String str4 = (String) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                    if (!TextUtils.isEmpty(str4)) {
                        return new ProxyConfig(str3, intValue, str4, strArr);
                    }
                } else if (Build.VERSION.SDK_INT >= 21) {
                    Uri uri = (Uri) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                    if (!Uri.EMPTY.equals(uri)) {
                        return new ProxyConfig(str3, intValue, uri.toString(), strArr);
                    }
                }
                return new ProxyConfig(str3, intValue, null, strArr);
            } catch (ClassNotFoundException e) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e);
                return null;
            } catch (NoSuchMethodException e2) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e2);
                return null;
            } catch (IllegalAccessException e3) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e3);
                return null;
            } catch (InvocationTargetException e4) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e4);
                return null;
            } catch (NullPointerException e5) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e5);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void proxySettingsChanged(ProxyReceiver proxyReceiver, ProxyConfig proxyConfig) {
        if (sEnabled && proxyReceiver == this.mProxyReceiver) {
            if (this.mDelegate != null) {
                this.mDelegate.proxySettingsChanged();
            }
            if (this.mNativePtr != 0) {
                if (proxyConfig != null) {
                    nativeProxySettingsChangedTo(this.mNativePtr, proxyConfig.mHost, proxyConfig.mPort, proxyConfig.mPacUrl, proxyConfig.mExclusionList);
                } else {
                    nativeProxySettingsChanged(this.mNativePtr);
                }
            }
        }
    }

    private void registerReceiver() {
        if (this.mProxyReceiver == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PROXY_CHANGE");
            this.mProxyReceiver = new ProxyReceiver();
            ContextUtils.getApplicationContext().registerReceiver(this.mProxyReceiver, intentFilter);
        }
    }

    private void unregisterReceiver() {
        if (this.mProxyReceiver != null) {
            ContextUtils.getApplicationContext().unregisterReceiver(this.mProxyReceiver);
            this.mProxyReceiver = null;
        }
    }

    private boolean onThread() {
        return this.mLooper == Looper.myLooper();
    }

    private void assertOnThread() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void runOnThread(Runnable runnable) {
        if (onThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }
}
