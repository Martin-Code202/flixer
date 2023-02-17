package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzl;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public final class zzand extends zzams implements Closeable {
    private static final String zzdpi = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String zzdpj = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final zzane zzdpk;
    private final zzaoz zzdpl = new zzaoz(zzvx());
    private final zzaoz zzdpm = new zzaoz(zzvx());

    zzand(zzamu zzamu) {
        super(zzamu);
        this.zzdpk = new zzane(this, zzamu.getContext(), "google_analytics_v4.db");
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
            } else if (rawQuery == null) {
                return 0;
            } else {
                rawQuery.close();
                return 0;
            }
        } catch (SQLiteException e) {
            zzd("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, null);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzd("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final Map<String, String> zzdr(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (str.startsWith("?")) {
                str2 = str;
            } else {
                String valueOf = String.valueOf(str);
                str2 = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            return zzl.zza(new URI(str2), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    private final Map<String, String> zzds(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String valueOf = String.valueOf(str);
            return zzl.zza(new URI(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    private final List<Long> zzn(long j) {
        zzj.zzuj();
        zzwk();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor query = writableDatabase.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
            if (query.moveToFirst()) {
                do {
                    arrayList.add(Long.valueOf(query.getLong(0)));
                } while (query.moveToNext());
            }
            if (query != null) {
                query.close();
            }
        } catch (SQLiteException e) {
            zzd("Error selecting hit ids", e);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    private final long zzwu() {
        zzj.zzuj();
        zzwk();
        return zzb("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    /* access modifiers changed from: private */
    public static String zzxb() {
        return "google_analytics_v4.db";
    }

    public final void beginTransaction() {
        zzwk();
        getWritableDatabase().beginTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.zzdpk.close();
        } catch (SQLiteException e) {
            zze("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            zze("Error closing database", e2);
        }
    }

    public final void endTransaction() {
        zzwk();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzdpk.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        return zzwu() == 0;
    }

    public final void setTransactionSuccessful() {
        zzwk();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(long j, String str, String str2) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzwk();
        zzj.zzuj();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    public final void zzc(zzaoi zzaoi) {
        zzbp.zzu(zzaoi);
        zzj.zzuj();
        zzwk();
        zzbp.zzu(zzaoi);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : zzaoi.zziy().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        String str = encodedQuery == null ? "" : encodedQuery;
        if (str.length() > 8192) {
            zzvy().zza(zzaoi, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = zzaod.zzdrd.get().intValue();
        long zzwu = zzwu();
        if (zzwu > ((long) (intValue - 1))) {
            List<Long> zzn = zzn((zzwu - ((long) intValue)) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(zzn.size()));
            zzq(zzn);
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", str);
        contentValues.put("hit_time", Long.valueOf(zzaoi.zzyn()));
        contentValues.put("hit_app_id", Integer.valueOf(zzaoi.zzyl()));
        contentValues.put("hit_url", zzaoi.zzyp() ? zzanv.zzyb() : zzanv.zzyc());
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                zzdq("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzaoi);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    public final List<zzaoi> zzo(long j) {
        zzbp.zzbh(j >= 0);
        zzj.zzuj();
        zzwk();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
            ArrayList arrayList = new ArrayList();
            if (query.moveToFirst()) {
                do {
                    arrayList.add(new zzaoi(this, zzdr(query.getString(2)), query.getLong(1), zzapd.zzed(query.getString(3)), query.getLong(0), query.getInt(4)));
                } while (query.moveToNext());
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zze("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzp(long j) {
        zzj.zzuj();
        zzwk();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        zzq(arrayList);
    }

    public final List<zzamx> zzq(long j) {
        zzwk();
        zzj.zzuj();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor = null;
        try {
            int intValue = zzaod.zzdrf.get().intValue();
            Cursor query = writableDatabase.query("properties", new String[]{"cid", "tid", "adid", "hits_count", "params"}, "app_uid=?", new String[]{"0"}, null, null, null, String.valueOf(intValue));
            ArrayList arrayList = new ArrayList();
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    boolean z = query.getInt(2) != 0;
                    long j2 = (long) query.getInt(3);
                    Map<String, String> zzds = zzds(query.getString(4));
                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                        zzc("Read property with empty client id or tracker id", string, string2);
                    } else {
                        arrayList.add(new zzamx(0, string, string2, z, j2, zzds));
                    }
                } while (query.moveToNext());
            }
            if (arrayList.size() >= intValue) {
                zzdp("Sending hits to too many properties. Campaign report might be incorrect");
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zze("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzq(List<Long> list) {
        zzbp.zzu(list);
        zzj.zzuj();
        zzwk();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            for (int i = 0; i < list.size(); i++) {
                Long l = list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(l);
            }
            sb.append(")");
            String sb2 = sb.toString();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = writableDatabase.delete("hits2", sb2, null);
                if (delete != list.size()) {
                    zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                }
            } catch (SQLiteException e) {
                zze("Error deleting hits", e);
                throw e;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
    }

    public final int zzwz() {
        zzj.zzuj();
        zzwk();
        if (!this.zzdpl.zzu(86400000)) {
            return 0;
        }
        this.zzdpl.start();
        zzdm("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzvx().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long zzxa() {
        zzj.zzuj();
        zzwk();
        return zza(zzdpj, (String[]) null, 0);
    }
}
