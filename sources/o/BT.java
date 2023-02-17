package o;

import android.graphics.Bitmap;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.util.HashMap;
public class BT {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f4622;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final HashMap<String, BR> f4623;

    /* renamed from: ˋ  reason: contains not printable characters */
    public Bitmap f4624;

    /* renamed from: ˎ  reason: contains not printable characters */
    public final ImageLoader.AbstractC0050 f4625;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final HashMap<String, BR> f4626;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f4627;

    public BT(Bitmap bitmap, String str, String str2, ImageLoader.AbstractC0050 r4, HashMap<String, BR> hashMap, HashMap<String, BR> hashMap2) {
        this.f4624 = bitmap;
        this.f4622 = str;
        this.f4627 = str2;
        this.f4625 = r4;
        this.f4623 = hashMap;
        this.f4626 = hashMap2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Bitmap m3923() {
        return this.f4624;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m3922() {
        return this.f4622;
    }

    public String toString() {
        int width = this.f4624 == null ? -1 : this.f4624.getWidth();
        return "ImageContainer [mBitmap=" + this.f4624 + ", x=" + width + ", y=" + (this.f4624 == null ? -1 : this.f4624.getHeight()) + ", byteCount=" + (this.f4624 == null ? -1 : this.f4624.getAllocationByteCount()) + ", mCacheKey=" + this.f4627 + ", mRequestUrl=" + this.f4622 + "]";
    }
}
