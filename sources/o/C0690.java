package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ม  reason: contains not printable characters */
public class C0690 extends AbstractC1067 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14181 = "persistent_ab8722";

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f14182 = "8722";

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f14183 = "Aim Low: Image Resolution Variation";

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_ab8722";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "8722";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m14976() {
        ABTestConfig.Cell r1 = C1272.m16803(C0690.class);
        return r1 == ABTestConfig.Cell.CELL_1 || r1 == ABTestConfig.Cell.CELL_5;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static float m14975() {
        switch (C1272.m16803(C0690.class)) {
            case CELL_2:
                return 1.0f;
            case CELL_3:
                return 0.6f;
            case CELL_4:
                return 0.3f;
            default:
                return 0.0f;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m14974() {
        return C1272.m16803(C0690.class) == ABTestConfig.Cell.CELL_5;
    }
}
