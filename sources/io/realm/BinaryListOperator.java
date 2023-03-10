package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;
final class BinaryListOperator extends ManagedListOperator<byte[]> {
    BinaryListOperator(BaseRealm baseRealm, OsList osList, Class<byte[]> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public byte[] get(int i) {
        return (byte[]) this.osList.getValue((long) i);
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof byte[])) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "byte[]", obj.getClass().getName()));
        }
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        this.osList.addBinary((byte[]) obj);
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        this.osList.insertBinary((long) i, (byte[]) obj);
    }

    /* access modifiers changed from: protected */
    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        this.osList.setBinary((long) i, (byte[]) obj);
    }
}
