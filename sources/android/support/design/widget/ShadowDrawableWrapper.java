package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;
/* access modifiers changed from: package-private */
public class ShadowDrawableWrapper extends DrawableWrapper {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private boolean mAddPaddingForCorners = true;
    final RectF mContentBounds;
    float mCornerRadius;
    final Paint mCornerShadowPaint;
    Path mCornerShadowPath;
    private boolean mDirty = true;
    final Paint mEdgeShadowPaint;
    float mMaxShadowSize;
    private boolean mPrintedShadowClipWarning = false;
    float mRawMaxShadowSize;
    float mRawShadowSize;
    private float mRotation;
    private final int mShadowEndColor;
    private final int mShadowMiddleColor;
    float mShadowSize;
    private final int mShadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.mShadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.mShadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.mShadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        this.mCornerShadowPaint = new Paint(5);
        this.mCornerShadowPaint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (float) Math.round(f);
        this.mContentBounds = new RectF();
        this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private static int toEven(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.mAddPaddingForCorners = z;
        invalidateSelf();
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.mCornerShadowPaint.setAlpha(i);
        this.mEdgeShadowPaint.setAlpha(i);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.mDirty = true;
    }

    /* access modifiers changed from: package-private */
    public void setShadowSize(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
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
            this.mShadowSize = (float) Math.round(1.5f * even);
            this.mMaxShadowSize = even2;
            this.mDirty = true;
            invalidateSelf();
        }
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - COS_45) * ((double) f2)));
        }
        return 1.5f * f;
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - COS_45) * ((double) f2)));
        }
        return f;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public final void setRotation(float f) {
        if (this.mRotation != f) {
            this.mRotation = f;
            invalidateSelf();
        }
    }

    private void drawShadow(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.mRotation, this.mContentBounds.centerX(), this.mContentBounds.centerY());
        float f = (-this.mCornerRadius) - this.mShadowSize;
        float f2 = this.mCornerRadius;
        boolean z = this.mContentBounds.width() - (2.0f * f2) > 0.0f;
        boolean z2 = this.mContentBounds.height() - (2.0f * f2) > 0.0f;
        float f3 = this.mRawShadowSize - (this.mRawShadowSize * 0.25f);
        float f4 = f2 / (f2 + (this.mRawShadowSize - (this.mRawShadowSize * 0.5f)));
        float f5 = f2 / (f2 + f3);
        float f6 = f2 / (f2 + (this.mRawShadowSize - (this.mRawShadowSize * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.mContentBounds.left + f2, this.mContentBounds.top + f2);
        canvas.scale(f4, f5);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.mContentBounds.width() - (2.0f * f2), -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.mContentBounds.right - f2, this.mContentBounds.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.mContentBounds.width() - (2.0f * f2), this.mShadowSize + (-this.mCornerRadius), this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.mContentBounds.left + f2, this.mContentBounds.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f, this.mContentBounds.height() - (2.0f * f2), -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        canvas.translate(this.mContentBounds.right - f2, this.mContentBounds.top + f2);
        canvas.scale(f4, f5);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.mContentBounds.height() - (2.0f * f2), -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(save);
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
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.mCornerRadius / f;
            this.mCornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.mShadowStartColor, this.mShadowMiddleColor, this.mShadowEndColor}, new float[]{0.0f, f2, f2 + ((1.0f - f2) / 2.0f), 1.0f}, Shader.TileMode.CLAMP));
        }
        this.mEdgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.mShadowStartColor, this.mShadowMiddleColor, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize * 1.5f;
        this.mContentBounds.set(((float) rect.left) + this.mRawMaxShadowSize, ((float) rect.top) + f, ((float) rect.right) - this.mRawMaxShadowSize, ((float) rect.bottom) - f);
        getWrappedDrawable().setBounds((int) this.mContentBounds.left, (int) this.mContentBounds.top, (int) this.mContentBounds.right, (int) this.mContentBounds.bottom);
        buildShadowCorners();
    }

    public void setShadowSize(float f) {
        setShadowSize(f, this.mRawMaxShadowSize);
    }

    public float getShadowSize() {
        return this.mRawShadowSize;
    }
}
