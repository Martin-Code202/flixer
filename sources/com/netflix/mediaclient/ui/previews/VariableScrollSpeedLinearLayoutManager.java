package com.netflix.mediaclient.ui.previews;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import o.C1456Fq;
import o.C1457Fr;
public final class VariableScrollSpeedLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final float f3825;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final If f3826;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f3827;

    public VariableScrollSpeedLinearLayoutManager(Context context, float f) {
        this(context, f, 0, false, 12, null);
    }

    public VariableScrollSpeedLinearLayoutManager(Context context, float f, int i) {
        this(context, f, i, false, 8, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VariableScrollSpeedLinearLayoutManager(Context context, float f, int i, boolean z) {
        super(context, i, z);
        C1457Fr.m5025(context, "context");
        this.f3827 = context;
        this.f3825 = f;
        this.f3826 = new If(this, this.f3827);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VariableScrollSpeedLinearLayoutManager(Context context, float f, int i, boolean z, int i2, C1456Fq fq) {
        this(context, f, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? false : z);
    }

    public static final class If extends LinearSmoothScroller {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ VariableScrollSpeedLinearLayoutManager f3828;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        If(VariableScrollSpeedLinearLayoutManager variableScrollSpeedLinearLayoutManager, Context context) {
            super(context);
            this.f3828 = variableScrollSpeedLinearLayoutManager;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            return this.f3828.computeScrollVectorForPosition(i);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            C1457Fr.m5025(displayMetrics, "displayMetrics");
            return super.calculateSpeedPerPixel(displayMetrics) * this.f3828.f3825;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        C1457Fr.m5025(recyclerView, "recyclerView");
        this.f3826.setTargetPosition(i);
        startSmoothScroll(this.f3826);
    }
}
