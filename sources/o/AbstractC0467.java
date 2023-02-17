package o;

import android.view.View;
import io.reactivex.subjects.PublishSubject;
/* renamed from: o.ϒ  reason: contains not printable characters */
public abstract class AbstractC0467 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final View f13518;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final PublishSubject<C0461> f13519;

    public AbstractC0467(View view) {
        C1457Fr.m5025(view, "rootView");
        this.f13518 = view;
        PublishSubject<C0461> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<UIEvent>()");
        this.f13519 = create;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final View m14352() {
        return this.f13518;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final PublishSubject<C0461> m14353() {
        return this.f13519;
    }

    /* renamed from: ॱ */
    public void mo13628() {
    }

    /* renamed from: ˊ */
    public void mo13625(C0361 r2) {
        C1457Fr.m5025(r2, "command");
    }

    /* renamed from: ॱ */
    public void mo11047(AbstractC0508 r2) {
        C1457Fr.m5025(r2, "uiModel");
    }
}
