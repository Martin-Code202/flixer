package io.realm;

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
import o.C2100qt;
public class RealmWatchedEpisodeRealmProxy extends C2100qt implements RealmObjectProxy {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmWatchedEpisodeColumnInfo columnInfo;
    private ProxyState<C2100qt> proxyState;

    /* access modifiers changed from: package-private */
    public static final class RealmWatchedEpisodeColumnInfo extends ColumnInfo {
        long episodeIdIndex;
        long episodeNumberIndex;
        long episodeSmartDownloadedIdIndex;
        long seasonNumberIndex;
        long showIdIndex;

        RealmWatchedEpisodeColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("RealmWatchedEpisode");
            this.episodeIdIndex = addColumnDetails("episodeId", objectSchemaInfo);
            this.episodeSmartDownloadedIdIndex = addColumnDetails("episodeSmartDownloadedId", objectSchemaInfo);
            this.showIdIndex = addColumnDetails("showId", objectSchemaInfo);
            this.seasonNumberIndex = addColumnDetails("seasonNumber", objectSchemaInfo);
            this.episodeNumberIndex = addColumnDetails("episodeNumber", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RealmWatchedEpisodeColumnInfo realmWatchedEpisodeColumnInfo = (RealmWatchedEpisodeColumnInfo) columnInfo;
            RealmWatchedEpisodeColumnInfo realmWatchedEpisodeColumnInfo2 = (RealmWatchedEpisodeColumnInfo) columnInfo2;
            realmWatchedEpisodeColumnInfo2.episodeIdIndex = realmWatchedEpisodeColumnInfo.episodeIdIndex;
            realmWatchedEpisodeColumnInfo2.episodeSmartDownloadedIdIndex = realmWatchedEpisodeColumnInfo.episodeSmartDownloadedIdIndex;
            realmWatchedEpisodeColumnInfo2.showIdIndex = realmWatchedEpisodeColumnInfo.showIdIndex;
            realmWatchedEpisodeColumnInfo2.seasonNumberIndex = realmWatchedEpisodeColumnInfo.seasonNumberIndex;
            realmWatchedEpisodeColumnInfo2.episodeNumberIndex = realmWatchedEpisodeColumnInfo.episodeNumberIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add("episodeId");
        arrayList.add("episodeSmartDownloadedId");
        arrayList.add("showId");
        arrayList.add("seasonNumber");
        arrayList.add("episodeNumber");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    RealmWatchedEpisodeRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RealmWatchedEpisodeColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public String realmGet$episodeId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.episodeIdIndex);
    }

    @Override // o.C2100qt
    public void realmSet$episodeId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'episodeId' cannot be changed after object was created.");
        }
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public String realmGet$episodeSmartDownloadedId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.episodeSmartDownloadedIdIndex);
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public void realmSet$episodeSmartDownloadedId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.episodeSmartDownloadedIdIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.episodeSmartDownloadedIdIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.episodeSmartDownloadedIdIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.episodeSmartDownloadedIdIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public String realmGet$showId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.showIdIndex);
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public void realmSet$showId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.showIdIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.showIdIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.showIdIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.showIdIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public int realmGet$seasonNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.seasonNumberIndex);
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public void realmSet$seasonNumber(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.seasonNumberIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.seasonNumberIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public int realmGet$episodeNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.episodeNumberIndex);
    }

    @Override // o.C2100qt, io.realm.RealmWatchedEpisodeRealmProxyInterface
    public void realmSet$episodeNumber(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.episodeNumberIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.episodeNumberIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmWatchedEpisode", 5, 0);
        builder.addPersistedProperty("episodeId", RealmFieldType.STRING, true, true, false);
        builder.addPersistedProperty("episodeSmartDownloadedId", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("showId", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("seasonNumber", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("episodeNumber", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmWatchedEpisodeColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RealmWatchedEpisodeColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_RealmWatchedEpisode";
    }

    public static C2100qt copyOrUpdate(Realm realm, C2100qt qtVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        long j;
        if ((qtVar instanceof RealmObjectProxy) && ((RealmObjectProxy) qtVar).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) qtVar).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return qtVar;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(qtVar);
        if (realmObjectProxy != null) {
            return (C2100qt) realmObjectProxy;
        }
        RealmWatchedEpisodeRealmProxy realmWatchedEpisodeRealmProxy = null;
        boolean z2 = z;
        if (z2) {
            Table table = realm.getTable(C2100qt.class);
            long j2 = ((RealmWatchedEpisodeColumnInfo) realm.getSchema().getColumnInfo(C2100qt.class)).episodeIdIndex;
            String realmGet$episodeId = qtVar.realmGet$episodeId();
            if (realmGet$episodeId == null) {
                j = table.findFirstNull(j2);
            } else {
                j = table.findFirstString(j2, realmGet$episodeId);
            }
            if (j == -1) {
                z2 = false;
            } else {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(j), realm.getSchema().getColumnInfo(C2100qt.class), false, Collections.emptyList());
                    realmWatchedEpisodeRealmProxy = new RealmWatchedEpisodeRealmProxy();
                    map.put(qtVar, realmWatchedEpisodeRealmProxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        return z2 ? update(realm, realmWatchedEpisodeRealmProxy, qtVar, map) : copy(realm, qtVar, z, map);
    }

    public static C2100qt copy(Realm realm, C2100qt qtVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(qtVar);
        if (realmObjectProxy != null) {
            return (C2100qt) realmObjectProxy;
        }
        C2100qt qtVar2 = (C2100qt) realm.createObjectInternal(C2100qt.class, qtVar.realmGet$episodeId(), false, Collections.emptyList());
        map.put(qtVar, (RealmObjectProxy) qtVar2);
        C2100qt qtVar3 = qtVar;
        C2100qt qtVar4 = qtVar2;
        qtVar4.realmSet$episodeSmartDownloadedId(qtVar3.realmGet$episodeSmartDownloadedId());
        qtVar4.realmSet$showId(qtVar3.realmGet$showId());
        qtVar4.realmSet$seasonNumber(qtVar3.realmGet$seasonNumber());
        qtVar4.realmSet$episodeNumber(qtVar3.realmGet$episodeNumber());
        return qtVar2;
    }

    static C2100qt update(Realm realm, C2100qt qtVar, C2100qt qtVar2, Map<RealmModel, RealmObjectProxy> map) {
        C2100qt qtVar3 = qtVar;
        C2100qt qtVar4 = qtVar2;
        qtVar3.realmSet$episodeSmartDownloadedId(qtVar4.realmGet$episodeSmartDownloadedId());
        qtVar3.realmSet$showId(qtVar4.realmGet$showId());
        qtVar3.realmSet$seasonNumber(qtVar4.realmGet$seasonNumber());
        qtVar3.realmSet$episodeNumber(qtVar4.realmGet$episodeNumber());
        return qtVar;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder("RealmWatchedEpisode = proxy[");
        sb.append("{episodeId:");
        sb.append(realmGet$episodeId() != null ? realmGet$episodeId() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{episodeSmartDownloadedId:");
        sb.append(realmGet$episodeSmartDownloadedId() != null ? realmGet$episodeSmartDownloadedId() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{showId:");
        sb.append(realmGet$showId() != null ? realmGet$showId() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{seasonNumber:");
        sb.append(realmGet$seasonNumber());
        sb.append("}");
        sb.append(",");
        sb.append("{episodeNumber:");
        sb.append(realmGet$episodeNumber());
        sb.append("}");
        sb.append("]");
        return sb.toString();
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
        RealmWatchedEpisodeRealmProxy realmWatchedEpisodeRealmProxy = (RealmWatchedEpisodeRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = realmWatchedEpisodeRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = realmWatchedEpisodeRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != realmWatchedEpisodeRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
