package o;

import android.util.Log;
import com.android.volley.VolleyError;
/* renamed from: o.ᵧ  reason: contains not printable characters */
public class C1040 implements AbstractC0573 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f15153;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final float f15154;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f15155;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f15156;

    public C1040() {
        this(2500, 1, 1.0f);
    }

    public C1040(int i, int i2, float f) {
        this.f15155 = i;
        this.f15156 = i2;
        this.f15154 = f;
    }

    @Override // o.AbstractC0573
    /* renamed from: ˋ */
    public int mo14675() {
        return this.f15155;
    }

    @Override // o.AbstractC0573
    /* renamed from: ˎ */
    public int mo14677() {
        return this.f15153;
    }

    @Override // o.AbstractC0573
    /* renamed from: ˋ */
    public void mo14676(VolleyError volleyError) {
        if (Log.isLoggable("DefaultRetryPolicy", 3)) {
            Log.d("DefaultRetryPolicy", "retrying - " + toString());
        }
        this.f15153++;
        this.f15155 = (int) (((float) this.f15155) + (((float) this.f15155) * this.f15154));
        if (!m16043()) {
            throw volleyError;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m16043() {
        if (Log.isLoggable("DefaultRetryPolicy", 3)) {
            Log.d("DefaultRetryPolicy", "hasAttemptRemaining() - " + toString());
        }
        return this.f15153 <= this.f15156;
    }

    public String toString() {
        return String.format(getClass().getSimpleName() + ": %d, %d / %d [%dms]", Integer.valueOf(hashCode()), Integer.valueOf(this.f15153), Integer.valueOf(this.f15156), Integer.valueOf(this.f15155));
    }
}
