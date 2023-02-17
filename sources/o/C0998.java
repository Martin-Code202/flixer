package o;

import android.widget.SeekBar;
/* access modifiers changed from: package-private */
/* renamed from: o.ᵁ  reason: contains not printable characters */
public final class C0998 extends AbstractC1092 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final SeekBar f15067;

    C0998(SeekBar seekBar) {
        if (seekBar == null) {
            throw new NullPointerException("Null view");
        }
        this.f15067 = seekBar;
    }

    @Override // o.AbstractC1119
    /* renamed from: ˊ  reason: contains not printable characters */
    public SeekBar mo15942() {
        return this.f15067;
    }

    public String toString() {
        return "SeekBarStartChangeEvent{view=" + this.f15067 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1092) {
            return this.f15067.equals(((AbstractC1092) obj).mo15942());
        }
        return false;
    }

    public int hashCode() {
        return 1000003 ^ this.f15067.hashCode();
    }
}
