package o;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewModel;
import o.C1046;
public final class rX extends C1046 {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0176 f9724 = new C0176(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final String f9725 = f9725;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f9726;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f9727 = -1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final TrailersFeedViewModel f9728;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rX(LifecycleOwner lifecycleOwner, TrailersFeedViewModel trailersFeedViewModel, C1046.iF iFVar) {
        super(C0682.m14928(), iFVar);
        C1457Fr.m5025(lifecycleOwner, "lifecycleOwner");
        C1457Fr.m5025(trailersFeedViewModel, "trailersFeedViewModel");
        C1457Fr.m5025(iFVar, "listener");
        this.f9728 = trailersFeedViewModel;
        this.f9728.m1926().observe(lifecycleOwner, new Observer<rW>(this) { // from class: o.rX.2

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ rX f9729;

            {
                this.f9729 = r1;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final void onChanged(rW rWVar) {
                if (rWVar instanceof rW) {
                    this.f9729.f9727 = this.f9729.f9728.m1933().m1962(rWVar);
                }
            }
        });
    }

    /* renamed from: o.rX$ˊ  reason: contains not printable characters */
    public static final class C0176 {
        private C0176() {
        }

        public /* synthetic */ C0176(C1456Fq fq) {
            this();
        }
    }

    @Override // o.C1046, android.support.v7.widget.LinearSnapHelper, android.support.v7.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        View view2;
        C1457Fr.m5025(layoutManager, "layoutManager");
        C1457Fr.m5025(view, "view");
        if (this.f9726 || this.f9727 == -1) {
            view2 = view;
            this.f9726 = false;
        } else {
            view2 = layoutManager.findViewByPosition(this.f9727);
            if (view2 == null) {
                view2 = view;
            }
        }
        int[] calculateDistanceToFinalSnap = super.calculateDistanceToFinalSnap(layoutManager, view2);
        C1457Fr.m5016((Object) calculateDistanceToFinalSnap, "super.calculateDistanceT…ayoutManager, targetView)");
        return calculateDistanceToFinalSnap;
    }

    @Override // android.support.v7.widget.LinearSnapHelper, android.support.v7.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        C1457Fr.m5025(layoutManager, "layoutManager");
        this.f9726 = true;
        int findTargetSnapPosition = super.findTargetSnapPosition(layoutManager, i, i2);
        if (findTargetSnapPosition != -1 || !(layoutManager instanceof LinearLayoutManager)) {
            return findTargetSnapPosition;
        }
        if (i2 > 0) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
    }
}
