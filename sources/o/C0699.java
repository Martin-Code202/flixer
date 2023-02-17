package o;

import android.os.Bundle;
import android.util.Log;
import o.C0742;
import o.C0897;
/* renamed from: o.า  reason: contains not printable characters */
public final class C0699 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14210;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean f14211;

    public C0699(String str, boolean z) {
        this.f14211 = z;
        this.f14210 = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public Bundle m15010(AbstractC0639 r3, Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Unexpected null Bundle provided");
        }
        bundle.putInt(this.f14210 + "persistent", r3.mo14609());
        bundle.putBoolean(this.f14210 + "recurring", r3.mo14608());
        bundle.putBoolean(this.f14210 + "replace_current", r3.mo14604());
        bundle.putString(this.f14210 + "tag", r3.mo14606());
        bundle.putString(this.f14210 + "service", r3.mo14602());
        bundle.putInt(this.f14210 + "constraints", C1225.m16564(r3.mo14607()));
        if (this.f14211) {
            bundle.putBundle(this.f14210 + "extras", r3.mo14605());
        }
        m15008(r3.mo14601(), bundle);
        m15009(r3.mo14603(), bundle);
        return bundle;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0742 m15011(Bundle bundle) {
        if (bundle == null) {
            Log.e("FJD.ExternalReceiver", "Unexpected null Bundle provided");
            return null;
        }
        Bundle bundle2 = bundle.getBundle("extras");
        if (bundle2 == null) {
            return null;
        }
        return m15012(bundle2).m15155();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0742.C0743 m15012(Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Unexpected null Bundle provided");
        }
        boolean z = bundle.getBoolean(this.f14210 + "recurring");
        boolean z2 = bundle.getBoolean(this.f14210 + "replace_current");
        int i = bundle.getInt(this.f14210 + "persistent");
        int[] r5 = C1225.m16565(bundle.getInt(this.f14210 + "constraints"));
        C0897 r6 = m15006(bundle);
        C0986 r7 = m15007(bundle);
        String string = bundle.getString(this.f14210 + "tag");
        String string2 = bundle.getString(this.f14210 + "service");
        if (string == null || string2 == null || r6 == null || r7 == null) {
            return null;
        }
        C0742.C0743 r10 = new C0742.C0743();
        r10.m15151(string);
        r10.m15156(string2);
        r10.m15148(r6);
        r10.m15149(r7);
        r10.m15154(z);
        r10.m15147(i);
        r10.m15150(r5);
        r10.m15152(z2);
        r10.m15153(bundle);
        return r10;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0897 m15006(Bundle bundle) {
        switch (bundle.getInt(this.f14210 + "trigger_type")) {
            case 1:
                return C0821.m15431(bundle.getInt(this.f14210 + "window_start"), bundle.getInt(this.f14210 + "window_end"));
            case 2:
                return C0821.f14612;
            default:
                if (!Log.isLoggable("FJD.ExternalReceiver", 3)) {
                    return null;
                }
                Log.d("FJD.ExternalReceiver", "Unsupported trigger.");
                return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15008(C0897 r4, Bundle bundle) {
        if (r4 == C0821.f14612) {
            bundle.putInt(this.f14210 + "trigger_type", 2);
        } else if (r4 instanceof C0897.If) {
            C0897.If r2 = (C0897.If) r4;
            bundle.putInt(this.f14210 + "trigger_type", 1);
            bundle.putInt(this.f14210 + "window_start", r2.m15624());
            bundle.putInt(this.f14210 + "window_end", r2.m15625());
        } else {
            throw new IllegalArgumentException("Unsupported trigger.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0986 m15007(Bundle bundle) {
        int i = bundle.getInt(this.f14210 + "retry_policy");
        if (i == 1 || i == 2) {
            return new C0986(i, bundle.getInt(this.f14210 + "initial_backoff_seconds"), bundle.getInt(this.f14210 + "maximum_backoff_seconds"));
        }
        return C0986.f15039;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15009(C0986 r3, Bundle bundle) {
        if (r3 == null) {
            r3 = C0986.f15039;
        }
        bundle.putInt(this.f14210 + "retry_policy", r3.m15925());
        bundle.putInt(this.f14210 + "initial_backoff_seconds", r3.m15924());
        bundle.putInt(this.f14210 + "maximum_backoff_seconds", r3.m15926());
    }
}
