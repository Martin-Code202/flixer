package io.realm.internal;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.exceptions.RealmException;
import java.util.List;
import java.util.Map;
import java.util.Set;
public abstract class RealmProxyMediator {
    public abstract <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map);

    public abstract ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo);

    public abstract Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap();

    public abstract Set<Class<? extends RealmModel>> getModelClasses();

    @Deprecated
    public abstract String getTableName(Class<? extends RealmModel> cls);

    public abstract <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list);

    public String getSimpleClassName(Class<? extends RealmModel> cls) {
        return Table.getClassNameForTable(getTableName(Util.getOriginalModelClass(cls)));
    }

    public boolean transformerApplied() {
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RealmProxyMediator)) {
            return false;
        }
        return getModelClasses().equals(((RealmProxyMediator) obj).getModelClasses());
    }

    public int hashCode() {
        return getModelClasses().hashCode();
    }

    protected static void checkClass(Class<? extends RealmModel> cls) {
        if (cls == null) {
            throw new NullPointerException("A class extending RealmObject must be provided");
        }
    }

    protected static RealmException getMissingProxyClassException(Class<? extends RealmModel> cls) {
        return new RealmException(String.format("'%s' is not part of the schema for this Realm.", cls.toString()));
    }
}
