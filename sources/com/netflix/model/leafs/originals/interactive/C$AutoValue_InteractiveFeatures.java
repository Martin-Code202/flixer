package com.netflix.model.leafs.originals.interactive;
/* renamed from: com.netflix.model.leafs.originals.interactive.$AutoValue_InteractiveFeatures  reason: invalid class name */
abstract class C$AutoValue_InteractiveFeatures extends InteractiveFeatures {
    private final boolean customBookmark;
    private final boolean fallbackTutorial;
    private final boolean hideDetailedDurations;
    private final boolean interactiveTrailer;
    private final boolean ipp;
    private final boolean playbackGraph;
    private final boolean playbackNotifications;
    private final boolean prePlay;

    C$AutoValue_InteractiveFeatures(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.playbackGraph = z;
        this.playbackNotifications = z2;
        this.ipp = z3;
        this.prePlay = z4;
        this.customBookmark = z5;
        this.fallbackTutorial = z6;
        this.interactiveTrailer = z7;
        this.hideDetailedDurations = z8;
    }

    @Override // com.netflix.model.leafs.originals.interactive.InteractiveFeatures
    public boolean playbackGraph() {
        return this.playbackGraph;
    }

    @Override // com.netflix.model.leafs.originals.interactive.InteractiveFeatures
    public boolean playbackNotifications() {
        return this.playbackNotifications;
    }

    @Override // com.netflix.model.leafs.originals.interactive.InteractiveFeatures
    public boolean ipp() {
        return this.ipp;
    }

    @Override // com.netflix.model.leafs.originals.interactive.InteractiveFeatures
    public boolean prePlay() {
        return this.prePlay;
    }

    @Override // com.netflix.model.leafs.originals.interactive.InteractiveFeatures
    public boolean customBookmark() {
        return this.customBookmark;
    }

    @Override // com.netflix.model.leafs.originals.interactive.InteractiveFeatures
    public boolean fallbackTutorial() {
        return this.fallbackTutorial;
    }

    @Override // com.netflix.model.leafs.originals.interactive.InteractiveFeatures
    public boolean interactiveTrailer() {
        return this.interactiveTrailer;
    }

    @Override // com.netflix.model.leafs.originals.interactive.InteractiveFeatures
    public boolean hideDetailedDurations() {
        return this.hideDetailedDurations;
    }

    public String toString() {
        return "InteractiveFeatures{playbackGraph=" + this.playbackGraph + ", playbackNotifications=" + this.playbackNotifications + ", ipp=" + this.ipp + ", prePlay=" + this.prePlay + ", customBookmark=" + this.customBookmark + ", fallbackTutorial=" + this.fallbackTutorial + ", interactiveTrailer=" + this.interactiveTrailer + ", hideDetailedDurations=" + this.hideDetailedDurations + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InteractiveFeatures)) {
            return false;
        }
        InteractiveFeatures interactiveFeatures = (InteractiveFeatures) obj;
        return this.playbackGraph == interactiveFeatures.playbackGraph() && this.playbackNotifications == interactiveFeatures.playbackNotifications() && this.ipp == interactiveFeatures.ipp() && this.prePlay == interactiveFeatures.prePlay() && this.customBookmark == interactiveFeatures.customBookmark() && this.fallbackTutorial == interactiveFeatures.fallbackTutorial() && this.interactiveTrailer == interactiveFeatures.interactiveTrailer() && this.hideDetailedDurations == interactiveFeatures.hideDetailedDurations();
    }

    public int hashCode() {
        return ((((((((((((((1000003 ^ (this.playbackGraph ? 1231 : 1237)) * 1000003) ^ (this.playbackNotifications ? 1231 : 1237)) * 1000003) ^ (this.ipp ? 1231 : 1237)) * 1000003) ^ (this.prePlay ? 1231 : 1237)) * 1000003) ^ (this.customBookmark ? 1231 : 1237)) * 1000003) ^ (this.fallbackTutorial ? 1231 : 1237)) * 1000003) ^ (this.interactiveTrailer ? 1231 : 1237)) * 1000003) ^ (this.hideDetailedDurations ? 1231 : 1237);
    }
}
