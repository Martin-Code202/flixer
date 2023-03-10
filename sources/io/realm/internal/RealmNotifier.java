package io.realm.internal;

import io.realm.RealmChangeListener;
import io.realm.internal.ObserverPairList;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
@Keep
public abstract class RealmNotifier implements Closeable {
    private final ObserverPairList.Callback<RealmObserverPair> onChangeCallBack = new ObserverPairList.Callback<RealmObserverPair>() { // from class: io.realm.internal.RealmNotifier.1
        public void onCalled(RealmObserverPair realmObserverPair, Object obj) {
            if (RealmNotifier.this.sharedRealm != null && !RealmNotifier.this.sharedRealm.isClosed()) {
                realmObserverPair.onChange(obj);
            }
        }
    };
    private ObserverPairList<RealmObserverPair> realmObserverPairs = new ObserverPairList<>();
    private SharedRealm sharedRealm;
    private List<Runnable> transactionCallbacks = new ArrayList();

    public abstract boolean post(Runnable runnable);

    /* access modifiers changed from: package-private */
    public static class RealmObserverPair<T> extends ObserverPairList.ObserverPair<T, RealmChangeListener<T>> {
        public RealmObserverPair(T t, RealmChangeListener<T> realmChangeListener) {
            super(t, realmChangeListener);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void onChange(T t) {
            if (t != null) {
                ((RealmChangeListener) this.listener).onChange(t);
            }
        }
    }

    protected RealmNotifier(SharedRealm sharedRealm2) {
        this.sharedRealm = sharedRealm2;
    }

    /* access modifiers changed from: package-private */
    public void didChange() {
        this.realmObserverPairs.foreach(this.onChangeCallBack);
        if (!this.transactionCallbacks.isEmpty()) {
            List<Runnable> list = this.transactionCallbacks;
            this.transactionCallbacks = new ArrayList();
            for (Runnable runnable : list) {
                runnable.run();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void beforeNotify() {
        this.sharedRealm.invalidateIterators();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        removeAllChangeListeners();
    }

    public <T> void addChangeListener(T t, RealmChangeListener<T> realmChangeListener) {
        this.realmObserverPairs.add(new RealmObserverPair(t, realmChangeListener));
    }

    public <E> void removeChangeListener(E e, RealmChangeListener<E> realmChangeListener) {
        this.realmObserverPairs.remove(e, realmChangeListener);
    }

    public <E> void removeChangeListeners(E e) {
        this.realmObserverPairs.removeByObserver(e);
    }

    private void removeAllChangeListeners() {
        this.realmObserverPairs.clear();
    }

    public void addTransactionCallback(Runnable runnable) {
        this.transactionCallbacks.add(runnable);
    }

    public int getListenersListSize() {
        return this.realmObserverPairs.size();
    }
}
