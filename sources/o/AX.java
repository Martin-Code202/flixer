package o;

import com.android.volley.VolleyError;
import com.netflix.mediaclient.service.msl.client.MslErrorException;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import java.io.IOException;
public final class AX {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3491(VolleyError volleyError) {
        DD r4;
        if (!(volleyError.getCause() instanceof IOException)) {
            return false;
        }
        IOException iOException = (IOException) volleyError.getCause();
        if (!(iOException.getCause() instanceof MslErrorException) || (r4 = ((MslErrorException) iOException.getCause()).m809()) == null || r4.m4592() != 205032) {
            return false;
        }
        m3488(r4);
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3490(DD dd) {
        if (dd == null) {
            return false;
        }
        m3488(dd);
        return dd.m4592() == 207007;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m3488(DD dd) {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static gV m3489(UserAgentInterface userAgentInterface, String str, gV gVVar, boolean z) {
        oR r4 = userAgentInterface.mo1364(str);
        if (r4 != null) {
            gVVar.m6619(r4);
        } else if (z) {
            C1283.m16855("nf_msl_utils", "MSLUserCredentialRegistry not found for profile %s, but request is marked as always deliver, use current credentials.", str);
        } else {
            C1283.m16855("nf_msl_utils", "MSLUserCredentialRegistry not found for profile %s, drop request", str);
            return null;
        }
        return gVVar;
    }
}
