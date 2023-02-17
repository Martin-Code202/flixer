package o;

import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.BillboardInteractionType;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: o.ᴏ  reason: contains not printable characters */
public class C0949 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final If f14845 = new If();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Map<String, String> f14846;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final BillboardInteractionType f14847;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final pJ f14848;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0949(C0876<?> r2, pJ pJVar, BillboardInteractionType billboardInteractionType, Map<String, String> map) {
        super(r2, AbstractC1222.m16563());
        this.f14848 = pJVar;
        this.f14847 = billboardInteractionType;
        this.f14846 = map;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        String str = "{}";
        if (this.f14846 != null) {
            str = new JSONObject(this.f14846).toString();
        }
        if (f14845.m15765(this.f13290.m15575(), this.f14848.getId())) {
            list.add(C0859.m15528("logBillboardActivity", this.f14848.getId(), this.f14847.m1501(), str));
        } else {
            m14111();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ͺ */
    public boolean mo14125() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14113(JsonObject jsonObject) {
        if (C0848.m15504(jsonObject.getAsJsonObject("value"))) {
            throw new FalkorException("Empty value");
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r1, C0856 r2) {
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r1, Status status) {
    }

    /* renamed from: o.ᴏ$If */
    static final class If {

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f14849 = null;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final HashSet<String> f14850 = new HashSet<>();

        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean m15765(String str, String str2) {
            if (C1349Bv.m4113(str2) || C1349Bv.m4113(str)) {
                return false;
            }
            if (!C1349Bv.m4126(str, this.f14849)) {
                C1283.m16851("CmpTask", "different lolomoId old: %s, new %s, videoId: %s", this.f14849, str, str2);
                this.f14849 = str;
                if (this.f14850.size() > 0) {
                    this.f14850.clear();
                }
                this.f14850.add(str2);
                return true;
            } else if (this.f14850.contains(str2)) {
                return false;
            } else {
                this.f14850.add(str2);
                C1283.m16851("CmpTask", "(size: %d) - Added videoId: %s", Integer.valueOf(this.f14850.size()), str2);
                return true;
            }
        }
    }
}
