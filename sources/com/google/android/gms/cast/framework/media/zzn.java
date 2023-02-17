package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.internal.zzazz;
import java.util.List;
/* access modifiers changed from: package-private */
public final class zzn implements zzazz {
    private /* synthetic */ RemoteMediaClient zzeud;

    zzn(RemoteMediaClient remoteMediaClient) {
        this.zzeud = remoteMediaClient;
    }

    private final void zzadg() {
        MediaStatus mediaStatus;
        if (this.zzeud.zzeuc != null && (mediaStatus = this.zzeud.getMediaStatus()) != null) {
            mediaStatus.zzaw(this.zzeud.zzeuc.parseIsPlayingAdFromMediaStatus(mediaStatus));
            List<AdBreakInfo> parseAdBreaksFromMediaStatus = this.zzeud.zzeuc.parseAdBreaksFromMediaStatus(mediaStatus);
            MediaInfo mediaInfo = this.zzeud.getMediaInfo();
            if (mediaInfo != null) {
                mediaInfo.zzx(parseAdBreaksFromMediaStatus);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzazz
    public final void onAdBreakStatusUpdated() {
        for (RemoteMediaClient.Listener listener : this.zzeud.mListeners) {
            listener.onAdBreakStatusUpdated();
        }
    }

    @Override // com.google.android.gms.internal.zzazz
    public final void onMetadataUpdated() {
        zzadg();
        for (RemoteMediaClient.Listener listener : this.zzeud.mListeners) {
            listener.onMetadataUpdated();
        }
    }

    @Override // com.google.android.gms.internal.zzazz
    public final void onPreloadStatusUpdated() {
        for (RemoteMediaClient.Listener listener : this.zzeud.mListeners) {
            listener.onPreloadStatusUpdated();
        }
    }

    @Override // com.google.android.gms.internal.zzazz
    public final void onQueueStatusUpdated() {
        for (RemoteMediaClient.Listener listener : this.zzeud.mListeners) {
            listener.onQueueStatusUpdated();
        }
    }

    @Override // com.google.android.gms.internal.zzazz
    public final void onStatusUpdated() {
        zzadg();
        this.zzeud.zzadf();
        for (RemoteMediaClient.Listener listener : this.zzeud.mListeners) {
            listener.onStatusUpdated();
        }
    }
}
