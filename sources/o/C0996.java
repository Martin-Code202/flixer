package o;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import o.C0740;
import o.C0747;
import o.C0887;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ᵀ  reason: contains not printable characters */
public class C0996 implements AbstractC0342 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C0740 f15058;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0761 f15059;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Path.FillType f15060;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0887 f15061;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0747 f15062;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final GradientType f15063;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0740 f15064;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0761 f15065;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f15066;

    private C0996(String str, GradientType gradientType, Path.FillType fillType, C0887 r4, C0747 r5, C0740 r6, C0740 r7, C0761 r8, C0761 r9) {
        this.f15063 = gradientType;
        this.f15060 = fillType;
        this.f15061 = r4;
        this.f15062 = r5;
        this.f15064 = r6;
        this.f15058 = r7;
        this.f15066 = str;
        this.f15059 = r8;
        this.f15065 = r9;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m15935() {
        return this.f15066;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public GradientType m15939() {
        return this.f15063;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Path.FillType m15938() {
        return this.f15060;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0887 m15937() {
        return this.f15061;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0747 m15936() {
        return this.f15062;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public C0740 m15940() {
        return this.f15064;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public C0740 m15934() {
        return this.f15058;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C0448(aux, r3, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᵀ$ˋ  reason: contains not printable characters */
    public static class C0997 {
        /* renamed from: ˏ  reason: contains not printable characters */
        static C0996 m15941(JSONObject jSONObject, C0433 r25) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has("k")) {
                int optInt = optJSONObject.optInt("p");
                optJSONObject = optJSONObject.optJSONObject("k");
                try {
                    optJSONObject.put("p", optInt);
                } catch (JSONException e) {
                }
            }
            C0887 r13 = null;
            if (optJSONObject != null) {
                r13 = C0887.iF.m15602(optJSONObject, r25);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            C0747 r15 = null;
            if (optJSONObject2 != null) {
                r15 = C0747.C0749.m15166(optJSONObject2, r25);
            }
            Path.FillType fillType = jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            GradientType gradientType = jSONObject.optInt("t", 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            C0740 r21 = null;
            if (optJSONObject3 != null) {
                r21 = C0740.If.m15120(optJSONObject3, r25);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            C0740 r23 = null;
            if (optJSONObject4 != null) {
                r23 = C0740.If.m15120(optJSONObject4, r25);
            }
            return new C0996(optString, gradientType, fillType, r13, r15, r21, r23, null, null);
        }
    }
}
