package com.netflix.mediaclient.ui.lolomo;

import android.content.Intent;
import java.util.LinkedHashMap;
import java.util.Map;
import o.AbstractC0517;
import o.tJ;
public class GenreFragmentCreator$1 extends LinkedHashMap<Intent, AbstractC0517> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ tJ f3192;

    public GenreFragmentCreator$1(tJ tJVar) {
        this.f3192 = tJVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Map$Entry] */
    /* access modifiers changed from: protected */
    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<Intent, AbstractC0517> entry) {
        return size() > 1;
    }
}
