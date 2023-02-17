package org.chromium.net;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.chromium.base.BuildInfo;
import org.chromium.base.ContextUtils;
public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled = (!X509Util.class.desiredAssertionStatus());
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerImplementation sDefaultTrustManager;
    private static boolean sDisableNativeCodeForTest;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock = new Object();
    private static File sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerImplementation sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    /* access modifiers changed from: package-private */
    public interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2);
    }

    private static native void nativeNotifyKeyChainChanged();

    private static native void nativeRecordCertVerifyCapabilitiesHistogram(boolean z);

    /* access modifiers changed from: package-private */
    public static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if (!BuildInfo.isAtLeastO()) {
                z = "android.security.STORAGE_CHANGED".equals(intent.getAction());
            } else if ("android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction()) || "android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction())) {
                z = true;
            } else if ("android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) && !intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false)) {
                z = true;
            }
            if (z) {
                try {
                    X509Util.reloadDefaultTrustManager();
                } catch (CertificateException e) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e);
                } catch (KeyStoreException e2) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e2);
                } catch (NoSuchAlgorithmException e3) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e3);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        private final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager x509TrustManager) {
            this.mTrustManager = x509TrustManager;
        }

        @Override // org.chromium.net.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            this.mTrustManager.checkServerTrusted(x509CertificateArr, str);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        private final X509TrustManagerExtensions mTrustManagerExtensions;

        @SuppressLint({"NewApi"})
        public X509TrustManagerJellyBean(X509TrustManager x509TrustManager) {
            this.mTrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        }

        @Override // org.chromium.net.X509Util.X509TrustManagerImplementation
        @SuppressLint({"NewApi"})
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            return this.mTrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, str2);
        }
    }

    private static void ensureInitialized() {
        synchronized (sLock) {
            ensureInitializedLocked();
        }
    }

    private static void ensureInitializedLocked() {
        if ($assertionsDisabled || Thread.holdsLock(sLock)) {
            if (sCertificateFactory == null) {
                sCertificateFactory = CertificateFactory.getInstance("X.509");
            }
            if (sDefaultTrustManager == null) {
                sDefaultTrustManager = createTrustManager(null);
            }
            if (!sLoadedSystemKeyStore) {
                try {
                    sSystemKeyStore = KeyStore.getInstance("AndroidCAStore");
                    try {
                        sSystemKeyStore.load(null);
                    } catch (IOException e) {
                    }
                    sSystemCertificateDirectory = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
                } catch (KeyStoreException e2) {
                }
                if (!sDisableNativeCodeForTest) {
                    nativeRecordCertVerifyCapabilitiesHistogram(sSystemKeyStore != null);
                }
                sLoadedSystemKeyStore = true;
            }
            if (sSystemTrustAnchorCache == null) {
                sSystemTrustAnchorCache = new HashSet();
            }
            if (sTestKeyStore == null) {
                sTestKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                try {
                    sTestKeyStore.load(null);
                } catch (IOException e3) {
                }
            }
            if (sTestTrustManager == null) {
                sTestTrustManager = createTrustManager(sTestKeyStore);
            }
            if (!sDisableNativeCodeForTest && sTrustStorageListener == null) {
                sTrustStorageListener = new TrustStorageListener();
                IntentFilter intentFilter = new IntentFilter();
                if (BuildInfo.isAtLeastO()) {
                    intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
                    intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
                    intentFilter.addAction("android.security.action.TRUST_STORE_CHANGED");
                } else {
                    intentFilter.addAction("android.security.STORAGE_CHANGED");
                }
                ContextUtils.getApplicationContext().registerReceiver(sTrustStorageListener, intentFilter);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private static X509TrustManagerImplementation createTrustManager(KeyStore keyStore) {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(keyStore);
        TrustManager[] trustManagers = instance.getTrustManagers();
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        return new X509TrustManagerJellyBean((X509TrustManager) trustManager);
                    }
                    return new X509TrustManagerIceCreamSandwich((X509TrustManager) trustManager);
                } catch (IllegalArgumentException e) {
                    Log.e("X509Util", "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e);
                }
            }
        }
        Log.e("X509Util", "Could not find suitable trust manager");
        return null;
    }

    private static void reloadTestTrustManager() {
        if ($assertionsDisabled || Thread.holdsLock(sLock)) {
            sTestTrustManager = createTrustManager(sTestKeyStore);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public static void reloadDefaultTrustManager() {
        synchronized (sLock) {
            sDefaultTrustManager = null;
            sSystemTrustAnchorCache = null;
            ensureInitializedLocked();
        }
        nativeNotifyKeyChainChanged();
    }

    public static X509Certificate createCertificateFromBytes(byte[] bArr) {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static void addTestRootCertificate(byte[] bArr) {
        ensureInitialized();
        X509Certificate createCertificateFromBytes = createCertificateFromBytes(bArr);
        synchronized (sLock) {
            sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), createCertificateFromBytes);
            reloadTestTrustManager();
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void clearTestRootCertificates() {
        /*
            ensureInitialized()
            java.lang.Object r2 = org.chromium.net.X509Util.sLock
            monitor-enter(r2)
            java.security.KeyStore r0 = org.chromium.net.X509Util.sTestKeyStore     // Catch:{ IOException -> 0x0010, all -> 0x0013 }
            r1 = 0
            r0.load(r1)     // Catch:{ IOException -> 0x0010, all -> 0x0013 }
            reloadTestTrustManager()     // Catch:{ IOException -> 0x0010, all -> 0x0013 }
            goto L_0x0011
        L_0x0010:
            r3 = move-exception
        L_0x0011:
            monitor-exit(r2)
            goto L_0x0016
        L_0x0013:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        L_0x0016:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.net.X509Util.clearTestRootCertificates():void");
    }

    private static String hashPrincipal(X500Principal x500Principal) {
        byte[] digest = MessageDigest.getInstance("MD5").digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i = 0; i < 4; i++) {
            cArr[i * 2] = HEX_DIGITS[(digest[3 - i] >> 4) & 15];
            cArr[(i * 2) + 1] = HEX_DIGITS[digest[3 - i] & 15];
        }
        return new String(cArr);
    }

    private static boolean isKnownRoot(X509Certificate x509Certificate) {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        } else if (sSystemKeyStore == null) {
            return false;
        } else {
            Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
            if (sSystemTrustAnchorCache.contains(pair)) {
                return true;
            }
            String hashPrincipal = hashPrincipal(x509Certificate.getSubjectX500Principal());
            int i = 0;
            while (true) {
                String str = hashPrincipal + '.' + i;
                if (!new File(sSystemCertificateDirectory, str).exists()) {
                    return false;
                }
                Certificate certificate = sSystemKeyStore.getCertificate("system:" + str);
                if (certificate != null) {
                    if (!(certificate instanceof X509Certificate)) {
                        Log.e("X509Util", "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                    } else {
                        X509Certificate x509Certificate2 = (X509Certificate) certificate;
                        if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                            sSystemTrustAnchorCache.add(pair);
                            return true;
                        }
                    }
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean verifyKeyUsage(java.security.cert.X509Certificate r4) {
        /*
            java.util.List r1 = r4.getExtendedKeyUsage()     // Catch:{ NullPointerException -> 0x0005 }
            goto L_0x0008
        L_0x0005:
            r2 = move-exception
            r0 = 0
            return r0
        L_0x0008:
            if (r1 != 0) goto L_0x000c
            r0 = 1
            return r0
        L_0x000c:
            java.util.Iterator r2 = r1.iterator()
        L_0x0010:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0040
            java.lang.Object r0 = r2.next()
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r0 = "1.3.6.1.5.5.7.3.1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = "2.5.29.37.0"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = "2.16.840.1.113730.4.1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = "1.3.6.1.4.1.311.10.3.3"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x003f
        L_0x003d:
            r0 = 1
            return r0
        L_0x003f:
            goto L_0x0010
        L_0x0040:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.net.X509Util.verifyKeyUsage(java.security.cert.X509Certificate):boolean");
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        List<X509Certificate> list;
        if (bArr == null || bArr.length == 0 || bArr[0] == null) {
            throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
        }
        try {
            ensureInitialized();
            X509Certificate[] x509CertificateArr = new X509Certificate[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                try {
                    x509CertificateArr[i] = createCertificateFromBytes(bArr[i]);
                } catch (CertificateException e) {
                    return new AndroidCertVerifyResult(-5);
                }
            }
            try {
                x509CertificateArr[0].checkValidity();
                if (!verifyKeyUsage(x509CertificateArr[0])) {
                    return new AndroidCertVerifyResult(-6);
                }
                synchronized (sLock) {
                    if (sDefaultTrustManager == null) {
                        return new AndroidCertVerifyResult(-1);
                    }
                    try {
                        list = sDefaultTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                    } catch (CertificateException e2) {
                        try {
                            list = sTestTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                        } catch (CertificateException e3) {
                            Log.i("X509Util", "Failed to validate the certificate chain, error: " + e2.getMessage());
                            return new AndroidCertVerifyResult(-2);
                        }
                    }
                    boolean z = false;
                    if (list.size() > 0) {
                        z = isKnownRoot(list.get(list.size() - 1));
                    }
                    return new AndroidCertVerifyResult(0, z, list);
                }
            } catch (CertificateExpiredException e4) {
                return new AndroidCertVerifyResult(-3);
            } catch (CertificateNotYetValidException e5) {
                return new AndroidCertVerifyResult(-4);
            } catch (CertificateException e6) {
                return new AndroidCertVerifyResult(-1);
            }
        } catch (CertificateException e7) {
            return new AndroidCertVerifyResult(-1);
        }
    }
}
