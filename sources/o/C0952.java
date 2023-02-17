package o;

import android.view.View;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
/* access modifiers changed from: package-private */
/* renamed from: o.ᴖ  reason: contains not printable characters */
public final class C0952 extends AbstractC0744<Boolean> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f14858;

    C0952(View view) {
        this.f14858 = view;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0744
    /* renamed from: ॱ */
    public void mo15158(Observer<? super Boolean> observer) {
        View$OnFocusChangeListenerC0953 r1 = new View$OnFocusChangeListenerC0953(this.f14858, observer);
        observer.onSubscribe(r1);
        this.f14858.setOnFocusChangeListener(r1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public Boolean mo15157() {
        return Boolean.valueOf(this.f14858.hasFocus());
    }

    /* renamed from: o.ᴖ$ˊ  reason: contains not printable characters */
    static final class View$OnFocusChangeListenerC0953 extends MainThreadDisposable implements View.OnFocusChangeListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Observer<? super Boolean> f14859;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final View f14860;

        View$OnFocusChangeListenerC0953(View view, Observer<? super Boolean> observer) {
            this.f14860 = view;
            this.f14859 = observer;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!isDisposed()) {
                this.f14859.onNext(Boolean.valueOf(z));
            }
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.f14860.setOnFocusChangeListener(null);
        }
    }
}
