package o;
/* renamed from: o.mp  reason: case insensitive filesystem */
public class C1985mp {

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f8919;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f8920;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f8921;

    public C1985mp(String str, int i, int i2) {
        this.f8921 = str;
        this.f8920 = i;
        this.f8919 = i2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9061(int i, int i2) {
        this.f8920 += i;
        this.f8919 += i2;
    }

    public String toString() {
        return "SubtitleQoe{downloadableId='" + this.f8921 + "', expectedToShow=" + this.f8920 + ", displayed=" + this.f8919 + '}';
    }
}
