package o;
/* renamed from: o.ɼ */
public abstract class AbstractC0385<T> {

    /* renamed from: ʼ */
    private static final boolean f13338 = false;

    /* renamed from: ˏ */
    private static final String f13339 = f13339;

    /* renamed from: ॱ */
    public static final iF f13340 = new iF(null);

    /* renamed from: ˊ */
    private final AbstractC0500<T> f13341;

    /* renamed from: ˋ */
    private AbstractC0409<T> f13342;

    /* renamed from: ˎ */
    private int f13343;

    public AbstractC0385(AbstractC0500<T> r2, AbstractC0409<T> r3) {
        C1457Fr.m5025(r2, "uiView");
        C1457Fr.m5025(r3, "currentUIModel");
        this.f13341 = r2;
        this.f13342 = r3;
    }

    /* renamed from: ˎ */
    public final AbstractC0409<T> m14155() {
        return this.f13342;
    }

    /* renamed from: o.ɼ$iF */
    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ */
        public final String m14158() {
            return AbstractC0385.f13339;
        }

        /* renamed from: ˏ */
        public final boolean m14157() {
            return AbstractC0385.f13338;
        }
    }

    /* renamed from: ˋ */
    public final void m14154(AbstractC0409<T> r6, Object obj) {
        C1457Fr.m5025(r6, "newUIModel");
        C1457Fr.m5025(obj, "event");
        this.f13342 = r6;
        this.f13341.mo2641(this.f13342);
        if (f13340.m14157()) {
            String r0 = f13340.m14158();
            this.f13343++;
            C1283.m16851(r0, "FORCED Re-rendering, counter is %d", Integer.valueOf(this.f13343));
        }
    }

    /* renamed from: ॱ */
    public static /* synthetic */ void m14153(AbstractC0385 r2, AbstractC0409 r3, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderUIView");
        }
        if ((i & 2) != 0) {
            obj = C1464Fy.f5682;
        }
        r2.m14156(r3, obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: o.ʱ<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˏ */
    public final void m14156(AbstractC0409<T> r6, Object obj) {
        C1457Fr.m5025(r6, "newUIModel");
        C1457Fr.m5025(obj, "event");
        if (r6.compareTo(this.f13342) < 0) {
            this.f13342 = r6;
            this.f13341.mo2641(this.f13342);
            if (f13340.m14157()) {
                String r0 = f13340.m14158();
                this.f13343++;
                C1283.m16851(r0, "Re-rendering, counter is %d", Integer.valueOf(this.f13343));
            }
        } else if (f13340.m14157()) {
            C1283.m16854(f13340.m14158(), "Skipping render, state did not change");
        }
        if (f13340.m14157()) {
            C1283.m16851(f13340.m14158(), "Event is %s New State is %s", obj.toString(), r6.toString());
        }
    }
}
