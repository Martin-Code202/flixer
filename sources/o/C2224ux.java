package o;

import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import io.reactivex.Observable;
import java.util.List;
/* renamed from: o.ux  reason: case insensitive filesystem */
public final class C2224ux extends AbstractC2218ur {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f11045;

    /* renamed from: ˋ  reason: contains not printable characters */
    private List<? extends GenreList> f11046 = EI.m4806(C2222uv.f11041.m11774());

    public C2224ux() {
        m11738(0);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.netflix.mediaclient.servicemgr.interface_.genre.GenreList>, java.util.List<com.netflix.mediaclient.servicemgr.interface_.genre.GenreList> */
    @Override // o.AbstractC2218ur
    /* renamed from: ˋ */
    public List<GenreList> mo11734() {
        return this.f11046;
    }

    @Override // o.AbstractC2218ur
    /* renamed from: ˎ */
    public int mo11735() {
        return this.f11046.size();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2218ur
    /* renamed from: ˎ */
    public GenreList mo11736(int i) {
        return (GenreList) this.f11046.get(i);
    }

    @Override // o.AbstractC2218ur
    /* renamed from: ˎ */
    public Observable<List<GenreList>> mo11737(boolean z) {
        if (!this.f11045) {
            this.f11045 = true;
            this.f11046 = EI.m4804(C2222uv.f11041.m11779("lolomo"), C2222uv.f11041.m11779(C2222uv.f11041.m11776()), C2222uv.f11041.m11779(C2222uv.f11041.m11778()), C2222uv.f11041.m11779("839338"));
        }
        Observable<List<GenreList>> just = Observable.just(this.f11046);
        C1457Fr.m5016((Object) just, "Observable.just(filterSelections)");
        return just;
    }
}
