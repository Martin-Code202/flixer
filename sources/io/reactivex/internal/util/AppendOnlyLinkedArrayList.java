package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail = this.head;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        this.capacity = i;
        this.head = new Object[(i + 1)];
    }

    public void add(T t) {
        int i = this.capacity;
        int i2 = this.offset;
        if (i2 == i) {
            Object[] objArr = new Object[(i + 1)];
            this.tail[i] = objArr;
            this.tail = objArr;
            i2 = 0;
        }
        this.tail[i2] = t;
        this.offset = i2 + 1;
    }

    public void setFirst(T t) {
        this.head[0] = t;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i = this.capacity;
        for (Object[] objArr = this.head; objArr != null; objArr = objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj == null || nonThrowingPredicate.test(obj)) {
                    break;
                }
            }
        }
    }

    public <U> boolean accept(Observer<? super U> observer) {
        int i = this.capacity;
        for (Object[] objArr = this.head; objArr != null; objArr = objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull(objArr2, observer)) {
                    return true;
                }
            }
        }
        return false;
    }
}
