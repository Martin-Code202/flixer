package org.chromium.net;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.net.NetworkChangeNotifierAutoDetect;
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled = (!NetworkChangeNotifier.class.desiredAssertionStatus());
    @SuppressLint({"StaticFieldLeak"})
    private static NetworkChangeNotifier sInstance;
    private NetworkChangeNotifierAutoDetect mAutoDetector;
    private final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers = new ObserverList<>();
    private int mCurrentConnectionType = 0;
    private final ArrayList<Long> mNativeChangeNotifiers = new ArrayList<>();

    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int i);
    }

    private native void nativeNotifyConnectionTypeChanged(long j, int i, long j2);

    private native void nativeNotifyMaxBandwidthChanged(long j, int i);

    private native void nativeNotifyOfNetworkConnect(long j, long j2, int i);

    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, long j2);

    private native void nativeNotifyPurgeActiveNetworkList(long j, long[] jArr);

    protected NetworkChangeNotifier() {
    }

    @CalledByNative
    public static NetworkChangeNotifier init() {
        if (sInstance == null) {
            sInstance = new NetworkChangeNotifier();
        }
        return sInstance;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.mAutoDetector == null) {
            return 0;
        }
        return this.mAutoDetector.getCurrentNetworkState().getConnectionSubtype();
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        if (this.mAutoDetector == null) {
            return -1;
        }
        return this.mAutoDetector.getDefaultNetId();
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        return this.mAutoDetector == null ? new long[0] : this.mAutoDetector.getNetworksAndTypes();
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.mNativeChangeNotifiers.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier getInstance() {
        if ($assertionsDisabled || sInstance != null) {
            return sInstance;
        }
        throw new AssertionError();
    }

    public static void setAutoDetectConnectivityState(boolean z) {
        getInstance().setAutoDetectConnectivityStateInternal(z, new RegistrationPolicyApplicationStatus());
    }

    public static void registerToReceiveNotificationsAlways() {
        getInstance().setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
    }

    private void destroyAutoDetector() {
        if (this.mAutoDetector != null) {
            this.mAutoDetector.destroy();
            this.mAutoDetector = null;
        }
    }

    private void setAutoDetectConnectivityStateInternal(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (!z) {
            destroyAutoDetector();
        } else if (this.mAutoDetector == null) {
            this.mAutoDetector = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: org.chromium.net.NetworkChangeNotifier.1
                @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                public void onConnectionTypeChanged(int i) {
                    NetworkChangeNotifier.this.updateCurrentConnectionType(i);
                }

                @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                public void onConnectionSubtypeChanged(int i) {
                    NetworkChangeNotifier.this.notifyObserversOfConnectionSubtypeChange(i);
                }

                @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                public void onNetworkConnect(long j, int i) {
                    NetworkChangeNotifier.this.notifyObserversOfNetworkConnect(j, i);
                }

                @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                public void onNetworkSoonToDisconnect(long j) {
                    NetworkChangeNotifier.this.notifyObserversOfNetworkSoonToDisconnect(j);
                }

                @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                public void onNetworkDisconnect(long j) {
                    NetworkChangeNotifier.this.notifyObserversOfNetworkDisconnect(j);
                }

                @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                public void purgeActiveNetworkList(long[] jArr) {
                    NetworkChangeNotifier.this.notifyObserversToPurgeActiveNetworkList(jArr);
                }
            }, registrationPolicy);
            NetworkChangeNotifierAutoDetect.NetworkState currentNetworkState = this.mAutoDetector.getCurrentNetworkState();
            updateCurrentConnectionType(currentNetworkState.getConnectionType());
            notifyObserversOfConnectionSubtypeChange(currentNetworkState.getConnectionSubtype());
        }
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        setAutoDetectConnectivityState(false);
        getInstance().forceConnectivityStateInternal(z);
    }

    private void forceConnectivityStateInternal(boolean z) {
        if ((this.mCurrentConnectionType != 6) != z) {
            updateCurrentConnectionType(z ? 0 : 6);
            notifyObserversOfConnectionSubtypeChange(z ? 0 : 1);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(long j, int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkConnect(j, i);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkSoonToDisconnect(j);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkDisconnect(j);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] jArr) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversToPurgeActiveNetworkList(jArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long j, int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionTypeChange(i, j);
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionSubtypeChange(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCurrentConnectionType(int i) {
        this.mCurrentConnectionType = i;
        notifyObserversOfConnectionTypeChange(i);
    }

    /* access modifiers changed from: package-private */
    public void notifyObserversOfConnectionTypeChange(int i) {
        notifyObserversOfConnectionTypeChange(i, getCurrentDefaultNetId());
    }

    private void notifyObserversOfConnectionTypeChange(int i, long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, j);
        }
        Iterator<ConnectionTypeObserver> it2 = this.mConnectionTypeObservers.iterator();
        while (it2.hasNext()) {
            it2.next().onConnectionTypeChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyObserversOfConnectionSubtypeChange(int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), i);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyObserversOfNetworkConnect(long j, int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), j, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyObserversOfNetworkSoonToDisconnect(long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), j);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyObserversOfNetworkDisconnect(long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), j);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyObserversToPurgeActiveNetworkList(long[] jArr) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), jArr);
        }
    }
}
