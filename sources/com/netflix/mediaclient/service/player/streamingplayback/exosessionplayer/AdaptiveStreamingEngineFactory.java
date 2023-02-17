package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer;

import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState;
import o.AbstractC1949kt;
import o.AbstractC1951ky;
import o.C1235;
import o.C1283;
import o.kA;
import o.kF;
import o.kv;
public final class AdaptiveStreamingEngineFactory {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static AseOption f1825 = AseOption.NETFLIX_OPTIMIZED;

    enum AseOption {
        NETFLIX_EXAMPLE,
        NETFLIX_OPTIMIZED
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static kv m1005(AbstractC1951ky kyVar, kA kAVar, IAsePlayerState iAsePlayerState, kF kFVar, AbstractC1949kt ktVar, String str) {
        switch (f1825) {
            case NETFLIX_OPTIMIZED:
                return m1006(kyVar, kAVar, iAsePlayerState, kFVar, ktVar, str);
            default:
                C1283.m16850("StreamingPlayback_AdaptiveStreamingEngineFactory", "Error in choosing ASE option");
                return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static kv m1006(AbstractC1951ky kyVar, kA kAVar, IAsePlayerState iAsePlayerState, kF kFVar, AbstractC1949kt ktVar, String str) {
        try {
            Object[] objArr = new Object[6];
            objArr[5] = str;
            objArr[4] = ktVar;
            objArr[3] = kFVar;
            objArr[2] = iAsePlayerState;
            objArr[1] = kAVar;
            objArr[0] = kyVar;
            return (kv) ((Class) C1235.m16591(7, 4, 6398)).getDeclaredConstructor(AbstractC1951ky.class, kA.class, IAsePlayerState.class, kF.class, AbstractC1949kt.class, String.class).newInstance(objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
