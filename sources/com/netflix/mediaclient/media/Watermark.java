package com.netflix.mediaclient.media;

import o.AK;
import o.C1283;
import o.C1349Bv;
import org.json.JSONObject;
public class Watermark {
    private static final String ANCHOR = "anchor";
    private static final String ID = "id";
    private static final String OPACITY = "opacity";
    private static final String TAG = "nf_watermark";
    private Anchor mAnchor;
    private String mIdentifier;
    private int mOpacity;

    public enum Anchor {
        top_center,
        bottom_center
    }

    private Watermark(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("Watermark json is null!");
        }
        this.mIdentifier = AK.m3376(jSONObject, ID, (String) null);
        this.mOpacity = AK.m3386(jSONObject, OPACITY, -1);
        String r2 = AK.m3376(jSONObject, ANCHOR, (String) null);
        if (!C1349Bv.m4113(r2)) {
            try {
                this.mAnchor = Anchor.valueOf(r2);
            } catch (Throwable th) {
                C1283.m16847(TAG, "Failed, go to default", th);
                this.mAnchor = Anchor.top_center;
            }
        }
    }

    public boolean isValid() {
        return this.mOpacity >= 0 && this.mOpacity <= 100 && C1349Bv.m4107(this.mIdentifier) && this.mAnchor != null;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public int getOpacity() {
        return this.mOpacity;
    }

    public Anchor getAnchor() {
        return this.mAnchor;
    }

    public String toString() {
        return "Watermark{mIdentifier='" + this.mIdentifier + "', mOpacity=" + this.mOpacity + ", mAnchor=" + this.mAnchor + '}';
    }

    public static Watermark createWatermark(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Watermark watermark = new Watermark(jSONObject);
        if (watermark.isValid()) {
            return watermark;
        }
        return null;
    }
}
