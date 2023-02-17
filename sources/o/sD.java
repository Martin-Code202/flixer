package o;

import com.netflix.cl.Logger;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.app.Status;
public class sD extends AbstractC2164sv {
    public sD(C2167sy syVar) {
        super(syVar);
    }

    @Override // o.AbstractC2164sv
    /* renamed from: ˊ */
    public boolean mo10502() {
        ActivityC2153sl r1 = m10857();
        return !C1316Ar.m3741(NetflixApplication.getInstance()) && r1 != null && zM.m13505(r1, r1.getServiceManager());
    }

    @Override // o.AbstractC2164sv
    /* renamed from: ॱ */
    public boolean mo10503() {
        C1362Ch.m4419(null, m10857().getUiScreen().f4084);
        final Long r4 = Logger.INSTANCE.m142(new C1224(null, m10857().getUiScreen().f4083));
        m10857().getServiceManager().m9805(new AbstractC2061pj() { // from class: o.sD.2
            @Override // o.AbstractC2061pj, o.oU
            public void onSurveyFetched(CL cl, Status status) {
                if (sD.this.m10857() != null) {
                    ActivityC2153sl r2 = sD.this.m10857();
                    if (!status.mo298()) {
                        Logger.INSTANCE.m140(r4);
                    } else if (cl == null || cl.m4211()) {
                        Logger.INSTANCE.m140(r4);
                    } else {
                        zM.m13504(r2, cl);
                    }
                }
            }
        });
        return true;
    }
}
