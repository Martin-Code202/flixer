package o;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.error.crypto.ErrorSource;
public final class rG {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String f9645 = "nf_crypto_error";

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AbstractC1578c m10145(ErrorSource errorSource, StatusCode statusCode) {
        if (errorSource == ErrorSource.msl) {
            return m10144(statusCode);
        }
        throw new IllegalStateException("Playback error sources not supported at this moment!");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static AbstractC1578c m10144(StatusCode statusCode) {
        if (rL.m10150(statusCode)) {
            return new rL(statusCode);
        }
        if (rJ.m10148(statusCode)) {
            return new rJ();
        }
        if (rI.m10147(statusCode)) {
            return new rI();
        }
        if (rQ.m10156(statusCode)) {
            return new rQ();
        }
        if (rO.m10151(statusCode)) {
            return new rO();
        }
        if (rH.m10146(statusCode)) {
            return new rH();
        }
        return null;
    }
}
