package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
/* renamed from: o.ᴫ  reason: contains not printable characters */
public class C0964 extends Drawable {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f14874;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f14875 = 3;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f14876;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f14877;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f14878 = true;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final TextPaint f14879 = new TextPaint(1);

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f14880;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Drawable f14881;

    /* renamed from: ˏ  reason: contains not printable characters */
    private StaticLayout f14882;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f14883 = false;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Layout.Alignment f14884 = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: ॱ  reason: contains not printable characters */
    private CharSequence f14885;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f14886 = false;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f14887;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f14888;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        if (this.f14878) {
            m15776();
            this.f14878 = false;
        }
        if (this.f14881 != null) {
            this.f14881.draw(canvas);
        }
        if (this.f14882 != null) {
            int height = this.f14882.getHeight();
            float width = (float) ((canvas.getWidth() - this.f14880) / 2);
            if (this.f14883) {
                f = (float) ((canvas.getHeight() / 2) - height);
            } else {
                f = (float) (((canvas.getHeight() - height) - this.f14877) - this.f14888);
            }
            canvas.save();
            canvas.translate(width, f);
            this.f14882.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15776() {
        if (getBounds().width() <= 0 || TextUtils.isEmpty(this.f14885)) {
            this.f14880 = 0;
            this.f14882 = null;
            return;
        }
        this.f14880 = (getBounds().width() - this.f14887) - this.f14874;
        this.f14884 = this.f14886 ? Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_NORMAL;
        this.f14882 = qP.m9945(this.f14885, 0, this.f14885.length(), this.f14879, this.f14880, this.f14884, 1.0f, 0.0f, false, TextUtils.TruncateAt.END, this.f14880, this.f14875);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f14879.getAlpha() != i) {
            this.f14878 = true;
        }
        this.f14879.setAlpha(i);
        if (this.f14881 != null) {
            this.f14881.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (!this.f14879.getColorFilter().equals(colorFilter)) {
            this.f14878 = true;
        }
        this.f14879.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        if (getBounds() == null || !getBounds().equals(rect)) {
            this.f14878 = true;
        }
        super.setBounds(rect);
        if (this.f14881 != null) {
            this.f14881.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        if (!(getBounds() != null && getBounds().left == i && getBounds().top == i2 && getBounds().bottom == i4)) {
            this.f14878 = true;
        }
        super.setBounds(i, i2, i3, i4);
        if (this.f14881 != null) {
            this.f14881.setBounds(i, i2, i3, i4);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15780(int i) {
        if (this.f14879.getColor() != i) {
            this.f14878 = true;
        }
        this.f14879.setColor(i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15778(int i) {
        if (this.f14879.getTextSize() != ((float) i)) {
            this.f14878 = true;
        }
        this.f14879.setTextSize((float) i);
        this.f14876 = i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15781(int i, int i2, int i3, int i4) {
        if (!(this.f14877 == i && this.f14874 == i2 && this.f14888 == i3 && this.f14887 == i4)) {
            this.f14878 = true;
        }
        this.f14877 = i;
        this.f14874 = i2;
        this.f14888 = i3;
        this.f14887 = i4;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15777(int i) {
        if (this.f14875 != i) {
            this.f14878 = true;
        }
        this.f14875 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15779(CharSequence charSequence) {
        if (this.f14885 != null && !this.f14885.equals(charSequence)) {
            this.f14878 = true;
        }
        this.f14885 = charSequence;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15782(Context context, int i) {
        this.f14881 = ContextCompat.getDrawable(context, i);
    }
}
