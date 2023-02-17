package o;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.ViewUtils;
/* access modifiers changed from: package-private */
/* renamed from: o.th  reason: case insensitive filesystem */
public class C2178th extends C2112ra {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f10540;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f10541;

    /* renamed from: ʽ  reason: contains not printable characters */
    private TransitionDrawable f10542;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f10543;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f10544;

    public C2178th(C2133rv rvVar, RecyclerView recyclerView, View[] viewArr, View view, View view2, VideoDetailsViewGroup videoDetailsViewGroup, boolean z, int i) {
        super(rvVar, recyclerView, viewArr, view, BrowseExperience.m1767((Activity) C1322Av.m3791(recyclerView.getContext(), Activity.class), (int) R.attr.detailsPageParallaxStartColor), 0, 0, view2);
        this.f10543 = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.kids_parallax_tracking_view_final_x_pos);
        m10329(false);
        if (!z) {
            videoDetailsViewGroup.m1682().setVisibility(8);
        }
        this.f10540 = i;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ʼ */
    public void mo10325() {
    }

    @Override // o.C2112ra
    /* renamed from: ᐝ */
    public Drawable mo10342() {
        if (this.f10542 == null) {
            this.f10542 = m11162(this.f9794.getResources());
        }
        return this.f10542;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private TransitionDrawable m11162(Resources resources) {
        int i;
        switch (this.f10540) {
            case R.color.kids_blue /* 2131099835 */:
                i = R.drawable.kids_toolbar_transition_blue;
                break;
            case R.color.kids_green /* 2131099839 */:
                i = R.drawable.kids_toolbar_transition_green;
                break;
            case R.color.kids_orange /* 2131099843 */:
                i = R.drawable.kids_toolbar_transition_orange;
                break;
            case R.color.kids_purple /* 2131099845 */:
                i = R.drawable.kids_toolbar_transition_purple;
                break;
            case R.color.kids_yellow /* 2131099851 */:
                i = R.drawable.kids_toolbar_transition_yellow;
                break;
            default:
                i = R.drawable.kids_toolbar_transition_default;
                break;
        }
        return (TransitionDrawable) resources.getDrawable(i);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ʽ */
    public int mo10326() {
        if (this.f9797 == null || this.f9797.getContext() == null) {
            return 0;
        }
        return ViewUtils.m3006(this.f9797.getContext());
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ʻ */
    public int mo10324() {
        return 300;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ˊॱ */
    public int mo10330() {
        return 300;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ॱˊ */
    public void mo10340() {
    }

    @Override // o.C2112ra
    /* renamed from: ˋ */
    public void mo10332(int i) {
        if (i == 0) {
            mo10331();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ˎ */
    public void mo10334() {
        if (this.f9797 != null) {
            m11159();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ॱ */
    public void mo10338() {
        if (this.f9797 != null) {
            m11164();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ˏ */
    public void mo10335() {
        if (this.f9797 == null) {
            m11159();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ˋ */
    public void mo10331() {
        if (this.f9797 == null) {
            m11164();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2112ra
    /* renamed from: ॱॱ */
    public int mo10341() {
        return this.f10543;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m11159() {
        if (!this.f10544 && !this.f10541 && this.f10542 != null) {
            this.f10541 = true;
            this.f10542.setCrossFadeEnabled(true);
            this.f9794.postDelayed(new Runnable() { // from class: o.th.1
                @Override // java.lang.Runnable
                public void run() {
                    C2178th.this.f10542.startTransition(300);
                    C2178th.this.f10544 = true;
                    C2178th.this.f10541 = false;
                }
            }, 300);
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m11164() {
        if (this.f10544 && !this.f10541 && this.f10542 != null) {
            this.f10542.setCrossFadeEnabled(true);
            this.f10542.reverseTransition(300);
            this.f10544 = false;
        }
    }
}
