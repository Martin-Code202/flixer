package o;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
/* renamed from: o.ze  reason: case insensitive filesystem */
public final class C2369ze extends AbstractC0467 {

    /* renamed from: ˊ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f12792 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2369ze.class), "titleBarView", "getTitleBarView()Lcom/netflix/android/widgetry/widget/ScaledItemListView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2369ze.class), "previewsPlayerRecyclerView", "getPreviewsPlayerRecyclerView()Lcom/netflix/mediaclient/ui/previews/PreviewsPlayerRecyclerView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2369ze.class), "bottomActionButtonBackgroundView", "getBottomActionButtonBackgroundView()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2369ze.class), "titleBarBackgroundView", "getTitleBarBackgroundView()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2369ze.class), "playNowTextView", "getPlayNowTextView()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2369ze.class), "showDisplayPageImageView", "getShowDisplayPageImageView()Lcom/netflix/mediaclient/android/widget/AdvancedImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2369ze.class), "addToMyListTextView", "getAddToMyListTextView()Lcom/netflix/mediaclient/android/widget/IconFontTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C2369ze.class), "closeSlideShowImageView", "getCloseSlideShowImageView()Lcom/netflix/mediaclient/android/widget/AdvancedImageView;"))};

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0325 f12793 = new C0325(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final FI f12794 = C1197.m16470(this, (int) R.id.previews_bottom_action_background);

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final ValueAnimator f12795 = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 0);

    /* renamed from: ʼ  reason: contains not printable characters */
    private final FI f12796 = C1197.m16470(this, (int) R.id.previews_title_bar_background);

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final AbstractC1449Fj<EA> f12797;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final FI f12798 = C1197.m16470(this, (int) R.id.preview_view_port);

    /* renamed from: ʾ  reason: contains not printable characters */
    private final String f12799;

    /* renamed from: ʿ  reason: contains not printable characters */
    private yR f12800;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final FI f12801 = C1197.m16470(this, (int) R.id.previews_show_dp);

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC2056pe f12802;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final PagerSnapHelper f12803 = new PagerSnapHelper();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final yV f12804;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final FI f12805 = C1197.m16470(this, (int) R.id.previews_add_to_my_list);

    /* renamed from: ͺ  reason: contains not printable characters */
    private final FI f12806 = C1197.m16470(this, (int) R.id.previews_slide_show_close);

    /* renamed from: ॱ  reason: contains not printable characters */
    private oY f12807;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private AddToListData.Cif f12808;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final int[] f12809 = {0, 0};

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final ValueAnimator f12810 = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 0);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final FI f12811 = C1197.m16470(this, (int) R.id.previews_title_bar);

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private List<yR> f12812 = new ArrayList();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final FI f12813 = C1197.m16470(this, (int) R.id.previews_play_now);

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final AnimatorSet f12814 = new AnimatorSet();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private final yW m13605() {
        return (yW) this.f12798.mo4986(this, f12792[1]);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C0716 m13606() {
        return (C0716) this.f12813.mo4986(this, f12792[4]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private final View m13607() {
        return (View) this.f12794.mo4986(this, f12792[2]);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final C0522 m13611() {
        return (C0522) this.f12806.mo4986(this, f12792[7]);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1133 m13614() {
        return (C1133) this.f12811.mo4986(this, f12792[0]);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final C0628 m13621() {
        return (C0628) this.f12805.mo4986(this, f12792[6]);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0522 m13622() {
        return (C0522) this.f12801.mo4986(this, f12792[5]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private final View m13623() {
        return (View) this.f12796.mo4986(this, f12792[3]);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2369ze(android.view.ViewGroup r11, o.AbstractC1449Fj<o.EA> r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 396
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C2369ze.<init>(android.view.ViewGroup, o.Fj, java.lang.String):void");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final AbstractC1449Fj<EA> m13626() {
        return this.f12797;
    }

    /* renamed from: o.ze$if  reason: invalid class name */
    public static abstract class Cif extends C0461 {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* renamed from: o.ze$if$ˋ  reason: contains not printable characters */
        public static final class C0323 extends Cif {

            /* renamed from: ˏ  reason: contains not printable characters */
            private final int f12826;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0323)) {
                    return false;
                }
                return this.f12826 == ((C0323) obj).f12826;
            }

            public int hashCode() {
                return this.f12826;
            }

            public String toString() {
                return "PreparingItemToPlay(itemPos=" + this.f12826 + ")";
            }

            public C0323(int i) {
                super(null);
                this.f12826 = i;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final int m13632() {
                return this.f12826;
            }
        }

        /* renamed from: o.ze$if$if  reason: invalid class name */
        public static final class Cif extends Cif {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final int f12824;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Cif)) {
                    return false;
                }
                return this.f12824 == ((Cif) obj).f12824;
            }

            public int hashCode() {
                return this.f12824;
            }

            public String toString() {
                return "PlaybackStarted(itemPos=" + this.f12824 + ")";
            }

            public Cif(int i) {
                super(null);
                this.f12824 = i;
            }
        }

        /* renamed from: o.ze$if$ˊ  reason: contains not printable characters */
        public static final class C0322 extends Cif {

            /* renamed from: ˏ  reason: contains not printable characters */
            private final int f12825;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0322)) {
                    return false;
                }
                return this.f12825 == ((C0322) obj).f12825;
            }

            public int hashCode() {
                return this.f12825;
            }

            public String toString() {
                return "PlaybackCompleted(itemPos=" + this.f12825 + ")";
            }

            public C0322(int i) {
                super(null);
                this.f12825 = i;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final int m13631() {
                return this.f12825;
            }
        }

        /* renamed from: o.ze$if$If */
        public static final class If extends Cif {

            /* renamed from: ˏ  reason: contains not printable characters */
            private final int f12820;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof If)) {
                    return false;
                }
                return this.f12820 == ((If) obj).f12820;
            }

            public int hashCode() {
                return this.f12820;
            }

            public String toString() {
                return "PlaybackErrorOccurred(itemPos=" + this.f12820 + ")";
            }

            public If(int i) {
                super(null);
                this.f12820 = i;
            }
        }

        /* renamed from: o.ze$if$ˎ  reason: contains not printable characters */
        public static final class C0324 extends Cif {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final boolean f12827;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0324)) {
                    return false;
                }
                return this.f12827 == ((C0324) obj).f12827;
            }

            public int hashCode() {
                boolean z = this.f12827;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public String toString() {
                return "SetPlaybackState(playing=" + this.f12827 + ")";
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final boolean m13633() {
                return this.f12827;
            }
        }

        /* renamed from: o.ze$if$aux */
        public static final class aux extends Cif {

            /* renamed from: ˎ  reason: contains not printable characters */
            private final int f12821;

            /* renamed from: ˏ  reason: contains not printable characters */
            private final int f12822;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof aux)) {
                    return false;
                }
                aux aux = (aux) obj;
                if (!(this.f12822 == aux.f12822)) {
                    return false;
                }
                return this.f12821 == aux.f12821;
            }

            public int hashCode() {
                return (this.f12822 * 31) + this.f12821;
            }

            public String toString() {
                return "Tapped(direction=" + this.f12822 + ", currItemPos=" + this.f12821 + ")";
            }

            public aux(int i, int i2) {
                super(null);
                this.f12822 = i;
                this.f12821 = i2;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final int m13629() {
                return this.f12822;
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public final int m13630() {
                return this.f12821;
            }
        }

        /* renamed from: o.ze$if$iF  reason: case insensitive filesystem */
        public static final class C2371iF extends Cif {

            /* renamed from: ˋ  reason: contains not printable characters */
            public static final C2371iF f12823 = new C2371iF();

            private C2371iF() {
                super(null);
            }
        }
    }

    /* renamed from: o.ze$ˋ  reason: contains not printable characters */
    public static abstract class AbstractC0326 extends C0361 {
        private AbstractC0326() {
        }

        public /* synthetic */ AbstractC0326(C1456Fq fq) {
            this();
        }

        /* renamed from: o.ze$ˋ$ˋ  reason: contains not printable characters */
        public static final class C0328 extends AbstractC0326 {

            /* renamed from: ˊ  reason: contains not printable characters */
            public static final C0328 f12831 = new C0328();

            private C0328() {
                super(null);
            }
        }

        /* renamed from: o.ze$ˋ$ˊ  reason: contains not printable characters */
        public static final class C0327 extends AbstractC0326 {

            /* renamed from: ॱ  reason: contains not printable characters */
            private final int f12830;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0327)) {
                    return false;
                }
                return this.f12830 == ((C0327) obj).f12830;
            }

            public int hashCode() {
                return this.f12830;
            }

            public String toString() {
                return "UpdateTheme(itemPos=" + this.f12830 + ")";
            }

            public C0327(int i) {
                super(null);
                this.f12830 = i;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final int m13636() {
                return this.f12830;
            }
        }

        /* renamed from: o.ze$ˋ$if  reason: invalid class name */
        public static final class Cif extends AbstractC0326 {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final int f12829;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Cif)) {
                    return false;
                }
                return this.f12829 == ((Cif) obj).f12829;
            }

            public int hashCode() {
                return this.f12829;
            }

            public String toString() {
                return "ScrollToItem(itemPos=" + this.f12829 + ")";
            }

            public Cif(int i) {
                super(null);
                this.f12829 = i;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final int m13635() {
                return this.f12829;
            }
        }

        /* renamed from: o.ze$ˋ$iF */
        public static final class iF extends AbstractC0326 {

            /* renamed from: ˏ  reason: contains not printable characters */
            private final boolean f12828;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof iF)) {
                    return false;
                }
                return this.f12828 == ((iF) obj).f12828;
            }

            public int hashCode() {
                boolean z = this.f12828;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public String toString() {
                return "SetPlaybackTo(playing=" + this.f12828 + ")";
            }

            public iF(boolean z) {
                super(null);
                this.f12828 = z;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final boolean m13634() {
                return this.f12828;
            }
        }
    }

    /* renamed from: o.ze$ˊ  reason: contains not printable characters */
    public static final class C0325 {
        private C0325() {
        }

        public /* synthetic */ C0325(C1456Fq fq) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ze$If */
    public static final class If implements View.OnClickListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2369ze f12817;

        If(C2369ze zeVar) {
            this.f12817 = zeVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AbstractC1449Fj<EA> r0 = this.f12817.m13626();
            if (r0 != null) {
                r0.invoke();
            }
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private final void m13617() {
        m13611().setOnClickListener(new If(this));
        m13622().setOnClickListener(new View$OnClickListenerC0329(this));
        m13606().setOnClickListener(new View$OnClickListenerC0331(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ze$ˎ  reason: contains not printable characters */
    public static final class View$OnClickListenerC0329 implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2369ze f12832;

        View$OnClickListenerC0329(C2369ze zeVar) {
            this.f12832 = zeVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NetflixActivity netflixActivity;
            yR yRVar = this.f12832.f12800;
            if (yRVar != null && (netflixActivity = (NetflixActivity) C1322Av.m3791(this.f12832.m14352().getContext(), NetflixActivity.class)) != null && !C1317As.m3750(netflixActivity)) {
                qU.m9974(netflixActivity, yRVar, yRVar.m13247(), "Previews");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ze$ᐝ  reason: contains not printable characters */
    public static final class View$OnClickListenerC0331 implements View.OnClickListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2369ze f12834;

        View$OnClickListenerC0331(C2369ze zeVar) {
            this.f12834 = zeVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            yR yRVar;
            pT videoDetails;
            NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(this.f12834.m14352().getContext(), NetflixActivity.class);
            if (netflixActivity != null && !C1317As.m3750(netflixActivity) && (yRVar = this.f12834.f12800) != null && (videoDetails = yRVar.getVideoDetails()) != null) {
                C1457Fr.m5016((Object) videoDetails, "videoDetails");
                pF playable = videoDetails.getPlayable();
                yR yRVar2 = this.f12834.f12800;
                VideoType type = yRVar2 != null ? yRVar2.getType() : null;
                yR yRVar3 = this.f12834.f12800;
                PlaybackLauncher.m1605(netflixActivity, playable, type, yRVar3 != null ? yRVar3.m13247() : null, -1);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m13627(C2059ph phVar) {
        C1457Fr.m5025(phVar, "serviceManager");
        AbstractC2056pe r2 = phVar.m9759();
        if (r2 != null) {
            this.f12802 = r2;
            this.f12807 = r2.mo7800();
            this.f12804.m13295(this.f12807);
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final C2059ph m13609() {
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(m14352().getContext(), NetflixActivity.class);
        C2059ph serviceManager = netflixActivity != null ? netflixActivity.getServiceManager() : null;
        if (serviceManager != null && serviceManager.mo9519()) {
            return serviceManager;
        }
        return null;
    }

    @Override // o.AbstractC0467
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo13625(C0361 r7) {
        AbstractC1449Fj<EA> fj;
        C1457Fr.m5025(r7, "command");
        if (r7 instanceof AbstractC0326.C0327) {
            int size = this.f12812.size();
            int r5 = ((AbstractC0326.C0327) r7).m13636();
            if (0 <= r5 && size >= r5) {
                C1283.m16854("PreviewsSlideShowUIView", "execute:UpdateTheme " + this.f12812.get(((AbstractC0326.C0327) r7).m13636()).getSupplementalVideoId());
                m13620(this.f12812.get(((AbstractC0326.C0327) r7).m13636()));
            }
        } else if (r7 instanceof AbstractC0326.Cif) {
            int size2 = this.f12812.size();
            int r52 = ((AbstractC0326.Cif) r7).m13635();
            if (0 <= r52 && size2 >= r52) {
                m13605().smoothScrollToPosition(((AbstractC0326.Cif) r7).m13635());
            }
        } else if (r7 instanceof AbstractC0326.iF) {
            m13605().setPlaybackState(((AbstractC0326.iF) r7).m13634());
        } else if ((r7 instanceof AbstractC0326.C0328) && (fj = this.f12797) != null) {
            fj.invoke();
        }
    }

    @Override // o.AbstractC0467
    /* renamed from: ॱ */
    public void mo11047(AbstractC0508 r6) {
        C1457Fr.m5025(r6, "uiModel");
        if (!(r6 instanceof yZ)) {
            C1283.m16850("PreviewsSlideShowUIView", "render: uiModel !is PreviewsSlideShowUIModel - render() is no-op");
            return;
        }
        this.f12812.clear();
        this.f12812.addAll(((yZ) r6).m13312());
        if (this.f12812.size() != 0) {
            m13614().m16300();
            this.f12804.notifyDataSetChanged();
            this.f12804.m13297(true);
            Integer r2 = ((yZ) r6).m13313();
            if (r2 != null) {
                int intValue = r2.intValue();
                int size = this.f12812.size();
                if (0 <= intValue && size >= intValue) {
                    m13620(this.f12812.get(intValue));
                    m13605().scrollToPosition(intValue);
                }
            }
            m13605().setPlaybackState(true);
        }
    }

    @Override // o.AbstractC0467
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo13628() {
        AbstractC2056pe peVar;
        oY oYVar = this.f12807;
        if (!(oYVar == null || (peVar = this.f12802) == null)) {
            peVar.mo7802(oYVar);
        }
        this.f12804.m13295((oY) null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m13619(int i) {
        m13606().setTextColor(i);
        m13606().getBackground().setTint(i);
        m13621().setTextColor(i);
        m13622().getBackground().setTint(i);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m13620(yR yRVar) {
        if (this.f12800 == null) {
            m13619(yRVar.getForegroundColor());
            this.f12809[0] = yRVar.getBackgroundColor();
            m13623().setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f12809));
            m13607().setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.f12809));
        } else {
            yR yRVar2 = this.f12800;
            if (yRVar2 != null) {
                this.f12795.setObjectValues(Integer.valueOf(yRVar2.getForegroundColor()), Integer.valueOf(yRVar.getForegroundColor()));
                this.f12810.setObjectValues(Integer.valueOf(yRVar2.getBackgroundColor()), Integer.valueOf(yRVar.getBackgroundColor()));
                this.f12814.start();
            }
        }
        this.f12800 = yRVar;
        if (m13609() == null) {
            C1276.m16820().mo5725("service not ready, can not update action buttons");
        }
        C2059ph r6 = m13609();
        if (r6 != null) {
            if (!r6.m9822()) {
                C1276.m16820().mo5725("IQ not available for profile, my list button for preview slide show will not work for " + yRVar.getId());
            } else {
                NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(m14352().getContext(), NetflixActivity.class);
                if (netflixActivity != null) {
                    this.f12808 = r6.m9798(netflixActivity, m13621(), yRVar.getId(), yRVar.getType(), 0);
                    r6.m9802(yRVar.getId(), this.f12808);
                }
            }
            long nanoTime = System.nanoTime();
            VideoType type = yRVar.getType();
            if (type != null) {
                switch (C2368zd.f12791[type.ordinal()]) {
                    case 1:
                        r6.m9764().mo9513(yRVar.getId(), (String) null, new C2370iF(this, String.valueOf(nanoTime), yRVar));
                        return;
                    case 2:
                        r6.m9764().mo9503(yRVar.getId(), (String) null, new C2370iF(this, String.valueOf(nanoTime), yRVar));
                        return;
                }
            }
            C1276.m16820().mo5725("" + yRVar.getId() + " for " + yRVar.getId() + " not handled, cta buttons for preview slide show will not work");
        }
    }

    /* renamed from: o.ze$ˏ  reason: contains not printable characters */
    public static final class C0330 extends RecyclerView.OnScrollListener {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C2369ze f12833;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0330(C2369ze zeVar) {
            this.f12833 = zeVar;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            C1457Fr.m5025(recyclerView, "recyclerView");
            C1283.m16854("PreviewsSlideShowUIView", "onScrollStateChanged: " + i);
            switch (i) {
                case 0:
                    RecyclerView.LayoutManager layoutManager = this.f12833.m13605().getLayoutManager();
                    if (layoutManager == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    }
                    int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
                    C1283.m16854("PreviewsSlideShowUIView", "onScrollStateChanged: SCROLL_STATE_IDLE itemPos = " + findFirstCompletelyVisibleItemPosition + " / " + recyclerView.getChildCount());
                    RecyclerView recyclerView2 = recyclerView;
                    int childCount = recyclerView2.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = recyclerView2.getChildAt(i2);
                        C1457Fr.m5016((Object) childAt, "getChildAt(index)");
                        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                        if (childViewHolder == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.previews.PreviewsPlayerItemViewHolder");
                        }
                        yS ySVar = (yS) childViewHolder;
                        C1283.m16854("PreviewsSlideShowUIView", "onScrollStateChanged: checking for view @" + ySVar.getAdapterPosition());
                        if (ySVar.getAdapterPosition() == findFirstCompletelyVisibleItemPosition) {
                            this.f12833.m14353().onNext(new Cif.C0323(findFirstCompletelyVisibleItemPosition));
                            ySVar.m13269("setPlaybackTo from SCROLL_STATE_IDLE");
                            ySVar.m13276(true);
                            return;
                        }
                    }
                    return;
                case 1:
                    RecyclerView.LayoutManager layoutManager2 = this.f12833.m13605().getLayoutManager();
                    if (layoutManager2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    }
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition();
                    C1283.m16854("PreviewsSlideShowUIView", "onScrollStateChanged: SCROLL_STATE_DRAGGING itemPos = " + findFirstVisibleItemPosition + " (childCount = " + recyclerView.getChildCount() + ')');
                    RecyclerView recyclerView3 = recyclerView;
                    int childCount2 = recyclerView3.getChildCount();
                    for (int i3 = 0; i3 < childCount2; i3++) {
                        View childAt2 = recyclerView3.getChildAt(i3);
                        C1457Fr.m5016((Object) childAt2, "getChildAt(index)");
                        RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(childAt2);
                        if (childViewHolder2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.previews.PreviewsPlayerItemViewHolder");
                        }
                        yS ySVar2 = (yS) childViewHolder2;
                        if (ySVar2.getAdapterPosition() == findFirstVisibleItemPosition) {
                            ySVar2.m13274();
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final void m13616() {
        m13605().setItemScrollListener(new C0330(this));
    }

    /* renamed from: o.ze$iF  reason: case insensitive filesystem */
    public final class C2370iF extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2369ze f12818;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final yR f12819;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C2370iF(C2369ze zeVar, String str, yR yRVar) {
            super(str);
            C1457Fr.m5025(str, "logTag");
            C1457Fr.m5025(yRVar, "previewItem");
            this.f12818 = zeVar;
            this.f12819 = yRVar;
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            AddToListData.Cif ifVar;
            super.onShowDetailsFetched(pRVar, status);
            this.f12819.setVideoDetails(pRVar);
            if (pRVar != null && pRVar.isInQueue() && (ifVar = this.f12818.f12808) != null) {
                ifVar.mo1480(AddToListData.AddToListState.IN_LIST);
            }
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            AddToListData.Cif ifVar;
            super.onMovieDetailsFetched(pPVar, status);
            this.f12819.setVideoDetails(pPVar);
            if (pPVar != null && pPVar.isInQueue() && (ifVar = this.f12818.f12808) != null) {
                ifVar.mo1480(AddToListData.AddToListState.IN_LIST);
            }
        }
    }
}
