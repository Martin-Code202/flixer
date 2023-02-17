package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzayu;
import com.google.android.gms.internal.zzaze;
import com.google.android.gms.internal.zzazy;
import com.google.android.gms.internal.zzbab;
import com.google.android.gms.internal.zzbac;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
public class RemoteMediaClient implements Cast.MessageReceivedCallback {
    public static final String NAMESPACE = zzazy.NAMESPACE;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final List<Listener> mListeners = new CopyOnWriteArrayList();
    private final Object mLock = new Object();
    private final zzazy zzemk;
    private final Cast.CastApi zzeox;
    private final zza zzety = new zza();
    private GoogleApiClient zzetz;
    private final Map<ProgressListener, zzd> zzeua = new ConcurrentHashMap();
    private final Map<Long, zzd> zzeub = new ConcurrentHashMap();
    private ParseAdsInfoCallback zzeuc;

    public interface Listener {
        void onAdBreakStatusUpdated();

        void onMetadataUpdated();

        void onPreloadStatusUpdated();

        void onQueueStatusUpdated();

        void onSendingRemoteMediaRequest();

        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
    }

    public interface ParseAdsInfoCallback {
        List<AdBreakInfo> parseAdBreaksFromMediaStatus(MediaStatus mediaStatus);

        boolean parseIsPlayingAdFromMediaStatus(MediaStatus mediaStatus);
    }

    public interface ProgressListener {
        void onProgressUpdated(long j, long j2);
    }

    class zza implements zzbab {
        private GoogleApiClient zzenn;
        private long zzeno = 0;

        public zza() {
        }

        @Override // com.google.android.gms.internal.zzbab
        public final void zza(String str, String str2, long j, String str3) {
            if (this.zzenn == null) {
                throw new IOException("No GoogleApiClient available");
            }
            RemoteMediaClient.this.zzeox.sendMessage(this.zzenn, str, str2).setResultCallback(new zzal(this, j));
        }

        @Override // com.google.android.gms.internal.zzbab
        public final long zzabr() {
            long j = this.zzeno + 1;
            this.zzeno = j;
            return j;
        }

        public final void zzb(GoogleApiClient googleApiClient) {
            this.zzenn = googleApiClient;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract class zzb extends zzayu<MediaChannelResult> {
        zzbac zzenr;
        private final boolean zzeug;

        zzb(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient) {
            this(googleApiClient, false);
        }

        zzb(GoogleApiClient googleApiClient, boolean z) {
            super(googleApiClient);
            this.zzeug = z;
            this.zzenr = new zzam(this, RemoteMediaClient.this);
        }

        @Override // com.google.android.gms.internal.zzayu, com.google.android.gms.common.api.internal.zzm, com.google.android.gms.common.api.internal.zzn
        public final /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((zzb) ((MediaChannelResult) obj));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$zzb] */
        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzm
        public final /* synthetic */ void zza(zzaze zzaze) {
            zzaze zzaze2 = zzaze;
            if (!this.zzeug) {
                for (Listener listener : RemoteMediaClient.this.mListeners) {
                    listener.onSendingRemoteMediaRequest();
                }
            }
            zzb(zzaze2);
        }

        @Override // com.google.android.gms.common.api.internal.zzs
        public final /* synthetic */ Result zzb(Status status) {
            return new zzan(this, status);
        }

        /* access modifiers changed from: package-private */
        public abstract void zzb(zzaze zzaze);
    }

    static final class zzc implements MediaChannelResult {
        private final Status mStatus;
        private final JSONObject zzeho;

        zzc(Status status, JSONObject jSONObject) {
            this.mStatus = status;
            this.zzeho = jSONObject;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.mStatus;
        }
    }

    /* access modifiers changed from: package-private */
    public class zzd {
        final /* synthetic */ RemoteMediaClient zzeud;
        private final Set<ProgressListener> zzeuj;
        private final long zzeuk;
        private final Runnable zzeul;
        private boolean zzeum;

        public final boolean isStarted() {
            return this.zzeum;
        }

        public final void start() {
            this.zzeud.mHandler.removeCallbacks(this.zzeul);
            this.zzeum = true;
            this.zzeud.mHandler.postDelayed(this.zzeul, this.zzeuk);
        }

        public final void stop() {
            this.zzeud.mHandler.removeCallbacks(this.zzeul);
            this.zzeum = false;
        }
    }

    public RemoteMediaClient(zzazy zzazy, Cast.CastApi castApi) {
        this.zzeox = castApi;
        this.zzemk = (zzazy) zzbp.zzu(zzazy);
        this.zzemk.zza(new zzn(this));
        this.zzemk.zza(this.zzety);
    }

    private final zzb zza(zzb zzb2) {
        try {
            this.zzetz.zze(zzb2);
            return zzb2;
        } catch (IllegalStateException unused) {
            zzb2.setResult((zzb) ((MediaChannelResult) zzb2.zzb(new Status(2100))));
            return zzb2;
        } catch (Throwable unused2) {
            return zzb2;
        }
    }

    private final void zza(Set<ProgressListener> set) {
        if (!isBuffering() && !isPaused()) {
            HashSet<ProgressListener> hashSet = new HashSet(set);
            if (isPlaying()) {
                for (ProgressListener progressListener : hashSet) {
                    progressListener.onProgressUpdated(getApproximateStreamPosition(), getStreamDuration());
                }
            } else if (isLoadingNextItem()) {
                MediaQueueItem loadingItem = getLoadingItem();
                if (!(loadingItem == null || loadingItem.getMedia() == null)) {
                    for (ProgressListener progressListener2 : hashSet) {
                        progressListener2.onProgressUpdated(0, loadingItem.getMedia().getStreamDuration());
                    }
                }
            } else {
                for (ProgressListener progressListener3 : hashSet) {
                    progressListener3.onProgressUpdated(0, 0);
                }
            }
        }
    }

    private final void zzade() {
        if (this.zzetz == null) {
            throw new IllegalStateException("No connection");
        }
    }

    /* access modifiers changed from: private */
    public final void zzadf() {
        for (zzd zzd2 : this.zzeub.values()) {
            if (hasMediaSession() && !zzd2.isStarted()) {
                zzd2.start();
            } else if (!hasMediaSession() && zzd2.isStarted()) {
                zzd2.stop();
            }
            if (zzd2.isStarted() && (isBuffering() || isPaused() || isLoadingNextItem())) {
                zza(zzd2.zzeuj);
            }
        }
    }

    public void addListener(Listener listener) {
        zzbp.zzfy("Must be called from the main thread.");
        if (listener != null) {
            this.mListeners.add(listener);
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.mLock) {
            zzbp.zzfy("Must be called from the main thread.");
            approximateStreamPosition = this.zzemk.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public int getIdleReason() {
        int idleReason;
        synchronized (this.mLock) {
            zzbp.zzfy("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            idleReason = mediaStatus != null ? mediaStatus.getIdleReason() : 0;
        }
        return idleReason;
    }

    public MediaQueueItem getLoadingItem() {
        zzbp.zzfy("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getLoadingItemId());
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.mLock) {
            zzbp.zzfy("Must be called from the main thread.");
            mediaInfo = this.zzemk.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.mLock) {
            zzbp.zzfy("Must be called from the main thread.");
            mediaStatus = this.zzemk.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        zzbp.zzfy("Must be called from the main thread.");
        return this.zzemk.getNamespace();
    }

    public int getPlayerState() {
        int playerState;
        synchronized (this.mLock) {
            zzbp.zzfy("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            playerState = mediaStatus != null ? mediaStatus.getPlayerState() : 1;
        }
        return playerState;
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.mLock) {
            zzbp.zzfy("Must be called from the main thread.");
            streamDuration = this.zzemk.getStreamDuration();
        }
        return streamDuration;
    }

    public boolean hasMediaSession() {
        zzbp.zzfy("Must be called from the main thread.");
        return isBuffering() || isPlaying() || isPaused() || isLoadingNextItem();
    }

    public boolean isBuffering() {
        zzbp.zzfy("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 4;
    }

    public boolean isLiveStream() {
        zzbp.zzfy("Must be called from the main thread.");
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null && mediaInfo.getStreamType() == 2;
    }

    public boolean isLoadingNextItem() {
        zzbp.zzfy("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return (mediaStatus == null || mediaStatus.getLoadingItemId() == 0) ? false : true;
    }

    public boolean isPaused() {
        zzbp.zzfy("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return false;
        }
        if (mediaStatus.getPlayerState() != 3) {
            return isLiveStream() && getIdleReason() == 2;
        }
        return true;
    }

    public boolean isPlaying() {
        zzbp.zzfy("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 2;
    }

    public boolean isPlayingAd() {
        zzbp.zzfy("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.isPlayingAd();
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzemk.zzff(str2);
    }

    public PendingResult<MediaChannelResult> pause() {
        return pause(null);
    }

    public PendingResult<MediaChannelResult> pause(JSONObject jSONObject) {
        zzbp.zzfy("Must be called from the main thread.");
        zzade();
        return zza(new zzae(this, this.zzetz, jSONObject));
    }

    public PendingResult<MediaChannelResult> play() {
        return play(null);
    }

    public PendingResult<MediaChannelResult> play(JSONObject jSONObject) {
        zzbp.zzfy("Must be called from the main thread.");
        zzade();
        return zza(new zzag(this, this.zzetz, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueNext(JSONObject jSONObject) {
        zzbp.zzfy("Must be called from the main thread.");
        zzade();
        return zza(new zzx(this, this.zzetz, jSONObject));
    }

    public PendingResult<MediaChannelResult> queuePrev(JSONObject jSONObject) {
        zzbp.zzfy("Must be called from the main thread.");
        zzade();
        return zza(new zzw(this, this.zzetz, jSONObject));
    }

    public void removeListener(Listener listener) {
        zzbp.zzfy("Must be called from the main thread.");
        if (listener != null) {
            this.mListeners.remove(listener);
        }
    }

    public PendingResult<MediaChannelResult> requestStatus() {
        zzbp.zzfy("Must be called from the main thread.");
        zzade();
        return zza(new zzak(this, this.zzetz));
    }

    public PendingResult<MediaChannelResult> seek(long j) {
        return seek(j, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(long j, int i, JSONObject jSONObject) {
        zzbp.zzfy("Must be called from the main thread.");
        zzade();
        return zza(new zzah(this, this.zzetz, j, i, jSONObject));
    }

    public void togglePlayback() {
        zzbp.zzfy("Must be called from the main thread.");
        int playerState = getPlayerState();
        if (playerState == 4 || playerState == 2) {
            pause();
        } else {
            play();
        }
    }

    public final void zzadd() {
        if (this.zzetz != null) {
            this.zzeox.setMessageReceivedCallbacks(this.zzetz, getNamespace(), this);
        }
    }

    public final void zzc(GoogleApiClient googleApiClient) {
        if (this.zzetz != googleApiClient) {
            if (this.zzetz != null) {
                this.zzemk.zzaee();
                this.zzeox.removeMessageReceivedCallbacks(this.zzetz, getNamespace());
                this.zzety.zzb(null);
                this.mHandler.removeCallbacksAndMessages(null);
            }
            this.zzetz = googleApiClient;
            if (this.zzetz != null) {
                this.zzety.zzb(this.zzetz);
            }
        }
    }
}
