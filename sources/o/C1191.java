package o;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.netflix.android.widgetry.widget.UserRatingButtonLottie_Ab9305$1;
import com.netflix.android.widgetry.widget.UserRatingButtonLottie_Ab9305$2;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.rxkotlin.SubscribersKt;
import o.C1177;
import o.C1269;
/* renamed from: o.ﺜ  reason: contains not printable characters */
public final class C1191 extends C1177 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1269.C1270 f15566;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0676 f15567;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1269 f15568;

    public C1191(Context context) {
        this(context, null, 0, 6, null);
    }

    public C1191(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1191(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        CharSequence charSequence = this.f15477;
        C1457Fr.m5016((Object) charSequence, "mAccessibilityOverlayThumbUpDescription");
        CharSequence charSequence2 = this.f15482;
        C1457Fr.m5016((Object) charSequence2, "mAccessibilityOverlayThumbDownDescription");
        CharSequence charSequence3 = this.f15471;
        C1457Fr.m5016((Object) charSequence3, "mAccessibilityOverlayCloseDescription");
        CharSequence charSequence4 = this.f15481;
        C1457Fr.m5016((Object) charSequence4, "mAccessibilityOverlayFeedbackVideoRated");
        CharSequence charSequence5 = this.f15473;
        C1457Fr.m5016((Object) charSequence5, "mAccessibilityOverlayFeedbackRatingCancelled");
        this.f15566 = new C1269.C1270(charSequence, charSequence2, charSequence3, charSequence4, charSequence5);
        setClickable(false);
        Single<C0676> observeOn = C1269.f15922.m16796().observeOn(AndroidSchedulers.mainThread());
        C1457Fr.m5016((Object) observeOn, "UserRatingButtonOverlayL…dSchedulers.mainThread())");
        SubscribersKt.subscribeBy(observeOn, UserRatingButtonLottie_Ab9305$2.f165, new UserRatingButtonLottie_Ab9305$1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1191(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.ﺜ$iF  reason: case insensitive filesystem */
    static final class View$OnClickListenerC2411iF implements View.OnClickListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ CoordinatorLayout f15570;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C1191 f15571;

        View$OnClickListenerC2411iF(C1191 r1, CoordinatorLayout coordinatorLayout) {
            this.f15571 = r1;
            this.f15570 = coordinatorLayout;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f15571.m16455(this.f15570, false);
        }
    }

    @Override // o.C1177
    public void setOnRateListener(CoordinatorLayout coordinatorLayout, C1177.AbstractC1178 r4, boolean z, int i) {
        C1457Fr.m5025(coordinatorLayout, "host");
        C1457Fr.m5025(r4, "onRateListener");
        this.f15479 = m16404(r4);
        this.f15485.setOnClickListener(new View$OnClickListenerC2411iF(this, coordinatorLayout));
        if (z) {
            this.f15485.setOnLongClickListener(new Cif(this, coordinatorLayout));
            this.f15485.setOnTouchListener(new If(this));
        }
    }

    /* renamed from: o.ﺜ$if  reason: invalid class name */
    static final class Cif implements View.OnLongClickListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C1191 f15572;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ CoordinatorLayout f15573;

        Cif(C1191 r1, CoordinatorLayout coordinatorLayout) {
            this.f15572 = r1;
            this.f15573 = coordinatorLayout;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            this.f15572.m16455(this.f15573, true);
            return true;
        }
    }

    /* renamed from: o.ﺜ$If */
    static final class If implements View.OnTouchListener {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C1191 f15569;

        If(C1191 r1) {
            this.f15569 = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            C1269 r0;
            if (this.f15569.f15568 == null) {
                return false;
            }
            C1269 r02 = this.f15569.f15568;
            if (!(r02 != null ? r02.m16786() : false) || (r0 = this.f15569.f15568) == null) {
                return false;
            }
            C1457Fr.m5016((Object) motionEvent, "event");
            r0.m16784(motionEvent);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m16455(CoordinatorLayout coordinatorLayout, boolean z) {
        C1269 r0;
        C0662 r02;
        C1177.AbstractC1178 r3;
        if (this.f15479 == null) {
            C1276.m16820().mo5725("openOverlay called before setting OnRateListener");
        }
        if (this.f15568 == null && (r3 = this.f15479) != null) {
            Context context = getContext();
            C1457Fr.m5016((Object) context, "context");
            C1457Fr.m5016((Object) r3, "it");
            this.f15568 = new C1269(context, r3, this.f15566);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        C0676 r32 = this.f15567;
        if (!(r32 == null || (r0 = this.f15568) == null || (r02 = r0.m16785()) == null)) {
            Context context2 = getContext();
            C1457Fr.m5016((Object) context2, "context");
            r02.setNetflixLottieComposition(context2, r32);
        }
        C1269 r03 = this.f15568;
        if (r03 != null) {
            r03.m16783(coordinatorLayout, this);
        }
        C1177.AbstractC1178 r04 = this.f15479;
        if (r04 != null) {
            r04.mo1705(this, z);
        }
    }
}
