package o;

import android.util.Log;
import android.util.Pair;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.BaseStatus;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;
/* renamed from: o.Bp  reason: case insensitive filesystem */
public final class C1343Bp {
    /* renamed from: ॱ  reason: contains not printable characters */
    private static C0510 m4067(StatusCode statusCode, String str, boolean z, RootCause rootCause) {
        return m4061(statusCode, AK.m3383(new Pair[]{new Pair(DeepErrorElement.FATAL, String.valueOf(z)), new Pair("reason", str), new Pair(Error.ROOT_CAUSE, rootCause.name())}));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Error m4060(StatusCode statusCode, boolean z, RootCause rootCause, DeepErrorElement.Debug debug) {
        ArrayList arrayList = new ArrayList();
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        arrayList.add(deepErrorElement);
        deepErrorElement.setErrorCode("" + statusCode.m271());
        deepErrorElement.setFatal(z);
        deepErrorElement.setDebug(debug);
        return new Error(rootCause, arrayList);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Status m4059(StatusCode statusCode, String str, boolean z, RootCause rootCause) {
        NetflixStatus netflixStatus = new NetflixStatus(statusCode);
        DeepErrorElement.Debug debug = new DeepErrorElement.Debug();
        debug.setMessage(AK.m3390("reason", str));
        C0510 r3 = m4067(statusCode, str, false, rootCause);
        netflixStatus.m309(m4060(statusCode, z, rootCause, debug));
        netflixStatus.m310(r3);
        return netflixStatus;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0510 m4068(Status status) {
        if (status != null && (status instanceof BaseStatus)) {
            return ((BaseStatus) status).mo294();
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Error m4064(Status status) {
        if (status != null && (status instanceof BaseStatus)) {
            return ((BaseStatus) status).mo293();
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C0510 m4061(StatusCode statusCode, JSONObject jSONObject) {
        C0501 r2 = null;
        if (jSONObject != null) {
            r2 = new C0501(jSONObject);
        }
        if (statusCode == null) {
            statusCode = StatusCode.UNKNOWN;
        }
        switch (statusCode) {
            case OK:
            case NON_RECOMMENDED_APP_VERSION:
                C1283.m16854("StatusUtils", "Report success");
                return null;
            case NETWORK_ERROR:
                return new C0510(RootCause.networkFailure.name(), r2);
            case NO_CONNECTIVITY:
                return new C0510(RootCause.tcpNoRouteToHost.name(), r2);
            case HTTP_SSL_NO_VALID_CERT:
                return new C0510(RootCause.sslExpiredCert.name(), r2);
            case HTTP_SSL_DATE_TIME_ERROR:
                return new C0510(RootCause.sslUntrustedCert.name(), r2);
            case HTTP_SSL_ERROR:
                return new C0510(RootCause.sslUntrustedCert.name(), r2);
            case SERVER_ERROR:
                return new C0510(RootCause.serverFailure.name(), r2);
            case UNKNOWN:
                return new C0510(RootCause.unknownFailure.name(), r2);
            default:
                return new C0510(RootCause.unknownFailure.name(), r2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m4062(VolleyError volleyError) {
        return (volleyError == null || volleyError.f128 == null) ? false : true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Error m4063(VolleyError volleyError) {
        ArrayList arrayList = new ArrayList();
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        DeepErrorElement.Debug debug = new DeepErrorElement.Debug();
        arrayList.add(deepErrorElement);
        deepErrorElement.setDebug(debug);
        deepErrorElement.setFatal(true);
        deepErrorElement.setErrorCode(StatusCode.NETWORK_ERROR.name());
        if (m4062(volleyError)) {
            try {
                JSONObject jSONObject = new JSONObject();
                debug.setMessage(jSONObject);
                jSONObject.put("statusCode", volleyError.f128.f15527);
                if (volleyError.f128.f15530 != null) {
                    jSONObject.put("response", new String(volleyError.f128.f15530, "UTF-8"));
                }
            } catch (Throwable th) {
            }
        }
        if (!(volleyError == null || volleyError.getStackTrace() == null)) {
            debug.setStackTrace(Log.getStackTraceString(volleyError));
        }
        return new Error(m4066(volleyError), arrayList);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static RootCause m4066(VolleyError volleyError) {
        if (!m4062(volleyError)) {
            return RootCause.networkFailure;
        }
        int i = volleyError.f128.f15527;
        if (i >= 400 && i < 500) {
            return RootCause.http4xx;
        }
        if (i >= 500 && i < 600) {
            return RootCause.http5xx;
        }
        String message = volleyError.getMessage();
        if (message != null) {
            String lowerCase = message.toLowerCase(Locale.US);
            if (lowerCase.contains("sslhandshakeexception")) {
                return RootCause.sslHandshakeFailure;
            }
            if (lowerCase.contains("current time") && lowerCase.contains("validation time")) {
                return RootCause.sslExpiredCert;
            }
            if (lowerCase.contains("no trusted certificate found")) {
                return RootCause.sslUntrustedCert;
            }
        }
        return RootCause.networkFailure;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0510 m4065(VolleyError volleyError) {
        if (volleyError == null) {
            return null;
        }
        C1181 r0 = volleyError.f128;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Error.ROOT_CAUSE, m4066(volleyError).name());
            if (m4062(volleyError)) {
                jSONObject.put("statusCode", volleyError.f128.f15527);
                if (volleyError.f128.f15530 != null) {
                    jSONObject.put("response", new String(volleyError.f128.f15530, "UTF-8"));
                }
            }
        } catch (Throwable th) {
        }
        return C0590.m14708(StatusCode.NETWORK_ERROR.name(), jSONObject, volleyError);
    }
}
