package com.netflix.mediaclient.android.app;

import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.logging.client.model.Error;
import o.C0510;
import o.C1343Bp;
public class NetworkErrorStatus extends BaseStatus {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Error f855;

    /* renamed from: ˎ  reason: contains not printable characters */
    private VolleyError f856;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0510 f857;

    public NetworkErrorStatus(VolleyError volleyError) {
        this.f849 = StatusCode.NETWORK_ERROR;
        this.f856 = volleyError;
        this.f857 = C1343Bp.m4065(volleyError);
        this.f855 = C1343Bp.m4063(volleyError);
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus
    /* renamed from: ʼ */
    public C0510 mo294() {
        return this.f857;
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus
    /* renamed from: ʻ */
    public Error mo293() {
        return this.f855;
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ॱˊ */
    public String mo307() {
        return null;
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ˊॱ */
    public boolean mo306() {
        return false;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public VolleyError m313() {
        return this.f856;
    }

    @Override // java.lang.Object
    public String toString() {
        return "NetworkErrorStatus{VolleyError=" + this.f856 + ", Error=" + this.f857 + '}';
    }
}
