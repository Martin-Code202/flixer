package o;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
/* renamed from: o.jq  reason: case insensitive filesystem */
public abstract class AbstractC1916jq implements Player.EventListener, VideoRendererEventListener, AudioRendererEventListener {
    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoEnabled(DecoderCounters decoderCounters) {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoInputFormatChanged(Format format) {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onDroppedFrames(int i, long j) {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onRenderedFirstFrame(Surface surface) {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoDisabled(DecoderCounters decoderCounters) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity() {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioEnabled(DecoderCounters decoderCounters) {
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioSessionId(int i) {
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioDecoderInitialized(String str, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioInputFormatChanged(Format format) {
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioTrackUnderrun(int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioDisabled(DecoderCounters decoderCounters) {
    }
}
