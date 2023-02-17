package o;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
/* renamed from: o.ა  reason: contains not printable characters */
public class C0713 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<AbstractC0635> f14239 = new LinkedList();

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m15039(AbstractC0635 r2) {
        if (r2 != null) {
            this.f14239.add(r2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONArray m15038(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        jSONArray.put(jSONArray2);
        for (AbstractC0635 r7 : this.f14239) {
            if (r7 instanceof AbstractC0615) {
                ((AbstractC0615) r7).mo14655(jSONArray2);
            } else if (r7 instanceof C0485) {
                jSONArray2.put(((C0485) r7).m14419());
            } else {
                C0441.m14304().mo4535("Not supported operation implementation: %s", r7.getClass().getSimpleName());
            }
        }
        return jSONArray;
    }
}
