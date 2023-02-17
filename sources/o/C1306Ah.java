package o;

import android.content.Intent;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import o.C1305Ag;
/* renamed from: o.Ah  reason: case insensitive filesystem */
public class C1306Ah implements AbstractC0390 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static C1303Af f4427 = null;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f4428;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static C1306Ah f4429 = new C1306Ah();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean f4430;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static long f4431;

    private C1306Ah() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1306Ah m3615() {
        return f4429;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m3623(NetflixActivity netflixActivity, boolean z, PlayVerifierVault playVerifierVault, C1305Ag.AbstractC0066 r11) {
        if (0 == 0 && 0 == 0) {
            if (!m3612(playVerifierVault.m2948(), playVerifierVault.m2947())) {
                C1303Af.m3596(netflixActivity, playVerifierVault, r11);
                return;
            }
        }
        if (f4427 == null || m3614(playVerifierVault)) {
            NetflixApplication netflixApplication = (NetflixApplication) netflixActivity.getApplication();
            if (netflixApplication.m244()) {
                C1283.m16854("nf_pin", "skip pin dialog - was in background");
                return;
            }
            netflixApplication.m237().mo14206(this);
            f4427 = C1303Af.m3591(playVerifierVault);
            f4427.m3606(r11);
            f4427.show(netflixActivity.getSupportFragmentManager(), NetflixActivity.FRAG_DIALOG_TAG);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m3614(PlayVerifierVault playVerifierVault) {
        C1283.m16865("nf_pin", String.format("pinDialog!=null loc:%s, visible:%b, hidden:%b", playVerifierVault.m2945(), Boolean.valueOf(f4427.isVisible()), Boolean.valueOf(f4427.isHidden())));
        if (!f4427.isVisible() && !f4427.isHidden()) {
            C1283.m16865("nf_pin", String.format("Error.. pinDialog!=null but not visible - killing.. loc:%s, visible:%b, hidden:%b", playVerifierVault.m2945(), Boolean.valueOf(f4427.isVisible()), Boolean.valueOf(f4427.isHidden())));
            m3620();
            return true;
        } else if (PlayVerifierVault.RequestedBy.MDX.m2951().equals(playVerifierVault.m2945())) {
            return false;
        } else {
            m3620();
            return true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3621() {
        m3617();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3610() {
        return f4428 > System.currentTimeMillis();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3611(long j) {
        m3613(j);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m3612(boolean z, boolean z2) {
        C1283.m16854("nf_pin_session", String.format("Active:%b isPinProtected:%b isPreviewProtected: %b - shouldVerifyPin", Boolean.valueOf(m3610()), Boolean.valueOf(z), Boolean.valueOf(z2)));
        if (z2) {
            return true;
        }
        return z && !m3610();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3622(boolean z, boolean z2) {
        boolean z3 = false;
        if (!z2 && m3610()) {
            z3 = true;
            m3616(System.currentTimeMillis() + 1800000);
        }
        C1283.m16854("nf_pin_session", String.format("isActive: %b, wasPinProtectedPlayback: %b, wasPreviewProtectedPlayback: %b, extendSession ? %b- registerPlayStopEvent", Boolean.valueOf(m3610()), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3619() {
        C1283.m16854("nf_pin_session", String.format("isActive: %b to: true - registerPinVerifyEvent", Boolean.valueOf(m3610())));
        m3616(System.currentTimeMillis() + 1800000);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m3613(long j) {
        if (m3610()) {
            C1283.m16854("nf_pin_session", String.format("isActive: %b lastInteractionTime:%d - registerUserInteractionEvent", Boolean.valueOf(m3610()), Long.valueOf(j)));
            m3616((System.currentTimeMillis() - j) + 1800000);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static void m3617() {
        f4428 = 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m3616(long j) {
        if (j > f4428) {
            C1283.m16854("nf_pin_session", String.format("isActive: %b, current:%d, newExpiry:%d - updatePinSessionExpiryTime", Boolean.valueOf(m3610()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(j)));
            f4428 = j;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001c: APUT  
      (r2v1 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x0017: INVOKE  (r3v4 java.lang.Boolean) = (r3v3 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m3620() {
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(f4430);
        objArr[1] = Boolean.valueOf(f4427 != null);
        C1283.m16854("nf_pin", String.format("dismissPinVerification appInBackground:%b, pinDialogValid:%b", objArr));
        if (f4427 != null) {
            f4427.m3607();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m3624() {
        C1283.m16854("nf_pin", "pinDialogDismissed mPinDialog=null");
        f4427 = null;
    }

    @Override // o.AbstractC0390
    /* renamed from: ॱ */
    public void mo213(AbstractC0457 r3) {
        C1283.m16854("nf_pin", "app in background");
        f4431 = System.currentTimeMillis();
        f4430 = true;
    }

    @Override // o.AbstractC0390
    /* renamed from: ˎ */
    public void mo211(AbstractC0457 r3, Intent intent) {
        f4430 = false;
        C1283.m16854("nf_pin", "app in foreground ");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m3618() {
        return f4430 && System.currentTimeMillis() - f4431 > 180000;
    }

    @Override // o.AbstractC0390
    /* renamed from: ˋ */
    public void mo209(AbstractC0457 r1) {
    }

    @Override // o.AbstractC0390
    /* renamed from: ˏ */
    public void mo212(AbstractC0457 r1) {
    }

    @Override // o.AbstractC0390
    /* renamed from: ˊ */
    public void mo208(AbstractC0457 r1) {
    }

    @Override // o.AbstractC0390
    /* renamed from: ˎ */
    public void mo210(AbstractC0457 r1) {
    }
}
