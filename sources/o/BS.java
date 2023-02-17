package o;

import com.android.volley.VolleyError;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.util.Map;
public abstract class BS implements ImageLoader.AbstractC0050 {

    /* renamed from: ʼ  reason: contains not printable characters */
    protected final AbstractC1188 f4618;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected final String f4619;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Map<String, oN> f4620;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f4621;

    public BS(AbstractC1188 r1, String str, Map<String, oN> map) {
        this.f4618 = r1;
        this.f4619 = str;
        this.f4620 = map;
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader.AbstractC0050
    /* renamed from: ˋ */
    public String mo3066() {
        return this.f4619;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m3921() {
        for (oN oNVar : this.f4620.values()) {
            if (oNVar.mo9574(this.f4618)) {
                oNVar.mo9576(this, this.f4618);
            }
        }
        this.f4621 = true;
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader.AbstractC0050
    /* renamed from: ˋ */
    public void mo3067(BT bt, ImageLoader.AssetLocationType assetLocationType) {
        this.f4618.setAssetLocationType(assetLocationType);
        if (this.f4621) {
            for (oN oNVar : this.f4620.values()) {
                oNVar.mo9572(this, assetLocationType);
            }
        }
    }

    @Override // o.C0524.AbstractC2398iF
    public void onErrorResponse(VolleyError volleyError) {
        if (this.f4621) {
            for (oN oNVar : this.f4620.values()) {
                oNVar.mo9572(this, ImageLoader.AssetLocationType.NETWORK);
            }
        }
    }
}
