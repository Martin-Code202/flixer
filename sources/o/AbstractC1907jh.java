package o;

import android.content.Context;
import com.netflix.falkor.FalkorException;
import org.json.JSONObject;
/* renamed from: o.jh  reason: case insensitive filesystem */
public abstract class AbstractC1907jh extends AbstractC1810gP<JSONObject> {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static final String f8015 = iT.f7647;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected Context f8016;

    public AbstractC1907jh(Context context) {
        this.f8016 = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject mo6580(CR cr) {
        String r2 = cr.m4302();
        if (!m6567(r2)) {
            return (JSONObject) mo986(r2);
        }
        C1283.m16850(f8015, "User is not authorized, trying recovery...");
        throw new FalkorException(r2);
    }
}
