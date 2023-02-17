package o;

import com.android.volley.ParseError;
import java.io.UnsupportedEncodingException;
import o.C0524;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ᓫ  reason: contains not printable characters */
public class C0834 extends AbstractC1048<JSONObject> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0834(int i, String str, JSONObject jSONObject, C0524.If<JSONObject> r10, C0524.AbstractC2398iF iFVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), r10, iFVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0834(String str, JSONObject jSONObject, C0524.If<JSONObject> r9, C0524.AbstractC2398iF iFVar) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, r9, iFVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1048, com.android.volley.Request
    public C0524<JSONObject> parseNetworkResponse(C1181 r4) {
        try {
            return C0524.m14563(new JSONObject(new String(r4.f15530, C0833.m15448(r4.f15528))), C0833.m15449(r4));
        } catch (UnsupportedEncodingException e) {
            return C0524.m14562(new ParseError(e));
        } catch (JSONException e2) {
            return C0524.m14562(new ParseError(e2));
        }
    }
}
