package io.realm.internal.modules;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class CompositeMediator extends RealmProxyMediator {
    private final Map<Class<? extends RealmModel>, RealmProxyMediator> mediators;

    public CompositeMediator(RealmProxyMediator... realmProxyMediatorArr) {
        HashMap hashMap = new HashMap();
        if (realmProxyMediatorArr != null) {
            for (RealmProxyMediator realmProxyMediator : realmProxyMediatorArr) {
                for (Class<? extends RealmModel> cls : realmProxyMediator.getModelClasses()) {
                    hashMap.put(cls, realmProxyMediator);
                }
            }
        }
        this.mediators = Collections.unmodifiableMap(hashMap);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap();
        for (RealmProxyMediator realmProxyMediator : this.mediators.values()) {
            hashMap.putAll(realmProxyMediator.getExpectedObjectSchemaInfoMap());
        }
        return hashMap;
    }

    @Override // io.realm.internal.RealmProxyMediator
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        return getMediator(cls).createColumnInfo(cls, osSchemaInfo);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public String getTableName(Class<? extends RealmModel> cls) {
        return getMediator(cls).getTableName(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        return (E) getMediator(cls).newInstance(cls, obj, row, columnInfo, z, list);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return this.mediators.keySet();
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        return (E) getMediator(Util.getOriginalModelClass(e.getClass())).copyOrUpdate(realm, e, z, map);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public boolean transformerApplied() {
        for (Map.Entry<Class<? extends RealmModel>, RealmProxyMediator> entry : this.mediators.entrySet()) {
            if (!entry.getValue().transformerApplied()) {
                return false;
            }
        }
        return true;
    }

    private RealmProxyMediator getMediator(Class<? extends RealmModel> cls) {
        RealmProxyMediator realmProxyMediator = this.mediators.get(cls);
        if (realmProxyMediator != null) {
            return realmProxyMediator;
        }
        throw new IllegalArgumentException(cls.getSimpleName() + " is not part of the schema for this Realm");
    }
}
