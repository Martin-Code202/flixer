package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC0342;
import o.AbstractC0420;
import o.AbstractC0741;
import o.C0429;
import o.C0431;
import o.C0433;
import o.C0747;
import o.C0761;
import o.C1518aux;
import org.json.JSONArray;
import org.json.JSONObject;
public class ShapeStroke implements AbstractC0342 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C0761 f57;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final LineCapType f58;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0747 f59;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f60;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0761 f61;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<C0761> f62;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0429 f63;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final LineJoinType f64;

    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        /* renamed from: ˊ  reason: contains not printable characters */
        public Paint.Cap m50() {
            switch (this) {
                case Butt:
                    return Paint.Cap.BUTT;
                case Round:
                    return Paint.Cap.ROUND;
                case Unknown:
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        /* renamed from: ॱ  reason: contains not printable characters */
        public Paint.Join m51() {
            switch (this) {
                case Bevel:
                    return Paint.Join.BEVEL;
                case Miter:
                    return Paint.Join.MITER;
                case Round:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    private ShapeStroke(String str, C0761 r2, List<C0761> list, C0429 r4, C0747 r5, C0761 r6, LineCapType lineCapType, LineJoinType lineJoinType) {
        this.f60 = str;
        this.f61 = r2;
        this.f62 = list;
        this.f63 = r4;
        this.f59 = r5;
        this.f57 = r6;
        this.f58 = lineCapType;
        this.f64 = lineJoinType;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C0431(aux, r3, this);
    }

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$ˋ  reason: contains not printable characters */
    public static class C0000 {
        /* renamed from: ˎ  reason: contains not printable characters */
        public static ShapeStroke m52(JSONObject jSONObject, C0433 r24) {
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            C0429 r12 = C0429.iF.m14242(jSONObject.optJSONObject("c"), r24);
            C0761 r13 = C0761.Cif.m15191(jSONObject.optJSONObject("w"), r24);
            C0747 r14 = C0747.C0749.m15166(jSONObject.optJSONObject("o"), r24);
            LineCapType lineCapType = LineCapType.values()[jSONObject.optInt("lc") - 1];
            LineJoinType lineJoinType = LineJoinType.values()[jSONObject.optInt("lj") - 1];
            C0761 r17 = null;
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject.optString("n");
                    if (optString2.equals("o")) {
                        r17 = C0761.Cif.m15191(optJSONObject.optJSONObject("v"), r24);
                    } else if (optString2.equals("d") || optString2.equals("g")) {
                        arrayList.add(C0761.Cif.m15191(optJSONObject.optJSONObject("v"), r24));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
            }
            return new ShapeStroke(optString, r17, arrayList, r12, r14, r13, lineCapType, lineJoinType);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m45() {
        return this.f60;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0429 m47() {
        return this.f63;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0747 m44() {
        return this.f59;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0761 m46() {
        return this.f57;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public List<C0761> m48() {
        return this.f62;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public C0761 m49() {
        return this.f61;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public LineCapType m42() {
        return this.f58;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public LineJoinType m43() {
        return this.f64;
    }
}
