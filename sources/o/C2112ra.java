package o;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import java.util.Date;
/* renamed from: o.ra  reason: case insensitive filesystem */
public class C2112ra extends RecyclerView.OnScrollListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C2133rv f9784;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private View f9785;

    /* renamed from: ʼ  reason: contains not printable characters */
    private ViewGroup f9786;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private int[] f9787 = new int[2];

    /* renamed from: ʽ  reason: contains not printable characters */
    private ViewGroup.LayoutParams f9788;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f9789;

    /* renamed from: ʾ  reason: contains not printable characters */
    private GradientDrawable f9790 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, null);

    /* renamed from: ˈ  reason: contains not printable characters */
    private int f9791;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected int f9792;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f9793;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final RecyclerView f9794;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private float f9795;

    /* renamed from: ˎ  reason: contains not printable characters */
    float f9796;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final View f9797;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f9798;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f9799;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected int f9800;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final View[] f9801;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int f9802;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private long f9803;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private iF f9804;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int f9805;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f9806 = true;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private long f9807;

    /* renamed from: o.ra$iF */
    public interface iF {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo10344();

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo10345();

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo10346();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ra$ˋ  reason: contains not printable characters */
    public interface AbstractC0181 {
        /* renamed from: ˏ */
        void mo10343();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo10335() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10331() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo10334() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo10338() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C2112ra m10316(C2133rv rvVar, RecyclerView recyclerView, View[] viewArr, View view, View view2) {
        Activity activity = (Activity) C1322Av.m3791(recyclerView.getContext(), Activity.class);
        return new C2112ra(rvVar, recyclerView, viewArr, view, BrowseExperience.m1767(activity, (int) R.attr.detailsPageParallaxStartColor), BrowseExperience.m1767(activity, (int) R.attr.detailsPageParallaxEndColor), 255, view2);
    }

    public C2112ra(C2133rv rvVar, RecyclerView recyclerView, View[] viewArr, View view, int i, int i2, int i3, View view2) {
        this.f9805 = i3;
        this.f9784 = rvVar;
        this.f9801 = viewArr;
        this.f9797 = view;
        this.f9785 = view2;
        this.f9794 = recyclerView;
        this.f9792 = i;
        this.f9800 = i2;
        if (view != null) {
            this.f9786 = (ViewGroup) view.getParent();
            this.f9788 = view.getLayoutParams();
        }
        m10327();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10327() {
        m10323();
        m10320();
        m10309();
        mo10325();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public Drawable mo10342() {
        return this.f9790;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m10320() {
        if (this.f9794 != null) {
            int[] iArr = new int[2];
            ((NetflixActivity) this.f9794.getContext()).getNetflixActionBar().m358().getLocationOnScreen(iArr);
            this.f9798 = iArr[1];
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int mo10341() {
        return 0;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m10323() {
        this.f9793 = mo10326();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ  reason: contains not printable characters */
    public int mo10326() {
        if (this.f9797 != null) {
            return ((NetflixActivity) this.f9797.getContext()).getActionBarHeight() + this.f9798;
        }
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10339(iF iFVar) {
        this.f9804 = iFVar;
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (i2 != 0) {
            this.f9802 += i2;
            long time = new Date().getTime();
            this.f9803 = Math.abs((time - this.f9807) / ((long) i2));
            this.f9807 = time;
        }
        if (this.f9806) {
            mo10340();
        }
        m10333();
        m10308();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public void mo10325() {
        mo10340();
        m10333();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m10308() {
        if (this.f9797 != null && this.f9785 != null) {
            int[] iArr = new int[2];
            this.f9785.getLocationOnScreen(iArr);
            C1283.m16854("DetailsPageParallaxScrollListener", "setTrackerViewPos... loc: " + iArr[1] + "   latch: " + this.f9793);
            if (iArr[1] >= this.f9793) {
                m10328(iArr[1]);
                mo10338();
                return;
            }
            m10337();
            mo10334();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public int mo10324() {
        return 300;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public int mo10330() {
        return 300;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public void m10337() {
        if (this.f9797 != null && !this.f9789 && !this.f9799) {
            m10317(new AbstractC0181() { // from class: o.ra.5
                @Override // o.C2112ra.AbstractC0181
                /* renamed from: ˏ */
                public void mo10343() {
                    C2112ra.this.m10321();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10328(int i) {
        if (this.f9797 != null && this.f9789 && !this.f9799) {
            m10317(new AbstractC0181() { // from class: o.ra.4
                @Override // o.C2112ra.AbstractC0181
                /* renamed from: ˏ  reason: contains not printable characters */
                public void mo10343() {
                    C2112ra.this.m10322();
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10317(final AbstractC0181 r5) {
        this.f9791 = mo10330();
        if (this.f9803 == 0) {
            this.f9791 = 100;
        }
        this.f9797.animate().alpha(0.0f).setDuration((long) this.f9791).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new Animator.AnimatorListener() { // from class: o.ra.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                C2112ra.this.f9799 = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C2112ra.this.f9799 = false;
                C2112ra.this.f9797.animate().alpha(1.0f).setDuration((long) C2112ra.this.mo10324()).setListener(new Animator.AnimatorListener() { // from class: o.ra.1.4
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        C2112ra.this.f9799 = false;
                        C2112ra.this.f9797.clearAnimation();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                    }
                });
                r5.mo10343();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m10321() {
        if (this.f9797 != null) {
            C0772 r5 = ((NetflixActivity) this.f9794.getContext()).getNetflixActionBar().m358();
            ViewGroup viewGroup = (ViewGroup) this.f9797.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f9797);
                r5.addView(this.f9797, new Toolbar.LayoutParams(-2, -2, 48));
                this.f9789 = true;
                this.f9797.setTranslationX((float) mo10341());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m10322() {
        ViewGroup viewGroup;
        if (this.f9797 != null && this.f9786 != null && this.f9788 != null && (viewGroup = (ViewGroup) this.f9797.getParent()) != null && viewGroup != this.f9786) {
            viewGroup.removeView(this.f9797);
            this.f9786.addView(this.f9797, this.f9788);
            this.f9797.setTranslationY(0.0f);
            this.f9797.setTranslationX(0.0f);
            this.f9789 = false;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (this.f9804 != null) {
            switch (i) {
                case 0:
                    this.f9804.mo10344();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10332(int i) {
        int max = Math.max(0, Math.min(this.f9805, i));
        this.f9787[0] = m10318(this.f9792, max);
        this.f9787[1] = m10318(this.f9800, max);
        this.f9790.setColors(this.f9787);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void mo10340() {
        mo10332(m10310());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m10318(int i, int i2) {
        float f = ((float) i2) / 255.0f;
        int alpha = Color.alpha(i);
        return Color.argb(alpha + ((int) (((float) (255 - alpha)) * f)), Color.red(i), Color.green(i), Color.blue(i));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m10333() {
        if (m10310() != 0) {
            if (this.f9804 != null) {
                this.f9804.mo10345();
            }
        } else if (this.f9804 != null) {
            this.f9804.mo10346();
        }
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private void m10309() {
        float actionBarHeight = (float) (((NetflixActivity) this.f9794.getContext()).getActionBarHeight() * 2);
        if (AD.m3299()) {
            actionBarHeight *= 2.0f;
        }
        this.f9795 = ((float) this.f9805) / actionBarHeight;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private int m10310() {
        if (this.f9794 == null) {
            return 0;
        }
        int i = 0;
        if (this.f9794.getChildCount() > 0) {
            View childAt = this.f9794.getChildAt(0);
            if (!((AbstractC0801) this.f9794.getAdapter()).m15325(childAt, this.f9794)) {
                i = this.f9805;
                if (!(this.f9784 == null || childAt.getTag(R.id.season_number) == null)) {
                    m10314(((Integer) childAt.getTag(R.id.season_number)).intValue());
                }
                mo10335();
            } else {
                i = (int) (((float) (-childAt.getTop())) * this.f9795);
                View[] viewArr = this.f9801;
                for (View view : viewArr) {
                    if (view != null) {
                        m10311(view, childAt.getTop());
                    }
                }
                mo10331();
            }
        }
        return Math.max(0, i);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m10336() {
        if (this.f9794.getChildCount() >= 1 && this.f9801.length >= 1) {
            C1283.m16846("DetailsPageParallaxScrollListener", "Resetting dynamic views' Y-position");
            View childAt = this.f9794.getChildAt(0);
            View[] viewArr = this.f9801;
            for (View view : viewArr) {
                if (view != null) {
                    m10311(view, childAt.getTop());
                }
            }
            m10308();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10314(final int i) {
        if (this.f9784 != null) {
            this.f9784.post(new Runnable() { // from class: o.ra.3
                @Override // java.lang.Runnable
                public void run() {
                    int r2 = C2112ra.this.f9784.m10486(i);
                    if (r2 < 0) {
                        C1283.m16846("DetailsPageParallaxScrollListener", "No valid season index found");
                    } else {
                        C2112ra.this.f9784.setSelection(r2, true);
                    }
                }
            });
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10311(View view, int i) {
        if (C1317As.m3758() >= 16) {
            float f = ((float) (-i)) + (((float) i) * 0.4f);
            if (view != null && f != this.f9796) {
                view.setTranslationY(f);
                this.f9796 = f;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10329(boolean z) {
        this.f9806 = z;
    }
}
