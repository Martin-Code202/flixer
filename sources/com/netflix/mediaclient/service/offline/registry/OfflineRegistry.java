package com.netflix.mediaclient.service.offline.registry;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.StatFs;
import com.google.gson.JsonSyntaxException;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import o.AE;
import o.AH;
import o.C1276;
import o.C1283;
import o.C1330Bc;
import o.C1349Bv;
import o.C1875ib;
import o.C1876ic;
import o.C1882ij;
import o.C1888ip;
import o.C1889iq;
import o.hI;
import o.hZ;
import o.oZ;
import o.pY;
public class OfflineRegistry {

    /* renamed from: ˊ  reason: contains not printable characters */
    private MetaRegistry f1546;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final oZ f1547 = new oZ();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f1548;

    /* renamed from: ˏ  reason: contains not printable characters */
    private RegistryState f1549 = RegistryState.NOT_READY;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<hZ> f1550 = new ArrayList();

    public enum RegistryState {
        NOT_READY,
        SUCCESS,
        STORAGE_ERROR
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public RegistryState m841() {
        return this.f1549;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m848(List<hI> list) {
        for (hZ hZVar : this.f1550) {
            hZVar.m7007(0);
        }
        for (hI hIVar : list) {
            if (hIVar.mo6881() != DownloadState.Complete) {
                Iterator<hZ> it = this.f1550.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    hZ next = it.next();
                    long r9 = hIVar.mo6887() - hIVar.mo6914();
                    if (hIVar.mo6884().startsWith(next.m7009().getAbsolutePath())) {
                        C1283.m16863("nf_offline_registry", "storageVolume=%s dataRemaining=%d", next.m7009(), Long.valueOf(r9));
                        next.m7010(r9);
                        break;
                    }
                }
            }
        }
    }

    public OfflineRegistry(Context context) {
        this.f1548 = context;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public RegistryState m846(C1875ib ibVar) {
        this.f1549 = RegistryState.NOT_READY;
        boolean z = false;
        this.f1550.clear();
        m825();
        for (C1876ic icVar : ibVar.m7657()) {
            File file = new File(icVar.m7664().getAbsolutePath() + "/.of");
            if (file.isDirectory() || file.mkdirs()) {
                RegistryData r10 = m826(file);
                if (r10 != null) {
                    C1283.m16863("nf_offline_registry", "init registryData.mMigrated=%b", Boolean.valueOf(r10.mMigrated));
                    if (!r10.mMigrated) {
                        r10.mMigrated = true;
                        this.f1546.mRegMap.put(Integer.valueOf(r10.mRegId), r10);
                        z = true;
                    } else {
                        RegistryData registryData = this.f1546.mRegMap.get(Integer.valueOf(r10.mRegId));
                        if (registryData != null) {
                            registryData.mOfflineRootStorageDirPath = r10.mOfflineRootStorageDirPath;
                            r10 = registryData;
                        } else {
                            C1283.m16844("nf_offline_registry", "RegistryId=%s not found", Integer.valueOf(r10.mRegId));
                            this.f1546.mRegMap.put(Integer.valueOf(r10.mRegId), r10);
                            z = true;
                            C1276.m16820().mo5730(new Throwable("RegistryId=" + r10.mRegId + " not found in metaRegistry"));
                        }
                    }
                    m829(r10);
                    this.f1550.add(new hZ(this.f1546, r10, icVar));
                }
            } else {
                C1283.m16844("nf_offline_registry", "OfflineRegistry can't create directory %s", file.getAbsolutePath());
            }
        }
        this.f1547.m9596(this.f1550);
        this.f1546.mCurrentRegistryData = null;
        if (this.f1550.size() > 0) {
            this.f1549 = RegistryState.SUCCESS;
            this.f1546.mCurrentRegistryData = this.f1550.get(0).f7187;
            Iterator<hZ> it = this.f1550.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RegistryData registryData2 = it.next().f7187;
                if (registryData2.mRegId == this.f1546.mUserSelectedRegId) {
                    C1283.m16863("nf_offline_registry", "found selected regId=%d", Integer.valueOf(registryData2.mRegId));
                    this.f1546.mCurrentRegistryData = registryData2;
                    break;
                }
            }
        } else {
            this.f1549 = RegistryState.STORAGE_ERROR;
        }
        C1283.m16863("nf_offline_registry", "init migrationDone=%b", Boolean.valueOf(z));
        if (z) {
            try {
                C1283.m16862("nf_offline_registry", "init calling persist for migration");
                m832();
            } catch (PersistRegistryException e) {
                C1283.m16847("nf_offline_registry", "PersistRegistryException", e);
            }
        }
        return this.f1549;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m836(OfflinePlayablePersistentData offlinePlayablePersistentData) {
        this.f1546.mCurrentRegistryData.mOfflinePlayablePersistentDataList.add(offlinePlayablePersistentData);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m847() {
        m832();
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m832() {
        boolean z = true;
        StringBuilder sb = new StringBuilder("persistRegistry failed count=" + this.f1550.size());
        for (hZ hZVar : this.f1550) {
            RegistryData registryData = hZVar.f7187;
            String r10 = m827(registryData);
            File file = new File(C1888ip.m7721(registryData.mOfflineRootStorageDirPath));
            C1283.m16863("nf_offline_registry", "persistRegistry writing registry=%s", file.getAbsolutePath());
            boolean r12 = C1882ij.m7701(file, r10);
            sb.append(", path=").append(file.getAbsolutePath());
            sb.append(", exists=").append(file.exists());
            sb.append(", saved=").append(r12).append(" ");
            if (z) {
                z = r12;
            }
        }
        this.f1546.mMetaRegistryWriteCounter++;
        boolean r9 = C1882ij.m7701(new File(C1888ip.m7718(this.f1548.getFilesDir())), AE.m3322().toJson(this.f1546));
        sb.append(", metaRegistrySaved=").append(r9);
        if (!z || !r9) {
            C1283.m16844("nf_offline_registry", "persistRegistry can't save, allRegistriesSaved=%b metaRegistrySaved=%b", Boolean.valueOf(z), Boolean.valueOf(r9));
            throw new PersistRegistryException(sb.toString());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m839() {
        for (hZ hZVar : this.f1550) {
            if (hZVar.f7187.mOfflinePlayablePersistentDataList.size() > 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    private List<hZ> m830() {
        return this.f1550;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m852() {
        return this.f1550.size();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m838(boolean z) {
        this.f1546.mDownloadsPausedByUser = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m849() {
        return this.f1546.mDownloadsPausedByUser;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public pY m856() {
        return this.f1547;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public int m834() {
        return this.f1547.mo9597();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m844(int i) {
        if (i >= 0 && i < this.f1550.size()) {
            hZ hZVar = this.f1550.get(i);
            for (hZ hZVar2 : this.f1550) {
                RegistryData registryData = hZVar2.f7187;
                if (registryData.mRegId == hZVar.m7006()) {
                    this.f1546.mCurrentRegistryData = registryData;
                    this.f1546.mUserSelectedRegId = registryData.mRegId;
                    C1283.m16863("nf_offline_registry", "setCurrentOfflineVolume success mRegId=%d", Integer.valueOf(registryData.mRegId));
                    return true;
                }
            }
        }
        C1283.m16863("nf_offline_registry", "setCurrentOfflineVolume invalid selectedVolumeIndex=%d", Integer.valueOf(i));
        return false;
    }

    @SuppressLint({"UseSparseArrays"})
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m825() {
        File file = new File(C1888ip.m7718(this.f1548.getFilesDir()));
        C1882ij.m7702(file);
        String str = "";
        try {
            if (file.exists()) {
                str = C1349Bv.m4111(AH.m3345(file), "utf-8");
            }
        } catch (IOException e) {
        }
        try {
            this.f1546 = (MetaRegistry) AE.m3322().fromJson(str, (Class<Object>) MetaRegistry.class);
        } catch (JsonSyntaxException e2) {
        }
        if (this.f1546 == null) {
            this.f1546 = new MetaRegistry(2);
        }
        if (this.f1546.mRegMap == null) {
            this.f1546.mRegMap = new HashMap();
            C1283.m16863("nf_offline_registry", "readMetaRegistry initial save=%b", Boolean.valueOf(C1882ij.m7701(new File(C1888ip.m7718(this.f1548.getFilesDir())), AE.m3322().toJson(this.f1546))));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m829(RegistryData registryData) {
        Iterator<OfflinePlayablePersistentData> it = registryData.mOfflinePlayablePersistentDataList.iterator();
        while (it.hasNext()) {
            OfflinePlayablePersistentData next = it.next();
            String r7 = C1888ip.m7717(registryData.mOfflineRootStorageDirPath, next.mPlayableId);
            if (next.getDownloadState() == DownloadState.Creating || next.getDownloadState() == DownloadState.CreateFailed || next.isOldFatalError()) {
                C1283.m16863("nf_offline_registry", "removeCreatingOrFailedItemsFromRegistryData deleting downloads path=%s success=%b", r7, Boolean.valueOf(C1889iq.m7729(r7)));
                it.remove();
            } else if (!AH.m3348(r7)) {
                C1283.m16862("nf_offline_registry", "removeCreatingOrFailedItemsFromRegistryData skip without playable directory");
                it.remove();
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private RegistryData m826(File file) {
        String str = "";
        File file2 = new File(C1888ip.m7721(file.getAbsolutePath()));
        RegistryData registryData = null;
        try {
            C1882ij.m7702(file2);
            if (file2.exists()) {
                str = C1349Bv.m4111(AH.m3345(file2), "utf-8");
            }
            registryData = (RegistryData) AE.m3322().fromJson(str, (Class<Object>) RegistryData.class);
        } catch (IOException e) {
            return null;
        } catch (JsonSyntaxException e2) {
        }
        if (registryData == null || registryData.mOfflinePlayablePersistentDataList == null || registryData.mDeletedPlayableList == null) {
            registryData = new RegistryData(new Random().nextInt(), file.getAbsolutePath());
            C1283.m16863("nf_offline_registry", "buildRegistryDataFromFile registrySaved=%b", Boolean.valueOf(C1882ij.m7701(file2, m827(registryData))));
        }
        registryData.mOfflineRootStorageDirPath = file.getAbsolutePath();
        return registryData;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m827(RegistryData registryData) {
        return AE.m3322().toJson(registryData);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m833() {
        return this.f1546.mCurrentRegistryData.mOfflineRootStorageDirPath;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m853(OfflinePlayablePersistentData offlinePlayablePersistentData, boolean z) {
        RegistryData registryData = null;
        for (hZ hZVar : this.f1550) {
            RegistryData registryData2 = hZVar.f7187;
            Iterator<OfflinePlayablePersistentData> it = registryData2.mOfflinePlayablePersistentDataList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().mPlayableId.equals(offlinePlayablePersistentData.mPlayableId)) {
                        registryData = registryData2;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (registryData != null) {
            registryData.mOfflinePlayablePersistentDataList.remove(offlinePlayablePersistentData);
            if (z) {
                registryData.mDeletedPlayableList.add(offlinePlayablePersistentData);
            }
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m855() {
        return this.f1546.mPrimaryProfileGuid;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m835() {
        return this.f1546.mGeoCountryCode;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m843(String str) {
        this.f1546.mGeoCountryCode = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m837(String str) {
        this.f1546.mPrimaryProfileGuid = str;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m845() {
        for (RegistryData registryData : this.f1546.mRegMap.values()) {
            registryData.mOfflinePlayablePersistentDataList.clear();
            registryData.mDeletedPlayableList.clear();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m842(OfflinePlayablePersistentData offlinePlayablePersistentData) {
        for (hZ hZVar : this.f1550) {
            hZVar.f7187.mDeletedPlayableList.remove(offlinePlayablePersistentData);
        }
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private List<OfflinePlayablePersistentData> m831() {
        ArrayList arrayList = new ArrayList();
        for (hZ hZVar : this.f1550) {
            for (OfflinePlayablePersistentData offlinePlayablePersistentData : hZVar.f7187.mDeletedPlayableList) {
                arrayList.add(offlinePlayablePersistentData);
            }
        }
        return arrayList;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m854() {
        for (hZ hZVar : this.f1550) {
            StatFs r3 = C1330Bc.m4008(hZVar.m7009());
            if (r3 != null) {
                hZVar.f7186.m7662(r3);
            }
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public List<OfflinePlayablePersistentData> m851() {
        ArrayList arrayList = new ArrayList();
        for (RegistryData registryData : this.f1546.mRegMap.values()) {
            arrayList.addAll(registryData.mOfflinePlayablePersistentDataList);
        }
        arrayList.addAll(m840());
        return arrayList;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public List<OfflinePlayablePersistentData> m840() {
        List<OfflinePlayablePersistentData> r2 = m831();
        ArrayList arrayList = new ArrayList();
        for (OfflinePlayablePersistentData offlinePlayablePersistentData : r2) {
            if (!offlinePlayablePersistentData.getDownloadState().equals(DownloadState.DeleteComplete)) {
                arrayList.add(offlinePlayablePersistentData);
            } else {
                m842(offlinePlayablePersistentData);
            }
        }
        return arrayList;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public C0018 m850() {
        return new C0018();
    }

    /* renamed from: com.netflix.mediaclient.service.offline.registry.OfflineRegistry$ˊ  reason: contains not printable characters */
    public class C0018 implements Enumeration {

        /* renamed from: ˎ  reason: contains not printable characters */
        int f1555 = 0;

        public C0018() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f1555 < OfflineRegistry.this.m830().size();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public RegistryData nextElement() {
            List r0 = OfflineRegistry.this.m830();
            int i = this.f1555;
            this.f1555 = i + 1;
            return ((hZ) r0.get(i)).f7187;
        }
    }
}
