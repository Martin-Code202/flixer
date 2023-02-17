package io.realm;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import io.realm.BaseRealm;
import io.realm.exceptions.RealmException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import o.C2092qm;
public class RealmPlayableRealmProxy extends C2092qm implements RealmObjectProxy {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmPlayableColumnInfo columnInfo;
    private ProxyState<C2092qm> proxyState;

    static final class RealmPlayableColumnInfo extends ColumnInfo {
        long advisoriesStringIndex;
        long bookmarkIndex;
        long durationIndex;
        long endtimeIndex;
        long episodeNumberHiddenIndex;
        long episodeNumberIndex;
        long expTimeIndex;
        long isAdvisoryDisabledIndex;
        long isAgeProtectedIndex;
        long isAutoPlayIndex;
        long isAvailableToStreamIndex;
        long isEpisodeIndex;
        long isNSREIndex;
        long isNextPlayableEpisodeIndex;
        long isPinProtectedIndex;
        long isPreviewProtectedIndex;
        long isSupplementalVideoIndex;
        long logicalStartIndex;
        long maxAutoplayIndex;
        long parentIdIndex;
        long parentTitleIndex;
        long playableIdIndex;
        long seasonLabelIndex;
        long seasonNumberIndex;
        long supportsPrePlayIndex;
        long titleIndex;
        long watchedTimeIndex;

        RealmPlayableColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(27);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("RealmPlayable");
            this.playableIdIndex = addColumnDetails("playableId", objectSchemaInfo);
            this.parentIdIndex = addColumnDetails("parentId", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", objectSchemaInfo);
            this.seasonLabelIndex = addColumnDetails("seasonLabel", objectSchemaInfo);
            this.parentTitleIndex = addColumnDetails("parentTitle", objectSchemaInfo);
            this.advisoriesStringIndex = addColumnDetails("advisoriesString", objectSchemaInfo);
            this.isEpisodeIndex = addColumnDetails("isEpisode", objectSchemaInfo);
            this.isNSREIndex = addColumnDetails("isNSRE", objectSchemaInfo);
            this.isAutoPlayIndex = addColumnDetails("isAutoPlay", objectSchemaInfo);
            this.isNextPlayableEpisodeIndex = addColumnDetails("isNextPlayableEpisode", objectSchemaInfo);
            this.isAgeProtectedIndex = addColumnDetails("isAgeProtected", objectSchemaInfo);
            this.isPinProtectedIndex = addColumnDetails("isPinProtected", objectSchemaInfo);
            this.isPreviewProtectedIndex = addColumnDetails("isPreviewProtected", objectSchemaInfo);
            this.isAdvisoryDisabledIndex = addColumnDetails("isAdvisoryDisabled", objectSchemaInfo);
            this.isAvailableToStreamIndex = addColumnDetails("isAvailableToStream", objectSchemaInfo);
            this.isSupplementalVideoIndex = addColumnDetails("isSupplementalVideo", objectSchemaInfo);
            this.durationIndex = addColumnDetails(SessionEndedEvent.DURATION, objectSchemaInfo);
            this.seasonNumberIndex = addColumnDetails("seasonNumber", objectSchemaInfo);
            this.episodeNumberIndex = addColumnDetails("episodeNumber", objectSchemaInfo);
            this.logicalStartIndex = addColumnDetails("logicalStart", objectSchemaInfo);
            this.endtimeIndex = addColumnDetails("endtime", objectSchemaInfo);
            this.maxAutoplayIndex = addColumnDetails("maxAutoplay", objectSchemaInfo);
            this.expTimeIndex = addColumnDetails("expTime", objectSchemaInfo);
            this.watchedTimeIndex = addColumnDetails("watchedTime", objectSchemaInfo);
            this.bookmarkIndex = addColumnDetails("bookmark", objectSchemaInfo);
            this.supportsPrePlayIndex = addColumnDetails("supportsPrePlay", objectSchemaInfo);
            this.episodeNumberHiddenIndex = addColumnDetails("episodeNumberHidden", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RealmPlayableColumnInfo realmPlayableColumnInfo = (RealmPlayableColumnInfo) columnInfo;
            RealmPlayableColumnInfo realmPlayableColumnInfo2 = (RealmPlayableColumnInfo) columnInfo2;
            realmPlayableColumnInfo2.playableIdIndex = realmPlayableColumnInfo.playableIdIndex;
            realmPlayableColumnInfo2.parentIdIndex = realmPlayableColumnInfo.parentIdIndex;
            realmPlayableColumnInfo2.titleIndex = realmPlayableColumnInfo.titleIndex;
            realmPlayableColumnInfo2.seasonLabelIndex = realmPlayableColumnInfo.seasonLabelIndex;
            realmPlayableColumnInfo2.parentTitleIndex = realmPlayableColumnInfo.parentTitleIndex;
            realmPlayableColumnInfo2.advisoriesStringIndex = realmPlayableColumnInfo.advisoriesStringIndex;
            realmPlayableColumnInfo2.isEpisodeIndex = realmPlayableColumnInfo.isEpisodeIndex;
            realmPlayableColumnInfo2.isNSREIndex = realmPlayableColumnInfo.isNSREIndex;
            realmPlayableColumnInfo2.isAutoPlayIndex = realmPlayableColumnInfo.isAutoPlayIndex;
            realmPlayableColumnInfo2.isNextPlayableEpisodeIndex = realmPlayableColumnInfo.isNextPlayableEpisodeIndex;
            realmPlayableColumnInfo2.isAgeProtectedIndex = realmPlayableColumnInfo.isAgeProtectedIndex;
            realmPlayableColumnInfo2.isPinProtectedIndex = realmPlayableColumnInfo.isPinProtectedIndex;
            realmPlayableColumnInfo2.isPreviewProtectedIndex = realmPlayableColumnInfo.isPreviewProtectedIndex;
            realmPlayableColumnInfo2.isAdvisoryDisabledIndex = realmPlayableColumnInfo.isAdvisoryDisabledIndex;
            realmPlayableColumnInfo2.isAvailableToStreamIndex = realmPlayableColumnInfo.isAvailableToStreamIndex;
            realmPlayableColumnInfo2.isSupplementalVideoIndex = realmPlayableColumnInfo.isSupplementalVideoIndex;
            realmPlayableColumnInfo2.durationIndex = realmPlayableColumnInfo.durationIndex;
            realmPlayableColumnInfo2.seasonNumberIndex = realmPlayableColumnInfo.seasonNumberIndex;
            realmPlayableColumnInfo2.episodeNumberIndex = realmPlayableColumnInfo.episodeNumberIndex;
            realmPlayableColumnInfo2.logicalStartIndex = realmPlayableColumnInfo.logicalStartIndex;
            realmPlayableColumnInfo2.endtimeIndex = realmPlayableColumnInfo.endtimeIndex;
            realmPlayableColumnInfo2.maxAutoplayIndex = realmPlayableColumnInfo.maxAutoplayIndex;
            realmPlayableColumnInfo2.expTimeIndex = realmPlayableColumnInfo.expTimeIndex;
            realmPlayableColumnInfo2.watchedTimeIndex = realmPlayableColumnInfo.watchedTimeIndex;
            realmPlayableColumnInfo2.bookmarkIndex = realmPlayableColumnInfo.bookmarkIndex;
            realmPlayableColumnInfo2.supportsPrePlayIndex = realmPlayableColumnInfo.supportsPrePlayIndex;
            realmPlayableColumnInfo2.episodeNumberHiddenIndex = realmPlayableColumnInfo.episodeNumberHiddenIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(27);
        arrayList.add("playableId");
        arrayList.add("parentId");
        arrayList.add("title");
        arrayList.add("seasonLabel");
        arrayList.add("parentTitle");
        arrayList.add("advisoriesString");
        arrayList.add("isEpisode");
        arrayList.add("isNSRE");
        arrayList.add("isAutoPlay");
        arrayList.add("isNextPlayableEpisode");
        arrayList.add("isAgeProtected");
        arrayList.add("isPinProtected");
        arrayList.add("isPreviewProtected");
        arrayList.add("isAdvisoryDisabled");
        arrayList.add("isAvailableToStream");
        arrayList.add("isSupplementalVideo");
        arrayList.add(SessionEndedEvent.DURATION);
        arrayList.add("seasonNumber");
        arrayList.add("episodeNumber");
        arrayList.add("logicalStart");
        arrayList.add("endtime");
        arrayList.add("maxAutoplay");
        arrayList.add("expTime");
        arrayList.add("watchedTime");
        arrayList.add("bookmark");
        arrayList.add("supportsPrePlay");
        arrayList.add("episodeNumberHidden");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    RealmPlayableRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RealmPlayableColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$playableId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.playableIdIndex);
    }

    @Override // o.C2092qm
    public void realmSet$playableId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'playableId' cannot be changed after object was created.");
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$parentId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.parentIdIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$parentId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.parentIdIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.parentIdIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.parentIdIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.parentIdIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$title() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.titleIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
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

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$seasonLabel() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.seasonLabelIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$seasonLabel(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.seasonLabelIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.seasonLabelIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.seasonLabelIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.seasonLabelIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$parentTitle() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.parentTitleIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$parentTitle(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.parentTitleIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.parentTitleIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.parentTitleIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.parentTitleIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$advisoriesString() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.advisoriesStringIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$advisoriesString(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.advisoriesStringIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.advisoriesStringIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.advisoriesStringIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.advisoriesStringIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isEpisode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isEpisodeIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isEpisode(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isEpisodeIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isEpisodeIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isNSRE() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isNSREIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isNSRE(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isNSREIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isNSREIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isAutoPlay() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isAutoPlayIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isAutoPlay(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isAutoPlayIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isAutoPlayIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isNextPlayableEpisode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isNextPlayableEpisodeIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isNextPlayableEpisode(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isNextPlayableEpisodeIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isNextPlayableEpisodeIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isAgeProtected() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isAgeProtectedIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isAgeProtected(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isAgeProtectedIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isAgeProtectedIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isPinProtected() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isPinProtectedIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isPinProtected(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isPinProtectedIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isPinProtectedIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isPreviewProtected() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isPreviewProtectedIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isPreviewProtected(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isPreviewProtectedIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isPreviewProtectedIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isAdvisoryDisabled() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isAdvisoryDisabledIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isAdvisoryDisabled(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isAdvisoryDisabledIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isAdvisoryDisabledIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isAvailableToStream() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isAvailableToStreamIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isAvailableToStream(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isAvailableToStreamIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isAvailableToStreamIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isSupplementalVideo() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isSupplementalVideoIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isSupplementalVideo(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isSupplementalVideoIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isSupplementalVideoIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$duration() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.durationIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$duration(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.durationIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.durationIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$seasonNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.seasonNumberIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$seasonNumber(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.seasonNumberIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.seasonNumberIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$episodeNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.episodeNumberIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$episodeNumber(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.episodeNumberIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.episodeNumberIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$logicalStart() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.logicalStartIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$logicalStart(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.logicalStartIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.logicalStartIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$endtime() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.endtimeIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$endtime(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.endtimeIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.endtimeIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$maxAutoplay() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.maxAutoplayIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$maxAutoplay(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.maxAutoplayIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.maxAutoplayIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public long realmGet$expTime() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.expTimeIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$expTime(long j) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.expTimeIndex, j);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.expTimeIndex, row$realm.getIndex(), j, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public long realmGet$watchedTime() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.watchedTimeIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$watchedTime(long j) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.watchedTimeIndex, j);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.watchedTimeIndex, row$realm.getIndex(), j, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$bookmark() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.bookmarkIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$bookmark(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.bookmarkIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.bookmarkIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$supportsPrePlay() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.supportsPrePlayIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$supportsPrePlay(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.supportsPrePlayIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.supportsPrePlayIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$episodeNumberHidden() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.episodeNumberHiddenIndex);
    }

    @Override // o.C2092qm, io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$episodeNumberHidden(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.episodeNumberHiddenIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.episodeNumberHiddenIndex, row$realm.getIndex(), z, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmPlayable", 27, 0);
        builder.addPersistedProperty("playableId", RealmFieldType.STRING, true, true, false);
        builder.addPersistedProperty("parentId", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("title", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("seasonLabel", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("parentTitle", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("advisoriesString", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("isEpisode", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isNSRE", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isAutoPlay", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isNextPlayableEpisode", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isAgeProtected", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isPinProtected", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isPreviewProtected", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isAdvisoryDisabled", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isAvailableToStream", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("isSupplementalVideo", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty(SessionEndedEvent.DURATION, RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("seasonNumber", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("episodeNumber", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("logicalStart", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("endtime", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("maxAutoplay", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("expTime", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("watchedTime", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("bookmark", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("supportsPrePlay", RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("episodeNumberHidden", RealmFieldType.BOOLEAN, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmPlayableColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RealmPlayableColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_RealmPlayable";
    }

    public static C2092qm copyOrUpdate(Realm realm, C2092qm qmVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        long j;
        if ((qmVar instanceof RealmObjectProxy) && ((RealmObjectProxy) qmVar).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) qmVar).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return qmVar;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(qmVar);
        if (realmObjectProxy != null) {
            return (C2092qm) realmObjectProxy;
        }
        RealmPlayableRealmProxy realmPlayableRealmProxy = null;
        boolean z2 = z;
        if (z2) {
            Table table = realm.getTable(C2092qm.class);
            long j2 = ((RealmPlayableColumnInfo) realm.getSchema().getColumnInfo(C2092qm.class)).playableIdIndex;
            String realmGet$playableId = qmVar.realmGet$playableId();
            if (realmGet$playableId == null) {
                j = table.findFirstNull(j2);
            } else {
                j = table.findFirstString(j2, realmGet$playableId);
            }
            if (j == -1) {
                z2 = false;
            } else {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(j), realm.getSchema().getColumnInfo(C2092qm.class), false, Collections.emptyList());
                    realmPlayableRealmProxy = new RealmPlayableRealmProxy();
                    map.put(qmVar, realmPlayableRealmProxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        return z2 ? update(realm, realmPlayableRealmProxy, qmVar, map) : copy(realm, qmVar, z, map);
    }

    public static C2092qm copy(Realm realm, C2092qm qmVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(qmVar);
        if (realmObjectProxy != null) {
            return (C2092qm) realmObjectProxy;
        }
        C2092qm qmVar2 = (C2092qm) realm.createObjectInternal(C2092qm.class, qmVar.realmGet$playableId(), false, Collections.emptyList());
        map.put(qmVar, (RealmObjectProxy) qmVar2);
        C2092qm qmVar3 = qmVar;
        C2092qm qmVar4 = qmVar2;
        qmVar4.realmSet$parentId(qmVar3.realmGet$parentId());
        qmVar4.realmSet$title(qmVar3.realmGet$title());
        qmVar4.realmSet$seasonLabel(qmVar3.realmGet$seasonLabel());
        qmVar4.realmSet$parentTitle(qmVar3.realmGet$parentTitle());
        qmVar4.realmSet$advisoriesString(qmVar3.realmGet$advisoriesString());
        qmVar4.realmSet$isEpisode(qmVar3.realmGet$isEpisode());
        qmVar4.realmSet$isNSRE(qmVar3.realmGet$isNSRE());
        qmVar4.realmSet$isAutoPlay(qmVar3.realmGet$isAutoPlay());
        qmVar4.realmSet$isNextPlayableEpisode(qmVar3.realmGet$isNextPlayableEpisode());
        qmVar4.realmSet$isAgeProtected(qmVar3.realmGet$isAgeProtected());
        qmVar4.realmSet$isPinProtected(qmVar3.realmGet$isPinProtected());
        qmVar4.realmSet$isPreviewProtected(qmVar3.realmGet$isPreviewProtected());
        qmVar4.realmSet$isAdvisoryDisabled(qmVar3.realmGet$isAdvisoryDisabled());
        qmVar4.realmSet$isAvailableToStream(qmVar3.realmGet$isAvailableToStream());
        qmVar4.realmSet$isSupplementalVideo(qmVar3.realmGet$isSupplementalVideo());
        qmVar4.realmSet$duration(qmVar3.realmGet$duration());
        qmVar4.realmSet$seasonNumber(qmVar3.realmGet$seasonNumber());
        qmVar4.realmSet$episodeNumber(qmVar3.realmGet$episodeNumber());
        qmVar4.realmSet$logicalStart(qmVar3.realmGet$logicalStart());
        qmVar4.realmSet$endtime(qmVar3.realmGet$endtime());
        qmVar4.realmSet$maxAutoplay(qmVar3.realmGet$maxAutoplay());
        qmVar4.realmSet$expTime(qmVar3.realmGet$expTime());
        qmVar4.realmSet$watchedTime(qmVar3.realmGet$watchedTime());
        qmVar4.realmSet$bookmark(qmVar3.realmGet$bookmark());
        qmVar4.realmSet$supportsPrePlay(qmVar3.realmGet$supportsPrePlay());
        qmVar4.realmSet$episodeNumberHidden(qmVar3.realmGet$episodeNumberHidden());
        return qmVar2;
    }

    static C2092qm update(Realm realm, C2092qm qmVar, C2092qm qmVar2, Map<RealmModel, RealmObjectProxy> map) {
        C2092qm qmVar3 = qmVar;
        C2092qm qmVar4 = qmVar2;
        qmVar3.realmSet$parentId(qmVar4.realmGet$parentId());
        qmVar3.realmSet$title(qmVar4.realmGet$title());
        qmVar3.realmSet$seasonLabel(qmVar4.realmGet$seasonLabel());
        qmVar3.realmSet$parentTitle(qmVar4.realmGet$parentTitle());
        qmVar3.realmSet$advisoriesString(qmVar4.realmGet$advisoriesString());
        qmVar3.realmSet$isEpisode(qmVar4.realmGet$isEpisode());
        qmVar3.realmSet$isNSRE(qmVar4.realmGet$isNSRE());
        qmVar3.realmSet$isAutoPlay(qmVar4.realmGet$isAutoPlay());
        qmVar3.realmSet$isNextPlayableEpisode(qmVar4.realmGet$isNextPlayableEpisode());
        qmVar3.realmSet$isAgeProtected(qmVar4.realmGet$isAgeProtected());
        qmVar3.realmSet$isPinProtected(qmVar4.realmGet$isPinProtected());
        qmVar3.realmSet$isPreviewProtected(qmVar4.realmGet$isPreviewProtected());
        qmVar3.realmSet$isAdvisoryDisabled(qmVar4.realmGet$isAdvisoryDisabled());
        qmVar3.realmSet$isAvailableToStream(qmVar4.realmGet$isAvailableToStream());
        qmVar3.realmSet$isSupplementalVideo(qmVar4.realmGet$isSupplementalVideo());
        qmVar3.realmSet$duration(qmVar4.realmGet$duration());
        qmVar3.realmSet$seasonNumber(qmVar4.realmGet$seasonNumber());
        qmVar3.realmSet$episodeNumber(qmVar4.realmGet$episodeNumber());
        qmVar3.realmSet$logicalStart(qmVar4.realmGet$logicalStart());
        qmVar3.realmSet$endtime(qmVar4.realmGet$endtime());
        qmVar3.realmSet$maxAutoplay(qmVar4.realmGet$maxAutoplay());
        qmVar3.realmSet$expTime(qmVar4.realmGet$expTime());
        qmVar3.realmSet$watchedTime(qmVar4.realmGet$watchedTime());
        qmVar3.realmSet$bookmark(qmVar4.realmGet$bookmark());
        qmVar3.realmSet$supportsPrePlay(qmVar4.realmGet$supportsPrePlay());
        qmVar3.realmSet$episodeNumberHidden(qmVar4.realmGet$episodeNumberHidden());
        return qmVar;
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
        RealmPlayableRealmProxy realmPlayableRealmProxy = (RealmPlayableRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = realmPlayableRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = realmPlayableRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != realmPlayableRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
