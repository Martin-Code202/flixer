package o;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import java.net.MalformedURLException;
import java.net.URL;
/* access modifiers changed from: package-private */
public class gZ extends AbstractC2040op<gY> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private If f6936;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f6937;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f6938;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected ApiEndpointRegistry f6939;

    public interface If {
        /* renamed from: ˎ  reason: contains not printable characters */
        void mo6642();

        /* renamed from: ॱ  reason: contains not printable characters */
        void mo6643(gY gYVar);
    }

    public gZ(int i, boolean z, If r4) {
        super(0);
        this.f6937 = i;
        this.f6938 = z;
        this.f6936 = r4;
    }

    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5783(ApiEndpointRegistry apiEndpointRegistry) {
        this.f6939 = apiEndpointRegistry;
        if (this.f6939.mo1457().mo1471()) {
            m9684(this.f6939.mo1452(null).toExternalForm());
        } else {
            m9684(this.f6939.mo9651(null).toExternalForm());
        }
    }

    @Override // com.android.volley.Request
    public void checkFtlFallback() {
        if (!this.f6939.mo1457().mo1471() && isFtlEndpoint()) {
            super.changeHostUrl(this.f6939.mo9651(null).getHost());
        }
    }

    @Override // com.android.volley.Request
    public void triggerFtlFallback(VolleyError volleyError) {
        C2034oj.m9660(volleyError, this.f6939.mo1457(), getTag(), SystemClock.elapsedRealtime() - this.mRequestBirthTime);
        super.changeHostUrl(this.f6939.mo9651(null).getHost());
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public String mo5784(String str) {
        try {
            URL url = new URL(str);
            return new URL(url.getProtocol(), url.getHost(), "/ftl/probe?monotonic=true&iter=" + this.f6937 + "&force=" + this.f6938).toString();
        } catch (MalformedURLException e) {
            C1283.m16856("nf_probe", e, "unable to parse baseUrl=%s", str);
            return "";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public gY mo5785(String str) {
        return (gY) NetflixApplication.m222().fromJson(str, (Class<Object>) gY.class);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˊ */
    public String mo5781() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo5640(gY gYVar) {
        if (this.f6936 != null) {
            this.f6936.mo6643(gYVar);
        }
        this.f6936 = null;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f6936 != null) {
            this.f6936.mo6642();
        }
        this.f6936 = null;
    }

    @Override // com.android.volley.Request
    public AbstractC0573 getRetryPolicy() {
        return new C1040(2500, 0, 1.0f);
    }
}
