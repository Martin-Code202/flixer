package o;

import org.json.JSONException;
/* renamed from: o.bP  reason: case insensitive filesystem */
public class C1541bP extends AbstractC1542bQ {
    public C1541bP(String str) {
        try {
            this.f6134.put("d", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˏ */
    public boolean mo1556() {
        return true;
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "multihistogram";
    }
}
