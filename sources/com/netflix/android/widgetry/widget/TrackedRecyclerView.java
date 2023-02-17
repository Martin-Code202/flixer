package com.netflix.android.widgetry.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.Locale;
public abstract class TrackedRecyclerView extends RecyclerView {

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f163 = 0;

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract String mo110();

    public TrackedRecyclerView(Context context) {
        super(context);
    }

    public TrackedRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TrackedRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
            this.f163 = m108(getAdapter());
        } catch (IndexOutOfBoundsException e) {
            throw new RowRecyclerException(e, mo110(), this.f163, getAdapter());
        }
    }

    static class RowRecyclerException extends RuntimeException {
        private RowRecyclerException(IndexOutOfBoundsException indexOutOfBoundsException, String str, int i, RecyclerView.Adapter adapter) {
            super(String.format(Locale.US, "%s in %s, last layout count: %s, current count %s", indexOutOfBoundsException.getMessage(), str, Integer.valueOf(i), Integer.valueOf(TrackedRecyclerView.m108(adapter))), indexOutOfBoundsException);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m108(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
