package o;
public class FG implements Iterable<Integer>, AbstractC1463Fx {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final Cif f5660 = new Cif(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f5661;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f5662;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f5663;

    public FG(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.f5662 = i;
        this.f5661 = C1446Fg.m5002(i, i2, i3);
        this.f5663 = i3;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final int m4983() {
        return this.f5662;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final int m4981() {
        return this.f5661;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final int m4984() {
        return this.f5663;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public EU iterator() {
        return new FH(this.f5662, this.f5661, this.f5663);
    }

    /* renamed from: ˎ */
    public boolean mo4978() {
        return this.f5663 > 0 ? this.f5662 > this.f5661 : this.f5662 < this.f5661;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof FG) && ((mo4978() && ((FG) obj).mo4978()) || (this.f5662 == ((FG) obj).f5662 && this.f5661 == ((FG) obj).f5661 && this.f5663 == ((FG) obj).f5663));
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (mo4978()) {
            return -1;
        }
        return (((this.f5662 * 31) + this.f5661) * 31) + this.f5663;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.f5663 > 0 ? "" + this.f5662 + ".." + this.f5661 + " step " + this.f5663 : "" + this.f5662 + " downTo " + this.f5661 + " step " + (-this.f5663);
    }

    /* renamed from: o.FG$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final FG m4985(int i, int i2, int i3) {
            return new FG(i, i2, i3);
        }
    }
}
