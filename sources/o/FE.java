package o;
public final class FE extends FG {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0095 f5658 = new C0095(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final FE f5659 = new FE(1, 0);

    public FE(int i, int i2) {
        super(i, i2, 1);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public Integer m4979() {
        return Integer.valueOf(m4983());
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Integer m4977() {
        return Integer.valueOf(m4981());
    }

    @Override // o.FG
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo4978() {
        return m4983() > m4981();
    }

    @Override // o.FG, java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof FE) && ((mo4978() && ((FE) obj).mo4978()) || (m4983() == ((FE) obj).m4983() && m4981() == ((FE) obj).m4981()));
    }

    @Override // o.FG, java.lang.Object
    public int hashCode() {
        if (mo4978()) {
            return -1;
        }
        return (m4983() * 31) + m4981();
    }

    @Override // o.FG, java.lang.Object
    public String toString() {
        return "" + m4983() + ".." + m4981();
    }

    /* renamed from: o.FE$ˋ  reason: contains not printable characters */
    public static final class C0095 {
        private C0095() {
        }

        public /* synthetic */ C0095(C1456Fq fq) {
            this();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final FE m4980() {
            return FE.f5659;
        }
    }
}
