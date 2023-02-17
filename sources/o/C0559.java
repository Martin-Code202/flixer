package o;

import android.os.Bundle;
import com.firebase.jobdispatcher.GooglePlayReceiver;
import o.C0897;
/* access modifiers changed from: package-private */
/* renamed from: o.ן  reason: contains not printable characters */
public final class C0559 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0699 f13803 = new C0699("com.firebase.jobdispatcher.", false);

    C0559() {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m14633(AbstractC0639 r3, Bundle bundle, C0897.If r5) {
        bundle.putInt("trigger_type", 1);
        if (r3.mo14608()) {
            bundle.putLong("period", (long) r5.m15625());
            bundle.putLong("period_flex", (long) (r5.m15625() - r5.m15624()));
            return;
        }
        bundle.putLong("window_start", (long) r5.m15624());
        bundle.putLong("window_end", (long) r5.m15625());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m14632(Bundle bundle) {
        bundle.putInt("trigger_type", 2);
        bundle.putLong("window_start", 0);
        bundle.putLong("window_end", 30);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Bundle m14638(AbstractC0639 r5, Bundle bundle) {
        bundle.putString("tag", r5.mo14606());
        bundle.putBoolean("update_current", r5.mo14604());
        bundle.putBoolean("persisted", r5.mo14609() == 2);
        bundle.putString("service", GooglePlayReceiver.class.getName());
        m14635(r5, bundle);
        m14637(r5, bundle);
        m14636(r5, bundle);
        Bundle r3 = r5.mo14605();
        if (r3 == null) {
            r3 = new Bundle();
        }
        bundle.putBundle("extras", this.f13803.m15010(r5, r3));
        return bundle;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14636(AbstractC0639 r5, Bundle bundle) {
        C0986 r2 = r5.mo14603();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("retry_policy", m14634(r2.m15925()));
        bundle2.putInt("initial_backoff_seconds", r2.m15924());
        bundle2.putInt("maximum_backoff_seconds", r2.m15926());
        bundle.putBundle("retryStrategy", bundle2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private int m14634(int i) {
        switch (i) {
            case 1:
            default:
                return 0;
            case 2:
                return 1;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14635(AbstractC0639 r5, Bundle bundle) {
        C0897 r3 = r5.mo14601();
        if (r3 == C0821.f14612) {
            m14632(bundle);
        } else if (r3 instanceof C0897.If) {
            m14633(r5, bundle, (C0897.If) r3);
        } else {
            throw new IllegalArgumentException("Unknown trigger: " + r3.getClass());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14637(AbstractC0639 r5, Bundle bundle) {
        int r3 = C1225.m16564(r5.mo14607());
        bundle.putBoolean("requiresCharging", (r3 & 4) == 4);
        bundle.putInt("requiredNetwork", m14631(r3));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m14631(int i) {
        return (i & 1) == 1 ? 1 : (i & 2) == 2 ? 0 : 2;
    }
}
