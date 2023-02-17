package o;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.mediaclient.servicemgr.Logblob;
import java.util.Map;
import org.json.JSONException;
/* access modifiers changed from: package-private */
public class lF extends AbstractC1542bQ {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f8504;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean f8505;

    public lF(String str, Logblob.Severity severity, boolean z, Object obj) {
        this.f8504 = str;
        this.f6135 = severity;
        this.f8505 = z;
        m8558(obj);
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return this.f8504;
    }

    @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˏ */
    public boolean mo1556() {
        return this.f8505;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8558(Object obj) {
        JsonElement jsonTree = AE.m3322().toJsonTree(obj);
        if (!(jsonTree instanceof JsonObject)) {
            C1283.m16850("nf_playreport", "unable to construct logblob - unable to create json tree");
            return;
        }
        for (Map.Entry<String, JsonElement> entry : ((JsonObject) jsonTree).entrySet()) {
            try {
                this.f6134.put(entry.getKey(), AK.m3392(entry.getValue()));
            } catch (JSONException e) {
                C1283.m16856("nf_playreport", e, "unable to construct logblob", new Object[0]);
            }
        }
        C1283.m16854("nf_playreport", mo5756());
    }
}
