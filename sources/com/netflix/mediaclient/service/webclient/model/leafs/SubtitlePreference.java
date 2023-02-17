package com.netflix.mediaclient.service.webclient.model.leafs;

import o.AK;
import o.C1283;
import o.C1349Bv;
import org.json.JSONException;
import org.json.JSONObject;
public class SubtitlePreference {
    private static final String FIELD_BACK_COLOR = "backgroundColor";
    private static final String FIELD_BACK_OPACITY = "backgroundOpacity";
    private static final String FIELD_CHAR_COLOR = "charColor";
    private static final String FIELD_CHAR_OPACITY = "charOpacity";
    private static final String FIELD_CHAR_SIZE = "charSize";
    private static final String FIELD_CHAR_STLE = "charStyle";
    private static final String FIELD_EDGE_ATTRS = "charEdgeAttrs";
    private static final String FIELD_EDGE_COLOR = "charEdgeColor";
    public static final String FIELD_SUBTITLE_DEFAULT = "subtitleDefault";
    public static final String FIELD_SUBTITLE_OVERRIDE = "subtitleOverride";
    private static final String FIELD_WIN_COLOR = "windowColor";
    private static final String FIELD_WIN_OPACITY = "windowOpacity";
    private static final String TAG = "nf_subtitlePreference";
    private String backgroundColor;
    private String backgroundOpacity;
    private String charColor;
    private String charEdgeAttrs;
    private String charEdgeColor;
    private String charOpacity;
    private String charSize;
    private String charStyle;
    private String windowColor;
    private String windowOpacity;

    public String getCharOpacity() {
        return this.charOpacity;
    }

    public void setCharOpacity(String str) {
        this.charOpacity = str;
    }

    public String getBackgroundOpacity() {
        return this.backgroundOpacity;
    }

    public void setBackgroundOpacity(String str) {
        this.backgroundOpacity = str;
    }

    public String getWindowOpacity() {
        return this.windowOpacity;
    }

    public void setWindowOpacity(String str) {
        this.windowOpacity = str;
    }

    public String getCharColor() {
        return this.charColor;
    }

    public void setCharColor(String str) {
        this.charColor = str;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    public String getWindowColor() {
        return this.windowColor;
    }

    public void setWindowColor(String str) {
        this.windowColor = str;
    }

    public String getCharEdgeColor() {
        return this.charEdgeColor;
    }

    public void setCharEdgeColor(String str) {
        this.charEdgeColor = str;
    }

    public String getCharEdgeAttrs() {
        return this.charEdgeAttrs;
    }

    public void setCharEdgeAttrs(String str) {
        this.charEdgeAttrs = str;
    }

    public String getCharSize() {
        return this.charSize;
    }

    public void setCharSize(String str) {
        this.charSize = str;
    }

    public String getCharStyle() {
        return this.charStyle;
    }

    public void setCharStyle(String str) {
        this.charStyle = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FIELD_CHAR_OPACITY, getCharOpacity());
            jSONObject.put(FIELD_BACK_OPACITY, getBackgroundOpacity());
            jSONObject.put(FIELD_WIN_OPACITY, getWindowOpacity());
            jSONObject.put(FIELD_CHAR_COLOR, getCharColor());
            jSONObject.put(FIELD_BACK_COLOR, getBackgroundColor());
            jSONObject.put(FIELD_WIN_COLOR, getWindowColor());
            jSONObject.put(FIELD_EDGE_COLOR, getCharEdgeColor());
            jSONObject.put(FIELD_EDGE_ATTRS, getCharEdgeAttrs());
            jSONObject.put(FIELD_CHAR_SIZE, getCharSize());
            jSONObject.put(FIELD_CHAR_STLE, getCharStyle());
        } catch (JSONException e) {
            C1283.m16854(TAG, "failed in json string " + e);
        }
        C1283.m16854(TAG, "user string=" + jSONObject.toString());
        return jSONObject.toString();
    }

    public SubtitlePreference(String str) {
        try {
            JSONObject jSONObject = C1349Bv.m4113(str) ? new JSONObject() : new JSONObject(str);
            setCharOpacity(AK.m3376(jSONObject, FIELD_CHAR_OPACITY, (String) null));
            setBackgroundOpacity(AK.m3376(jSONObject, FIELD_BACK_OPACITY, (String) null));
            setWindowOpacity(AK.m3376(jSONObject, FIELD_WIN_OPACITY, (String) null));
            setCharColor(AK.m3376(jSONObject, FIELD_CHAR_COLOR, (String) null));
            setBackgroundColor(AK.m3376(jSONObject, FIELD_BACK_COLOR, (String) null));
            setWindowColor(AK.m3376(jSONObject, FIELD_WIN_COLOR, (String) null));
            setCharEdgeColor(AK.m3376(jSONObject, FIELD_EDGE_COLOR, (String) null));
            setCharEdgeAttrs(AK.m3376(jSONObject, FIELD_EDGE_ATTRS, (String) null));
            setCharSize(AK.m3376(jSONObject, FIELD_CHAR_SIZE, (String) null));
            setCharStyle(AK.m3376(jSONObject, FIELD_CHAR_STLE, (String) null));
        } catch (JSONException e) {
            C1283.m16854(TAG, "failed to create json string=" + str + " exception =" + e);
        }
    }
}
