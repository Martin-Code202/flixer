package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
public interface AdaptiveMediaSourceEventListener {
    void onDownstreamFormatChanged(int i, Format format, int i2, Object obj, long j);

    void onLoadCanceled(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void onLoadCompleted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void onLoadError(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void onLoadStarted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3);

    public static final class EventDispatcher {
        private final Handler handler;
        private final AdaptiveMediaSourceEventListener listener;
        private final long mediaTimeOffsetMs;

        public EventDispatcher(Handler handler2, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
            this(handler2, adaptiveMediaSourceEventListener, 0);
        }

        public EventDispatcher(Handler handler2, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, long j) {
            this.handler = adaptiveMediaSourceEventListener != null ? (Handler) Assertions.checkNotNull(handler2) : null;
            this.listener = adaptiveMediaSourceEventListener;
            this.mediaTimeOffsetMs = j;
        }

        public EventDispatcher copyWithMediaTimeOffsetMs(long j) {
            return new EventDispatcher(this.handler, this.listener, j);
        }

        public void loadStarted(DataSpec dataSpec, int i, long j) {
            loadStarted(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
        }

        public void loadStarted(final DataSpec dataSpec, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onLoadStarted(dataSpec, i, i2, format, i3, obj, EventDispatcher.this.adjustMediaTime(j), EventDispatcher.this.adjustMediaTime(j2), j3);
                    }
                });
            }
        }

        public void loadCompleted(DataSpec dataSpec, int i, long j, long j2, long j3) {
            loadCompleted(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public void loadCompleted(final DataSpec dataSpec, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onLoadCompleted(dataSpec, i, i2, format, i3, obj, EventDispatcher.this.adjustMediaTime(j), EventDispatcher.this.adjustMediaTime(j2), j3, j4, j5);
                    }
                });
            }
        }

        public void loadCanceled(DataSpec dataSpec, int i, long j, long j2, long j3) {
            loadCanceled(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public void loadCanceled(final DataSpec dataSpec, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.3
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onLoadCanceled(dataSpec, i, i2, format, i3, obj, EventDispatcher.this.adjustMediaTime(j), EventDispatcher.this.adjustMediaTime(j2), j3, j4, j5);
                    }
                });
            }
        }

        public void loadError(DataSpec dataSpec, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            loadError(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        public void loadError(final DataSpec dataSpec, final int i, final int i2, final Format format, final int i3, final Object obj, final long j, final long j2, final long j3, final long j4, final long j5, final IOException iOException, final boolean z) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.4
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onLoadError(dataSpec, i, i2, format, i3, obj, EventDispatcher.this.adjustMediaTime(j), EventDispatcher.this.adjustMediaTime(j2), j3, j4, j5, iOException, z);
                    }
                });
            }
        }

        public void downstreamFormatChanged(final int i, final Format format, final int i2, final Object obj, final long j) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher.6
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onDownstreamFormatChanged(i, format, i2, obj, EventDispatcher.this.adjustMediaTime(j));
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long adjustMediaTime(long j) {
            long usToMs = C.usToMs(j);
            if (usToMs == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.mediaTimeOffsetMs + usToMs;
        }
    }
}
