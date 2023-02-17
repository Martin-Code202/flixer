package com.netflix.mediaclient.common.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.view.View;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import o.AbstractC1449Fj;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1456Fq;
import o.C1457Fr;
import o.EA;
public abstract class LifecycleController<T> implements LifecycleObserver {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final If f978 = new If(null);

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f979;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final View f980;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ReplaySubject<EA> f981 = ReplaySubject.create();

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f982;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final PublishSubject<T> f983 = PublishSubject.create();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final PublishSubject<T> f984 = PublishSubject.create();

    public LifecycleController(View view) {
        C1457Fr.m5025(view, "controllerView");
        this.f980 = view;
        ReplaySubject<EA> replaySubject = this.f981;
        C1457Fr.m5016((Object) replaySubject, "destroy");
        SubscribersKt.subscribeBy$default(replaySubject, new AbstractC1450Fk<Throwable, EA>(this) { // from class: com.netflix.mediaclient.common.ui.LifecycleController.2

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ LifecycleController f986;

            {
                this.f986 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // o.AbstractC1450Fk
            public /* synthetic */ EA invoke(Throwable th) {
                m462(th);
                return EA.f5503;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final void m462(Throwable th) {
                C1457Fr.m5025(th, "it");
                this.f986.f984.onComplete();
                this.f986.f983.onComplete();
            }
        }, new AbstractC1449Fj<EA>(this) { // from class: com.netflix.mediaclient.common.ui.LifecycleController.1

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ LifecycleController f985;

            {
                this.f985 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // o.AbstractC1449Fj
            public /* synthetic */ EA invoke() {
                m461();
                return EA.f5503;
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m461() {
                this.f985.f984.onComplete();
                this.f985.f983.onComplete();
            }
        }, null, 4, null);
        C1283.m16854("LifecycleController", "onCreate " + getClass().getSimpleName());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final View m457() {
        return this.f980;
    }

    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m458(T t) {
        if (this.f982) {
            throw new IllegalStateException("controller already active");
        }
        C1283.m16854("LifecycleController", "onActivated " + ((Object) t));
        this.f982 = true;
        this.f984.onNext(t);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m455(T t) {
        if (!this.f982) {
            throw new IllegalStateException("controller already inactive");
        }
        C1283.m16854("LifecycleController", "onDeactivated " + ((Object) t));
        this.f982 = false;
        this.f983.onNext(t);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (this.f979) {
            throw new IllegalStateException("controller already destroyed");
        }
        C1283.m16854("LifecycleController", "onDestroy " + getClass().getSimpleName());
        this.f979 = true;
        this.f981.onNext(EA.f5503);
        this.f981.onComplete();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public final Observable<T> m456() {
        PublishSubject<T> publishSubject = this.f984;
        C1457Fr.m5016((Object) publishSubject, "activates");
        return publishSubject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final Observable<T> m459() {
        PublishSubject<T> publishSubject = this.f983;
        C1457Fr.m5016((Object) publishSubject, "deactivates");
        return publishSubject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final Observable<EA> m460() {
        ReplaySubject<EA> replaySubject = this.f981;
        C1457Fr.m5016((Object) replaySubject, "destroy");
        return replaySubject;
    }
}
