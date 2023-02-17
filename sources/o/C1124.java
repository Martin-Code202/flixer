package o;

import android.widget.SeekBar;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
/* access modifiers changed from: package-private */
/* renamed from: o.ﭤ  reason: contains not printable characters */
public final class C1124 extends AbstractC0744<AbstractC1119> {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final SeekBar f15357;

    C1124(SeekBar seekBar) {
        this.f15357 = seekBar;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0744
    /* renamed from: ॱ */
    public void mo15158(Observer<? super AbstractC1119> observer) {
        if (C0820.m15429(observer)) {
            C1125 r1 = new C1125(this.f15357, observer);
            this.f15357.setOnSeekBarChangeListener(r1);
            observer.onSubscribe(r1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC1119 mo15157() {
        return AbstractC1123.m16278(this.f15357, this.f15357.getProgress(), false);
    }

    /* renamed from: o.ﭤ$ˊ  reason: contains not printable characters */
    static final class C1125 extends MainThreadDisposable implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Observer<? super AbstractC1119> f15358;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final SeekBar f15359;

        C1125(SeekBar seekBar, Observer<? super AbstractC1119> observer) {
            this.f15359 = seekBar;
            this.f15358 = observer;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (!isDisposed()) {
                this.f15358.onNext(AbstractC1123.m16278(seekBar, i, z));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (!isDisposed()) {
                this.f15358.onNext(AbstractC1092.m16184(seekBar));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!isDisposed()) {
                this.f15358.onNext(AbstractC1153.m16343(seekBar));
            }
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.f15359.setOnSeekBarChangeListener(null);
        }
    }
}
