package o;
/* renamed from: o.ﹴ  reason: contains not printable characters */
public class C1163 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f15417;

    /* renamed from: ˎ  reason: contains not printable characters */
    private float f15418;

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16352(float f) {
        this.f15418 += f;
        this.f15417++;
        if (this.f15417 == Integer.MAX_VALUE) {
            this.f15418 /= 2.0f;
            this.f15417 /= 2;
        }
    }
}
