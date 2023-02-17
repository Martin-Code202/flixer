package o;

import android.content.Context;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.User;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.OnRampEligibility;
public class nW {

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1221 f9043;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Context f9044;

    public nW(Context context, AbstractC1221 r2) {
        this.f9044 = context;
        this.f9043 = r2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private NetflixDataRequest.Transport m9184() {
        if (this.f9043.mo16511()) {
            return NetflixDataRequest.Transport.msl;
        }
        return NetflixDataRequest.Transport.web;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public NetflixDataRequest m9200(String str, boolean z, String str2, AbstractC2022nz nzVar) {
        return new nE(this.f9044, m9184(), str, z, str2, nzVar).m16567();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public NetflixDataRequest m9198(int i, String str, String str2, AbstractC2022nz nzVar) {
        return new nU(this.f9044, m9184(), i, str, str2, nzVar).m16567();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetflixDataRequest m9196(String str, AbstractC2022nz nzVar) {
        return new nB(this.f9044, m9184(), str, nzVar).m16567();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetflixDataRequest m9192(long j, AbstractC2022nz nzVar) {
        return new nA(this.f9044, m9184(), j, nzVar).m16567();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public NetflixDataRequest m9202(OnRampEligibility.Action action, AbstractC2022nz nzVar) {
        return new nC(this.f9044, m9184(), action, nzVar).m16567();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public NetflixDataRequest m9205(AbstractC2022nz nzVar) {
        return new nF(nzVar);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetflixDataRequest m9195(String str, String str2, boolean z, String str3, AbstractC2022nz nzVar) {
        return new nI(this.f9044, m9184(), str, str2, z, str3, nzVar).m16567();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public NetflixDataRequest m9201(AbstractC2022nz nzVar) {
        return new nG(this.f9044, m9184(), nzVar).m16567();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public nJ m9190(String str, AbstractC2022nz nzVar) {
        return new nJ(str, nzVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public nH m9187(String str, AbstractC2022nz nzVar) {
        return new nH(str, nzVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public NetflixDataRequest m9186(AbstractC2022nz nzVar) {
        return new nN(this.f9044, m9184(), nzVar).m16567();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetflixDataRequest m9197(AbstractC2022nz nzVar) {
        return new nO(this.f9044, m9184(), nzVar).m16567();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetflixDataRequest m9191() {
        return new nL(this.f9044, m9184()).m16567();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixDataRequest m9188(String str, String str2) {
        return new nK(this.f9044, m9184(), str, str2).m16567();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public NetflixDataRequest m9199(String str, String str2) {
        return new nT(this.f9044, m9184(), str, str2).m16567();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetflixDataRequest m9194(String str) {
        return new nM(this.f9044, m9184(), str).m16567();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixDataRequest m9189(AbstractC2022nz nzVar) {
        return new nP(this.f9044, m9184(), nzVar).m16567();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public NetflixDataRequest m9185(AbstractC2022nz nzVar) {
        return new nS(this.f9044, m9184(), nzVar).m16567();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetflixDataRequest m9193(Context context, User user) {
        return new nR(this.f9044, m9184(), user).m16567();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public NetflixDataRequest m9204(String str, AbstractC2022nz nzVar) {
        return new nQ(this.f9044, m9184(), str, nzVar).m16567();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public NetflixDataRequest m9203(String str, UserAgentInterface.PinType pinType, String str2, AbstractC2022nz nzVar) {
        return new nV(this.f9044, m9184(), str, pinType, str2, nzVar).m16567();
    }
}
