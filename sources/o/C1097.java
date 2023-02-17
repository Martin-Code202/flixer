package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballCallData;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.List;
/* renamed from: o.乀  reason: contains not printable characters */
public class C1097 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Context f15265;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1221 f15266;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1194 f15267;

    public C1097(Context context, AbstractC1194 r2, AbstractC1221 r3) {
        this.f15265 = context;
        this.f15267 = r2;
        this.f15266 = r3;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public NetflixDataRequest m16201(MoneyballCallData moneyballCallData, AbstractC1113 r8) {
        return new C1192(this.f15265, this.f15267, this.f15266, moneyballCallData, r8);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public NetflixDataRequest m16200(List<String> list, AbstractC1113 r8) {
        return new C1083(this.f15265, this.f15267, this.f15266, list, r8);
    }
}
