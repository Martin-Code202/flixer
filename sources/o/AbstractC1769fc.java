package o;

import com.netflix.mediaclient.servicemgr.Logblob;
import org.json.JSONException;
/* renamed from: o.fc  reason: case insensitive filesystem */
public abstract class AbstractC1769fc extends AbstractC1542bQ {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f6746 = AbstractC1769fc.class.getSimpleName();

    protected AbstractC1769fc(String str) {
        try {
            this.f6134.put("ctrlcat", "Android");
            this.f6134.put("groupname", str);
            String r3 = m6378();
            if (r3 != null) {
                this.f6134.put("xid", r3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6379(C1768fb fbVar) {
        try {
            fbVar.m6377(this.f6134);
            this.f6135 = Logblob.Severity.error;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˏ */
    public boolean mo1556() {
        if (Logblob.Severity.error.equals(this.f6135)) {
            return true;
        }
        return false;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m6378() {
        return null;
    }
}
