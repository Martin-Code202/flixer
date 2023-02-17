package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzayu;
import com.google.android.gms.internal.zzaze;
import com.google.android.gms.internal.zzazw;
import java.io.IOException;
public final class Cast {
    public static final Api<CastOptions> API = new Api<>("Cast.API", zzdwp, zzazw.zzfbx);
    public static final CastApi CastApi = new CastApi.zza();
    private static Api.zza<zzaze, CastOptions> zzdwp = new zze();

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    @Deprecated
    public interface CastApi {

        public static final class zza implements CastApi {
            private final PendingResult<ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, String str, String str2, zzab zzab) {
                return googleApiClient.zze(new zzi(this, googleApiClient, str, str2, null));
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str) {
                return zza(googleApiClient, str, null, null);
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
                return zza(googleApiClient, str, str2, null);
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str) {
                return googleApiClient.zze(new zzg(this, googleApiClient, str));
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
                return googleApiClient.zze(new zzh(this, googleApiClient, str, launchOptions));
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) {
                try {
                    ((zzaze) googleApiClient.zza(zzazw.zzfbx)).removeMessageReceivedCallbacks(str);
                } catch (RemoteException unused) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2) {
                return googleApiClient.zze(new zzf(this, googleApiClient, str, str2));
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) {
                try {
                    ((zzaze) googleApiClient.zza(zzazw.zzfbx)).setMessageReceivedCallbacks(str, messageReceivedCallback);
                } catch (RemoteException unused) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str) {
                return googleApiClient.zze(new zzl(this, googleApiClient, str));
            }
        }

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str);

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements Api.ApiOptions.HasOptions {
        final Bundle extras;
        final CastDevice zzeif;
        final Listener zzeig;
        private final int zzeih;

        public static final class Builder {
            private Bundle mExtras;
            CastDevice zzeii;
            Listener zzeij;
            private int zzeik = 0;

            public Builder(CastDevice castDevice, Listener listener) {
                zzbp.zzb(castDevice, "CastDevice parameter cannot be null");
                zzbp.zzb(listener, "CastListener parameter cannot be null");
                this.zzeii = castDevice;
                this.zzeij = listener;
            }

            public final CastOptions build() {
                return new CastOptions(this, null);
            }

            public final Builder zze(Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzeif = builder.zzeii;
            this.zzeig = builder.zzeij;
            this.zzeih = builder.zzeik;
            this.extras = builder.mExtras;
        }

        /* synthetic */ CastOptions(Builder builder, zze zze) {
            this(builder);
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(castDevice, listener);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int i) {
        }

        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int i) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* access modifiers changed from: package-private */
    public static abstract class zza extends zzayu<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public void zza(zzaze zzaze) {
        }

        @Override // com.google.android.gms.common.api.internal.zzs
        public final /* synthetic */ Result zzb(Status status) {
            return new zzm(this, status);
        }
    }
}
