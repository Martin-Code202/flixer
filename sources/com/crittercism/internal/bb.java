package com.crittercism.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.crittercism.internal.av;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class bb implements av<ba> {
    private SharedPreferences a;
    private final List<av.a> b = new LinkedList();

    public bb(Context context, String str) {
        this.a = context.getSharedPreferences("com.crittercism." + str + ".usermetadata.v2", 0);
    }

    private boolean d() {
        return this.a.getBoolean("dirty", false);
    }

    private boolean e() {
        String str = null;
        long j = Long.MAX_VALUE;
        for (String str2 : this.a.getAll().keySet()) {
            if (str2.startsWith("__timestamp_") && (str == null || j > this.a.getLong(str2, j))) {
                str = str2;
                j = this.a.getLong(str2, j);
            }
        }
        if (str == null) {
            return false;
        }
        return this.a.edit().remove(str).remove(str.substring(12)).commit();
    }

    /* access modifiers changed from: private */
    public boolean a(ba baVar) {
        String string = this.a.getString(baVar.a, null);
        String str = baVar.a;
        String str2 = "__timestamp_" + baVar.a;
        if (baVar.b.equals(string)) {
            this.a.edit().putLong(str2, System.nanoTime()).commit();
            return true;
        } else if ((this.a.getAll().size() - 1) / 2 >= 25 && !this.a.contains(baVar.a) && !e()) {
            return false;
        } else {
            boolean commit = this.a.edit().putString(str, baVar.b).putLong(str2, System.nanoTime()).putBoolean("dirty", true).commit();
            if (commit) {
                for (av.a aVar : this.b) {
                    aVar.a();
                }
            }
            return commit;
        }
    }

    public final boolean a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        boolean z = true;
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                z = a(new ba(next, jSONObject.get(next).toString())) & z;
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    @Override // com.crittercism.internal.av
    public final void a(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // com.crittercism.internal.av
    public final JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        Iterator<ba> it = b().iterator();
        if (!it.hasNext()) {
            return jSONArray;
        }
        it.next();
        throw new UnsupportedOperationException();
    }

    @Override // com.crittercism.internal.av
    public final List<ba> b() {
        Map<String, ?> all = this.a.getAll();
        LinkedList linkedList = new LinkedList();
        for (String str : all.keySet()) {
            if (!str.startsWith("__timestamp_") && !str.equals("dirty")) {
                linkedList.add(new ba(str, (String) all.get(str)));
            }
        }
        return linkedList;
    }

    @Override // com.crittercism.internal.av
    public final List<ba> c() {
        if (d()) {
            return b();
        }
        return new LinkedList();
    }

    @Override // com.crittercism.internal.av
    public final void a(av.a aVar) {
        synchronized (this.b) {
            this.b.add(aVar);
        }
        if (d()) {
            aVar.a();
        }
    }

    @Override // com.crittercism.internal.av
    public final void a(List<ba> list) {
        this.a.edit().putBoolean("dirty", false).commit();
    }
}
