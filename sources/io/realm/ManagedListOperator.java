package io.realm;

import io.realm.internal.OsList;
/* access modifiers changed from: package-private */
public abstract class ManagedListOperator<T> {
    final Class<T> clazz;
    final OsList osList;
    final BaseRealm realm;

    /* access modifiers changed from: protected */
    public abstract void appendValue(Object obj);

    /* access modifiers changed from: protected */
    public abstract void checkValidValue(Object obj);

    public abstract T get(int i);

    /* access modifiers changed from: protected */
    public abstract void insertValue(int i, Object obj);

    /* access modifiers changed from: protected */
    public abstract void setValue(int i, Object obj);

    ManagedListOperator(BaseRealm baseRealm, OsList osList2, Class<T> cls) {
        this.realm = baseRealm;
        this.clazz = cls;
        this.osList = osList2;
    }

    public final boolean isValid() {
        return this.osList.isValid();
    }

    public final int size() {
        long size = this.osList.size();
        if (size < 2147483647L) {
            return (int) size;
        }
        return Integer.MAX_VALUE;
    }

    public final void append(Object obj) {
        checkValidValue(obj);
        if (obj == null) {
            appendNull();
        } else {
            appendValue(obj);
        }
    }

    private void appendNull() {
        this.osList.addNull();
    }

    public final void insert(int i, Object obj) {
        checkValidValue(obj);
        if (obj == null) {
            insertNull(i);
        } else {
            insertValue(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void insertNull(int i) {
        this.osList.insertNull((long) i);
    }

    public final T set(int i, Object obj) {
        checkValidValue(obj);
        T t = get(i);
        if (obj == null) {
            setNull(i);
        } else {
            setValue(i, obj);
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public void setNull(int i) {
        this.osList.setNull((long) i);
    }

    /* access modifiers changed from: package-private */
    public final void remove(int i) {
        this.osList.remove((long) i);
    }

    /* access modifiers changed from: package-private */
    public final void removeAll() {
        this.osList.removeAll();
    }
}
