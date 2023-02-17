package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ᖪ  reason: contains not printable characters */
public class C0909 extends C0946 {
    public C0909(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    /* access modifiers changed from: protected */
    @Override // o.C0946
    /* renamed from: ˏ  reason: contains not printable characters */
    public DetailsActivity.Action mo15707() {
        return DetailsActivity.Action.AddToMyList;
    }

    /* access modifiers changed from: protected */
    @Override // o.C0946
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo15706() {
        return (String) this.f1041.get("msg_token");
    }
}
