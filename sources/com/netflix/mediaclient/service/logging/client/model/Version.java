package com.netflix.mediaclient.service.logging.client.model;

import android.content.Context;
import android.os.Build;
import com.google.gson.annotations.Since;
import o.AK;
import o.C1318At;
import org.json.JSONObject;
public class Version {
    public static final String APP = "app";
    public static final String MDXJS = "mdxjs";
    public static final String MDXLIB = "mdxlib";
    public static final String NRDLIB = "nrdlib";
    public static final String OS = "os";
    public static final String UI = "ui";
    @Since(1.0d)
    private String app;
    @Since(1.1d)
    private String mdxjs;
    @Since(1.0d)
    private String mdxlib;
    @Since(1.0d)
    private String os;
    @Since(1.0d)
    private String ui;

    public Version() {
    }

    Version(Context context) {
        this.app = C1318At.m3776(context);
        this.ui = this.app;
        this.mdxlib = "2014.1";
        this.mdxjs = "1.1.6-android";
        this.os = Build.VERSION.RELEASE;
    }

    public String getApp() {
        return this.app;
    }

    public String getUi() {
        return this.ui;
    }

    public String getMdxlib() {
        return this.mdxlib;
    }

    public String getOs() {
        return this.os;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.app != null) {
            jSONObject.put(APP, this.app);
        }
        if (this.ui != null) {
            jSONObject.put(UI, this.ui);
        }
        if (this.mdxlib != null) {
            jSONObject.put(MDXLIB, this.mdxlib);
        }
        if (this.mdxjs != null) {
            jSONObject.put(MDXJS, this.mdxjs);
        }
        if (this.os != null) {
            jSONObject.put(OS, this.os);
        }
        return jSONObject;
    }

    public static Version createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Version version = new Version();
        version.app = AK.m3376(jSONObject, APP, (String) null);
        version.ui = AK.m3376(jSONObject, UI, (String) null);
        version.mdxlib = AK.m3376(jSONObject, MDXLIB, (String) null);
        version.mdxjs = AK.m3376(jSONObject, MDXJS, (String) null);
        version.os = AK.m3376(jSONObject, OS, (String) null);
        return version;
    }

    public String getMdxjs() {
        return this.mdxjs;
    }

    public String toString() {
        return "Version [app=" + this.app + ", ui=" + this.ui + ", mdxlib=" + this.mdxlib + ", mdxjs=" + this.mdxjs + "os=" + this.os + "]";
    }
}
