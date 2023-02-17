package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.netflix.android.widgetry.widget.TrackedRecyclerView;
import com.netflix.mediaclient.util.ViewUtils;
public final class rY extends TrackedRecyclerView {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C0177 f9730 = new C0177(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    private RecyclerView.OnScrollListener f9731;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f9732;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final float f9733;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f9734;

    /* renamed from: o.rY$ˊ  reason: contains not printable characters */
    public static final class C0177 {
        private C0177() {
        }

        public /* synthetic */ C0177(C1456Fq fq) {
            this();
        }
    }

    public final void setScrollingLocked(boolean z) {
        this.f9732 = z;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final int m10232() {
        return this.f9734;
    }

    public final void setArtificialPaddingBottom(int i) {
        this.f9734 = i;
        Context context = getContext();
        C1457Fr.m5016((Object) context, "context");
        Resources resources = context.getResources();
        C1457Fr.m5016((Object) resources, "context.resources");
        Configuration configuration = resources.getConfiguration();
        C1457Fr.m5016((Object) configuration, "context.resources.configuration");
        m10231(configuration);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rY(Context context) {
        super(context);
        C1457Fr.m5025(context, "context");
        this.f9733 = C0682.m14927() ? 0.67f : 1.0f;
        this.f9734 = -1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rY(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1457Fr.m5025(context, "context");
        this.f9733 = C0682.m14927() ? 0.67f : 1.0f;
        this.f9734 = -1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rY(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f9733 = C0682.m14927() ? 0.67f : 1.0f;
        this.f9734 = -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.android.widgetry.widget.TrackedRecyclerView
    /* renamed from: ˎ */
    public String mo110() {
        return "TrailersFeedRecyclerView";
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        C1457Fr.m5025(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        m10231(configuration);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m10231(Configuration configuration) {
        int r2 = configuration.orientation == 2 ? 0 : m10232();
        if (getPaddingBottom() != r2 && r2 != -1) {
            ViewUtils.m3029(this, r2);
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i, int i2) {
        return super.fling(i, (int) (((float) i2) * this.f9733));
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "e");
        if (this.f9732) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setItemScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        C1457Fr.m5025(onScrollListener, "listener");
        this.f9731 = onScrollListener;
        RecyclerView.OnScrollListener onScrollListener2 = this.f9731;
        if (onScrollListener2 == null) {
            C1457Fr.m5017("itemScrollListener");
        }
        addOnScrollListener(onScrollListener2);
    }
}
