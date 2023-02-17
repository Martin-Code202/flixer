package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import o.AbstractC0560;
import o.C0415;
import o.C0699;
import o.C0742;
import o.C1266;
import o.HandlerC0579;
public class GooglePlayReceiver extends Service implements C1266.AbstractC1267 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final C0699 f135 = new C0699("com.firebase.jobdispatcher.", true);

    /* renamed from: ʼ  reason: contains not printable characters */
    private SimpleArrayMap<String, SimpleArrayMap<String, AbstractC0560>> f136 = new SimpleArrayMap<>(1);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0415 f137 = new C0415();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Object f138 = new Object();

    /* renamed from: ˏ  reason: contains not printable characters */
    Messenger f139;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1266 f140;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m86(AbstractC0560 r4, int i) {
        try {
            r4.mo14143(i);
        } catch (Throwable th) {
            Log.e("FJD.GooglePlayReceiver", "Encountered error running callback", th.getCause());
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            super.onStartCommand(intent, i, i2);
            if (intent == null) {
                Log.w("FJD.GooglePlayReceiver", "Null Intent passed, terminating");
                synchronized (this) {
                    if (this.f136.isEmpty()) {
                        stopSelf(i2);
                    }
                }
                return 2;
            }
            String action = intent.getAction();
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                m90().m16765(m88(intent));
                synchronized (this) {
                    if (this.f136.isEmpty()) {
                        stopSelf(i2);
                    }
                }
                return 2;
            } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                synchronized (this) {
                    if (this.f136.isEmpty()) {
                        stopSelf(i2);
                    }
                }
                return 2;
            } else {
                Log.e("FJD.GooglePlayReceiver", "Unknown action received, terminating");
                synchronized (this) {
                    if (this.f136.isEmpty()) {
                        stopSelf(i2);
                    }
                }
                return 2;
            }
        } catch (Throwable th) {
            synchronized (this) {
                if (this.f136.isEmpty()) {
                    stopSelf(i2);
                }
                throw th;
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null || Build.VERSION.SDK_INT < 21 || !"com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) {
            return null;
        }
        return m87().getBinder();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Messenger m87() {
        Messenger messenger;
        synchronized (this.f138) {
            if (this.f139 == null) {
                this.f139 = new Messenger(new HandlerC0579(Looper.getMainLooper(), this));
            }
            messenger = this.f139;
        }
        return messenger;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1266 m90() {
        C1266 r0;
        synchronized (this.f138) {
            if (this.f140 == null) {
                this.f140 = new C1266(this, this);
            }
            r0 = this.f140;
        }
        return r0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public C0742 m88(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
            return null;
        }
        AbstractC0560 r3 = this.f137.m14224(extras);
        if (r3 != null) {
            return m89(extras, r3);
        }
        Log.i("FJD.GooglePlayReceiver", "no callback found");
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0742 m89(Bundle bundle, AbstractC0560 r8) {
        C0742 r2 = f135.m15011(bundle);
        if (r2 == null) {
            Log.e("FJD.GooglePlayReceiver", "unable to decode job");
            m86(r8, 2);
            return null;
        }
        synchronized (this) {
            SimpleArrayMap<String, AbstractC0560> simpleArrayMap = this.f136.get(r2.mo14602());
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap<>(1);
                this.f136.put(r2.mo14602(), simpleArrayMap);
            }
            simpleArrayMap.put(r2.mo14606(), r8);
        }
        return r2;
    }

    @Override // o.C1266.AbstractC1267
    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void mo91(C0742 r6, int i) {
        SimpleArrayMap<String, AbstractC0560> simpleArrayMap = this.f136.get(r6.mo14602());
        if (simpleArrayMap != null) {
            AbstractC0560 remove = simpleArrayMap.remove(r6.mo14606());
            if (remove != null) {
                if (Log.isLoggable("FJD.GooglePlayReceiver", 2)) {
                    Log.v("FJD.GooglePlayReceiver", "sending jobFinished for " + r6.mo14606() + " = " + i);
                }
                m86(remove, i);
            }
            if (simpleArrayMap.isEmpty()) {
                this.f136.remove(r6.mo14602());
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0699 m85() {
        return f135;
    }
}
