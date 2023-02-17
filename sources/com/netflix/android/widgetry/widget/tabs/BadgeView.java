package com.netflix.android.widgetry.widget.tabs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import o.C1004;
public class BadgeView extends AppCompatTextView {

    /* renamed from: ʻ  reason: contains not printable characters */
    private RectF f170 = new RectF();

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f171;

    /* renamed from: ʽ  reason: contains not printable characters */
    private RectF f172 = new RectF();

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f173;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f174;

    /* renamed from: ˋ  reason: contains not printable characters */
    private DisplayType f175 = DisplayType.DOT;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f176;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Paint f177 = new Paint();

    /* renamed from: ˏ  reason: contains not printable characters */
    private Paint f178 = new Paint();

    /* renamed from: ॱ  reason: contains not printable characters */
    private RectF f179 = new RectF();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Drawable f180;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private RectF f181 = new RectF();

    public enum DisplayType {
        DOT,
        TEXT,
        PROGRESS,
        DRAWABLE
    }

    public BadgeView(Context context) {
        super(context);
        m116();
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m116();
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m116();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m116() {
        this.f177.setColor(-16776961);
        this.f177.setStyle(Paint.Style.FILL);
        this.f177.setAntiAlias(true);
        this.f178.setColor(-16777216);
        this.f178.setAntiAlias(true);
        this.f178.setStyle(Paint.Style.STROKE);
        int r2 = C1004.m15954(getContext(), 1);
        this.f178.setStrokeWidth((float) r2);
        this.f173 = r2 / 2;
        this.f174 = C1004.m15954(getContext(), 2);
        this.f176 = this.f174 / 2;
        setGravity(17);
        setMinLines(1);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth < measuredHeight) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f175 != DisplayType.DRAWABLE) {
            if (this.f179.width() > this.f179.height()) {
                int min = this.f175 == DisplayType.TEXT ? 180 : Math.min(this.f171, 180);
                canvas.drawArc(this.f181, 90.0f, (float) (this.f175 == DisplayType.TEXT ? 180 : Math.max(this.f171 - 180, 0)), true, this.f177);
                canvas.drawArc(this.f181, 90.0f, 180.0f, false, this.f178);
                canvas.drawRect(this.f170, this.f177);
                canvas.drawLine(this.f170.left, this.f170.top, this.f170.right, this.f170.top, this.f178);
                canvas.drawLine(this.f170.left, this.f170.bottom, this.f170.right, this.f170.bottom, this.f178);
                canvas.drawArc(this.f172, 270.0f, (float) min, true, this.f177);
                canvas.drawArc(this.f172, 270.0f, 180.0f, false, this.f178);
                if (this.f175 == DisplayType.PROGRESS) {
                    this.f177.setStyle(Paint.Style.STROKE);
                    this.f177.setStrokeWidth((float) this.f174);
                    canvas.drawArc(this.f181.left + ((float) this.f176), this.f181.top + ((float) this.f176), this.f181.right - ((float) this.f176), this.f181.bottom - ((float) this.f176), 90.0f, 180.0f, false, this.f177);
                    canvas.drawLine(this.f170.left, this.f170.top + ((float) this.f176), this.f170.right, this.f170.top + ((float) this.f176), this.f177);
                    canvas.drawLine(this.f170.left, this.f170.bottom + ((float) this.f176), this.f170.right, this.f170.bottom + ((float) this.f176), this.f177);
                    canvas.drawArc(this.f172.left + ((float) this.f176), this.f172.top + ((float) this.f176), this.f172.right - ((float) this.f176), this.f172.bottom - ((float) this.f176), 270.0f, 180.0f, false, this.f177);
                    this.f177.setStyle(Paint.Style.FILL);
                }
            } else {
                canvas.drawArc(this.f179, 270.0f, (float) (this.f175 == DisplayType.TEXT ? 360 : this.f171), true, this.f177);
                canvas.drawArc(this.f179, 270.0f, 360.0f, false, this.f178);
                if (this.f175 == DisplayType.PROGRESS) {
                    this.f177.setStyle(Paint.Style.STROKE);
                    this.f177.setStrokeWidth((float) this.f174);
                    canvas.drawArc(this.f179.left + ((float) this.f176), this.f179.top + ((float) this.f176), this.f179.right - ((float) this.f176), this.f179.bottom - ((float) this.f176), 270.0f, 360.0f, false, this.f177);
                    this.f177.setStyle(Paint.Style.FILL);
                }
            }
            super.onDraw(canvas);
        } else if (this.f180 != null) {
            this.f180.draw(canvas);
        }
    }

    public void setDisplayType(DisplayType displayType) {
        this.f175 = displayType;
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f171 = (i * 360) / 100;
    }

    public void setDrawable(Drawable drawable) {
        this.f180 = drawable;
        if (this.f180 != null) {
            this.f180.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f177.setColor(i);
    }

    public void setBackgroundShadowColor(int i) {
        this.f178.setColor(i);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f179.set((float) this.f173, (float) this.f173, (float) (i - this.f173), (float) (i2 - this.f173));
        this.f181.set((float) this.f173, (float) this.f173, (float) (i2 - this.f173), (float) (i2 - this.f173));
        this.f170.set((float) (i2 / 2), (float) this.f173, (float) (i - (i2 / 2)), (float) (i2 - this.f173));
        this.f172.set((float) ((i - i2) + this.f173), (float) this.f173, (float) (i - this.f173), (float) (i2 - this.f173));
        if (this.f180 != null) {
            this.f180.setBounds(0, 0, i, i2);
        }
    }
}
