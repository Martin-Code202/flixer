package o;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.util.log.UIScreen;
import o.DialogC1104;
/* renamed from: o.ɜ  reason: contains not printable characters */
public class C0368 {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m14087(Activity activity, Status status) {
        StatusCode r5 = status.mo302();
        C1283.m16846("ServiceErrorsHandler", "Handling manager response, code: " + r5 + " [" + activity.getClass().toString() + "]");
        switch (r5) {
            case OK:
                return false;
            case NON_RECOMMENDED_APP_VERSION:
                return m14082(activity, false);
            case NON_SUPPORTED_LOCALE:
                if (C1317As.m3758() > 18) {
                    C1283.m16851("ServiceErrorsHandler", "api version %d", 18);
                    return false;
                }
                C2059ph serviceManager = ((NetflixActivity) activity).getServiceManager();
                if (serviceManager == null) {
                    C1283.m16854("ServiceErrorsHandler", "nf_config_locale manager == null");
                    return false;
                } else if (!serviceManager.m9796() || C1349Bv.m4113(serviceManager.m9827().mo16525()) || C2020nx.m9370(activity)) {
                    return false;
                } else {
                    return m14084(activity, serviceManager.m9827().mo16525());
                }
            case OBSOLETE_APP_VERSION:
                return m14082(activity, true);
            case NO_CONNECTIVITY:
                m14080(activity, activity.getString(R.string.label_startup_nointernet));
                return true;
            case ESN_MIGRATION_NO_CONNECTIVITY:
                m14088(activity, activity.getString(R.string.label_startup_nointernet));
                return true;
            case DRM_FAILURE_CDM:
            case DRM_FAILURE_GOOGLE_CDM_PROVISIONG_DENIED:
                m14080(activity, activity.getString(R.string.label_drm_cdm_provisioning_failed));
                return true;
            case DRM_FAILURE_GOOGLE_DECLINED_PROVISIONING:
                m14080(activity, activity.getString(R.string.label_drm_google_declined_widevine_provisioning));
                return true;
            case HTTP_SSL_DATE_TIME_ERROR:
            case HTTP_SSL_ERROR:
            case HTTP_SSL_NO_VALID_CERT:
                m14080(activity, activity.getString(R.string.login_network_or_ssl_Error) + " (" + r5.m271() + ")");
                return true;
            case FATAL_CONFIG_DOWNLOAD_FAILED:
            case FATAL_ESN_BASED_CONFIG_DOWNLOAD_FAILED:
                C1283.m16850("ServiceErrorsHandler", "Configuration can not be downloaded on first app start!");
                m14081(activity, m14083(activity, r5), true);
                return true;
            case FATAL_CONFIG_BLACKLISTED:
                C1283.m16850("ServiceErrorsHandler", "Configuration blacklisted device. ");
                m14081(activity, m14085(activity, r5), true);
                return true;
            case MSL_LEGACY_CRYPTO:
            case MSL_BLACKLISTED_DEVICE_FATAL:
                m14086(activity);
                return true;
            case MSL_BLACKLISTED_DEVICE_FAILBACK:
                C1283.m16854("ServiceErrorsHandler", "Blacklisted device, failing back to Widevine L3, restart!");
                m14080(activity, activity.getString(R.string.label_drm_failed_restart_app, new Object[]{Integer.valueOf(status.mo302().m271())}));
                return true;
            case MSL_FAILED_TO_CREATE_CLIENT:
                m14088(activity, m14083(activity, r5));
                return true;
            case INIT_SERVICE_TIMEOUT:
                m14088(activity, m14079(activity, r5));
                return true;
            case MSL_LEGACY_CRYPTO_BUT_USED_WIDEVINE_BEFORE:
                C1283.m16854("ServiceErrorsHandler", "Handled by CryptoErrorManager...");
                return true;
            case NETWORK_ERROR:
            default:
                m14080(activity, m14083(activity, r5));
                return true;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String m14079(Activity activity, StatusCode statusCode) {
        if (BL.m3876(90000)) {
            C1283.m16865("ServiceErrorsHandler", "Widevine plugin is blocked");
            C1276.m16820().mo5727("Widevine plugin is blocked");
            return activity.getString(R.string.label_drm_failed_restart_device, new Object[]{Integer.valueOf(StatusCode.DRM_FAILURE_MEDIADRM_WIDEVINE_PLUGIN_BLOCKED.m271())});
        }
        C1283.m16865("ServiceErrorsHandler", "Widevine plugin is NOT blocked");
        return m14083(activity, statusCode);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m14083(Activity activity, StatusCode statusCode) {
        return activity.getString(R.string.nflx_connectivity_error) + " (" + statusCode.m271() + ")";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String m14085(Activity activity, StatusCode statusCode) {
        return activity.getString(R.string.config_blacklisted_error_msg) + " (" + statusCode.m271() + ")";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m14082(final Activity activity, boolean z) {
        DialogC1104.Cif ifVar = new DialogC1104.Cif(activity);
        ifVar.m16217("");
        if (z) {
            ifVar.m16215(R.string.label_mandatory_app_update_found);
        } else {
            int r3 = C1339Bl.m4037(activity, "nflx_update_skipped", 0);
            final int r5 = new C1252(activity).m16653();
            if (r3 == r5) {
                return false;
            }
            ifVar.m16215(R.string.label_app_update_found);
            ifVar.m16222(false);
            ifVar.m16216(R.string.label_cancel, new DialogInterface.OnClickListener() { // from class: o.ɜ.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C1339Bl.m4042((Context) activity, "nflx_update_skipped", r5);
                    activity.startActivity(ActivityC2187tq.m11247(activity, "ServiceErrorsHandler"));
                    activity.finish();
                }
            });
        }
        ifVar.m16221(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.ɜ.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C1283.m16862("ServiceErrorsHandler", "User clicked Ok on prompt to update");
                Intent r2 = C1325Ay.m3824(activity);
                if (r2 != null) {
                    r2.addFlags(268435456);
                    try {
                        activity.startActivity(r2);
                    } catch (ActivityNotFoundException e) {
                        C1283.m16847("ServiceErrorsHandler", "Failed to start store Activity!", e);
                    } finally {
                        activity.finish();
                    }
                }
            }
        });
        ifVar.m16220();
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m14080(final Activity activity, String str) {
        new AlertDialog.Builder(activity).setCancelable(false).setMessage(str).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.ɜ.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        }).show();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m14088(final Activity activity, String str) {
        new AlertDialog.Builder(activity).setCancelable(false).setMessage(str).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.ɜ.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C1317As.m3756(activity);
            }
        }).show();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m14081(final Activity activity, String str, final boolean z) {
        new AlertDialog.Builder(activity).setCancelable(false).setMessage(str).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.ɜ.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (z) {
                    C1283.m16854("ServiceErrorsHandler", "killing service");
                    C1317As.m3756(activity);
                    return;
                }
                activity.finish();
            }
        }).setNegativeButton(R.string.label_help, new DialogInterface.OnClickListener() { // from class: o.ɜ.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent r2 = ActivityC1313Ao.m3721(activity);
                UIScreen uiScreen = ((NetflixActivity) activity).getUiScreen();
                if (uiScreen != null) {
                    r2.putExtra(NetflixActivity.EXTRA_SOURCE, uiScreen.name());
                }
                r2.putExtra(NetflixActivity.EXTRA_ENTRY, CustomerServiceLogging.EntryPoint.errorDialog.name());
                activity.startActivity(r2);
            }
        }).show();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m14084(final Activity activity, String str) {
        SpannableString spannableString = new SpannableString(str);
        Linkify.addLinks(spannableString, 15);
        AlertDialog create = new AlertDialog.Builder(activity).setCancelable(false).setMessage(spannableString).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: o.ɜ.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (((NetflixActivity) activity).getServiceManager() != null) {
                    C2020nx.m9371(activity);
                    activity.startActivity(ActivityC2187tq.m11247(activity, "ServiceErrorsHandler"));
                    activity.finish();
                }
            }
        }).create();
        create.show();
        TextView textView = (TextView) create.findViewById(16908299);
        if (textView == null) {
            return true;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m14086(final Activity activity) {
        new AlertDialog.Builder(activity).setMessage(R.string.legacy_crypto_cs_page_msg).setPositiveButton(R.string.learn_how, new DialogInterface.OnClickListener() { // from class: o.ɜ.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://help.netflix.com/en/node/57688")));
                } catch (ActivityNotFoundException e) {
                    C1276.m16820().mo5730(e);
                }
                activity.finish();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: o.ɜ.10
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                activity.finish();
            }
        }).show();
    }
}
