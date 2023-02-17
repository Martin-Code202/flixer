package com.netflix.android.widgetry.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.netflix.android.widgetry.widget.TrackedLayoutManager;
public abstract class TrackedGridLayoutManager extends GridLayoutManager implements TrackedLayoutManager {
    public TrackedGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public TrackedGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    public TrackedGridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            throw new TrackedLayoutManager.TrackedLayoutManagerException(e, mo104());
        }
    }
}
