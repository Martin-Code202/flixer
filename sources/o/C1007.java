package o;

import android.widget.CompoundButton;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
/* access modifiers changed from: package-private */
/* renamed from: o.ᵊ  reason: contains not printable characters */
public final class C1007 extends AbstractC0744<Boolean> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final CompoundButton f15091;

    C1007(CompoundButton compoundButton) {
        this.f15091 = compoundButton;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0744
    /* renamed from: ॱ */
    public void mo15158(Observer<? super Boolean> observer) {
        if (C0820.m15429(observer)) {
            C1008 r1 = new C1008(this.f15091, observer);
            observer.onSubscribe(r1);
            this.f15091.setOnCheckedChangeListener(r1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Boolean mo15157() {
        return Boolean.valueOf(this.f15091.isChecked());
    }

    /* renamed from: o.ᵊ$ˋ  reason: contains not printable characters */
    static final class C1008 extends MainThreadDisposable implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final CompoundButton f15092;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final Observer<? super Boolean> f15093;

        C1008(CompoundButton compoundButton, Observer<? super Boolean> observer) {
            this.f15092 = compoundButton;
            this.f15093 = observer;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!isDisposed()) {
                this.f15093.onNext(Boolean.valueOf(z));
            }
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.f15092.setOnCheckedChangeListener(null);
        }
    }
}
