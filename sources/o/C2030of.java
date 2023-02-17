package o;

import com.netflix.mediaclient.util.net.AuthorizationCredentials;
/* renamed from: o.of  reason: case insensitive filesystem */
public class C2030of implements AbstractC2031og {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC2031og f9327;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f9328;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f9329;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f9330;

    public C2030of(AbstractC2031og ogVar) {
        this.f9327 = ogVar;
        if (ogVar != null) {
            this.f9328 = ogVar.mo1399();
            this.f9330 = ogVar.mo1397();
            this.f9329 = ogVar.mo1396();
        }
    }

    @Override // o.AbstractC2031og
    /* renamed from: ˊ */
    public String mo1396() {
        return this.f9329;
    }

    @Override // o.AbstractC2031og
    /* renamed from: ॱ */
    public String mo1401() {
        return this.f9327.mo1401();
    }

    @Override // o.AbstractC2031og
    /* renamed from: ˎ */
    public String mo1398() {
        return this.f9327.mo1398();
    }

    @Override // o.AbstractC2031og
    /* renamed from: ˏ */
    public String mo1399() {
        return this.f9328;
    }

    @Override // o.AbstractC2031og
    /* renamed from: ˋ */
    public String mo1397() {
        return this.f9330;
    }

    @Override // o.AbstractC2031og
    /* renamed from: ˏ */
    public boolean mo1400(AuthorizationCredentials authorizationCredentials) {
        return this.f9327.mo1400(authorizationCredentials);
    }

    @Override // o.AbstractC2031og
    /* renamed from: ʻ */
    public String mo1395() {
        return this.f9327.mo1395();
    }
}
