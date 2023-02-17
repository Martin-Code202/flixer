package o;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.Episode;
/* renamed from: o.Cz  reason: case insensitive filesystem */
public class C1383Cz extends CH implements pI {

    /* renamed from: ˊ  reason: contains not printable characters */
    public Episode.Detail f5242;

    public C1383Cz(AbstractC0929<? extends AbstractC0730> r1) {
        super(r1);
    }

    @Override // o.CH, o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        if (!"detail".equals(str)) {
            return super.getOrCreate(str);
        }
        Episode.Detail detail = new Episode.Detail();
        this.f5242 = detail;
        return detail;
    }

    @Override // o.CH, o.AbstractC0730
    public void set(String str, Object obj) {
        if ("detail".equals(str)) {
            this.f5242 = (Episode.Detail) obj;
        } else {
            super.set(str, obj);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public Episode.Detail getDetail() {
        return this.f5242;
    }

    @Override // o.CH, o.AbstractC2072pu
    public String getId() {
        if (super.getId() != null) {
            return super.getId();
        }
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getId();
    }

    @Override // o.CH, o.AbstractC2072pu
    public VideoType getType() {
        return VideoType.EPISODE;
    }

    @Override // o.pI
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo4563() {
        if (this.bookmark == null) {
            return 0;
        }
        return this.bookmark.getBookmarkPosition();
    }

    @Override // o.CH, o.pF
    public long getPlayableBookmarkUpdateTime() {
        if (this.bookmark == null) {
            return 0;
        }
        return this.bookmark.getLastModified();
    }

    @Override // o.pI
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo4564() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getSeasonId();
    }

    @Override // o.pI
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo4565() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getShowId();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m4568() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getShowTitle();
    }

    @Override // o.pI
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo4566() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.restUrl;
    }

    @Override // o.pI
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo4562() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getNextEpisodeId();
    }

    @Override // o.CH, o.pT
    public String getCatalogIdUrl() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getShowRestUrl();
    }

    @Override // o.CH, o.pF
    public int getEpisodeNumber() {
        if (this.f5242 == null) {
            return -1;
        }
        return this.f5242.getEpisodeNumber();
    }

    @Override // o.CH, o.pF, o.pS
    public int getSeasonNumber() {
        if (this.f5242 == null) {
            return -1;
        }
        return this.f5242.getSeasonNumber();
    }

    @Override // o.CH, o.pF
    public String getTopLevelId() {
        return mo4565();
    }

    @Override // o.CH, o.pF
    public String getParentTitle() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getShowTitle();
    }

    @Override // o.CH, o.pF
    public String getPlayableId() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getId();
    }

    @Override // o.CH, o.pF
    public String getPlayableTitle() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getTitle();
    }

    @Override // o.CH, o.pF
    public boolean isAutoPlayEnabled() {
        if (this.f5242 == null) {
            return false;
        }
        return this.f5242.isAutoPlayEnabled();
    }

    @Override // o.CH, o.pF
    public int getAutoPlayMaxCount() {
        if (this.f5242 == null) {
            return -1;
        }
        return this.f5242.getAutoPlayMaxCount();
    }

    @Override // o.CH, o.pF
    public boolean isNextPlayableEpisode() {
        if (this.f5242 == null) {
            return false;
        }
        return this.f5242.isNextPlayableEpisode();
    }

    @Override // o.CH, o.pF
    public boolean isPlayableEpisode() {
        return true;
    }

    @Override // o.CH, o.pF
    public boolean isPinProtected() {
        if (this.f5242 == null) {
            return false;
        }
        return this.f5242.isPinProtected();
    }

    @Override // o.CH, o.pF
    public boolean isPreviewProtected() {
        if (this.f5242 == null) {
            return false;
        }
        return this.f5242.isPreviewProtected();
    }

    @Override // o.pI
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String mo4567() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getAvailabilityDateMessage();
    }

    @Override // o.CH, o.pN
    public String getNewBadge() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getNewBadge();
    }

    @Override // o.CH, o.pF
    public long getExpirationTime() {
        if (this.f5242 == null) {
            return -1;
        }
        return this.f5242.expirationTime;
    }

    @Override // o.CH, o.pF
    public boolean supportsPrePlay() {
        Episode.Detail r1 = getDetail();
        return r1 != null && r1.supportsPrePlay;
    }

    @Override // o.CH, o.pJ
    public boolean isPreRelease() {
        return false;
    }

    @Override // o.CH, o.pF
    public String getSeasonAbbrSeqLabel() {
        return (this.f5242 == null || this.f5242.abbrSeqLabel == null) ? "" : this.f5242.abbrSeqLabel;
    }

    @Override // o.CH, o.AbstractC2074pw
    public String getInterestingUrl() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getInterestingUrl();
    }

    @Override // o.CH, o.pI
    public String getInterestingSmallUrl() {
        if (this.f5242 == null) {
            return null;
        }
        return this.f5242.getInterestingSmallUrl();
    }
}
