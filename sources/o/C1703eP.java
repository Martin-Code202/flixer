package o;

import o.BJ;
/* renamed from: o.eP  reason: case insensitive filesystem */
public final class C1703eP {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f6580;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f6581;

    /* renamed from: ˊ  reason: contains not printable characters */
    If f6582;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f6583;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6584;

    /* renamed from: ˏ  reason: contains not printable characters */
    private BJ.C0067 f6585;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1699eL f6586;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f6587;

    /* renamed from: o.eP$If */
    public interface If {
        /* renamed from: ॱ */
        void mo6187(String str);
    }

    public C1703eP(C1699eL eLVar, If r2) {
        this.f6586 = eLVar;
        this.f6582 = r2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6251(String str, String str2, BJ.C0067 r5, int i, int i2, boolean z) {
        if (this.f6587) {
            C1283.m16850("nf_mdxSwitchTarget", "switching already undergoing");
        }
        if (C1349Bv.m4113(str)) {
            C1283.m16850("nf_mdxSwitchTarget", "current target is not a mdx target");
            return;
        }
        this.f6587 = true;
        this.f6584 = str2;
        this.f6585 = r5;
        this.f6583 = i;
        this.f6580 = i2;
        this.f6586.mo6035(str);
        this.f6581 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6250(String str) {
        if (this.f6587) {
            this.f6582.mo6187(this.f6584);
            if (C1349Bv.m4107(this.f6584)) {
                this.f6586.mo6043(this.f6584, this.f6585.f4576, this.f6580, this.f6585.f4580, this.f6583, this.f6581);
            }
            this.f6587 = false;
        }
    }
}
