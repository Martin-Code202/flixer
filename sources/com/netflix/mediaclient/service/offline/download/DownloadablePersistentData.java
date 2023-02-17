package com.netflix.mediaclient.service.offline.download;

import com.google.gson.annotations.SerializedName;
import o.hD;
public class DownloadablePersistentData {
    @SerializedName("downloadableId")
    public final String mDownloadableId;
    @SerializedName("isComplete")
    public boolean mIsComplete = false;
    @SerializedName("size")
    public long mSizeOfDownloadable;

    public DownloadablePersistentData(hD hDVar) {
        this.mDownloadableId = hDVar.mo6809();
        this.mSizeOfDownloadable = hDVar.mo6812();
    }
}
