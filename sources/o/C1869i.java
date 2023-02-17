package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.user.UserAgent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.ui.lomo.BillboardView;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.originals.BigRowSummary;
import com.netflix.model.leafs.originals.BillboardBackground;
import com.netflix.model.leafs.originals.BillboardBackgroundPortrait;
import com.netflix.model.leafs.originals.BillboardLogo;
import com.netflix.model.leafs.originals.BillboardSummary;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import o.tP;
/* renamed from: o.i  reason: case insensitive filesystem */
public final class C1869i implements AbstractC2051p {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Cif f7479 = new Cif(null);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final String f7480 = f7480;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final UserAgent f7481;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C2003ng f7482;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f7483;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC2228v f7484;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0120 f7485 = new C0120(this);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final If f7486 = new If();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C1926k f7487;

    public C1869i(AbstractC2228v vVar, C2003ng ngVar, C1926k kVar, UserAgent userAgent) {
        C1457Fr.m5025(vVar, "netflixJobScheduler");
        C1457Fr.m5025(ngVar, "resourceFetcher");
        C1457Fr.m5025(kVar, "falkorAgent");
        C1457Fr.m5025(userAgent, "userAgent");
        this.f7484 = vVar;
        this.f7482 = ngVar;
        this.f7487 = kVar;
        this.f7481 = userAgent;
        AG.m3334(AbstractApplicationC1258.m16692(), this.f7485, null, "com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_ACTIVE", "com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE");
        m7387();
    }

    /* renamed from: o.i$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final String m7401() {
            return C1869i.f7480;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final int m7399() {
            if (AD.m3299()) {
                return 6;
            }
            return 3;
        }
    }

    /* renamed from: o.i$ˊ  reason: contains not printable characters */
    public static final class C0120 extends BroadcastReceiver {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C1869i f7490;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0120(C1869i iVar) {
            this.f7490 = iVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1457Fr.m5025(context, "context");
            C1457Fr.m5025(intent, "intent");
            this.f7490.m7377(intent);
        }
    }

    /* renamed from: o.i$If */
    public static final class If implements AbstractC0957 {
        If() {
        }

        @Override // o.AbstractC0957
        public void onErrorResponse(String str) {
        }

        @Override // o.AbstractC0957
        public void onResponse(Bitmap bitmap, String str) {
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m7387() {
        if (C0728.f14271.m15074()) {
            long millis = TimeUnit.HOURS.toMillis(C0728.f14271.m15072());
            if (millis <= 0) {
                AbstractC1236 r9 = C1276.m16820();
                C1464Fy fy = C1464Fy.f5682;
                Object[] objArr = {Long.valueOf(millis)};
                int length = objArr.length;
                String format = String.format("Insomnia JS jobPeriod = %d is invalid. The value should be a positive number", Arrays.copyOf(objArr, 1));
                C1457Fr.m5016((Object) format, "java.lang.String.format(format, *args)");
                r9.mo5725(format);
                return;
            }
            this.f7484.mo11320(NetflixJob.m567(millis, C0728.f14271.m15073()));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m7381() {
        this.f7484.mo11319(NetflixJob.NetflixJobId.INSOMNIA);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        o.C1445Ff.m5001(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        throw r5;
     */
    @Override // o.AbstractC2051p
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7115(com.netflix.mediaclient.service.job.NetflixJob.NetflixJobId r7) {
        /*
            r6 = this;
            java.lang.String r0 = "jobId"
            o.C1457Fr.m5025(r7, r0)
            r0 = 0
            r6.f7483 = r0
            r6.m7390()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.netflix.mediaclient.service.user.UserAgent r0 = r6.f7481
            boolean r0 = r0.mo1333()
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "status"
            java.lang.String r1 = "userNotLoggedIn"
            r2.put(r0, r1)
            com.netflix.mediaclient.servicemgr.IClientLogging$CompletionReason r0 = com.netflix.mediaclient.servicemgr.IClientLogging.CompletionReason.canceled
            r1 = 0
            r6.m7375(r0, r2, r1)
            return
        L_0x0026:
            o.ｺ r0 = o.AbstractApplicationC1258.getInstance()
            java.lang.String r1 = "BaseNetflixApp.getInstance()"
            o.C1457Fr.m5016(r0, r1)
            o.ε r0 = r0.mo234()
            java.lang.String r1 = "BaseNetflixApp.getInstance().userInputTracker"
            o.C1457Fr.m5016(r0, r1)
            boolean r0 = r0.mo14205()
            if (r0 == 0) goto L_0x004c
            java.lang.String r0 = "status"
            java.lang.String r1 = "appInForeground"
            r2.put(r0, r1)
            com.netflix.mediaclient.servicemgr.IClientLogging$CompletionReason r0 = com.netflix.mediaclient.servicemgr.IClientLogging.CompletionReason.canceled
            r1 = 0
            r6.m7375(r0, r2, r1)
            return
        L_0x004c:
            o.ｿ r0 = o.C1069.f15227
            r1 = 0
            o.丿 r0 = o.C1138.m16312(r0, r1)
            r3 = r0
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = 0
            r4 = 0
            r5 = r3
            o.丿 r5 = (o.AbstractC1096) r5     // Catch:{ Throwable -> 0x0064 }
            r5.mo16194()     // Catch:{ Throwable -> 0x0064 }
            o.EA r5 = o.EA.f5503     // Catch:{ Throwable -> 0x0064 }
            o.C1445Ff.m5001(r3, r4)
            goto L_0x006c
        L_0x0064:
            r5 = move-exception
            r4 = r5
            throw r5     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r5 = move-exception
            o.C1445Ff.m5001(r3, r4)
            throw r5
        L_0x006c:
            r6.m7384(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1869i.mo7115(com.netflix.mediaclient.service.job.NetflixJob$NetflixJobId):void");
    }

    /* renamed from: o.i$ˋ  reason: contains not printable characters */
    public static final class C0121 extends AbstractC1222 {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ HashMap f7491;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C1869i f7492;

        C0121(C1869i iVar, HashMap hashMap) {
            this.f7492 = iVar;
            this.f7491 = hashMap;
        }

        @Override // o.AbstractC1222, o.AbstractC1203
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo7402(LoLoMoSummary loLoMoSummary, Status status) {
            C1457Fr.m5025(status, "res");
            super.mo7402(loLoMoSummary, status);
            C1283.m16851(C1869i.f7479.m7401(), "Lolomo summary %s", loLoMoSummary);
            if (!this.f7492.f7483 && status.mo298()) {
                this.f7492.m7376();
            }
            IClientLogging.CompletionReason completionReason = status.mo301() ? IClientLogging.CompletionReason.failed : IClientLogging.CompletionReason.success;
            this.f7491.put("status", status.mo307());
            this.f7492.m7375(completionReason, this.f7491, status.mo301());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m7384(HashMap<String, String> hashMap) {
        this.f7487.m8162(1, (String) null, true, (AbstractC1203) new C0121(this, hashMap));
    }

    /* renamed from: o.i$iF  reason: case insensitive filesystem */
    public static final class C1870iF extends AbstractC1222 {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C1869i f7488;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1870iF(C1869i iVar) {
            this.f7488 = iVar;
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0057: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v0 java.lang.String) */
        @Override // o.AbstractC1222, o.AbstractC1203
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo7393(List<? extends pC> list, Status status) {
            super.mo7393((List<pC>) list, status);
            if (status == null || !status.mo298() || list == null) {
                String r0 = C1869i.f7479.m7401();
                Object[] objArr = new Object[1];
                objArr[0] = status != null ? status.mo307() : null;
                C1283.m16851(r0, "onLoMosFetched: failure - %s", objArr);
                return;
            }
            for (pC pCVar : list) {
                if (pCVar != null) {
                    this.f7488.f7487.m8144(pCVar, 0, uH.m11417(AbstractApplicationC1258.m16692()) - 1, false, false, false, new C0119(this));
                }
            }
        }

        /* renamed from: o.i$iF$ˋ  reason: contains not printable characters */
        public static final class C0119 extends AbstractC1222 {

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ C1870iF f7489;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C0119(C1870iF iFVar) {
                this.f7489 = iFVar;
            }

            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ॱॱ  reason: contains not printable characters */
            public void mo7398(List<pJ> list, Status status) {
                super.mo7398(list, status);
                if (list != null) {
                    Iterator<pJ> it = list.iterator();
                    while (it.hasNext()) {
                        pJ next = it.next();
                        this.f7489.f7488.m7392(next != null ? next.getBoxshotUrl() : null);
                    }
                }
            }

            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo7395(List<AbstractC2074pw> list, Status status) {
                super.mo7395(list, status);
                if (list != null) {
                    Iterator<AbstractC2074pw> it = list.iterator();
                    while (it.hasNext()) {
                        AbstractC2074pw next = it.next();
                        this.f7489.f7488.m7392(next != null ? next.getCleanBoxshotUrl() : null);
                    }
                }
            }

            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˋ  reason: contains not printable characters */
            public void mo7396(List<AbstractC2077pz> list, Status status) {
                super.mo7396(list, status);
                if (list != null) {
                    for (AbstractC2077pz pzVar : list) {
                        this.f7489.f7488.m7382(pzVar);
                    }
                }
            }

            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˋॱ  reason: contains not printable characters */
            public void mo7397(List<AbstractC2070ps> list, Status status) {
                BillboardLogo logo;
                BillboardBackground background;
                C1457Fr.m5025(list, "bigRowList");
                C1457Fr.m5025(status, "ok");
                super.mo7397(list, status);
                for (AbstractC2070ps psVar : list) {
                    C1869i iVar = this.f7489.f7488;
                    BigRowSummary bigRowSummary = psVar.getBigRowSummary();
                    iVar.m7392((bigRowSummary == null || (background = bigRowSummary.getBackground()) == null) ? null : background.getUrl());
                    C1869i iVar2 = this.f7489.f7488;
                    BigRowSummary bigRowSummary2 = psVar.getBigRowSummary();
                    iVar2.m7392((bigRowSummary2 == null || (logo = bigRowSummary2.getLogo()) == null) ? null : logo.getUrl());
                }
            }

            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ʼ  reason: contains not printable characters */
            public void mo7394(List<pK> list, Status status) {
                super.mo7394(list, status);
                if (list != null) {
                    for (pK pKVar : list) {
                        if ((pKVar instanceof CH) && tP.If.m10987()) {
                            this.f7489.f7488.m7392(((CH) pKVar).getTallPanelUrl());
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m7376() {
        this.f7487.mo7816((String) null, 0, f7479.m7399() - 1, new C1870iF(this));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m7382(AbstractC2077pz pzVar) {
        BillboardSummary billboardSummary;
        BillboardBackgroundPortrait backgroundPortrait;
        BillboardSummary billboardSummary2;
        BillboardLogo logo;
        BillboardSummary billboardSummary3;
        BillboardBackground background;
        BillboardSummary billboardSummary4;
        BillboardLogo logo2;
        BillboardSummary billboardSummary5;
        BillboardBackgroundPortrait backgroundPortrait2;
        if (BillboardView.BillboardType.m2142(pzVar != null ? pzVar.getBillboardSummary() : null)) {
            m7392((pzVar == null || (billboardSummary5 = pzVar.getBillboardSummary()) == null || (backgroundPortrait2 = billboardSummary5.getBackgroundPortrait()) == null) ? null : backgroundPortrait2.getUrl());
            m7392((pzVar == null || (billboardSummary4 = pzVar.getBillboardSummary()) == null || (logo2 = billboardSummary4.getLogo()) == null) ? null : logo2.getUrl());
            return;
        }
        m7392((pzVar == null || (billboardSummary3 = pzVar.getBillboardSummary()) == null || (background = billboardSummary3.getBackground()) == null) ? null : background.getUrl());
        m7392((pzVar == null || (billboardSummary2 = pzVar.getBillboardSummary()) == null || (logo = billboardSummary2.getLogo()) == null) ? null : logo.getUrl());
        if (AD.m3292()) {
            m7392((pzVar == null || (billboardSummary = pzVar.getBillboardSummary()) == null || (backgroundPortrait = billboardSummary.getBackgroundPortrait()) == null) ? null : backgroundPortrait.getUrl());
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m7392(String str) {
        this.f7482.m9305(AbstractApplicationC1258.m16692()).mo3059(str, AssetType.boxArt, 0, 0, this.f7486);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m7375(IClientLogging.CompletionReason completionReason, HashMap<String, String> hashMap, boolean z) {
        Context r2 = AbstractApplicationC1258.m16692();
        hashMap.put("isCellular", String.valueOf(ConnectivityUtils.m2952(r2) && ConnectivityUtils.m2969(r2) && !ConnectivityUtils.m2955(r2)));
        hashMap.put("reason", completionReason.name());
        this.f7484.mo11322(NetflixJob.NetflixJobId.INSOMNIA, z);
        m7388(hashMap);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final void m7390() {
        PerformanceProfiler.INSTANCE.m663(Sessions.INSOMNIA);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m7388(HashMap<String, String> hashMap) {
        PerformanceProfiler.INSTANCE.m665(Sessions.INSOMNIA, hashMap);
    }

    @Override // o.AbstractC2051p
    /* renamed from: ˊ */
    public void mo7114(NetflixJob.NetflixJobId netflixJobId) {
        C1457Fr.m5025(netflixJobId, "jobId");
        this.f7483 = true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m7391() {
        AG.m3329(AbstractApplicationC1258.m16692(), this.f7485);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m7377(Intent intent) {
        String r1 = AG.m3332(intent);
        if (r1 != null) {
            switch (r1.hashCode()) {
                case -1141868828:
                    if (r1.equals("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_ACTIVE")) {
                        m7387();
                        return;
                    }
                    return;
                case 39639845:
                    if (r1.equals("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE")) {
                        m7381();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
