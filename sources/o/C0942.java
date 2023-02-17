package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC0931;
/* renamed from: o.ᚆ  reason: contains not printable characters */
public class C0942 extends SurfaceView implements AbstractC0931 {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected int f14826 = 0;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected float f14827 = 1.0f;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected double f14828 = 1.0d;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected int f14829 = 0;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final List<AbstractC0931.AbstractC0932> f14830 = new ArrayList();

    /* renamed from: ˋ  reason: contains not printable characters */
    protected int f14831 = 0;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected If f14832;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected int f14833;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected int f14834 = 0;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected int f14835 = 0;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected int f14836 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected int f14837;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected int f14838 = 0;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected double f14839 = 1.0d;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final C0653 f14840;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected boolean f14841 = false;

    /* renamed from: o.ᚆ$If */
    public interface If {
        /* renamed from: ˏ */
        void mo12578(int i, int i2);
    }

    public C0942(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14840 = C0653.m14813(context, this);
        m15755(context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15755(Context context) {
        C1283.m16854("@@@", "INIT_SURFACE");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1283.m16854("TAP", "onTouchEvent " + motionEvent);
        if (motionEvent.getAction() != 1) {
            return true;
        }
        mo15743(motionEvent);
        return true;
    }

    @Override // o.AbstractC0931
    /* renamed from: ॱ */
    public void mo15743(MotionEvent motionEvent) {
        for (AbstractC0931.AbstractC0932 r0 : this.f14830) {
            r0.mo2538(motionEvent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15759(AbstractC0931.AbstractC0932 r2) {
        if (r2 != null) {
            this.f14830.add(r2);
        }
        if (this.f14830.size() > 0) {
            this.f14840.mo14785();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m15757(AbstractC0931.AbstractC0932 r3) {
        if (r3 == null) {
            return false;
        }
        boolean remove = this.f14830.remove(r3);
        if (this.f14830.size() <= 0) {
            this.f14840.mo14786();
        }
        return remove;
    }

    @Override // o.AbstractC0931
    /* renamed from: ˏ */
    public View mo15742() {
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        C1283.m16862("@@@", "onMeasure");
        ViewGroup viewGroup = (ViewGroup) getParent();
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size == 0 || size2 == 0) {
            size = getDefaultSize(this.f14837, i);
            size2 = getDefaultSize(this.f14833, i2);
            C1283.m16854("@@@", "use default size");
        }
        if (size == 0 || size2 == 0) {
            size = 1920;
            size2 = 1080;
            C1283.m16854("@@@", "use hardcode size");
        }
        this.f14829 = size2;
        this.f14834 = size;
        if (this.f14829 < this.f14834 || this.f14836 <= 0 || this.f14838 <= 0) {
            if (this.f14837 > 0 && this.f14833 > 0) {
                if (this.f14841) {
                    this.f14837 = this.f14831;
                    this.f14833 = this.f14826;
                }
                if (this.f14837 * size2 > this.f14833 * size) {
                    C1283.m16854("@@@", "image too tall, correcting");
                    size2 = (this.f14833 * size) / this.f14837;
                } else if (this.f14837 * size2 < this.f14833 * size) {
                    C1283.m16854("@@@", "image too wide, correcting");
                    size = (this.f14837 * size2) / this.f14833;
                }
            }
            C1283.m16854("@@@", "aspect ratio corrected: " + size + "x" + size2);
            switch (this.f14835) {
                case 0:
                    C1283.m16862("@@@", "Follow Aspect ration");
                    if (this.f14841) {
                        C1283.m16862("@@@", "Video image has crop");
                        size = (int) (this.f14828 * ((double) size));
                        size2 = (int) (this.f14839 * ((double) size2));
                        break;
                    }
                    break;
                case 1:
                    C1283.m16862("@@@", "Zoomin ...");
                    if (!(size == 0 || size2 == 0)) {
                        float f = ((float) this.f14834) / ((float) size);
                        float f2 = ((float) this.f14829) / ((float) size2);
                        if (f >= f2) {
                            size = this.f14834;
                            size2 = (int) (((float) size2) * f);
                        } else {
                            size2 = this.f14829;
                            size = (int) (((float) size) * f2);
                        }
                        if (this.f14841) {
                            C1283.m16862("@@@", "Video image has crop, scalex= mCropScaleX scaley=" + this.f14839);
                            size = (int) (this.f14828 * ((double) size));
                            size2 = (int) (this.f14839 * ((double) size2));
                            break;
                        }
                    }
                    break;
                case 2:
                default:
                    C1283.m16862("@@@", "Stretch to full screen ...");
                    size = this.f14834;
                    size2 = this.f14829;
                    break;
                case 3:
                    C1283.m16862("@@@", "Scale surface");
                    if (!(size == 0 || size2 == 0 || this.f14827 <= 0.0f)) {
                        size = (int) (((float) size) * this.f14827);
                        size2 = (int) (((float) size2) * this.f14827);
                        break;
                    }
            }
            setMeasuredDimension(size, size2);
            this.f14836 = size;
            this.f14838 = size2;
            if (null != this.f14832) {
                this.f14832.mo12578(size, size2);
                return;
            }
            return;
        }
        setMeasuredDimension(this.f14836, this.f14838);
    }

    public void setVideoWidth(int i) {
        this.f14837 = i;
        this.f14836 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m15758() {
        return this.f14833;
    }

    public void setVideoHeight(int i) {
        this.f14833 = i;
        this.f14838 = i;
    }

    public void setCroppedVideoWidth(int i) {
        this.f14831 = i;
        this.f14828 = ((double) this.f14837) / ((double) i);
        if (this.f14831 != 0 && this.f14826 != 0) {
            this.f14841 = true;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m15760() {
        return this.f14826;
    }

    public void setCroppedVideoHeight(int i) {
        this.f14826 = i;
        this.f14839 = ((double) this.f14833) / ((double) i);
        if (this.f14831 != 0 && this.f14826 != 0) {
            this.f14841 = true;
        }
    }

    @Override // o.AbstractC0931
    /* renamed from: ˋ */
    public int mo15741() {
        return this.f14835;
    }

    @Override // o.AbstractC0931
    public void setMode(int i) {
        if (i < 0 || i > 2) {
            C1283.m16865("@@@", "Invalid mode");
            return;
        }
        this.f14827 = 1.0f;
        this.f14835 = i;
        requestLayout();
    }

    @Override // o.AbstractC0931
    public void setScale(float f) {
        if (f > 0.0f) {
            this.f14835 = 3;
            this.f14827 = f;
            requestLayout();
            return;
        }
        C1283.m16865("@@@", "Invalid mode");
    }

    public void setSurfaceMeasureListener(If r1) {
        this.f14832 = r1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m15756() {
        if (this.f14837 == 0 || this.f14833 == 0 || this.f14834 == 0 || this.f14829 == 0 || this.f14837 * this.f14829 != this.f14833 * this.f14834) {
            return true;
        }
        return false;
    }
}
