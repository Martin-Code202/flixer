package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.খ  reason: contains not printable characters */
public class C0652 extends AbstractC1067 {
    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "8506";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_ab8506";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m14812(Context context) {
        switch (C1272.m16797(C0652.class, context)) {
            case CELL_2:
            case CELL_3:
            case CELL_4:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m14811(Context context) {
        switch (C1272.m16797(C0652.class, context)) {
            case CELL_1:
            case CELL_2:
            case CELL_3:
                return true;
            default:
                return false;
        }
    }

    public static boolean c_(Context context) {
        return context != null && C1272.m16797(C0652.class, context) == ABTestConfig.Cell.CELL_3;
    }
}
