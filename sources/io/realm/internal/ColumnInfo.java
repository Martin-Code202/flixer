package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.HashMap;
import java.util.Map;
public abstract class ColumnInfo {
    private final Map<String, ColumnDetails> indicesMap;
    private final boolean mutable;

    public abstract void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2);

    public static final class ColumnDetails {
        public final long columnIndex;
        public final RealmFieldType columnType;
        public final String linkedClassName;

        private ColumnDetails(long j, RealmFieldType realmFieldType, String str) {
            this.columnIndex = j;
            this.columnType = realmFieldType;
            this.linkedClassName = str;
        }

        ColumnDetails(Property property) {
            this(property.getColumnIndex(), property.getType(), property.getLinkedObjectName());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ColumnDetails[");
            sb.append(this.columnIndex);
            sb.append(", ").append(this.columnType);
            sb.append(", ").append(this.linkedClassName);
            return sb.append("]").toString();
        }
    }

    protected ColumnInfo(int i) {
        this(i, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected ColumnInfo(ColumnInfo columnInfo, boolean z) {
        this(columnInfo == null ? 0 : columnInfo.indicesMap.size(), z);
        if (columnInfo != null) {
            this.indicesMap.putAll(columnInfo.indicesMap);
        }
    }

    private ColumnInfo(int i, boolean z) {
        this.indicesMap = new HashMap(i);
        this.mutable = z;
    }

    public ColumnDetails getColumnDetails(String str) {
        return this.indicesMap.get(str);
    }

    public void copyFrom(ColumnInfo columnInfo) {
        if (!this.mutable) {
            throw new UnsupportedOperationException("Attempt to modify an immutable ColumnInfo");
        } else if (null == columnInfo) {
            throw new NullPointerException("Attempt to copy null ColumnInfo");
        } else {
            this.indicesMap.clear();
            this.indicesMap.putAll(columnInfo.indicesMap);
            copy(columnInfo, this);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColumnInfo[");
        sb.append(this.mutable).append(",");
        if (this.indicesMap != null) {
            boolean z = false;
            for (Map.Entry<String, ColumnDetails> entry : this.indicesMap.entrySet()) {
                if (z) {
                    sb.append(",");
                }
                sb.append(entry.getKey()).append("->").append(entry.getValue());
                z = true;
            }
        }
        return sb.append("]").toString();
    }

    /* access modifiers changed from: protected */
    public final long addColumnDetails(String str, OsObjectSchemaInfo osObjectSchemaInfo) {
        Property property = osObjectSchemaInfo.getProperty(str);
        this.indicesMap.put(str, new ColumnDetails(property));
        return property.getColumnIndex();
    }
}
