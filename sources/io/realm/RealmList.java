package io.realm;

import io.realm.internal.InvalidRow;
import io.realm.internal.OsList;
import io.realm.internal.RealmObjectProxy;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
public class RealmList<E> extends AbstractList<E> implements OrderedRealmCollection<E> {
    protected String className;
    protected Class<E> clazz;
    final ManagedListOperator<E> osListOperator;
    protected final BaseRealm realm;
    private List<E> unmanagedList;

    public RealmList() {
        this.realm = null;
        this.osListOperator = null;
        this.unmanagedList = new ArrayList();
    }

    RealmList(Class<E> cls, OsList osList, BaseRealm baseRealm) {
        this.clazz = cls;
        this.osListOperator = getOperator(baseRealm, osList, cls, null);
        this.realm = baseRealm;
    }

    public boolean isManaged() {
        return this.realm != null;
    }

    private boolean isAttached() {
        return this.osListOperator != null && this.osListOperator.isValid();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        if (isManaged()) {
            checkValidRealm();
            this.osListOperator.insert(i, e);
        } else {
            this.unmanagedList.add(i, e);
        }
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean add(E e) {
        if (isManaged()) {
            checkValidRealm();
            this.osListOperator.append(e);
        } else {
            this.unmanagedList.add(e);
        }
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        if (!isManaged()) {
            return this.unmanagedList.set(i, e);
        }
        checkValidRealm();
        return this.osListOperator.set(i, e);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        if (isManaged()) {
            checkValidRealm();
            this.osListOperator.removeAll();
        } else {
            this.unmanagedList.clear();
        }
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        E e;
        if (isManaged()) {
            checkValidRealm();
            e = get(i);
            this.osListOperator.remove(i);
        } else {
            e = this.unmanagedList.remove(i);
        }
        this.modCount++;
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        if (!isManaged() || this.realm.isInTransaction()) {
            return super.remove(obj);
        }
        throw new IllegalStateException("Objects can only be removed from inside a write transaction.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        if (!isManaged() || this.realm.isInTransaction()) {
            return super.removeAll(collection);
        }
        throw new IllegalStateException("Objects can only be removed from inside a write transaction.");
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (!isManaged()) {
            return this.unmanagedList.get(i);
        }
        checkValidRealm();
        return this.osListOperator.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        if (!isManaged()) {
            return this.unmanagedList.size();
        }
        checkValidRealm();
        return this.osListOperator.size();
    }

    @Override // io.realm.RealmCollection
    public boolean isLoaded() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        if (!isManaged()) {
            return this.unmanagedList.contains(obj);
        }
        this.realm.checkIfValid();
        if (!(obj instanceof RealmObjectProxy) || ((RealmObjectProxy) obj).realmGet$proxyState().getRow$realm() != InvalidRow.INSTANCE) {
            return super.contains(obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        if (isManaged()) {
            return new RealmItr();
        }
        return super.iterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        if (isManaged()) {
            return new RealmListItr(i);
        }
        return super.listIterator(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkValidRealm() {
        this.realm.checkIfValid();
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!isManaged()) {
            sb.append("RealmList<?>@[");
            int size = size();
            for (int i = 0; i < size; i++) {
                E e = get(i);
                if (e instanceof RealmModel) {
                    sb.append(System.identityHashCode(e));
                } else if (e instanceof byte[]) {
                    sb.append("byte[").append(((byte[]) e).length).append("]");
                } else {
                    sb.append((Object) e);
                }
                sb.append(",");
            }
            if (0 < size()) {
                sb.setLength(sb.length() - ",".length());
            }
            sb.append("]");
        } else {
            sb.append("RealmList<");
            if (this.className != null) {
                sb.append(this.className);
            } else if (isClassForRealmModel(this.clazz)) {
                sb.append(this.realm.getSchema().getSchemaForClass(this.clazz).getClassName());
            } else if (this.clazz == byte[].class) {
                sb.append(this.clazz.getSimpleName());
            } else {
                sb.append(this.clazz.getName());
            }
            sb.append(">@[");
            if (!isAttached()) {
                sb.append("invalid");
            } else if (isClassForRealmModel(this.clazz)) {
                for (int i2 = 0; i2 < size(); i2++) {
                    sb.append(get(i2).realmGet$proxyState().getRow$realm().getIndex());
                    sb.append(",");
                }
                if (0 < size()) {
                    sb.setLength(sb.length() - ",".length());
                }
            } else {
                for (int i3 = 0; i3 < size(); i3++) {
                    E e2 = get(i3);
                    if (e2 instanceof byte[]) {
                        sb.append("byte[").append(((byte[]) e2).length).append("]");
                    } else {
                        sb.append((Object) e2);
                    }
                    sb.append(",");
                }
                if (0 < size()) {
                    sb.setLength(sb.length() - ",".length());
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public class RealmItr implements Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet;

        private RealmItr() {
            this.cursor = 0;
            this.lastRet = -1;
            this.expectedModCount = RealmList.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            RealmList.this.checkValidRealm();
            checkConcurrentModification();
            return this.cursor != RealmList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            RealmList.this.checkValidRealm();
            checkConcurrentModification();
            int i = this.cursor;
            try {
                E e = (E) RealmList.this.get(i);
                this.lastRet = i;
                this.cursor = i + 1;
                return e;
            } catch (IndexOutOfBoundsException e2) {
                checkConcurrentModification();
                throw new NoSuchElementException("Cannot access index " + i + " when size is " + RealmList.this.size() + ". Remember to check hasNext() before using next().");
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            RealmList.this.checkValidRealm();
            if (this.lastRet < 0) {
                throw new IllegalStateException("Cannot call remove() twice. Must call next() in between.");
            }
            checkConcurrentModification();
            try {
                RealmList.this.remove(this.lastRet);
                if (this.lastRet < this.cursor) {
                    this.cursor--;
                }
                this.lastRet = -1;
                this.expectedModCount = RealmList.this.modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: package-private */
        public final void checkConcurrentModification() {
            if (RealmList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class RealmListItr extends RealmList<E>.RealmItr implements ListIterator<E> {
        RealmListItr(int i) {
            super();
            if (i < 0 || i > RealmList.this.size()) {
                throw new IndexOutOfBoundsException("Starting location must be a valid index: [0, " + (RealmList.this.size() - 1) + "]. Index was " + i);
            }
            this.cursor = i;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkConcurrentModification();
            int i = this.cursor - 1;
            try {
                E e = (E) RealmList.this.get(i);
                this.cursor = i;
                this.lastRet = i;
                return e;
            } catch (IndexOutOfBoundsException e2) {
                checkConcurrentModification();
                throw new NoSuchElementException("Cannot access index less than zero. This was " + i + ". Remember to check hasPrevious() before using previous().");
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.cursor;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.cursor - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            RealmList.this.realm.checkIfValid();
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkConcurrentModification();
            try {
                RealmList.this.set(this.lastRet, e);
                this.expectedModCount = RealmList.this.modCount;
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            RealmList.this.realm.checkIfValid();
            checkConcurrentModification();
            try {
                int i = this.cursor;
                RealmList.this.add(i, e);
                this.lastRet = -1;
                this.cursor = i + 1;
                this.expectedModCount = RealmList.this.modCount;
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static boolean isClassForRealmModel(Class<?> cls) {
        return RealmModel.class.isAssignableFrom(cls);
    }

    private ManagedListOperator<E> getOperator(BaseRealm baseRealm, OsList osList, Class<E> cls, String str) {
        if (cls == null || isClassForRealmModel(cls)) {
            return new RealmModelListOperator(baseRealm, osList, cls, str);
        }
        if (cls == String.class) {
            return new StringListOperator(baseRealm, osList, cls);
        }
        if (cls == Long.class || cls == Integer.class || cls == Short.class || cls == Byte.class) {
            return new LongListOperator(baseRealm, osList, cls);
        }
        if (cls == Boolean.class) {
            return new BooleanListOperator(baseRealm, osList, cls);
        }
        if (cls == byte[].class) {
            return new BinaryListOperator(baseRealm, osList, cls);
        }
        if (cls == Double.class) {
            return new DoubleListOperator(baseRealm, osList, cls);
        }
        if (cls == Float.class) {
            return new FloatListOperator(baseRealm, osList, cls);
        }
        if (cls == Date.class) {
            return new DateListOperator(baseRealm, osList, cls);
        }
        throw new IllegalArgumentException("Unexpected value class: " + cls.getName());
    }
}
