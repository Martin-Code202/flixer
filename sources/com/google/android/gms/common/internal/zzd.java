package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
public abstract class zzd<T extends IInterface> {
    private static String[] zzfti = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzakf;
    private final zze zzfkn;
    private int zzfsn;
    private long zzfso;
    private long zzfsp;
    private int zzfsq;
    private long zzfsr;
    private zzal zzfss;
    private final zzaf zzfst;
    private final Object zzfsu;
    private zzax zzfsv;
    protected zzj zzfsw;
    private T zzfsx;
    private final ArrayList<zzi<?>> zzfsy;
    private zzl zzfsz;
    private int zzfta;
    private final zzf zzftb;
    private final zzg zzftc;
    private final int zzftd;
    private final String zzfte;
    private ConnectionResult zzftf;
    private boolean zzftg;
    protected AtomicInteger zzfth;

    protected zzd(Context context, Looper looper, int i, zzf zzf, zzg zzg, String str) {
        this(context, looper, zzaf.zzce(context), zze.zzaex(), i, (zzf) zzbp.zzu(zzf), (zzg) zzbp.zzu(zzg), null);
    }

    protected zzd(Context context, Looper looper, zzaf zzaf, zze zze, int i, zzf zzf, zzg zzg, String str) {
        this.mLock = new Object();
        this.zzfsu = new Object();
        this.zzfsy = new ArrayList<>();
        this.zzfta = 1;
        this.zzftf = null;
        this.zzftg = false;
        this.zzfth = new AtomicInteger(0);
        this.mContext = (Context) zzbp.zzb(context, "Context must not be null");
        this.zzakf = (Looper) zzbp.zzb(looper, "Looper must not be null");
        this.zzfst = (zzaf) zzbp.zzb(zzaf, "Supervisor must not be null");
        this.zzfkn = (zze) zzbp.zzb(zze, "API availability must not be null");
        this.mHandler = new zzh(this, looper);
        this.zzftd = i;
        this.zzftb = zzf;
        this.zzftc = zzg;
        this.zzfte = str;
    }

    /* access modifiers changed from: private */
    public final void zza(int i, T t) {
        zzbp.zzbh((i == 4) == (t != null));
        synchronized (this.mLock) {
            this.zzfta = i;
            this.zzfsx = t;
            switch (i) {
                case 1:
                    if (this.zzfsz != null) {
                        this.zzfst.zza(zzhc(), zzaje(), 129, this.zzfsz, zzajf());
                        this.zzfsz = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (!(this.zzfsz == null || this.zzfss == null)) {
                        String zzakl = this.zzfss.zzakl();
                        String packageName = this.zzfss.getPackageName();
                        Log.e("GmsClient", new StringBuilder(String.valueOf(packageName).length() + String.valueOf(zzakl).length() + 70).append("Calling connect() while still connected, missing disconnect() for ").append(zzakl).append(" on ").append(packageName).toString());
                        this.zzfst.zza(this.zzfss.zzakl(), this.zzfss.getPackageName(), this.zzfss.zzakh(), this.zzfsz, zzajf());
                        this.zzfth.incrementAndGet();
                    }
                    this.zzfsz = new zzl(this, this.zzfth.get());
                    this.zzfss = new zzal(zzaje(), zzhc(), false, 129);
                    if (!this.zzfst.zza(new zzag(this.zzfss.zzakl(), this.zzfss.getPackageName(), this.zzfss.zzakh()), this.zzfsz, zzajf())) {
                        String zzakl2 = this.zzfss.zzakl();
                        String packageName2 = this.zzfss.getPackageName();
                        Log.e("GmsClient", new StringBuilder(String.valueOf(packageName2).length() + String.valueOf(zzakl2).length() + 34).append("unable to connect to service: ").append(zzakl2).append(" on ").append(packageName2).toString());
                        zza(16, (Bundle) null, this.zzfth.get());
                    }
                    break;
                case 4:
                    zza((zzd<T>) t);
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zza(int i, int i2, T t) {
        synchronized (this.mLock) {
            if (this.zzfta != i) {
                return false;
            }
            zza(i2, (int) t);
            return true;
        }
    }

    private final String zzajf() {
        return this.zzfte == null ? this.mContext.getClass().getName() : this.zzfte;
    }

    private final boolean zzajh() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfta == 3;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final boolean zzajn() {
        if (this.zzftg || TextUtils.isEmpty(zzhd()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(zzhd());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzcd(int i) {
        int i2;
        if (zzajh()) {
            i2 = 5;
            this.zzftg = true;
        } else {
            i2 = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i2, this.zzfth.get(), 16));
    }

    @Override // com.google.android.gms.common.api.Api.zze
    public void disconnect() {
        this.zzfth.incrementAndGet();
        synchronized (this.zzfsy) {
            int size = this.zzfsy.size();
            for (int i = 0; i < size; i++) {
                this.zzfsy.get(i).removeListener();
            }
            this.zzfsy.clear();
        }
        synchronized (this.zzfsu) {
            this.zzfsv = null;
        }
        zza(1, (int) null);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        zzax zzax;
        synchronized (this.mLock) {
            i = this.zzfta;
            t = this.zzfsx;
        }
        synchronized (this.zzfsu) {
            zzax = this.zzfsv;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) zzhd()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (zzax == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(zzax.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzfsp > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzfsp;
            String format = simpleDateFormat.format(new Date(this.zzfsp));
            append.println(new StringBuilder(String.valueOf(format).length() + 21).append(j).append(" ").append(format).toString());
        }
        if (this.zzfso > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            switch (this.zzfsn) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append((CharSequence) String.valueOf(this.zzfsn));
                    break;
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzfso;
            String format2 = simpleDateFormat.format(new Date(this.zzfso));
            append2.println(new StringBuilder(String.valueOf(format2).length() + 21).append(j2).append(" ").append(format2).toString());
        }
        if (this.zzfsr > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzfsq));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzfsr;
            String format3 = simpleDateFormat.format(new Date(this.zzfsr));
            append3.println(new StringBuilder(String.valueOf(format3).length() + 21).append(j3).append(" ").append(format3).toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzakf;
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfta == 4;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfta == 2 || this.zzfta == 3;
        }
        return z;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzfsq = connectionResult.getErrorCode();
        this.zzfsr = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public final void onConnectionSuspended(int i) {
        this.zzfsn = i;
        this.zzfso = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i2, -1, new zzo(this, i, null)));
    }

    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public void zza(T t) {
        this.zzfsp = System.currentTimeMillis();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0095, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        android.util.Log.w("GmsClient", "IGmsServiceBroker.getService failed", r6);
        zza(8, (android.os.IBinder) null, (android.os.Bundle) null, r10.zzfth.get());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.common.internal.zzam r11, java.util.Set<com.google.android.gms.common.api.Scope> r12) {
        /*
            r10 = this;
            android.os.Bundle r4 = r10.zzzu()
            com.google.android.gms.common.internal.zzy r8 = new com.google.android.gms.common.internal.zzy
            int r0 = r10.zzftd
            r8.<init>(r0)
            android.content.Context r0 = r10.mContext
            java.lang.String r9 = r0.getPackageName()
            r8.zzfud = r9
            r9 = r4
            r8.zzfug = r9
            r5 = r8
            if (r12 == 0) goto L_0x0028
            r9 = r12
            int r0 = r9.size()
            com.google.android.gms.common.api.Scope[] r0 = new com.google.android.gms.common.api.Scope[r0]
            java.lang.Object[] r0 = r12.toArray(r0)
            com.google.android.gms.common.api.Scope[] r0 = (com.google.android.gms.common.api.Scope[]) r0
            r5.zzfuf = r0
        L_0x0028:
            boolean r0 = r10.zzaac()
            if (r0 == 0) goto L_0x0050
            r8 = r10
            android.accounts.Account r0 = r10.getAccount()
            if (r0 == 0) goto L_0x003a
            android.accounts.Account r9 = r8.getAccount()
            goto L_0x0043
        L_0x003a:
            android.accounts.Account r9 = new android.accounts.Account
            java.lang.String r0 = "<<default account>>"
            java.lang.String r1 = "com.google"
            r9.<init>(r0, r1)
        L_0x0043:
            r8 = r5
            r5.zzfuh = r9
            r9 = r11
            if (r9 == 0) goto L_0x004f
            android.os.IBinder r0 = r9.asBinder()
            r8.zzfue = r0
        L_0x004f:
            goto L_0x005c
        L_0x0050:
            boolean r0 = r10.zzajl()
            if (r0 == 0) goto L_0x005c
            android.accounts.Account r9 = r10.getAccount()
            r5.zzfuh = r9
        L_0x005c:
            com.google.android.gms.common.zzc[] r9 = r10.zzaji()
            r5.zzfui = r9
            java.lang.Object r6 = r10.zzfsu     // Catch:{ DeadObjectException -> 0x0086, SecurityException -> 0x0093 }
            monitor-enter(r6)     // Catch:{ DeadObjectException -> 0x0086, SecurityException -> 0x0093 }
            com.google.android.gms.common.internal.zzax r0 = r10.zzfsv     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x007a
            com.google.android.gms.common.internal.zzax r0 = r10.zzfsv     // Catch:{ all -> 0x0083 }
            com.google.android.gms.common.internal.zzk r1 = new com.google.android.gms.common.internal.zzk     // Catch:{ all -> 0x0083 }
            java.util.concurrent.atomic.AtomicInteger r2 = r10.zzfth     // Catch:{ all -> 0x0083 }
            int r2 = r2.get()     // Catch:{ all -> 0x0083 }
            r1.<init>(r10, r2)     // Catch:{ all -> 0x0083 }
            r0.zza(r1, r5)     // Catch:{ all -> 0x0083 }
            goto L_0x0081
        L_0x007a:
            java.lang.String r0 = "GmsClient"
            java.lang.String r1 = "mServiceBroker is null, client disconnected"
            android.util.Log.w(r0, r1)     // Catch:{ all -> 0x0083 }
        L_0x0081:
            monitor-exit(r6)
            return
        L_0x0083:
            r7 = move-exception
            monitor-exit(r6)
            throw r7     // Catch:{ RemoteException | RuntimeException -> 0x0095 }
        L_0x0086:
            r6 = move-exception
            java.lang.String r0 = "GmsClient"
            java.lang.String r1 = "IGmsServiceBroker.getService failed"
            android.util.Log.w(r0, r1, r6)
            r0 = 1
            r10.zzcc(r0)
            return
        L_0x0093:
            r0 = move-exception
            throw r0
        L_0x0095:
            r6 = move-exception
            java.lang.String r0 = "GmsClient"
            java.lang.String r1 = "IGmsServiceBroker.getService failed"
            android.util.Log.w(r0, r1, r6)
            java.util.concurrent.atomic.AtomicInteger r0 = r10.zzfth
            int r0 = r0.get()
            r1 = 8
            r2 = 0
            r3 = 0
            r10.zza(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzd.zza(com.google.android.gms.common.internal.zzam, java.util.Set):void");
    }

    public void zza(zzj zzj) {
        this.zzfsw = (zzj) zzbp.zzb(zzj, "Connection progress callbacks cannot be null.");
        zza(2, (int) null);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzj zzj, int i, PendingIntent pendingIntent) {
        this.zzfsw = (zzj) zzbp.zzb(zzj, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzfth.get(), i, pendingIntent));
    }

    @Override // com.google.android.gms.common.api.Api.zze
    public boolean zzaac() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.zze
    public boolean zzaal() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.zze
    public Intent zzaam() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @Override // com.google.android.gms.common.internal.zzae
    public Bundle zzaeh() {
        return null;
    }

    public boolean zzaff() {
        return true;
    }

    public final IBinder zzafg() {
        synchronized (this.zzfsu) {
            if (this.zzfsv == null) {
                return null;
            }
            return this.zzfsv.asBinder();
        }
    }

    /* access modifiers changed from: protected */
    public String zzaje() {
        return "com.google.android.gms";
    }

    public final void zzajg() {
        int isGooglePlayServicesAvailable = this.zzfkn.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, (int) null);
            zza(new zzm(this), isGooglePlayServicesAvailable, (PendingIntent) null);
            return;
        }
        zza(new zzm(this));
    }

    public zzc[] zzaji() {
        return new zzc[0];
    }

    /* access modifiers changed from: protected */
    public final void zzajj() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzajk() {
        T t;
        synchronized (this.mLock) {
            if (this.zzfta == 5) {
                throw new DeadObjectException();
            }
            zzajj();
            zzbp.zza(this.zzfsx != null, "Client is connected but service is null");
            t = this.zzfsx;
        }
        return t;
    }

    public boolean zzajl() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zzajm() {
        return Collections.EMPTY_SET;
    }

    public final void zzcc(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.zzfth.get(), i));
    }

    public abstract T zzd(IBinder iBinder);

    public abstract String zzhc();

    public abstract String zzhd();

    public Bundle zzzu() {
        return new Bundle();
    }
}
