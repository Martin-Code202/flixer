package o;

import io.realm.RealmModel;
import io.realm.RealmWatchedEpisodeRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
/* renamed from: o.qt  reason: case insensitive filesystem */
public class C2100qt implements RealmModel, RealmWatchedEpisodeRealmProxyInterface {
    private String episodeId;
    private int episodeNumber;
    private String episodeSmartDownloadedId;
    private int seasonNumber;
    private String showId;

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public String realmGet$episodeId() {
        return this.episodeId;
    }

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public int realmGet$episodeNumber() {
        return this.episodeNumber;
    }

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public String realmGet$episodeSmartDownloadedId() {
        return this.episodeSmartDownloadedId;
    }

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public int realmGet$seasonNumber() {
        return this.seasonNumber;
    }

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public String realmGet$showId() {
        return this.showId;
    }

    public void realmSet$episodeId(String str) {
        this.episodeId = str;
    }

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public void realmSet$episodeNumber(int i) {
        this.episodeNumber = i;
    }

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public void realmSet$episodeSmartDownloadedId(String str) {
        this.episodeSmartDownloadedId = str;
    }

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public void realmSet$seasonNumber(int i) {
        this.seasonNumber = i;
    }

    @Override // io.realm.RealmWatchedEpisodeRealmProxyInterface
    public void realmSet$showId(String str) {
        this.showId = str;
    }

    public C2100qt() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public C2100qt(pF pFVar) {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$episodeId(pFVar.getPlayableId());
        realmSet$showId(pFVar.getTopLevelId());
        realmSet$seasonNumber(pFVar.getSeasonNumber());
        realmSet$episodeNumber(pFVar.getEpisodeNumber());
    }

    public String getEpisodeId() {
        return realmGet$episodeId();
    }

    public String getEpisodeSmartDownloadedId() {
        return realmGet$episodeSmartDownloadedId();
    }

    public void setEpisodeSmartDownloadedId(String str) {
        realmSet$episodeSmartDownloadedId(str);
    }

    public String getShowId() {
        return realmGet$showId();
    }

    public int getSeasonNumber() {
        return realmGet$seasonNumber();
    }

    public int getEpisodeNumber() {
        return realmGet$episodeNumber();
    }
}
