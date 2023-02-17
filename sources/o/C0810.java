package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
/* renamed from: o.ᒺ  reason: contains not printable characters */
public class C0810 extends GridView {
    public C0810(Context context) {
        super(context);
    }

    public C0810(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C0810(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }
}
