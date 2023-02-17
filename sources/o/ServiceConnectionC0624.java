package o;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import o.AbstractServiceC0766;
/* access modifiers changed from: package-private */
/* renamed from: o.ہ  reason: contains not printable characters */
public class ServiceConnectionC0624 implements ServiceConnection {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0742 f13935;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Message f13936;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13937 = false;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractServiceC0766.BinderC0768 f13938;

    ServiceConnectionC0624(C0742 r3, Message message) {
        this.f13936 = message;
        this.f13935 = r3;
        this.f13936.obj = this.f13935;
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (!(iBinder instanceof AbstractServiceC0766.BinderC0768)) {
            Log.w("FJD.ExternalReceiver", "Unknown service connected");
        } else if (this.f13937) {
            Log.w("FJD.ExternalReceiver", "onServiceConnected Duplicate calls. Ignored.");
        } else {
            this.f13937 = true;
            this.f13938 = (AbstractServiceC0766.BinderC0768) iBinder;
            this.f13938.m15219().m15217(this.f13935, this.f13936);
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        this.f13938 = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized boolean m14755() {
        return this.f13938 != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m14756() {
        if (m14755()) {
            this.f13938.m15219().m15216(this.f13935);
        }
    }
}
