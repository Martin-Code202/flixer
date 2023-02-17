package o;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import com.netflix.mediaclient.servicemgr.UiLocation;
import o.C1348Bu;
import o.yO;
import org.json.JSONObject;
public abstract class yQ {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f12422;

    /* renamed from: ˋ  reason: contains not printable characters */
    private yO.AbstractRunnableC0303 f12423;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ColorDrawable f12424;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Runnable f12425;

    /* renamed from: ˊ */
    public abstract AbstractC2087qh mo11028();

    /* renamed from: ˋ */
    public abstract Integer mo11029();

    /* renamed from: ˎ */
    public abstract AbstractC2072pu mo11030();

    /* renamed from: ˏ */
    public abstract Integer mo11031();

    /* renamed from: ॱ */
    public abstract View mo11032();

    /* renamed from: ᐝ */
    public abstract UiLocation mo11034();

    public yQ() {
        Cif ifVar;
        this.f12424 = yO.f12410 ? new ColorDrawable(Color.argb(200, 0, 0, 0)) : null;
        if (yO.f12410) {
            ifVar = new Cif(this);
        } else {
            ifVar = null;
        }
        this.f12425 = ifVar;
    }

    /* renamed from: o.yQ$if  reason: invalid class name */
    static final class Cif implements Runnable {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ yQ f12426;

        Cif(yQ yQVar) {
            this.f12426 = yQVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f12426.mo11032().setForeground(null);
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final yO.AbstractRunnableC0303 m13240() {
        return this.f12423;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m13243(yO.AbstractRunnableC0303 r1) {
        this.f12423 = r1;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public final boolean m13241() {
        return this.f12422;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m13244(boolean z) {
        this.f12422 = z;
    }

    /* renamed from: ʻ */
    public JSONObject mo11027() {
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m13242(int i) {
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public final void m13245() {
        yO.AbstractRunnableC0303 r1 = this.f12423;
        if (r1 != null) {
            C1348Bu.If.m4099(r1);
            this.f12423 = null;
        }
    }
}
