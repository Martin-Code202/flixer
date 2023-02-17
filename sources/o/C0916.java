package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ᖺ  reason: contains not printable characters */
public class C0916 extends AbstractC1067 {
    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "8183";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_network_request_config";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m15719(Context context) {
        return m15718(context) != ABTestConfig.Cell.CELL_1;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static ABTestConfig.Cell m15718(Context context) {
        return C1272.m16797(C0916.class, context);
    }
}
