package o;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.AbsListView;
import com.netflix.mediaclient.R;
import o.AbstractC0801;
/* renamed from: o.Bz  reason: case insensitive filesystem */
public final class C1353Bz {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static final boolean m4153(pT pTVar) {
        return (pTVar == null || !pTVar.isOriginal() || pTVar.getDefaultTrailer() == null) ? false : true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static GridLayoutManager m4152(Context context, final AbstractC0801 r5) {
        final int integer = context.getResources().getInteger(R.integer.trailer_span_count);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, integer);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: o.Bz.1
            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (i == 0 || r5.m15330(i)) {
                    return integer;
                }
                return 1;
            }
        });
        return gridLayoutManager;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AbstractC0801.Cif m4154(final View view) {
        final int integer = view.getContext().getResources().getInteger(R.integer.trailer_span_count);
        return new AbstractC0801.Cif() { // from class: o.Bz.3

            /* renamed from: ˋ  reason: contains not printable characters */
            private int f4678;

            /* renamed from: ॱ  reason: contains not printable characters */
            private int f4680;

            {
                m4155();
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            private void m4155() {
                this.f4678 = view.getWidth() > 0 ? view.getWidth() : AD.m3317(view.getContext());
                this.f4678 /= integer;
                this.f4680 = (int) (((float) this.f4678) * 0.5625f);
            }

            @Override // o.AbstractC0801.Cif
            /* renamed from: ˏ  reason: contains not printable characters */
            public View mo4156(View view2) {
                uK uKVar = new uK(view2.getContext());
                uKVar.setLayoutParams(new AbsListView.LayoutParams(this.f4678, this.f4680));
                return uKVar;
            }
        };
    }
}
