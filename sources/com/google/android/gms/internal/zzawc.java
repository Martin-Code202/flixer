package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.v7.media.MediaRouter;
import com.google.android.gms.common.internal.zzbp;
public final class zzawc extends MediaRouter.Callback {
    private static final zzazx zzejc = new zzazx("MediaRouterCallback");
    private final zzavs zzeql;

    public zzawc(zzavs zzavs) {
        this.zzeql = (zzavs) zzbp.zzu(zzavs);
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzeql.zzc(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onRouteAdded", zzavs.class.getSimpleName());
        }
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzeql.zzd(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onRouteChanged", zzavs.class.getSimpleName());
        }
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzeql.zze(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onRouteRemoved", zzavs.class.getSimpleName());
        }
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public final void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzeql.zzf(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onRouteSelected", zzavs.class.getSimpleName());
        }
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public final void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i) {
        try {
            this.zzeql.zza(routeInfo.getId(), routeInfo.getExtras(), i);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onRouteUnselected", zzavs.class.getSimpleName());
        }
    }
}
