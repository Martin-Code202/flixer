package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
/* renamed from: o.Ag  reason: case insensitive filesystem */
public class C1305Ag {

    /* renamed from: o.Ag$ˊ  reason: contains not printable characters */
    public interface AbstractC0066 {
        void onOfflineDownloadPinAndAgeVerified(boolean z, PlayVerifierVault playVerifierVault);

        void onPlayVerified(boolean z, PlayVerifierVault playVerifierVault);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3609(NetflixActivity netflixActivity, boolean z, PlayVerifierVault playVerifierVault) {
        C1283.m16846("nf_age", String.format(" isAgeProtected: %b, isAgeVerified: %b", Boolean.valueOf(z), Boolean.valueOf(netflixActivity.getServiceManager().m9812())));
        if (!z || netflixActivity.getServiceManager().m9812()) {
            m3608(netflixActivity, playVerifierVault, netflixActivity);
        } else {
            C1308Aj.m3632().m3634(netflixActivity, playVerifierVault, netflixActivity);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static void m3608(NetflixActivity netflixActivity, PlayVerifierVault playVerifierVault, AbstractC0066 r4) {
        if (playVerifierVault != null) {
            C1306Ah.m3615().m3623(netflixActivity, playVerifierVault.m2948(), playVerifierVault, r4);
        } else {
            C1283.m16850("nf_age", "vault null, skipping pin and play");
        }
    }
}
