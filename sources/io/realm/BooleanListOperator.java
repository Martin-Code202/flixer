package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;
final class BooleanListOperator extends ManagedListOperator<Boolean> {
    BooleanListOperator(BaseRealm baseRealm, OsList osList, Class<Boolean> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public Boolean get(int i) {
        return (Boolean) this.osList.getValue((long) i);
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Boolean)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.Boolean", obj.getClass().getName()));
        }
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        this.osList.addBoolean(((Boolean) obj).booleanValue());
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        this.osList.insertBoolean((long) i, ((Boolean) obj).booleanValue());
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        this.osList.setBoolean((long) i, ((Boolean) obj).booleanValue());
    }
}
