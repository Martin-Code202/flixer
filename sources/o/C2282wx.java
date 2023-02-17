package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.Property;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
/* renamed from: o.wx  reason: case insensitive filesystem */
public class C2282wx {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Interpolator f11726 = PathInterpolatorCompat.create(0.19f, 1.0f, 0.22f, 1.0f);

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Interpolator f11727 = PathInterpolatorCompat.create(0.755f, 0.05f, 0.855f, 0.06f);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static AnimatorSet f11728 = new AnimatorSet();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Interpolator f11729 = PathInterpolatorCompat.create(0.23f, 1.0f, 0.32f, 1.0f);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final float f11730 = NetflixApplication.getInstance().getResources().getDimension(R.dimen.player_big_buttons_medium_translation);

    /* renamed from: ʼ  reason: contains not printable characters */
    private final float f11731 = NetflixApplication.getInstance().getResources().getDimension(R.dimen.player_big_buttons_small_translation);

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f11732 = NetflixApplication.getInstance().getString(R.string.label_player_10_forward);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f11733 = NetflixApplication.getInstance().getString(R.string.label_player_10);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final float f11734 = NetflixApplication.getInstance().getResources().getDimension(R.dimen.player_big_buttons_translation);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f11735 = NetflixApplication.getInstance().getString(R.string.label_player_10_back);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12584(View view, TextView textView, View view2) {
        m12583(textView, true);
        view.setTranslationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotation(0.0f);
        view2.setAlpha(0.0f);
        view2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12581(View view, TextView textView) {
        m12583(textView, false);
        view.setTranslationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12583(TextView textView, boolean z) {
        textView.setTranslationX(0.0f);
        textView.setText(this.f11733);
        textView.setScaleX(1.0f);
        textView.setScaleY(1.0f);
        textView.setAlpha(z ? 1.0f : 0.0f);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12589(final View view, final TextView textView, final View view2, boolean z, final View view3, final View view4) {
        final View view5;
        if (view != null && textView != null && view2 != null && (view5 = (View) view.getParent()) != null) {
            float f = this.f11734;
            float f2 = z ? -45.0f : 45.0f;
            float f3 = z ? f * -1.0f : f;
            final String str = z ? this.f11735 : this.f11732;
            boolean z2 = view3 != null && view3.getVisibility() == 0;
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, 0.9f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.9f)).setDuration(100L);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(textView, View.ALPHA, 1.0f, 0.0f).setDuration(100L);
            ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f)).setDuration(350L);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, View.ROTATION, 0.0f, f2).setDuration(150L);
            duration4.setInterpolator(f11726);
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(view, View.ROTATION, f2, 0.0f).setDuration(750L);
            duration5.setInterpolator(f11726);
            ObjectAnimator duration6 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_X, f3).setDuration(750L);
            duration6.setInterpolator(f11729);
            duration6.addListener(new AnimatorListenerAdapter() { // from class: o.wx.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    textView.setText(str);
                }
            });
            ObjectAnimator duration7 = ObjectAnimator.ofFloat(textView, View.ALPHA, 1.0f, 0.0f).setDuration(150L);
            duration7.addListener(new AnimatorListenerAdapter() { // from class: o.wx.11
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    textView.setTranslationX(0.0f);
                    textView.setText(C2282wx.this.f11733);
                    textView.setScaleX(1.0f);
                    textView.setScaleY(1.0f);
                }
            });
            ObjectAnimator duration8 = ObjectAnimator.ofFloat(textView, View.ALPHA, 0.0f, 1.0f).setDuration(150L);
            ObjectAnimator duration9 = ObjectAnimator.ofFloat(textView, View.ALPHA, 0.0f, 1.0f).setDuration(100L);
            duration9.setStartDelay(80);
            ObjectAnimator duration10 = ObjectAnimator.ofPropertyValuesHolder(textView, PropertyValuesHolder.ofFloat("scaleX", 1.4f), PropertyValuesHolder.ofFloat("scaleY", 1.4f)).setDuration(750L);
            duration10.setInterpolator(f11729);
            ObjectAnimator duration11 = ObjectAnimator.ofFloat(view2, View.ALPHA, 0.0f, 0.7f).setDuration(100L);
            duration11.addListener(new AnimatorListenerAdapter() { // from class: o.wx.14
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view2.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view2.setVisibility(8);
                }
            });
            ObjectAnimator duration12 = ObjectAnimator.ofFloat(view2, View.ALPHA, 0.7f, 0.0f).setDuration(350L);
            if (f11728.isRunning()) {
                f11728.cancel();
            }
            f11728 = new AnimatorSet();
            f11728.play(duration).with(duration2).before(duration9).before(duration3).before(duration4).before(duration6).before(duration10).before(duration11);
            f11728.play(duration5).after(duration4);
            f11728.play(duration7).after(duration6);
            f11728.play(duration8).after(duration7);
            f11728.play(duration12).after(duration11);
            if (z2 || view3 == null || view4 == null) {
                f11728.addListener(new AnimatorListenerAdapter() { // from class: o.wx.15
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        C2282wx.this.m12584(view, textView, view2);
                    }
                });
            } else {
                view.setVisibility(0);
                textView.setVisibility(0);
                view3.setVisibility(0);
                view3.setAlpha(1.0f);
                view5.setVisibility(0);
                view4.setAlpha(0.0f);
                ObjectAnimator duration13 = ObjectAnimator.ofFloat(view3, View.ALPHA, 1.0f, 0.0f).setDuration(100L);
                duration13.addListener(new AnimatorListenerAdapter() { // from class: o.wx.12
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        view3.setVisibility(8);
                        view5.setVisibility(4);
                        C2282wx.this.m12584(view, textView, view2);
                        view4.setAlpha(1.0f);
                    }
                });
                f11728.addListener(new AnimatorListenerAdapter() { // from class: o.wx.13
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        view3.setVisibility(8);
                        ((View) view.getParent()).setVisibility(4);
                        C2282wx.this.m12584(view, textView, view2);
                        view4.setAlpha(1.0f);
                    }
                });
                f11728.play(duration13).after(750);
            }
            f11728.start();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12592(View view, boolean z, boolean z2) {
        m12591(view, z, z2, 0.0f, null);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0038: APUT  (r1v1 float[]), (0 ??[int, short, byte, char]), (r2v0 float) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0055: APUT  (r1v4 float[]), (0 ??[int, short, byte, char]), (r2v1 float) */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12591(final View view, final boolean z, boolean z2, float f, final Runnable runnable) {
        if (view != null) {
            if (C1322Av.m3792()) {
                view.setVisibility(0);
                return;
            }
            float f2 = f > 0.0f ? f : this.f11730;
            if (z) {
                view.setAlpha(0.0f);
                view.setVisibility(0);
                view.setTranslationY(z2 ? f2 : -f2);
            }
            Property property = View.TRANSLATION_Y;
            float[] fArr = new float[1];
            fArr[0] = z ? 0.0f : z2 ? f2 : -f2;
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, property, fArr).setDuration(300L);
            duration.setInterpolator(f11729);
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[2];
            fArr2[0] = z ? 0.0f : 1.0f;
            fArr2[1] = z ? 1.0f : 0.0f;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, property2, fArr2).setDuration(150L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setStartDelay(z ? 0 : 100);
            animatorSet.play(duration).with(duration2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: o.wx.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    view.setVisibility(z ? 0 : 4);
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(z ? 0 : 4);
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
            animatorSet.start();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12587(View view, boolean z) {
        m12588(view, z, null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12588(final View view, final boolean z, final Runnable runnable) {
        if (view != null) {
            if (z != (view.getVisibility() == 0)) {
                if (z) {
                    view.setAlpha(0.0f);
                    view.setVisibility(0);
                }
                view.animate().setDuration(150).alpha(z ? 1.0f : 0.0f).setStartDelay(z ? 100 : 0).setListener(new AnimatorListenerAdapter() { // from class: o.wx.17
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!z) {
                            view.setVisibility(8);
                            view.setAlpha(1.0f);
                        }
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002c: APUT  (r1v1 float[]), (0 ??[int, short, byte, char]), (r2v0 float) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0052: APUT  (r1v4 float[]), (0 ??[int, short, byte, char]), (r2v1 float) */
    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12593(final View view, final View view2, final boolean z) {
        if (view != null && view2 != null) {
            float f = this.f11731;
            view.setTranslationX(z ? f : 0.0f);
            view2.setTranslationX(z ? -f : 0.0f);
            if (z) {
                view.setVisibility(0);
                view2.setVisibility(0);
            }
            Property property = View.TRANSLATION_X;
            float[] fArr = new float[1];
            fArr[0] = z ? 0.0f : f;
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, property, fArr).setDuration(z ? 300 : 100);
            duration.setInterpolator(z ? f11729 : f11727);
            Property property2 = View.TRANSLATION_X;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 0.0f : -f;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, property2, fArr2).setDuration(z ? 300 : 100);
            duration2.setInterpolator(z ? f11729 : f11727);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setStartDelay(z ? 100 : 0);
            animatorSet.play(duration).with(duration2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: o.wx.20
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!z) {
                        view.setVisibility(4);
                        view2.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (!z) {
                        view.setVisibility(4);
                        view2.setVisibility(4);
                    }
                }
            });
            animatorSet.start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12586(final View view, final TextView textView, final View view2, final View view3, boolean z, final View view4, final View view5) {
        final View view6;
        if (view != null && textView != null && view2 != null && view3 != null && view4 != null && view5 != null && (view6 = (View) view.getParent()) != null) {
            float f = this.f11734;
            float f2 = z ? f * -1.0f : f;
            final String str = z ? this.f11735 : this.f11732;
            boolean z2 = view4.getVisibility() == 0;
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, 0.9f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.9f)).setDuration(100L);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f)).setDuration(350L);
            textView.setAlpha(0.0f);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_X, f2).setDuration(750L);
            duration3.setInterpolator(f11729);
            duration3.addListener(new AnimatorListenerAdapter() { // from class: o.wx.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    textView.setVisibility(0);
                    textView.setText(str);
                }
            });
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(textView, View.ALPHA, 0.0f, 1.0f).setDuration(150L);
            duration4.setStartDelay(50);
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(textView, View.ALPHA, 1.0f, 0.0f).setDuration(150L);
            duration5.addListener(new AnimatorListenerAdapter() { // from class: o.wx.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    textView.setTranslationX(0.0f);
                    textView.setScaleX(1.0f);
                    textView.setScaleY(1.0f);
                    textView.setAlpha(0.0f);
                }
            });
            ObjectAnimator duration6 = ObjectAnimator.ofFloat(view2, View.ALPHA, 0.0f, 0.7f).setDuration(100L);
            if (z) {
                duration6.setStartDelay(100);
            }
            duration6.addListener(new AnimatorListenerAdapter() { // from class: o.wx.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view2.setVisibility(0);
                }
            });
            ObjectAnimator duration7 = ObjectAnimator.ofFloat(view2, View.ALPHA, 0.7f, 0.0f).setDuration(350L);
            ObjectAnimator duration8 = ObjectAnimator.ofFloat(view3, View.ALPHA, 0.0f, 0.7f).setDuration(100L);
            if (!z) {
                duration8.setStartDelay(100);
            }
            duration6.addListener(new AnimatorListenerAdapter() { // from class: o.wx.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view3.setVisibility(0);
                }
            });
            ObjectAnimator duration9 = ObjectAnimator.ofFloat(view3, View.ALPHA, 0.7f, 0.0f).setDuration(350L);
            ObjectAnimator duration10 = ObjectAnimator.ofPropertyValuesHolder(textView, PropertyValuesHolder.ofFloat("scaleX", 1.4f), PropertyValuesHolder.ofFloat("scaleY", 1.4f)).setDuration(750L);
            duration10.setInterpolator(f11729);
            if (f11728.isRunning()) {
                f11728.cancel();
            }
            f11728 = new AnimatorSet();
            f11728.play(duration).before(duration2).before(duration3).before(duration4).before(duration10).before(duration6).before(duration8);
            f11728.play(duration5).after(duration3);
            f11728.play(duration7).after(duration6);
            f11728.play(duration9).after(duration8);
            if (!z2) {
                view.setVisibility(0);
                textView.setVisibility(0);
                view4.setVisibility(0);
                view4.setAlpha(1.0f);
                view6.setVisibility(0);
                view5.setAlpha(0.0f);
                ObjectAnimator duration11 = ObjectAnimator.ofFloat(view4, View.ALPHA, 1.0f, 0.0f).setDuration(100L);
                duration11.addListener(new AnimatorListenerAdapter() { // from class: o.wx.10
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        view4.setVisibility(8);
                        view6.setVisibility(4);
                        C2282wx.this.m12581(view, textView);
                        view5.setAlpha(1.0f);
                    }
                });
                f11728.addListener(new AnimatorListenerAdapter() { // from class: o.wx.9
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        view4.setVisibility(8);
                        view6.setVisibility(4);
                        C2282wx.this.m12581(view, textView);
                        view5.setAlpha(1.0f);
                    }
                });
                f11728.play(duration11).after(750);
            } else {
                f11728.addListener(new AnimatorListenerAdapter() { // from class: o.wx.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        C2282wx.this.m12581(view, textView);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        C2282wx.this.m12581(view, textView);
                    }
                });
            }
            f11728.start();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12590(final View view, final boolean z) {
        if (view != null) {
            if (C1322Av.m3792()) {
                view.setAlpha(z ? 1.0f : 0.3f);
                view.setClickable(z);
                return;
            }
            view.clearAnimation();
            view.animate().alpha(z ? 1.0f : 0.3f).setDuration(200).setListener(new AnimatorListenerAdapter() { // from class: o.wx.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view.setClickable(z);
                }
            }).start();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12594(final View view, final boolean z) {
        if (view != null) {
            if (C1322Av.m3792()) {
                view.setAlpha(z ? 1.0f : 0.3f);
                view.setEnabled(z);
                return;
            }
            view.clearAnimation();
            view.animate().alpha(z ? 1.0f : 0.3f).setDuration(200).setListener(new AnimatorListenerAdapter() { // from class: o.wx.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view.setEnabled(z);
                }
            }).start();
        }
    }
}
