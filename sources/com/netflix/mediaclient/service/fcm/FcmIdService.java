package com.netflix.mediaclient.service.fcm;

import android.content.Context;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.netflix.mediaclient.service.fcm.FcmService;
import o.C1283;
import o.C1456Fq;
import o.C1457Fr;
import o.Ge;
import o.ServiceC0966;
public final class FcmIdService extends FirebaseInstanceIdService {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f1111 = f1111;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Cif f1112 = new Cif(null);

    @Override // com.google.firebase.iid.FirebaseInstanceIdService
    public void onTokenRefresh() {
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        C1457Fr.m5016((Object) instance, "FirebaseInstanceId.getInstance()");
        String token = instance.getToken();
        if (token == null) {
            token = "";
        }
        if (!Ge.m5063(token)) {
            C1283.m16854(f1112.m549(), "fcm device token got refreshed: " + token);
            if (!ServiceC0966.m15814()) {
                C1283.m16854(f1112.m549(), "Netflix service is not running, no need to pick up fcm id change");
                return;
            }
            Context applicationContext = getApplicationContext();
            FcmService.Cif ifVar = FcmService.f1116;
            C1457Fr.m5016((Object) applicationContext, "context");
            if (!applicationContext.bindService(ifVar.m566(applicationContext), new FcmService.If(token), 1)) {
                C1283.m16850(f1112.m549(), "FcmJobService could not bind to NetflixService!");
            }
        }
    }

    /* renamed from: com.netflix.mediaclient.service.fcm.FcmIdService$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final String m549() {
            return FcmIdService.f1111;
        }
    }
}
