package o;
public final class mW {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static mZ m8968(CH ch) {
        mZ mZVar = new mZ();
        mZVar.id = ch.getId();
        mZVar.videoType = ch.getType();
        mZVar.title = ch.getTitle();
        mZVar.horzDispUrl = ch.getHorzDispUrl();
        mZVar.tvCardUrl = ch.getTitleImgUrl();
        return mZVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static mZ m8971(AbstractC2074pw pwVar) {
        mZ r1 = m8968((CH) pwVar);
        m8969(r1, pwVar);
        r1.trickplayUrl = BE.m3843(pwVar, true);
        return r1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static mZ m8970(AbstractC2077pz pzVar) {
        mZ r1 = m8968((CH) pzVar);
        m8969(r1, pzVar);
        return r1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static mZ m8969(mZ mZVar, pF pFVar) {
        mZVar.isPlayable = true;
        mZVar.isPlayableEpisode = pFVar.isPlayableEpisode();
        mZVar.isNextPlayableEpisode = pFVar.isNextPlayableEpisode();
        mZVar.isAutoPlayEnabled = pFVar.isAutoPlayEnabled();
        mZVar.isAgeProtected = pFVar.isAgeProtected();
        mZVar.isPinProtected = pFVar.isPinProtected();
        mZVar.isPreviewProtected = pFVar.isPreviewProtected();
        mZVar.plyableBookmarkPos = pFVar.getPlayableBookmarkPosition();
        mZVar.playableRuntime = pFVar.getRuntime();
        mZVar.playableEndtime = pFVar.getEndtime();
        mZVar.playableId = pFVar.getPlayableId();
        mZVar.playableTitle = pFVar.getPlayableTitle();
        mZVar.playableParentId = pFVar.getTopLevelId();
        mZVar.playableParentTitle = pFVar.getParentTitle();
        mZVar.playableEpisodeNumber = pFVar.getEpisodeNumber();
        mZVar.playableSeasonNumber = pFVar.getSeasonNumber();
        mZVar.playableSeasonNumAbbrLabel = pFVar.getSeasonAbbrSeqLabel();
        return mZVar;
    }
}
