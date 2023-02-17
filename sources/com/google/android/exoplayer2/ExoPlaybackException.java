package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
public final class ExoPlaybackException extends Exception {
    public final int rendererIndex;
    public final int type;

    public static ExoPlaybackException createForRenderer(Exception exc, int i) {
        return new ExoPlaybackException(1, null, exc, i);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, null, iOException, -1);
    }

    static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, null, runtimeException, -1);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException, int i, String str) {
        return new ExoPlaybackException(2, str, runtimeException, i);
    }

    private ExoPlaybackException(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.type = i;
        this.rendererIndex = i2;
    }

    public IOException getSourceException() {
        Assertions.checkState(this.type == 0);
        return (IOException) getCause();
    }

    public Exception getRendererException() {
        Assertions.checkState(this.type == 1);
        return (Exception) getCause();
    }

    public RuntimeException getUnexpectedException() {
        Assertions.checkState(this.type == 2);
        return (RuntimeException) getCause();
    }
}
