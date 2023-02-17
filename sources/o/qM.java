package o;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.search.SearchUtils;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.ArrayList;
import java.util.List;
public class qM extends BaseAdapter {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f9487;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean f9488;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Activity f9489;

    /* renamed from: ˎ  reason: contains not printable characters */
    private List<AbstractC2084qe> f9490 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final GridView f9491;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC2087qh f9492;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f9493;

    public qM(Activity activity, GridView gridView, boolean z) {
        this.f9489 = activity;
        this.f9491 = gridView;
        this.f9488 = z;
        this.f9487 = SearchUtils.m2919(activity);
        gridView.setNumColumns(this.f9487);
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.qM.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                GridView gridView2 = qM.this.f9491;
                int width = (gridView2.getWidth() - gridView2.getPaddingLeft()) - gridView2.getPaddingRight();
                C1283.m16846("SearchSimilarItemsGridViewAdapter", "View dimens: " + width + ", " + gridView2.getHeight());
                qM.this.f9493 = (int) ((((double) (width / qM.this.f9487)) * SearchUtils.m2918()) + 0.5d);
                C1283.m16846("SearchSimilarItemsGridViewAdapter", "imgHeight: " + qM.this.f9493);
                ViewUtils.m3009(gridView2, this);
            }
        });
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9488 ? m9922(this.f9490.size()) : this.f9490.size();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public pJ getItem(int i) {
        return this.f9490.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            C1210 r6 = new C1210(this.f9489);
            int dimensionPixelOffset = this.f9489.getResources().getDimensionPixelOffset(R.dimen.lomo_item_padding);
            r6.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            r6.setLayoutParams(new AbsListView.LayoutParams(-1, this.f9493));
            r6.setAdjustViewBounds(true);
            r6.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view = r6;
        }
        C1210 r62 = (C1210) view;
        r62.setIsHorizontal(!SearchUtils.m2930());
        r62.mo2123(getItem(i), this.f9492, i, true, false);
        return view;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m9925(List<AbstractC2084qe> list, AbstractC2087qh qhVar) {
        this.f9490 = list;
        this.f9492 = qhVar;
        notifyDataSetChanged();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m9922(int i) {
        return (i / this.f9487) * this.f9487;
    }
}
