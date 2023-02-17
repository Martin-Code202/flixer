package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
/* access modifiers changed from: package-private */
@TargetApi(11)
public final class zzcbt extends SQLiteOpenHelper {
    private /* synthetic */ zzcbs zzipm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcbt(zzcbs zzcbs, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzipm = zzcbs;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException e) {
            if (Build.VERSION.SDK_INT < 11 || !(e instanceof SQLiteDatabaseLockedException)) {
                this.zzipm.zzaum().zzaye().log("Opening the local database failed, dropping and recreating it");
                String zzawk = zzcax.zzawk();
                if (!this.zzipm.getContext().getDatabasePath(zzawk).delete()) {
                    this.zzipm.zzaum().zzaye().zzj("Failed to delete corrupted local db file", zzawk);
                }
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException e2) {
                    this.zzipm.zzaum().zzaye().zzj("Failed to open local database. Events will bypass local storage", e2);
                    return null;
                }
            } else {
                throw e;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzcay.zza(this.zzipm.zzaum(), sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
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
        zzcay.zza(this.zzipm.zzaum(), sQLiteDatabase, SignupConstants.Field.MESSAGES, "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
