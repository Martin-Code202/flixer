package o;

import android.content.Intent;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.model.leafs.OnRampEligibility;
/* renamed from: o.sw  reason: case insensitive filesystem */
public class C2165sw extends AbstractC2164sv {
    public C2165sw(C2167sy syVar) {
        super(syVar);
    }

    @Override // o.AbstractC2164sv
    /* renamed from: ˊ */
    public boolean mo10502() {
        return zK.m13489(m10857().getServiceManager(), m10857());
    }

    @Override // o.AbstractC2164sv
    /* renamed from: ॱ */
    public boolean mo10503() {
        m10857().getServiceManager().m9793(OnRampEligibility.Action.FETCH, new AbstractC2061pj() { // from class: o.sw.4
            @Override // o.AbstractC2061pj, o.oU
            public void onOnRampEligibilityAction(OnRampEligibility onRampEligibility, Status status) {
                if (C2165sw.this.m10857() == null) {
                    return;
                }
                if (status == null || !status.mo298() || onRampEligibility == null || !onRampEligibility.isEligible()) {
                    C2165sw.this.f10295.m10861();
                } else {
                    C2165sw.this.m10857().startActivity(new Intent(C2165sw.this.m10857(), zK.class));
                }
            }
        });
        return true;
    }
}
