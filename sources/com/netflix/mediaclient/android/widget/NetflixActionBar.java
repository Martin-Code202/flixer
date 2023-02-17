package com.netflix.mediaclient.android.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.util.Property;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.TextView;
import com.netflix.android.widgetry.widget.ScrollAwayBehavior;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.ViewUtils;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref;
import o.ActivityC2153sl;
import o.BX;
import o.C0525;
import o.C0549;
import o.C0727;
import o.C0772;
import o.C0828;
import o.C1004;
import o.C1276;
import o.C1283;
import o.C1456Fq;
import o.C1457Fr;
import o.C2221uu;
public class NetflixActionBar {

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static final C0011 f889 = new C0011(null);

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static final TypedValue f890 = new TypedValue();

    /* renamed from: ʻ  reason: contains not printable characters */
    private final View f891;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final Drawable f892;

    /* renamed from: ʼ  reason: contains not printable characters */
    private ActionBar.LayoutParams f893;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Animator f894;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final ActionBar f895;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C2221uu f896;

    /* renamed from: ˋ  reason: contains not printable characters */
    private View f897;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final Drawable f898;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ViewGroup f899;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final TextView f900;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f901;

    /* renamed from: ͺ  reason: contains not printable characters */
    private iF f902;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0772 f903;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f904;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final int f905 = R.drawable.ab_logo;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final NetflixActivity f906;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private View f907;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final C0828 f908;

    public enum LogoType {
        START_ALIGNED,
        START_MONOCHROME,
        CENTERED
    }

    public NetflixActionBar(NetflixActivity netflixActivity, C0828 r7) {
        C1457Fr.m5025(netflixActivity, "activity");
        this.f906 = netflixActivity;
        this.f908 = r7;
        View findViewById = this.f906.findViewById(this.f906.getActionBarParentViewId());
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        View inflate = LayoutInflater.from(this.f906).inflate(R.layout.action_bar, viewGroup, false);
        if (inflate == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        this.f899 = (ViewGroup) inflate;
        if (this.f908 != null) {
            this.f899.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) { // from class: com.netflix.mediaclient.android.widget.NetflixActionBar.3

                /* renamed from: ˊ  reason: contains not printable characters */
                final /* synthetic */ NetflixActionBar f909;

                {
                    this.f909 = r1;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    NetflixActionBar netflixActionBar = this.f909;
                    C1457Fr.m5016((Object) windowInsets, "insets");
                    netflixActionBar.f904 = windowInsets.getSystemWindowInsetTop();
                    C1004.m15959(this.f909.f899, 1, this.f909.f904);
                    return windowInsets;
                }
            });
            this.f899.setFitsSystemWindows(true);
        }
        View findViewById2 = this.f899.findViewById(R.id.action_bar);
        C1457Fr.m5016((Object) findViewById2, "actionBarGroup.findViewById(R.id.action_bar)");
        this.f903 = (C0772) findViewById2;
        View findViewById3 = this.f899.findViewById(R.id.centered_title);
        C1457Fr.m5016((Object) findViewById3, "actionBarGroup.findViewById(R.id.centered_title)");
        this.f900 = (TextView) findViewById3;
        View findViewById4 = this.f899.findViewById(R.id.centered_logo);
        C1457Fr.m5016((Object) findViewById4, "actionBarGroup.findViewById(R.id.centered_logo)");
        this.f891 = findViewById4;
        viewGroup.addView(this.f899, new ViewGroup.LayoutParams(-1, -2));
        this.f906.setSupportActionBar(this.f903);
        ActionBar supportActionBar = this.f906.getSupportActionBar();
        if (supportActionBar == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.app.ActionBar");
        }
        this.f895 = supportActionBar;
        this.f895.setDisplayShowHomeEnabled(true);
        m342();
        m340();
        m330();
        if (this.f903.getBackground() != null) {
            this.f903.getBackground().mutate();
        }
        this.f892 = this.f903.getBackground();
        this.f898 = this.f903.getNavigationIcon();
        this.f902 = m345().mo394(this.f903.getTitle()).mo392();
        if (C0727.m15067() && (this.f906 instanceof ActivityC2153sl)) {
            this.f896 = new C2221uu(this, (ActivityC2153sl) this.f906);
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final NetflixActivity m353() {
        return this.f906;
    }

    /* renamed from: com.netflix.mediaclient.android.widget.NetflixActionBar$ˊ  reason: contains not printable characters */
    public static final class C0011 {
        private C0011() {
        }

        public /* synthetic */ C0011(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final TypedValue m404() {
            return NetflixActionBar.f890;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final ActionBar m349() {
        return this.f895;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final C0772 m358() {
        return this.f903;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public final View m347() {
        return this.f897;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final C2221uu m367() {
        return this.f896;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final iF.AbstractC0010 m345() {
        return iF.f914.m385().mo387(this.f892).mo398(this.f898).mo397(this.f903.m15226()).mo393(this.f903.m15229()).mo400(this.f903.m15228()).mo390(this.f903.m15227());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final boolean m346() {
        switch (this.f901) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                return this.f903.getVisibility() == 0;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m361(boolean z) {
        if (this.f899.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            ScrollAwayBehavior scrollAwayBehavior = z ? new ScrollAwayBehavior(48) : null;
            ViewGroup.LayoutParams layoutParams = this.f899.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.design.widget.CoordinatorLayout.LayoutParams");
            }
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(scrollAwayBehavior);
            this.f899.requestLayout();
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final void m366() {
        if (m339()) {
            m361(false);
            m361(true);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean m339() {
        if (!(this.f899.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = this.f899.getLayoutParams();
        if (layoutParams != null) {
            return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() != null;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.design.widget.CoordinatorLayout.LayoutParams");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m364(int i) {
        C1457Fr.m5018(this.f903.getBackground(), this.f892);
        if (this.f903.getBackground() != null) {
            Drawable background = this.f903.getBackground();
            C1457Fr.m5016((Object) background, "toolbar.background");
            if (background.getAlpha() != i) {
                Drawable background2 = this.f903.getBackground();
                C1457Fr.m5016((Object) background2, "toolbar.background");
                background2.setAlpha(i);
            }
        }
        C0828 r2 = this.f908;
        if (r2 != null) {
            float f = ((float) i) / 255.0f;
            if (r2.getAlpha() != f) {
                r2.setAlpha(f);
            }
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public final int m363() {
        return this.f899.getHeight() > 0 ? this.f899.getHeight() : ViewUtils.m3006(this.f906);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m340() {
        for (View view : C0549.m14593(this.f903)) {
            if ((view instanceof ImageView) && ((ImageView) view).getDrawable() != null && ((ImageView) view).getDrawable() == this.f903.getNavigationIcon()) {
                this.f897 = view;
                ((ImageView) view).setId(R.id.menu_navigation_button_view);
                return;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m330() {
        Drawable navigationIcon = this.f903.getNavigationIcon();
        if (navigationIcon != null && this.f906.getTheme().resolveAttribute(R.attr.actionBarIconColor, f889.m404(), true)) {
            this.f903.setNavigationIcon(BrowseExperience.m1778(navigationIcon, this.f906, (int) R.attr.actionBarIconColor));
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final void m342() {
        View findViewById = this.f906.findViewById(16908332);
        if (findViewById != null) {
            ViewParent parent = findViewById.getParent();
            if (parent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setFocusable(false);
            if (viewGroup.getParent() instanceof View) {
                ViewParent parent2 = viewGroup.getParent();
                if (parent2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                }
                ((View) parent2).setFocusable(false);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final boolean m352(MenuItem menuItem) {
        C1457Fr.m5025(menuItem, "item");
        C1283.m16846("NetflixActionBar", "handleHomeButtonSelected, id: " + menuItem.getItemId());
        if (menuItem.getItemId() == 16908332) {
            return m343();
        }
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int m333(int i) {
        if ((i == 3 || i == 4) && BX.m3957()) {
            return i == 3 ? 1 : 0;
        }
        return i;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x012f: APUT  (r2v1 float[]), (0 ??[int, short, byte, char]), (r3v0 float) */
    @SuppressLint({"SwitchIntDef"})
    /* renamed from: ˊ  reason: contains not printable characters */
    private final Animator m328(int i, boolean z, int i2) {
        int i3;
        ObjectAnimator objectAnimator;
        int r5 = m333(i);
        if (this.f903.getWidth() > 0) {
            i3 = this.f903.getWidth();
        } else {
            Resources resources = this.f906.getResources();
            C1457Fr.m5016((Object) resources, "activity.resources");
            i3 = resources.getDisplayMetrics().widthPixels;
        }
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.f4253 = 0.0f;
        Ref.FloatRef floatRef2 = new Ref.FloatRef();
        floatRef2.f4253 = 0.0f;
        switch (r5) {
            case 0:
                float x = (this.f903.getX() <= 0.0f || this.f903.getX() >= ((float) i3)) ? z ? -((float) i3) : 0.0f : this.f903.getX();
                this.f903.setY(0.0f);
                floatRef.f4253 = z ? 0.0f : -((float) i3);
                objectAnimator = ObjectAnimator.ofFloat(this.f903, View.TRANSLATION_X, x, floatRef.f4253);
                break;
            case 1:
                float x2 = (this.f903.getX() <= 0.0f || this.f903.getX() >= ((float) i3)) ? z ? (float) i3 : 0.0f : this.f903.getX();
                this.f903.setY(0.0f);
                floatRef.f4253 = z ? 0.0f : (float) i3;
                objectAnimator = ObjectAnimator.ofFloat(this.f903, View.TRANSLATION_X, x2, floatRef.f4253);
                break;
            case 2:
                float y = (this.f903.getY() <= ((float) (-this.f903.getHeight())) || this.f903.getY() >= 0.0f) ? z ? -((float) this.f903.getHeight()) : 0.0f : this.f903.getY();
                this.f903.setX(0.0f);
                floatRef2.f4253 = z ? 0.0f : -((float) this.f903.getHeight());
                objectAnimator = ObjectAnimator.ofFloat(this.f903, View.TRANSLATION_Y, y, floatRef2.f4253);
                break;
            default:
                C0772 r0 = this.f903;
                Property property = View.TRANSLATION_Y;
                float[] fArr = new float[1];
                fArr[0] = z ? 0.0f : -((float) this.f903.getHeight());
                objectAnimator = ObjectAnimator.ofFloat(r0, property, fArr);
                break;
        }
        C1457Fr.m5016((Object) objectAnimator, "animator");
        objectAnimator.setDuration(150L);
        objectAnimator.setAutoCancel(true);
        objectAnimator.addListener(new C0012(this, i2, floatRef, floatRef2));
        this.f894 = objectAnimator;
        return objectAnimator;
    }

    /* renamed from: com.netflix.mediaclient.android.widget.NetflixActionBar$ˋ  reason: contains not printable characters */
    public static final class C0012 extends AnimatorListenerAdapter {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ Ref.FloatRef f915;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ Ref.FloatRef f916;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ int f917;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ NetflixActionBar f918;

        C0012(NetflixActionBar netflixActionBar, int i, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
            this.f918 = netflixActionBar;
            this.f917 = i;
            this.f915 = floatRef;
            this.f916 = floatRef2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f918.f901 = this.f917 == 0 ? 1 : 2;
            this.f918.m358().setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f918.m358().setVisibility(this.f917);
            this.f918.m358().setTranslationX(this.f915.f4253);
            this.f918.m358().setTranslationY(this.f916.f4253);
            if (this.f917 == 8) {
                this.f918.m349().hide();
            }
            this.f918.f901 = 0;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m350(boolean z) {
        m351(z, 2);
    }

    @SuppressLint({"SwitchIntDef"})
    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m351(boolean z, int i) {
        if (!z || this.f901 == 2) {
            m344();
            this.f903.setVisibility(8);
            return;
        }
        this.f901 = 2;
        m328(i, false, 8).start();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m356(boolean z) {
        m357(z, 2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m357(boolean z, int i) {
        if (!z || this.f901 == 1) {
            m344();
            this.f903.setTranslationX(0.0f);
            this.f903.setTranslationY(0.0f);
            this.f903.setVisibility(0);
        } else {
            this.f901 = 1;
            m328(i, true, 0).start();
        }
        this.f895.show();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Animator m354(int i) {
        return m328(i, true, 0);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final Animator m348(int i) {
        return m328(i, false, 8);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final void m344() {
        Animator animator = this.f894;
        if (animator != null) {
            animator.cancel();
            this.f894 = null;
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public final void m362() {
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final boolean m343() {
        if (!this.f902.mo368()) {
            return false;
        }
        C1283.m16846("NetflixActionBar", "performing up action");
        this.f906.performUpAction();
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m359(float f) {
        ViewPropertyAnimator animate;
        this.f903.animate().cancel();
        this.f903.setAlpha(f);
        C0828 r0 = this.f908;
        if (!(r0 == null || (animate = r0.animate()) == null)) {
            animate.cancel();
        }
        C0828 r02 = this.f908;
        if (r02 != null) {
            r02.setAlpha(f);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m360(float f, int i) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator alpha2 = this.f903.animate().alpha(f);
        C1457Fr.m5016((Object) alpha2, "toolbar.animate().alpha(alpha)");
        alpha2.setDuration((long) i);
        C0828 r0 = this.f908;
        if (r0 != null && (animate = r0.animate()) != null && (alpha = animate.alpha(f)) != null) {
            alpha.setDuration((long) i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m365(View view, ActionBar.LayoutParams layoutParams) {
        this.f895.setCustomView(view, layoutParams);
        this.f907 = view;
        this.f893 = layoutParams;
        this.f895.setDisplayShowCustomEnabled(view != null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m338(boolean z, int i) {
        if (i == 1) {
            this.f900.setVisibility(z ? 0 : 8);
            this.f895.setDisplayShowTitleEnabled(false);
            return;
        }
        this.f895.setDisplayShowTitleEnabled(z);
        this.f900.setVisibility(8);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m336(boolean z, LogoType logoType) {
        Drawable drawable;
        if (!z) {
            this.f891.setVisibility(8);
            this.f895.setDisplayUseLogoEnabled(false);
            this.f903.setLogo((Drawable) null);
        } else if (C1457Fr.m5018(logoType, LogoType.CENTERED)) {
            this.f891.setVisibility(0);
            this.f895.setDisplayUseLogoEnabled(false);
        } else {
            this.f895.setDisplayUseLogoEnabled(true);
            this.f891.setVisibility(8);
            if (C1457Fr.m5018(logoType, LogoType.START_ALIGNED)) {
                this.f903.setLogo(this.f905);
            } else if (C1457Fr.m5018(logoType, LogoType.START_MONOCHROME) && (drawable = this.f906.getResources().getDrawable(this.f905)) != null) {
                drawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                this.f903.setLogo(drawable);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m331(boolean z, Drawable drawable, String str) {
        this.f895.setDisplayHomeAsUpEnabled(z);
        if (z) {
            if (drawable != null) {
                this.f903.setNavigationIcon(drawable);
            } else {
                this.f903.setNavigationIcon(this.f898);
            }
            if (!C1457Fr.m5018(this.f902.mo383(), drawable)) {
                m330();
            }
        } else {
            this.f903.setNavigationIcon((Drawable) null);
        }
        if (str == null) {
            this.f903.setNavigationContentDescription(R.string.accessibility_navigate_up_button);
        } else {
            this.f903.setNavigationContentDescription(str);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m341(iF iFVar) {
        if (iFVar.mo380() != null && iFVar.mo376()) {
            C1276.m16820().mo5725("Custom View and Title are mutually exclusive because of support for center title");
        }
        if (iFVar.mo380() != null && iFVar.mo370()) {
            C1276.m16820().mo5725("Custom View and Logo are mutually exclusive because of support for center logo");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m355(iF iFVar) {
        C1457Fr.m5025(iFVar, "state");
        m341(iFVar);
        m338(iFVar.mo376(), iFVar.mo371());
        this.f900.setText(BX.m3953(iFVar.mo373()));
        this.f895.setTitle(BX.m3953(iFVar.mo373()));
        this.f903.setTitleTextAppearance(this.f906, iFVar.mo379());
        this.f903.setTitleTextColor(iFVar.mo375());
        this.f903.setSubtitle(BX.m3953(iFVar.mo377()));
        this.f903.setSubtitleTextColor(iFVar.mo381());
        m331(iFVar.mo368(), iFVar.mo383(), iFVar.mo369());
        m336(iFVar.mo370(), iFVar.mo382());
        m365(iFVar.mo380(), iFVar.mo374());
        if (!C1457Fr.m5018(this.f903.getBackground(), iFVar.mo378())) {
            this.f903.setBackground(iFVar.mo378());
            C0828 r0 = this.f908;
            if (r0 != null) {
                r0.setAlpha(1.0f);
            }
        }
        if (!iFVar.mo372()) {
            m366();
        }
        m361(iFVar.mo372());
        this.f902 = iFVar;
    }

    public static abstract class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        public static final Cif f914 = new Cif(null);

        /* renamed from: com.netflix.mediaclient.android.widget.NetflixActionBar$iF$ˊ  reason: contains not printable characters */
        public static abstract class AbstractC0010 {
            /* renamed from: ˊ  reason: contains not printable characters */
            public abstract AbstractC0010 mo386(int i);

            /* renamed from: ˊ  reason: contains not printable characters */
            public abstract AbstractC0010 mo387(Drawable drawable);

            /* renamed from: ˊ  reason: contains not printable characters */
            public abstract AbstractC0010 mo388(ActionBar.LayoutParams layoutParams);

            /* renamed from: ˊ  reason: contains not printable characters */
            public abstract AbstractC0010 mo389(boolean z);

            /* renamed from: ˋ  reason: contains not printable characters */
            public abstract AbstractC0010 mo390(int i);

            /* renamed from: ˋ  reason: contains not printable characters */
            public abstract AbstractC0010 mo391(View view);

            /* renamed from: ˋ  reason: contains not printable characters */
            public abstract iF mo392();

            /* renamed from: ˎ  reason: contains not printable characters */
            public abstract AbstractC0010 mo393(int i);

            /* renamed from: ˎ  reason: contains not printable characters */
            public abstract AbstractC0010 mo394(CharSequence charSequence);

            /* renamed from: ˎ  reason: contains not printable characters */
            public abstract AbstractC0010 mo395(String str);

            /* renamed from: ˎ  reason: contains not printable characters */
            public abstract AbstractC0010 mo396(boolean z);

            /* renamed from: ˏ  reason: contains not printable characters */
            public abstract AbstractC0010 mo397(int i);

            /* renamed from: ˏ  reason: contains not printable characters */
            public abstract AbstractC0010 mo398(Drawable drawable);

            /* renamed from: ˏ  reason: contains not printable characters */
            public abstract AbstractC0010 mo399(boolean z);

            /* renamed from: ॱ  reason: contains not printable characters */
            public abstract AbstractC0010 mo400(int i);

            /* renamed from: ॱ  reason: contains not printable characters */
            public abstract AbstractC0010 mo401(LogoType logoType);

            /* renamed from: ॱ  reason: contains not printable characters */
            public abstract AbstractC0010 mo402(CharSequence charSequence);

            /* renamed from: ॱ  reason: contains not printable characters */
            public abstract AbstractC0010 mo403(boolean z);
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        public abstract boolean mo368();

        /* renamed from: ʼ  reason: contains not printable characters */
        public abstract String mo369();

        /* renamed from: ʽ  reason: contains not printable characters */
        public abstract boolean mo370();

        /* renamed from: ˊ  reason: contains not printable characters */
        public abstract int mo371();

        /* renamed from: ˊॱ  reason: contains not printable characters */
        public abstract boolean mo372();

        /* renamed from: ˋ  reason: contains not printable characters */
        public abstract CharSequence mo373();

        /* renamed from: ˋॱ  reason: contains not printable characters */
        public abstract ActionBar.LayoutParams mo374();

        /* renamed from: ˎ  reason: contains not printable characters */
        public abstract int mo375();

        /* renamed from: ˏ  reason: contains not printable characters */
        public abstract boolean mo376();

        /* renamed from: ˏॱ  reason: contains not printable characters */
        public abstract CharSequence mo377();

        /* renamed from: ͺ  reason: contains not printable characters */
        public abstract Drawable mo378();

        /* renamed from: ॱ  reason: contains not printable characters */
        public abstract int mo379();

        /* renamed from: ॱˊ  reason: contains not printable characters */
        public abstract View mo380();

        /* renamed from: ॱˋ  reason: contains not printable characters */
        public abstract int mo381();

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public abstract LogoType mo382();

        /* renamed from: ᐝ  reason: contains not printable characters */
        public abstract Drawable mo383();

        /* renamed from: ᐝॱ  reason: contains not printable characters */
        public abstract int mo384();

        /* renamed from: com.netflix.mediaclient.android.widget.NetflixActionBar$iF$if  reason: invalid class name */
        public static final class Cif {
            private Cif() {
            }

            public /* synthetic */ Cif(C1456Fq fq) {
                this();
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public final AbstractC0010 m385() {
                return new C0525.C0526().mo396(true).mo386(0).mo403(true).mo399(false).mo401(LogoType.START_ALIGNED).mo389(false).mo397(0).mo393(0).mo400(0).mo390(0);
            }
        }
    }
}
