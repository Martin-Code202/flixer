package o;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.LinkedList;
/* renamed from: o.ju  reason: case insensitive filesystem */
public class C1920ju extends MediaCodecVideoRenderer implements Handler.Callback {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f8075;

    /* renamed from: ˋ  reason: contains not printable characters */
    private RuntimeException f8076;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Handler f8077;

    /* renamed from: ˏ  reason: contains not printable characters */
    private HandlerThread f8078;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final LinkedList<Integer> f8079 = new LinkedList<>();

    public C1920ju(Context context, MediaCodecSelector mediaCodecSelector, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(context, mediaCodecSelector, j, drmSessionManager, z, handler, videoRendererEventListener, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.video.MediaCodecVideoRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        if (!(format == null || mediaCrypto == null)) {
            this.f8075 = mediaCrypto.requiresSecureDecoderComponent(format.sampleMimeType);
        }
        super.configureCodec(mediaCodecInfo, mediaCodec, format, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.video.MediaCodecVideoRenderer
    public long getMaxAheadTimedReleasUs() {
        if (this.f8075) {
            return 450000;
        }
        return super.getMaxAheadTimedReleasUs();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.video.MediaCodecVideoRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) {
        this.f8078 = new HandlerThread("NetflixMediaCodecVideoRenderer#" + SystemClock.elapsedRealtime(), -16);
        this.f8079.clear();
        this.f8078.start();
        this.f8077 = new Handler(this.f8078.getLooper(), this);
        super.onEnabled(z);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.video.MediaCodecVideoRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f8078.quit();
        this.f8077 = null;
        try {
            C1283.m16854("MediaCodecVideoRenderer", this.f8078.toString() + " finishing...");
            this.f8078.join(500);
            C1283.m16854("MediaCodecVideoRenderer", this.f8078.toString() + " should finished.");
        } catch (InterruptedException e) {
            C1283.m16865("MediaCodecVideoRenderer", this.f8078.toString() + " fails to join.");
        }
        this.f8078 = null;
        super.onDisabled();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int getInputIndex() {
        if (this.f8077 == null) {
            return super.getInputIndex();
        }
        synchronized (this.f8079) {
            if (!this.f8079.isEmpty()) {
                return this.f8079.removeFirst().intValue();
            }
        }
        if (this.f8077 == null || this.f8077.hasMessages(2)) {
            return -1;
        }
        this.f8077.obtainMessage(2).sendToTarget();
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void queueSecureInputBuffer(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        if (this.f8077 == null) {
            super.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
            return;
        }
        this.f8077.obtainMessage(1, new iF(i, i2, cryptoInfo, j, i3)).sendToTarget();
        RuntimeException r8 = m8080(null);
        if (r8 instanceof RuntimeException) {
            throw r8;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    @Override // android.os.Handler.Callback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r12) {
        /*
            r11 = this;
            int r0 = r12.what
            switch(r0) {
                case 1: goto L_0x0007;
                case 2: goto L_0x002a;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x004f
        L_0x0007:
            java.lang.Object r0 = r12.obj
            r7 = r0
            o.ju$iF r7 = (o.C1920ju.iF) r7
            r0 = r11
            int r1 = r7.f8083     // Catch:{ IllegalStateException -> 0x001b, RuntimeException -> 0x0025 }
            int r2 = r7.f8080     // Catch:{ IllegalStateException -> 0x001b, RuntimeException -> 0x0025 }
            android.media.MediaCodec$CryptoInfo r3 = r7.f8082     // Catch:{ IllegalStateException -> 0x001b, RuntimeException -> 0x0025 }
            long r4 = r7.f8081     // Catch:{ IllegalStateException -> 0x001b, RuntimeException -> 0x0025 }
            int r6 = r7.f8084     // Catch:{ IllegalStateException -> 0x001b, RuntimeException -> 0x0025 }
            super.queueSecureInputBuffer(r1, r2, r3, r4, r6)     // Catch:{ IllegalStateException -> 0x001b, RuntimeException -> 0x0025 }
            goto L_0x002a
        L_0x001b:
            r8 = move-exception
            java.lang.String r0 = "ignore IllegalStateException on queueSecureInputBuffer."
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.google.android.exoplayer2.util.NetflixExoLogUtil.Log(r0, r1)
            goto L_0x004f
        L_0x0025:
            r8 = move-exception
            r11.m8080(r8)
            goto L_0x004f
        L_0x002a:
            java.util.LinkedList<java.lang.Integer> r8 = r11.f8079
            monitor-enter(r8)
        L_0x002d:
            int r9 = super.getInputIndex()     // Catch:{ Exception -> 0x003f, all -> 0x0042 }
            if (r9 < 0) goto L_0x003c
            java.util.LinkedList<java.lang.Integer> r0 = r11.f8079     // Catch:{ Exception -> 0x003f, all -> 0x0042 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x003f, all -> 0x0042 }
            r0.add(r1)     // Catch:{ Exception -> 0x003f, all -> 0x0042 }
        L_0x003c:
            if (r9 >= 0) goto L_0x002d
            goto L_0x0040
        L_0x003f:
            r9 = move-exception
        L_0x0040:
            monitor-exit(r8)
            goto L_0x0045
        L_0x0042:
            r10 = move-exception
            monitor-exit(r8)
            throw r10
        L_0x0045:
            android.os.Handler r0 = r11.f8077
            if (r0 == 0) goto L_0x004f
            android.os.Handler r0 = r11.f8077
            r1 = 2
            r0.removeMessages(r1)
        L_0x004f:
            r0 = 0
            return r0
            switch-data {1->0x0007, 2->0x002a, }
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1920ju.handleMessage(android.os.Message):boolean");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void clearInput(boolean z) {
        if (this.f8077 != null) {
            this.f8077.removeMessages(1);
            this.f8077.removeMessages(2);
        }
        synchronized (this.f8079) {
            super.clearInput(z);
            this.f8079.clear();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private synchronized RuntimeException m8080(RuntimeException runtimeException) {
        RuntimeException runtimeException2;
        runtimeException2 = this.f8076;
        this.f8076 = runtimeException;
        return runtimeException2;
    }

    /* renamed from: o.ju$iF */
    static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        final int f8080;

        /* renamed from: ˋ  reason: contains not printable characters */
        final long f8081;

        /* renamed from: ˎ  reason: contains not printable characters */
        final MediaCodec.CryptoInfo f8082;

        /* renamed from: ˏ  reason: contains not printable characters */
        final int f8083;

        /* renamed from: ॱ  reason: contains not printable characters */
        final int f8084;

        public iF(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
            this.f8083 = i;
            this.f8080 = i2;
            MediaCodec.CryptoInfo cryptoInfo2 = new MediaCodec.CryptoInfo();
            cryptoInfo2.set(cryptoInfo.numSubSamples, (int[]) cryptoInfo.numBytesOfClearData.clone(), (int[]) cryptoInfo.numBytesOfEncryptedData.clone(), (byte[]) cryptoInfo.key.clone(), (byte[]) cryptoInfo.iv.clone(), cryptoInfo.mode);
            this.f8082 = cryptoInfo2;
            this.f8081 = j;
            this.f8084 = i3;
        }
    }
}
