package o;

import com.android.volley.Request;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
/* renamed from: o.bl  reason: case insensitive filesystem */
public abstract class AbstractC1563bl extends AbstractC2040op<String> {

    /* renamed from: ॱ  reason: contains not printable characters */
    protected ApiEndpointRegistry f6161;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public abstract String mo5786();

    /* renamed from: ᐝ */
    public abstract String mo5641();

    protected AbstractC1563bl() {
        super(1);
    }

    @Override // o.AbstractC2040op
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5783(ApiEndpointRegistry apiEndpointRegistry) {
        this.f6161 = apiEndpointRegistry;
        m9684(mo5786());
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo5784(String str) {
        String r4 = m5780(str);
        C1283.m16851(mo5641(), "URL = %s", r4);
        return r4;
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo5781() {
        return "post";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m5780(String str) {
        String str2 = null;
        Object tag = getTag();
        if (tag instanceof String) {
            str2 = (String) tag;
        } else if (tag != null) {
            str2 = tag.toString();
        }
        if (!C1349Bv.m4107(str2)) {
            return str;
        }
        if (str.contains("?")) {
            return str + "&TAG=" + str2;
        }
        return str + "?TAG=" + str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo5785(String str) {
        C1283.m16851(mo5641(), "String response to parse = %s", str);
        return "OK";
    }
}
