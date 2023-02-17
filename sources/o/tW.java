package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
public abstract class tW extends AnimationDrawable implements Animatable, Runnable {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f10449;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Context f10450;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f10451;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f10452;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Paint f10453;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Rect f10454;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Paint f10455;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Path f10456;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f10457;

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract Bitmap mo11041();

    public tW(Context context, int i, Bitmap bitmap, int i2, int i3) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(bitmap, "boxArt");
        this.f10450 = context;
        this.f10457 = i;
        this.f10451 = i2;
        this.f10449 = i3;
        Integer num = (Integer) ED.m4791((Comparable[]) new Integer[]{Integer.valueOf(this.f10457), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
        this.f10452 = num != null ? num.intValue() : 0;
        this.f10456 = new Path();
        this.f10455 = new Paint(1);
        this.f10455.setStyle(Paint.Style.STROKE);
        this.f10455.setColor(this.f10451);
        this.f10455.setStrokeWidth((float) C1004.m15954(this.f10450, 2));
        this.f10453 = new Paint(1);
        this.f10453.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) this.f10457, 0, this.f10449, Shader.TileMode.CLAMP));
        this.f10454 = new Rect(0, 0, this.f10457, this.f10457);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final int m11040() {
        return this.f10452;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C1457Fr.m5025(canvas, "canvas");
        if (this.f10452 > 0 && mo11041() != null) {
            float r4 = FA.m4975(((float) this.f10457) / 2.0f);
            this.f10456.addCircle(r4, r4, r4, Path.Direction.CW);
            canvas.clipPath(this.f10456);
            int save = canvas.save();
            canvas.drawBitmap(mo11041(), 0.0f, 0.0f, (Paint) null);
            canvas.drawCircle(r4, r4, r4, this.f10455);
            canvas.drawRect(this.f10454, this.f10453);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f10455.setAlpha(i);
        this.f10453.setAlpha(i);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f10455.setColorFilter(colorFilter);
        this.f10453.setColorFilter(colorFilter);
    }
}
