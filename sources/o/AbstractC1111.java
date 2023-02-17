package o;

import android.content.Context;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.webclient.AUIApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
/* renamed from: o.ﬥ  reason: contains not printable characters */
abstract class AbstractC1111<T> extends AbstractC1103<T> {

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static String f15329 = "aui";

    AbstractC1111(Context context, AbstractC1221 r2) {
        super(context, r2);
    }

    AbstractC1111(Context context, AbstractC1221 r2, int i) {
        super(context, r2, i);
    }

    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5783(ApiEndpointRegistry apiEndpointRegistry) {
        this.f15290 = (AUIApiEndpointRegistry) apiEndpointRegistry;
        m9684(this.f15290.mo9651(null).toExternalForm());
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.AUI;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public boolean mo9692() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ʻ */
    public boolean mo9685() {
        return false;
    }
}
