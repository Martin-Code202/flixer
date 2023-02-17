package o;

import com.netflix.mediaclient.NetflixApplication;
/* renamed from: o.sx  reason: case insensitive filesystem */
public class C2166sx extends AbstractC2164sv {
    public C2166sx(C2167sy syVar) {
        super(syVar);
    }

    @Override // o.AbstractC2164sv
    /* renamed from: ˊ */
    public boolean mo10502() {
        ActivityC2153sl r2 = m10857();
        return !C1316Ar.m3741(NetflixApplication.getInstance()) && r2 != null && r2.getTutorialHelper().m12055(r2.getServiceManager());
    }

    @Override // o.AbstractC2164sv
    /* renamed from: ॱ */
    public boolean mo10503() {
        return m10857().showDialog(new vP());
    }
}
