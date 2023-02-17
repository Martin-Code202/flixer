package io.reactivex.internal.util;
public final class OpenHashSet<T> {
    T[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.loadFactor = f;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = roundToPowerOfTwo - 1;
        this.maxSize = (int) (((float) roundToPowerOfTwo) * f);
        this.keys = (T[]) new Object[roundToPowerOfTwo];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.keys;
        int i = this.mask;
        int mix = mix(t.hashCode()) & i;
        T t3 = tArr[mix];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                mix = (mix + 1) & i;
                t2 = tArr[mix];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[mix] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 < this.maxSize) {
            return true;
        }
        rehash();
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.keys;
        int i = this.mask;
        int mix = mix(t.hashCode()) & i;
        T t3 = tArr[mix];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return removeEntry(mix, tArr, i);
        }
        do {
            mix = (mix + 1) & i;
            t2 = tArr[mix];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return removeEntry(mix, tArr, i);
    }

    /* access modifiers changed from: package-private */
    public boolean removeEntry(int i, T[] tArr, int i2) {
        T t;
        this.size--;
        while (true) {
            while (true) {
                i = (i + 1) & i2;
                t = tArr[i];
                if (t != null) {
                    int mix = mix(t.hashCode()) & i2;
                    if (i > i) {
                        if (i >= mix && mix > i) {
                            break;
                        }
                    } else if (i >= mix || mix > i) {
                        break;
                    }
                } else {
                    tArr[i] = null;
                    return true;
                }
            }
            tArr[i] = t;
        }
    }

    /* access modifiers changed from: package-private */
    public void rehash() {
        T[] tArr = this.keys;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.size;
        while (true) {
            i3--;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int mix = mix(tArr[length].hashCode()) & i2;
                if (tArr2[mix] != null) {
                    do {
                        mix = (mix + 1) & i2;
                    } while (tArr2[mix] != null);
                }
                tArr2[mix] = tArr[length];
            } else {
                this.mask = i2;
                this.maxSize = (int) (((float) i) * this.loadFactor);
                this.keys = tArr2;
                return;
            }
        }
    }

    static int mix(int i) {
        int i2 = i * -1640531527;
        return (i2 >>> 16) ^ i2;
    }

    public Object[] keys() {
        return this.keys;
    }
}
