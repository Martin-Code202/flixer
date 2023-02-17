package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
public class DefaultRenderersFactory implements RenderersFactory {
    private final long allowedVideoJoiningTimeMs;
    private final Context context;
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final int extensionRendererMode;

    public DefaultRenderersFactory(Context context2, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, int i) {
        this(context2, drmSessionManager2, i, 5000);
    }

    public DefaultRenderersFactory(Context context2, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, int i, long j) {
        this.context = context2;
        this.drmSessionManager = drmSessionManager2;
        this.extensionRendererMode = i;
        this.allowedVideoJoiningTimeMs = j;
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextRenderer.Output output, MetadataRenderer.Output output2) {
        ArrayList<Renderer> arrayList = new ArrayList<>();
        buildVideoRenderers(this.context, this.drmSessionManager, this.allowedVideoJoiningTimeMs, handler, videoRendererEventListener, this.extensionRendererMode, arrayList);
        buildAudioRenderers(this.context, this.drmSessionManager, buildAudioProcessors(), handler, audioRendererEventListener, this.extensionRendererMode, arrayList);
        buildTextRenderers(this.context, output, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, output2, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
    }

    public void buildVideoRenderers(Context context2, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MediaCodecVideoRenderer(context2, MediaCodecSelector.DEFAULT, j, drmSessionManager2, false, handler, videoRendererEventListener, 50));
        if (i != 0) {
            int size = arrayList.size();
            if (i == 2) {
                size--;
            }
            try {
                int i2 = size + 1;
                arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(true, Long.valueOf(j), handler, videoRendererEventListener, 50));
                Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException e) {
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void buildAudioRenderers(Context context2, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, AudioProcessor[] audioProcessorArr, Handler handler, AudioRendererEventListener audioRendererEventListener, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MediaCodecAudioRenderer(MediaCodecSelector.DEFAULT, drmSessionManager2, true, handler, audioRendererEventListener, AudioCapabilities.getCapabilities(context2), audioProcessorArr));
        if (i != 0) {
            int size = arrayList.size();
            if (i == 2) {
                size--;
            }
            try {
                size++;
                arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                Log.i("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
            } catch (ClassNotFoundException e) {
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
            try {
                size++;
                arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                Log.i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
            } catch (ClassNotFoundException e3) {
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
            try {
                int i2 = size + 1;
                arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                Log.i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException e5) {
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void buildTextRenderers(Context context2, TextRenderer.Output output, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(output, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMetadataRenderers(Context context2, MetadataRenderer.Output output, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(output, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    /* access modifiers changed from: protected */
    public AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }
}
