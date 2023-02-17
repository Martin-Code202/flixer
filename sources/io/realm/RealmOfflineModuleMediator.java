package io.realm;

import com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails;
import com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason;
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
import o.C2091ql;
import o.C2092qm;
import o.C2098qr;
import o.C2099qs;
import o.C2100qt;
@RealmModule
class RealmOfflineModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    @Override // io.realm.internal.RealmProxyMediator
    public boolean transformerApplied() {
        return true;
    }

    RealmOfflineModuleMediator() {
    }

    static {
        HashSet hashSet = new HashSet(7);
        hashSet.add(C2098qr.class);
        hashSet.add(C2100qt.class);
        hashSet.add(C2092qm.class);
        hashSet.add(C2099qs.class);
        hashSet.add(RealmIncompleteVideoDetails.class);
        hashSet.add(RealmSeason.class);
        hashSet.add(C2091ql.class);
        MODEL_CLASSES = Collections.unmodifiableSet(hashSet);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap(7);
        hashMap.put(C2098qr.class, RealmVideoDetailsRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(C2100qt.class, RealmWatchedEpisodeRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(C2092qm.class, RealmPlayableRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(C2099qs.class, RealmWatchedShowRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RealmIncompleteVideoDetails.class, RealmIncompleteVideoDetailsRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RealmSeason.class, RealmSeasonRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(C2091ql.class, RealmProfileRealmProxy.getExpectedObjectSchemaInfo());
        return hashMap;
    }

    @Override // io.realm.internal.RealmProxyMediator
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        checkClass(cls);
        if (cls.equals(C2098qr.class)) {
            return RealmVideoDetailsRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(C2100qt.class)) {
            return RealmWatchedEpisodeRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(C2092qm.class)) {
            return RealmPlayableRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(C2099qs.class)) {
            return RealmWatchedShowRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RealmIncompleteVideoDetails.class)) {
            return RealmIncompleteVideoDetailsRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RealmSeason.class)) {
            return RealmSeasonRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(C2091ql.class)) {
            return RealmProfileRealmProxy.createColumnInfo(osSchemaInfo);
        }
        throw getMissingProxyClassException(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public String getTableName(Class<? extends RealmModel> cls) {
        checkClass(cls);
        if (cls.equals(C2098qr.class)) {
            return RealmVideoDetailsRealmProxy.getTableName();
        }
        if (cls.equals(C2100qt.class)) {
            return RealmWatchedEpisodeRealmProxy.getTableName();
        }
        if (cls.equals(C2092qm.class)) {
            return RealmPlayableRealmProxy.getTableName();
        }
        if (cls.equals(C2099qs.class)) {
            return RealmWatchedShowRealmProxy.getTableName();
        }
        if (cls.equals(RealmIncompleteVideoDetails.class)) {
            return RealmIncompleteVideoDetailsRealmProxy.getTableName();
        }
        if (cls.equals(RealmSeason.class)) {
            return RealmSeasonRealmProxy.getTableName();
        }
        if (cls.equals(C2091ql.class)) {
            return RealmProfileRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            realmObjectContext.set((BaseRealm) obj, row, columnInfo, z, list);
            checkClass(cls);
            if (cls.equals(C2098qr.class)) {
                return cls.cast(new RealmVideoDetailsRealmProxy());
            }
            if (cls.equals(C2100qt.class)) {
                E cast = cls.cast(new RealmWatchedEpisodeRealmProxy());
                realmObjectContext.clear();
                return cast;
            } else if (cls.equals(C2092qm.class)) {
                E cast2 = cls.cast(new RealmPlayableRealmProxy());
                realmObjectContext.clear();
                return cast2;
            } else if (cls.equals(C2099qs.class)) {
                E cast3 = cls.cast(new RealmWatchedShowRealmProxy());
                realmObjectContext.clear();
                return cast3;
            } else if (cls.equals(RealmIncompleteVideoDetails.class)) {
                E cast4 = cls.cast(new RealmIncompleteVideoDetailsRealmProxy());
                realmObjectContext.clear();
                return cast4;
            } else if (cls.equals(RealmSeason.class)) {
                E cast5 = cls.cast(new RealmSeasonRealmProxy());
                realmObjectContext.clear();
                return cast5;
            } else if (cls.equals(C2091ql.class)) {
                E cast6 = cls.cast(new RealmProfileRealmProxy());
                realmObjectContext.clear();
                return cast6;
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
        if (superclass.equals(C2098qr.class)) {
            return (E) ((RealmModel) superclass.cast(RealmVideoDetailsRealmProxy.copyOrUpdate(realm, (C2098qr) e, z, map)));
        }
        if (superclass.equals(C2100qt.class)) {
            return (E) ((RealmModel) superclass.cast(RealmWatchedEpisodeRealmProxy.copyOrUpdate(realm, (C2100qt) e, z, map)));
        }
        if (superclass.equals(C2092qm.class)) {
            return (E) ((RealmModel) superclass.cast(RealmPlayableRealmProxy.copyOrUpdate(realm, (C2092qm) e, z, map)));
        }
        if (superclass.equals(C2099qs.class)) {
            return (E) ((RealmModel) superclass.cast(RealmWatchedShowRealmProxy.copyOrUpdate(realm, (C2099qs) e, z, map)));
        }
        if (superclass.equals(RealmIncompleteVideoDetails.class)) {
            return (E) ((RealmModel) superclass.cast(RealmIncompleteVideoDetailsRealmProxy.copyOrUpdate(realm, (RealmIncompleteVideoDetails) e, z, map)));
        }
        if (superclass.equals(RealmSeason.class)) {
            return (E) ((RealmModel) superclass.cast(RealmSeasonRealmProxy.copyOrUpdate(realm, (RealmSeason) e, z, map)));
        }
        if (superclass.equals(C2091ql.class)) {
            return (E) ((RealmModel) superclass.cast(RealmProfileRealmProxy.copyOrUpdate(realm, (C2091ql) e, z, map)));
        }
        throw getMissingProxyClassException(superclass);
    }
}
