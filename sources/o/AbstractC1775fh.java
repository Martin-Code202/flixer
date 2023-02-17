package o;

import org.json.JSONException;
/* renamed from: o.fh  reason: case insensitive filesystem */
public abstract class AbstractC1775fh extends AbstractC1769fc {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f6761 = AbstractC1775fh.class.getSimpleName();

    protected AbstractC1775fh(String str, long j) {
        super(str);
        try {
            this.f6134.put("delay", j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
