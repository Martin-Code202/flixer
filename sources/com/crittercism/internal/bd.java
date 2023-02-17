package com.crittercism.internal;

import com.crittercism.internal.av;
import com.crittercism.internal.bf;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
public final class bd<T extends bf> implements av<T> {
    @Override // com.crittercism.internal.av
    public final boolean a(T t) {
        return true;
    }

    @Override // com.crittercism.internal.av
    public final void a(String str) {
    }

    @Override // com.crittercism.internal.av
    public final JSONArray a() {
        return new JSONArray();
    }

    @Override // com.crittercism.internal.av
    public final List<T> b() {
        return new LinkedList();
    }

    @Override // com.crittercism.internal.av
    public final List<T> c() {
        return new LinkedList();
    }

    @Override // com.crittercism.internal.av
    public final void a(av.a aVar) {
    }

    @Override // com.crittercism.internal.av
    public final void a(List<T> list) {
    }
}
