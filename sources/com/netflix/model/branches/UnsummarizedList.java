package com.netflix.model.branches;

import com.netflix.falkor.BranchMap;
import o.AbstractC1264;
import o.C0855;
import o.C1049;
public class UnsummarizedList<T> extends BranchMap<T> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private C0855<C1049> f4099;

    public UnsummarizedList(AbstractC1264<T> r1) {
        super(r1);
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0989
    public C0855<C1049> getReferences() {
        return this.f4099;
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0989
    public void setReferences(C0855<C1049> r1) {
        this.f4099 = r1;
    }
}
