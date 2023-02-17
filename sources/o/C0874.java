package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
/* renamed from: o.ᔫ  reason: contains not printable characters */
public class C0874 extends ListView {

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f14750 = true;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f14751;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f14752;

    public C0874(Context context) {
        super(context);
    }

    public C0874(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C0874(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f14750) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setAsStatic(boolean z) {
        if (this.f14750 != z) {
            this.f14750 = z;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (RuntimeException e) {
            throw new RuntimeException("SPY-11315 " + e.toString() + ": currentCount=" + (getAdapter() == null ? "null" : String.valueOf(getAdapter().getCount())) + ", lastNotifiedCount=" + this.f14752 + ", extraText=" + this.f14751, e);
        }
    }

    public void setLastNotifiedCount(int i, String str) {
        this.f14752 = i;
        this.f14751 = str;
    }
}
