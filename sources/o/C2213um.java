package o;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import java.util.Locale;
import o.AbstractC0835;
/* renamed from: o.um  reason: case insensitive filesystem */
public class C2213um extends AbstractC0835.AbstractC2404iF {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static C2213um m11713(ViewGroup viewGroup) {
        Space space = new Space(viewGroup.getContext());
        space.setLayoutParams(new RecyclerView.LayoutParams(-1, C1004.m15954(viewGroup.getContext(), 1)));
        return new C2213um(space);
    }

    private C2213um(View view) {
        super(view);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11714(pC pCVar) {
        if (pCVar == null) {
            C1276.m16820().mo5725("Unknown view type, got null lomo");
        } else {
            C1276.m16820().mo5725(String.format(Locale.US, "Unknown view type, got type=%s, class=%s", pCVar.getType(), pCVar.getClass().getName()));
        }
    }
}
