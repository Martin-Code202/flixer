package o;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Locale;
/* renamed from: o.ᒃ  reason: contains not printable characters */
public abstract class AbstractServiceC0766 extends Service {

    /* renamed from: ˊ  reason: contains not printable characters */
    private BinderC0768 f14395 = new BinderC0768();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final SimpleArrayMap<String, C0767> f14396 = new SimpleArrayMap<>(1);

    /* renamed from: ˋ */
    public abstract boolean mo551(AbstractC0639 v);

    /* renamed from: ˏ */
    public abstract boolean mo552(AbstractC0639 v);

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15217(AbstractC0639 r10, Message message) {
        synchronized (this.f14396) {
            if (this.f14396.containsKey(r10.mo14606())) {
                Log.w("FJD.JobService", String.format(Locale.US, "Job with tag = %s was already running.", r10.mo14606()));
                return;
            }
            this.f14396.put(r10.mo14606(), new C0767(message));
            if (!mo552(r10)) {
                this.f14396.remove(r10.mo14606()).m15218(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15216(C0742 r7) {
        synchronized (this.f14396) {
            C0767 remove = this.f14396.remove(r7.mo14606());
            if (remove == null) {
                if (Log.isLoggable("FJD.JobService", 3)) {
                    Log.d("FJD.JobService", "Provided job has already been executed.");
                }
                return;
            }
            remove.m15218(mo551(r7) ? 1 : 0);
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        stopSelf(i2);
        return 2;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f14395;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        synchronized (this.f14396) {
            for (int size = this.f14396.size() - 1; size >= 0; size--) {
                C0767 r4 = this.f14396.get(this.f14396.keyAt(size));
                if (r4 != null) {
                    r4.m15218(mo551((AbstractC0639) r4.f14397.obj) ? 1 : 2);
                }
            }
        }
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Service
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    /* renamed from: o.ᒃ$ˊ  reason: contains not printable characters */
    static final class C0767 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final Message f14397;

        private C0767(Message message) {
            this.f14397 = message;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public void m15218(int i) {
            this.f14397.arg1 = i;
            this.f14397.sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᒃ$ˋ  reason: contains not printable characters */
    public class BinderC0768 extends Binder {
        BinderC0768() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public AbstractServiceC0766 m15219() {
            return AbstractServiceC0766.this;
        }
    }
}
