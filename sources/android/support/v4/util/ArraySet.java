package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    private Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    private int mSize;

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i2, i);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == i) {
            if (obj.equals(this.mArray[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = binarySearch - 1;
        while (i4 >= 0 && this.mHashes[i4] == i) {
            if (obj.equals(this.mArray[i4])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i, 0);
        if (binarySearch < 0 || null == this.mArray[binarySearch]) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (null == this.mArray[i2]) {
                return i2;
            }
            i2++;
        }
        int i3 = binarySearch - 1;
        while (i3 >= 0 && this.mHashes[i3] == 0) {
            if (null == this.mArray[i3]) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    private void allocArrays(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCache != null) {
                    Object[] objArr = sTwiceBaseCache;
                    this.mArray = objArr;
                    sTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCache != null) {
                    Object[] objArr2 = sBaseCache;
                    this.mArray = objArr2;
                    sBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    sBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[i];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCacheSize < 10) {
                    objArr[0] = sTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    sTwiceBaseCache = objArr;
                    sTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCacheSize < 10) {
                    objArr[0] = sBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    sBaseCache = objArr;
                    sBaseCacheSize++;
                }
            }
        }
    }

    public ArraySet() {
        this(0);
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (this.mSize != 0) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    public void ensureCapacity(int i) {
        if (this.mHashes.length < i) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int indexOf(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public E valueAt(int i) {
        return (E) this.mArray[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int i2;
        if (e == null) {
            i2 = 0;
            i = indexOfNull();
        } else {
            i2 = e.hashCode();
            i = indexOf(e, i2);
        }
        if (i >= 0) {
            return false;
        }
        int i3 = i ^ -1;
        if (this.mSize >= this.mHashes.length) {
            int i4 = this.mSize >= 8 ? this.mSize + (this.mSize >> 1) : this.mSize >= 4 ? 8 : 4;
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i4);
            if (this.mHashes.length > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        if (i3 < this.mSize) {
            System.arraycopy(this.mHashes, i3, this.mHashes, i3 + 1, this.mSize - i3);
            System.arraycopy(this.mArray, i3, this.mArray, i3 + 1, this.mSize - i3);
        }
        this.mHashes[i3] = i2;
        this.mArray[i3] = e;
        this.mSize++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public E removeAt(int i) {
        E e = (E) this.mArray[i];
        if (this.mSize <= 1) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        } else if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
            this.mSize--;
            if (i < this.mSize) {
                System.arraycopy(this.mHashes, i + 1, this.mHashes, i, this.mSize - i);
                System.arraycopy(this.mArray, i + 1, this.mArray, i, this.mSize - i);
            }
            this.mArray[this.mSize] = null;
        } else {
            int i2 = this.mSize > 8 ? this.mSize + (this.mSize >> 1) : 8;
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i2);
            this.mSize--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i);
                System.arraycopy(objArr, 0, this.mArray, 0, i);
            }
            if (i < this.mSize) {
                System.arraycopy(iArr, i + 1, this.mHashes, i, this.mSize - i);
                System.arraycopy(objArr, i + 1, this.mArray, i, this.mSize - i);
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[this.mSize];
        System.arraycopy(this.mArray, 0, objArr, 0, this.mSize);
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[]] */
    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        if (tArr.length > this.mSize) {
            tArr[this.mSize] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        for (int i = 0; i < this.mSize; i++) {
            try {
                if (!set.contains(valueAt(i))) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int[] iArr = this.mHashes;
        int i = 0;
        int i2 = this.mSize;
        for (int i3 = 0; i3 < i2; i3++) {
            i += iArr[i3];
        }
        return i;
    }

    @Override // java.lang.Object
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append((Object) valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() { // from class: android.support.v4.util.ArraySet.1
                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public int colGetSize() {
                    return ArraySet.this.mSize;
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public Object colGetEntry(int i, int i2) {
                    return ArraySet.this.mArray[i];
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public int colIndexOfKey(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public int colIndexOfValue(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public Map<E, E> colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public void colPut(E e, E e2) {
                    ArraySet.this.add(e);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public E colSetValue(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public void colRemoveAt(int i) {
                    ArraySet.this.removeAt(i);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.util.MapCollections
                public void colClear() {
                    ArraySet.this.clear();
                }
            };
        }
        return this.mCollections;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: android.support.v4.util.ArraySet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        boolean z = false;
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.mSize - 1; i >= 0; i--) {
            if (!collection.contains(this.mArray[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }
}
