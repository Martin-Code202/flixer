package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import com.netflix.mediaclient.ui.player.ScaleType;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC0931;
/* renamed from: o.ᴒ  reason: contains not printable characters */
public class C0951 extends NetflixVideoView implements AbstractC0931 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f14851 = C0951.class.getName();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final List<AbstractC0931.AbstractC0932> f14852 = new ArrayList();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private float f14853 = 1.0f;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f14854 = 0;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f14855;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final C0653 f14856;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f14857;

    public C0951(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14856 = C0653.m14813(context, this);
        m15766(context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15766(Context context) {
        C1283.m16854(f14851, "INIT_SURFACE");
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
        for (AbstractC0931.AbstractC0932 r0 : this.f14852) {
            r0.mo2538(motionEvent);
        }
    }

    @Override // o.AbstractC0931
    /* renamed from: ˋ */
    public int mo15741() {
        return this.f14854;
    }

    @Override // o.AbstractC0931
    public void setMode(int i) {
        switch (i) {
            case 0:
                setScaleType(ScaleType.CROP);
                break;
            case 1:
                setScaleType(ScaleType.ZOOM);
                break;
            case 2:
                setScaleType(ScaleType.FIT);
                break;
            default:
                C1283.m16865(f14851, "Invalid mode");
                return;
        }
        this.f14853 = 1.0f;
        requestLayout();
    }

    @Override // com.netflix.mediaclient.ui.player.NetflixVideoView, o.AbstractC0931
    public void setScale(float f) {
        if (f > 0.0f) {
            this.f14854 = 3;
            this.f14853 = f;
            setScaleX(f);
            setScaleY(f);
            requestLayout();
            return;
        }
        C1283.m16865(f14851, "Invalid mode");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15769(AbstractC0931.AbstractC0932 r2) {
        if (r2 != null) {
            this.f14852.add(r2);
        }
        if (this.f14852.size() > 0) {
            this.f14856.mo14785();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m15768(AbstractC0931.AbstractC0932 r3) {
        if (r3 == null) {
            return false;
        }
        boolean remove = this.f14852.remove(r3);
        if (this.f14852.size() <= 0) {
            this.f14856.mo14786();
        }
        return remove;
    }

    @Override // o.AbstractC0931
    /* renamed from: ˏ */
    public View mo15742() {
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size == 0 || size2 == 0) {
            size = 1920;
            size2 = 1080;
            C1283.m16854(f14851, "use hardcode size");
        }
        this.f14855 = size;
        this.f14857 = size2;
        super.onMeasure(i, i2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m15767() {
        if (m2338() == 0 || m2336() == 0 || this.f14855 == 0 || this.f14857 == 0 || m2338() * this.f14857 != m2336() * this.f14855) {
            return true;
        }
        return false;
    }
}
