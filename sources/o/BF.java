package o;

import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import com.netflix.mediaclient.servicemgr.interface_.offline.WatchState;
public class BF {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3845(int i) {
        if (i < 0) {
            return "DLST.N" + (i * -1);
        }
        return "DLST." + i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3846(StopReason stopReason) {
        int r2 = stopReason.m1583();
        if (r2 < 0) {
            return "DLS.N" + (r2 * -1);
        }
        return "DLS." + r2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3847(WatchState watchState) {
        int r2 = watchState.m1585();
        if (r2 < 0) {
            return "DLW.N" + (r2 * -1);
        }
        return "DLW." + r2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3844(String str) {
        return " (" + str + ")";
    }
}
