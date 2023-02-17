package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import com.netflix.mediaclient.servicemgr.interface_.offline.WatchState;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.ui.offline.OfflineAdapterData;
import com.netflix.mediaclient.ui.offline.StorageSwitchHelper;
import com.netflix.mediaclient.ui.player.PlanChoice;
import com.netflix.mediaclient.util.ConnectivityUtils;
import org.json.JSONObject;
public class vN extends AbstractC0496 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private oX f11197;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final DialogInterface.OnClickListener f11198 = new DialogInterface.OnClickListener() { // from class: o.vN.2
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            NetflixActivity r3 = vN.this.m14476();
            if (!C1317As.m3750(r3)) {
                if (ConnectivityUtils.m2954(r3)) {
                    AbstractC1853hl r4 = vN.this.m11980();
                    if (r4 != null) {
                        r4.mo7134(vN.this.m12007(), vN.this.m12008(), vN.this.m12001());
                    }
                } else {
                    C1004.m15958(r3, (int) R.string.offline_message_no_network_title, 0);
                }
            }
            dialogInterface.dismiss();
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f11199;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final DialogInterface.OnClickListener f11200 = new DialogInterface.OnClickListener() { // from class: o.vN.7
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            NetflixActivity r1 = vN.this.m14476();
            if (!C1317As.m3750(r1)) {
                r1.startActivity(vH.m11936(vN.this.m14476()));
            }
            dialogInterface.dismiss();
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f11201;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final DialogInterface.OnClickListener f11202 = new DialogInterface.OnClickListener() { // from class: o.vN.3
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            NetflixActivity r2 = vN.this.m14476();
            if (!C1317As.m3750(r2)) {
                if (ConnectivityUtils.m2954(r2)) {
                    AbstractC1853hl r3 = vN.this.m11980();
                    if (r3 != null) {
                        r3.mo7128(vN.this.m12007());
                    } else {
                        C1283.m16862("offlineErrorDialog", "downloadResumeAction offlineAgent is null");
                    }
                } else {
                    C1004.m15958(r2, (int) R.string.offline_message_no_network_title, 0);
                }
            }
            dialogInterface.dismiss();
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private final DialogInterface.OnClickListener f11203 = new DialogInterface.OnClickListener() { // from class: o.vN.9
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            NetflixActivity r3 = vN.this.m14476();
            if (!C1317As.m3750(r3)) {
                if (ConnectivityUtils.m2954(r3)) {
                    AbstractC1853hl r4 = vN.this.m11980();
                    if (r4 != null) {
                        r4.mo7121(vN.this.m12007(), vN.this.m12008(), vN.this.m12001());
                    }
                } else {
                    C1004.m15958(r3, (int) R.string.offline_message_no_network_title, 0);
                }
            }
            dialogInterface.dismiss();
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    private final DialogInterface.OnClickListener f11204 = new DialogInterface.OnClickListener() { // from class: o.vN.10
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            NetflixActivity r2 = vN.this.m14476();
            if (!C1317As.m3750(r2)) {
                vN.this.dismissAllowingStateLoss();
                r2.getSupportFragmentManager().executePendingTransactions();
                JSONObject r3 = vN.this.m11990(r2);
                if (r3 != null) {
                    vV r4 = vV.f11264.m12078(r3, vN.this.m12001());
                    r4.onManagerReady(vN.this.m14474(), AbstractC0367.f13235);
                    r4.setCancelable(true);
                    r2.showDialog(r4);
                }
            }
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private StopReason f11205;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f11206 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f11207;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private DownloadState f11208;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f11209 = false;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f11210 = "";

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private AbstractC1853hl f11211;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final DialogInterface.OnClickListener f11212 = new DialogInterface.OnClickListener() { // from class: o.vN.4
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private WatchState f11213;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final DialogInterface.OnClickListener f11214 = new DialogInterface.OnClickListener() { // from class: o.vN.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractC1853hl r2 = vN.this.m11980();
            if (r2 != null) {
                r2.mo7140(vN.this.m12007());
                DownloadButton.m2159(vN.this.m12007());
            } else {
                C1283.m16862("offlineErrorDialog", "deleteAction offlineAgent is null");
            }
            dialogInterface.dismiss();
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    private VideoType f11215;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f11216 = AbstractC0367.f13235.mo302().m271();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static vN m11997(VideoType videoType, pV pVVar, AbstractC1853hl hlVar) {
        return m11998(videoType, pVVar, hlVar, pVVar.mo6885());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static vN m11998(VideoType videoType, pV pVVar, AbstractC1853hl hlVar, Status status) {
        vN vNVar = new vN();
        Bundle bundle = new Bundle();
        bundle.putString("playableId", pVVar.mo6915());
        bundle.putString("videoType", videoType.toString());
        bundle.putInt("watchState", pVVar.mo6912().m1585());
        bundle.putInt("downloadState", pVVar.mo6881().m1577());
        bundle.putString("oxid", pVVar.mo6913());
        bundle.putString("dxid", pVVar.mo6882());
        bundle.putBundle("status_bundle", m11985(status));
        StopReason r4 = pVVar.mo6911();
        bundle.putInt("stopReason", r4 != null ? r4.m1583() : StopReason.Unknown.m1583());
        bundle.putBoolean("hasNetflixDownloadedData", m12000(hlVar));
        bundle.putBoolean("requiresWiFiConnection", hlVar.mo7131());
        vNVar.setArguments(bundle);
        return vNVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Bundle m11985(Status status) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status_is_error_or_warning", status.mo296());
        bundle.putBoolean("status_show_message", status.mo306());
        bundle.putString("status_displayable_message", status.mo307());
        bundle.putInt("status_code_int_value", status.mo302().m271());
        return bundle;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11994(Bundle bundle) {
        if (bundle != null) {
            this.f11209 = bundle.getBoolean("status_is_error_or_warning", false);
            this.f11206 = bundle.getBoolean("status_show_message", false);
            this.f11210 = bundle.getString("status_displayable_message", "");
            this.f11216 = bundle.getInt("status_code_int_value", AbstractC0367.f13235.mo302().m271());
            return;
        }
        this.f11209 = false;
        this.f11206 = false;
        this.f11210 = "";
        this.f11216 = AbstractC0367.f13235.mo302().m271();
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f11207 = arguments.getString("playableId");
        this.f11215 = VideoType.valueOf(arguments.getString("videoType"));
        this.f11213 = WatchState.m1584(arguments.getInt("watchState"));
        this.f11208 = DownloadState.m1576(arguments.getInt("downloadState"));
        this.f11205 = StopReason.m1580(arguments.getInt("stopReason"));
        this.f11201 = arguments.getString("oxid");
        this.f11199 = arguments.getString("dxid");
        m11994(arguments.getBundle("status_bundle"));
        boolean z = arguments.getBoolean("hasNetflixDownloadedData", false);
        boolean z2 = arguments.getBoolean("requiresWiFiConnection", true);
        if (this.f11207 == null || this.f11215 == null || this.f11215 == VideoType.UNKNOWN) {
            return m11987();
        }
        String str = "";
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        switch (this.f11208) {
            case Unknown:
                z5 = true;
                break;
            case Creating:
                z5 = true;
                break;
            case InProgress:
                z5 = true;
                break;
            case Stopped:
                str = BF.m3844(BF.m3846(this.f11205));
                switch (this.f11205) {
                    case Unknown:
                        z5 = true;
                        break;
                    case WaitingToBeStarted:
                        z5 = true;
                        break;
                    case NetworkError:
                        z3 = true;
                        z4 = true;
                        break;
                    case StorageError:
                        z3 = true;
                        z4 = true;
                        break;
                    case NotEnoughSpace:
                        return m11995(z);
                    case StoppedFromAgentAPI:
                        z5 = true;
                        break;
                    case NotAllowedOnCurrentNetwork:
                        if (z2) {
                            return vD.m11894(m14476(), m12007(), this.f11215, true);
                        }
                        return vD.m11895(m14476(), m12007(), true);
                    case NoNetworkConnectivity:
                        return vD.m11895(m14476(), m12007(), true);
                    case PlayerStreaming:
                        z5 = true;
                        break;
                    case AccountInActive:
                    case EncodesRevoked:
                        break;
                    case EncodesAreNotAvailableAnyMore:
                    case ManifestError:
                    case GeoCheckError:
                    case DownloadLimitRequiresManualResume:
                        z3 = true;
                        z4 = true;
                        break;
                    default:
                        z3 = true;
                        z4 = true;
                        C1276.m16820().mo5725("OfflineErrorDialog unhandled stopReason" + this.f11205);
                        break;
                }
            case Complete:
                str = BF.m3844(BF.m3847(this.f11213));
                switch (this.f11213) {
                    case NOT_WATCHABLE_DUE_TO_NOT_ENOUGH_DATA:
                        z5 = true;
                        break;
                    case WATCHING_ALLOWED:
                        z5 = true;
                        break;
                    case LICENSE_EXPIRED:
                        if (this.f11209 && (this.f11216 == StatusCode.DL_LIMIT_CANT_DOWNLOAD_TILL_DATE.m271() || this.f11216 == StatusCode.DL_ENCODES_DELETE_ON_REVOCATION.m271())) {
                            C1283.m16863("offlineErrorDialog", "mErrorStatusCodeIntValue=%d", Integer.valueOf(this.f11216));
                            break;
                        } else {
                            return m11983();
                        }
                    case PLAY_WINDOW_EXPIRED_BUT_RENEWABLE:
                        return m11981();
                    case PLAY_WINDOW_EXPIRED_FINAL:
                        return m12011();
                    case VIEW_WINDOW_EXPIRED:
                        return m11991();
                    case GEO_BLOCKED:
                        return m11978();
                    default:
                        z3 = true;
                        z4 = true;
                        C1276.m16820().mo5725("OfflineErrorDialog unhandled watchState" + this.f11213);
                        break;
                }
            case Deleted:
                z5 = true;
                break;
            case DeleteComplete:
                z5 = true;
                break;
            case CreateFailed:
                break;
            default:
                C1276.m16820().mo5725("OfflineErrorDialog unhandled downloadState" + this.f11208);
                break;
        }
        if (z5) {
            m12010();
            return m11987();
        } else if (this.f11209) {
            return m11988(z);
        } else {
            return m12003(str, z3, z4);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m12010() {
        NetflixActivity r1 = m14476();
        if (!C1317As.m3750(r1)) {
            r1.requestDownloadButtonRefresh(m12007());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m12000(AbstractC1853hl hlVar) {
        vM r2 = vO.m12029(hlVar);
        long j = 0;
        for (int i = 0; i < r2.mo4074(); i++) {
            OfflineAdapterData.ViewType viewType = ((OfflineAdapterData) r2.mo4075(i)).m2192().f3356;
            if (viewType == OfflineAdapterData.ViewType.SHOW || viewType == OfflineAdapterData.ViewType.MOVIE) {
                j += r2.mo11968(i);
            }
        }
        return j > 50000000;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private Dialog m11983() {
        C1283.m16862("offlineErrorDialog", "createLicenseExpiredDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.offline_message_expired_offline_title);
        builder.setNegativeButton(m12002(), this.f11214);
        if (ConnectivityUtils.m2954(m14476())) {
            builder.setMessage(R.string.offline_message_expired_to_renew_description_online);
            builder.setPositiveButton(R.string.offline_action_renew_download, new DialogInterface.OnClickListener() { // from class: o.vN.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AbstractC1853hl r1 = vN.this.m11980();
                    if (r1 != null) {
                        r1.mo7133(vN.this.m12007());
                    }
                    dialogInterface.dismiss();
                }
            });
        } else {
            builder.setMessage(R.string.offline_message_expired_to_renew_description);
            builder.setPositiveButton(R.string.offline_action_renew_later, this.f11212);
        }
        return builder.create();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Dialog m12003(String str, boolean z, boolean z2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.offline_message_download_generic_error_title).setMessage(m14476().getString(R.string.offline_message_download_generic_error_description, new Object[]{str}));
        if (z) {
            builder.setNegativeButton(m12002(), this.f11214);
        }
        if (z2) {
            builder.setPositiveButton(R.string.offline_action_retry_download, this.f11202);
        }
        builder.setNeutralButton(R.string.label_ok, this.f11212);
        return builder.create();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private AlertDialog m11988(boolean z) {
        String str;
        PlanChoice r7;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (this.f11216 == StatusCode.DL_NOT_ENOUGH_FREE_SPACE.m271()) {
            return m11995(z);
        }
        if (this.f11206) {
            str = this.f11210;
        } else {
            String r6 = BF.m3844(BF.m3845(this.f11216));
            int i = R.string.offline_message_download_generic_error_description;
            if (StatusCode.m263(this.f11216)) {
                i = R.string.offline_message_download_network_error_description;
            }
            str = m14476().getString(i, new Object[]{r6});
        }
        builder.setMessage(str);
        if (this.f11216 == StatusCode.DL_LIMIT_CANT_DOWNLOAD_TILL_DATE.m271()) {
            builder.setTitle(R.string.offline_message_download_limit_title).setPositiveButton(R.string.label_ok, this.f11214);
        } else if (this.f11216 == StatusCode.DL_LIMIT_TOO_MANY_DOWNLOADED_DELETE_SOME.m271()) {
            builder.setTitle(R.string.offline_message_download_limit_title).setPositiveButton(R.string.label_ok, this.f11212);
            if (m12006()) {
                builder.setNegativeButton(R.string.offline_action_my_downloads, this.f11200);
            }
        } else if (this.f11216 == StatusCode.DL_LIMIT_TOO_MANY_DEVICES_PLAN_OPTION.m271()) {
            JSONObject r62 = m11990(m14476());
            if (!(r62 == null || (r7 = vV.f11264.m12077(vV.f11264.m12079(r62))) == PlanChoice.f3470.m2387())) {
                builder.setMessage(getResources().getString(R.string.offline_message_device_limit_message_plan_choice, r7.m2377()));
                m12013(builder);
            }
            builder.setTitle(R.string.offline_message_device_limit_title).setNegativeButton(R.string.offline_action_retry_download, this.f11203).setNeutralButton(m12002(), this.f11214);
        } else if (this.f11216 == StatusCode.DL_WARNING_DL_N_TIMES_BEFORE_DATE.m271()) {
            builder.setNegativeButton(R.string.label_cancel, this.f11214).setPositiveButton(R.string.button_message_download, this.f11202);
        } else if (this.f11216 == StatusCode.DL_ENCODES_DELETE_ON_REVOCATION.m271()) {
            builder.setTitle(R.string.offline_message_no_available_title).setMessage(R.string.offline_message_expired_to_delete_description);
            builder.setPositiveButton(m12002(), this.f11214);
            builder.setNegativeButton(getString(R.string.offline_action_download_again), this.f11203);
        } else if (this.f11216 == StatusCode.DL_TOTAL_LICENSE_PER_DEVICE_LIMIT.m271()) {
            builder.setTitle(R.string.offline_message_download_limit_title).setMessage(R.string.offline_message_per_device_download_limit);
            builder.setPositiveButton(R.string.label_ok, this.f11214);
            builder.setNegativeButton(R.string.offline_action_my_downloads, this.f11200);
        } else {
            builder.setTitle(R.string.offline_message_download_generic_error_title).setMessage(str);
            builder.setNegativeButton(m12002(), this.f11214).setPositiveButton(R.string.offline_action_retry_download, this.f11203);
        }
        return builder.create();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12013(AlertDialog.Builder builder) {
        if (!BrowseExperience.m1780()) {
            builder.setPositiveButton(R.string.offline_action_upgrade_plan, this.f11204);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private AlertDialog m11981() {
        C1283.m16862("offlineErrorDialog", "createPlayWindowExpiredButRenewableDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.offline_message_expired_offline_title);
        builder.setNegativeButton(m12002(), this.f11214);
        if (ConnectivityUtils.m2954(m14476())) {
            builder.setMessage(R.string.offline_message_expired_to_renew_description_online);
            builder.setPositiveButton(R.string.offline_action_renew_download, new DialogInterface.OnClickListener() { // from class: o.vN.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AbstractC1853hl r2 = vN.this.m11980();
                    if (r2 != null) {
                        r2.mo7120(vN.this.m12007());
                    } else {
                        C1283.m16862("offlineErrorDialog", "createPlayWindowExpiredButRenewableDialog no offlineAgent");
                    }
                    dialogInterface.dismiss();
                }
            });
        } else {
            builder.setMessage(R.string.offline_message_expired_to_renew_description);
            builder.setPositiveButton(R.string.offline_action_renew_later, this.f11212);
        }
        return builder.create();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AlertDialog m12011() {
        C1283.m16862("offlineErrorDialog", "createPlayWindowFinalExpiredDialog");
        vK.m11964(m14476(), m12007(), this.f11201, this.f11199, WatchState.PLAY_WINDOW_EXPIRED_FINAL);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.offline_message_expired_offline_title).setMessage(R.string.offline_message_expired_to_delete_description).setPositiveButton(m12002(), this.f11214);
        return builder.create();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private AlertDialog m11978() {
        C1283.m16862("offlineErrorDialog", "createGeoNotPlayableDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.offline_message_no_available_title).setMessage(R.string.offline_message_no_available_geo_description).setNegativeButton(m12002(), this.f11214).setPositiveButton(R.string.label_ok, this.f11212);
        return builder.create();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private AlertDialog m11995(boolean z) {
        StorageSwitchHelper.StorageSwitchOption r3;
        AbstractC1853hl r2 = m11980();
        if (this.f11208 != DownloadState.CreateFailed || r2 == null || (r3 = StorageSwitchHelper.m2224(r2, m12007())) == StorageSwitchHelper.StorageSwitchOption.CAN_NOT_SWITCH) {
            return m11992(z);
        }
        return m12004(r3 == StorageSwitchHelper.StorageSwitchOption.SWITCH_TO_INTERNAL_STORAGE);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private AlertDialog m12004(boolean z) {
        String string = z ? m14476().getString(R.string.offline_message_internal_storage) : m14476().getString(R.string.offline_message_removable_storage);
        String string2 = z ? m14476().getString(R.string.offline_message_removable_storage) : m14476().getString(R.string.offline_message_internal_storage);
        AlertDialog.Builder title = new AlertDialog.Builder(m14476()).setTitle(R.string.offline_message_no_storage_title);
        title.setMessage(Html.fromHtml(m14476().getResources().getString(R.string.offline_message_switch_to_other_storage, string2, string))).setPositiveButton(R.string.label_cancel, this.f11214).setNegativeButton(R.string.label_switch_retry, this.f11198);
        return title.create();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private AlertDialog m11992(boolean z) {
        C1283.m16862("offlineErrorDialog", "createNotEnoughSpaceDialog");
        boolean r2 = m12006();
        boolean z2 = false;
        AlertDialog.Builder title = new AlertDialog.Builder(m14476()).setTitle(R.string.offline_message_no_storage_title);
        if (z) {
            title.setMessage(R.string.offline_message_no_storage_delete_description);
            if (r2) {
                z2 = true;
                title.setNegativeButton(R.string.offline_action_my_downloads, this.f11200);
            }
        } else {
            title.setMessage(R.string.offline_message_no_storage_description);
        }
        if (this.f11208 == DownloadState.CreateFailed) {
            title.setPositiveButton(R.string.label_ok, r2 ? this.f11214 : this.f11212);
            if (z2) {
                title.setNeutralButton(R.string.offline_action_retry_download, this.f11203);
            } else {
                title.setNegativeButton(R.string.offline_action_retry_download, this.f11203);
            }
        } else {
            title.setPositiveButton(R.string.label_ok, this.f11212);
            if (z2) {
                title.setNeutralButton(R.string.offline_action_retry_download, this.f11202);
            } else {
                title.setNegativeButton(R.string.offline_action_retry_download, this.f11202);
            }
        }
        return title.create();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean m12006() {
        return !(m14476() instanceof vH);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private Dialog m11991() {
        C1283.m16862("offlineErrorDialog", "createViewWindowExpiredDialog");
        vK.m11964(m14476(), m12007(), this.f11201, this.f11199, WatchState.VIEW_WINDOW_EXPIRED);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.offline_message_no_longer_available_description).setPositiveButton(m12002(), this.f11214);
        return builder.create();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Dialog m11987() {
        return new AlertDialog.Builder(m14476()).setTitle(R.string.offline_message_download_generic_error_title).setMessage(m14476().getResources().getString(R.string.offline_message_download_generic_error_description, "")).setNegativeButton(R.string.label_ok, this.f11212).create();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private int m12002() {
        return this.f11208 == DownloadState.Complete ? R.string.offline_action_delete_download : R.string.offline_action_cancel_download;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private oX m12001() {
        if (this.f11197 == null) {
            if (m14476() instanceof qK) {
                this.f11197 = ((qK) m14476()).mo1635();
            }
            if (this.f11197 == null) {
                this.f11197 = new oB("offlineErrorDialog");
            }
        }
        return this.f11197;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    private VideoType m12008() {
        return this.f11215;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    private String m12007() {
        return this.f11207;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private AbstractC1853hl m11980() {
        C2059ph r1;
        if (this.f11211 == null && (r1 = m14474()) != null) {
            this.f11211 = r1.m9832();
        }
        return this.f11211;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private JSONObject m11990(NetflixActivity netflixActivity) {
        pV r3;
        AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(netflixActivity);
        if (offlineAgentOrNull == null || (r3 = vO.m12029(offlineAgentOrNull).mo11976(this.f11207)) == null) {
            return null;
        }
        Status r4 = r3.mo6885();
        if (r4 instanceof BladerunnerErrorStatus) {
            return ((BladerunnerErrorStatus) r4).m967();
        }
        return null;
    }
}
