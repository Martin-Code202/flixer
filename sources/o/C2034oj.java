package o;

import android.content.Context;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.configuration.EdgeStack;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import com.netflix.mediaclient.service.webclient.volley.FtlController;
import java.net.HttpRetryException;
import org.chromium.net.NetworkException;
/* renamed from: o.oj  reason: case insensitive filesystem */
public final class C2034oj {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m9656(VolleyError volleyError) {
        if (volleyError instanceof ServerError) {
            int i = ((ServerError) volleyError).f128.f15527;
            switch (i) {
                case 414:
                case 418:
                case 502:
                case 504:
                    C1283.m16864("ftl", volleyError, "performing FTL fallback for status code %s", Integer.valueOf(i));
                    return i;
                default:
                    C1283.m16864("ftl", volleyError.getCause(), "NOT performing FTL fallback: status code %s", Integer.valueOf(i));
                    return -1;
            }
        } else if (volleyError instanceof TimeoutError) {
            C1283.m16864("ftl", volleyError, "performing FTL fallback for connection timeout", new Object[0]);
            return 1;
        } else {
            RootCause r6 = C1343Bp.m4066(volleyError);
            if (r6 == RootCause.sslExpiredCert || r6 == RootCause.sslHandshakeFailure || r6 == RootCause.sslNoCipher || r6 == RootCause.sslUntrustedCert) {
                C1283.m16864("ftl", volleyError, "performing FTL fallback for TLS failure", new Object[0]);
                return 3;
            }
            Throwable cause = volleyError.getCause();
            if (cause instanceof HttpRetryException) {
                C1283.m16864("ftl", volleyError.getCause(), "NOT performing FTL fallback for retry: status code %s", Integer.valueOf(((HttpRetryException) cause).responseCode()));
                return -1;
            } else if (cause instanceof NetworkException) {
                switch (((NetworkException) cause).getErrorCode()) {
                    case 1:
                        C1283.m16864("ftl", volleyError, "performing FTL fallback for DNS failure", new Object[0]);
                        return 2;
                    case 2:
                    case 3:
                        return -1;
                    case 4:
                    case 6:
                        C1283.m16864("ftl", volleyError, "performing FTL fallback for cronet timeout", new Object[0]);
                        return 1;
                    case 5:
                    default:
                        C1283.m16864("ftl", volleyError, "performing FTL fallback for connection: %s", Integer.valueOf(((NetworkException) cause).getErrorCode()));
                        return 0;
                }
            } else {
                C1283.m16864("ftl", volleyError.getCause(), "NOT performing FTL fallback: unknown connection error", new Object[0]);
                return -1;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m9658(VolleyError volleyError) {
        if (volleyError instanceof ServerError) {
            return m9659(((ServerError) volleyError).f128);
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m9659(C1181 r3) {
        if (r3 == null || r3.f15528 == null) {
            return null;
        }
        return r3.f15528.get("Via");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m9657(Context context) {
        return m9661(context);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m9661(Context context) {
        EdgeStack edgeStack = EdgeStack.PROD;
        if (C0685.m14964(context)) {
            return C0685.m14965(edgeStack);
        }
        return C0681.m14919(edgeStack);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static synchronized void m9660(VolleyError volleyError, AbstractC2039oo ooVar, Object obj, long j) {
        NetworkRequestType r13;
        synchronized (C2034oj.class) {
            if (!ooVar.mo1469()) {
                int r10 = m9656(volleyError);
                String message = volleyError.getMessage();
                String str = null;
                if (!(obj == null || (r13 = NetworkRequestType.m477((str = obj.toString()))) == null)) {
                    str = r13.toString();
                }
                ooVar.mo1468(r10, new FtlController.iF(AbstractApplicationC1258.m16692(), r10, BK.m3869(volleyError), message, m9658(volleyError), j, str));
                Logger.INSTANCE.m127(new C0950());
            }
        }
    }
}
