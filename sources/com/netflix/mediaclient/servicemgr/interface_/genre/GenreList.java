package com.netflix.mediaclient.servicemgr.interface_.genre;

import android.os.Parcelable;
import o.AbstractC2071pt;
public interface GenreList extends AbstractC2071pt, Parcelable {

    public enum GenreType {
        GALLERY,
        LOLOMO,
        UNKNOWN
    }

    GenreType getGenreType();
}
