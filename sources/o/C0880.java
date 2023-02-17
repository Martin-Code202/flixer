package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ᔲ  reason: contains not printable characters */
public class C0880 extends AbstractC1067 {
    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_smart_downloads_key";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "9185";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m15595() {
        return C1272.m16803(C0880.class) != ABTestConfig.Cell.CELL_1;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m15596() {
        return C1272.m16803(C0880.class) == ABTestConfig.Cell.CELL_2;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m15594() {
        ABTestConfig.Cell r1 = C1272.m16803(C0880.class);
        return r1 == ABTestConfig.Cell.CELL_2 || r1 == ABTestConfig.Cell.CELL_3 || r1 == ABTestConfig.Cell.CELL_4;
    }
}
