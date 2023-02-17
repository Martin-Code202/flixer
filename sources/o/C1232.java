package o;

import android.content.Context;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import java.util.regex.Pattern;
/* renamed from: o.ｎ  reason: contains not printable characters */
public final class C1232 implements AbstractC0518 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f15760 = SecurityRepository.getEsnDelim();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f15761 = SecurityRepository.getEsnPrefix();

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f15762;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f15763;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f15764;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f15765;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f15766;

    /* renamed from: ॱ  reason: contains not printable characters */
    private CryptoProvider f15767;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f15768;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Context f15769;

    private C1232(Context context, String str) {
        this.f15769 = context;
        this.f15762 = str;
        this.f15767 = m16584(this.f15762) ? CryptoProvider.WIDEVINE_L1 : CryptoProvider.WIDEVINE_L3;
        if (this.f15762.lastIndexOf(f15760) < 0) {
            throw new IllegalStateException("Invalid ESN");
        }
        m16586();
        this.f15766 = this.f15765.substring(this.f15765.lastIndexOf(f15760) + 1);
        this.f15763 = AbstractC0488.m14428();
        m16585(this.f15769);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m16586() {
        int length = this.f15762.split(Pattern.quote("-")).length - 1;
        int length2 = f15761.length() + "PRV-".length();
        switch (length) {
            case 3:
                break;
            case 4:
            default:
                C1283.m16855("ESN", "unexpected esn %s", this.f15762);
                break;
            case 5:
                length2 += "P-".length();
                break;
            case 6:
                length2 += "P-".length() + "L3-".length();
                break;
        }
        this.f15765 = this.f15762.substring(0, length2);
        C1283.m16851("ESN", "Cached ESN prefix: %s", this.f15765);
    }

    @Override // o.AbstractC0518
    /* renamed from: ˋ */
    public byte[] mo14444() {
        return null;
    }

    @Override // o.AbstractC0518
    /* renamed from: ॱ */
    public String mo14449() {
        return this.f15762;
    }

    @Override // o.AbstractC0518
    /* renamed from: ˎ */
    public String mo14445() {
        return this.f15768;
    }

    @Override // o.AbstractC0518
    /* renamed from: ˏ */
    public String mo14447() {
        return this.f15764;
    }

    @Override // o.AbstractC0518
    /* renamed from: ˊ */
    public String mo14442() {
        return this.f15765;
    }

    @Override // o.AbstractC0518
    /* renamed from: ᐝ */
    public String mo14452() {
        return this.f15763;
    }

    @Override // o.AbstractC0518
    /* renamed from: ʼ */
    public String mo14441() {
        return this.f15762;
    }

    @Override // o.AbstractC0518
    /* renamed from: ʽ */
    public CryptoProvider mo14530() {
        return this.f15767;
    }

    @Override // o.AbstractC0518
    /* renamed from: ʻ */
    public String mo14537() {
        return this.f15766;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16585(Context context) {
        new StringBuilder();
        String r3 = AbstractC0488.m14427(AbstractC0488.m14435());
        String r4 = AbstractC0488.m14424(context);
        StringBuilder sb = new StringBuilder();
        sb.append(f15761);
        sb.append(r3).append(f15760).append(r4);
        this.f15768 = sb.toString();
        String r5 = AbstractC0488.m14438(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f15761);
        sb2.append(r3).append(f15760).append(r5);
        this.f15764 = sb2.toString();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C1232 m16583(Context context) {
        String r3 = C1339Bl.m4045(context, "nf_drm_esn", (String) null);
        if (C1349Bv.m4113(r3)) {
            return null;
        }
        try {
            return new C1232(context, r3);
        } catch (Throwable th) {
            C1283.m16856("ESN", th, "Failed to create cached ESN provider!", new Object[0]);
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m16584(String str) {
        return !str.contains("L3-");
    }
}
