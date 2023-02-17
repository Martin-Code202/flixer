package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public final class zzawd extends zzavr {
    private final MediaRouter zzejy;
    private final Map<MediaRouteSelector, Set<MediaRouter.Callback>> zzeqm = new HashMap();

    public zzawd(MediaRouter mediaRouter) {
        this.zzejy = mediaRouter;
    }

    public final void setMediaSessionCompat(MediaSessionCompat mediaSessionCompat) {
        this.zzejy.setMediaSessionCompat(mediaSessionCompat);
    }

    @Override // com.google.android.gms.internal.zzavq
    public final void zza(Bundle bundle, int i) {
        MediaRouteSelector fromBundle = MediaRouteSelector.fromBundle(bundle);
        for (MediaRouter.Callback callback : this.zzeqm.get(fromBundle)) {
            this.zzejy.addCallback(fromBundle, callback, i);
        }
    }

    @Override // com.google.android.gms.internal.zzavq
    public final void zza(Bundle bundle, zzavs zzavs) {
        MediaRouteSelector fromBundle = MediaRouteSelector.fromBundle(bundle);
        if (!this.zzeqm.containsKey(fromBundle)) {
            this.zzeqm.put(fromBundle, new HashSet());
        }
        this.zzeqm.get(fromBundle).add(new zzawc(zzavs));
    }

    @Override // com.google.android.gms.internal.zzavq
    public final void zzacm() {
        this.zzejy.selectRoute(this.zzejy.getDefaultRoute());
    }

    @Override // com.google.android.gms.internal.zzavq
    public final boolean zzacn() {
        return this.zzejy.getSelectedRoute().getId().equals(this.zzejy.getDefaultRoute().getId());
    }

    @Override // com.google.android.gms.internal.zzavq
    public final String zzaco() {
        return this.zzejy.getSelectedRoute().getId();
    }

    @Override // com.google.android.gms.internal.zzavq
    public final boolean zzb(Bundle bundle, int i) {
        return this.zzejy.isRouteAvailable(MediaRouteSelector.fromBundle(bundle), i);
    }

    @Override // com.google.android.gms.internal.zzavq
    public final void zzfb(String str) {
        for (MediaRouter.RouteInfo routeInfo : this.zzejy.getRoutes()) {
            if (routeInfo.getId().equals(str)) {
                this.zzejy.selectRoute(routeInfo);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzavq
    public final Bundle zzfc(String str) {
        for (MediaRouter.RouteInfo routeInfo : this.zzejy.getRoutes()) {
            if (routeInfo.getId().equals(str)) {
                return routeInfo.getExtras();
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzavq
    public final void zzh(Bundle bundle) {
        for (MediaRouter.Callback callback : this.zzeqm.get(MediaRouteSelector.fromBundle(bundle))) {
            this.zzejy.removeCallback(callback);
        }
    }
}
