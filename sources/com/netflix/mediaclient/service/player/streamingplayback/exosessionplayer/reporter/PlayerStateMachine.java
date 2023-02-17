package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.netflix.mediaclient.service.player.streamingplayback.playbackreporter.ErrorCodeUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import o.C1283;
import o.lR;
import o.lX;
public class PlayerStateMachine {

    /* renamed from: ˊ  reason: contains not printable characters */
    private List<If> f1928 = new CopyOnWriteArrayList();

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f1929;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f1930;

    /* renamed from: ˏ  reason: contains not printable characters */
    private lR f1931 = new lR();

    /* renamed from: ॱ  reason: contains not printable characters */
    private State f1932 = State.INITIALIZING;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Player.EventListener f1933 = new Player.EventListener() { // from class: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.PlayerStateMachine.2
        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj) {
            C1283.m16848("nf_playreport", "onTimelineChanged(%s, %s)", timeline, obj);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            C1283.m16848("nf_playreport", "onTracksChanged(%s, %s)", trackGroupArray, trackSelectionArray);
            PlayerStateMachine.this.f1929 = false;
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            C1283.m16848("nf_playreport", "onPlayerStateChanged(%s %s)", Boolean.valueOf(z), Integer.valueOf(i));
            switch (i) {
                case 1:
                case 4:
                default:
                    return;
                case 2:
                    PlayerStateMachine.this.m1096(State.REBUFFERING);
                    return;
                case 3:
                    if (z) {
                        PlayerStateMachine.this.m1096(State.PLAYING);
                        return;
                    } else {
                        PlayerStateMachine.this.m1096(State.PAUSED);
                        return;
                    }
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            C1283.m16848("nf_playreport", "onPlayerError(%s)", exoPlaybackException.toString());
            lX r5 = ErrorCodeUtils.m1126(exoPlaybackException);
            for (If r7 : PlayerStateMachine.this.f1928) {
                r7.mo1106(r5);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity() {
            C1283.m16846("nf_playreport", "onPositionDiscontinuity()");
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onLoadingChanged(boolean z) {
        }
    };

    public interface If {
        /* renamed from: ˋ  reason: contains not printable characters */
        void mo1106(lX lXVar);

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo1107(State state, State state2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1100(If r2) {
        this.f1928.add(r2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1104(ExoPlayer exoPlayer) {
        exoPlayer.addListener(this.f1933);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public State m1101() {
        return this.f1932;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m1098() {
        return m1101() == State.PAUSED;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m1103() {
        return this.f1931.m8660();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1099() {
        m1096(State.SEEKING);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1102() {
        m1096(State.SUBTITLE_STALLED);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m1105() {
        m1096(State.AUDIO);
        this.f1929 = true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1096(State state) {
        if (this.f1932 == State.INITIALIZING && state != State.PLAYING) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - invalid transition (init). ignoring", this.f1932, state);
        } else if (this.f1930 && state == State.PLAYING) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - spurious transition (seek). ignoring", this.f1932, state);
        } else if (this.f1929 && state == State.PLAYING) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - spurious transition (audio). ignoring", this.f1932, state);
        } else if (this.f1932 == State.AUDIO && state == State.REBUFFERING) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - info loss transition (audio). ignoring", this.f1932, state);
        } else if (this.f1932 == State.SEEKING && state == State.REBUFFERING) {
            this.f1930 = false;
            C1283.m16848("nf_playreport", "setState(%s -> %s) - info loss transition (seek). ignoring", this.f1932, state);
        } else if (this.f1932 == State.SEEKING && state == State.PAUSED) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - info loss transition (seek). ignoring", this.f1932, state);
        } else if (this.f1932 == State.SEEKING && state == State.SUBTITLE_STALLED) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - info loss transition (seek). ignoring", this.f1932, state);
        } else if (this.f1932 == State.SUBTITLE_STALLED && state == State.PAUSED) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - info loss transition (subtitle rebuffer). ignoring", this.f1932, state);
        } else if (this.f1932 == State.SEEKING && state == State.PAUSED) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - info loss transition (seek). ignoring", this.f1932, state);
        } else if (this.f1932 == State.SEEKING && state == State.SUBTITLE_STALLED) {
            C1283.m16848("nf_playreport", "setState(%s -> %s) - info loss transition (seek). ignoring", this.f1932, state);
        } else if (state != this.f1932) {
            C1283.m16851("nf_playreport", "setState(%s -> %s)", this.f1932, state);
            for (If r0 : this.f1928) {
                r0.mo1107(this.f1932, state);
            }
            this.f1930 = state == State.SEEKING;
            this.f1931 = new lR();
            this.f1932 = state;
        }
    }

    public enum State {
        INITIALIZING,
        PLAYING,
        REBUFFERING,
        SUBTITLE_STALLED,
        PAUSED,
        SEEKING,
        SKIPPING,
        AUDIO;

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m1108() {
            return this == INITIALIZING || this == REBUFFERING || this == SEEKING || this == SKIPPING || this == AUDIO || this == SUBTITLE_STALLED;
        }
    }
}
