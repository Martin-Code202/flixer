package o;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.ArrayList;
import java.util.List;
import o.C0740;
import o.C0747;
import o.C0761;
import o.C0887;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ﾟ  reason: contains not printable characters */
public class C1287 implements AbstractC0342 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final List<C0761> f15998;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C0740 f15999;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final ShapeStroke.LineCapType f16000;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0740 f16001;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0747 f16002;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f16003;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final GradientType f16004;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final C0761 f16005;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0887 f16006;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0761 f16007;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final ShapeStroke.LineJoinType f16008;

    private C1287(String str, GradientType gradientType, C0887 r3, C0747 r4, C0740 r5, C0740 r6, C0761 r7, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, List<C0761> list, C0761 r11) {
        this.f16003 = str;
        this.f16004 = gradientType;
        this.f16006 = r3;
        this.f16002 = r4;
        this.f16001 = r5;
        this.f15999 = r6;
        this.f16007 = r7;
        this.f16000 = lineCapType;
        this.f16008 = lineJoinType;
        this.f15998 = list;
        this.f16005 = r11;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m16874() {
        return this.f16003;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public GradientType m16876() {
        return this.f16004;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0887 m16873() {
        return this.f16006;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0747 m16878() {
        return this.f16002;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0740 m16877() {
        return this.f16001;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public C0740 m16880() {
        return this.f15999;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public C0761 m16879() {
        return this.f16007;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public ShapeStroke.LineCapType m16870() {
        return this.f16000;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public ShapeStroke.LineJoinType m16871() {
        return this.f16008;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public List<C0761> m16872() {
        return this.f15998;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public C0761 m16875() {
        return this.f16005;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C0424(aux, r3, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ﾟ$iF */
    public static class iF {
        /* renamed from: ˏ  reason: contains not printable characters */
        static C1287 m16881(JSONObject jSONObject, C0433 r35) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has("k")) {
                optJSONObject = optJSONObject.optJSONObject("k");
            }
            C0887 r15 = null;
            if (optJSONObject != null) {
                r15 = C0887.iF.m15602(optJSONObject, r35);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            C0747 r17 = null;
            if (optJSONObject2 != null) {
                r17 = C0747.C0749.m15166(optJSONObject2, r35);
            }
            GradientType gradientType = jSONObject.optInt("t", 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            C0740 r21 = null;
            if (optJSONObject3 != null) {
                r21 = C0740.If.m15120(optJSONObject3, r35);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            C0740 r23 = null;
            if (optJSONObject4 != null) {
                r23 = C0740.If.m15120(optJSONObject4, r35);
            }
            C0761 r24 = C0761.Cif.m15191(jSONObject.optJSONObject("w"), r35);
            ShapeStroke.LineCapType lineCapType = ShapeStroke.LineCapType.values()[jSONObject.optInt("lc") - 1];
            ShapeStroke.LineJoinType lineJoinType = ShapeStroke.LineJoinType.values()[jSONObject.optInt("lj") - 1];
            C0761 r27 = null;
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject5.optString("n");
                    if (optString2.equals("o")) {
                        r27 = C0761.Cif.m15191(optJSONObject5.optJSONObject("v"), r35);
                    } else if (optString2.equals("d") || optString2.equals("g")) {
                        arrayList.add(C0761.Cif.m15191(optJSONObject5.optJSONObject("v"), r35));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
            }
            return new C1287(optString, gradientType, r15, r17, r21, r23, r24, lineCapType, lineJoinType, arrayList, r27);
        }
    }
}
