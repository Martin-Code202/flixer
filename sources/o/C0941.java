package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* renamed from: o.ᚁ  reason: contains not printable characters */
public final class C0941 extends C0942 {

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static final iF f14823 = new iF(null);

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private static final String f14824 = f14824;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final int[] f14825 = new int[2];

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0941(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(attributeSet, "attrs");
    }

    /* access modifiers changed from: protected */
    @Override // o.C0942, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        C1283.m16862(f14823.m15754(), "onMeasure");
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size == 0 || size2 == 0) {
            size = C0942.getDefaultSize(this.f14837, i);
            size2 = C0942.getDefaultSize(this.f14833, i2);
            C1283.m16854(f14823.m15754(), "use default size");
        }
        if (size == 0 || size2 == 0) {
            size = 1920;
            size2 = 1080;
            C1283.m16854(f14823.m15754(), "use hardcode size");
        }
        this.f14829 = size2;
        this.f14834 = size;
        if (this.f14837 > 0 && this.f14833 > 0) {
            int i3 = this.f14837;
            int i4 = this.f14833;
            if (this.f14841) {
                i3 = this.f14831;
                i4 = this.f14826;
            }
            if (i3 * size2 > size * i4) {
                C1283.m16854(f14823.m15754(), "image too tall, correcting");
                size2 = (size * i4) / i3;
            } else if (i3 * size2 < this.f14833 * size) {
                C1283.m16854(f14823.m15754(), "image too wide, correcting");
                size = (size2 * i3) / this.f14833;
            }
        }
        C1283.m16854(f14823.m15754(), "aspect ratio corrected: " + size + " x " + size2);
        switch (this.f14835) {
            case 0:
                C1283.m16862(f14823.m15754(), "Follow Aspect ration");
                if (this.f14841) {
                    C1283.m16862(f14823.m15754(), "Video image has crop");
                    size = (int) (this.f14828 * ((double) size));
                    size2 = (int) (this.f14839 * ((double) size2));
                    break;
                }
                break;
            case 1:
                C1283.m16862(f14823.m15754(), "Zoomin ...");
                if (!(size == 0 || size2 == 0)) {
                    float f = ((float) this.f14834) / ((float) size);
                    float f2 = ((float) this.f14829) / ((float) size2);
                    if (this.f14829 > this.f14834) {
                        if (f2 >= f) {
                            size = this.f14834;
                            size2 = (int) (((float) size2) * f);
                        } else {
                            size2 = this.f14829;
                            size = (int) (((float) size) * f2);
                        }
                    } else if (f >= f2) {
                        size = this.f14834;
                        size2 = (int) (((float) size2) * f);
                    } else {
                        size2 = this.f14829;
                        size = (int) (((float) size) * f2);
                    }
                    if (this.f14841) {
                        C1283.m16862(f14823.m15754(), "Video image has crop, scalex=" + this.f14828 + " scaley=" + this.f14839);
                        size = (int) (this.f14828 * ((double) size));
                        size2 = (int) (this.f14839 * ((double) size2));
                        break;
                    }
                }
                break;
            case 2:
            default:
                C1283.m16862(f14823.m15754(), "Stretch to full screen ...");
                size = this.f14834;
                size2 = this.f14829;
                break;
            case 3:
                C1283.m16862(f14823.m15754(), "Scale surface");
                if (size > 0 && size2 > 0 && this.f14827 > 0.0f) {
                    size = (int) (((float) size) * this.f14827);
                    size2 = (int) (((float) size2) * this.f14827);
                    break;
                }
        }
        setMeasuredDimension(size, size2);
        this.f14836 = size;
        this.f14838 = size2;
        if (this.f14832 != null) {
            this.f14832.mo12578(size, size2);
        }
    }

    /* renamed from: o.ᚁ$iF */
    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final String m15754() {
            return C0941.f14824;
        }
    }
}
