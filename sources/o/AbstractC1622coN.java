package o;

import java.util.ArrayList;
import java.util.List;
/* renamed from: o.coN  reason: case insensitive filesystem */
public abstract class AbstractC1622coN<K, A> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f6317 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    final List<AbstractC0107> f6318 = new ArrayList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<? extends C1297AUx<K>> f6319;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1297AUx<K> f6320;

    /* renamed from: ॱ  reason: contains not printable characters */
    private float f6321 = 0.0f;

    /* renamed from: o.coN$ˊ  reason: contains not printable characters */
    public interface AbstractC0107 {
        /* renamed from: ˎ */
        void mo3789();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public abstract A mo4283(C1297AUx<K> aUx, float f);

    AbstractC1622coN(List<? extends C1297AUx<K>> list) {
        this.f6319 = list;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5906() {
        this.f6317 = true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5905(AbstractC0107 r2) {
        this.f6318.add(r2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5907(float f) {
        if (f < m5903()) {
            f = 0.0f;
        } else if (f > m5900()) {
            f = 1.0f;
        }
        if (f != this.f6321) {
            this.f6321 = f;
            for (int i = 0; i < this.f6318.size(); i++) {
                this.f6318.get(i).mo3789();
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1297AUx<K> m5902() {
        if (this.f6319.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        } else if (this.f6320 != null && this.f6320.m3443(this.f6321)) {
            return this.f6320;
        } else {
            int i = 0;
            C1297AUx<K> aUx = (C1297AUx) this.f6319.get(0);
            if (this.f6321 < aUx.m3444()) {
                this.f6320 = aUx;
                return aUx;
            }
            while (!aUx.m3443(this.f6321) && i < this.f6319.size()) {
                aUx = (C1297AUx) this.f6319.get(i);
                i++;
            }
            this.f6320 = aUx;
            return aUx;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private float m5901() {
        if (this.f6317) {
            return 0.0f;
        }
        C1297AUx<K> r2 = m5902();
        if (r2.m3442()) {
            return 0.0f;
        }
        return r2.f4313.getInterpolation((this.f6321 - r2.m3444()) / (r2.m3441() - r2.m3444()));
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private float m5903() {
        if (this.f6319.isEmpty()) {
            return 0.0f;
        }
        return ((C1297AUx) this.f6319.get(0)).m3444();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private float m5900() {
        if (this.f6319.isEmpty()) {
            return 1.0f;
        }
        return ((C1297AUx) this.f6319.get(this.f6319.size() - 1)).m3441();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public A mo5904() {
        return mo4283(m5902(), m5901());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public float m5908() {
        return this.f6321;
    }
}
