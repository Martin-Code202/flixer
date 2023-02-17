package o;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.widget.PopupMenu;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.util.ConnectivityUtils;
public class vD {
    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m11896(Context context) {
        return C1317As.m3755(context, vH.m11934()) != null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static PopupMenu m11884(final Context context, DownloadButton downloadButton, final String str, final VideoType videoType, boolean z, final oX oXVar) {
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(context, m11886(context)), downloadButton);
        popupMenu.inflate(R.menu.offline_download_button_menu);
        popupMenu.getMenu().findItem(R.id.play).setVisible(true);
        popupMenu.getMenu().findItem(R.id.delete).setVisible(true);
        popupMenu.getMenu().findItem(R.id.view_my_downloads).setVisible(z && !m11896(context));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: o.vD.3
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                AbstractC1853hl r5;
                if (menuItem.getItemId() == R.id.play) {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.StartCachedPlay, IClientLogging.ModalView.offlineShows, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    ActivityC2280wv wvVar = (ActivityC2280wv) C1322Av.m3791(context, ActivityC2280wv.class);
                    if (wvVar != null) {
                        wvVar.finish();
                    }
                    vO.m12025(context, str, videoType, oXVar);
                    return true;
                } else if (menuItem.getItemId() == R.id.delete) {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.RemoveCachedVideoCommand, IClientLogging.ModalView.removeCachedVideoButton, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
                    if (netflixActivity == null || (r5 = netflixActivity.getServiceManager().m9832()) == null) {
                        return true;
                    }
                    r5.mo7140(str);
                    DownloadButton.m2159(str);
                    return true;
                } else if (menuItem.getItemId() != R.id.view_my_downloads) {
                    return true;
                } else {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.ShowMyDownloads, IClientLogging.ModalView.myDownloads, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    Activity activity = (Activity) C1322Av.m3791(context, Activity.class);
                    if (activity == null) {
                        return true;
                    }
                    context.startActivity(vH.m11936(activity));
                    return true;
                }
            }
        });
        return popupMenu;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static PopupMenu m11892(final Context context, final DownloadButton downloadButton, final String str, boolean z) {
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(context, m11886(context)), downloadButton);
        popupMenu.inflate(R.menu.offline_download_button_menu);
        popupMenu.getMenu().findItem(R.id.pause).setVisible(true);
        popupMenu.getMenu().findItem(R.id.cancel).setVisible(true);
        popupMenu.getMenu().findItem(R.id.view_my_downloads).setVisible(!m11896(context) && z);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: o.vD.10
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                AbstractC1853hl r5;
                AbstractC1853hl r52;
                if (menuItem.getItemId() == R.id.pause) {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.PauseDownloadCommand, IClientLogging.ModalView.pauseDownloadButton, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
                    if (netflixActivity == null || (r52 = netflixActivity.getServiceManager().m9832()) == null) {
                        return true;
                    }
                    r52.mo7123(str);
                    downloadButton.m2168(DownloadButton.ButtonState.PAUSED, str);
                    return true;
                } else if (menuItem.getItemId() == R.id.cancel) {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.RemoveCachedVideoCommand, IClientLogging.ModalView.removeCachedVideoButton, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    NetflixActivity netflixActivity2 = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
                    if (netflixActivity2 == null || (r5 = netflixActivity2.getServiceManager().m9832()) == null) {
                        return true;
                    }
                    r5.mo7140(str);
                    DownloadButton.m2159(str);
                    return true;
                } else if (menuItem.getItemId() != R.id.view_my_downloads) {
                    return true;
                } else {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.ShowMyDownloads, IClientLogging.ModalView.myDownloads, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    Activity activity = (Activity) C1322Av.m3791(context, Activity.class);
                    if (activity == null) {
                        return true;
                    }
                    context.startActivity(vH.m11936(activity));
                    return true;
                }
            }
        });
        return popupMenu;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static PopupMenu m11893(final Context context, DownloadButton downloadButton, final String str, boolean z, boolean z2) {
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(context, m11886(context)), downloadButton);
        popupMenu.inflate(R.menu.offline_download_button_menu);
        popupMenu.getMenu().findItem(R.id.resume).setVisible(z2);
        popupMenu.getMenu().findItem(R.id.cancel).setVisible(true);
        popupMenu.getMenu().findItem(R.id.view_my_downloads).setVisible(z && !m11896(context));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: o.vD.8
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                AbstractC1853hl r5;
                if (menuItem.getItemId() == R.id.resume) {
                    NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
                    if (!ConnectivityUtils.m2964(context) || netflixActivity == null) {
                        vD.m11895(context, str, true).show();
                        return true;
                    }
                    AbstractC1853hl r52 = netflixActivity.getServiceManager().m9832();
                    if (r52 == null) {
                        return true;
                    }
                    boolean r6 = netflixActivity.getServiceManager().m9832().mo7131();
                    boolean z3 = ConnectivityUtils.m2952(context) && ConnectivityUtils.m2969(context) && !ConnectivityUtils.m2955(context);
                    if (!r6 || !z3) {
                        C1364Cj.m4434(UIViewLogging.UIViewCommandName.ResumeDownloadCommand, IClientLogging.ModalView.resumeDownloadButton, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                        r52.mo7128(str);
                        return true;
                    }
                    vD.m11894(context, str, C2093qn.m10096(str).getType(), true).show();
                    return true;
                } else if (menuItem.getItemId() == R.id.cancel) {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.RemoveCachedVideoCommand, IClientLogging.ModalView.removeCachedVideoButton, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    NetflixActivity netflixActivity2 = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
                    if (!(netflixActivity2 == null || (r5 = netflixActivity2.getServiceManager().m9832()) == null)) {
                        r5.mo7140(str);
                    }
                    DownloadButton.m2159(str);
                    return true;
                } else if (menuItem.getItemId() != R.id.view_my_downloads) {
                    return true;
                } else {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.ShowMyDownloads, IClientLogging.ModalView.myDownloads, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    Activity activity = (Activity) C1322Av.m3791(context, Activity.class);
                    if (activity == null) {
                        return true;
                    }
                    context.startActivity(vH.m11936(activity));
                    return true;
                }
            }
        });
        return popupMenu;
    }

    @SuppressLint({"PrivateResource"})
    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m11886(Context context) {
        return BrowseExperience.m1780() ? R.style.res_2131952200_theme_appcompat_light : R.style.res_2131952187_theme_appcompat;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static Dialog m11888(final Context context, boolean z) {
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle(R.string.offline_message_no_storage_title);
        if (z) {
            title.setMessage(R.string.offline_message_no_storage_delete_description).setNegativeButton(R.string.offline_action_my_downloads, new DialogInterface.OnClickListener() { // from class: o.vD.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.ShowMyDownloads, IClientLogging.ModalView.myDownloads, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    Activity activity = (Activity) C1322Av.m3791(context, Activity.class);
                    if (activity != null) {
                        context.startActivity(vH.m11936(activity));
                    }
                    dialogInterface.dismiss();
                }
            }).setPositiveButton(R.string.label_cancel, new DialogInterface.OnClickListener() { // from class: o.vD.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        } else {
            title.setMessage(R.string.offline_message_no_storage_description).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.vD.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
        return title.create();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Dialog m11895(final Context context, final String str, boolean z) {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(context).setTitle(R.string.offline_message_no_network_title).setMessage(R.string.offline_message_no_network_description).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.vD.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            positiveButton.setNegativeButton(R.string.offline_action_cancel_download, new DialogInterface.OnClickListener() { // from class: o.vD.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AbstractC1853hl r1 = vD.m11889(context);
                    if (r1 != null) {
                        r1.mo7140(str);
                        DownloadButton.m2159(str);
                    }
                    dialogInterface.dismiss();
                }
            });
        }
        return positiveButton.create();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Dialog m11894(final Context context, final String str, final VideoType videoType, boolean z) {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(context).setTitle(R.string.offline_message_no_wifi_title).setMessage(R.string.offline_message_no_wifi_description).setNeutralButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.vD.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(R.string.offline_action_download_settings, new DialogInterface.OnClickListener() { // from class: o.vD.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Activity activity = (Activity) C1322Av.m3791(context, Activity.class);
                if (activity != null) {
                    Intent r3 = zC.m13380(activity);
                    r3.putExtra(NetflixActivity.EXTRA_DL_PLAYABLE_ID, str);
                    r3.putExtra(NetflixActivity.EXTRA_DL_VIDEO_TYPE_STRING, videoType.getValue());
                    activity.startActivityForResult(r3, NetflixActivity.DL_REQUEST_CODE);
                }
                dialogInterface.dismiss();
            }
        });
        if (z) {
            positiveButton.setNegativeButton(R.string.offline_action_cancel_download, new DialogInterface.OnClickListener() { // from class: o.vD.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AbstractC1853hl r1 = vD.m11889(context);
                    if (r1 != null) {
                        r1.mo7140(str);
                        DownloadButton.m2159(str);
                    }
                    dialogInterface.dismiss();
                }
            });
        }
        return positiveButton.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static AbstractC1853hl m11889(Context context) {
        C2059ph r2;
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
        if (netflixActivity == null || (r2 = C2059ph.m9741(netflixActivity)) == null) {
            return null;
        }
        return r2.m9832();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static Dialog m11891(Context context, String str) {
        return new AlertDialog.Builder(context).setTitle(R.string.offline_message_download_generic_error_title).setMessage(context.getResources().getString(R.string.offline_message_download_generic_error_description, str)).setNegativeButton(R.string.label_cancel, new DialogInterface.OnClickListener() { // from class: o.vD.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Dialog m11887(Context context, final DialogInterface.OnClickListener onClickListener, String str) {
        String string = context.getResources().getString(R.string.offline_message_tap_delete_all_description, str);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new TextAppearanceSpan(context, R.style.res_2131952032_secondarytext_smallmedium), 0, string.length(), 33);
        return new AlertDialog.Builder(context).setTitle(R.string.offline_message_tap_delete_all_title).setMessage(spannableString).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.vD.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                onClickListener.onClick(dialogInterface, i);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(R.string.label_cancel, new DialogInterface.OnClickListener() { // from class: o.vD.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Dialog m11890(Context context) {
        return new AlertDialog.Builder(context).setMessage(R.string.offline_message_title_already_requested_for_download).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.vD.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
    }
}
