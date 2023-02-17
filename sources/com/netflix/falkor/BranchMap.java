package com.netflix.falkor;

import java.util.HashMap;
import java.util.Map;
import o.AbstractC0730;
import o.AbstractC0989;
import o.AbstractC1264;
import o.C0855;
import o.C1049;
import o.C1128;
public class BranchMap<T> extends HashMap<String, T> implements AbstractC0730, AbstractC0989 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private Map<String, Object> f530;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0855<C1049> f531;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1264<T> f532;

    public BranchMap(AbstractC1264<T> r1) {
        this.f532 = r1;
    }

    @Override // o.AbstractC0730
    public Object get(String str) {
        Object obj = get((Object) str);
        if (obj != null || this.f530 == null) {
            return obj;
        }
        return this.f530.get(str);
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        if ((obj instanceof Exception) || (obj instanceof C1128)) {
            if (this.f530 == null) {
                this.f530 = new HashMap();
            }
            this.f530.put(str, obj);
            if (containsKey(str)) {
                super.remove((Object) str);
                return;
            }
            return;
        }
        put(str, obj);
        if (this.f530 != null && this.f530.containsKey(str)) {
            this.f530.remove(str);
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        super.remove((Object) str);
        if (this.f530 != null) {
            this.f530.remove(str);
        }
    }

    @Override // o.AbstractC0989
    public C0855<C1049> getReferences() {
        return this.f531;
    }

    @Override // o.AbstractC0989
    public void setReferences(C0855<C1049> r1) {
        this.f531 = r1;
    }

    @Override // o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        T r1 = this.f532.mo4186();
        put(str, r1);
        return r1;
    }
}
