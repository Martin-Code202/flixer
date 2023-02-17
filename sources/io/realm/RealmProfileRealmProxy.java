package io.realm;

import com.netflix.mediaclient.service.logging.client.model.Event;
import io.realm.BaseRealm;
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
import o.C2091ql;
public class RealmProfileRealmProxy extends C2091ql implements RealmObjectProxy {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmProfileColumnInfo columnInfo;
    private ProxyState<C2091ql> proxyState;

    /* access modifiers changed from: package-private */
    public static final class RealmProfileColumnInfo extends ColumnInfo {
        long iconUrlIndex;
        long idIndex;
        long kidsIndex;
        long nameIndex;

        RealmProfileColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("RealmProfile");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.kidsIndex = addColumnDetails(Event.KIDS, objectSchemaInfo);
            this.iconUrlIndex = addColumnDetails("iconUrl", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RealmProfileColumnInfo realmProfileColumnInfo = (RealmProfileColumnInfo) columnInfo;
            RealmProfileColumnInfo realmProfileColumnInfo2 = (RealmProfileColumnInfo) columnInfo2;
            realmProfileColumnInfo2.idIndex = realmProfileColumnInfo.idIndex;
            realmProfileColumnInfo2.nameIndex = realmProfileColumnInfo.nameIndex;
            realmProfileColumnInfo2.kidsIndex = realmProfileColumnInfo.kidsIndex;
            realmProfileColumnInfo2.iconUrlIndex = realmProfileColumnInfo.iconUrlIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add("id");
        arrayList.add("name");
        arrayList.add(Event.KIDS);
        arrayList.add("iconUrl");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    RealmProfileRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RealmProfileColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // o.C2091ql, io.realm.RealmProfileRealmProxyInterface
    public String realmGet$id() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.idIndex);
    }

    @Override // o.C2091ql, io.realm.RealmProfileRealmProxyInterface
    public String realmGet$name() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.nameIndex);
    }

    @Override // o.C2091ql, io.realm.RealmProfileRealmProxyInterface
    public void realmSet$name(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.nameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.nameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.nameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.nameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C2091ql, io.realm.RealmProfileRealmProxyInterface
    public boolean realmGet$kids() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.kidsIndex);
    }

    @Override // o.C2091ql, io.realm.RealmProfileRealmProxyInterface
    public void realmSet$kids(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.kidsIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.kidsIndex, row$realm.getIndex(), z, true);
        }
    }

    @Override // o.C2091ql, io.realm.RealmProfileRealmProxyInterface
    public String realmGet$iconUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.iconUrlIndex);
    }

    @Override // o.C2091ql, io.realm.RealmProfileRealmProxyInterface
    public void realmSet$iconUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.iconUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.iconUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.iconUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.iconUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmProfile", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, true, true, false);
        builder.addPersistedProperty("name", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty(Event.KIDS, RealmFieldType.BOOLEAN, false, false, true);
        builder.addPersistedProperty("iconUrl", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmProfileColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RealmProfileColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_RealmProfile";
    }

    public static C2091ql copyOrUpdate(Realm realm, C2091ql qlVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        long j;
        if ((qlVar instanceof RealmObjectProxy) && ((RealmObjectProxy) qlVar).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) qlVar).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return qlVar;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(qlVar);
        if (realmObjectProxy != null) {
            return (C2091ql) realmObjectProxy;
        }
        RealmProfileRealmProxy realmProfileRealmProxy = null;
        boolean z2 = z;
        if (z2) {
            Table table = realm.getTable(C2091ql.class);
            long j2 = ((RealmProfileColumnInfo) realm.getSchema().getColumnInfo(C2091ql.class)).idIndex;
            String realmGet$id = qlVar.realmGet$id();
            if (realmGet$id == null) {
                j = table.findFirstNull(j2);
            } else {
                j = table.findFirstString(j2, realmGet$id);
            }
            if (j == -1) {
                z2 = false;
            } else {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(j), realm.getSchema().getColumnInfo(C2091ql.class), false, Collections.emptyList());
                    realmProfileRealmProxy = new RealmProfileRealmProxy();
                    map.put(qlVar, realmProfileRealmProxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        return z2 ? update(realm, realmProfileRealmProxy, qlVar, map) : copy(realm, qlVar, z, map);
    }

    public static C2091ql copy(Realm realm, C2091ql qlVar, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(qlVar);
        if (realmObjectProxy != null) {
            return (C2091ql) realmObjectProxy;
        }
        C2091ql qlVar2 = (C2091ql) realm.createObjectInternal(C2091ql.class, qlVar.realmGet$id(), false, Collections.emptyList());
        map.put(qlVar, (RealmObjectProxy) qlVar2);
        C2091ql qlVar3 = qlVar;
        C2091ql qlVar4 = qlVar2;
        qlVar4.realmSet$name(qlVar3.realmGet$name());
        qlVar4.realmSet$kids(qlVar3.realmGet$kids());
        qlVar4.realmSet$iconUrl(qlVar3.realmGet$iconUrl());
        return qlVar2;
    }

    static C2091ql update(Realm realm, C2091ql qlVar, C2091ql qlVar2, Map<RealmModel, RealmObjectProxy> map) {
        C2091ql qlVar3 = qlVar;
        C2091ql qlVar4 = qlVar2;
        qlVar3.realmSet$name(qlVar4.realmGet$name());
        qlVar3.realmSet$kids(qlVar4.realmGet$kids());
        qlVar3.realmSet$iconUrl(qlVar4.realmGet$iconUrl());
        return qlVar;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder("RealmProfile = proxy[");
        sb.append("{id:");
        sb.append(realmGet$id() != null ? realmGet$id() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{name:");
        sb.append(realmGet$name() != null ? realmGet$name() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{kids:");
        sb.append(realmGet$kids());
        sb.append("}");
        sb.append(",");
        sb.append("{iconUrl:");
        sb.append(realmGet$iconUrl() != null ? realmGet$iconUrl() : "null");
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
        RealmProfileRealmProxy realmProfileRealmProxy = (RealmProfileRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = realmProfileRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = realmProfileRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != realmProfileRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
