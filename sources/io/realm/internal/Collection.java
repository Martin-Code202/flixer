package io.realm.internal;

import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmChangeListener;
import io.realm.internal.ObservableCollection;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
public class Collection implements NativeObject, ObservableCollection {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final NativeContext context;
    private boolean isSnapshot;
    private boolean loaded;
    private final long nativePtr;
    private final ObserverPairList<ObservableCollection.CollectionObserverPair> observerPairs;
    private final SharedRealm sharedRealm;
    private final Table table;

    private static native Object nativeAggregate(long j, long j2, byte b);

    private static native void nativeClear(long j);

    private static native boolean nativeContains(long j, long j2);

    private static native long nativeCreateResults(long j, long j2, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2);

    private static native long nativeCreateResultsFromBacklinks(long j, long j2, long j3, long j4);

    private static native long nativeCreateResultsFromList(long j, long j2, SortDescriptor sortDescriptor);

    private static native long nativeCreateSnapshot(long j);

    private static native void nativeDelete(long j, long j2);

    private static native boolean nativeDeleteFirst(long j);

    private static native boolean nativeDeleteLast(long j);

    private static native long nativeDistinct(long j, SortDescriptor sortDescriptor);

    private static native long nativeFirstRow(long j);

    private static native long nativeGetFinalizerPtr();

    private static native byte nativeGetMode(long j);

    private static native long nativeGetRow(long j, int i);

    private static native long nativeIndexOf(long j, long j2);

    private static native boolean nativeIsValid(long j);

    private static native long nativeLastRow(long j);

    private static native long nativeSize(long j);

    private static native long nativeSort(long j, SortDescriptor sortDescriptor);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    private static native long nativeWhere(long j);

    public static abstract class Iterator<T> implements java.util.Iterator<T> {
        Collection iteratorCollection;
        protected int pos = -1;

        public abstract T convertRowToObject(UncheckedRow uncheckedRow);

        public Iterator(Collection collection) {
            if (collection.sharedRealm.isClosed()) {
                throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
            }
            this.iteratorCollection = collection;
            if (!collection.isSnapshot) {
                if (collection.sharedRealm.isInTransaction()) {
                    detach();
                } else {
                    this.iteratorCollection.sharedRealm.addIterator(this);
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkValid();
            return ((long) (this.pos + 1)) < this.iteratorCollection.size();
        }

        @Override // java.util.Iterator
        public T next() {
            checkValid();
            this.pos++;
            if (((long) this.pos) < this.iteratorCollection.size()) {
                return get(this.pos);
            }
            throw new NoSuchElementException("Cannot access index " + this.pos + " when size is " + this.iteratorCollection.size() + ". Remember to check hasNext() before using next().");
        }

        @Override // java.util.Iterator
        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported by RealmResults iterators.");
        }

        /* access modifiers changed from: package-private */
        public void detach() {
            this.iteratorCollection = this.iteratorCollection.createSnapshot();
        }

        /* access modifiers changed from: package-private */
        public void invalidate() {
            this.iteratorCollection = null;
        }

        /* access modifiers changed from: package-private */
        public void checkValid() {
            if (this.iteratorCollection == null) {
                throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a living Realm collection.");
            }
        }

        /* access modifiers changed from: package-private */
        public T get(int i) {
            return convertRowToObject(this.iteratorCollection.getUncheckedRow(i));
        }
    }

    public static abstract class ListIterator<T> extends Iterator<T> implements java.util.ListIterator<T> {
        public ListIterator(Collection collection, int i) {
            super(collection);
            if (i < 0 || ((long) i) > this.iteratorCollection.size()) {
                throw new IndexOutOfBoundsException("Starting location must be a valid index: [0, " + (this.iteratorCollection.size() - 1) + "]. Yours was " + i);
            }
            this.pos = i - 1;
        }

        @Override // java.util.ListIterator
        @Deprecated
        public void add(T t) {
            throw new UnsupportedOperationException("Adding an element is not supported. Use Realm.createObject() instead.");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            checkValid();
            return this.pos >= 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            checkValid();
            return this.pos + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            checkValid();
            try {
                this.pos--;
                return get(this.pos);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException("Cannot access index less than zero. This was " + this.pos + ". Remember to check hasPrevious() before using previous().");
            }
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            checkValid();
            return this.pos;
        }

        @Override // java.util.ListIterator
        @Deprecated
        public void set(T t) {
            throw new UnsupportedOperationException("Replacing and element is not supported.");
        }
    }

    public Collection(SharedRealm sharedRealm2, TableQuery tableQuery, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2) {
        this.isSnapshot = false;
        this.observerPairs = new ObserverPairList<>();
        tableQuery.validateQuery();
        this.nativePtr = nativeCreateResults(sharedRealm2.getNativePtr(), tableQuery.getNativePtr(), sortDescriptor, sortDescriptor2);
        this.sharedRealm = sharedRealm2;
        this.context = sharedRealm2.context;
        this.table = tableQuery.getTable();
        this.context.addReference(this);
        this.loaded = false;
    }

    private Collection(SharedRealm sharedRealm2, Table table2, long j) {
        this(sharedRealm2, table2, j, false);
    }

    Collection(SharedRealm sharedRealm2, Table table2, long j, boolean z) {
        this.isSnapshot = false;
        this.observerPairs = new ObserverPairList<>();
        this.sharedRealm = sharedRealm2;
        this.context = sharedRealm2.context;
        this.table = table2;
        this.nativePtr = j;
        this.context.addReference(this);
        this.loaded = z;
    }

    public Collection createSnapshot() {
        if (this.isSnapshot) {
            return this;
        }
        Collection collection = new Collection(this.sharedRealm, this.table, nativeCreateSnapshot(this.nativePtr));
        collection.isSnapshot = true;
        return collection;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public UncheckedRow getUncheckedRow(int i) {
        return this.table.getUncheckedRowByPointer(nativeGetRow(this.nativePtr, i));
    }

    public UncheckedRow firstUncheckedRow() {
        long nativeFirstRow = nativeFirstRow(this.nativePtr);
        if (nativeFirstRow != 0) {
            return this.table.getUncheckedRowByPointer(nativeFirstRow);
        }
        return null;
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public void clear() {
        nativeClear(this.nativePtr);
    }

    public <T> void removeListener(T t, OrderedRealmCollectionChangeListener<T> orderedRealmCollectionChangeListener) {
        this.observerPairs.remove(t, orderedRealmCollectionChangeListener);
        if (this.observerPairs.isEmpty()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public <T> void removeListener(T t, RealmChangeListener<T> realmChangeListener) {
        removeListener(t, new ObservableCollection.RealmChangeListenerWrapper(realmChangeListener));
    }

    public boolean isValid() {
        return nativeIsValid(this.nativePtr);
    }

    @Override // io.realm.internal.ObservableCollection
    public void notifyChangeListeners(long j) {
        if (j != 0 || !isLoaded()) {
            boolean z = this.loaded;
            this.loaded = true;
            this.observerPairs.foreach(new ObservableCollection.Callback((j == 0 || !z) ? null : new OsCollectionChangeSet(j)));
        }
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void load() {
        if (!this.loaded) {
            notifyChangeListeners(0);
        }
    }
}
