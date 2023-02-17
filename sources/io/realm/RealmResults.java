package io.realm;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
public class RealmResults<E> extends OrderedRealmCollectionImpl<E> {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.List
    @Deprecated
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        super.add(i, obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.List
    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(int i, Collection collection) {
        return super.addAll(i, collection);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // io.realm.OrderedRealmCollectionImpl
    public /* bridge */ /* synthetic */ boolean deleteAllFromRealm() {
        return super.deleteAllFromRealm();
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return super.get(i);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.List
    @Deprecated
    public /* bridge */ /* synthetic */ Object remove(int i) {
        return super.remove(i);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractList, java.util.List
    @Deprecated
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return super.set(i, obj);
    }

    @Override // io.realm.OrderedRealmCollectionImpl, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    RealmResults(BaseRealm baseRealm, io.realm.internal.Collection collection, Class<E> cls) {
        super(baseRealm, collection, cls);
    }

    RealmResults(BaseRealm baseRealm, io.realm.internal.Collection collection, String str) {
        super(baseRealm, collection, str);
    }

    @Override // io.realm.RealmCollection
    public boolean isLoaded() {
        this.realm.checkIfValid();
        return this.collection.isLoaded();
    }

    public boolean load() {
        this.realm.checkIfValid();
        this.collection.load();
        return true;
    }
}
