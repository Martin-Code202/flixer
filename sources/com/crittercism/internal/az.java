package com.crittercism.internal;

import com.crittercism.internal.av;
import com.crittercism.internal.bf;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.json.JSONArray;
public final class az<T extends bf> implements av<T> {
    private final SortedMap<String, T> a = new TreeMap();
    private final List<av.a> b = new LinkedList();
    private int c;

    public az(int i) {
        this.c = i;
    }

    @Override // com.crittercism.internal.av
    public final synchronized boolean a(T t) {
        if (this.a.size() >= this.c) {
            this.a.remove(this.a.firstKey());
        }
        this.a.put(t.f(), t);
        synchronized (this.b) {
            for (av.a aVar : this.b) {
                aVar.a();
            }
        }
        return true;
    }

    @Override // com.crittercism.internal.av
    public final void a(String str) {
        this.a.remove(str);
    }

    @Override // com.crittercism.internal.av
    public final JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        for (T t : b()) {
            jSONArray.put(t.g());
        }
        return jSONArray;
    }

    @Override // com.crittercism.internal.av
    public final List<T> b() {
        return new LinkedList(this.a.values());
    }

    @Override // com.crittercism.internal.av
    public final List<T> c() {
        return b();
    }

    @Override // com.crittercism.internal.av
    public final void a(List<T> list) {
        for (T t : list) {
            this.a.remove(t.f());
        }
    }

    @Override // com.crittercism.internal.av
    public final void a(av.a aVar) {
        synchronized (this.b) {
            this.b.add(aVar);
        }
    }
}
