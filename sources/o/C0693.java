package o;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
/* renamed from: o.ล  reason: contains not printable characters */
public class C0693 {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m14983(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return false;
        }
        if ("http".equalsIgnoreCase(intent.getData().getScheme()) || "https".equalsIgnoreCase(intent.getData().getScheme())) {
            return "www.netflix.com".equalsIgnoreCase(intent.getData().getAuthority());
        }
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m14982(Activity activity, Intent intent) {
        boolean z = true;
        List<String> r2 = m14986(intent.getData());
        AbstractC0695 r4 = m14985(r2, C1330Bc.m4009(intent.getData()));
        if (r4 != null) {
            z = !r4.mo14971(r2);
        }
        if (z) {
            C0808.m15370(activity, intent.getData());
            activity.finish();
        }
        return z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static NflxHandler.Response m14984(NetflixActivity netflixActivity, Intent intent) {
        Uri data = intent.getData();
        String stringExtra = intent.getStringExtra(NetflixActivity.EXTRA_SOURCE);
        List<String> r6 = m14986(data);
        Map<String, String> r7 = C1330Bc.m4009(data);
        if (C1349Bv.m4107(stringExtra)) {
            r7.put(NetflixActivity.EXTRA_SOURCE, stringExtra);
        }
        AbstractC0695 r8 = m14985(r6, r7);
        C1276.m16820().mo5728("uri: " + (data == null ? "null" : data.toString()));
        if (r8 == null) {
            C1283.m16865("NetflixComHandlerFactory", "Got null creator for data: " + data.toString() + ". Redirecting user to browser.");
        } else {
            NflxHandler.Response r9 = r8.mo14972(netflixActivity, r6, C0808.m15366(data));
            if (r9 == NflxHandler.Response.NOT_HANDLING) {
                C1276.m16820().mo5727("SPY-7518 - couldn't handle the following data: " + data.toString());
            } else {
                Logger.INSTANCE.m127(new C0711(1.0f, data.toString()));
                C1364Cj.m4443(UIViewLogging.UIViewCommandName.deepLink, IClientLogging.ModalView.homeScreen, null, data.toString());
                sE.m10528(netflixActivity, intent);
                return r9;
            }
        }
        C0808.m15370(netflixActivity, data);
        return NflxHandler.Response.HANDLING;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static List<String> m14986(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 1 || !Pattern.compile("^[a-zA-Z]{2}(?:-[a-zA-Z]{2}){0,1}(?:-[a-zA-Z]{2})?$").matcher(pathSegments.get(0)).matches()) {
            return pathSegments;
        }
        return pathSegments.subList(1, pathSegments.size());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static AbstractC0695 m14985(List<String> list, Map<String, String> map) {
        String str = list.size() > 0 ? list.get(0) : "";
        if ("title".equals(str) && map.containsKey("fromWatch") && map.get("fromWatch").equals("true")) {
            str = "watch";
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2120335645:
                if (str.equals("mobilehelp")) {
                    c = '\f';
                    break;
                }
                break;
            case -1380604278:
                if (str.equals("browse")) {
                    c = 6;
                    break;
                }
                break;
            case -1002263574:
                if (str.equals("profiles")) {
                    c = 11;
                    break;
                }
                break;
            case -906336856:
                if (str.equals("search")) {
                    c = '\t';
                    break;
                }
                break;
            case 0:
                if (str.equals("")) {
                    c = 0;
                    break;
                }
                break;
            case 96417:
                if (str.equals("add")) {
                    c = 7;
                    break;
                }
                break;
            case 2338445:
                if (str.equals("Kids")) {
                    c = 3;
                    break;
                }
                break;
            case 3321751:
                if (str.equals("like")) {
                    c = '\r';
                    break;
                }
                break;
            case 3545755:
                if (str.equals("sync")) {
                    c = '\n';
                    break;
                }
                break;
            case 73596745:
                if (str.equals("Login")) {
                    c = 1;
                    break;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    c = 2;
                    break;
                }
                break;
            case 112903375:
                if (str.equals("watch")) {
                    c = 4;
                    break;
                }
                break;
            case 595233003:
                if (str.equals("notification")) {
                    c = 15;
                    break;
                }
                break;
            case 1427818632:
                if (str.equals("download")) {
                    c = '\b';
                    break;
                }
                break;
            case 1671642405:
                if (str.equals("dislike")) {
                    c = 14;
                    break;
                }
                break;
            case 2074637936:
                if (str.equals("nmwatch")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new C0705();
            case 1:
                return new C0718();
            case 2:
                return new C0805();
            case 3:
                return new C0799();
            case 4:
            case 5:
                return new C0800(C0808.m15365(map), C0808.m15372(map));
            case 6:
                return new C0688();
            case 7:
                return new C0689();
            case '\b':
                return new C0702();
            case '\t':
                return new C0804();
            case '\n':
                return new C0809();
            case 11:
                return new C0759();
            case '\f':
                return new C0712();
            case '\r':
                return new C0755(DetailsActivity.Action.Like);
            case 14:
                return new C0755(DetailsActivity.Action.Dislike);
            case 15:
                return new C0776();
            default:
                String str2 = "SPY-7518 - got unsupported suffix: " + str;
                C1283.m16850("NetflixComHandlerFactory", str2);
                C1276.m16820().mo5727(str2);
                return null;
        }
    }
}
