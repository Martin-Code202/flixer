package io.realm;

import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import o.C1147;
public class FalkorRealmCacheLruBasedRealmProxy extends C1147 implements RealmObjectProxy {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private FalkorRealmCacheLruBasedColumnInfo columnInfo;
    private ProxyState<C1147> proxyState;

    /* access modifiers changed from: package-private */
    public static final class FalkorRealmCacheLruBasedColumnInfo extends ColumnInfo {
        long expiryIndex;
        long lastModifiedIndex;
        long pathIndex;
        long payloadIndex;
        long sentinelIndex;

        FalkorRealmCacheLruBasedColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("FalkorRealmCacheLruBased");
            this.pathIndex = addColumnDetails(FalkorPathResult.PATH, objectSchemaInfo);
            this.payloadIndex = addColumnDetails("payload", objectSchemaInfo);
            this.expiryIndex = addColumnDetails("expiry", objectSchemaInfo);
            this.lastModifiedIndex = addColumnDetails("lastModified", objectSchemaInfo);
            this.sentinelIndex = addColumnDetails("sentinel", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            FalkorRealmCacheLruBasedColumnInfo falkorRealmCacheLruBasedColumnInfo = (FalkorRealmCacheLruBasedColumnInfo) columnInfo;
            FalkorRealmCacheLruBasedColumnInfo falkorRealmCacheLruBasedColumnInfo2 = (FalkorRealmCacheLruBasedColumnInfo) columnInfo2;
            falkorRealmCacheLruBasedColumnInfo2.pathIndex = falkorRealmCacheLruBasedColumnInfo.pathIndex;
            falkorRealmCacheLruBasedColumnInfo2.payloadIndex = falkorRealmCacheLruBasedColumnInfo.payloadIndex;
            falkorRealmCacheLruBasedColumnInfo2.expiryIndex = falkorRealmCacheLruBasedColumnInfo.expiryIndex;
            falkorRealmCacheLruBasedColumnInfo2.lastModifiedIndex = falkorRealmCacheLruBasedColumnInfo.lastModifiedIndex;
            falkorRealmCacheLruBasedColumnInfo2.sentinelIndex = falkorRealmCacheLruBasedColumnInfo.sentinelIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(FalkorPathResult.PATH);
        arrayList.add("payload");
        arrayList.add("expiry");
        arrayList.add("lastModified");
        arrayList.add("sentinel");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    FalkorRealmCacheLruBasedRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (FalkorRealmCacheLruBasedColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public String realmGet$path() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pathIndex);
    }

    @Override // o.C1147
    public void realmSet$path(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'path' cannot be changed after object was created.");
        }
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public String realmGet$payload() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.payloadIndex);
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public void realmSet$payload(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.payloadIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.payloadIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.payloadIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.payloadIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public Date realmGet$expiry() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.expiryIndex)) {
            return null;
        }
        return this.proxyState.getRow$realm().getDate(this.columnInfo.expiryIndex);
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public void realmSet$expiry(Date date) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (date == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.expiryIndex);
            } else {
                this.proxyState.getRow$realm().setDate(this.columnInfo.expiryIndex, date);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (date == null) {
                row$realm.getTable().setNull(this.columnInfo.expiryIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setDate(this.columnInfo.expiryIndex, row$realm.getIndex(), date, true);
            }
        }
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public long realmGet$lastModified() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.lastModifiedIndex);
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public void realmSet$lastModified(long j) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.lastModifiedIndex, j);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.lastModifiedIndex, row$realm.getIndex(), j, true);
        }
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public boolean realmGet$sentinel() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.sentinelIndex);
    }

    @Override // o.C1147, io.realm.FalkorRealmCacheLruBasedRealmProxyInterface
    public void realmSet$sentinel(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.sentinelIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.sentinelIndex, row$realm.getIndex(), z, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("FalkorRealmCacheLruBased", 5, 0);
        builder.addPersistedProperty(FalkorPathResult.PATH, RealmFieldType.STRING, true, true, false);
        builder.addPersistedProperty("payload", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("expiry", RealmFieldType.DATE, false, false, false);
        builder.addPersistedProperty("lastModified", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("sentinel", RealmFieldType.BOOLEAN, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FalkorRealmCacheLruBasedColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new FalkorRealmCacheLruBasedColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_FalkorRealmCacheLruBased";
    }

    public static C1147 copyOrUpdate(Realm realm, C1147 r19, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        long j;
        if ((r19 instanceof RealmObjectProxy) && ((RealmObjectProxy) r19).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) r19).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return r19;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(r19);
        if (realmObjectProxy != null) {
            return (C1147) realmObjectProxy;
        }
        FalkorRealmCacheLruBasedRealmProxy falkorRealmCacheLruBasedRealmProxy = null;
        boolean z2 = z;
        if (z2) {
            Table table = realm.getTable(C1147.class);
            long j2 = ((FalkorRealmCacheLruBasedColumnInfo) realm.getSchema().getColumnInfo(C1147.class)).pathIndex;
            String realmGet$path = r19.realmGet$path();
            if (realmGet$path == null) {
                j = table.findFirstNull(j2);
            } else {
                j = table.findFirstString(j2, realmGet$path);
            }
            if (j == -1) {
                z2 = false;
            } else {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(j), realm.getSchema().getColumnInfo(C1147.class), false, Collections.emptyList());
                    falkorRealmCacheLruBasedRealmProxy = new FalkorRealmCacheLruBasedRealmProxy();
                    map.put(r19, falkorRealmCacheLruBasedRealmProxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        return z2 ? update(realm, falkorRealmCacheLruBasedRealmProxy, r19, map) : copy(realm, r19, z, map);
    }

    public static C1147 copy(Realm realm, C1147 r9, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(r9);
        if (realmObjectProxy != null) {
            return (C1147) realmObjectProxy;
        }
        C1147 r5 = (C1147) realm.createObjectInternal(C1147.class, r9.realmGet$path(), false, Collections.emptyList());
        map.put(r9, (RealmObjectProxy) r5);
        C1147 r6 = r9;
        C1147 r7 = r5;
        r7.realmSet$payload(r6.realmGet$payload());
        r7.realmSet$expiry(r6.realmGet$expiry());
        r7.realmSet$lastModified(r6.realmGet$lastModified());
        r7.realmSet$sentinel(r6.realmGet$sentinel());
        return r5;
    }

    static C1147 update(Realm realm, C1147 r5, C1147 r6, Map<RealmModel, RealmObjectProxy> map) {
        C1147 r2 = r5;
        C1147 r3 = r6;
        r2.realmSet$payload(r3.realmGet$payload());
        r2.realmSet$expiry(r3.realmGet$expiry());
        r2.realmSet$lastModified(r3.realmGet$lastModified());
        r2.realmSet$sentinel(r3.realmGet$sentinel());
        return r5;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder("FalkorRealmCacheLruBased = proxy[");
        sb.append("{path:");
        sb.append(realmGet$path() != null ? realmGet$path() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{payload:");
        sb.append(realmGet$payload() != null ? realmGet$payload() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{expiry:");
        sb.append(realmGet$expiry() != null ? realmGet$expiry() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{lastModified:");
        sb.append(realmGet$lastModified());
        sb.append("}");
        sb.append(",");
        sb.append("{sentinel:");
        sb.append(realmGet$sentinel());
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
        FalkorRealmCacheLruBasedRealmProxy falkorRealmCacheLruBasedRealmProxy = (FalkorRealmCacheLruBasedRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = falkorRealmCacheLruBasedRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = falkorRealmCacheLruBasedRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != falkorRealmCacheLruBasedRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
