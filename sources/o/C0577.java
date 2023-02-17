package o;

import android.content.Context;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.service.webclient.model.leafs.BwCap;
import com.netflix.mediaclient.service.webclient.model.leafs.StreamProfileData;
import com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment;
import com.netflix.mediaclient.util.ConnectivityUtils;
/* renamed from: o.ت  reason: contains not printable characters */
public final class C0577 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Boolean f13841 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Boolean f13842 = true;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final int f13843 = BandwidthPreferenceDialogFragment.ManualBwChoice.LOW.m1601();

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int f13844 = 1200;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m14681(Context context) {
        int r2 = C1339Bl.m4037(context, "bw_user_control_auto", -1);
        if (r2 < 0) {
            return f13842.booleanValue();
        }
        return r2 != 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m14690(Context context, Boolean bool, int i) {
        C1339Bl.m4042(context, "bw_user_control_auto", bool.booleanValue() ? 1 : 0);
        C1339Bl.m4042(context, "bw_user_manual_setting", i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m14684(Context context) {
        int r2 = C1339Bl.m4037(context, "bw_user_manual_setting", -1);
        if (r2 >= 0 && r2 <= BandwidthPreferenceDialogFragment.ManualBwChoice.UNLIMITED.m1601() && r2 != BandwidthPreferenceDialogFragment.ManualBwChoice.MEDIUM.m1601() && r2 != BandwidthPreferenceDialogFragment.ManualBwChoice.HIGH.m1601()) {
            return r2;
        }
        int i = f13843;
        C1339Bl.m4042(context, "bw_user_manual_setting", i);
        return i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m14688(Context context) {
        if (m14683(context)) {
            return C1339Bl.m4051(context, "nf_play_no_wifi_warning", false);
        }
        if (!m14681(context) && BandwidthPreferenceDialogFragment.ManualBwChoice.OFF.m1601() == m14684(context)) {
            return true;
        }
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m14689(Context context) {
        if (m14683(context)) {
            C1283.m16854("nf_bw_saving", "Data saver functionality is not yet enabled .. skip migrate");
        } else if (C1339Bl.m4051(context, "nf_play_no_wifi_warning", false)) {
            C1283.m16854("nf_bw_saving", "migrating wifi only setting to latest");
            m14690(context, false, BandwidthPreferenceDialogFragment.ManualBwChoice.OFF.m1601());
            C1283.m16854("nf_bw_saving", "unsetting old wifi only setting");
            C1339Bl.m4048(context, "nf_play_no_wifi_warning", false);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m14683(Context context) {
        return C1339Bl.m4051(context, "disable_data_saver", false);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m14692(Context context) {
        if (m14681(context)) {
            C1283.m16851("nf_bw_saving", "shouldLimitCellularVideoBitrate :%b", true);
            return true;
        }
        boolean z = BandwidthPreferenceDialogFragment.ManualBwChoice.UNLIMITED.m1601() != m14684(context);
        C1283.m16851("nf_bw_saving", "shouldLimitCellularVideoBitrate :%b", Boolean.valueOf(z));
        return z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m14685(Context context, BwCap bwCap) {
        if (m14681(context)) {
            return m14687(bwCap);
        }
        int r6 = m14684(context);
        int r7 = m14682(r6, bwCap);
        C1283.m16851("nf_bw_saving", "getCellularVideoBitrateKbps manual: %b,  : %d", Integer.valueOf(r6), Integer.valueOf(r7));
        return r7;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m14682(int i, BwCap bwCap) {
        if (BandwidthPreferenceDialogFragment.ManualBwChoice.LOW.m1601() == i) {
            return m14680(bwCap);
        }
        if (BandwidthPreferenceDialogFragment.ManualBwChoice.UNLIMITED.m1601() == i) {
            return 20000;
        }
        if (BandwidthPreferenceDialogFragment.ManualBwChoice.OFF.m1601() == i) {
            return 0;
        }
        return StreamProfileData.Companion.getDEFAULT_CELLULAR_AUTO_KBPS();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m14679(Context context) {
        if (f13841.booleanValue()) {
            return true;
        }
        if (!ConnectivityUtils.m2969(context)) {
            C1283.m16854("nf_bw_saving", "no cellular!!");
            return false;
        } else if (m14683(context)) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r1 = m14684(r2);
     */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m14691(android.content.Context r2) {
        /*
            boolean r0 = m14683(r2)
            if (r0 == 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            boolean r0 = com.netflix.mediaclient.util.ConnectivityUtils.m2952(r2)
            if (r0 != 0) goto L_0x0010
            r0 = 0
            return r0
        L_0x0010:
            boolean r0 = m14681(r2)
            if (r0 == 0) goto L_0x0018
            r0 = 1
            return r0
        L_0x0018:
            int r1 = m14684(r2)
            com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment$ManualBwChoice r0 = com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment.ManualBwChoice.UNLIMITED
            int r0 = r0.m1601()
            if (r0 == r1) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0577.m14691(android.content.Context):boolean");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m14686(Context context, BwCap bwCap, StreamProfileType streamProfileType) {
        int i;
        if (m14691(context)) {
            int r4 = m14685(context, bwCap);
            i = r4 > 0 ? r4 : 20000;
        } else {
            i = 20000;
        }
        if (C1317As.m3758() < 19 || C1909jj.m8008()) {
            return i;
        }
        return Math.min(20000, f13844);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m14678(Context context) {
        return ConnectivityUtils.m2952(context) && m14692(context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int m14680(BwCap bwCap) {
        return (bwCap == null || bwCap.getLow() <= 0) ? StreamProfileData.Companion.getDEFAULT_MANUAL_VIDEO_BITRATE_LOW() : bwCap.getLow();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int m14687(BwCap bwCap) {
        return (bwCap == null || bwCap.getAuto() <= 0) ? StreamProfileData.Companion.getDEFAULT_CELLULAR_AUTO_KBPS() : bwCap.getAuto();
    }
}
