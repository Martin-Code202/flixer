package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.ArrayList;
import java.util.List;
import o.AK;
import o.C1359Ce;
import org.json.JSONArray;
import org.json.JSONObject;
public abstract class Event {
    public static final String ACTIVE_SESSIONS = "activeSessions";
    public static final String CATEGORY = "category";
    public static final String CUSTOM = "custom";
    public static final String DATA = "data";
    public static final String DATA_CONTEXT = "dataContext";
    public static final String KIDS = "kids";
    public static final String MODAL_VIEW = "modalView";
    public static final String NAME = "name";
    public static final String SEQUENCE = "sequence";
    public static final String SEVERITY = "severity";
    public static final String TIME = "time";
    public static final String TYPE = "type";
    public static final String UPTIME = "uptime";
    @SerializedName(ACTIVE_SESSIONS)
    @Since(1.0d)
    protected List<SessionKey> activeSessions = new ArrayList();
    @SerializedName("category")
    @Since(1.0d)
    protected String category;
    @SerializedName(DATA_CONTEXT)
    @Since(1.0d)
    protected C1359Ce dataContext;
    @SerializedName(KIDS)
    @Since(1.1d)
    protected boolean kids;
    @SerializedName(MODAL_VIEW)
    @Since(1.0d)
    protected IClientLogging.ModalView modalView;
    @SerializedName("name")
    @Since(1.0d)
    protected String name;
    @SerializedName(SEQUENCE)
    @Since(1.0d)
    protected long sequence;
    @SerializedName("time")
    @Since(1.0d)
    protected long time = System.currentTimeMillis();
    @SerializedName("type")
    @Since(1.0d)
    protected EventType type;
    @SerializedName(UPTIME)
    @Since(1.0d)
    protected long uptime;

    public Event() {
    }

    public Event(JSONObject jSONObject) {
        String r3 = AK.m3376(jSONObject, "type", (String) null);
        if (r3 != null) {
            this.type = EventType.valueOf(r3);
        }
        this.kids = AK.m3381(jSONObject, KIDS, false);
        String r32 = AK.m3376(jSONObject, MODAL_VIEW, (String) null);
        if (r32 != null) {
            this.modalView = IClientLogging.ModalView.valueOf(r32);
        }
        this.category = AK.m3376(jSONObject, "category", (String) null);
        this.name = AK.m3376(jSONObject, "name", (String) null);
        this.time = AK.m3388(jSONObject, "time", 0);
        this.sequence = AK.m3388(jSONObject, SEQUENCE, 0);
        this.uptime = AK.m3388(jSONObject, UPTIME, 0);
        this.dataContext = C1359Ce.m4360(AK.m3380(jSONObject, DATA_CONTEXT, (JSONObject) null));
        JSONArray r4 = AK.m3377(jSONObject, ACTIVE_SESSIONS);
        if (r4 != null) {
            for (int i = 0; i < r4.length(); i++) {
                this.activeSessions.add(SessionKey.createInstance(r4.getJSONObject(i)));
            }
        }
    }

    public EventType getType() {
        return this.type;
    }

    public String getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public long getTime() {
        return this.time;
    }

    public long getSequence() {
        return this.sequence;
    }

    public long getUptime() {
        return this.uptime;
    }

    public IClientLogging.ModalView getModalView() {
        return this.modalView;
    }

    public C1359Ce getDataContext() {
        return this.dataContext;
    }

    public void setDataContext(C1359Ce ce) {
        this.dataContext = ce;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSequence(long j) {
        this.sequence = j;
    }

    public void setUptime(long j) {
        this.uptime = j;
    }

    public void setModalView(IClientLogging.ModalView modalView2) {
        this.modalView = modalView2;
    }

    public void addActiveSession(SessionKey sessionKey) {
        this.activeSessions.add(sessionKey);
    }

    public boolean removeActiveSession(SessionKey sessionKey) {
        return this.activeSessions.remove(sessionKey);
    }

    public void addAllActiveSession(List<SessionKey> list) {
        this.activeSessions.addAll(list);
    }

    public List<SessionKey> getAllActiveSessions() {
        return this.activeSessions;
    }

    public String toString() {
        return "Event [type=" + this.type + ", category=" + this.category + ", name=" + this.name + ", time=" + this.time + ", sequence=" + this.sequence + ", kids=" + this.kids + ", uptime=" + this.uptime + ", modalView=" + this.modalView + ", dataContex=" + this.dataContext + "]";
    }

    public JSONObject getData() {
        JSONObject jSONObject = new JSONObject();
        JSONObject customData = getCustomData();
        if (customData != null) {
            jSONObject.put(CUSTOM, customData);
        }
        return jSONObject;
    }

    public JSONObject getCustomData() {
        return null;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.category != null) {
            jSONObject.put("category", this.category);
        }
        if (this.name != null) {
            jSONObject.put("name", this.name);
        }
        if (this.type != null) {
            jSONObject.put("type", this.type.name());
        }
        if (this.modalView != null) {
            jSONObject.put(MODAL_VIEW, this.modalView.name());
        }
        if (this.dataContext != null) {
            jSONObject.put(DATA_CONTEXT, this.dataContext.toJSONObject());
        }
        JSONObject data = getData();
        if (data != null) {
            jSONObject.put(DATA, data);
        }
        jSONObject.put("time", this.time);
        jSONObject.put(SEQUENCE, this.sequence);
        jSONObject.put(UPTIME, this.uptime);
        jSONObject.put(KIDS, this.kids);
        if (this.activeSessions != null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(ACTIVE_SESSIONS, jSONArray);
            for (SessionKey sessionKey : this.activeSessions) {
                jSONArray.put(sessionKey.toJSONArray());
            }
        }
        return jSONObject;
    }

    public static Event createEvent(JSONObject jSONObject) {
        return null;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public boolean isKids() {
        return this.kids;
    }

    public void setKids(boolean z) {
        this.kids = z;
    }
}
