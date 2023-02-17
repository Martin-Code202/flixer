package o;

import java.util.Collections;
import java.util.List;
import o.AbstractC0923;
import o.C1297AUx;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ᴸ  reason: contains not printable characters */
public class C0987<T> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0433 f15045;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final JSONObject f15046;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC0923.Cif<T> f15047;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final float f15048;

    private C0987(JSONObject jSONObject, float f, C0433 r3, AbstractC0923.Cif<T> ifVar) {
        this.f15046 = jSONObject;
        this.f15048 = f;
        this.f15045 = r3;
        this.f15047 = ifVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static <T> C0987<T> m15927(JSONObject jSONObject, float f, C0433 r3, AbstractC0923.Cif<T> ifVar) {
        return new C0987<>(jSONObject, f, r3, ifVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public C0988<T> m15931() {
        List<C1297AUx<T>> r1 = m15930();
        return new C0988<>(r1, m15929(r1));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private List<C1297AUx<T>> m15930() {
        if (this.f15046 == null) {
            return Collections.emptyList();
        }
        Object opt = this.f15046.opt("k");
        if (m15928(opt)) {
            return C1297AUx.iF.m3447((JSONArray) opt, this.f15045, this.f15048, this.f15047);
        }
        return Collections.emptyList();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private T m15929(List<C1297AUx<T>> list) {
        if (this.f15046 == null) {
            return null;
        }
        if (!list.isEmpty()) {
            return list.get(0).f4310;
        }
        return this.f15047.mo14319(this.f15046.opt("k"), this.f15048);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m15928(Object obj) {
        if (!(obj instanceof JSONArray)) {
            return false;
        }
        Object opt = ((JSONArray) obj).opt(0);
        return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᴸ$ˊ  reason: contains not printable characters */
    public static class C0988<T> {

        /* renamed from: ˎ  reason: contains not printable characters */
        final T f15049;

        /* renamed from: ॱ  reason: contains not printable characters */
        final List<C1297AUx<T>> f15050;

        C0988(List<C1297AUx<T>> list, T t) {
            this.f15050 = list;
            this.f15049 = t;
        }
    }
}
