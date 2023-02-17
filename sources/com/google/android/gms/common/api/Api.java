package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzam;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;
public final class Api<O extends ApiOptions> {
    private final String mName;
    private final zza<?, O> zzfge;
    private final zzh<?, O> zzfgf = null;
    private final zzf<?> zzfgg;
    private final zzi<?> zzfgh;

    public interface ApiOptions {

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class zza<T extends zze, O> extends zzd<T, O> {
        public abstract T zza(Context context, Looper looper, zzq zzq, O o2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
    }

    public interface zzb {
    }

    public static class zzc<C extends zzb> {
    }

    public static abstract class zzd<T extends zzb, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> zzn(O o2) {
            return Collections.emptyList();
        }
    }

    public interface zze extends zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        boolean isConnecting();

        void zza(zzam zzam, Set<Scope> set);

        void zza(zzj zzj);

        boolean zzaac();

        boolean zzaal();

        Intent zzaam();

        boolean zzaff();

        IBinder zzafg();
    }

    public static final class zzf<C extends zze> extends zzc<C> {
    }

    public interface zzg<T extends IInterface> extends zzb {
    }

    public static abstract class zzh<T extends zzg, O> extends zzd<T, O> {
    }

    public static final class zzi<C extends zzg> extends zzc<C> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.common.api.Api$zza<C extends com.google.android.gms.common.api.Api$zze, O extends com.google.android.gms.common.api.Api$ApiOptions> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.common.api.Api$zzf<C extends com.google.android.gms.common.api.Api$zze> */
    /* JADX WARN: Multi-variable type inference failed */
    public <C extends zze> Api(String str, zza<C, O> zza2, zzf<C> zzf2) {
        zzbp.zzb(zza2, "Cannot construct an Api with a null ClientBuilder");
        zzbp.zzb(zzf2, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.zzfge = zza2;
        this.zzfgg = zzf2;
        this.zzfgh = null;
    }

    public final String getName() {
        return this.mName;
    }

    public final zzd<?, O> zzafc() {
        return this.zzfge;
    }

    public final zza<?, O> zzafd() {
        zzbp.zza(this.zzfge != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zzfge;
    }

    public final zzc<?> zzafe() {
        if (this.zzfgg != null) {
            return this.zzfgg;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }
}
