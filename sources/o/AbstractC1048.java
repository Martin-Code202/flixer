package o;

import com.android.volley.Request;
import java.io.UnsupportedEncodingException;
import o.C0524;
/* renamed from: o.ⁿ  reason: contains not printable characters */
public abstract class AbstractC1048<T> extends Request<T> {
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);
    private final C0524.If<T> mListener;
    private final String mRequestBody;

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public abstract C0524<T> parseNetworkResponse(C1181 v);

    public AbstractC1048(String str, String str2, C0524.If<T> r9, C0524.AbstractC2398iF iFVar) {
        this(-1, str, str2, r9, iFVar);
    }

    public AbstractC1048(int i, String str, String str2, C0524.If<T> r4, C0524.AbstractC2398iF iFVar) {
        super(i, str, iFVar);
        this.mListener = r4;
        this.mRequestBody = str2;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(T t) {
        this.mListener.onResponse(t);
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
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C0509.m14521("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, PROTOCOL_CHARSET);
            return null;
        }
    }
}
