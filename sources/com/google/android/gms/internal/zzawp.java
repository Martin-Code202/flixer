package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.media.MediaNotificationService;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.util.zzp;
public final class zzawp implements RemoteMediaClient.Listener {
    private boolean mIsAttached;
    private CastDevice zzeii;
    private final Context zzeog;
    private RemoteMediaClient zzepb;
    private final zzawd zzepz;
    private final CastOptions zzevf;
    private final ComponentName zzevg;
    private final zzawe zzevh;
    private final zzawe zzevi;
    private MediaSessionCompat zzevj;
    private MediaSessionCompat.Callback zzevk;

    public zzawp(Context context, CastOptions castOptions, zzawd zzawd) {
        this.zzeog = context;
        this.zzevf = castOptions;
        this.zzepz = zzawd;
        if (this.zzevf.getCastMediaOptions() == null || TextUtils.isEmpty(this.zzevf.getCastMediaOptions().getExpandedControllerActivityClassName())) {
            this.zzevg = null;
        } else {
            this.zzevg = new ComponentName(this.zzeog, this.zzevf.getCastMediaOptions().getExpandedControllerActivityClassName());
        }
        this.zzevh = new zzawe(this.zzeog);
        this.zzevh.zza(new zzawq(this));
        this.zzevi = new zzawe(this.zzeog);
        this.zzevi.zza(new zzawr(this));
    }

    private final Uri zza(MediaMetadata mediaMetadata, int i) {
        WebImage onPickImage = this.zzevf.getCastMediaOptions().getImagePicker() != null ? this.zzevf.getCastMediaOptions().getImagePicker().onPickImage(mediaMetadata, i) : mediaMetadata.hasImages() ? mediaMetadata.getImages().get(0) : null;
        if (onPickImage == null) {
            return null;
        }
        return onPickImage.getUrl();
    }

    private final void zza(int i, MediaInfo mediaInfo) {
        PendingIntent pendingIntent;
        if (i == 0) {
            this.zzevj.setPlaybackState(new PlaybackStateCompat.Builder().setState(0, 0, 1.0f).build());
            this.zzevj.setMetadata(new MediaMetadataCompat.Builder().build());
            return;
        }
        this.zzevj.setPlaybackState(new PlaybackStateCompat.Builder().setState(i, 0, 1.0f).setActions(mediaInfo.getStreamType() == 2 ? 5 : 512).build());
        MediaSessionCompat mediaSessionCompat = this.zzevj;
        if (this.zzevg == null) {
            pendingIntent = null;
        } else {
            Intent intent = new Intent();
            intent.setComponent(this.zzevg);
            pendingIntent = PendingIntent.getActivity(this.zzeog, 0, intent, 134217728);
        }
        mediaSessionCompat.setSessionActivity(pendingIntent);
        MediaMetadata metadata = mediaInfo.getMetadata();
        this.zzevj.setMetadata(zzadk().putString("android.media.metadata.TITLE", metadata.getString("com.google.android.gms.cast.metadata.TITLE")).putString("android.media.metadata.DISPLAY_TITLE", metadata.getString("com.google.android.gms.cast.metadata.TITLE")).putString("android.media.metadata.DISPLAY_SUBTITLE", metadata.getString("com.google.android.gms.cast.metadata.SUBTITLE")).putLong("android.media.metadata.DURATION", mediaInfo.getStreamDuration()).build());
        Uri zza = zza(metadata, 0);
        if (zza != null) {
            this.zzevh.zzl(zza);
        } else {
            zza((Bitmap) null, 0);
        }
        Uri zza2 = zza(metadata, 3);
        if (zza2 != null) {
            this.zzevi.zzl(zza2);
        } else {
            zza((Bitmap) null, 3);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Bitmap bitmap, int i) {
        if (i == 0) {
            if (bitmap != null) {
                this.zzevj.setMetadata(zzadk().putBitmap("android.media.metadata.DISPLAY_ICON", bitmap).build());
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(0);
            this.zzevj.setMetadata(zzadk().putBitmap("android.media.metadata.DISPLAY_ICON", createBitmap).build());
        } else if (i == 3) {
            this.zzevj.setMetadata(zzadk().putBitmap("android.media.metadata.ALBUM_ART", bitmap).build());
        }
    }

    private final MediaMetadataCompat.Builder zzadk() {
        MediaMetadataCompat metadata = this.zzevj.getController().getMetadata();
        return metadata == null ? new MediaMetadataCompat.Builder() : new MediaMetadataCompat.Builder(metadata);
    }

    private final void zzadl() {
        if (this.zzevf.getCastMediaOptions().getNotificationOptions() != null) {
            Intent intent = new Intent(this.zzeog, MediaNotificationService.class);
            intent.setPackage(this.zzeog.getPackageName());
            intent.setAction("com.google.android.gms.cast.framework.action.UPDATE_NOTIFICATION");
            this.zzeog.stopService(intent);
        }
    }

    private final void zzadm() {
        if (this.zzevf.getEnableReconnectionService()) {
            Intent intent = new Intent(this.zzeog, ReconnectionService.class);
            intent.setPackage(this.zzeog.getPackageName());
            this.zzeog.stopService(intent);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onAdBreakStatusUpdated() {
        zzax(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onMetadataUpdated() {
        zzax(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onPreloadStatusUpdated() {
        zzax(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onQueueStatusUpdated() {
        zzax(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onSendingRemoteMediaRequest() {
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onStatusUpdated() {
        zzax(false);
    }

    public final void zza(RemoteMediaClient remoteMediaClient, CastDevice castDevice) {
        if (!this.mIsAttached && this.zzevf != null && this.zzevf.getCastMediaOptions() != null && remoteMediaClient != null && castDevice != null) {
            this.zzepb = remoteMediaClient;
            this.zzepb.addListener(this);
            this.zzeii = castDevice;
            if (!zzp.zzalk()) {
                ((AudioManager) this.zzeog.getSystemService("audio")).requestAudioFocus(null, 3, 3);
            }
            ComponentName componentName = new ComponentName(this.zzeog, this.zzevf.getCastMediaOptions().getMediaIntentReceiverClassName());
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            this.zzevj = new MediaSessionCompat(this.zzeog, "CastMediaSession", componentName, PendingIntent.getBroadcast(this.zzeog, 0, intent, 0));
            this.zzevj.setFlags(3);
            zza(0, (MediaInfo) null);
            if (this.zzeii != null && !TextUtils.isEmpty(this.zzeii.getFriendlyName())) {
                this.zzevj.setMetadata(new MediaMetadataCompat.Builder().putString("android.media.metadata.ALBUM_ARTIST", this.zzeog.getResources().getString(R.string.cast_casting_to_device, this.zzeii.getFriendlyName())).build());
            }
            this.zzevk = new zzaws(this);
            this.zzevj.setCallback(this.zzevk);
            this.zzevj.setActive(true);
            this.zzepz.setMediaSessionCompat(this.zzevj);
            this.mIsAttached = true;
            zzax(false);
        }
    }

    public final void zzax(boolean z) {
        int i;
        if (this.zzepb != null) {
            MediaStatus mediaStatus = this.zzepb.getMediaStatus();
            MediaInfo mediaInfo = mediaStatus == null ? null : mediaStatus.getMediaInfo();
            MediaMetadata metadata = mediaInfo == null ? null : mediaInfo.getMetadata();
            boolean z2 = false;
            if (mediaStatus != null && mediaInfo != null && metadata != null) {
                switch (this.zzepb.getPlayerState()) {
                    case 1:
                        int idleReason = mediaStatus.getIdleReason();
                        boolean z3 = this.zzepb.isLiveStream() && idleReason == 2;
                        int loadingItemId = mediaStatus.getLoadingItemId();
                        z2 = loadingItemId != 0 && (idleReason == 1 || idleReason == 3);
                        if (!z3) {
                            MediaQueueItem queueItemById = mediaStatus.getQueueItemById(loadingItemId);
                            if (queueItemById == null) {
                                i = 0;
                                break;
                            } else {
                                mediaInfo = queueItemById.getMedia();
                                i = 6;
                                break;
                            }
                        } else {
                            i = 2;
                            break;
                        }
                        break;
                    case 2:
                        i = 3;
                        break;
                    case 3:
                        i = 2;
                        break;
                    case 4:
                        i = 6;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            zza(i, mediaInfo);
            if (i == 0) {
                zzadl();
                zzadm();
                return;
            }
            if (!(this.zzevf.getCastMediaOptions().getNotificationOptions() == null || this.zzepb == null)) {
                Intent intent = new Intent(this.zzeog, MediaNotificationService.class);
                intent.putExtra("extra_media_notification_force_update", z);
                intent.setPackage(this.zzeog.getPackageName());
                intent.setAction("com.google.android.gms.cast.framework.action.UPDATE_NOTIFICATION");
                intent.putExtra("extra_media_info", this.zzepb.getMediaInfo());
                intent.putExtra("extra_remote_media_client_player_state", this.zzepb.getPlayerState());
                intent.putExtra("extra_cast_device", this.zzeii);
                intent.putExtra("extra_media_session_token", this.zzevj == null ? null : this.zzevj.getSessionToken());
                MediaStatus mediaStatus2 = this.zzepb.getMediaStatus();
                if (mediaStatus2 != null) {
                    boolean z4 = false;
                    boolean z5 = false;
                    switch (mediaStatus2.getQueueRepeatMode()) {
                        case 1:
                        case 2:
                        case 3:
                            z4 = true;
                            z5 = true;
                            break;
                        default:
                            Integer indexById = mediaStatus2.getIndexById(mediaStatus2.getCurrentItemId());
                            if (indexById != null) {
                                if (indexById.intValue() > 0) {
                                    z5 = true;
                                }
                                if (indexById.intValue() < mediaStatus2.getQueueItemCount() - 1) {
                                    z4 = true;
                                    break;
                                }
                            }
                            break;
                    }
                    intent.putExtra("extra_can_skip_next", z4);
                    intent.putExtra("extra_can_skip_prev", z5);
                }
                this.zzeog.startService(intent);
            }
            if (!z2 && this.zzevf.getEnableReconnectionService()) {
                Intent intent2 = new Intent(this.zzeog, ReconnectionService.class);
                intent2.setPackage(this.zzeog.getPackageName());
                this.zzeog.startService(intent2);
            }
        }
    }

    public final void zzbg(int i) {
        if (this.mIsAttached) {
            this.mIsAttached = false;
            if (this.zzepb != null) {
                this.zzepb.removeListener(this);
            }
            if (!zzp.zzalk()) {
                ((AudioManager) this.zzeog.getSystemService("audio")).abandonAudioFocus(null);
            }
            this.zzepz.setMediaSessionCompat(null);
            if (this.zzevh != null) {
                this.zzevh.clear();
            }
            if (this.zzevi != null) {
                this.zzevi.clear();
            }
            if (this.zzevj != null) {
                this.zzevj.setSessionActivity(null);
                this.zzevj.setCallback(null);
                this.zzevj.setMetadata(new MediaMetadataCompat.Builder().build());
                zza(0, (MediaInfo) null);
                this.zzevj.setActive(false);
                this.zzevj.release();
                this.zzevj = null;
            }
            this.zzepb = null;
            this.zzeii = null;
            this.zzevk = null;
            zzadl();
            if (i == 0) {
                zzadm();
            }
        }
    }
}
