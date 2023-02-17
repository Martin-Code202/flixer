package o;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
/* renamed from: o.ւ  reason: contains not printable characters */
public class C0544 extends C1057 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f13749;

    /* renamed from: ˊ  reason: contains not printable characters */
    private float f13750;

    /* renamed from: ˋ  reason: contains not printable characters */
    private float f13751;

    /* renamed from: ˎ  reason: contains not printable characters */
    private float f13752;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13753;

    /* renamed from: ॱ  reason: contains not printable characters */
    private float f13754;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private float f13755;

    public C0544(Context context) {
        super(context);
        this.f13753 = false;
        this.f13754 = 0.0f;
        this.f13752 = 4.0f;
        this.f13751 = 1.0f;
        this.f13755 = 0.0f;
        this.f13749 = false;
    }

    public C0544(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13753 = false;
        this.f13754 = 0.0f;
        this.f13752 = 4.0f;
        this.f13751 = 1.0f;
        this.f13755 = 0.0f;
        this.f13749 = false;
    }

    public C0544(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13753 = false;
        this.f13754 = 0.0f;
        this.f13752 = 4.0f;
        this.f13751 = 1.0f;
        this.f13755 = 0.0f;
        this.f13749 = false;
        this.f13750 = getTextSize();
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f13753 = true;
        m14586();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3 || i2 != i4) {
            this.f13753 = true;
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.f13750 = getTextSize();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.f13750 = getTextSize();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f13751 = f2;
        this.f13755 = f;
    }

    public void setMaxTextSize(float f) {
        this.f13754 = f;
        requestLayout();
        invalidate();
    }

    public void setMinTextSize(float f) {
        this.f13752 = f;
        requestLayout();
        invalidate();
    }

    public void setAddEllipsis(boolean z) {
        this.f13749 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14586() {
        if (this.f13750 > 0.0f) {
            super.setTextSize(0, this.f13750);
            this.f13754 = this.f13750;
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.f13753) {
            m14585(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14585(int i, int i2) {
        CharSequence text = getText();
        if (text != null && text.length() != 0 && i2 > 0 && i > 0 && this.f13750 != 0.0f) {
            TextPaint paint = getPaint();
            float min = this.f13754 > 0.0f ? Math.min(this.f13750, this.f13754) : this.f13750;
            int r11 = m14584(text, paint, i, min);
            while (r11 > i2 && min > this.f13752) {
                min = Math.max(min - 2.0f, this.f13752);
                r11 = m14584(text, paint, i, min);
            }
            if (this.f13749 && min == this.f13752 && r11 > i2) {
                StaticLayout staticLayout = new StaticLayout(text, paint, i, Layout.Alignment.ALIGN_NORMAL, this.f13751, this.f13755, false);
                if (staticLayout.getLineCount() > 0) {
                    int lineForVertical = staticLayout.getLineForVertical(i2) - 1;
                    if (lineForVertical < 0) {
                        setText("");
                    } else {
                        int lineStart = staticLayout.getLineStart(lineForVertical);
                        int lineEnd = staticLayout.getLineEnd(lineForVertical);
                        float lineWidth = staticLayout.getLineWidth(lineForVertical);
                        float measureText = paint.measureText("...");
                        while (((float) i) < lineWidth + measureText) {
                            lineEnd--;
                            lineWidth = paint.measureText(text.subSequence(lineStart, lineEnd + 1).toString());
                        }
                        setText(((Object) text.subSequence(0, lineEnd)) + "...");
                    }
                }
            }
            paint.setTextSize(min);
            setLineSpacing(this.f13755, this.f13751);
            this.f13753 = false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m14584(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        textPaint.setTextSize(f);
        return new StaticLayout(charSequence, textPaint, i, Layout.Alignment.ALIGN_NORMAL, this.f13751, this.f13755, true).getHeight();
    }
}
