package com.netflix.mediaclient.ui.feeds;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.common.ui.LifecycleController;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC0744;
import o.AbstractC1092;
import o.AbstractC1119;
import o.AbstractC1123;
import o.AbstractC1153;
import o.AbstractC1450Fk;
import o.C0656;
import o.C0716;
import o.C0754;
import o.C0795;
import o.C0965;
import o.C0972;
import o.C1033;
import o.C1197;
import o.C1283;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.EA;
import o.ED;
import o.FI;
import o.FQ;
import o.pF;
import o.rS;
import o.rW;
public final class PlayerControls extends LifecycleController<rW> {

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private static final boolean f3015 = false;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private static final long f3016 = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private static final int[] f3017 = ED.m4796(new Integer[]{Integer.valueOf((int) R.id.fullscreen), Integer.valueOf((int) R.id.scrubber), Integer.valueOf((int) R.id.time), Integer.valueOf((int) R.id.chrome_shader), Integer.valueOf((int) R.id.play_pause), Integer.valueOf((int) R.id.seek_backward), Integer.valueOf((int) R.id.seek_forward), Integer.valueOf((int) R.id.item_header_text), Integer.valueOf((int) R.id.remind_me), Integer.valueOf((int) R.id.tags)});

    /* renamed from: ˍ  reason: contains not printable characters */
    private static final int[] f3018 = ED.m4796(new Integer[]{Integer.valueOf((int) R.id.fullscreen), Integer.valueOf((int) R.id.scrubber), Integer.valueOf((int) R.id.time), Integer.valueOf((int) R.id.chrome_shader), Integer.valueOf((int) R.id.play_pause)});

    /* renamed from: ˏ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f3019 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "fullscreen", "getFullscreen()Lcom/netflix/mediaclient/android/widget/NetflixImageButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "playPause", "getPlayPause()Lcom/netflix/mediaclient/android/widget/NetflixImageButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "scrubber", "getScrubber()Landroid/widget/SeekBar;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "time", "getTime()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "seekForward", "getSeekForward()Lcom/netflix/mediaclient/android/widget/SeekButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "seekBackward", "getSeekBackward()Lcom/netflix/mediaclient/android/widget/SeekButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "loading", "getLoading()Landroid/widget/ProgressBar;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "audio", "getAudio()Lcom/netflix/mediaclient/android/widget/NetflixImageButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "manualPlay", "getManualPlay()Lcom/netflix/mediaclient/android/widget/NetflixTextButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlayerControls.class), "iconShader", "getIconShader()Landroid/view/View;"))};

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C0034 f3020 = new C0034(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final FI f3021 = C1197.m16474(this, R.id.seek_backward);

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f3022;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final FI f3023 = C1197.m16474(this, R.id.play_pause);

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final Cif f3024 = new Cif(this);

    /* renamed from: ʽ  reason: contains not printable characters */
    private final FI f3025 = C1197.m16474(this, R.id.time);

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final Map<Integer, View> f3026 = new LinkedHashMap();

    /* renamed from: ʾ  reason: contains not printable characters */
    private int f3027 = 8;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final C1292iF f3028 = new C1292iF();

    /* renamed from: ˈ  reason: contains not printable characters */
    private final PublishSubject<Long> f3029 = PublishSubject.create();

    /* renamed from: ˉ  reason: contains not printable characters */
    private final AbstractC1450Fk<Throwable, EA> f3030;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final View f3031;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final FI f3032 = C1197.m16474(this, R.id.audio);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final PublishSubject<EA> f3033 = PublishSubject.create();

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final TrailersFeedViewModel f3034;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final FI f3035 = C1197.m16474(this, R.id.manual_play);

    /* renamed from: ˎ  reason: contains not printable characters */
    private final FI f3036 = C1197.m16474(this, R.id.fullscreen);

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final Drawable f3037 = m1800().getBackground();

    /* renamed from: ͺ  reason: contains not printable characters */
    private final FI f3038 = C1197.m16474(this, R.id.icon_shader);

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final FI f3039 = C1197.m16474(this, R.id.loading);

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int[] f3040 = f3020.m1857();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private int f3041 = 8;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final FI f3042 = C1197.m16474(this, R.id.scrubber);

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final PublishSubject<Long> f3043 = PublishSubject.create();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final FI f3044 = C1197.m16474(this, R.id.seek_forward);

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final PublishSubject<Long> f3045 = PublishSubject.create();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final SeekBar m1785() {
        return (SeekBar) this.f3042.mo4986(this, f3019[2]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final C0716 m1787() {
        return (C0716) this.f3025.mo4986(this, f3019[3]);
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private final C0656 m1788() {
        return (C0656) this.f3023.mo4986(this, f3019[1]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʿ  reason: contains not printable characters */
    private final C0795 m1789() {
        return (C0795) this.f3044.mo4986(this, f3019[4]);
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private final C0656 m1790() {
        return (C0656) this.f3036.mo4986(this, f3019[0]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˉ  reason: contains not printable characters */
    private final C0656 m1791() {
        return (C0656) this.f3032.mo4986(this, f3019[7]);
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private final C0754 m1795() {
        return (C0754) this.f3035.mo4986(this, f3019[8]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final ProgressBar m1796() {
        return (ProgressBar) this.f3039.mo4986(this, f3019[6]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final C0795 m1798() {
        return (C0795) this.f3021.mo4986(this, f3019[5]);
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final View m1800() {
        return (View) this.f3038.mo4986(this, f3019[9]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: o.Fk<? super java.lang.Throwable, o.EA> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerControls(View view, TrailersFeedViewModel trailersFeedViewModel, AbstractC1450Fk<? super Throwable, EA> fk) {
        super(view);
        C1457Fr.m5025(view, "root");
        C1457Fr.m5025(trailersFeedViewModel, "trailersFeedViewModel");
        C1457Fr.m5025(fk, "onError");
        this.f3031 = view;
        this.f3034 = trailersFeedViewModel;
        this.f3030 = fk;
        SubscribersKt.subscribeBy$default(m456(), this.f3030, null, new AbstractC1450Fk<rW, EA>(this) { // from class: com.netflix.mediaclient.ui.feeds.PlayerControls.1

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ PlayerControls f3049;

            {
                this.f3049 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // o.AbstractC1450Fk
            public /* synthetic */ EA invoke(rW rWVar) {
                m1843(rWVar);
                return EA.f5503;
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m1843(rW rWVar) {
                C1457Fr.m5025(rWVar, "item");
                C1283.m16854("PlayerControls", "activates " + rWVar);
                pF r6 = rWVar.mo4192();
                if (r6 != null) {
                    Observable<Integer> observeOn = rWVar.m10225().takeUntil(this.f3049.m459()).debounce(100, TimeUnit.MILLISECONDS).filter(iF.f3050).observeOn(AndroidSchedulers.mainThread());
                    C1457Fr.m5016((Object) observeOn, "item.playProgress\n      …dSchedulers.mainThread())");
                    SubscribersKt.subscribeBy$default(observeOn, this.f3049.f3030, null, new PlayerControls$1$$special$$inlined$let$lambda$1(r6, this, rWVar), 2, null);
                    this.f3049.m1789().setOnSeekButtonListener(this.f3049.f3024);
                    this.f3049.m1798().setOnSeekButtonListener(this.f3049.f3024);
                }
                this.f3049.m1791().setClickable(false);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: com.netflix.mediaclient.ui.feeds.PlayerControls$1$iF */
            public static final class iF<T> implements Predicate<Integer> {

                /* renamed from: ॱ  reason: contains not printable characters */
                public static final iF f3050 = new iF();

                iF() {
                }

                /* renamed from: ˎ  reason: contains not printable characters */
                public final boolean test(Integer num) {
                    C1457Fr.m5025(num, "it");
                    return C1457Fr.m5021(num.intValue(), 0) >= 0;
                }
            }
        }, 2, null);
        SubscribersKt.subscribeBy$default(m459(), this.f3030, null, new AbstractC1450Fk<rW, EA>(this) { // from class: com.netflix.mediaclient.ui.feeds.PlayerControls.2

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ PlayerControls f3051;

            {
                this.f3051 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // o.AbstractC1450Fk
            public /* synthetic */ EA invoke(rW rWVar) {
                m1845(rWVar);
                return EA.f5503;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final void m1845(rW rWVar) {
                C1457Fr.m5025(rWVar, "item");
                C1283.m16854(this.f3051.m1803(), "deactivates " + rWVar);
                this.f3051.m1789().setOnSeekButtonListener(null);
                this.f3051.m1798().setOnSeekButtonListener(null);
            }
        }, 2, null);
        Observable<EA> observeOn = this.f3033.takeUntil(m460()).debounce(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        C1457Fr.m5016((Object) observeOn, "hideAfterDelay\n         …dSchedulers.mainThread())");
        SubscribersKt.subscribeBy$default(observeOn, this.f3030, null, new AbstractC1450Fk<EA, EA>(this) { // from class: com.netflix.mediaclient.ui.feeds.PlayerControls.3

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ PlayerControls f3052;

            {
                this.f3052 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // o.AbstractC1450Fk
            public /* synthetic */ EA invoke(EA ea) {
                m1846(ea);
                return EA.f5503;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final void m1846(EA ea) {
                this.f3052.m1836(8);
            }
        }, 2, null);
        AbstractC0744<AbstractC1119> r0 = C1033.m16037(m1785());
        C1457Fr.m5016((Object) r0, "RxSeekBar.changeEvents(this)");
        Observable<AbstractC1119> takeUntil = r0.takeUntil(m460());
        C1457Fr.m5016((Object) takeUntil, "scrubber\n               …    .takeUntil(destroy())");
        SubscribersKt.subscribeBy$default(takeUntil, this.f3030, null, new AbstractC1450Fk<AbstractC1119, EA>(this) { // from class: com.netflix.mediaclient.ui.feeds.PlayerControls.4

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ PlayerControls f3053;

            {
                this.f3053 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // o.AbstractC1450Fk
            public /* synthetic */ EA invoke(AbstractC1119 r2) {
                m1847(r2);
                return EA.f5503;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final void m1847(AbstractC1119 r5) {
                if (r5 instanceof AbstractC1092) {
                    this.f3053.f3045.onNext(Long.valueOf((long) this.f3053.m1785().getProgress()));
                } else if (r5 instanceof AbstractC1123) {
                    if (((AbstractC1123) r5).mo15944()) {
                        this.f3053.f3029.onNext(Long.valueOf((long) this.f3053.m1785().getProgress()));
                        this.f3053.f3033.onNext(EA.f5503);
                    }
                } else if (r5 instanceof AbstractC1153) {
                    this.f3053.f3043.onNext(Long.valueOf((long) this.f3053.m1785().getProgress()));
                }
                this.f3053.m1787().setText(rS.f9676.m10184().format(Integer.valueOf(this.f3053.m1785().getProgress())));
            }
        }, 2, null);
    }

    /* renamed from: com.netflix.mediaclient.ui.feeds.PlayerControls$ˊ  reason: contains not printable characters */
    public static final class C0034 {
        private C0034() {
        }

        public /* synthetic */ C0034(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final boolean m1859() {
            return PlayerControls.f3015;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˎ  reason: contains not printable characters */
        private final long m1856() {
            return PlayerControls.f3016;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final int[] m1857() {
            return PlayerControls.f3018;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final int[] m1854() {
            return PlayerControls.f3017;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1828(boolean z) {
        this.f3022 = z;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final boolean m1830() {
        return this.f3022;
    }

    /* renamed from: com.netflix.mediaclient.ui.feeds.PlayerControls$if  reason: invalid class name */
    public static final class Cif implements C0795.AbstractC2402If {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ PlayerControls f3059;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        Cif(PlayerControls playerControls) {
            this.f3059 = playerControls;
        }

        @Override // o.C0795.AbstractC2402If
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo1851(C0795 r2, int i, int i2) {
            C1457Fr.m5025(r2, "seekButton");
            this.f3059.m1838();
        }

        @Override // o.C0795.AbstractC2402If
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo1852(C0795 r8, int i, int i2) {
            C1457Fr.m5025(r8, "seekButton");
            this.f3059.f3043.onNext(Long.valueOf(((long) this.f3059.m1785().getProgress()) + (PlayerControls.f3020.m1856() * ((long) i) * ((long) i2))));
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final Observable<EA> m1826() {
        if (!this.f3034.m1954()) {
            Observable<R> map = C0965.m15783(m1791()).map(C0972.f14975);
            C1457Fr.m5016((Object) map, "RxView.clicks(this).map(VoidToUnit)");
            Observable<R> takeUntil = map.takeUntil(m460());
            C1457Fr.m5016((Object) takeUntil, "audio.clicks()\n         …    .takeUntil(destroy())");
            return takeUntil;
        }
        Observable<EA> empty = Observable.empty();
        C1457Fr.m5016((Object) empty, "Observable.empty()");
        return empty;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final Observable<EA> m1840() {
        Observable<R> map = C0965.m15783(m1790()).map(C0972.f14975);
        C1457Fr.m5016((Object) map, "RxView.clicks(this).map(VoidToUnit)");
        Observable<R> takeUntil = map.takeUntil(m460());
        C1457Fr.m5016((Object) takeUntil, "fullscreen.clicks()\n    …    .takeUntil(destroy())");
        return takeUntil;
    }

    static final class If<T> implements Consumer<EA> {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ PlayerControls f3054;

        If(PlayerControls playerControls) {
            this.f3054 = playerControls;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void accept(EA ea) {
            C1457Fr.m5025(ea, "it");
            this.f3054.m1838();
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final Observable<EA> m1825() {
        Observable<R> map = C0965.m15783(m1788()).map(C0972.f14975);
        C1457Fr.m5016((Object) map, "RxView.clicks(this).map(VoidToUnit)");
        Observable<R> takeUntil = map.doOnNext(new If(this)).takeUntil(m460());
        C1457Fr.m5016((Object) takeUntil, "playPause.clicks()\n     …    .takeUntil(destroy())");
        return takeUntil;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public final Observable<EA> m1827() {
        Observable<R> map = C0965.m15783(m1795()).map(C0972.f14975);
        C1457Fr.m5016((Object) map, "RxView.clicks(this).map(VoidToUnit)");
        Observable<R> takeUntil = map.takeUntil(m460());
        C1457Fr.m5016((Object) takeUntil, "manualPlay.clicks()\n    …    .takeUntil(destroy())");
        return takeUntil;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static /* synthetic */ void m1806(PlayerControls playerControls, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = R.string.coming_soon_preview_button;
        }
        if ((i3 & 2) != 0) {
            i2 = R.drawable.ic_coming_soon_manual_play;
        }
        playerControls.m1793(i, i2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m1793(int i, int i2) {
        m1795().setVisibility(0);
        m1795().setText(i);
        m1795().setCompoundDrawablesRelative(ContextCompat.getDrawable(m1795().getContext(), i2), null, null, null);
        this.f3041 = 0;
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private final void m1808() {
        m1795().setVisibility(8);
        this.f3041 = 8;
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private final void m1802() {
        m1796().setVisibility(0);
        m1813(this, null, 1, null);
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private final void m1801() {
        m1796().setVisibility(8);
        m1794(this, null, 1, null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static /* synthetic */ void m1794(PlayerControls playerControls, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        playerControls.m1807(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m1807(String str) {
        C1283.m16854(m1803(), "hideIconShader " + str);
        Drawable drawable = this.f3037;
        if (drawable != null) {
            drawable.setAlpha(0);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static /* bridge */ /* synthetic */ void m1813(PlayerControls playerControls, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        playerControls.m1814(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m1814(String str) {
        C1283.m16854(m1803(), "showIconShader " + str);
        Drawable drawable = this.f3037;
        if (drawable != null) {
            drawable.setAlpha(255);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m1833(boolean z, boolean z2) {
        int i = this.f3027;
        m1836(8);
        if (z) {
            this.f3040 = f3020.m1854();
            m1790().setImageResource(R.drawable.ic_coming_soon_fullscreen_off);
            int dimensionPixelSize = m1788().getResources().getDimensionPixelSize(R.dimen.coming_soon_fullscreen_play_button_padding);
            m1788().setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        } else {
            this.f3040 = f3020.m1857();
            m1790().setImageResource(R.drawable.ic_coming_soon_fullscreen_on);
            int dimensionPixelSize2 = m1788().getResources().getDimensionPixelSize(R.dimen.coming_soon_play_button_padding);
            m1788().setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
            View r0 = m1809(R.id.remind_me);
            if (r0 != null) {
                r0.setVisibility(0);
            }
            View r02 = m1809(R.id.item_header_text);
            if (r02 != null) {
                r02.setVisibility(0);
            }
        }
        m1836(i);
        if (this.f3027 == 0) {
            m1838();
        }
        if (z2) {
            m1808();
            m1801();
            return;
        }
        m1795().setVisibility(this.f3041);
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1805(int i, int i2) {
        if (m1787().getText() == null || m1785().getProgress() != i) {
            m1785().setProgress(i);
        }
        if (m1785().getMax() != i2) {
            m1785().setMax(i2);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m1836(int i) {
        this.f3027 = i;
        for (int i2 : this.f3040) {
            View r0 = m1809(i2);
            if (r0 != null) {
                r0.setVisibility(i);
            }
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final void m1841() {
        if (this.f3027 == 8) {
            m1836(0);
        } else {
            m1836(8);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public final void m1838() {
        this.f3033.onNext(EA.f5503);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public final Observable<Long> m1835() {
        PublishSubject<Long> publishSubject = this.f3045;
        C1457Fr.m5016((Object) publishSubject, "seekStarts");
        return publishSubject;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final Observable<Long> m1831() {
        PublishSubject<Long> publishSubject = this.f3043;
        C1457Fr.m5016((Object) publishSubject, "seekEnds");
        return publishSubject;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public final Observable<Long> m1834() {
        PublishSubject<Long> publishSubject = this.f3029;
        C1457Fr.m5016((Object) publishSubject, "seekings");
        return publishSubject;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final View m1809(int i) {
        View view = this.f3026.get(Integer.valueOf(i));
        if (view instanceof View) {
            return view;
        }
        View findViewById = this.f3031.findViewById(i);
        Map<Integer, View> map = this.f3026;
        Integer valueOf = Integer.valueOf(i);
        C1457Fr.m5016((Object) findViewById, "view");
        map.put(valueOf, findViewById);
        return findViewById;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m1837(boolean z, boolean z2) {
        C1283.m16854(m1803(), "setIdle " + z);
        this.f3028.m1850(this.f3028.m1849());
        if (!z) {
            m1808();
        } else if (z2) {
            m1793(R.string.coming_soon_replay_button, R.drawable.ic_coming_soon_replay);
        } else if (this.f3022) {
            m1808();
            this.f3028.m1850(ContextCompat.getDrawable(m1791().getContext(), R.drawable.ic_trailer_playable_hint));
        } else {
            m1806(this, 0, 0, 3, null);
        }
        m1801();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public final void m1832() {
        C1283.m16854(m1803(), "setLoading");
        this.f3028.m1850(this.f3028.m1849());
        m1802();
        m1808();
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public final void m1839() {
        C1283.m16854(m1803(), "setError");
        this.f3028.m1850(ContextCompat.getDrawable(m1791().getContext(), R.drawable.ic_coming_soon_playback_error));
        m1791().setClickable(true);
        m1801();
        m1808();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1829(boolean z, boolean z2) {
        C1283.m16854(m1803(), "setPlayback " + z + ' ' + z2);
        Drawable drawable = !this.f3034.m1954() ? ContextCompat.getDrawable(m1791().getContext(), R.drawable.ic_audio_off) : this.f3028.m1849();
        m1791().setClickable(z2);
        this.f3028.m1850(drawable);
        m1788().setImageResource(!z2 ? R.drawable.ic_player_play_ab8579 : R.drawable.ic_player_pause_ab8579);
        m1801();
        m1808();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˍ  reason: contains not printable characters */
    private final String m1803() {
        return "PlayerControls";
    }

    /* renamed from: com.netflix.mediaclient.ui.feeds.PlayerControls$iF  reason: case insensitive filesystem */
    public final class C1292iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final ValueAnimator f3055 = new ValueAnimator();

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Drawable f3057;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C1292iF() {
            this.f3055.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.netflix.mediaclient.ui.feeds.PlayerControls.iF.3

                /* renamed from: ॱ  reason: contains not printable characters */
                final /* synthetic */ C1292iF f3058;

                {
                    this.f3058 = r1;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C1457Fr.m5016((Object) valueAnimator, "animation");
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
                    }
                    float floatValue = ((Float) animatedValue).floatValue();
                    int i = (int) (255.0f * floatValue);
                    if (PlayerControls.f3020.m1859() && (i < 10 || i > 250)) {
                        C1283.m16854(PlayerControls.this.m1803(), "anim: " + floatValue + " alphaAsInt is " + i);
                    }
                    Drawable drawable = PlayerControls.this.m1791().getDrawable();
                    if (drawable != null) {
                        drawable.setAlpha(i);
                    }
                    if (!C1457Fr.m5018(PlayerControls.this.m1791().getDrawable(), this.f3058.m1849()) || PlayerControls.this.m1796().getVisibility() != 8) {
                        PlayerControls.this.m1814("animation " + i + ' ' + (PlayerControls.this.m1796().getVisibility() != 0));
                    } else {
                        PlayerControls.this.m1807("animation " + i + ' ' + (PlayerControls.this.m1796().getVisibility() != 0));
                    }
                }
            });
            this.f3055.setDuration(320L);
            this.f3055.setRepeatMode(2);
            this.f3055.setRepeatCount(-1);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final Drawable m1849() {
            return this.f3057;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m1850(Drawable drawable) {
            C1283.m16854(PlayerControls.this.m1803(), "switchTo: " + drawable);
            if (this.f3055.isStarted() || this.f3055.isRunning()) {
                this.f3055.cancel();
            }
            PlayerControls.this.m1791().setImageDrawable(drawable);
            this.f3055.setFloatValues(0.25f, 1.0f);
            this.f3055.setCurrentPlayTime(PlayerControls.f3016);
            this.f3055.setRepeatCount(0);
            this.f3055.start();
        }
    }
}
