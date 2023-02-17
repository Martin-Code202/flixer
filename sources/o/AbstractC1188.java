package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import o.C1238;
/* renamed from: o.ﺘ  reason: contains not printable characters */
public abstract class AbstractC1188 extends AbstractC0575 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final ImageView.ScaleType[] f15551 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f15552;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f15553;

    /* renamed from: ʽ  reason: contains not printable characters */
    private ImageView.ScaleType f15554;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f15555;

    /* renamed from: ˋ  reason: contains not printable characters */
    private ColorStateList f15556;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f15557;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f15558;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Drawable f15559;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f15560;

    public abstract void setImageLoaderInfo(C0638 v);

    /* renamed from: ˏ */
    public abstract C0638 mo14544();

    public AbstractC1188(Context context) {
        this(context, null);
    }

    public AbstractC1188(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractC1188(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15558 = 0;
        this.f15557 = 0;
        this.f15556 = ColorStateList.valueOf(-16777216);
        this.f15555 = false;
        this.f15560 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1238.C1239.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(C1238.C1239.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(f15551[i2]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.f15558 = obtainStyledAttributes.getDimensionPixelSize(C1238.C1239.RoundedImageView_corner_radius, -1);
        this.f15557 = obtainStyledAttributes.getDimensionPixelSize(C1238.C1239.RoundedImageView_border_width, -1);
        if (this.f15558 < 0) {
            this.f15558 = 0;
        }
        if (this.f15557 < 0) {
            this.f15557 = 0;
        }
        this.f15556 = obtainStyledAttributes.getColorStateList(C1238.C1239.RoundedImageView_border_color);
        if (this.f15556 == null) {
            this.f15556 = ColorStateList.valueOf(-16777216);
        }
        this.f15560 = obtainStyledAttributes.getBoolean(C1238.C1239.RoundedImageView_round_background, false);
        this.f15555 = obtainStyledAttributes.getBoolean(C1238.C1239.RoundedImageView_is_oval, false);
        m16446();
        m16448();
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f15554;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        boolean z = this.f15554 != scaleType;
        this.f15554 = scaleType;
        if (m16450()) {
            super.setScaleType(scaleType);
            return;
        }
        if (z) {
            switch (AnonymousClass3.f15561[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
        }
        m16446();
        m16448();
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ﺘ$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: ॱ  reason: contains not printable characters */
        static final /* synthetic */ int[] f15561 = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f15561[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15561[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15561[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15561[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15561[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15561[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15561[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f15558 == 0 && this.f15557 == 0) {
            super.setImageDrawable(drawable);
            return;
        }
        this.f15553 = 0;
        this.f15559 = C1175.m16384(drawable);
        m16446();
        super.setImageDrawable(this.f15559);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.f15558 == 0 && this.f15557 == 0) {
            super.setImageBitmap(bitmap);
            return;
        }
        this.f15553 = 0;
        this.f15559 = C1175.m16385(bitmap);
        m16446();
        super.setImageDrawable(this.f15559);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.f15558 == 0 && this.f15557 == 0) {
            super.setImageResource(i);
        } else if (this.f15553 != i) {
            this.f15553 = i;
            this.f15559 = m16449();
            m16446();
            super.setImageDrawable(this.f15559);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m16450() {
        return this.f15552;
    }

    public void setPassActualScaleTypeToParent(boolean z) {
        this.f15552 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Drawable m16449() {
        Resources resources = getResources();
        if (resources == null) {
            return null;
        }
        Drawable drawable = null;
        if (this.f15553 != 0) {
            try {
                drawable = resources.getDrawable(this.f15553);
            } catch (Exception e) {
                C1283.m16855("RoundedImageView", "Unable to find resource: " + this.f15553, e);
                this.f15553 = 0;
            }
        }
        return C1175.m16384(drawable);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16446() {
        m16447(this.f15559, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16448() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16447(Drawable drawable, boolean z) {
        if (drawable != null) {
            if (drawable instanceof C1175) {
                ((C1175) drawable).m16388(this.f15554).m16390((!z || this.f15560) ? (float) this.f15558 : 0.0f).m16389((!z || this.f15560) ? this.f15557 : 0).m16387(this.f15556).m16391(this.f15555);
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    m16447(layerDrawable.getDrawable(i), z);
                }
            }
        }
    }

    public void setCornerRadius(int i) {
        if (this.f15558 != i) {
            this.f15558 = i;
            m16446();
            m16448();
        }
    }

    public void setBorderWidth(int i) {
        if (this.f15557 != i) {
            this.f15557 = i;
            m16446();
            m16448();
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        setBorderColors(ColorStateList.valueOf(i));
    }

    public void setBorderColors(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (!this.f15556.equals(colorStateList)) {
            if (colorStateList != null) {
                colorStateList2 = colorStateList;
            } else {
                colorStateList2 = ColorStateList.valueOf(-16777216);
            }
            this.f15556 = colorStateList2;
            m16446();
            m16448();
            if (this.f15557 > 0) {
                invalidate();
            }
        }
    }

    public void setOval(boolean z) {
        this.f15555 = z;
        m16446();
        m16448();
        invalidate();
    }

    public void setRoundBackground(boolean z) {
        if (this.f15560 != z) {
            this.f15560 = z;
            m16448();
            invalidate();
        }
    }
}
