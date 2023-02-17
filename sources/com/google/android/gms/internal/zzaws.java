package com.google.android.gms.internal;

import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
/* access modifiers changed from: package-private */
public final class zzaws extends MediaSessionCompat.Callback {
    private /* synthetic */ zzawp zzevl;

    zzaws(zzawp zzawp) {
        this.zzevl = zzawp;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return true;
        }
        if (keyEvent.getKeyCode() != 127 && keyEvent.getKeyCode() != 126) {
            return true;
        }
        this.zzevl.zzepb.togglePlayback();
        return true;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onPause() {
        this.zzevl.zzepb.togglePlayback();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onPlay() {
        this.zzevl.zzepb.togglePlayback();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onStop() {
        if (this.zzevl.zzepb.isLiveStream()) {
            this.zzevl.zzepb.togglePlayback();
        }
    }
}
