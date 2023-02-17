package o;

import android.arch.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
/* renamed from: o.ʎ  reason: contains not printable characters */
public class C0396<T> extends MutableLiveData<T> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final BehaviorSubject<T> f13345;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Disposable f13346;

    public C0396(T t) {
        BehaviorSubject<T> createDefault = BehaviorSubject.createDefault(t);
        C1457Fr.m5016((Object) createDefault, "BehaviorSubject.createDefault(defaultValue)");
        this.f13345 = createDefault;
    }

    /* renamed from: o.ʎ$ˊ  reason: contains not printable characters */
    static final class C0397<T> implements Consumer<T> {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C0396 f13347;

        C0397(C0396 r1) {
            this.f13347 = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) {
            C0396.super.setValue(t);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.LiveData
    public void onActive() {
        Disposable subscribe = m14181(this.f13345).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0397(this));
        C1457Fr.m5016((Object) subscribe, "observable(behaviorSubje…(value)\n                }");
        this.f13346 = subscribe;
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.LiveData
    public void onInactive() {
        Disposable disposable = this.f13346;
        if (disposable == null) {
            C1457Fr.m5017("disposable");
        }
        disposable.dispose();
    }

    @Override // android.arch.lifecycle.MutableLiveData, android.arch.lifecycle.LiveData
    public final void setValue(T t) {
        this.f13345.onNext(t);
    }

    @Override // android.arch.lifecycle.LiveData
    public final T getValue() {
        return this.f13345.getValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Observable<T> m14181(Observable<T> observable) {
        C1457Fr.m5025(observable, "observable");
        return observable;
    }
}
