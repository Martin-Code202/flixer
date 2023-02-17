package o;

import java.util.Iterator;
class FZ extends Ga {

    /* renamed from: o.FZ$if  reason: invalid class name */
    public static final class Cif implements Iterable<T>, AbstractC1463Fx {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ FW f5668;

        public Cif(FW fw) {
            this.f5668 = fw;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f5668.mo4843();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T, R> FW<R> m4996(FW<? extends T> fw, AbstractC1450Fk<? super T, ? extends R> fk) {
        C1457Fr.m5025(fw, "$receiver");
        C1457Fr.m5025(fk, "transform");
        return new Gb(fw, fk);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <T, A extends Appendable> A m4993(FW<? extends T> fw, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, AbstractC1450Fk<? super T, ? extends CharSequence> fk) {
        C1457Fr.m5025(fw, "$receiver");
        C1457Fr.m5025(a, "buffer");
        C1457Fr.m5025(charSequence, "separator");
        C1457Fr.m5025(charSequence2, "prefix");
        C1457Fr.m5025(charSequence3, "postfix");
        C1457Fr.m5025(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        Iterator<? extends T> r3 = fw.mo4843();
        while (r3.hasNext()) {
            Object next = r3.next();
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            Ge.m5061(a, next, fk);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ String m4997(FW fw, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, AbstractC1450Fk fk, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
            fk = null;
        }
        return FU.m4995(fw, charSequence, charSequence2, charSequence3, i, charSequence4, fk);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T> String m4995(FW<? extends T> fw, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, AbstractC1450Fk<? super T, ? extends CharSequence> fk) {
        C1457Fr.m5025(fw, "$receiver");
        C1457Fr.m5025(charSequence, "separator");
        C1457Fr.m5025(charSequence2, "prefix");
        C1457Fr.m5025(charSequence3, "postfix");
        C1457Fr.m5025(charSequence4, "truncated");
        String sb = ((StringBuilder) FU.m4993(fw, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, fk)).toString();
        C1457Fr.m5016((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T> Iterable<T> m4994(FW<? extends T> fw) {
        C1457Fr.m5025(fw, "$receiver");
        return new Cif(fw);
    }
}
