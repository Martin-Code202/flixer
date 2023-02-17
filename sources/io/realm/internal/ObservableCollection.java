package io.realm.internal;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmChangeListener;
import io.realm.internal.ObserverPairList;
@Keep
interface ObservableCollection {
    void notifyChangeListeners(long j);

    public static class CollectionObserverPair<T> extends ObserverPairList.ObserverPair<T, Object> {
        public void onChange(T t, OrderedCollectionChangeSet orderedCollectionChangeSet) {
            if (this.listener instanceof OrderedRealmCollectionChangeListener) {
                ((OrderedRealmCollectionChangeListener) this.listener).onChange(t, orderedCollectionChangeSet);
            } else if (this.listener instanceof RealmChangeListener) {
                ((RealmChangeListener) this.listener).onChange(t);
            } else {
                throw new RuntimeException("Unsupported listener type: " + this.listener);
            }
        }
    }

    public static class RealmChangeListenerWrapper<T> implements OrderedRealmCollectionChangeListener<T> {
        private final RealmChangeListener<T> listener;

        RealmChangeListenerWrapper(RealmChangeListener<T> realmChangeListener) {
            this.listener = realmChangeListener;
        }

        @Override // io.realm.OrderedRealmCollectionChangeListener
        public void onChange(T t, OrderedCollectionChangeSet orderedCollectionChangeSet) {
            this.listener.onChange(t);
        }

        public boolean equals(Object obj) {
            return (obj instanceof RealmChangeListenerWrapper) && this.listener == ((RealmChangeListenerWrapper) obj).listener;
        }

        public int hashCode() {
            return this.listener.hashCode();
        }
    }

    public static class Callback implements ObserverPairList.Callback<CollectionObserverPair> {
        private final OrderedCollectionChangeSet changeSet;

        Callback(OrderedCollectionChangeSet orderedCollectionChangeSet) {
            this.changeSet = orderedCollectionChangeSet;
        }

        public void onCalled(CollectionObserverPair collectionObserverPair, Object obj) {
            collectionObserverPair.onChange(obj, this.changeSet);
        }
    }
}
