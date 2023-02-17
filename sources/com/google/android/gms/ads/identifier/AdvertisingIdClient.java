package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public class AdvertisingIdClient {
    private final Context mContext;
    private com.google.android.gms.common.zza zzalk;
    private zzev zzall;
    private boolean zzalm;
    private Object zzaln;
    private zza zzalo;
    private long zzalp;

    public static final class Info {
        private final String zzalv;
        private final boolean zzalw;

        public Info(String str, boolean z) {
            this.zzalv = str;
            this.zzalw = z;
        }

        public final String getId() {
            return this.zzalv;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzalw;
        }

        public final String toString() {
            String str = this.zzalv;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzalw).toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzalr;
        private long zzals;
        CountDownLatch zzalt = new CountDownLatch(1);
        boolean zzalu = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzalr = new WeakReference<>(advertisingIdClient);
            this.zzals = j;
            start();
        }

        private final void disconnect() {
            AdvertisingIdClient advertisingIdClient = this.zzalr.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzalu = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (!this.zzalt.await(this.zzals, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException unused) {
                disconnect();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z) {
        this.zzaln = new Object();
        zzbp.zzu(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext == null ? context : applicationContext;
        } else {
            this.mContext = context;
        }
        this.zzalm = false;
        this.zzalp = j;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        Info info;
        zzd zzd = new zzd(context);
        boolean z = zzd.getBoolean("gads:ad_id_app_context:enabled", false);
        float f = zzd.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        boolean z2 = zzd.getBoolean("gads:ad_id_use_shared_preference:enabled", false);
        String string = zzd.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        if (z2 && (info = zzb.zzd(context).getInfo()) != null) {
            return info;
        }
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.start(false);
            Info info2 = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info2, z, f, SystemClock.elapsedRealtime() - elapsedRealtime, string, null);
            advertisingIdClient.finish();
            return info2;
        } catch (Throwable th) {
            advertisingIdClient.finish();
            throw th;
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final void start(boolean z) {
        zzbp.zzgh("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzalm) {
                finish();
            }
            this.zzalk = zzc(this.mContext);
            this.zzall = zza(this.mContext, this.zzalk);
            this.zzalm = true;
            if (z) {
                zzbh();
            }
        }
    }

    private static zzev zza(Context context, com.google.android.gms.common.zza zza2) {
        try {
            return zzew.zzc(zza2.zza(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > ((double) f)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put(ExceptionClEvent.CATEGORY_VALUE, th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new zza(this, hashMap).start();
        return true;
    }

    private final void zzbh() {
        synchronized (this.zzaln) {
            if (this.zzalo != null) {
                this.zzalo.zzalt.countDown();
                try {
                    this.zzalo.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.zzalp > 0) {
                this.zzalo = new zza(this, this.zzalp);
            }
        }
    }

    private static com.google.android.gms.common.zza zzc(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zze.zzaex().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    com.google.android.gms.common.zza zza2 = new com.google.android.gms.common.zza();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (com.google.android.gms.common.stats.zza.zzakz().zza(context, intent, zza2, 1)) {
                            return zza2;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        finish();
        super.finalize();
    }

    public void finish() {
        zzbp.zzgh("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext != null && this.zzalk != null) {
                try {
                    if (this.zzalm) {
                        com.google.android.gms.common.stats.zza.zzakz();
                        this.mContext.unbindService(this.zzalk);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.zzalm = false;
                this.zzall = null;
                this.zzalk = null;
            }
        }
    }

    public Info getInfo() {
        Info info;
        zzbp.zzgh("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzalm) {
                synchronized (this.zzaln) {
                    if (this.zzalo == null || !this.zzalo.zzalu) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzalm) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            zzbp.zzu(this.zzalk);
            zzbp.zzu(this.zzall);
            try {
                info = new Info(this.zzall.getId(), this.zzall.zzb(true));
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        zzbh();
        return info;
    }

    public void start() {
        start(true);
    }
}
