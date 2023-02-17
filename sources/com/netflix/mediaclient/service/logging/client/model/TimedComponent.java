package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import o.AK;
import org.json.JSONObject;
public class TimedComponent {
    public static final String ELAPSED = "elapsed";
    public static final String NAME = "name";
    @SerializedName(ELAPSED)
    @Since(1.0d)
    private long elapsed;
    @SerializedName("name")
    @Since(1.0d)
    private String name;

    public TimedComponent() {
    }

    public TimedComponent(String str, long j) {
        this.name = str;
        this.elapsed = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getElapsed() {
        return this.elapsed;
    }

    public void setElapsed(long j) {
        this.elapsed = j;
    }

    public String toString() {
        return "TimedComponent [name=" + this.name + ", elapsed=" + this.elapsed + "]";
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.name != null) {
            jSONObject.put("name", this.name);
        }
        jSONObject.put(ELAPSED, this.elapsed);
        return jSONObject;
    }

    public static TimedComponent createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        TimedComponent timedComponent = new TimedComponent();
        timedComponent.name = AK.m3376(jSONObject, "name", (String) null);
        timedComponent.elapsed = AK.m3388(jSONObject, ELAPSED, 0);
        return timedComponent;
    }
}
