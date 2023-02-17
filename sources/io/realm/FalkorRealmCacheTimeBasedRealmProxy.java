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
import o.C1202;
public class FalkorRealmCacheTimeBasedRealmProxy extends C1202 implements RealmObjectProxy {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private FalkorRealmCacheTimeBasedColumnInfo columnInfo;
    private ProxyState<C1202> proxyState;

    /* access modifiers changed from: package-private */
    public static final class FalkorRealmCacheTimeBasedColumnInfo extends ColumnInfo {
        long expiryIndex;
        long lastModifiedIndex;
        long pathIndex;
        long payloadIndex;
        long sentinelIndex;

        FalkorRealmCacheTimeBasedColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("FalkorRealmCacheTimeBased");
            this.pathIndex = addColumnDetails(FalkorPathResult.PATH, objectSchemaInfo);
            this.payloadIndex = addColumnDetails("payload", objectSchemaInfo);
            this.expiryIndex = addColumnDetails("expiry", objectSchemaInfo);
            this.lastModifiedIndex = addColumnDetails("lastModified", objectSchemaInfo);
            this.sentinelIndex = addColumnDetails("sentinel", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            FalkorRealmCacheTimeBasedColumnInfo falkorRealmCacheTimeBasedColumnInfo = (FalkorRealmCacheTimeBasedColumnInfo) columnInfo;
            FalkorRealmCacheTimeBasedColumnInfo falkorRealmCacheTimeBasedColumnInfo2 = (FalkorRealmCacheTimeBasedColumnInfo) columnInfo2;
            falkorRealmCacheTimeBasedColumnInfo2.pathIndex = falkorRealmCacheTimeBasedColumnInfo.pathIndex;
            falkorRealmCacheTimeBasedColumnInfo2.payloadIndex = falkorRealmCacheTimeBasedColumnInfo.payloadIndex;
            falkorRealmCacheTimeBasedColumnInfo2.expiryIndex = falkorRealmCacheTimeBasedColumnInfo.expiryIndex;
            falkorRealmCacheTimeBasedColumnInfo2.lastModifiedIndex = falkorRealmCacheTimeBasedColumnInfo.lastModifiedIndex;
            falkorRealmCacheTimeBasedColumnInfo2.sentinelIndex = falkorRealmCacheTimeBasedColumnInfo.sentinelIndex;
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

    FalkorRealmCacheTimeBasedRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (FalkorRealmCacheTimeBasedColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
    public String realmGet$path() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.pathIndex);
    }

    @Override // o.C1202
    public void realmSet$path(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'path' cannot be changed after object was created.");
        }
    }

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
    public String realmGet$payload() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.payloadIndex);
    }

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
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

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
    public Date realmGet$expiry() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.expiryIndex)) {
            return null;
        }
        return this.proxyState.getRow$realm().getDate(this.columnInfo.expiryIndex);
    }

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
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

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
    public long realmGet$lastModified() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.lastModifiedIndex);
    }

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
    public void realmSet$lastModified(long j) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.lastModifiedIndex, j);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.lastModifiedIndex, row$realm.getIndex(), j, true);
        }
    }

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
    public boolean realmGet$sentinel() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.sentinelIndex);
    }

    @Override // o.C1202, io.realm.FalkorRealmCacheTimeBasedRealmProxyInterface
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("FalkorRealmCacheTimeBased", 5, 0);
        builder.addPersistedProperty(FalkorPathResult.PATH, RealmFieldType.STRING, true, true, true);
        builder.addPersistedProperty("payload", RealmFieldType.STRING, false, false, false);
        builder.addPersistedProperty("expiry", RealmFieldType.DATE, false, false, false);
        builder.addPersistedProperty("lastModified", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("sentinel", RealmFieldType.BOOLEAN, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FalkorRealmCacheTimeBasedColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new FalkorRealmCacheTimeBasedColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_FalkorRealmCacheTimeBased";
    }

    public static C1202 copyOrUpdate(Realm realm, C1202 r18, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        if ((r18 instanceof RealmObjectProxy) && ((RealmObjectProxy) r18).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) r18).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return r18;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(r18);
        if (realmObjectProxy != null) {
            return (C1202) realmObjectProxy;
        }
        FalkorRealmCacheTimeBasedRealmProxy falkorRealmCacheTimeBasedRealmProxy = null;
        boolean z2 = z;
        if (z2) {
            Table table = realm.getTable(C1202.class);
            long findFirstString = table.findFirstString(((FalkorRealmCacheTimeBasedColumnInfo) realm.getSchema().getColumnInfo(C1202.class)).pathIndex, r18.realmGet$path());
            if (findFirstString == -1) {
                z2 = false;
            } else {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(findFirstString), realm.getSchema().getColumnInfo(C1202.class), false, Collections.emptyList());
                    falkorRealmCacheTimeBasedRealmProxy = new FalkorRealmCacheTimeBasedRealmProxy();
                    map.put(r18, falkorRealmCacheTimeBasedRealmProxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        return z2 ? update(realm, falkorRealmCacheTimeBasedRealmProxy, r18, map) : copy(realm, r18, z, map);
    }

    public static C1202 copy(Realm realm, C1202 r9, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(r9);
        if (realmObjectProxy != null) {
            return (C1202) realmObjectProxy;
        }
        C1202 r5 = (C1202) realm.createObjectInternal(C1202.class, r9.realmGet$path(), false, Collections.emptyList());
        map.put(r9, (RealmObjectProxy) r5);
        C1202 r6 = r9;
        C1202 r7 = r5;
        r7.realmSet$payload(r6.realmGet$payload());
        r7.realmSet$expiry(r6.realmGet$expiry());
        r7.realmSet$lastModified(r6.realmGet$lastModified());
        r7.realmSet$sentinel(r6.realmGet$sentinel());
        return r5;
    }

    static C1202 update(Realm realm, C1202 r5, C1202 r6, Map<RealmModel, RealmObjectProxy> map) {
        C1202 r2 = r5;
        C1202 r3 = r6;
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
        StringBuilder sb = new StringBuilder("FalkorRealmCacheTimeBased = proxy[");
        sb.append("{path:");
        sb.append(realmGet$path());
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
        FalkorRealmCacheTimeBasedRealmProxy falkorRealmCacheTimeBasedRealmProxy = (FalkorRealmCacheTimeBasedRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = falkorRealmCacheTimeBasedRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = falkorRealmCacheTimeBasedRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != falkorRealmCacheTimeBasedRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
