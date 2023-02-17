package io.realm;

import io.realm.internal.ColumnIndices;
import io.realm.internal.ColumnInfo;
import io.realm.internal.Table;
import io.realm.internal.Util;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
public abstract class RealmSchema {
    private final Map<Class<? extends RealmModel>, RealmObjectSchema> classToSchema = new HashMap();
    private final Map<Class<? extends RealmModel>, Table> classToTable = new HashMap();
    private final ColumnIndices columnIndices;
    private final Map<String, RealmObjectSchema> dynamicClassToSchema = new HashMap();
    private final Map<String, Table> dynamicClassToTable = new HashMap();
    final BaseRealm realm;

    public abstract RealmObjectSchema create(String str);

    public abstract RealmObjectSchema get(String str);

    RealmSchema(BaseRealm baseRealm, ColumnIndices columnIndices2) {
        this.realm = baseRealm;
        this.columnIndices = columnIndices2;
    }

    public Set<RealmObjectSchema> getAll() {
        int size = (int) this.realm.getSharedRealm().size();
        LinkedHashSet linkedHashSet = new LinkedHashSet(size);
        for (int i = 0; i < size; i++) {
            RealmObjectSchema realmObjectSchema = get(Table.getClassNameForTable(this.realm.getSharedRealm().getTableName(i)));
            if (realmObjectSchema != null) {
                linkedHashSet.add(realmObjectSchema);
            }
        }
        return linkedHashSet;
    }

    /* access modifiers changed from: package-private */
    public void checkNotEmpty(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* access modifiers changed from: package-private */
    public Table getTable(String str) {
        String tableNameForClass = Table.getTableNameForClass(str);
        Table table = this.dynamicClassToTable.get(tableNameForClass);
        if (table != null) {
            return table;
        }
        Table table2 = this.realm.getSharedRealm().getTable(tableNameForClass);
        this.dynamicClassToTable.put(tableNameForClass, table2);
        return table2;
    }

    /* access modifiers changed from: package-private */
    public Table getTable(Class<? extends RealmModel> cls) {
        Table table = this.classToTable.get(cls);
        if (table != null) {
            return table;
        }
        Class<? extends RealmModel> originalModelClass = Util.getOriginalModelClass(cls);
        if (isProxyClass(originalModelClass, cls)) {
            table = this.classToTable.get(originalModelClass);
        }
        if (table == null) {
            table = this.realm.getSharedRealm().getTable(this.realm.getConfiguration().getSchemaMediator().getTableName(originalModelClass));
            this.classToTable.put(originalModelClass, table);
        }
        if (isProxyClass(originalModelClass, cls)) {
            this.classToTable.put(cls, table);
        }
        return table;
    }

    /* access modifiers changed from: package-private */
    public RealmObjectSchema getSchemaForClass(Class<? extends RealmModel> cls) {
        RealmObjectSchema realmObjectSchema = this.classToSchema.get(cls);
        if (realmObjectSchema != null) {
            return realmObjectSchema;
        }
        Class<? extends RealmModel> originalModelClass = Util.getOriginalModelClass(cls);
        if (isProxyClass(originalModelClass, cls)) {
            realmObjectSchema = this.classToSchema.get(originalModelClass);
        }
        if (realmObjectSchema == null) {
            realmObjectSchema = new ImmutableRealmObjectSchema(this.realm, this, getTable(cls), getColumnInfo(originalModelClass));
            this.classToSchema.put(originalModelClass, realmObjectSchema);
        }
        if (isProxyClass(originalModelClass, cls)) {
            this.classToSchema.put(cls, realmObjectSchema);
        }
        return realmObjectSchema;
    }

    /* access modifiers changed from: package-private */
    public RealmObjectSchema getSchemaForClass(String str) {
        String tableNameForClass = Table.getTableNameForClass(str);
        RealmObjectSchema realmObjectSchema = this.dynamicClassToSchema.get(tableNameForClass);
        if (realmObjectSchema != null && realmObjectSchema.getTable().isValid() && realmObjectSchema.getClassName().equals(str)) {
            return realmObjectSchema;
        }
        if (!this.realm.getSharedRealm().hasTable(tableNameForClass)) {
            throw new IllegalArgumentException("The class " + str + " doesn't exist in this Realm.");
        }
        ImmutableRealmObjectSchema immutableRealmObjectSchema = new ImmutableRealmObjectSchema(this.realm, this, this.realm.getSharedRealm().getTable(tableNameForClass));
        this.dynamicClassToSchema.put(tableNameForClass, immutableRealmObjectSchema);
        return immutableRealmObjectSchema;
    }

    private boolean isProxyClass(Class<? extends RealmModel> cls, Class<? extends RealmModel> cls2) {
        return cls.equals(cls2);
    }

    /* access modifiers changed from: package-private */
    public final boolean haveColumnInfo() {
        return this.columnIndices != null;
    }

    /* access modifiers changed from: package-private */
    public final ColumnInfo getColumnInfo(Class<? extends RealmModel> cls) {
        checkIndices();
        return this.columnIndices.getColumnInfo(cls);
    }

    /* access modifiers changed from: protected */
    public final ColumnInfo getColumnInfo(String str) {
        checkIndices();
        return this.columnIndices.getColumnInfo(str);
    }

    private void checkIndices() {
        if (!haveColumnInfo()) {
            throw new IllegalStateException("Attempt to use column index before set.");
        }
    }

    /* access modifiers changed from: package-private */
    public void refresh() {
        if (this.columnIndices != null) {
            this.columnIndices.refresh();
        }
        this.dynamicClassToTable.clear();
        this.classToTable.clear();
        this.classToSchema.clear();
        this.dynamicClassToSchema.clear();
    }
}
