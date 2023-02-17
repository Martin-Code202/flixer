package io.realm;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.realm.internal.Collection;
import io.realm.internal.InvalidRow;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.UncheckedRow;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
/* access modifiers changed from: package-private */
public abstract class OrderedRealmCollectionImpl<E> extends AbstractList<E> implements OrderedRealmCollection<E> {
    final String className;
    final Class<E> classSpec;
    final Collection collection;
    @SuppressFBWarnings({"SS_SHOULD_BE_STATIC"})
    final boolean forValues;
    final BaseRealm realm;

    OrderedRealmCollectionImpl(BaseRealm baseRealm, Collection collection2, Class<E> cls) {
        this(baseRealm, collection2, cls, null);
    }

    OrderedRealmCollectionImpl(BaseRealm baseRealm, Collection collection2, String str) {
        this(baseRealm, collection2, null, str);
    }

    private OrderedRealmCollectionImpl(BaseRealm baseRealm, Collection collection2, Class<E> cls, String str) {
        this.forValues = false;
        this.realm = baseRealm;
        this.collection = collection2;
        this.classSpec = cls;
        this.className = str;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        if (!isLoaded()) {
            return false;
        }
        if ((obj instanceof RealmObjectProxy) && ((RealmObjectProxy) obj).realmGet$proxyState().getRow$realm() == InvalidRow.INSTANCE) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        this.realm.checkIfValid();
        return (E) this.realm.get(this.classSpec, this.className, this.collection.getUncheckedRow(i));
    }

    public boolean deleteAllFromRealm() {
        this.realm.checkIfValid();
        if (size() <= 0) {
            return false;
        }
        this.collection.clear();
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new RealmCollectionIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new RealmCollectionListIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        return new RealmCollectionListIterator(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        if (!isLoaded()) {
            return 0;
        }
        long size = this.collection.size();
        if (size > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) size;
    }

    @Override // java.util.AbstractList, java.util.List
    @Deprecated
    public E remove(int i) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public boolean removeAll(java.util.Collection<?> collection2) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.List
    @Deprecated
    public E set(int i, E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public boolean retainAll(java.util.Collection<?> collection2) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public boolean add(E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.List
    @Deprecated
    public void add(int i, E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractList, java.util.List
    @Deprecated
    public boolean addAll(int i, java.util.Collection<? extends E> collection2) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public boolean addAll(java.util.Collection<? extends E> collection2) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    /* access modifiers changed from: package-private */
    public class RealmCollectionIterator extends Collection.Iterator<E> {
        RealmCollectionIterator() {
            super(OrderedRealmCollectionImpl.this.collection);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.Collection.Iterator
        public E convertRowToObject(UncheckedRow uncheckedRow) {
            return (E) OrderedRealmCollectionImpl.this.realm.get(OrderedRealmCollectionImpl.this.classSpec, OrderedRealmCollectionImpl.this.className, uncheckedRow);
        }
    }

    /* access modifiers changed from: package-private */
    public class RealmCollectionListIterator extends Collection.ListIterator<E> {
        RealmCollectionListIterator(int i) {
            super(OrderedRealmCollectionImpl.this.collection, i);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.Collection.Iterator
        public E convertRowToObject(UncheckedRow uncheckedRow) {
            return (E) OrderedRealmCollectionImpl.this.realm.get(OrderedRealmCollectionImpl.this.classSpec, OrderedRealmCollectionImpl.this.className, uncheckedRow);
        }
    }
}
