package o;

import android.content.Context;
import com.netflix.mediaclient.service.job.NetflixJob;
/* renamed from: o.nr  reason: case insensitive filesystem */
public class C2014nr implements AbstractC2051p {

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC2228v f9205;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Context f9206;

    public C2014nr(Context context, AbstractC2228v vVar) {
        this.f9206 = context;
        this.f9205 = vVar;
        NetflixJob r2 = NetflixJob.m569();
        if (!this.f9205.mo11321(NetflixJob.NetflixJobId.INSTALL_TOKEN)) {
            this.f9205.mo11320(r2);
        }
    }

    @Override // o.AbstractC2051p
    /* renamed from: ॱ */
    public void mo7115(NetflixJob.NetflixJobId netflixJobId) {
        C1283.m16854("partnerInstallJob", "install token job started");
    }

    @Override // o.AbstractC2051p
    /* renamed from: ˊ */
    public void mo7114(NetflixJob.NetflixJobId netflixJobId) {
        C1283.m16854("partnerInstallJob", "install token job stopped");
    }
}
