package o;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import o.AbstractC0835;
/* renamed from: o.uh  reason: case insensitive filesystem */
public class C2208uh extends AbstractC0835.AbstractC2404iF {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static C2208uh m11704(ViewGroup viewGroup, int i) {
        C1105 r2 = new C1105(viewGroup.getContext());
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, C1004.m15954(viewGroup.getContext(), 10));
        int r4 = C1004.m15954(viewGroup.getContext(), 5);
        layoutParams.setMargins(0, r4, 0, r4);
        r2.setLayoutParams(layoutParams);
        r2.setProgressTint(i);
        return new C2208uh(r2);
    }

    private C2208uh(View view) {
        super(view);
    }
}
