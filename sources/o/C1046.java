package o;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
/* renamed from: o.⁔  reason: contains not printable characters */
public class C1046 extends LinearSnapHelper {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f15164;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f15165;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f15166;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final iF f15167;

    /* renamed from: ˋ  reason: contains not printable characters */
    private OrientationHelper f15168;

    /* renamed from: ˎ  reason: contains not printable characters */
    private RecyclerView f15169;

    /* renamed from: ˏ  reason: contains not printable characters */
    private OrientationHelper f15170;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f15171;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private RecyclerView.OnScrollListener f15172;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f15173;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f15174;

    /* renamed from: o.⁔$iF */
    public interface iF {
        /* renamed from: ˋ */
        void mo1888(int i);
    }

    public C1046(int i) {
        this(i, null);
    }

    public C1046(int i, iF iFVar) {
        this.f15173 = 0;
        this.f15172 = new RecyclerView.OnScrollListener() { // from class: o.⁔.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                int findFirstVisibleItemPosition;
                int r1;
                super.onScrollStateChanged(recyclerView, i2);
                if (!(C1046.this.f15167 == null || i2 != 0 || (r1 = C1046.this.m16062(recyclerView)) == -1)) {
                    C1046.this.f15167.mo1888(r1);
                }
                if (i2 == 1 && (findFirstVisibleItemPosition = ((LinearLayoutManager) C1046.this.f15169.getLayoutManager()).findFirstVisibleItemPosition()) != -1) {
                    C1046.this.f15173 = findFirstVisibleItemPosition;
                }
            }
        };
        if (i == 8388611 || i == 8388613 || i == 80 || i == 48 || i == 17) {
            this.f15167 = iFVar;
            this.f15171 = i;
            return;
        }
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
    }

    @Override // android.support.v7.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) {
        m16072(recyclerView, 40, 1, 2, 1);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16072(RecyclerView recyclerView, int i, int i2, int i3, int i4) {
        this.f15169 = recyclerView;
        if (this.f15169 != null) {
            this.f15169.addOnScrollListener(this.f15172);
            this.f15164 = i;
            this.f15166 = i2;
            this.f15174 = i3;
            this.f15165 = i4;
        }
        super.attachToRecyclerView(this.f15169);
    }

    @Override // android.support.v7.widget.LinearSnapHelper, android.support.v7.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (!layoutManager.canScrollHorizontally()) {
            iArr[0] = 0;
        } else if (this.f15171 == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        } else {
            if (this.f15171 == 8388611) {
                iArr[0] = m16068(view, m16058(layoutManager), false);
            } else {
                iArr[0] = m16066(view, m16058(layoutManager), false);
            }
        }
        if (!layoutManager.canScrollVertically()) {
            iArr[1] = 0;
        } else if (this.f15171 == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        } else {
            if (this.f15171 == 48) {
                iArr[1] = m16068(view, m16063(layoutManager), false);
            } else {
                iArr[1] = m16066(view, m16063(layoutManager), false);
            }
        }
        return iArr;
    }

    @Override // android.support.v7.widget.LinearSnapHelper, android.support.v7.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return null;
        }
        switch (this.f15171) {
            case 17:
                return super.findSnapView(layoutManager);
            case 48:
                return m16059(layoutManager, m16063(layoutManager));
            case 80:
                return m16071(layoutManager, m16063(layoutManager));
            case 8388611:
                return m16059(layoutManager, m16058(layoutManager));
            case 8388613:
                return m16071(layoutManager, m16058(layoutManager));
            default:
                return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m16068(View view, OrientationHelper orientationHelper, boolean z) {
        if (!m16065(view) || z) {
            return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
        }
        return m16066(view, orientationHelper, true);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m16065(View view) {
        return view.getLayoutDirection() == 1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private int m16066(View view, OrientationHelper orientationHelper, boolean z) {
        if (!m16065(view) || z) {
            return orientationHelper.getDecoratedEnd(view) - orientationHelper.getEndAfterPadding();
        }
        return m16068(view, orientationHelper, true);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private View m16059(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int findFirstVisibleItemPosition;
        float f;
        if (!(layoutManager instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (m16065(findViewByPosition)) {
            f = ((float) (orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition))) / ((float) orientationHelper.getDecoratedMeasurement(findViewByPosition));
        } else {
            f = ((float) orientationHelper.getDecoratedEnd(findViewByPosition)) / ((float) orientationHelper.getDecoratedMeasurement(findViewByPosition));
        }
        boolean z = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() + -1;
        if (f > 0.5f && !z) {
            return findViewByPosition;
        }
        if (z) {
            return null;
        }
        return layoutManager.findViewByPosition(findFirstVisibleItemPosition + 1);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private View m16071(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int findLastVisibleItemPosition;
        float f;
        if (!(layoutManager instanceof LinearLayoutManager) || (findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition()) == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findLastVisibleItemPosition);
        if (m16065(findViewByPosition)) {
            f = ((float) orientationHelper.getDecoratedEnd(findViewByPosition)) / ((float) orientationHelper.getDecoratedMeasurement(findViewByPosition));
        } else {
            f = ((float) (orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition))) / ((float) orientationHelper.getDecoratedMeasurement(findViewByPosition));
        }
        boolean z = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
        if (f > 0.5f && !z) {
            return findViewByPosition;
        }
        if (z) {
            return null;
        }
        return layoutManager.findViewByPosition(findLastVisibleItemPosition - 1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private int m16062(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return -1;
        }
        if (this.f15171 == 8388611 || this.f15171 == 48 || this.f15171 == 17) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (this.f15171 == 8388613 || this.f15171 == 80) {
            return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        return -1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private OrientationHelper m16058(RecyclerView.LayoutManager layoutManager) {
        if (this.f15168 == null) {
            this.f15168 = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f15168;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private OrientationHelper m16063(RecyclerView.LayoutManager layoutManager) {
        if (this.f15170 == null) {
            this.f15170 = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f15170;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.f15169.getContext()) { // from class: o.⁔.4
            @Override // android.support.v7.widget.RecyclerView.SmoothScroller
            public void setTargetPosition(int i) {
                int i2;
                int i3 = C1046.this.f15166 * C1046.this.f15174 * C1046.this.f15165;
                if (i > C1046.this.f15173) {
                    i2 = Math.min(C1046.this.f15173 + i3, i);
                } else {
                    i2 = Math.max(C1046.this.f15173 - i3, i);
                }
                super.setTargetPosition(i2);
            }

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.LinearSmoothScroller, android.support.v7.widget.RecyclerView.SmoothScroller
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                int[] calculateDistanceToFinalSnap = C1046.this.calculateDistanceToFinalSnap(C1046.this.f15169.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return ((float) C1046.this.f15164) / ((float) displayMetrics.densityDpi);
            }
        };
    }
}
