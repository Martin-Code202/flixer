package o;

import android.view.Surface;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
/* renamed from: o.jr  reason: case insensitive filesystem */
public abstract class AbstractC1917jr {

    /* renamed from: ˋ  reason: contains not printable characters */
    protected SimpleExoPlayer f8039;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected MappingTrackSelector f8040;

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8032(MediaSource mediaSource) {
        this.f8039.prepare(mediaSource);
        this.f8039.setVolume(0.0f);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8038() {
        C1283.m16854("ExoSessionPlayer", "play() ");
        this.f8039.setPlayWhenReady(true);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8034() {
        this.f8039.setPlayWhenReady(false);
    }

    /* renamed from: ˊ */
    public void mo7981() {
        this.f8039.release();
    }

    /* renamed from: ˏ */
    public void mo7982(long j) {
        this.f8039.seekTo(j);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8037() {
        this.f8039.stop();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8035(Surface surface) {
        this.f8039.setVideoSurface(surface);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m8036() {
        return this.f8039.getCurrentPosition();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m8030() {
        return this.f8039.getPlaybackState() == 3 && this.f8039.getPlayWhenReady();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m8040() {
        TrackSelection trackSelection = null;
        int i = 0;
        while (true) {
            if (i >= this.f8039.getRendererCount()) {
                break;
            } else if (this.f8039.getRendererType(i) == 1) {
                TrackSelectionArray currentTrackSelections = this.f8039.getCurrentTrackSelections();
                trackSelection = currentTrackSelections.length > i ? currentTrackSelections.get(i) : null;
            } else {
                i++;
            }
        }
        if (trackSelection != null) {
            return C1918js.m8041(trackSelection);
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m8039(String str) {
        if (C1349Bv.m4126(m8040(), str)) {
            return true;
        }
        if (str.equals(m8040())) {
            C1283.m16854("ExoSessionPlayer", "selectAudioTrack, already selected ");
            return false;
        }
        C1918js.m8042(this.f8040, str);
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8033(boolean z) {
        if (this.f8039 != null) {
            this.f8039.setVolume(z ? 0.3f : 1.0f);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8031(float f) {
        this.f8039.setVolume(f);
    }
}
