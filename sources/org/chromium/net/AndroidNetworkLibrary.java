package org.chromium.net;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.security.KeyChain;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.CalledByNativeUnchecked;
class AndroidNetworkLibrary {
    AndroidNetworkLibrary() {
    }

    @CalledByNative
    public static boolean storeKeyPair(byte[] bArr, byte[] bArr2) {
        try {
            Intent createInstallIntent = KeyChain.createInstallIntent();
            createInstallIntent.putExtra("PKEY", bArr2);
            createInstallIntent.putExtra("KEY", bArr);
            createInstallIntent.addFlags(268435456);
            ContextUtils.getApplicationContext().startActivity(createInstallIntent);
            return true;
        } catch (ActivityNotFoundException e) {
            Log.w("AndroidNetworkLibrary", "could not store key pair: " + e);
            return false;
        }
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String str) {
        return URLConnection.guessContentTypeFromName("foo." + str);
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                try {
                    if (nextElement.isUp() && !nextElement.isLoopback()) {
                        return false;
                    }
                } catch (SocketException e) {
                }
            }
            return true;
        } catch (Exception e2) {
            Log.w("AndroidNetworkLibrary", "could not get network interfaces: " + e2);
            return false;
        }
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        try {
            return X509Util.verifyServerCertificates(bArr, str, str2);
        } catch (KeyStoreException e) {
            return new AndroidCertVerifyResult(-1);
        } catch (NoSuchAlgorithmException e2) {
            return new AndroidCertVerifyResult(-1);
        } catch (IllegalArgumentException e3) {
            return new AndroidCertVerifyResult(-1);
        }
    }

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] bArr) {
        X509Util.addTestRootCertificate(bArr);
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() {
        X509Util.clearTestRootCertificates();
    }

    @CalledByNative
    private static String getNetworkCountryIso() {
        TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getNetworkCountryIso();
    }

    @CalledByNative
    private static String getNetworkOperator() {
        TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getNetworkOperator();
    }

    @CalledByNative
    private static String getSimOperator() {
        TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getSimOperator();
    }

    @CalledByNative
    private static boolean getIsRoaming() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isRoaming();
    }

    @TargetApi(23)
    @CalledByNative
    private static boolean getIsCaptivePortal() {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        return (Build.VERSION.SDK_INT < 23 || (connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")) == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(17)) ? false : true;
    }

    @CalledByNative
    public static String getWifiSSID() {
        WifiInfo wifiInfo;
        String ssid;
        Intent registerReceiver = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (registerReceiver == null || (wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo")) == null || (ssid = wifiInfo.getSSID()) == null) {
            return "";
        }
        return ssid;
    }

    @TargetApi(24)
    @CalledByNative
    private static boolean isCleartextPermitted(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        NetworkSecurityPolicy instance = NetworkSecurityPolicy.getInstance();
        if (Build.VERSION.SDK_INT >= 24) {
            return instance.isCleartextTrafficPermitted(str);
        }
        return instance.isCleartextTrafficPermitted();
    }

    @TargetApi(23)
    @CalledByNative
    private static byte[][] getDnsServers() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return (byte[][]) Array.newInstance(Byte.TYPE, 0, 0);
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return (byte[][]) Array.newInstance(Byte.TYPE, 0, 0);
        }
        LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
        if (linkProperties == null) {
            return (byte[][]) Array.newInstance(Byte.TYPE, 0, 0);
        }
        List<InetAddress> dnsServers = linkProperties.getDnsServers();
        byte[][] bArr = new byte[dnsServers.size()][];
        for (int i = 0; i < dnsServers.size(); i++) {
            bArr[i] = dnsServers.get(i).getAddress();
        }
        return bArr;
    }
}
