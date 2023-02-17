package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
class InnerZoneDrawable extends Drawable {
    private float centerX;
    private float centerY;
    private final Paint zzeqj;
    private float zzeqk;
    private final Paint zzerj;
    private final int zzerl;
    private float zzerm;
    private float zzern;
    private float zzero;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.zzero > 0.0f) {
            float f = this.zzeqk * this.zzern;
            this.zzerj.setAlpha((int) (((float) this.zzerl) * this.zzero));
            canvas.drawCircle(this.centerX, this.centerY, f, this.zzerj);
        }
        canvas.drawCircle(this.centerX, this.centerY, this.zzeqk * this.zzerm, this.zzeqj);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.zzeqj.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.zzeqj.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setPulseAlpha(float f) {
        this.zzero = f;
        invalidateSelf();
    }

    @Keep
    public void setPulseScale(float f) {
        this.zzern = f;
        invalidateSelf();
    }

    @Keep
    public void setScale(float f) {
        this.zzerm = f;
        invalidateSelf();
    }
}
