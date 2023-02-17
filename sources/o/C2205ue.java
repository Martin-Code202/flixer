package o;

import android.content.Context;
import android.graphics.Bitmap;
/* renamed from: o.ue  reason: case insensitive filesystem */
public final class C2205ue extends tW {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Bitmap f10984;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f10985;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2205ue(Context context, int i, Bitmap bitmap, int i2, int i3) {
        super(context, i, bitmap, i2, i3);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(bitmap, "boxArt");
        this.f10985 = (int) FA.m4975(((float) (bitmap.getWidth() - m11040())) / 2.0f);
        if (i > 0) {
            m11700(Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmap, m11701(), 0, m11040(), m11040()), i, i, true));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m11701() {
        return this.f10985;
    }

    @Override // o.tW
    /* renamed from: ˎ */
    public Bitmap mo11041() {
        return this.f10984;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11700(Bitmap bitmap) {
        this.f10984 = bitmap;
    }
}
