package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
/* access modifiers changed from: package-private */
public final class zzcbb extends SQLiteOpenHelper {
    private /* synthetic */ zzcay zzinc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcbb(zzcay zzcay, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzinc = zzcay;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        if (!this.zzinc.zzimw.zzu(zzcax.zzawf())) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.zzinc.zzimw.start();
            this.zzinc.zzaum().zzaye().log("Opening the database failed, dropping and recreating it");
            String zzawj = zzcax.zzawj();
            if (!this.zzinc.getContext().getDatabasePath(zzawj).delete()) {
                this.zzinc.zzaum().zzaye().zzj("Failed to delete corrupted db file", zzawj);
            }
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.zzinc.zzimw.clear();
                return writableDatabase;
            } catch (SQLiteException e) {
                this.zzinc.zzaum().zzaye().zzj("Failed to open freshly created database", e);
                throw e;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase);
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
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, LoggingRequest.EVENTS, "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzcay.zzimq);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzcay.zzimr);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzcay.zzimt);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzcay.zzims);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        zzcay.zza(this.zzinc.zzaum(), sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzcay.zzimu);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
