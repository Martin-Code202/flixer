package o;

import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.blades.CreditMarks;
import java.util.List;
public interface pF {
    List<Advisory> getAdvisories();

    int getAutoPlayMaxCount();

    CreditMarks getCreditMarks();

    int getEndtime();

    int getEpisodeNumber();

    long getExpirationTime();

    int getLogicalStart();

    String getParentTitle();

    int getPlayableBookmarkPosition();

    long getPlayableBookmarkUpdateTime();

    String getPlayableId();

    String getPlayableTitle();

    int getRuntime();

    String getSeasonAbbrSeqLabel();

    @Override // o.pS
    int getSeasonNumber();

    String getTopLevelId();

    boolean isAdvisoryDisabled();

    boolean isAgeProtected();

    boolean isAutoPlayEnabled();

    boolean isAvailableOffline();

    boolean isAvailableToStream();

    boolean isEpisodeNumberHidden();

    boolean isNSRE();

    boolean isNextPlayableEpisode();

    boolean isPinProtected();

    boolean isPlayableEpisode();

    boolean isPreviewProtected();

    boolean isSupplementalVideo();

    boolean supportsPrePlay();
}
