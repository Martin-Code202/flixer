package com.netflix.android.widgetry.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.netflix.android.widgetry.widget.TrackedLayoutManager;
public abstract class TrackedLinearLayoutManager extends LinearLayoutManager implements TrackedLayoutManager {
    public TrackedLinearLayoutManager(Context context) {
        super(context);
    }

    public TrackedLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public TrackedLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            throw new TrackedLayoutManager.TrackedLayoutManagerException(e, mo104());
        }
    }
}
