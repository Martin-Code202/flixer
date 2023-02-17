package o;

import android.content.Context;
import android.view.OrientationEventListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
/* renamed from: o.ɢ  reason: contains not printable characters */
public final class C0371 extends OrientationEventListener {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0372 f13284 = new C0372(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Observable<Integer> f13285;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final PublishSubject<Integer> f13286;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0371(Context context) {
        super(context);
        C1457Fr.m5025(context, "context");
        PublishSubject<Integer> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create()");
        this.f13286 = create;
        Observable<Integer> observeOn = this.f13286.distinctUntilChanged().debounce(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        C1457Fr.m5016((Object) observeOn, "orientations\n           …dSchedulers.mainThread())");
        this.f13285 = observeOn;
    }

    /* renamed from: o.ɢ$ˊ  reason: contains not printable characters */
    public static final class C0372 {
        private C0372() {
        }

        public /* synthetic */ C0372(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final Observable<Integer> m14098() {
        return this.f13285;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int i2;
        if (i != -1) {
            if ((i >= 320 && i < 360) || (i >= 0 && i <= 40)) {
                i2 = 1;
            } else if (i >= 230 && i <= 310) {
                i2 = 2;
            } else if (i < 140 || i > 220) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            this.f13286.onNext(Integer.valueOf(i2));
        }
    }
}
