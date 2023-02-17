package o;

import android.content.Context;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.StreamingCodecPrefData;
import com.netflix.mediaclient.util.ConnectivityUtils;
import org.json.JSONObject;
/* renamed from: o.jb  reason: case insensitive filesystem */
public class C1901jb extends iW {
    C1901jb(AbstractC1221 r1, UserAgentInterface userAgentInterface, ConnectivityUtils.NetType netType, Context context) {
        super(context, userAgentInterface, r1, netType);
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ॱ */
    public void mo7614(JSONObject jSONObject) {
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ˋ */
    public boolean mo7608(Context context) {
        StreamingCodecPrefData l_ = this.f7674.l_();
        if (l_ == null) {
            return false;
        }
        return !ConnectivityUtils.m2952(context) || !l_.isAVCHighCodecDisabledForCellular;
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ˎ */
    public boolean mo7610() {
        StreamingCodecPrefData l_ = this.f7674.l_();
        return l_ != null && l_.isVP9HWCodecEnabled;
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ˏ */
    public boolean mo7612() {
        StreamingCodecPrefData l_ = this.f7674.l_();
        return l_ != null && l_.isEveVP9HWCodecEnabled;
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ˋ */
    public boolean mo7607() {
        StreamingCodecPrefData l_ = this.f7674.l_();
        return l_ != null && l_.isAVCHighCodecEnabled;
    }
}
