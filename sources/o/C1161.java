package o;

import android.graphics.Path;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import o.AbstractC0923;
import o.C1297AUx;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ﹳ  reason: contains not printable characters */
public class C1161 extends C1297AUx<PointF> {

    /* renamed from: ʼ  reason: contains not printable characters */
    private Path f15416;

    private C1161(C0433 r1, PointF pointF, PointF pointF2, Interpolator interpolator, float f, Float f2) {
        super(r1, pointF, pointF2, interpolator, f, f2);
    }

    /* renamed from: o.ﹳ$ˋ  reason: contains not printable characters */
    public static class C1162 {
        /* renamed from: ॱ  reason: contains not printable characters */
        public static C1161 m16351(JSONObject jSONObject, C0433 r16, AbstractC0923.Cif<PointF> ifVar) {
            C1297AUx r8 = C1297AUx.iF.m3446(jSONObject, r16, r16.m14266(), ifVar);
            PointF pointF = null;
            PointF pointF2 = null;
            JSONArray optJSONArray = jSONObject.optJSONArray("ti");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("to");
            if (!(optJSONArray == null || optJSONArray2 == null)) {
                pointF = C0914.m15714(optJSONArray2, r16.m14266());
                pointF2 = C0914.m15714(optJSONArray, r16.m14266());
            }
            C1161 r0 = new C1161(r16, r8.f4310, r8.f4309, r8.f4313, r8.f4312, r8.f4311);
            boolean z = (r8.f4309 == null || r8.f4310 == null || !r8.f4310.equals(((PointF) r8.f4309).x, ((PointF) r8.f4309).y)) ? false : true;
            if (r0.f4309 != null && !z) {
                r0.f15416 = C1026.m16013(r8.f4310, r8.f4309, pointF, pointF2);
            }
            return r0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Path m16350() {
        return this.f15416;
    }
}
