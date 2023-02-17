package o;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$onCreate$1;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$1;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$2;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$3;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$4;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$5;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$6;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupPrimaryGenresModel$1;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupPrimaryGenresModel$2;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupSubGenresModel$1;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$setupSubGenresModel$2;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$showGenreSelectorsInActionBar$$inlined$let$lambda$1;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$showGenreSelectorsInActionBar$$inlined$let$lambda$2;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$update$2;
import com.netflix.mediaclient.ui.lolomo.ab9031.GenresActionBarPresenter$update$3;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.List;
import o.C0975;
import org.json.JSONObject;
/* renamed from: o.uu  reason: case insensitive filesystem */
public final class C2221uu {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C0236 f11025 = new C0236(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private View f11026;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Disposable f11027;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C2226uz f11028 = new C2226uz();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final ActivityC2153sl f11029;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f11030 = "";

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f11031 = "lolomo";

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C2224ux f11032 = new C2224ux();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final Drawable f11033 = f11025.m11772(this.f11029);

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f11034 = "lolomo";

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final NetflixActionBar f11035;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final CompositeDisposable f11036 = new CompositeDisposable();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0975 f11037;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final void m11747(NetflixActionBar netflixActionBar, RecyclerView recyclerView, boolean z) {
        f11025.m11771(netflixActionBar, recyclerView, z);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final Drawable m11755(Activity activity) {
        return f11025.m11772(activity);
    }

    public C2221uu(NetflixActionBar netflixActionBar, ActivityC2153sl slVar) {
        C1457Fr.m5025(netflixActionBar, "netflixActionBar");
        C1457Fr.m5025(slVar, "activity");
        this.f11035 = netflixActionBar;
        this.f11029 = slVar;
        m11751();
    }

    /* renamed from: o.uu$ˋ  reason: contains not printable characters */
    public static final class C0236 {
        private C0236() {
        }

        public /* synthetic */ C0236(C1456Fq fq) {
            this();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m11771(NetflixActionBar netflixActionBar, RecyclerView recyclerView, boolean z) {
            int i;
            C1457Fr.m5025(netflixActionBar, "netflixActionBar");
            C1457Fr.m5025(recyclerView, "recyclerView");
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int r3 = netflixActionBar.m363() * 4;
            if (!z || computeVerticalScrollOffset > r3) {
                i = 255;
            } else {
                i = (computeVerticalScrollOffset * 255) / r3;
            }
            netflixActionBar.m364(i);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final Drawable m11772(Activity activity) {
            C1457Fr.m5025(activity, "activity");
            Drawable mutate = activity.getDrawable(BrowseExperience.m1774(activity, R.attr.toolbarBackground)).mutate();
            C1457Fr.m5016((Object) mutate, "activity.getDrawable(Bro…lbarBackground)).mutate()");
            return mutate;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final C2224ux m11769() {
        return this.f11032;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final C2226uz m11770() {
        return this.f11028;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m11768(C2059ph phVar) {
        C1457Fr.m5025(phVar, "serviceManager");
        m11746();
        m11758(phVar);
        C0975 r0 = this.f11037;
        if (r0 != null) {
            r0.m15900(true);
        }
        C0975 r02 = this.f11037;
        if (r02 != null) {
            r02.setLogoClickListener(new GenresActionBarPresenter$onCreate$1(this));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m11767(String str, String str2) {
        C1457Fr.m5025(str, "newPrimaryGenreId");
        C1457Fr.m5025(str2, "newSubGenreId");
        if (!C1317As.m3750(this.f11029)) {
            m11741();
            if (!m11754(str)) {
                this.f11034 = str;
                this.f11031 = str2;
                m11743();
                if (C0727.m15064()) {
                    Disposable disposable = this.f11027;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f11028.m11795(str);
                    Observable<List<GenreList>> take = this.f11028.mo11737(false).take(1);
                    C1457Fr.m5016((Object) take, "subGenresModel.fetchGenr…                 .take(1)");
                    this.f11027 = SubscribersKt.subscribeBy$default(take, GenresActionBarPresenter$update$3.f3245, null, new GenresActionBarPresenter$update$2(this), 2, null);
                }
            } else if ((!C1457Fr.m5018((Object) str, (Object) this.f11034)) || (!C1457Fr.m5018((Object) str2, (Object) this.f11031))) {
                this.f11034 = str;
                this.f11031 = str2;
                C0975 r6 = this.f11037;
                if (r6 == null) {
                    return;
                }
                if (C0727.m15064()) {
                    r6.m15901();
                } else {
                    r6.setSelectedPrimaryGenre(str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public final boolean m11759() {
        return C0727.m15064() && (C1457Fr.m5018(this.f11034, C2222uv.f11041.m11776()) || C1457Fr.m5018(this.f11034, C2222uv.f11041.m11778()));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean m11754(String str) {
        return C1457Fr.m5018(str, "lolomo") || !C0727.m15064();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m11746() {
        this.f11032.mo11737(false).take(1).subscribe();
        this.f11036.add(SubscribersKt.subscribeBy$default(this.f11032.m11733(), GenresActionBarPresenter$setupPrimaryGenresModel$2.f3241, null, new GenresActionBarPresenter$setupPrimaryGenresModel$1(this), 2, null));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m11758(C2059ph phVar) {
        if (C0727.m15064()) {
            this.f11028.m11796(phVar);
            this.f11036.add(SubscribersKt.subscribeBy$default(this.f11028.m11733(), GenresActionBarPresenter$setupSubGenresModel$2.f3243, null, new GenresActionBarPresenter$setupSubGenresModel$1(this), 2, null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m11766(View view) {
        C0975 r3;
        if (view != null && !C1317As.m3750(this.f11029) && (r3 = this.f11037) != null) {
            if (m11754(this.f11034)) {
                C0975.Cif r5 = C0975.f14981.m15911(view);
                if (r5 != null) {
                    GenreList r6 = C2222uv.f11041.m11779(r5.m15906());
                    if (!C1457Fr.m5018(r6, C2222uv.f11041.m11774())) {
                        C1300Ac.m3531(new C1080(AppView.browseTab, m11761(r5.m15906())), new C0344(), true);
                        this.f11029.m10798(r6, r5.m15906());
                        r3.setSelectedPrimaryGenre(r5.m15906());
                    }
                }
            } else if (view.getId() == R.id.sub_category) {
                C1300Ac.m3531(new C1080(AppView.browseTab, m11761(m11744(this.f11031))), new C0344(), true);
                m11748(this.f11028);
            } else {
                C1300Ac.m3531(new C1080(AppView.browseTab, m11761(this.f11034)), new C0344(), true);
                m11748(this.f11032);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m11751() {
        if (this.f11026 == null) {
            this.f11026 = LayoutInflater.from(this.f11029).inflate(R.layout.action_bar_primary_genres_ab9031, (ViewGroup) null);
        }
        View view = this.f11026;
        this.f11037 = view != null ? (C0975) view.findViewById(R.id.ribbon) : null;
        C0975 r6 = this.f11037;
        if (r6 != null) {
            int i = 0;
            if (C0727.m15068()) {
                r6.setLogo(R.drawable.ab_logo);
            }
            if (C0727.m15064()) {
                r6.m15902(3);
            } else {
                r6.setSimpleMode(BrowseExperience.m1767(this.f11029, 16842806), BrowseExperience.m1767(this.f11029, 16842808));
                GenreList r9 = C2222uv.f11041.m11779("lolomo");
                i = 0 + 1;
                String title = r9.getTitle();
                C1457Fr.m5016((Object) title, "primaryGenre.title");
                String id = r9.getId();
                C1457Fr.m5016((Object) id, "primaryGenre.id");
                r6.setupHolder(0, title, id, true, new GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$1(this));
            }
            GenreList r92 = C2222uv.f11041.m11779(C2222uv.f11041.m11776());
            int i2 = i + 1;
            String title2 = r92.getTitle();
            C1457Fr.m5016((Object) title2, "primaryGenre.title");
            String id2 = r92.getId();
            C1457Fr.m5016((Object) id2, "primaryGenre.id");
            r6.setupHolder(i, title2, id2, true, new GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$2(this));
            GenreList r93 = C2222uv.f11041.m11779(C2222uv.f11041.m11778());
            int i3 = i2 + 1;
            String title3 = r93.getTitle();
            C1457Fr.m5016((Object) title3, "primaryGenre.title");
            String id3 = r93.getId();
            C1457Fr.m5016((Object) id3, "primaryGenre.id");
            r6.setupHolder(i2, title3, id3, true, new GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$3(this));
            if (C0727.m15065()) {
                r6.m15902(i3);
            } else {
                GenreList r94 = C2222uv.f11041.m11779("839338");
                String title4 = r94.getTitle();
                C1457Fr.m5016((Object) title4, "primaryGenre.title");
                String id4 = r94.getId();
                C1457Fr.m5016((Object) id4, "primaryGenre.id");
                r6.setupHolder(i3, title4, id4, false, new GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$4(this));
            }
            r6.setSubCategoryClickListener(new GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$5(this));
            r6.setPresentedCallback(new GenresActionBarPresenter$setupAroRibbon$$inlined$let$lambda$6(this));
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private final void m11741() {
        this.f11035.m355(this.f11029.getActionBarStateBuilder().mo396(false).mo399(false).mo403(false).mo387(this.f11033).mo391(this.f11026).mo388(new ActionBar.LayoutParams(-1, -2, 8388627)).mo389(true).mo392());
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private final void m11743() {
        C0975 r2;
        if (!C1317As.m3750(this.f11029) && (r2 = this.f11037) != null) {
            r2.setMainCaratClickListener(new GenresActionBarPresenter$showGenreSelectorsInActionBar$$inlined$let$lambda$1(this));
            r2.setSelectedPrimaryGenre(this.f11034);
            if (m11759()) {
                if (C1457Fr.m5018((Object) this.f11034, (Object) this.f11031)) {
                    String title = C2222uv.f11041.m11775(this.f11034).getTitle();
                    C1457Fr.m5016((Object) title, "AroGalleriesConstants.ge…ist(primaryGenreId).title");
                    r2.setSubCategoryLabel(title, this.f11034);
                }
                r2.setSubCategoryVisibility(0);
                r2.setSubCategoryClickListener(new GenresActionBarPresenter$showGenreSelectorsInActionBar$$inlined$let$lambda$2(this));
                return;
            }
            r2.setSubCategoryVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m11748(AbstractC2218ur urVar) {
        if (!C1317As.m3750(this.f11029)) {
            new tM(this.f11029, urVar).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m11744(String str) {
        return C1457Fr.m5018(this.f11034, str) ? "all" : str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.uu$iF */
    public static final class iF implements AbstractC0574 {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ String f11038;

        iF(String str) {
            this.f11038 = str;
        }

        @Override // o.AbstractC0503
        public final JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            if (C1457Fr.m5018((Object) this.f11038, (Object) "lolomo")) {
                return jSONObject.put("tabName", "home");
            }
            jSONObject.put("tabName", "genreCategory");
            return jSONObject.put("genreId", this.f11038);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final AbstractC0574 m11761(String str) {
        return new iF(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m11753(C0975.AbstractC2408iF iFVar) {
        C0785 r2 = null;
        if (iFVar instanceof C0975.AbstractC2408iF.C0976iF) {
            r2 = m11757(((C0975.AbstractC2408iF.C0976iF) iFVar).m15903());
        } else if (iFVar instanceof C0975.AbstractC2408iF.C0977) {
            if (!C1457Fr.m5018((Object) ((C0975.AbstractC2408iF.C0977) iFVar).m15904(), (Object) this.f11030)) {
                this.f11030 = ((C0975.AbstractC2408iF.C0977) iFVar).m15904();
                r2 = m11757(((C0975.AbstractC2408iF.C0977) iFVar).m15904());
            }
        } else if (iFVar instanceof C0975.AbstractC2408iF.C0978) {
            if (!C1457Fr.m5018((Object) this.f11031, (Object) "lolomo")) {
                r2 = m11757(m11744(this.f11031));
            }
        } else if (iFVar instanceof C0975.AbstractC2408iF.If) {
            r2 = m11742();
        }
        if (r2 != null) {
            Logger.INSTANCE.m131(r2);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C0785 m11742() {
        return new C0785(false, AppView.netflixLogo, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0785 m11757(String str) {
        return new C0785(false, AppView.browseTab, m11761(str));
    }
}
