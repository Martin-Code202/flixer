package o;

import android.text.TextUtils;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ऽ  reason: contains not printable characters */
public class C0648 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f13989;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f13990;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f13991;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0648(C0876<?> r2, String str, int i, int i2, AbstractC1203 r6) {
        super(r2, r6);
        if (str == null) {
            this.f13990 = this.f13290.m15575();
        } else {
            this.f13990 = str;
        }
        this.f13989 = i;
        this.f13991 = i2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public boolean mo14121(List<C0859> list) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        C0859 r3;
        if (TextUtils.isEmpty(this.f13990)) {
            list.add(C0859.m15528("lolomo", "summary"));
        }
        if (C1349Bv.m4113(this.f13990)) {
            r3 = C0859.m15528("lolomo", C0859.m15532(this.f13989, this.f13991));
        } else {
            r3 = C0859.m15528("lolomos", this.f13990, C0859.m15532(this.f13989, this.f13991));
        }
        list.add(r3.m15542("summary"));
        list.add(r3.m15535(C0859.m15528(C0859.m15519(uH.m11414(NetflixApplication.getInstance(), LoMoType.STANDARD) - 1), "summary")));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r5, C0856 r6) {
        r5.mo7393(this.f13290.m15580(this.f13989, r6.f14697), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo7393(Collections.emptyList(), status);
    }
}
