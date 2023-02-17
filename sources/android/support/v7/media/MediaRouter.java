package android.support.v7.media;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.util.Pair;
import android.support.v7.media.MediaRouteProvider;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.RegisteredMediaRouteProviderWatcher;
import android.support.v7.media.RemoteControlClientCompat;
import android.support.v7.media.SystemMediaRouteProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public final class MediaRouter {
    static final boolean DEBUG = Log.isLoggable("MediaRouter", 3);
    static GlobalMediaRouter sGlobal;
    final ArrayList<CallbackRecord> mCallbackRecords;
    final Context mContext;

    private MediaRouter(Context context) {
        this.mCallbackRecords = new ArrayList<>();
        this.mContext = context;
    }

    public static MediaRouter getInstance(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        checkCallingThread();
        if (sGlobal == null) {
            sGlobal = new GlobalMediaRouter(context.getApplicationContext());
            sGlobal.start();
        }
        return sGlobal.getRouter(context);
    }

    public List<RouteInfo> getRoutes() {
        checkCallingThread();
        return sGlobal.getRoutes();
    }

    public RouteInfo getDefaultRoute() {
        checkCallingThread();
        return sGlobal.getDefaultRoute();
    }

    public RouteInfo getSelectedRoute() {
        checkCallingThread();
        return sGlobal.getSelectedRoute();
    }

    public void selectRoute(RouteInfo routeInfo) {
        if (routeInfo == null) {
            throw new IllegalArgumentException("route must not be null");
        }
        checkCallingThread();
        if (DEBUG) {
            Log.d("MediaRouter", "selectRoute: " + routeInfo);
        }
        sGlobal.selectRoute(routeInfo);
    }

    public boolean isRouteAvailable(MediaRouteSelector mediaRouteSelector, int i) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        checkCallingThread();
        return sGlobal.isRouteAvailable(mediaRouteSelector, i);
    }

    public void addCallback(MediaRouteSelector mediaRouteSelector, Callback callback, int i) {
        CallbackRecord callbackRecord;
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else {
            checkCallingThread();
            if (DEBUG) {
                Log.d("MediaRouter", "addCallback: selector=" + mediaRouteSelector + ", callback=" + callback + ", flags=" + Integer.toHexString(i));
            }
            int findCallbackRecord = findCallbackRecord(callback);
            if (findCallbackRecord < 0) {
                callbackRecord = new CallbackRecord(this, callback);
                this.mCallbackRecords.add(callbackRecord);
            } else {
                callbackRecord = this.mCallbackRecords.get(findCallbackRecord);
            }
            boolean z = false;
            if (((callbackRecord.mFlags ^ -1) & i) != 0) {
                callbackRecord.mFlags |= i;
                z = true;
            }
            if (!callbackRecord.mSelector.contains(mediaRouteSelector)) {
                callbackRecord.mSelector = new MediaRouteSelector.Builder(callbackRecord.mSelector).addSelector(mediaRouteSelector).build();
                z = true;
            }
            if (z) {
                sGlobal.updateDiscoveryRequest();
            }
        }
    }

    public void removeCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        checkCallingThread();
        if (DEBUG) {
            Log.d("MediaRouter", "removeCallback: callback=" + callback);
        }
        int findCallbackRecord = findCallbackRecord(callback);
        if (findCallbackRecord >= 0) {
            this.mCallbackRecords.remove(findCallbackRecord);
            sGlobal.updateDiscoveryRequest();
        }
    }

    private int findCallbackRecord(Callback callback) {
        int size = this.mCallbackRecords.size();
        for (int i = 0; i < size; i++) {
            if (this.mCallbackRecords.get(i).mCallback == callback) {
                return i;
            }
        }
        return -1;
    }

    public void setMediaSessionCompat(MediaSessionCompat mediaSessionCompat) {
        if (DEBUG) {
            Log.d("MediaRouter", "addMediaSessionCompat: " + mediaSessionCompat);
        }
        sGlobal.setMediaSessionCompat(mediaSessionCompat);
    }

    static void checkCallingThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    static <T> boolean equal(T t, T t2) {
        return t == t2 || !(t == null || t2 == null || !t.equals(t2));
    }

    public static class RouteInfo {
        private boolean mCanDisconnect;
        private boolean mConnecting;
        private int mConnectionState;
        private final ArrayList<IntentFilter> mControlFilters = new ArrayList<>();
        private String mDescription;
        MediaRouteDescriptor mDescriptor;
        private final String mDescriptorId;
        private int mDeviceType;
        private boolean mEnabled;
        private Bundle mExtras;
        private Uri mIconUri;
        private String mName;
        private int mPlaybackStream;
        private int mPlaybackType;
        private Display mPresentationDisplay;
        private int mPresentationDisplayId = -1;
        private final ProviderInfo mProvider;
        private IntentSender mSettingsIntent;
        private final String mUniqueId;
        private int mVolume;
        private int mVolumeHandling;
        private int mVolumeMax;

        RouteInfo(ProviderInfo providerInfo, String str, String str2) {
            this.mProvider = providerInfo;
            this.mDescriptorId = str;
            this.mUniqueId = str2;
        }

        public ProviderInfo getProvider() {
            return this.mProvider;
        }

        public String getId() {
            return this.mUniqueId;
        }

        public String getName() {
            return this.mName;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public boolean isSelected() {
            MediaRouter.checkCallingThread();
            return MediaRouter.sGlobal.getSelectedRoute() == this;
        }

        public boolean isDefault() {
            MediaRouter.checkCallingThread();
            return MediaRouter.sGlobal.getDefaultRoute() == this;
        }

        public boolean matchesSelector(MediaRouteSelector mediaRouteSelector) {
            if (mediaRouteSelector == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            MediaRouter.checkCallingThread();
            return mediaRouteSelector.matchesControlFilters(this.mControlFilters);
        }

        public boolean supportsControlCategory(String str) {
            if (str == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            MediaRouter.checkCallingThread();
            int size = this.mControlFilters.size();
            for (int i = 0; i < size; i++) {
                if (this.mControlFilters.get(i).hasCategory(str)) {
                    return true;
                }
            }
            return false;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getPlaybackStream() {
            return this.mPlaybackStream;
        }

        public boolean isDefaultOrBluetooth() {
            if (isDefault() || this.mDeviceType == 3) {
                return true;
            }
            return isSystemMediaRouteProvider(this) && supportsControlCategory("android.media.intent.category.LIVE_AUDIO") && !supportsControlCategory("android.media.intent.category.LIVE_VIDEO");
        }

        /* access modifiers changed from: package-private */
        public boolean isSelectable() {
            return this.mDescriptor != null && this.mEnabled;
        }

        private static boolean isSystemMediaRouteProvider(RouteInfo routeInfo) {
            return TextUtils.equals(routeInfo.getProviderInstance().getMetadata().getPackageName(), "android");
        }

        public int getVolumeHandling() {
            return this.mVolumeHandling;
        }

        public int getVolume() {
            return this.mVolume;
        }

        public int getVolumeMax() {
            return this.mVolumeMax;
        }

        public void requestSetVolume(int i) {
            MediaRouter.checkCallingThread();
            MediaRouter.sGlobal.requestSetVolume(this, Math.min(this.mVolumeMax, Math.max(0, i)));
        }

        public void requestUpdateVolume(int i) {
            MediaRouter.checkCallingThread();
            if (i != 0) {
                MediaRouter.sGlobal.requestUpdateVolume(this, i);
            }
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public void select() {
            MediaRouter.checkCallingThread();
            MediaRouter.sGlobal.selectRoute(this);
        }

        public String toString() {
            return "MediaRouter.RouteInfo{ uniqueId=" + this.mUniqueId + ", name=" + this.mName + ", description=" + this.mDescription + ", iconUri=" + this.mIconUri + ", enabled=" + this.mEnabled + ", connecting=" + this.mConnecting + ", connectionState=" + this.mConnectionState + ", canDisconnect=" + this.mCanDisconnect + ", playbackType=" + this.mPlaybackType + ", playbackStream=" + this.mPlaybackStream + ", deviceType=" + this.mDeviceType + ", volumeHandling=" + this.mVolumeHandling + ", volume=" + this.mVolume + ", volumeMax=" + this.mVolumeMax + ", presentationDisplayId=" + this.mPresentationDisplayId + ", extras=" + this.mExtras + ", settingsIntent=" + this.mSettingsIntent + ", providerPackageName=" + this.mProvider.getPackageName() + " }";
        }

        /* access modifiers changed from: package-private */
        public int maybeUpdateDescriptor(MediaRouteDescriptor mediaRouteDescriptor) {
            if (this.mDescriptor != mediaRouteDescriptor) {
                return updateDescriptor(mediaRouteDescriptor);
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int updateDescriptor(MediaRouteDescriptor mediaRouteDescriptor) {
            int i = 0;
            this.mDescriptor = mediaRouteDescriptor;
            if (mediaRouteDescriptor == null) {
                return 0;
            }
            if (!MediaRouter.equal(this.mName, mediaRouteDescriptor.getName())) {
                this.mName = mediaRouteDescriptor.getName();
                i = 1;
            }
            if (!MediaRouter.equal(this.mDescription, mediaRouteDescriptor.getDescription())) {
                this.mDescription = mediaRouteDescriptor.getDescription();
                i = 1;
            }
            if (!MediaRouter.equal(this.mIconUri, mediaRouteDescriptor.getIconUri())) {
                this.mIconUri = mediaRouteDescriptor.getIconUri();
                i = 1;
            }
            if (this.mEnabled != mediaRouteDescriptor.isEnabled()) {
                this.mEnabled = mediaRouteDescriptor.isEnabled();
                i |= 1;
            }
            if (this.mConnecting != mediaRouteDescriptor.isConnecting()) {
                this.mConnecting = mediaRouteDescriptor.isConnecting();
                i |= 1;
            }
            if (this.mConnectionState != mediaRouteDescriptor.getConnectionState()) {
                this.mConnectionState = mediaRouteDescriptor.getConnectionState();
                i |= 1;
            }
            if (!this.mControlFilters.equals(mediaRouteDescriptor.getControlFilters())) {
                this.mControlFilters.clear();
                this.mControlFilters.addAll(mediaRouteDescriptor.getControlFilters());
                i |= 1;
            }
            if (this.mPlaybackType != mediaRouteDescriptor.getPlaybackType()) {
                this.mPlaybackType = mediaRouteDescriptor.getPlaybackType();
                i |= 1;
            }
            if (this.mPlaybackStream != mediaRouteDescriptor.getPlaybackStream()) {
                this.mPlaybackStream = mediaRouteDescriptor.getPlaybackStream();
                i |= 1;
            }
            if (this.mDeviceType != mediaRouteDescriptor.getDeviceType()) {
                this.mDeviceType = mediaRouteDescriptor.getDeviceType();
                i |= 1;
            }
            if (this.mVolumeHandling != mediaRouteDescriptor.getVolumeHandling()) {
                this.mVolumeHandling = mediaRouteDescriptor.getVolumeHandling();
                i |= 3;
            }
            if (this.mVolume != mediaRouteDescriptor.getVolume()) {
                this.mVolume = mediaRouteDescriptor.getVolume();
                i |= 3;
            }
            if (this.mVolumeMax != mediaRouteDescriptor.getVolumeMax()) {
                this.mVolumeMax = mediaRouteDescriptor.getVolumeMax();
                i |= 3;
            }
            if (this.mPresentationDisplayId != mediaRouteDescriptor.getPresentationDisplayId()) {
                this.mPresentationDisplayId = mediaRouteDescriptor.getPresentationDisplayId();
                this.mPresentationDisplay = null;
                i |= 5;
            }
            if (!MediaRouter.equal(this.mExtras, mediaRouteDescriptor.getExtras())) {
                this.mExtras = mediaRouteDescriptor.getExtras();
                i |= 1;
            }
            if (!MediaRouter.equal(this.mSettingsIntent, mediaRouteDescriptor.getSettingsActivity())) {
                this.mSettingsIntent = mediaRouteDescriptor.getSettingsActivity();
                i |= 1;
            }
            if (this.mCanDisconnect == mediaRouteDescriptor.canDisconnectAndKeepPlaying()) {
                return i;
            }
            this.mCanDisconnect = mediaRouteDescriptor.canDisconnectAndKeepPlaying();
            return i | 5;
        }

        /* access modifiers changed from: package-private */
        public String getDescriptorId() {
            return this.mDescriptorId;
        }

        public MediaRouteProvider getProviderInstance() {
            return this.mProvider.getProviderInstance();
        }
    }

    public static class RouteGroup extends RouteInfo {
        private List<RouteInfo> mRoutes = new ArrayList();

        RouteGroup(ProviderInfo providerInfo, String str, String str2) {
            super(providerInfo, str, str2);
        }

        public List<RouteInfo> getRoutes() {
            return this.mRoutes;
        }

        @Override // android.support.v7.media.MediaRouter.RouteInfo
        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString());
            sb.append('[');
            int size = this.mRoutes.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(this.mRoutes.get(i));
            }
            sb.append(']');
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.media.MediaRouter.RouteInfo
        public int maybeUpdateDescriptor(MediaRouteDescriptor mediaRouteDescriptor) {
            boolean z = false;
            if (this.mDescriptor != mediaRouteDescriptor) {
                this.mDescriptor = mediaRouteDescriptor;
                if (mediaRouteDescriptor != null) {
                    List<String> groupMemberIds = mediaRouteDescriptor.getGroupMemberIds();
                    ArrayList arrayList = new ArrayList();
                    z = groupMemberIds.size() != this.mRoutes.size();
                    for (String str : groupMemberIds) {
                        RouteInfo route = MediaRouter.sGlobal.getRoute(MediaRouter.sGlobal.getUniqueId(getProvider(), str));
                        if (route != null) {
                            arrayList.add(route);
                            if (!z && !this.mRoutes.contains(route)) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        this.mRoutes = arrayList;
                    }
                }
            }
            return (z ? 1 : 0) | super.updateDescriptor(mediaRouteDescriptor);
        }
    }

    public static final class ProviderInfo {
        private MediaRouteProviderDescriptor mDescriptor;
        private final MediaRouteProvider.ProviderMetadata mMetadata;
        private final MediaRouteProvider mProviderInstance;
        private final List<RouteInfo> mRoutes = new ArrayList();

        ProviderInfo(MediaRouteProvider mediaRouteProvider) {
            this.mProviderInstance = mediaRouteProvider;
            this.mMetadata = mediaRouteProvider.getMetadata();
        }

        public MediaRouteProvider getProviderInstance() {
            MediaRouter.checkCallingThread();
            return this.mProviderInstance;
        }

        public String getPackageName() {
            return this.mMetadata.getPackageName();
        }

        public ComponentName getComponentName() {
            return this.mMetadata.getComponentName();
        }

        /* access modifiers changed from: package-private */
        public boolean updateDescriptor(MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
            if (this.mDescriptor == mediaRouteProviderDescriptor) {
                return false;
            }
            this.mDescriptor = mediaRouteProviderDescriptor;
            return true;
        }

        /* access modifiers changed from: package-private */
        public int findRouteByDescriptorId(String str) {
            int size = this.mRoutes.size();
            for (int i = 0; i < size; i++) {
                if (this.mRoutes.get(i).mDescriptorId.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        public String toString() {
            return "MediaRouter.RouteProviderInfo{ packageName=" + getPackageName() + " }";
        }
    }

    public static abstract class Callback {
        public void onRouteSelected(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteUnselected(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteUnselected(MediaRouter mediaRouter, RouteInfo routeInfo, int i) {
            onRouteUnselected(mediaRouter, routeInfo);
        }

        public void onRouteAdded(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteRemoved(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onProviderAdded(MediaRouter mediaRouter, ProviderInfo providerInfo) {
        }

        public void onProviderRemoved(MediaRouter mediaRouter, ProviderInfo providerInfo) {
        }

        public void onProviderChanged(MediaRouter mediaRouter, ProviderInfo providerInfo) {
        }
    }

    public static abstract class ControlRequestCallback {
        public void onResult(Bundle bundle) {
        }

        public void onError(String str, Bundle bundle) {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class CallbackRecord {
        public final Callback mCallback;
        public int mFlags;
        public final MediaRouter mRouter;
        public MediaRouteSelector mSelector = MediaRouteSelector.EMPTY;

        public CallbackRecord(MediaRouter mediaRouter, Callback callback) {
            this.mRouter = mediaRouter;
            this.mCallback = callback;
        }

        public boolean filterRouteEvent(RouteInfo routeInfo) {
            return (this.mFlags & 2) != 0 || routeInfo.matchesSelector(this.mSelector);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class GlobalMediaRouter implements SystemMediaRouteProvider.SyncCallback, RegisteredMediaRouteProviderWatcher.Callback {
        final Context mApplicationContext;
        private RouteInfo mBluetoothRoute;
        final CallbackHandler mCallbackHandler = new CallbackHandler();
        private MediaSessionCompat mCompatSession;
        private RouteInfo mDefaultRoute;
        private MediaRouteDiscoveryRequest mDiscoveryRequest;
        private final DisplayManagerCompat mDisplayManager;
        private final boolean mLowRam;
        private MediaSessionRecord mMediaSession;
        final RemoteControlClientCompat.PlaybackInfo mPlaybackInfo = new RemoteControlClientCompat.PlaybackInfo();
        private final ProviderCallback mProviderCallback = new ProviderCallback();
        private final ArrayList<ProviderInfo> mProviders = new ArrayList<>();
        MediaSessionCompat mRccMediaSession;
        private RegisteredMediaRouteProviderWatcher mRegisteredProviderWatcher;
        private final ArrayList<RemoteControlClientRecord> mRemoteControlClients = new ArrayList<>();
        private final Map<String, MediaRouteProvider.RouteController> mRouteControllerMap = new HashMap();
        final ArrayList<WeakReference<MediaRouter>> mRouters = new ArrayList<>();
        private final ArrayList<RouteInfo> mRoutes = new ArrayList<>();
        RouteInfo mSelectedRoute;
        private MediaRouteProvider.RouteController mSelectedRouteController;
        private MediaSessionCompat.OnActiveChangeListener mSessionActiveListener = new MediaSessionCompat.OnActiveChangeListener() { // from class: android.support.v7.media.MediaRouter.GlobalMediaRouter.1
            @Override // android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener
            public void onActiveChanged() {
                if (GlobalMediaRouter.this.mRccMediaSession == null) {
                    return;
                }
                if (GlobalMediaRouter.this.mRccMediaSession.isActive()) {
                    GlobalMediaRouter.this.addRemoteControlClient(GlobalMediaRouter.this.mRccMediaSession.getRemoteControlClient());
                } else {
                    GlobalMediaRouter.this.removeRemoteControlClient(GlobalMediaRouter.this.mRccMediaSession.getRemoteControlClient());
                }
            }
        };
        final SystemMediaRouteProvider mSystemProvider;
        private final Map<Pair<String, String>, String> mUniqueIdMap = new HashMap();

        GlobalMediaRouter(Context context) {
            this.mApplicationContext = context;
            this.mDisplayManager = DisplayManagerCompat.getInstance(context);
            this.mLowRam = ActivityManagerCompat.isLowRamDevice((ActivityManager) context.getSystemService("activity"));
            this.mSystemProvider = SystemMediaRouteProvider.obtain(context, this);
        }

        public void start() {
            addProvider(this.mSystemProvider);
            this.mRegisteredProviderWatcher = new RegisteredMediaRouteProviderWatcher(this.mApplicationContext, this);
            this.mRegisteredProviderWatcher.start();
        }

        public MediaRouter getRouter(Context context) {
            int size = this.mRouters.size();
            while (true) {
                size--;
                if (size >= 0) {
                    MediaRouter mediaRouter = this.mRouters.get(size).get();
                    if (mediaRouter == null) {
                        this.mRouters.remove(size);
                    } else if (mediaRouter.mContext == context) {
                        return mediaRouter;
                    }
                } else {
                    MediaRouter mediaRouter2 = new MediaRouter(context);
                    this.mRouters.add(new WeakReference<>(mediaRouter2));
                    return mediaRouter2;
                }
            }
        }

        public void requestSetVolume(RouteInfo routeInfo, int i) {
            MediaRouteProvider.RouteController routeController;
            if (routeInfo == this.mSelectedRoute && this.mSelectedRouteController != null) {
                this.mSelectedRouteController.onSetVolume(i);
            } else if (!this.mRouteControllerMap.isEmpty() && (routeController = this.mRouteControllerMap.get(routeInfo.mDescriptorId)) != null) {
                routeController.onSetVolume(i);
            }
        }

        public void requestUpdateVolume(RouteInfo routeInfo, int i) {
            if (routeInfo == this.mSelectedRoute && this.mSelectedRouteController != null) {
                this.mSelectedRouteController.onUpdateVolume(i);
            }
        }

        public RouteInfo getRoute(String str) {
            Iterator<RouteInfo> it = this.mRoutes.iterator();
            while (it.hasNext()) {
                RouteInfo next = it.next();
                if (next.mUniqueId.equals(str)) {
                    return next;
                }
            }
            return null;
        }

        public List<RouteInfo> getRoutes() {
            return this.mRoutes;
        }

        /* access modifiers changed from: package-private */
        public RouteInfo getDefaultRoute() {
            if (this.mDefaultRoute != null) {
                return this.mDefaultRoute;
            }
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }

        /* access modifiers changed from: package-private */
        public RouteInfo getBluetoothRoute() {
            return this.mBluetoothRoute;
        }

        /* access modifiers changed from: package-private */
        public RouteInfo getSelectedRoute() {
            if (this.mSelectedRoute != null) {
                return this.mSelectedRoute;
            }
            throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
        }

        /* access modifiers changed from: package-private */
        public void selectRoute(RouteInfo routeInfo) {
            selectRoute(routeInfo, 3);
        }

        /* access modifiers changed from: package-private */
        public void selectRoute(RouteInfo routeInfo, int i) {
            if (!this.mRoutes.contains(routeInfo)) {
                Log.w("MediaRouter", "Ignoring attempt to select removed route: " + routeInfo);
            } else if (!routeInfo.mEnabled) {
                Log.w("MediaRouter", "Ignoring attempt to select disabled route: " + routeInfo);
            } else {
                setSelectedRouteInternal(routeInfo, i);
            }
        }

        public boolean isRouteAvailable(MediaRouteSelector mediaRouteSelector, int i) {
            if (mediaRouteSelector.isEmpty()) {
                return false;
            }
            if ((i & 2) == 0 && this.mLowRam) {
                return true;
            }
            int size = this.mRoutes.size();
            for (int i2 = 0; i2 < size; i2++) {
                RouteInfo routeInfo = this.mRoutes.get(i2);
                if (((i & 1) == 0 || !routeInfo.isDefaultOrBluetooth()) && routeInfo.matchesSelector(mediaRouteSelector)) {
                    return true;
                }
            }
            return false;
        }

        public void updateDiscoveryRequest() {
            boolean z = false;
            boolean z2 = false;
            MediaRouteSelector.Builder builder = new MediaRouteSelector.Builder();
            int size = this.mRouters.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                MediaRouter mediaRouter = this.mRouters.get(size).get();
                if (mediaRouter == null) {
                    this.mRouters.remove(size);
                } else {
                    int size2 = mediaRouter.mCallbackRecords.size();
                    for (int i = 0; i < size2; i++) {
                        CallbackRecord callbackRecord = mediaRouter.mCallbackRecords.get(i);
                        builder.addSelector(callbackRecord.mSelector);
                        if ((callbackRecord.mFlags & 1) != 0) {
                            z2 = true;
                            z = true;
                        }
                        if ((callbackRecord.mFlags & 4) != 0 && !this.mLowRam) {
                            z = true;
                        }
                        if ((callbackRecord.mFlags & 8) != 0) {
                            z = true;
                        }
                    }
                }
            }
            MediaRouteSelector build = z ? builder.build() : MediaRouteSelector.EMPTY;
            if (this.mDiscoveryRequest == null || !this.mDiscoveryRequest.getSelector().equals(build) || this.mDiscoveryRequest.isActiveScan() != z2) {
                if (!build.isEmpty() || z2) {
                    this.mDiscoveryRequest = new MediaRouteDiscoveryRequest(build, z2);
                } else if (this.mDiscoveryRequest != null) {
                    this.mDiscoveryRequest = null;
                } else {
                    return;
                }
                if (MediaRouter.DEBUG) {
                    Log.d("MediaRouter", "Updated discovery request: " + this.mDiscoveryRequest);
                }
                if (z && !z2 && this.mLowRam) {
                    Log.i("MediaRouter", "Forcing passive route discovery on a low-RAM device, system performance may be affected.  Please consider using CALLBACK_FLAG_REQUEST_DISCOVERY instead of CALLBACK_FLAG_FORCE_DISCOVERY.");
                }
                int size3 = this.mProviders.size();
                for (int i2 = 0; i2 < size3; i2++) {
                    this.mProviders.get(i2).mProviderInstance.setDiscoveryRequest(this.mDiscoveryRequest);
                }
            }
        }

        @Override // android.support.v7.media.RegisteredMediaRouteProviderWatcher.Callback
        public void addProvider(MediaRouteProvider mediaRouteProvider) {
            if (findProviderInfo(mediaRouteProvider) < 0) {
                ProviderInfo providerInfo = new ProviderInfo(mediaRouteProvider);
                this.mProviders.add(providerInfo);
                if (MediaRouter.DEBUG) {
                    Log.d("MediaRouter", "Provider added: " + providerInfo);
                }
                this.mCallbackHandler.post(513, providerInfo);
                updateProviderContents(providerInfo, mediaRouteProvider.getDescriptor());
                mediaRouteProvider.setCallback(this.mProviderCallback);
                mediaRouteProvider.setDiscoveryRequest(this.mDiscoveryRequest);
            }
        }

        @Override // android.support.v7.media.RegisteredMediaRouteProviderWatcher.Callback
        public void removeProvider(MediaRouteProvider mediaRouteProvider) {
            int findProviderInfo = findProviderInfo(mediaRouteProvider);
            if (findProviderInfo >= 0) {
                mediaRouteProvider.setCallback(null);
                mediaRouteProvider.setDiscoveryRequest(null);
                ProviderInfo providerInfo = this.mProviders.get(findProviderInfo);
                updateProviderContents(providerInfo, null);
                if (MediaRouter.DEBUG) {
                    Log.d("MediaRouter", "Provider removed: " + providerInfo);
                }
                this.mCallbackHandler.post(514, providerInfo);
                this.mProviders.remove(findProviderInfo);
            }
        }

        /* access modifiers changed from: package-private */
        public void updateProviderDescriptor(MediaRouteProvider mediaRouteProvider, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
            int findProviderInfo = findProviderInfo(mediaRouteProvider);
            if (findProviderInfo >= 0) {
                updateProviderContents(this.mProviders.get(findProviderInfo), mediaRouteProviderDescriptor);
            }
        }

        private int findProviderInfo(MediaRouteProvider mediaRouteProvider) {
            int size = this.mProviders.size();
            for (int i = 0; i < size; i++) {
                if (this.mProviders.get(i).mProviderInstance == mediaRouteProvider) {
                    return i;
                }
            }
            return -1;
        }

        private void updateProviderContents(ProviderInfo providerInfo, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
            if (providerInfo.updateDescriptor(mediaRouteProviderDescriptor)) {
                int i = 0;
                boolean z = false;
                if (mediaRouteProviderDescriptor != null) {
                    if (mediaRouteProviderDescriptor.isValid()) {
                        List<MediaRouteDescriptor> routes = mediaRouteProviderDescriptor.getRoutes();
                        int size = routes.size();
                        ArrayList<Pair> arrayList = new ArrayList();
                        ArrayList<Pair> arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < size; i2++) {
                            MediaRouteDescriptor mediaRouteDescriptor = routes.get(i2);
                            String id = mediaRouteDescriptor.getId();
                            int findRouteByDescriptorId = providerInfo.findRouteByDescriptorId(id);
                            if (findRouteByDescriptorId < 0) {
                                String assignRouteUniqueId = assignRouteUniqueId(providerInfo, id);
                                boolean z2 = mediaRouteDescriptor.getGroupMemberIds() != null;
                                RouteInfo routeGroup = z2 ? new RouteGroup(providerInfo, id, assignRouteUniqueId) : new RouteInfo(providerInfo, id, assignRouteUniqueId);
                                i++;
                                providerInfo.mRoutes.add(i, routeGroup);
                                this.mRoutes.add(routeGroup);
                                if (z2) {
                                    arrayList.add(new Pair(routeGroup, mediaRouteDescriptor));
                                } else {
                                    routeGroup.maybeUpdateDescriptor(mediaRouteDescriptor);
                                    if (MediaRouter.DEBUG) {
                                        Log.d("MediaRouter", "Route added: " + routeGroup);
                                    }
                                    this.mCallbackHandler.post(257, routeGroup);
                                }
                            } else if (findRouteByDescriptorId < i) {
                                Log.w("MediaRouter", "Ignoring route descriptor with duplicate id: " + mediaRouteDescriptor);
                            } else {
                                RouteInfo routeInfo = (RouteInfo) providerInfo.mRoutes.get(findRouteByDescriptorId);
                                i++;
                                Collections.swap(providerInfo.mRoutes, findRouteByDescriptorId, i);
                                if (routeInfo instanceof RouteGroup) {
                                    arrayList2.add(new Pair(routeInfo, mediaRouteDescriptor));
                                } else if (updateRouteDescriptorAndNotify(routeInfo, mediaRouteDescriptor) != 0 && routeInfo == this.mSelectedRoute) {
                                    z = true;
                                }
                            }
                        }
                        for (Pair pair : arrayList) {
                            F f = pair.first;
                            f.maybeUpdateDescriptor(pair.second);
                            if (MediaRouter.DEBUG) {
                                Log.d("MediaRouter", "Route added: " + ((Object) f));
                            }
                            this.mCallbackHandler.post(257, f);
                        }
                        for (Pair pair2 : arrayList2) {
                            F f2 = pair2.first;
                            if (updateRouteDescriptorAndNotify(f2, pair2.second) != 0 && f2 == this.mSelectedRoute) {
                                z = true;
                            }
                        }
                    } else {
                        Log.w("MediaRouter", "Ignoring invalid provider descriptor: " + mediaRouteProviderDescriptor);
                    }
                }
                for (int size2 = providerInfo.mRoutes.size() - 1; size2 >= i; size2--) {
                    RouteInfo routeInfo2 = (RouteInfo) providerInfo.mRoutes.get(size2);
                    routeInfo2.maybeUpdateDescriptor(null);
                    this.mRoutes.remove(routeInfo2);
                }
                updateSelectedRouteIfNeeded(z);
                for (int size3 = providerInfo.mRoutes.size() - 1; size3 >= i; size3--) {
                    RouteInfo routeInfo3 = (RouteInfo) providerInfo.mRoutes.remove(size3);
                    if (MediaRouter.DEBUG) {
                        Log.d("MediaRouter", "Route removed: " + routeInfo3);
                    }
                    this.mCallbackHandler.post(258, routeInfo3);
                }
                if (MediaRouter.DEBUG) {
                    Log.d("MediaRouter", "Provider changed: " + providerInfo);
                }
                this.mCallbackHandler.post(515, providerInfo);
            }
        }

        private int updateRouteDescriptorAndNotify(RouteInfo routeInfo, MediaRouteDescriptor mediaRouteDescriptor) {
            int maybeUpdateDescriptor = routeInfo.maybeUpdateDescriptor(mediaRouteDescriptor);
            if (maybeUpdateDescriptor != 0) {
                if ((maybeUpdateDescriptor & 1) != 0) {
                    if (MediaRouter.DEBUG) {
                        Log.d("MediaRouter", "Route changed: " + routeInfo);
                    }
                    this.mCallbackHandler.post(259, routeInfo);
                }
                if ((maybeUpdateDescriptor & 2) != 0) {
                    if (MediaRouter.DEBUG) {
                        Log.d("MediaRouter", "Route volume changed: " + routeInfo);
                    }
                    this.mCallbackHandler.post(260, routeInfo);
                }
                if ((maybeUpdateDescriptor & 4) != 0) {
                    if (MediaRouter.DEBUG) {
                        Log.d("MediaRouter", "Route presentation display changed: " + routeInfo);
                    }
                    this.mCallbackHandler.post(261, routeInfo);
                }
            }
            return maybeUpdateDescriptor;
        }

        private String assignRouteUniqueId(ProviderInfo providerInfo, String str) {
            String flattenToShortString = providerInfo.getComponentName().flattenToShortString();
            String str2 = flattenToShortString + ":" + str;
            if (findRouteByUniqueId(str2) < 0) {
                this.mUniqueIdMap.put(new Pair<>(flattenToShortString, str), str2);
                return str2;
            }
            Log.w("MediaRouter", "Either " + str + " isn't unique in " + flattenToShortString + " or we're trying to assign a unique ID for an already added route");
            int i = 2;
            while (true) {
                String format = String.format(Locale.US, "%s_%d", str2, Integer.valueOf(i));
                if (findRouteByUniqueId(format) < 0) {
                    this.mUniqueIdMap.put(new Pair<>(flattenToShortString, str), format);
                    return format;
                }
                i++;
            }
        }

        private int findRouteByUniqueId(String str) {
            int size = this.mRoutes.size();
            for (int i = 0; i < size; i++) {
                if (this.mRoutes.get(i).mUniqueId.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String getUniqueId(ProviderInfo providerInfo, String str) {
            return this.mUniqueIdMap.get(new Pair(providerInfo.getComponentName().flattenToShortString(), str));
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void updateSelectedRouteIfNeeded(boolean z) {
            if (this.mDefaultRoute != null && !this.mDefaultRoute.isSelectable()) {
                Log.i("MediaRouter", "Clearing the default route because it is no longer selectable: " + this.mDefaultRoute);
                this.mDefaultRoute = null;
            }
            if (this.mDefaultRoute == null && !this.mRoutes.isEmpty()) {
                Iterator<RouteInfo> it = this.mRoutes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RouteInfo next = it.next();
                    if (isSystemDefaultRoute(next) && next.isSelectable()) {
                        this.mDefaultRoute = next;
                        Log.i("MediaRouter", "Found default route: " + this.mDefaultRoute);
                        break;
                    }
                }
            }
            if (this.mBluetoothRoute != null && !this.mBluetoothRoute.isSelectable()) {
                Log.i("MediaRouter", "Clearing the bluetooth route because it is no longer selectable: " + this.mBluetoothRoute);
                this.mBluetoothRoute = null;
            }
            if (this.mBluetoothRoute == null && !this.mRoutes.isEmpty()) {
                Iterator<RouteInfo> it2 = this.mRoutes.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    RouteInfo next2 = it2.next();
                    if (isSystemLiveAudioOnlyRoute(next2) && next2.isSelectable()) {
                        this.mBluetoothRoute = next2;
                        Log.i("MediaRouter", "Found bluetooth route: " + this.mBluetoothRoute);
                        break;
                    }
                }
            }
            if (this.mSelectedRoute == null || !this.mSelectedRoute.isSelectable()) {
                Log.i("MediaRouter", "Unselecting the current route because it is no longer selectable: " + this.mSelectedRoute);
                setSelectedRouteInternal(chooseFallbackRoute(), 0);
            } else if (z) {
                if (this.mSelectedRoute instanceof RouteGroup) {
                    List<RouteInfo> routes = ((RouteGroup) this.mSelectedRoute).getRoutes();
                    HashSet hashSet = new HashSet();
                    for (RouteInfo routeInfo : routes) {
                        hashSet.add(routeInfo.mDescriptorId);
                    }
                    Iterator<Map.Entry<String, MediaRouteProvider.RouteController>> it3 = this.mRouteControllerMap.entrySet().iterator();
                    while (it3.hasNext()) {
                        Map.Entry<String, MediaRouteProvider.RouteController> next3 = it3.next();
                        if (!hashSet.contains(next3.getKey())) {
                            MediaRouteProvider.RouteController value = next3.getValue();
                            value.onUnselect();
                            value.onRelease();
                            it3.remove();
                        }
                    }
                    for (RouteInfo routeInfo2 : routes) {
                        if (!this.mRouteControllerMap.containsKey(routeInfo2.mDescriptorId)) {
                            MediaRouteProvider.RouteController onCreateRouteController = routeInfo2.getProviderInstance().onCreateRouteController(routeInfo2.mDescriptorId, this.mSelectedRoute.mDescriptorId);
                            onCreateRouteController.onSelect();
                            this.mRouteControllerMap.put(routeInfo2.mDescriptorId, onCreateRouteController);
                        }
                    }
                }
                updatePlaybackInfoFromSelectedRoute();
            }
        }

        /* access modifiers changed from: package-private */
        public RouteInfo chooseFallbackRoute() {
            Iterator<RouteInfo> it = this.mRoutes.iterator();
            while (it.hasNext()) {
                RouteInfo next = it.next();
                if (next != this.mDefaultRoute && isSystemLiveAudioOnlyRoute(next) && next.isSelectable()) {
                    return next;
                }
            }
            return this.mDefaultRoute;
        }

        private boolean isSystemLiveAudioOnlyRoute(RouteInfo routeInfo) {
            return routeInfo.getProviderInstance() == this.mSystemProvider && routeInfo.supportsControlCategory("android.media.intent.category.LIVE_AUDIO") && !routeInfo.supportsControlCategory("android.media.intent.category.LIVE_VIDEO");
        }

        private boolean isSystemDefaultRoute(RouteInfo routeInfo) {
            return routeInfo.getProviderInstance() == this.mSystemProvider && routeInfo.mDescriptorId.equals("DEFAULT_ROUTE");
        }

        private void setSelectedRouteInternal(RouteInfo routeInfo, int i) {
            if (MediaRouter.sGlobal == null || (this.mBluetoothRoute != null && routeInfo.isDefault())) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb = new StringBuilder();
                for (int i2 = 3; i2 < stackTrace.length; i2++) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    sb.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append(":").append(stackTraceElement.getLineNumber()).append("  ");
                }
                if (MediaRouter.sGlobal == null) {
                    Log.w("MediaRouter", "setSelectedRouteInternal is called while sGlobal is null: pkgName=" + this.mApplicationContext.getPackageName() + ", callers=" + sb.toString());
                } else {
                    Log.w("MediaRouter", "Default route is selected while a BT route is available: pkgName=" + this.mApplicationContext.getPackageName() + ", callers=" + sb.toString());
                }
            }
            if (this.mSelectedRoute != routeInfo) {
                if (this.mSelectedRoute != null) {
                    if (MediaRouter.DEBUG) {
                        Log.d("MediaRouter", "Route unselected: " + this.mSelectedRoute + " reason: " + i);
                    }
                    this.mCallbackHandler.post(263, this.mSelectedRoute, i);
                    if (this.mSelectedRouteController != null) {
                        this.mSelectedRouteController.onUnselect(i);
                        this.mSelectedRouteController.onRelease();
                        this.mSelectedRouteController = null;
                    }
                    if (!this.mRouteControllerMap.isEmpty()) {
                        for (MediaRouteProvider.RouteController routeController : this.mRouteControllerMap.values()) {
                            routeController.onUnselect(i);
                            routeController.onRelease();
                        }
                        this.mRouteControllerMap.clear();
                    }
                }
                this.mSelectedRoute = routeInfo;
                this.mSelectedRouteController = routeInfo.getProviderInstance().onCreateRouteController(routeInfo.mDescriptorId);
                if (this.mSelectedRouteController != null) {
                    this.mSelectedRouteController.onSelect();
                }
                if (MediaRouter.DEBUG) {
                    Log.d("MediaRouter", "Route selected: " + this.mSelectedRoute);
                }
                this.mCallbackHandler.post(262, this.mSelectedRoute);
                if (this.mSelectedRoute instanceof RouteGroup) {
                    List<RouteInfo> routes = ((RouteGroup) this.mSelectedRoute).getRoutes();
                    this.mRouteControllerMap.clear();
                    for (RouteInfo routeInfo2 : routes) {
                        MediaRouteProvider.RouteController onCreateRouteController = routeInfo2.getProviderInstance().onCreateRouteController(routeInfo2.mDescriptorId, this.mSelectedRoute.mDescriptorId);
                        onCreateRouteController.onSelect();
                        this.mRouteControllerMap.put(routeInfo2.mDescriptorId, onCreateRouteController);
                    }
                }
                updatePlaybackInfoFromSelectedRoute();
            }
        }

        @Override // android.support.v7.media.SystemMediaRouteProvider.SyncCallback
        public void onSystemRouteSelectedByDescriptorId(String str) {
            ProviderInfo providerInfo;
            int findRouteByDescriptorId;
            this.mCallbackHandler.removeMessages(262);
            int findProviderInfo = findProviderInfo(this.mSystemProvider);
            if (findProviderInfo >= 0 && (findRouteByDescriptorId = (providerInfo = this.mProviders.get(findProviderInfo)).findRouteByDescriptorId(str)) >= 0) {
                ((RouteInfo) providerInfo.mRoutes.get(findRouteByDescriptorId)).select();
            }
        }

        public void addRemoteControlClient(Object obj) {
            if (findRemoteControlClientRecord(obj) < 0) {
                this.mRemoteControlClients.add(new RemoteControlClientRecord(obj));
            }
        }

        public void removeRemoteControlClient(Object obj) {
            int findRemoteControlClientRecord = findRemoteControlClientRecord(obj);
            if (findRemoteControlClientRecord >= 0) {
                this.mRemoteControlClients.remove(findRemoteControlClientRecord).disconnect();
            }
        }

        public void setMediaSessionCompat(MediaSessionCompat mediaSessionCompat) {
            this.mCompatSession = mediaSessionCompat;
            if (Build.VERSION.SDK_INT >= 21) {
                setMediaSessionRecord(mediaSessionCompat != null ? new MediaSessionRecord(mediaSessionCompat) : null);
            } else if (Build.VERSION.SDK_INT >= 14) {
                if (this.mRccMediaSession != null) {
                    removeRemoteControlClient(this.mRccMediaSession.getRemoteControlClient());
                    this.mRccMediaSession.removeOnActiveChangeListener(this.mSessionActiveListener);
                }
                this.mRccMediaSession = mediaSessionCompat;
                if (mediaSessionCompat != null) {
                    mediaSessionCompat.addOnActiveChangeListener(this.mSessionActiveListener);
                    if (mediaSessionCompat.isActive()) {
                        addRemoteControlClient(mediaSessionCompat.getRemoteControlClient());
                    }
                }
            }
        }

        private void setMediaSessionRecord(MediaSessionRecord mediaSessionRecord) {
            if (this.mMediaSession != null) {
                this.mMediaSession.clearVolumeHandling();
            }
            this.mMediaSession = mediaSessionRecord;
            if (mediaSessionRecord != null) {
                updatePlaybackInfoFromSelectedRoute();
            }
        }

        private int findRemoteControlClientRecord(Object obj) {
            int size = this.mRemoteControlClients.size();
            for (int i = 0; i < size; i++) {
                if (this.mRemoteControlClients.get(i).getRemoteControlClient() == obj) {
                    return i;
                }
            }
            return -1;
        }

        private void updatePlaybackInfoFromSelectedRoute() {
            if (this.mSelectedRoute != null) {
                this.mPlaybackInfo.volume = this.mSelectedRoute.getVolume();
                this.mPlaybackInfo.volumeMax = this.mSelectedRoute.getVolumeMax();
                this.mPlaybackInfo.volumeHandling = this.mSelectedRoute.getVolumeHandling();
                this.mPlaybackInfo.playbackStream = this.mSelectedRoute.getPlaybackStream();
                this.mPlaybackInfo.playbackType = this.mSelectedRoute.getPlaybackType();
                int size = this.mRemoteControlClients.size();
                for (int i = 0; i < size; i++) {
                    this.mRemoteControlClients.get(i).updatePlaybackInfo();
                }
                if (this.mMediaSession == null) {
                    return;
                }
                if (this.mSelectedRoute == getDefaultRoute() || this.mSelectedRoute == getBluetoothRoute()) {
                    this.mMediaSession.clearVolumeHandling();
                    return;
                }
                int i2 = 0;
                if (this.mPlaybackInfo.volumeHandling == 1) {
                    i2 = 2;
                }
                this.mMediaSession.configureVolume(i2, this.mPlaybackInfo.volumeMax, this.mPlaybackInfo.volume);
            } else if (this.mMediaSession != null) {
                this.mMediaSession.clearVolumeHandling();
            }
        }

        /* access modifiers changed from: package-private */
        public final class ProviderCallback extends MediaRouteProvider.Callback {
            ProviderCallback() {
            }

            @Override // android.support.v7.media.MediaRouteProvider.Callback
            public void onDescriptorChanged(MediaRouteProvider mediaRouteProvider, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
                GlobalMediaRouter.this.updateProviderDescriptor(mediaRouteProvider, mediaRouteProviderDescriptor);
            }
        }

        /* access modifiers changed from: package-private */
        public final class MediaSessionRecord {
            private int mControlType;
            private int mMaxVolume;
            private final MediaSessionCompat mMsCompat;
            private VolumeProviderCompat mVpCompat;

            public MediaSessionRecord(MediaSessionCompat mediaSessionCompat) {
                this.mMsCompat = mediaSessionCompat;
            }

            public void configureVolume(int i, int i2, int i3) {
                if (this.mVpCompat != null && i == this.mControlType && i2 == this.mMaxVolume) {
                    this.mVpCompat.setCurrentVolume(i3);
                    return;
                }
                this.mVpCompat = new VolumeProviderCompat(i, i2, i3) { // from class: android.support.v7.media.MediaRouter.GlobalMediaRouter.MediaSessionRecord.1
                    @Override // android.support.v4.media.VolumeProviderCompat
                    public void onSetVolumeTo(final int i4) {
                        GlobalMediaRouter.this.mCallbackHandler.post(new Runnable() { // from class: android.support.v7.media.MediaRouter.GlobalMediaRouter.MediaSessionRecord.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (GlobalMediaRouter.this.mSelectedRoute != null) {
                                    GlobalMediaRouter.this.mSelectedRoute.requestSetVolume(i4);
                                }
                            }
                        });
                    }

                    @Override // android.support.v4.media.VolumeProviderCompat
                    public void onAdjustVolume(final int i4) {
                        GlobalMediaRouter.this.mCallbackHandler.post(new Runnable() { // from class: android.support.v7.media.MediaRouter.GlobalMediaRouter.MediaSessionRecord.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (GlobalMediaRouter.this.mSelectedRoute != null) {
                                    GlobalMediaRouter.this.mSelectedRoute.requestUpdateVolume(i4);
                                }
                            }
                        });
                    }
                };
                this.mMsCompat.setPlaybackToRemote(this.mVpCompat);
            }

            public void clearVolumeHandling() {
                this.mMsCompat.setPlaybackToLocal(GlobalMediaRouter.this.mPlaybackInfo.playbackStream);
                this.mVpCompat = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final class RemoteControlClientRecord implements RemoteControlClientCompat.VolumeCallback {
            private boolean mDisconnected;
            private final RemoteControlClientCompat mRccCompat;

            public RemoteControlClientRecord(Object obj) {
                this.mRccCompat = RemoteControlClientCompat.obtain(GlobalMediaRouter.this.mApplicationContext, obj);
                this.mRccCompat.setVolumeCallback(this);
                updatePlaybackInfo();
            }

            public Object getRemoteControlClient() {
                return this.mRccCompat.getRemoteControlClient();
            }

            public void disconnect() {
                this.mDisconnected = true;
                this.mRccCompat.setVolumeCallback(null);
            }

            public void updatePlaybackInfo() {
                this.mRccCompat.setPlaybackInfo(GlobalMediaRouter.this.mPlaybackInfo);
            }

            @Override // android.support.v7.media.RemoteControlClientCompat.VolumeCallback
            public void onVolumeSetRequest(int i) {
                if (!this.mDisconnected && GlobalMediaRouter.this.mSelectedRoute != null) {
                    GlobalMediaRouter.this.mSelectedRoute.requestSetVolume(i);
                }
            }

            @Override // android.support.v7.media.RemoteControlClientCompat.VolumeCallback
            public void onVolumeUpdateRequest(int i) {
                if (!this.mDisconnected && GlobalMediaRouter.this.mSelectedRoute != null) {
                    GlobalMediaRouter.this.mSelectedRoute.requestUpdateVolume(i);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final class CallbackHandler extends Handler {
            private final ArrayList<CallbackRecord> mTempCallbackRecords = new ArrayList<>();

            CallbackHandler() {
            }

            public void post(int i, Object obj) {
                obtainMessage(i, obj).sendToTarget();
            }

            public void post(int i, Object obj, int i2) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.arg1 = i2;
                obtainMessage.sendToTarget();
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                Object obj = message.obj;
                int i2 = message.arg1;
                if (i == 259 && GlobalMediaRouter.this.getSelectedRoute().getId().equals(((RouteInfo) obj).getId())) {
                    GlobalMediaRouter.this.updateSelectedRouteIfNeeded(true);
                }
                syncWithSystemProvider(i, obj);
                try {
                    int size = GlobalMediaRouter.this.mRouters.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        MediaRouter mediaRouter = GlobalMediaRouter.this.mRouters.get(size).get();
                        if (mediaRouter == null) {
                            GlobalMediaRouter.this.mRouters.remove(size);
                        } else {
                            this.mTempCallbackRecords.addAll(mediaRouter.mCallbackRecords);
                        }
                    }
                    int size2 = this.mTempCallbackRecords.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        invokeCallback(this.mTempCallbackRecords.get(i3), i, obj, i2);
                    }
                } finally {
                    this.mTempCallbackRecords.clear();
                }
            }

            private void syncWithSystemProvider(int i, Object obj) {
                switch (i) {
                    case 257:
                        GlobalMediaRouter.this.mSystemProvider.onSyncRouteAdded((RouteInfo) obj);
                        return;
                    case 258:
                        GlobalMediaRouter.this.mSystemProvider.onSyncRouteRemoved((RouteInfo) obj);
                        return;
                    case 259:
                        GlobalMediaRouter.this.mSystemProvider.onSyncRouteChanged((RouteInfo) obj);
                        return;
                    case 260:
                    case 261:
                    default:
                        return;
                    case 262:
                        GlobalMediaRouter.this.mSystemProvider.onSyncRouteSelected((RouteInfo) obj);
                        return;
                }
            }

            private void invokeCallback(CallbackRecord callbackRecord, int i, Object obj, int i2) {
                MediaRouter mediaRouter = callbackRecord.mRouter;
                Callback callback = callbackRecord.mCallback;
                switch (65280 & i) {
                    case 256:
                        RouteInfo routeInfo = (RouteInfo) obj;
                        if (callbackRecord.filterRouteEvent(routeInfo)) {
                            switch (i) {
                                case 257:
                                    callback.onRouteAdded(mediaRouter, routeInfo);
                                    return;
                                case 258:
                                    callback.onRouteRemoved(mediaRouter, routeInfo);
                                    return;
                                case 259:
                                    callback.onRouteChanged(mediaRouter, routeInfo);
                                    return;
                                case 260:
                                    callback.onRouteVolumeChanged(mediaRouter, routeInfo);
                                    return;
                                case 261:
                                    callback.onRoutePresentationDisplayChanged(mediaRouter, routeInfo);
                                    return;
                                case 262:
                                    callback.onRouteSelected(mediaRouter, routeInfo);
                                    return;
                                case 263:
                                    callback.onRouteUnselected(mediaRouter, routeInfo, i2);
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            return;
                        }
                    case 512:
                        ProviderInfo providerInfo = (ProviderInfo) obj;
                        switch (i) {
                            case 513:
                                callback.onProviderAdded(mediaRouter, providerInfo);
                                return;
                            case 514:
                                callback.onProviderRemoved(mediaRouter, providerInfo);
                                return;
                            case 515:
                                callback.onProviderChanged(mediaRouter, providerInfo);
                                return;
                            default:
                                return;
                        }
                    default:
                        return;
                }
            }
        }
    }
}
