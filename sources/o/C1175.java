package o;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
/* renamed from: o.ﹿ  reason: contains not printable characters */
public class C1175 extends Drawable {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Matrix f15453 = new Matrix();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Paint f15454;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f15455;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final RectF f15456 = new RectF();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private ColorStateList f15457 = ColorStateList.valueOf(-16777216);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final RectF f15458 = new RectF();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private float f15459 = 0.0f;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final RectF f15460 = new RectF();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final BitmapShader f15461;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private ImageView.ScaleType f15462 = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: ͺ  reason: contains not printable characters */
    private float f15463 = 0.0f;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Paint f15464;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f15465 = false;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f15466;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final RectF f15467 = new RectF();

    public C1175(Bitmap bitmap) {
        this.f15466 = bitmap.getWidth();
        this.f15455 = bitmap.getHeight();
        this.f15458.set(0.0f, 0.0f, (float) this.f15466, (float) this.f15455);
        this.f15461 = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f15461.setLocalMatrix(this.f15453);
        this.f15464 = new Paint();
        this.f15464.setStyle(Paint.Style.FILL);
        this.f15464.setAntiAlias(true);
        this.f15464.setShader(this.f15461);
        this.f15454 = new Paint();
        this.f15454.setStyle(Paint.Style.STROKE);
        this.f15454.setAntiAlias(true);
        this.f15454.setColor(this.f15457.getColorForState(getState(), -16777216));
        this.f15454.setStrokeWidth(this.f15463);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C1175 m16385(Bitmap bitmap) {
        if (bitmap != null) {
            return new C1175(bitmap);
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Drawable m16384(Drawable drawable) {
        if (drawable == null || (drawable instanceof C1175)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), m16384(layerDrawable.getDrawable(i)));
            }
            return layerDrawable;
        }
        Bitmap r2 = m16386(drawable);
        if (r2 != null) {
            return new C1175(r2);
        }
        Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
        return drawable;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Bitmap m16386(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 1), Math.max(drawable.getIntrinsicHeight(), 1), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f15457.isStateful();
    }

    /* access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.f15457.getColorForState(iArr, 0);
        if (this.f15454.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f15454.setColor(colorForState);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ﹿ$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: ˏ  reason: contains not printable characters */
        static final /* synthetic */ int[] f15468 = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f15468[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15468[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15468[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15468[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15468[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15468[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15468[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16383() {
        float f;
        float f2;
        switch (AnonymousClass3.f15468[this.f15462.ordinal()]) {
            case 1:
                this.f15467.set(this.f15460);
                this.f15467.inset(this.f15463 / 2.0f, this.f15463 / 2.0f);
                this.f15453.set(null);
                this.f15453.setTranslate((float) ((int) (((this.f15467.width() - ((float) this.f15466)) * 0.5f) + 0.5f)), (float) ((int) (((this.f15467.height() - ((float) this.f15455)) * 0.5f) + 0.5f)));
                break;
            case 2:
                this.f15467.set(this.f15460);
                this.f15467.inset(this.f15463 / 2.0f, this.f15463 / 2.0f);
                this.f15453.set(null);
                float f3 = 0.0f;
                float f4 = 0.0f;
                if (((float) this.f15466) * this.f15467.height() > this.f15467.width() * ((float) this.f15455)) {
                    f2 = this.f15467.height() / ((float) this.f15455);
                    f3 = (this.f15467.width() - (((float) this.f15466) * f2)) * 0.5f;
                } else {
                    f2 = this.f15467.width() / ((float) this.f15466);
                    f4 = (this.f15467.height() - (((float) this.f15455) * f2)) * 0.5f;
                }
                this.f15453.setScale(f2, f2);
                this.f15453.postTranslate(((float) ((int) (0.5f + f3))) + this.f15463, ((float) ((int) (0.5f + f4))) + this.f15463);
                break;
            case 3:
                this.f15453.set(null);
                if (((float) this.f15466) > this.f15460.width() || ((float) this.f15455) > this.f15460.height()) {
                    f = Math.min(this.f15460.width() / ((float) this.f15466), this.f15460.height() / ((float) this.f15455));
                } else {
                    f = 1.0f;
                }
                float width = (float) ((int) (((this.f15460.width() - (((float) this.f15466) * f)) * 0.5f) + 0.5f));
                float height = (float) ((int) (((this.f15460.height() - (((float) this.f15455) * f)) * 0.5f) + 0.5f));
                this.f15453.setScale(f, f);
                this.f15453.postTranslate(width, height);
                this.f15467.set(this.f15458);
                this.f15453.mapRect(this.f15467);
                this.f15467.inset(this.f15463 / 2.0f, this.f15463 / 2.0f);
                this.f15453.setRectToRect(this.f15458, this.f15467, Matrix.ScaleToFit.FILL);
                break;
            case 4:
            default:
                this.f15467.set(this.f15458);
                this.f15453.setRectToRect(this.f15458, this.f15460, Matrix.ScaleToFit.CENTER);
                this.f15453.mapRect(this.f15467);
                this.f15467.inset(this.f15463 / 2.0f, this.f15463 / 2.0f);
                this.f15453.setRectToRect(this.f15458, this.f15467, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.f15467.set(this.f15458);
                this.f15453.setRectToRect(this.f15458, this.f15460, Matrix.ScaleToFit.END);
                this.f15453.mapRect(this.f15467);
                this.f15467.inset(this.f15463 / 2.0f, this.f15463 / 2.0f);
                this.f15453.setRectToRect(this.f15458, this.f15467, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.f15467.set(this.f15458);
                this.f15453.setRectToRect(this.f15458, this.f15460, Matrix.ScaleToFit.START);
                this.f15453.mapRect(this.f15467);
                this.f15467.inset(this.f15463 / 2.0f, this.f15463 / 2.0f);
                this.f15453.setRectToRect(this.f15458, this.f15467, Matrix.ScaleToFit.FILL);
                break;
            case 7:
                this.f15467.set(this.f15460);
                this.f15467.inset(this.f15463 / 2.0f, this.f15463 / 2.0f);
                this.f15453.set(null);
                this.f15453.setRectToRect(this.f15458, this.f15467, Matrix.ScaleToFit.FILL);
                break;
        }
        this.f15456.set(this.f15467);
        this.f15461.setLocalMatrix(this.f15453);
    }

    /* access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f15460.set(rect);
        m16383();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f15465) {
            if (this.f15463 > 0.0f) {
                canvas.drawOval(this.f15456, this.f15464);
                canvas.drawOval(this.f15467, this.f15454);
                return;
            }
            canvas.drawOval(this.f15456, this.f15464);
        } else if (this.f15463 > 0.0f) {
            canvas.drawRoundRect(this.f15456, Math.max(this.f15459, 0.0f), Math.max(this.f15459, 0.0f), this.f15464);
            canvas.drawRoundRect(this.f15467, this.f15459, this.f15459, this.f15454);
        } else {
            canvas.drawRoundRect(this.f15456, this.f15459, this.f15459, this.f15464);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f15464.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15464.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f15464.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f15464.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f15466;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f15455;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1175 m16390(float f) {
        this.f15459 = f;
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1175 m16389(int i) {
        this.f15463 = (float) i;
        this.f15454.setStrokeWidth(this.f15463);
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1175 m16387(ColorStateList colorStateList) {
        this.f15457 = colorStateList != null ? colorStateList : ColorStateList.valueOf(0);
        this.f15454.setColor(this.f15457.getColorForState(getState(), -16777216));
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1175 m16391(boolean z) {
        this.f15465 = z;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1175 m16388(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f15462 != scaleType) {
            this.f15462 = scaleType;
            m16383();
        }
        return this;
    }
}
