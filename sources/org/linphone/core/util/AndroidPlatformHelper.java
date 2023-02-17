package org.linphone.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import java.net.InetAddress;
import java.util.List;
import org.linphone.mediastream.Log;
public class AndroidPlatformHelper {
    private ConnectivityManager mConnectivityManager;
    private WifiManager.MulticastLock mMcastLock;
    private PowerManager mPowerManager;
    private PowerManager.WakeLock mWakeLock = this.mPowerManager.newWakeLock(1, "AndroidPlatformHelper");
    private WifiManager.WifiLock mWifiLock;

    public AndroidPlatformHelper(Object obj) {
        Context context = (Context) obj;
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.mWakeLock.setReferenceCounted(true);
        this.mMcastLock = wifiManager.createMulticastLock("AndroidPlatformHelper");
        this.mMcastLock.setReferenceCounted(true);
        this.mWifiLock = wifiManager.createWifiLock(3, "AndroidPlatformHelper");
        this.mWifiLock.setReferenceCounted(true);
    }

    public Object getPowerManager() {
        return this.mPowerManager;
    }

    public String[] getDnsServers() {
        if (this.mConnectivityManager == null || Build.VERSION.SDK_INT < 23 || this.mConnectivityManager.getActiveNetwork() == null || this.mConnectivityManager.getLinkProperties(this.mConnectivityManager.getActiveNetwork()) == null) {
            return null;
        }
        int i = 0;
        List<InetAddress> dnsServers = this.mConnectivityManager.getLinkProperties(this.mConnectivityManager.getActiveNetwork()).getDnsServers();
        String[] strArr = new String[dnsServers.size()];
        for (InetAddress inetAddress : dnsServers) {
            i++;
            strArr[i] = inetAddress.getHostAddress();
        }
        Log.i("getDnsServers() returning");
        return strArr;
    }

    public void acquireWifiLock() {
        Log.i("acquireWifiLock()");
        this.mWifiLock.acquire();
    }

    public void releaseWifiLock() {
        Log.i("releaseWifiLock()");
        this.mWifiLock.release();
    }

    public void acquireMcastLock() {
        Log.i("acquireMcastLock()");
        this.mMcastLock.acquire();
    }

    public void releaseMcastLock() {
        Log.i("releaseMcastLock()");
        this.mMcastLock.release();
    }

    public void acquireCpuLock() {
        Log.i("acquireCpuLock()");
        this.mWakeLock.acquire();
    }

    public void releaseCpuLock() {
        Log.i("releaseCpuLock()");
        this.mWakeLock.release();
    }
}
