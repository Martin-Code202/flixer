package com.netflix.mediaclient.service.logging.client.model;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import java.util.ArrayList;
import java.util.List;
import o.AK;
import o.AbstractC1221;
import org.json.JSONArray;
import org.json.JSONObject;
public class LoggingRequest {
    public static final String APP_NAME = "appName";
    public static final String DEVICE = "device";
    public static final String EVENTS = "events";
    public static final String LOCALE = "locale";
    public static final String NETFLIX_ID = "netflixId";
    public static final String TEST_ALLOCATIONS = "testAllocations";
    public static final String TIME = "time";
    public static final String VERSION = "version";
    @SerializedName(TEST_ALLOCATIONS)
    private String abAllocations;
    @SerializedName(APP_NAME)
    @Since(1.0d)
    private String appName = "android";
    @SerializedName(DEVICE)
    @Since(1.0d)
    private Device device;
    @SerializedName(EVENTS)
    @Since(1.0d)
    private List<Event> events = new ArrayList();
    @SerializedName(LOCALE)
    @Since(1.0d)
    private String locale;
    @SerializedName(NETFLIX_ID)
    @Since(1.0d)
    private String netflixId;
    @SerializedName("time")
    @Since(1.0d)
    private long time = System.currentTimeMillis();
    @SerializedName(VERSION)
    @Since(1.0d)
    private Version version;

    public LoggingRequest() {
    }

    public LoggingRequest(Context context, AbstractC1221 r4, UserAgentInterface userAgentInterface, String str) {
        this.version = new Version(context);
        this.device = new Device(r4);
        this.netflixId = userAgentInterface.mo1362().mo1399();
        this.locale = str;
        if (r4 != null && r4.mo16505() != null) {
            this.abAllocations = r4.mo16505().toJsonString();
        }
    }

    public String getAppName() {
        return this.appName;
    }

    public long getTime() {
        return this.time;
    }

    public Version getVersion() {
        return this.version;
    }

    public String getNetflixId() {
        return this.netflixId;
    }

    public String getLocale() {
        return this.locale;
    }

    public Device getDevice() {
        return this.device;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public void addAllEvent(List<Event> list) {
        this.events.addAll(list);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(APP_NAME, this.appName);
        if (this.version != null) {
            jSONObject.put(VERSION, this.version.toJSONObject());
        }
        if (this.device != null) {
            jSONObject.put(DEVICE, this.device.toJSONObject());
        }
        jSONObject.put("time", this.time);
        if (this.netflixId != null) {
            jSONObject.put(NETFLIX_ID, this.netflixId);
        }
        if (this.locale != null) {
            jSONObject.put(LOCALE, this.locale);
        }
        if (this.abAllocations != null) {
            jSONObject.put(TEST_ALLOCATIONS, new JSONObject(this.abAllocations));
        }
        if (this.events != null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(EVENTS, jSONArray);
            for (Event event : this.events) {
                jSONArray.put(event.toJSONObject());
            }
        }
        return jSONObject;
    }

    public static LoggingRequest createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LoggingRequest loggingRequest = new LoggingRequest();
        loggingRequest.time = AK.m3388(jSONObject, "time", 0);
        loggingRequest.netflixId = AK.m3376(jSONObject, NETFLIX_ID, (String) null);
        loggingRequest.locale = AK.m3376(jSONObject, LOCALE, (String) null);
        loggingRequest.version = Version.createInstance(AK.m3380(jSONObject, VERSION, (JSONObject) null));
        loggingRequest.device = Device.createInstance(AK.m3380(jSONObject, DEVICE, (JSONObject) null));
        JSONArray r4 = AK.m3377(jSONObject, EVENTS);
        if (r4 != null) {
            for (int i = 0; i < r4.length(); i++) {
                Event createEvent = Event.createEvent(r4.getJSONObject(i));
                if (createEvent != null) {
                    loggingRequest.events.add(createEvent);
                }
            }
        }
        return loggingRequest;
    }
}
