package o;

import com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix;
import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
/* renamed from: o.gr  reason: case insensitive filesystem */
public class C1832gr extends AbstractC1823gi implements AbstractC1830gp {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final MdxStackNetflix f6993;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f6994;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f6995 = 0;

    public C1832gr(String str, String str2, String str3, MdxStackNetflix mdxStackNetflix, C1767fa faVar) {
        super(str, str2, str3, faVar);
        this.f6993 = mdxStackNetflix;
    }

    @Override // o.AbstractC1823gi
    /* renamed from: ˋ */
    public boolean mo6670(String str) {
        if (super.m6671().equals(str)) {
            return true;
        }
        if (this.f6975 == null || !this.f6975.m6671().equals(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m6698() {
        return this.f6975 != null;
    }

    @Override // o.AbstractC1830gp
    /* renamed from: ॱ */
    public boolean mo6679(boolean z) {
        this.f6994 = false;
        this.f6978 = z;
        if (m6698()) {
            C1283.m16862("MdxTargetDial", "launchTarget, already launched");
            mo791().m788(this.f6978);
            return true;
        } else if (!this.f6978) {
            return true;
        } else {
            C1283.m16862("MdxTargetDial", "launchTarget, will launch");
            this.f6993.m748(m6671());
            return true;
        }
    }

    @Override // o.AbstractC1830gp
    /* renamed from: ॱ */
    public void mo6678(boolean z, oD oDVar, AbstractC1700eM eMVar) {
        if (!z) {
            if ((m6698() || this.f6978) && !this.f6994) {
                this.f6994 = true;
                eMVar.mo6057(m6671(), 106, m6669());
            }
        } else if (!m6698()) {
            C1283.m16865("MdxTargetDial", "launch success full, but no session target. BUG!!!");
        } else {
            mo791().m788(this.f6978);
            AbstractC1744fD r3 = m6673();
            if (r3 != null) {
                mo791().mo792(r3);
            }
        }
    }

    @Override // o.AbstractC1823gi
    /* renamed from: ॱ */
    public SessionMdxTarget mo791() {
        return this.f6975;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m6701() {
        C1283.m16863("MdxTargetDial", "SessionMdxTarget lost %s", m6669());
        if (this.f6975 != null) {
            this.f6975.m773();
            this.f6975 = null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6699(SessionMdxTarget sessionMdxTarget) {
        this.f6975 = sessionMdxTarget;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m6700(int i) {
        if (i == this.f6995) {
            return false;
        }
        this.f6995 = i;
        return true;
    }
}
