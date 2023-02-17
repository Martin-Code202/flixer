package o;

import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ะ  reason: contains not printable characters */
public class C0698 extends AbstractC0380 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14208;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14209;

    public C0698(C0876<?> r8, AbstractC0948 r9, C0902 r10, String str, String str2, boolean z, AbstractC1203 r14) {
        super(r8, r9, r10, str, z, r14);
        this.f14208 = str;
        this.f14209 = str2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        super.mo14127(list);
        C0506.m14518(list, Collections.singletonList(this.f14208), C0881.m15600(NetflixApplication.getInstance()));
        if (C1349Bv.m4107(this.f14209)) {
            list.add(C0506.m14494(VideoType.MOVIE.getValue(), this.f14208, this.f14209));
        }
        if (C0881.m15600(NetflixApplication.getInstance())) {
            list.add(C0506.m14503(true, this.f14208));
            list.add(C0506.m14514(true, this.f14208));
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        super.mo14114(r7, r8);
        pP pPVar = (pP) this.f13290.m15584(C0859.m15528("movies", this.f14208));
        if (pPVar == null || C1349Bv.m4113(pPVar.getId())) {
            String str = "SPY-7519: FetchMovieDetailsTask got weird movie id: " + (pPVar == null ? "null" : pPVar.getId() + " requested Movie id : " + this.f14208);
            C1276.m16820().mo5727(str);
            C1283.m16850("FetchMovieDetailsTask", str);
            r7.mo6200((pP) null, AbstractC0367.f13245);
            return;
        }
        if (pPVar instanceof CH) {
            m14483(this.f14208, ((CH) pPVar).getBookmark());
        }
        r7.mo6200(pPVar, new FalkorAgentStatus(StatusCode.OK, m14129()));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        super.mo14128(r2, status);
        r2.mo6200((pP) null, status);
    }
}
