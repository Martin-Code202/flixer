package android.support.v7.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ObjectsCompat;
public abstract class MediaRouteProvider {
    private Callback mCallback;
    private final Context mContext;
    private MediaRouteProviderDescriptor mDescriptor;
    private MediaRouteDiscoveryRequest mDiscoveryRequest;
    private final ProviderHandler mHandler = new ProviderHandler();
    private final ProviderMetadata mMetadata;
    private boolean mPendingDescriptorChange;
    private boolean mPendingDiscoveryRequestChange;

    MediaRouteProvider(Context context, ProviderMetadata providerMetadata) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.mContext = context;
        if (providerMetadata == null) {
            this.mMetadata = new ProviderMetadata(new ComponentName(context, getClass()));
        } else {
            this.mMetadata = providerMetadata;
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Handler getHandler() {
        return this.mHandler;
    }

    public final ProviderMetadata getMetadata() {
        return this.mMetadata;
    }

    public final void setCallback(Callback callback) {
        MediaRouter.checkCallingThread();
        this.mCallback = callback;
    }

    public final MediaRouteDiscoveryRequest getDiscoveryRequest() {
        return this.mDiscoveryRequest;
    }

    public final void setDiscoveryRequest(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        MediaRouter.checkCallingThread();
        if (!ObjectsCompat.equals(this.mDiscoveryRequest, mediaRouteDiscoveryRequest)) {
            this.mDiscoveryRequest = mediaRouteDiscoveryRequest;
            if (!this.mPendingDiscoveryRequestChange) {
                this.mPendingDiscoveryRequestChange = true;
                this.mHandler.sendEmptyMessage(2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void deliverDiscoveryRequestChanged() {
        this.mPendingDiscoveryRequestChange = false;
        onDiscoveryRequestChanged(this.mDiscoveryRequest);
    }

    public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
    }

    public final MediaRouteProviderDescriptor getDescriptor() {
        return this.mDescriptor;
    }

    public final void setDescriptor(MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
        MediaRouter.checkCallingThread();
        if (this.mDescriptor != mediaRouteProviderDescriptor) {
            this.mDescriptor = mediaRouteProviderDescriptor;
            if (!this.mPendingDescriptorChange) {
                this.mPendingDescriptorChange = true;
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void deliverDescriptorChanged() {
        this.mPendingDescriptorChange = false;
        if (this.mCallback != null) {
            this.mCallback.onDescriptorChanged(this, this.mDescriptor);
        }
    }

    public RouteController onCreateRouteController(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    public RouteController onCreateRouteController(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        } else if (str2 != null) {
            return onCreateRouteController(str);
        } else {
            throw new IllegalArgumentException("routeGroupId cannot be null");
        }
    }

    public static final class ProviderMetadata {
        private final ComponentName mComponentName;

        ProviderMetadata(ComponentName componentName) {
            if (componentName == null) {
                throw new IllegalArgumentException("componentName must not be null");
            }
            this.mComponentName = componentName;
        }

        public String getPackageName() {
            return this.mComponentName.getPackageName();
        }

        public ComponentName getComponentName() {
            return this.mComponentName;
        }

        public String toString() {
            return "ProviderMetadata{ componentName=" + this.mComponentName.flattenToShortString() + " }";
        }
    }

    public static abstract class RouteController {
        public void onRelease() {
        }

        public void onSelect() {
        }

        public void onUnselect() {
        }

        public void onUnselect(int i) {
            onUnselect();
        }

        public void onSetVolume(int i) {
        }

        public void onUpdateVolume(int i) {
        }
    }

    public static abstract class Callback {
        public void onDescriptorChanged(MediaRouteProvider mediaRouteProvider, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
        }
    }

    final class ProviderHandler extends Handler {
        ProviderHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    MediaRouteProvider.this.deliverDescriptorChanged();
                    return;
                case 2:
                    MediaRouteProvider.this.deliverDiscoveryRequestChanged();
                    return;
                default:
                    return;
            }
        }
    }
}
