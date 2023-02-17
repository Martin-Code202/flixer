package com.netflix.mediaclient.service.fcm;

import android.content.Context;
import android.os.Bundle;
import com.netflix.mediaclient.service.fcm.FcmService;
import o.AbstractC0639;
import o.AbstractServiceC0766;
import o.C1283;
import o.C1456Fq;
import o.C1457Fr;
public final class FcmJobService extends AbstractServiceC0766 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f1113 = f1113;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0015 f1114 = new C0015(null);

    @Override // o.AbstractServiceC0766
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo552(AbstractC0639 r7) {
        C1283.m16854(f1114.m554(), "Performing long running task in scheduled job");
        if (r7 == null) {
            C1283.m16850(f1114.m554(), "job parameters null - drop");
            return false;
        }
        Bundle r3 = r7.mo14605();
        if (r3 == null || r3.isEmpty()) {
            C1283.m16850(f1114.m554(), "bundle bad - drop");
            return false;
        }
        C1283.m16854(f1114.m554(), "binding to NetflixService from job service");
        Context applicationContext = getApplicationContext();
        FcmService.Cif ifVar = FcmService.f1116;
        C1457Fr.m5016((Object) applicationContext, "context");
        if (applicationContext.bindService(ifVar.m566(applicationContext), new FcmService.If(r3), 1)) {
            return false;
        }
        C1283.m16850(f1114.m554(), "FcmJobService could not bind to NetflixService!");
        return false;
    }

    @Override // o.AbstractServiceC0766
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo551(AbstractC0639 r2) {
        C1457Fr.m5025(r2, "jobParameters");
        return false;
    }

    /* renamed from: com.netflix.mediaclient.service.fcm.FcmJobService$ˊ  reason: contains not printable characters */
    public static final class C0015 {
        private C0015() {
        }

        public /* synthetic */ C0015(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final String m554() {
            return FcmJobService.f1113;
        }
    }
}
