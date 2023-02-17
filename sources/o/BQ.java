package o;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.ViewUtils;
import o.C1348Bu;
public class BQ {
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0010: APUT  (r0v1 android.graphics.drawable.Drawable[]), (0 ??[int, short, byte, char]), (r1v0 android.graphics.drawable.Drawable) */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3915(final ImageView imageView, Drawable drawable, final Bitmap bitmap) {
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[0] = drawable == null ? new ColorDrawable(0) : drawable;
        drawableArr[1] = new BitmapDrawable(imageView.getResources(), bitmap);
        TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArr);
        transitionDrawable.setCrossFadeEnabled(true);
        imageView.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(150);
        Runnable runnable = (Runnable) imageView.getTag(R.id.animation_utils_cross_fade);
        if (runnable != null) {
            C1348Bu.If.m4099(runnable);
        }
        AnonymousClass1 r6 = new Runnable() { // from class: o.BQ.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!C1317As.m3750(imageView.getContext()) && (imageView.getDrawable() instanceof TransitionDrawable)) {
                        TransitionDrawable transitionDrawable2 = (TransitionDrawable) imageView.getDrawable();
                        if (transitionDrawable2.getNumberOfLayers() > 1 && (transitionDrawable2.getDrawable(1) instanceof BitmapDrawable)) {
                            BitmapDrawable bitmapDrawable = (BitmapDrawable) transitionDrawable2.getDrawable(1);
                            if (bitmapDrawable.getBitmap() == bitmap) {
                                imageView.setImageDrawable(bitmapDrawable);
                            }
                        }
                    }
                } finally {
                    imageView.setTag(R.id.animation_utils_cross_fade, null);
                }
            }
        };
        imageView.setTag(R.id.animation_utils_cross_fade, r6);
        C1348Bu.If.m4100(r6, 150);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3913(ImageView imageView) {
        Runnable runnable = (Runnable) imageView.getTag(R.id.animation_utils_cross_fade);
        if (runnable != null) {
            C1348Bu.If.m4099(runnable);
            imageView.setTag(R.id.animation_utils_cross_fade, null);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3909(View view, boolean z) {
        if (view != null) {
            if (z) {
                m3910(view, 1.0f, 0.0f, 75, new C0069(view));
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3911(View view, boolean z) {
        if (view != null) {
            if (view.getVisibility() != 0 || !C1021.m15987(view.getAlpha(), 1.0f)) {
                view.animate().cancel();
                m3914(view, z);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3914(View view, boolean z) {
        if (view != null) {
            if (z) {
                m3910(view, 0.0f, 1.0f, 150, new iF(view));
                return;
            }
            view.animate().cancel();
            view.setAlpha(1.0f);
            view.setVisibility(0);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m3910(View view, float f, float f2, int i, Animator.AnimatorListener animatorListener) {
        view.setAlpha(f);
        view.animate().withLayer().alpha(f2).setDuration((long) i).setListener(animatorListener).start();
    }

    /* renamed from: o.BQ$ˊ  reason: contains not printable characters */
    public static class C0069 implements Animator.AnimatorListener {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final View f4613;

        public C0069(View view) {
            this.f4613 = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4613.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* access modifiers changed from: package-private */
    public static class iF implements Animator.AnimatorListener {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final View f4612;

        public iF(View view) {
            this.f4612 = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f4612.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3912(View view, Animator.AnimatorListener animatorListener) {
        m3910(view, 0.7f, 1.0f, 150, animatorListener);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static ViewPropertyAnimator m3916(View view, boolean z) {
        return m3908(view, z, 300);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static ViewPropertyAnimator m3908(final View view, final boolean z, int i) {
        final float f = z ? 1.0f : 0.0f;
        final ViewPropertyAnimator alpha = view.animate().alpha(f);
        alpha.setDuration((long) i).setInterpolator(new LinearInterpolator()).setListener(new Animator.AnimatorListener() { // from class: o.BQ.2

            /* renamed from: ˊ  reason: contains not printable characters */
            private boolean f4607;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if ((z || (view.getAlpha() >= 1.0f && view.isShown())) && (!z || view.getAlpha() <= 0.0f || !view.isShown())) {
                    ViewUtils.m3002(view, true);
                    this.f4607 = false;
                    return;
                }
                C1283.m16865("AnimationUtils", "Skipping view appearance animation - view is already in correct state.");
                ViewUtils.m3002(view, z);
                alpha.cancel();
                view.setAlpha(f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C1283.m16846("AnimationUtils", "onAnimationEnd");
                if (!this.f4607) {
                    ViewUtils.m3002(view, z);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                C1283.m16862("AnimationUtils", "onAnimationCancel");
                this.f4607 = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        alpha.start();
        return alpha;
    }
}
