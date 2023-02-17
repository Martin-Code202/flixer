package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ষ  reason: contains not printable characters */
public class C0668 extends AbstractC1067 {
    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "8656";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_ab8656";
    }

    public static boolean d_(Context context) {
        if (context == null || C1272.m16797(C0668.class, context) != ABTestConfig.Cell.CELL_2) {
            return false;
        }
        return true;
    }
}
