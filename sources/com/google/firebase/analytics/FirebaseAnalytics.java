package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzccw;
@Keep
public final class FirebaseAnalytics {
    private final zzccw zzikh;

    public static class Event {
        protected Event() {
        }
    }

    public static class Param {
        protected Param() {
        }
    }

    public static class UserProperty {
        protected UserProperty() {
        }
    }

    public FirebaseAnalytics(zzccw zzccw) {
        zzbp.zzu(zzccw);
        this.zzikh = zzccw;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        return zzccw.zzdn(context).zzaza();
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzikh.zzaue().setCurrentScreen(activity, str, str2);
    }
}
