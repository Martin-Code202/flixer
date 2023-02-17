package o;

import android.content.Context;
/* renamed from: o.Cq  reason: case insensitive filesystem */
public final class C1374Cq implements AbstractC1378Cu {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f5189;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f5190;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f5191 = C1374Cq.class.getSimpleName();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f5192 = "nfvdid";

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f5193 = "flwssn";

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Context f5194;

    public C1374Cq(Context context) {
        this.f5194 = context;
        this.f5190 = C1339Bl.m4045(this.f5194, "nfvdid", (String) null);
        this.f5189 = C1339Bl.m4045(this.f5194, "flwssn", (String) null);
    }

    @Override // o.AbstractC1378Cu
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo4542() {
        return this.f5190;
    }

    @Override // o.AbstractC1378Cu
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo4540() {
        return "nfvdid";
    }

    @Override // o.AbstractC1378Cu
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo4539(String str) {
        if (!C1349Bv.m4126(this.f5190, str)) {
            this.f5190 = str;
            C1339Bl.m4039(this.f5194, "nfvdid", str);
        }
    }

    @Override // o.AbstractC1378Cu
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo4541() {
        return "flwssn";
    }

    @Override // o.AbstractC1378Cu
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo4538() {
        return this.f5189;
    }

    @Override // o.AbstractC1378Cu
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo4543(String str) {
        if (!C1349Bv.m4126(this.f5189, str)) {
            this.f5189 = str;
            C1339Bl.m4039(this.f5194, "flwssn", str);
        }
    }
}
