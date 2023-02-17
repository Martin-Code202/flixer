package o;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.WindowManager;
import com.android.volley.NetworkError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.apm.model.Display;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
/* renamed from: o.Cd  reason: case insensitive filesystem */
public abstract class AbstractC1358Cd {
    AbstractC1358Cd() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4354() {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_PAUSE_EVENTS_DELIVERY");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4359(boolean z) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_RESUME_EVENTS_DELIVERY");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("flush", z);
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static Error m4346(VolleyError volleyError, String str) {
        if (volleyError == null || volleyError.f128 == null) {
            return new Error(RootCause.unknownFailure, null);
        }
        int i = volleyError.f128.f15527;
        if (i >= 400 && i < 500) {
            return new Error(RootCause.http4xx, null);
        }
        if (i == 500) {
            return new Error(RootCause.serverFailure, null);
        }
        if (i <= 500 || i >= 600) {
            return new Error(RootCause.unknownFailure, null);
        }
        return new Error(RootCause.http5xx, null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static Error m4352(StatusCode statusCode, String str) {
        switch (statusCode) {
            case OK:
            case NON_RECOMMENDED_APP_VERSION:
                return null;
            case NETWORK_ERROR:
                return new Error(RootCause.networkFailure, null);
            case NO_CONNECTIVITY:
                return new Error(RootCause.tcpNoRouteToHost, null);
            case HTTP_SSL_NO_VALID_CERT:
                return new Error(RootCause.sslExpiredCert, null);
            case HTTP_SSL_DATE_TIME_ERROR:
                return new Error(RootCause.sslUntrustedCert, null);
            case HTTP_SSL_ERROR:
                return new Error(RootCause.sslUntrustedCert, null);
            case SERVER_ERROR:
                return new Error(RootCause.serverFailure, null);
            case UNKNOWN:
                return new Error(RootCause.unknownFailure, null);
            default:
                return new Error(RootCause.unknownFailure, null);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static boolean m4349(Object obj, String str) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Display m4350(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return null;
        }
        android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
        float refreshRate = defaultDisplay.getRefreshRate();
        if (refreshRate < 10.0f) {
            refreshRate = 60.0f;
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return new Display(Display.Connector.internal, null, Integer.valueOf(point.x), Integer.valueOf(point.y), Integer.valueOf((int) refreshRate), null, context.getResources().getDisplayMetrics().densityDpi);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static List<DeepErrorElement> m4348(StatusCode statusCode, String str) {
        ArrayList arrayList = new ArrayList();
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        deepErrorElement.setErrorCode(String.valueOf(statusCode.m271()));
        DeepErrorElement.Debug debug = new DeepErrorElement.Debug();
        debug.setStackTrace(str);
        deepErrorElement.setDebug(debug);
        arrayList.add(deepErrorElement);
        return arrayList;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static UIError m4347(Status status, String str, ActionOnUIError actionOnUIError) {
        return new UIError(C1343Bp.m4064(status), actionOnUIError, str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static UIError m4357(Status status, String str, ActionOnUIError actionOnUIError) {
        RootCause rootCause;
        RootCause rootCause2 = RootCause.serverFailure;
        StatusCode r3 = status.mo302();
        List<DeepErrorElement> r4 = m4348(r3, str);
        switch (r3) {
            case NETWORK_ERROR:
            case NO_CONNECTIVITY:
                rootCause = RootCause.networkFailure;
                break;
            case HTTP_SSL_NO_VALID_CERT:
                rootCause = RootCause.sslUntrustedCert;
                break;
            case HTTP_SSL_DATE_TIME_ERROR:
                rootCause = RootCause.sslExpiredCert;
                break;
            case HTTP_SSL_ERROR:
                rootCause = RootCause.sslHandshakeFailure;
                break;
            case SERVER_ERROR:
            case NRD_LOGIN_ACTIONID_1:
            case NRD_LOGIN_ACTIONID_2:
            case NRD_LOGIN_ACTIONID_3:
            case NRD_LOGIN_ACTIONID_5:
            case NRD_LOGIN_ACTIONID_6:
            case NRD_LOGIN_ACTIONID_7:
            case NRD_LOGIN_ACTIONID_9:
            case NRD_LOGIN_ACTIONID_10:
            case NRD_LOGIN_ACTIONID_11:
            case NRD_LOGIN_ACTIONID_12:
                rootCause = RootCause.serverFailure;
                break;
            case UNKNOWN:
            default:
                if (!StatusCode.m263(r3.m271())) {
                    rootCause = RootCause.unknownFailure;
                    break;
                } else {
                    rootCause = RootCause.clientFailure;
                    break;
                }
            case NRD_ERROR:
            case INTERNAL_ERROR:
            case INT_ERR_ADVIS_VIDEO_ID_NULL:
            case INT_ERR_CMP:
            case INT_ERR_CMP_RESP_NULL:
            case INT_ERR_MDX_INIT:
            case INT_ERR_RESOURCE_URL_NULL:
            case INT_ERR_CB_NULL:
            case INT_ERR_REALM_DETAILS_NULL:
            case INT_ERR_MNGR_NOT_READY:
            case INT_ERR_SERVICE_DISCONNECTED:
            case INT_ERR_BAD_COOKIES:
            case INT_ERR_FALKOR_EXCEPTION:
                rootCause = RootCause.clientFailure;
                break;
            case FALKOR_RESPONSE_PARSE_ERROR:
                rootCause = RootCause.serverResponseBad;
                break;
            case NRD_LOGIN_ACTIONID_4:
            case NRD_LOGIN_ACTIONID_8:
                rootCause = RootCause.clientRequestBad;
                break;
        }
        return new UIError(rootCause, actionOnUIError, str, r4);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static UIError m4353(Status status, String str, ActionOnUIError actionOnUIError) {
        if (C1343Bp.m4068(status) != null) {
            return m4347(status, str, actionOnUIError);
        }
        C1283.m16854("nf_log", "Error message does NOT exist in status object");
        return m4357(status, str, actionOnUIError);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Error m4351(VolleyError volleyError) {
        Error error = new Error();
        C1181 r0 = volleyError.f128;
        if (volleyError instanceof FalkorException) {
            error.setRootCause(RootCause.serverResponseBad);
        } else if (volleyError instanceof ServerError) {
            error.setRootCause(RootCause.serverFailure);
        } else if (volleyError instanceof TimeoutError) {
            error.setRootCause(RootCause.tcpConnectionTimeout);
        } else if (volleyError instanceof NetworkError) {
            error.setRootCause(m4356(volleyError));
        }
        C1283.m16854("nf_log", "Report data request failed");
        JSONObject jSONObject = null;
        if (volleyError.f128 != null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("bodyResponse", new String(volleyError.f128.f15530));
            } catch (Throwable th) {
                C1283.m16847("nf_log", "Failed to add body response to JSON object", th);
            }
        }
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        DeepErrorElement.Debug debug = new DeepErrorElement.Debug();
        debug.setStackTrace(Log.getStackTraceString(volleyError));
        debug.setMessage(jSONObject);
        deepErrorElement.setDebug(debug);
        if (volleyError == null || volleyError.f128 == null) {
            C1283.m16850("nf_log", "Network response is not set!");
            deepErrorElement.setErrorCode("504");
        } else {
            deepErrorElement.setErrorCode("" + volleyError.f128.f15527);
        }
        error.addDeepError(deepErrorElement);
        return error;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    protected static RootCause m4356(VolleyError volleyError) {
        String message = volleyError.getMessage();
        if (message == null) {
            return RootCause.networkFailure;
        }
        String lowerCase = message.toLowerCase(Locale.US);
        RootCause rootCause = RootCause.networkFailure;
        if (!lowerCase.contains("sslhandshakeexception")) {
            return rootCause;
        }
        RootCause rootCause2 = RootCause.sslHandshakeFailure;
        if (lowerCase.contains("current time") && lowerCase.contains("validation time")) {
            return RootCause.sslExpiredCert;
        }
        if (lowerCase.contains("no trusted certificate found")) {
            return RootCause.sslUntrustedCert;
        }
        return rootCause2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4355() {
        return String.valueOf(m4358());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static UUID m4358() {
        return UUID.randomUUID();
    }
}
