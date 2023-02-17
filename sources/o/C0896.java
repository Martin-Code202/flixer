package o;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.android.volley.ParseError;
import com.android.volley.Request;
import o.C0524;
/* renamed from: o.ᕝ  reason: contains not printable characters */
public class C0896 extends Request<Bitmap> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Object f14770 = new Object();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0524.If<Bitmap> f14771;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Bitmap.Config f14772;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f14773;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f14774;

    public C0896(String str, C0524.If<Bitmap> r6, int i, int i2, Bitmap.Config config, C0524.AbstractC2398iF iFVar) {
        super(0, str, iFVar);
        setRetryPolicy(new C1040(1000, 2, 2.0f));
        this.f14771 = r6;
        this.f14772 = config;
        this.f14774 = i;
        this.f14773 = i2;
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int m15620(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = ((double) i4) / ((double) i3);
            if (((double) i) * d > ((double) i2)) {
                return (int) (((double) i2) / d);
            }
            return i;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<Bitmap> parseNetworkResponse(C1181 r8) {
        C0524<Bitmap> r0;
        synchronized (f14770) {
            try {
                r0 = m15622(r8);
            } catch (OutOfMemoryError e) {
                C0509.m14519("Caught OOM for %d byte image, url=%s", Integer.valueOf(r8.f15530.length), getUrl());
                return C0524.m14562(new ParseError(e));
            }
        }
        return r0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0524<Bitmap> m15622(C1181 r11) {
        Bitmap bitmap;
        byte[] bArr = r11.f15530;
        this.mResponseSizeInBytes = bArr.length;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f14774 == 0 && this.f14773 == 0) {
            options.inPreferredConfig = this.f14772;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int r7 = m15620(this.f14774, this.f14773, i, i2);
            int r8 = m15620(this.f14773, this.f14774, i2, i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m15621(i, i2, r7, r8);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null || (decodeByteArray.getWidth() <= r7 && decodeByteArray.getHeight() <= r8)) {
                bitmap = decodeByteArray;
            } else {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, r7, r8, true);
                decodeByteArray.recycle();
            }
        }
        if (bitmap == null) {
            return C0524.m14562(new ParseError());
        }
        return C0524.m14563(bitmap, C0833.m15449(r11));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void deliverResponse(Bitmap bitmap) {
        this.f14771.onResponse(bitmap);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static int m15621(int i, int i2, int i3, int i4) {
        float f = 1.0f;
        while (((double) (2.0f * f)) <= Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4))) {
            f *= 2.0f;
        }
        return (int) f;
    }
}
