package io.realm.internal;

import io.realm.RealmModel;
import io.realm.exceptions.RealmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
public final class ColumnIndices {
    private final Map<Class<? extends RealmModel>, ColumnInfo> classToColumnInfoMap = new HashMap();
    private final RealmProxyMediator mediator;
    private final OsSchemaInfo osSchemaInfo;
    private final Map<String, ColumnInfo> simpleClassNameToColumnInfoMap = new HashMap();

    public ColumnIndices(RealmProxyMediator realmProxyMediator, OsSchemaInfo osSchemaInfo2) {
        this.mediator = realmProxyMediator;
        this.osSchemaInfo = osSchemaInfo2;
    }

    public ColumnInfo getColumnInfo(Class<? extends RealmModel> cls) {
        ColumnInfo columnInfo = this.classToColumnInfoMap.get(cls);
        if (columnInfo != null) {
            return columnInfo;
        }
        ColumnInfo createColumnInfo = this.mediator.createColumnInfo(cls, this.osSchemaInfo);
        this.classToColumnInfoMap.put(cls, createColumnInfo);
        return createColumnInfo;
    }

    public ColumnInfo getColumnInfo(String str) {
        ColumnInfo columnInfo = this.simpleClassNameToColumnInfoMap.get(str);
        if (columnInfo == null) {
            Iterator<Class<? extends RealmModel>> it = this.mediator.getModelClasses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Class<? extends RealmModel> next = it.next();
                if (Table.getClassNameForTable(this.mediator.getTableName(next)).equals(str)) {
                    columnInfo = getColumnInfo(next);
                    this.simpleClassNameToColumnInfoMap.put(str, columnInfo);
                    break;
                }
            }
        }
        if (columnInfo != null) {
            return columnInfo;
        }
        throw new RealmException(String.format(Locale.US, "'%s' doesn't exist in current schema.", str));
    }

    public void refresh() {
        for (Map.Entry<Class<? extends RealmModel>, ColumnInfo> entry : this.classToColumnInfoMap.entrySet()) {
            entry.getValue().copyFrom(this.mediator.createColumnInfo(entry.getKey(), this.osSchemaInfo));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColumnIndices[");
        boolean z = false;
        for (Map.Entry<Class<? extends RealmModel>, ColumnInfo> entry : this.classToColumnInfoMap.entrySet()) {
            if (z) {
                sb.append(",");
            }
            sb.append(entry.getKey().getSimpleName()).append("->").append(entry.getValue());
            z = true;
        }
        return sb.append("]").toString();
    }
}
