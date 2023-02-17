package o;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import o.C2256vz;
public abstract class vI {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static BehaviorSubject<vI> f11187 = BehaviorSubject.createDefault(f11188);

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final vI f11188 = m11939().mo11952(0).mo11951(0).mo11954(0).mo11949(0).mo11953(0).mo11950(false).mo11955();

    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract int mo11943();

    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract int mo11944();

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract int mo11945();

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract int mo11946();

    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract int mo11947();

    /* renamed from: ᐝ  reason: contains not printable characters */
    public abstract boolean mo11948();

    /* renamed from: ʽ  reason: contains not printable characters */
    public static Observable<vI> m11940() {
        return f11187;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m11941(vI vIVar) {
        f11187.onNext(vIVar);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m11942() {
        return ((mo11944() - mo11946()) - mo11943()) - mo11945() > 0;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static Cif m11939() {
        return new C2256vz.If();
    }

    /* renamed from: o.vI$if  reason: invalid class name */
    public static abstract class Cif {
        /* renamed from: ˊ  reason: contains not printable characters */
        public abstract Cif mo11949(int i);

        /* renamed from: ˊ  reason: contains not printable characters */
        public abstract Cif mo11950(boolean z);

        /* renamed from: ˋ  reason: contains not printable characters */
        public abstract Cif mo11951(int i);

        /* renamed from: ˎ  reason: contains not printable characters */
        public abstract Cif mo11952(int i);

        /* renamed from: ˏ  reason: contains not printable characters */
        public abstract Cif mo11953(int i);

        /* renamed from: ॱ  reason: contains not printable characters */
        public abstract Cif mo11954(int i);

        /* renamed from: ॱ  reason: contains not printable characters */
        public abstract vI mo11955();

        Cif() {
        }
    }
}
