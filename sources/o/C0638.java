package o;

import android.graphics.Bitmap;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
/* renamed from: o.ܚ  reason: contains not printable characters */
public final class C0638 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public final Bitmap.Config f13956;

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean f13957 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    public final String f13958;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final ImageLoader.If f13959;

    /* renamed from: ॱ  reason: contains not printable characters */
    public final AssetType f13960;

    public C0638(String str, ImageLoader.If r3, Bitmap.Config config, AssetType assetType) {
        this.f13958 = str;
        this.f13959 = r3;
        this.f13956 = config;
        this.f13960 = assetType;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14776(boolean z) {
        this.f13957 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public ImageLoader.If m14777() {
        return this.f13959;
    }
}
