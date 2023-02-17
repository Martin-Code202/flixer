package com.google.android.gms.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
public class zzccw {
    private static volatile zzccw zzisq;
    private final Context mContext;
    private final zzd zzasb = zzh.zzald();
    private final boolean zzdod;
    private final zzcax zzisr = new zzcax(this);
    private final zzcch zziss;
    private final zzcbw zzist;
    private final zzccr zzisu;
    private final zzcfl zzisv;
    private final zzccq zzisw;
    private final AppMeasurement zzisx;
    private final FirebaseAnalytics zzisy;
    private final zzcfw zzisz;
    private final zzcbu zzita;
    private final zzcay zzitb;
    private final zzcbs zzitc;
    private final zzcca zzitd;
    private final zzcek zzite;
    private final zzceo zzitf;
    private final zzcbe zzitg;
    private final zzcdw zzith;
    private final zzcbr zziti;
    private final zzccf zzitj;
    private final zzcfr zzitk;
    private final zzcau zzitl;
    private final zzcan zzitm;
    private boolean zzitn;
    private Boolean zzito;
    private long zzitp;
    private FileLock zzitq;
    private FileChannel zzitr;
    private List<Long> zzits;
    private List<Runnable> zzitt;
    private int zzitu;
    private int zzitv;
    private long zzitw = -1;
    private long zzitx;
    private boolean zzity;
    private boolean zzitz;
    private boolean zziua;
    private final long zziub = this.zzasb.currentTimeMillis();

    /* access modifiers changed from: package-private */
    public class zza implements zzcba {
        List<zzcgh> zzaob;
        zzcgk zziud;
        List<Long> zziue;
        private long zziuf;

        private zza() {
        }

        /* synthetic */ zza(zzccw zzccw, zzccx zzccx) {
            this();
        }

        private static long zza(zzcgh zzcgh) {
            return ((zzcgh.zziyx.longValue() / 1000) / 60) / 60;
        }

        @Override // com.google.android.gms.internal.zzcba
        public final boolean zza(long j, zzcgh zzcgh) {
            zzbp.zzu(zzcgh);
            if (this.zzaob == null) {
                this.zzaob = new ArrayList();
            }
            if (this.zziue == null) {
                this.zziue = new ArrayList();
            }
            if (this.zzaob.size() > 0 && zza(this.zzaob.get(0)) != zza(zzcgh)) {
                return false;
            }
            long zzhi = this.zziuf + ((long) zzcgh.zzhi());
            if (zzhi >= ((long) zzcax.zzaws())) {
                return false;
            }
            this.zziuf = zzhi;
            this.zzaob.add(zzcgh);
            this.zziue.add(Long.valueOf(j));
            return this.zzaob.size() < zzcax.zzawt();
        }

        @Override // com.google.android.gms.internal.zzcba
        public final void zzb(zzcgk zzcgk) {
            zzbp.zzu(zzcgk);
            this.zziud = zzcgk;
        }
    }

    private zzccw(zzcdv zzcdv) {
        String str;
        zzcby zzcby;
        zzbp.zzu(zzcdv);
        this.mContext = zzcdv.mContext;
        zzcch zzcch = new zzcch(this);
        zzcch.initialize();
        this.zziss = zzcch;
        zzcbw zzcbw = new zzcbw(this);
        zzcbw.initialize();
        this.zzist = zzcbw;
        zzaum().zzayi().zzj("App measurement is starting up, version", Long.valueOf(zzcax.zzauw()));
        zzcax.zzawl();
        zzaum().zzayi().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzcfw zzcfw = new zzcfw(this);
        zzcfw.initialize();
        this.zzisz = zzcfw;
        zzcbu zzcbu = new zzcbu(this);
        zzcbu.initialize();
        this.zzita = zzcbu;
        zzcbe zzcbe = new zzcbe(this);
        zzcbe.initialize();
        this.zzitg = zzcbe;
        zzcbr zzcbr = new zzcbr(this);
        zzcbr.initialize();
        this.zziti = zzcbr;
        zzcax.zzawl();
        String appId = zzcbr.getAppId();
        if (zzaui().zzke(appId)) {
            zzcby = zzaum().zzayi();
            str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            zzcby = zzaum().zzayi();
            String valueOf = String.valueOf(appId);
            str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
        }
        zzcby.log(str);
        zzaum().zzayj().log("Debug-level message logging enabled");
        zzcay zzcay = new zzcay(this);
        zzcay.initialize();
        this.zzitb = zzcay;
        zzcbs zzcbs = new zzcbs(this);
        zzcbs.initialize();
        this.zzitc = zzcbs;
        zzcau zzcau = new zzcau(this);
        zzcau.initialize();
        this.zzitl = zzcau;
        this.zzitm = new zzcan(this);
        zzcca zzcca = new zzcca(this);
        zzcca.initialize();
        this.zzitd = zzcca;
        zzcek zzcek = new zzcek(this);
        zzcek.initialize();
        this.zzite = zzcek;
        zzceo zzceo = new zzceo(this);
        zzceo.initialize();
        this.zzitf = zzceo;
        zzcdw zzcdw = new zzcdw(this);
        zzcdw.initialize();
        this.zzith = zzcdw;
        zzcfr zzcfr = new zzcfr(this);
        zzcfr.initialize();
        this.zzitk = zzcfr;
        this.zzitj = new zzccf(this);
        this.zzisx = new AppMeasurement(this);
        this.zzisy = new FirebaseAnalytics(this);
        zzcfl zzcfl = new zzcfl(this);
        zzcfl.initialize();
        this.zzisv = zzcfl;
        zzccq zzccq = new zzccq(this);
        zzccq.initialize();
        this.zzisw = zzccq;
        zzccr zzccr = new zzccr(this);
        zzccr.initialize();
        this.zzisu = zzccr;
        if (this.zzitu != this.zzitv) {
            zzaum().zzaye().zze("Not all components initialized", Integer.valueOf(this.zzitu), Integer.valueOf(this.zzitv));
        }
        this.zzdod = true;
        zzcax.zzawl();
        if (this.mContext.getApplicationContext() instanceof Application) {
            zzcdw zzaua = zzaua();
            if (zzaua.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzaua.getContext().getApplicationContext();
                if (zzaua.zzius == null) {
                    zzaua.zzius = new zzcej(zzaua, null);
                }
                application.unregisterActivityLifecycleCallbacks(zzaua.zzius);
                application.registerActivityLifecycleCallbacks(zzaua.zzius);
                zzaua.zzaum().zzayk().log("Registered activity lifecycle callback");
            }
        } else {
            zzaum().zzayg().log("Application context is not an Application");
        }
        this.zzisu.zzg(new zzccx(this));
    }

    private final int zza(FileChannel fileChannel) {
        zzaul().zzuj();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzaum().zzaye().log("Bad chanel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            } else if (read == -1) {
                return 0;
            } else {
                zzaum().zzayg().zzj("Unexpected data length. Bytes read", Integer.valueOf(read));
                return 0;
            }
        } catch (IOException e) {
            zzaum().zzaye().zzj("Failed to read from channel", e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(com.google.android.gms.internal.zzcbf r22, com.google.android.gms.internal.zzcas r23) {
        /*
        // Method dump skipped, instructions count: 722
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzccw.zza(com.google.android.gms.internal.zzcbf, com.google.android.gms.internal.zzcas):void");
    }

    private static void zza(zzcdt zzcdt) {
        if (zzcdt == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzcdu zzcdu) {
        if (zzcdu == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzcdu.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzaul().zzuj();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzaum().zzaye().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzaum().zzaye().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzaum().zzaye().zzj("Failed to write to channel", e);
            return false;
        }
    }

    private final zzcgg[] zza(String str, zzcgm[] zzcgmArr, zzcgh[] zzcghArr) {
        zzbp.zzgg(str);
        return zzatz().zza(str, zzcghArr, zzcgmArr);
    }

    static void zzatv() {
        zzcax.zzawl();
        throw new IllegalStateException("Unexpected call on client side");
    }

    private final zzccf zzazc() {
        if (this.zzitj != null) {
            return this.zzitj;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzcfr zzazd() {
        zza((zzcdu) this.zzitk);
        return this.zzitk;
    }

    private final boolean zzaze() {
        zzaul().zzuj();
        try {
            this.zzitr = new RandomAccessFile(new File(this.mContext.getFilesDir(), zzcax.zzawj()), "rw").getChannel();
            this.zzitq = this.zzitr.tryLock();
            if (this.zzitq != null) {
                zzaum().zzayk().log("Storage concurrent access okay");
                return true;
            }
            zzaum().zzaye().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaum().zzaye().zzj("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaum().zzaye().zzj("Failed to access storage lock file", e2);
            return false;
        }
    }

    private final long zzazg() {
        long currentTimeMillis = this.zzasb.currentTimeMillis();
        zzcch zzaun = zzaun();
        zzaun.zzwk();
        zzaun.zzuj();
        long j = zzaun.zziqs.get();
        long j2 = j;
        if (j == 0) {
            j2 = (long) (zzaun.zzaui().zzazz().nextInt(86400000) + 1);
            zzaun.zziqs.set(j2);
        }
        return ((((currentTimeMillis + j2) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzazi() {
        zzaul().zzuj();
        zzwk();
        return zzaug().zzaxo() || !TextUtils.isEmpty(zzaug().zzaxj());
    }

    private final void zzazj() {
        long j;
        long j2;
        zzaul().zzuj();
        zzwk();
        if (zzazm()) {
            if (this.zzitx > 0) {
                long abs = 3600000 - Math.abs(this.zzasb.elapsedRealtime() - this.zzitx);
                if (abs > 0) {
                    zzaum().zzayk().zzj("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzazc().unregister();
                    zzazd().cancel();
                    return;
                }
                this.zzitx = 0;
            }
            if (!zzayw() || !zzazi()) {
                zzaum().zzayk().log("Nothing to upload or uploading impossible");
                zzazc().unregister();
                zzazd().cancel();
                return;
            }
            long currentTimeMillis = this.zzasb.currentTimeMillis();
            long zzaxe = zzcax.zzaxe();
            boolean z = zzaug().zzaxp() || zzaug().zzaxk();
            if (z) {
                String zzaxh = this.zzisr.zzaxh();
                j = (TextUtils.isEmpty(zzaxh) || ".none.".equals(zzaxh)) ? zzcax.zzawz() : zzcax.zzaxa();
            } else {
                j = zzcax.zzawy();
            }
            long j3 = zzaun().zziqo.get();
            long j4 = zzaun().zziqp.get();
            long max = Math.max(zzaug().zzaxm(), zzaug().zzaxn());
            if (max != 0) {
                long abs2 = currentTimeMillis - Math.abs(max - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(j3 - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(j4 - currentTimeMillis);
                long max2 = Math.max(abs3, abs4);
                long j5 = abs2 + zzaxe;
                if (z && max2 > 0) {
                    j5 = Math.min(abs2, max2) + j;
                }
                if (!zzaui().zzf(max2, j)) {
                    j5 = max2 + j;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    long j6 = j5;
                    int i = 0;
                    while (true) {
                        if (i >= zzcax.zzaxg()) {
                            j2 = 0;
                            break;
                        }
                        long zzaxf = (zzcax.zzaxf() * ((long) (1 << i))) + j6;
                        j6 = zzaxf;
                        if (zzaxf > abs4) {
                            j2 = j6;
                            break;
                        }
                        i++;
                    }
                } else {
                    j2 = j5;
                }
            } else {
                j2 = 0;
            }
            long j7 = j2;
            if (j2 == 0) {
                zzaum().zzayk().log("Next upload time is 0");
                zzazc().unregister();
                zzazd().cancel();
            } else if (!zzazb().zzyx()) {
                zzaum().zzayk().log("No network");
                zzazc().zzyu();
                zzazd().cancel();
            } else {
                long j8 = zzaun().zziqq.get();
                long zzawx = zzcax.zzawx();
                if (!zzaui().zzf(j8, zzawx)) {
                    j7 = Math.max(j7, j8 + zzawx);
                }
                zzazc().unregister();
                long currentTimeMillis2 = j7 - this.zzasb.currentTimeMillis();
                long j9 = currentTimeMillis2;
                if (currentTimeMillis2 <= 0) {
                    j9 = zzcax.zzaxb();
                    zzaun().zziqo.set(this.zzasb.currentTimeMillis());
                }
                zzaum().zzayk().zzj("Upload scheduled in approximately ms", Long.valueOf(j9));
                zzazd().zzs(j9);
            }
        }
    }

    private final boolean zzazm() {
        zzaul().zzuj();
        zzwk();
        return this.zzitn;
    }

    private final void zzazn() {
        zzaul().zzuj();
        if (this.zzity || this.zzitz || this.zziua) {
            zzaum().zzayk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzity), Boolean.valueOf(this.zzitz), Boolean.valueOf(this.zziua));
            return;
        }
        zzaum().zzayk().log("Stopping uploading service(s)");
        if (this.zzitt != null) {
            for (Runnable runnable : this.zzitt) {
                runnable.run();
            }
            this.zzitt.clear();
        }
    }

    private final void zzb(zzcar zzcar) {
        zzaul().zzuj();
        if (TextUtils.isEmpty(zzcar.getGmpAppId())) {
            zzb(zzcar.getAppId(), 204, null, null, null);
            return;
        }
        String gmpAppId = zzcar.getGmpAppId();
        String appInstanceId = zzcar.getAppInstanceId();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(zzcbm.zzioe.get()).encodedAuthority(zzcbm.zziof.get());
        String valueOf = String.valueOf(gmpAppId);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "11400");
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            zzaum().zzayk().zzj("Fetching remote configuration", zzcar.getAppId());
            zzcge zzjn = zzauj().zzjn(zzcar.getAppId());
            ArrayMap arrayMap = null;
            String zzjo = zzauj().zzjo(zzcar.getAppId());
            if (zzjn != null && !TextUtils.isEmpty(zzjo)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", zzjo);
            }
            this.zzity = true;
            zzcca zzazb = zzazb();
            String appId = zzcar.getAppId();
            zzcda zzcda = new zzcda(this);
            zzazb.zzuj();
            zzazb.zzwk();
            zzbp.zzu(url);
            zzbp.zzu(zzcda);
            zzazb.zzaul().zzh(new zzcce(zzazb, appId, url, null, arrayMap, zzcda));
        } catch (MalformedURLException unused) {
            zzaum().zzaye().zze("Failed to parse config URL. Not fetching. appId", zzcbw.zzjf(zzcar.getAppId()), uri);
        }
    }

    private final void zzc(zzcbk zzcbk, zzcas zzcas) {
        zzcbg zzcbg;
        long j;
        zzcfv zzcfv;
        zzcar zziw;
        zzbp.zzu(zzcas);
        zzbp.zzgg(zzcas.packageName);
        long nanoTime = System.nanoTime();
        zzaul().zzuj();
        zzwk();
        String str = zzcas.packageName;
        zzaui();
        if (zzcfw.zzd(zzcbk, zzcas)) {
            if (!zzcas.zzily) {
                zzf(zzcas);
            } else if (zzauj().zzao(str, zzcbk.name)) {
                zzaum().zzayg().zze("Dropping blacklisted event. appId", zzcbw.zzjf(str), zzauh().zzjc(zzcbk.name));
                boolean z = zzaui().zzkg(str) || zzaui().zzkh(str);
                if (!z && !"_err".equals(zzcbk.name)) {
                    zzaui().zza(str, 11, "_ev", zzcbk.name, 0);
                }
                if (z && (zziw = zzaug().zziw(str)) != null && Math.abs(this.zzasb.currentTimeMillis() - Math.max(zziw.zzavb(), zziw.zzava())) > zzcax.zzawp()) {
                    zzaum().zzayj().log("Fetching config for blacklisted app");
                    zzb(zziw);
                }
            } else {
                if (zzaum().zzad(2)) {
                    zzaum().zzayk().zzj("Logging event", zzauh().zzb(zzcbk));
                }
                zzaug().beginTransaction();
                try {
                    Bundle zzaya = zzcbk.zzinq.zzaya();
                    zzf(zzcas);
                    if ("_iap".equals(zzcbk.name) || "ecommerce_purchase".equals(zzcbk.name)) {
                        String string = zzaya.getString("currency");
                        if ("ecommerce_purchase".equals(zzcbk.name)) {
                            double d = zzaya.getDouble("value") * 1000000.0d;
                            double d2 = d;
                            if (d == 0.0d) {
                                d2 = ((double) zzaya.getLong("value")) * 1000000.0d;
                            }
                            if (d2 > 9.223372036854776E18d || d2 < -9.223372036854776E18d) {
                                zzaum().zzayg().zze("Data lost. Currency value is too big. appId", zzcbw.zzjf(str), Double.valueOf(d2));
                                zzaug().setTransactionSuccessful();
                                zzaug().endTransaction();
                                return;
                            }
                            j = Math.round(d2);
                        } else {
                            j = zzaya.getLong("value");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String upperCase = string.toUpperCase(Locale.US);
                            if (upperCase.matches("[A-Z]{3}")) {
                                String valueOf = String.valueOf("_ltv_");
                                String valueOf2 = String.valueOf(upperCase);
                                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                                zzcfv zzah = zzaug().zzah(str, concat);
                                if (zzah == null || !(zzah.mValue instanceof Long)) {
                                    zzcay zzaug = zzaug();
                                    int zzb = this.zzisr.zzb(str, zzcbm.zzipe) - 1;
                                    zzbp.zzgg(str);
                                    zzaug.zzuj();
                                    zzaug.zzwk();
                                    try {
                                        zzaug.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                                    } catch (SQLiteException e) {
                                        zzaug.zzaum().zzaye().zze("Error pruning currencies. appId", zzcbw.zzjf(str), e);
                                    }
                                    zzcfv = new zzcfv(str, zzcbk.zzimf, concat, this.zzasb.currentTimeMillis(), Long.valueOf(j));
                                } else {
                                    zzcfv = new zzcfv(str, zzcbk.zzimf, concat, this.zzasb.currentTimeMillis(), Long.valueOf(((Long) zzah.mValue).longValue() + j));
                                }
                                if (!zzaug().zza(zzcfv)) {
                                    zzaum().zzaye().zzd("Too many unique user properties are set. Ignoring user property. appId", zzcbw.zzjf(str), zzauh().zzje(zzcfv.mName), zzcfv.mValue);
                                    zzaui().zza(str, 9, (String) null, (String) null, 0);
                                }
                            }
                        }
                    }
                    boolean zzju = zzcfw.zzju(zzcbk.name);
                    boolean equals = "_err".equals(zzcbk.name);
                    zzcaz zza2 = zzaug().zza(zzazg(), str, true, zzju, false, equals, false);
                    long zzavx = zza2.zzimy - zzcax.zzavx();
                    if (zzavx > 0) {
                        if (zzavx % 1000 == 1) {
                            zzaum().zzaye().zze("Data loss. Too many events logged. appId, count", zzcbw.zzjf(str), Long.valueOf(zza2.zzimy));
                        }
                        zzaug().setTransactionSuccessful();
                        return;
                    }
                    if (zzju) {
                        long zzavy = zza2.zzimx - zzcax.zzavy();
                        if (zzavy > 0) {
                            if (zzavy % 1000 == 1) {
                                zzaum().zzaye().zze("Data loss. Too many public events logged. appId, count", zzcbw.zzjf(str), Long.valueOf(zza2.zzimx));
                            }
                            zzaui().zza(str, 16, "_ev", zzcbk.name, 0);
                            zzaug().setTransactionSuccessful();
                            zzaug().endTransaction();
                            return;
                        }
                    }
                    if (equals) {
                        long max = zza2.zzina - ((long) Math.max(0, Math.min(1000000, this.zzisr.zzb(zzcas.packageName, zzcbm.zziol))));
                        if (max > 0) {
                            if (max == 1) {
                                zzaum().zzaye().zze("Too many error events logged. appId, count", zzcbw.zzjf(str), Long.valueOf(zza2.zzina));
                            }
                            zzaug().setTransactionSuccessful();
                            zzaug().endTransaction();
                            return;
                        }
                    }
                    zzaui().zza(zzaya, "_o", zzcbk.zzimf);
                    if (zzaui().zzke(str)) {
                        zzaui().zza(zzaya, "_dbg", (Object) 1L);
                        zzaui().zza(zzaya, "_r", (Object) 1L);
                    }
                    long zzix = zzaug().zzix(str);
                    if (zzix > 0) {
                        zzaum().zzayg().zze("Data lost. Too many events stored on disk, deleted. appId", zzcbw.zzjf(str), Long.valueOf(zzix));
                    }
                    zzcbf zzcbf = new zzcbf(this, zzcbk.zzimf, str, zzcbk.name, zzcbk.zzinr, 0, zzaya);
                    zzcbg zzaf = zzaug().zzaf(str, zzcbf.mName);
                    if (zzaf == null) {
                        long zzja = zzaug().zzja(str);
                        zzcax.zzavw();
                        if (zzja >= 500) {
                            zzaum().zzaye().zzd("Too many event names used, ignoring event. appId, name, supported count", zzcbw.zzjf(str), zzauh().zzjc(zzcbf.mName), Integer.valueOf(zzcax.zzavw()));
                            zzaui().zza(str, 8, (String) null, (String) null, 0);
                            zzaug().endTransaction();
                            return;
                        }
                        zzcbg = new zzcbg(str, zzcbf.mName, 0, 0, zzcbf.zzfdb);
                    } else {
                        zzcbf = zzcbf.zza(this, zzaf.zzinm);
                        zzcbg = zzaf.zzbb(zzcbf.zzfdb);
                    }
                    zzaug().zza(zzcbg);
                    zza(zzcbf, zzcas);
                    zzaug().setTransactionSuccessful();
                    if (zzaum().zzad(2)) {
                        zzaum().zzayk().zzj("Event recorded", zzauh().zza(zzcbf));
                    }
                    zzaug().endTransaction();
                    zzazj();
                    zzaum().zzayk().zzj("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    zzaug().endTransaction();
                }
            }
        }
    }

    public static zzccw zzdn(Context context) {
        zzbp.zzu(context);
        zzbp.zzu(context.getApplicationContext());
        if (zzisq == null) {
            synchronized (zzccw.class) {
                if (zzisq == null) {
                    zzisq = new zzccw(new zzcdv(context));
                }
            }
        }
        return zzisq;
    }

    private final void zzf(zzcas zzcas) {
        zzaul().zzuj();
        zzwk();
        zzbp.zzu(zzcas);
        zzbp.zzgg(zzcas.packageName);
        zzcar zziw = zzaug().zziw(zzcas.packageName);
        String zzji = zzaun().zzji(zzcas.packageName);
        boolean z = false;
        if (zziw == null) {
            zziw = new zzcar(this, zzcas.packageName);
            zziw.zzim(zzaub().zzayb());
            zziw.zzio(zzji);
            z = true;
        } else if (!zzji.equals(zziw.zzauq())) {
            zziw.zzio(zzji);
            zziw.zzim(zzaub().zzayb());
            z = true;
        }
        if (!TextUtils.isEmpty(zzcas.zzilt) && !zzcas.zzilt.equals(zziw.getGmpAppId())) {
            zziw.zzin(zzcas.zzilt);
            z = true;
        }
        if (!TextUtils.isEmpty(zzcas.zzimb) && !zzcas.zzimb.equals(zziw.zzaur())) {
            zziw.zzip(zzcas.zzimb);
            z = true;
        }
        if (!(zzcas.zzilv == 0 || zzcas.zzilv == zziw.zzauw())) {
            zziw.zzao(zzcas.zzilv);
            z = true;
        }
        if (!TextUtils.isEmpty(zzcas.zzhts) && !zzcas.zzhts.equals(zziw.zzuo())) {
            zziw.setAppVersion(zzcas.zzhts);
            z = true;
        }
        if (zzcas.zzima != zziw.zzauu()) {
            zziw.zzan(zzcas.zzima);
            z = true;
        }
        if (zzcas.zzilu != null && !zzcas.zzilu.equals(zziw.zzauv())) {
            zziw.zziq(zzcas.zzilu);
            z = true;
        }
        if (zzcas.zzilw != zziw.zzaux()) {
            zziw.zzap(zzcas.zzilw);
            z = true;
        }
        if (zzcas.zzily != zziw.zzauy()) {
            zziw.setMeasurementEnabled(zzcas.zzily);
            z = true;
        }
        if (!TextUtils.isEmpty(zzcas.zzilx) && !zzcas.zzilx.equals(zziw.zzavj())) {
            zziw.zzir(zzcas.zzilx);
            z = true;
        }
        if (zzcas.zzimc != zziw.zzavl()) {
            zziw.zzaz(zzcas.zzimc);
            z = true;
        }
        if (z) {
            zzaug().zza(zziw);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x03ab, code lost:
        if (com.google.android.gms.internal.zzcfw.zzki(r9.zzaob.get(r13).name) != false) goto L_0x03ad;
     */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0814  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzg(java.lang.String r52, long r53) {
        /*
        // Method dump skipped, instructions count: 2093
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzccw.zzg(java.lang.String, long):boolean");
    }

    private final zzcas zzjr(String str) {
        zzcar zziw = zzaug().zziw(str);
        if (zziw == null || TextUtils.isEmpty(zziw.zzuo())) {
            zzaum().zzayj().zzj("No app data available; dropping", str);
            return null;
        }
        try {
            String str2 = zzbed.zzcr(this.mContext).getPackageInfo(str, 0).versionName;
            if (zziw.zzuo() != null && !zziw.zzuo().equals(str2)) {
                zzaum().zzayg().zzj("App version does not match; dropping. appId", zzcbw.zzjf(str));
                return null;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return new zzcas(str, zziw.getGmpAppId(), zziw.zzuo(), zziw.zzauu(), zziw.zzauv(), zziw.zzauw(), zziw.zzaux(), (String) null, zziw.zzauy(), false, zziw.zzaur(), zziw.zzavl(), 0L, 0);
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final boolean isEnabled() {
        zzaul().zzuj();
        zzwk();
        if (this.zzisr.zzawm()) {
            return false;
        }
        Boolean zzit = this.zzisr.zzit("firebase_analytics_collection_enabled");
        return zzaun().zzbn(zzit != null ? zzit.booleanValue() : !zzcax.zzaif());
    }

    /* access modifiers changed from: protected */
    public final void start() {
        zzaul().zzuj();
        zzaug().zzaxl();
        if (zzaun().zziqo.get() == 0) {
            zzaun().zziqo.set(this.zzasb.currentTimeMillis());
        }
        if (Long.valueOf(zzaun().zziqt.get()).longValue() == 0) {
            zzaum().zzayk().zzj("Persisting first open", Long.valueOf(this.zziub));
            zzaun().zziqt.set(this.zziub);
        }
        if (zzayw()) {
            zzcax.zzawl();
            if (!TextUtils.isEmpty(zzaub().getGmpAppId())) {
                String zzayn = zzaun().zzayn();
                if (zzayn == null) {
                    zzaun().zzjj(zzaub().getGmpAppId());
                } else if (!zzayn.equals(zzaub().getGmpAppId())) {
                    zzaum().zzayi().log("Rechecking which service to use due to a GMP App Id change");
                    zzaun().zzayq();
                    this.zzitf.disconnect();
                    this.zzitf.zzxh();
                    zzaun().zzjj(zzaub().getGmpAppId());
                    zzaun().zziqt.set(this.zziub);
                    zzaun().zziqu.zzjl(null);
                }
            }
            zzaua().zzjk(zzaun().zziqu.zzays());
            zzcax.zzawl();
            if (!TextUtils.isEmpty(zzaub().getGmpAppId())) {
                zzcdw zzaua = zzaua();
                zzaua.zzuj();
                zzaua.zzatw();
                zzaua.zzwk();
                if (zzaua.zzikh.zzayw()) {
                    zzaua.zzaud().zzazr();
                    String zzayr = zzaua.zzaun().zzayr();
                    if (!TextUtils.isEmpty(zzayr)) {
                        zzaua.zzauc().zzwk();
                        if (!zzayr.equals(Build.VERSION.RELEASE)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_po", zzayr);
                            zzaua.zzc("auto", "_ou", bundle);
                        }
                    }
                }
                zzaud().zza(new AtomicReference<>());
            }
        } else if (isEnabled()) {
            if (!zzaui().zzdt("android.permission.INTERNET")) {
                zzaum().zzaye().log("App is missing INTERNET permission");
            }
            if (!zzaui().zzdt("android.permission.ACCESS_NETWORK_STATE")) {
                zzaum().zzaye().log("App is missing ACCESS_NETWORK_STATE permission");
            }
            zzcax.zzawl();
            if (!zzbed.zzcr(this.mContext).zzalr()) {
                if (!zzccn.zzj(this.mContext, false)) {
                    zzaum().zzaye().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzcfh.zzk(this.mContext, false)) {
                    zzaum().zzaye().log("AppMeasurementService not registered/enabled");
                }
            }
            zzaum().zzaye().log("Uploading is not possible. App measurement disabled");
        }
        zzazj();
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, Throwable th, byte[] bArr) {
        zzaul().zzuj();
        zzwk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzitz = false;
                zzazn();
                throw th2;
            }
        }
        List<Long> list = this.zzits;
        this.zzits = null;
        if ((i == 200 || i == 204) && th == null) {
            try {
                zzaun().zziqo.set(this.zzasb.currentTimeMillis());
                zzaun().zziqp.set(0);
                zzazj();
                zzaum().zzayk().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzaug().beginTransaction();
                try {
                    for (Long l : list) {
                        zzcay zzaug = zzaug();
                        long longValue = l.longValue();
                        zzaug.zzuj();
                        zzaug.zzwk();
                        try {
                            if (zzaug.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzaug.zzaum().zzaye().zzj("Failed to delete a bundle in a queue table", e);
                            throw e;
                        }
                    }
                    zzaug().setTransactionSuccessful();
                    if (!zzazb().zzyx() || !zzazi()) {
                        this.zzitw = -1;
                        zzazj();
                    } else {
                        zzazh();
                    }
                    this.zzitx = 0;
                } finally {
                    zzaug().endTransaction();
                }
            } catch (SQLiteException e2) {
                zzaum().zzaye().zzj("Database error while trying to delete uploaded bundles", e2);
                this.zzitx = this.zzasb.elapsedRealtime();
                zzaum().zzayk().zzj("Disable upload, time", Long.valueOf(this.zzitx));
            }
        } else {
            zzaum().zzayk().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzaun().zziqp.set(this.zzasb.currentTimeMillis());
            if (i == 503 || i == 429) {
                zzaun().zziqq.set(this.zzasb.currentTimeMillis());
            }
            zzazj();
        }
        this.zzitz = false;
        zzazn();
    }

    public final byte[] zza(zzcbk zzcbk, String str) {
        long j;
        zzwk();
        zzaul().zzuj();
        zzatv();
        zzbp.zzu(zzcbk);
        zzbp.zzgg(str);
        zzcgj zzcgj = new zzcgj();
        zzaug().beginTransaction();
        try {
            zzcar zziw = zzaug().zziw(str);
            if (zziw == null) {
                zzaum().zzayj().zzj("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zziw.zzauy()) {
                zzaum().zzayj().zzj("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzaug().endTransaction();
                return bArr;
            } else {
                zzcgk zzcgk = new zzcgk();
                zzcgj.zzizb = new zzcgk[]{zzcgk};
                zzcgk.zzizd = 1;
                zzcgk.zzizl = "android";
                zzcgk.zzch = zziw.getAppId();
                zzcgk.zzilu = zziw.zzauv();
                zzcgk.zzhts = zziw.zzuo();
                long zzauu = zziw.zzauu();
                zzcgk.zzizy = zzauu == -2147483648L ? null : Integer.valueOf((int) zzauu);
                zzcgk.zzizp = Long.valueOf(zziw.zzauw());
                zzcgk.zzilt = zziw.getGmpAppId();
                zzcgk.zzizu = Long.valueOf(zziw.zzaux());
                if (isEnabled() && zzcax.zzaxi() && this.zzisr.zziu(zzcgk.zzch)) {
                    zzaub();
                    zzcgk.zzjae = null;
                }
                Pair<String, Boolean> zzjh = zzaun().zzjh(zziw.getAppId());
                if (zzjh != null && !TextUtils.isEmpty((CharSequence) zzjh.first)) {
                    zzcgk.zzizr = (String) zzjh.first;
                    zzcgk.zzizs = (Boolean) zzjh.second;
                }
                zzauc().zzwk();
                zzcgk.zzizm = Build.MODEL;
                zzauc().zzwk();
                zzcgk.zzcv = Build.VERSION.RELEASE;
                zzcgk.zzizo = Integer.valueOf((int) zzauc().zzaxx());
                zzcgk.zzizn = zzauc().zzaxy();
                zzcgk.zzizt = zziw.getAppInstanceId();
                zzcgk.zzimb = zziw.zzaur();
                List<zzcfv> zziv = zzaug().zziv(zziw.getAppId());
                zzcgk.zzizf = new zzcgm[zziv.size()];
                for (int i = 0; i < zziv.size(); i++) {
                    zzcgm zzcgm = new zzcgm();
                    zzcgk.zzizf[i] = zzcgm;
                    zzcgm.name = zziv.get(i).mName;
                    zzcgm.zzjai = Long.valueOf(zziv.get(i).zzixc);
                    zzaui().zza(zzcgm, zziv.get(i).mValue);
                }
                Bundle zzaya = zzcbk.zzinq.zzaya();
                if ("_iap".equals(zzcbk.name)) {
                    zzaya.putLong("_c", 1);
                    zzaum().zzayj().log("Marking in-app purchase as real-time");
                    zzaya.putLong("_r", 1);
                }
                zzaya.putString("_o", zzcbk.zzimf);
                if (zzaui().zzke(zzcgk.zzch)) {
                    zzaui().zza(zzaya, "_dbg", (Object) 1L);
                    zzaui().zza(zzaya, "_r", (Object) 1L);
                }
                zzcbg zzaf = zzaug().zzaf(str, zzcbk.name);
                if (zzaf == null) {
                    j = 0;
                    zzaug().zza(new zzcbg(str, zzcbk.name, 1, 0, zzcbk.zzinr));
                } else {
                    j = zzaf.zzinm;
                    zzaug().zza(zzaf.zzbb(zzcbk.zzinr).zzaxz());
                }
                zzcbf zzcbf = new zzcbf(this, zzcbk.zzimf, str, zzcbk.name, zzcbk.zzinr, j, zzaya);
                zzcgh zzcgh = new zzcgh();
                zzcgk.zzize = new zzcgh[]{zzcgh};
                zzcgh.zziyx = Long.valueOf(zzcbf.zzfdb);
                zzcgh.name = zzcbf.mName;
                zzcgh.zziyy = Long.valueOf(zzcbf.zzini);
                zzcgh.zziyw = new zzcgi[zzcbf.zzinj.size()];
                int i2 = 0;
                Iterator<String> it = zzcbf.zzinj.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    zzcgi zzcgi = new zzcgi();
                    i2++;
                    zzcgh.zziyw[i2] = zzcgi;
                    zzcgi.name = next;
                    zzaui().zza(zzcgi, zzcbf.zzinj.get(next));
                }
                zzcgk.zzizx = zza(zziw.getAppId(), zzcgk.zzizf, zzcgk.zzize);
                zzcgk.zzizh = zzcgh.zziyx;
                zzcgk.zzizi = zzcgh.zziyx;
                long zzaut = zziw.zzaut();
                zzcgk.zzizk = zzaut != 0 ? Long.valueOf(zzaut) : null;
                long zzaus = zziw.zzaus();
                long j2 = zzaus;
                if (zzaus == 0) {
                    j2 = zzaut;
                }
                zzcgk.zzizj = j2 != 0 ? Long.valueOf(j2) : null;
                zziw.zzavc();
                zzcgk.zzizv = Integer.valueOf((int) zziw.zzauz());
                zzcgk.zzizq = Long.valueOf(zzcax.zzauw());
                zzcgk.zzizg = Long.valueOf(this.zzasb.currentTimeMillis());
                zzcgk.zzizw = Boolean.TRUE;
                zziw.zzal(zzcgk.zzizh.longValue());
                zziw.zzam(zzcgk.zzizi.longValue());
                zzaug().zza(zziw);
                zzaug().setTransactionSuccessful();
                zzaug().endTransaction();
                try {
                    byte[] bArr2 = new byte[zzcgj.zzhi()];
                    zzegy zzi = zzegy.zzi(bArr2, 0, bArr2.length);
                    zzcgj.zza(zzi);
                    zzi.zzccm();
                    return zzaui().zzo(bArr2);
                } catch (IOException e) {
                    zzaum().zzaye().zze("Data loss. Failed to bundle and serialize. appId", zzcbw.zzjf(str), e);
                    return null;
                }
            }
        } finally {
            zzaug().endTransaction();
        }
    }

    public final zzcan zzaty() {
        zza(this.zzitm);
        return this.zzitm;
    }

    public final zzcau zzatz() {
        zza((zzcdu) this.zzitl);
        return this.zzitl;
    }

    public final zzcdw zzaua() {
        zza((zzcdu) this.zzith);
        return this.zzith;
    }

    public final zzcbr zzaub() {
        zza((zzcdu) this.zziti);
        return this.zziti;
    }

    public final zzcbe zzauc() {
        zza((zzcdu) this.zzitg);
        return this.zzitg;
    }

    public final zzceo zzaud() {
        zza((zzcdu) this.zzitf);
        return this.zzitf;
    }

    public final zzcek zzaue() {
        zza((zzcdu) this.zzite);
        return this.zzite;
    }

    public final zzcbs zzauf() {
        zza((zzcdu) this.zzitc);
        return this.zzitc;
    }

    public final zzcay zzaug() {
        zza((zzcdu) this.zzitb);
        return this.zzitb;
    }

    public final zzcbu zzauh() {
        zza((zzcdt) this.zzita);
        return this.zzita;
    }

    public final zzcfw zzaui() {
        zza((zzcdt) this.zzisz);
        return this.zzisz;
    }

    public final zzccq zzauj() {
        zza((zzcdu) this.zzisw);
        return this.zzisw;
    }

    public final zzcfl zzauk() {
        zza((zzcdu) this.zzisv);
        return this.zzisv;
    }

    public final zzccr zzaul() {
        zza((zzcdu) this.zzisu);
        return this.zzisu;
    }

    public final zzcbw zzaum() {
        zza((zzcdu) this.zzist);
        return this.zzist;
    }

    public final zzcch zzaun() {
        zza((zzcdt) this.zziss);
        return this.zziss;
    }

    public final zzcax zzauo() {
        return this.zzisr;
    }

    /* access modifiers changed from: protected */
    public final boolean zzayw() {
        zzwk();
        zzaul().zzuj();
        if (this.zzito == null || this.zzitp == 0 || (this.zzito != null && !this.zzito.booleanValue() && Math.abs(this.zzasb.elapsedRealtime() - this.zzitp) > 1000)) {
            this.zzitp = this.zzasb.elapsedRealtime();
            zzcax.zzawl();
            this.zzito = Boolean.valueOf(zzaui().zzdt("android.permission.INTERNET") && zzaui().zzdt("android.permission.ACCESS_NETWORK_STATE") && (zzbed.zzcr(this.mContext).zzalr() || (zzccn.zzj(this.mContext, false) && zzcfh.zzk(this.mContext, false))));
            if (this.zzito.booleanValue()) {
                this.zzito = Boolean.valueOf(zzaui().zzkb(zzaub().getGmpAppId()));
            }
        }
        return this.zzito.booleanValue();
    }

    public final zzcbw zzayx() {
        if (this.zzist == null || !this.zzist.isInitialized()) {
            return null;
        }
        return this.zzist;
    }

    /* access modifiers changed from: package-private */
    public final zzccr zzayy() {
        return this.zzisu;
    }

    public final AppMeasurement zzayz() {
        return this.zzisx;
    }

    public final FirebaseAnalytics zzaza() {
        return this.zzisy;
    }

    public final zzcca zzazb() {
        zza((zzcdu) this.zzitd);
        return this.zzitd;
    }

    /* access modifiers changed from: package-private */
    public final long zzazf() {
        Long valueOf = Long.valueOf(zzaun().zziqt.get());
        return valueOf.longValue() == 0 ? this.zziub : Math.min(this.zziub, valueOf.longValue());
    }

    public final void zzazh() {
        zzcar zziw;
        zzaul().zzuj();
        zzwk();
        this.zziua = true;
        try {
            zzcax.zzawl();
            Boolean zzayp = zzaun().zzayp();
            if (zzayp == null) {
                zzaum().zzayg().log("Upload data called on the client side before use of service was decided");
            } else if (zzayp.booleanValue()) {
                zzaum().zzaye().log("Upload called in the client side when service should be used");
                this.zziua = false;
                zzazn();
            } else if (this.zzitx > 0) {
                zzazj();
                this.zziua = false;
                zzazn();
            } else {
                zzaul().zzuj();
                if (this.zzits != null) {
                    zzaum().zzayk().log("Uploading requested multiple times");
                    this.zziua = false;
                    zzazn();
                } else if (!zzazb().zzyx()) {
                    zzaum().zzayk().log("Network not connected, ignoring upload request");
                    zzazj();
                    this.zziua = false;
                    zzazn();
                } else {
                    long currentTimeMillis = this.zzasb.currentTimeMillis();
                    zzg(null, currentTimeMillis - zzcax.zzaww());
                    long j = zzaun().zziqo.get();
                    if (j != 0) {
                        zzaum().zzayj().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                    }
                    String zzaxj = zzaug().zzaxj();
                    if (!TextUtils.isEmpty(zzaxj)) {
                        if (this.zzitw == -1) {
                            this.zzitw = zzaug().zzaxq();
                        }
                        List<Pair<zzcgk, Long>> zzl = zzaug().zzl(zzaxj, this.zzisr.zzb(zzaxj, zzcbm.zziog), Math.max(0, this.zzisr.zzb(zzaxj, zzcbm.zzioh)));
                        if (!zzl.isEmpty()) {
                            String str = null;
                            Iterator<Pair<zzcgk, Long>> it = zzl.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                zzcgk zzcgk = (zzcgk) it.next().first;
                                if (!TextUtils.isEmpty(zzcgk.zzizr)) {
                                    str = zzcgk.zzizr;
                                    break;
                                }
                            }
                            if (str != null) {
                                int i = 0;
                                while (true) {
                                    if (i >= zzl.size()) {
                                        break;
                                    }
                                    zzcgk zzcgk2 = (zzcgk) zzl.get(i).first;
                                    if (!(TextUtils.isEmpty(zzcgk2.zzizr) || zzcgk2.zzizr.equals(str))) {
                                        zzl = zzl.subList(0, i);
                                        break;
                                    }
                                    i++;
                                }
                            }
                            zzcgj zzcgj = new zzcgj();
                            zzcgj.zzizb = new zzcgk[zzl.size()];
                            ArrayList arrayList = new ArrayList(zzl.size());
                            boolean z = zzcax.zzaxi() && this.zzisr.zziu(zzaxj);
                            for (int i2 = 0; i2 < zzcgj.zzizb.length; i2++) {
                                zzcgj.zzizb[i2] = (zzcgk) zzl.get(i2).first;
                                arrayList.add((Long) zzl.get(i2).second);
                                zzcgj.zzizb[i2].zzizq = Long.valueOf(zzcax.zzauw());
                                zzcgj.zzizb[i2].zzizg = Long.valueOf(currentTimeMillis);
                                zzcgj.zzizb[i2].zzizw = Boolean.valueOf(zzcax.zzawl());
                                if (!z) {
                                    zzcgj.zzizb[i2].zzjae = null;
                                }
                            }
                            String str2 = null;
                            if (zzaum().zzad(2)) {
                                str2 = zzauh().zza(zzcgj);
                            }
                            byte[] zzb = zzaui().zzb(zzcgj);
                            String zzawv = zzcax.zzawv();
                            try {
                                URL url = new URL(zzawv);
                                zzbp.zzbh(!arrayList.isEmpty());
                                if (this.zzits != null) {
                                    zzaum().zzaye().log("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzits = new ArrayList(arrayList);
                                }
                                zzaun().zziqp.set(currentTimeMillis);
                                String str3 = "?";
                                if (zzcgj.zzizb.length > 0) {
                                    str3 = zzcgj.zzizb[0].zzch;
                                }
                                zzaum().zzayk().zzd("Uploading data. app, uncompressed size, data", str3, Integer.valueOf(zzb.length), str2);
                                this.zzitz = true;
                                zzcca zzazb = zzazb();
                                zzccz zzccz = new zzccz(this);
                                zzazb.zzuj();
                                zzazb.zzwk();
                                zzbp.zzu(url);
                                zzbp.zzu(zzb);
                                zzbp.zzu(zzccz);
                                zzazb.zzaul().zzh(new zzcce(zzazb, zzaxj, url, zzb, null, zzccz));
                            } catch (MalformedURLException unused) {
                                zzaum().zzaye().zze("Failed to parse upload URL. Not uploading. appId", zzcbw.zzjf(zzaxj), zzawv);
                            }
                        }
                    } else {
                        this.zzitw = -1;
                        String zzba = zzaug().zzba(currentTimeMillis - zzcax.zzaww());
                        if (!TextUtils.isEmpty(zzba) && (zziw = zzaug().zziw(zzba)) != null) {
                            zzb(zziw);
                        }
                    }
                    this.zziua = false;
                    zzazn();
                }
            }
        } finally {
            this.zziua = false;
            zzazn();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzazk() {
        this.zzitv++;
    }

    /* access modifiers changed from: package-private */
    public final void zzazl() {
        zzaul().zzuj();
        zzwk();
        if (!this.zzitn) {
            zzaum().zzayi().log("This instance being marked as an uploader");
            zzaul().zzuj();
            zzwk();
            if (zzazm() && zzaze()) {
                int zza2 = zza(this.zzitr);
                int zzayc = zzaub().zzayc();
                zzaul().zzuj();
                if (zza2 > zzayc) {
                    zzaum().zzaye().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzayc));
                } else if (zza2 < zzayc) {
                    if (zza(zzayc, this.zzitr)) {
                        zzaum().zzayk().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzayc));
                    } else {
                        zzaum().zzaye().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzayc));
                    }
                }
            }
            this.zzitn = true;
            zzazj();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzcav zzcav, zzcas zzcas) {
        zzbp.zzu(zzcav);
        zzbp.zzgg(zzcav.packageName);
        zzbp.zzu(zzcav.zzimf);
        zzbp.zzu(zzcav.zzimg);
        zzbp.zzgg(zzcav.zzimg.name);
        zzaul().zzuj();
        zzwk();
        if (!TextUtils.isEmpty(zzcas.zzilt)) {
            if (!zzcas.zzily) {
                zzf(zzcas);
                return;
            }
            zzcav zzcav2 = new zzcav(zzcav);
            zzcav2.zzimi = false;
            zzaug().beginTransaction();
            boolean z = false;
            try {
                zzcav zzai = zzaug().zzai(zzcav2.packageName, zzcav2.zzimg.name);
                if (zzai != null && !zzai.zzimf.equals(zzcav2.zzimf)) {
                    zzaum().zzayg().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzauh().zzje(zzcav2.zzimg.name), zzcav2.zzimf, zzai.zzimf);
                }
                if (zzai != null && zzai.zzimi) {
                    zzcav2.zzimf = zzai.zzimf;
                    zzcav2.zzimh = zzai.zzimh;
                    zzcav2.zziml = zzai.zziml;
                    zzcav2.zzimj = zzai.zzimj;
                    zzcav2.zzimm = zzai.zzimm;
                    zzcav2.zzimi = zzai.zzimi;
                    zzcav2.zzimg = new zzcft(zzcav2.zzimg.name, zzai.zzimg.zziwy, zzcav2.zzimg.getValue(), zzai.zzimg.zzimf);
                } else if (TextUtils.isEmpty(zzcav2.zzimj)) {
                    zzcav2.zzimg = new zzcft(zzcav2.zzimg.name, zzcav2.zzimh, zzcav2.zzimg.getValue(), zzcav2.zzimg.zzimf);
                    zzcav2.zzimi = true;
                    z = true;
                }
                if (zzcav2.zzimi) {
                    zzcft zzcft = zzcav2.zzimg;
                    zzcfv zzcfv = new zzcfv(zzcav2.packageName, zzcav2.zzimf, zzcft.name, zzcft.zziwy, zzcft.getValue());
                    if (zzaug().zza(zzcfv)) {
                        zzaum().zzayj().zzd("User property updated immediately", zzcav2.packageName, zzauh().zzje(zzcfv.mName), zzcfv.mValue);
                    } else {
                        zzaum().zzaye().zzd("(2)Too many active user properties, ignoring", zzcbw.zzjf(zzcav2.packageName), zzauh().zzje(zzcfv.mName), zzcfv.mValue);
                    }
                    if (z && zzcav2.zzimm != null) {
                        zzc(new zzcbk(zzcav2.zzimm, zzcav2.zzimh), zzcas);
                    }
                }
                if (zzaug().zza(zzcav2)) {
                    zzaum().zzayj().zzd("Conditional property added", zzcav2.packageName, zzauh().zzje(zzcav2.zzimg.name), zzcav2.zzimg.getValue());
                } else {
                    zzaum().zzaye().zzd("Too many conditional properties, ignoring", zzcbw.zzjf(zzcav2.packageName), zzauh().zzje(zzcav2.zzimg.name), zzcav2.zzimg.getValue());
                }
                zzaug().setTransactionSuccessful();
            } finally {
                zzaug().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzcbk zzcbk, zzcas zzcas) {
        List<zzcav> list;
        List<zzcav> list2;
        List<zzcav> list3;
        zzbp.zzu(zzcas);
        zzbp.zzgg(zzcas.packageName);
        zzaul().zzuj();
        zzwk();
        String str = zzcas.packageName;
        long j = zzcbk.zzinr;
        zzaui();
        if (zzcfw.zzd(zzcbk, zzcas)) {
            if (!zzcas.zzily) {
                zzf(zzcas);
                return;
            }
            zzaug().beginTransaction();
            try {
                zzcay zzaug = zzaug();
                zzbp.zzgg(str);
                zzaug.zzuj();
                zzaug.zzwk();
                if (j < 0) {
                    zzaug.zzaum().zzayg().zze("Invalid time querying timed out conditional properties", zzcbw.zzjf(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzaug.zzc("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzcav zzcav : list) {
                    if (zzcav != null) {
                        zzaum().zzayj().zzd("User property timed out", zzcav.packageName, zzauh().zzje(zzcav.zzimg.name), zzcav.zzimg.getValue());
                        if (zzcav.zzimk != null) {
                            zzc(new zzcbk(zzcav.zzimk, j), zzcas);
                        }
                        zzaug().zzaj(str, zzcav.zzimg.name);
                    }
                }
                zzcay zzaug2 = zzaug();
                zzbp.zzgg(str);
                zzaug2.zzuj();
                zzaug2.zzwk();
                if (j < 0) {
                    zzaug2.zzaum().zzayg().zze("Invalid time querying expired conditional properties", zzcbw.zzjf(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzaug2.zzc("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzcav zzcav2 : list2) {
                    if (zzcav2 != null) {
                        zzaum().zzayj().zzd("User property expired", zzcav2.packageName, zzauh().zzje(zzcav2.zzimg.name), zzcav2.zzimg.getValue());
                        zzaug().zzag(str, zzcav2.zzimg.name);
                        if (zzcav2.zzimo != null) {
                            arrayList.add(zzcav2.zzimo);
                        }
                        zzaug().zzaj(str, zzcav2.zzimg.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzc(new zzcbk((zzcbk) obj, j), zzcas);
                }
                zzcay zzaug3 = zzaug();
                String str2 = zzcbk.name;
                zzbp.zzgg(str);
                zzbp.zzgg(str2);
                zzaug3.zzuj();
                zzaug3.zzwk();
                if (j < 0) {
                    zzaug3.zzaum().zzayg().zzd("Invalid time querying triggered conditional properties", zzcbw.zzjf(str), zzaug3.zzauh().zzjc(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzaug3.zzc("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzcav zzcav3 : list3) {
                    if (zzcav3 != null) {
                        zzcft zzcft = zzcav3.zzimg;
                        zzcfv zzcfv = new zzcfv(zzcav3.packageName, zzcav3.zzimf, zzcft.name, j, zzcft.getValue());
                        if (zzaug().zza(zzcfv)) {
                            zzaum().zzayj().zzd("User property triggered", zzcav3.packageName, zzauh().zzje(zzcfv.mName), zzcfv.mValue);
                        } else {
                            zzaum().zzaye().zzd("Too many active user properties, ignoring", zzcbw.zzjf(zzcav3.packageName), zzauh().zzje(zzcfv.mName), zzcfv.mValue);
                        }
                        if (zzcav3.zzimm != null) {
                            arrayList3.add(zzcav3.zzimm);
                        }
                        zzcav3.zzimg = new zzcft(zzcfv);
                        zzcav3.zzimi = true;
                        zzaug().zza(zzcav3);
                    }
                }
                zzc(zzcbk, zzcas);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzc(new zzcbk((zzcbk) obj2, j), zzcas);
                }
                zzaug().setTransactionSuccessful();
            } finally {
                zzaug().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzcbk zzcbk, String str) {
        zzcar zziw = zzaug().zziw(str);
        if (zziw == null || TextUtils.isEmpty(zziw.zzuo())) {
            zzaum().zzayj().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = zzbed.zzcr(this.mContext).getPackageInfo(str, 0).versionName;
            if (zziw.zzuo() != null && !zziw.zzuo().equals(str2)) {
                zzaum().zzayg().zzj("App version does not match; dropping event. appId", zzcbw.zzjf(str));
                return;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (!"_ui".equals(zzcbk.name)) {
                zzaum().zzayg().zzj("Could not find package. appId", zzcbw.zzjf(str));
            }
        }
        zzb(zzcbk, new zzcas(str, zziw.getGmpAppId(), zziw.zzuo(), zziw.zzauu(), zziw.zzauv(), zziw.zzauw(), zziw.zzaux(), (String) null, zziw.zzauy(), false, zziw.zzaur(), zziw.zzavl(), 0L, 0));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzcdu zzcdu) {
        this.zzitu++;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzcft zzcft, zzcas zzcas) {
        zzaul().zzuj();
        zzwk();
        if (!TextUtils.isEmpty(zzcas.zzilt)) {
            if (!zzcas.zzily) {
                zzf(zzcas);
                return;
            }
            int zzjy = zzaui().zzjy(zzcft.name);
            if (zzjy != 0) {
                zzaui();
                zzaui().zza(zzcas.packageName, zzjy, "_ev", zzcfw.zza(zzcft.name, zzcax.zzavp(), true), zzcft.name != null ? zzcft.name.length() : 0);
                return;
            }
            int zzl = zzaui().zzl(zzcft.name, zzcft.getValue());
            if (zzl != 0) {
                zzaui();
                String zza2 = zzcfw.zza(zzcft.name, zzcax.zzavp(), true);
                Object value = zzcft.getValue();
                int i = 0;
                if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                    i = String.valueOf(value).length();
                }
                zzaui().zza(zzcas.packageName, zzl, "_ev", zza2, i);
                return;
            }
            Object zzm = zzaui().zzm(zzcft.name, zzcft.getValue());
            if (zzm != null) {
                zzcfv zzcfv = new zzcfv(zzcas.packageName, zzcft.zzimf, zzcft.name, zzcft.zziwy, zzm);
                zzaum().zzayj().zze("Setting user property", zzauh().zzje(zzcfv.mName), zzm);
                zzaug().beginTransaction();
                try {
                    zzf(zzcas);
                    boolean zza3 = zzaug().zza(zzcfv);
                    zzaug().setTransactionSuccessful();
                    if (zza3) {
                        zzaum().zzayj().zze("User property set", zzauh().zzje(zzcfv.mName), zzcfv.mValue);
                    } else {
                        zzaum().zzaye().zze("Too many unique user properties are set. Ignoring user property", zzauh().zzje(zzcfv.mName), zzcfv.mValue);
                        zzaui().zza(zzcas.packageName, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzaug().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzaul().zzuj();
        zzwk();
        zzbp.zzgg(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzity = false;
                zzazn();
                throw th2;
            }
        }
        zzaum().zzayk().zzj("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzaug().beginTransaction();
        try {
            zzcar zziw = zzaug().zziw(str);
            boolean z = (i == 200 || i == 204 || i == 304) && th == null;
            if (zziw == null) {
                zzaum().zzayg().zzj("App does not exist in onConfigFetched. appId", zzcbw.zzjf(str));
            } else if (z || i == 404) {
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i == 404 || i == 304) {
                    if (zzauj().zzjn(str) == null && !zzauj().zzb(str, null, null)) {
                        zzaug().endTransaction();
                        this.zzity = false;
                        zzazn();
                        return;
                    }
                } else if (!zzauj().zzb(str, bArr, str2)) {
                    zzaug().endTransaction();
                    this.zzity = false;
                    zzazn();
                    return;
                }
                zziw.zzar(this.zzasb.currentTimeMillis());
                zzaug().zza(zziw);
                if (i == 404) {
                    zzaum().zzayh().zzj("Config not found. Using empty config. appId", str);
                } else {
                    zzaum().zzayk().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (!zzazb().zzyx() || !zzazi()) {
                    zzazj();
                } else {
                    zzazh();
                }
            } else {
                zziw.zzas(this.zzasb.currentTimeMillis());
                zzaug().zza(zziw);
                zzaum().zzayk().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzauj().zzjp(str);
                zzaun().zziqp.set(this.zzasb.currentTimeMillis());
                if (i == 503 || i == 429) {
                    zzaun().zziqq.set(this.zzasb.currentTimeMillis());
                }
                zzazj();
            }
            zzaug().setTransactionSuccessful();
            this.zzity = false;
            zzazn();
        } finally {
            zzaug().endTransaction();
        }
    }

    public final void zzbo(boolean z) {
        zzazj();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzcav zzcav, zzcas zzcas) {
        zzbp.zzu(zzcav);
        zzbp.zzgg(zzcav.packageName);
        zzbp.zzu(zzcav.zzimg);
        zzbp.zzgg(zzcav.zzimg.name);
        zzaul().zzuj();
        zzwk();
        if (!TextUtils.isEmpty(zzcas.zzilt)) {
            if (!zzcas.zzily) {
                zzf(zzcas);
                return;
            }
            zzaug().beginTransaction();
            try {
                zzf(zzcas);
                zzcav zzai = zzaug().zzai(zzcav.packageName, zzcav.zzimg.name);
                if (zzai != null) {
                    zzaum().zzayj().zze("Removing conditional user property", zzcav.packageName, zzauh().zzje(zzcav.zzimg.name));
                    zzaug().zzaj(zzcav.packageName, zzcav.zzimg.name);
                    if (zzai.zzimi) {
                        zzaug().zzag(zzcav.packageName, zzcav.zzimg.name);
                    }
                    if (zzcav.zzimo != null) {
                        Bundle bundle = null;
                        if (zzcav.zzimo.zzinq != null) {
                            bundle = zzcav.zzimo.zzinq.zzaya();
                        }
                        zzc(zzaui().zza(zzcav.zzimo.name, bundle, zzai.zzimf, zzcav.zzimo.zzinr, true, false), zzcas);
                    }
                } else {
                    zzaum().zzayg().zze("Conditional user property doesn't exist", zzcbw.zzjf(zzcav.packageName), zzauh().zzje(zzcav.zzimg.name));
                }
                zzaug().setTransactionSuccessful();
            } finally {
                zzaug().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzcft zzcft, zzcas zzcas) {
        zzaul().zzuj();
        zzwk();
        if (!TextUtils.isEmpty(zzcas.zzilt)) {
            if (!zzcas.zzily) {
                zzf(zzcas);
                return;
            }
            zzaum().zzayj().zzj("Removing user property", zzauh().zzje(zzcft.name));
            zzaug().beginTransaction();
            try {
                zzf(zzcas);
                zzaug().zzag(zzcas.packageName, zzcft.name);
                zzaug().setTransactionSuccessful();
                zzaum().zzayj().zzj("User property removed", zzauh().zzje(zzcft.name));
            } finally {
                zzaug().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzcas zzcas) {
        zzaul().zzuj();
        zzwk();
        zzbp.zzgg(zzcas.packageName);
        zzf(zzcas);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzcav zzcav) {
        zzcas zzjr = zzjr(zzcav.packageName);
        if (zzjr != null) {
            zzb(zzcav, zzjr);
        }
    }

    public final void zze(zzcas zzcas) {
        zzaul().zzuj();
        zzwk();
        zzbp.zzu(zzcas);
        zzbp.zzgg(zzcas.packageName);
        if (!TextUtils.isEmpty(zzcas.zzilt)) {
            zzcar zziw = zzaug().zziw(zzcas.packageName);
            if (zziw != null && TextUtils.isEmpty(zziw.getGmpAppId()) && !TextUtils.isEmpty(zzcas.zzilt)) {
                zziw.zzar(0);
                zzaug().zza(zziw);
                zzauj().zzjq(zzcas.packageName);
            }
            if (!zzcas.zzily) {
                zzf(zzcas);
                return;
            }
            long j = zzcas.zzimd;
            long j2 = j;
            if (j == 0) {
                j2 = this.zzasb.currentTimeMillis();
            }
            int i = zzcas.zzime;
            int i2 = i;
            if (!(i == 0 || i2 == 1)) {
                zzaum().zzayg().zze("Incorrect app type, assuming installed app. appId, appType", zzcbw.zzjf(zzcas.packageName), Integer.valueOf(i2));
                i2 = 0;
            }
            zzaug().beginTransaction();
            try {
                zzcar zziw2 = zzaug().zziw(zzcas.packageName);
                if (!(zziw2 == null || zziw2.getGmpAppId() == null || zziw2.getGmpAppId().equals(zzcas.zzilt))) {
                    zzaum().zzayg().zzj("New GMP App Id passed in. Removing cached database data. appId", zzcbw.zzjf(zziw2.getAppId()));
                    zzcay zzaug = zzaug();
                    String appId = zziw2.getAppId();
                    zzaug.zzwk();
                    zzaug.zzuj();
                    zzbp.zzgg(appId);
                    try {
                        SQLiteDatabase writableDatabase = zzaug.getWritableDatabase();
                        String[] strArr = {appId};
                        int delete = writableDatabase.delete(LoggingRequest.EVENTS, "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            zzaug.zzaum().zzayk().zze("Deleted application data. app, records", appId, Integer.valueOf(delete));
                        }
                    } catch (SQLiteException e) {
                        zzaug.zzaum().zzaye().zze("Error deleting application data. appId, error", zzcbw.zzjf(appId), e);
                    }
                    zziw2 = null;
                }
                if (!(zziw2 == null || zziw2.zzuo() == null || zziw2.zzuo().equals(zzcas.zzhts))) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_pv", zziw2.zzuo());
                    zzb(new zzcbk("_au", new zzcbh(bundle), "auto", j2), zzcas);
                }
                zzf(zzcas);
                zzcbg zzcbg = null;
                if (i2 == 0) {
                    zzcbg = zzaug().zzaf(zzcas.packageName, "_f");
                } else if (i2 == 1) {
                    zzcbg = zzaug().zzaf(zzcas.packageName, "_v");
                }
                if (zzcbg == null) {
                    long j3 = ((j2 / 3600000) + 1) * 3600000;
                    if (i2 == 0) {
                        zzb(new zzcft("_fot", j2, Long.valueOf(j3), "auto"), zzcas);
                        zzaul().zzuj();
                        zzwk();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1);
                        bundle2.putLong("_r", 1);
                        bundle2.putLong("_uwa", 0);
                        bundle2.putLong("_pfo", 0);
                        bundle2.putLong("_sys", 0);
                        bundle2.putLong("_sysu", 0);
                        if (this.mContext.getPackageManager() == null) {
                            zzaum().zzaye().zzj("PackageManager is null, first open report might be inaccurate. appId", zzcbw.zzjf(zzcas.packageName));
                        } else {
                            PackageInfo packageInfo = null;
                            try {
                                packageInfo = zzbed.zzcr(this.mContext).getPackageInfo(zzcas.packageName, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                zzaum().zzaye().zze("Package info is null, first open report might be inaccurate. appId", zzcbw.zzjf(zzcas.packageName), e2);
                            }
                            if (!(packageInfo == null || packageInfo.firstInstallTime == 0)) {
                                boolean z = false;
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    bundle2.putLong("_uwa", 1);
                                } else {
                                    z = true;
                                }
                                zzb(new zzcft("_fi", j2, Long.valueOf(z ? 1 : 0), "auto"), zzcas);
                            }
                            ApplicationInfo applicationInfo = null;
                            try {
                                applicationInfo = zzbed.zzcr(this.mContext).getApplicationInfo(zzcas.packageName, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                zzaum().zzaye().zze("Application info is null, first open report might be inaccurate. appId", zzcbw.zzjf(zzcas.packageName), e3);
                            }
                            if (applicationInfo != null) {
                                if ((applicationInfo.flags & 1) != 0) {
                                    bundle2.putLong("_sys", 1);
                                }
                                if ((applicationInfo.flags & 128) != 0) {
                                    bundle2.putLong("_sysu", 1);
                                }
                            }
                        }
                        zzcay zzaug2 = zzaug();
                        String str = zzcas.packageName;
                        zzbp.zzgg(str);
                        zzaug2.zzuj();
                        zzaug2.zzwk();
                        long zzam = zzaug2.zzam(str, "first_open_count");
                        if (zzam >= 0) {
                            bundle2.putLong("_pfo", zzam);
                        }
                        zzb(new zzcbk("_f", new zzcbh(bundle2), "auto", j2), zzcas);
                    } else if (i2 == 1) {
                        zzb(new zzcft("_fvt", j2, Long.valueOf(j3), "auto"), zzcas);
                        zzaul().zzuj();
                        zzwk();
                        Bundle bundle3 = new Bundle();
                        bundle3.putLong("_c", 1);
                        bundle3.putLong("_r", 1);
                        zzb(new zzcbk("_v", new zzcbh(bundle3), "auto", j2), zzcas);
                    }
                    Bundle bundle4 = new Bundle();
                    bundle4.putLong("_et", 1);
                    zzb(new zzcbk("_e", new zzcbh(bundle4), "auto", j2), zzcas);
                } else if (zzcas.zzilz) {
                    zzb(new zzcbk("_cd", new zzcbh(new Bundle()), "auto", j2), zzcas);
                }
                zzaug().setTransactionSuccessful();
            } finally {
                zzaug().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzcav zzcav) {
        zzcas zzjr = zzjr(zzcav.packageName);
        if (zzjr != null) {
            zzc(zzcav, zzjr);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(Runnable runnable) {
        zzaul().zzuj();
        if (this.zzitt == null) {
            this.zzitt = new ArrayList();
        }
        this.zzitt.add(runnable);
    }

    public final String zzjs(String str) {
        try {
            return (String) zzaul().zzd(new zzccy(this, str)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaum().zzaye().zze("Failed to get app instance id. appId", zzcbw.zzjf(str), e);
            return null;
        }
    }

    public final zzd zzvx() {
        return this.zzasb;
    }

    /* access modifiers changed from: package-private */
    public final void zzwk() {
        if (!this.zzdod) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }
}
