package o;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
public class AL extends RecyclerView.ItemDecoration {

    /* renamed from: ˋ  reason: contains not printable characters */
    protected int f4284;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected int f4285;

    public AL(int i, int i2) {
        this.f4284 = i;
        this.f4285 = i2;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (!(recyclerView.getAdapter() instanceof AbstractC0801) || !((AbstractC0801) recyclerView.getAdapter()).m15325(view, recyclerView)) {
            rect.left = this.f4284 / 2;
            rect.right = this.f4284 / 2;
            rect.top = this.f4284 / 2;
            rect.bottom = this.f4284 / 2;
        }
    }
}
