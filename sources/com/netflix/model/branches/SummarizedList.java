package com.netflix.model.branches;

import com.netflix.falkor.BranchMap;
import o.AbstractC1264;
import o.C0855;
import o.C1049;
public class SummarizedList<T, L> extends BranchMap<T> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private L f4096;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0855<C1049> f4097;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1264<L> f4098;

    public SummarizedList(AbstractC1264<T> r1, AbstractC1264<L> r2) {
        super(r1);
        this.f4098 = r2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public L m3069() {
        return this.f4096;
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0989
    public C0855<C1049> getReferences() {
        return this.f4097;
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0989
    public void setReferences(C0855<C1049> r1) {
        this.f4097 = r1;
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object get(String str) {
        if ("summary".equals(str)) {
            return this.f4096;
        }
        return super.get(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void set(String str, Object obj) {
        if ("summary".equals(str)) {
            this.f4096 = obj;
        } else {
            super.set(str, obj);
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        if (!"summary".equals(str)) {
            return super.getOrCreate(str);
        }
        this.f4096 = this.f4098.mo4186();
        return this.f4096;
    }
}
