package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
/* renamed from: o.ﹸ  reason: contains not printable characters */
public class C1167 implements AbstractC0414 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final TypedArray f15434;

    public C1167(Context context, AttributeSet attributeSet, int[] iArr) {
        this.f15434 = context.obtainStyledAttributes(attributeSet, iArr);
    }

    @Override // o.AbstractC0414
    /* renamed from: ˎ */
    public int mo14222(int i) {
        return this.f15434.getResourceId(i, 0);
    }

    @Override // o.AbstractC0414
    /* renamed from: ˏ */
    public void mo14223() {
        this.f15434.recycle();
    }
}
