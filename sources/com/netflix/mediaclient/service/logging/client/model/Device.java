package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import o.AK;
import o.AbstractC0488;
import o.AbstractC1221;
import org.json.JSONObject;
public class Device {
    public static final String ESN = "esn";
    public static final String MODEL = "model";
    public static final String TYPE = "type";
    @SerializedName(ESN)
    @Since(1.0d)
    private String esn;
    @SerializedName(MODEL)
    @Since(1.0d)
    private String model;
    @SerializedName("type")
    @Since(1.0d)
    private String type = AbstractC0488.f13570;

    public Device() {
    }

    Device(AbstractC1221 r3) {
        if (r3 == null) {
            throw new IllegalArgumentException("Configuration is null!");
        }
        this.model = r3.d_().mo14452();
        this.esn = r3.d_().mo14449();
    }

    public String getEsn() {
        return this.esn;
    }

    public String getType() {
        return this.type;
    }

    public String getModel() {
        return this.model;
    }

    public String toString() {
        return "Device [esn=" + this.esn + ", type=" + this.type + ", model=" + this.model + "]";
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.esn != null) {
            jSONObject.put(ESN, this.esn);
        }
        if (this.model != null) {
            jSONObject.put(MODEL, this.model);
        }
        if (this.type != null) {
            jSONObject.put("type", this.type);
        }
        return jSONObject;
    }

    public static Device createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Device device = new Device();
        device.esn = AK.m3376(jSONObject, ESN, (String) null);
        device.model = AK.m3376(jSONObject, MODEL, (String) null);
        device.type = AK.m3376(jSONObject, "type", (String) null);
        return device;
    }
}
