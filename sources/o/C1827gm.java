package o;

import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
/* renamed from: o.gm  reason: case insensitive filesystem */
public class C1827gm extends AbstractC1823gi implements AbstractC1830gp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1780fm f6984;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f6985;

    public C1827gm(String str, String str2, String str3, C1780fm fmVar, C1767fa faVar) {
        super(str, str2, str3, faVar);
        this.f6984 = fmVar;
    }

    @Override // o.AbstractC1830gp
    /* renamed from: ॱ */
    public boolean mo6679(boolean z) {
        C1283.m16851("CafMdxTarget", "CafMdxTarget launchTarget - forceLaunch: %b, name: %s", Boolean.valueOf(z), m6669());
        this.f6985 = false;
        this.f6978 = z;
        if (m6681()) {
            C1283.m16862("CafMdxTarget", "CafMdxTarget launchTarget, already launched");
            mo791().m788(this.f6978);
            return true;
        }
        C1283.m16862("CafMdxTarget", "CafMdxTarget launchTarget, will launch");
        this.f6984.m6430(m6671());
        return true;
    }

    @Override // o.AbstractC1830gp
    /* renamed from: ॱ */
    public void mo6678(boolean z, oD oDVar, AbstractC1700eM eMVar) {
        C1283.m16863("CafMdxTarget", "CafMdxTarget notifyLaunchResult - uuid: %s, success: %b", m6671(), Boolean.valueOf(z));
        if (!z) {
            if ((m6681() || this.f6978) && !this.f6985) {
                this.f6985 = true;
                eMVar.mo6057(m6671(), 106, m6669());
            }
            if (this.f6975 != null) {
                this.f6975.m773();
                this.f6975 = null;
            }
        } else if (!m6681()) {
            this.f6975 = new SessionMdxTarget(m6671(), m6669(), m6667(), this.f6984, oDVar, eMVar, this.f6977);
            mo791().m788(this.f6978);
            AbstractC1744fD r8 = m6673();
            if (r8 != null) {
                mo791().mo792(r8);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m6681() {
        return this.f6975 != null;
    }

    @Override // o.AbstractC1823gi
    /* renamed from: ॱ */
    public SessionMdxTarget mo791() {
        return this.f6975;
    }
}
