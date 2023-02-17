package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
/* renamed from: o.ト  reason: contains not printable characters */
abstract class AbstractC1084<T> extends AbstractC2035ok<T> {
    AbstractC1084(Context context) {
        super(context);
    }

    AbstractC1084(Context context, int i) {
        super(context, i);
    }

    @Override // o.AbstractC2035ok, o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5783(ApiEndpointRegistry apiEndpointRegistry) {
        this.f9334 = apiEndpointRegistry;
        if (!mo9664() || !this.f9334.mo1457().mo1471()) {
            m9684(this.f9334.mo1451(null));
        } else {
            m9684(this.f9334.mo1458(null));
        }
    }
}
