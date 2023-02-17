package com.ibm.icu.impl;

import com.ibm.icu.util.ICUException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
public abstract class CacheValue<V> {
    private static final CacheValue NULL_VALUE = new NullValue();
    private static volatile Strength strength = Strength.SOFT;

    public enum Strength {
        STRONG,
        SOFT
    }

    public abstract V get();

    public abstract V resetIfCleared(V v);

    public static boolean futureInstancesWillBeStrong() {
        return strength == Strength.STRONG;
    }

    public static <V> CacheValue<V> getInstance(V v) {
        if (v == null) {
            return NULL_VALUE;
        }
        return strength == Strength.STRONG ? new StrongValue(v) : new SoftValue(v);
    }

    public boolean isNull() {
        return false;
    }

    static final class NullValue<V> extends CacheValue<V> {
        private NullValue() {
        }

        @Override // com.ibm.icu.impl.CacheValue
        public boolean isNull() {
            return true;
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V get() {
            return null;
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V resetIfCleared(V v) {
            if (v == null) {
                return null;
            }
            throw new ICUException("resetting a null value to a non-null value");
        }
    }

    static final class StrongValue<V> extends CacheValue<V> {
        private V value;

        StrongValue(V v) {
            this.value = v;
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V get() {
            return this.value;
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V resetIfCleared(V v) {
            return this.value;
        }
    }

    static final class SoftValue<V> extends CacheValue<V> {
        private Reference<V> ref;

        SoftValue(V v) {
            this.ref = new SoftReference(v);
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V get() {
            return this.ref.get();
        }

        @Override // com.ibm.icu.impl.CacheValue
        public synchronized V resetIfCleared(V v) {
            V v2 = this.ref.get();
            if (v2 != null) {
                return v2;
            }
            this.ref = new SoftReference(v);
            return v;
        }
    }
}
