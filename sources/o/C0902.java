package o;

import android.util.Pair;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.servicemgr.BillboardInteractionType;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.C0876;
import o.C1348Bu;
import o.tP;
/* renamed from: o.ᖕ  reason: contains not printable characters */
public class C0902 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0876<?> f14781;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1926k f14782;

    public C0902(C0876<?> r1, C1926k kVar) {
        this.f14781 = r1;
        this.f14782 = kVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15649(String str, String str2) {
        if (C1349Bv.m4113(str)) {
            C1283.m16854("NetflixFalkorTasksDispatcher", "Can't refresh list - input listContext is null or empty");
        } else if (C1349Bv.m4113(this.f14781.m15577(str))) {
            C1283.m16854("NetflixFalkorTasksDispatcher", "Can't refresh list - lolomoId is empty");
        } else {
            List<C0876.Cif> r8 = this.f14781.m15588(str);
            if (r8 == null || r8.isEmpty()) {
                C1283.m16851("NetflixFalkorTasksDispatcher", "Can't refresh list - no listContext %s rows found", str);
                return;
            }
            for (C0876.Cif ifVar : r8) {
                if (ifVar == null || ifVar.f14754 == null) {
                    C1283.m16851("NetflixFalkorTasksDispatcher", "Can't refresh list - refreshData is null for listContext %s", str);
                } else {
                    pC pCVar = ifVar.f14754;
                    String id = pCVar.getId();
                    String str3 = ifVar.f14756;
                    long refreshInterval = pCVar.getRefreshInterval();
                    if (C1349Bv.m4113(id)) {
                        C1283.m16854("NetflixFalkorTasksDispatcher", "Can't refresh list - lomo id is empty");
                    } else if (String.valueOf(-1).equals(str3)) {
                        C1283.m16854("NetflixFalkorTasksDispatcher", "Can't refresh list - lomo index is invalid");
                    } else if (pCVar.getType() != LoMoType.STANDARD || refreshInterval > 0) {
                        m15635(new C0960(this.f14781, ifVar.f14755, id, str3, str, str2));
                    } else {
                        C1283.m16854("NetflixFalkorTasksDispatcher", "Can't refresh list - refresh interval is <= 0, the list is not a volatile row");
                    }
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15652(AbstractC0487 r4, AbstractC1203 r5) {
        m15635(new C0498(this.f14781, this.f14782, r4, r5));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15663(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, AbstractC1203 r22, int i7, boolean z4, String str) {
        this.f14781.f14451 = i3;
        this.f14781.f14452 = i4;
        m15635(new C1101(this.f14781, i2, i4, i6, 2, z, z3, r22, i7, z4, str));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15678(String str, int i, int i2, int i3, int i4, int i5, AbstractC1203 r14) {
        m15635(new C0999(this.f14781, str, i2, i4, i5, r14));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15666(String str, int i, int i2, AbstractC1203 r10) {
        m15635(new C0648(this.f14781, str, i, i2, r10));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15644(pC pCVar, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, AbstractC1203 r18) {
        if (LoMoType.BILLBOARD.equals(pCVar.getType())) {
            m15635(new C0576(this.f14781, i, i2, pCVar.getId(), z, r18));
        } else if (LoMoType.ROAR.equals(pCVar.getType()) && tP.If.m10987() && pCVar.isRichUITreatment()) {
            m15635(new C0822(this.f14781, pCVar, i, i2, z, z2, z3, z4, r18));
        } else if (LoMoType.BIG_ROW.equals(pCVar.getType())) {
            m15635(new C0535(this.f14781, i, 1, pCVar.getId(), z, r18));
        } else if (LoMoType.SHORT_FORM.equals(pCVar.getType())) {
            m15635(new C0849(this.f14781, i, i2, pCVar.getId(), r18));
        } else if (LoMoType.PREVIEWS.equals(pCVar.getType())) {
            m15635(new C0756(this.f14781, i, i2, pCVar.getId(), r18));
        } else {
            m15635(new C0873(this.f14781, pCVar, i, i2, z, z2, z3, z4, r18));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15665(int i, boolean z, AbstractC1203 r5) {
        m15635(new C0686(this.f14781, i, z, r5));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15654(int i, int i2, String str, boolean z, AbstractC1203 r12) {
        m15635(new C0576(this.f14781, i, i2, str, z, r12));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15646(int i, int i2, String str, boolean z, AbstractC1203 r13) {
        m15635(new C0546(this.f14781, this.f14782, i, i2, str, z ? CmpTaskMode.FROM_CACHE_ONLY : CmpTaskMode.FROM_CACHE_OR_NETWORK, r13));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15637(int i, int i2, String str, AbstractC1203 r12) {
        m15635(new C0546(this.f14781, this.f14782, i, i2, str, CmpTaskMode.FROM_NETWORK, r12));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15664(int i, int i2, String str, AbstractC1203 r10) {
        m15635(new C0849(this.f14781, i, i2, str, r10));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15653(int i, int i2, String str, AbstractC1203 r10) {
        m15635(new C0756(this.f14781, i, i2, str, r10));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15676(int i, AbstractC1203 r4) {
        m15635(new C0872(this.f14781, i, r4));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15636() {
        m15635(new C1054(this.f14781, this.f14782));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15656(VideoType videoType, String str, boolean z, AbstractC1203 r10) {
        m15635(new C0877(this.f14781, videoType, str, z, r10));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15673(List<String> list, AbstractC1203 r4) {
        m15635(new C0753(this.f14781, list, r4));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15675(int i, int i2, pC pCVar, boolean z, boolean z2, boolean z3, final AbstractC1203 r18) {
        if (pCVar == null) {
            Pair<pC, String> r10 = this.f14781.m15579(LoMoType.INSTANT_QUEUE);
            if (r10 != null) {
                pCVar = (pC) r10.first;
            } else {
                C1283.m16865("NetflixFalkorTasksDispatcher", "Asked to fetch IQ videos but no IQ lomo currently exists in cache!");
                C1348Bu.If.m4098(new Runnable() { // from class: o.ᖕ.4
                    @Override // java.lang.Runnable
                    public void run() {
                        r18.mo7398(null, AbstractC0367.f13251);
                    }
                });
                return;
            }
        }
        m15635(new C0873(this.f14781, pCVar, i, i2, z, z2, false, z3, r18));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15683(AbstractC1203 r3) {
        m15635(new C0587(this.f14781, r3));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15658(String str, CmpTaskMode cmpTaskMode, AbstractC1203 r5) {
        m15635(new C0588(this.f14781, str, cmpTaskMode, r5));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15638(String str, int i, int i2, AbstractC1203 r10) {
        m15635(new C0710(this.f14781, str, i, i2, r10));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15671(String str, AbstractC1203 r4) {
        m15635(new C0854(this.f14781, str, r4));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15643(String str, AbstractC1203 r4) {
        m15635(new C0585(this.f14781, str, r4));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15670(String str, String str2, boolean z, AbstractC1203 r12) {
        m15635(new C0698(this.f14781, this.f14782, this, str, str2, z, r12));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15680(String str, String str2, boolean z, boolean z2, boolean z3, AbstractC1203 r16) {
        m15635(new C0850(this.f14781, this.f14782, this, str, str2, z, z2, z3, r16));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15672(String str, boolean z, AbstractC1203 r10) {
        m15635(new C0858(this.f14781, this.f14782, this, str, z, r10));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15662(List<? extends AbstractC2072pu> list, AbstractC1203 r3) {
        boolean r0 = qX.m10004();
        qX.m10010(list, r3);
        if (r0) {
            m15645();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15645() {
        while (!qX.m10004() && qX.m10017() < 2) {
            qX.m10001();
            AbstractC2072pu r8 = qX.m10012();
            if (r8 != null) {
                AbstractC1203 r9 = qX.m10013(r8);
                if (r8.getType() == VideoType.MOVIE) {
                    m15670(r8.getId(), (String) null, true, r9);
                } else if (r8.getType() == VideoType.SHOW) {
                    m15680(r8.getId(), null, true, true, true, r9);
                } else if (r8.getType() == VideoType.CHARACTERS) {
                    m15672(r8.getId(), true, r9);
                }
            } else {
                qX.m10007();
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15668(String str, VideoType videoType, PlayLocationType playLocationType, AbstractC1203 r10) {
        m15635(new C0771(this.f14781, str, videoType, playLocationType, r10));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15660(String str, VideoType videoType, AbstractC1203 r10) {
        m15635(new C0773(this.f14781, this.f14782, this, str, videoType, r10));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15648(String str, VideoType videoType, String str2, String str3, AbstractC1203 r12) {
        m15635(new C0934(this.f14781, str, videoType, str2, str3, r12));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15642(String str, String str2, AbstractC1203 r5) {
        m15635(new C0945(this.f14781, str, str2, r5));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15661(String str, String str2, AbstractC1203 r9) {
        m15635(new C0562(this.f14781, this.f14782, str, str2, r9));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15677(VideoType videoType, String str, String str2, AbstractC1203 r10) {
        m15635(new C0827(this.f14781, videoType, str, str2, r10));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15650(String str, AbstractC1203 r4) {
        m15635(new C0620(this.f14781, str, r4));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15640(String str, CmpTaskMode cmpTaskMode, AbstractC1203 r5) {
        m15635(new C0778(this.f14781, str, cmpTaskMode, r5));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15639(String str, CmpTaskMode cmpTaskMode, VideoType videoType, int i, int i2, AbstractC1203 r15) {
        m15635(new C0598(this.f14781, this.f14782, str, cmpTaskMode, videoType, i, i2, r15));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15641(String str, CmpTaskMode cmpTaskMode, boolean z, AbstractC1203 r10) {
        m15635(new C0691(this.f14781, str, cmpTaskMode, z, r10));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15647(String str, CmpTaskMode cmpTaskMode, int i, int i2, boolean z, AbstractC1203 r14) {
        m15635(new C0823(this.f14781, cmpTaskMode, str, z, i, i2, r14));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15651(String str, AbstractC1203 r8, int i, int i2) {
        m15635(new C0831(this.f14781, str, r8, i, i2));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15655(int i, int i2, boolean z, AbstractC1203 r10) {
        m15635(new C0770(this.f14781, i, i2, z, r10));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15657(IrisNotificationSummary irisNotificationSummary, AbstractC1203 r4) {
        m15635(new C0959(this.f14781, irisNotificationSummary, r4));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15682(List<IrisNotificationSummary> list, AbstractC1203 r4) {
        m15635(new C0959(this.f14781, list, r4));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15659(String str, VideoType videoType, int i, int i2, AbstractC1203 r12) {
        m15635(new C1213(this.f14781, str, videoType, i, i2, r12));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15667(String str, VideoType videoType, int i, String str2, AbstractC1203 r18) {
        String r11 = this.f14781.m15575();
        Pair<String, String> r12 = this.f14781.m15583(LoMoType.INSTANT_QUEUE);
        m15635(new C0466(this.f14781, this.f14782, str, videoType, r11, (String) r12.first, (String) r12.second, i, str2, r18));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15669(String str, VideoType videoType, String str2, AbstractC1203 r15) {
        String r9 = this.f14781.m15575();
        Pair<String, String> r10 = this.f14781.m15583(LoMoType.INSTANT_QUEUE);
        m15635(new C1227(this.f14781, str, videoType, r9, (String) r10.first, (String) r10.second, str2, r15));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15674(pJ pJVar, BillboardInteractionType billboardInteractionType, Map<String, String> map) {
        m15635(new C0949(this.f14781, pJVar, billboardInteractionType, map));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15679(String str, ExpiringContentAdvisory.ContentAction contentAction) {
        m15635(new C1228(this.f14781, str, contentAction));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15681(String str, AbstractC1203 r4) {
        if (!C1349Bv.m4113(str)) {
            m15635(new C0507(this.f14781, str, r4));
        } else if (r4 != null) {
            r4.mo8522(new ArrayList(0), AbstractC0367.f13234);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m15635(Runnable runnable) {
        C1283.m16848("NetflixFalkorTasksDispatcher", "Launching task: %s", runnable.getClass().getSimpleName());
        new BackgroundTask().m285(runnable);
    }
}
