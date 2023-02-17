package com.netflix.mediaclient.ui.history;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import o.C1457Fr;
import o.CH;
public final class WatchHistoryViewModel extends AndroidViewModel {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final MutableLiveData<List<CH>> f3159 = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WatchHistoryViewModel(Application application) {
        super(application);
        C1457Fr.m5025(application, "application");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final MutableLiveData<List<CH>> m1965() {
        return this.f3159;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1966(List<? extends CH> list) {
        this.f3159.postValue(list);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m1967(List<? extends CH> list) {
        if (list != null && (this.f3159.getValue() instanceof ArrayList)) {
            List<CH> value = this.f3159.getValue();
            if (value == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<com.netflix.model.branches.FalkorVideo>");
            }
            ((ArrayList) value).addAll(list);
            this.f3159.postValue(this.f3159.getValue());
        }
    }
}
