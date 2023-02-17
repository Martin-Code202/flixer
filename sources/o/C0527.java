package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.ViewUtils;
import o.C0567;
/* renamed from: o.ԁ  reason: contains not printable characters */
public final class C0527 extends C0616 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C0531 f13712 = new C0531(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final iF f13713 = new iF.C0529();

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final iF f13714 = new iF.Cif();

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final iF f13715 = new iF.C0528iF();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final View f13716;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Runnable f13717;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final AnimatedVectorDrawableCompat f13718;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Runnable f13719;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0527(View view, C0567.Cif ifVar, AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        super(view, ifVar, R.id.animated_loading_view);
        C1457Fr.m5025(view, "parent");
        this.f13716 = view;
        this.f13718 = animatedVectorDrawableCompat;
        this.f13719 = new RunnableC0530(this);
        this.f13717 = new Cif(this);
        mo14570(false);
    }

    /* renamed from: o.ԁ$ˋ  reason: contains not printable characters */
    public static final class C0531 extends C1277 {
        private C0531() {
            super("AnimatedLoadingAndErrorWrapper");
        }

        public /* synthetic */ C0531(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final AnimatedVectorDrawableCompat m14572(Context context, iF iFVar) {
            try {
                return AnimatedVectorDrawableCompat.create(context, iFVar.mo14571());
            } catch (Exception e) {
                C1276.m16820().mo5729("Unable to start or load animatedVectorDrawable " + iFVar.mo14571() + " as " + context.getResources().getResourceName(iFVar.mo14571()), e);
                return null;
            }
        }
    }

    /* renamed from: o.ԁ$iF */
    public static abstract class iF {
        /* renamed from: ˏ  reason: contains not printable characters */
        public abstract int mo14571();

        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }

        /* renamed from: o.ԁ$iF$if  reason: invalid class name */
        public static final class Cif extends iF {
            public Cif() {
                super(null);
            }

            @Override // o.C0527.iF
            /* renamed from: ˏ */
            public int mo14571() {
                return R.drawable.avd_loading_skeleton_lolomo_billboard;
            }
        }

        /* renamed from: o.ԁ$iF$iF  reason: collision with other inner class name */
        public static final class C0528iF extends iF {
            public C0528iF() {
                super(null);
            }

            @Override // o.C0527.iF
            /* renamed from: ˏ */
            public int mo14571() {
                return R.drawable.avd_loading_skeleton_lolomo;
            }
        }

        /* renamed from: o.ԁ$iF$ˊ  reason: contains not printable characters */
        public static final class C0529 extends iF {
            public C0529() {
                super(null);
            }

            @Override // o.C0527.iF
            /* renamed from: ˏ */
            public int mo14571() {
                return R.drawable.avd_loading_skeleton_gallery;
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0527(android.view.View r4, o.C0567.Cif r5, o.C0527.iF r6) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            o.C1457Fr.m5025(r4, r0)
            java.lang.String r0 = "screenType"
            o.C1457Fr.m5025(r6, r0)
            o.ԁ$ˋ r0 = o.C0527.f13712
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "parent.context"
            o.C1457Fr.m5016(r1, r2)
            android.support.graphics.drawable.AnimatedVectorDrawableCompat r0 = o.C0527.C0531.m14573(r0, r1, r6)
            r3.<init>(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0527.<init>(android.view.View, o.צ$if, o.ԁ$iF):void");
    }

    /* renamed from: o.ԁ$ˊ  reason: contains not printable characters */
    static final class RunnableC0530 implements Runnable {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C0527 f13721;

        RunnableC0530(C0527 r1) {
            this.f13721 = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C1348Bu.m4093();
            if (!ViewUtils.m3005(this.f13721.f13925)) {
                C0531 r2 = C0527.f13712;
                BQ.m3914(this.f13721.f13925, false);
                this.f13721.m14568();
            }
        }
    }

    /* renamed from: o.ԁ$if  reason: invalid class name */
    static final class Cif implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C0527 f13720;

        Cif(C0527 r1) {
            this.f13720 = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C1348Bu.m4093();
            if (!ViewUtils.m3005(this.f13720.f13925)) {
                C0531 r2 = C0527.f13712;
                BQ.m3914(this.f13720.f13925, true);
                this.f13720.m14568();
            }
        }
    }

    @Override // o.C0616
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo14570(boolean z) {
        mo14569();
        super.mo14663(z);
        View view = this.f13925;
        C1457Fr.m5016((Object) view, "loading");
        if (view.getVisibility() == 0) {
            C0531 r4 = f13712;
            return;
        }
        C0531 r42 = f13712;
        this.f13922.postDelayed(z ? this.f13717 : this.f13719, C0616.f13921);
    }

    /* access modifiers changed from: protected */
    @Override // o.C0616
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo14569() {
        this.f13922.removeCallbacks(this.f13719);
        this.f13922.removeCallbacks(this.f13717);
        m14565();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m14568() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
        if (!C1322Av.m3792() && (animatedVectorDrawableCompat = this.f13718) != null) {
            View view = this.f13925;
            C1457Fr.m5016((Object) view, "loading");
            m14566(view, animatedVectorDrawableCompat);
            View view2 = this.f13925;
            C1457Fr.m5016((Object) view2, "loading");
            view2.setBackground(animatedVectorDrawableCompat);
            if (!animatedVectorDrawableCompat.isRunning()) {
                animatedVectorDrawableCompat.start();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m14566(View view, Drawable drawable) {
        if (drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
            float intrinsicHeight = ((float) drawable.getIntrinsicHeight()) / ((float) drawable.getIntrinsicWidth());
            C1281 r4 = C1281.f15992;
            Resources resources = ((Context) C1281.m16832(Context.class)).getResources();
            C1457Fr.m5016((Object) resources, "Lookup.get<Context>().resources");
            int i = resources.getDisplayMetrics().widthPixels;
            view.getLayoutParams().width = i;
            view.getLayoutParams().height = (int) (((float) i) * intrinsicHeight);
            view.requestLayout();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m14565() {
        if (!C1322Av.m3792()) {
            View view = this.f13925;
            C1457Fr.m5016((Object) view, "loading");
            Drawable background = view.getBackground();
            if (background instanceof AnimatedVectorDrawableCompat) {
                if (((AnimatedVectorDrawableCompat) background).isRunning()) {
                    ((AnimatedVectorDrawableCompat) background).stop();
                }
                View view2 = this.f13925;
                C1457Fr.m5016((Object) view2, "loading");
                view2.setBackground(null);
            }
        }
    }
}
