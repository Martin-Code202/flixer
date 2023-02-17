package o;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import io.reactivex.subjects.BehaviorSubject;
public final class yR implements pD {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final BehaviorSubject<Integer> f12427;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final qN f12428 = new qN("previews-playcontext-request-id", 90785634, -1, this.f12429.getPosition());

    /* renamed from: ॱ  reason: contains not printable characters */
    private final pD f12429;

    @Override // o.pD
    public int getBackgroundColor() {
        return this.f12429.getBackgroundColor();
    }

    @Override // o.pJ
    public String getBoxartId() {
        return this.f12429.getBoxartId();
    }

    @Override // o.pJ
    public String getBoxshotUrl() {
        return this.f12429.getBoxshotUrl();
    }

    @Override // o.pJ
    public VideoType getErrorType() {
        return this.f12429.getErrorType();
    }

    @Override // o.pD
    public int getForegroundColor() {
        return this.f12429.getForegroundColor();
    }

    @Override // o.AbstractC2072pu
    public String getId() {
        return this.f12429.getId();
    }

    @Override // o.pD
    public String getPanelArtUrl() {
        return this.f12429.getPanelArtUrl();
    }

    @Override // o.pD
    public int getPosition() {
        return this.f12429.getPosition();
    }

    @Override // o.pD
    public long getSupplementalVideoDuration() {
        return this.f12429.getSupplementalVideoDuration();
    }

    @Override // o.pD
    public String getSupplementalVideoId() {
        return this.f12429.getSupplementalVideoId();
    }

    @Override // o.AbstractC2072pu
    public String getTitle() {
        return this.f12429.getTitle();
    }

    @Override // o.pD
    public String getTitleTreatmentUrl() {
        return this.f12429.getTitleTreatmentUrl();
    }

    @Override // o.AbstractC2072pu
    public VideoType getType() {
        return this.f12429.getType();
    }

    @Override // o.pD
    public pT getVideoDetails() {
        return this.f12429.getVideoDetails();
    }

    @Override // o.pJ
    public boolean isOriginal() {
        return this.f12429.isOriginal();
    }

    @Override // o.pJ
    public boolean isPreRelease() {
        return this.f12429.isPreRelease();
    }

    @Override // o.pD
    public void setBookmark(long j) {
        this.f12429.setBookmark(j);
    }

    @Override // o.pD
    public void setVideoDetails(pT pTVar) {
        this.f12429.setVideoDetails(pTVar);
    }

    public yR(pD pDVar) {
        C1457Fr.m5025(pDVar, "previewsFeedItem");
        this.f12429 = pDVar;
        BehaviorSubject<Integer> createDefault = BehaviorSubject.createDefault(0);
        C1457Fr.m5016((Object) createDefault, "BehaviorSubject.createDefault(0)");
        this.f12427 = createDefault;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final BehaviorSubject<Integer> m13246() {
        return this.f12427;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final qN m13247() {
        return this.f12428;
    }
}
