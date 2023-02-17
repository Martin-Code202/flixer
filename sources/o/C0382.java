package o;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.gcm.INetworkTaskCallback;
/* access modifiers changed from: package-private */
/* renamed from: o.ɹ  reason: contains not printable characters */
public final class C0382 implements AbstractC0560 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final INetworkTaskCallback f13331;

    public C0382(IBinder iBinder) {
        this.f13331 = INetworkTaskCallback.Stub.asInterface(iBinder);
    }

    @Override // o.AbstractC0560
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo14143(int i) {
        try {
            this.f13331.taskFinished(i);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
