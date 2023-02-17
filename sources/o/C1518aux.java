package o;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* renamed from: o.aux  reason: case insensitive filesystem */
public class C1518aux extends Drawable implements Drawable.Callback {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f6067 = C1518aux.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C1024 f6068 = new C1024();

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private C0700 f6069;

    /* renamed from: ʼ  reason: contains not printable characters */
    private float f6070 = 1.0f;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Set<iF> f6071 = new HashSet();

    /* renamed from: ˊ  reason: contains not printable characters */
    Cif f6072;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C1047 f6073;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Matrix f6074 = new Matrix();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final ArrayList<Cif> f6075 = new ArrayList<>();

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f6076;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1034 f6077;

    /* renamed from: ͺ  reason: contains not printable characters */
    private AbstractC1871iF f6078;

    /* renamed from: ॱ  reason: contains not printable characters */
    C1490aUx f6079;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f6080;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f6081;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean f6082;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private float f6083 = 1.0f;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0433 f6084;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f6085 = 255;

    /* access modifiers changed from: package-private */
    /* renamed from: o.aux$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˋ */
        void mo5701(C0433 v);
    }

    public C1518aux() {
        this.f6068.setRepeatCount(0);
        this.f6068.setInterpolator(new LinearInterpolator());
        this.f6068.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.aux.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (C1518aux.this.f6069 != null) {
                    C1518aux.this.f6069.mo15013(C1518aux.this.f6068.m16002());
                }
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m5691() {
        return this.f6081;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5690(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(f6067, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.f6081 = z;
        if (this.f6084 != null) {
            m5657();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5684(String str) {
        this.f6080 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m5668() {
        return this.f6080;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5694() {
        if (this.f6077 != null) {
            this.f6077.m16041();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m5692(C0433 r5) {
        if (this.f6084 == r5) {
            return false;
        }
        m5661();
        this.f6084 = r5;
        m5680(this.f6070);
        m5669(this.f6083);
        m5663();
        m5657();
        m5652();
        Iterator it = new ArrayList(this.f6075).iterator();
        while (it.hasNext()) {
            ((Cif) it.next()).mo5701(r5);
            it.remove();
        }
        this.f6075.clear();
        r5.m14259(this.f6082);
        this.f6068.m16006();
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5673(boolean z) {
        this.f6082 = z;
        if (this.f6084 != null) {
            this.f6084.m14259(z);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m5657() {
        this.f6069 = new C0700(this, Layer.C0001.m82(this.f6084), this.f6084.m14252(), this.f6084);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m5652() {
        if (this.f6069 != null) {
            for (iF iFVar : this.f6071) {
                this.f6069.mo5648(iFVar.f6097, iFVar.f6098, iFVar.f6096);
            }
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m5661() {
        m5694();
        this.f6069 = null;
        this.f6077 = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f6085 = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f6085;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("Use addColorFilter instead.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5683(ColorFilter colorFilter) {
        m5656(null, null, colorFilter);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5656(String str, String str2, ColorFilter colorFilter) {
        iF iFVar = new iF(str, str2, colorFilter);
        if (colorFilter != null || !this.f6071.contains(iFVar)) {
            this.f6071.add(new iF(str, str2, colorFilter));
        } else {
            this.f6071.remove(iFVar);
        }
        if (this.f6069 != null) {
            this.f6069.mo5648(str, str2, colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C1466If.m5165("Drawable#draw");
        if (this.f6069 != null) {
            float f = this.f6083;
            float f2 = 1.0f;
            float r5 = m5658(canvas);
            if (f > r5) {
                f = r5;
                f2 = this.f6083 / f;
            }
            if (f2 > 1.0f) {
                canvas.save();
                float width = ((float) this.f6084.m14263().width()) / 2.0f;
                float height = ((float) this.f6084.m14263().height()) / 2.0f;
                float f3 = width * f;
                float f4 = height * f;
                canvas.translate((m5674() * width) - f3, (m5674() * height) - f4);
                canvas.scale(f2, f2, f3, f4);
            }
            this.f6074.reset();
            this.f6074.preScale(f, f);
            this.f6069.mo5647(canvas, this.f6074, this.f6085);
            C1466If.m5166("Drawable#draw");
            if (f2 > 1.0f) {
                canvas.restore();
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5679() {
        this.f6076 = true;
        this.f6068.m15999();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5686(boolean z) {
        this.f6068.setRepeatCount(z ? -1 : 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m5678() {
        return this.f6068.getRepeatCount() == -1;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m5665() {
        return this.f6068.isRunning();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m5699() {
        m5659(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5659(final boolean z) {
        if (this.f6069 == null) {
            this.f6075.add(new Cif() { // from class: o.aux.5
                @Override // o.C1518aux.Cif
                /* renamed from: ˋ */
                public void mo5701(C0433 r3) {
                    C1518aux.this.m5659(z);
                }
            });
        } else if (z) {
            this.f6068.start();
        } else {
            this.f6068.m16000();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5672(final int i, final int i2) {
        if (this.f6084 == null) {
            this.f6075.add(new Cif() { // from class: o.aux.3
                @Override // o.C1518aux.Cif
                /* renamed from: ˋ */
                public void mo5701(C0433 r4) {
                    C1518aux.this.m5672(i, i2);
                }
            });
        } else {
            m5688(((float) i) / this.f6084.m14257(), ((float) i2) / this.f6084.m14257());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5688(float f, float f2) {
        this.f6068.m16005(f, f2);
        this.f6068.setCurrentPlayTime(0);
        m5687(f);
        m5659(false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5671(final int i) {
        if (this.f6084 == null) {
            this.f6075.add(new Cif() { // from class: o.aux.1
                @Override // o.C1518aux.Cif
                /* renamed from: ˋ  reason: contains not printable characters */
                public void mo5701(C0433 r3) {
                    C1518aux.this.m5671(i);
                }
            });
        } else {
            m5676(((float) i) / this.f6084.m14257());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5676(float f) {
        this.f6068.m16007(f);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5681(final int i) {
        if (this.f6084 == null) {
            this.f6075.add(new Cif() { // from class: o.aux.2
                @Override // o.C1518aux.Cif
                /* renamed from: ˋ */
                public void mo5701(C0433 r3) {
                    C1518aux.this.m5681(i);
                }
            });
        } else {
            m5695(((float) i) / this.f6084.m14257());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5695(float f) {
        this.f6068.m16001(f);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5696(int i, int i2) {
        m5671(i);
        m5681(i2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5670(float f, float f2) {
        m5676(f);
        m5695(f2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5680(float f) {
        this.f6070 = f;
        this.f6068.m16008(f < 0.0f);
        if (this.f6084 != null) {
            this.f6068.setDuration((long) (((float) this.f6084.m14267()) / Math.abs(f)));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5687(float f) {
        this.f6068.m16003(f);
        if (this.f6069 != null) {
            this.f6069.mo15013(f);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public float m5700() {
        return this.f6068.m16002();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5669(float f) {
        this.f6083 = f;
        m5663();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5697(AbstractC1871iF iFVar) {
        this.f6078 = iFVar;
        if (this.f6077 != null) {
            this.f6077.m16038(iFVar);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5685(Cif ifVar) {
        this.f6072 = ifVar;
        if (this.f6073 != null) {
            this.f6073.m16076(ifVar);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5689(C1490aUx aux) {
        this.f6079 = aux;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public C1490aUx m5664() {
        return this.f6079;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m5666() {
        return this.f6079 == null && this.f6084.m14253().size() > 0;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public float m5674() {
        return this.f6083;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public C0433 m5698() {
        return this.f6084;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m5663() {
        if (this.f6084 != null) {
            float r4 = m5674();
            setBounds(0, 0, (int) (((float) this.f6084.m14263().width()) * r4), (int) (((float) this.f6084.m14263().height()) * r4));
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m5693() {
        this.f6075.clear();
        this.f6068.cancel();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5677(Animator.AnimatorListener animatorListener) {
        this.f6068.addListener(animatorListener);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5682(Animator.AnimatorListener animatorListener) {
        this.f6068.removeListener(animatorListener);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f6084 == null) {
            return -1;
        }
        return (int) (((float) this.f6084.m14263().width()) * m5674());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f6084 == null) {
            return -1;
        }
        return (int) (((float) this.f6084.m14263().height()) * m5674());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Bitmap m5667(String str) {
        C1034 r1 = m5662();
        if (r1 != null) {
            return r1.m16040(str);
        }
        return null;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1034 m5662() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f6077 != null && !this.f6077.m16039(m5660())) {
            this.f6077.m16041();
            this.f6077 = null;
        }
        if (this.f6077 == null) {
            this.f6077 = new C1034(getCallback(), this.f6080, this.f6078, this.f6084.m14260());
        }
        return this.f6077;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Typeface m5675(String str, String str2) {
        C1047 r1 = m5651();
        if (r1 != null) {
            return r1.m16075(str, str2);
        }
        return null;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private C1047 m5651() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f6073 == null) {
            this.f6073 = new C1047(getCallback(), this.f6072);
        }
        return this.f6073;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private Context m5660() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private float m5658(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f6084.m14263().width()), ((float) canvas.getHeight()) / ((float) this.f6084.m14263().height()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.aux$iF */
    public static class iF {

        /* renamed from: ˋ  reason: contains not printable characters */
        final ColorFilter f6096;

        /* renamed from: ˎ  reason: contains not printable characters */
        final String f6097;

        /* renamed from: ॱ  reason: contains not printable characters */
        final String f6098;

        iF(String str, String str2, ColorFilter colorFilter) {
            this.f6097 = str;
            this.f6098 = str2;
            this.f6096 = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.f6097 != null) {
                i = this.f6097.hashCode() * 527;
            }
            if (this.f6098 != null) {
                return i * 31 * this.f6098.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof iF)) {
                return false;
            }
            iF iFVar = (iF) obj;
            return hashCode() == iFVar.hashCode() && this.f6096 == iFVar.f6096;
        }
    }
}
