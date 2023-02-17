package o;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
/* access modifiers changed from: package-private */
/* renamed from: o.ר  reason: contains not printable characters */
public class C0569 implements AbstractC0560 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Messenger f13833;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f13834;

    C0569(Messenger messenger, String str) {
        this.f13833 = messenger;
        this.f13834 = str;
    }

    @Override // o.AbstractC0560
    /* renamed from: ॱ */
    public void mo14143(int i) {
        try {
            this.f13833.send(m14665(i));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Message m14665(int i) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i;
        Bundle bundle = new Bundle();
        bundle.putString("tag", this.f13834);
        obtain.setData(bundle);
        return obtain;
    }
}
