package android.support.v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
public class UnPressableLinearLayout extends LinearLayout {
    public UnPressableLinearLayout(Context context) {
        this(context, null);
    }

    public UnPressableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSetPressed(boolean z) {
    }
}
