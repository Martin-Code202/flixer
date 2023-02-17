package org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public class ObserverList<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ObserverList.class.desiredAssertionStatus());
    private int mCount;
    private int mIterationDepth;
    private boolean mNeedsCompact;
    public final List<E> mObservers = new ArrayList();

    public interface RewindableIterator extends Iterator {
    }

    public boolean addObserver(E e) {
        if (e == null || this.mObservers.contains(e)) {
            return false;
        }
        boolean add = this.mObservers.add(e);
        if ($assertionsDisabled || add) {
            this.mCount++;
            return true;
        }
        throw new AssertionError();
    }

    public boolean removeObserver(E e) {
        int indexOf;
        if (e == null || (indexOf = this.mObservers.indexOf(e)) == -1) {
            return false;
        }
        if (this.mIterationDepth == 0) {
            this.mObservers.remove(indexOf);
        } else {
            this.mNeedsCompact = true;
            this.mObservers.set(indexOf, null);
        }
        this.mCount--;
        if ($assertionsDisabled || this.mCount >= 0) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new ObserverListIterator();
    }

    private void compact() {
        if ($assertionsDisabled || this.mIterationDepth == 0) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                if (this.mObservers.get(size) == null) {
                    this.mObservers.remove(size);
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void incrementIterationDepth() {
        this.mIterationDepth++;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void decrementIterationDepthAndCompactIfNeeded() {
        this.mIterationDepth--;
        if (!$assertionsDisabled && this.mIterationDepth < 0) {
            throw new AssertionError();
        } else if (this.mIterationDepth <= 0 && this.mNeedsCompact) {
            this.mNeedsCompact = false;
            compact();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int capacity() {
        return this.mObservers.size();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private E getObserverAt(int i) {
        return this.mObservers.get(i);
    }

    class ObserverListIterator implements RewindableIterator<E> {
        private int mIndex;
        private boolean mIsExhausted;
        private int mListEndMarker;

        private ObserverListIterator() {
            ObserverList.this.incrementIterationDepth();
            this.mListEndMarker = ObserverList.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mListEndMarker && ObserverList.this.getObserverAt(i) == null) {
                i++;
            }
            if (i < this.mListEndMarker) {
                return true;
            }
            compactListIfNeeded();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.mListEndMarker && ObserverList.this.getObserverAt(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.mListEndMarker) {
                ObserverList observerList = ObserverList.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) observerList.getObserverAt(i);
            }
            compactListIfNeeded();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void compactListIfNeeded() {
            if (!this.mIsExhausted) {
                this.mIsExhausted = true;
                ObserverList.this.decrementIterationDepthAndCompactIfNeeded();
            }
        }
    }
}
