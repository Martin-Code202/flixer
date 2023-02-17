package o;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.transition.Fade;
import android.support.transition.Transition;
import android.support.v4.app.Fragment;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.lolomo.GenreFragmentCreator$1;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.Map;
import org.json.JSONObject;
public class tJ implements AbstractC2141sc {

    /* renamed from: ˏ  reason: contains not printable characters */
    private NetflixActivity f10374;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Map<Intent, AbstractC0517> f10375 = new GenreFragmentCreator$1(this);

    tJ(NetflixActivity netflixActivity) {
        this.f10374 = netflixActivity;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ॱ */
    public boolean mo10080(Intent intent) {
        return ActivityC2153sl.m10785(intent) || m10956(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m10956(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null || !component.getClassName().equals(uB.m11325().getCanonicalName())) {
            return false;
        }
        intent.setExtrasClassLoader(getClass().getClassLoader());
        return intent.hasExtra("lomo_parcel");
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public boolean mo10074() {
        return false;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ʽ */
    public AppView mo10051(Intent intent) {
        return AppView.browseTitlesGallery;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ᐝ */
    public UIScreen mo10083() {
        return UIScreen.browseTitles;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ʻ */
    public AbstractC0574 mo10050(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(getClass().getClassLoader());
        final GenreList genreList = (GenreList) extras.getParcelable("genre_parcel");
        final pC pCVar = (pC) extras.getParcelable("lomo_parcel");
        return new AbstractC0574() { // from class: o.tJ.5
            @Override // o.AbstractC0503
            public JSONObject toJSONObject() {
                JSONObject jSONObject = new JSONObject();
                if (genreList != null && genreList.getId() != null) {
                    jSONObject.put("genreId", genreList.getId());
                    if (genreList.getTrackId() > 0) {
                        jSONObject.put("trackId", genreList.getTrackId());
                    }
                } else if (pCVar != null) {
                    jSONObject.put("listId", pCVar.getId());
                    jSONObject.put("trackId", pCVar.getTrackId());
                }
                return jSONObject;
            }
        };
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˋ */
    public AbstractC0517 mo10061(Intent intent) {
        if (!mo10080(intent)) {
            return null;
        }
        if (this.f10375.get(intent) != null) {
            return this.f10375.get(intent);
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(getClass().getClassLoader());
        String string = extras.getString("genre_id");
        String string2 = extras.getString("genre_filter");
        GenreList genreList = (GenreList) extras.getParcelable("genre_parcel");
        pC pCVar = (pC) extras.getParcelable("lomo_parcel");
        if (intent.getBooleanExtra(NetflixActivity.EXTRA_EXPAND_CAST_PLAYER, false)) {
            this.f10374.notifyCastPlayerShown(true);
        }
        if (C1349Bv.m4113(string) && pCVar == null) {
            C1283.m16854("GenreFragmentCreator", "No new ID to show");
            return null;
        } else if ("lolomo".equals(string)) {
            C1283.m16854("GenreFragmentCreator", "Won't try to display home lolomo");
            return null;
        } else if (pCVar != null && tK.m10965(pCVar.getId())) {
            return tK.m10960(pCVar);
        } else {
            if (genreList == null || genreList.getGenreType() != GenreList.GenreType.GALLERY) {
                if (BrowseExperience.m1780() && !m10957(intent) && !"1647397".equalsIgnoreCase(string)) {
                    return tD.m10889(string, genreList);
                }
                if (string2 == null || !C0727.m15067()) {
                    return tQ.m11003(string, genreList);
                }
                return tS.m11022(string2, genreList);
            } else if (m10957(intent)) {
                return C2219us.m11739(string, string2, genreList);
            } else {
                return tD.m10889(string, genreList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m10957(Intent intent) {
        intent.setExtrasClassLoader(getClass().getClassLoader());
        return intent.getStringExtra("genre_filter") != null && C0727.m15067();
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public boolean mo10075(Intent intent) {
        return false;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˊ */
    public void mo10055(Intent intent, AbstractC0517 r5, boolean z) {
        Transition transition;
        if (m10957(intent)) {
            if (z) {
                transition = new Fade().setDuration((long) tH.m10937());
            } else {
                transition = new BM().m3962(BrowseExperience.m1774(this.f10374, 16842836));
            }
            r5.setEnterTransition(transition);
        }
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˋ */
    public void mo10062(Intent intent, AbstractC0517 r5, boolean z) {
        Transition transition;
        if (m10957(intent)) {
            if (z) {
                transition = new Fade().setDuration((long) tH.m10937());
            } else {
                transition = new BM().m3962(BrowseExperience.m1774(this.f10374, 16842836));
            }
            r5.setExitTransition(transition);
        }
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public void mo10069(Intent intent, Fragment fragment) {
        if (fragment instanceof AbstractC0517) {
            this.f10375.put(intent, (AbstractC0517) fragment);
        }
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˎ */
    public void mo10066(Intent intent, Fragment fragment) {
        this.f10375.remove(intent);
    }
}
