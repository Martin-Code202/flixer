package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import o.AT;
/* renamed from: o.ᓖ  reason: contains not printable characters */
public class C0824 extends SeekBar {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f14617;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Rect f14618;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f14619;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Bitmap f14620;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Drawable f14621;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f14622 = -1;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0826 f14623;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f14624;

    /* renamed from: o.ᓖ$ˊ  reason: contains not printable characters */
    public interface AbstractC0825 {
        /* renamed from: ˋ */
        void mo11523(SeekBar seekBar);

        /* renamed from: ˋ */
        void mo11524(SeekBar seekBar, boolean z);

        /* renamed from: ॱ */
        void mo11532(SeekBar seekBar, int i, boolean z);
    }

    public C0824(Context context) {
        super(context);
        m15434();
    }

    public C0824(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15434();
    }

    public C0824(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15434();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15434() {
        setSplitTrack(false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Drawable m15442() {
        return this.f14621;
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        this.f14621 = drawable;
        super.setThumb(drawable);
    }

    public void setScrubberDentBitmap(int i) {
        this.f14620 = BitmapFactory.decodeResource(getResources(), i);
        C1283.m16846("SnappableSeekBar", "Dent: " + this.f14620.getWidth() + "x" + this.f14620.getHeight());
    }

    public void setDisableTrackTouching(boolean z) {
        this.f14624 = z;
    }

    public void setShouldSnapToTouchStartPosition(boolean z) {
        this.f14617 = z;
    }

    public void setSnappableOnSeekBarChangeListener(AbstractC0825 r2) {
        this.f14623 = new C0826(r2);
        super.setOnSeekBarChangeListener(this.f14623);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable r3;
        boolean z = false;
        if (this.f14624 && (r3 = m15442()) != null) {
            Rect rect = new Rect(r3.getBounds());
            rect.left -= getThumbOffset();
            rect.right -= getThumbOffset();
            z = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f14624 && !z && motionEvent.getAction() == 0) {
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int r4 = m15433(motionEvent);
        if ((motionEvent.getAction() == 2 || motionEvent.getAction() == 1) && this.f14623 != null && this.f14623.m15445(r4)) {
            setProgress(this.f14622);
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14619 && this.f14620 != null) {
            m15441(canvas);
            m15435(canvas);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15441(Canvas canvas) {
        if (this.f14620 != null) {
            if (this.f14618 == null) {
                int r5 = ((((int) (m15436(this.f14622) + 0.5f)) + getPaddingLeft()) + (getThumbOffset() / 2)) - (this.f14620.getWidth() / 2);
                int width = r5 + this.f14620.getWidth();
                int centerY = getProgressDrawable().getBounds().centerY();
                this.f14618 = new Rect(r5, centerY - (this.f14620.getHeight() / 2), width, centerY + (this.f14620.getHeight() / 2));
            }
            canvas.save();
            canvas.translate((float) (getPaddingLeft() - getThumbOffset()), (float) getPaddingTop());
            canvas.drawBitmap(this.f14620, (Rect) null, this.f14618, (Paint) null);
            canvas.restore();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15435(Canvas canvas) {
        if (this.f14621 != null) {
            canvas.save();
            canvas.translate((float) (getPaddingLeft() - getThumbOffset()), (float) getPaddingTop());
            this.f14621.draw(canvas);
            canvas.restore();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15440() {
        this.f14619 = true;
        this.f14622 = getProgress();
        invalidate();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15438() {
        this.f14619 = false;
        this.f14618 = null;
        this.f14622 = -1;
        invalidate();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int m15433(MotionEvent motionEvent) {
        float f;
        int width = getWidth();
        int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
        int x = (int) motionEvent.getX();
        if (x < getPaddingLeft()) {
            f = 0.0f;
        } else if (x > width - getPaddingRight()) {
            f = 1.0f;
        } else {
            f = ((float) (x - getPaddingLeft())) / ((float) paddingLeft);
        }
        return (int) (0.0f + (((float) getMax()) * f));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private float m15436(int i) {
        return (float) ((((getWidth() - getPaddingLeft()) - getPaddingRight()) * i) / getMax());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᓖ$ˋ  reason: contains not printable characters */
    public class C0826 implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final AbstractC0825 f14625;

        /* renamed from: ˏ  reason: contains not printable characters */
        private AT.iF f14627;

        public C0826(AbstractC0825 r2) {
            this.f14625 = r2;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            C1283.m16846("SnappableSeekBar", "onStartTrackingTouch");
            this.f14625.mo11523(seekBar);
            this.f14627 = C0824.this.f14617 ? m15444() : null;
            C0824.this.m15440();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private AT.iF m15444() {
            int r2 = (int) (((float) (C1004.m15954(C0824.this.getContext(), 24) * C0824.this.getMax())) / ((float) C0824.this.getWidth()));
            int progress = C0824.this.getProgress();
            return new AT.iF(progress - r2, progress + r2);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            C1283.m16846("SnappableSeekBar", "onStopTrackingTouch");
            this.f14625.mo11524(seekBar, this.f14627 != null && this.f14627.m3415(C0824.this.getProgress()));
            this.f14627 = null;
            C0824.this.m15438();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            C1283.m16846("SnappableSeekBar", "onProgressChanged, progress: " + i + ", fromUser: " + z);
            if (z && m15445(i)) {
                i = AT.m3413(this.f14627.m3416(), 0, seekBar.getMax());
                seekBar.setProgress(i);
            }
            this.f14625.mo11532(seekBar, i, z);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean m15445(int i) {
            return this.f14627 != null && this.f14627.m3415(i);
        }
    }
}
