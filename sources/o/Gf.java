package o;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* access modifiers changed from: package-private */
public final class Gf implements FW<FE> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f5695;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final CharSequence f5696;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f5697;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1451Fl<CharSequence, Integer, Pair<Integer, Integer>> f5698;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: o.Fl<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public Gf(CharSequence charSequence, int i, int i2, AbstractC1451Fl<? super CharSequence, ? super Integer, Pair<Integer, Integer>> fl) {
        C1457Fr.m5025(charSequence, "input");
        C1457Fr.m5025(fl, "getNextMatch");
        this.f5696 = charSequence;
        this.f5697 = i;
        this.f5695 = i2;
        this.f5698 = fl;
    }

    /* renamed from: o.Gf$ˋ  reason: contains not printable characters */
    public static final class C0097 implements Iterator<FE>, AbstractC1463Fx {

        /* renamed from: ʽ  reason: contains not printable characters */
        private int f5699;

        /* renamed from: ˊ  reason: contains not printable characters */
        private FE f5700;

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f5701;

        /* renamed from: ˎ  reason: contains not printable characters */
        private int f5702;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ Gf f5703;

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f5704 = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0097(Gf gf) {
            this.f5703 = gf;
            this.f5701 = FF.m4989(gf.f5697, 0, gf.f5696.length());
            this.f5702 = this.f5701;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
            if (r7.f5699 < r7.f5703.f5695) goto L_0x0025;
         */
        /* renamed from: ˏ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void m5058() {
            /*
                r7 = this;
                int r0 = r7.f5702
                if (r0 >= 0) goto L_0x000d
                r0 = 0
                r7.f5704 = r0
                r0 = 0
                r0 = 0
                r7.f5700 = r0
                goto L_0x00ae
            L_0x000d:
                o.Gf r0 = r7.f5703
                int r0 = o.Gf.m5055(r0)
                if (r0 <= 0) goto L_0x0025
                int r0 = r7.f5699
                int r0 = r0 + 1
                r7.f5699 = r0
                int r0 = r7.f5699
                o.Gf r1 = r7.f5703
                int r1 = o.Gf.m5055(r1)
                if (r0 >= r1) goto L_0x0033
            L_0x0025:
                int r0 = r7.f5702
                o.Gf r1 = r7.f5703
                java.lang.CharSequence r1 = o.Gf.m5057(r1)
                int r1 = r1.length()
                if (r0 <= r1) goto L_0x004b
            L_0x0033:
                int r3 = r7.f5701
                o.FE r0 = new o.FE
                o.Gf r1 = r7.f5703
                java.lang.CharSequence r1 = o.Gf.m5057(r1)
                int r1 = o.Ge.m5095(r1)
                r0.<init>(r3, r1)
                r7.f5700 = r0
                r0 = -1
                r7.f5702 = r0
                goto L_0x00ab
            L_0x004b:
                o.Gf r0 = r7.f5703
                o.Fl r0 = o.Gf.m5056(r0)
                o.Gf r1 = r7.f5703
                java.lang.CharSequence r1 = o.Gf.m5057(r1)
                int r2 = r7.f5702
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                java.lang.Object r0 = r0.invoke(r1, r2)
                r3 = r0
                kotlin.Pair r3 = (kotlin.Pair) r3
                if (r3 != 0) goto L_0x007d
                int r4 = r7.f5701
                o.FE r0 = new o.FE
                o.Gf r1 = r7.f5703
                java.lang.CharSequence r1 = o.Gf.m5057(r1)
                int r1 = o.Ge.m5095(r1)
                r0.<init>(r4, r1)
                r7.f5700 = r0
                r0 = -1
                r7.f5702 = r0
                goto L_0x00ab
            L_0x007d:
                r6 = r3
                java.lang.Object r0 = r6.m3224()
                java.lang.Number r0 = (java.lang.Number) r0
                int r4 = r0.intValue()
                java.lang.Object r0 = r6.m3222()
                java.lang.Number r0 = (java.lang.Number) r0
                int r5 = r0.intValue()
                int r6 = r7.f5701
                o.FE r0 = new o.FE
                int r1 = r4 + -1
                r0.<init>(r6, r1)
                r7.f5700 = r0
                int r0 = r4 + r5
                r7.f5701 = r0
                int r0 = r7.f5701
                if (r5 != 0) goto L_0x00a7
                r1 = 1
                goto L_0x00a8
            L_0x00a7:
                r1 = 0
            L_0x00a8:
                int r0 = r0 + r1
                r7.f5702 = r0
            L_0x00ab:
                r0 = 1
                r7.f5704 = r0
            L_0x00ae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o.Gf.C0097.m5058():void");
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public FE next() {
            if (this.f5704 == -1) {
                m5058();
            }
            if (this.f5704 == 0) {
                throw new NoSuchElementException();
            }
            FE fe = this.f5700;
            if (fe == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.f5700 = null;
            this.f5704 = -1;
            return fe;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5704 == -1) {
                m5058();
            }
            return this.f5704 == 1;
        }
    }

    @Override // o.FW
    /* renamed from: ˊ */
    public Iterator<FE> mo4843() {
        return new C0097(this);
    }
}
