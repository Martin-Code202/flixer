package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
@TargetApi(16)
public class SimpleExoPlayer implements ExoPlayer {
    private AudioAttributes audioAttributes;
    private AudioRendererEventListener audioDebugListener;
    private DecoderCounters audioDecoderCounters;
    private Format audioFormat;
    private final int audioRendererCount;
    private int audioSessionId;
    private float audioVolume;
    private final ComponentListener componentListener = new ComponentListener();
    private final CopyOnWriteArraySet<MetadataRenderer.Output> metadataOutputs = new CopyOnWriteArraySet<>();
    private boolean ownsSurface;
    private final ExoPlayer player;
    protected final Renderer[] renderers;
    private Surface surface;
    private SurfaceHolder surfaceHolder;
    private final CopyOnWriteArraySet<TextRenderer.Output> textOutputs = new CopyOnWriteArraySet<>();
    private TextureView textureView;
    private VideoRendererEventListener videoDebugListener;
    private DecoderCounters videoDecoderCounters;
    private Format videoFormat;
    private final CopyOnWriteArraySet<VideoListener> videoListeners = new CopyOnWriteArraySet<>();
    private final int videoRendererCount;
    private int videoScalingMode;

    public interface VideoListener {
        void onRenderedFirstFrame();

        void onVideoSizeChanged(int i, int i2, int i3, float f);
    }

    protected SimpleExoPlayer(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        this.renderers = renderersFactory.createRenderers(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.componentListener, this.componentListener, this.componentListener, this.componentListener);
        int i = 0;
        int i2 = 0;
        for (Renderer renderer : this.renderers) {
            switch (renderer.getTrackType()) {
                case 1:
                    i2++;
                    break;
                case 2:
                    i++;
                    break;
            }
        }
        this.videoRendererCount = i;
        this.audioRendererCount = i2;
        this.audioVolume = 1.0f;
        this.audioSessionId = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.videoScalingMode = 1;
        this.player = new ExoPlayerImpl(this.renderers, trackSelector, loadControl);
    }

    public void setVideoSurface(Surface surface2) {
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(surface2, false);
    }

    public void setVolume(float f) {
        this.audioVolume = f;
        ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.audioRendererCount];
        int i = 0;
        Renderer[] rendererArr = this.renderers;
        for (Renderer renderer : rendererArr) {
            if (renderer.getTrackType() == 1) {
                i++;
                exoPlayerMessageArr[i] = new ExoPlayer.ExoPlayerMessage(renderer, 2, Float.valueOf(f));
            }
        }
        this.player.sendMessages(exoPlayerMessageArr);
    }

    public void setVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListener = videoRendererEventListener;
    }

    public void setAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListener = audioRendererEventListener;
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        this.player.addListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        this.player.removeListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource) {
        this.player.prepare(mediaSource);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        this.player.setPlayWhenReady(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(long j) {
        this.player.seekTo(j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        this.player.stop();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        this.player.release();
        removeSurfaceCallbacks();
        if (this.surface != null) {
            if (this.ownsSurface) {
                this.surface.release();
            }
            this.surface = null;
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.sendMessages(exoPlayerMessageArr);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.blockingSendMessages(exoPlayerMessageArr);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        return this.player.getRendererCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i) {
        return this.player.getRendererType(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.player.getCurrentTrackSelections();
    }

    @Override // com.google.android.exoplayer2.Player
    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    private void removeSurfaceCallbacks() {
        if (this.textureView != null) {
            if (this.textureView.getSurfaceTextureListener() != this.componentListener) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setVideoSurfaceInternal(Surface surface2, boolean z) {
        ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.videoRendererCount];
        int i = 0;
        Renderer[] rendererArr = this.renderers;
        for (Renderer renderer : rendererArr) {
            if (renderer.getTrackType() == 2) {
                i++;
                exoPlayerMessageArr[i] = new ExoPlayer.ExoPlayerMessage(renderer, 1, surface2);
            }
        }
        if (this.surface == null || this.surface == surface2) {
            this.player.sendMessages(exoPlayerMessageArr);
        } else {
            this.player.blockingSendMessages(exoPlayerMessageArr);
            if (this.ownsSurface) {
                this.surface.release();
            }
        }
        this.surface = surface2;
        this.ownsSurface = z;
    }

    /* access modifiers changed from: package-private */
    public final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextRenderer.Output, MetadataRenderer.Output, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.videoDecoderCounters = decoderCounters;
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j, long j2) {
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoDecoderInitialized(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
            SimpleExoPlayer.this.videoFormat = format;
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onDroppedFrames(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
            while (it.hasNext()) {
                ((VideoListener) it.next()).onVideoSizeChanged(i, i2, i3, f);
            }
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoSizeChanged(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            if (SimpleExoPlayer.this.surface == surface) {
                Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
                while (it.hasNext()) {
                    ((VideoListener) it.next()).onRenderedFirstFrame();
                }
            }
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onRenderedFirstFrame(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
            if (SimpleExoPlayer.this.videoDebugListener != null) {
                SimpleExoPlayer.this.videoDebugListener.onVideoDisabled(decoderCounters);
            }
            SimpleExoPlayer.this.videoFormat = null;
            SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.audioDecoderCounters = decoderCounters;
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i) {
            SimpleExoPlayer.this.audioSessionId = i;
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioSessionId(i);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j, long j2) {
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioDecoderInitialized(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
            SimpleExoPlayer.this.audioFormat = format;
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioTrackUnderrun(int i, long j, long j2) {
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioTrackUnderrun(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
            if (SimpleExoPlayer.this.audioDebugListener != null) {
                SimpleExoPlayer.this.audioDebugListener.onAudioDisabled(decoderCounters);
            }
            SimpleExoPlayer.this.audioFormat = null;
            SimpleExoPlayer.this.audioDecoderCounters = null;
            SimpleExoPlayer.this.audioSessionId = 0;
        }

        @Override // com.google.android.exoplayer2.text.TextRenderer.Output
        public void onCues(List<Cue> list) {
            Iterator it = SimpleExoPlayer.this.textOutputs.iterator();
            while (it.hasNext()) {
                ((TextRenderer.Output) it.next()).onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataRenderer.Output
        public void onMetadata(Metadata metadata) {
            Iterator it = SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it.hasNext()) {
                ((MetadataRenderer.Output) it.next()).onMetadata(metadata);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, false);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
