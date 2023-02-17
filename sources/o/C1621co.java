package o;

import com.netflix.mediaclient.service.logging.pdslogging.offline.PdsOfflinePlaySession;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.co  reason: case insensitive filesystem */
public class C1621co {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f6310 = PdsOfflinePlaySession.f1174;

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f6311 = 120000;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f6312;

    /* renamed from: ˋ  reason: contains not printable characters */
    private LinkedHashSet<JSONObject> f6313 = new LinkedHashSet<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC0106 f6314;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f6315;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f6316;

    /* renamed from: o.co$ˊ  reason: contains not printable characters */
    public interface AbstractC0106 {
        /* renamed from: ˎ */
        void mo613(JSONObject jSONObject);
    }

    public C1621co(AbstractC0106 r5) {
        this.f6314 = r5;
        this.f6312 = BA.m3835() + this.f6311;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5896() {
        this.f6316 = true;
        this.f6315 = true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5898(boolean z) {
        synchronized (this.f6313) {
            m5893(z);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5893(boolean z) {
        if (this.f6316 && !z) {
            this.f6316 = false;
        }
        m5892();
        this.f6315 = false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m5899() {
        return this.f6315;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m5897() {
        return this.f6315 || (!this.f6315 && !this.f6316);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5895(JSONObject jSONObject) {
        C1283.m16854(f6310, "holding pds event");
        synchronized (this.f6313) {
            this.f6313.add(jSONObject);
            if (BA.m3835() > this.f6312) {
                m5893(false);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5892() {
        Iterator<JSONObject> it = this.f6313.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (this.f6316) {
                next = m5894(next);
            }
            if (next != null) {
                this.f6314.mo613(next);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject m5894(JSONObject jSONObject) {
        if (jSONObject == null) {
            return jSONObject;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        try {
            optJSONObject.putOpt("persistentlicense", false);
            jSONObject.putOpt("params", optJSONObject);
        } catch (JSONException e) {
            C1283.m16847(f6310, "error reworkingPdsEvent", e);
        }
        return jSONObject;
    }
}
