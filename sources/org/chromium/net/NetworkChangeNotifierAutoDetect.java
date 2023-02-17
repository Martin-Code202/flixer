package org.chromium.net;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.util.Arrays;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
@SuppressLint({"NewApi"})
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    private static final String TAG = NetworkChangeNotifierAutoDetect.class.getSimpleName();
    private ConnectivityManagerDelegate mConnectivityManagerDelegate;
    private final Handler mHandler = new Handler(this.mLooper);
    private boolean mIgnoreNextBroadcast;
    private final NetworkConnectivityIntentFilter mIntentFilter;
    private final Looper mLooper = Looper.myLooper();
    private final MyNetworkCallback mNetworkCallback;
    private final NetworkRequest mNetworkRequest;
    private NetworkState mNetworkState;
    private final Observer mObserver;
    private boolean mRegistered;
    private final RegistrationPolicy mRegistrationPolicy;
    private boolean mShouldSignalObserver;
    private WifiManagerDelegate mWifiManagerDelegate;

    public interface Observer {
        void onConnectionSubtypeChanged(int i);

        void onConnectionTypeChanged(int i);

        void onNetworkConnect(long j, int i);

        void onNetworkDisconnect(long j);

        void onNetworkSoonToDisconnect(long j);

        void purgeActiveNetworkList(long[] jArr);
    }

    public static class NetworkState {
        static final /* synthetic */ boolean $assertionsDisabled = (!NetworkChangeNotifierAutoDetect.class.desiredAssertionStatus());
        private final boolean mConnected;
        private final int mSubtype;
        private final int mType;
        private final String mWifiSsid;

        public NetworkState(boolean z, int i, int i2, String str) {
            this.mConnected = z;
            this.mType = i;
            this.mSubtype = i2;
            if ($assertionsDisabled || this.mType == 1 || str == null) {
                this.mWifiSsid = str == null ? "" : str;
                return;
            }
            throw new AssertionError();
        }

        public boolean isConnected() {
            return this.mConnected;
        }

        public int getNetworkType() {
            return this.mType;
        }

        public int getNetworkSubType() {
            return this.mSubtype;
        }

        public String getWifiSsid() {
            return this.mWifiSsid;
        }

        public int getConnectionType() {
            if (!isConnected()) {
                return 6;
            }
            return NetworkChangeNotifierAutoDetect.convertToConnectionType(getNetworkType(), getNetworkSubType());
        }

        public int getConnectionSubtype() {
            if (!isConnected()) {
                return 1;
            }
            switch (getNetworkType()) {
                case 0:
                    switch (getNetworkSubType()) {
                        case 1:
                            return 7;
                        case 2:
                            return 8;
                        case 3:
                            return 9;
                        case 4:
                            return 5;
                        case 5:
                            return 10;
                        case 6:
                            return 11;
                        case 7:
                            return 6;
                        case 8:
                            return 14;
                        case 9:
                            return 15;
                        case 10:
                            return 12;
                        case 11:
                            return 4;
                        case 12:
                            return 13;
                        case 13:
                            return 18;
                        case 14:
                            return 16;
                        case 15:
                            return 17;
                        default:
                            return 0;
                    }
                case 1:
                case 6:
                case 7:
                case 9:
                    return 0;
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                default:
                    return 0;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class ConnectivityManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = (!NetworkChangeNotifierAutoDetect.class.desiredAssertionStatus());
        private final ConnectivityManager mConnectivityManager;

        ConnectivityManagerDelegate(Context context) {
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        ConnectivityManagerDelegate() {
            this.mConnectivityManager = null;
        }

        @TargetApi(21)
        private NetworkInfo getActiveNetworkInfo() {
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.isConnected()) {
                return activeNetworkInfo;
            }
            if (Build.VERSION.SDK_INT >= 21 && activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.BLOCKED && ApplicationStatus.getStateForApplication() == 1) {
                return activeNetworkInfo;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public NetworkState getNetworkState(WifiManagerDelegate wifiManagerDelegate) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return new NetworkState(false, -1, -1, null);
            }
            if (activeNetworkInfo.getType() != 1) {
                return new NetworkState(true, activeNetworkInfo.getType(), activeNetworkInfo.getSubtype(), null);
            }
            if (activeNetworkInfo.getExtraInfo() == null || "".equals(activeNetworkInfo.getExtraInfo())) {
                return new NetworkState(true, activeNetworkInfo.getType(), activeNetworkInfo.getSubtype(), wifiManagerDelegate.getWifiSsid());
            }
            return new NetworkState(true, activeNetworkInfo.getType(), activeNetworkInfo.getSubtype(), activeNetworkInfo.getExtraInfo());
        }

        private NetworkInfo getNetworkInfo(Network network) {
            try {
                return this.mConnectivityManager.getNetworkInfo(network);
            } catch (NullPointerException e) {
                try {
                    return this.mConnectivityManager.getNetworkInfo(network);
                } catch (NullPointerException e2) {
                    return null;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @TargetApi(21)
        public int getConnectionType(Network network) {
            NetworkInfo networkInfo = getNetworkInfo(network);
            if (networkInfo != null && networkInfo.getType() == 17) {
                networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                return 6;
            }
            return NetworkChangeNotifierAutoDetect.convertToConnectionType(networkInfo.getType(), networkInfo.getSubtype());
        }

        /* access modifiers changed from: protected */
        @TargetApi(21)
        public Network[] getAllNetworksUnfiltered() {
            Network[] allNetworks = this.mConnectivityManager.getAllNetworks();
            return allNetworks == null ? new Network[0] : allNetworks;
        }

        /* access modifiers changed from: protected */
        @TargetApi(21)
        public boolean vpnAccessible(Network network) {
            try {
                network.getSocketFactory().createSocket().close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        /* access modifiers changed from: protected */
        @TargetApi(21)
        public NetworkCapabilities getNetworkCapabilities(Network network) {
            return this.mConnectivityManager.getNetworkCapabilities(network);
        }

        /* access modifiers changed from: package-private */
        @TargetApi(21)
        public void registerNetworkCallback(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback) {
            this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback);
        }

        /* access modifiers changed from: package-private */
        @TargetApi(21)
        public void unregisterNetworkCallback(ConnectivityManager.NetworkCallback networkCallback) {
            this.mConnectivityManager.unregisterNetworkCallback(networkCallback);
        }

        /* access modifiers changed from: package-private */
        @TargetApi(21)
        public long getDefaultNetId() {
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this, null);
            long j = -1;
            for (Network network : allNetworksFiltered) {
                NetworkInfo networkInfo = getNetworkInfo(network);
                if (networkInfo != null && (networkInfo.getType() == activeNetworkInfo.getType() || networkInfo.getType() == 17)) {
                    if ($assertionsDisabled || j == -1) {
                        j = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            return j;
        }
    }

    /* access modifiers changed from: package-private */
    public static class WifiManagerDelegate {
        private final Context mContext;
        private boolean mHasWifiPermission;
        private boolean mHasWifiPermissionComputed;
        private final Object mLock;
        private WifiManager mWifiManager;

        WifiManagerDelegate(Context context) {
            this.mLock = new Object();
            this.mContext = context;
        }

        WifiManagerDelegate() {
            this.mLock = new Object();
            this.mContext = null;
        }

        @SuppressLint({"WifiManagerPotentialLeak"})
        private boolean hasPermissionLocked() {
            if (this.mHasWifiPermissionComputed) {
                return this.mHasWifiPermission;
            }
            this.mHasWifiPermission = this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) == 0;
            this.mWifiManager = this.mHasWifiPermission ? (WifiManager) this.mContext.getSystemService("wifi") : null;
            this.mHasWifiPermissionComputed = true;
            return this.mHasWifiPermission;
        }

        /* access modifiers changed from: package-private */
        public String getWifiSsid() {
            synchronized (this.mLock) {
                if (!hasPermissionLocked()) {
                    return AndroidNetworkLibrary.getWifiSSID();
                }
                WifiInfo wifiInfoLocked = getWifiInfoLocked();
                if (wifiInfoLocked == null) {
                    return "";
                }
                return wifiInfoLocked.getSSID();
            }
        }

        private WifiInfo getWifiInfoLocked() {
            try {
                return this.mWifiManager.getConnectionInfo();
            } catch (NullPointerException e) {
                try {
                    return this.mWifiManager.getConnectionInfo();
                } catch (NullPointerException e2) {
                    return null;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(21)
    public class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled = (!NetworkChangeNotifierAutoDetect.class.desiredAssertionStatus());
        private Network mVpnInPlace;

        private MyNetworkCallback() {
        }

        /* access modifiers changed from: package-private */
        public void initializeVpnInPlace() {
            NetworkCapabilities networkCapabilities;
            Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, null);
            this.mVpnInPlace = null;
            if (allNetworksFiltered.length == 1 && (networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(allNetworksFiltered[0])) != null && networkCapabilities.hasTransport(4)) {
                this.mVpnInPlace = allNetworksFiltered[0];
            }
        }

        private boolean ignoreNetworkDueToVpn(Network network) {
            return this.mVpnInPlace != null && !this.mVpnInPlace.equals(network);
        }

        private boolean ignoreConnectedInaccessibleVpn(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(network);
            }
            return networkCapabilities == null || (networkCapabilities.hasTransport(4) && !NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.vpnAccessible(network));
        }

        private boolean ignoreConnectedNetwork(Network network, NetworkCapabilities networkCapabilities) {
            return ignoreNetworkDueToVpn(network) || ignoreConnectedInaccessibleVpn(network, networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(network);
            if (!ignoreConnectedNetwork(network, networkCapabilities)) {
                final boolean hasTransport = networkCapabilities.hasTransport(4);
                if (hasTransport) {
                    this.mVpnInPlace = network;
                }
                final long networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                final int connectionType = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network);
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkConnect(networkToNetId, connectionType);
                        if (hasTransport) {
                            NetworkChangeNotifierAutoDetect.this.mObserver.onConnectionTypeChanged(connectionType);
                            NetworkChangeNotifierAutoDetect.this.mObserver.purgeActiveNetworkList(new long[]{networkToNetId});
                        }
                    }
                });
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (!ignoreConnectedNetwork(network, networkCapabilities)) {
                final long networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                final int connectionType = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network);
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkConnect(networkToNetId, connectionType);
                    }
                });
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            if (!ignoreConnectedNetwork(network, null)) {
                final long networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.3
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkSoonToDisconnect(networkToNetId);
                    }
                });
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network network) {
            if (!ignoreNetworkDueToVpn(network)) {
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.4
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkDisconnect(NetworkChangeNotifierAutoDetect.networkToNetId(network));
                    }
                });
                if (this.mVpnInPlace == null) {
                    return;
                }
                if ($assertionsDisabled || network.equals(this.mVpnInPlace)) {
                    this.mVpnInPlace = null;
                    for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, network)) {
                        onAvailable(network2);
                    }
                    final int connectionType = NetworkChangeNotifierAutoDetect.this.getCurrentNetworkState().getConnectionType();
                    NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetworkChangeNotifierAutoDetect.this.mObserver.onConnectionTypeChanged(connectionType);
                        }
                    });
                    return;
                }
                throw new AssertionError();
            }
        }
    }

    public static abstract class RegistrationPolicy {
        static final /* synthetic */ boolean $assertionsDisabled = (!NetworkChangeNotifierAutoDetect.class.desiredAssertionStatus());
        private NetworkChangeNotifierAutoDetect mNotifier;

        /* access modifiers changed from: protected */
        public abstract void destroy();

        /* access modifiers changed from: protected */
        public final void register() {
            if ($assertionsDisabled || this.mNotifier != null) {
                this.mNotifier.register();
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public final void unregister() {
            if ($assertionsDisabled || this.mNotifier != null) {
                this.mNotifier.unregister();
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            this.mNotifier = networkChangeNotifierAutoDetect;
        }
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer observer, RegistrationPolicy registrationPolicy) {
        this.mObserver = observer;
        this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.getApplicationContext());
        this.mWifiManagerDelegate = new WifiManagerDelegate(ContextUtils.getApplicationContext());
        if (Build.VERSION.SDK_INT >= 21) {
            this.mNetworkCallback = new MyNetworkCallback();
            this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        } else {
            this.mNetworkCallback = null;
            this.mNetworkRequest = null;
        }
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = registrationPolicy;
        this.mRegistrationPolicy.init(this);
        this.mShouldSignalObserver = true;
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

    public void destroy() {
        assertOnThread();
        this.mRegistrationPolicy.destroy();
        unregister();
    }

    public void register() {
        assertOnThread();
        if (!this.mRegistered) {
            if (this.mShouldSignalObserver) {
                connectionTypeChanged();
            }
            this.mIgnoreNextBroadcast = ContextUtils.getApplicationContext().registerReceiver(this, this.mIntentFilter) != null;
            this.mRegistered = true;
            if (this.mNetworkCallback != null) {
                this.mNetworkCallback.initializeVpnInPlace();
                this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback);
                if (this.mShouldSignalObserver) {
                    Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
                    long[] jArr = new long[allNetworksFiltered.length];
                    for (int i = 0; i < allNetworksFiltered.length; i++) {
                        jArr[i] = networkToNetId(allNetworksFiltered[i]);
                    }
                    this.mObserver.purgeActiveNetworkList(jArr);
                }
            }
        }
    }

    public void unregister() {
        assertOnThread();
        if (this.mRegistered) {
            ContextUtils.getApplicationContext().unregisterReceiver(this);
            this.mRegistered = false;
            if (this.mNetworkCallback != null) {
                this.mConnectivityManagerDelegate.unregisterNetworkCallback(this.mNetworkCallback);
            }
        }
    }

    public NetworkState getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate);
    }

    /* access modifiers changed from: private */
    @TargetApi(21)
    public static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate connectivityManagerDelegate, Network network) {
        NetworkCapabilities networkCapabilities;
        Network[] allNetworksUnfiltered = connectivityManagerDelegate.getAllNetworksUnfiltered();
        int i = 0;
        for (Network network2 : allNetworksUnfiltered) {
            if (!network2.equals(network) && (networkCapabilities = connectivityManagerDelegate.getNetworkCapabilities(network2)) != null && networkCapabilities.hasCapability(12)) {
                if (!networkCapabilities.hasTransport(4)) {
                    i++;
                    allNetworksUnfiltered[i] = network2;
                } else if (connectivityManagerDelegate.vpnAccessible(network2)) {
                    return new Network[]{network2};
                }
            }
        }
        return (Network[]) Arrays.copyOf(allNetworksUnfiltered, i);
    }

    public long[] getNetworksAndTypes() {
        if (Build.VERSION.SDK_INT < 21) {
            return new long[0];
        }
        Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] jArr = new long[(allNetworksFiltered.length * 2)];
        int i = 0;
        for (Network network : allNetworksFiltered) {
            int i2 = i + 1;
            jArr[i] = networkToNetId(network);
            i = i2 + 1;
            jArr[i2] = (long) this.mConnectivityManagerDelegate.getConnectionType(network);
        }
        return jArr;
    }

    public long getDefaultNetId() {
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        return this.mConnectivityManagerDelegate.getDefaultNetId();
    }

    /* access modifiers changed from: private */
    public static int convertToConnectionType(int i, int i2) {
        switch (i) {
            case 0:
                switch (i2) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 3;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 4;
                    case 13:
                        return 5;
                    default:
                        return 0;
                }
            case 1:
                return 2;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            default:
                return 0;
            case 6:
                return 5;
            case 7:
                return 7;
            case 9:
                return 1;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.1
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                    if (NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast) {
                        NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast = false;
                    } else {
                        NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void connectionTypeChanged() {
        NetworkState currentNetworkState = getCurrentNetworkState();
        if (currentNetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || !currentNetworkState.getWifiSsid().equals(this.mNetworkState.getWifiSsid())) {
            this.mObserver.onConnectionTypeChanged(currentNetworkState.getConnectionType());
        }
        if (!(currentNetworkState.getConnectionType() == this.mNetworkState.getConnectionType() && currentNetworkState.getConnectionSubtype() == this.mNetworkState.getConnectionSubtype())) {
            this.mObserver.onConnectionSubtypeChanged(currentNetworkState.getConnectionSubtype());
        }
        this.mNetworkState = currentNetworkState;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi", "ParcelCreator"})
    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    @TargetApi(21)
    static long networkToNetId(Network network) {
        if (Build.VERSION.SDK_INT >= 23) {
            return network.getNetworkHandle();
        }
        return (long) Integer.parseInt(network.toString());
    }
}
