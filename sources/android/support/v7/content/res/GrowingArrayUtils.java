package android.support.v7.content.res;

import java.lang.reflect.Array;
final class GrowingArrayUtils {
    static final /* synthetic */ boolean $assertionsDisabled = (!GrowingArrayUtils.class.desiredAssertionStatus());

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object[], java.lang.Object] */
    public static <T> T[] append(T[] tArr, int i, T t) {
        if ($assertionsDisabled || i <= tArr.length) {
            if (i + 1 > tArr.length) {
                Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i));
                System.arraycopy(tArr, 0, objArr, 0, i);
                tArr = objArr;
            }
            tArr[i] = t;
            return tArr;
        }
        throw new AssertionError();
    }

    public static int[] append(int[] iArr, int i, int i2) {
        if ($assertionsDisabled || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[growSize(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static int growSize(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    private GrowingArrayUtils() {
    }
}
