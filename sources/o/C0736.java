package o;

import o.AbstractC0923;
import org.json.JSONArray;
/* renamed from: o.ᐠ  reason: contains not printable characters */
public class C0736 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final float f14305;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final float f14306;

    public C0736(float f, float f2) {
        this.f14305 = f;
        this.f14306 = f2;
    }

    public C0736() {
        this(1.0f, 1.0f);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public float m15109() {
        return this.f14305;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public float m15108() {
        return this.f14306;
    }

    public String toString() {
        return m15109() + "x" + m15108();
    }

    /* renamed from: o.ᐠ$If */
    public static class If implements AbstractC0923.Cif<C0736> {

        /* renamed from: ˎ  reason: contains not printable characters */
        public static final If f14307 = new If();

        private If() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C0736 mo14319(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            return new C0736((((float) jSONArray.optDouble(0, 1.0d)) / 100.0f) * f, (((float) jSONArray.optDouble(1, 1.0d)) / 100.0f) * f);
        }
    }
}
