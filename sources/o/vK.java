package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.logblob.LogBlobType;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.LogArguments;
import com.netflix.mediaclient.servicemgr.Logblob;
import com.netflix.mediaclient.servicemgr.interface_.offline.WatchState;
import org.json.JSONException;
public class vK extends AbstractC1607ca {
    private vK(Logblob.Severity severity, String str, String str2, String str3, String str4, String str5) {
        super(str2, str3);
        this.f6135 = severity;
        this.f6134.put("level", LogArguments.LogLevel.ERROR.m1554());
        if (C1349Bv.m4107(str)) {
            this.f6134.put("mid", str);
        }
        if (C1349Bv.m4107(str4)) {
            this.f6134.put("errorcode", str4);
        }
        if (C1349Bv.m4107(str5)) {
            this.f6134.put("errormsg", str5);
        }
    }

    @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˏ */
    public boolean mo1556() {
        return true;
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return LogBlobType.OFFLINE_LOGBLOB_TYPE.m602();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m11964(NetflixActivity netflixActivity, String str, String str2, String str3, WatchState watchState) {
        C2059ph r7;
        IClientLogging r8;
        oQ r9;
        if (!C1317As.m3750(netflixActivity) && (r7 = C2059ph.m9741(netflixActivity)) != null && (r8 = r7.m9825()) != null && (r9 = r8.mo1512()) != null) {
            try {
                r9.mo5226(new vK(Logblob.Severity.error, str, str2, str3, BF.m3847(watchState), "offlineWatchError"));
            } catch (JSONException e) {
                C1283.m16847("offlineDialogLogblob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16847("offlineDialogLogblob", "Exception:", e2);
            }
        }
    }
}
