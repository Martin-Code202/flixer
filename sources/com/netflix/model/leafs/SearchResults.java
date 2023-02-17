package com.netflix.model.leafs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import o.AbstractC2080qa;
import o.AbstractC2083qd;
import o.AbstractC2084qe;
import o.AbstractC2086qg;
public class SearchResults implements AbstractC2080qa {
    private List<SearchCollectionEntity> collection;
    private final List<Object> sectionsList;
    private List<AbstractC2083qd> suggestions;
    private AbstractC2086qg suggestionsListSummary;
    private AbstractC2086qg videoListSummary;
    private List<AbstractC2084qe> videos;

    private SearchResults() {
        this.sectionsList = new ArrayList(3);
    }

    @Override // o.AbstractC2080qa
    public int getNumResults() {
        int i = 0;
        Iterator<Object> it = this.sectionsList.iterator();
        while (it.hasNext()) {
            i += ((List) it.next()).size();
        }
        return i;
    }

    @Override // o.AbstractC2080qa
    public int getNumResultsVideos() {
        if (this.videos == null) {
            return 0;
        }
        return this.videos.size();
    }

    @Override // o.AbstractC2080qa
    public int getNumResultsSuggestions() {
        if (this.suggestions == null) {
            return 0;
        }
        return this.suggestions.size();
    }

    @Override // o.AbstractC2080qa
    public List<AbstractC2084qe> getResultsVideos() {
        return this.videos;
    }

    @Override // o.AbstractC2080qa
    public AbstractC2084qe getResultsVideos(int i) {
        if (this.videos == null || i >= this.videos.size()) {
            return null;
        }
        AbstractC2084qe qeVar = this.videos.get(i);
        if (qeVar instanceof AbstractC2084qe) {
            return qeVar;
        }
        return null;
    }

    @Override // o.AbstractC2080qa
    public AbstractC2083qd getResultsSuggestions(int i) {
        if (this.suggestions == null || i >= this.suggestions.size()) {
            return null;
        }
        AbstractC2083qd qdVar = this.suggestions.get(i);
        if (qdVar instanceof AbstractC2083qd) {
            return qdVar;
        }
        return null;
    }

    @Override // o.AbstractC2080qa
    public List<SearchCollectionEntity> getResultsCollection() {
        return this.collection;
    }

    public int getNumSections() {
        return this.sectionsList.size();
    }

    @Override // o.AbstractC2080qa
    public boolean hasResults() {
        return hasVideos() || hasSuggestions();
    }

    private boolean hasVideos() {
        return this.videos != null && this.videos.size() > 0;
    }

    private boolean hasSuggestions() {
        return this.suggestions != null && this.suggestions.size() > 0;
    }

    public static class Builder {
        private static final int MAX_RESULTS = 20;
        private final SearchResults results = new SearchResults();

        public void addVideos(Collection<AbstractC2084qe> collection) {
            if (this.results.videos == null) {
                this.results.videos = new ArrayList(20);
                this.results.sectionsList.add(this.results.videos);
            }
            this.results.videos.addAll(collection);
        }

        public void addCollection(Collection<SearchCollectionEntity> collection) {
            if (this.results.collection == null) {
                this.results.collection = new ArrayList(20);
            }
            for (SearchCollectionEntity searchCollectionEntity : collection) {
                if (searchCollectionEntity.getId() != null) {
                    this.results.collection.add(searchCollectionEntity);
                }
            }
        }

        public void addSuggestions(Collection<AbstractC2083qd> collection) {
            if (this.results.suggestions == null) {
                this.results.suggestions = new ArrayList(20);
                this.results.sectionsList.add(this.results.suggestions);
            }
            this.results.suggestions.addAll(collection);
        }

        public SearchResults getResults() {
            return this.results;
        }

        public void setVideoListSummary(AbstractC2086qg qgVar) {
            this.results.videoListSummary = qgVar;
        }

        public void setSuggestionsListSummary(AbstractC2086qg qgVar) {
            this.results.suggestionsListSummary = qgVar;
        }
    }

    @Override // o.AbstractC2080qa
    public AbstractC2086qg getVideosListTrackable() {
        return this.videoListSummary;
    }

    @Override // o.AbstractC2080qa
    public AbstractC2086qg getSuggestionsListTrackable() {
        return this.suggestionsListSummary;
    }
}
