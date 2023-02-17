package o;

import java.util.Set;
public interface pR extends pG, pQ, pU {
    Set<String> getCharacterRoles();

    String getCreators();

    String getCurrentEpisodeBadge();

    String getCurrentEpisodeHorzDispUrl();

    String getCurrentEpisodeId();

    int getCurrentEpisodeNumber();

    String getCurrentEpisodeSynopsis();

    String getCurrentEpisodeTitle();

    CB getCurrentSeasonDetail();

    int getCurrentSeasonNumber();

    int getNumCreators();

    String getNumSeasonsLabel();

    int getSeasonCount();
}
