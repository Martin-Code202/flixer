package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbp;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* access modifiers changed from: package-private */
public final class zzcay extends zzcdu {
    private static final Map<String, String> zzimq;
    private static final Map<String, String> zzimr;
    private static final Map<String, String> zzims;
    private static final Map<String, String> zzimt;
    private static final Map<String, String> zzimu;
    private final zzcbb zzimv = new zzcbb(this, getContext(), zzcax.zzawj());
    private final zzcfq zzimw = new zzcfq(zzvx());

    static {
        ArrayMap arrayMap = new ArrayMap(1);
        zzimq = arrayMap;
        arrayMap.put("origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;");
        ArrayMap arrayMap2 = new ArrayMap(18);
        zzimr = arrayMap2;
        arrayMap2.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        zzimr.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        zzimr.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        zzimr.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        zzimr.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        zzimr.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        zzimr.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        zzimr.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        zzimr.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        zzimr.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        zzimr.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        zzimr.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        zzimr.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        zzimr.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        zzimr.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        zzimr.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
        zzimr.put("daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;");
        zzimr.put("health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;");
        zzimr.put("android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;");
        ArrayMap arrayMap3 = new ArrayMap(1);
        zzims = arrayMap3;
        arrayMap3.put("realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;");
        ArrayMap arrayMap4 = new ArrayMap(1);
        zzimt = arrayMap4;
        arrayMap4.put("has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;");
        ArrayMap arrayMap5 = new ArrayMap(1);
        zzimu = arrayMap5;
        arrayMap5.put("previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;");
    }

    zzcay(zzccw zzccw) {
        super(zzccw);
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzaum().zzaye().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzaum().zzaye().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzaum().zzaye().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        zzbp.zzgg(str);
        zzbp.zzu(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    static void zza(zzcbw zzcbw, SQLiteDatabase sQLiteDatabase) {
        if (zzcbw == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzcbw.zzayg().log("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzcbw.zzayg().log("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzcbw.zzayg().log("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            zzcbw.zzayg().log("Failed to turn on database write permission for owner");
        }
    }

    static void zza(zzcbw zzcbw, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) {
        if (zzcbw == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzcbw, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            zza(zzcbw, sQLiteDatabase, str, str3, map);
        } catch (SQLiteException e) {
            zzcbw.zzaye().zzj("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    private static void zza(zzcbw zzcbw, SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) {
        if (zzcbw == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Set<String> zzb = zzb(sQLiteDatabase, str);
        String[] split = str2.split(",");
        for (String str3 : split) {
            if (!zzb.remove(str3)) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str3).length() + String.valueOf(str).length() + 35).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
            }
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!zzb.remove(entry.getKey())) {
                    sQLiteDatabase.execSQL(entry.getValue());
                }
            }
        }
        if (!zzb.isEmpty()) {
            zzcbw.zzayg().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
        }
    }

    private static boolean zza(zzcbw zzcbw, SQLiteDatabase sQLiteDatabase, String str) {
        if (zzcbw == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            cursor = query;
            boolean moveToFirst = query.moveToFirst();
            if (cursor != null) {
                cursor.close();
            }
            return moveToFirst;
        } catch (SQLiteException e) {
            zzcbw.zzayg().zze("Error querying for table", str, e);
            if (cursor == null) {
                return false;
            }
            cursor.close();
            return false;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean zza(String str, int i, zzcfy zzcfy) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        zzbp.zzu(zzcfy);
        if (TextUtils.isEmpty(zzcfy.zzixn)) {
            zzaum().zzayg().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzcbw.zzjf(str), Integer.valueOf(i), String.valueOf(zzcfy.zzixm));
            return false;
        }
        try {
            byte[] bArr = new byte[zzcfy.zzhi()];
            zzegy zzi = zzegy.zzi(bArr, 0, bArr.length);
            zzcfy.zza(zzi);
            zzi.zzccm();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzcfy.zzixm);
            contentValues.put("event_name", zzcfy.zzixn);
            contentValues.put(Event.DATA, bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzaum().zzaye().zzj("Failed to insert event filter (got -1). appId", zzcbw.zzjf(str));
                return true;
            } catch (SQLiteException e) {
                zzaum().zzaye().zze("Error storing event filter. appId", zzcbw.zzjf(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzaum().zzaye().zze("Configuration loss. Failed to serialize event filter. appId", zzcbw.zzjf(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzcgb zzcgb) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        zzbp.zzu(zzcgb);
        if (TextUtils.isEmpty(zzcgb.zziyc)) {
            zzaum().zzayg().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzcbw.zzjf(str), Integer.valueOf(i), String.valueOf(zzcgb.zzixm));
            return false;
        }
        try {
            byte[] bArr = new byte[zzcgb.zzhi()];
            zzegy zzi = zzegy.zzi(bArr, 0, bArr.length);
            zzcgb.zza(zzi);
            zzi.zzccm();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzcgb.zzixm);
            contentValues.put("property_name", zzcgb.zziyc);
            contentValues.put(Event.DATA, bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzaum().zzaye().zzj("Failed to insert property filter (got -1). appId", zzcbw.zzjf(str));
                return false;
            } catch (SQLiteException e) {
                zzaum().zzaye().zze("Error storing property filter. appId", zzcbw.zzjf(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzaum().zzaye().zze("Configuration loss. Failed to serialize property filter. appId", zzcbw.zzjf(str), e2);
            return false;
        }
    }

    private final boolean zzaxr() {
        return getContext().getDatabasePath(zzcax.zzawj()).exists();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private final boolean zzc(String str, List<Integer> list) {
        zzbp.zzgg(str);
        zzwk();
        zzuj();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long zzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzauo().zzb(str, zzcbm.zzipf)));
            if (zzb <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            String sb = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            return writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(sb).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(sb).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Database error querying filters. appId", zzcbw.zzjf(str), e);
            return false;
        }
    }

    public final void beginTransaction() {
        zzwk();
        getWritableDatabase().beginTransaction();
    }

    public final void endTransaction() {
        zzwk();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase getWritableDatabase() {
        zzuj();
        try {
            return this.zzimv.getWritableDatabase();
        } catch (SQLiteException e) {
            zzaum().zzayg().zzj("Error opening database", e);
            throw e;
        }
    }

    public final void setTransactionSuccessful() {
        zzwk();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(zzcgk zzcgk) {
        long j;
        zzuj();
        zzwk();
        zzbp.zzu(zzcgk);
        zzbp.zzgg(zzcgk.zzch);
        try {
            byte[] bArr = new byte[zzcgk.zzhi()];
            zzegy zzi = zzegy.zzi(bArr, 0, bArr.length);
            zzcgk.zza(zzi);
            zzi.zzccm();
            zzcfw zzaui = zzaui();
            zzbp.zzu(bArr);
            zzaui.zzuj();
            MessageDigest zzec = zzcfw.zzec("MD5");
            if (zzec == null) {
                zzaui.zzaum().zzaye().log("Failed to get MD5");
                j = 0;
            } else {
                j = zzcfw.zzq(zzec.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcgk.zzch);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzaum().zzaye().zze("Error storing raw event metadata. appId", zzcbw.zzjf(zzcgk.zzch), e);
                throw e;
            }
        } catch (IOException e2) {
            zzaum().zzaye().zze("Data loss. Failed to serialize event metadata. appId", zzcbw.zzjf(zzcgk.zzch), e2);
            throw e2;
        }
    }

    public final zzcaz zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        zzbp.zzgg(str);
        zzuj();
        zzwk();
        String[] strArr = {str};
        zzcaz zzcaz = new zzcaz();
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Cursor query = writableDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            if (!query.moveToFirst()) {
                zzaum().zzayg().zzj("Not updating daily counts, app is not known. appId", zzcbw.zzjf(str));
                if (query != null) {
                    query.close();
                }
                return zzcaz;
            }
            if (query.getLong(0) == j) {
                zzcaz.zzimy = query.getLong(1);
                zzcaz.zzimx = query.getLong(2);
                zzcaz.zzimz = query.getLong(3);
                zzcaz.zzina = query.getLong(4);
                zzcaz.zzinb = query.getLong(5);
            }
            if (z) {
                zzcaz.zzimy++;
            }
            if (z2) {
                zzcaz.zzimx++;
            }
            if (z3) {
                zzcaz.zzimz++;
            }
            if (z4) {
                zzcaz.zzina++;
            }
            if (z5) {
                zzcaz.zzinb++;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzcaz.zzimx));
            contentValues.put("daily_events_count", Long.valueOf(zzcaz.zzimy));
            contentValues.put("daily_conversions_count", Long.valueOf(zzcaz.zzimz));
            contentValues.put("daily_error_events_count", Long.valueOf(zzcaz.zzina));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzcaz.zzinb));
            writableDatabase.update("apps", contentValues, "app_id=?", strArr);
            if (query != null) {
                query.close();
            }
            return zzcaz;
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error updating daily counts. appId", zzcbw.zzjf(str), e);
            if (0 != 0) {
                cursor.close();
            }
            return zzcaz;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zza(zzcar zzcar) {
        zzbp.zzu(zzcar);
        zzuj();
        zzwk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcar.getAppId());
        contentValues.put("app_instance_id", zzcar.getAppInstanceId());
        contentValues.put("gmp_app_id", zzcar.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzcar.zzauq());
        contentValues.put("last_bundle_index", Long.valueOf(zzcar.zzauz()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzcar.zzaus()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzcar.zzaut()));
        contentValues.put("app_version", zzcar.zzuo());
        contentValues.put("app_store", zzcar.zzauv());
        contentValues.put("gmp_version", Long.valueOf(zzcar.zzauw()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzcar.zzaux()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzcar.zzauy()));
        contentValues.put("day", Long.valueOf(zzcar.zzavd()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzcar.zzave()));
        contentValues.put("daily_events_count", Long.valueOf(zzcar.zzavf()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzcar.zzavg()));
        contentValues.put("config_fetched_time", Long.valueOf(zzcar.zzava()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzcar.zzavb()));
        contentValues.put("app_version_int", Long.valueOf(zzcar.zzauu()));
        contentValues.put("firebase_instance_id", zzcar.zzaur());
        contentValues.put("daily_error_events_count", Long.valueOf(zzcar.zzavi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzcar.zzavh()));
        contentValues.put("health_monitor_sample", zzcar.zzavj());
        contentValues.put("android_id", Long.valueOf(zzcar.zzavl()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzcar.getAppId()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzaum().zzaye().zzj("Failed to insert/update app (got -1). appId", zzcbw.zzjf(zzcar.getAppId()));
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error storing app. appId", zzcbw.zzjf(zzcar.getAppId()), e);
        }
    }

    public final void zza(zzcbg zzcbg) {
        zzbp.zzu(zzcbg);
        zzuj();
        zzwk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcbg.mAppId);
        contentValues.put("name", zzcbg.mName);
        contentValues.put("lifetime_count", Long.valueOf(zzcbg.zzink));
        contentValues.put("current_bundle_count", Long.valueOf(zzcbg.zzinl));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzcbg.zzinm));
        try {
            if (getWritableDatabase().insertWithOnConflict(LoggingRequest.EVENTS, null, contentValues, 5) == -1) {
                zzaum().zzaye().zzj("Failed to insert/update event aggregates (got -1). appId", zzcbw.zzjf(zzcbg.mAppId));
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error storing event aggregates. appId", zzcbw.zzjf(zzcbg.mAppId), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzcfx[] zzcfxArr) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        zzbp.zzu(zzcfxArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzwk();
            zzuj();
            zzbp.zzgg(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete("property_filters", "app_id=?", new String[]{str});
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzcfx zzcfx : zzcfxArr) {
                zzwk();
                zzuj();
                zzbp.zzgg(str);
                zzbp.zzu(zzcfx);
                zzbp.zzu(zzcfx.zzixk);
                zzbp.zzu(zzcfx.zzixj);
                if (zzcfx.zzixi == null) {
                    zzaum().zzayg().zzj("Audience with no ID. appId", zzcbw.zzjf(str));
                } else {
                    int intValue = zzcfx.zzixi.intValue();
                    zzcfy[] zzcfyArr = zzcfx.zzixk;
                    int length = zzcfyArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            zzcgb[] zzcgbArr = zzcfx.zzixj;
                            int length2 = zzcgbArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    boolean z = true;
                                    zzcfy[] zzcfyArr2 = zzcfx.zzixk;
                                    int length3 = zzcfyArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length3) {
                                            break;
                                        } else if (!zza(str, intValue, zzcfyArr2[i3])) {
                                            z = false;
                                            break;
                                        } else {
                                            i3++;
                                        }
                                    }
                                    if (z) {
                                        zzcgb[] zzcgbArr2 = zzcfx.zzixj;
                                        int length4 = zzcgbArr2.length;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= length4) {
                                                break;
                                            } else if (!zza(str, intValue, zzcgbArr2[i4])) {
                                                z = false;
                                                break;
                                            } else {
                                                i4++;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzwk();
                                        zzuj();
                                        zzbp.zzgg(str);
                                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                    }
                                } else if (zzcgbArr[i2].zzixm == null) {
                                    zzaum().zzayg().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzcbw.zzjf(str), zzcfx.zzixi);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        } else if (zzcfyArr[i].zzixm == null) {
                            zzaum().zzayg().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzcbw.zzjf(str), zzcfx.zzixi);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzcfx zzcfx2 : zzcfxArr) {
                arrayList.add(zzcfx2.zzixi);
            }
            zzc(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final boolean zza(zzcav zzcav) {
        zzbp.zzu(zzcav);
        zzuj();
        zzwk();
        if (zzah(zzcav.packageName, zzcav.zzimg.name) == null) {
            long zzb = zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzcav.packageName});
            zzcax.zzawc();
            if (zzb >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcav.packageName);
        contentValues.put("origin", zzcav.zzimf);
        contentValues.put("name", zzcav.zzimg.name);
        zza(contentValues, "value", zzcav.zzimg.getValue());
        contentValues.put("active", Boolean.valueOf(zzcav.zzimi));
        contentValues.put("trigger_event_name", zzcav.zzimj);
        contentValues.put("trigger_timeout", Long.valueOf(zzcav.zziml));
        zzaui();
        contentValues.put("timed_out_event", zzcfw.zza(zzcav.zzimk));
        contentValues.put("creation_timestamp", Long.valueOf(zzcav.zzimh));
        zzaui();
        contentValues.put("triggered_event", zzcfw.zza(zzcav.zzimm));
        contentValues.put("triggered_timestamp", Long.valueOf(zzcav.zzimg.zziwy));
        contentValues.put("time_to_live", Long.valueOf(zzcav.zzimn));
        zzaui();
        contentValues.put("expired_event", zzcfw.zza(zzcav.zzimo));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzaum().zzaye().zzj("Failed to insert/update conditional user property (got -1)", zzcbw.zzjf(zzcav.packageName));
            return true;
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error storing conditional user property", zzcbw.zzjf(zzcav.packageName), e);
            return true;
        }
    }

    public final boolean zza(zzcbf zzcbf, long j, boolean z) {
        zzuj();
        zzwk();
        zzbp.zzu(zzcbf);
        zzbp.zzgg(zzcbf.mAppId);
        zzcgh zzcgh = new zzcgh();
        zzcgh.zziyy = Long.valueOf(zzcbf.zzini);
        zzcgh.zziyw = new zzcgi[zzcbf.zzinj.size()];
        int i = 0;
        Iterator<String> it = zzcbf.zzinj.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzcgi zzcgi = new zzcgi();
            i++;
            zzcgh.zziyw[i] = zzcgi;
            zzcgi.name = next;
            zzaui().zza(zzcgi, zzcbf.zzinj.get(next));
        }
        try {
            byte[] bArr = new byte[zzcgh.zzhi()];
            zzegy zzi = zzegy.zzi(bArr, 0, bArr.length);
            zzcgh.zza(zzi);
            zzi.zzccm();
            zzaum().zzayk().zze("Saving event, name, data size", zzauh().zzjc(zzcbf.mName), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcbf.mAppId);
            contentValues.put("name", zzcbf.mName);
            contentValues.put("timestamp", Long.valueOf(zzcbf.zzfdb));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put(Event.DATA, bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzaum().zzaye().zzj("Failed to insert raw event (got -1). appId", zzcbw.zzjf(zzcbf.mAppId));
                return false;
            } catch (SQLiteException e) {
                zzaum().zzaye().zze("Error storing raw event. appId", zzcbw.zzjf(zzcbf.mAppId), e);
                return false;
            }
        } catch (IOException e2) {
            zzaum().zzaye().zze("Data loss. Failed to serialize event params/data. appId", zzcbw.zzjf(zzcbf.mAppId), e2);
            return false;
        }
    }

    public final boolean zza(zzcfv zzcfv) {
        zzbp.zzu(zzcfv);
        zzuj();
        zzwk();
        if (zzah(zzcfv.mAppId, zzcfv.mName) == null) {
            if (zzcfw.zzju(zzcfv.mName)) {
                long zzb = zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzcfv.mAppId});
                zzcax.zzavz();
                if (zzb >= 25) {
                    return false;
                }
            } else {
                long zzb2 = zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzcfv.mAppId, zzcfv.mOrigin});
                zzcax.zzawb();
                if (zzb2 >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcfv.mAppId);
        contentValues.put("origin", zzcfv.mOrigin);
        contentValues.put("name", zzcfv.mName);
        contentValues.put("set_timestamp", Long.valueOf(zzcfv.zzixc));
        zza(contentValues, "value", zzcfv.mValue);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            zzaum().zzaye().zzj("Failed to insert/update user property (got -1). appId", zzcbw.zzjf(zzcfv.mAppId));
            return true;
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error storing user property. appId", zzcbw.zzjf(zzcfv.mAppId), e);
            return true;
        }
    }

    public final boolean zza(zzcgk zzcgk, boolean z) {
        zzuj();
        zzwk();
        zzbp.zzu(zzcgk);
        zzbp.zzgg(zzcgk.zzch);
        zzbp.zzu(zzcgk.zzizi);
        zzaxl();
        long currentTimeMillis = zzvx().currentTimeMillis();
        if (zzcgk.zzizi.longValue() < currentTimeMillis - zzcax.zzawn() || zzcgk.zzizi.longValue() > zzcax.zzawn() + currentTimeMillis) {
            zzaum().zzayg().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzcbw.zzjf(zzcgk.zzch), Long.valueOf(currentTimeMillis), zzcgk.zzizi);
        }
        try {
            byte[] bArr = new byte[zzcgk.zzhi()];
            zzegy zzi = zzegy.zzi(bArr, 0, bArr.length);
            zzcgk.zza(zzi);
            zzi.zzccm();
            byte[] zzo = zzaui().zzo(bArr);
            zzaum().zzayk().zzj("Saving bundle, size", Integer.valueOf(zzo.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcgk.zzch);
            contentValues.put("bundle_end_timestamp", zzcgk.zzizi);
            contentValues.put(Event.DATA, zzo);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzaum().zzaye().zzj("Failed to insert bundle (got -1). appId", zzcbw.zzjf(zzcgk.zzch));
                return false;
            } catch (SQLiteException e) {
                zzaum().zzaye().zze("Error storing bundle. appId", zzcbw.zzjf(zzcgk.zzch), e);
                return false;
            }
        } catch (IOException e2) {
            zzaum().zzaye().zze("Data loss. Failed to serialize bundle. appId", zzcbw.zzjf(zzcgk.zzch), e2);
            return false;
        }
    }

    public final void zzae(List<Long> list) {
        zzbp.zzu(list);
        zzuj();
        zzwk();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(list.get(i).longValue());
        }
        sb.append(")");
        int delete = getWritableDatabase().delete("raw_events", sb.toString(), null);
        if (delete != list.size()) {
            zzaum().zzaye().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public final zzcbg zzaf(String str, String str2) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzuj();
        zzwk();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query(LoggingRequest.EVENTS, new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            cursor = query;
            if (query.moveToFirst()) {
                zzcbg zzcbg = new zzcbg(str, str2, cursor.getLong(0), cursor.getLong(1), cursor.getLong(2));
                if (cursor.moveToNext()) {
                    zzaum().zzaye().zzj("Got multiple records for event aggregates, expected one. appId", zzcbw.zzjf(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return zzcbg;
            } else if (cursor == null) {
                return null;
            } else {
                cursor.close();
                return null;
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zzd("Error querying events. appId", zzcbw.zzjf(str), zzauh().zzjc(str2), e);
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzag(String str, String str2) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzuj();
        zzwk();
        try {
            zzaum().zzayk().zzj("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzaum().zzaye().zzd("Error deleting user attribute. appId", zzcbw.zzjf(str), zzauh().zzje(str2), e);
        }
    }

    public final zzcfv zzah(String str, String str2) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzuj();
        zzwk();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            cursor = query;
            if (query.moveToFirst()) {
                zzcfv zzcfv = new zzcfv(str, cursor.getString(2), str2, cursor.getLong(0), zza(cursor, 1));
                if (cursor.moveToNext()) {
                    zzaum().zzaye().zzj("Got multiple records for user property, expected one. appId", zzcbw.zzjf(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return zzcfv;
            } else if (cursor == null) {
                return null;
            } else {
                cursor.close();
                return null;
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zzd("Error querying user property. appId", zzcbw.zzjf(str), zzauh().zzje(str2), e);
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzcav zzai(String str, String str2) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzuj();
        zzwk();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            cursor = query;
            if (query.moveToFirst()) {
                String string = cursor.getString(0);
                Object zza = zza(cursor, 1);
                boolean z = cursor.getInt(2) != 0;
                String string2 = cursor.getString(3);
                long j = cursor.getLong(4);
                zzcav zzcav = new zzcav(str, string, new zzcft(str2, cursor.getLong(8), zza, string), cursor.getLong(6), z, string2, (zzcbk) zzaui().zzb(cursor.getBlob(5), zzcbk.CREATOR), j, (zzcbk) zzaui().zzb(cursor.getBlob(7), zzcbk.CREATOR), cursor.getLong(9), (zzcbk) zzaui().zzb(cursor.getBlob(10), zzcbk.CREATOR));
                if (cursor.moveToNext()) {
                    zzaum().zzaye().zze("Got multiple records for conditional property, expected one", zzcbw.zzjf(str), zzauh().zzje(str2));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return zzcav;
            } else if (cursor == null) {
                return null;
            } else {
                cursor.close();
                return null;
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zzd("Error querying conditional property", zzcbw.zzjf(str), zzauh().zzje(str2), e);
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final int zzaj(String str, String str2) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzuj();
        zzwk();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzaum().zzaye().zzd("Error deleting conditional property", zzcbw.zzjf(str), zzauh().zzje(str2), e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzcfy>> zzak(String str, String str2) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("event_filters", new String[]{"audience_id", Event.DATA}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (!query.moveToFirst()) {
                Map<Integer, List<zzcfy>> emptyMap = Collections.emptyMap();
                if (query != null) {
                    query.close();
                }
                return emptyMap;
            }
            do {
                byte[] blob = query.getBlob(1);
                zzegx zzh = zzegx.zzh(blob, 0, blob.length);
                zzcfy zzcfy = new zzcfy();
                try {
                    zzcfy.zza(zzh);
                    int i = query.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(zzcfy);
                } catch (IOException e) {
                    zzaum().zzaye().zze("Failed to merge filter. appId", zzcbw.zzjf(str), e);
                }
            } while (query.moveToNext());
            if (query != null) {
                query.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzaum().zzaye().zze("Database error querying filters. appId", zzcbw.zzjf(str), e2);
            if (0 == 0) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzcgb>> zzal(String str, String str2) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("property_filters", new String[]{"audience_id", Event.DATA}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (!query.moveToFirst()) {
                Map<Integer, List<zzcgb>> emptyMap = Collections.emptyMap();
                if (query != null) {
                    query.close();
                }
                return emptyMap;
            }
            do {
                byte[] blob = query.getBlob(1);
                zzegx zzh = zzegx.zzh(blob, 0, blob.length);
                zzcgb zzcgb = new zzcgb();
                try {
                    zzcgb.zza(zzh);
                    int i = query.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(zzcgb);
                } catch (IOException e) {
                    zzaum().zzaye().zze("Failed to merge filter", zzcbw.zzjf(str), e);
                }
            } while (query.moveToNext());
            if (query != null) {
                query.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzaum().zzaye().zze("Database error querying filters. appId", zzcbw.zzjf(str), e2);
            if (0 == 0) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final long zzam(String str, String str2) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzuj();
        zzwk();
        long j = 0;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            long zza = zza(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1);
            j = zza;
            if (zza == -1) {
                j = 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", (Integer) 0);
                contentValues.put("previous_install_count", (Integer) 0);
                if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzaum().zzaye().zze("Failed to insert column (got -1). appId", zzcbw.zzjf(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put(str2, Long.valueOf(1 + j));
            if (((long) writableDatabase.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                zzaum().zzaye().zze("Failed to update column (got 0). appId", zzcbw.zzjf(str), str2);
                writableDatabase.endTransaction();
                return -1;
            }
            writableDatabase.setTransactionSuccessful();
            return j;
        } catch (SQLiteException e) {
            zzaum().zzaye().zzd("Error inserting column. appId", zzcbw.zzjf(str), str2, e);
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final String zzaxj() {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            } else if (rawQuery == null) {
                return null;
            } else {
                rawQuery.close();
                return null;
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zzj("Database error getting next bundle app id", e);
            if (0 == 0) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean zzaxk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzaxl() {
        int delete;
        zzuj();
        zzwk();
        if (zzaxr()) {
            long j = zzaun().zziqr.get();
            long elapsedRealtime = zzvx().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzcax.zzawo()) {
                zzaun().zziqr.set(elapsedRealtime);
                zzuj();
                zzwk();
                if (zzaxr() && (delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzvx().currentTimeMillis()), String.valueOf(zzcax.zzawn())})) > 0) {
                    zzaum().zzayk().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final long zzaxm() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long zzaxn() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzaxo() {
        return zzb("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzaxp() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzaxq() {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            cursor = rawQuery;
            if (rawQuery.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } else if (cursor == null) {
                return -1;
            } else {
                cursor.close();
                return -1;
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zzj("Error querying raw events", e);
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final String zzba(long j) {
        zzuj();
        zzwk();
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            if (!rawQuery.moveToFirst()) {
                zzaum().zzayk().log("No expired configs for apps with pending events");
                if (rawQuery == null) {
                    return null;
                }
                rawQuery.close();
                return null;
            }
            String string = rawQuery.getString(0);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return string;
        } catch (SQLiteException e) {
            zzaum().zzaye().zzj("Error selecting expired configs", e);
            if (0 == 0) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzcav> zzc(String str, String[] strArr) {
        zzuj();
        zzwk();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            zzcax.zzawc();
            Cursor query = getWritableDatabase().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            cursor = query;
            if (!query.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < zzcax.zzawc()) {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    boolean z = cursor.getInt(4) != 0;
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    arrayList.add(new zzcav(string, string2, new zzcft(string3, cursor.getLong(10), zza, string2), cursor.getLong(8), z, string4, (zzcbk) zzaui().zzb(cursor.getBlob(7), zzcbk.CREATOR), j, (zzcbk) zzaui().zzb(cursor.getBlob(9), zzcbk.CREATOR), cursor.getLong(11), (zzcbk) zzaui().zzb(cursor.getBlob(12), zzcbk.CREATOR)));
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzaum().zzaye().zzj("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(zzcax.zzawc()));
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzaum().zzaye().zzj("Error querying conditional user property value", e);
            List<zzcav> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzcfv> zzg(String str, String str2, String str3) {
        zzbp.zzgg(str);
        zzuj();
        zzwk();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                arrayList2.add(str2);
                sb.append(" and origin=?");
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                sb.append(" and name glob ?");
            }
            String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            String sb2 = sb.toString();
            zzcax.zzawa();
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb2, strArr, null, null, "rowid", "1001");
            if (!query.moveToFirst()) {
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < zzcax.zzawa()) {
                    String string = query.getString(0);
                    long j = query.getLong(1);
                    Object zza = zza(query, 2);
                    String string2 = query.getString(3);
                    if (zza == null) {
                        zzaum().zzaye().zzd("(2)Read invalid user property value, ignoring it", zzcbw.zzjf(str), string2, str3);
                    } else {
                        arrayList.add(new zzcfv(str, string2, string, j, zza));
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } else {
                    zzaum().zzaye().zzj("Read more than the max allowed user properties, ignoring excess", Integer.valueOf(zzcax.zzawa()));
                    break;
                }
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzaum().zzaye().zzd("(2)Error querying user properties", zzcbw.zzjf(str), str2, e);
            if (0 == 0) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzcav> zzh(String str, String str2, String str3) {
        zzbp.zzgg(str);
        zzuj();
        zzwk();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzc(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzcfv> zziv(String str) {
        zzbp.zzgg(str);
        zzuj();
        zzwk();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzcax.zzawa()));
            cursor = query;
            if (!query.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                String string = cursor.getString(0);
                String string2 = cursor.getString(1);
                if (string2 == null) {
                    string2 = "";
                }
                long j = cursor.getLong(2);
                Object zza = zza(cursor, 3);
                if (zza == null) {
                    zzaum().zzaye().zzj("Read invalid user property value, ignoring it. appId", zzcbw.zzjf(str));
                } else {
                    arrayList.add(new zzcfv(str, string2, string, j, zza));
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error querying user properties. appId", zzcbw.zzjf(str), e);
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzcar zziw(String str) {
        zzbp.zzgg(str);
        zzuj();
        zzwk();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id"}, "app_id=?", new String[]{str}, null, null, null);
            cursor = query;
            if (query.moveToFirst()) {
                zzcar zzcar = new zzcar(this.zzikh, str);
                zzcar.zzim(cursor.getString(0));
                zzcar.zzin(cursor.getString(1));
                zzcar.zzio(cursor.getString(2));
                zzcar.zzaq(cursor.getLong(3));
                zzcar.zzal(cursor.getLong(4));
                zzcar.zzam(cursor.getLong(5));
                zzcar.setAppVersion(cursor.getString(6));
                zzcar.zziq(cursor.getString(7));
                zzcar.zzao(cursor.getLong(8));
                zzcar.zzap(cursor.getLong(9));
                zzcar.setMeasurementEnabled((cursor.isNull(10) ? 1 : cursor.getInt(10)) != 0);
                zzcar.zzat(cursor.getLong(11));
                zzcar.zzau(cursor.getLong(12));
                zzcar.zzav(cursor.getLong(13));
                zzcar.zzaw(cursor.getLong(14));
                zzcar.zzar(cursor.getLong(15));
                zzcar.zzas(cursor.getLong(16));
                zzcar.zzan(cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                zzcar.zzip(cursor.getString(18));
                zzcar.zzay(cursor.getLong(19));
                zzcar.zzax(cursor.getLong(20));
                zzcar.zzir(cursor.getString(21));
                zzcar.zzaz(cursor.isNull(22) ? 0 : cursor.getLong(22));
                zzcar.zzaup();
                if (cursor.moveToNext()) {
                    zzaum().zzaye().zzj("Got multiple records for app, expected one. appId", zzcbw.zzjf(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return zzcar;
            } else if (cursor == null) {
                return null;
            } else {
                cursor.close();
                return null;
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error querying app. appId", zzcbw.zzjf(str), e);
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zzix(String str) {
        zzbp.zzgg(str);
        zzuj();
        zzwk();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzauo().zzb(str, zzcbm.zziop))))});
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error deleting over the limit events. appId", zzcbw.zzjf(str), e);
            return 0;
        }
    }

    public final byte[] zziy(String str) {
        zzbp.zzgg(str);
        zzuj();
        zzwk();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            cursor = query;
            if (query.moveToFirst()) {
                byte[] blob = cursor.getBlob(0);
                if (cursor.moveToNext()) {
                    zzaum().zzaye().zzj("Got multiple records for app config, expected one. appId", zzcbw.zzjf(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return blob;
            } else if (cursor == null) {
                return null;
            } else {
                cursor.close();
                return null;
            }
        } catch (SQLiteException e) {
            zzaum().zzaye().zze("Error querying remote config. appId", zzcbw.zzjf(str), e);
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, zzcgl> zziz(String str) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            cursor = query;
            if (query.moveToFirst()) {
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursor.getInt(0);
                    byte[] blob = cursor.getBlob(1);
                    zzegx zzh = zzegx.zzh(blob, 0, blob.length);
                    zzcgl zzcgl = new zzcgl();
                    try {
                        zzcgl.zza(zzh);
                        arrayMap.put(Integer.valueOf(i), zzcgl);
                    } catch (IOException e) {
                        zzaum().zzaye().zzd("Failed to merge filter results. appId, audienceId, error", zzcbw.zzjf(str), Integer.valueOf(i), e);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } else if (cursor == null) {
                return null;
            } else {
                cursor.close();
                return null;
            }
        } catch (SQLiteException e2) {
            zzaum().zzaye().zze("Database error querying filter results. appId", zzcbw.zzjf(str), e2);
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zzja(String str) {
        zzbp.zzgg(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final List<Pair<zzcgk, Long>> zzl(String str, int i, int i2) {
        zzuj();
        zzwk();
        zzbp.zzbh(i > 0);
        zzbp.zzbh(i2 > 0);
        zzbp.zzgg(str);
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("queue", new String[]{"rowid", Event.DATA}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            if (!query.moveToFirst()) {
                List<Pair<zzcgk, Long>> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = query.getLong(0);
                try {
                    byte[] zzp = zzaui().zzp(query.getBlob(1));
                    if (!arrayList.isEmpty() && zzp.length + i3 > i2) {
                        break;
                    }
                    zzegx zzh = zzegx.zzh(zzp, 0, zzp.length);
                    zzcgk zzcgk = new zzcgk();
                    try {
                        zzcgk.zza(zzh);
                        i3 += zzp.length;
                        arrayList.add(Pair.create(zzcgk, Long.valueOf(j)));
                    } catch (IOException e) {
                        zzaum().zzaye().zze("Failed to merge queued bundle. appId", zzcbw.zzjf(str), e);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzaum().zzaye().zze("Failed to unzip queued bundle. appId", zzcbw.zzjf(str), e2);
                }
            } while (i3 <= i2);
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzaum().zzaye().zze("Error querying bundles. appId", zzcbw.zzjf(str), e3);
            List<Pair<zzcgk, Long>> emptyList2 = Collections.emptyList();
            if (0 != 0) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
    }
}
