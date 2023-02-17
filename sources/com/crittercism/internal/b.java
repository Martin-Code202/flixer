package com.crittercism.internal;

import android.os.Build;
import com.crittercism.internal.aw;
import com.crittercism.internal.f;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class b implements bf {
    public long a = Long.MAX_VALUE;
    long b = Long.MAX_VALUE;
    boolean c = false;
    String d = be.a.a();
    float e = 1.0f;
    c f = c.NOT_LOGGED_YET;
    long g = 0;
    public long h = 0;
    public int i = 0;
    public String j = "";
    public bj k = new bj(null);
    double[] l;
    public f m = new f();
    public String n;

    /* renamed from: o  reason: collision with root package name */
    public a f16013o = a.MOBILE;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;

    public enum c {
        NOT_LOGGED_YET("Not logged"),
        INPUT_STREAM_READ("InputStream.read()"),
        INPUT_STREAM_CLOSE("InputStream.close()"),
        SOCKET_CLOSE("Socket.close()"),
        LEGACY_JAVANET("Legacy java.net"),
        HTTP_CONTENT_LENGTH_PARSER("parse()"),
        INPUT_STREAM_FINISHED("finishedMessage()"),
        PARSING_INPUT_STREAM_LOG_ERROR("logError()"),
        SOCKET_IMPL_CONNECT("MonitoredSocketImpl.connect()"),
        SSL_SOCKET_START_HANDSHAKE("MonitoredSSLSocketKK.startHandshake"),
        UNIT_TEST("Unit test"),
        LOG_ENDPOINT("logEndpoint"),
        WEBVIEW_CLIENT_ON_PAGE_FINISHED("onPageFinished"),
        WEBVIEW_CLIENT_ON_RECEIVED_ERROR("onReceivedError");
        

        /* renamed from: o  reason: collision with root package name */
        private String f16014o;

        private c(String str) {
            this.f16014o = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public final String toString() {
            return this.f16014o;
        }
    }

    public final String a() {
        String str = this.n;
        if (str == null) {
            f fVar = this.m;
            String str2 = "unknown-host";
            if (fVar.b != null) {
                str2 = fVar.b;
            } else if (fVar.a != null) {
                str2 = fVar.a.getHostName();
            }
            if (fVar.f) {
                int i2 = fVar.e;
                if (i2 > 0) {
                    String str3 = ":" + i2;
                    if (!str2.endsWith(str3)) {
                        str = str2 + str3;
                    }
                }
                str = str2;
            } else {
                String str4 = fVar.c;
                String str5 = "";
                if (str4 != null && (str4.regionMatches(true, 0, "http:", 0, 5) || str4.regionMatches(true, 0, "https:", 0, 6))) {
                    str = str4;
                } else {
                    if (fVar.d != null) {
                        str5 = str5 + f.a.a(fVar.d) + ":";
                    }
                    if (str4.startsWith("//")) {
                        str = str5 + str4;
                    } else {
                        String str6 = str5 + "//";
                        if (str4.startsWith(str2)) {
                            str = str6 + str4;
                        } else {
                            String str7 = "";
                            if (fVar.e > 0 && (fVar.d == null || f.a.b(fVar.d) != fVar.e)) {
                                String str8 = ":" + fVar.e;
                                if (!str2.endsWith(str8)) {
                                    str7 = str8;
                                }
                            }
                            str = str6 + str2 + str7 + str4;
                        }
                    }
                }
            }
            this.n = str;
        }
        return str;
    }

    public final long b() {
        if (this.a == Long.MAX_VALUE || this.b == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return this.b - this.a;
    }

    public final String toString() {
        String str = ((((((((((((((("URI            : " + this.n + "\n") + "URI Builder    : " + this.m.toString() + "\n") + "\n") + "Logged by      : " + this.f.toString() + "\n") + "Error type:         : " + this.k.a + "\n") + "Error code:         : " + this.k.b + "\n") + "\n") + "Response time  : " + b() + "\n") + "Start time     : " + this.a + "\n") + "End time       : " + this.b + "\n") + "\n") + "Bytes out    : " + this.h + "\n") + "Bytes in     : " + this.g + "\n") + "\n") + "Response code  : " + this.i + "\n") + "Request method : " + this.j + "\n";
        if (this.l != null) {
            return str + "Location       : " + Arrays.toString(this.l) + "\n";
        }
        return str;
    }

    /* renamed from: e */
    public final JSONArray g() {
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(this.j);
            jSONArray.put(a());
            jSONArray.put(ci.a.a(new Date(this.a)));
            jSONArray.put(b());
            jSONArray.put(this.f16013o.e);
            jSONArray.put(this.g);
            jSONArray.put(this.h);
            jSONArray.put(this.i);
            jSONArray.put(this.k.a);
            jSONArray.put(this.k.b);
            if (this.l == null) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(this.l[0]);
            jSONArray2.put(this.l[1]);
            jSONArray.put(jSONArray2);
            return jSONArray;
        } catch (Exception e2) {
            System.out.println("Failed to create statsArray");
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.crittercism.internal.bf
    public final String f() {
        return this.d;
    }

    /* renamed from: com.crittercism.internal.b$b  reason: collision with other inner class name */
    public static class C0002b implements aw.b<b> {
        private C0002b() {
        }

        public /* synthetic */ C0002b(byte b) {
            this();
        }

        /* Return type fixed from 'com.crittercism.internal.bf' to match base method */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ b a(File file) {
            return b(file);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.crittercism.internal.bf, java.io.OutputStream] */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ void a(b bVar, OutputStream outputStream) {
            b bVar2 = bVar;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("Sequence Number", bVar2.d).put("rate", (double) bVar2.e).put("Request Method", bVar2.j).put("Uri", bVar2.a()).put("Time Stamp", ci.a.a(new Date(bVar2.a))).put("Response Time", bVar2.b()).put("Network Status", bVar2.f16013o.e).put("Bytes In", bVar2.g).put("Bytes Out", bVar2.h).put("Return Code", bVar2.i).put("Error Type", bVar2.k.a).put("Error Code", bVar2.k.b);
                if (bVar2.l != null) {
                    JSONArray jSONArray = new JSONArray();
                    if (bVar2.l.length == 2) {
                        jSONArray.put(bVar2.l[0]);
                        jSONArray.put(bVar2.l[1]);
                        jSONObject.put("Location", jSONArray);
                    }
                }
                outputStream.write(jSONObject.toString().getBytes());
            } catch (JSONException unused) {
                throw new IOException("Bad values pased to write to stream");
            }
        }

        private static b b(File file) {
            String b = cg.b(file);
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(b);
                bVar.d = jSONObject.getString("Sequence Number");
                bVar.j = jSONObject.getString("Request Method");
                bVar.n = jSONObject.getString("Uri");
                bVar.a = ci.a.a(jSONObject.getString("Time Stamp"));
                bVar.b = bVar.a + jSONObject.getLong("Response Time");
                bVar.f16013o = a.a(jSONObject.getInt("Network Status"));
                bVar.g = jSONObject.getLong("Bytes In");
                bVar.h = jSONObject.getLong("Bytes Out");
                bVar.i = jSONObject.getInt("Return Code");
                bVar.k = new bj(jSONObject.getInt("Error Type"), jSONObject.getInt("Error Code"));
                if (jSONObject.has("Location")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("Location");
                    bVar.l = new double[]{jSONArray.getDouble(0), jSONArray.getDouble(1)};
                }
                bVar.e = (float) jSONObject.getDouble("rate");
                return bVar;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            } catch (ParseException e2) {
                throw new IOException(e2.getMessage());
            }
        }
    }

    public static class a extends bx {
        public a(au auVar) {
            super(auVar);
        }

        @Override // com.crittercism.internal.bx
        public final bt a(as asVar, List<? extends bf> list) {
            if (list.size() == 0) {
                throw new IOException("No events provided");
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(this.a.e);
            jSONArray2.put(this.a.a.a);
            jSONArray2.put(this.a.h());
            jSONArray2.put("5.8.7");
            jSONArray2.put(this.a.f.b.getInt("sessionIDSetting", 0));
            jSONArray.put(jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(ci.a.a());
            jSONArray3.put(this.a.b());
            jSONArray3.put(Build.MODEL);
            jSONArray3.put("Android");
            jSONArray3.put(Build.VERSION.RELEASE);
            jSONArray3.put(this.a.c());
            jSONArray3.put(this.a.d());
            jSONArray.put(jSONArray3);
            JSONArray jSONArray4 = new JSONArray();
            for (bf bfVar : list) {
                jSONArray4.put(((b) bfVar).g());
            }
            jSONArray.put(jSONArray4);
            try {
                jSONObject.put("d", jSONArray);
                return bt.a(new URL(asVar.a, "/api/apm/network"), jSONObject, this.b);
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
