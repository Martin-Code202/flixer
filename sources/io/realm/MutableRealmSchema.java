package io.realm;

import io.realm.internal.Table;
import java.util.Locale;
/* access modifiers changed from: package-private */
public class MutableRealmSchema extends RealmSchema {
    MutableRealmSchema(BaseRealm baseRealm) {
        super(baseRealm, null);
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema get(String str) {
        checkNotEmpty(str, "Null or empty class names are not allowed");
        String tableNameForClass = Table.getTableNameForClass(str);
        if (!this.realm.getSharedRealm().hasTable(tableNameForClass)) {
            return null;
        }
        return new MutableRealmObjectSchema(this.realm, this, this.realm.getSharedRealm().getTable(tableNameForClass));
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema create(String str) {
        checkNotEmpty(str, "Null or empty class names are not allowed");
        String tableNameForClass = Table.getTableNameForClass(str);
        if (str.length() <= Table.CLASS_NAME_MAX_LENGTH) {
            return new MutableRealmObjectSchema(this.realm, this, this.realm.getSharedRealm().createTable(tableNameForClass));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Class name is too long. Limit is %1$d characters: %2$s", Integer.valueOf(Table.CLASS_NAME_MAX_LENGTH), Integer.valueOf(str.length())));
    }
}
