package o;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import java.util.HashMap;
import java.util.Map;
public final class uH {

    /* access modifiers changed from: package-private */
    /* renamed from: o.uH$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static final Map<BrowseExperience, SparseArray<SparseIntArray>> f10767 = new HashMap();

        /* renamed from: ˋ  reason: contains not printable characters */
        private static final SparseArray<SparseIntArray> f10768 = new SparseArray<>(2);

        static {
            m11424();
            SparseIntArray sparseIntArray = new SparseIntArray();
            sparseIntArray.put(1, 2);
            sparseIntArray.put(2, 2);
            sparseIntArray.put(3, 3);
            sparseIntArray.put(4, 3);
            f10768.put(1, sparseIntArray);
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            sparseIntArray2.put(1, 2);
            sparseIntArray2.put(2, 2);
            sparseIntArray2.put(3, 3);
            sparseIntArray2.put(4, 4);
            f10768.put(2, sparseIntArray2);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private static void m11424() {
            SparseArray<SparseIntArray> sparseArray = new SparseArray<>(2);
            SparseIntArray sparseIntArray = new SparseIntArray();
            sparseIntArray.put(1, 2);
            sparseIntArray.put(2, 3);
            sparseIntArray.put(3, 4);
            sparseIntArray.put(4, 4);
            sparseArray.put(1, sparseIntArray);
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            sparseIntArray2.put(1, 3);
            sparseIntArray2.put(2, 4);
            sparseIntArray2.put(3, 5);
            sparseIntArray2.put(4, 6);
            sparseArray.put(2, sparseIntArray2);
            f10767.put(BrowseExperience.STANDARD, sparseArray);
        }

        /* access modifiers changed from: private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public static int m11426(Context context, LoMoType loMoType) {
            if (loMoType == LoMoType.BILLBOARD) {
                return 3;
            }
            if (loMoType == LoMoType.FLAT_GENRE) {
                return 40;
            }
            int r2 = AD.m3290(context);
            return uH.m11416(2, r2) * uH.m11416(1, r2);
        }

        /* access modifiers changed from: private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public static int m11418(int i, int i2) {
            return f10767.get(BrowseExperience.STANDARD).get(i).get(i2);
        }

        /* access modifiers changed from: private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public static int m11419(Context context) {
            int r1 = AD.m3284(context);
            return f10768.get(r1).get(AD.m3290(context));
        }

        /* access modifiers changed from: private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public static int m11423(Context context) {
            return m11418(AD.m3284(context), AD.m3290(context));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m11414(Context context, LoMoType loMoType) {
        return Cif.m11426(context, loMoType);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m11416(int i, int i2) {
        return Cif.m11418(i, i2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m11417(Context context) {
        return Cif.m11423(context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m11413(Context context) {
        return Cif.m11419(context);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m11415() {
        return NetflixApplication.getInstance().getResources().getDimensionPixelOffset(R.dimen.lomo_list_padding);
    }
}
