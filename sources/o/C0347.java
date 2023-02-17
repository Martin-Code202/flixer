package o;
/* access modifiers changed from: package-private */
/* renamed from: o.ł  reason: contains not printable characters */
public final class C0347<T, V> implements FI<T, V> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1451Fl<T, FQ<?>, V> f13062;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Object f13063 = iF.f13064;

    /* renamed from: o.ł$iF */
    static final class iF {

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final iF f13064 = new iF();

        private iF() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: o.Fl<? super T, ? super o.FQ<?>, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public C0347(AbstractC1451Fl<? super T, ? super FQ<?>, ? extends V> fl) {
        C1457Fr.m5025(fl, "initializer");
        this.f13062 = fl;
    }

    @Override // o.FI
    /* renamed from: ˊ */
    public V mo4986(T t, FQ<?> fq) {
        C1457Fr.m5025(fq, "property");
        if (C1457Fr.m5018(this.f13063, iF.f13064)) {
            this.f13063 = this.f13062.invoke(t, fq);
        }
        return (V) this.f13063;
    }
}
