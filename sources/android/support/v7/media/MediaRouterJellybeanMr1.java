package android.support.v7.media;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.os.Build;
import android.os.Handler;
import android.support.v7.media.MediaRouterJellybean;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
final class MediaRouterJellybeanMr1 {

    public interface Callback extends MediaRouterJellybean.Callback {
        void onRoutePresentationDisplayChanged(Object obj);
    }

    MediaRouterJellybeanMr1() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static final class RouteInfo {
        public static boolean isEnabled(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isEnabled();
        }

        public static Display getPresentationDisplay(Object obj) {
            try {
                return ((MediaRouter.RouteInfo) obj).getPresentationDisplay();
            } catch (NoSuchMethodError e) {
                Log.w("MediaRouterJellybeanMr1", "Cannot get presentation display for the route.", e);
                return null;
            }
        }
    }

    public static final class ActiveScanWorkaround implements Runnable {
        private boolean mActivelyScanningWifiDisplays;
        private final DisplayManager mDisplayManager;
        private final Handler mHandler;
        private Method mScanWifiDisplaysMethod;

        public ActiveScanWorkaround(Context context, Handler handler) {
            if (Build.VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            this.mDisplayManager = (DisplayManager) context.getSystemService("display");
            this.mHandler = handler;
            try {
                this.mScanWifiDisplaysMethod = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }

        public void setActiveScanRouteTypes(int i) {
            if ((i & 2) != 0) {
                if (this.mActivelyScanningWifiDisplays) {
                    return;
                }
                if (this.mScanWifiDisplaysMethod != null) {
                    this.mActivelyScanningWifiDisplays = true;
                    this.mHandler.post(this);
                    return;
                }
                Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
            } else if (this.mActivelyScanningWifiDisplays) {
                this.mActivelyScanningWifiDisplays = false;
                this.mHandler.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mActivelyScanningWifiDisplays) {
                try {
                    this.mScanWifiDisplaysMethod.invoke(this.mDisplayManager, new Object[0]);
                } catch (IllegalAccessException e) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e);
                } catch (InvocationTargetException e2) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e2);
                }
                this.mHandler.postDelayed(this, 15000);
            }
        }
    }

    public static final class IsConnectingWorkaround {
        private Method mGetStatusCodeMethod;
        private int mStatusConnecting;

        public IsConnectingWorkaround() {
            if (Build.VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.mStatusConnecting = MediaRouter.RouteInfo.class.getField("STATUS_CONNECTING").getInt(null);
                this.mGetStatusCodeMethod = MediaRouter.RouteInfo.class.getMethod("getStatusCode", new Class[0]);
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException e) {
            }
        }

        public boolean isConnecting(Object obj) {
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) obj;
            if (this.mGetStatusCodeMethod == null) {
                return false;
            }
            try {
                return ((Integer) this.mGetStatusCodeMethod.invoke(routeInfo, new Object[0])).intValue() == this.mStatusConnecting;
            } catch (IllegalAccessException | InvocationTargetException e) {
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class CallbackProxy<T extends Callback> extends MediaRouterJellybean.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            ((Callback) this.mCallback).onRoutePresentationDisplayChanged(routeInfo);
        }
    }
}
