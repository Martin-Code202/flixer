package o;

import io.reactivex.Observable;
import io.reactivex.Observer;
/* renamed from: o.ᐦ  reason: contains not printable characters */
public abstract class AbstractC0744<T> extends Observable<T> {
    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract T mo15157();

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract void mo15158(Observer<? super T> observer);

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        mo15158(observer);
        observer.onNext(mo15157());
    }
}
