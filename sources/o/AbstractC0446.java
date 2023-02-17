package o;

import android.content.Context;
import o.C0738;
/* renamed from: o.ˤ  reason: contains not printable characters */
public abstract class AbstractC0446 {
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract C0738.C0739 mo14321(String str);

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract void mo14322(AbstractC0865 v);

    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract void mo14323(C0900 v, AbstractC0868 v2);

    /* renamed from: o.ˤ$if  reason: invalid class name */
    public static final class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Context f13484;

        /* renamed from: ˋ  reason: contains not printable characters */
        private AbstractC0888 f13485;

        private Cif(Context context) {
            this.f13484 = context;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public Cif m14325(AbstractC0888 r1) {
            this.f13485 = r1;
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public AbstractC0446 m14324() {
            if (this.f13484 == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            } else if (this.f13485 != null) {
                return new C0866(this.f13484, this.f13485);
            } else {
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Cif m14320(Context context) {
        return new Cif(context);
    }
}
