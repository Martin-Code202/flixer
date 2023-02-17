package o;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
/* access modifiers changed from: package-private */
/* renamed from: o.ᴲ  reason: contains not printable characters */
public final class C0973 extends Observable<Object> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean f14976;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final View f14977;

    C0973(View view, boolean z) {
        this.f14977 = view;
        this.f14976 = z;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Object> observer) {
        if (C0820.m15429(observer)) {
            If r2 = new If(this.f14977, this.f14976, observer);
            observer.onSubscribe(r2);
            this.f14977.addOnAttachStateChangeListener(r2);
        }
    }

    /* renamed from: o.ᴲ$If */
    static final class If extends MainThreadDisposable implements View.OnAttachStateChangeListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final View f14978;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Observer<? super Object> f14979;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final boolean f14980;

        If(View view, boolean z, Observer<? super Object> observer) {
            this.f14978 = view;
            this.f14980 = z;
            this.f14979 = observer;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (this.f14980 && !isDisposed()) {
                this.f14979.onNext(Notification.INSTANCE);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (!this.f14980 && !isDisposed()) {
                this.f14979.onNext(Notification.INSTANCE);
            }
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.f14978.removeOnAttachStateChangeListener(this);
        }
    }
}
