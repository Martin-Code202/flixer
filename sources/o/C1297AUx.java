package o;

import android.graphics.PointF;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.AbstractC0923;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.AUx  reason: case insensitive filesystem */
public class C1297AUx<T> {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final Interpolator f4305 = new LinearInterpolator();

    /* renamed from: ʻ  reason: contains not printable characters */
    private float f4306 = Float.MIN_VALUE;

    /* renamed from: ʼ  reason: contains not printable characters */
    private float f4307 = Float.MIN_VALUE;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0433 f4308;

    /* renamed from: ˊ  reason: contains not printable characters */
    public final T f4309;

    /* renamed from: ˋ  reason: contains not printable characters */
    public final T f4310;

    /* renamed from: ˎ  reason: contains not printable characters */
    public Float f4311;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final float f4312;

    /* renamed from: ॱ  reason: contains not printable characters */
    public final Interpolator f4313;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3439(List<? extends C1297AUx<?>> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            ((C1297AUx) list.get(i)).f4311 = Float.valueOf(((C1297AUx) list.get(i + 1)).f4312);
        }
        C1297AUx aUx = (C1297AUx) list.get(size - 1);
        if (aUx.f4310 == null) {
            list.remove(aUx);
        }
    }

    public C1297AUx(C0433 r2, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.f4308 = r2;
        this.f4310 = t;
        this.f4309 = t2;
        this.f4313 = interpolator;
        this.f4312 = f;
        this.f4311 = f2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public float m3444() {
        if (this.f4307 == Float.MIN_VALUE) {
            this.f4307 = (this.f4312 - ((float) this.f4308.m14269())) / this.f4308.m14257();
        }
        return this.f4307;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public float m3441() {
        if (this.f4306 == Float.MIN_VALUE) {
            if (this.f4311 == null) {
                this.f4306 = 1.0f;
            } else {
                this.f4306 = m3444() + ((this.f4311.floatValue() - this.f4312) / this.f4308.m14257());
            }
        }
        return this.f4306;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m3442() {
        return this.f4313 == null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m3443(float f) {
        return f >= m3444() && f <= m3441();
    }

    public String toString() {
        return "Keyframe{startValue=" + ((Object) this.f4310) + ", endValue=" + ((Object) this.f4309) + ", startFrame=" + this.f4312 + ", endFrame=" + this.f4311 + ", interpolator=" + this.f4313 + '}';
    }

    /* renamed from: o.AUx$iF */
    public static class iF {

        /* renamed from: ˏ  reason: contains not printable characters */
        private static SparseArrayCompat<WeakReference<Interpolator>> f4314;

        /* renamed from: ˊ  reason: contains not printable characters */
        private static SparseArrayCompat<WeakReference<Interpolator>> m3445() {
            if (f4314 == null) {
                f4314 = new SparseArrayCompat<>();
            }
            return f4314;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static WeakReference<Interpolator> m3448(int i) {
            WeakReference<Interpolator> weakReference;
            synchronized (iF.class) {
                weakReference = m3445().get(i);
            }
            return weakReference;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static void m3449(int i, WeakReference<Interpolator> weakReference) {
            synchronized (iF.class) {
                f4314.put(i, weakReference);
            }
        }

        private iF() {
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static <T> C1297AUx<T> m3446(JSONObject jSONObject, C0433 r22, float f, AbstractC0923.Cif<T> ifVar) {
            PointF pointF = null;
            PointF pointF2 = null;
            float f2 = 0.0f;
            T t = null;
            T t2 = null;
            Interpolator interpolator = null;
            if (jSONObject.has("t")) {
                f2 = (float) jSONObject.optDouble("t", 0.0d);
                Object opt = jSONObject.opt("s");
                if (opt != null) {
                    t = ifVar.mo14319(opt, f);
                }
                Object opt2 = jSONObject.opt("e");
                if (opt2 != null) {
                    t2 = ifVar.mo14319(opt2, f);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("o");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("i");
                if (!(optJSONObject == null || optJSONObject2 == null)) {
                    pointF = C0914.m15713(optJSONObject, f);
                    pointF2 = C0914.m15713(optJSONObject2, f);
                }
                if (jSONObject.optInt("h", 0) == 1) {
                    t2 = t;
                    interpolator = C1297AUx.f4305;
                } else if (pointF != null) {
                    pointF.x = C1150.m16329(pointF.x, -f, f);
                    pointF.y = C1150.m16329(pointF.y, -100.0f, 100.0f);
                    pointF2.x = C1150.m16329(pointF2.x, -f, f);
                    pointF2.y = C1150.m16329(pointF2.y, -100.0f, 100.0f);
                    int r18 = C1026.m16012(pointF.x, pointF.y, pointF2.x, pointF2.y);
                    WeakReference<Interpolator> r19 = m3448(r18);
                    if (r19 != null) {
                        interpolator = r19.get();
                    }
                    if (r19 == null || interpolator == null) {
                        interpolator = PathInterpolatorCompat.create(pointF.x / f, pointF.y / f, pointF2.x / f, pointF2.y / f);
                        try {
                            m3449(r18, new WeakReference(interpolator));
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                } else {
                    interpolator = C1297AUx.f4305;
                }
            } else {
                t = ifVar.mo14319(jSONObject, f);
                t2 = t;
            }
            return new C1297AUx<>(r22, t, t2, interpolator, f2, null);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static <T> List<C1297AUx<T>> m3447(JSONArray jSONArray, C0433 r5, float f, AbstractC0923.Cif<T> ifVar) {
            int length = jSONArray.length();
            if (length == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(m3446(jSONArray.optJSONObject(i), r5, f, ifVar));
            }
            C1297AUx.m3439(arrayList);
            return arrayList;
        }
    }
}
