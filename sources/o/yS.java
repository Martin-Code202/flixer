package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import com.netflix.mediaclient.ui.player.ScaleType;
import com.netflix.mediaclient.ui.previews.PreviewsPlayerItemViewHolder$onViewFullyVisible$4;
import com.netflix.mediaclient.ui.previews.PreviewsPlayerItemViewHolder$onViewFullyVisible$5;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C2369ze;
public final class yS extends RecyclerView.ViewHolder {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0304 f12430 = new C0304(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f12431 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(yS.class), "placeHolderImgView", "getPlaceHolderImgView()Lcom/netflix/mediaclient/ui/previews/PulsatingImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(yS.class), "videoView", "getVideoView()Lcom/netflix/mediaclient/ui/player/NetflixVideoView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(yS.class), "debugView", "getDebugView()Lcom/netflix/android/widgetry/widget/RecyclerViewHolderDebugView;"))};

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static final AbstractC2055pd f12432 = new yP();

    /* renamed from: ʻ  reason: contains not printable characters */
    private final GestureDetectorCompat f12433;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final PublishSubject<C0461> f12434;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f12435;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f12436;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final FI f12437 = C1197.m16471(this, (int) R.id.previews_place_holder);

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f12438;

    /* renamed from: ˋ  reason: contains not printable characters */
    public yR f12439;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private AnimatorSet f12440;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final FI f12441 = C1197.m16471(this, (int) R.id.previews_video);

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private IPlayer.PlayerState f12442;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Boolean f12443;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final PublishSubject<IPlayer.aux> f12444;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private Disposable f12445;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final oY f12446;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f12447;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final FI f12448 = C1197.m16471(this, (int) R.id.previews_video_debug_view);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private final C2372zf m13249() {
        return (C2372zf) this.f12437.mo4986(this, f12431[0]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private final NetflixVideoView m13250() {
        return (NetflixVideoView) this.f12441.mo4986(this, f12431[1]);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C1045 m13253() {
        return (C1045) this.f12448.mo4986(this, f12431[2]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yS(View view, oY oYVar, PublishSubject<C0461> publishSubject) {
        super(view);
        C1457Fr.m5025(view, "view");
        this.f12446 = oYVar;
        this.f12434 = publishSubject;
        this.f12433 = new GestureDetectorCompat(view.getContext(), new If(this));
        this.f12442 = IPlayer.PlayerState.Idle;
        this.f12440 = new AnimatorSet();
        this.f12444 = PublishSubject.create();
        m13253().setVisibility(yV.f12463.m13298() ? 0 : 8);
        m13265();
        this.itemView.setOnTouchListener(new View.OnTouchListener(this) { // from class: o.yS.3

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ yS f12450;

            {
                this.f12450 = r1;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                C0304 r2 = yS.f12430;
                if (this.f12450.f12433.onTouchEvent(motionEvent)) {
                    return true;
                }
                C1457Fr.m5016((Object) motionEvent, "e");
                switch (motionEvent.getAction()) {
                    case 1:
                        this.f12450.m13269("setPlaybackTo from ACTION_UP");
                        this.f12450.m13276(true);
                        return true;
                    default:
                        return false;
                }
            }
        });
        m13249().setPassActualScaleTypeToParent(true);
        m13249().setScaleType(ImageView.ScaleType.CENTER_CROP);
        m13249().setAlpha(0.4f);
        this.f12440.setDuration(500L);
        this.f12440.playTogether(ObjectAnimator.ofFloat(m13249(), View.ALPHA, 0.4f, 0.0f), ObjectAnimator.ofFloat(m13250(), View.ALPHA, 0.0f, 1.0f));
        this.f12440.addListener(new AnimatorListenerAdapter(this) { // from class: o.yS.1

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ yS f12449;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f12449 = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.f12449.m13249().setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                C1457Fr.m5025(animator, "animation");
                this.f12449.m13250().setVisibility(0);
                this.f12449.m13249().m13642();
            }
        });
    }

    /* renamed from: o.yS$ˊ  reason: contains not printable characters */
    public static final class C0304 extends C1277 {
        private C0304() {
            super("PreviewsPlayerItemViewHolder");
        }

        public /* synthetic */ C0304(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˎ  reason: contains not printable characters */
        private final AbstractC2055pd m13277() {
            return yS.f12432;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final yR m13272() {
        yR yRVar = this.f12439;
        if (yRVar == null) {
            C1457Fr.m5017("currPreviewItem");
        }
        return yRVar;
    }

    public static final class If extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ yS f12451;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        If(yS ySVar) {
            this.f12451 = ySVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            C1457Fr.m5025(motionEvent, "event");
            C0304 r6 = yS.f12430;
            View view = this.f12451.itemView;
            C1457Fr.m5016((Object) view, "itemView");
            boolean z = ((double) motionEvent.getX()) < ((double) view.getWidth()) * 0.333d;
            PublishSubject publishSubject = this.f12451.f12434;
            if (publishSubject == null) {
                return true;
            }
            publishSubject.onNext(new C2369ze.Cif.aux(z ? 3 : 5, this.f12451.getAdapterPosition()));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            C1457Fr.m5025(motionEvent, "event");
            C0304 r1 = yS.f12430;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            C1457Fr.m5025(motionEvent, "event");
            C0304 r2 = yS.f12430;
            this.f12451.m13269("setPlaybackTo from onLongPress");
            this.f12451.m13276(false);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13275(Context context, int i, List<yR> list) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(list, "previewItems");
        if (i < list.size()) {
            this.f12439 = list.get(i);
            ImageLoader imageLoader = NetflixActivity.getImageLoader(context);
            if (imageLoader != null) {
                C2372zf r1 = m13249();
                String panelArtUrl = list.get(i).getPanelArtUrl();
                AssetType assetType = AssetType.boxArt;
                yR yRVar = this.f12439;
                if (yRVar == null) {
                    C1457Fr.m5017("currPreviewItem");
                }
                imageLoader.mo3063(r1, panelArtUrl, assetType, yRVar.getTitle(), BrowseExperience.m1769(), true, 1);
            }
            m13249().setVisibility(0);
            m13250().setVisibility(4);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m13270(boolean z) {
        this.f12435 = true;
        m13269("onViewAttachedToWindow");
        m13250().setViewInFocus(true);
        if (z) {
            m13269("setPlaybackTo from onViewAttached");
            m13276(true);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m13273(List<yR> list) {
        C1457Fr.m5025(list, "previewItems");
        this.f12435 = false;
        m13269("onViewDetachedToWindow");
        if (m13250().m2347()) {
            m13250().m2350();
        }
        m13250().b_();
        m13269("detached playback session @ PTS = " + this.f12436);
        m13250().setViewInFocus(false);
        if (getAdapterPosition() != -1 && getAdapterPosition() < list.size()) {
            list.get(getAdapterPosition()).setBookmark(this.f12436);
        }
        m13249().setVisibility(0);
        m13250().setVisibility(4);
        Disposable disposable = this.f12445;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f12445 = null;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final void m13265() {
        if (this.f12446 != null) {
            m13250().setScaleType(ScaleType.ZOOM);
            m13250().setOnErrorListener(new C2335iF(this));
            m13250().setPlayerStatusChangeListener(new Cif(this));
            m13250().setOnPlayProgressListener(new C0305(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.yS$iF  reason: case insensitive filesystem */
    public static final class C2335iF implements IPlayer.AbstractC0024 {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ yS f12452;

        C2335iF(yS ySVar) {
            this.f12452 = ySVar;
        }

        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0024
        /* renamed from: ˎ */
        public final void mo1530(IPlayer.aux aux) {
            yS ySVar = this.f12452;
            StringBuilder append = new StringBuilder().append('(').append(this.f12452.f12438).append(")(ERR=");
            C1457Fr.m5016((Object) aux, "playbackError");
            ySVar.m13269(append.append(aux.mo998()).append(") ").append(aux.mo1000()).toString());
            this.f12452.f12444.onNext(aux);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.yS$if  reason: invalid class name */
    public static final class Cif implements IPlayer.AbstractC0025 {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ yS f12453;

        Cif(yS ySVar) {
            this.f12453 = ySVar;
        }

        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0025
        /* renamed from: ˏ */
        public final void mo1531(IPlayer.PlayerState playerState) {
            this.f12453.m13269("player status changed = " + playerState);
            if (playerState != null) {
                switch (yU.f12461[playerState.ordinal()]) {
                    case 1:
                        this.f12453.m13249().setVisibility(0);
                        this.f12453.m13250().setVisibility(4);
                        break;
                    case 3:
                        this.f12453.m13269("play delay = " + (((float) (System.currentTimeMillis() - this.f12453.f12447)) / 1000.0f) + 's');
                        if (!C1457Fr.m5018(this.f12453.f12442, IPlayer.PlayerState.Paused)) {
                            this.f12453.f12440.start();
                        }
                        this.f12453.f12438 = 0;
                        Boolean bool = this.f12453.f12443;
                        if (bool != null) {
                            boolean booleanValue = bool.booleanValue();
                            this.f12453.f12443 = null;
                            this.f12453.m13269("deferred action - " + (booleanValue ? "play" : "pause"));
                            if (booleanValue) {
                                this.f12453.m13250().m2345();
                            } else {
                                this.f12453.m13250().m2350();
                            }
                        }
                        PublishSubject publishSubject = this.f12453.f12434;
                        if (publishSubject != null) {
                            publishSubject.onNext(new C2369ze.Cif.Cif(this.f12453.getAdapterPosition()));
                            break;
                        }
                        break;
                    case 5:
                        this.f12453.m13249().setVisibility(0);
                        this.f12453.m13250().b_();
                        this.f12453.m13250().setVisibility(4);
                        break;
                    case 6:
                        this.f12453.m13272().m13246().onNext(100);
                        this.f12453.m13250().b_();
                        PublishSubject publishSubject2 = this.f12453.f12434;
                        if (publishSubject2 != null) {
                            publishSubject2.onNext(new C2369ze.Cif.C0322(this.f12453.getAdapterPosition()));
                            break;
                        }
                        break;
                }
            }
            yS ySVar = this.f12453;
            C1457Fr.m5016((Object) playerState, "status");
            ySVar.f12442 = playerState;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.yS$ˋ  reason: contains not printable characters */
    public static final class C0305 implements IPlayer.Cif {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ yS f12454;

        C0305(yS ySVar) {
            this.f12454 = ySVar;
        }

        @Override // com.netflix.mediaclient.servicemgr.IPlayer.Cif
        /* renamed from: ॱ */
        public final void mo1529(long j) {
            this.f12454.f12436 = j;
            this.f12454.m13272().m13246().onNext(Integer.valueOf((int) (j / (this.f12454.m13272().getSupplementalVideoDuration() * 10))));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m13268() {
        m13269("onFailedToRecycleView");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m13271() {
        m13269("onViewRecycled");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final void m13267() {
        this.f12447 = System.currentTimeMillis();
        C0304 r10 = f12430;
        if (m13250().m2333() != null && m13250().m2331()) {
            C0304 r102 = f12430;
            m13250().m2345();
        } else if (m13250().m2329() || m13250().m2333() == null) {
            C0304 r103 = f12430;
            yR yRVar = this.f12439;
            if (yRVar == null) {
                C1457Fr.m5017("currPreviewItem");
            }
            String supplementalVideoId = yRVar.getSupplementalVideoId();
            if (supplementalVideoId != null) {
                m13250().b_();
                m13249().m13641();
                Disposable disposable = this.f12445;
                if (disposable != null) {
                    disposable.dispose();
                }
                Observable<IPlayer.aux> observeOn = this.f12444.delay(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
                C1457Fr.m5016((Object) observeOn, "retryOnPlaybackError\n   …dSchedulers.mainThread())");
                this.f12445 = SubscribersKt.subscribeBy$default(observeOn, PreviewsPlayerItemViewHolder$onViewFullyVisible$5.f3817, null, new PreviewsPlayerItemViewHolder$onViewFullyVisible$4(this), 2, null);
                NetflixVideoView r14 = m13250();
                oY oYVar = this.f12446;
                long parseLong = Long.parseLong(supplementalVideoId);
                yR yRVar2 = this.f12439;
                if (yRVar2 == null) {
                    C1457Fr.m5017("currPreviewItem");
                }
                VideoType type = yRVar2.getType();
                AbstractC2055pd r5 = f12430.m13277();
                yR yRVar3 = this.f12439;
                if (yRVar3 == null) {
                    C1457Fr.m5017("currPreviewItem");
                }
                m13269(r14.mo2340(oYVar, parseLong, type, r5, yRVar3.m13247(), 0, true) ? "video playback started" : "video playback failed to start");
                return;
            }
            C1276.m16820().mo5729("PreviewsPlayerItemViewHolder", new IllegalStateException("supplementalVideoId is null - cannot play trailer."));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13274() {
        C0304 r1 = f12430;
        m13269("setPlaybackTo from onScrollingStarted");
        m13276(false);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13276(boolean z) {
        C0304 r2 = f12430;
        m13269("" + this.f12442 + " (setting playback to - " + (z ? "play" : "pause") + ')');
        if (this.f12435) {
            if (C1457Fr.m5018(this.f12442, IPlayer.PlayerState.Idle) || C1457Fr.m5018(this.f12442, IPlayer.PlayerState.Prepared)) {
                this.f12443 = Boolean.valueOf(z);
            }
            if (z) {
                m13267();
            } else if (m13250().m2333() != null) {
                m13250().m2350();
            } else {
                m13269("ERR: unable to " + (z ? "play" : "pause"));
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m13269(String str) {
        C1457Fr.m5025(str, "msg");
        m13253().m16048(str);
    }
}
