package o;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.Locale;
import o.AbstractC0837;
import o.C0602;
/* renamed from: o.ᖦ  reason: contains not printable characters */
public class C0904 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final boolean f14785;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f14786;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14787;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f14788;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f14789;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Handler f14790;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f14791;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Runnable f14792;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC0837 f14793;

    /* renamed from: o.ᖦ$ˋ  reason: contains not printable characters */
    public interface AbstractC0905 {
        /* renamed from: ʼ */
        Rect mo11721();

        /* renamed from: ˊ */
        AnimatedVectorDrawable mo11722();

        /* renamed from: ˎ */
        boolean mo11724();

        /* renamed from: ॱ */
        View mo11725();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static /* synthetic */ int m15686(C0904 r2) {
        int i = r2.f14791;
        r2.f14791 = i + 1;
        return i;
    }

    public C0904(Context context, AbstractC0837 r3) {
        this(context, r3, false);
    }

    public C0904(Context context, AbstractC0837 r5, boolean z) {
        this.f14790 = new Handler();
        this.f14788 = 0;
        this.f14791 = 0;
        this.f14789 = 0;
        this.f14786 = false;
        this.f14792 = new Runnable() { // from class: o.ᖦ.5
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView r6 = C0904.this.f14793.m15481();
                if (r6 == null || !r6.isAttachedToWindow() || C1322Av.m3793(r6.getContext())) {
                    C1283.m16851("PulseAnimator", "Row#%s run... wait, no RecyclerView or valid activity detected, stopping...", Integer.valueOf(C0904.this.f14793.m15482()));
                    C0904.this.f14786 = false;
                    return;
                }
                C1283.m16851("PulseAnimator", "Row#%s run at %s with %s pulses", Integer.valueOf(C0904.this.f14793.m15482()), Integer.valueOf(C0904.this.f14791), Integer.valueOf(C0904.this.f14788));
                AbstractC0837.AbstractC0838 r7 = null;
                while (r7 == null && r6.getAdapter() != null && C0904.this.f14791 < r6.getAdapter().getItemCount()) {
                    r7 = (AbstractC0837.AbstractC0838) r6.findViewHolderForAdapterPosition(C0904.m15686(C0904.this));
                }
                if (r7 instanceof AbstractC0905) {
                    AbstractC0905 r8 = (AbstractC0905) r7;
                    if (r8.mo11724()) {
                        View r9 = r8.mo11725();
                        AnimatedVectorDrawable r10 = r8.mo11722();
                        Rect r11 = r8.mo11721();
                        if (r11 != null) {
                            int i = r11.right - r11.left;
                            int i2 = r11.bottom - r11.top;
                            if (i < 0 || i2 < 0) {
                                C1276.m16820().mo5725(String.format(Locale.US, "%s - Invalid dimensions for image view: width: %d, height: %d", "PulseAnimator", Integer.valueOf(i), Integer.valueOf(i2)));
                            } else {
                                r9.getLayoutParams().width = i;
                                r9.getLayoutParams().height = i2;
                                r10.setBounds(r11);
                            }
                        }
                        r9.setBackground(r10);
                        r10.start();
                    }
                }
                if (C0904.this.f14791 >= r6.getAdapter().getItemCount()) {
                    C0904.this.f14791 = 0;
                }
                if (C0904.this.f14786) {
                    C0904.this.f14790.postDelayed(C0904.this.f14792, (long) C0904.this.f14787);
                }
            }
        };
        this.f14793 = r5;
        this.f14789 = this.f14793.m15482();
        this.f14785 = z;
        this.f14787 = (int) (((float) context.getResources().getInteger(C0602.C0607.pulse_duration_ms)) * 0.33333334f);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15696() {
        this.f14786 = true;
        if (this.f14785) {
            this.f14790.postDelayed(this.f14792, (long) ((this.f14789 % 2 == 0 ? 0 : 1) * 250));
        } else {
            this.f14792.run();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15697() {
        this.f14786 = false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m15700() {
        return this.f14786;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15695() {
        this.f14788++;
        if (this.f14788 > 0 && !m15700()) {
            m15696();
        }
        C1283.m16851("PulseAnimator", "Row#%s onPulseAttached with %s attached", Integer.valueOf(this.f14793.m15482()), Integer.valueOf(this.f14788));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15694() {
        this.f14788--;
        if (this.f14788 < 0) {
            throw new IllegalStateException("mPulsesCount should not be negative");
        }
        if (this.f14788 == 0 && m15700()) {
            m15697();
        }
        C1283.m16851("PulseAnimator", "Row#%s onPulseDetached with %s attached", Integer.valueOf(this.f14793.m15482()), Integer.valueOf(this.f14788));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15699(RecyclerView recyclerView) {
        if (this.f14788 > 0) {
            m15696();
        }
        C1283.m16851("PulseAnimator", "Row#%s onAttachedToRecyclerView with %s attached", Integer.valueOf(this.f14793.m15482()), Integer.valueOf(this.f14788));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15698(RecyclerView recyclerView) {
        if (m15700()) {
            m15697();
        }
        C1283.m16851("PulseAnimator", "Row#%s onDetachedFromRecyclerView with %s attached", Integer.valueOf(this.f14793.m15482()), Integer.valueOf(this.f14788));
    }
}
