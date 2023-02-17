package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.netflix.mediaclient.R;
/* renamed from: o.ᓛ  reason: contains not printable characters */
public class C0832 extends C0544 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f14638;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f14639;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f14640;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Paint f14641 = new Paint();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Canvas f14642 = new Canvas();

    /* renamed from: ॱ  reason: contains not printable characters */
    private Bitmap f14643;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f14644 = -1;

    public C0832(Context context) {
        super(context);
        m15447(context, null, 0);
    }

    public C0832(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15447(context, attributeSet, 0);
    }

    public C0832(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15447(context, attributeSet, i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15447(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.C0006.StrokeTextView, i, 0);
        if (obtainStyledAttributes != null) {
            for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (index) {
                    case 0:
                        this.f14644 = obtainStyledAttributes.getColor(index, 0);
                        break;
                    case 1:
                        this.f14638 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            this.f14639 = true;
            this.f14641.setAntiAlias(true);
            this.f14641.setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        this.f14640 = i;
    }

    public void setStrokeColor(int i) {
        this.f14644 = i;
    }

    public void setStrokeWidth(int i) {
        this.f14638 = i;
    }

    /* access modifiers changed from: protected */
    @Override // o.C0544, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.f14639 = true;
    }

    /* access modifiers changed from: protected */
    @Override // o.C0544, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            this.f14643 = null;
            return;
        }
        this.f14639 = true;
        this.f14643 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f14643 != null) {
            if (this.f14639) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                String charSequence = getText().toString();
                Rect rect = new Rect();
                TextPaint paint = getPaint();
                int measureText = (int) paint.measureText(charSequence);
                paint.getTextBounds("x", 0, 1, rect);
                this.f14642.setBitmap(this.f14643);
                this.f14642.drawColor(0, PorterDuff.Mode.CLEAR);
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                Drawable[] compoundDrawables = getCompoundDrawables();
                for (int i = 0; i < compoundDrawables.length; i++) {
                    if (compoundDrawables[i] != null) {
                        compoundDrawables[i].setBounds(paddingLeft, paddingTop, compoundDrawables[i].getIntrinsicWidth() + paddingLeft, compoundDrawables[i].getIntrinsicHeight() + paddingTop);
                        compoundDrawables[i].draw(this.f14642);
                    }
                }
                int paddingRight = (measuredWidth - getPaddingRight()) - measureText;
                int height = (rect.height() + measuredHeight) / 2;
                this.f14641.setStrokeWidth((float) this.f14638);
                this.f14641.setColor(this.f14644);
                this.f14641.setTextSize(getTextSize());
                this.f14642.drawText(charSequence, (float) paddingRight, (float) height, this.f14641);
                this.f14641.setStrokeWidth(0.0f);
                this.f14641.setColor(this.f14640);
                this.f14642.drawText(charSequence, (float) paddingRight, (float) height, this.f14641);
                this.f14639 = false;
            }
            canvas.drawBitmap(this.f14643, 0.0f, 0.0f, this.f14641);
            return;
        }
        super.onDraw(canvas);
    }
}
