package com.crittercism.internal;

import android.os.Build;
import android.util.Base64;
import com.crittercism.internal.aw;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class bc implements bf {
    JSONObject a;
    JSONArray b;
    String c;
    String d;
    String e;
    public float f;

    /* synthetic */ bc(byte b2) {
        this();
    }

    @Override // com.crittercism.internal.bf
    public final /* synthetic */ Object g() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_state", this.a);
        hashMap.put("rate", Float.valueOf(this.f));
        hashMap.put("breadcrumbs", new JSONObject());
        hashMap.put("endpoints", new JSONArray());
        hashMap.put("systemBreadcrumbs", this.b);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("dmp_name", this.c);
        hashMap2.put("dmp_file", this.d);
        hashMap.put("ndk_dmp_info", new JSONObject(hashMap2));
        return new JSONObject(hashMap);
    }

    private bc(File file, av<at> avVar, au auVar) {
        this.f = 1.0f;
        this.e = be.a.a();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[((int) randomAccessFile.length())];
        randomAccessFile.read(bArr);
        this.d = new String(Base64.encode(bArr, 0));
        this.c = file.getName();
        this.a = new JSONObject();
        try {
            this.a.putOpt("app_version", auVar.a.a).putOpt("app_version_code", auVar.a()).putOpt("arch", System.getProperty("os.arch")).putOpt("carrier", auVar.b()).putOpt("mobile_country_code", auVar.c()).putOpt("mobile_network_code", auVar.d()).putOpt("disk_space_total", auVar.k()).putOpt("dpi", auVar.e()).putOpt("xdpi", Float.valueOf(auVar.f())).putOpt("ydpi", Float.valueOf(auVar.g())).putOpt(LoggingRequest.LOCALE, auVar.i()).putOpt(Device.MODEL, Build.MODEL).putOpt("memory_total", au.l()).putOpt("name", new String()).putOpt("platform", "android").putOpt("development_platform", auVar.h).putOpt("system", "Android").putOpt("system_version", Build.VERSION.RELEASE);
        } catch (JSONException unused) {
        }
        this.b = avVar.a();
    }

    private bc() {
        this.f = 1.0f;
    }

    public static bc a(File file, av<at> avVar, au auVar) {
        File[] listFiles;
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return null;
        }
        bc bcVar = null;
        if (listFiles.length == 1) {
            File file2 = listFiles[0];
            if (file2.isFile()) {
                try {
                    bcVar = new bc(file2, avVar, auVar);
                } catch (ThreadDeath e2) {
                    throw e2;
                } catch (Throwable unused) {
                }
            }
        }
        for (File file3 : listFiles) {
            cg.a(file3);
        }
        return bcVar;
    }

    @Override // com.crittercism.internal.bf
    public final String f() {
        return this.e;
    }

    public static class b implements aw.b<bc> {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        /* Return type fixed from 'com.crittercism.internal.bf' to match base method */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ bc a(File file) {
            return b(file);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.crittercism.internal.bf, java.io.OutputStream] */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ void a(bc bcVar, OutputStream outputStream) {
            bc bcVar2 = bcVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appState", bcVar2.a);
                jSONObject.put("breadcrumbs", bcVar2.b);
                jSONObject.put("crashDumpFileName", bcVar2.c);
                jSONObject.put("base64EncodedCrash", bcVar2.d);
                jSONObject.put("fileName", bcVar2.e);
                jSONObject.put("rate", (double) bcVar2.f);
                outputStream.write(jSONObject.toString().getBytes());
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }

        private static bc b(File file) {
            try {
                JSONObject jSONObject = new JSONObject(cg.b(file));
                bc bcVar = new bc((byte) 0);
                bcVar.a = jSONObject.getJSONObject("appState");
                bcVar.b = jSONObject.getJSONArray("breadcrumbs");
                bcVar.c = jSONObject.getString("crashDumpFileName");
                bcVar.d = jSONObject.getString("base64EncodedCrash");
                bcVar.e = jSONObject.getString("fileName");
                bcVar.f = (float) jSONObject.getDouble("rate");
                return bcVar;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public static class a extends bx {
        public a(au auVar) {
            super(auVar);
        }

        @Override // com.crittercism.internal.bx
        public final bt a(as asVar, List<? extends bf> list) {
            URL url = new URL(asVar.b, "/android_v2/handle_ndk_crashes");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", this.a.e);
                jSONObject.put("hashed_device_id", this.a.h());
                jSONObject.put("library_version", "5.8.7");
                JSONArray jSONArray = new JSONArray();
                for (bf bfVar : list) {
                    jSONArray.put(bfVar.g());
                }
                jSONObject.put("crashes", jSONArray);
                return bt.a(url, jSONObject, this.b);
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
