package io.realm;

import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.Table;
/* access modifiers changed from: package-private */
public class ImmutableRealmObjectSchema extends RealmObjectSchema {
    ImmutableRealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table, ColumnInfo columnInfo) {
        super(baseRealm, realmSchema, table, columnInfo);
    }

    ImmutableRealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table) {
        super(baseRealm, realmSchema, table, new RealmObjectSchema.DynamicColumnIndices(table));
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addField(String str, Class<?> cls, FieldAttribute... fieldAttributeArr) {
        throw new UnsupportedOperationException("This 'RealmObjectSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addRealmListField(String str, RealmObjectSchema realmObjectSchema) {
        throw new UnsupportedOperationException("This 'RealmObjectSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema removeField(String str) {
        throw new UnsupportedOperationException("This 'RealmObjectSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema renameField(String str, String str2) {
        throw new UnsupportedOperationException("This 'RealmObjectSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addPrimaryKey(String str) {
        throw new UnsupportedOperationException("This 'RealmObjectSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }
}
