package o;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.netflix.mediaclient.ui.player.ScaleType;
/* renamed from: o.xc  reason: case insensitive filesystem */
public class SurfaceHolder$CallbackC2307xc implements AbstractC2308xd, SurfaceHolder.Callback {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f12146 = SurfaceHolder$CallbackC2307xc.class.getName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f12147 = 1080;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f12148 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f12149 = 1920;

    /* renamed from: ˋ  reason: contains not printable characters */
    private ScaleType f12150 = ScaleType.CROP;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0293 f12151;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC2309xe f12152;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f12153 = 0;

    /* renamed from: o.xc$ˋ  reason: contains not printable characters */
    public class C0293 extends SurfaceView {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Rect f12155 = new Rect();

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int[] f12156 = new int[2];

        public C0293(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        @Override // android.view.SurfaceView, android.view.View
        public void onMeasure(int i, int i2) {
            C1283.m16854("MeasurableSurfaceView", "Measureable SurfaceView measure called. ");
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            getWindowVisibleDisplayFrame(this.f12155);
            getLocationOnScreen(this.f12156);
            C1283.m16854("MeasurableSurfaceView", "setting size: " + size + 'x' + size2 + ", start coordinates: " + this.f12156[0] + ", " + this.f12156[1]);
            int i3 = SurfaceHolder$CallbackC2307xc.this.f12149;
            int i4 = SurfaceHolder$CallbackC2307xc.this.f12147;
            double d = ((double) SurfaceHolder$CallbackC2307xc.this.f12148) / ((double) SurfaceHolder$CallbackC2307xc.this.f12149);
            double d2 = ((double) SurfaceHolder$CallbackC2307xc.this.f12153) / ((double) SurfaceHolder$CallbackC2307xc.this.f12147);
            if (SurfaceHolder$CallbackC2307xc.this.m12908()) {
                i3 = SurfaceHolder$CallbackC2307xc.this.f12148;
                i4 = SurfaceHolder$CallbackC2307xc.this.f12153;
            }
            switch (SurfaceHolder$CallbackC2307xc.this.f12150) {
                case MATRIX:
                    C1283.m16854("MeasurableSurfaceView", "unsupported scale type");
                    break;
                case FIT:
                    C1283.m16862("MeasurableSurfaceView", "Video content to fit the view");
                    if (SurfaceHolder$CallbackC2307xc.this.m12908()) {
                        C1283.m16862("MeasurableSurfaceView", "Video image has crop");
                        size = ((int) (((float) SurfaceHolder$CallbackC2307xc.this.f12149) / ((float) SurfaceHolder$CallbackC2307xc.this.f12148))) * SurfaceHolder$CallbackC2307xc.this.f12149;
                        size2 = ((int) (((float) SurfaceHolder$CallbackC2307xc.this.f12147) / ((float) SurfaceHolder$CallbackC2307xc.this.f12153))) * SurfaceHolder$CallbackC2307xc.this.f12147;
                        break;
                    }
                    break;
                case CROP:
                    C1283.m16862("MeasurableSurfaceView", "Video content preserve aspect ratio");
                    if (SurfaceHolder$CallbackC2307xc.this.f12149 > 0 && SurfaceHolder$CallbackC2307xc.this.f12147 > 0) {
                        if (i3 * size2 > size * i4) {
                            size2 = (size * i4) / i3;
                        } else if (i3 * size2 < size * i4) {
                            size = (size2 * i3) / i4;
                        }
                        if (SurfaceHolder$CallbackC2307xc.this.m12908()) {
                            C1283.m16862("MeasurableSurfaceView", "Video image has crop, scalex=" + d + "scaley=" + d2);
                            size = (int) (((double) size) / d);
                            size2 = (int) (((double) size2) / d2);
                            break;
                        }
                    }
                    break;
                case ZOOM:
                    C1283.m16862("MeasurableSurfaceView", "Zoomin but preserve aspect ratio ...");
                    if (SurfaceHolder$CallbackC2307xc.this.f12149 > 0 && SurfaceHolder$CallbackC2307xc.this.f12147 > 0) {
                        if (i3 * size2 > size * i4) {
                            size = (size2 * i3) / i4;
                        } else if (i3 * size2 < size * i4) {
                            size2 = (size * i4) / i3;
                        }
                        if (SurfaceHolder$CallbackC2307xc.this.m12908()) {
                            C1283.m16862("MeasurableSurfaceView", "Video image has crop, scalex=" + d + "scaley=" + d2);
                            size = (int) (((double) size) / d);
                            size2 = (int) (((double) size2) / d2);
                            break;
                        }
                    }
                    break;
                default:
                    C1283.m16850("MeasurableSurfaceView", "unsupporte scale type");
                    break;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
        }
    }

    public SurfaceHolder$CallbackC2307xc(Context context, AbstractC2309xe xeVar) {
        this.f12151 = new C0293(context);
        this.f12152 = xeVar;
        this.f12151.getHolder().addCallback(this);
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ˏ  reason: contains not printable characters */
    public Surface mo12914() {
        return this.f12151.getHolder().getSurface();
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ॱ  reason: contains not printable characters */
    public View mo12916() {
        return this.f12151;
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12915(boolean z) {
        ((C0293) mo12916()).setSecure(z);
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo12912(ScaleType scaleType) {
        this.f12150 = scaleType;
        mo12916().requestLayout();
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12913(Point point, Point point2) {
        if (point != null) {
            this.f12149 = point.x;
            this.f12147 = point.y;
        }
        if (point2 != null) {
            this.f12148 = point2.x;
            this.f12153 = point2.y;
        }
        if (point != null || point2 != null) {
            this.f12151.requestLayout();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        C1283.m16854(f12146, "Surface created. ");
        this.f12152.mo2359(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        C1283.m16854(f12146, "Surface changed");
        this.f12152.mo2361(this, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C1283.m16854(f12146, "Surface destroyed");
        this.f12152.mo2360(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m12908() {
        return this.f12153 > 0 && this.f12148 > 0;
    }
}
