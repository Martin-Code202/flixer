package o;

import android.content.Context;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.List;
/* renamed from: o.ﭖ  reason: contains not printable characters */
public class C1116 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC1221 f15332;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Context f15333;

    public C1116(Context context, AbstractC1221 r2) {
        this.f15333 = context;
        this.f15332 = r2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public NetflixDataRequest m16247(oR oRVar, List<String> list, AbstractC1254 r10) {
        if (oRVar == null) {
            return new C1129(this.f15333, this.f15332, list, false, r10);
        }
        C1109 r6 = new C1109(this.f15333, list, r10);
        r6.m6619(oRVar);
        return r6;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixDataRequest m16249(boolean z, AbstractC1254 r4) {
        if (z) {
            return new C1130(r4);
        }
        return new C1140(this.f15333, r4);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public NetflixDataRequest m16251(String str, String str2, AbstractC1254 r9) {
        if (!this.f15332.k_()) {
            return new C1205(this.f15333, this.f15332, str, str2, r9);
        }
        return new C1206(this.f15333, this.f15332, str, str2, r9);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetflixDataRequest m16250(List<String> list, AbstractC0477 r5) {
        if (this.f15332.mo16511()) {
            return new C1143(list, r5);
        }
        return new C1144(this.f15333, list, false, r5);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixDataRequest m16248(String str, AbstractC2033oi oiVar) {
        if (this.f15332.mo16511()) {
            return new C1154(str, oiVar);
        }
        return new C1207(this.f15333, str, oiVar);
    }
}
