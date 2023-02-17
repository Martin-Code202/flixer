package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
public class tV extends C0843 implements AbstractC2220ut {
    public tV(Context context) {
        super(context);
    }

    public tV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public tV(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public LolomoRecyclerViewAdapter m11037() {
        if (getAdapter() instanceof LolomoRecyclerViewAdapter) {
            return (LolomoRecyclerViewAdapter) getAdapter();
        }
        return null;
    }

    @Override // o.AbstractC2220ut
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo11039(View view) {
        LolomoRecyclerViewAdapter r1;
        if (view == null || (r1 = m11037()) == null) {
            return false;
        }
        return r1.m15462(view);
    }

    @Override // o.AbstractC2220ut
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo11038(View view, Object obj, boolean z) {
        LolomoRecyclerViewAdapter r0;
        if (view != null && (r0 = m11037()) != null) {
            r0.m15472(view);
        }
    }
}
