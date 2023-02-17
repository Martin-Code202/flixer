package o;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmWatchedShowRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import java.util.List;
/* renamed from: o.qs  reason: case insensitive filesystem */
public class C2099qs implements RealmModel, RealmWatchedShowRealmProxyInterface {
    private String showId;
    private RealmList<C2100qt> watchedEpisodes;

    @Override // io.realm.RealmWatchedShowRealmProxyInterface
    public String realmGet$showId() {
        return this.showId;
    }

    @Override // io.realm.RealmWatchedShowRealmProxyInterface
    public RealmList realmGet$watchedEpisodes() {
        return this.watchedEpisodes;
    }

    public void realmSet$showId(String str) {
        this.showId = str;
    }

    public void realmSet$watchedEpisodes(RealmList realmList) {
        this.watchedEpisodes = realmList;
    }

    public C2099qs() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public C2099qs(pF pFVar) {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$showId(pFVar.getTopLevelId());
        realmSet$watchedEpisodes(new RealmList());
        realmGet$watchedEpisodes().add(new C2100qt(pFVar));
    }

    public String getShowId() {
        return realmGet$showId();
    }

    public List<C2100qt> getWatchedEpisodes() {
        return realmGet$watchedEpisodes();
    }
}
