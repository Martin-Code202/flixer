package o;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.ref.WeakReference;
/* renamed from: o.ﾆ  reason: contains not printable characters */
public class C1266 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f15914;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Cif f15915 = new Cif(Looper.getMainLooper(), new WeakReference(this));

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1267 f15916;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final SimpleArrayMap<C0742, ServiceConnectionC0624> f15917 = new SimpleArrayMap<>();

    /* renamed from: o.ﾆ$ˊ  reason: contains not printable characters */
    public interface AbstractC1267 {
        /* renamed from: ॱ */
        void mo91(C0742 v, int i);
    }

    public C1266(Context context, AbstractC1267 r5) {
        this.f15914 = context;
        this.f15916 = r5;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m16765(C0742 r8) {
        boolean bindService;
        if (r8 == null) {
            return false;
        }
        ServiceConnectionC0624 r3 = new ServiceConnectionC0624(r8, this.f15915.obtainMessage(1));
        synchronized (this.f15917) {
            if (this.f15917.put(r8, r3) != null) {
                Log.e("FJD.ExternalReceiver", "Received execution request for already running job");
            }
            bindService = this.f15914.bindService(m16761(r8), r3, 1);
        }
        return bindService;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Intent m16761(AbstractC0639 r4) {
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f15914, r4.mo14602());
        return intent;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16766(C0742 r5) {
        synchronized (this.f15917) {
            ServiceConnectionC0624 remove = this.f15917.remove(r5);
            if (remove != null) {
                remove.m14756();
                m16764(remove);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16764(ServiceConnectionC0624 r5) {
        if (r5 != null && r5.m14755()) {
            try {
                this.f15914.unbindService(r5);
            } catch (IllegalArgumentException e) {
                Log.w("FJD.ExternalReceiver", "Error unbinding service: " + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16762(C0742 r5, int i) {
        synchronized (this.f15917) {
            m16764(this.f15917.remove(r5));
        }
        this.f15916.mo91(r5, i);
    }

    /* renamed from: o.ﾆ$if  reason: invalid class name */
    static class Cif extends Handler {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final WeakReference<C1266> f15918;

        Cif(Looper looper, WeakReference<C1266> weakReference) {
            super(looper);
            this.f15918 = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj instanceof C0742) {
                        C1266 r3 = this.f15918.get();
                        if (r3 == null) {
                            Log.wtf("FJD.ExternalReceiver", "handleMessage: service was unexpectedly GC'd, can't send job result");
                            return;
                        } else {
                            r3.m16762((C0742) message.obj, message.arg1);
                            return;
                        }
                    } else {
                        Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown obj returned");
                        return;
                    }
                default:
                    Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown message type received: " + message.what);
                    return;
            }
        }
    }
}
