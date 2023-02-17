package o;

import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.Iterator;
public final class Gb<T, R> implements FW<R> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final FW<T> f5684;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1450Fk<T, R> f5685;

    /* renamed from: o.Gb$if  reason: invalid class name */
    public static final class Cif implements Iterator<R>, AbstractC1463Fx {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final Iterator<T> f5686;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ Gb f5687;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        Cif(Gb gb) {
            this.f5687 = gb;
            this.f5686 = gb.f5684.mo4843();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f5687.f5685.invoke(this.f5686.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5686.hasNext();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: o.FW<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: o.Fk<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public Gb(FW<? extends T> fw, AbstractC1450Fk<? super T, ? extends R> fk) {
        C1457Fr.m5025(fw, Event.SEQUENCE);
        C1457Fr.m5025(fk, "transformer");
        this.f5684 = fw;
        this.f5685 = fk;
    }

    @Override // o.FW
    /* renamed from: ˊ */
    public Iterator<R> mo4843() {
        return new Cif(this);
    }
}
