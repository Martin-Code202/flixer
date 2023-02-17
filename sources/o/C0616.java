package o;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.ViewUtils;
import o.C0567;
/* renamed from: o.ڕ  reason: contains not printable characters */
public class C0616 extends C0567 {

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static final long f13921 = (C1322Av.m3792() ? 0 : 150);

    /* renamed from: ʻ  reason: contains not printable characters */
    protected final Handler f13922;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Runnable f13923;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Runnable f13924;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected final View f13925;

    public C0616(View view, C0567.Cif ifVar) {
        this(view, ifVar, R.id.loading_view);
        mo14570(false);
    }

    protected C0616(View view, C0567.Cif ifVar, int i) {
        super(view, ifVar);
        this.f13924 = new Runnable() { // from class: o.ڕ.1
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                if (!ViewUtils.m3005(C0616.this.f13925)) {
                    C1283.m16846("LoadingAndErrorWrapper", "Showing loading view without animation (via runnable)");
                    BQ.m3914(C0616.this.f13925, false);
                }
            }
        };
        this.f13923 = new Runnable() { // from class: o.ڕ.5
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                if (!ViewUtils.m3005(C0616.this.f13925)) {
                    C1283.m16846("LoadingAndErrorWrapper", "Showing loading view with animation (via runnable)");
                    BQ.m3914(C0616.this.f13925, true);
                }
            }
        };
        this.f13922 = new Handler(Looper.getMainLooper());
        this.f13925 = view.findViewById(i);
        this.f13925.setVisibility(8);
    }

    @Override // o.C0567
    /* renamed from: ˎ */
    public void mo14663(boolean z) {
        mo14569();
        super.mo14663(z);
        BQ.m3909(this.f13925, z);
    }

    @Override // o.C0567
    /* renamed from: ˋ */
    public void mo14660(boolean z) {
        mo14569();
        super.mo14660(z);
        BQ.m3909(this.f13925, z);
    }

    @Override // o.C0567
    /* renamed from: ˎ */
    public void mo14662(int i, boolean z, boolean z2) {
        mo14569();
        super.mo14662(i, z, z2);
        BQ.m3909(this.f13925, z2);
    }

    /* renamed from: ˏ */
    public void mo14570(boolean z) {
        mo14569();
        super.mo14663(z);
        if (this.f13925.getVisibility() == 0) {
            C1283.m16846("LoadingAndErrorWrapper", "Loading view is already visible - skipping");
            return;
        }
        C1283.m16846("LoadingAndErrorWrapper", "Showing loading view after delay");
        this.f13922.postDelayed(z ? this.f13923 : this.f13924, f13921);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public void mo14569() {
        this.f13922.removeCallbacks(this.f13924);
        this.f13922.removeCallbacks(this.f13923);
    }

    @Override // o.C0567
    /* renamed from: ˋ */
    public void mo14659(int i, int i2, int i3, int i4) {
        super.mo14659(i, i2, i3, i4);
        if (this.f13925 != null) {
            this.f13925.setPadding(i, i2, i3, i4);
        }
    }
}
