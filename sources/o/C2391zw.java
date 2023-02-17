package o;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.offline.agent.OfflineUnavailableReason;
import o.C1350Bw;
/* renamed from: o.zw  reason: case insensitive filesystem */
class C2391zw {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f13010 = 0;

    C2391zw() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static void m13836(zC zCVar, C2059ph phVar) {
        C1283.m16862("nf_dl_diagnostics", "showDialog");
        if (!C1317As.m3750(zCVar) && !phVar.m9824()) {
            AbstractC1221 r2 = phVar.m9827();
            OfflineUnavailableReason r3 = r2 != null ? r2.mo16555() : null;
            C1350Bw.If r4 = C1350Bw.m4131(zCVar);
            if (r4 == null || r4.mExternalStorageInfoList == null || r4.mExternalStorageInfoList.size() == 0) {
                m13835(zCVar, m13832(OfflineUnavailableReason.NA_NO_EXTERNAL_STORAGE, zCVar));
            } else if (r4 != null && r4.m4132(zCVar)) {
                m13829(zCVar, m13832(OfflineUnavailableReason.NA_OFFLINE_STORAGE_NOT_AVAILABLE, zCVar));
            } else if (r3 != null) {
                m13833(zCVar, m13832(r3, zCVar));
            } else if (m13831(zCVar)) {
                m13828((Activity) zCVar, m13832(OfflineUnavailableReason.NA_MSL_CLIENT_DISABLED, zCVar));
            } else {
                m13830(zCVar, m13832(OfflineUnavailableReason.NA_WIDE_VINE_UNRECOVERABLE, zCVar));
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m13835(zC zCVar, String str) {
        m13834((Activity) zCVar, str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m13829(final zC zCVar, String str) {
        new AlertDialog.Builder(zCVar).setMessage(str).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.zw.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!C1317As.m3750(zCVar)) {
                    zCVar.m14000();
                    dialogInterface.dismiss();
                }
            }
        }).setNegativeButton(R.string.label_cancel, new DialogInterface.OnClickListener() { // from class: o.zw.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m13828(final Activity activity, String str) {
        new AlertDialog.Builder(activity).setMessage(str).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.zw.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!C1317As.m3750(activity)) {
                    AV.m3471(activity);
                    dialogInterface.dismiss();
                    AbstractApplicationC1258.getInstance().mo252(activity, "download diagnostics");
                }
            }
        }).setNegativeButton(R.string.label_cancel, new DialogInterface.OnClickListener() { // from class: o.zw.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m13830(Activity activity, String str) {
        m13834(activity, str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m13833(Activity activity, String str) {
        m13834(activity, str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m13831(NetflixActivity netflixActivity) {
        boolean r2 = C1339Bl.m4051(netflixActivity, "offline_ever_worked", false);
        C2059ph serviceManager = netflixActivity.getServiceManager();
        return r2 || AV.m3473(netflixActivity, serviceManager != null ? serviceManager.m9827() : null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m13834(Activity activity, String str) {
        new AlertDialog.Builder(activity).setMessage(str).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.zw.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m13832(OfflineUnavailableReason offlineUnavailableReason, Context context) {
        String format = String.format("(%s)", offlineUnavailableReason.m822());
        switch (offlineUnavailableReason) {
            case NA_OFFLINE_STORAGE_NOT_AVAILABLE:
                return context.getString(R.string.offline_storage_permission_problem, format);
            case NA_MSL_CLIENT_DISABLED:
                return context.getString(R.string.offline_widevine_disabled_recoverable, format);
            case NA_DISABLED_FROM_END_POINT:
                return context.getString(R.string.offline_disabled_generic, format);
            case NA_WIDE_VINE_UNRECOVERABLE:
                return context.getString(R.string.offline_widevine_disabled_non_recoverable, format);
            case NA_NO_EXTERNAL_STORAGE:
                return context.getString(R.string.offline_disabled_external_storage_missing, format);
            case NA_DISABLED_BY_SYSTEM_ID_4266:
            case NA_DISABLED_BY_SYSTEM_ID_4266_FROM_SERVER:
                return context.getString(R.string.offline_widevine_disabled_non_recoverable, format);
            default:
                return "";
        }
    }
}
