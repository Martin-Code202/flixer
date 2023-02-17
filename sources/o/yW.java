package o;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.netflix.android.widgetry.widget.TrackedRecyclerView;
import kotlin.TypeCastException;
public final class yW extends TrackedRecyclerView {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0306 f12469 = new C0306(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private float f12470;

    /* renamed from: ˎ  reason: contains not printable characters */
    private RecyclerView.OnScrollListener f12471;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1133 f12472;

    public yW(Context context) {
        this(context, null, 0, 6, null);
    }

    public yW(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yW(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yW(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.yW$ˋ  reason: contains not printable characters */
    public static final class C0306 extends C1277 {
        private C0306() {
            super("PreviewsPlayerRecyclerView");
        }

        public /* synthetic */ C0306(C1456Fq fq) {
            this();
        }
    }

    public final void setTitleBarView(C1133 r1) {
        this.f12472 = r1;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.android.widgetry.widget.TrackedRecyclerView
    /* renamed from: ˎ */
    public String mo110() {
        return f12469.m16821();
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        C1133 r2 = this.f12472;
        if (r2 != null) {
            this.f12470 += (float) i;
            float width = this.f12470 / ((float) getWidth());
            C0306 r5 = f12469;
            if (Math.abs(r2.m16295() - width) > 1.0f) {
                stopScroll();
                RecyclerView.ViewHolder childViewHolder = getChildViewHolder(getChildAt(0));
                int adapterPosition = childViewHolder != null ? childViewHolder.getAdapterPosition() : -1;
                C0306 r6 = f12469;
                if (adapterPosition != -1) {
                    r2.m16299(adapterPosition);
                    scrollToPosition(adapterPosition);
                    this.f12470 = 0.0f;
                    return;
                }
                return;
            }
            r2.m16298(width);
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void scrollToPosition(int i) {
        super.scrollToPosition(i);
        C1133 r0 = this.f12472;
        if (r0 != null) {
            r0.m16299(i);
        }
        setPlaybackState(true);
    }

    public final void setPlaybackState(boolean z) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            RecyclerView.ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.previews.PreviewsPlayerItemViewHolder");
            }
            yS ySVar = (yS) childViewHolder;
            ySVar.m13269("setPlaybackTo from PreviewsRecyclerView");
            ySVar.m13276(z);
            C0306 r6 = f12469;
        }
    }

    public final void setItemScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        C1457Fr.m5025(onScrollListener, "listener");
        this.f12471 = onScrollListener;
        RecyclerView.OnScrollListener onScrollListener2 = this.f12471;
        if (onScrollListener2 == null) {
            C1457Fr.m5017("itemScrollListener");
        }
        addOnScrollListener(onScrollListener2);
    }
}
