package o;
/* renamed from: o.fD  reason: case insensitive filesystem */
public abstract class AbstractC1744fD extends AbstractC1741fA {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6712 = "sessionAction=appMessage\r\n";

    protected AbstractC1744fD(String str) {
        super(str);
        m6350("appAction", str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6350(String str, String str2) {
        this.f6712 += str + "=" + str2 + "\r\n";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6354(String str, String str2) {
        this.f6712 += "appBody." + str + "=" + str2 + "\r\n";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6353(String str, boolean z) {
        this.f6712 += "appBody." + str + "=" + String.valueOf(z) + "\r\n";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6351(String str, int i) {
        this.f6712 += "appBody." + str + "=" + String.valueOf(i) + "\r\n";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m6352(int i) {
        return this.f6712 + "sessionId=" + String.valueOf(i) + "\r\n";
    }
}
