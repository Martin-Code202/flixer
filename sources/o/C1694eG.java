package o;
/* renamed from: o.eG  reason: case insensitive filesystem */
public class C1694eG {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f6462;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6463;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6464;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6465;

    public C1694eG(String str, String str2, String str3, boolean z) {
        this.f6465 = str;
        this.f6463 = str2;
        this.f6464 = str3;
        this.f6462 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m6073() {
        return this.f6462;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1694eG)) {
            return false;
        }
        C1694eG eGVar = (C1694eG) obj;
        return C1349Bv.m4126(this.f6465, eGVar.f6465) && C1349Bv.m4126(this.f6463, eGVar.f6463) && C1349Bv.m4126(this.f6464, eGVar.f6464) && this.f6462 == eGVar.f6462;
    }
}
