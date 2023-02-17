package com.netflix.mediaclient.ui.error;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.error.crypto.ErrorSource;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import o.AbstractC1853hl;
import o.AbstractC2049oy;
import o.oH;
public interface CryptoErrorManager {

    public enum CryptoFailback {
        widevineL3,
        widevineL3Failed,
        uknown
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo1737(ErrorSource errorSource, StatusCode statusCode, Throwable th);

    /* renamed from: ॱ  reason: contains not printable characters */
    CryptoFailback mo1738();

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo1739(Context context, long j, UserAgentInterface userAgentInterface, AbstractC1853hl hlVar, oH oHVar, AbstractC2049oy oyVar);
}
