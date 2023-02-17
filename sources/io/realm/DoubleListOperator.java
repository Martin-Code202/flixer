package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;
final class DoubleListOperator extends ManagedListOperator<Double> {
    DoubleListOperator(BaseRealm baseRealm, OsList osList, Class<Double> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public Double get(int i) {
        return (Double) this.osList.getValue((long) i);
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Number)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.Number", obj.getClass().getName()));
        }
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        this.osList.addDouble(((Number) obj).doubleValue());
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        this.osList.insertDouble((long) i, ((Number) obj).doubleValue());
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        this.osList.setDouble((long) i, ((Number) obj).doubleValue());
    }
}
