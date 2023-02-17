package o;

import android.text.TextUtils;
import com.netflix.model.leafs.LoLoMoSummary;
import java.util.Map;
/* renamed from: o.su  reason: case insensitive filesystem */
public abstract class AbstractC2163su extends AbstractC0517 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private LoLoMoSummary f10294;

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10854(boolean z) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo10856(int i, String str) {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m10853(LoLoMoSummary loLoMoSummary) {
        this.f10294 = loLoMoSummary;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final LoLoMoSummary m10855() {
        return this.f10294;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final Map<String, String> m10852(Map<String, String> map) {
        if (this.f10294 == null) {
            C1283.m16854("HomeFragment", "No-op! lolomo summary is null, nothing to populate.");
            return map;
        }
        map.put("lolomoId", this.f10294.getId());
        map.put("isFromCache", String.valueOf(this.f10294.isFromCache()));
        map.put("timeToExpiry", String.valueOf(this.f10294.getExpiryTimeStamp() - System.currentTimeMillis()));
        if (m14536() != null) {
            String r5 = m14536().m9835();
            map.put("isProfileMismatch", String.valueOf(!TextUtils.equals(r5, this.f10294.getLolomoProfileGuid())));
            map.put("clientProfileGuid", r5);
            map.put("lolomoProfileGuid", this.f10294.getLolomoProfileGuid());
            AbstractC2089qj r6 = m14536().m9826();
            String str = null;
            if (r6 != null) {
                str = String.valueOf(r6.isKidsProfile());
            }
            map.put("isKidsProfile", str);
        }
        return map;
    }
}
