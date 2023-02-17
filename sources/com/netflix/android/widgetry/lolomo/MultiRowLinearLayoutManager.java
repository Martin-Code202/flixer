package com.netflix.android.widgetry.lolomo;

import android.content.Context;
import android.util.AttributeSet;
import com.netflix.android.widgetry.widget.TrackedGridLayoutManager;
public class MultiRowLinearLayoutManager extends TrackedGridLayoutManager {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f157 = "MultiRowLinearLayoutManager";

    public MultiRowLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public MultiRowLinearLayoutManager(Context context, int i) {
        super(context, i);
    }

    public MultiRowLinearLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
    }

    @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo105(String str) {
        this.f157 = str;
    }

    @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo104() {
        return this.f157;
    }
}
