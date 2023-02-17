package com.netflix.android.widgetry.lolomo;

import android.content.Context;
import android.util.AttributeSet;
import com.netflix.android.widgetry.widget.TrackedLinearLayoutManager;
public class RowLinearLayoutManager extends TrackedLinearLayoutManager {

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f158 = "RowLinearLayoutManager";

    public RowLinearLayoutManager(Context context) {
        super(context);
    }

    public RowLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public RowLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
    /* renamed from: ˏ */
    public void mo105(String str) {
        this.f158 = str;
    }

    @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
    /* renamed from: ˊ */
    public String mo104() {
        return this.f158;
    }
}
