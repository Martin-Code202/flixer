package o;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
/* renamed from: o.ד  reason: contains not printable characters */
public final class C0549 {

    /* renamed from: o.ד$if  reason: invalid class name */
    public static final class Cif implements Iterable<View>, AbstractC1463Fx {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ ViewGroup f13767;

        /* renamed from: o.ד$if$If */
        public static final class If implements Iterator<View>, AbstractC1463Fx {

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ Cif f13768;

            /* renamed from: ˋ  reason: contains not printable characters */
            private int f13769;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            If(Cif ifVar) {
                this.f13768 = ifVar;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f13769 < this.f13768.f13767.getChildCount();
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public View next() {
                ViewGroup viewGroup = this.f13768.f13767;
                int i = this.f13769;
                this.f13769 = i + 1;
                return viewGroup.getChildAt(i);
            }
        }

        Cif(ViewGroup viewGroup) {
            this.f13767 = viewGroup;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public If iterator() {
            return new If(this);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Iterable<View> m14593(ViewGroup viewGroup) {
        C1457Fr.m5025(viewGroup, "$receiver");
        return new Cif(viewGroup);
    }
}
