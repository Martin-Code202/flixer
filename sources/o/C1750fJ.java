package o;

import android.os.Build;
import com.netflix.mediaclient.service.logging.client.model.Device;
/* renamed from: o.fJ  reason: case insensitive filesystem */
public final class C1750fJ extends AbstractC1744fD {
    public C1750fJ(String str, int i, String str2, String str3, Integer num, boolean z, Boolean bool) {
        super("PLAYER_PLAY");
        m6355(str, i, str2, str3, num, z, bool.booleanValue());
        m6354("originator", "USER");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6355(String str, int i, String str2, String str3, Integer num, boolean z, boolean z2) {
        m6354("catalogId", str);
        m6351("trackId", i);
        m6354(Device.ESN, str2);
        m6353("enablePostPlay", true);
        m6354("controllerName", Build.MODEL);
        if (C1061.m16114().mo14173()) {
            m6353("isPinVerified", true);
        }
        if (z) {
            m6353("isPreReleasePinVerified", true);
        }
        if (str3 != null) {
            m6354("episodeId", str3);
        }
        if (num != null && num.intValue() >= 0) {
            m6351("startTime", num.intValue());
        }
        if (z2) {
            m6353("enableSkipIntro", true);
        }
    }
}
