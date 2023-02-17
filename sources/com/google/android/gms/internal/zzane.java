package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* access modifiers changed from: package-private */
public final class zzane extends SQLiteOpenHelper {
    private /* synthetic */ zzand zzdpn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzane(zzand zzand, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzdpn = zzand;
    }

    private static void zza(SQLiteDatabase sQLiteDatabase) {
        Set<String> zzb = zzb(sQLiteDatabase, "properties");
        String[] strArr = {"app_uid", "cid", "tid", "params", "adid", "hits_count"};
        for (int i = 0; i < 6; i++) {
            String str = strArr[i];
            if (!zzb.remove(str)) {
                String valueOf = String.valueOf(str);
                throw new SQLiteException(valueOf.length() != 0 ? "Database properties is missing required column: ".concat(valueOf) : new String("Database properties is missing required column: "));
            }
        }
        if (!zzb.isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
        }
    }

    private final boolean zza(SQLiteDatabase sQLiteDatabase, String str) {
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
            this.zzdpn.zzc("Error querying for table", str, e);
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

    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        String[] columnNames;
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            for (String str2 : rawQuery.getColumnNames()) {
                hashSet.add(str2);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        if (!this.zzdpn.zzdpm.zzu(3600000)) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.zzdpn.zzdpm.start();
            this.zzdpn.zzdq("Opening the database failed, dropping the table and recreating it");
            zzand zzand = this.zzdpn;
            this.zzdpn.getContext().getDatabasePath(zzand.zzxb()).delete();
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.zzdpn.zzdpm.clear();
                return writableDatabase;
            } catch (SQLiteException e) {
                this.zzdpn.zze("Failed to open freshly created database", e);
                throw e;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (zzaoc.version() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (Build.VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (!zza(sQLiteDatabase, "hits2")) {
            sQLiteDatabase.execSQL(zzand.zzdpi);
        } else {
            Set<String> zzb = zzb(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (!zzb.remove(str)) {
                    String valueOf = String.valueOf(str);
                    throw new SQLiteException(valueOf.length() != 0 ? "Database hits2 is missing required column: ".concat(valueOf) : new String("Database hits2 is missing required column: "));
                }
            }
            boolean z = !zzb.remove("hit_app_id");
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (z) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        }
        if (!zza(sQLiteDatabase, "properties")) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
        } else {
            zza(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
