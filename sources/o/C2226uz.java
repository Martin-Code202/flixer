package o;

import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: o.uz  reason: case insensitive filesystem */
public final class C2226uz extends AbstractC2218ur {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final String f11053 = f11053;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final If f11054 = new If(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private C2059ph f11055;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<NetflixActivity.If> f11056 = new ArrayList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f11057 = "lolomo";

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<GenreList> f11058 = EI.m4802(C2222uv.f11041.m11780());

    /* renamed from: o.uz$If */
    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final String m11798() {
            return C2226uz.f11053;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final List<GenreList> m11797() {
        return this.f11058;
    }

    @Override // o.AbstractC2218ur
    /* renamed from: ˋ */
    public List<GenreList> mo11734() {
        return this.f11058;
    }

    @Override // o.AbstractC2218ur
    /* renamed from: ˎ */
    public int mo11735() {
        return this.f11058.size();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2218ur
    /* renamed from: ˎ */
    public GenreList mo11736(int i) {
        GenreList genreList = this.f11058.get(i);
        String str = this.f11057;
        if (C1457Fr.m5018(genreList, C2222uv.f11041.m11775(str))) {
            return C2222uv.f11041.m11779(str);
        }
        return genreList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final synchronized void m11796(C2059ph phVar) {
        C1457Fr.m5025(phVar, "newServiceManager");
        this.f11055 = phVar;
        if (phVar.mo9519()) {
            Iterator<T> it = this.f11056.iterator();
            while (it.hasNext()) {
                it.next().run(phVar);
            }
        }
        this.f11056.clear();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m11795(String str) {
        C1457Fr.m5025(str, "newPrimaryGenreId");
        this.f11057 = str;
    }

    @Override // o.AbstractC2218ur
    /* renamed from: ˎ */
    public synchronized Observable<List<GenreList>> mo11737(boolean z) {
        PublishSubject create;
        create = PublishSubject.create();
        CmpTaskMode cmpTaskMode = z ? CmpTaskMode.FROM_NETWORK : CmpTaskMode.FROM_CACHE_OR_NETWORK;
        C2059ph phVar = this.f11055;
        if (phVar == null || !phVar.mo9519()) {
            this.f11056.add(new C2227iF(this, this.f11057, cmpTaskMode, create));
        } else {
            oF r0 = phVar.m9764();
            if (r0 != null) {
                String str = this.f11057;
                C1457Fr.m5016((Object) create, "falkorRequestSubject");
                r0.mo9501(str, cmpTaskMode, new Cif(this, create));
            }
        }
        C1457Fr.m5016((Object) create, "falkorRequestSubject");
        return create;
    }

    /* renamed from: o.uz$iF  reason: case insensitive filesystem */
    public static final class C2227iF extends NetflixActivity.If {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ PublishSubject f11059;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2226uz f11060;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ String f11061;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ CmpTaskMode f11062;

        C2227iF(C2226uz uzVar, String str, CmpTaskMode cmpTaskMode, PublishSubject publishSubject) {
            this.f11060 = uzVar;
            this.f11061 = str;
            this.f11062 = cmpTaskMode;
            this.f11059 = publishSubject;
        }

        @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
        public void run(C2059ph phVar) {
            C1457Fr.m5025(phVar, "manager");
            oF r0 = phVar.m9764();
            if (r0 != null) {
                String str = this.f11061;
                CmpTaskMode cmpTaskMode = this.f11062;
                C2226uz uzVar = this.f11060;
                PublishSubject publishSubject = this.f11059;
                C1457Fr.m5016((Object) publishSubject, "falkorRequestSubject");
                r0.mo9501(str, cmpTaskMode, new Cif(uzVar, publishSubject));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uz$if  reason: invalid class name */
    public final class Cif extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private PublishSubject<List<GenreList>> f11063;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C2226uz f11064;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(C2226uz uzVar, PublishSubject<List<GenreList>> publishSubject) {
            super(C2226uz.f11054.m11798());
            C1457Fr.m5025(publishSubject, "observable");
            this.f11064 = uzVar;
            this.f11063 = publishSubject;
        }

        @Override // o.oP, o.oU
        public void onGenreListsFetched(List<? extends GenreList> list, Status status) {
            C1457Fr.m5025(status, "res");
            super.onGenreListsFetched(list, status);
            if (status.mo301()) {
                C1283.m16865(C2226uz.f11054.m11798(), "Invalid status code for genres fetch");
                this.f11063.onError(new Throwable("status error " + status.toString()));
                return;
            }
            if (list == null || list.isEmpty()) {
                C1283.m16846(C2226uz.f11054.m11798(), "No genres in response");
                this.f11063.onNext(new ArrayList());
            } else {
                this.f11064.m11797().clear();
                this.f11064.m11797().add(C2222uv.f11041.m11775(this.f11064.f11057));
                this.f11064.m11797().addAll(list);
                this.f11063.onNext(this.f11064.m11797());
            }
            this.f11063.onComplete();
        }
    }
}
