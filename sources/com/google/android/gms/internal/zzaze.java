package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzab;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzq;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
public final class zzaze extends zzaa<zzazq> {
    private static final zzazx zzejm = new zzazx("CastClientImpl");
    private static final Object zzfbk = new Object();
    private static final Object zzfbl = new Object();
    private final Bundle mExtras;
    private final Cast.Listener zzeij;
    private double zzely;
    private boolean zzelz;
    private final CastDevice zzepc;
    private ApplicationMetadata zzfat;
    private final Map<String, Cast.MessageReceivedCallback> zzfau = new HashMap();
    private final long zzfav;
    private zzazg zzfaw;
    private String zzfax;
    private boolean zzfay;
    private boolean zzfaz;
    private boolean zzfba;
    private int zzfbb;
    private int zzfbc;
    private final AtomicLong zzfbd = new AtomicLong(0);
    private String zzfbe;
    private String zzfbf;
    private Bundle zzfbg;
    private final Map<Long, zzn<Status>> zzfbh = new HashMap();
    private zzn<Cast.ApplicationConnectionResult> zzfbi;
    private zzn<Status> zzfbj;

    public zzaze(Context context, Looper looper, zzq zzq, CastDevice castDevice, long j, Cast.Listener listener, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, zzq, connectionCallbacks, onConnectionFailedListener);
        this.zzepc = castDevice;
        this.zzeij = listener;
        this.zzfav = j;
        this.mExtras = bundle;
        zzaeg();
    }

    private final void zza(zzn<Cast.ApplicationConnectionResult> zzn) {
        synchronized (zzfbk) {
            if (this.zzfbi != null) {
                this.zzfbi.setResult(new zzazf(new Status(2002)));
            }
            this.zzfbi = zzn;
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzays zzays) {
        boolean z = false;
        String zzaed = zzays.zzaed();
        if (!zzazl.zza(zzaed, this.zzfax)) {
            this.zzfax = zzaed;
            z = true;
        }
        zzejm.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzfay));
        if (this.zzeij != null && (z || this.zzfay)) {
            this.zzeij.onApplicationStatusChanged();
        }
        this.zzfay = false;
    }

    /* access modifiers changed from: private */
    public final void zza(zzazm zzazm) {
        ApplicationMetadata applicationMetadata = zzazm.getApplicationMetadata();
        if (!zzazl.zza(applicationMetadata, this.zzfat)) {
            this.zzfat = applicationMetadata;
            this.zzeij.onApplicationMetadataChanged(this.zzfat);
        }
        boolean z = false;
        double volume = zzazm.getVolume();
        if (!Double.isNaN(volume) && Math.abs(volume - this.zzely) > 1.0E-7d) {
            this.zzely = volume;
            z = true;
        }
        boolean zzaeo = zzazm.zzaeo();
        if (zzaeo != this.zzelz) {
            this.zzelz = zzaeo;
            z = true;
        }
        zzejm.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzfaz));
        if (this.zzeij != null && (z || this.zzfaz)) {
            this.zzeij.onVolumeChanged();
        }
        boolean z2 = false;
        int activeInputState = zzazm.getActiveInputState();
        if (activeInputState != this.zzfbb) {
            this.zzfbb = activeInputState;
            z2 = true;
        }
        zzejm.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.zzfaz));
        if (this.zzeij != null && (z2 || this.zzfaz)) {
            this.zzeij.onActiveInputStateChanged(this.zzfbb);
        }
        boolean z3 = false;
        int standbyState = zzazm.getStandbyState();
        if (standbyState != this.zzfbc) {
            this.zzfbc = standbyState;
            z3 = true;
        }
        zzejm.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(this.zzfaz));
        if (this.zzeij != null && (z3 || this.zzfaz)) {
            this.zzeij.onStandbyStateChanged(this.zzfbc);
        }
        this.zzfaz = false;
    }

    /* access modifiers changed from: private */
    public final void zzaeg() {
        this.zzfba = false;
        this.zzfbb = -1;
        this.zzfbc = -1;
        this.zzfat = null;
        this.zzfax = null;
        this.zzely = 0.0d;
        this.zzelz = false;
    }

    private final void zzaei() {
        zzejm.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzfau) {
            this.zzfau.clear();
        }
    }

    private final void zzaej() {
        if (!this.zzfba || this.zzfaw == null || this.zzfaw.isDisposed()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    private final void zzc(zzn<Status> zzn) {
        synchronized (zzfbl) {
            if (this.zzfbj != null) {
                zzn.setResult(new Status(2001));
            } else {
                this.zzfbj = zzn;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    public final void disconnect() {
        zzejm.zzb("disconnect(); ServiceListener=%s, isConnected=%b", this.zzfaw, Boolean.valueOf(isConnected()));
        zzazg zzazg = this.zzfaw;
        this.zzfaw = null;
        if (zzazg == null || zzazg.zzaen() == null) {
            zzejm.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzaei();
        try {
            ((zzazq) super.zzajk()).disconnect();
        } catch (RemoteException | IllegalStateException e) {
            zzejm.zzb(e, "Error while disconnecting the controller interface: %s", e.getMessage());
        } finally {
            super.disconnect();
        }
    }

    @Override // com.google.android.gms.common.internal.zzd
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        zzaei();
    }

    public final void removeMessageReceivedCallbacks(String str) {
        Cast.MessageReceivedCallback remove;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzfau) {
            remove = this.zzfau.remove(str);
        }
        if (remove != null) {
            try {
                ((zzazq) super.zzajk()).zzfk(str);
            } catch (IllegalStateException e) {
                zzejm.zzb(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public final void setMessageReceivedCallbacks(String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        zzazl.zzfg(str);
        removeMessageReceivedCallbacks(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzfau) {
                this.zzfau.put(str, messageReceivedCallback);
            }
            ((zzazq) super.zzajk()).zzfj(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzejm.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.zzfba = true;
            this.zzfay = true;
            this.zzfaz = true;
        } else {
            this.zzfba = false;
        }
        int i3 = i;
        if (i == 1001) {
            this.zzfbg = new Bundle();
            this.zzfbg.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            i3 = 0;
        }
        super.zza(i3, iBinder, bundle, i2);
    }

    public final void zza(String str, LaunchOptions launchOptions, zzn<Cast.ApplicationConnectionResult> zzn) {
        zza(zzn);
        ((zzazq) super.zzajk()).zzb(str, launchOptions);
    }

    public final void zza(String str, zzn<Status> zzn) {
        zzc(zzn);
        ((zzazq) super.zzajk()).zzez(str);
    }

    public final void zza(String str, String str2, zzab zzab, zzn<Cast.ApplicationConnectionResult> zzn) {
        zza(zzn);
        if (zzab == null) {
            zzab = new zzab();
        }
        ((zzazq) super.zzajk()).zza(str, str2, zzab);
    }

    public final void zza(String str, String str2, zzn<Status> zzn) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzazl.zzfg(str);
            zzaej();
            long incrementAndGet = this.zzfbd.incrementAndGet();
            try {
                this.zzfbh.put(Long.valueOf(incrementAndGet), zzn);
                ((zzazq) super.zzajk()).zzb(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.zzfbh.remove(Long.valueOf(incrementAndGet));
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.internal.zzae
    public final Bundle zzaeh() {
        if (this.zzfbg == null) {
            return super.zzaeh();
        }
        Bundle bundle = this.zzfbg;
        this.zzfbg = null;
        return bundle;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return queryLocalInterface instanceof zzazq ? (zzazq) queryLocalInterface : new zzazr(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final Bundle zzzu() {
        Bundle bundle = new Bundle();
        zzejm.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzfbe, this.zzfbf);
        this.zzepc.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzfav);
        if (this.mExtras != null) {
            bundle.putAll(this.mExtras);
        }
        this.zzfaw = new zzazg(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzfaw.asBinder()));
        if (this.zzfbe != null) {
            bundle.putString("last_application_id", this.zzfbe);
            if (this.zzfbf != null) {
                bundle.putString("last_session_id", this.zzfbf);
            }
        }
        return bundle;
    }
}
