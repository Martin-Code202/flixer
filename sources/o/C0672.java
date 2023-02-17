package o;
/* renamed from: o.৲  reason: contains not printable characters */
public class C0672 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f14051;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f14052;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f14053;

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0458 f14054;

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean f14055;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f14056;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC0414 f14057;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f14058;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f14059;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f14060;

    public C0672(AbstractC0458 r2, AbstractC0417 r3, AbstractC0414 r4) {
        this.f14058 = r3.mo14225();
        this.f14057 = r4;
        this.f14054 = r2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14878(int i, int i2) {
        int r1 = this.f14057.mo14222(i);
        if (r1 != 0) {
            this.f14054.mo14346(r1);
        }
        int r2 = this.f14057.mo14222(i2);
        if (r2 != 0) {
            this.f14054.mo14347(r2);
        }
        this.f14057.mo14223();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14882(int i, int i2) {
        this.f14056 = i;
        this.f14053 = i2;
        this.f14059 = (this.f14058 - i2) - this.f14056;
        if (this.f14053 > this.f14058 - this.f14056) {
            this.f14054.mo14344(this.f14059);
            this.f14060 = true;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14879(int i) {
        this.f14051 = i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14881(int i) {
        this.f14055 = true;
        m14876(i);
        m14877(i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14876(int i) {
        if (i > (this.f14053 - this.f14058) + this.f14056) {
            this.f14054.mo14345();
            this.f14060 = false;
            return;
        }
        this.f14054.mo14344(this.f14059 + i);
        this.f14060 = true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14877(int i) {
        if (i > this.f14051) {
            this.f14054.mo14342(i - this.f14051);
            this.f14052 = true;
            return;
        }
        this.f14054.mo14343();
        this.f14052 = false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14880(int i, int i2) {
        if (this.f14055) {
            this.f14059 = (this.f14058 - i) - this.f14056;
            this.f14053 = i;
            if (i2 > this.f14058 - this.f14056) {
                this.f14054.mo14344(this.f14059);
                this.f14060 = true;
                return;
            }
            this.f14054.mo14345();
            this.f14060 = false;
            return;
        }
        m14882(this.f14056, i);
    }
}
