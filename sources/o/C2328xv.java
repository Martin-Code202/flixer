package o;

import android.view.View;
/* access modifiers changed from: package-private */
/* renamed from: o.xv  reason: case insensitive filesystem */
public class C2328xv {

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f12275;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f12276;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f12277;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f12278;

    /* renamed from: ˏ  reason: contains not printable characters */
    private float f12279 = 1.0f;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f12280;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f12281;

    private C2328xv(int i, int i2, int i3, int i4) {
        m13013(i, i2);
        this.f12275 = i4;
        this.f12281 = i3;
        float f = ((float) i3) / ((float) i);
        float f2 = ((float) i4) / ((float) i2);
        if (!m13015()) {
            C1283.m16854("nf_subtitles_render", "Movie gots whole width");
            this.f12278 = 0;
            this.f12279 = f;
            this.f12276 = (i4 - ((int) (((float) i2) * this.f12279))) / 2;
            if (this.f12276 < 0) {
                C1283.m16850("nf_subtitles_render", "Offset can not be negative!");
                this.f12276 = 0;
                return;
            }
            return;
        }
        C1283.m16854("nf_subtitles_render", "Movie gots whole height");
        this.f12276 = 0;
        this.f12279 = f2;
        this.f12278 = (i3 - ((int) (((float) i) * this.f12279))) / 2;
        if (this.f12278 < 0) {
            C1283.m16850("nf_subtitles_render", "Offset can not be negative!");
            this.f12278 = 0;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13013(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            C1283.m16850("nf_subtitles_render", "Invalid root container height, default to w/h: 1280/720");
            this.f12280 = 720;
            this.f12277 = 1280;
            return;
        }
        this.f12280 = i2;
        this.f12277 = i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C2328xv m13014(int i, int i2, View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width > 0 && height > 0 && i2 > 0 && i > 0) {
            return new C2328xv(i, i2, width, height);
        }
        C1283.m16850("nf_subtitles_render", "DisplayView measures not know or master index not parsed yet!");
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m13015() {
        return this.f12281 * this.f12277 > this.f12275 * this.f12280;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public float m13016() {
        return this.f12279;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m13019() {
        return this.f12276;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m13017() {
        return this.f12278;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m13018() {
        return this.f12275;
    }

    public String toString() {
        return "MeasureTranslator [mScaleFactor=" + this.f12279 + ", mVerticalOffset=" + this.f12276 + ", mHorizontalOffset=" + this.f12278 + ", mRootContainerWidth=" + this.f12277 + ", mRootContainerHeight=" + this.f12280 + ", mDeviceWidth=" + this.f12281 + ", mDeviceHeight=" + this.f12275 + "]";
    }
}
