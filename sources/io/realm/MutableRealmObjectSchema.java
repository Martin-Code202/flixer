package io.realm;

import io.realm.RealmObjectSchema;
import io.realm.internal.OsObjectStore;
import io.realm.internal.Table;
import java.util.Locale;
class MutableRealmObjectSchema extends RealmObjectSchema {
    MutableRealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table) {
        super(baseRealm, realmSchema, table, new RealmObjectSchema.DynamicColumnIndices(table));
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addField(String str, Class<?> cls, FieldAttribute... fieldAttributeArr) {
        RealmObjectSchema.FieldMetaData fieldMetaData = (RealmObjectSchema.FieldMetaData) SUPPORTED_SIMPLE_FIELDS.get(cls);
        if (fieldMetaData != null) {
            if (containsAttribute(fieldAttributeArr, FieldAttribute.PRIMARY_KEY)) {
                checkAddPrimaryKeyForSync();
            }
            checkNewFieldName(str);
            boolean z = fieldMetaData.defaultNullable;
            if (containsAttribute(fieldAttributeArr, FieldAttribute.REQUIRED)) {
                z = false;
            }
            long addColumn = this.table.addColumn(fieldMetaData.fieldType, str, z);
            try {
                addModifiers(str, fieldAttributeArr);
                return this;
            } catch (Exception e) {
                this.table.removeColumn(addColumn);
                throw e;
            }
        } else if (SUPPORTED_LINKED_FIELDS.containsKey(cls)) {
            throw new IllegalArgumentException("Use addRealmObjectField() instead to add fields that link to other RealmObjects: " + str);
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "Realm doesn't support this field type: %s(%s)", str, cls));
        }
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addRealmListField(String str, RealmObjectSchema realmObjectSchema) {
        checkLegalName(str);
        checkFieldNameIsAvailable(str);
        this.table.addColumnLink(RealmFieldType.LIST, str, this.realm.sharedRealm.getTable(Table.getTableNameForClass(realmObjectSchema.getClassName())));
        return this;
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema removeField(String str) {
        this.realm.checkNotInSync();
        checkLegalName(str);
        if (!hasField(str)) {
            throw new IllegalStateException(str + " does not exist.");
        }
        long columnIndex = getColumnIndex(str);
        String className = getClassName();
        if (str.equals(OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, className))) {
            OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, className, str);
        }
        this.table.removeColumn(columnIndex);
        return this;
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema renameField(String str, String str2) {
        this.realm.checkNotInSync();
        checkLegalName(str);
        checkFieldExists(str);
        checkLegalName(str2);
        checkFieldNameIsAvailable(str2);
        this.table.renameColumn(getColumnIndex(str), str2);
        return this;
    }

    public RealmObjectSchema addIndex(String str) {
        checkLegalName(str);
        checkFieldExists(str);
        long columnIndex = getColumnIndex(str);
        if (this.table.hasSearchIndex(columnIndex)) {
            throw new IllegalStateException(str + " already has an index.");
        }
        this.table.addSearchIndex(columnIndex);
        return this;
    }

    @Override // io.realm.RealmObjectSchema
    public RealmObjectSchema addPrimaryKey(String str) {
        checkAddPrimaryKeyForSync();
        checkLegalName(str);
        checkFieldExists(str);
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, getClassName());
        if (primaryKeyForObject != null) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "Field '%s' has been already defined as primary key.", primaryKeyForObject));
        }
        long columnIndex = getColumnIndex(str);
        if (!this.table.hasSearchIndex(columnIndex)) {
            this.table.addSearchIndex(columnIndex);
        }
        OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, getClassName(), str);
        return this;
    }

    private void addModifiers(String str, FieldAttribute[] fieldAttributeArr) {
        if (fieldAttributeArr != null) {
            try {
                if (fieldAttributeArr.length > 0) {
                    if (containsAttribute(fieldAttributeArr, FieldAttribute.INDEXED)) {
                        addIndex(str);
                    }
                    if (containsAttribute(fieldAttributeArr, FieldAttribute.PRIMARY_KEY)) {
                        addPrimaryKey(str);
                    }
                }
            } catch (Exception e) {
                long columnIndex = getColumnIndex(str);
                if (0 != 0) {
                    this.table.removeSearchIndex(columnIndex);
                }
                throw ((RuntimeException) e);
            }
        }
    }

    static boolean containsAttribute(FieldAttribute[] fieldAttributeArr, FieldAttribute fieldAttribute) {
        if (fieldAttributeArr == null || fieldAttributeArr.length == 0) {
            return false;
        }
        for (FieldAttribute fieldAttribute2 : fieldAttributeArr) {
            if (fieldAttribute2 == fieldAttribute) {
                return true;
            }
        }
        return false;
    }

    private void checkNewFieldName(String str) {
        checkLegalName(str);
        checkFieldNameIsAvailable(str);
    }

    private void checkFieldNameIsAvailable(String str) {
        if (this.table.getColumnIndex(str) != -1) {
            throw new IllegalArgumentException("Field already exists in '" + getClassName() + "': " + str);
        }
    }

    private void checkAddPrimaryKeyForSync() {
        if (this.realm.configuration.isSyncConfiguration()) {
            throw new UnsupportedOperationException("'addPrimaryKey' is not supported by synced Realms.");
        }
    }
}
