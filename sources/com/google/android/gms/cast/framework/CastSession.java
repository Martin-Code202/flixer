package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzavl;
import com.google.android.gms.internal.zzavn;
import com.google.android.gms.internal.zzawp;
import com.google.android.gms.internal.zzazx;
import com.google.android.gms.internal.zzazy;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class CastSession extends Session {
    private static final zzazx zzejc = new zzazx("CastSession");
    private final Context zzeog;
    private final CastOptions zzeom;
    private final Set<Cast.Listener> zzeov = new HashSet();
    private final zzl zzeow;
    private final Cast.CastApi zzeox;
    private final zzavn zzeoy;
    private final zzawp zzeoz;
    private GoogleApiClient zzepa;
    private RemoteMediaClient zzepb;
    private CastDevice zzepc;
    private Cast.ApplicationConnectionResult zzepd;

    class zza implements ResultCallback<Cast.ApplicationConnectionResult> {
        private String zzepe;

        zza(String str) {
            this.zzepe = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Result] */
        @Override // com.google.android.gms.common.api.ResultCallback
        public final /* synthetic */ void onResult(Cast.ApplicationConnectionResult applicationConnectionResult) {
            Cast.ApplicationConnectionResult applicationConnectionResult2 = applicationConnectionResult;
            CastSession.this.zzepd = applicationConnectionResult2;
            try {
                if (applicationConnectionResult2.getStatus().isSuccess()) {
                    CastSession.zzejc.zzb("%s() -> success result", this.zzepe);
                    CastSession.this.zzepb = new RemoteMediaClient(new zzazy(null, zzh.zzald()), CastSession.this.zzeox);
                    try {
                        CastSession.this.zzepb.zzc(CastSession.this.zzepa);
                        CastSession.this.zzepb.zzadd();
                        CastSession.this.zzepb.requestStatus();
                        CastSession.this.zzeoz.zza(CastSession.this.zzepb, CastSession.this.getCastDevice());
                    } catch (IOException e) {
                        CastSession.zzejc.zza(e, "Exception when setting GoogleApiClient.", new Object[0]);
                        CastSession.this.zzepb = null;
                    }
                    CastSession.this.zzeow.zza(applicationConnectionResult2.getApplicationMetadata(), applicationConnectionResult2.getApplicationStatus(), applicationConnectionResult2.getSessionId(), applicationConnectionResult2.getWasLaunched());
                    return;
                }
                CastSession.zzejc.zzb("%s() -> failure result", this.zzepe);
                CastSession.this.zzeow.zzbe(applicationConnectionResult2.getStatus().getStatusCode());
            } catch (RemoteException e2) {
                CastSession.zzejc.zzb(e2, "Unable to call %s on %s.", "methods", zzl.class.getSimpleName());
            }
        }
    }

    class zzb extends zzi {
        private zzb() {
        }

        @Override // com.google.android.gms.cast.framework.zzh
        public final void zza(String str, LaunchOptions launchOptions) {
            CastSession.this.zzeox.launchApplication(CastSession.this.zzepa, str, launchOptions).setResultCallback(new zza("launchApplication"));
        }

        @Override // com.google.android.gms.cast.framework.zzh
        public final void zzbd(int i) {
            CastSession.this.zzbd(i);
        }

        @Override // com.google.android.gms.cast.framework.zzh
        public final void zzez(String str) {
            CastSession.this.zzeox.stopApplication(CastSession.this.zzepa, str);
        }

        @Override // com.google.android.gms.cast.framework.zzh
        public final void zzr(String str, String str2) {
            CastSession.this.zzeox.joinApplication(CastSession.this.zzepa, str, str2).setResultCallback(new zza("joinApplication"));
        }
    }

    /* access modifiers changed from: package-private */
    public class zzc extends Cast.Listener {
        private zzc() {
        }

        @Override // com.google.android.gms.cast.Cast.Listener
        public final void onActiveInputStateChanged(int i) {
            for (Cast.Listener listener : new HashSet(CastSession.this.zzeov)) {
                listener.onActiveInputStateChanged(i);
            }
        }

        @Override // com.google.android.gms.cast.Cast.Listener
        public final void onApplicationDisconnected(int i) {
            CastSession.this.zzbd(i);
            CastSession.this.notifySessionEnded(i);
            for (Cast.Listener listener : new HashSet(CastSession.this.zzeov)) {
                listener.onApplicationDisconnected(i);
            }
        }

        @Override // com.google.android.gms.cast.Cast.Listener
        public final void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
            for (Cast.Listener listener : new HashSet(CastSession.this.zzeov)) {
                listener.onApplicationMetadataChanged(applicationMetadata);
            }
        }

        @Override // com.google.android.gms.cast.Cast.Listener
        public final void onApplicationStatusChanged() {
            for (Cast.Listener listener : new HashSet(CastSession.this.zzeov)) {
                listener.onApplicationStatusChanged();
            }
        }

        @Override // com.google.android.gms.cast.Cast.Listener
        public final void onStandbyStateChanged(int i) {
            for (Cast.Listener listener : new HashSet(CastSession.this.zzeov)) {
                listener.onStandbyStateChanged(i);
            }
        }

        @Override // com.google.android.gms.cast.Cast.Listener
        public final void onVolumeChanged() {
            for (Cast.Listener listener : new HashSet(CastSession.this.zzeov)) {
                listener.onVolumeChanged();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private zzd() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void onConnected(Bundle bundle) {
            try {
                if (CastSession.this.zzepb != null) {
                    try {
                        CastSession.this.zzepb.zzadd();
                        CastSession.this.zzepb.requestStatus();
                    } catch (IOException e) {
                        CastSession.zzejc.zza(e, "Exception when setting GoogleApiClient.", new Object[0]);
                        CastSession.this.zzepb = null;
                    }
                }
                CastSession.this.zzeow.onConnected(bundle);
            } catch (RemoteException e2) {
                CastSession.zzejc.zzb(e2, "Unable to call %s on %s.", "onConnected", zzl.class.getSimpleName());
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            try {
                CastSession.this.zzeow.onConnectionFailed(connectionResult);
            } catch (RemoteException e) {
                CastSession.zzejc.zzb(e, "Unable to call %s on %s.", "onConnectionFailed", zzl.class.getSimpleName());
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void onConnectionSuspended(int i) {
            try {
                CastSession.this.zzeow.onConnectionSuspended(i);
            } catch (RemoteException e) {
                CastSession.zzejc.zzb(e, "Unable to call %s on %s.", "onConnectionSuspended", zzl.class.getSimpleName());
            }
        }
    }

    public CastSession(Context context, String str, String str2, CastOptions castOptions, Cast.CastApi castApi, zzavn zzavn, zzawp zzawp) {
        super(context, str, str2);
        this.zzeog = context.getApplicationContext();
        this.zzeom = castOptions;
        this.zzeox = castApi;
        this.zzeoy = zzavn;
        this.zzeoz = zzawp;
        this.zzeow = zzavl.zza(context, castOptions, zzacb(), new zzb());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzbd(int i) {
        this.zzeoz.zzbg(i);
        if (this.zzepa != null) {
            this.zzepa.disconnect();
            this.zzepa = null;
        }
        this.zzepc = null;
        if (this.zzepb != null) {
            try {
                this.zzepb.zzc((GoogleApiClient) null);
            } catch (IOException e) {
                zzejc.zza(e, "Exception when setting GoogleApiClient.", new Object[0]);
            }
            this.zzepb = null;
        }
        this.zzepd = null;
    }

    private final void zzf(Bundle bundle) {
        this.zzepc = CastDevice.getFromBundle(bundle);
        if (this.zzepc != null) {
            if (this.zzepa != null) {
                this.zzepa.disconnect();
                this.zzepa = null;
            }
            zzejc.zzb("Acquiring a connection to Google Play Services for %s", this.zzepc);
            zzd zzd2 = new zzd();
            Context context = this.zzeog;
            CastDevice castDevice = this.zzepc;
            CastOptions castOptions = this.zzeom;
            zzc zzc2 = new zzc();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", (castOptions == null || castOptions.getCastMediaOptions() == null || castOptions.getCastMediaOptions().getNotificationOptions() == null) ? false : true);
            this.zzepa = new GoogleApiClient.Builder(context).addApi(Cast.API, new Cast.CastOptions.Builder(castDevice, zzc2).zze(bundle2).build()).addConnectionCallbacks(zzd2).addOnConnectionFailedListener(zzd2).build();
            this.zzepa.connect();
        } else if (isResuming()) {
            notifyFailedToResumeSession(8);
        } else {
            notifyFailedToStartSession(8);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.cast.framework.Session
    public void end(boolean z) {
        try {
            this.zzeow.zzb(z, 0);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "disconnectFromDevice", zzl.class.getSimpleName());
        }
        notifySessionEnded(0);
    }

    public CastDevice getCastDevice() {
        zzbp.zzfy("Must be called from the main thread.");
        return this.zzepc;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        zzbp.zzfy("Must be called from the main thread.");
        return this.zzepb;
    }

    @Override // com.google.android.gms.cast.framework.Session
    public long getSessionRemainingTimeMs() {
        zzbp.zzfy("Must be called from the main thread.");
        if (this.zzepb == null) {
            return 0;
        }
        return this.zzepb.getStreamDuration() - this.zzepb.getApproximateStreamPosition();
    }

    public void removeMessageReceivedCallbacks(String str) {
        zzbp.zzfy("Must be called from the main thread.");
        if (this.zzepa != null) {
            this.zzeox.removeMessageReceivedCallbacks(this.zzepa, str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.cast.framework.Session
    public void resume(Bundle bundle) {
        zzf(bundle);
    }

    public PendingResult<Status> sendMessage(String str, String str2) {
        zzbp.zzfy("Must be called from the main thread.");
        if (this.zzepa != null) {
            return this.zzeox.sendMessage(this.zzepa, str, str2);
        }
        return null;
    }

    public void setMessageReceivedCallbacks(String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        zzbp.zzfy("Must be called from the main thread.");
        if (this.zzepa != null) {
            this.zzeox.setMessageReceivedCallbacks(this.zzepa, str, messageReceivedCallback);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.cast.framework.Session
    public void start(Bundle bundle) {
        zzf(bundle);
    }
}
