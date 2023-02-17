package com.netflix.mediaclient.android.app;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.logging.client.model.Error;
import o.C0510;
public final class NetflixImmutableStatus extends BaseStatus {
    private static final long serialVersionUID = -5942279556763023564L;

    public NetflixImmutableStatus(StatusCode statusCode) {
        this.f849 = statusCode;
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus
    /* renamed from: ʼ */
    public C0510 mo294() {
        return null;
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus
    /* renamed from: ʻ */
    public Error mo293() {
        return null;
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public String mo307() {
        return null;
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean mo306() {
        return false;
    }

    @Override // java.lang.Object
    public String toString() {
        return "NetflixImmutableStatus, " + this.f849;
    }
}
