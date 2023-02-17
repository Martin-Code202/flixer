package o;

import android.graphics.Color;
import o.AbstractC0923;
import org.json.JSONArray;
/* renamed from: o.ᵎ  reason: contains not printable characters */
public class C1012 implements AbstractC0923.Cif<Integer> {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C1012 f15096 = new C1012();

    /* renamed from: ॱ  reason: contains not printable characters */
    public Integer mo14319(Object obj, float f) {
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.length() != 4) {
            return -16777216;
        }
        boolean z = true;
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.optDouble(i) > 1.0d) {
                z = false;
            }
        }
        float f2 = z ? 255.0f : 1.0f;
        return Integer.valueOf(Color.argb((int) (jSONArray.optDouble(3) * ((double) f2)), (int) (jSONArray.optDouble(0) * ((double) f2)), (int) (jSONArray.optDouble(1) * ((double) f2)), (int) (jSONArray.optDouble(2) * ((double) f2))));
    }
}
