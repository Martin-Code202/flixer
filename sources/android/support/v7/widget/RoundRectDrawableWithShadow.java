package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.R;
/* access modifiers changed from: package-private */
public class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners = true;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty = true;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning = false;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        this.mCornerShadowPaint = new Paint(5);
        this.mCornerShadowPaint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (float) ((int) (0.5f + f));
        this.mCardBounds = new RectF();
        this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private void setBackground(ColorStateList colorStateList) {
        this.mBackground = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.mPaint.setColor(this.mBackground.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private int toEven(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public void setAddPaddingForCorners(boolean z) {
        this.mAddPaddingForCorners = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        this.mCornerShadowPaint.setAlpha(i);
        this.mEdgeShadowPaint.setAlpha(i);
    }

    /* access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    private void setShadowSize(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float even = (float) toEven(f);
            float even2 = (float) toEven(f2);
            if (even > even2) {
                even = even2;
                if (!this.mPrintedShadowClipWarning) {
                    this.mPrintedShadowClipWarning = true;
                }
            }
            if (this.mRawShadowSize != even || this.mRawMaxShadowSize != even2) {
                this.mRawShadowSize = even;
                this.mRawMaxShadowSize = even2;
                this.mShadowSize = (float) ((int) ((1.5f * even) + ((float) this.mInsetShadow) + 0.5f));
                this.mDirty = true;
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float calculateVerticalPadding(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - COS_45) * ((double) f2)));
        }
        return 1.5f * f;
    }

    static float calculateHorizontalPadding(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - COS_45) * ((double) f2)));
        }
        return f;
    }

    /* access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.mBackground.getColorForState(iArr, this.mBackground.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.mBackground != null && this.mBackground.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: package-private */
    public void setCornerRadius(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (this.mCornerRadius != f2) {
            this.mCornerRadius = f2;
            this.mDirty = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    private void drawShadow(Canvas canvas) {
        float f = (-this.mCornerRadius) - this.mShadowSize;
        float f2 = this.mCornerRadius + ((float) this.mInsetShadow) + (this.mRawShadowSize / 2.0f);
        boolean z = this.mCardBounds.width() - (2.0f * f2) > 0.0f;
        boolean z2 = this.mCardBounds.height() - (2.0f * f2) > 0.0f;
        int save = canvas.save();
        canvas.translate(this.mCardBounds.left + f2, this.mCardBounds.top + f2);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z) {
            canvas.drawRect(0.0f, f, this.mCardBounds.width() - (2.0f * f2), -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.mCardBounds.right - f2, this.mCardBounds.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z) {
            canvas.drawRect(0.0f, f, this.mCardBounds.width() - (2.0f * f2), this.mShadowSize + (-this.mCornerRadius), this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.mCardBounds.left + f2, this.mCardBounds.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z2) {
            canvas.drawRect(0.0f, f, this.mCardBounds.height() - (2.0f * f2), -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.mCardBounds.right - f2, this.mCardBounds.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z2) {
            canvas.drawRect(0.0f, f, this.mCardBounds.height() - (2.0f * f2), -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save4);
    }

    private void buildShadowCorners() {
        RectF rectF = new RectF(-this.mCornerRadius, -this.mCornerRadius, this.mCornerRadius, this.mCornerRadius);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.mShadowSize, -this.mShadowSize);
        if (this.mCornerShadowPath == null) {
            this.mCornerShadowPath = new Path();
        } else {
            this.mCornerShadowPath.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        this.mCornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, this.mCornerRadius + this.mShadowSize, new int[]{this.mShadowStartColor, this.mShadowStartColor, this.mShadowEndColor}, new float[]{0.0f, this.mCornerRadius / (this.mCornerRadius + this.mShadowSize), 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setShader(new LinearGradient(0.0f, this.mShadowSize + (-this.mCornerRadius), 0.0f, (-this.mCornerRadius) - this.mShadowSize, new int[]{this.mShadowStartColor, this.mShadowStartColor, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize * 1.5f;
        this.mCardBounds.set(((float) rect.left) + this.mRawMaxShadowSize, ((float) rect.top) + f, ((float) rect.right) - this.mRawMaxShadowSize, ((float) rect.bottom) - f);
        buildShadowCorners();
    }

    /* access modifiers changed from: package-private */
    public void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public void setShadowSize(float f) {
        setShadowSize(f, this.mRawMaxShadowSize);
    }

    /* access modifiers changed from: package-private */
    public void setMaxShadowSize(float f) {
        setShadowSize(this.mRawShadowSize, f);
    }

    /* access modifiers changed from: package-private */
    public float getMinWidth() {
        return ((this.mRawMaxShadowSize + ((float) this.mInsetShadow)) * 2.0f) + (2.0f * Math.max(this.mRawMaxShadowSize, this.mCornerRadius + ((float) this.mInsetShadow) + (this.mRawMaxShadowSize / 2.0f)));
    }

    /* access modifiers changed from: package-private */
    public float getMinHeight() {
        return (((this.mRawMaxShadowSize * 1.5f) + ((float) this.mInsetShadow)) * 2.0f) + (2.0f * Math.max(this.mRawMaxShadowSize, this.mCornerRadius + ((float) this.mInsetShadow) + ((this.mRawMaxShadowSize * 1.5f) / 2.0f)));
    }

    /* access modifiers changed from: package-private */
    public void setColor(ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }
}
