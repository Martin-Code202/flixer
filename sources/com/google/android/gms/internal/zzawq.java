package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
/* access modifiers changed from: package-private */
public final class zzawq implements zzawf {
    private /* synthetic */ zzawp zzevl;

    zzawq(zzawp zzawp) {
        this.zzevl = zzawp;
    }

    @Override // com.google.android.gms.internal.zzawf
    public final void zzc(Bitmap bitmap) {
        Bitmap bitmap2;
        if (bitmap == null) {
            bitmap2 = null;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = (int) (((((float) width) * 9.0f) / 16.0f) + 0.5f);
            float f = (float) ((i - height) / 2);
            RectF rectF = new RectF(0.0f, f, (float) width, ((float) height) + f);
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, i, config);
            new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
            bitmap2 = createBitmap;
        }
        this.zzevl.zza(bitmap2, 0);
    }
}
