package o;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import o.AbstractC0801;
public class qS extends AbstractC0801 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f9544;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f9545;

    public qS(boolean z, int i, AbstractC0801.Cif ifVar) {
        super(ifVar);
        this.f9545 = z;
        this.f9544 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9950(RecyclerView recyclerView) {
        if (recyclerView != null) {
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt instanceof C1210) {
                    ((C1210) childAt).m14542();
                }
            }
        }
    }

    @Override // o.AbstractC0801, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9545 ? m9949() : super.getItemCount();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private int m9949() {
        if (m15312() == 1) {
            return m15326() + 1 + (m15324() ? 1 : 0);
        }
        return ((m15312() / this.f9544) * this.f9544) + m15326() + (m15324() ? 1 : 0);
    }
}
