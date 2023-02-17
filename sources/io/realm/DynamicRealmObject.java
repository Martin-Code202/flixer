package io.realm;

import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import java.util.Arrays;
import java.util.Locale;
public class DynamicRealmObject extends RealmObject implements RealmObjectProxy {
    private final ProxyState<DynamicRealmObject> proxyState = new ProxyState<>(this);

    DynamicRealmObject(BaseRealm baseRealm, Row row) {
        this.proxyState.setRealm$realm(baseRealm);
        this.proxyState.setRow$realm(row);
        this.proxyState.setConstructionFinished();
    }

    public String[] getFieldNames() {
        this.proxyState.getRealm$realm().checkIfValid();
        String[] strArr = new String[((int) this.proxyState.getRow$realm().getColumnCount())];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = this.proxyState.getRow$realm().getColumnName((long) i);
        }
        return strArr;
    }

    public void setNull(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        if (this.proxyState.getRow$realm().getColumnType(columnIndex) == RealmFieldType.OBJECT) {
            this.proxyState.getRow$realm().nullifyLink(columnIndex);
            return;
        }
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setNull(columnIndex);
    }

    public String getType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getTable().getClassName();
    }

    public int hashCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        String path = this.proxyState.getRealm$realm().getPath();
        String name = this.proxyState.getRow$realm().getTable().getName();
        long index = this.proxyState.getRow$realm().getIndex();
        return (((((path != null ? path.hashCode() : 0) + 527) * 31) + (name != null ? name.hashCode() : 0)) * 31) + ((int) ((index >>> 32) ^ index));
    }

    public boolean equals(Object obj) {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DynamicRealmObject dynamicRealmObject = (DynamicRealmObject) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = dynamicRealmObject.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = dynamicRealmObject.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        return this.proxyState.getRow$realm().getIndex() == dynamicRealmObject.proxyState.getRow$realm().getIndex();
    }

    public String toString() {
        String str;
        this.proxyState.getRealm$realm().checkIfValid();
        if (!this.proxyState.getRow$realm().isAttached()) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder(this.proxyState.getRow$realm().getTable().getClassName() + " = dynamic[");
        String[] fieldNames = getFieldNames();
        for (String str2 : fieldNames) {
            long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str2);
            RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(columnIndex);
            sb.append("{");
            sb.append(str2).append(":");
            switch (columnType) {
                case BOOLEAN:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(columnIndex)));
                    break;
                case INTEGER:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Long.valueOf(this.proxyState.getRow$realm().getLong(columnIndex)));
                    break;
                case FLOAT:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Float.valueOf(this.proxyState.getRow$realm().getFloat(columnIndex)));
                    break;
                case DOUBLE:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Double.valueOf(this.proxyState.getRow$realm().getDouble(columnIndex)));
                    break;
                case STRING:
                    sb.append(this.proxyState.getRow$realm().getString(columnIndex));
                    break;
                case BINARY:
                    sb.append(Arrays.toString(this.proxyState.getRow$realm().getBinaryByteArray(columnIndex)));
                    break;
                case DATE:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : this.proxyState.getRow$realm().getDate(columnIndex));
                    break;
                case OBJECT:
                    if (this.proxyState.getRow$realm().isNullLink(columnIndex)) {
                        str = "null";
                    } else {
                        str = this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getClassName();
                    }
                    sb.append(str);
                    break;
                case LIST:
                    sb.append(String.format(Locale.US, "RealmList<%s>[%s]", this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getClassName(), Long.valueOf(this.proxyState.getRow$realm().getModelList(columnIndex).size())));
                    break;
                case LINKING_OBJECTS:
                default:
                    sb.append("?");
                    break;
                case INTEGER_LIST:
                    sb.append(String.format(Locale.US, "RealmList<Long>[%s]", Long.valueOf(this.proxyState.getRow$realm().getValueList(columnIndex, columnType).size())));
                    break;
                case BOOLEAN_LIST:
                    sb.append(String.format(Locale.US, "RealmList<Boolean>[%s]", Long.valueOf(this.proxyState.getRow$realm().getValueList(columnIndex, columnType).size())));
                    break;
                case STRING_LIST:
                    sb.append(String.format(Locale.US, "RealmList<String>[%s]", Long.valueOf(this.proxyState.getRow$realm().getValueList(columnIndex, columnType).size())));
                    break;
                case BINARY_LIST:
                    sb.append(String.format(Locale.US, "RealmList<byte[]>[%s]", Long.valueOf(this.proxyState.getRow$realm().getValueList(columnIndex, columnType).size())));
                    break;
                case DATE_LIST:
                    sb.append(String.format(Locale.US, "RealmList<Date>[%s]", Long.valueOf(this.proxyState.getRow$realm().getValueList(columnIndex, columnType).size())));
                    break;
                case FLOAT_LIST:
                    sb.append(String.format(Locale.US, "RealmList<Float>[%s]", Long.valueOf(this.proxyState.getRow$realm().getValueList(columnIndex, columnType).size())));
                    break;
                case DOUBLE_LIST:
                    sb.append(String.format(Locale.US, "RealmList<Double>[%s]", Long.valueOf(this.proxyState.getRow$realm().getValueList(columnIndex, columnType).size())));
                    break;
            }
            sb.append("},");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }

    public DynamicRealm getDynamicRealm() {
        BaseRealm realm$realm = realmGet$proxyState().getRealm$realm();
        realm$realm.checkIfValid();
        if (isValid()) {
            return (DynamicRealm) realm$realm;
        }
        throw new IllegalStateException("the object is already deleted.");
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
    }

    @Override // io.realm.internal.RealmObjectProxy
    public ProxyState realmGet$proxyState() {
        return this.proxyState;
    }

    private void checkIsPrimaryKey(String str) {
        RealmObjectSchema schemaForClass = this.proxyState.getRealm$realm().getSchema().getSchemaForClass(getType());
        if (schemaForClass.hasPrimaryKey() && schemaForClass.getPrimaryKey().equals(str)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Primary key field '%s' cannot be changed after object was created.", str));
        }
    }
}
