package o;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
/* renamed from: o.Һ  reason: contains not printable characters */
public class C0523 extends C0803 {

    /* renamed from: ʻ  reason: contains not printable characters */
    int f13660;

    /* renamed from: ʼ  reason: contains not printable characters */
    int f13661;

    /* renamed from: ʽ  reason: contains not printable characters */
    View f13662;

    /* renamed from: ˊ  reason: contains not printable characters */
    View f13663;

    /* renamed from: ˋ  reason: contains not printable characters */
    ValueAnimator f13664;

    /* renamed from: ˎ  reason: contains not printable characters */
    ValueAnimator f13665;

    /* renamed from: ˏ  reason: contains not printable characters */
    ValueAnimator f13666;

    /* renamed from: ॱ  reason: contains not printable characters */
    View f13667;

    /* renamed from: ᐝ  reason: contains not printable characters */
    View f13668;

    public C0523(NetflixActivity netflixActivity, C0828 r2) {
        super(netflixActivity, r2);
        m14548();
        m14552();
        m14556();
        m14546();
    }

    /* access modifiers changed from: protected */
    @Override // o.C0803
    /* renamed from: ˏ  reason: contains not printable characters */
    public int mo14560() {
        return R.layout.action_bar_search_ab8274;
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m14548() {
        this.f13667 = this.f14536.findViewById(this.f14536.getContext().getResources().getIdentifier("android:id/search_plate", null, null));
        this.f13663 = this.f14536.findViewById(this.f14536.getContext().getResources().getIdentifier("android:id/submit_area", null, null));
        this.f13668 = this.f14536.findViewById(this.f14536.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null));
        this.f13662 = m349().getCustomView().findViewById(R.id.action_bar_search_up);
        if (this.f13662 != null && BX.m3957()) {
            this.f13662.setRotation(180.0f);
        }
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m14546() {
        if (this.f13667 != null) {
            this.f13667.setBackgroundColor(0);
        }
        if (this.f13663 != null) {
            this.f13663.setBackgroundColor(0);
        }
        m358().setContentInsetsAbsolute(0, 0);
        m358().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.Һ.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (C0523.this.m349().getCustomView() != null) {
                    C0523.this.f13661 = C0523.this.f13668.getMeasuredWidth();
                    C0523.this.f13660 = C0523.this.m349().getCustomView().getMeasuredHeight();
                    C0523.this.m358().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    C0523.this.m14553();
                    C0523.this.m14554();
                }
            }
        });
        m14551();
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m14551() {
        this.f13665 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(m353().getResources().getColor(R.color.black)), Integer.valueOf(m353().getResources().getColor(R.color.dark_grey)));
        this.f13665.setDuration(200L);
        this.f13665.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.Һ.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (C0523.this.m349().getCustomView() != null) {
                    C0523.this.m349().getCustomView().setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˌ  reason: contains not printable characters */
    private void m14554() {
        this.f13666 = ValueAnimator.ofInt(this.f13661, 0);
        this.f13666.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.Һ.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() > 0.5f) {
                    C0523.this.f13668.setAlpha(0.0f);
                } else {
                    C0523.this.f13668.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
                }
                C0523.this.m14555(valueAnimator, C0523.this.f13668);
            }
        });
        this.f13666.setDuration(200L);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m14553() {
        this.f13664 = ValueAnimator.ofInt(this.f13660, ((View) m349().getCustomView().getParent()).getMeasuredHeight());
        this.f13664.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.Һ.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                C0523.this.m14547(valueAnimator, C0523.this.m349().getCustomView());
            }
        });
        this.f13664.setDuration(200L);
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private void m14552() {
        m349().setHomeButtonEnabled(false);
        m349().setDisplayHomeAsUpEnabled(false);
        m349().setDisplayShowHomeEnabled(false);
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m14556() {
        if (this.f13662 != null) {
            this.f13662.setOnClickListener(new View.OnClickListener() { // from class: o.Һ.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C0523.this.m353().performUpAction();
                }
            });
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14561() {
        this.f13665.start();
        this.f13666.start();
        this.f13664.start();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14559() {
        this.f13665.reverse();
        this.f13666.reverse();
        this.f13664.reverse();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14555(ValueAnimator valueAnimator, View view) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = intValue;
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14547(ValueAnimator valueAnimator, View view) {
        if (view != null) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = intValue;
            view.setLayoutParams(layoutParams);
        }
    }
}
