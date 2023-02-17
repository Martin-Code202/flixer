package o;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.netflix.mediaclient.ui.player.ScaleType;
/* renamed from: o.xf  reason: case insensitive filesystem */
public class TextureView$SurfaceTextureListenerC2310xf implements AbstractC2308xd, TextureView.SurfaceTextureListener {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f12158 = TextureView$SurfaceTextureListenerC2310xf.class.getName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f12159 = 1080;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f12160 = 0;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f12161 = 1920;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private float f12162 = 1.7777778f;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC2309xe f12163;

    /* renamed from: ˎ  reason: contains not printable characters */
    private SurfaceTexture f12164;

    /* renamed from: ˏ  reason: contains not printable characters */
    private TextureView f12165;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Surface f12166;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private ScaleType f12167 = ScaleType.CROP;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f12168 = 0;

    /* renamed from: o.xf$ˋ  reason: contains not printable characters */
    class C0294 extends TextureView {
        public C0294(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            C1283.m16854("MeasurableTextureView", "Measureable TextureView measure called. ");
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i3 = TextureView$SurfaceTextureListenerC2310xf.this.f12161;
            int i4 = TextureView$SurfaceTextureListenerC2310xf.this.f12159;
            double d = ((double) TextureView$SurfaceTextureListenerC2310xf.this.f12168) / ((double) TextureView$SurfaceTextureListenerC2310xf.this.f12161);
            double d2 = ((double) TextureView$SurfaceTextureListenerC2310xf.this.f12160) / ((double) TextureView$SurfaceTextureListenerC2310xf.this.f12159);
            if (TextureView$SurfaceTextureListenerC2310xf.this.m12918()) {
                i3 = TextureView$SurfaceTextureListenerC2310xf.this.f12168;
                i4 = TextureView$SurfaceTextureListenerC2310xf.this.f12160;
            }
            switch (TextureView$SurfaceTextureListenerC2310xf.this.f12167) {
                case CROP:
                    if (TextureView$SurfaceTextureListenerC2310xf.this.f12161 > 0 && TextureView$SurfaceTextureListenerC2310xf.this.f12159 > 0) {
                        if (i3 * size2 > size * i4) {
                            size2 = (size * i4) / i3;
                        } else if (i3 * size2 < size * i4) {
                            size = (size2 * i3) / i4;
                        }
                        if (TextureView$SurfaceTextureListenerC2310xf.this.m12918()) {
                            C1283.m16862("MeasurableTextureView", "Video image has crop, scalex=" + d + "scaley=" + d2);
                            size = (int) (((double) size) / d);
                            size2 = (int) (((double) size2) / d2);
                            break;
                        }
                    }
                    break;
                case ZOOM:
                    C1283.m16862("MeasurableTextureView", "Zoomin but preserve aspect ratio ...");
                    if (TextureView$SurfaceTextureListenerC2310xf.this.f12161 > 0 && TextureView$SurfaceTextureListenerC2310xf.this.f12159 > 0) {
                        if (i3 * size2 > size * i4) {
                            size = (size2 * i3) / i4;
                        } else if (i3 * size2 < size * i4) {
                            size2 = (size * i4) / i3;
                        }
                        if (TextureView$SurfaceTextureListenerC2310xf.this.m12918()) {
                            C1283.m16862("MeasurableTextureView", "Video image has crop, scalex=" + d + "scaley=" + d2);
                            size = (int) (((double) size) / d);
                            size2 = (int) (((double) size2) / d2);
                            break;
                        }
                    }
                    break;
                default:
                    C1283.m16850("MeasurableTextureView", "unsupported scale type");
                    break;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
        }
    }

    public TextureView$SurfaceTextureListenerC2310xf(Context context, AbstractC2309xe xeVar) {
        this.f12165 = new C0294(context);
        this.f12165.setSurfaceTextureListener(this);
        this.f12163 = xeVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        C1283.m16854(f12158, "onSurfaceTextureAvailable");
        if (surfaceTexture != null) {
            if (this.f12164 != null) {
                m12921();
            }
            this.f12164 = surfaceTexture;
            this.f12166 = new Surface(this.f12164);
            this.f12163.mo2359(this);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        C1283.m16854(f12158, "onSurfaceTextureSizeChanged");
        this.f12163.mo2361(this, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        C1283.m16854(f12158, "onSurfaceTextureDestroyed");
        m12921();
        this.f12163.mo2360(this);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f12163.mo2362(this);
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ˏ */
    public Surface mo12914() {
        return this.f12166;
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ॱ */
    public View mo12916() {
        return this.f12165;
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ˏ */
    public void mo12915(boolean z) {
        Activity activity;
        if (z && this.f12165 != null && (activity = (Activity) this.f12165.getContext()) != null) {
            activity.getWindow().setFlags(8192, 8192);
        }
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ˊ */
    public void mo12912(ScaleType scaleType) {
        this.f12167 = scaleType;
        switch (scaleType) {
            case CROP:
            case ZOOM:
                this.f12162 = ((float) this.f12161) / ((float) this.f12159);
                if (m12918()) {
                    this.f12162 = ((float) this.f12168) / ((float) this.f12160);
                    return;
                }
                return;
            case MATRIX:
                m12925(scaleType.m2596());
                return;
            case FIT:
                if (m12918()) {
                    Matrix matrix = new Matrix();
                    matrix.setScale(((float) this.f12161) / ((float) this.f12168), ((float) this.f12159) / ((float) this.f12160));
                    m12925(matrix);
                    return;
                }
                return;
            default:
                C1283.m16854(f12158, "unsupported scale type");
                return;
        }
    }

    @Override // o.AbstractC2308xd
    /* renamed from: ˋ */
    public void mo12913(Point point, Point point2) {
        if (point != null) {
            this.f12161 = point.x;
            this.f12159 = point.y;
        }
        if (point2 != null) {
            this.f12168 = point2.x;
            this.f12160 = point2.y;
        }
        if (point != null || point2 != null) {
            this.f12165.requestLayout();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12925(Matrix matrix) {
        this.f12165.setTransform(matrix);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m12918() {
        return this.f12160 > 0 && this.f12168 > 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12921() {
        if (this.f12164 != null) {
            this.f12164.release();
            this.f12164 = null;
            if (this.f12166 != null) {
                this.f12166.release();
                this.f12166 = null;
            }
        }
    }
}
