package o;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowInsets;
import java.util.HashSet;
import java.util.Set;
/* renamed from: o.ᵟ  reason: contains not printable characters */
public class C1031 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Runnable f15137 = new Runnable() { // from class: o.ᵟ.3
        @Override // java.lang.Runnable
        public void run() {
            C1031.this.m16029(C1031.this.f15140);
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private Handler f15138 = new Handler(Looper.getMainLooper());

    /* renamed from: ˎ  reason: contains not printable characters */
    private Set<If> f15139 = new HashSet();

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f15140 = false;

    /* renamed from: o.ᵟ$If */
    public interface If {
        /* renamed from: ˎ */
        void mo434(boolean z);
    }

    public C1031(final Activity activity) {
        activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: o.ᵟ.2
            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                boolean z = C1031.this.f15140;
                C1031.this.f15140 = windowInsets.getSystemWindowInsetBottom() - C1004.m15954(activity, 80) > windowInsets.getStableInsetBottom();
                if (z != C1031.this.f15140) {
                    C1031.this.m16033(C1031.this.f15140);
                }
                return view.onApplyWindowInsets(windowInsets);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16033(boolean z) {
        if (z) {
            m16029(true);
        } else {
            this.f15138.post(this.f15137);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16029(boolean z) {
        synchronized (this) {
            for (If r0 : this.f15139) {
                r0.mo434(z);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m16036(If r2) {
        this.f15139.add(r2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m16035() {
        return this.f15140;
    }
}
