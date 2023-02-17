package o;

import android.text.TextUtils;
import com.android.volley.Request;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.LoLoMoSummary;
import java.util.ArrayList;
import java.util.List;
import o.AB;
import o.tP;
/* renamed from: o.冖  reason: contains not printable characters */
public class C1101 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static long f15276 = 0;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final boolean f15277;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f15278;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f15279;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final boolean f15280;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f15281;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final String f15282;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final int f15283;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f15284;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int f15285;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C1101(C0876<?> r7, int i, int i2, int i3, int i4, boolean z, boolean z2, AbstractC1203 r14, int i5, boolean z3, String str) {
        super(r7, r14);
        this.f15281 = i;
        this.f15279 = i2;
        this.f15284 = i3;
        this.f15285 = i4;
        this.f15278 = z;
        this.f15277 = z2;
        this.f15280 = z3;
        this.f15282 = str;
        this.f15283 = i5;
        boolean r5 = m16207();
        C1283.m16851("CmpTask", "Checking if - refreshType = %s & if lolomoExpired = %s", Integer.valueOf(i5), Boolean.valueOf(r5));
        if (i5 == 1 || r5) {
            this.f13290.m15587();
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean m16207() {
        LoLoMoSummary loLoMoSummary = (LoLoMoSummary) this.f13290.mo15251(C0859.m15528("lolomo", "summary"));
        if (loLoMoSummary == null) {
            C1283.m16854("CmpTask", "Lolomosummary is null, checking PreferenceKey");
            return System.currentTimeMillis() > C1339Bl.m4044(m14132(), "prefs_cache_installed_lolomo_expiry_time_stamp", 0);
        }
        long expiryTimeStamp = loLoMoSummary.getExpiryTimeStamp();
        long currentTimeMillis = (System.currentTimeMillis() - expiryTimeStamp) / 1000;
        C1283.m16851("CmpTask", "lolomo expiry time stamp = %d, FORCE_EXP_DELTA PLT = %d, Lolomo's time to expiry = %d", Long.valueOf(expiryTimeStamp), Long.valueOf(f15276), Long.valueOf(currentTimeMillis));
        return currentTimeMillis > 0;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f15277 || this.f15283 == 2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public boolean mo14121(List<C0859> list) {
        return list.size() > 25;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("lolomo", "summary"));
        list.add(C0859.m15528("lolomo", C0859.m15519(this.f15281), "summary"));
        list.add(C0859.m15528("lolomo", C0859.m15519(this.f15281), C0859.m15519(this.f15279), "summary"));
        C0506.m14498(list, (String) null, (String) null, 0, this.f15284, false);
        C0506.m14505(list, null, null, 0, this.f15285, false);
        if (tP.If.m10987()) {
            C0506.m14516(list, null, null, 0, this.f15279);
        }
        C0506.m14517(list, null, null, 0, 1, false);
        if (C0878.m15589()) {
            C0506.m14511(list, null, null, 0, this.f15279, false);
        }
        if (C0891.m15609()) {
            C0506.m14501(list, null, null, 0, this.f15279, false);
        }
        list.add(C0859.m15528("lolomo", "queue", "summary"));
        if (this.f15278) {
            int i = this.f15279 + 1;
            list.add(C0859.m15528("lolomo", "characters", C0859.m15532(i, this.f15279 + i), "summary"));
        }
    }

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋ */
    public Request.Priority mo14117() {
        return Request.Priority.IMMEDIATE;
    }

    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public Object mo14126() {
        return NetworkRequestType.BROWSE_PREFETCH;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList();
        if (zK.m13486().m13494()) {
            arrayList.add(new AB.If("isFirstLolomoAfterOnRamp", Boolean.TRUE.toString()));
        }
        ABTestConfig.Cell r4 = C0728.f14271.m15075();
        if (r4 != null) {
            arrayList.add(new AB.If("ab9064", String.valueOf(r4.getCellId())));
        }
        if (this.f15280) {
            arrayList.add(new AB.If("bgFetch", Boolean.TRUE.toString()));
        }
        if (!TextUtils.isEmpty(this.f15282)) {
            arrayList.add(new AB.If("renoId", this.f15282));
        }
        if (this.f15283 == 2) {
            arrayList.add(new AB.If("refreshContent", Boolean.TRUE.toString()));
        }
        if (C0891.m15609()) {
            arrayList.add(new AB.If("previewsEnabled", Boolean.TRUE.toString()));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        r6.mo7402((LoLoMoSummary) this.f13290.mo15251(C0859.m15528("lolomo", "summary")), new FalkorAgentStatus(StatusCode.OK, m14129()));
        m14130();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r6, Status status) {
        r6.mo7402((LoLoMoSummary) this.f13290.mo15251(C0859.m15528("lolomo", "summary")), status);
    }
}
