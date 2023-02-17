package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfigData;
import o.C1272;
/* renamed from: o.Ↄ  reason: contains not printable characters */
public abstract class AbstractC1067 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private ABTestConfig.Cell f15214;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f15215;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Object f15216 = new Object();

    /* renamed from: ˎ */
    public abstract String mo510();

    /* renamed from: ˏ */
    public abstract String mo511();

    /* renamed from: ˋ  reason: contains not printable characters */
    public ABTestConfig m16128(ABTestConfigData aBTestConfigData) {
        return aBTestConfigData.getConfigForId(mo511());
    }

    public ABTestConfig.Cell e_(Context context) {
        return m16129(context, m16131());
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public ABTestConfig.Cell m16131() {
        return ABTestConfig.Cell.CELL_1;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public ABTestConfig.Cell m16129(Context context, ABTestConfig.Cell cell) {
        ABTestConfig.Cell cell2 = this.f15214;
        if (cell2 != null) {
            return cell2;
        }
        synchronized (this.f15216) {
            if (this.f15214 == null) {
                int r4 = C1339Bl.m4037(context, mo510(), cell.getCellId());
                this.f15215 = C1339Bl.m4051(context, mo510() + ".explicit", false);
                this.f15214 = ABTestConfig.Cell.fromInt(r4);
                if (this.f15214 == null) {
                    this.f15214 = cell;
                }
            }
        }
        return this.f15214;
    }

    /* renamed from: ˊ */
    public boolean mo509() {
        return false;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public boolean m16126() {
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16130(Context context, AbstractC1221 r8, C1272.iF iFVar) {
        ABTestConfig.Cell r2 = m16131();
        ABTestConfigData r3 = r8.mo16505();
        if (r3 != null) {
            ABTestConfig r4 = m16128(r3);
            if (r4 != null) {
                r2 = r4.getCell();
                if (r2 != null) {
                    C1339Bl.m4042(context, mo510(), r2.getCellId());
                    C1339Bl.m4048(context, mo510() + ".explicit", r4.isExplicit());
                }
                if (iFVar != null) {
                    iFVar.mo3578(context, r4, this);
                }
            } else {
                C1339Bl.m4042(context, mo510(), r2.getCellId());
                C1339Bl.m4048(context, mo510() + ".explicit", false);
            }
        }
        if (m16127()) {
            synchronized (this.f15216) {
                this.f15214 = r2;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˈ  reason: contains not printable characters */
    public boolean m16127() {
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m16125(Context context) {
        synchronized (this.f15216) {
            this.f15214 = null;
        }
        C1339Bl.m4041(context, mo510());
        C1339Bl.m4041(context, mo510() + ".explicit");
    }
}
