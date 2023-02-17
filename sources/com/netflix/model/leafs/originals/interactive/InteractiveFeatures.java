package com.netflix.model.leafs.originals.interactive;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.netflix.model.leafs.originals.interactive.AutoValue_InteractiveFeatures;
public abstract class InteractiveFeatures {
    public abstract boolean customBookmark();

    public abstract boolean fallbackTutorial();

    public abstract boolean hideDetailedDurations();

    public abstract boolean interactiveTrailer();

    public abstract boolean ipp();

    public abstract boolean playbackGraph();

    public abstract boolean playbackNotifications();

    public abstract boolean prePlay();

    public static TypeAdapter<InteractiveFeatures> typeAdapter(Gson gson) {
        return new AutoValue_InteractiveFeatures.GsonTypeAdapter(gson);
    }
}
