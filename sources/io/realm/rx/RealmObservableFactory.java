package io.realm.rx;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.ObjectChangeSet;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmObjectChangeListener;
import io.realm.RealmResults;
import java.util.IdentityHashMap;
import java.util.Map;
public class RealmObservableFactory implements RxObservableFactory {
    private static final BackpressureStrategy BACK_PRESSURE_STRATEGY = BackpressureStrategy.LATEST;
    private ThreadLocal<StrongReferenceCounter<RealmList>> listRefs = new ThreadLocal<StrongReferenceCounter<RealmList>>() { // from class: io.realm.rx.RealmObservableFactory.2
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StrongReferenceCounter<RealmList> initialValue() {
            return new StrongReferenceCounter<>();
        }
    };
    private ThreadLocal<StrongReferenceCounter<RealmModel>> objectRefs = new ThreadLocal<StrongReferenceCounter<RealmModel>>() { // from class: io.realm.rx.RealmObservableFactory.3
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StrongReferenceCounter<RealmModel> initialValue() {
            return new StrongReferenceCounter<>();
        }
    };
    private ThreadLocal<StrongReferenceCounter<RealmResults>> resultsRefs = new ThreadLocal<StrongReferenceCounter<RealmResults>>() { // from class: io.realm.rx.RealmObservableFactory.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StrongReferenceCounter<RealmResults> initialValue() {
            return new StrongReferenceCounter<>();
        }
    };

    @Override // io.realm.rx.RxObservableFactory
    public <E extends RealmModel> Flowable<E> from(Realm realm, final E e) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return Flowable.create(new FlowableOnSubscribe<E>() { // from class: io.realm.rx.RealmObservableFactory.14
        }, BACK_PRESSURE_STRATEGY);
    }

    @Override // io.realm.rx.RxObservableFactory
    public <E extends RealmModel> Observable<ObjectChange<E>> changesetsFrom(Realm realm, final E e) {
        final RealmConfiguration configuration = realm.getConfiguration();
        return Observable.create(new ObservableOnSubscribe<ObjectChange<E>>() { // from class: io.realm.rx.RealmObservableFactory.15
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<ObjectChange<E>> observableEmitter) {
                final Realm instance = Realm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).acquireReference(e);
                final AnonymousClass1 r4 = new RealmObjectChangeListener<E>() { // from class: io.realm.rx.RealmObservableFactory.15.1
                    @Override // io.realm.RealmObjectChangeListener
                    public void onChange(E e2, ObjectChangeSet objectChangeSet) {
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(new ObjectChange(e2, objectChangeSet));
                        }
                    }
                };
                RealmObject.addChangeListener(e, r4);
                observableEmitter.setDisposable(Disposables.fromRunnable(new Runnable() { // from class: io.realm.rx.RealmObservableFactory.15.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RealmObject.removeChangeListener(e, r4);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).releaseReference(e);
                    }
                }));
                observableEmitter.onNext(new ObjectChange<>(e, null));
            }
        });
    }

    @Override // io.realm.rx.RxObservableFactory
    public Flowable<DynamicRealmObject> from(DynamicRealm dynamicRealm, final DynamicRealmObject dynamicRealmObject) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return Flowable.create(new FlowableOnSubscribe<DynamicRealmObject>() { // from class: io.realm.rx.RealmObservableFactory.16
        }, BACK_PRESSURE_STRATEGY);
    }

    @Override // io.realm.rx.RxObservableFactory
    public Observable<ObjectChange<DynamicRealmObject>> changesetsFrom(DynamicRealm dynamicRealm, final DynamicRealmObject dynamicRealmObject) {
        final RealmConfiguration configuration = dynamicRealm.getConfiguration();
        return Observable.create(new ObservableOnSubscribe<ObjectChange<DynamicRealmObject>>() { // from class: io.realm.rx.RealmObservableFactory.17
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<ObjectChange<DynamicRealmObject>> observableEmitter) {
                final DynamicRealm instance = DynamicRealm.getInstance(configuration);
                ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).acquireReference(dynamicRealmObject);
                final AnonymousClass1 r4 = new RealmObjectChangeListener<DynamicRealmObject>() { // from class: io.realm.rx.RealmObservableFactory.17.1
                    public void onChange(DynamicRealmObject dynamicRealmObject2, ObjectChangeSet objectChangeSet) {
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(new ObjectChange(dynamicRealmObject2, objectChangeSet));
                        }
                    }
                };
                dynamicRealmObject.addChangeListener(r4);
                observableEmitter.setDisposable(Disposables.fromRunnable(new Runnable() { // from class: io.realm.rx.RealmObservableFactory.17.2
                    @Override // java.lang.Runnable
                    public void run() {
                        dynamicRealmObject.removeChangeListener(r4);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).releaseReference(dynamicRealmObject);
                    }
                }));
                observableEmitter.onNext(new ObjectChange<>(dynamicRealmObject, null));
            }
        });
    }

    public boolean equals(Object obj) {
        return obj instanceof RealmObservableFactory;
    }

    public int hashCode() {
        return 37;
    }

    /* access modifiers changed from: package-private */
    public static class StrongReferenceCounter<K> {
        private final Map<K, Integer> references;

        private StrongReferenceCounter() {
            this.references = new IdentityHashMap();
        }

        public void acquireReference(K k) {
            Integer num = this.references.get(k);
            if (num == null) {
                this.references.put(k, 1);
            } else {
                this.references.put(k, Integer.valueOf(num.intValue() + 1));
            }
        }

        public void releaseReference(K k) {
            Integer num = this.references.get(k);
            if (num == null) {
                throw new IllegalStateException("Object does not have any references: " + ((Object) k));
            } else if (num.intValue() > 1) {
                this.references.put(k, Integer.valueOf(num.intValue() - 1));
            } else if (num.intValue() == 1) {
                this.references.remove(k);
            } else {
                throw new IllegalStateException("Invalid reference count: " + num);
            }
        }
    }
}
