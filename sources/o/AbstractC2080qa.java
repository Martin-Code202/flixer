package o;

import com.netflix.model.leafs.SearchCollectionEntity;
import java.util.List;
/* renamed from: o.qa  reason: case insensitive filesystem */
public interface AbstractC2080qa {
    int getNumResults();

    int getNumResultsSuggestions();

    int getNumResultsVideos();

    List<SearchCollectionEntity> getResultsCollection();

    AbstractC2083qd getResultsSuggestions(int i);

    List<AbstractC2084qe> getResultsVideos();

    AbstractC2084qe getResultsVideos(int i);

    AbstractC2086qg getSuggestionsListTrackable();

    AbstractC2086qg getVideosListTrackable();

    boolean hasResults();
}
