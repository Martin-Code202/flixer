package com.airbnb.lottie.model.layer;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import o.AbstractC0342;
import o.C0433;
import o.C0551;
import o.C0737;
import o.C0761;
import o.C0984;
import o.C1026;
import o.C1035;
import o.C1297AUx;
import org.json.JSONArray;
import org.json.JSONObject;
public class Layer {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f83 = Layer.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private final List<Mask> f84;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final int f85;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final LayerType f86;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0984 f87;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final List<C1297AUx<Float>> f88;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final MatteType f89;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<AbstractC0342> f90;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final int f91;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final long f92;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final int f93;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0433 f94;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final int f95;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final float f96;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f97;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final float f98;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final int f99;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final C0737 f100;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final long f101;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final C0761 f102;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f103;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final C1035 f104;

    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    private Layer(List<AbstractC0342> list, C0433 r3, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, C0984 r12, int i, int i2, int i3, float f, float f2, int i4, int i5, C0737 r20, C1035 r21, List<C1297AUx<Float>> list3, MatteType matteType, C0761 r24) {
        this.f90 = list;
        this.f94 = r3;
        this.f97 = str;
        this.f92 = j;
        this.f86 = layerType;
        this.f101 = j2;
        this.f103 = str2;
        this.f84 = list2;
        this.f87 = r12;
        this.f95 = i;
        this.f91 = i2;
        this.f93 = i3;
        this.f96 = f;
        this.f98 = f2;
        this.f99 = i4;
        this.f85 = i5;
        this.f100 = r20;
        this.f104 = r21;
        this.f88 = list3;
        this.f89 = matteType;
        this.f102 = r24;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0433 m65() {
        return this.f94;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public float m70() {
        return this.f96;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public float m67() {
        return this.f98;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public List<C1297AUx<Float>> m69() {
        return this.f88;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m74() {
        return this.f92;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m80() {
        return this.f97;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m60() {
        return this.f103;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public int m64() {
        return this.f99;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public int m62() {
        return this.f85;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public List<Mask> m78() {
        return this.f84;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public LayerType m66() {
        return this.f86;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public MatteType m72() {
        return this.f89;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public long m68() {
        return this.f101;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public List<AbstractC0342> m73() {
        return this.f90;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public C0984 m75() {
        return this.f87;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public int m77() {
        return this.f93;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public int m79() {
        return this.f91;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public int m61() {
        return this.f95;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public C0737 m81() {
        return this.f100;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public C1035 m76() {
        return this.f104;
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public C0761 m63() {
        return this.f102;
    }

    public String toString() {
        return m71("");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m71(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(m80()).append("\n");
        Layer r7 = this.f94.m14256(m68());
        if (r7 != null) {
            sb.append("\t\tParents: ").append(r7.m80());
            Layer r72 = this.f94.m14256(r7.m68());
            while (r72 != null) {
                sb.append("->").append(r72.m80());
                r72 = this.f94.m14256(r72.m68());
            }
            sb.append(str).append("\n");
        }
        if (!m78().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(m78().size()).append("\n");
        }
        if (!(m61() == 0 || m79() == 0)) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(m61()), Integer.valueOf(m79()), Integer.valueOf(m77())));
        }
        if (!this.f90.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (AbstractC0342 r9 : this.f90) {
                sb.append(str).append("\t\t").append(r9).append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: com.airbnb.lottie.model.layer.Layer$ˋ  reason: contains not printable characters */
    public static class C0001 {
        /* renamed from: ˊ  reason: contains not printable characters */
        public static Layer m82(C0433 r26) {
            Rect r25 = r26.m14263();
            return new Layer(Collections.emptyList(), r26, "root", -1, LayerType.PreComp, -1, null, Collections.emptyList(), C0984.C0985.m15923(), 0, 0, 0, 0.0f, 0.0f, r25.width(), r25.height(), null, null, Collections.emptyList(), MatteType.None, null);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static Layer m83(JSONObject jSONObject, C0433 r58) {
            LayerType layerType;
            String optString = jSONObject.optString("nm");
            String optString2 = jSONObject.optString("refId");
            if (optString.endsWith(".ai") || jSONObject.optString("cl", "").equals("ai")) {
                r58.m14262("Convert your Illustrator layers to shape layers.");
            }
            long optLong = jSONObject.optLong("ind");
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int optInt = jSONObject.optInt("ty", -1);
            if (optInt < LayerType.Unknown.ordinal()) {
                layerType = LayerType.values()[optInt];
            } else {
                layerType = LayerType.Unknown;
            }
            if (layerType == LayerType.Text && !C1026.m16016(r58, 4, 8, 0)) {
                layerType = LayerType.Unknown;
                r58.m14262("Text is only supported on bodymovin >= 4.8.0");
            }
            long optLong2 = jSONObject.optLong("parent", -1);
            if (layerType == LayerType.Solid) {
                i = (int) (((float) jSONObject.optInt("sw")) * r58.m14266());
                i2 = (int) (((float) jSONObject.optInt("sh")) * r58.m14266());
                i3 = Color.parseColor(jSONObject.optString("sc"));
            }
            C0984 r38 = C0984.C0985.m15921(jSONObject.optJSONObject("ks"), r58);
            MatteType matteType = MatteType.values()[jSONObject.optInt("tt")];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("masksProperties");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    arrayList.add(Mask.If.m24(optJSONArray.optJSONObject(i6), r58));
                }
            }
            ArrayList arrayList3 = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("shapes");
            if (optJSONArray2 != null) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    AbstractC0342 r46 = C0551.m14596(optJSONArray2.optJSONObject(i7), r58);
                    if (r46 != null) {
                        arrayList3.add(r46);
                    }
                }
            }
            C0737 r45 = null;
            C1035 r462 = null;
            JSONObject optJSONObject = jSONObject.optJSONObject("t");
            if (optJSONObject != null) {
                r45 = C0737.If.m15112(optJSONObject.optJSONObject("d"), r58);
                r462 = C1035.Cif.m16042(optJSONObject.optJSONArray("a").optJSONObject(0), r58);
            }
            if (jSONObject.has("ef")) {
                r58.m14262("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape.");
            }
            float optDouble = (float) jSONObject.optDouble("sr", 1.0d);
            float optDouble2 = ((float) jSONObject.optDouble("st")) / r58.m14257();
            if (layerType == LayerType.PreComp) {
                i4 = (int) (((float) jSONObject.optInt("w")) * r58.m14266());
                i5 = (int) (((float) jSONObject.optInt("h")) * r58.m14266());
            }
            float optLong3 = ((float) jSONObject.optLong("ip")) / optDouble;
            float optLong4 = ((float) jSONObject.optLong("op")) / optDouble;
            if (optLong3 > 0.0f) {
                arrayList2.add(new C1297AUx(r58, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float r0 = optLong4 > 0.0f ? optLong4 : (float) (r58.m14268() + 1);
            arrayList2.add(new C1297AUx(r58, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(r0)));
            arrayList2.add(new C1297AUx(r58, Float.valueOf(0.0f), Float.valueOf(0.0f), null, r0, Float.valueOf(Float.MAX_VALUE)));
            C0761 r56 = null;
            if (jSONObject.has("tm")) {
                r56 = C0761.Cif.m15192(jSONObject.optJSONObject("tm"), r58, false);
            }
            return new Layer(arrayList3, r58, optString, optLong, layerType, optLong2, optString2, arrayList, r38, i, i2, i3, optDouble, optDouble2, i4, i5, r45, r462, arrayList2, matteType, r56);
        }
    }
}
