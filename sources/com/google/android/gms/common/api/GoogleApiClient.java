package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zzbd;
import com.google.android.gms.common.api.internal.zzcf;
import com.google.android.gms.common.api.internal.zzcv;
import com.google.android.gms.common.api.internal.zzdg;
import com.google.android.gms.common.api.internal.zzi;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.api.internal.zzw;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.internal.zzcpp;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
public abstract class GoogleApiClient {
    private static final Set<GoogleApiClient> zzfgz = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Looper zzakf;
        private Account zzduy;
        private String zzdxb;
        private final Set<Scope> zzfha = new HashSet();
        private final Set<Scope> zzfhb = new HashSet();
        private int zzfhc;
        private View zzfhd;
        private String zzfhe;
        private final Map<Api<?>, zzs> zzfhf = new ArrayMap();
        private final Map<Api<?>, Api.ApiOptions> zzfhg = new ArrayMap();
        private zzcf zzfhh;
        private int zzfhi = -1;
        private OnConnectionFailedListener zzfhj;
        private GoogleApiAvailability zzfhk = GoogleApiAvailability.getInstance();
        private Api.zza<? extends zzcps, zzcpt> zzfhl = zzcpp.zzdwp;
        private final ArrayList<ConnectionCallbacks> zzfhm = new ArrayList<>();
        private final ArrayList<OnConnectionFailedListener> zzfhn = new ArrayList<>();
        private boolean zzfho = false;

        public Builder(Context context) {
            this.mContext = context;
            this.zzakf = context.getMainLooper();
            this.zzdxb = context.getPackageName();
            this.zzfhe = context.getClass().getName();
        }

        public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzbp.zzb(api, "Api must not be null");
            this.zzfhg.put(api, null);
            List<Scope> zzn = api.zzafc().zzn(null);
            this.zzfhb.addAll(zzn);
            this.zzfha.addAll(zzn);
            return this;
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o2) {
            zzbp.zzb(api, "Api must not be null");
            zzbp.zzb(o2, "Null options are not permitted for this Api");
            this.zzfhg.put(api, o2);
            List<Scope> zzn = api.zzafc().zzn(o2);
            this.zzfhb.addAll(zzn);
            this.zzfha.addAll(zzn);
            return this;
        }

        public final Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            zzbp.zzb(connectionCallbacks, "Listener must not be null");
            this.zzfhm.add(connectionCallbacks);
            return this;
        }

        public final Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            zzbp.zzb(onConnectionFailedListener, "Listener must not be null");
            this.zzfhn.add(onConnectionFailedListener);
            return this;
        }

        public final GoogleApiClient build() {
            zzbp.zzb(!this.zzfhg.isEmpty(), "must call addApi() to add at least one API");
            zzq zzafr = zzafr();
            Api<?> api = null;
            boolean z = false;
            Map<Api<?>, zzs> zzaju = zzafr.zzaju();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            for (Api<?> api2 : this.zzfhg.keySet()) {
                Api.ApiOptions apiOptions = this.zzfhg.get(api2);
                boolean z2 = zzaju.get(api2) != null;
                arrayMap.put(api2, Boolean.valueOf(z2));
                zzw zzw = new zzw(api2, z2);
                arrayList.add(zzw);
                Api.zza<?, ?> zzafd = api2.zzafd();
                Api.zze zza = zzafd.zza(this.mContext, this.zzakf, zzafr, apiOptions, zzw, zzw);
                arrayMap2.put(api2.zzafe(), zza);
                if (zzafd.getPriority() == 1) {
                    z = apiOptions != null;
                }
                if (zza.zzaal()) {
                    if (api != null) {
                        String name = api2.getName();
                        String name2 = api.getName();
                        throw new IllegalStateException(new StringBuilder(String.valueOf(name2).length() + String.valueOf(name).length() + 21).append(name).append(" cannot be used with ").append(name2).toString());
                    }
                    api = api2;
                }
            }
            if (api != null) {
                if (z) {
                    String name3 = api.getName();
                    throw new IllegalStateException(new StringBuilder(String.valueOf(name3).length() + 82).append("With using ").append(name3).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
                }
                zzbp.zza(this.zzduy == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                zzbp.zza(this.zzfha.equals(this.zzfhb), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
            }
            zzbd zzbd = new zzbd(this.mContext, new ReentrantLock(), this.zzakf, zzafr, this.zzfhk, this.zzfhl, arrayMap, this.zzfhm, this.zzfhn, arrayMap2, this.zzfhi, zzbd.zza(arrayMap2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.zzfgz) {
                GoogleApiClient.zzfgz.add(zzbd);
            }
            if (this.zzfhi >= 0) {
                zzi.zza(this.zzfhh).zza(this.zzfhi, zzbd, this.zzfhj);
            }
            return zzbd;
        }

        public final Builder setHandler(Handler handler) {
            zzbp.zzb(handler, "Handler must not be null");
            this.zzakf = handler.getLooper();
            return this;
        }

        public final zzq zzafr() {
            zzcpt zzcpt = zzcpt.zzjno;
            if (this.zzfhg.containsKey(zzcpp.API)) {
                zzcpt = (zzcpt) this.zzfhg.get(zzcpp.API);
            }
            return new zzq(this.zzduy, this.zzfha, this.zzfhf, this.zzfhc, this.zzfhd, this.zzdxb, this.zzfhe, zzcpt);
        }
    }

    public interface ConnectionCallbacks {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public static Set<GoogleApiClient> zzafo() {
        Set<GoogleApiClient> set;
        synchronized (zzfgz) {
            set = zzfgz;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isConnected();

    public abstract void reconnect();

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public <C extends Api.zze> C zza(Api.zzc<C> zzc) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzdg zzdg) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzcv zzcv) {
        throw new UnsupportedOperationException();
    }

    public void zzafp() {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzdg zzdg) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        throw new UnsupportedOperationException();
    }
}
