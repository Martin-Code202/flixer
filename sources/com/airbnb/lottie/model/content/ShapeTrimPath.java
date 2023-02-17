package com.airbnb.lottie.model.content;

import o.AbstractC0342;
import o.AbstractC0420;
import o.AbstractC0741;
import o.C0433;
import o.C0761;
import o.C1354COn;
import o.C1518aux;
import org.json.JSONObject;
public class ShapeTrimPath implements AbstractC0342 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Type f75;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0761 f76;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f77;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0761 f78;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0761 f79;

    public enum Type {
        Simultaneously,
        Individually;

        /* renamed from: ˋ  reason: contains not printable characters */
        static Type m58(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    throw new IllegalArgumentException("Unknown trim path type " + i);
            }
        }
    }

    private ShapeTrimPath(String str, Type type, C0761 r3, C0761 r4, C0761 r5) {
        this.f77 = str;
        this.f75 = type;
        this.f78 = r3;
        this.f76 = r4;
        this.f79 = r5;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m56() {
        return this.f77;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Type m54() {
        return this.f75;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0761 m55() {
        return this.f76;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0761 m53() {
        return this.f78;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0761 m57() {
        return this.f79;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C1354COn(r3, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.f78 + ", end: " + this.f76 + ", offset: " + this.f79 + "}";
    }

    public static class iF {
        /* renamed from: ˋ  reason: contains not printable characters */
        public static ShapeTrimPath m59(JSONObject jSONObject, C0433 r8) {
            return new ShapeTrimPath(jSONObject.optString("nm"), Type.m58(jSONObject.optInt("m", 1)), C0761.Cif.m15192(jSONObject.optJSONObject("s"), r8, false), C0761.Cif.m15192(jSONObject.optJSONObject("e"), r8, false), C0761.Cif.m15192(jSONObject.optJSONObject("o"), r8, false));
        }
    }
}
