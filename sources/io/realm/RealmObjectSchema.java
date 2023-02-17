package io.realm;

import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectStore;
import io.realm.internal.Table;
import io.realm.internal.fields.FieldDescriptor;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public abstract class RealmObjectSchema {
    static final Map<Class<?>, FieldMetaData> SUPPORTED_LINKED_FIELDS;
    static final Map<Class<?>, FieldMetaData> SUPPORTED_SIMPLE_FIELDS;
    private final ColumnInfo columnInfo;
    final BaseRealm realm;
    final RealmSchema schema;
    final Table table;

    public abstract RealmObjectSchema addField(String str, Class<?> cls, FieldAttribute... fieldAttributeArr);

    public abstract RealmObjectSchema addPrimaryKey(String str);

    public abstract RealmObjectSchema addRealmListField(String str, RealmObjectSchema realmObjectSchema);

    public abstract RealmObjectSchema removeField(String str);

    public abstract RealmObjectSchema renameField(String str, String str2);

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(String.class, new FieldMetaData(RealmFieldType.STRING, RealmFieldType.STRING_LIST, true));
        hashMap.put(Short.TYPE, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Short.class, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(Integer.TYPE, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Integer.class, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(Long.TYPE, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Long.class, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(Float.TYPE, new FieldMetaData(RealmFieldType.FLOAT, RealmFieldType.FLOAT_LIST, false));
        hashMap.put(Float.class, new FieldMetaData(RealmFieldType.FLOAT, RealmFieldType.FLOAT_LIST, true));
        hashMap.put(Double.TYPE, new FieldMetaData(RealmFieldType.DOUBLE, RealmFieldType.DOUBLE_LIST, false));
        hashMap.put(Double.class, new FieldMetaData(RealmFieldType.DOUBLE, RealmFieldType.DOUBLE_LIST, true));
        hashMap.put(Boolean.TYPE, new FieldMetaData(RealmFieldType.BOOLEAN, RealmFieldType.BOOLEAN_LIST, false));
        hashMap.put(Boolean.class, new FieldMetaData(RealmFieldType.BOOLEAN, RealmFieldType.BOOLEAN_LIST, true));
        hashMap.put(Byte.TYPE, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Byte.class, new FieldMetaData(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(byte[].class, new FieldMetaData(RealmFieldType.BINARY, RealmFieldType.BINARY_LIST, true));
        hashMap.put(Date.class, new FieldMetaData(RealmFieldType.DATE, RealmFieldType.DATE_LIST, true));
        SUPPORTED_SIMPLE_FIELDS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(RealmObject.class, new FieldMetaData(RealmFieldType.OBJECT, null, false));
        hashMap2.put(RealmList.class, new FieldMetaData(RealmFieldType.LIST, null, false));
        SUPPORTED_LINKED_FIELDS = Collections.unmodifiableMap(hashMap2);
    }

    RealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table2, ColumnInfo columnInfo2) {
        this.schema = realmSchema;
        this.realm = baseRealm;
        this.table = table2;
        this.columnInfo = columnInfo2;
    }

    public String getClassName() {
        return this.table.getClassName();
    }

    public boolean hasField(String str) {
        return this.table.getColumnIndex(str) != -1;
    }

    public boolean hasPrimaryKey() {
        return OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, getClassName()) != null;
    }

    public String getPrimaryKey() {
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, getClassName());
        if (primaryKeyForObject != null) {
            return primaryKeyForObject;
        }
        throw new IllegalStateException(getClassName() + " doesn't have a primary key.");
    }

    /* access modifiers changed from: protected */
    public final FieldDescriptor getColumnIndices(String str, RealmFieldType... realmFieldTypeArr) {
        return FieldDescriptor.createStandardFieldDescriptor(getSchemaConnector(), getTable(), str, realmFieldTypeArr);
    }

    /* access modifiers changed from: package-private */
    public Table getTable() {
        return this.table;
    }

    private SchemaConnector getSchemaConnector() {
        return new SchemaConnector(this.schema);
    }

    static void checkLegalName(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Field name can not be null or empty");
        } else if (str.contains(".")) {
            throw new IllegalArgumentException("Field name can not contain '.'");
        } else if (str.length() > 63) {
            throw new IllegalArgumentException("Field name is currently limited to max 63 characters.");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkFieldExists(String str) {
        if (this.table.getColumnIndex(str) == -1) {
            throw new IllegalArgumentException("Field name doesn't exist on object '" + getClassName() + "': " + str);
        }
    }

    /* access modifiers changed from: package-private */
    public long getColumnIndex(String str) {
        long columnIndex = this.table.getColumnIndex(str);
        if (columnIndex != -1) {
            return columnIndex;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Field name '%s' does not exist on schema for '%s'", str, getClassName()));
    }

    static final class DynamicColumnIndices extends ColumnInfo {
        private final Table table;

        DynamicColumnIndices(Table table2) {
            super((ColumnInfo) null, false);
            this.table = table2;
        }

        @Override // io.realm.internal.ColumnInfo
        public ColumnInfo.ColumnDetails getColumnDetails(String str) {
            throw new UnsupportedOperationException("DynamicColumnIndices do not support 'getColumnDetails'");
        }

        @Override // io.realm.internal.ColumnInfo
        public void copyFrom(ColumnInfo columnInfo) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot be copied");
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot copy");
        }
    }

    static final class FieldMetaData {
        final boolean defaultNullable;
        final RealmFieldType fieldType;
        final RealmFieldType listType;

        FieldMetaData(RealmFieldType realmFieldType, RealmFieldType realmFieldType2, boolean z) {
            this.fieldType = realmFieldType;
            this.listType = realmFieldType2;
            this.defaultNullable = z;
        }
    }
}
