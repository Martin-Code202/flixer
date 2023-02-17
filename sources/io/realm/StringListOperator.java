package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;
final class StringListOperator extends ManagedListOperator<String> {
    StringListOperator(BaseRealm baseRealm, OsList osList, Class<String> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public String get(int i) {
        return (String) this.osList.getValue((long) i);
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof String)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.String", obj.getClass().getName()));
        }
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        this.osList.addString((String) obj);
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        this.osList.insertString((long) i, (String) obj);
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        this.osList.setString((long) i, (String) obj);
    }
}
