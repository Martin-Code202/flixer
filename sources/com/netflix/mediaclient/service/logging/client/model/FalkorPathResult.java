package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import java.util.ArrayList;
import java.util.List;
import o.AK;
import o.C1349Bv;
import org.json.JSONArray;
import org.json.JSONObject;
public class FalkorPathResult {
    public static final String PATH = "path";
    public static final String PATH_ERROR = "pathError";
    public static final String SUCCESS = "success";
    @SerializedName(PATH)
    @Since(1.0d)
    private String path;
    @SerializedName(PATH_ERROR)
    @Since(1.0d)
    private final List<DeepErrorElement> pathError = new ArrayList();
    @SerializedName(SUCCESS)
    @Since(1.0d)
    private boolean success;

    public FalkorPathResult() {
    }

    public FalkorPathResult(String str, boolean z, List<DeepErrorElement> list) {
        this.path = str;
        this.success = z;
        if (list != null) {
            this.pathError.addAll(list);
        }
    }

    public String getPath() {
        return this.path;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public List<DeepErrorElement> getPathError() {
        return this.pathError;
    }

    public String toString() {
        return "FalkorPathResult [path=" + this.path + ", success=" + this.success + "]";
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.path != null) {
            jSONObject.put(PATH, this.path);
        }
        jSONObject.put(SUCCESS, this.success);
        if (this.pathError != null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(PATH_ERROR, jSONArray);
            for (DeepErrorElement deepErrorElement : this.pathError) {
                jSONArray.put(deepErrorElement.toJSONObject());
            }
        }
        return jSONObject;
    }

    public static FalkorPathResult createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FalkorPathResult falkorPathResult = new FalkorPathResult();
        falkorPathResult.success = AK.m3381(jSONObject, SUCCESS, false);
        falkorPathResult.path = AK.m3376(jSONObject, PATH, (String) null);
        JSONArray r3 = AK.m3377(jSONObject, PATH_ERROR);
        if (r3 != null) {
            for (int i = 0; i < r3.length(); i++) {
                falkorPathResult.pathError.add(DeepErrorElement.createInstance(r3.getJSONObject(i)));
            }
        }
        return falkorPathResult;
    }

    public static FalkorPathResult createInstance(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return createInstance(new JSONObject(str));
    }

    public static List<FalkorPathResult> createList(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(createInstance(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static String createJSONArray(List<FalkorPathResult> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i).toJSONObject());
        }
        return jSONArray.toString();
    }
}
