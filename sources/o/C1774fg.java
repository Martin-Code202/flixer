package o;

import org.json.JSONException;
/* renamed from: o.fg  reason: case insensitive filesystem */
public class C1774fg extends AbstractC1775fh {
    public C1774fg(String str, long j) {
        super(str, j);
        try {
            this.f6134.put("mdxver", "2014.1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "mdxinit";
    }
}
