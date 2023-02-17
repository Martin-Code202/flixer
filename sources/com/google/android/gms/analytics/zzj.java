package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzalv;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzapd;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public final class zzj {
    private static volatile zzj zzdkw;
    private final Context mContext;
    private final List<Object> zzdkx = new CopyOnWriteArrayList();
    private final zze zzdky = new zze();
    private final zza zzdkz = new zza();
    private volatile zzalv zzdla;
    private Thread.UncaughtExceptionHandler zzdlb;

    /* access modifiers changed from: package-private */
    public class zza extends ThreadPoolExecutor {
        public zza() {
            super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new zzb(null));
            allowCoreThreadTimeOut(true);
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new zzl(this, runnable, t);
        }
    }

    static class zzb implements ThreadFactory {
        private static final AtomicInteger zzdlf = new AtomicInteger();

        private zzb() {
        }

        /* synthetic */ zzb(zzk zzk) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new zzc(runnable, new StringBuilder(23).append("measurement-").append(zzdlf.incrementAndGet()).toString());
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzc extends Thread {
        zzc(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    private zzj(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzbp.zzu(applicationContext);
        this.mContext = applicationContext;
    }

    /* access modifiers changed from: private */
    public static void zzb(zzg zzg) {
        zzbp.zzgh("deliver should be called from worker thread");
        zzbp.zzb(zzg.zzub(), "Measurement must be submitted");
        List<zzm> transports = zzg.getTransports();
        if (!transports.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (zzm zzm : transports) {
                Uri zztu = zzm.zztu();
                if (!hashSet.contains(zztu)) {
                    hashSet.add(zztu);
                    zzm.zzb(zzg);
                }
            }
        }
    }

    public static zzj zzbf(Context context) {
        zzbp.zzu(context);
        if (zzdkw == null) {
            synchronized (zzj.class) {
                if (zzdkw == null) {
                    zzdkw = new zzj(context);
                }
            }
        }
        return zzdkw;
    }

    public static void zzuj() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void zza(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdlb = uncaughtExceptionHandler;
    }

    public final <V> Future<V> zzc(Callable<V> callable) {
        zzbp.zzu(callable);
        if (!(Thread.currentThread() instanceof zzc)) {
            return this.zzdkz.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void zzc(Runnable runnable) {
        zzbp.zzu(runnable);
        this.zzdkz.submit(runnable);
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzg zzg) {
        if (zzg.zzue()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (zzg.zzub()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            zzg zztx = zzg.zztx();
            zztx.zzuc();
            this.zzdkz.execute(new zzk(this, zztx));
        }
    }

    public final zzalv zzuh() {
        if (this.zzdla == null) {
            synchronized (this) {
                if (this.zzdla == null) {
                    zzalv zzalv = new zzalv();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    zzalv.setAppId(packageName);
                    zzalv.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = packageName;
                    String str2 = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                str = applicationLabel.toString();
                            }
                            str2 = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(str);
                        Log.e("GAv4", valueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(valueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    zzalv.setAppName(str);
                    zzalv.setAppVersion(str2);
                    this.zzdla = zzalv;
                }
            }
        }
        return this.zzdla;
    }

    public final zzama zzui() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        zzama zzama = new zzama();
        zzama.setLanguage(zzapd.zza(Locale.getDefault()));
        zzama.zzcet = displayMetrics.widthPixels;
        zzama.zzceu = displayMetrics.heightPixels;
        return zzama;
    }
}
