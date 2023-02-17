package o;
class Gi extends Gm {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T> void m5061(Appendable appendable, T t, AbstractC1450Fk<? super T, ? extends CharSequence> fk) {
        C1457Fr.m5025(appendable, "$receiver");
        if (fk != null) {
            appendable.append((CharSequence) fk.invoke(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append(t);
        } else if (t instanceof Character) {
            appendable.append(t.charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
