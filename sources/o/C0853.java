package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.List;
/* renamed from: o.ᓾ  reason: contains not printable characters */
public class C0853 extends AbstractC0454 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0859 f14691;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0010: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v1 java.lang.String) */
    public C0853(String str, VideoType videoType) {
        Object[] objArr = new Object[5];
        objArr[0] = videoType == VideoType.MOVIE ? "movies" : "shows";
        objArr[1] = str;
        objArr[2] = "similars";
        objArr[3] = C0859.m15519(19);
        objArr[4] = C0859.m15523("summary", "horzDispArt");
        this.f14691 = C0859.m15528(objArr);
    }

    @Override // o.AbstractC0487
    /* renamed from: ˊ */
    public void mo14421(List<C0859> list) {
        list.add(this.f14691);
    }

    @Override // o.AbstractC0487
    /* renamed from: ॱ */
    public void mo14423(C0498 r4, AbstractC1203 r5, C0856 r6) {
        List<CH> r2 = r4.f13290.mo15259(this.f14691);
        if (r2 == null) {
            r5.mo8541(null, AbstractC0367.f13245);
        } else {
            r5.mo8541(r2, AbstractC0367.f13235);
        }
    }

    @Override // o.AbstractC0487
    /* renamed from: ˋ */
    public void mo14422(AbstractC1203 r2, Status status) {
        r2.mo8541(null, status);
    }
}
