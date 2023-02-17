package com.crittercism.internal;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.view.Display;
import android.view.WindowManager;
import com.crittercism.internal.aw;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class aq implements bf {
    public long a;
    JSONArray b;
    JSONArray c;
    public String d;
    public String e;
    JSONArray f;
    public JSONArray g;
    public String h;
    JSONObject i;
    int j;
    boolean k;
    String l;
    public float m;

    /* synthetic */ aq(byte b2) {
        this();
    }

    @Override // com.crittercism.internal.bf
    public final /* synthetic */ Object g() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_state", this.i);
        hashMap.put("platform", "android");
        hashMap.put("ts", this.h);
        hashMap.put("rate", Float.valueOf(this.m));
        hashMap.put("exception_name", this.d);
        hashMap.put("exception_reason", this.e);
        if (!this.k) {
            hashMap.put("suspect_line_index", Integer.valueOf(this.j));
        }
        hashMap.put("unsymbolized_stacktrace", this.f);
        hashMap.put("current_thread_id", Long.valueOf(this.a));
        if (this.g != null) {
            hashMap.put("threads", this.g);
        }
        hashMap.put("systemBreadcrumbs", this.b);
        if (this.c != null && this.c.length() > 0) {
            hashMap.put("transactions", this.c);
        }
        return new JSONObject(hashMap);
    }

    public aq(Throwable th, au auVar, long j2) {
        Double d2;
        JSONArray jSONArray;
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.e = "";
        this.f = new JSONArray();
        this.h = ci.a.a();
        this.j = -1;
        this.k = false;
        this.l = be.a.a();
        this.m = 1.0f;
        this.k = th instanceof bm;
        this.l = be.a.a();
        this.i = new JSONObject();
        try {
            JSONObject putOpt = this.i.putOpt("activity", auVar.g).putOpt("app_version", auVar.a.a).putOpt("app_version_code", auVar.a()).putOpt("arch", System.getProperty("os.arch"));
            Intent registerReceiver = auVar.b.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                Double valueOf = Double.valueOf(1.0d);
                int intExtra = registerReceiver.getIntExtra("level", -1);
                double intExtra2 = (double) registerReceiver.getIntExtra("scale", -1);
                if (intExtra >= 0 && intExtra2 > 0.0d) {
                    valueOf = Double.valueOf(((double) intExtra) / intExtra2);
                }
                d2 = valueOf;
            } else {
                d2 = null;
            }
            JSONObject putOpt2 = putOpt.putOpt("battery_level", d2).putOpt("carrier", auVar.b()).putOpt("mobile_country_code", auVar.c()).putOpt("mobile_network_code", auVar.d()).putOpt("disk_space_free", auVar.j()).putOpt("disk_space_total", auVar.k()).putOpt("dpi", auVar.e()).putOpt("xdpi", Float.valueOf(auVar.f())).putOpt("ydpi", Float.valueOf(auVar.g())).putOpt(LoggingRequest.LOCALE, auVar.i());
            if (auVar.c.a) {
                jSONArray = auVar.d.a();
            } else {
                jSONArray = null;
            }
            JSONObject putOpt3 = putOpt2.putOpt("logcat", jSONArray);
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            JSONObject putOpt4 = putOpt3.putOpt("memory_usage", Integer.valueOf((memoryInfo.dalvikPss + memoryInfo.nativePss + memoryInfo.otherPss) * 1024)).putOpt("memory_total", au.l()).putOpt("mobile_network", auVar.a(0)).putOpt(Device.MODEL, Build.MODEL).putOpt("name", new String());
            int i2 = auVar.b.getResources().getConfiguration().orientation;
            int i3 = i2;
            if (i2 == 0) {
                Display defaultDisplay = ((WindowManager) auVar.b.getSystemService("window")).getDefaultDisplay();
                if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
                    i3 = 3;
                } else if (defaultDisplay.getWidth() > defaultDisplay.getHeight()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
            }
            putOpt4.putOpt("orientation", Integer.valueOf(i3)).putOpt("sd_space_free", auVar.m()).putOpt("sd_space_total", auVar.n()).putOpt("platform", "android").putOpt("development_platform", auVar.h).putOpt("system", "Android").putOpt("system_version", Build.VERSION.RELEASE).putOpt("wifi", auVar.a(1));
        } catch (JSONException unused) {
        }
        this.b = new JSONArray();
        this.a = j2;
        this.d = a(th);
        if (th.getMessage() != null) {
            this.e = th.getMessage();
        }
        if (!this.k) {
            this.j = c(th);
        }
        for (String str : b(th)) {
            this.f.put(str);
        }
    }

    private aq() {
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.e = "";
        this.f = new JSONArray();
        this.h = ci.a.a();
        this.j = -1;
        this.k = false;
        this.l = be.a.a();
        this.m = 1.0f;
    }

    public final void a(av<at> avVar) {
        this.b = avVar.a();
    }

    public final void a(Collection<cc> collection) {
        this.c = new JSONArray();
        for (cc ccVar : collection) {
            this.c.put(ccVar.g());
        }
    }

    private String a(Throwable th) {
        String name;
        if (this.k) {
            return ((bm) th).a;
        }
        do {
            name = th.getClass().getName();
            th = th.getCause();
            if (th == null) {
                break;
            }
        } while (th != th);
        return name;
    }

    private static String[] b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        do {
            th.printStackTrace(printWriter);
            th = th.getCause();
            if (th == null) {
                break;
            }
        } while (th != th);
        return stringWriter.toString().split("\n");
    }

    private static int c(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            try {
                Class<?> cls = Class.forName(stackTrace[i2].getClassName());
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                boolean z = false;
                while (true) {
                    if (systemClassLoader == null) {
                        break;
                    } else if (cls.getClassLoader() == systemClassLoader) {
                        z = true;
                        break;
                    } else {
                        systemClassLoader = systemClassLoader.getParent();
                    }
                }
                if (!z) {
                    return i2 + 1;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        return -1;
    }

    @Override // com.crittercism.internal.bf
    public final String f() {
        return this.l;
    }

    public static class a implements aw.b<aq> {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* Return type fixed from 'com.crittercism.internal.bf' to match base method */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ aq a(File file) {
            return b(file);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.crittercism.internal.bf, java.io.OutputStream] */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ void a(aq aqVar, OutputStream outputStream) {
            aq aqVar2 = aqVar;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("currentThreadID", aqVar2.a);
                jSONObject.put("breadcrumbs", aqVar2.b);
                jSONObject.put("txns", aqVar2.c);
                jSONObject.put("exceptionName", aqVar2.d);
                jSONObject.put("exceptionReason", aqVar2.e);
                jSONObject.put("stacktrace", aqVar2.f);
                jSONObject.put("threads", aqVar2.g);
                jSONObject.put("ts", aqVar2.h);
                jSONObject.put("rate", (double) aqVar2.m);
                jSONObject.put("appState", aqVar2.i);
                jSONObject.put("suspectLineIndex", aqVar2.j);
                jSONObject.put("isPluginException", aqVar2.k);
                jSONObject.put("fileName", aqVar2.l);
                outputStream.write(jSONObject.toString().getBytes());
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }

        private static aq b(File file) {
            try {
                JSONObject jSONObject = new JSONObject(cg.b(file));
                aq aqVar = new aq((byte) 0);
                aqVar.a = jSONObject.getLong("currentThreadID");
                aqVar.b = jSONObject.getJSONArray("breadcrumbs");
                aqVar.c = jSONObject.getJSONArray("txns");
                aqVar.d = jSONObject.getString("exceptionName");
                aqVar.e = jSONObject.getString("exceptionReason");
                aqVar.f = jSONObject.getJSONArray("stacktrace");
                aqVar.g = jSONObject.optJSONArray("threads");
                aqVar.h = jSONObject.getString("ts");
                aqVar.m = (float) jSONObject.getDouble("rate");
                aqVar.i = jSONObject.getJSONObject("appState");
                aqVar.j = jSONObject.getInt("suspectLineIndex");
                aqVar.k = jSONObject.getBoolean("isPluginException");
                aqVar.l = jSONObject.getString("fileName");
                return aqVar;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public static class b extends bx {
        private String c;
        private String d;

        public b(au auVar, String str, String str2) {
            super(auVar);
            this.c = str;
            this.d = str2;
        }

        @Override // com.crittercism.internal.bx
        public final bt a(as asVar, List<? extends bf> list) {
            URL url = new URL(asVar.b, this.d);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", this.a.e);
                jSONObject.put("hashed_device_id", this.a.h());
                jSONObject.put("library_version", "5.8.7");
                JSONArray jSONArray = new JSONArray();
                for (bf bfVar : list) {
                    jSONArray.put(bfVar.g());
                }
                jSONObject.put(this.c, jSONArray);
                return bt.a(url, jSONObject, this.b);
            } catch (JSONException e) {
                throw ((IOException) new IOException(e.getMessage()).initCause(e));
            }
        }
    }
}
