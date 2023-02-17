package com.netflix.mediaclient.service.fcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.netflix.mediaclient.android.app.Status;
import java.util.Map;
import o.C0353;
import o.C0548;
import o.C1283;
import o.C1456Fq;
import o.C1457Fr;
import o.C2066po;
import o.ServiceC0966;
import o.oE;
public final class FcmService extends FirebaseMessagingService {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f1115 = f1115;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final Cif f1116 = new Cif(null);

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage != null) {
            C1283.m16854(f1116.m565(), "received msg from: " + remoteMessage.getFrom());
            Map<String, String> data = remoteMessage.getData();
            C1457Fr.m5016((Object) data, "remoteMessage.data");
            if (!data.isEmpty()) {
                C1283.m16851(f1116.m565(), "Message data payload: %s", remoteMessage.getData());
                if (ServiceC0966.m15814()) {
                    C1283.m16854(f1116.m565(), "Netflix service is running. Try to bind and send intent");
                    Context applicationContext = getApplicationContext();
                    Cif ifVar = f1116;
                    C1457Fr.m5016((Object) applicationContext, "context");
                    Intent r0 = ifVar.m566(applicationContext);
                    Map<String, String> data2 = remoteMessage.getData();
                    C1457Fr.m5016((Object) data2, "remoteMessage.data");
                    if (!applicationContext.bindService(r0, new If(data2), 1)) {
                        C1283.m16850(f1116.m565(), "FcmJobService could not bind to NetflixService!");
                        Map<String, String> data3 = remoteMessage.getData();
                        C1457Fr.m5016((Object) data3, "remoteMessage.data");
                        m557(m556(data3));
                        return;
                    }
                    return;
                }
                Map<String, String> data4 = remoteMessage.getData();
                C1457Fr.m5016((Object) data4, "remoteMessage.data");
                m557(m556(data4));
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m557(Bundle bundle) {
        C1283.m16854(f1116.m565(), "scheduling job for rcvd push message");
        C0353 r4 = new C0353(new C0548(this));
        r4.m13959(r4.m13958().m14622(FcmJobService.class).m14620(bundle).m14621("" + SystemClock.elapsedRealtime()).m14619());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Bundle m556(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, String.valueOf(map.get(str)));
        }
        C1283.m16854(f1116.m565(), "bundle: " + bundle);
        return bundle;
    }

    public static final class If implements ServiceConnection {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Object f1117;

        public If(Object obj) {
            C1457Fr.m5025(obj, "receivedMsg");
            this.f1117 = obj;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1457Fr.m5025(componentName, "component");
            C1457Fr.m5025(iBinder, "rawBinder");
            C1283.m16854(FcmService.f1116.m565(), "ServiceConnected with IBinder");
            oE r3 = ((ServiceC0966.BinderC0967) iBinder).m15872();
            r3.mo9448(new Cif(this, r3));
        }

        /* renamed from: com.netflix.mediaclient.service.fcm.FcmService$If$if  reason: invalid class name */
        public static final class Cif extends C2066po {

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ oE f1118;

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ If f1119;

            Cif(If r1, oE oEVar) {
                this.f1119 = r1;
                this.f1118 = oEVar;
            }

            @Override // o.C2066po, o.oL
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo563(int i, Status status) {
                C1457Fr.m5025(status, "res");
                super.mo563(i, status);
                if (status.mo298()) {
                    If r0 = this.f1119;
                    oE oEVar = this.f1118;
                    C1457Fr.m5016((Object) oEVar, "netflixService");
                    Context applicationContext = oEVar.getApplicationContext();
                    C1457Fr.m5016((Object) applicationContext, "netflixService.applicationContext");
                    Intent r5 = this.f1119.m558(r0.m560(applicationContext), this.f1119.f1117);
                    C1283.m16853(FcmService.f1116.m565(), "sending message to netflixService:", r5);
                    this.f1118.mo9444(r5);
                    return;
                }
                C1283.m16844(FcmService.f1116.m565(), "dropping received intent: %s, service init failed: %s", this.f1119.f1117, status);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1457Fr.m5025(componentName, "arg0");
            C1283.m16854(FcmService.f1116.m565(), "onServiceDisconnected");
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private final Intent m558(Intent intent, Object obj) {
            if (obj instanceof String) {
                intent.putExtra("reg_id", (String) obj);
            } else if (obj instanceof Bundle) {
                for (String str : ((Bundle) obj).keySet()) {
                    Object obj2 = ((Bundle) obj).get(str);
                    intent.putExtra(str, obj2 != null ? obj2.toString() : null);
                }
            } else if (obj instanceof Map) {
                for (Object obj3 : ((Map) obj).keySet()) {
                    if (obj3 instanceof String) {
                        String str2 = (String) obj3;
                        Object obj4 = ((Map) obj).get(obj3);
                        intent.putExtra(str2, obj4 != null ? obj4.toString() : null);
                    }
                }
            }
            return intent;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˎ  reason: contains not printable characters */
        private final Intent m560(Context context) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_GCM_ONMESSAGE");
            intent.setClass(context, ServiceC0966.class);
            intent.addCategory("com.netflix.mediaclient.intent.category.PUSH");
            intent.putExtra("isRunning", ServiceC0966.m15814());
            return intent;
        }
    }

    /* renamed from: com.netflix.mediaclient.service.fcm.FcmService$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final String m565() {
            return FcmService.f1115;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final Intent m566(Context context) {
            C1457Fr.m5025(context, "context");
            return new Intent(context, ServiceC0966.class);
        }
    }
}
