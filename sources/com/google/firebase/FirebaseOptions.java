package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzbz;
import com.google.android.gms.common.util.zzs;
import java.util.Arrays;
public final class FirebaseOptions {
    private final String zzehx;
    private final String zzlgn;
    private final String zzlgo;
    private final String zzlgp;
    private final String zzlgq;
    private final String zzlgr;
    private final String zzlgs;

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        zzbp.zza(!zzs.zzgm(str), "ApplicationId must be set.");
        this.zzehx = str;
        this.zzlgn = str2;
        this.zzlgo = str3;
        this.zzlgp = str4;
        this.zzlgq = str5;
        this.zzlgr = str6;
        this.zzlgs = str7;
    }

    public static FirebaseOptions fromResource(Context context) {
        zzbz zzbz = new zzbz(context);
        String string = zzbz.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, zzbz.getString("google_api_key"), zzbz.getString("firebase_database_url"), zzbz.getString("ga_trackingId"), zzbz.getString("gcm_defaultSenderId"), zzbz.getString("google_storage_bucket"), zzbz.getString("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return zzbf.equal(this.zzehx, firebaseOptions.zzehx) && zzbf.equal(this.zzlgn, firebaseOptions.zzlgn) && zzbf.equal(this.zzlgo, firebaseOptions.zzlgo) && zzbf.equal(this.zzlgp, firebaseOptions.zzlgp) && zzbf.equal(this.zzlgq, firebaseOptions.zzlgq) && zzbf.equal(this.zzlgr, firebaseOptions.zzlgr) && zzbf.equal(this.zzlgs, firebaseOptions.zzlgs);
    }

    public final String getApplicationId() {
        return this.zzehx;
    }

    public final String getGcmSenderId() {
        return this.zzlgq;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzehx, this.zzlgn, this.zzlgo, this.zzlgp, this.zzlgq, this.zzlgr, this.zzlgs});
    }

    public final String toString() {
        return zzbf.zzt(this).zzg("applicationId", this.zzehx).zzg("apiKey", this.zzlgn).zzg("databaseUrl", this.zzlgo).zzg("gcmSenderId", this.zzlgq).zzg("storageBucket", this.zzlgr).zzg("projectId", this.zzlgs).toString();
    }
}
