package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.netflix.mediaclient.service.logging.client.model.Version;
import o.AbstractC0342;
import o.AbstractC0420;
import o.AbstractC0741;
import o.AbstractC0923;
import o.C0433;
import o.C0761;
import o.C1019;
import o.C1518aux;
import o.C1623con;
import org.json.JSONObject;
public class PolystarShape implements AbstractC0342 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C0761 f44;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C0761 f45;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0761 f46;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0761 f47;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC0923<PointF, PointF> f48;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Type f49;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0761 f50;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f51;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0761 f52;

    public enum Type {
        Star(1),
        Polygon(2);
        

        /* renamed from: ॱ  reason: contains not printable characters */
        private final int f56;

        private Type(int i) {
            this.f56 = i;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        static Type m40(int i) {
            Type[] values = values();
            for (Type type : values) {
                if (type.f56 == i) {
                    return type;
                }
            }
            return null;
        }
    }

    private PolystarShape(String str, Type type, C0761 r3, AbstractC0923<PointF, PointF> r4, C0761 r5, C0761 r6, C0761 r7, C0761 r8, C0761 r9) {
        this.f51 = str;
        this.f49 = type;
        this.f50 = r3;
        this.f48 = r4;
        this.f47 = r5;
        this.f45 = r6;
        this.f44 = r7;
        this.f46 = r8;
        this.f52 = r9;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m37() {
        return this.f51;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Type m34() {
        return this.f49;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0761 m33() {
        return this.f50;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC0923<PointF, PointF> m35() {
        return this.f48;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0761 m36() {
        return this.f47;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public C0761 m39() {
        return this.f45;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public C0761 m32() {
        return this.f44;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public C0761 m38() {
        return this.f46;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public C0761 m31() {
        return this.f52;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C1623con(aux, r3, this);
    }

    /* renamed from: com.airbnb.lottie.model.content.PolystarShape$if  reason: invalid class name */
    public static class Cif {
        /* renamed from: ˎ  reason: contains not printable characters */
        public static PolystarShape m41(JSONObject jSONObject, C0433 r21) {
            C0761 r19;
            C0761 r18;
            String optString = jSONObject.optString("nm");
            Type r12 = Type.m40(jSONObject.optInt("sy"));
            C0761 r13 = C0761.Cif.m15192(jSONObject.optJSONObject("pt"), r21, false);
            AbstractC0923<PointF, PointF> r14 = C1019.m15982(jSONObject.optJSONObject("p"), r21);
            C0761 r15 = C0761.Cif.m15192(jSONObject.optJSONObject("r"), r21, false);
            C0761 r16 = C0761.Cif.m15191(jSONObject.optJSONObject("or"), r21);
            C0761 r17 = C0761.Cif.m15192(jSONObject.optJSONObject(Version.OS), r21, false);
            if (r12 == Type.Star) {
                r18 = C0761.Cif.m15191(jSONObject.optJSONObject("ir"), r21);
                r19 = C0761.Cif.m15192(jSONObject.optJSONObject("is"), r21, false);
            } else {
                r18 = null;
                r19 = null;
            }
            return new PolystarShape(optString, r12, r13, r14, r15, r18, r16, r19, r17);
        }
    }
}
