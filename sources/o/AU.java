package o;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.media.MediaRouter;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.gms.cast.CastDevice;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import o.DialogC2233vc;
public final class AU {

    public interface If {
        /* renamed from: ʻॱ  reason: contains not printable characters */
        long mo3429();

        @Override // o.qK
        /* renamed from: ʼ */
        oX mo1635();

        /* renamed from: ʼॱ  reason: contains not printable characters */
        void mo3430();

        /* renamed from: ʽॱ  reason: contains not printable characters */
        boolean mo3431();

        /* renamed from: ʾ  reason: contains not printable characters */
        VideoType mo3432();

        /* renamed from: ˈ  reason: contains not printable characters */
        void mo3433();

        /* renamed from: ॱˋ  reason: contains not printable characters */
        uW mo3434();

        /* renamed from: ॱˎ  reason: contains not printable characters */
        boolean mo3435();

        /* renamed from: ॱᐝ  reason: contains not printable characters */
        pF mo3436();

        /* renamed from: ᐝॱ  reason: contains not printable characters */
        C2240vj mo3437();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m3427(SeekBar seekBar) {
        int progress = seekBar.getProgress();
        int i = (progress / 10) * 10;
        int max = seekBar.getMax();
        if (i + 10 >= max && max > 0) {
            C1283.m16854("MdxUtils", "seek to close to EOS, defaulting to 10 seconds before EOS.");
            i = max - 10;
        }
        if (i == progress) {
            C1283.m16851("MdxUtils", "Right on target, no need to adjust seekBar position %d [sec]", Integer.valueOf(progress));
        } else {
            C1283.m16851("MdxUtils", "Progress : %d  [sec] vs. bif position %d [sec]", Integer.valueOf(progress), Integer.valueOf(i));
            seekBar.setProgress(i);
        }
        return i;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3420(oG oGVar, String str) {
        if (oGVar == null) {
            C1283.m16865("MdxUtils", "MDX agent is null - isSameVideoPlaying returning false");
            return false;
        } else if (oGVar.mo6183() == null) {
            C1283.m16865("MdxUtils", "Video detail is null - isSameVideoPlaying returning false");
            return false;
        } else {
            pF playable = oGVar.mo6183().getPlayable();
            if (playable == null || playable.getPlayableId() == null || !playable.getPlayableId().equals(str)) {
                C1283.m16854("MdxUtils", "Video is not currently playing or different video, start play if play is not already pending...");
                return false;
            }
            C1283.m16854("MdxUtils", "Same video is playing, just sync...");
            return true;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3423(C2059ph phVar) {
        if (phVar != null && phVar.mo9519() && phVar.m9811() != null && phVar.m9811().r_()) {
            return m3421(phVar, phVar.m9811().mo6171());
        }
        C1283.m16854("MdxUtils", "MDX service is NOT ready");
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3428(C2059ph phVar) {
        C1283.m16854("MdxUtils", "isTargetReadyToControl");
        if (!m3423(phVar)) {
            return false;
        }
        C1283.m16854("MdxUtils", "isTargetReadyToControl check is launched");
        return phVar.m9811().mo6190();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3421(C2059ph phVar, String str) {
        if (C1349Bv.m4113(str)) {
            C1283.m16854("MdxUtils", "uuid is empty");
            return false;
        } else if (phVar == null || !phVar.mo9519() || phVar.m9811() == null || !phVar.m9811().r_()) {
            C1283.m16854("MdxUtils", "MDX service is NOT ready");
            return false;
        } else {
            Pair<String, String>[] r2 = phVar.m9811().mo6163();
            if (r2 == null || r2.length < 1) {
                C1283.m16865("MdxUtils", "No MDX remote targets found");
                return false;
            }
            for (Pair<String, String> pair : r2) {
                if (str.equals(pair.first)) {
                    C1283.m16854("MdxUtils", "Target found");
                    return true;
                }
            }
            C1283.m16865("MdxUtils", "Target NOT found!");
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static AlertDialog m3422(NetflixActivity netflixActivity, If r4) {
        if (netflixActivity == null || C1317As.m3750(netflixActivity)) {
            C1283.m16865("MdxUtils", "Activity is not valid. Skipping MDX menu dialog");
            return null;
        } else if (m3428(netflixActivity.getServiceManager())) {
            return m3417(netflixActivity, r4);
        } else {
            return m3424(netflixActivity, r4);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static AlertDialog m3424(final NetflixActivity netflixActivity, final If r10) {
        if (netflixActivity == null || r10 == null || C1317As.m3750(netflixActivity)) {
            C1283.m16865("MdxUtils", "Activity is not valid or MdxFrag is null. Skipping MDX target selection dialog");
            return null;
        }
        final C2059ph serviceManager = netflixActivity.getServiceManager();
        final uW r5 = r10.mo3434();
        int r6 = r5.m11660(serviceManager.m9811().mo6171());
        r5.m11662(r6);
        DialogC2233vc.C0245 r7 = new DialogC2233vc.C0245(netflixActivity);
        r7.setCancelable(true);
        r7.setTitle(R.string.label_localMdxTargetWatch);
        r7.m12128(r5.m11661(netflixActivity));
        String str = "";
        if (r10.mo3436() != null && C1349Bv.m4107(r10.mo3436().getPlayableTitle())) {
            str = String.format(netflixActivity.getString(R.string.now_playing_title), r10.mo3436().getPlayableTitle());
        }
        r7.m12129(r6, str);
        r7.m12130(new AdapterView.OnItemClickListener() { // from class: o.AU.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C1283.m16854("MdxUtils", "Mdx target clicked: item with id " + j + ", on position " + i);
                netflixActivity.removeVisibleDialog();
                if (!serviceManager.mo9519()) {
                    C1283.m16865("MdxUtils", "Service not ready - bailing early");
                    return;
                }
                r5.m11662(i);
                uZ r8 = r5.m11665();
                if (r8 == null) {
                    C1283.m16850("MdxUtils", "Target is NULL, this should NOT happen!");
                } else if (r8.m11679()) {
                    if (r10.mo3431()) {
                        C1283.m16854("MdxUtils", "We were playing remotely - switching to playback locally");
                        serviceManager.m9811().mo6188(null, 0);
                        PlaybackLauncher.m1604(netflixActivity, r10.mo3436(), r10.mo3432(), r10.mo1635(), (int) (r10.mo3429() / 1000));
                        r10.mo3433();
                    } else {
                        C1283.m16854("MdxUtils", "Target is local. Remove current target from MDX agent.");
                        serviceManager.m9811().mo6180((String) null);
                    }
                } else if (!AU.m3421(serviceManager, r8.m11680())) {
                    C1283.m16865("MdxUtils", "Remote target is NOT available, stay and dismiss dialog");
                } else if (r10.mo3435() || r10.mo3431()) {
                    C2240vj r9 = r10.mo3437();
                    int i2 = 0;
                    if (r9 != null) {
                        i2 = r9.m12156();
                    } else {
                        C1283.m16850("MdxUtils", "Remote player is null. This should not happen!");
                    }
                    serviceManager.m9811().mo6188(r8.m11680(), i2);
                    r10.mo3430();
                } else {
                    serviceManager.m9811().mo6180(r8.m11680());
                }
                netflixActivity.setConnectingToTarget(true);
                netflixActivity.invalidateOptionsMenu();
            }
        });
        return r7.create();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static AlertDialog m3417(final NetflixActivity netflixActivity, If r14) {
        String str;
        String str2;
        if (netflixActivity == null || r14 == null || C1317As.m3750(netflixActivity)) {
            C1283.m16865("MdxUtils", "Activity is not valid or MdxFrag is null. Skipping MDX disconnect dialog");
            return null;
        }
        View inflate = netflixActivity.getLayoutInflater().inflate(R.layout.mdx_disconnect_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.mdx_dialog_title)).setText(C1298Aa.m3505(netflixActivity.getServiceManager()));
        TextView textView = (TextView) inflate.findViewById(R.id.mdx_dialog_message);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mdx_dialog_video_info);
        pF r11 = r14.mo3436();
        if (!r14.mo3431() || r11 == null) {
            str = netflixActivity.getResources().getString(R.string.mdx_disconnect_dialog_ready_cast);
            textView2.setVisibility(8);
        } else {
            str = netflixActivity.getResources().getString(R.string.now_playing_title, "");
            textView2.setVisibility(0);
            if (r11.isPlayableEpisode()) {
                str2 = netflixActivity.getResources().getString(R.string.mdx_disconnect_dialog_video_info, r11.getParentTitle(), r11.getSeasonAbbrSeqLabel(), Integer.valueOf(r11.getEpisodeNumber()), r11.getPlayableTitle());
            } else {
                str2 = r11.getPlayableTitle();
            }
            textView2.setText(str2);
        }
        textView.setText(str);
        AlertDialog create = new AlertDialog.Builder(netflixActivity).setPositiveButton(R.string.mdx_disconnect_dialog_button, new DialogInterface.OnClickListener() { // from class: o.AU.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                uU castPlayerFrag = netflixActivity.getCastPlayerFrag();
                oG r4 = netflixActivity.getServiceManager().m9811();
                if (castPlayerFrag != null && r4 != null) {
                    if (castPlayerFrag.mo3437() != null && castPlayerFrag.mo3437().m12165()) {
                        castPlayerFrag.mo3437().m12161(false);
                        r4.mo6188(null, 0);
                        castPlayerFrag.mo3433();
                    }
                    r4.mo6180((String) null);
                    AbstractC1712eY eYVar = (AbstractC1712eY) r4;
                    if (eYVar != null) {
                        eYVar.mo6189();
                    }
                    LocalBroadcastManager.getInstance(netflixActivity).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.UPDATE_CAPABILITIES_BADGES"));
                    netflixActivity.invalidateOptionsMenu();
                }
            }
        }).setView(inflate).setCancelable(true).create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3425() {
        return C1317As.m3758() >= 21;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3426(oG oGVar) {
        if (oGVar == null) {
            C1283.m16865("MdxUtils", "MDX agent is null inside isAnyMdxTargetAvailable()...returning false!");
            return false;
        } else if (!oGVar.r_()) {
            C1283.m16854("MdxUtils", "MDX service is NOT ready");
            return false;
        } else {
            Pair<String, String>[] r2 = oGVar.mo6163();
            if (r2 != null && r2.length >= 1) {
                return true;
            }
            C1283.m16854("MdxUtils", "No MDX remote targets found");
            return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3418(MediaRouter.RouteInfo routeInfo) {
        CastDevice fromBundle = CastDevice.getFromBundle(routeInfo.getExtras());
        if (fromBundle == null) {
            return null;
        }
        return fromBundle.getIpAddress().getHostAddress();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3419(String str) {
        int indexOf;
        int length;
        if (str != null && (indexOf = str.indexOf("CastMediaRouteProviderService:")) >= 0 && str.length() > (length = indexOf + "CastMediaRouteProviderService:".length())) {
            return str.substring(length);
        }
        return null;
    }
}
