package o;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
/* access modifiers changed from: package-private */
/* renamed from: o.ﯧ  reason: contains not printable characters */
public final class C1149 extends AbstractC0744<CharSequence> {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final TextView f15399;

    C1149(TextView textView) {
        this.f15399 = textView;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0744
    /* renamed from: ॱ */
    public void mo15158(Observer<? super CharSequence> observer) {
        iF iFVar = new iF(this.f15399, observer);
        observer.onSubscribe(iFVar);
        this.f15399.addTextChangedListener(iFVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public CharSequence mo15157() {
        return this.f15399.getText();
    }

    /* renamed from: o.ﯧ$iF */
    static final class iF extends MainThreadDisposable implements TextWatcher {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final Observer<? super CharSequence> f15400;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final TextView f15401;

        iF(TextView textView, Observer<? super CharSequence> observer) {
            this.f15401 = textView;
            this.f15400 = observer;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!isDisposed()) {
                this.f15400.onNext(charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.f15401.removeTextChangedListener(this);
        }
    }
}
