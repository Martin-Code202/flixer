package o;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.util.ViewUtils;
import o.C2315xk;
/* renamed from: o.xn  reason: case insensitive filesystem */
public class C2318xn implements AbstractC2311xg {

    /* renamed from: ॱ  reason: contains not printable characters */
    protected static String f12213 = "nf_postplay";

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f12214 = 300;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f12215 = 12;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected C2315xk.Cif f12216;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected ViewGroup f12217;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected iF f12218;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected AbstractC0931 f12219;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected TextureView f12220;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f12221 = 12;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected IPlayerFragment f12222;

    C2318xn(IPlayerFragment iPlayerFragment) {
        this.f12222 = iPlayerFragment;
        View r8 = iPlayerFragment.mo2246();
        this.f12219 = (AbstractC0931) r8.findViewById(R.id.surface);
        if (this.f12219 == null) {
            this.f12219 = (AbstractC0931) r8.findViewById(R.id.netflix_video_view);
        }
        if (this.f12219 == null && C0910.m15708()) {
            this.f12219 = (AbstractC0931) r8.findViewById(R.id.playback_surface);
        }
        this.f12220 = (TextureView) r8.findViewById(R.id.surface2);
        this.f12217 = (ViewGroup) r8.findViewById(R.id.background);
        if (this.f12219 == null) {
            C1283.m16865(f12213, "PostPlayWithScaling:: surface not found");
        }
        if (this.f12220 == null) {
            C1283.m16865(f12213, "PostPlayWithScaling:: surface2 not found");
        }
        if (this.f12217 == null) {
            C1283.m16865(f12213, "PostPlayWithScaling:: rootFrame not found");
        }
        int r9 = AD.m3317(this.f12222.mo2269());
        this.f12216 = new C2315xk.Cif(0, 0, 0, 1.0f, C1004.m15954(this.f12222.mo2269(), 12), C1004.m15954(this.f12222.mo2269(), 12), ((float) C1004.m15954(this.f12222.mo2269(), 300)) / ((float) r9));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12952(final int i, final int i2, final float f) {
        this.f12222.mo2235(new Runnable() { // from class: o.xn.4
            @Override // java.lang.Runnable
            public void run() {
                C2318xn.this.m12950(i, i2, f);
                C2318xn.this.m12955(i, i2);
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12955(int i, int i2) {
        if (this.f12220 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12220.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, 0, 0);
            this.f12220.setLayoutParams(marginLayoutParams);
            this.f12220.postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12950(int i, int i2, float f) {
        if (this.f12219 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12219.mo15742().getLayoutParams();
            marginLayoutParams.setMargins(i, i2, 0, 0);
            this.f12219.mo15742().setLayoutParams(marginLayoutParams);
            this.f12219.setScale(f);
            this.f12219.mo15742().postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public iF m12954() {
        if (this.f12219 == null) {
            return null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12219.mo15742().getLayoutParams();
        return new iF(marginLayoutParams.bottomMargin, marginLayoutParams.topMargin, marginLayoutParams.leftMargin, marginLayoutParams.rightMargin, this.f12219.mo15741());
    }

    @Override // o.AbstractC2311xg
    /* renamed from: ˊ */
    public void mo12926() {
        C1283.m16854(f12213, "PostPlayWithScaling:: doTransitionToPostPlay starts");
        if (this.f12219 == null) {
            C1283.m16865(f12213, "PostPlayWithScaling:: surface not found");
            return;
        }
        this.f12218 = m12954();
        m12951(this.f12219.mo15742());
        m12951(this.f12220);
        m12952(0, 0, this.f12216.m12942());
        C1283.m16854(f12213, "PostPlayWithScaling:: doTransitionToPostPlay ends after request layout");
    }

    @Override // o.AbstractC2311xg
    /* renamed from: ˏ */
    public void mo12929(Runnable runnable) {
        C1283.m16854(f12213, "PostPlayWithScaling:: doTransitionFromPostPlay starts");
        if (this.f12219 == null) {
            C1283.m16865(f12213, "PostPlayWithScaling:: surface not found");
            return;
        }
        if (this.f12218 == null) {
            C1283.m16850(f12213, "Previous state unknown");
            this.f12218 = new iF(0, 0, 0, 0, 0);
        }
        m12953(this.f12219.mo15742());
        m12956(this.f12219.mo15742(), this.f12218.f12230, this.f12218.f12229, this.f12218.f12231, this.f12218.f12227);
        this.f12219.setMode(this.f12218.f12228);
        this.f12219.mo15742().postInvalidate();
        if (this.f12220 != null) {
            m12953(this.f12220);
            m12956(this.f12220, this.f12218.f12230, this.f12218.f12229, this.f12218.f12231, this.f12218.f12227);
            this.f12220.postInvalidate();
        }
        C1283.m16854(f12213, "PostPlayWithScaling:: doTransitionFromPostPlay ends after request layout");
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12951(View view) {
        if (view != null) {
            if (view.getParent() instanceof ConstraintLayout) {
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) view.getParent());
                constraintSet.clear(view.getId(), 3);
                constraintSet.clear(view.getId(), 4);
                constraintSet.clear(view.getId(), 6);
                constraintSet.clear(view.getId(), 7);
                constraintSet.setHorizontalBias(view.getId(), 0.0f);
                constraintSet.setVerticalBias(view.getId(), 0.0f);
                constraintSet.applyTo((ConstraintLayout) view.getParent());
            } else if (view instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.removeRule(13);
                view.setLayoutParams(layoutParams);
            } else if (view instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.gravity = 0;
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12956(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12219.mo15742().getLayoutParams();
        marginLayoutParams.setMargins(i, i2, i3, i4);
        view.setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12953(View view) {
        if (view == null) {
            return;
        }
        if (view.getParent() instanceof ConstraintLayout) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone((ConstraintLayout) view.getParent());
            constraintSet.connect(view.getId(), 3, 0, 3);
            constraintSet.connect(view.getId(), 4, 0, 4);
            constraintSet.connect(view.getId(), 6, 0, 6);
            constraintSet.connect(view.getId(), 7, 0, 7);
            constraintSet.setHorizontalBias(view.getId(), 0.5f);
            constraintSet.setVerticalBias(view.getId(), 0.5f);
            constraintSet.applyTo((ConstraintLayout) view.getParent());
        } else if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.addRule(13, -1);
            view.setLayoutParams(layoutParams);
        } else if (view instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.gravity = 17;
            view.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o.xn$iF */
    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        int f12227;

        /* renamed from: ˋ  reason: contains not printable characters */
        int f12228;

        /* renamed from: ˎ  reason: contains not printable characters */
        int f12229;

        /* renamed from: ˏ  reason: contains not printable characters */
        int f12230;

        /* renamed from: ॱ  reason: contains not printable characters */
        int f12231;

        iF(int i, int i2, int i3, int i4, int i5) {
            this.f12227 = i;
            this.f12229 = i2;
            this.f12230 = i3;
            this.f12231 = i4;
            this.f12228 = i5;
        }
    }

    @Override // o.AbstractC2311xg
    /* renamed from: ˎ */
    public void mo12928(boolean z) {
        if (z) {
            ViewUtils.m3010(this.f12219.mo15742(), ViewUtils.Visibility.VISIBLE);
            ViewUtils.m3010(this.f12220, ViewUtils.Visibility.VISIBLE);
            return;
        }
        ViewUtils.m3010(this.f12219.mo15742(), ViewUtils.Visibility.INVISIBLE);
        ViewUtils.m3010(this.f12220, ViewUtils.Visibility.INVISIBLE);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public C2315xk.Cif mo12940() {
        return this.f12216;
    }

    @Override // o.AbstractC2311xg
    /* renamed from: ˋ */
    public boolean mo12927() {
        return true;
    }
}
