package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbp;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public final class zzang extends zzams {
    private boolean mStarted;
    private final zzand zzdpo;
    private final zzaop zzdpp;
    private final zzaoo zzdpq;
    private final zzamy zzdpr;
    private long zzdps = Long.MIN_VALUE;
    private final zzanx zzdpt;
    private final zzanx zzdpu;
    private final zzaoz zzdpv;
    private long zzdpw;
    private boolean zzdpx;

    protected zzang(zzamu zzamu, zzamw zzamw) {
        super(zzamu);
        zzbp.zzu(zzamw);
        this.zzdpq = new zzaoo(zzamu);
        this.zzdpo = new zzand(zzamu);
        this.zzdpp = new zzaop(zzamu);
        this.zzdpr = new zzamy(zzamu);
        this.zzdpv = new zzaoz(zzvx());
        this.zzdpt = new zzanh(this, zzamu);
        this.zzdpu = new zzani(this, zzamu);
    }

    private final void zza(zzamx zzamx, zzalw zzalw) {
        zzbp.zzu(zzamx);
        zzbp.zzu(zzalw);
        zza zza = new zza(zzvw());
        zza.zzcw(zzamx.zzws());
        zza.enableAdvertisingIdCollection(zzamx.zzwt());
        zzg zzts = zza.zzts();
        zzame zzame = (zzame) zzts.zzb(zzame.class);
        zzame.zzdh(Event.DATA);
        zzame.zzai(true);
        zzts.zza(zzalw);
        zzalz zzalz = (zzalz) zzts.zzb(zzalz.class);
        zzalv zzalv = (zzalv) zzts.zzb(zzalv.class);
        for (Map.Entry<String, String> entry : zzamx.zziy().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                zzalv.setAppName(value);
            } else if ("av".equals(key)) {
                zzalv.setAppVersion(value);
            } else if ("aid".equals(key)) {
                zzalv.setAppId(value);
            } else if ("aiid".equals(key)) {
                zzalv.setAppInstallerId(value);
            } else if ("uid".equals(key)) {
                zzame.setUserId(value);
            } else {
                zzalz.set(key, value);
            }
        }
        zzb("Sending installation campaign to", zzamx.zzws(), zzalw);
        zzts.zzl(zzwf().zzzb());
        zzts.zzua();
    }

    private final boolean zzdt(String str) {
        return zzbed.zzcr(getContext()).checkCallingOrSelfPermission(str) == 0;
    }

    private final long zzxa() {
        zzj.zzuj();
        zzwk();
        try {
            return this.zzdpo.zzxa();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public final void zzxf() {
        zzb(new zzank(this));
    }

    /* access modifiers changed from: private */
    public final void zzxg() {
        try {
            this.zzdpo.zzwz();
            zzxk();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzdpu.zzs(86400000);
    }

    private final void zzxh() {
        if (!this.zzdpx && zzanv.zzxv() && !this.zzdpr.isConnected()) {
            if (this.zzdpv.zzu(zzaod.zzdsm.get().longValue())) {
                this.zzdpv.start();
                zzdm("Connecting to service");
                if (this.zzdpr.connect()) {
                    zzdm("Connected to service");
                    this.zzdpv.clear();
                    onServiceConnected();
                }
            }
        }
    }

    private final boolean zzxi() {
        zzj.zzuj();
        zzwk();
        zzdm("Dispatching a batch of local hits");
        boolean z = !this.zzdpr.isConnected();
        boolean z2 = !this.zzdpp.zzyx();
        if (!z || !z2) {
            long max = (long) Math.max(zzanv.zzxz(), zzanv.zzya());
            ArrayList arrayList = new ArrayList();
            long j = 0;
            while (true) {
                try {
                    this.zzdpo.beginTransaction();
                    arrayList.clear();
                    try {
                        List<zzaoi> zzo = this.zzdpo.zzo(max);
                        if (zzo.isEmpty()) {
                            zzdm("Store is empty, nothing to dispatch");
                            zzxm();
                            try {
                                this.zzdpo.setTransactionSuccessful();
                                this.zzdpo.endTransaction();
                                return false;
                            } catch (SQLiteException e) {
                                zze("Failed to commit local dispatch transaction", e);
                                zzxm();
                                return false;
                            }
                        } else {
                            zza("Hits loaded from store. count", Integer.valueOf(zzo.size()));
                            for (zzaoi zzaoi : zzo) {
                                if (zzaoi.zzym() == j) {
                                    zzd("Database contains successfully uploaded hit", Long.valueOf(j), Integer.valueOf(zzo.size()));
                                    zzxm();
                                    try {
                                        return false;
                                    } catch (SQLiteException e2) {
                                    }
                                }
                            }
                            if (this.zzdpr.isConnected()) {
                                zzdm("Service connected, sending hits to the service");
                                while (!zzo.isEmpty()) {
                                    zzaoi zzaoi2 = zzo.get(0);
                                    if (!this.zzdpr.zzb(zzaoi2)) {
                                        break;
                                    }
                                    j = Math.max(j, zzaoi2.zzym());
                                    zzo.remove(zzaoi2);
                                    zzb("Hit sent do device AnalyticsService for delivery", zzaoi2);
                                    try {
                                        this.zzdpo.zzp(zzaoi2.zzym());
                                        arrayList.add(Long.valueOf(zzaoi2.zzym()));
                                    } catch (SQLiteException e3) {
                                        zze("Failed to remove hit that was send for delivery", e3);
                                        zzxm();
                                        try {
                                            this.zzdpo.setTransactionSuccessful();
                                            this.zzdpo.endTransaction();
                                            return false;
                                        } catch (SQLiteException e4) {
                                            zze("Failed to commit local dispatch transaction", e4);
                                            zzxm();
                                            return false;
                                        }
                                    }
                                }
                            }
                            if (this.zzdpp.zzyx()) {
                                List<Long> zzs = this.zzdpp.zzs(zzo);
                                for (Long l : zzs) {
                                    j = Math.max(j, l.longValue());
                                }
                                try {
                                    this.zzdpo.zzq(zzs);
                                    arrayList.addAll(zzs);
                                } catch (SQLiteException e5) {
                                    zze("Failed to remove successfully uploaded hits", e5);
                                    zzxm();
                                    try {
                                        this.zzdpo.setTransactionSuccessful();
                                        this.zzdpo.endTransaction();
                                        return false;
                                    } catch (SQLiteException e6) {
                                        zze("Failed to commit local dispatch transaction", e6);
                                        zzxm();
                                        return false;
                                    }
                                }
                            }
                            if (arrayList.isEmpty()) {
                                try {
                                    this.zzdpo.setTransactionSuccessful();
                                    this.zzdpo.endTransaction();
                                    return false;
                                } catch (SQLiteException e7) {
                                    zze("Failed to commit local dispatch transaction", e7);
                                    zzxm();
                                    return false;
                                }
                            } else {
                                try {
                                    this.zzdpo.setTransactionSuccessful();
                                    this.zzdpo.endTransaction();
                                } catch (SQLiteException e8) {
                                    zze("Failed to commit local dispatch transaction", e8);
                                    zzxm();
                                    return false;
                                }
                            }
                        }
                    } catch (SQLiteException e9) {
                        zzd("Failed to read hits from persisted store", e9);
                        zzxm();
                        try {
                            this.zzdpo.setTransactionSuccessful();
                            this.zzdpo.endTransaction();
                            return false;
                        } catch (SQLiteException e10) {
                            zze("Failed to commit local dispatch transaction", e10);
                            zzxm();
                            return false;
                        }
                    }
                } finally {
                    try {
                        this.zzdpo.setTransactionSuccessful();
                        this.zzdpo.endTransaction();
                    } catch (SQLiteException e2) {
                        zze("Failed to commit local dispatch transaction", e2);
                        zzxm();
                        return false;
                    }
                }
            }
        } else {
            zzdm("No network or service available. Will retry later");
            return false;
        }
    }

    private final void zzxl() {
        zzaoa zzwd = zzwd();
        if (zzwd.zzyj() && !zzwd.zzdp()) {
            long zzxa = zzxa();
            if (zzxa != 0 && Math.abs(zzvx().currentTimeMillis() - zzxa) <= zzaod.zzdrl.get().longValue()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzanv.zzxy()));
                zzwd.schedule();
            }
        }
    }

    private final void zzxm() {
        if (this.zzdpt.zzdp()) {
            zzdm("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzdpt.cancel();
        zzaoa zzwd = zzwd();
        if (zzwd.zzdp()) {
            zzwd.cancel();
        }
    }

    private final long zzxn() {
        if (this.zzdps != Long.MIN_VALUE) {
            return this.zzdps;
        }
        long longValue = zzaod.zzdrg.get().longValue();
        zzape zzwe = zzwe();
        zzwe.zzwk();
        if (!zzwe.zzdum) {
            return longValue;
        }
        zzape zzwe2 = zzwe();
        zzwe2.zzwk();
        return ((long) zzwe2.zzdst) * 1000;
    }

    private final void zzxo() {
        zzwk();
        zzj.zzuj();
        this.zzdpx = true;
        this.zzdpr.disconnect();
        zzxk();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[LOOP:1: B:18:0x0050->B:26:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0041 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected() {
        /*
            r7 = this;
            com.google.android.gms.analytics.zzj.zzuj()
            r3 = r7
            com.google.android.gms.analytics.zzj.zzuj()
            r3.zzwk()
            boolean r0 = com.google.android.gms.internal.zzanv.zzxv()
            if (r0 != 0) goto L_0x0015
            java.lang.String r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService"
            r3.zzdp(r0)
        L_0x0015:
            com.google.android.gms.internal.zzamy r0 = r3.zzdpr
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "Service not connected"
            r3.zzdm(r0)
            return
        L_0x0023:
            com.google.android.gms.internal.zzand r0 = r3.zzdpo
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0082
            java.lang.String r0 = "Dispatching local hits to device AnalyticsService"
            r3.zzdm(r0)
        L_0x0030:
            com.google.android.gms.internal.zzand r0 = r3.zzdpo     // Catch:{ SQLiteException -> 0x0046 }
            int r1 = com.google.android.gms.internal.zzanv.zzxz()     // Catch:{ SQLiteException -> 0x0046 }
            long r1 = (long) r1     // Catch:{ SQLiteException -> 0x0046 }
            java.util.List r4 = r0.zzo(r1)     // Catch:{ SQLiteException -> 0x0046 }
            boolean r0 = r4.isEmpty()     // Catch:{ SQLiteException -> 0x0046 }
            if (r0 == 0) goto L_0x0045
            r3.zzxk()     // Catch:{ SQLiteException -> 0x0046 }
            return
        L_0x0045:
            goto L_0x0050
        L_0x0046:
            r5 = move-exception
            java.lang.String r0 = "Failed to read hits from store"
            r3.zze(r0, r5)
            r3.zzxm()
            return
        L_0x0050:
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x0081
            r0 = 0
            java.lang.Object r0 = r4.get(r0)
            r5 = r0
            com.google.android.gms.internal.zzaoi r5 = (com.google.android.gms.internal.zzaoi) r5
            com.google.android.gms.internal.zzamy r0 = r3.zzdpr
            boolean r0 = r0.zzb(r5)
            if (r0 != 0) goto L_0x006a
            r3.zzxk()
            return
        L_0x006a:
            r4.remove(r5)
            com.google.android.gms.internal.zzand r0 = r3.zzdpo     // Catch:{ SQLiteException -> 0x0077 }
            long r1 = r5.zzym()     // Catch:{ SQLiteException -> 0x0077 }
            r0.zzp(r1)     // Catch:{ SQLiteException -> 0x0077 }
            goto L_0x0050
        L_0x0077:
            r6 = move-exception
            java.lang.String r0 = "Failed to remove hit that was send for delivery"
            r3.zze(r0, r6)
            r3.zzxm()
            return
        L_0x0081:
            goto L_0x0030
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzang.onServiceConnected():void");
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        zzwk();
        zzbp.zza(!this.mStarted, "Analytics backend already started");
        this.mStarted = true;
        zzwa().zzc(new zzanj(this));
    }

    public final long zza(zzamx zzamx, boolean z) {
        zzbp.zzu(zzamx);
        zzwk();
        zzj.zzuj();
        try {
            this.zzdpo.beginTransaction();
            zzand zzand = this.zzdpo;
            long zzwr = zzamx.zzwr();
            String zzve = zzamx.zzve();
            zzbp.zzgg(zzve);
            zzand.zzwk();
            zzj.zzuj();
            int delete = zzand.getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(zzwr), zzve});
            if (delete > 0) {
                zzand.zza("Deleted property records", Integer.valueOf(delete));
            }
            long zza = this.zzdpo.zza(zzamx.zzwr(), zzamx.zzve(), zzamx.zzws());
            zzamx.zzm(1 + zza);
            zzand zzand2 = this.zzdpo;
            zzbp.zzu(zzamx);
            zzand2.zzwk();
            zzj.zzuj();
            SQLiteDatabase writableDatabase = zzand2.getWritableDatabase();
            Map<String, String> zziy = zzamx.zziy();
            zzbp.zzu(zziy);
            Uri.Builder builder = new Uri.Builder();
            for (Map.Entry<String, String> entry : zziy.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            String encodedQuery = builder.build().getEncodedQuery();
            String str = encodedQuery == null ? "" : encodedQuery;
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uid", Long.valueOf(zzamx.zzwr()));
            contentValues.put("cid", zzamx.zzve());
            contentValues.put("tid", zzamx.zzws());
            contentValues.put("adid", Integer.valueOf(zzamx.zzwt() ? 1 : 0));
            contentValues.put("hits_count", Long.valueOf(zzamx.zzwu()));
            contentValues.put("params", str);
            try {
                if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                    zzand2.zzdq("Failed to insert/update a property (got -1)");
                }
            } catch (SQLiteException e) {
                zzand2.zze("Error storing a property", e);
            }
            this.zzdpo.setTransactionSuccessful();
            try {
                this.zzdpo.endTransaction();
            } catch (SQLiteException e2) {
                zze("Failed to end transaction", e2);
            }
            return zza;
        } catch (SQLiteException e3) {
            zze("Failed to update Analytics property", e3);
            try {
                this.zzdpo.endTransaction();
                return -1;
            } catch (SQLiteException e4) {
                zze("Failed to end transaction", e4);
                return -1;
            }
        } catch (Throwable th) {
            try {
                this.zzdpo.endTransaction();
            } catch (SQLiteException e5) {
                zze("Failed to end transaction", e5);
            }
            throw th;
        }
    }

    public final void zza(zzaoi zzaoi) {
        zzaoi zzaoi2;
        zzbp.zzu(zzaoi);
        zzj.zzuj();
        zzwk();
        if (this.zzdpx) {
            zzdn("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzaoi);
        }
        if (!TextUtils.isEmpty(zzaoi.zzyr())) {
            zzaoi2 = zzaoi;
        } else {
            Pair<String, Long> zzzi = zzwf().zzzg().zzzi();
            if (zzzi == null) {
                zzaoi2 = zzaoi;
            } else {
                Long l = (Long) zzzi.second;
                String str = (String) zzzi.first;
                String valueOf = String.valueOf(l);
                String sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(valueOf).length() + 1).append(valueOf).append(":").append(str).toString();
                HashMap hashMap = new HashMap(zzaoi.zziy());
                hashMap.put("_m", sb);
                zzaoi2 = new zzaoi(this, hashMap, zzaoi.zzyn(), zzaoi.zzyp(), zzaoi.zzym(), zzaoi.zzyl(), zzaoi.zzyo());
            }
        }
        zzxh();
        if (this.zzdpr.zzb(zzaoi2)) {
            zzdn("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.zzdpo.zzc(zzaoi2);
            zzxk();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            zzvy().zza(zzaoi2, "deliver: failed to insert hit to database");
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzamx zzamx) {
        zzj.zzuj();
        zzb("Sending first hit to property", zzamx.zzws());
        if (!zzwf().zzzc().zzu(zzanv.zzyf())) {
            String zzzf = zzwf().zzzf();
            if (!TextUtils.isEmpty(zzzf)) {
                zzalw zza = zzapd.zza(zzvy(), zzzf);
                zzb("Found relevant installation campaign", zza);
                zza(zzamx, zza);
            }
        }
    }

    public final void zzb(zzaob zzaob) {
        long j = this.zzdpw;
        zzj.zzuj();
        zzwk();
        long j2 = -1;
        long zzzd = zzwf().zzzd();
        if (zzzd != 0) {
            j2 = Math.abs(zzvx().currentTimeMillis() - zzzd);
        }
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        zzxh();
        try {
            zzxi();
            zzwf().zzze();
            zzxk();
            if (zzaob != null) {
                zzaob.zzb(null);
            }
            if (this.zzdpw != j) {
                this.zzdpq.zzyw();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zzwf().zzze();
            zzxk();
            if (zzaob != null) {
                zzaob.zzb(th);
            }
        }
    }

    public final void zzdu(String str) {
        zzbp.zzgg(str);
        zzj.zzuj();
        zzalw zza = zzapd.zza(zzvy(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzzf = zzwf().zzzf();
        if (str.equals(zzzf)) {
            zzdp("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(zzzf)) {
            zzd("Ignoring multiple install campaigns. original, new", zzzf, str);
        } else {
            zzwf().zzdx(str);
            if (zzwf().zzzc().zzu(zzanv.zzyf())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzamx zzamx : this.zzdpo.zzq(0)) {
                zza(zzamx, zza);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
        this.zzdpo.initialize();
        this.zzdpp.initialize();
        this.zzdpr.initialize();
    }

    /* access modifiers changed from: package-private */
    public final void zzvv() {
        zzj.zzuj();
        this.zzdpw = zzvx().currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public final void zzxe() {
        zzwk();
        zzj.zzuj();
        Context context = zzvw().getContext();
        if (!zzaou.zzbe(context)) {
            zzdp("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzaov.zzbi(context)) {
            zzdq("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzbe(context)) {
            zzdp("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzwf().zzzb();
        if (!zzdt("android.permission.ACCESS_NETWORK_STATE")) {
            zzdq("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzxo();
        }
        if (!zzdt("android.permission.INTERNET")) {
            zzdq("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzxo();
        }
        if (zzaov.zzbi(getContext())) {
            zzdm("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzdp("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzdpx && !this.zzdpo.isEmpty()) {
            zzxh();
        }
        zzxk();
    }

    public final void zzxk() {
        boolean z;
        long j;
        zzj.zzuj();
        zzwk();
        if (!(!this.zzdpx && zzxn() > 0)) {
            this.zzdpq.unregister();
            zzxm();
        } else if (this.zzdpo.isEmpty()) {
            this.zzdpq.unregister();
            zzxm();
        } else {
            if (!zzaod.zzdsh.get().booleanValue()) {
                this.zzdpq.zzyu();
                z = this.zzdpq.isConnected();
            } else {
                z = true;
            }
            if (z) {
                zzxl();
                long zzxn = zzxn();
                long zzzd = zzwf().zzzd();
                if (zzzd != 0) {
                    long abs = zzxn - Math.abs(zzvx().currentTimeMillis() - zzzd);
                    j = abs > 0 ? abs : Math.min(zzanv.zzxx(), zzxn);
                } else {
                    j = Math.min(zzanv.zzxx(), zzxn);
                }
                zza("Dispatch scheduled (ms)", Long.valueOf(j));
                if (this.zzdpt.zzdp()) {
                    this.zzdpt.zzt(Math.max(1L, this.zzdpt.zzyg() + j));
                } else {
                    this.zzdpt.zzs(j);
                }
            } else {
                zzxm();
                zzxl();
            }
        }
    }
}
