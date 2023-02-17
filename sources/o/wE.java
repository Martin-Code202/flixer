package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
public class wE {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f11431 = wE.class.getSimpleName();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Cif f11432;

    /* renamed from: ॱ  reason: contains not printable characters */
    private MediaSessionCompat f11433;

    public wE(Context context, IPlayerFragment iPlayerFragment) {
        this.f11433 = new MediaSessionCompat(context.getApplicationContext(), "NetflixMediaSession");
        this.f11432 = new Cif(iPlayerFragment);
        this.f11433.setFlags(3);
        this.f11433.setMediaButtonReceiver(null);
        this.f11433.setCallback(this.f11432);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12278() {
        C1283.m16854(f11431, "startMediaSession");
        m12276(true);
        m12277(3);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12280() {
        C1283.m16862(f11431, "stopMediaSession");
        m12277(1);
        m12276(false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12277(int i) {
        long j;
        PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder();
        switch (i) {
            case 1:
            default:
                j = 4;
                break;
            case 2:
                j = 108;
                break;
            case 3:
                j = 106;
                break;
        }
        builder.setActions(j);
        builder.setState(i, -1, 1.0f);
        if (this.f11433 != null) {
            this.f11433.setPlaybackState(builder.build());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12279() {
        C1283.m16862(f11431, "destroy");
        if (this.f11433 != null) {
            this.f11433.release();
        }
        this.f11433 = null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12276(boolean z) {
        if (this.f11433 != null) {
            this.f11433.setActive(z);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12281(pT pTVar) {
        this.f11432.m12282(pTVar);
    }

    /* renamed from: o.wE$if  reason: invalid class name */
    static class Cif extends MediaSessionCompat.Callback {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final IPlayerFragment f11434;

        /* renamed from: ˋ  reason: contains not printable characters */
        private pT f11435;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final BroadcastReceiver f11436 = null;

        public Cif(IPlayerFragment iPlayerFragment) {
            this.f11434 = iPlayerFragment;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onPause() {
            this.f11434.mo2240();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onFastForward() {
            this.f11434.mo2264();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onRewind() {
            this.f11434.mo2256();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onSkipToNext() {
            if (this.f11435 != null) {
                CH r4 = C1841h.m6800(this.f11435);
                if (r4 != null) {
                    pF playable = r4.getPlayable();
                    this.f11434.mo2253(playable, VideoType.EPISODE, qN.f9509, playable.getPlayableBookmarkPosition());
                }
                this.f11435 = null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onStop() {
            this.f11434.mo2240();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onSeekTo(long j) {
            this.f11434.mo2258((int) j);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onPlay() {
            this.f11434.mo2247();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public void m12282(pT pTVar) {
            this.f11435 = pTVar;
        }
    }
}
