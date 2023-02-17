package io.realm;

import io.realm.RealmModel;
public interface RealmObjectChangeListener<T extends RealmModel> {
    void onChange(T t, ObjectChangeSet objectChangeSet);
}
