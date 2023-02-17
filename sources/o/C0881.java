package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ᔹ  reason: contains not printable characters */
public class C0881 extends AbstractC1067 {
    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "9204";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_phone_dp_9204";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m15597(Context context) {
        return C1272.m16803(C0881.class) != ABTestConfig.Cell.CELL_1 && !AD.m3299();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m15600(Context context) {
        return m15598(context) || m15599(context);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m15598(Context context) {
        return m15597(context) && C1272.m16803(C0881.class) == ABTestConfig.Cell.CELL_3;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m15599(Context context) {
        return m15597(context) && C1272.m16803(C0881.class) == ABTestConfig.Cell.CELL_4;
    }
}
