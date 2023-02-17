package o;

import android.text.TextUtils;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.AB;
/* renamed from: o.ᴣ  reason: contains not printable characters */
public class C0960 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f14866;

    /* renamed from: ʼ  reason: contains not printable characters */
    private LoMoType f14867 = LoMoType.STANDARD;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f14868;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14869;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14870;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f14871;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0960(C0876<?> r2, String str, String str2, String str3, String str4, String str5) {
        super(r2, AbstractC1222.m16563());
        this.f14869 = str;
        this.f14870 = str2;
        this.f14866 = str3;
        this.f14868 = str4;
        this.f14871 = str5;
        this.f14867 = LoMoType.m1573(str4);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        m15773();
        list.add(C0859.m15528("lolomos", this.f14869, "refreshList"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public boolean mo14115() {
        return true;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m15773() {
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList(8);
        String format = String.format("'%s'", this.f14870);
        String format2 = String.format("'%s'", this.f14868);
        arrayList.add(new AB.If("param", format));
        arrayList.add(new AB.If("param", this.f14866));
        arrayList.add(new AB.If("param", format2));
        if (!TextUtils.isEmpty(this.f14871)) {
            arrayList.add(new AB.If("param", String.format("'%s'", this.f14871)));
        }
        Map r9 = m15775(true, this.f14867);
        String r10 = C0859.m15528(r9, "summary").toString();
        if (this.f14867 == LoMoType.CONTINUE_WATCHING) {
            r10 = C0859.m15528(r9).m15535(C0506.m14508(true)).toString();
            arrayList.add(new AB.If("pathSuffix", C0859.m15528(r9).m15535(C0506.f13635).toString()));
        } else if (this.f14867 == LoMoType.BILLBOARD) {
            arrayList.add(new AB.If("pathSuffix", C0506.m14496(r9, C0506.m14502(true)).toString()));
            arrayList.add(new AB.If("pathSuffix", C0506.m14496(r9, C0506.f13636).toString()));
            arrayList.add(new AB.If("pathSuffix", C0506.m14495(r9).toString()));
        }
        arrayList.add(new AB.If("pathSuffix", r10));
        arrayList.add(new AB.If("pathSuffix", "['summary']"));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r3, C0856 r4) {
        C1283.m16854("CmpTask", "RefreshLomoTask finished onSuccess");
        m15774(AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r4, Status status) {
        C1283.m16854("CmpTask", "RefreshLomoTask finished onFailure statusCode=" + status);
        m15774(status);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15774(Status status) {
        C2059ph.m9734(m14132(), this.f14868);
        if (this.f14867 == LoMoType.CONTINUE_WATCHING) {
            m14130();
            mV.m8960(m14132());
        } else if (this.f14867 == LoMoType.INSTANT_QUEUE) {
            mV.m8957(m14132());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public Map m15775(boolean z, LoMoType loMoType) {
        int r6 = this.f13290.m15248();
        if (z && r6 < 0) {
            r6 = uH.m11414(m14132(), loMoType) - 1;
            C1283.m16851("CmpTask", "getLastPrefetchToVideo was unset. Defaulting to=%d", Integer.valueOf(r6));
        }
        return C0859.m15532(0, r6);
    }
}
