package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
/* access modifiers changed from: package-private */
/* renamed from: o.hd  reason: case insensitive filesystem */
public class C1845hd extends AbstractC2040op<String> {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC0114 f7221;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f7222;

    /* renamed from: o.hd$ˋ  reason: contains not printable characters */
    public interface AbstractC0114 {
        /* renamed from: ˋ */
        void mo7029(String str, int i);
    }

    public C1845hd(String str, AbstractC0114 r3) {
        super(0);
        this.f7222 = str;
        this.f7221 = r3;
    }

    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5783(ApiEndpointRegistry apiEndpointRegistry) {
        m9684("");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public String mo5784(String str) {
        return this.f7222;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op, com.android.volley.Request
    public C0524<String> parseNetworkResponse(C1181 r4) {
        if (!(r4 == null || r4.f15530 == null)) {
            this.f7221.mo7029(this.f7222, r4.f15530.length);
        }
        return C0524.m14563("OK", null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo5785(String str) {
        return "OK";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˊ */
    public String mo5781() {
        return null;
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5640(String str) {
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
    }
}
