package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C0602;
/* renamed from: o.ᴴ  reason: contains not printable characters */
public final class C0975 extends FrameLayout {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0980 f14981 = new C0980(null);

    /* renamed from: ˎ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f14982 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "base", "getBase()Landroid/view/ViewGroup;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "carat", "getCarat()Landroid/widget/ImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "logoIcon", "getLogoIcon()Landroid/widget/ImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "subCategory", "getSubCategory()Landroid/widget/TextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "subCategoryCarat", "getSubCategoryCarat()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "spacer0", "getSpacer0()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "spacer1", "getSpacer1()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "spacer2", "getSpacer2()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "spacer3", "getSpacer3()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "text0", "getText0()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "text1", "getText1()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "text2", "getText2()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0975.class), "text3", "getText3()Lcom/netflix/mediaclient/android/widget/NetflixTextView;"))};

    /* renamed from: ʻ  reason: contains not printable characters */
    private final FI f14983;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private C0979 f14984;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final FI f14985;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private long f14986;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final FI f14987;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private C0979 f14988;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final Typeface f14989;

    /* renamed from: ʿ  reason: contains not printable characters */
    private int f14990;

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean f14991;

    /* renamed from: ˉ  reason: contains not printable characters */
    private boolean f14992;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final FI f14993;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private String f14994;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final IF f14995;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final FI f14996;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final C0981 f14997;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private int f14998;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final FI f14999;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private AbstractC1450Fk<? super AbstractC2408iF, EA> f15000;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final FI f15001;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final FI f15002;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final FI f15003;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final FI f15004;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final FI f15005;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final ArrayList<C0979> f15006;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final HashMap<String, C0979> f15007;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final FI f15008;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final Interpolator f15009;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final FI f15010;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final Interpolator f15011;

    public C0975(Context context) {
        this(context, null, 0, 6, null);
    }

    public C0975(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private final View m15874() {
        return (View) this.f14987.mo4986(this, f14982[4]);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private final View m15876() {
        return (View) this.f14999.mo4986(this, f14982[8]);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private final View m15877() {
        return (View) this.f15008.mo4986(this, f14982[7]);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final ImageView m15878() {
        return (ImageView) this.f15001.mo4986(this, f14982[1]);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final C0716 m15881() {
        return (C0716) this.f14996.mo4986(this, f14982[12]);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ImageView m15882() {
        return (ImageView) this.f14993.mo4986(this, f14982[2]);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final TextView m15888() {
        return (TextView) this.f14983.mo4986(this, f14982[3]);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final C0716 m15891() {
        return (C0716) this.f15003.mo4986(this, f14982[10]);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private final C0716 m15892() {
        return (C0716) this.f15005.mo4986(this, f14982[11]);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ViewGroup m15893() {
        return (ViewGroup) this.f15004.mo4986(this, f14982[0]);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final C0716 m15895() {
        return (C0716) this.f15002.mo4986(this, f14982[9]);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final View m15896() {
        return (View) this.f14985.mo4986(this, f14982[6]);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final View m15898() {
        return (View) this.f15010.mo4986(this, f14982[5]);
    }

    /* renamed from: o.ᴴ$ˋ  reason: contains not printable characters */
    public static final class C0980 {
        private C0980() {
        }

        public /* synthetic */ C0980(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final Cif m15911(View view) {
            C1457Fr.m5025(view, "v");
            Object tag = view.getTag(C0602.IF.aro_ribbon_view_data);
            if (!(tag instanceof Cif)) {
                tag = null;
            }
            return (Cif) tag;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0975(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f15004 = C1197.m16465(this, C0602.IF.base);
        this.f15001 = C1197.m16465(this, C0602.IF.carat);
        this.f14993 = C1197.m16465(this, C0602.IF.ribbon_n_logo);
        this.f14983 = C1197.m16465(this, C0602.IF.sub_category);
        this.f14987 = C1197.m16465(this, C0602.IF.sub_category_carat);
        this.f15010 = C1197.m16465(this, C0602.IF.spacer0);
        this.f14985 = C1197.m16465(this, C0602.IF.spacer1);
        this.f15008 = C1197.m16465(this, C0602.IF.spacer2);
        this.f14999 = C1197.m16465(this, C0602.IF.spacer3);
        this.f15002 = C1197.m16465(this, C0602.IF.text0);
        this.f15003 = C1197.m16465(this, C0602.IF.text1);
        this.f15005 = C1197.m16465(this, C0602.IF.text2);
        this.f14996 = C1197.m16465(this, C0602.IF.text3);
        this.f15011 = PathInterpolatorCompat.create(0.68f, 0.0f, 0.265f, 1.15f);
        this.f15009 = PathInterpolatorCompat.create(0.755f, 0.05f, 0.855f, 0.06f);
        this.f15006 = new ArrayList<>();
        this.f15007 = new HashMap<>();
        this.f14986 = 100;
        this.f14990 = -1;
        this.f14998 = -1;
        this.f14992 = true;
        this.f14994 = "";
        this.f14995 = new IF(this);
        this.f14997 = new C0981(this);
        FrameLayout.inflate(getContext(), C0602.C0606.aro_ribbon_layout, this);
        Typeface typeface = m15895().getTypeface();
        C1457Fr.m5016((Object) typeface, "text0.typeface");
        this.f14989 = typeface;
        this.f15006.add(new C0979(m15898(), m15895(), false, 4, null));
        this.f15006.add(new C0979(m15896(), m15891(), false, 4, null));
        this.f15006.add(new C0979(m15877(), m15892(), false, 4, null));
        this.f15006.add(new C0979(m15876(), m15881(), false, 4, null));
        m15893().getLayoutTransition().setStartDelay(1, 0);
        m15893().getLayoutTransition().disableTransitionType(2);
        m15893().getLayoutTransition().disableTransitionType(3);
        m15893().getLayoutTransition().setInterpolator(1, this.f15011);
        m15893().getLayoutTransition().setInterpolator(0, this.f15011);
        m15893().getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener(this) { // from class: o.ᴴ.3

            /* renamed from: ॱ  reason: contains not printable characters */
            final /* synthetic */ C0975 f15012;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f15012 = r1;
            }

            @Override // android.animation.LayoutTransition.TransitionListener
            public void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i2) {
            }

            @Override // android.animation.LayoutTransition.TransitionListener
            public void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i2) {
                if (i2 == 0) {
                    C0979 r0 = this.f15012.f14984;
                    if (C1457Fr.m5018(view, r0 != null ? r0.m15908() : null)) {
                        this.f15012.m15897();
                    }
                }
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0975(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.ᴴ$If  reason: case insensitive filesystem */
    public static final class View$OnLayoutChangeListenerC2407If implements View.OnLayoutChangeListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C0975 f15014;

        public View$OnLayoutChangeListenerC2407If(C0975 r1) {
            this.f15014 = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            if (this.f15014.f15006.size() > 2) {
                this.f15014.m15902(this.f15014.f15006.size() - 1);
                for (C0979 r7 : this.f15014.f15006) {
                    r7.m15908().setMaxWidth(Integer.MAX_VALUE);
                }
            }
        }
    }

    /* renamed from: o.ᴴ$ᐝ  reason: contains not printable characters */
    public static final class View$OnLayoutChangeListenerC0982 implements View.OnLayoutChangeListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C0975 f15031;

        public View$OnLayoutChangeListenerC0982(C0975 r1) {
            this.f15031 = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            this.f15031.f14992 = false;
        }
    }

    /* renamed from: o.ᴴ$IF */
    public static final class IF extends AnimatorListenerAdapter {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C0975 f15013;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        IF(C0975 r1) {
            this.f15013 = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f15013.m15899();
        }
    }

    /* renamed from: o.ᴴ$ˏ  reason: contains not printable characters */
    public static final class C0981 extends AnimatorListenerAdapter {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C0975 f15030;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0981(C0975 r1) {
            this.f15030 = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f15030.m15875();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᴴ$ˊ  reason: contains not printable characters */
    public static final class C0979 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final C0716 f15027;

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean f15028;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final View f15029;

        public C0979(View view, C0716 r3, boolean z) {
            C1457Fr.m5025(view, "spacer");
            C1457Fr.m5025(r3, "text");
            this.f15029 = view;
            this.f15027 = r3;
            this.f15028 = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0979(View view, C0716 r3, boolean z, int i, C1456Fq fq) {
            this(view, r3, (i & 4) != 0 ? true : z);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final boolean m15907() {
            return this.f15028;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final C0716 m15908() {
            return this.f15027;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final void m15909(boolean z) {
            this.f15028 = z;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final View m15910() {
            return this.f15029;
        }
    }

    public final void setPresentedCallback(AbstractC1450Fk<? super AbstractC2408iF, EA> fk) {
        this.f15000 = fk;
    }

    /* renamed from: o.ᴴ$if  reason: invalid class name */
    public static final class Cif {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final int f15025;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f15026;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cif)) {
                return false;
            }
            Cif ifVar = (Cif) obj;
            if (!C1457Fr.m5018((Object) this.f15026, (Object) ifVar.f15026)) {
                return false;
            }
            return this.f15025 == ifVar.f15025;
        }

        public int hashCode() {
            String str = this.f15026;
            return ((str != null ? str.hashCode() : 0) * 31) + this.f15025;
        }

        public String toString() {
            return "TagHolder(genreId=" + this.f15026 + ", rank=" + this.f15025 + ")";
        }

        public Cif(String str, int i) {
            C1457Fr.m5025(str, "genreId");
            this.f15026 = str;
            this.f15025 = i;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final String m15906() {
            return this.f15026;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final int m15905() {
            return this.f15025;
        }
    }

    /* renamed from: o.ᴴ$iF  reason: case insensitive filesystem */
    public static abstract class AbstractC2408iF {

        /* renamed from: o.ᴴ$iF$If */
        public static final class If extends AbstractC2408iF {

            /* renamed from: ˋ  reason: contains not printable characters */
            private final int f15016;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof If)) {
                    return false;
                }
                return this.f15016 == ((If) obj).f15016;
            }

            public int hashCode() {
                return this.f15016;
            }

            public String toString() {
                return "NetflixLogo(rank=" + this.f15016 + ")";
            }

            public If(int i) {
                super(null);
                this.f15016 = i;
            }
        }

        private AbstractC2408iF() {
        }

        public /* synthetic */ AbstractC2408iF(C1456Fq fq) {
            this();
        }

        /* renamed from: o.ᴴ$iF$iF  reason: collision with other inner class name */
        public static final class C0976iF extends AbstractC2408iF {

            /* renamed from: ˎ  reason: contains not printable characters */
            private final int f15017;

            /* renamed from: ˏ  reason: contains not printable characters */
            private final String f15018;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0976iF)) {
                    return false;
                }
                C0976iF iFVar = (C0976iF) obj;
                if (!C1457Fr.m5018((Object) this.f15018, (Object) iFVar.f15018)) {
                    return false;
                }
                return this.f15017 == iFVar.f15017;
            }

            public int hashCode() {
                String str = this.f15018;
                return ((str != null ? str.hashCode() : 0) * 31) + this.f15017;
            }

            public String toString() {
                return "BrowseTab(genreId=" + this.f15018 + ", rank=" + this.f15017 + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0976iF(String str, int i) {
                super(null);
                C1457Fr.m5025(str, "genreId");
                this.f15018 = str;
                this.f15017 = i;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final String m15903() {
                return this.f15018;
            }
        }

        /* renamed from: o.ᴴ$iF$ˊ  reason: contains not printable characters */
        public static final class C0977 extends AbstractC2408iF {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final CharSequence f15019;

            /* renamed from: ˋ  reason: contains not printable characters */
            private final String f15020;

            /* renamed from: ˏ  reason: contains not printable characters */
            private final int f15021;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0977)) {
                    return false;
                }
                C0977 r2 = (C0977) obj;
                if (!C1457Fr.m5018(this.f15019, r2.f15019) || !C1457Fr.m5018((Object) this.f15020, (Object) r2.f15020)) {
                    return false;
                }
                return this.f15021 == r2.f15021;
            }

            public int hashCode() {
                CharSequence charSequence = this.f15019;
                int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
                String str = this.f15020;
                return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f15021;
            }

            public String toString() {
                return "CategorySelector(tabName=" + this.f15019 + ", genreId=" + this.f15020 + ", rank=" + this.f15021 + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0977(CharSequence charSequence, String str, int i) {
                super(null);
                C1457Fr.m5025(charSequence, "tabName");
                C1457Fr.m5025(str, "genreId");
                this.f15019 = charSequence;
                this.f15020 = str;
                this.f15021 = i;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final String m15904() {
                return this.f15020;
            }
        }

        /* renamed from: o.ᴴ$iF$ˋ  reason: contains not printable characters */
        public static final class C0978 extends AbstractC2408iF {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final CharSequence f15022;

            /* renamed from: ˏ  reason: contains not printable characters */
            private final String f15023;

            /* renamed from: ॱ  reason: contains not printable characters */
            private final int f15024;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0978)) {
                    return false;
                }
                C0978 r2 = (C0978) obj;
                if (!C1457Fr.m5018(this.f15022, r2.f15022) || !C1457Fr.m5018((Object) this.f15023, (Object) r2.f15023)) {
                    return false;
                }
                return this.f15024 == r2.f15024;
            }

            public int hashCode() {
                CharSequence charSequence = this.f15022;
                int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
                String str = this.f15023;
                return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f15024;
            }

            public String toString() {
                return "SubCategorySelector(tabName=" + this.f15022 + ", genreId=" + this.f15023 + ", rank=" + this.f15024 + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0978(CharSequence charSequence, String str, int i) {
                super(null);
                C1457Fr.m5025(charSequence, "tabName");
                C1457Fr.m5025(str, "genreId");
                this.f15022 = charSequence;
                this.f15023 = str;
                this.f15024 = i;
            }
        }
    }

    public final void setSimpleMode(int i, int i2) {
        if (!this.f14991) {
            this.f14991 = true;
            this.f14990 = i;
            this.f14998 = i2;
            Iterator<T> it = this.f15006.iterator();
            while (it.hasNext()) {
                it.next().m15908().setTextColor(i2);
            }
            C0979 r0 = this.f15006.get(0);
            C1457Fr.m5016((Object) r0, "holders[0]");
            m15879(r0);
        }
    }

    public final void setLogo(int i) {
        int i2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        m15882().setImageResource(i);
        ImageView r11 = m15882();
        C1281 r4 = C1281.f15992;
        Resources resources = ((Context) C1281.m16832(Context.class)).getResources();
        C1457Fr.m5016((Object) resources, "Lookup.get<Context>().resources");
        C1004.m15952(r11, 0, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        ViewGroup.LayoutParams layoutParams = m15898().getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        if (i == C0602.C0604.logo_ribbon_n) {
            C1281 r5 = C1281.f15992;
            Resources resources2 = ((Context) C1281.m16832(Context.class)).getResources();
            C1457Fr.m5016((Object) resources2, "Lookup.get<Context>().resources");
            int applyDimension = (int) TypedValue.applyDimension(1, 38.0f, resources2.getDisplayMetrics());
            marginLayoutParams = marginLayoutParams2;
            i2 = applyDimension;
        } else {
            C1281 r52 = C1281.f15992;
            Resources resources3 = ((Context) C1281.m16832(Context.class)).getResources();
            C1457Fr.m5016((Object) resources3, "Lookup.get<Context>().resources");
            int applyDimension2 = (int) TypedValue.applyDimension(1, 90.0f, resources3.getDisplayMetrics());
            marginLayoutParams = marginLayoutParams2;
            i2 = applyDimension2;
        }
        marginLayoutParams.setMarginStart(i2);
        m15898().setLayoutParams(marginLayoutParams2);
    }

    public final void setupHolder(int i, String str, String str2, boolean z, AbstractC1450Fk<? super View, EA> fk) {
        C1457Fr.m5025(str, SignupConstants.Field.LABEL);
        C1457Fr.m5025(str2, "genreId");
        C1457Fr.m5025(fk, "clickListener");
        if (i < this.f15006.size()) {
            C0979 r4 = this.f15006.get(i);
            r4.m15909(z);
            r4.m15908().setText(str);
            r4.m15908().setTag(C0602.IF.aro_ribbon_view_data, new Cif(str2, i + 1));
            r4.m15908().setOnClickListener(new View$OnClickListenerC0995(fk));
            C1457Fr.m5016((Object) r4, "holder");
            this.f15007.put(str2, r4);
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final boolean m15886() {
        return m15888().getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (m15886()) {
            C0979 r3 = this.f14984;
            if (r3 != null) {
                ViewGroup.LayoutParams layoutParams = m15888().getLayoutParams();
                if (layoutParams == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                m15888().setMaxWidth((((((View.MeasureSpec.getSize(i) - m15882().getMeasuredWidth()) - m15878().getMeasuredWidth()) - m15874().getMeasuredWidth()) - layoutParams2.getMarginStart()) - layoutParams2.getMarginEnd()) - r3.m15908().getMeasuredWidth());
                return;
            }
            return;
        }
        int size = View.MeasureSpec.getSize(i) - m15882().getMeasuredWidth();
        int i3 = 0;
        Iterator<T> it = this.f15006.iterator();
        while (it.hasNext()) {
            i3 += it.next().m15908().getMeasuredWidth();
        }
        if (i3 > size) {
            if (this.f15006.size() > 2) {
                addOnLayoutChangeListener(new View$OnLayoutChangeListenerC2407If(this));
            }
            for (T t : this.f15006) {
                t.m15908().setMaxWidth((t.m15908().getMeasuredWidth() * size) / i3);
            }
        } else if (this.f14992) {
            addOnLayoutChangeListener(new View$OnLayoutChangeListenerC0982(this));
        }
    }

    public final void setSubCategoryVisibility(int i) {
        m15888().setVisibility(i);
        m15874().setVisibility(i);
        if (i == 0 && !isLaidOut()) {
            m15897();
        }
    }

    public final void setSubCategoryLabel(String str, String str2) {
        C1457Fr.m5025(str, SignupConstants.Field.LABEL);
        C1457Fr.m5025(str2, "genreId");
        if ((!C1457Fr.m5018((Object) m15888().getText(), (Object) str)) || (!C1457Fr.m5018((Object) this.f14994, (Object) str2))) {
            m15888().setText(str);
            this.f14994 = str2;
            AbstractC1450Fk<? super AbstractC2408iF, EA> fk = this.f15000;
            if (fk != null) {
                fk.invoke(new AbstractC2408iF.C0977(str, str2, 2));
            }
        }
    }

    public final void setSubCategoryClickListener(AbstractC1450Fk<? super View, EA> fk) {
        C1457Fr.m5025(fk, "clickListener");
        m15888().setOnClickListener(new View$OnClickListenerC0995(fk));
        m15874().setOnClickListener(new View$OnClickListenerC0995(fk));
    }

    public final void setLogoClickListener(AbstractC1450Fk<? super View, EA> fk) {
        C1457Fr.m5025(fk, "clickListener");
        m15882().setOnClickListener(new View$OnClickListenerC0995(fk));
    }

    public final void setMainCaratClickListener(AbstractC1450Fk<? super View, EA> fk) {
        C1457Fr.m5025(fk, "clickListener");
        m15878().setOnClickListener(new View$OnClickListenerC0995(fk));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m15902(int i) {
        if (i < this.f15006.size()) {
            C0979 r2 = this.f15006.get(i);
            this.f15006.remove(i);
            r2.m15910().setVisibility(8);
            r2.m15908().setVisibility(8);
            r2.m15908().setOnClickListener(aux.f15015);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᴴ$aux */
    public static final class aux implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        public static final aux f15015 = new aux();

        aux() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m15901() {
        if (this.f14991) {
            C0979 r0 = this.f15006.get(0);
            C1457Fr.m5016((Object) r0, "holders[0]");
            m15879(r0);
            return;
        }
        C0979 r3 = this.f14984;
        if (r3 != null) {
            r3.m15908().animate().setStartDelay(0).cancel();
            r3.m15908().animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).setInterpolator(this.f15011).start();
            m15888().animate().alpha(0.0f).setDuration(200).setInterpolator(this.f15011).setListener(this.f14995).start();
            m15874().animate().alpha(0.0f).setDuration(200).setInterpolator(this.f15011).start();
            m15878().animate().alpha(0.0f).setDuration(200).setInterpolator(this.f15011).start();
        }
    }

    public final void setSelectedPrimaryGenre(String str) {
        C1457Fr.m5025(str, "genreId");
        C0979 r2 = this.f15007.get(str);
        if (r2 != null && (!C1457Fr.m5018(r2, this.f14984))) {
            if (this.f14991) {
                m15879(r2);
            } else {
                m15885(r2);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m15900(boolean z) {
        AbstractC1450Fk<? super AbstractC2408iF, EA> fk = this.f15000;
        if (fk != null) {
            if (z) {
                fk.invoke(new AbstractC2408iF.If(0));
            }
            Iterator<T> it = this.f15006.iterator();
            while (it.hasNext()) {
                Object tag = it.next().m15908().getTag(C0602.IF.aro_ribbon_view_data);
                if (!(tag instanceof Cif)) {
                    tag = null;
                }
                Cif ifVar = (Cif) tag;
                if (ifVar != null) {
                    fk.invoke(new AbstractC2408iF.C0976iF(ifVar.m15906(), ifVar.m15905()));
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m15879(C0979 r5) {
        C0979 r2 = this.f14988;
        if (r2 != null) {
            r2.m15908().setTypeface(this.f14989);
            r2.m15908().setTextColor(this.f14998);
        }
        r5.m15908().setTypeface(Typeface.DEFAULT_BOLD);
        r5.m15908().setTextColor(this.f14990);
        this.f14988 = r5;
        this.f14984 = r5;
        m15900(false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m15885(C0979 r10) {
        C0979 r6;
        C0716 r62;
        C0716 r0;
        C0716 r5;
        if (this.f14984 != null) {
            LayoutTransition layoutTransition = m15893().getLayoutTransition();
            m15893().setLayoutTransition(null);
            C0979 r52 = this.f14984;
            if (!(r52 == null || (r5 = r52.m15908()) == null)) {
                m15884(r5, 1.0f);
            }
            C0979 r02 = this.f14984;
            if (!(r02 == null || (r0 = r02.m15908()) == null)) {
                r0.setVisibility(8);
            }
            this.f14988 = r10;
            this.f14984 = r10;
            r10.m15908().setVisibility(0);
            m15884(r10.m15908(), 1.15f);
            m15893().setLayoutTransition(layoutTransition);
        } else {
            this.f14988 = r10;
            this.f14984 = r10;
            if (isLaidOut()) {
                this.f14986 = r10.m15908().getVisibility() == 8 ? 0 : (((long) (this.f15006.indexOf(r10) + 1)) * 150) + 150;
                m15893().getLayoutTransition().setDuration(0, this.f14986);
                m15893().getLayoutTransition().setDuration(1, this.f14986);
                r10.m15908().animate().setStartDelay(0).cancel();
                r10.m15908().animate().scaleX(1.15f).scaleY(1.15f).setDuration(50).setListener(this.f14997).start();
            } else {
                r10.m15908().setScaleX(1.15f);
                r10.m15908().setScaleY(1.15f);
                m15875();
            }
        }
        AbstractC1450Fk<? super AbstractC2408iF, EA> fk = this.f15000;
        if (fk != null && (r6 = this.f14984) != null && (r62 = r6.m15908()) != null) {
            Object tag = r10.m15908().getTag(C0602.IF.aro_ribbon_view_data);
            if (!(tag instanceof Cif)) {
                tag = null;
            }
            Cif ifVar = (Cif) tag;
            if (ifVar != null) {
                CharSequence text = r62.getText();
                C1457Fr.m5016((Object) text, "text.text");
                fk.invoke(new AbstractC2408iF.C0977(text, ifVar.m15906(), 1));
            }
        }
    }

    @Override // android.view.View
    public boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final void m15899() {
        if (this.f14984 != null) {
            m15888().setVisibility(8);
            m15874().setVisibility(8);
            m15878().setVisibility(8);
            for (T t : this.f15006) {
                t.m15910().setVisibility(0);
                if (!C1457Fr.m5018((Object) t, (Object) this.f14984)) {
                    t.m15908().setAlpha(0.0f);
                    t.m15908().setVisibility(0);
                    t.m15908().animate().setStartDelay(0).cancel();
                    t.m15908().animate().alpha(1.0f).setStartDelay(this.f14986 - 100).setDuration(200).setInterpolator(this.f15011).setListener(null).start();
                }
            }
            this.f14984 = null;
        }
        m15900(false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m15884(View view, float f) {
        view.setScaleX(f);
        view.setScaleY(f);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final void m15875() {
        C0979 r4 = this.f14984;
        if (r4 != null) {
            m15878().setAlpha(0.0f);
            m15878().setVisibility(0);
            if (r4.m15907()) {
                m15888().setAlpha(0.0f);
                m15888().setVisibility(0);
                m15874().setAlpha(0.0f);
                m15874().setVisibility(0);
                AbstractC1450Fk<? super AbstractC2408iF, EA> fk = this.f15000;
                if (fk != null) {
                    fk.invoke(new AbstractC2408iF.C0978("", "", 2));
                }
            }
            for (T t : this.f15006) {
                t.m15910().setVisibility(8);
                if (!C1457Fr.m5018((Object) t, (Object) r4)) {
                    t.m15908().setVisibility(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final void m15897() {
        C0979 r3 = this.f14984;
        if (r3 != null) {
            if (r3.m15907()) {
                if (isLaidOut()) {
                    m15888().animate().cancel();
                    m15888().animate().alpha(1.0f).setDuration(200).setInterpolator(this.f15011).setListener(null).start();
                    m15874().animate().alpha(1.0f).setDuration(200).setInterpolator(this.f15011).start();
                } else {
                    m15888().setAlpha(1.0f);
                    m15874().setAlpha(1.0f);
                }
            }
            if (isLaidOut()) {
                m15878().animate().alpha(1.0f).setDuration(200).setInterpolator(this.f15011).start();
            } else {
                m15878().setAlpha(1.0f);
            }
        }
    }
}
