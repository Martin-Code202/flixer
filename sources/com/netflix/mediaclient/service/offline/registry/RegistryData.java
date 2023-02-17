package com.netflix.mediaclient.service.offline.registry;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import java.util.ArrayList;
import java.util.List;
public class RegistryData {
    @SerializedName("deletedPlayableList")
    public List<OfflinePlayablePersistentData> mDeletedPlayableList = new ArrayList();
    @SerializedName("migrated")
    public boolean mMigrated;
    @SerializedName("offlinePlayableList")
    public List<OfflinePlayablePersistentData> mOfflinePlayablePersistentDataList = new ArrayList();
    public transient String mOfflineRootStorageDirPath;
    @SerializedName("regId")
    public final int mRegId;

    public RegistryData(int i, String str) {
        this.mRegId = i;
        this.mOfflineRootStorageDirPath = str;
    }
}
