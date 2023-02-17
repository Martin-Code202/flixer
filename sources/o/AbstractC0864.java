package o;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ᔈ  reason: contains not printable characters */
public abstract class AbstractC0864<V, O> implements AbstractC0923<V, O> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final V f14716;

    /* renamed from: ˎ  reason: contains not printable characters */
    final List<C1297AUx<V>> f14717;

    AbstractC0864(V v) {
        this(Collections.emptyList(), v);
    }

    AbstractC0864(List<C1297AUx<V>> list, V v) {
        this.f14717 = list;
        this.f14716 = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public O mo15382(V v) {
        return v;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m15557() {
        return !this.f14717.isEmpty();
    }

    /* renamed from: ˊ */
    public O mo15162() {
        return mo15382(this.f14716);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append((Object) this.f14716);
        if (!this.f14717.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.f14717.toArray()));
        }
        return sb.toString();
    }
}
