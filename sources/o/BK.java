package o;

import com.android.volley.NoConnectionError;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.service.msl.client.MslErrorException;
import com.netflix.mediaclient.service.msl.client.WidevineContextException;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.volley.ParseException;
import com.netflix.mediaclient.service.webclient.volley.StatusCodeError;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Locale;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
public final class BK {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final VolleyError f4581 = new VolleyError(new C1181(f4582, new byte[0], Collections.emptyMap(), false));

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int f4582 = 408;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static NetflixStatus m3875(VolleyError volleyError, AbstractC2049oy oyVar, StatusCode statusCode) {
        StatusCode statusCode2;
        String message = volleyError.getMessage();
        if (volleyError instanceof FalkorException) {
            statusCode2 = FalkorException.m156(message, oyVar);
        } else if (volleyError instanceof ParseException) {
            statusCode2 = StatusCode.RESPONSE_PARSE_ERROR;
        } else if (volleyError instanceof ServerError) {
            statusCode2 = StatusCode.SERVER_ERROR;
        } else if (volleyError instanceof NoConnectionError) {
            statusCode2 = StatusCode.NO_CONNECTIVITY;
        } else if (volleyError instanceof StatusCodeError) {
            statusCode2 = ((StatusCodeError) volleyError).m1474();
        } else {
            statusCode2 = m3869(volleyError);
        }
        if (statusCode2 == null) {
            statusCode2 = statusCode;
        }
        C1283.m16854("nf_volley", "getStatus statusCode: " + statusCode2);
        NetflixStatus netflixStatus = new NetflixStatus(statusCode2);
        netflixStatus.m309(AbstractC1358Cd.m4351(volleyError));
        netflixStatus.m310(C1343Bp.m4065(volleyError));
        netflixStatus.m303(volleyError);
        return netflixStatus;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static StatusCodeError m3872(VolleyError volleyError) {
        String volleyError2 = volleyError.toString();
        if (volleyError2 == null) {
            return new StatusCodeError(StatusCode.HTTP_ERROR_UNKNOWN, volleyError.toString());
        }
        String upperCase = volleyError2.toUpperCase(Locale.ENGLISH);
        if (upperCase.contains("REQUEST_ERROR_CONNECTION_TIMED_OUT")) {
            return new StatusCodeError(StatusCode.HTTP_ERR_TIMEOUT, upperCase);
        }
        if (upperCase.contains("ERR_NAME_NOT_RESOLVED")) {
            return new StatusCodeError(StatusCode.HTTP_ERR_NOT_RESOLVED, upperCase);
        }
        if (upperCase.contains("ERR_INVALID_URL") || upperCase.contains("ERR_DISALLOWED_URL_SCHEME") || upperCase.contains("ERR_UNKNOWN_URL_SCHEME")) {
            return new StatusCodeError(StatusCode.HTTP_ERR_MALFORMED_URL, upperCase);
        }
        return new StatusCodeError(StatusCode.HTTP_ERROR_UNKNOWN, upperCase);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static StatusCode m3869(VolleyError volleyError) {
        Throwable cause = volleyError.getCause();
        if (cause == null) {
            return null;
        }
        if (cause instanceof UnknownHostException) {
            return StatusCode.NET_UNKNOWN_HOST_EXCEPTION;
        }
        if (cause instanceof ConnectException) {
            return StatusCode.NET_CONNECTION_EXCEPTION;
        }
        if (cause instanceof SocketTimeoutException) {
            return StatusCode.NET_SOCKET_TIMEOUT_EXCEPTION;
        }
        if (AX.m3491(volleyError)) {
            return StatusCode.MSL_USERAUTH_ENTITY_MISMATCH;
        }
        if (cause instanceof WidevineContextException) {
            return ((WidevineContextException) cause).m810();
        }
        if (m3870(cause)) {
            return StatusCode.MSL_GENERIC_EXCEPTION;
        }
        if (cause instanceof CronetException) {
            return m3871((CronetException) cause);
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static StatusCode m3871(CronetException cronetException) {
        if (!(cronetException instanceof NetworkException)) {
            return null;
        }
        switch (((NetworkException) cronetException).getErrorCode()) {
            case 1:
                return StatusCode.NET_CRONET_HOSTNAME_NOT_RESOLVED;
            case 2:
                return StatusCode.NET_CRONET_INTERNET_DISCONNECTED;
            case 3:
                return StatusCode.NET_CRONET_NETWORK_CHANGED;
            case 4:
                return StatusCode.NET_CRONET_TIMED_OUT;
            case 5:
                return StatusCode.NET_CRONET_CONNECTION_CLOSED;
            case 6:
                return StatusCode.NET_CRONET_CONNECTION_TIMED_OUT;
            case 7:
                return StatusCode.NET_CRONET_CONNECTION_REFUSED;
            case 8:
                return StatusCode.NET_CRONET_CONNECTION_RESET;
            case 9:
                return StatusCode.NET_CRONET_ADDRESS_UNREACHABLE;
            case 10:
                return StatusCode.NET_CRONET_QUIC_PROTOCOL_FAILED;
            case 11:
                return StatusCode.NET_CRONET_ERROR_OTHER;
            default:
                return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m3870(Throwable th) {
        if (th == null) {
            return false;
        }
        if (m3873(th) || m3873(th.getCause())) {
            return true;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        return (C1349Bv.m4107(stringWriter2) && stringWriter2.contains("com.netflix.msl")) || stringWriter2.contains(C1796gB.class.getCanonicalName()) || stringWriter2.contains(C1799gE.class.getCanonicalName());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m3873(Throwable th) {
        return (th instanceof MslErrorException) || (th instanceof MslInternalException) || (th instanceof MslException);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AbstractC2040op m3874(UserAgentInterface userAgentInterface, String str, AbstractC2040op opVar, boolean z) {
        AbstractC2031og r4 = userAgentInterface.mo1343(str);
        if (r4 != null) {
            opVar.m9687(r4);
        } else if (z) {
            C1283.m16855("nf_volley", "UserCredentialRegistry not found for profile %s, but request is marked as always deliver, use current credentials.", str);
        } else {
            C1283.m16855("nf_volley", "UserCredentialRegistry not found for profile %s, drop request", str);
            return null;
        }
        return opVar;
    }
}
