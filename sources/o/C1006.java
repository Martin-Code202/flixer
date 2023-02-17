package o;

import android.widget.SeekBar;
/* access modifiers changed from: package-private */
/* renamed from: o.ᵉ  reason: contains not printable characters */
public final class C1006 extends AbstractC1153 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final SeekBar f15090;

    C1006(SeekBar seekBar) {
        if (seekBar == null) {
            throw new NullPointerException("Null view");
        }
        this.f15090 = seekBar;
    }

    @Override // o.AbstractC1119
    /* renamed from: ˊ */
    public SeekBar mo15942() {
        return this.f15090;
    }

    public String toString() {
        return "SeekBarStopChangeEvent{view=" + this.f15090 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1153) {
            return this.f15090.equals(((AbstractC1153) obj).mo15942());
        }
        return false;
    }

    public int hashCode() {
        return 1000003 ^ this.f15090.hashCode();
    }
}
