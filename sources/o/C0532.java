package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.netflix.mediaclient.R;
/* renamed from: o.ԅ  reason: contains not printable characters */
public class C0532 extends C0522 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f13722;

    /* renamed from: ʼ  reason: contains not printable characters */
    private float f13723;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f13724;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f13725;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private BitmapShader f13726;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f13727;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private Paint f13728;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f13729;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13730;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f13731;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Bitmap f13732;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f13733;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Paint f13734;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private float f13735;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private ColorFilter f13736;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private float f13737;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Paint f13738;

    public C0532(Context context) {
        this(context, null, 0);
    }

    public C0532(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0532(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14575(context, attributeSet, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14575(Context context, AttributeSet attributeSet, int i) {
        this.f13734 = new Paint();
        this.f13734.setAntiAlias(true);
        this.f13728 = new Paint();
        this.f13728.setAntiAlias(true);
        this.f13728.setStyle(Paint.Style.STROKE);
        this.f13738 = new Paint();
        this.f13738.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.C0006.CircleImageView, i, 0);
        this.f13727 = obtainStyledAttributes.getBoolean(0, false);
        this.f13729 = obtainStyledAttributes.getBoolean(3, false);
        this.f13724 = obtainStyledAttributes.getBoolean(7, false);
        if (this.f13727) {
            setBorderWidth(obtainStyledAttributes.getDimensionPixelOffset(2, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f)));
            setBorderColor(obtainStyledAttributes.getColor(1, -1));
        }
        if (this.f13729) {
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
            setSelectorColor(obtainStyledAttributes.getColor(4, 0));
            setSelectorStrokeWidth(obtainStyledAttributes.getDimensionPixelOffset(6, i2));
            setSelectorStrokeColor(obtainStyledAttributes.getColor(5, -16776961));
        }
        if (this.f13724) {
            this.f13735 = obtainStyledAttributes.getFloat(9, 1.0f);
            this.f13723 = obtainStyledAttributes.getFloat(10, 0.0f);
            this.f13737 = obtainStyledAttributes.getFloat(11, 2.0f);
            this.f13731 = obtainStyledAttributes.getColor(8, -16777216);
            setShadowEnabled(true);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // o.AbstractC1188
    public void setBorderWidth(int i) {
        this.f13733 = i;
        if (this.f13728 != null) {
            this.f13728.setStrokeWidth((float) i);
        }
        requestLayout();
        invalidate();
    }

    @Override // o.AbstractC1188
    public void setBorderColor(int i) {
        if (this.f13728 != null) {
            this.f13728.setColor(i);
        }
        invalidate();
    }

    public void setSelectorColor(int i) {
        this.f13736 = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        invalidate();
    }

    public void setSelectorStrokeWidth(int i) {
        this.f13722 = i;
        requestLayout();
        invalidate();
    }

    public void setSelectorStrokeColor(int i) {
        if (this.f13738 != null) {
            this.f13738.setColor(i);
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.f13724 = z;
        m14577();
    }

    public void setShadow(float f, float f2, float f3, int i) {
        this.f13735 = f;
        this.f13723 = f2;
        this.f13737 = f3;
        this.f13731 = i;
        m14577();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13732 != null && this.f13732.getHeight() != 0 && this.f13732.getWidth() != 0) {
            int i = this.f13725;
            this.f13725 = getWidth() < getHeight() ? getWidth() : getHeight();
            if (i != this.f13725) {
                m14578();
            }
            this.f13734.setShader(this.f13726);
            int i2 = 0;
            int i3 = this.f13725 / 2;
            if (this.f13729 && this.f13730) {
                i2 = this.f13722;
                i3 = (this.f13725 - (i2 * 2)) / 2;
                this.f13734.setColorFilter(this.f13736);
                canvas.drawCircle((float) (i3 + i2), (float) (i3 + i2), ((float) (((this.f13725 - (i2 * 2)) / 2) + i2)) - 4.0f, this.f13738);
            } else if (this.f13727) {
                i2 = this.f13733;
                i3 = (this.f13725 - (i2 * 2)) / 2;
                this.f13734.setColorFilter(null);
                canvas.drawArc(new RectF((float) ((i2 / 2) + 0), (float) ((i2 / 2) + 0), (float) (this.f13725 - (i2 / 2)), (float) (this.f13725 - (i2 / 2))), 360.0f, 360.0f, false, this.f13728);
            } else {
                this.f13734.setColorFilter(null);
            }
            canvas.drawCircle((float) (i3 + i2), (float) (i3 + i2), (float) ((this.f13725 - (i2 * 2)) / 2), this.f13734);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isClickable()) {
            this.f13730 = false;
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f13730 = true;
                break;
            case 1:
            case 3:
            case 4:
            case 8:
                this.f13730 = false;
                break;
        }
        invalidate();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // o.AbstractC1188, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f13732 = m14579(getDrawable());
        if (this.f13725 > 0) {
            m14578();
        }
    }

    @Override // o.AbstractC1188, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f13732 = m14579(getDrawable());
        if (this.f13725 > 0) {
            m14578();
        }
    }

    @Override // o.AbstractC1188, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f13732 = m14579(getDrawable());
        if (this.f13725 > 0) {
            m14578();
        }
    }

    @Override // o.AbstractC1188, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f13732 = bitmap;
        if (this.f13725 > 0) {
            m14578();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C0522, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m14574(i), m14576(i2));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int m14574(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return size;
        }
        return this.f13725;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private int m14576(int i) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i2 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i2 = size;
        } else {
            i2 = this.f13725;
        }
        return i2 + 2;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m14577() {
        float f = this.f13724 ? this.f13735 : 0.0f;
        this.f13728.setShadowLayer(f, this.f13723, this.f13737, this.f13731);
        this.f13738.setShadowLayer(f, this.f13723, this.f13737, this.f13731);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Bitmap m14579(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            C1283.m16862("CircleImageView", "Bitmap drawable!");
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            C1283.m16850("CircleImageView", "Encountered OutOfMemoryError while generating bitmap!");
            return null;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m14578() {
        if (this.f13732 != null) {
            this.f13726 = new BitmapShader(this.f13732, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            if (this.f13725 != this.f13732.getWidth() || this.f13725 != this.f13732.getHeight()) {
                Matrix matrix = new Matrix();
                float width = ((float) this.f13725) / ((float) this.f13732.getWidth());
                matrix.setScale(width, width);
                this.f13726.setLocalMatrix(matrix);
            }
        }
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.f13730;
    }
}
