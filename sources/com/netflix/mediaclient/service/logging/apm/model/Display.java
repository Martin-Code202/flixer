package com.netflix.mediaclient.service.logging.apm.model;

import org.json.JSONObject;
public class Display {

    /* renamed from: ʻ  reason: contains not printable characters */
    private ScanMode f1142;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Integer f1143;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Integer f1144;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Connector f1145;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Integer f1146;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AspectRatio f1147;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f1148;

    public enum Connector {
        internal,
        component,
        composite,
        hdmi
    }

    public enum ScanMode {
        progressive,
        interlaced
    }

    private Display() {
    }

    public Display(Connector connector, AspectRatio aspectRatio, Integer num, Integer num2, Integer num3, ScanMode scanMode, int i) {
        this.f1145 = connector;
        this.f1147 = aspectRatio;
        this.f1143 = num;
        this.f1144 = num2;
        this.f1146 = num3;
        this.f1142 = scanMode;
        this.f1148 = i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public JSONObject m594() {
        JSONObject jSONObject = new JSONObject();
        if (this.f1145 != null) {
            jSONObject.put("connector", this.f1145.name());
        }
        if (this.f1147 != null) {
            jSONObject.put("aspectRatio", this.f1147.m595());
        }
        if (this.f1142 != null) {
            jSONObject.put("scanMode", this.f1142.name());
        }
        if (!(this.f1143 == null || this.f1144 == null)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("resolution", jSONObject2);
            jSONObject2.put("height", this.f1144.intValue());
            jSONObject2.put("width", this.f1143.intValue());
        }
        if (this.f1146 != null) {
            jSONObject.put("refreshRate", this.f1146.intValue());
        }
        jSONObject.put("horizontalDpi", this.f1148);
        return jSONObject;
    }

    public enum AspectRatio {
        _16x9("16x9"),
        _4x3("4x3");
        

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f1152;

        private AspectRatio(String str) {
            this.f1152 = str;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m595() {
            return this.f1152;
        }
    }
}
