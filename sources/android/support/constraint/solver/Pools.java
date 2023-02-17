package android.support.constraint.solver;
final class Pools {

    /* access modifiers changed from: package-private */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);

        void releaseAll(T[] tArr, int i);
    }

    /* access modifiers changed from: package-private */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i];
        }

        @Override // android.support.constraint.solver.Pools.Pool
        public T acquire() {
            if (this.mPoolSize <= 0) {
                return null;
            }
            int i = this.mPoolSize - 1;
            T t = (T) this.mPool[i];
            this.mPool[i] = null;
            this.mPoolSize--;
            return t;
        }

        @Override // android.support.constraint.solver.Pools.Pool
        public boolean release(T t) {
            if (this.mPoolSize >= this.mPool.length) {
                return false;
            }
            this.mPool[this.mPoolSize] = t;
            this.mPoolSize++;
            return true;
        }

        @Override // android.support.constraint.solver.Pools.Pool
        public void releaseAll(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.mPoolSize < this.mPool.length) {
                    this.mPool[this.mPoolSize] = t;
                    this.mPoolSize++;
                }
            }
        }
    }
}
