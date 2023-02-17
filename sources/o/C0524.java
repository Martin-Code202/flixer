package o;

import com.android.volley.VolleyError;
import o.AbstractC1001;
/* renamed from: o.Ӏ  reason: contains not printable characters */
public class C0524<T> {

    /* renamed from: ˋ  reason: contains not printable characters */
    public final T f13674;

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean f13675;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final VolleyError f13676;

    /* renamed from: ॱ  reason: contains not printable characters */
    public final AbstractC1001.Cif f13677;

    /* renamed from: o.Ӏ$If */
    public interface If<T> {
        void onResponse(T t);
    }

    /* renamed from: o.Ӏ$iF  reason: case insensitive filesystem */
    public interface AbstractC2398iF {
        void onErrorResponse(VolleyError volleyError);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static <T> C0524<T> m14563(T t, AbstractC1001.Cif ifVar) {
        return new C0524<>(t, ifVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static <T> C0524<T> m14562(VolleyError volleyError) {
        return new C0524<>(volleyError);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m14564() {
        return this.f13676 == null;
    }

    private C0524(T t, AbstractC1001.Cif ifVar) {
        this.f13675 = false;
        this.f13674 = t;
        this.f13677 = ifVar;
        this.f13676 = null;
    }

    private C0524(VolleyError volleyError) {
        this.f13675 = false;
        this.f13674 = null;
        this.f13677 = null;
        this.f13676 = volleyError;
    }
}
