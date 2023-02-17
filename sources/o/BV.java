package o;

import android.graphics.Bitmap;
public class BV extends C0456<String, Bitmap> {
    public BV(int i) {
        super("BitmapLruCache", i);
        C1283.m16846("BitmapLruCache", "Max size: " + i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Bitmap m3924(String str) {
        return (Bitmap) super.get(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3925(String str, Bitmap bitmap) {
        put(str, bitmap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
        super.entryRemoved(z, str, bitmap, bitmap2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}
