package o;

import android.widget.SeekBar;
/* access modifiers changed from: package-private */
/* renamed from: o.ᵃ  reason: contains not printable characters */
public final class C1000 extends AbstractC1123 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean f15072;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final SeekBar f15073;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f15074;

    C1000(SeekBar seekBar, int i, boolean z) {
        if (seekBar == null) {
            throw new NullPointerException("Null view");
        }
        this.f15073 = seekBar;
        this.f15074 = i;
        this.f15072 = z;
    }

    @Override // o.AbstractC1119
    /* renamed from: ˊ */
    public SeekBar mo15942() {
        return this.f15073;
    }

    @Override // o.AbstractC1123
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo15945() {
        return this.f15074;
    }

    @Override // o.AbstractC1123
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo15944() {
        return this.f15072;
    }

    public String toString() {
        return "SeekBarProgressChangeEvent{view=" + this.f15073 + ", progress=" + this.f15074 + ", fromUser=" + this.f15072 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1123)) {
            return false;
        }
        AbstractC1123 r2 = (AbstractC1123) obj;
        return this.f15073.equals(r2.mo15942()) && this.f15074 == r2.mo15945() && this.f15072 == r2.mo15944();
    }

    public int hashCode() {
        return ((((1000003 ^ this.f15073.hashCode()) * 1000003) ^ this.f15074) * 1000003) ^ (this.f15072 ? 1231 : 1237);
    }
}
