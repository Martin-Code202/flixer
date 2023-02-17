package o;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* renamed from: o.ڹ  reason: contains not printable characters */
public class C0621 extends ScrollView {

    /* renamed from: ˊ  reason: contains not printable characters */
    private If f13929;

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f13930 = -1;

    /* renamed from: o.ڹ$If */
    public interface If {
        /* renamed from: ॱ */
        void mo2907();
    }

    public C0621(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public C0621(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C0621(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f13930 == -1) {
            m14748();
            postDelayed(new RunnableC2401iF(), 100);
        }
        this.f13930 = System.currentTimeMillis();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14748() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14749() {
        if (this.f13929 != null) {
            this.f13929.mo2907();
        }
    }

    public void setOnScrollStopListener(If r1) {
        this.f13929 = r1;
    }

    /* renamed from: o.ڹ$iF  reason: case insensitive filesystem */
    class RunnableC2401iF implements Runnable {
        private RunnableC2401iF() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - C0621.this.f13930 > 100) {
                C0621.this.f13930 = -1;
                C0621.this.m14749();
                return;
            }
            C0621.this.postDelayed(this, 100);
        }
    }
}
