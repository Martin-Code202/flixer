package o;

import android.widget.SearchView;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
/* access modifiers changed from: package-private */
/* renamed from: o.ゝ  reason: contains not printable characters */
public final class C1077 extends AbstractC0744<AbstractC1115> {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final SearchView f15237;

    C1077(SearchView searchView) {
        this.f15237 = searchView;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0744
    /* renamed from: ॱ */
    public void mo15158(Observer<? super AbstractC1115> observer) {
        if (C0820.m15429(observer)) {
            C1078 r1 = new C1078(this.f15237, observer);
            this.f15237.setOnQueryTextListener(r1);
            observer.onSubscribe(r1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC1115 mo15157() {
        return AbstractC1115.m16246(this.f15237, this.f15237.getQuery(), false);
    }

    /* renamed from: o.ゝ$ˊ  reason: contains not printable characters */
    static final class C1078 extends MainThreadDisposable implements SearchView.OnQueryTextListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Observer<? super AbstractC1115> f15238;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final SearchView f15239;

        C1078(SearchView searchView, Observer<? super AbstractC1115> observer) {
            this.f15239 = searchView;
            this.f15238 = observer;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (isDisposed()) {
                return false;
            }
            this.f15238.onNext(AbstractC1115.m16246(this.f15239, str, false));
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            if (isDisposed()) {
                return false;
            }
            this.f15238.onNext(AbstractC1115.m16246(this.f15239, str, true));
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.f15239.setOnQueryTextListener(null);
        }
    }
}
