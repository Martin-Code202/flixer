package o;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.concurrent.TimeUnit;
/* renamed from: o.hr  reason: case insensitive filesystem */
public class C1860hr {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f7419 = 0;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final long f7420 = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Object f7421 = new Object();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m7330(Context context) {
        synchronized (f7421) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= f7419 + f7420) {
                C1339Bl.m4043(context, "last_contact_netflix_ms", currentTimeMillis);
                f7419 = currentTimeMillis;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static long m7326(Context context) {
        long j;
        synchronized (f7421) {
            if (f7419 == 0) {
                f7419 = C1339Bl.m4044(context, "last_contact_netflix_ms", -1);
            }
            j = f7419;
        }
        return j;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m7327(Context context) {
        long r4 = m7326(context);
        if (r4 <= 0 || (f7420 * 2) + r4 < System.currentTimeMillis() || !ConnectivityUtils.m2954(context)) {
            return false;
        }
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m7333(OfflinePlayablePersistentData.iF iFVar) {
        return iFVar.mViewingWindow >= System.currentTimeMillis();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m7331(Context context, OfflinePlayablePersistentData offlinePlayablePersistentData, OfflinePlayablePersistentData.iF iFVar) {
        if (!iFVar.mShouldUsePlayWindowLimits || offlinePlayablePersistentData.mPlayStartTime <= 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - offlinePlayablePersistentData.mPlayStartTime < iFVar.m824() || ConnectivityUtils.m2954(context)) {
            return true;
        }
        long r6 = m7326(context);
        if (!iFVar.mPwResettable || iFVar.mPlayWindowResetLimit <= 0 || r6 <= 0 || currentTimeMillis - r6 >= iFVar.m824()) {
            return false;
        }
        iFVar.mPlayWindowResetLimit--;
        synchronized (offlinePlayablePersistentData) {
            offlinePlayablePersistentData.mPlayStartTime = 0;
        }
        C1283.m16854("nf_PlayabilityEnforcer", "reset play window");
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m7329(OfflinePlayablePersistentData.iF iFVar) {
        return iFVar.mExpirationTimeInMs < BA.m3835();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m7332(OfflinePlayablePersistentData.iF iFVar) {
        long r4 = BA.m3835();
        return (iFVar.mShouldRefreshByTimestamp && r4 >= iFVar.mRefreshLicenseTimestamp) || (iFVar.mExpirationTimeInMs > 0 && iFVar.mExpirationTimeInMs <= 864000000 + r4);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static Status m7328(Context context, OfflinePlayablePersistentData offlinePlayablePersistentData) {
        if (!offlinePlayablePersistentData.mLicenseData.mPwResettable || offlinePlayablePersistentData.mLicenseData.mPlayWindowResetLimit <= 0 || !ConnectivityUtils.m2954(context)) {
            return new NetflixStatus(StatusCode.DL_PLAY_WINDOW_RENEW_FAILED);
        }
        offlinePlayablePersistentData.mLicenseData.mPlayWindowResetLimit--;
        offlinePlayablePersistentData.mPlayStartTime = 0;
        return AbstractC0367.f13235;
    }
}
