package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import o.C1305Ag;
/* renamed from: o.Aj  reason: case insensitive filesystem */
public class C1308Aj {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static C1308Aj f4443 = new C1308Aj();

    private C1308Aj() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C1308Aj m3632() {
        return f4443;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3634(NetflixActivity netflixActivity, PlayVerifierVault playVerifierVault, C1305Ag.AbstractC0066 r6) {
        if (m3633(playVerifierVault)) {
            C1299Ab r2 = C1299Ab.m3513(playVerifierVault);
            r2.m3521(r6);
            r2.show(netflixActivity.getSupportFragmentManager(), NetflixActivity.FRAG_DIALOG_TAG);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m3633(PlayVerifierVault playVerifierVault) {
        if (PlayVerifierVault.RequestedBy.MDX.m2951().equals(playVerifierVault.m2945())) {
            return false;
        }
        return true;
    }
}
