package o;

import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
/* renamed from: o.ur  reason: case insensitive filesystem */
public abstract class AbstractC2218ur {

    /* renamed from: ˊ  reason: contains not printable characters */
    private PublishSubject<GenreList> f11022 = PublishSubject.create();

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f11023 = -1;

    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract List<GenreList> mo11734();

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract int mo11735();

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract GenreList mo11736(int i);

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract Observable<List<GenreList>> mo11737(boolean z);

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m11738(int i) {
        this.f11023 = i;
        this.f11022.onNext(mo11736(i));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final Observable<GenreList> m11733() {
        PublishSubject<GenreList> publishSubject = this.f11022;
        C1457Fr.m5016((Object) publishSubject, "selectionChangedObs");
        return publishSubject;
    }
}
