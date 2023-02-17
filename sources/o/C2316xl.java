package o;

import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.offlineplayback.ExoPlaybackError;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import java.util.concurrent.TimeUnit;
import o.C0505;
/* renamed from: o.xl  reason: case insensitive filesystem */
public final class C2316xl {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final long f12209 = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: ˊ  reason: contains not printable characters */
    public static AbstractC1268 m12949(IPlayerFragment iPlayerFragment, IPlayer.aux aux) {
        String str;
        if (!iPlayerFragment.m2250()) {
            C1283.m16862("ErrorManager", "Fragment was already detached from the activity - skipping error...");
            return null;
        }
        if (aux instanceof C1934ke) {
            str = aux.mo1000();
            if (C1349Bv.m4113(str)) {
                str = iPlayerFragment.mo2252(R.string.NFErr_STREAMING_PLAYBACK_FAILED, "(" + aux.mo1001() + ")");
            }
        } else {
            int i = R.string.NFErr_OFFLINE_PLAYBACK_FAILED;
            if ((aux instanceof ExoPlaybackError) && aux.mo998() == ExoPlaybackError.ExoPlaybackErrorCode.CRYPTO_ERROR.m1003() && BA.m3834(f12209)) {
                i = R.string.NFErr_OFFLINE_PLAYBACK_FAILED_TIME_OFF;
            }
            str = iPlayerFragment.mo2252(i, "(" + aux.mo1001() + ")");
        }
        NetflixActivity r8 = iPlayerFragment.m2242();
        C1687e eVar = new C1687e(r8);
        final AQ aq = new AQ(r8.getApplicationContext(), "https://help.netflix.com/support/14384");
        r8.getServiceManager().m9784(3600000, new AbstractC2061pj() { // from class: o.xl.5
            @Override // o.AbstractC2061pj, o.oU
            public void onAutoLoginTokenCreated(String str2, Status status) {
                if (str2 != null) {
                    aq.m3402(C2154sm.m10802("https://help.netflix.com/support/14384", str2));
                }
            }
        });
        return new C2323xr(new C0505.If("", str, null, eVar, r8.getString(R.string.label_dialogButtonMore), aq));
    }
}
