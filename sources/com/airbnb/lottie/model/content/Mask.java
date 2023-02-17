package com.airbnb.lottie.model.content;

import o.C0433;
import o.C0747;
import o.C0814;
import org.json.JSONObject;
public class Mask {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0814 f28;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0747 f29;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final MaskMode f30;

    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect,
        MaskModeUnknown
    }

    private Mask(MaskMode maskMode, C0814 r2, C0747 r3) {
        this.f30 = maskMode;
        this.f28 = r2;
        this.f29 = r3;
    }

    public static class If {
        /* renamed from: ˊ  reason: contains not printable characters */
        public static Mask m24(JSONObject jSONObject, C0433 r7) {
            MaskMode maskMode;
            String optString = jSONObject.optString("mode");
            char c = 65535;
            switch (optString.hashCode()) {
                case 97:
                    if (optString.equals("a")) {
                        c = 0;
                        break;
                    }
                    break;
                case 105:
                    if (optString.equals("i")) {
                        c = 2;
                        break;
                    }
                    break;
                case 115:
                    if (optString.equals("s")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    maskMode = MaskMode.MaskModeAdd;
                    break;
                case 1:
                    maskMode = MaskMode.MaskModeSubtract;
                    break;
                case 2:
                    maskMode = MaskMode.MaskModeIntersect;
                    break;
                default:
                    maskMode = MaskMode.MaskModeUnknown;
                    break;
            }
            return new Mask(maskMode, C0814.iF.m15384(jSONObject.optJSONObject("pt"), r7), C0747.C0749.m15166(jSONObject.optJSONObject("o"), r7));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public MaskMode m23() {
        return this.f30;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0814 m22() {
        return this.f28;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0747 m21() {
        return this.f29;
    }
}
