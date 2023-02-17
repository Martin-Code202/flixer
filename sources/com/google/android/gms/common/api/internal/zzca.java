package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzbz;
@Deprecated
public final class zzca {
    private static final Object zzaqc = new Object();
    private static zzca zzfoi;
    private final String mAppId;
    private final Status zzfoj;
    private final boolean zzfok;
    private final boolean zzfol;

    private zzca(Context context) {
        Resources resources = context.getResources();
        boolean z = true;
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            z = resources.getInteger(identifier) != 0;
            this.zzfol = !z;
        } else {
            this.zzfol = false;
        }
        this.zzfok = z;
        String zzcf = zzbe.zzcf(context);
        zzcf = zzcf == null ? new zzbz(context).getString("google_app_id") : zzcf;
        if (TextUtils.isEmpty(zzcf)) {
            this.zzfoj = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.mAppId = null;
            return;
        }
        this.mAppId = zzcf;
        this.zzfoj = Status.zzfhu;
    }

    public static String zzaie() {
        return zzft("getGoogleAppId").mAppId;
    }

    public static boolean zzaif() {
        return zzft("isMeasurementExplicitlyDisabled").zzfol;
    }

    public static Status zzcb(Context context) {
        Status status;
        zzbp.zzb(context, "Context must not be null.");
        synchronized (zzaqc) {
            if (zzfoi == null) {
                zzfoi = new zzca(context);
            }
            status = zzfoi.zzfoj;
        }
        return status;
    }

    private static zzca zzft(String str) {
        zzca zzca;
        synchronized (zzaqc) {
            if (zzfoi == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            zzca = zzfoi;
        }
        return zzca;
    }
}
