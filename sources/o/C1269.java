package o;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import com.netflix.android.widgetry.widget.UserRatingButtonOverlayLottie$Companion$ratingsCompositionCreator$2;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C0602;
import o.C0662;
import o.C1177;
/* renamed from: o.ﾉ */
public final class C1269 extends ViewGroup {

    /* renamed from: ˊˋ */
    private static C0676 f15919;

    /* renamed from: ˋˊ */
    private static final AbstractC1433Et f15920 = C1435Ev.m4972(UserRatingButtonOverlayLottie$Companion$ratingsCompositionCreator$2.f166);

    /* renamed from: ˎ */
    static final /* synthetic */ FQ[] f15921 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C1269.class), "thumbLottie", "getThumbLottie()Lcom/netflix/mediaclient/android/widget/NetflixLottieAnimationView;"))};

    /* renamed from: ˏ */
    public static final C1271 f15922 = new C1271(null);

    /* renamed from: ʻ */
    private CoordinatorLayout f15923;

    /* renamed from: ʻॱ */
    private C0670 f15924;

    /* renamed from: ʼ */
    private C1191 f15925;

    /* renamed from: ʼॱ */
    private int f15926;

    /* renamed from: ʽ */
    private final Rect f15927 = new Rect();

    /* renamed from: ʽॱ */
    private int f15928;

    /* renamed from: ʾ */
    private final Cif f15929 = new Cif(this);

    /* renamed from: ʿ */
    private int f15930;

    /* renamed from: ˈ */
    private int f15931;

    /* renamed from: ˊ */
    private boolean f15932;

    /* renamed from: ˊˊ */
    private final C1177.AbstractC1178 f15933;

    /* renamed from: ˊॱ */
    private boolean f15934 = true;

    /* renamed from: ˊᐝ */
    private final C1270 f15935;

    /* renamed from: ˋ */
    private final Paint f15936 = new Paint();

    /* renamed from: ˋॱ */
    private final ColorDrawable f15937;

    /* renamed from: ˏॱ */
    private C0926 f15938;

    /* renamed from: ͺ */
    private final int[] f15939 = new int[2];

    /* renamed from: ॱ */
    private final FI f15940 = C1197.m16465(this, C0602.IF.thumb_lottie);

    /* renamed from: ॱˊ */
    private boolean f15941;

    /* renamed from: ॱˋ */
    private final int[] f15942 = new int[2];

    /* renamed from: ॱˎ */
    private final Map<String, CharSequence> f15943;

    /* renamed from: ॱॱ */
    private boolean f15944;

    /* renamed from: ॱᐝ */
    private final List<C0926> f15945 = new ArrayList();

    /* renamed from: ᐝ */
    private final Rect f15946 = new Rect();

    /* renamed from: ᐝॱ */
    private final AccessibilityManager f15947;

    /* renamed from: ˏ */
    public final C0662 m16785() {
        return (C0662) this.f15940.mo4986(this, f15921[0]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1269(Context context, C1177.AbstractC1178 r8, C1270 r9) {
        super(context);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(r8, "onRateListener");
        C1457Fr.m5025(r9, "accessibilityStrings");
        this.f15933 = r8;
        this.f15935 = r9;
        View.inflate(context, C0602.C0606.user_rating_overlay_lottie, this);
        m16785().setAnimationListener(this.f15929);
        m16785().setShowTapAreaBorder(this.f15932);
        this.f15931 = getResources().getDimensionPixelSize(C0602.C0603.thumbs_lottie_target_overlap_offset_a) * -1;
        this.f15928 = getResources().getDimensionPixelSize(C0602.C0603.thumbs_lottie_target_overlap_offset_b) * -1;
        this.f15937 = new ColorDrawable(ContextCompat.getColor(context, C0602.Cif.thumb_button_dark_dim));
        this.f15930 = getResources().getDimensionPixelSize(C0602.C0603.thumbs_overlay_button_size);
        this.f15936.setColor(-65536);
        this.f15936.setStyle(Paint.Style.STROKE);
        this.f15936.setStrokeWidth(1.5f);
        Object systemService = context.getSystemService("accessibility");
        this.f15947 = systemService != null ? (AccessibilityManager) systemService : null;
        this.f15943 = ES.m4862(C1438Ey.m4973("nflx-close-up", this.f15935.m16788()), C1438Ey.m4973("nflx-close-down", this.f15935.m16788()), C1438Ey.m4973("nflx-dislikeSelect-up", this.f15935.m16791()), C1438Ey.m4973("nflx-dislikeSelect-down", this.f15935.m16791()), C1438Ey.m4973("nflx-likeSelect-up", this.f15935.m16790()), C1438Ey.m4973("nflx-likeSelect-down", this.f15935.m16790()));
    }

    /* renamed from: o.ﾉ$ˊ */
    public static final class C1270 {

        /* renamed from: ˊ */
        private final CharSequence f15949;

        /* renamed from: ˋ */
        private final CharSequence f15950;

        /* renamed from: ˎ */
        private final CharSequence f15951;

        /* renamed from: ˏ */
        private final CharSequence f15952;

        /* renamed from: ॱ */
        private final CharSequence f15953;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1270)) {
                return false;
            }
            C1270 r2 = (C1270) obj;
            return C1457Fr.m5018(this.f15952, r2.f15952) && C1457Fr.m5018(this.f15953, r2.f15953) && C1457Fr.m5018(this.f15950, r2.f15950) && C1457Fr.m5018(this.f15949, r2.f15949) && C1457Fr.m5018(this.f15951, r2.f15951);
        }

        public int hashCode() {
            CharSequence charSequence = this.f15952;
            int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.f15953;
            int hashCode2 = (hashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            CharSequence charSequence3 = this.f15950;
            int hashCode3 = (hashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
            CharSequence charSequence4 = this.f15949;
            int hashCode4 = (hashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
            CharSequence charSequence5 = this.f15951;
            return hashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0);
        }

        public String toString() {
            return "AccessibilityStrings(thumbUp=" + this.f15952 + ", thumbDown=" + this.f15953 + ", close=" + this.f15950 + ", feedbackVideoRated=" + this.f15949 + ", feedbackRatingCancelled=" + this.f15951 + ")";
        }

        public C1270(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
            C1457Fr.m5025(charSequence, "thumbUp");
            C1457Fr.m5025(charSequence2, "thumbDown");
            C1457Fr.m5025(charSequence3, "close");
            C1457Fr.m5025(charSequence4, "feedbackVideoRated");
            C1457Fr.m5025(charSequence5, "feedbackRatingCancelled");
            this.f15952 = charSequence;
            this.f15953 = charSequence2;
            this.f15950 = charSequence3;
            this.f15949 = charSequence4;
            this.f15951 = charSequence5;
        }

        /* renamed from: ˏ */
        public final CharSequence m16790() {
            return this.f15952;
        }

        /* renamed from: ॱ */
        public final CharSequence m16791() {
            return this.f15953;
        }

        /* renamed from: ˋ */
        public final CharSequence m16788() {
            return this.f15950;
        }

        /* renamed from: ˎ */
        public final CharSequence m16789() {
            return this.f15949;
        }

        /* renamed from: ˊ */
        public final CharSequence m16787() {
            return this.f15951;
        }
    }

    /* renamed from: o.ﾉ$ˋ */
    public static final class C1271 {

        /* renamed from: ˊ */
        static final /* synthetic */ FQ[] f15954 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C1271.class), "ratingsCompositionCreator", "getRatingsCompositionCreator()Lio/reactivex/Single;"))};

        /* renamed from: ॱ */
        public final Single<C0676> m16796() {
            AbstractC1433Et et = C1269.f15920;
            FQ fq = f15954[0];
            return (Single) et.mo3220();
        }

        private C1271() {
        }

        public /* synthetic */ C1271(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: public */
        /* renamed from: ˊ */
        private final void m16793(C0676 r1) {
            C1269.f15919 = r1;
        }

        /* access modifiers changed from: public */
        /* renamed from: ˎ */
        private final C0676 m16795() {
            return C1269.f15919;
        }
    }

    public final void setDrawDebugBorder(boolean z) {
        this.f15932 = z;
    }

    /* renamed from: o.ﾉ$if */
    public static final class Cif implements C0662.AbstractC0664 {

        /* renamed from: ˏ */
        final /* synthetic */ C1269 f15948;

        Cif(C1269 r1) {
            this.f15948 = r1;
        }

        @Override // o.C0662.AbstractC0664
        /* renamed from: ˎ */
        public void mo14857(String str) {
            C1457Fr.m5025(str, "tag");
            this.f15948.f15941 = true;
            C1191 r4 = this.f15948.f15925;
            if (r4 == null) {
                return;
            }
            if (Ge.m5067(str, "nflx-dislikeSelect", false, 2, null)) {
                this.f15948.f15933.mo1703(r4, 1);
            } else if (Ge.m5067(str, "nflx-likeSelect", false, 2, null)) {
                this.f15948.f15933.mo1703(r4, 2);
            } else if (Ge.m5067(str, "nflx-dislikeDeselect", false, 2, null) || Ge.m5067(str, "nflx-likeDeselect", false, 2, null)) {
                this.f15948.f15933.mo1703(r4, 0);
            }
        }

        @Override // o.C0662.AbstractC0664
        /* renamed from: ॱ */
        public void mo14858(String str) {
            C1457Fr.m5025(str, "tag");
            C1191 r5 = this.f15948.f15925;
            if (r5 != null) {
                if (Ge.m5067(str, "nflx-dislikeSelect", false, 2, null)) {
                    r5.setRating(1);
                } else if (Ge.m5067(str, "nflx-likeSelect", false, 2, null)) {
                    r5.setRating(2);
                } else if (Ge.m5067(str, "nflx-dislikeDeselect", false, 2, null) || Ge.m5067(str, "nflx-likeDeselect", false, 2, null)) {
                    r5.setRating(0);
                }
            }
            if (!Ge.m5067(str, "nflx-thumbExpand", false, 2, null)) {
                this.f15948.m16773(!Ge.m5067(str, "nflx-close", false, 2, null));
            } else {
                this.f15948.m16782();
            }
            this.f15948.f15941 = false;
        }
    }

    /* renamed from: ˋ */
    private final String m16771() {
        return this.f15934 ? "-up" : "-down";
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15932 && canvas != null) {
            canvas.drawRect(this.f15946, this.f15936);
        }
    }

    /* renamed from: ʼ */
    private final void m16767() {
        ImageView r0;
        if (this.f15925 != null && this.f15923 != null) {
            C1191 r02 = this.f15925;
            if (!(r02 == null || (r0 = r02.m16405()) == null)) {
                r0.getLocationInWindow(this.f15939);
            }
            CoordinatorLayout coordinatorLayout = this.f15923;
            if (coordinatorLayout != null) {
                coordinatorLayout.getLocationInWindow(this.f15942);
            }
            int[] iArr = this.f15939;
            iArr[0] = iArr[0] - this.f15942[0];
            int[] iArr2 = this.f15939;
            iArr2[1] = iArr2[1] - this.f15942[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if ((z || this.f15944) && this.f15925 != null && this.f15923 != null) {
            m16767();
            C1191 r5 = this.f15925;
            if (r5 != null) {
                this.f15946.left = this.f15939[0];
                this.f15946.top = this.f15939[1];
                Rect rect = this.f15946;
                int i5 = this.f15939[0];
                ImageView r2 = r5.m16405();
                C1457Fr.m5016((Object) r2, "it.iconView");
                rect.right = i5 + r2.getMeasuredWidth();
                Rect rect2 = this.f15946;
                int i6 = this.f15939[1];
                ImageView r22 = r5.m16405();
                C1457Fr.m5016((Object) r22, "it.iconView");
                rect2.bottom = i6 + r22.getMeasuredHeight();
            }
            int measuredWidth = m16785().getMeasuredWidth();
            this.f15927.left = (this.f15931 + this.f15946.centerX()) - (measuredWidth / 2);
            this.f15927.top = (this.f15928 + this.f15946.centerY()) - (measuredWidth / 2);
            this.f15927.right = this.f15928 + this.f15946.left + ((measuredWidth * 3) / 4);
            this.f15927.bottom = this.f15931 + this.f15946.top + ((measuredWidth * 3) / 4);
            C1283.m16854("UserRatingButtonOverlayLottie", "onLayout -> " + measuredWidth + " : " + this.f15946 + " : " + this.f15927);
            m16785().layout(this.f15927.left, this.f15927.top, this.f15927.right, this.f15927.bottom);
            this.f15944 = false;
            m16785().setResetViewScaleFactor(true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        measureChild(m16785(), i, i2);
    }

    /* renamed from: ˏ */
    private final void m16777(String str) {
        C0926 r3 = m16785().m14851(str + m16771());
        if (r3 != null) {
            this.f15945.add(r3);
        }
    }

    /* renamed from: ˊ */
    public final void m16783(CoordinatorLayout coordinatorLayout, C1191 r7) {
        ImageView r0;
        C1457Fr.m5025(coordinatorLayout, "coordinatorLayout");
        C1457Fr.m5025(r7, "targetButton");
        if (this.f15923 == null) {
            this.f15926 = r7.m16403();
            this.f15923 = coordinatorLayout;
            this.f15925 = r7;
            C1191 r02 = this.f15925;
            if (!(r02 == null || (r0 = r02.m16405()) == null)) {
                r0.setVisibility(4);
            }
            m16776(true);
            CoordinatorLayout coordinatorLayout2 = this.f15923;
            if (coordinatorLayout2 != null) {
                coordinatorLayout2.addView(this, new CoordinatorLayout.LayoutParams(-1, -1));
            }
            this.f15944 = true;
            C1191 r03 = this.f15925;
            if (r03 == null || r03.m16403() != 0) {
                setBackground(new ColorDrawable(0));
            } else {
                setBackground(this.f15937);
            }
            m16768();
            this.f15945.clear();
            m16777("nflx-close");
            m16777("nflx-likeSelect");
            m16777("nflx-dislikeSelect");
        }
    }

    /* renamed from: ॱॱ */
    private final void m16782() {
        this.f15924 = new C0670(m16785(), this.f15943, this.f15945);
        ViewCompat.setAccessibilityDelegate(m16785(), this.f15924);
        ViewCompat.setImportantForAccessibility(m16785(), 1);
        m16785().getAccessibilityNodeProvider().performAction(0, 64, null);
    }

    /* renamed from: ॱ */
    public final boolean m16786() {
        return this.f15923 != null;
    }

    /* renamed from: ˋ */
    private final void m16773(boolean z) {
        ImageView r0;
        C1191 r02 = this.f15925;
        if (!(r02 == null || (r0 = r02.m16405()) == null)) {
            r0.setVisibility(0);
        }
        m16770(z ? this.f15935.m16789() : this.f15935.m16787());
        CoordinatorLayout coordinatorLayout = this.f15923;
        if (coordinatorLayout != null) {
            coordinatorLayout.removeView(this);
        }
        m16776(false);
        this.f15923 = null;
        this.f15925 = null;
        this.f15938 = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "event");
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "event");
        if (m16785().m14847(motionEvent)) {
            return false;
        }
        if (this.f15941) {
            return true;
        }
        C0662.m14843(m16785(), "nflx-close" + m16771(), 0, 2, null);
        C1191 r5 = this.f15925;
        if (r5 == null) {
            return true;
        }
        this.f15933.mo1702(r5);
        return true;
    }

    /* renamed from: ʽ */
    private final void m16768() {
        m16767();
        this.f15934 = this.f15939[1] - ((this.f15930 * 3) / 2) >= 0;
        C1191 r0 = this.f15925;
        Integer valueOf = r0 != null ? Integer.valueOf(r0.m16403()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            C0662.m14843(m16785(), "nflx-thumbExpand" + m16771(), 0, 2, null);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            C0662.m14843(m16785(), "nflx-dislikeDeselect" + m16771(), 0, 2, null);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            C0662.m14843(m16785(), "nflx-likeDeselect" + m16771(), 0, 2, null);
        }
    }

    /* renamed from: ˎ */
    public final void m16784(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "event");
        switch (motionEvent.getAction()) {
            case 1:
                if (this.f15938 == null && this.f15926 == 0) {
                    if (this.f15941) {
                        this.f15941 = false;
                        m16785().m14();
                        C0926 r5 = m16785().m14851("nflx-thumbExpand" + m16771());
                        if (r5 != null) {
                            m16785().m14848("nflx-close" + m16771(), m16785().m14849() - r5.m15737());
                        }
                    } else {
                        C0662.m14843(m16785(), "nflx-close" + m16771(), 0, 2, null);
                    }
                    C1191 r52 = this.f15925;
                    if (r52 != null) {
                        this.f15933.mo1702(r52);
                    }
                }
                C0926 r53 = this.f15938;
                if (r53 != null) {
                    C0662.m14843(m16785(), r53.m15734(), 0, 2, null);
                }
                this.f15938 = null;
                return;
            case 2:
                C0926 r54 = m16785().m14846(motionEvent);
                if (!C1457Fr.m5018(r54, this.f15938)) {
                    this.f15938 = r54;
                    if (r54 != null) {
                        m16785().performHapticFeedback(1);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: ˎ */
    private final void m16776(boolean z) {
        CoordinatorLayout coordinatorLayout = this.f15923;
        if (coordinatorLayout != null) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (!C1457Fr.m5018(childAt, this)) {
                    ViewCompat.setImportantForAccessibility(childAt, z ? 4 : 1);
                }
            }
        }
    }

    /* renamed from: ˊ */
    private final void m16770(CharSequence charSequence) {
        AccessibilityManager accessibilityManager = this.f15947;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager != null ? accessibilityManager.getEnabledAccessibilityServiceList(1) : null;
        if (enabledAccessibilityServiceList != null) {
            if (!enabledAccessibilityServiceList.isEmpty()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
                C1457Fr.m5016((Object) obtain, "event");
                obtain.getText().add(charSequence);
                obtain.setEnabled(true);
                Context context = getContext();
                C1457Fr.m5016((Object) context, "context");
                obtain.setPackageName(context.getPackageName());
                AccessibilityManager accessibilityManager2 = this.f15947;
                if (accessibilityManager2 != null) {
                    accessibilityManager2.sendAccessibilityEvent(obtain);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "event");
        C0670 r1 = this.f15924;
        if (r1 == null || !r1.dispatchHoverEvent(motionEvent)) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return true;
    }
}
