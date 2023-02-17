package o;

import android.support.v7.media.MediaRouter;
/* renamed from: o.eU  reason: case insensitive filesystem */
public class C1708eU extends MediaRouter.Callback {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1705eR f6604;

    public C1708eU(AbstractC1705eR eRVar) {
        this.f6604 = eRVar;
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        C1283.m16851("CafRouteManager", "CafRouteManager onRouteSelected - route: %s", routeInfo.getName());
        super.onRouteSelected(mediaRouter, routeInfo);
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i) {
        C1283.m16851("CafRouteManager", "CafRouteManager onRouteUnselected - route: %s", routeInfo.getName());
        super.onRouteUnselected(mediaRouter, routeInfo, i);
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        super.onRouteAdded(mediaRouter, routeInfo);
        String r5 = AU.m3419(routeInfo.getId());
        if (r5 == null) {
            C1283.m16855("CafRouteManager", "CafRouteManager onRouteAdded - couldn't get UUID for route - routeId: %s", routeInfo.getId());
            return;
        }
        String name = routeInfo.getName();
        String r7 = AU.m3418(routeInfo);
        boolean isSelected = routeInfo.isSelected();
        C1283.m16863("CafRouteManager", "CafRouteManager onRouteAdded - friendlyName: %s, uuid: %s, location: %s, isSelected: %b", name, r5, r7, Boolean.valueOf(isSelected));
        this.f6604.mo6252(r5, name, r7, isSelected);
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        super.onRouteRemoved(mediaRouter, routeInfo);
        String r5 = AU.m3419(routeInfo.getId());
        if (r5 == null) {
            C1283.m16855("CafRouteManager", "CafRouteManager onRouteRemoved - couldn't get UUID for route - routeId: %s", routeInfo.getId());
            return;
        }
        C1283.m16863("CafRouteManager", "CafRouteManager onRouteRemoved - name: %s, uuid: %s", routeInfo.getName(), r5);
        this.f6604.mo6253(r5);
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        C1283.m16851("CafRouteManager", "CafRouteManager onRouteChanged - name: %s, uuid: %s", routeInfo.getName(), routeInfo.getId());
        super.onRouteChanged(mediaRouter, routeInfo);
        onRouteAdded(mediaRouter, routeInfo);
    }
}
