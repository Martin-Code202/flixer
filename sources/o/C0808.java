package o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.launch.NetflixComLaunchActivity;
import java.util.Iterator;
import java.util.Map;
/* renamed from: o.ᒸ  reason: contains not printable characters */
public class C0808 {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m15373(NetflixActivity netflixActivity) {
        netflixActivity.startActivity(ActivityC2153sl.m10779(netflixActivity));
        netflixActivity.overridePendingTransition(0, 0);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m15367(NetflixActivity netflixActivity) {
        netflixActivity.startActivity(ActivityC2383zq.m13731(netflixActivity));
        netflixActivity.overridePendingTransition(0, 0);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m15371(NetflixActivity netflixActivity) {
        netflixActivity.startActivity(new Intent(netflixActivity, NetflixComLaunchActivity.class));
        netflixActivity.overridePendingTransition(0, 0);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m15368(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar) {
        Intent r2 = vH.m11932(netflixActivity);
        r2.putExtra(NetflixActivity.EXTRA_VIDEO_ID, pFVar.getPlayableId());
        r2.putExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE, videoType.getValue());
        r2.putExtra(NetflixActivity.EXTRA_PLAY_CONTEXT, oXVar);
        r2.addFlags(131072);
        netflixActivity.startActivity(r2);
        netflixActivity.overridePendingTransition(0, 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m15369(NetflixActivity netflixActivity) {
        Intent r2 = ActivityC1313Ao.m3721(netflixActivity);
        r2.addFlags(872415232);
        netflixActivity.startActivity(r2);
        netflixActivity.overridePendingTransition(0, 0);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m15370(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        ResolveInfo resolveActivity = activity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://google.com")), 65536);
        ActivityInfo activityInfo = null;
        ActivityInfo activityInfo2 = null;
        ActivityInfo activityInfo3 = null;
        Iterator<ResolveInfo> it = activity.getPackageManager().queryIntentActivities(intent, 64).iterator();
        while (true) {
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                if (next != null && next.activityInfo != null && next.activityInfo.packageName != null && next.activityInfo.name != null) {
                    if (resolveActivity != null && resolveActivity.activityInfo != null && next.activityInfo.name.equals(resolveActivity.activityInfo.name) && next.activityInfo.packageName.equals(resolveActivity.activityInfo.packageName)) {
                        activityInfo = next.activityInfo;
                        break;
                    } else if (next.activityInfo.packageName.contains("chrome")) {
                        activityInfo3 = next.activityInfo;
                    } else if (activityInfo2 == null && !next.activityInfo.packageName.contains("com.netflix")) {
                        activityInfo2 = next.activityInfo;
                    }
                } else {
                    C1283.m16865("NetflixComUtils", "Found a weird null activityInfo. Skipping...");
                }
            } else {
                break;
            }
        }
        if (activityInfo != null) {
            intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        } else if (activityInfo3 != null) {
            intent.setComponent(new ComponentName(activityInfo3.packageName, activityInfo3.name));
        } else if (activityInfo2 != null) {
            intent.setComponent(new ComponentName(activityInfo2.packageName, activityInfo2.name));
        } else {
            C1276.m16820().mo5725("Didn't find right activity to handle: " + uri);
        }
        C1283.m16849("NetflixComUtils", intent);
        intent.addFlags(268435456);
        activity.startActivity(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m15366(Uri uri) {
        String queryParameter = uri.getQueryParameter("trkid");
        if (C1349Bv.m4113(queryParameter)) {
            return uri.getQueryParameter("trkId");
        }
        return queryParameter;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m15365(Map<String, String> map) {
        String str = map.get("t");
        if (C1332Be.m4016(str)) {
            return C1332Be.m4015(str, -1).intValue();
        }
        return -1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m15372(Map<String, String> map) {
        return map.get("scene");
    }
}
