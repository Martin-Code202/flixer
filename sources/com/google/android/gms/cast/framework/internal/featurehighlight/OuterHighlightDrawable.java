package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
class OuterHighlightDrawable extends Drawable {
    private float centerX;
    private float centerY;
    private final Paint zzeqj;
    private float zzeqk;
    private float zzerm;
    private float zzery;
    private float zzerz;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(this.centerX + this.zzery, this.centerY + this.zzerz, this.zzeqk * this.zzerm, this.zzeqj);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.zzeqj.getAlpha();
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
    public void setScale(float f) {
        this.zzerm = f;
        invalidateSelf();
    }

    @Keep
    public void setTranslationX(float f) {
        this.zzery = f;
        invalidateSelf();
    }

    @Keep
    public void setTranslationY(float f) {
        this.zzerz = f;
        invalidateSelf();
    }
}
