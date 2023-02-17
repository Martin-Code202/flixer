package io.realm.rx;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.Realm;
import io.realm.RealmModel;
public interface RxObservableFactory {
    Observable<ObjectChange<DynamicRealmObject>> changesetsFrom(DynamicRealm dynamicRealm, DynamicRealmObject dynamicRealmObject);

    <E extends RealmModel> Observable<ObjectChange<E>> changesetsFrom(Realm realm, E e);

    Flowable<DynamicRealmObject> from(DynamicRealm dynamicRealm, DynamicRealmObject dynamicRealmObject);

    <E extends RealmModel> Flowable<E> from(Realm realm, E e);
}
