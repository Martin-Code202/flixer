package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
@TargetApi(16)
public interface DrmSession<T extends ExoMediaCrypto> {

    public static class DrmSessionException extends Exception {
    }

    DrmSessionException getError();

    T getMediaCrypto();

    int getState();
}
