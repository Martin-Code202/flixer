package io.realm;

import io.realm.BaseRealm;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import o.C1145;
public class FalkorRealmCacheHomeLolomoRealmProxy extends C1145 implements RealmObjectProxy {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private FalkorRealmCacheHomeLolomoColumnInfo columnInfo;
    private ProxyState<C1145> proxyState;

    /* access modifiers changed from: package-private */
    public static final class FalkorRealmCacheHomeLolomoColumnInfo extends ColumnInfo {
        long expiryIndex;
        long lolomosRefIndex;

        FalkorRealmCacheHomeLolomoColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("FalkorRealmCacheHomeLolomo");
            this.lolomosRefIndex = addColumnDetails("lolomosRef", objectSchemaInfo);
            this.expiryIndex = addColumnDetails("expiry", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            FalkorRealmCacheHomeLolomoColumnInfo falkorRealmCacheHomeLolomoColumnInfo = (FalkorRealmCacheHomeLolomoColumnInfo) columnInfo;
            FalkorRealmCacheHomeLolomoColumnInfo falkorRealmCacheHomeLolomoColumnInfo2 = (FalkorRealmCacheHomeLolomoColumnInfo) columnInfo2;
            falkorRealmCacheHomeLolomoColumnInfo2.lolomosRefIndex = falkorRealmCacheHomeLolomoColumnInfo.lolomosRefIndex;
            falkorRealmCacheHomeLolomoColumnInfo2.expiryIndex = falkorRealmCacheHomeLolomoColumnInfo.expiryIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("lolomosRef");
        arrayList.add("expiry");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    FalkorRealmCacheHomeLolomoRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (FalkorRealmCacheHomeLolomoColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // o.C1145, io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface
    public String realmGet$lolomosRef() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.lolomosRefIndex);
    }

    @Override // o.C1145, io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface
    public void realmSet$lolomosRef(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lolomosRef' to null.");
            }
            this.proxyState.getRow$realm().setString(this.columnInfo.lolomosRefIndex, str);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lolomosRef' to null.");
            }
            row$realm.getTable().setString(this.columnInfo.lolomosRefIndex, row$realm.getIndex(), str, true);
        }
    }

    @Override // o.C1145, io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface
    public Date realmGet$expiry() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getDate(this.columnInfo.expiryIndex);
    }

    @Override // o.C1145, io.realm.FalkorRealmCacheHomeLolomoRealmProxyInterface
    public void realmSet$expiry(Date date) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (date == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'expiry' to null.");
            }
            this.proxyState.getRow$realm().setDate(this.columnInfo.expiryIndex, date);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (date == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'expiry' to null.");
            }
            row$realm.getTable().setDate(this.columnInfo.expiryIndex, row$realm.getIndex(), date, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("FalkorRealmCacheHomeLolomo", 2, 0);
        builder.addPersistedProperty("lolomosRef", RealmFieldType.STRING, false, false, true);
        builder.addPersistedProperty("expiry", RealmFieldType.DATE, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FalkorRealmCacheHomeLolomoColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new FalkorRealmCacheHomeLolomoColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_FalkorRealmCacheHomeLolomo";
    }

    public static C1145 copyOrUpdate(Realm realm, C1145 r7, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        if ((r7 instanceof RealmObjectProxy) && ((RealmObjectProxy) r7).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) r7).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return r7;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(r7);
        if (realmObjectProxy != null) {
            return (C1145) realmObjectProxy;
        }
        return copy(realm, r7, z, map);
    }

    public static C1145 copy(Realm realm, C1145 r8, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(r8);
        if (realmObjectProxy != null) {
            return (C1145) realmObjectProxy;
        }
        C1145 r4 = (C1145) realm.createObjectInternal(C1145.class, false, Collections.emptyList());
        map.put(r8, (RealmObjectProxy) r4);
        C1145 r5 = r8;
        C1145 r6 = r4;
        r6.realmSet$lolomosRef(r5.realmGet$lolomosRef());
        r6.realmSet$expiry(r5.realmGet$expiry());
        return r4;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "FalkorRealmCacheHomeLolomo = proxy[{lolomosRef:" + realmGet$lolomosRef() + "},{expiry:" + realmGet$expiry() + "}]";
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
        FalkorRealmCacheHomeLolomoRealmProxy falkorRealmCacheHomeLolomoRealmProxy = (FalkorRealmCacheHomeLolomoRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = falkorRealmCacheHomeLolomoRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = falkorRealmCacheHomeLolomoRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != falkorRealmCacheHomeLolomoRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
