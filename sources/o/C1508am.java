package o;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
/* renamed from: o.am  reason: case insensitive filesystem */
public final class C1508am {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static AbstractC1506ak m5627(Context context) {
        C1348Bu.m4094();
        try {
            if (0 == GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)) {
                return new C1509an(context);
            }
            C1283.m16850("nf_log", "Not success!");
            return null;
        } catch (Throwable th) {
            C1283.m16847("nf_log", "Failed to create Google Play provider", th);
            return null;
        }
    }
}
