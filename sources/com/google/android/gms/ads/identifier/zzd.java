package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.zzo;
/* access modifiers changed from: package-private */
public final class zzd {
    private SharedPreferences zzamb;

    zzd(Context context) {
        try {
            Context remoteContext = zzo.getRemoteContext(context);
            this.zzamb = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.zzamb = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean getBoolean(String str, boolean z) {
        try {
            if (this.zzamb == null) {
                return false;
            }
            return this.zzamb.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final float getFloat(String str, float f) {
        try {
            if (this.zzamb == null) {
                return 0.0f;
            }
            return this.zzamb.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public final String getString(String str, String str2) {
        try {
            return this.zzamb == null ? str2 : this.zzamb.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }
}
