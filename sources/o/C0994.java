package o;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
/* access modifiers changed from: package-private */
/* renamed from: o.ᴾ  reason: contains not printable characters */
public final class C0994 extends Observable<Object> {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final View f15054;

    C0994(View view) {
        this.f15054 = view;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Object> observer) {
        if (C0820.m15429(observer)) {
            If r1 = new If(this.f15054, observer);
            observer.onSubscribe(r1);
            this.f15054.setOnClickListener(r1);
        }
    }

    /* renamed from: o.ᴾ$If */
    static final class If extends MainThreadDisposable implements View.OnClickListener {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final View f15055;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Observer<? super Object> f15056;

        If(View view, Observer<? super Object> observer) {
            this.f15055 = view;
            this.f15056 = observer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!isDisposed()) {
                this.f15056.onNext(Notification.INSTANCE);
            }
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.f15055.setOnClickListener(null);
        }
    }
}
