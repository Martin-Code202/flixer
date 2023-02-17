package io.realm.internal.fields;

import io.realm.RealmFieldType;
import io.realm.internal.ColumnInfo;
import io.realm.internal.fields.FieldDescriptor;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* access modifiers changed from: package-private */
public class CachedFieldDescriptor extends FieldDescriptor {
    private final String className;
    private final FieldDescriptor.SchemaProxy schema;

    CachedFieldDescriptor(FieldDescriptor.SchemaProxy schemaProxy, String str, String str2, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str2, set, set2);
        this.className = str;
        this.schema = schemaProxy;
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.internal.fields.FieldDescriptor
    public void compileFieldDescription(List<String> list) {
        long j;
        int size = list.size();
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        String str = this.className;
        String str2 = null;
        RealmFieldType realmFieldType = null;
        for (int i = 0; i < size; i++) {
            str2 = list.get(i);
            if (str2 == null || str2.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            ColumnInfo columnInfo = this.schema.getColumnInfo(str);
            if (columnInfo == null) {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: class '%s' not found in this schema.", str));
            }
            ColumnInfo.ColumnDetails columnDetails = columnInfo.getColumnDetails(str2);
            if (columnDetails == null) {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in class '%s'.", str2, str));
            }
            realmFieldType = columnDetails.columnType;
            if (i < size - 1) {
                verifyInternalColumnType(str, str2, realmFieldType);
                str = columnDetails.linkedClassName;
            }
            jArr[i] = columnDetails.columnIndex;
            if (realmFieldType != RealmFieldType.LINKING_OBJECTS) {
                j = 0;
            } else {
                j = this.schema.getNativeTablePtr(columnDetails.linkedClassName);
            }
            jArr2[i] = j;
        }
        setCompilationResults(str, str2, realmFieldType, jArr, jArr2);
    }
}
