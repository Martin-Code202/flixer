package o;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.AbstractC0923;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ˣ  reason: contains not printable characters */
public class C0445 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private PointF f13480;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f13481;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<C1169> f13482;

    private C0445(PointF pointF, boolean z, List<C1169> list) {
        this.f13482 = new ArrayList();
        this.f13480 = pointF;
        this.f13481 = z;
        this.f13482.addAll(list);
    }

    public C0445() {
        this.f13482 = new ArrayList();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14312(float f, float f2) {
        if (this.f13480 == null) {
            this.f13480 = new PointF();
        }
        this.f13480.set(f, f2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public PointF m14314() {
        return this.f13480;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m14313() {
        return this.f13481;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public List<C1169> m14316() {
        return this.f13482;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14315(C0445 r17, C0445 r18, float f) {
        if (this.f13480 == null) {
            this.f13480 = new PointF();
        }
        this.f13481 = r17.m14313() || r18.m14313();
        if (this.f13482.isEmpty() || this.f13482.size() == r17.m14316().size() || this.f13482.size() == r18.m14316().size()) {
            if (this.f13482.isEmpty()) {
                for (int size = r17.m14316().size() - 1; size >= 0; size--) {
                    this.f13482.add(new C1169());
                }
            }
            PointF r5 = r17.m14314();
            PointF r6 = r18.m14314();
            m14312(C1150.m16323(r5.x, r6.x, f), C1150.m16323(r5.y, r6.y, f));
            for (int size2 = this.f13482.size() - 1; size2 >= 0; size2--) {
                C1169 r8 = r17.m14316().get(size2);
                C1169 r9 = r18.m14316().get(size2);
                PointF r10 = r8.m16361();
                PointF r11 = r8.m16365();
                PointF r12 = r8.m16362();
                PointF r13 = r9.m16361();
                PointF r14 = r9.m16365();
                PointF r15 = r9.m16362();
                this.f13482.get(size2).m16366(C1150.m16323(r10.x, r13.x, f), C1150.m16323(r10.y, r13.y, f));
                this.f13482.get(size2).m16363(C1150.m16323(r11.x, r14.x, f), C1150.m16323(r11.y, r14.y, f));
                this.f13482.get(size2).m16364(C1150.m16323(r12.x, r15.x, f), C1150.m16323(r12.y, r15.y, f));
            }
            return;
        }
        throw new IllegalStateException("Curves must have the same number of control points. This: " + m14316().size() + "\tShape 1: " + r17.m14316().size() + "\tShape 2: " + r18.m14316().size());
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f13482.size() + "closed=" + this.f13481 + '}';
    }

    /* renamed from: o.ˣ$if  reason: invalid class name */
    public static class Cif implements AbstractC0923.Cif<C0445> {

        /* renamed from: ॱ  reason: contains not printable characters */
        public static final Cif f13483 = new Cif();

        private Cif() {
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0445 mo14319(Object obj, float f) {
            JSONObject jSONObject = null;
            if (obj instanceof JSONArray) {
                Object opt = ((JSONArray) obj).opt(0);
                if ((opt instanceof JSONObject) && ((JSONObject) opt).has("v")) {
                    jSONObject = (JSONObject) opt;
                }
            } else if ((obj instanceof JSONObject) && ((JSONObject) obj).has("v")) {
                jSONObject = (JSONObject) obj;
            }
            if (jSONObject == null) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("v");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("i");
            JSONArray optJSONArray3 = jSONObject.optJSONArray("o");
            boolean optBoolean = jSONObject.optBoolean("c", false);
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray3 == null || optJSONArray.length() != optJSONArray2.length() || optJSONArray.length() != optJSONArray3.length()) {
                throw new IllegalStateException("Unable to process points array or tangents. " + jSONObject);
            } else if (optJSONArray.length() == 0) {
                return new C0445(new PointF(), false, Collections.emptyList());
            } else {
                int length = optJSONArray.length();
                PointF r11 = m14317(0, optJSONArray);
                r11.x *= f;
                r11.y *= f;
                ArrayList arrayList = new ArrayList(length);
                for (int i = 1; i < length; i++) {
                    PointF r112 = m14317(i, optJSONArray);
                    PointF r15 = m14317(i - 1, optJSONArray);
                    PointF r16 = m14317(i - 1, optJSONArray3);
                    PointF r17 = m14317(i, optJSONArray2);
                    PointF r18 = C1150.m16326(r15, r16);
                    PointF r19 = C1150.m16326(r112, r17);
                    r18.x *= f;
                    r18.y *= f;
                    r19.x *= f;
                    r19.y *= f;
                    r112.x *= f;
                    r112.y *= f;
                    arrayList.add(new C1169(r18, r19, r112));
                }
                if (optBoolean) {
                    PointF r113 = m14317(0, optJSONArray);
                    PointF r14 = m14317(length - 1, optJSONArray);
                    PointF r152 = m14317(length - 1, optJSONArray3);
                    PointF r162 = m14317(0, optJSONArray2);
                    PointF r172 = C1150.m16326(r14, r152);
                    PointF r182 = C1150.m16326(r113, r162);
                    if (f != 1.0f) {
                        r172.x *= f;
                        r172.y *= f;
                        r182.x *= f;
                        r182.y *= f;
                        r113.x *= f;
                        r113.y *= f;
                    }
                    arrayList.add(new C1169(r172, r182, r113));
                }
                return new C0445(r11, optBoolean, arrayList);
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private static PointF m14317(int i, JSONArray jSONArray) {
            if (i >= jSONArray.length()) {
                throw new IllegalArgumentException("Invalid index " + i + ". There are only " + jSONArray.length() + " points.");
            }
            JSONArray optJSONArray = jSONArray.optJSONArray(i);
            Object opt = optJSONArray.opt(0);
            Object opt2 = optJSONArray.opt(1);
            return new PointF(opt instanceof Double ? ((Double) opt).floatValue() : (float) ((Integer) opt).intValue(), opt2 instanceof Double ? ((Double) opt2).floatValue() : (float) ((Integer) opt2).intValue());
        }
    }
}
