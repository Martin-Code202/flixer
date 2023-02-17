package io.realm;

import com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason;
import io.realm.BaseRealm;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.C2092qm;
import o.C2098qr;
public class RealmVideoDetailsRealmProxy extends C2098qr implements RealmObjectProxy {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmVideoDetailsColumnInfo columnInfo;
    private ProxyState<C2098qr> proxyState;
    private RealmList<RealmSeason> seasonLabelsRealmList;

    static final class RealmVideoDetailsColumnInfo extends ColumnInfo {
        long actorsIndex;
        long bifUrlIndex;
        long boxartImageIdIndex;
        long boxshotUrlIndex;
        long catalogIdUrlIndex;
        long certIndex;
        long copyrightIndex;
        long defaultTrailerIndex;
        long errorTypeIndex;
        long genresIndex;
        long hResLandBoxArtUrlIndex;
        long hResPortBoxArtUrlIndex;
        long hasTrailersIndex;
        long hasWatchedIndex;
        long horzDispSmallUrlIndex;
        long horzDispUrlIndex;
        long idIndex;
        long isInQueueIndex;
        long isOriginalIndex;
        long isPreReleaseIndex;
        long isVideo5dot1Index;
        long isVideoDolbyVisionIndex;
        long isVideoHdIndex;
        long isVideoHdr10Index;
        long isVideoUhdIndex;
        long maturityLevelIndex;
        long nextEpisodeIdIndex;
        long playableIndex;
        long profileIdIndex;
        long qualityIndex;
        long seasonLabelsIndex;
        long seasonNumberIndex;
        long storyDispUrlIndex;
        long storyUrlIndex;
        long supplMessageIndex;
        long synopsisIndex;
        long titleCroppedImgUrlIndex;
        long titleImgUrlIndex;
        long titleIndex;
        long tvCardUrlIndex;
        long videoTypeIndex;
        long yearIndex;

        RealmVideoDetailsColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(42);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("RealmVideoDetails");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.playableIndex = addColumnDetails("playable", objectSchemaInfo);
            this.profileIdIndex = addColumnDetails("profileId", objectSchemaInfo);
            this.seasonNumberIndex = addColumnDetails("seasonNumber", objectSchemaInfo);
            this.seasonLabelsIndex = addColumnDetails("seasonLabels", objectSchemaInfo);
            this.errorTypeIndex = addColumnDetails("errorType", objectSchemaInfo);
            this.videoTypeIndex = addColumnDetails("videoType", objectSchemaInfo);
            this.yearIndex = addColumnDetails("year", objectSchemaInfo);
            this.maturityLevelIndex = addColumnDetails("maturityLevel", objectSchemaInfo);
            this.synopsisIndex = addColumnDetails("synopsis", objectSchemaInfo);
            this.qualityIndex = addColumnDetails("quality", objectSchemaInfo);
            this.actorsIndex = addColumnDetails("actors", objectSchemaInfo);
            this.genresIndex = addColumnDetails("genres", objectSchemaInfo);
            this.certIndex = addColumnDetails("cert", objectSchemaInfo);
            this.supplMessageIndex = addColumnDetails("supplMessage", objectSchemaInfo);
            this.defaultTrailerIndex = addColumnDetails("defaultTrailer", objectSchemaInfo);
            this.copyrightIndex = addColumnDetails("copyright", objectSchemaInfo);
            this.hResPortBoxArtUrlIndex = addColumnDetails("hResPortBoxArtUrl", objectSchemaInfo);
            this.hResLandBoxArtUrlIndex = addColumnDetails("hResLandBoxArtUrl", objectSchemaInfo);
            this.boxshotUrlIndex = addColumnDetails("boxshotUrl", objectSchemaInfo);
            this.boxartImageIdIndex = addColumnDetails("boxartImageId", objectSchemaInfo);
            this.horzDispUrlIndex = addColumnDetails("horzDispUrl", objectSchemaInfo);
            this.horzDispSmallUrlIndex = addColumnDetails("horzDispSmallUrl", objectSchemaInfo);
            this.storyDispUrlIndex = addColumnDetails("storyDispUrl", objectSchemaInfo);
            this.tvCardUrlIndex = addColumnDetails("tvCardUrl", objectSchemaInfo);
            this.storyUrlIndex = addColumnDetails("storyUrl", objectSchemaInfo);
            this.bifUrlIndex = addColumnDetails("bifUrl", objectSchemaInfo);
            this.catalogIdUrlIndex = addColumnDetails("catalogIdUrl", objectSchemaInfo);
            this.titleImgUrlIndex = addColumnDetails("titleImgUrl", objectSchemaInfo);
            this.titleCroppedImgUrlIndex = addColumnDetails("titleCroppedImgUrl", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", objectSchemaInfo);
            this.nextEpisodeIdIndex = addColumnDetails("nextEpisodeId", objectSchemaInfo);
            this.isOriginalIndex = addColumnDetails("isOriginal", objectSchemaInfo);
            this.isPreReleaseIndex = addColumnDetails("isPreRelease", objectSchemaInfo);
            this.hasWatchedIndex = addColumnDetails("hasWatched", objectSchemaInfo);
            this.hasTrailersIndex = addColumnDetails("hasTrailers", objectSchemaInfo);
            this.isInQueueIndex = addColumnDetails("isInQueue", objectSchemaInfo);
            this.isVideoHdIndex = addColumnDetails("isVideoHd", objectSchemaInfo);
            this.isVideoUhdIndex = addColumnDetails("isVideoUhd", objectSchemaInfo);
            this.isVideo5dot1Index = addColumnDetails("isVideo5dot1", objectSchemaInfo);
            this.isVideoHdr10Index = addColumnDetails("isVideoHdr10", objectSchemaInfo);
            this.isVideoDolbyVisionIndex = addColumnDetails("isVideoDolbyVision", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RealmVideoDetailsColumnInfo realmVideoDetailsColumnInfo = (RealmVideoDetailsColumnInfo) columnInfo;
            RealmVideoDetailsColumnInfo realmVideoDetailsColumnInfo2 = (RealmVideoDetailsColumnInfo) columnInfo2;
            realmVideoDetailsColumnInfo2.idIndex = realmVideoDetailsColumnInfo.idIndex;
            realmVideoDetailsColumnInfo2.playableIndex = realmVideoDetailsColumnInfo.playableIndex;
            realmVideoDetailsColumnInfo2.profileIdIndex = realmVideoDetailsColumnInfo.profileIdIndex;
            realmVideoDetailsColumnInfo2.seasonNumberIndex = realmVideoDetailsColumnInfo.seasonNumberIndex;
            realmVideoDetailsColumnInfo2.seasonLabelsIndex = realmVideoDetailsColumnInfo.seasonLabelsIndex;
            realmVideoDetailsColumnInfo2.errorTypeIndex = realmVideoDetailsColumnInfo.errorTypeIndex;
            realmVideoDetailsColumnInfo2.videoTypeIndex = realmVideoDetailsColumnInfo.videoTypeIndex;
            realmVideoDetailsColumnInfo2.yearIndex = realmVideoDetailsColumnInfo.yearIndex;
            realmVideoDetailsColumnInfo2.maturityLevelIndex = realmVideoDetailsColumnInfo.maturityLevelIndex;
            realmVideoDetailsColumnInfo2.synopsisIndex = realmVideoDetailsColumnInfo.synopsisIndex;
            realmVideoDetailsColumnInfo2.qualityIndex = realmVideoDetailsColumnInfo.qualityIndex;
            realmVideoDetailsColumnInfo2.actorsIndex = realmVideoDetailsColumnInfo.actorsIndex;
            realmVideoDetailsColumnInfo2.genresIndex = realmVideoDetailsColumnInfo.genresIndex;
            realmVideoDetailsColumnInfo2.certIndex = realmVideoDetailsColumnInfo.certIndex;
            realmVideoDetailsColumnInfo2.supplMessageIndex = realmVideoDetailsColumnInfo.supplMessageIndex;
            realmVideoDetailsColumnInfo2.defaultTrailerIndex = realmVideoDetailsColumnInfo.defaultTrailerIndex;
            realmVideoDetailsColumnInfo2.copyrightIndex = realmVideoDetailsColumnInfo.copyrightIndex;
            realmVideoDetailsColumnInfo2.hResPortBoxArtUrlIndex = realmVideoDetailsColumnInfo.hResPortBoxArtUrlIndex;
            realmVideoDetailsColumnInfo2.hResLandBoxArtUrlIndex = realmVideoDetailsColumnInfo.hResLandBoxArtUrlIndex;
            realmVideoDetailsColumnInfo2.boxshotUrlIndex = realmVideoDetailsColumnInfo.boxshotUrlIndex;
            realmVideoDetailsColumnInfo2.boxartImageIdIndex = realmVideoDetailsColumnInfo.boxartImageIdIndex;
            realmVideoDetailsColumnInfo2.horzDispUrlIndex = realmVideoDetailsColumnInfo.horzDispUrlIndex;
            realmVideoDetailsColumnInfo2.horzDispSmallUrlIndex = realmVideoDetailsColumnInfo.horzDispSmallUrlIndex;
            realmVideoDetailsColumnInfo2.storyDispUrlIndex = realmVideoDetailsColumnInfo.storyDispUrlIndex;
            realmVideoDetailsColumnInfo2.tvCardUrlIndex = realmVideoDetailsColumnInfo.tvCardUrlIndex;
            realmVideoDetailsColumnInfo2.storyUrlIndex = realmVideoDetailsColumnInfo.storyUrlIndex;
            realmVideoDetailsColumnInfo2.bifUrlIndex = realmVideoDetailsColumnInfo.bifUrlIndex;
            realmVideoDetailsColumnInfo2.catalogIdUrlIndex = realmVideoDetailsColumnInfo.catalogIdUrlIndex;
            realmVideoDetailsColumnInfo2.titleImgUrlIndex = realmVideoDetailsColumnInfo.titleImgUrlIndex;
            realmVideoDetailsColumnInfo2.titleCroppedImgUrlIndex = realmVideoDetailsColumnInfo.titleCroppedImgUrlIndex;
            realmVideoDetailsColumnInfo2.titleIndex = realmVideoDetailsColumnInfo.titleIndex;
            realmVideoDetailsColumnInfo2.nextEpisodeIdIndex = realmVideoDetailsColumnInfo.nextEpisodeIdIndex;
            realmVideoDetailsColumnInfo2.isOriginalIndex = realmVideoDetailsColumnInfo.isOriginalIndex;
            realmVideoDetailsColumnInfo2.isPreReleaseIndex = realmVideoDetailsColumnInfo.isPreReleaseIndex;
            realmVideoDetailsColumnInfo2.hasWatchedIndex = realmVideoDetailsColumnInfo.hasWatchedIndex;
            realmVideoDetailsColumnInfo2.hasTrailersIndex = realmVideoDetailsColumnInfo.hasTrailersIndex;
            realmVideoDetailsColumnInfo2.isInQueueIndex = realmVideoDetailsColumnInfo.isInQueueIndex;
            realmVideoDetailsColumnInfo2.isVideoHdIndex = realmVideoDetailsColumnInfo.isVideoHdIndex;
            realmVideoDetailsColumnInfo2.isVideoUhdIndex = realmVideoDetailsColumnInfo.isVideoUhdIndex;
            realmVideoDetailsColumnInfo2.isVideo5dot1Index = realmVideoDetailsColumnInfo.isVideo5dot1Index;
            realmVideoDetailsColumnInfo2.isVideoHdr10Index = realmVideoDetailsColumnInfo.isVideoHdr10Index;
            realmVideoDetailsColumnInfo2.isVideoDolbyVisionIndex = realmVideoDetailsColumnInfo.isVideoDolbyVisionIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(42);
        arrayList.add("id");
        arrayList.add("playable");
        arrayList.add("profileId");
        arrayList.add("seasonNumber");
        arrayList.add("seasonLabels");
        arrayList.add("errorType");
        arrayList.add("videoType");
        arrayList.add("year");
        arrayList.add("maturityLevel");
        arrayList.add("synopsis");
        arrayList.add("quality");
        arrayList.add("actors");
        arrayList.add("genres");
        arrayList.add("cert");
        arrayList.add("supplMessage");
        arrayList.add("defaultTrailer");
        arrayList.add("copyright");
        arrayList.add("hResPortBoxArtUrl");
        arrayList.add("hResLandBoxArtUrl");
        arrayList.add("boxshotUrl");
        arrayList.add("boxartImageId");
        arrayList.add("horzDispUrl");
        arrayList.add("horzDispSmallUrl");
        arrayList.add("storyDispUrl");
        arrayList.add("tvCardUrl");
        arrayList.add("storyUrl");
        arrayList.add("bifUrl");
        arrayList.add("catalogIdUrl");
        arrayList.add("titleImgUrl");
        arrayList.add("titleCroppedImgUrl");
        arrayList.add("title");
        arrayList.add("nextEpisodeId");
        arrayList.add("isOriginal");
        arrayList.add("isPreRelease");
        arrayList.add("hasWatched");
        arrayList.add("hasTrailers");
        arrayList.add("isInQueue");
        arrayList.add("isVideoHd");
        arrayList.add("isVideoUhd");
        arrayList.add("isVideo5dot1");
        arrayList.add("isVideoHdr10");
        arrayList.add("isVideoDolbyVision");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    RealmVideoDetailsRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RealmVideoDetailsColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$id() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.idIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public C2092qm realmGet$playable() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.playableIndex)) {
            return null;
        }
        return (C2092qm) this.proxyState.getRealm$realm().get(C2092qm.class, this.proxyState.getRow$realm().getLink(this.columnInfo.playableIndex), false, Collections.emptyList());
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$playable(C2092qm qmVar) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (qmVar == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.playableIndex);
                return;
            }
            this.proxyState.checkValidObject(qmVar);
            this.proxyState.getRow$realm().setLink(this.columnInfo.playableIndex, ((RealmObjectProxy) qmVar).realmGet$proxyState().getRow$realm().getIndex());
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("playable")) {
            if (qmVar != null && !RealmObject.isManaged(qmVar)) {
                qmVar = (C2092qm) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(qmVar);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (qmVar == null) {
                row$realm.nullifyLink(this.columnInfo.playableIndex);
                return;
            }
            this.proxyState.checkValidObject(qmVar);
            row$realm.getTable().setLink(this.columnInfo.playableIndex, row$realm.getIndex(), ((RealmObjectProxy) qmVar).realmGet$proxyState().getRow$realm().getIndex(), true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$profileId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.profileIdIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$profileId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.profileIdIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.profileIdIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.profileIdIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.profileIdIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$seasonNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.seasonNumberIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$seasonNumber(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.seasonNumberIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.seasonNumberIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public RealmList<RealmSeason> realmGet$seasonLabels() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.seasonLabelsRealmList != null) {
            return this.seasonLabelsRealmList;
        }
        this.seasonLabelsRealmList = new RealmList<>(RealmSeason.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.seasonLabelsIndex), this.proxyState.getRealm$realm());
        return this.seasonLabelsRealmList;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x005c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [io.realm.RealmList, io.realm.RealmList<com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason>] */
    /* JADX WARN: Type inference failed for: r9v1, types: [io.realm.RealmList] */
    /* JADX WARN: Type inference failed for: r9v2, types: [io.realm.RealmList] */
    @Override // o.C2098qr
    public void realmSet$seasonLabels(RealmList<RealmSeason> realmList) {
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("seasonLabels")) {
                return;
            }
            if (realmList != 0 && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                realmList = new RealmList<>();
                Iterator it = realmList.iterator();
                while (it.hasNext()) {
                    RealmSeason realmSeason = (RealmSeason) it.next();
                    if (realmSeason == null || RealmObject.isManaged(realmSeason)) {
                        realmList.add(realmSeason);
                    } else {
                        realmList.add(realm.copyToRealm(realmSeason));
                    }
                }
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.seasonLabelsIndex);
        if (realmList == 0 || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != 0) {
                int size = realmList.size();
                for (int i = 0; i < size; i++) {
                    RealmSeason realmSeason2 = (RealmSeason) realmList.get(i);
                    this.proxyState.checkValidObject(realmSeason2);
                    modelList.addRow(((RealmObjectProxy) realmSeason2).realmGet$proxyState().getRow$realm().getIndex());
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            RealmSeason realmSeason3 = (RealmSeason) realmList.get(i2);
            this.proxyState.checkValidObject(realmSeason3);
            modelList.setRow((long) i2, ((RealmObjectProxy) realmSeason3).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$errorType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.errorTypeIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$errorType(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.errorTypeIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.errorTypeIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$videoType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.videoTypeIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$videoType(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.videoTypeIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.videoTypeIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$year() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.yearIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$year(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.yearIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.yearIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$maturityLevel() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.maturityLevelIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$maturityLevel(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.maturityLevelIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.maturityLevelIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$synopsis() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.synopsisIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$synopsis(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.synopsisIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.synopsisIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.synopsisIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.synopsisIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$quality() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.qualityIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$quality(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.qualityIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.qualityIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.qualityIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.qualityIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$actors() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.actorsIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$actors(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.actorsIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.actorsIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.actorsIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.actorsIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$genres() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.genresIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$genres(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.genresIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.genresIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.genresIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.genresIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$cert() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.certIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$cert(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.certIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.certIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.certIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.certIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$supplMessage() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.supplMessageIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$supplMessage(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.supplMessageIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.supplMessageIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.supplMessageIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.supplMessageIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$defaultTrailer() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.defaultTrailerIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$defaultTrailer(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.defaultTrailerIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.defaultTrailerIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.defaultTrailerIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.defaultTrailerIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$copyright() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.copyrightIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$copyright(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.copyrightIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.copyrightIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.copyrightIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.copyrightIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$hResPortBoxArtUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.hResPortBoxArtUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$hResPortBoxArtUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.hResPortBoxArtUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.hResPortBoxArtUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.hResPortBoxArtUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.hResPortBoxArtUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$hResLandBoxArtUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.hResLandBoxArtUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$hResLandBoxArtUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.hResLandBoxArtUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.hResLandBoxArtUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.hResLandBoxArtUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.hResLandBoxArtUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$boxshotUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.boxshotUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$boxshotUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.boxshotUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.boxshotUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.boxshotUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.boxshotUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$boxartImageId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.boxartImageIdIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$boxartImageId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.boxartImageIdIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.boxartImageIdIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.boxartImageIdIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.boxartImageIdIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$horzDispUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.horzDispUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$horzDispUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.horzDispUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.horzDispUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.horzDispUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.horzDispUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$horzDispSmallUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.horzDispSmallUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$horzDispSmallUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.horzDispSmallUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.horzDispSmallUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.horzDispSmallUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.horzDispSmallUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$storyDispUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.storyDispUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$storyDispUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.storyDispUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.storyDispUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.storyDispUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.storyDispUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$tvCardUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.tvCardUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$tvCardUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.tvCardUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.tvCardUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.tvCardUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.tvCardUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$storyUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.storyUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$storyUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.storyUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.storyUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.storyUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.storyUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$bifUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.bifUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$bifUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.bifUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.bifUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.bifUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.bifUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$catalogIdUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.catalogIdUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$catalogIdUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.catalogIdUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.catalogIdUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.catalogIdUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.catalogIdUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$titleImgUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.titleImgUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$titleImgUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.titleImgUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.titleImgUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.titleImgUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.titleImgUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$titleCroppedImgUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.titleCroppedImgUrlIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$titleCroppedImgUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.titleCroppedImgUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.titleCroppedImgUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.titleCroppedImgUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.titleCroppedImgUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$title() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.titleIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$title(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.titleIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.titleIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.titleIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.titleIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$nextEpisodeId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.nextEpisodeIdIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$nextEpisodeId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.nextEpisodeIdIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.nextEpisodeIdIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.nextEpisodeIdIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.nextEpisodeIdIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isOriginal() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isOriginalIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isOriginal(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isOriginalIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isOriginalIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isPreRelease() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isPreReleaseIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isPreRelease(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isPreReleaseIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isPreReleaseIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$hasWatched() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.hasWatchedIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$hasWatched(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.hasWatchedIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.hasWatchedIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$hasTrailers() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.hasTrailersIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$hasTrailers(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.hasTrailersIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.hasTrailersIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isInQueue() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isInQueueIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isInQueue(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isInQueueIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isInQueueIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideoHd() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isVideoHdIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideoHd(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isVideoHdIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isVideoHdIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideoUhd() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isVideoUhdIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideoUhd(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isVideoUhdIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isVideoUhdIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideo5dot1() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isVideo5dot1Index);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideo5dot1(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isVideo5dot1Index, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isVideo5dot1Index, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideoHdr10() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isVideoHdr10Index);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideoHdr10(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isVideoHdr10Index, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isVideoHdr10Index, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideoDolbyVision() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isVideoDolbyVisionIndex);
    }

    @Override // o.C2098qr, io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideoDolbyVision(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isVideoDolbyVisionIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isVideoDolbyVisionIndex, row$realm.getIndex(), z, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmVideoDetails", 42, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, true, true, false);
        builder.addPersistedLinkProperty("playable", RealmFieldType.OBJECT, "RealmPlayable");
        builder.addPersistedProperty("profileId", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("seasonNumber", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedLinkProperty("seasonLabels", RealmFieldType.LIST, "RealmSeason");
        builder.addPersistedProperty("errorType", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("videoType", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("year", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("maturityLevel", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("synopsis", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("quality", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("actors", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("genres", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("cert", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("supplMessage", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("defaultTrailer", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("copyright", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("hResPortBoxArtUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("hResLandBoxArtUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("boxshotUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("boxartImageId", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("horzDispUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("horzDispSmallUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("storyDispUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("tvCardUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("storyUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("bifUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("catalogIdUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("titleImgUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("titleCroppedImgUrl", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("title", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("nextEpisodeId", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("isOriginal", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isPreRelease", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("hasWatched", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("hasTrailers", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isInQueue", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isVideoHd", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isVideoUhd", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isVideo5dot1", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isVideoHdr10", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isVideoDolbyVision", RealmFieldType.BOOLEAN, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmVideoDetailsColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RealmVideoDetailsColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_RealmVideoDetails";
    }

    public static C2098qr copyOrUpdate(Realm realm, C2098qr qrVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        long j;
        if ((qrVar instanceof RealmObjectProxy) && ((RealmObjectProxy) qrVar).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) qrVar).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return qrVar;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(qrVar);
        if (realmObjectProxy != null) {
            return (C2098qr) realmObjectProxy;
        }
        RealmVideoDetailsRealmProxy realmVideoDetailsRealmProxy = null;
        boolean z2 = z;
        if (z2) {
            Table table = realm.getTable(C2098qr.class);
            long j2 = ((RealmVideoDetailsColumnInfo) realm.getSchema().getColumnInfo(C2098qr.class)).idIndex;
            String realmGet$id = qrVar.realmGet$id();
            if (realmGet$id == null) {
                j = table.findFirstNull(j2);
            } else {
                j = table.findFirstString(j2, realmGet$id);
            }
            if (j == -1) {
                z2 = false;
            } else {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(j), realm.getSchema().getColumnInfo(C2098qr.class), false, Collections.emptyList());
                    realmVideoDetailsRealmProxy = new RealmVideoDetailsRealmProxy();
                    map.put(qrVar, realmVideoDetailsRealmProxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        return z2 ? update(realm, realmVideoDetailsRealmProxy, qrVar, map) : copy(realm, qrVar, z, map);
    }

    public static C2098qr copy(Realm realm, C2098qr qrVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(qrVar);
        if (realmObjectProxy != null) {
            return (C2098qr) realmObjectProxy;
        }
        C2098qr qrVar2 = (C2098qr) realm.createObjectInternal(C2098qr.class, qrVar.realmGet$id(), false, Collections.emptyList());
        map.put(qrVar, (RealmObjectProxy) qrVar2);
        C2098qr qrVar3 = qrVar;
        C2098qr qrVar4 = qrVar2;
        C2092qm realmGet$playable = qrVar3.realmGet$playable();
        if (realmGet$playable == null) {
            qrVar4.realmSet$playable(null);
        } else {
            C2092qm qmVar = (C2092qm) map.get(realmGet$playable);
            if (qmVar != null) {
                qrVar4.realmSet$playable(qmVar);
            } else {
                qrVar4.realmSet$playable(RealmPlayableRealmProxy.copyOrUpdate(realm, realmGet$playable, z, map));
            }
        }
        qrVar4.realmSet$profileId(qrVar3.realmGet$profileId());
        qrVar4.realmSet$seasonNumber(qrVar3.realmGet$seasonNumber());
        RealmList<RealmSeason> realmGet$seasonLabels = qrVar3.realmGet$seasonLabels();
        if (realmGet$seasonLabels != null) {
            RealmList<RealmSeason> realmGet$seasonLabels2 = qrVar4.realmGet$seasonLabels();
            realmGet$seasonLabels2.clear();
            for (int i = 0; i < realmGet$seasonLabels.size(); i++) {
                RealmSeason realmSeason = realmGet$seasonLabels.get(i);
                RealmSeason realmSeason2 = (RealmSeason) map.get(realmSeason);
                if (realmSeason2 != null) {
                    realmGet$seasonLabels2.add(realmSeason2);
                } else {
                    realmGet$seasonLabels2.add(RealmSeasonRealmProxy.copyOrUpdate(realm, realmSeason, z, map));
                }
            }
        }
        qrVar4.realmSet$errorType(qrVar3.realmGet$errorType());
        qrVar4.realmSet$videoType(qrVar3.realmGet$videoType());
        qrVar4.realmSet$year(qrVar3.realmGet$year());
        qrVar4.realmSet$maturityLevel(qrVar3.realmGet$maturityLevel());
        qrVar4.realmSet$synopsis(qrVar3.realmGet$synopsis());
        qrVar4.realmSet$quality(qrVar3.realmGet$quality());
        qrVar4.realmSet$actors(qrVar3.realmGet$actors());
        qrVar4.realmSet$genres(qrVar3.realmGet$genres());
        qrVar4.realmSet$cert(qrVar3.realmGet$cert());
        qrVar4.realmSet$supplMessage(qrVar3.realmGet$supplMessage());
        qrVar4.realmSet$defaultTrailer(qrVar3.realmGet$defaultTrailer());
        qrVar4.realmSet$copyright(qrVar3.realmGet$copyright());
        qrVar4.realmSet$hResPortBoxArtUrl(qrVar3.realmGet$hResPortBoxArtUrl());
        qrVar4.realmSet$hResLandBoxArtUrl(qrVar3.realmGet$hResLandBoxArtUrl());
        qrVar4.realmSet$boxshotUrl(qrVar3.realmGet$boxshotUrl());
        qrVar4.realmSet$boxartImageId(qrVar3.realmGet$boxartImageId());
        qrVar4.realmSet$horzDispUrl(qrVar3.realmGet$horzDispUrl());
        qrVar4.realmSet$horzDispSmallUrl(qrVar3.realmGet$horzDispSmallUrl());
        qrVar4.realmSet$storyDispUrl(qrVar3.realmGet$storyDispUrl());
        qrVar4.realmSet$tvCardUrl(qrVar3.realmGet$tvCardUrl());
        qrVar4.realmSet$storyUrl(qrVar3.realmGet$storyUrl());
        qrVar4.realmSet$bifUrl(qrVar3.realmGet$bifUrl());
        qrVar4.realmSet$catalogIdUrl(qrVar3.realmGet$catalogIdUrl());
        qrVar4.realmSet$titleImgUrl(qrVar3.realmGet$titleImgUrl());
        qrVar4.realmSet$titleCroppedImgUrl(qrVar3.realmGet$titleCroppedImgUrl());
        qrVar4.realmSet$title(qrVar3.realmGet$title());
        qrVar4.realmSet$nextEpisodeId(qrVar3.realmGet$nextEpisodeId());
        qrVar4.realmSet$isOriginal(qrVar3.realmGet$isOriginal());
        qrVar4.realmSet$isPreRelease(qrVar3.realmGet$isPreRelease());
        qrVar4.realmSet$hasWatched(qrVar3.realmGet$hasWatched());
        qrVar4.realmSet$hasTrailers(qrVar3.realmGet$hasTrailers());
        qrVar4.realmSet$isInQueue(qrVar3.realmGet$isInQueue());
        qrVar4.realmSet$isVideoHd(qrVar3.realmGet$isVideoHd());
        qrVar4.realmSet$isVideoUhd(qrVar3.realmGet$isVideoUhd());
        qrVar4.realmSet$isVideo5dot1(qrVar3.realmGet$isVideo5dot1());
        qrVar4.realmSet$isVideoHdr10(qrVar3.realmGet$isVideoHdr10());
        qrVar4.realmSet$isVideoDolbyVision(qrVar3.realmGet$isVideoDolbyVision());
        return qrVar2;
    }

    static C2098qr update(Realm realm, C2098qr qrVar, C2098qr qrVar2, Map<RealmModel, RealmObjectProxy> map) {
        C2098qr qrVar3 = qrVar;
        C2098qr qrVar4 = qrVar2;
        C2092qm realmGet$playable = qrVar4.realmGet$playable();
        if (realmGet$playable == null) {
            qrVar3.realmSet$playable(null);
        } else {
            C2092qm qmVar = (C2092qm) map.get(realmGet$playable);
            if (qmVar != null) {
                qrVar3.realmSet$playable(qmVar);
            } else {
                qrVar3.realmSet$playable(RealmPlayableRealmProxy.copyOrUpdate(realm, realmGet$playable, true, map));
            }
        }
        qrVar3.realmSet$profileId(qrVar4.realmGet$profileId());
        qrVar3.realmSet$seasonNumber(qrVar4.realmGet$seasonNumber());
        RealmList<RealmSeason> realmGet$seasonLabels = qrVar4.realmGet$seasonLabels();
        RealmList<RealmSeason> realmGet$seasonLabels2 = qrVar3.realmGet$seasonLabels();
        if (realmGet$seasonLabels == null || realmGet$seasonLabels.size() != realmGet$seasonLabels2.size()) {
            realmGet$seasonLabels2.clear();
            if (realmGet$seasonLabels != null) {
                for (int i = 0; i < realmGet$seasonLabels.size(); i++) {
                    RealmSeason realmSeason = realmGet$seasonLabels.get(i);
                    RealmSeason realmSeason2 = (RealmSeason) map.get(realmSeason);
                    if (realmSeason2 != null) {
                        realmGet$seasonLabels2.add(realmSeason2);
                    } else {
                        realmGet$seasonLabels2.add(RealmSeasonRealmProxy.copyOrUpdate(realm, realmSeason, true, map));
                    }
                }
            }
        } else {
            int size = realmGet$seasonLabels.size();
            for (int i2 = 0; i2 < size; i2++) {
                RealmSeason realmSeason3 = realmGet$seasonLabels.get(i2);
                RealmSeason realmSeason4 = (RealmSeason) map.get(realmSeason3);
                if (realmSeason4 != null) {
                    realmGet$seasonLabels2.set(i2, realmSeason4);
                } else {
                    realmGet$seasonLabels2.set(i2, RealmSeasonRealmProxy.copyOrUpdate(realm, realmSeason3, true, map));
                }
            }
        }
        qrVar3.realmSet$errorType(qrVar4.realmGet$errorType());
        qrVar3.realmSet$videoType(qrVar4.realmGet$videoType());
        qrVar3.realmSet$year(qrVar4.realmGet$year());
        qrVar3.realmSet$maturityLevel(qrVar4.realmGet$maturityLevel());
        qrVar3.realmSet$synopsis(qrVar4.realmGet$synopsis());
        qrVar3.realmSet$quality(qrVar4.realmGet$quality());
        qrVar3.realmSet$actors(qrVar4.realmGet$actors());
        qrVar3.realmSet$genres(qrVar4.realmGet$genres());
        qrVar3.realmSet$cert(qrVar4.realmGet$cert());
        qrVar3.realmSet$supplMessage(qrVar4.realmGet$supplMessage());
        qrVar3.realmSet$defaultTrailer(qrVar4.realmGet$defaultTrailer());
        qrVar3.realmSet$copyright(qrVar4.realmGet$copyright());
        qrVar3.realmSet$hResPortBoxArtUrl(qrVar4.realmGet$hResPortBoxArtUrl());
        qrVar3.realmSet$hResLandBoxArtUrl(qrVar4.realmGet$hResLandBoxArtUrl());
        qrVar3.realmSet$boxshotUrl(qrVar4.realmGet$boxshotUrl());
        qrVar3.realmSet$boxartImageId(qrVar4.realmGet$boxartImageId());
        qrVar3.realmSet$horzDispUrl(qrVar4.realmGet$horzDispUrl());
        qrVar3.realmSet$horzDispSmallUrl(qrVar4.realmGet$horzDispSmallUrl());
        qrVar3.realmSet$storyDispUrl(qrVar4.realmGet$storyDispUrl());
        qrVar3.realmSet$tvCardUrl(qrVar4.realmGet$tvCardUrl());
        qrVar3.realmSet$storyUrl(qrVar4.realmGet$storyUrl());
        qrVar3.realmSet$bifUrl(qrVar4.realmGet$bifUrl());
        qrVar3.realmSet$catalogIdUrl(qrVar4.realmGet$catalogIdUrl());
        qrVar3.realmSet$titleImgUrl(qrVar4.realmGet$titleImgUrl());
        qrVar3.realmSet$titleCroppedImgUrl(qrVar4.realmGet$titleCroppedImgUrl());
        qrVar3.realmSet$title(qrVar4.realmGet$title());
        qrVar3.realmSet$nextEpisodeId(qrVar4.realmGet$nextEpisodeId());
        qrVar3.realmSet$isOriginal(qrVar4.realmGet$isOriginal());
        qrVar3.realmSet$isPreRelease(qrVar4.realmGet$isPreRelease());
        qrVar3.realmSet$hasWatched(qrVar4.realmGet$hasWatched());
        qrVar3.realmSet$hasTrailers(qrVar4.realmGet$hasTrailers());
        qrVar3.realmSet$isInQueue(qrVar4.realmGet$isInQueue());
        qrVar3.realmSet$isVideoHd(qrVar4.realmGet$isVideoHd());
        qrVar3.realmSet$isVideoUhd(qrVar4.realmGet$isVideoUhd());
        qrVar3.realmSet$isVideo5dot1(qrVar4.realmGet$isVideo5dot1());
        qrVar3.realmSet$isVideoHdr10(qrVar4.realmGet$isVideoHdr10());
        qrVar3.realmSet$isVideoDolbyVision(qrVar4.realmGet$isVideoDolbyVision());
        return qrVar;
    }

    @Override // io.realm.internal.RealmObjectProxy
    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int hashCode() {
        String path = this.proxyState.getRealm$realm().getPath();
        String name = this.proxyState.getRow$realm().getTable().getName();
        long index = this.proxyState.getRow$realm().getIndex();
        return (((((path != null ? path.hashCode() : 0) + 527) * 31) + (name != null ? name.hashCode() : 0)) * 31) + ((int) ((index >>> 32) ^ index));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RealmVideoDetailsRealmProxy realmVideoDetailsRealmProxy = (RealmVideoDetailsRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = realmVideoDetailsRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = realmVideoDetailsRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != realmVideoDetailsRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
