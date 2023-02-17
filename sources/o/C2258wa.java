package o;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.util.ViewUtils;
import o.C2275wq;
/* renamed from: o.wa  reason: case insensitive filesystem */
public class C2258wa extends wF implements AbstractC2264wf {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected vZ f11562;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected ImageButton f11563;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected int f11564;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected TextView f11565;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected int f11566;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected C1081 f11567;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final C2282wx f11568 = new C2282wx();

    /* renamed from: ˎ  reason: contains not printable characters */
    protected ImageButton f11569;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected View f11570;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private View f11571;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected View f11572;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected ImageButton f11573;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected SeekBar.OnSeekBarChangeListener f11574;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected boolean f11575 = true;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected C1351Bx f11576 = new C1351Bx();

    public C2258wa(PlayerFragment playerFragment, View view, C2275wq.C0256 r4) {
        super(playerFragment);
        mo12102(view, r4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public void mo12102(View view, C2275wq.C0256 r5) {
        this.f11565 = (TextView) view.findViewById(R.id.label_duration);
        this.f11570 = view.findViewById(R.id.bottom_panel);
        this.f11571 = view.findViewById(R.id.bottom_gradient);
        this.f11567 = (C1081) view.findViewById(R.id.timeline);
        this.f11574 = r5.f11691;
        this.f11567.setThumbOffset(C1004.m15954(this.f11438.m14534(), this.f11438.m2472().f11516));
        this.f11573 = (ImageButton) view.findViewById(R.id.player);
        this.f11573.setOnClickListener(r5.f11695);
        this.f11569 = (ImageButton) view.findViewById(R.id.skip_back);
        this.f11569.setOnClickListener(r5.f11693);
        this.f11563 = (ImageButton) view.findViewById(R.id.zoom);
        this.f11563.setOnClickListener(r5.f11689);
        this.f11572 = view.findViewById(R.id.extra_seekbar_handler);
        this.f11562 = vZ.m12109(this.f11438);
    }

    /* renamed from: ॱ */
    public synchronized void mo12107() {
        if (this.f11562 != null) {
            this.f11562.m12110();
        }
        BQ.m3916(this.f11570, false);
        if (this.f11571 != null) {
            BQ.m3916(this.f11571, false);
        }
        m12405();
    }

    @Override // o.AbstractC2264wf
    /* renamed from: ˋ */
    public void mo12098() {
        if (this.f11567 != null) {
            this.f11567.setVisibility(8);
        }
        if (this.f11565 != null) {
            this.f11565.setVisibility(8);
        }
    }

    @Override // o.AbstractC2264wf
    /* renamed from: ˏ */
    public ViewGroup mo12101() {
        return (ViewGroup) this.f11570;
    }

    @Override // o.AbstractC2264wf
    /* renamed from: ˊ */
    public void mo12097() {
        this.f11568.m12587((View) this.f11567, true);
        this.f11568.m12587((View) this.f11565, true);
    }

    /* renamed from: ˎ */
    public synchronized void mo12099() {
        mo12096();
        BQ.m3916(this.f11570, true);
        if (this.f11571 != null) {
            BQ.m3916(this.f11571, true);
        }
        ViewUtils.m3002(this.f11563, this.f11575);
        this.f11562.m12113();
        if (this.f11564 <= 0) {
            C1283.m16854("screen", "Timeline was NOT visible before, its location is NOT known, delay until is rendered first time");
            final C1081 r2 = this.f11567;
            r2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.wa.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    C1283.m16854("screen", "Timeline is visible now, its location is known, render current time now!!! <==");
                    C2258wa.this.f11562.mo12116();
                    if (C2258wa.this.f11564 > 1) {
                        ViewUtils.m3009(r2, this);
                    }
                    C2258wa.this.f11564++;
                }
            });
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12403(boolean z, boolean z2) {
        mo12104(z);
        if (z2) {
            this.f11567.setEnabled(z);
        }
        this.f11565.setTextColor(this.f11438.getResources().getColor(z ? R.color.white : R.color.disabled_text_color));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ */
    public void mo12096() {
        if (this.f11562 != null) {
            this.f11562.m12115();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12407(boolean z) {
        this.f11567.setOnSeekBarChangeListener(z ? this.f11574 : null);
    }

    /* renamed from: ˏ */
    public void mo12104(boolean z) {
        m12382(this.f11573, z);
        m12382(this.f11569, z);
        m12382(this.f11563, z);
    }

    @Override // o.wF
    /* renamed from: ॱॱ */
    public void mo12118() {
        if (this.f11567 != null) {
            this.f11567.setOnSeekBarChangeListener(null);
        }
        if (this.f11573 != null) {
            this.f11573.setOnTouchListener(null);
        }
        if (this.f11569 != null) {
            this.f11569.setOnTouchListener(null);
        }
        if (this.f11563 != null) {
            this.f11563.setOnTouchListener(null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12402(boolean z) {
        this.f11573.setImageResource(z ? this.f11438.m2472().f11520 : this.f11438.m2472().f11518);
    }

    /* renamed from: ॱ */
    public int mo12106(View view) {
        int r3 = m12397(this.f11573, this.f11567, this.f11566);
        ((ViewGroup.MarginLayoutParams) this.f11572.getLayoutParams()).leftMargin = r3 - (this.f11572.getWidth() / 2);
        view.measure(0, 0);
        int measuredWidth = r3 - (view.getMeasuredWidth() / 2);
        if (measuredWidth > 10) {
            return measuredWidth;
        }
        return 10;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m12397(ImageButton imageButton, C1081 r7, int i) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        r7.getLocationOnScreen(iArr);
        if (imageButton == null) {
            return (int) r7.m16172((long) i);
        }
        imageButton.getLocationOnScreen(iArr2);
        return (int) (((float) ((iArr[0] - iArr2[0]) + r7.getPaddingLeft())) + r7.m16172((long) i));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12400(int i, Runnable runnable) {
        m12401(i, runnable, this.f11562, this.f11572, this.f11567);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12401(int i, final Runnable runnable, final vZ vZVar, final View view, C1081 r11) {
        int i2 = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
        int r3 = mo12105(i);
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, r3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.wa.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                marginLayoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.requestLayout();
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: o.wa.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (vZVar != null) {
                    vZVar.m12110();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (vZVar != null) {
                    vZVar.m12115();
                }
                view.post(runnable);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(200L);
        ofInt.start();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public int mo12105(int i) {
        return m12397(this.f11573, this.f11567, i) - (this.f11572.getWidth() / 2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12404(boolean z) {
        if (this.f11563 != null) {
            this.f11563.setImageResource(z ? this.f11438.m2472().f11519 : this.f11438.m2472().f11521);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m12408(int i, int i2, boolean z) {
        if (this.f11567 != null && z) {
            this.f11567.setProgress(i);
        }
        if (this.f11565 != null && i2 > 0) {
            this.f11565.setText(this.f11576.m4133(i2 - i));
        }
        this.f11566 = i;
        mo12413();
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo12413() {
        if (this.f11570.getAlpha() > 0.0f) {
            this.f11562.m12113();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public int m12399() {
        return this.f11566;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12409(int i) {
        if (this.f11567 != null) {
            this.f11567.setMax(i);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12412(boolean z) {
        this.f11575 = z;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public vZ m12398() {
        return this.f11562;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public C1351Bx m12410() {
        return this.f11576;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m12411() {
        ViewUtils.m3020(this.f11572, true);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m12405() {
        ViewUtils.m3020(this.f11572, false);
    }

    /* renamed from: ˏ */
    public void mo12103(pT pTVar, boolean z) {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo12406(Configuration configuration) {
    }
}
