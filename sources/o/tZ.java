package o;

import android.content.Context;
import android.graphics.Bitmap;
public final class tZ extends tW {

    /* renamed from: ॱ  reason: contains not printable characters */
    private Bitmap f10471;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tZ(Context context, int i, Bitmap bitmap, int i2, int i3) {
        super(context, i, bitmap, i2, i3);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(bitmap, "boxArt");
        if (i > 0) {
            m11056(Bitmap.createScaledBitmap(bitmap, i, (int) (((float) i) * (((float) bitmap.getHeight()) / ((float) bitmap.getWidth()))), true));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11056(Bitmap bitmap) {
        this.f10471 = bitmap;
    }

    @Override // o.tW
    /* renamed from: ˎ */
    public Bitmap mo11041() {
        return this.f10471;
    }
}
