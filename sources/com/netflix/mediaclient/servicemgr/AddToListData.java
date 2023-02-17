package com.netflix.mediaclient.servicemgr;

import java.util.HashSet;
import java.util.Set;
public class AddToListData {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Set<Cif> f2367 = new HashSet(2);

    /* renamed from: ˏ  reason: contains not printable characters */
    private AddToListState f2368 = AddToListState.NOT_IN_LIST;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AddToListState f2369 = AddToListState.NOT_IN_LIST;

    public enum AddToListState {
        IN_LIST,
        NOT_IN_LIST,
        LOADING
    }

    /* renamed from: com.netflix.mediaclient.servicemgr.AddToListData$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˏ  reason: contains not printable characters */
        void mo1480(AddToListState addToListState);
    }

    public AddToListData(Cif ifVar) {
        this.f2367.add(ifVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1477(Cif ifVar) {
        this.f2367.add(ifVar);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1479(Cif ifVar) {
        this.f2367.remove(ifVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public AddToListState m1476() {
        return this.f2368;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1475() {
        m1478(this.f2369);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1478(AddToListState addToListState) {
        if (this.f2368 != AddToListState.LOADING) {
            this.f2369 = this.f2368;
        }
        this.f2368 = addToListState;
        for (Cif ifVar : this.f2367) {
            ifVar.mo1480(addToListState);
        }
    }
}
