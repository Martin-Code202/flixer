package com.crittercism.internal;

import com.crittercism.internal.aw;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class at implements bf {
    public String a;
    String b;
    public int c;
    Object d;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class c extends Enum<c> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f = {a, b, c, d, e};
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class d extends Enum<d> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c = {a, b};
    }

    /* synthetic */ at(String str, String str2, int i, Object obj, byte b2) {
        this(str, str2, i, obj);
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class b extends Enum<b> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;
        private static final /* synthetic */ int[] i = {a, b, c, d, e, f, g, h};

        public static int[] a() {
            return (int[]) i.clone();
        }
    }

    public at(int i, Object obj) {
        this(be.a.a(), ci.a.a(), i, obj);
    }

    public at(Date date, int i, Object obj) {
        this(be.a.a(), ci.a.a(date), i, obj);
    }

    private at(String str, String str2, int i, Object obj) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = obj;
    }

    public static at a(Date date) {
        return new at(date, b.a, null);
    }

    public static at a(String str) {
        if (str.length() > 140) {
            str = str.substring(0, 140);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("text", str);
        hashMap.put("level", 0);
        return new at(b.b, new JSONObject(hashMap));
    }

    public static at a(int i, String str) {
        if (i != c.c) {
            int i2 = c.d;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("change", Integer.valueOf(i - 1));
        hashMap.put("type", str);
        return new at(b.e, new JSONObject(hashMap));
    }

    @Override // com.crittercism.internal.bf
    public final String f() {
        return this.a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONArray g() {
        JSONArray put = new JSONArray().put(this.b).put(this.c - 1);
        if (this.d != null) {
            put.put(this.d);
        }
        return put;
    }

    public static class a implements aw.b<at> {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* Return type fixed from 'com.crittercism.internal.bf' to match base method */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ at a(File file) {
            return b(file);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.crittercism.internal.bf, java.io.OutputStream] */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ void a(at atVar, OutputStream outputStream) {
            at atVar2 = atVar;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timestamp", atVar2.b);
                jSONObject.put("filename", atVar2.a);
                jSONObject.put("type", atVar2.c - 1);
                jSONObject.put("payload", atVar2.d);
                outputStream.write(jSONObject.toString().getBytes());
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }

        private static at b(File file) {
            try {
                JSONObject jSONObject = new JSONObject(cg.b(file));
                return new at(jSONObject.getString("filename"), jSONObject.getString("timestamp"), b.a()[jSONObject.getInt("type")], jSONObject.has("payload") ? jSONObject.get("payload") : null, (byte) 0);
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            } catch (IndexOutOfBoundsException e2) {
                throw new IOException(e2.getMessage());
            }
        }
    }

    public final String toString() {
        try {
            return g().toString(4);
        } catch (JSONException e) {
            return e.toString();
        }
    }
}
