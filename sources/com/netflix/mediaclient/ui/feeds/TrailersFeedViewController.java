package com.netflix.mediaclient.ui.feeds;

import android.arch.lifecycle.LifecycleOwner;
import android.content.res.Configuration;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.common.ui.LifecycleController;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1449Fj;
import o.AbstractC1450Fk;
import o.C0549;
import o.C0567;
import o.C0616;
import o.C0682;
import o.C1046;
import o.C1197;
import o.C1276;
import o.C1283;
import o.C1322Av;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.EA;
import o.FI;
import o.FQ;
import o.rS;
import o.rW;
import o.rX;
import o.rY;
import o.rZ;
public final class TrailersFeedViewController extends LifecycleController<TrailersFeedViewModel> {

    /* renamed from: ˋ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f3078 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(TrailersFeedViewController.class), "trailerFeed", "getTrailerFeed()Lcom/netflix/mediaclient/ui/feeds/TrailersFeedRecyclerView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(TrailersFeedViewController.class), "loadingView", "getLoadingView()Landroid/view/View;"))};

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final If f3079 = new If(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final TrailersFeedViewController$linearLayoutManager$1 f3080 = new TrailersFeedViewController$linearLayoutManager$1(this, m1871().getContext(), 1, false);

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC1450Fk<EA, EA> f3081;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0616 f3082;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final FI f3083 = C1197.m16474(this, R.id.trailers_feed);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final FI f3084 = C1197.m16474(this, R.id.loading_view);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final PublishSubject<Configuration> f3085;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Parcelable f3086;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private final rY m1871() {
        return (rY) this.f3083.mo4986(this, f3078[0]);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private final View m1873() {
        return (View) this.f3084.mo4986(this, f3078[1]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: o.Fk<? super o.EA, o.EA> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewController(final LifecycleOwner lifecycleOwner, View view, AbstractC1450Fk<? super EA, EA> fk) {
        super(view);
        C1457Fr.m5025(lifecycleOwner, "lifecycleOwner");
        C1457Fr.m5025(view, "root");
        C1457Fr.m5025(fk, "onLoadItem");
        this.f3081 = fk;
        this.f3082 = new C0616(view, new Cif(this));
        this.f3085 = PublishSubject.create();
        m1871().setLayoutManager(this.f3080);
        final Observable<EA> r6 = m460();
        Observable takeUntil = m456().takeUntil(r6);
        C1457Fr.m5016((Object) takeUntil, "activates()\n            …ntil(takeUntilObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, null, new AbstractC1449Fj<EA>(this) { // from class: com.netflix.mediaclient.ui.feeds.TrailersFeedViewController.2

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ TrailersFeedViewController f3098;

            {
                this.f3098 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // o.AbstractC1449Fj
            public /* synthetic */ EA invoke() {
                m1889();
                return EA.f5503;
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m1889() {
                RecyclerView.Adapter adapter = this.f3098.m1871().getAdapter();
                if (adapter instanceof rS) {
                    ((rS) adapter).m10181();
                }
            }
        }, new AbstractC1450Fk<TrailersFeedViewModel, EA>(this) { // from class: com.netflix.mediaclient.ui.feeds.TrailersFeedViewController.1

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ TrailersFeedViewController f3087;

            {
                this.f3087 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // o.AbstractC1450Fk
            public /* synthetic */ EA invoke(TrailersFeedViewModel trailersFeedViewModel) {
                m1886(trailersFeedViewModel);
                return EA.f5503;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final void m1886(final TrailersFeedViewModel trailersFeedViewModel) {
                C1457Fr.m5016((Object) trailersFeedViewModel, "trailersFeedViewModel");
                final rS rSVar = new rS(trailersFeedViewModel, lifecycleOwner);
                this.f3087.m1871().setAdapter(rSVar);
                final iF iFVar = new iF(this, trailersFeedViewModel);
                if (C0682.m14927()) {
                    new rX(lifecycleOwner, trailersFeedViewModel, iFVar).m16072(this.f3087.m1871(), 40, 1, 7, 1);
                }
                this.f3087.m1871().setItemScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.netflix.mediaclient.ui.feeds.TrailersFeedViewController.1.1

                    /* renamed from: ˏ  reason: contains not printable characters */
                    final /* synthetic */ AnonymousClass1 f3091;

                    {
                        this.f3091 = r1;
                    }

                    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                        C1457Fr.m5025(recyclerView, "recyclerView");
                        switch (i) {
                            case 0:
                                if (!C0682.m14927()) {
                                    iFVar.mo1888(this.f3091.f3087.f3080.findFirstCompletelyVisibleItemPosition());
                                }
                                if (this.f3091.f3087.f3080.findLastVisibleItemPosition() > trailersFeedViewModel.m1928() - 5) {
                                    this.f3091.f3087.f3081.invoke(EA.f5503);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }

                    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                        C1457Fr.m5025(recyclerView, "recyclerView");
                        for (View view2 : C0549.m14593(recyclerView)) {
                            RecyclerView.ViewHolder childViewHolder = this.f3091.f3087.m1871().getChildViewHolder(view2);
                            if (childViewHolder == null) {
                                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders.BaseViewHolder");
                            }
                            rZ.AbstractC2110iF iFVar2 = (rZ.AbstractC2110iF) childViewHolder;
                            if (iFVar2.mo10238(this.f3091.f3087.m1871())) {
                                trailersFeedViewModel.m1942(iFVar2.getAdapterPosition());
                                return;
                            }
                        }
                    }
                });
                Observable takeUntil2 = this.f3087.f3085.takeUntil(r6);
                C1457Fr.m5016((Object) takeUntil2, "configurationChanges\n   …ntil(takeUntilObservable)");
                SubscribersKt.subscribeBy$default(takeUntil2, null, null, new AbstractC1450Fk<Configuration, EA>(this) { // from class: com.netflix.mediaclient.ui.feeds.TrailersFeedViewController.1.2

                    /* renamed from: ॱ  reason: contains not printable characters */
                    final /* synthetic */ AnonymousClass1 f3095;

                    {
                        this.f3095 = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // o.AbstractC1450Fk
                    public /* synthetic */ EA invoke(Configuration configuration) {
                        m1887(configuration);
                        return EA.f5503;
                    }

                    /* renamed from: ˋ  reason: contains not printable characters */
                    public final void m1887(Configuration configuration) {
                        switch (configuration.orientation) {
                            case 2:
                                rW value = trailersFeedViewModel.m1947().getValue();
                                if (!(value instanceof rW)) {
                                    C1276.m16820().mo5725("No focused item while changing to landscape");
                                    break;
                                } else {
                                    this.f3095.f3087.f3086 = this.f3095.f3087.f3080.onSaveInstanceState();
                                    this.f3095.f3087.f3080.scrollToPositionWithOffset(value.m10214(), 0);
                                    this.f3095.f3087.m1871().setScrollingLocked(true);
                                    break;
                                }
                            default:
                                Parcelable parcelable = this.f3095.f3087.f3086;
                                if (parcelable != null) {
                                    this.f3095.f3087.f3080.onRestoreInstanceState(parcelable);
                                    this.f3095.f3087.f3086 = null;
                                }
                                this.f3095.f3087.m1871().setScrollingLocked(false);
                                break;
                        }
                        rS rSVar2 = rSVar;
                        C1457Fr.m5016((Object) configuration, "newConfig");
                        rSVar2.m10175(configuration);
                    }
                }, 3, null);
                this.f3087.f3081.invoke(EA.f5503);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: com.netflix.mediaclient.ui.feeds.TrailersFeedViewController$1$iF */
            public static final class iF implements C1046.iF {

                /* renamed from: ˊ  reason: contains not printable characters */
                final /* synthetic */ TrailersFeedViewModel f3096;

                /* renamed from: ॱ  reason: contains not printable characters */
                final /* synthetic */ AnonymousClass1 f3097;

                iF(AnonymousClass1 r1, TrailersFeedViewModel trailersFeedViewModel) {
                    this.f3097 = r1;
                    this.f3096 = trailersFeedViewModel;
                }

                @Override // o.C1046.iF
                /* renamed from: ˋ  reason: contains not printable characters */
                public final void mo1888(int i) {
                    for (View view : C0549.m14593(this.f3097.f3087.m1871())) {
                        RecyclerView.ViewHolder childViewHolder = this.f3097.f3087.m1871().getChildViewHolder(view);
                        if (childViewHolder == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.feeds.TrailersFeedViewHolders.BaseViewHolder");
                        }
                        rZ.AbstractC2110iF iFVar = (rZ.AbstractC2110iF) childViewHolder;
                        if (iFVar.mo10238(this.f3097.f3087.m1871())) {
                            this.f3096.m1934(iFVar.getAdapterPosition());
                            return;
                        }
                    }
                }
            }
        }, 1, null);
    }

    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: com.netflix.mediaclient.ui.feeds.TrailersFeedViewController$if  reason: invalid class name */
    static final class Cif implements C0567.Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ TrailersFeedViewController f3099;

        Cif(TrailersFeedViewController trailersFeedViewController) {
            this.f3099 = trailersFeedViewController;
        }

        @Override // o.C0567.Cif
        public final void N_() {
            this.f3099.f3081.invoke(EA.f5503);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1881() {
        this.f3082.mo14660(true);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final void m1885() {
        m1871().setVisibility(8);
        this.f3082.mo14570(true);
        m1872();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m1883(Status status) {
        m1878();
        if (status == null || !status.mo298()) {
            this.f3082.mo14660(true);
            return;
        }
        m1871().setVisibility(0);
        this.f3082.mo14663(true);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private final void m1872() {
        if (!C1322Av.m3792()) {
            try {
                AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(m1873().getContext(), R.drawable.avd_trailers_feed_loading_skeleton);
                if (create instanceof AnimatedVectorDrawableCompat) {
                    m1873().setBackground(create);
                    if (!create.isRunning()) {
                        create.start();
                    }
                }
            } catch (Exception e) {
                C1276.m16820().mo5729("Unable to load avd_trailers_feed_loading_skeleton", e);
            }
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final void m1878() {
        if (!C1322Av.m3792()) {
            Drawable background = m1873().getBackground();
            if (background instanceof AnimatedVectorDrawable) {
                m1873().setBackground(null);
                if (!((AnimatedVectorDrawable) background).isRunning()) {
                    ((AnimatedVectorDrawable) background).stop();
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m1882(Configuration configuration) {
        C1457Fr.m5025(configuration, "newConfig");
        this.f3085.onNext(configuration);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final boolean m1884() {
        boolean z = this.f3080.findFirstCompletelyVisibleItemPosition() == 0;
        boolean z2 = this.f3080.findFirstVisibleItemPosition() > 40;
        if (z) {
            C1283.m16854("TrailersFeedViewController", "performUpAction, already at top");
            return false;
        } else if (z2) {
            C1283.m16854("TrailersFeedViewController", "performUpAction, direct scroll to top");
            m1871().scrollToPosition(0);
            return true;
        } else {
            C1283.m16854("TrailersFeedViewController", "performUpAction, smooth scroll to top");
            m1871().smoothScrollToPosition(0);
            return true;
        }
    }
}
