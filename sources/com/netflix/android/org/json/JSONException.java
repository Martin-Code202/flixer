package com.netflix.android.org.json;
public class JSONException extends RuntimeException {
    private static final long serialVersionUID = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Throwable f156;

    public JSONException(String str) {
        super(str);
    }

    public JSONException(Throwable th) {
        super(th.getMessage());
        this.f156 = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f156;
    }
}
