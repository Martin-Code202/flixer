package io.realm;

import io.realm.BaseRealm;
import io.realm.annotations.RealmModule;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.C1145;
import o.C1147;
import o.C1202;
@RealmModule
class FalkorRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    @Override // io.realm.internal.RealmProxyMediator
    public boolean transformerApplied() {
        return true;
    }

    FalkorRealmModuleMediator() {
    }

    static {
        HashSet hashSet = new HashSet(3);
        hashSet.add(C1145.class);
        hashSet.add(C1147.class);
        hashSet.add(C1202.class);
        MODEL_CLASSES = Collections.unmodifiableSet(hashSet);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap(3);
        hashMap.put(C1145.class, FalkorRealmCacheHomeLolomoRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(C1147.class, FalkorRealmCacheLruBasedRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(C1202.class, FalkorRealmCacheTimeBasedRealmProxy.getExpectedObjectSchemaInfo());
        return hashMap;
    }

    @Override // io.realm.internal.RealmProxyMediator
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        checkClass(cls);
        if (cls.equals(C1145.class)) {
            return FalkorRealmCacheHomeLolomoRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(C1147.class)) {
            return FalkorRealmCacheLruBasedRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(C1202.class)) {
            return FalkorRealmCacheTimeBasedRealmProxy.createColumnInfo(osSchemaInfo);
        }
        throw getMissingProxyClassException(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public String getTableName(Class<? extends RealmModel> cls) {
        checkClass(cls);
        if (cls.equals(C1145.class)) {
            return FalkorRealmCacheHomeLolomoRealmProxy.getTableName();
        }
        if (cls.equals(C1147.class)) {
            return FalkorRealmCacheLruBasedRealmProxy.getTableName();
        }
        if (cls.equals(C1202.class)) {
            return FalkorRealmCacheTimeBasedRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            realmObjectContext.set((BaseRealm) obj, row, columnInfo, z, list);
            checkClass(cls);
            if (cls.equals(C1145.class)) {
                return cls.cast(new FalkorRealmCacheHomeLolomoRealmProxy());
            }
            if (cls.equals(C1147.class)) {
                E cast = cls.cast(new FalkorRealmCacheLruBasedRealmProxy());
                realmObjectContext.clear();
                return cast;
            } else if (cls.equals(C1202.class)) {
                E cast2 = cls.cast(new FalkorRealmCacheTimeBasedRealmProxy());
                realmObjectContext.clear();
                return cast2;
            } else {
                throw getMissingProxyClassException(cls);
            }
        } finally {
            realmObjectContext.clear();
        }
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        Class<?> superclass = e instanceof RealmObjectProxy ? e.getClass().getSuperclass() : e.getClass();
        if (superclass.equals(C1145.class)) {
            return (E) ((RealmModel) superclass.cast(FalkorRealmCacheHomeLolomoRealmProxy.copyOrUpdate(realm, (C1145) e, z, map)));
        }
        if (superclass.equals(C1147.class)) {
            return (E) ((RealmModel) superclass.cast(FalkorRealmCacheLruBasedRealmProxy.copyOrUpdate(realm, (C1147) e, z, map)));
        }
        if (superclass.equals(C1202.class)) {
            return (E) ((RealmModel) superclass.cast(FalkorRealmCacheTimeBasedRealmProxy.copyOrUpdate(realm, (C1202) e, z, map)));
        }
        throw getMissingProxyClassException(superclass);
    }
}
