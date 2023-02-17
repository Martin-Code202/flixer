package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintSet;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.feeds.PlayerControls;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$10;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$11;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$12;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$13;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$14;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$15;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$16;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$17;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$19$$special$$inlined$let$lambda$1;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$19$$special$$inlined$let$lambda$2;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$22;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$23;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$4;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$5;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$6;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$7;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$8;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$9;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$controls$1;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$10;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$11;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$12;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$13;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$3;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$4;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$5;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$6;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$8;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$9;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewModel;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import com.netflix.model.leafs.originals.ListOfTagSummary;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C1106;
import o.rV;
import o.uE;
import org.json.JSONObject;
public final class rZ {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0180 f9735 = new C0180(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final AbstractC2055pd f9736 = new rT();

    /* renamed from: o.rZ$ˊ  reason: contains not printable characters */
    public static final class C0180 {
        private C0180() {
        }

        public /* synthetic */ C0180(C1456Fq fq) {
            this();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final AbstractC2055pd m10307() {
            return rZ.f9736;
        }
    }

    /* renamed from: o.rZ$iF  reason: case insensitive filesystem */
    public static abstract class AbstractC2110iF extends RecyclerView.ViewHolder {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final ReplaySubject<EA> f9740 = ReplaySubject.create();

        /* renamed from: ˎ */
        public abstract boolean mo10238(RecyclerView recyclerView);

        /* renamed from: ॱ */
        public abstract void mo10240(int i, rW rWVar, List<? extends Object> list, boolean z);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AbstractC2110iF(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
            super(layoutInflater.inflate(i, viewGroup, false));
            C1457Fr.m5025(layoutInflater, "inflater");
            C1457Fr.m5025(viewGroup, "parentView");
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˎ  reason: contains not printable characters */
        public final ReplaySubject<EA> m10245() {
            return this.f9740;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m10242(int i, rW rWVar, List<? extends Object> list, boolean z) {
            C1457Fr.m5025(rWVar, Event.DATA);
            mo10240(i, rWVar, list, z);
        }

        /* renamed from: ˏ */
        public void mo10239() {
        }

        /* renamed from: ˊ */
        public void mo10237() {
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo10246() {
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean mo10244() {
            return false;
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        public void mo10241() {
            this.f9740.onNext(EA.f5503);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo10243(Configuration configuration) {
            C1457Fr.m5025(configuration, "newConfig");
        }
    }

    public static final class If extends AbstractC2110iF {

        /* renamed from: ˎ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f9737 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(If.class), "itemLoadingAnimationView", "getItemLoadingAnimationView()Landroid/view/View;"))};

        /* renamed from: ˋ  reason: contains not printable characters */
        private final rY f9738;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final FI f9739 = C1197.m16471(this, (int) R.id.item_loading_animation);

        /* renamed from: ʻ  reason: contains not printable characters */
        private final View m10234() {
            return (View) this.f9739.mo4986(this, f9737[0]);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public If(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater, viewGroup, R.layout.trailers_feed_loading_more);
            C1457Fr.m5025(layoutInflater, "inflater");
            C1457Fr.m5025(viewGroup, "parentView");
            this.f9738 = (rY) viewGroup;
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo10240(int i, rW rWVar, List<? extends Object> list, boolean z) {
            C1457Fr.m5025(rWVar, Event.DATA);
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo10237() {
            super.mo10237();
            m10235();
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo10239() {
            m10236();
            super.mo10239();
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        private final void m10235() {
            if (!C1322Av.m3792()) {
                try {
                    AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(m10234().getContext(), R.drawable.avd_trailers_feed_loading_skeleton);
                    if (create instanceof AnimatedVectorDrawableCompat) {
                        m10234().setBackground(create);
                        if (!create.isRunning()) {
                            create.start();
                        }
                    }
                    if (m10234().getLayoutParams().height != this.f9738.getMeasuredHeight()) {
                        m10234().getLayoutParams().height = this.f9738.getMeasuredHeight();
                        m10234().requestLayout();
                    }
                } catch (Exception e) {
                    C1276.m16820().mo5729("Unable to load avd_trailers_feed_loading_skeleton", e);
                }
            }
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final void m10236() {
            if (!C1322Av.m3792()) {
                Drawable background = m10234().getBackground();
                if (background instanceof AnimatedVectorDrawableCompat) {
                    if (!((AnimatedVectorDrawableCompat) background).isRunning()) {
                        ((AnimatedVectorDrawableCompat) background).stop();
                    }
                    m10234().setBackground(null);
                }
            }
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean mo10238(RecyclerView recyclerView) {
            C1457Fr.m5025(recyclerView, "recyclerView");
            return false;
        }
    }

    /* renamed from: o.rZ$if  reason: invalid class name */
    public static final class Cif extends AbstractC2110iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f9741 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "debugView", "getDebugView()Lcom/netflix/android/widgetry/widget/RecyclerViewHolderDebugView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "headerText", "getHeaderText()Landroid/widget/TextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "footerText", "getFooterText()Landroid/widget/TextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "remindMe", "getRemindMe()Lcom/netflix/mediaclient/android/widget/NetflixTextButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "description", "getDescription()Landroid/widget/TextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "image", "getImage()Lcom/netflix/mediaclient/android/widget/AdvancedImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "tags", "getTags()Lcom/netflix/android/widgetry/widget/TagsLayout;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(Cif.class), "video", "getVideo()Lcom/netflix/mediaclient/ui/feeds/TrailerVideoView;"))};

        /* renamed from: ʻ  reason: contains not printable characters */
        private final FI f9742;

        /* renamed from: ʻॱ  reason: contains not printable characters */
        private final ConstraintSet f9743;

        /* renamed from: ʼ  reason: contains not printable characters */
        private final FI f9744;

        /* renamed from: ʼॱ  reason: contains not printable characters */
        private final CompositeDisposable f9745;

        /* renamed from: ʽ  reason: contains not printable characters */
        private boolean f9746;

        /* renamed from: ʽॱ  reason: contains not printable characters */
        private long f9747;

        /* renamed from: ʾ  reason: contains not printable characters */
        private long f9748;

        /* renamed from: ʿ  reason: contains not printable characters */
        private final PublishSubject<EA> f9749;

        /* renamed from: ˈ  reason: contains not printable characters */
        private rW f9750;

        /* renamed from: ˉ  reason: contains not printable characters */
        private C0970 f9751;

        /* renamed from: ˊˊ  reason: contains not printable characters */
        private C0618 f9752;

        /* renamed from: ˊॱ  reason: contains not printable characters */
        private final ColorDrawable f9753;

        /* renamed from: ˊᐝ  reason: contains not printable characters */
        private final TrailersFeedViewModel f9754;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final FI f9755;

        /* renamed from: ˋˊ  reason: contains not printable characters */
        private final ViewGroup f9756;

        /* renamed from: ˋॱ  reason: contains not printable characters */
        private float f9757;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final FI f9758;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final FI f9759;

        /* renamed from: ˏॱ  reason: contains not printable characters */
        private final ValueAnimator f9760;

        /* renamed from: ͺ  reason: contains not printable characters */
        private final PlayerControls f9761;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C2140sb f9762;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private final FI f9763;

        /* renamed from: ॱˋ  reason: contains not printable characters */
        private boolean f9764;

        /* renamed from: ॱˎ  reason: contains not printable characters */
        private int f9765;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private final FI f9766;

        /* renamed from: ॱᐝ  reason: contains not printable characters */
        private final ConstraintSet f9767;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final FI f9768;

        /* renamed from: ᐝॱ  reason: contains not printable characters */
        private boolean f9769;

        /* renamed from: ʻ  reason: contains not printable characters */
        private final TextView m10248() {
            return (TextView) this.f9755.mo4986(this, f9741[2]);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ʽ  reason: contains not printable characters */
        private final C1045 m10252() {
            return (C1045) this.f9758.mo4986(this, f9741[0]);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊॱ  reason: contains not printable characters */
        private final C0522 m10258() {
            return (C0522) this.f9768.mo4986(this, f9741[5]);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋॱ  reason: contains not printable characters */
        private final rV m10265() {
            return (rV) this.f9763.mo4986(this, f9741[7]);
        }

        /* renamed from: ˏॱ  reason: contains not printable characters */
        private final TextView m10280() {
            return (TextView) this.f9742.mo4986(this, f9741[4]);
        }

        /* access modifiers changed from: private */
        /* renamed from: ͺ  reason: contains not printable characters */
        public final C0754 m10281() {
            return (C0754) this.f9744.mo4986(this, f9741[3]);
        }

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private final C1106 m10286() {
            return (C1106) this.f9766.mo4986(this, f9741[6]);
        }

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private final TextView m10288() {
            return (TextView) this.f9759.mo4986(this, f9741[1]);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(TrailersFeedViewModel trailersFeedViewModel, LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater, viewGroup, R.layout.trailers_feed_title_with_trailer);
            C1457Fr.m5025(trailersFeedViewModel, "trailersFeedViewModel");
            C1457Fr.m5025(layoutInflater, "inflater");
            C1457Fr.m5025(viewGroup, "parentView");
            this.f9754 = trailersFeedViewModel;
            this.f9756 = viewGroup;
            View view = this.itemView;
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.feeds.TrailersItemConstraintLayout");
            }
            this.f9762 = (C2140sb) view;
            this.f9758 = C1197.m16471(this, (int) R.id.debug_view);
            this.f9759 = C1197.m16471(this, (int) R.id.item_header_text);
            this.f9755 = C1197.m16471(this, (int) R.id.item_footer_text);
            this.f9744 = C1197.m16471(this, (int) R.id.remind_me);
            this.f9742 = C1197.m16471(this, (int) R.id.description);
            this.f9768 = C1197.m16471(this, (int) R.id.image);
            this.f9766 = C1197.m16471(this, (int) R.id.tags);
            this.f9760 = new ValueAnimator();
            View view2 = this.itemView;
            C1457Fr.m5016((Object) view2, "itemView");
            this.f9753 = new ColorDrawable(BrowseExperience.m1767((Activity) C0345.m13893(view2.getContext(), Activity.class), (int) R.attr.trailersShadeColor));
            View view3 = this.itemView;
            C1457Fr.m5016((Object) view3, "itemView");
            this.f9761 = new PlayerControls(view3, this.f9754, new TrailersFeedViewHolders$TitleWithTrailer$controls$1(this));
            this.f9763 = C1197.m16471(this, (int) R.id.video);
            this.f9767 = new ConstraintSet();
            this.f9743 = new ConstraintSet();
            this.f9745 = new CompositeDisposable();
            this.f9748 = -1;
            this.f9749 = PublishSubject.create();
            C1283.m16854(m10253(this, (String) null, 1, (Object) null), "new(" + getAdapterPosition() + ')');
            this.f9761.m1833(false, false);
            this.f9761.m1837(false, false);
            this.f9767.clone(this.f9762);
            this.f9743.clone(this.f9762.getContext(), R.layout.trailers_feed_title_with_trailer_fullscreen);
            m10281().setText(m10249());
            this.f9762.setForeground(this.f9753);
            this.f9760.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: o.rZ.if.5

                /* renamed from: ˏ  reason: contains not printable characters */
                final /* synthetic */ Cif f9774;

                {
                    this.f9774 = r1;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C1457Fr.m5016((Object) valueAnimator, "animation");
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
                    }
                    this.f9774.f9753.setAlpha((int) (255.0f * ((Float) animatedValue).floatValue()));
                }
            });
            this.f9760.addListener(new AnimatorListenerAdapter(this) { // from class: o.rZ.if.2

                /* renamed from: ˋ  reason: contains not printable characters */
                final /* synthetic */ Cif f9771;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.f9771 = r1;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    C1457Fr.m5025(animator, "animator");
                    this.f9771.f9746 = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C1457Fr.m5025(animator, "animator");
                    this.f9771.f9746 = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    C1457Fr.m5025(animator, "animator");
                    this.f9771.f9746 = true;
                }
            });
            m10286().setOnTagClickListener(new C1106.Cif(this) { // from class: o.rZ.if.9

                /* renamed from: ॱ  reason: contains not printable characters */
                final /* synthetic */ Cif f9776;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.f9776 = r1;
                }

                @Override // o.C1106.Cif
                /* renamed from: ˏ  reason: contains not printable characters */
                public void mo10297(View view4, int i) {
                    ListOfTagSummary[] r3;
                    C1457Fr.m5025(view4, "view");
                    rW rWVar = this.f9776.f9750;
                    if (rWVar != null && (r3 = rWVar.mo4191()) != null) {
                        if (i < 0 || i >= r3.length) {
                            C1276.m16820().mo5725("Tag click out of bounds (p=" + i + ", s=" + r3.length + ')');
                            return;
                        }
                        ListOfTagSummary listOfTagSummary = r3[i];
                        uE.C2198iF iFVar = uE.f10700;
                        C1457Fr.m5016((Object) listOfTagSummary, "tag");
                        iFVar.m11360(listOfTagSummary);
                        ActivityC2153sl.m10769((NetflixActivity) C0345.m13893(view4.getContext(), NetflixActivity.class), listOfTagSummary);
                    }
                }
            });
            SubscribersKt.subscribeBy$default(this.f9761.m1826(), new TrailersFeedViewHolders$TitleWithTrailer$5(this), null, new TrailersFeedViewHolders$TitleWithTrailer$4(this), 2, null);
            SubscribersKt.subscribeBy$default(this.f9761.m1840(), new TrailersFeedViewHolders$TitleWithTrailer$7(this), null, new TrailersFeedViewHolders$TitleWithTrailer$6(this), 2, null);
            SubscribersKt.subscribeBy$default(this.f9761.m1827(), new TrailersFeedViewHolders$TitleWithTrailer$9(this), null, new TrailersFeedViewHolders$TitleWithTrailer$8(this), 2, null);
            SubscribersKt.subscribeBy$default(this.f9761.m1825(), new TrailersFeedViewHolders$TitleWithTrailer$11(this), null, new TrailersFeedViewHolders$TitleWithTrailer$10(this), 2, null);
            SubscribersKt.subscribeBy$default(this.f9761.m1835(), new TrailersFeedViewHolders$TitleWithTrailer$13(this), null, new TrailersFeedViewHolders$TitleWithTrailer$12(this), 2, null);
            SubscribersKt.subscribeBy$default(this.f9761.m1831(), new TrailersFeedViewHolders$TitleWithTrailer$15(this), null, new TrailersFeedViewHolders$TitleWithTrailer$14(this), 2, null);
            SubscribersKt.subscribeBy$default(this.f9761.m1834(), new TrailersFeedViewHolders$TitleWithTrailer$17(this), null, TrailersFeedViewHolders$TitleWithTrailer$16.f3111, 2, null);
            m10265().setOnPlayProgressListener(new IPlayer.Cif(this) { // from class: o.rZ.if.3

                /* renamed from: ॱ  reason: contains not printable characters */
                final /* synthetic */ Cif f9772;

                {
                    this.f9772 = r1;
                }

                @Override // com.netflix.mediaclient.servicemgr.IPlayer.Cif
                /* renamed from: ॱ */
                public final void mo1529(long j) {
                    rW rWVar = this.f9772.f9750;
                    if (rWVar != null) {
                        rWVar.m10220((int) j);
                    }
                }
            });
            m10265().setPlayerStatusChangeListener(new IPlayer.AbstractC0025(this) { // from class: o.rZ.if.4

                /* renamed from: ˊ  reason: contains not printable characters */
                public final /* synthetic */ Cif f9773;

                {
                    this.f9773 = r1;
                }

                @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0025
                /* renamed from: ˏ */
                public final void mo1531(IPlayer.PlayerState playerState) {
                    TrailersFeedItemSummary r13;
                    rW rWVar = this.f9773.f9750;
                    if (rWVar != null) {
                        C1283.m16854(Cif.m10253(this.f9773, (String) null, 1, (Object) null), "state changed to " + playerState);
                        this.f9773.m10252().m16048("" + playerState);
                        if (playerState != null) {
                            switch (C2144sf.f10138[playerState.ordinal()]) {
                                case 1:
                                case 6:
                                    return;
                                case 2:
                                    this.f9773.m10258().setVisibility(0);
                                    Cif.m10255(this.f9773, rWVar, false, 2, null);
                                    return;
                                case 3:
                                    this.f9773.m10258().setVisibility(0);
                                    this.f9773.m10267(rWVar, true);
                                    C0618 r9 = this.f9773.f9752;
                                    if (r9 != null) {
                                        Logger.INSTANCE.m140(Long.valueOf(r9.m14625()));
                                        this.f9773.f9752 = null;
                                    }
                                    rW rWVar2 = this.f9773.f9750;
                                    if (rWVar2 != null) {
                                        String r11 = rWVar2.mo4199();
                                        String r12 = rWVar2.mo4203();
                                        if (r11 != null && r12 != null && (r13 = this.f9773.f9754.m1951()) != null) {
                                            C1300Ac.m3530(r13.getId(), this.f9773.f9754.m1925(), r11, r12, null, rWVar2.m10214(), AppView.replayButton);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 4:
                                    this.f9773.m10265().setVisibility(0);
                                    this.f9773.m10258().setVisibility(8);
                                    this.f9773.f9761.m1829(this.f9773.f9754.m1954(), true);
                                    rWVar.m10221(true);
                                    if (this.f9773.f9748 != -1) {
                                        this.f9773.f9747 = System.currentTimeMillis() - this.f9773.f9748;
                                        this.f9773.m10252().m16048("play delay " + this.f9773.f9747 + " msec");
                                    }
                                    Observable<R> map = C0965.m15783(this.f9773.m10265()).map(C0972.f14975);
                                    C1457Fr.m5016((Object) map, "RxView.clicks(this).map(VoidToUnit)");
                                    Observable<R> takeUntil = map.takeUntil(this.f9773.f9749);
                                    C1457Fr.m5016((Object) takeUntil, "video.clicks()\n         …        .takeUntil(idles)");
                                    SubscribersKt.subscribeBy$default(takeUntil, new TrailersFeedViewHolders$TitleWithTrailer$19$$special$$inlined$let$lambda$2(this, playerState), null, new TrailersFeedViewHolders$TitleWithTrailer$19$$special$$inlined$let$lambda$1(this, playerState), 2, null);
                                    this.f9773.m10292();
                                    C0970 r92 = this.f9773.f9751;
                                    if (r92 != null) {
                                        Logger.INSTANCE.m140(Long.valueOf(r92.m14625()));
                                        this.f9773.f9751 = null;
                                    }
                                    Cif ifVar = this.f9773;
                                    C0618 r93 = new C0618(rWVar.m10219());
                                    Logger.INSTANCE.m142(r93);
                                    ifVar.f9752 = r93;
                                    return;
                                case 5:
                                    if (this.f9773.f9769 || this.f9773.f9764) {
                                        this.f9773.f9761.m1829(this.f9773.f9754.m1954(), false);
                                    } else {
                                        this.f9773.m10258().setVisibility(0);
                                        this.f9773.f9761.m1836(8);
                                        Cif.m10255(this.f9773, rWVar, false, 2, null);
                                    }
                                    rWVar.m10221(false);
                                    C0618 r94 = this.f9773.f9752;
                                    if (r94 != null) {
                                        Logger.INSTANCE.m147(new C0386(r94));
                                        this.f9773.f9752 = null;
                                        return;
                                    }
                                    return;
                            }
                        }
                        C1276.m16820().mo5727("Unhandled state : " + playerState);
                    }
                }
            });
            m10265().setRetryPolicy(new rV.Cif(this) { // from class: o.rZ.if.1

                /* renamed from: ˋ  reason: contains not printable characters */
                final /* synthetic */ Cif f9770;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.f9770 = r1;
                }

                @Override // o.rV.Cif
                /* renamed from: ˊ */
                public boolean mo10209(long j) {
                    rW rWVar = this.f9770.f9750;
                    if ((rWVar instanceof rW) && C1457Fr.m5018((Object) rWVar.m10227().getValue(), (Object) true) && rWVar.mo4192() != null) {
                        pF r0 = rWVar.mo4192();
                        if (Long.parseLong(r0 != null ? r0.getPlayableId() : null) == j) {
                            this.f9770.m10252().m16048("Retry");
                            return true;
                        }
                    }
                    this.f9770.m10252().m16048("No retry");
                    return false;
                }
            }, 3, 1000);
            m10265().setOnErrorListener(new IPlayer.AbstractC0024(this) { // from class: o.rZ.if.8

                /* renamed from: ॱ  reason: contains not printable characters */
                final /* synthetic */ Cif f9775;

                {
                    this.f9775 = r1;
                }

                @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0024
                /* renamed from: ˎ */
                public final void mo1530(IPlayer.aux aux) {
                    this.f9775.m10252().m16048("Playback error : " + aux);
                    this.f9775.f9761.m1839();
                    this.f9775.m10258().setVisibility(0);
                    C0970 r4 = this.f9775.f9751;
                    if (r4 != null) {
                        Logger.INSTANCE.m147(new C0389(r4, new C0510("" + aux)));
                        this.f9775.f9751 = null;
                    }
                    C0618 r42 = this.f9775.f9752;
                    if (r42 != null) {
                        Logger.INSTANCE.m147(new C0389(r42, new C0510("" + aux)));
                        this.f9775.f9752 = null;
                    }
                }
            });
            Observable<R> map = C0965.m15783(m10281()).map(C0972.f14975);
            C1457Fr.m5016((Object) map, "RxView.clicks(this).map(VoidToUnit)");
            Observable<R> takeUntil = map.takeUntil(m10245());
            C1457Fr.m5016((Object) takeUntil, "remindMe.clicks()\n      …      .takeUntil(destroy)");
            SubscribersKt.subscribeBy$default(takeUntil, new TrailersFeedViewHolders$TitleWithTrailer$23(this), null, new TrailersFeedViewHolders$TitleWithTrailer$22(this), 2, null);
            View view4 = this.itemView;
            C1457Fr.m5016((Object) view4, "itemView");
            LifecycleOwner lifecycleOwner = (LifecycleOwner) C0345.m13893(view4.getContext(), LifecycleOwner.class);
            if (lifecycleOwner instanceof LifecycleOwner) {
                this.f9754.m1929().observe(lifecycleOwner, new C2111iF(this));
                return;
            }
            AbstractC1236 r0 = C1276.m16820();
            StringBuilder append = new StringBuilder().append("");
            View view5 = this.itemView;
            C1457Fr.m5016((Object) view5, "itemView");
            r0.mo5725(append.append(view5.getContext()).append(" should resolve to a LifecycleOwner class").toString());
        }

        /* renamed from: o.rZ$if$iF  reason: case insensitive filesystem */
        static final class C2111iF<T> implements Observer<Boolean> {

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ Cif f9778;

            C2111iF(Cif ifVar) {
                this.f9778 = ifVar;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final void onChanged(Boolean bool) {
                C1283.m16854(Cif.m10253(this.f9778, (String) null, 1, (Object) null), "audio.observe " + bool + " at position " + this.f9778.getAdapterPosition());
                if (bool instanceof Boolean) {
                    this.f9778.m10263(bool.booleanValue());
                }
            }
        }

        /* renamed from: ʻॱ  reason: contains not printable characters */
        private final int m10249() {
            return C0682.m14923() ? R.string.coming_soon_remind_me : R.string.label_my_list_2;
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        public final int m10296() {
            return C0682.m14923() ? R.drawable.ic_coming_soon_remind_me_bell : R.drawable.ic_coming_soon_remind_me_plus;
        }

        /* access modifiers changed from: private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public final void m10277(boolean z) {
            m10281().setCompoundDrawablesRelative(z ? ContextCompat.getDrawable(m10281().getContext(), R.drawable.ic_coming_soon_remind_me_check) : ContextCompat.getDrawable(m10281().getContext(), m10296()), null, null, null);
            m10281().setText(m10249());
        }

        /* access modifiers changed from: private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m10261(Throwable th) {
            C1276.m16820().mo5729(m10252().m16054(), th);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("callback", "handleOnError");
            jSONObject.put(ExceptionClEvent.CATEGORY_VALUE, th.toString());
            Logger.INSTANCE.m131(new C0729(jSONObject));
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ˎ */
        public boolean mo10238(RecyclerView recyclerView) {
            C1457Fr.m5025(recyclerView, "recyclerView");
            int[] iArr = new int[2];
            m10265().getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            recyclerView.getLocationInWindow(iArr2);
            return iArr[1] >= iArr2[1] && iArr[1] + m10265().getMeasuredHeight() < iArr2[1] + recyclerView.getMeasuredHeight();
        }

        @SuppressLint({"NewApi"})
        /* renamed from: ˎ  reason: contains not printable characters */
        public final void m10295(boolean z) {
            rW rWVar = this.f9750;
            if ((rWVar instanceof rW) && rWVar.mo4190()) {
                if (z) {
                    m10252().m16048("play");
                }
                C1283.m16854(m10253(this, (String) null, 1, (Object) null), "play " + getAdapterPosition());
                pF r0 = rWVar.mo4192();
                long parseLong = Long.parseLong(r0 != null ? r0.getPlayableId() : null);
                m10265().setViewInFocus(parseLong, true);
                if (!m10265().m2347()) {
                    this.f9764 = false;
                    if (C1457Fr.m5018(m10265().m2344(), IPlayer.PlayerState.Paused)) {
                        this.f9748 = -1;
                        m10265().m2345();
                    } else if (rWVar.mo4190() && (rWVar.mo4192() instanceof pF)) {
                        if (this.f9751 == null) {
                            C0970 r13 = new C0970(0, rWVar.m10219());
                            Logger.INSTANCE.m142(r13);
                            this.f9751 = r13;
                        }
                        oY r132 = this.f9754.m1941();
                        if (r132 instanceof oY) {
                            C1283.m16854("TrailersFeedViewHolders", "Playing " + rWVar.mo4198());
                            this.f9748 = System.currentTimeMillis();
                            this.f9761.m1832();
                            m10252().m16048("attachPlaybackSessionAndPlay");
                            m10265().mo2340(r132, parseLong, rWVar.mo4201(), rZ.f9735.m10307(), rWVar.m10222(), 0, true);
                            return;
                        }
                        C1276.m16820().mo5725("trailersFeedViewModel.videoGroup should not ne null");
                    }
                } else {
                    C1283.m16854(m10253(this, (String) null, 1, (Object) null), "already playing " + getAdapterPosition());
                }
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m10293(boolean z) {
            if (this.f9750 instanceof rW) {
                C1283.m16854(m10253(this, (String) null, 1, (Object) null), "pause " + getAdapterPosition());
                if (m10265().m2347()) {
                    this.f9769 = z;
                    m10265().m2350();
                }
            }
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ॱ */
        public void mo10240(int i, rW rWVar, List<? extends Object> list, boolean z) {
            String str;
            C1457Fr.m5025(rWVar, Event.DATA);
            C1283.m16854(m10253(this, (String) null, 1, (Object) null), "Bind " + rWVar.mo4198() + ' ' + rWVar.mo4195() + ' ' + rWVar.mo4191());
            m10252().mo16050(i);
            this.f9765++;
            C1283.m16854(m10253(this, (String) null, 1, (Object) null), "onBind(" + getAdapterPosition() + ')');
            this.f9750 = rWVar;
            TextView r0 = m10288();
            if (rWVar.mo4202() != null) {
                View view = this.itemView;
                C1457Fr.m5016((Object) view, "itemView");
                str = C0403.m14185(view.getContext(), R.string.coming_soon_title_and_season_Label).m14186("title", rWVar.mo4198()).m14186("seasonLabel", rWVar.mo4202()).m14188();
            } else {
                str = "" + rWVar.mo4198();
            }
            r0.setText(str);
            m10248().setText(rWVar.mo4193() == null ? String.valueOf(rWVar.mo4196()) : rWVar.mo4193());
            m10288().setVisibility(0);
            TextView r02 = m10280();
            rW rWVar2 = this.f9750;
            r02.setText(rWVar2 != null ? rWVar2.mo4200() : null);
            if (rWVar.mo4195() != null) {
                View view2 = this.itemView;
                C1457Fr.m5016((Object) view2, "itemView");
                ImageLoader imageLoader = NetflixActivity.getImageLoader(view2.getContext());
                if (imageLoader != null) {
                    imageLoader.mo3057(m10258(), String.valueOf(rWVar.mo4195()), AssetType.heroImage, "trailerFeedItem", StaticImgConfig.DARK, false);
                }
            } else {
                m10258().setImageResource(R.color.black);
            }
            this.f9761.m1828(C0682.m14921());
            m10277(rWVar.mo4194());
            m10263(this.f9754.m1954());
            m10278(false, false);
            m10272(rWVar);
            this.f9761.m458((PlayerControls) rWVar);
            m10258().setVisibility(0);
            m10255(this, rWVar, false, 2, null);
            m10284(i, z);
            m10286().setAdapter(new Cif(rWVar));
            C1106 r03 = m10286();
            ListOfTagSummary[] r1 = rWVar.mo4191();
            r03.setVisibility((r1 != null ? r1.length : 0) > 0 ? 0 : 8);
        }

        /* renamed from: o.rZ$if$if  reason: invalid class name */
        public static final class Cif implements C1106.AbstractC2410iF {

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ rW f9779;

            Cif(rW rWVar) {
                this.f9779 = rWVar;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public String mo10301(int i) {
                ListOfTagSummary listOfTagSummary;
                ListOfTagSummary[] r0 = this.f9779.mo4191();
                if (r0 == null || (listOfTagSummary = r0[i]) == null) {
                    return null;
                }
                return listOfTagSummary.getTitle();
            }

            @Override // o.C1106.AbstractC2410iF
            /* renamed from: ˊ  reason: contains not printable characters */
            public int mo10300() {
                ListOfTagSummary[] r0 = this.f9779.mo4191();
                if (r0 != null) {
                    return r0.length;
                }
                return 0;
            }

            @Override // o.C1106.AbstractC2410iF
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo10304(int i) {
                this.f9779.m10223(i);
            }

            @Override // o.C1106.AbstractC2410iF
            /* renamed from: ˏ  reason: contains not printable characters */
            public boolean mo10303(int i) {
                return true;
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private final void m10284(int i, boolean z) {
            if (z) {
                this.f9762.setItemMode(1);
            } else if (i == 0) {
                this.f9762.setItemMode(-1);
            } else {
                this.f9762.setItemMode(0);
            }
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ˊ */
        public void mo10237() {
            m10252().mo16051();
            C1283.m16854(m10253(this, (String) null, 1, (Object) null), "onViewAttachedToWindow(" + getAdapterPosition() + ')');
            super.mo10237();
            this.f9761.m1836(8);
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ˏ */
        public void mo10239() {
            m10252().mo16052();
            C1283.m16854(m10253(this, (String) null, 1, (Object) null), "onViewDetachedFromWindow(" + getAdapterPosition() + ')');
            C0970 r3 = this.f9751;
            if (r3 != null) {
                Logger.INSTANCE.m147(new C0386(r3));
                this.f9751 = null;
            }
            m10293(false);
            super.mo10239();
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ॱ */
        public void mo10246() {
            m10252().mo16053();
            C1283.m16854(m10253(this, (String) null, 1, (Object) null), "onViewRecycled(" + getAdapterPosition() + ')');
            rW rWVar = this.f9750;
            if (rWVar instanceof rW) {
                this.f9761.m455((PlayerControls) rWVar);
                this.f9750 = null;
            }
            this.f9745.clear();
            m10278(false, false);
            m10265().b_();
            this.f9760.cancel();
            super.mo10246();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private final void m10263(boolean z) {
            if (m10265().m2347() || C1457Fr.m5018(m10265().m2344(), IPlayer.PlayerState.Paused)) {
                this.f9761.m1829(z, m10265().m2347());
            }
            if (!z) {
                m10265().setVolume(0.0f);
            } else {
                m10265().setVolume(1.0f);
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static /* bridge */ /* synthetic */ void m10276(Cif ifVar, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = true;
            }
            ifVar.m10278(z, z2);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private final void m10278(boolean z, boolean z2) {
            float f = z ? 0.0f : 1.0f;
            if (!z2) {
                this.f9757 = f;
                this.f9760.cancel();
                this.f9753.setAlpha((int) (this.f9757 * 255.0f));
            } else if (!C1021.m15987(this.f9757, f)) {
                if (this.f9746) {
                    this.f9760.cancel();
                }
                this.f9757 = f;
                this.f9760.setFloatValues(0.003921569f * ((float) this.f9753.getAlpha()), f);
                this.f9760.start();
                C1283.m16854(m10253(this, (String) null, 1, (Object) null), "Starting to animate from " + this.f9753.getAlpha() + " to " + this.f9757);
            }
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ˋ */
        public boolean mo10244() {
            m10252().mo16049();
            C1283.m16854(m10253(this, (String) null, 1, (Object) null), "onFailedToRecycleView(" + getAdapterPosition() + ')');
            C1283.m16854(m10253(this, (String) null, 1, (Object) null), "itemView.hasTransientState = " + this.itemView.hasTransientState());
            if (this.itemView instanceof ViewGroup) {
                for (View view : C0549.m14593((ViewGroup) this.itemView)) {
                    C1283.m16854(m10253(this, (String) null, 1, (Object) null), "" + view.getResources().getResourceName(view.getId()) + ".hasTransientState = " + view.hasTransientState());
                }
            }
            this.f9760.cancel();
            return true;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private final void m10272(rW rWVar) {
            if (this.f9761.m1830()) {
                CompositeDisposable compositeDisposable = this.f9745;
                Observable<Boolean> filter = rWVar.m10227().doOnNext(new C0179(this, rWVar)).debounce(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).filter(new C0178(this, rWVar));
                C1457Fr.m5016((Object) filter, "data.focus\n             …data && data.isPlayable }");
                C1220.m16501(compositeDisposable, SubscribersKt.subscribeBy$default(filter, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$4(this), null, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$3(this, rWVar), 2, null));
            }
            CompositeDisposable compositeDisposable2 = this.f9745;
            Observable<Boolean> distinctUntilChanged = rWVar.m10226().distinctUntilChanged();
            C1457Fr.m5016((Object) distinctUntilChanged, "data.highlight\n         …  .distinctUntilChanged()");
            C1220.m16501(compositeDisposable2, SubscribersKt.subscribeBy$default(distinctUntilChanged, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$6(this), null, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$5(this, rWVar), 2, null));
            CompositeDisposable compositeDisposable3 = this.f9745;
            Observable<Boolean> filter2 = rWVar.m10227().filter(If.f9777);
            C1457Fr.m5016((Object) filter2, "data.focus\n             …  .filter { it == false }");
            C1220.m16501(compositeDisposable3, SubscribersKt.subscribeBy$default(filter2, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$9(this), null, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$8(this, rWVar), 2, null));
            C1220.m16501(this.f9745, SubscribersKt.subscribeBy$default(rWVar.m10224(), new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$11(this), null, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$10(this, rWVar), 2, null));
            PublishSubject<EA> r7 = rWVar.m10213();
            if (r7 != null) {
                C1220.m16501(this.f9745, SubscribersKt.subscribeBy$default(r7, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$13(this), null, new TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$12(this), 2, null));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.rZ$if$ˋ  reason: contains not printable characters */
        public static final class C0179<T> implements Consumer<Boolean> {

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ Cif f9782;

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ rW f9783;

            C0179(Cif ifVar, rW rWVar) {
                this.f9782 = ifVar;
                this.f9783 = rWVar;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final void accept(Boolean bool) {
                C1457Fr.m5025(bool, "focus");
                this.f9782.m10252().m16048("focus(" + this.f9782.getAdapterPosition() + ") " + bool);
                if (!this.f9783.mo4190() || !bool.booleanValue()) {
                    Cif.m10255(this.f9782, this.f9783, false, 2, null);
                    return;
                }
                this.f9782.f9761.m1832();
                Cif ifVar = this.f9782;
                C0970 r5 = new C0970(0, this.f9783.m10219());
                Logger.INSTANCE.m142(r5);
                ifVar.f9751 = r5;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.rZ$if$ˊ  reason: contains not printable characters */
        public static final class C0178<T> implements Predicate<Boolean> {

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ rW f9780;

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ Cif f9781;

            C0178(Cif ifVar, rW rWVar) {
                this.f9781 = ifVar;
                this.f9780 = rWVar;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final boolean test(Boolean bool) {
                C1457Fr.m5025(bool, "it");
                return C1457Fr.m5018(this.f9781.f9750, this.f9780) && this.f9780.mo4190();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.rZ$if$If */
        public static final class If<T> implements Predicate<Boolean> {

            /* renamed from: ˊ  reason: contains not printable characters */
            public static final If f9777 = new If();

            If() {
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final boolean test(Boolean bool) {
                C1457Fr.m5025(bool, "it");
                return C1457Fr.m5018((Object) bool, (Object) false);
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static /* synthetic */ void m10255(Cif ifVar, rW rWVar, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            ifVar.m10267(rWVar, z);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˎ  reason: contains not printable characters */
        private final void m10267(rW rWVar, boolean z) {
            this.f9761.m1837(rWVar.mo4190(), z);
            this.f9749.onNext(EA.f5503);
            Boolean value = rWVar.m10227().getValue();
            C1457Fr.m5016((Object) value, "data.focus.value");
            if (value.booleanValue()) {
                m10290();
            }
            C0970 r3 = this.f9751;
            if (r3 != null) {
                Logger.INSTANCE.m140(Long.valueOf(r3.m14625()));
                this.f9751 = null;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ᐝॱ  reason: contains not printable characters */
        private final void m10292() {
            View view = this.itemView;
            C1457Fr.m5016((Object) view, "itemView");
            Activity activity = (Activity) C0345.m13893(view.getContext(), Activity.class);
            if (activity != null) {
                if (activity.getRequestedOrientation() == 1) {
                    activity.setRequestedOrientation(-1);
                }
                this.f9754.m1949();
            }
        }

        /* renamed from: ॱᐝ  reason: contains not printable characters */
        private final void m10290() {
            View view = this.itemView;
            C1457Fr.m5016((Object) view, "itemView");
            Activity activity = (Activity) C0345.m13893(view.getContext(), Activity.class);
            if (activity != null) {
                activity.setRequestedOrientation(1);
                this.f9754.m1946();
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static /* synthetic */ String m10253(Cif ifVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "TrailersFeedViewHolders";
            }
            return ifVar.m10294(str);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final String m10294(String str) {
            C1457Fr.m5025(str, "tag");
            return str;
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ˋ */
        public void mo10243(Configuration configuration) {
            int i;
            C1457Fr.m5025(configuration, "newConfig");
            rW rWVar = this.f9750;
            if (rWVar != null) {
                Boolean value = rWVar.m10227().getValue();
                C1457Fr.m5016((Object) value, "currentItem.focus.value");
                if (value.booleanValue()) {
                    int visibility = m10252().getVisibility();
                    boolean z = m10265().m2347() || (m10265().m2331() && this.f9769);
                    if (configuration.orientation == 2) {
                        this.f9743.applyTo(this.f9762);
                        this.f9762.getLayoutParams().height = -1;
                        this.f9762.requestLayout();
                        this.f9761.m1833(true, z);
                        m10258().setVisibility(8);
                        m10288().setGravity(17);
                        this.f9762.setBackgroundColor(-16777216);
                        Logger.INSTANCE.m142(new C1132());
                        Logger.INSTANCE.m130("EnterFullscreenCommand");
                    } else {
                        this.f9767.applyTo(this.f9762);
                        this.f9762.getLayoutParams().height = -2;
                        this.f9762.requestLayout();
                        this.f9761.m1833(false, z);
                        C0522 r0 = m10258();
                        if (z) {
                            i = 8;
                        } else {
                            i = 0;
                        }
                        r0.setVisibility(i);
                        m10288().setGravity(8388611);
                        this.f9762.setBackground(null);
                        Logger.INSTANCE.m142(new C1102());
                        Logger.INSTANCE.m130("ExitFullscreenCommand");
                    }
                    m10252().setVisibility(visibility);
                }
            }
            super.mo10243(configuration);
        }

        @Override // o.rZ.AbstractC2110iF
        /* renamed from: ʼ */
        public void mo10241() {
            this.f9761.onDestroy();
            m10265().b_();
            super.mo10241();
        }
    }
}
