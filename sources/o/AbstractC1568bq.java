package o;
/* renamed from: o.bq  reason: case insensitive filesystem */
public abstract class AbstractC1568bq extends AbstractC1563bl {
    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract String mo5639();

    protected AbstractC1568bq() {
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return "application/json";
    }

    @Override // com.android.volley.Request
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override // com.android.volley.Request
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        try {
            return mo5639().getBytes("UTF-8");
        } catch (Exception e) {
            C1283.m16847(mo5641(), "Failed to create body of client logging request", e);
            return null;
        }
    }

    @Override // o.AbstractC1563bl
    /* renamed from: ॱॱ */
    public String mo5786() {
        return this.f6161.mo1455("/ichnaea/log");
    }
}
