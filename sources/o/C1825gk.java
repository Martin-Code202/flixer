package o;

import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
/* renamed from: o.gk  reason: case insensitive filesystem */
public class C1825gk extends AbstractC1823gi implements AbstractC1830gp {

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f6981;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f6982;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1782fo f6983;

    public C1825gk(String str, String str2, String str3, C1782fo foVar, C1767fa faVar) {
        super(str, str2, str3, faVar);
        this.f6983 = foVar;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m6677() {
        return this.f6975 != null;
    }

    @Override // o.AbstractC1830gp
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo6679(boolean z) {
        this.f6982 = false;
        this.f6978 = z;
        if (m6677()) {
            C1283.m16862("MdxTargetCast", "launchTarget, already launched");
            mo791().m788(this.f6978);
            return true;
        }
        C1283.m16862("MdxTargetCast", "launchTarget, will launch");
        this.f6983.m6442(m6671());
        this.f6981 = true;
        return true;
    }

    @Override // o.AbstractC1830gp
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6678(boolean z, oD oDVar, AbstractC1700eM eMVar) {
        C1283.m16863("MdxTargetCast", "notifyLaunchResult %s %b", m6671(), Boolean.valueOf(z));
        this.f6981 = false;
        if (!z) {
            if ((m6677() || this.f6978) && !this.f6982) {
                this.f6982 = true;
                eMVar.mo6057(m6671(), 106, m6669());
            }
            if (this.f6975 != null) {
                this.f6975.m773();
                this.f6975 = null;
            }
        } else if (!m6677()) {
            this.f6975 = new SessionMdxTarget(m6671(), m6669(), m6667(), this.f6983, oDVar, eMVar, this.f6977);
            mo791().m788(this.f6978);
            AbstractC1744fD r8 = m6673();
            if (r8 != null) {
                mo791().mo792(r8);
            }
        }
    }

    @Override // o.AbstractC1823gi
    /* renamed from: ॱ */
    public SessionMdxTarget mo791() {
        return this.f6975;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m6676() {
        this.f6981 = true;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m6680() {
        return this.f6981;
    }
}
