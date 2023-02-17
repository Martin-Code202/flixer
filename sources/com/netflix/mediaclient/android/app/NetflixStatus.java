package com.netflix.mediaclient.android.app;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.logging.client.model.Error;
import o.C0510;
public class NetflixStatus extends BaseStatus {
    private static final long serialVersionUID = 5121797712426793309L;

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f850;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected transient Error f851;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected String f852;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected boolean f853;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected transient C0510 f854;

    public NetflixStatus(StatusCode statusCode, int i) {
        if (statusCode == null) {
            throw new IllegalArgumentException("Status code can not be null!");
        }
        this.f849 = statusCode;
        this.f850 = i;
    }

    public NetflixStatus(StatusCode statusCode) {
        this(statusCode, Integer.MAX_VALUE);
    }

    public NetflixStatus(StatusCode statusCode, Throwable th) {
        this(statusCode, Integer.MAX_VALUE);
        this.f848 = th;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m308(int i) {
        this.f850 = i;
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus
    /* renamed from: ʼ */
    public C0510 mo294() {
        return this.f854;
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus
    /* renamed from: ʻ */
    public Error mo293() {
        return this.f851;
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ॱˊ */
    public String mo307() {
        return this.f852;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m312(String str) {
        this.f852 = str;
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ˊॱ */
    public boolean mo306() {
        return this.f853;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m311(boolean z) {
        this.f853 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m310(C0510 r1) {
        this.f854 = r1;
    }

    @Override // java.lang.Object
    public String toString() {
        return "NetflixStatus, " + this.f849;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m309(Error error) {
        this.f851 = error;
    }
}
