package io.realm;

import io.realm.internal.ColumnIndices;
import io.realm.internal.Table;
/* access modifiers changed from: package-private */
public class ImmutableRealmSchema extends RealmSchema {
    ImmutableRealmSchema(BaseRealm baseRealm, ColumnIndices columnIndices) {
        super(baseRealm, columnIndices);
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema get(String str) {
        checkNotEmpty(str, "Null or empty class names are not allowed");
        String tableNameForClass = Table.getTableNameForClass(str);
        if (!this.realm.getSharedRealm().hasTable(tableNameForClass)) {
            return null;
        }
        return new ImmutableRealmObjectSchema(this.realm, this, this.realm.getSharedRealm().getTable(tableNameForClass), getColumnInfo(str));
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema create(String str) {
        throw new UnsupportedOperationException("This 'RealmSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }
}
