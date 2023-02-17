package io.realm;

import io.realm.BaseRealm;
import io.realm.exceptions.RealmException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.C2099qs;
import o.C2100qt;
public class RealmWatchedShowRealmProxy extends C2099qs implements RealmObjectProxy {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmWatchedShowColumnInfo columnInfo;
    private ProxyState<C2099qs> proxyState;
    private RealmList<C2100qt> watchedEpisodesRealmList;

    /* access modifiers changed from: package-private */
    public static final class RealmWatchedShowColumnInfo extends ColumnInfo {
        long showIdIndex;
        long watchedEpisodesIndex;

        RealmWatchedShowColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("RealmWatchedShow");
            this.showIdIndex = addColumnDetails("showId", objectSchemaInfo);
            this.watchedEpisodesIndex = addColumnDetails("watchedEpisodes", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RealmWatchedShowColumnInfo realmWatchedShowColumnInfo = (RealmWatchedShowColumnInfo) columnInfo;
            RealmWatchedShowColumnInfo realmWatchedShowColumnInfo2 = (RealmWatchedShowColumnInfo) columnInfo2;
            realmWatchedShowColumnInfo2.showIdIndex = realmWatchedShowColumnInfo.showIdIndex;
            realmWatchedShowColumnInfo2.watchedEpisodesIndex = realmWatchedShowColumnInfo.watchedEpisodesIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("showId");
        arrayList.add("watchedEpisodes");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    RealmWatchedShowRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RealmWatchedShowColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // o.C2099qs, io.realm.RealmWatchedShowRealmProxyInterface
    public String realmGet$showId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.showIdIndex);
    }

    @Override // o.C2099qs
    public void realmSet$showId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'showId' cannot be changed after object was created.");
        }
    }

    @Override // o.C2099qs, io.realm.RealmWatchedShowRealmProxyInterface
    public RealmList<C2100qt> realmGet$watchedEpisodes() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.watchedEpisodesRealmList != null) {
            return this.watchedEpisodesRealmList;
        }
        this.watchedEpisodesRealmList = new RealmList<>(C2100qt.class, this.proxyState.getRow$realm().getModelList(this.columnInfo.watchedEpisodesIndex), this.proxyState.getRealm$realm());
        return this.watchedEpisodesRealmList;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x005c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [io.realm.RealmList<o.qt>, io.realm.RealmList] */
    /* JADX WARN: Type inference failed for: r9v1, types: [io.realm.RealmList] */
    /* JADX WARN: Type inference failed for: r9v2, types: [io.realm.RealmList] */
    @Override // o.C2099qs
    public void realmSet$watchedEpisodes(RealmList<C2100qt> realmList) {
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("watchedEpisodes")) {
                return;
            }
            if (realmList != 0 && !realmList.isManaged()) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                realmList = new RealmList<>();
                Iterator it = realmList.iterator();
                while (it.hasNext()) {
                    C2100qt qtVar = (C2100qt) it.next();
                    if (qtVar == null || RealmObject.isManaged(qtVar)) {
                        realmList.add(qtVar);
                    } else {
                        realmList.add(realm.copyToRealm(qtVar));
                    }
                }
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.columnInfo.watchedEpisodesIndex);
        if (realmList == 0 || ((long) realmList.size()) != modelList.size()) {
            modelList.removeAll();
            if (realmList != 0) {
                int size = realmList.size();
                for (int i = 0; i < size; i++) {
                    C2100qt qtVar2 = (C2100qt) realmList.get(i);
                    this.proxyState.checkValidObject(qtVar2);
                    modelList.addRow(((RealmObjectProxy) qtVar2).realmGet$proxyState().getRow$realm().getIndex());
                }
                return;
            }
            return;
        }
        int size2 = realmList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C2100qt qtVar3 = (C2100qt) realmList.get(i2);
            this.proxyState.checkValidObject(qtVar3);
            modelList.setRow((long) i2, ((RealmObjectProxy) qtVar3).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmWatchedShow", 2, 0);
        builder.addPersistedProperty("showId", RealmFieldType.STRING, true, true, false);
        builder.addPersistedLinkProperty("watchedEpisodes", RealmFieldType.LIST, "RealmWatchedEpisode");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmWatchedShowColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RealmWatchedShowColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_RealmWatchedShow";
    }

    public static C2099qs copyOrUpdate(Realm realm, C2099qs qsVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        long j;
        if ((qsVar instanceof RealmObjectProxy) && ((RealmObjectProxy) qsVar).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) qsVar).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return qsVar;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(qsVar);
        if (realmObjectProxy != null) {
            return (C2099qs) realmObjectProxy;
        }
        RealmWatchedShowRealmProxy realmWatchedShowRealmProxy = null;
        boolean z2 = z;
        if (z2) {
            Table table = realm.getTable(C2099qs.class);
            long j2 = ((RealmWatchedShowColumnInfo) realm.getSchema().getColumnInfo(C2099qs.class)).showIdIndex;
            String realmGet$showId = qsVar.realmGet$showId();
            if (realmGet$showId == null) {
                j = table.findFirstNull(j2);
            } else {
                j = table.findFirstString(j2, realmGet$showId);
            }
            if (j == -1) {
                z2 = false;
            } else {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(j), realm.getSchema().getColumnInfo(C2099qs.class), false, Collections.emptyList());
                    realmWatchedShowRealmProxy = new RealmWatchedShowRealmProxy();
                    map.put(qsVar, realmWatchedShowRealmProxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        return z2 ? update(realm, realmWatchedShowRealmProxy, qsVar, map) : copy(realm, qsVar, z, map);
    }

    public static C2099qs copy(Realm realm, C2099qs qsVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(qsVar);
        if (realmObjectProxy != null) {
            return (C2099qs) realmObjectProxy;
        }
        C2099qs qsVar2 = (C2099qs) realm.createObjectInternal(C2099qs.class, qsVar.realmGet$showId(), false, Collections.emptyList());
        map.put(qsVar, (RealmObjectProxy) qsVar2);
        C2099qs qsVar3 = qsVar2;
        RealmList<C2100qt> realmGet$watchedEpisodes = qsVar.realmGet$watchedEpisodes();
        if (realmGet$watchedEpisodes != null) {
            RealmList<C2100qt> realmGet$watchedEpisodes2 = qsVar3.realmGet$watchedEpisodes();
            realmGet$watchedEpisodes2.clear();
            for (int i = 0; i < realmGet$watchedEpisodes.size(); i++) {
                C2100qt qtVar = realmGet$watchedEpisodes.get(i);
                C2100qt qtVar2 = (C2100qt) map.get(qtVar);
                if (qtVar2 != null) {
                    realmGet$watchedEpisodes2.add(qtVar2);
                } else {
                    realmGet$watchedEpisodes2.add(RealmWatchedEpisodeRealmProxy.copyOrUpdate(realm, qtVar, z, map));
                }
            }
        }
        return qsVar2;
    }

    static C2099qs update(Realm realm, C2099qs qsVar, C2099qs qsVar2, Map<RealmModel, RealmObjectProxy> map) {
        RealmList<C2100qt> realmGet$watchedEpisodes = qsVar2.realmGet$watchedEpisodes();
        RealmList<C2100qt> realmGet$watchedEpisodes2 = qsVar.realmGet$watchedEpisodes();
        if (realmGet$watchedEpisodes == null || realmGet$watchedEpisodes.size() != realmGet$watchedEpisodes2.size()) {
            realmGet$watchedEpisodes2.clear();
            if (realmGet$watchedEpisodes != null) {
                for (int i = 0; i < realmGet$watchedEpisodes.size(); i++) {
                    C2100qt qtVar = realmGet$watchedEpisodes.get(i);
                    C2100qt qtVar2 = (C2100qt) map.get(qtVar);
                    if (qtVar2 != null) {
                        realmGet$watchedEpisodes2.add(qtVar2);
                    } else {
                        realmGet$watchedEpisodes2.add(RealmWatchedEpisodeRealmProxy.copyOrUpdate(realm, qtVar, true, map));
                    }
                }
            }
        } else {
            int size = realmGet$watchedEpisodes.size();
            for (int i2 = 0; i2 < size; i2++) {
                C2100qt qtVar3 = realmGet$watchedEpisodes.get(i2);
                C2100qt qtVar4 = (C2100qt) map.get(qtVar3);
                if (qtVar4 != null) {
                    realmGet$watchedEpisodes2.set(i2, qtVar4);
                } else {
                    realmGet$watchedEpisodes2.set(i2, RealmWatchedEpisodeRealmProxy.copyOrUpdate(realm, qtVar3, true, map));
                }
            }
        }
        return qsVar;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder("RealmWatchedShow = proxy[");
        sb.append("{showId:");
        sb.append(realmGet$showId() != null ? realmGet$showId() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{watchedEpisodes:");
        sb.append("RealmList<RealmWatchedEpisode>[").append(realmGet$watchedEpisodes().size()).append("]");
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
        RealmWatchedShowRealmProxy realmWatchedShowRealmProxy = (RealmWatchedShowRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = realmWatchedShowRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = realmWatchedShowRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != realmWatchedShowRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
