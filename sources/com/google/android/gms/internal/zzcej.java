package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
/* access modifiers changed from: package-private */
@TargetApi(14)
public final class zzcej implements Application.ActivityLifecycleCallbacks {
    private /* synthetic */ zzcdw zziux;

    private zzcej(zzcdw zzcdw) {
        this.zziux = zzcdw;
    }

    /* synthetic */ zzcej(zzcdw zzcdw, zzcdx zzcdx) {
        this(zzcdw);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        Uri data;
        try {
            this.zziux.zzaum().zzayk().log("onActivityCreated");
            Intent intent = activity.getIntent();
            if (!(intent == null || (data = intent.getData()) == null || !data.isHierarchical())) {
                if (bundle == null) {
                    Bundle zzp = this.zziux.zzaui().zzp(data);
                    this.zziux.zzaui();
                    String str = zzcfw.zzl(intent) ? "gs" : "auto";
                    if (zzp != null) {
                        this.zziux.zzc(str, "_cmp", zzp);
                    }
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                        this.zziux.zzaum().zzayj().log("Activity created with data 'referrer' param without gclid and at least one utm field");
                        return;
                    }
                    this.zziux.zzaum().zzayj().zzj("Activity created with referrer", queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        this.zziux.zzb("auto", "_ldl", queryParameter);
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
            this.zziux.zzaum().zzaye().zzj("Throwable caught in onActivityCreated", th);
        }
        zzcek zzaue = this.zziux.zzaue();
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service")) != null) {
            zzcen zzq = zzaue.zzq(activity);
            zzq.zziko = bundle2.getLong("id");
            zzq.zzikm = bundle2.getString("name");
            zzq.zzikn = bundle2.getString("referrer_name");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zziux.zzaue().onActivityDestroyed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zziux.zzaue().onActivityPaused(activity);
        zzcfl zzauk = this.zziux.zzauk();
        zzauk.zzaul().zzg(new zzcfp(zzauk, zzauk.zzvx().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.zziux.zzaue().onActivityResumed(activity);
        zzcfl zzauk = this.zziux.zzauk();
        zzauk.zzaul().zzg(new zzcfo(zzauk, zzauk.zzvx().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zziux.zzaue().onActivitySaveInstanceState(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
