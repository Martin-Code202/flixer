package android.support.v7.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.support.v7.media.MediaRouteDescriptor;
import android.support.v7.media.MediaRouteProvider;
import android.support.v7.media.MediaRouteProviderDescriptor;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouterApi24;
import android.support.v7.media.MediaRouterJellybean;
import android.support.v7.media.MediaRouterJellybeanMr1;
import android.support.v7.media.MediaRouterJellybeanMr2;
import android.support.v7.mediarouter.R;
import android.view.Display;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* access modifiers changed from: package-private */
public abstract class SystemMediaRouteProvider extends MediaRouteProvider {

    public interface SyncCallback {
        void onSystemRouteSelectedByDescriptorId(String str);
    }

    protected SystemMediaRouteProvider(Context context) {
        super(context, new MediaRouteProvider.ProviderMetadata(new ComponentName("android", SystemMediaRouteProvider.class.getName())));
    }

    public static SystemMediaRouteProvider obtain(Context context, SyncCallback syncCallback) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Api24Impl(context, syncCallback);
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return new JellybeanMr2Impl(context, syncCallback);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return new JellybeanMr1Impl(context, syncCallback);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new JellybeanImpl(context, syncCallback);
        }
        return new LegacyImpl(context);
    }

    public void onSyncRouteAdded(MediaRouter.RouteInfo routeInfo) {
    }

    public void onSyncRouteRemoved(MediaRouter.RouteInfo routeInfo) {
    }

    public void onSyncRouteChanged(MediaRouter.RouteInfo routeInfo) {
    }

    public void onSyncRouteSelected(MediaRouter.RouteInfo routeInfo) {
    }

    /* access modifiers changed from: protected */
    public Object getDefaultRoute() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public static class LegacyImpl extends SystemMediaRouteProvider {
        private static final ArrayList<IntentFilter> CONTROL_FILTERS = new ArrayList<>();
        final AudioManager mAudioManager;
        int mLastReportedVolume = -1;
        private final VolumeChangeReceiver mVolumeChangeReceiver;

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            intentFilter.addCategory("android.media.intent.category.LIVE_VIDEO");
            CONTROL_FILTERS.add(intentFilter);
        }

        public LegacyImpl(Context context) {
            super(context);
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
            this.mVolumeChangeReceiver = new VolumeChangeReceiver();
            context.registerReceiver(this.mVolumeChangeReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            publishRoutes();
        }

        /* access modifiers changed from: package-private */
        public void publishRoutes() {
            Resources resources = getContext().getResources();
            int streamMaxVolume = this.mAudioManager.getStreamMaxVolume(3);
            this.mLastReportedVolume = this.mAudioManager.getStreamVolume(3);
            setDescriptor(new MediaRouteProviderDescriptor.Builder().addRoute(new MediaRouteDescriptor.Builder("DEFAULT_ROUTE", resources.getString(R.string.mr_system_route_name)).addControlFilters(CONTROL_FILTERS).setPlaybackStream(3).setPlaybackType(0).setVolumeHandling(1).setVolumeMax(streamMaxVolume).setVolume(this.mLastReportedVolume).build()).build());
        }

        @Override // android.support.v7.media.MediaRouteProvider
        public MediaRouteProvider.RouteController onCreateRouteController(String str) {
            if (str.equals("DEFAULT_ROUTE")) {
                return new DefaultRouteController();
            }
            return null;
        }

        final class DefaultRouteController extends MediaRouteProvider.RouteController {
            DefaultRouteController() {
            }

            @Override // android.support.v7.media.MediaRouteProvider.RouteController
            public void onSetVolume(int i) {
                LegacyImpl.this.mAudioManager.setStreamVolume(3, i, 0);
                LegacyImpl.this.publishRoutes();
            }

            @Override // android.support.v7.media.MediaRouteProvider.RouteController
            public void onUpdateVolume(int i) {
                int streamVolume = LegacyImpl.this.mAudioManager.getStreamVolume(3);
                if (Math.min(LegacyImpl.this.mAudioManager.getStreamMaxVolume(3), Math.max(0, streamVolume + i)) != streamVolume) {
                    LegacyImpl.this.mAudioManager.setStreamVolume(3, streamVolume, 0);
                }
                LegacyImpl.this.publishRoutes();
            }
        }

        final class VolumeChangeReceiver extends BroadcastReceiver {
            VolumeChangeReceiver() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra;
                if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3 && (intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1)) >= 0 && intExtra != LegacyImpl.this.mLastReportedVolume) {
                    LegacyImpl.this.publishRoutes();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class JellybeanImpl extends SystemMediaRouteProvider implements MediaRouterJellybean.Callback, MediaRouterJellybean.VolumeCallback {
        private static final ArrayList<IntentFilter> LIVE_AUDIO_CONTROL_FILTERS = new ArrayList<>();
        private static final ArrayList<IntentFilter> LIVE_VIDEO_CONTROL_FILTERS = new ArrayList<>();
        protected boolean mActiveScan;
        protected final Object mCallbackObj;
        protected boolean mCallbackRegistered;
        private MediaRouterJellybean.GetDefaultRouteWorkaround mGetDefaultRouteWorkaround;
        protected int mRouteTypes;
        protected final Object mRouterObj;
        private MediaRouterJellybean.SelectRouteWorkaround mSelectRouteWorkaround;
        private final SyncCallback mSyncCallback;
        protected final ArrayList<SystemRouteRecord> mSystemRouteRecords = new ArrayList<>();
        protected final Object mUserRouteCategoryObj;
        protected final ArrayList<UserRouteRecord> mUserRouteRecords = new ArrayList<>();
        protected final Object mVolumeCallbackObj;

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            LIVE_AUDIO_CONTROL_FILTERS.add(intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
            LIVE_VIDEO_CONTROL_FILTERS.add(intentFilter2);
        }

        public JellybeanImpl(Context context, SyncCallback syncCallback) {
            super(context);
            this.mSyncCallback = syncCallback;
            this.mRouterObj = MediaRouterJellybean.getMediaRouter(context);
            this.mCallbackObj = createCallbackObj();
            this.mVolumeCallbackObj = createVolumeCallbackObj();
            this.mUserRouteCategoryObj = MediaRouterJellybean.createRouteCategory(this.mRouterObj, context.getResources().getString(R.string.mr_user_route_category_name), false);
            updateSystemRoutes();
        }

        @Override // android.support.v7.media.MediaRouteProvider
        public MediaRouteProvider.RouteController onCreateRouteController(String str) {
            int findSystemRouteRecordByDescriptorId = findSystemRouteRecordByDescriptorId(str);
            if (findSystemRouteRecordByDescriptorId >= 0) {
                return new SystemRouteController(this.mSystemRouteRecords.get(findSystemRouteRecordByDescriptorId).mRouteObj);
            }
            return null;
        }

        @Override // android.support.v7.media.MediaRouteProvider
        public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
            int i = 0;
            boolean z = false;
            if (mediaRouteDiscoveryRequest != null) {
                List<String> controlCategories = mediaRouteDiscoveryRequest.getSelector().getControlCategories();
                int size = controlCategories.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = controlCategories.get(i2);
                    if (str.equals("android.media.intent.category.LIVE_AUDIO")) {
                        i |= 1;
                    } else if (str.equals("android.media.intent.category.LIVE_VIDEO")) {
                        i |= 2;
                    } else {
                        i |= 8388608;
                    }
                }
                z = mediaRouteDiscoveryRequest.isActiveScan();
            }
            if (!(this.mRouteTypes == i && this.mActiveScan == z)) {
                this.mRouteTypes = i;
                this.mActiveScan = z;
                updateSystemRoutes();
            }
        }

        @Override // android.support.v7.media.MediaRouterJellybean.Callback
        public void onRouteAdded(Object obj) {
            if (addSystemRouteNoPublish(obj)) {
                publishRoutes();
            }
        }

        private void updateSystemRoutes() {
            updateCallback();
            boolean z = false;
            for (Object obj : MediaRouterJellybean.getRoutes(this.mRouterObj)) {
                z |= addSystemRouteNoPublish(obj);
            }
            if (z) {
                publishRoutes();
            }
        }

        private boolean addSystemRouteNoPublish(Object obj) {
            if (getUserRouteRecord(obj) != null || findSystemRouteRecord(obj) >= 0) {
                return false;
            }
            SystemRouteRecord systemRouteRecord = new SystemRouteRecord(obj, assignRouteId(obj));
            updateSystemRouteDescriptor(systemRouteRecord);
            this.mSystemRouteRecords.add(systemRouteRecord);
            return true;
        }

        private String assignRouteId(Object obj) {
            String str;
            if (getDefaultRoute() == obj) {
                str = "DEFAULT_ROUTE";
            } else {
                str = String.format(Locale.US, "ROUTE_%08x", Integer.valueOf(getRouteName(obj).hashCode()));
            }
            if (findSystemRouteRecordByDescriptorId(str) < 0) {
                return str;
            }
            int i = 2;
            while (true) {
                String format = String.format(Locale.US, "%s_%d", str, Integer.valueOf(i));
                if (findSystemRouteRecordByDescriptorId(format) < 0) {
                    return format;
                }
                i++;
            }
        }

        @Override // android.support.v7.media.MediaRouterJellybean.Callback
        public void onRouteRemoved(Object obj) {
            int findSystemRouteRecord;
            if (getUserRouteRecord(obj) == null && (findSystemRouteRecord = findSystemRouteRecord(obj)) >= 0) {
                this.mSystemRouteRecords.remove(findSystemRouteRecord);
                publishRoutes();
            }
        }

        @Override // android.support.v7.media.MediaRouterJellybean.Callback
        public void onRouteChanged(Object obj) {
            int findSystemRouteRecord;
            if (getUserRouteRecord(obj) == null && (findSystemRouteRecord = findSystemRouteRecord(obj)) >= 0) {
                updateSystemRouteDescriptor(this.mSystemRouteRecords.get(findSystemRouteRecord));
                publishRoutes();
            }
        }

        @Override // android.support.v7.media.MediaRouterJellybean.Callback
        public void onRouteVolumeChanged(Object obj) {
            int findSystemRouteRecord;
            if (getUserRouteRecord(obj) == null && (findSystemRouteRecord = findSystemRouteRecord(obj)) >= 0) {
                SystemRouteRecord systemRouteRecord = this.mSystemRouteRecords.get(findSystemRouteRecord);
                int volume = MediaRouterJellybean.RouteInfo.getVolume(obj);
                if (volume != systemRouteRecord.mRouteDescriptor.getVolume()) {
                    systemRouteRecord.mRouteDescriptor = new MediaRouteDescriptor.Builder(systemRouteRecord.mRouteDescriptor).setVolume(volume).build();
                    publishRoutes();
                }
            }
        }

        @Override // android.support.v7.media.MediaRouterJellybean.Callback
        public void onRouteSelected(int i, Object obj) {
            if (obj == MediaRouterJellybean.getSelectedRoute(this.mRouterObj, 8388611)) {
                UserRouteRecord userRouteRecord = getUserRouteRecord(obj);
                if (userRouteRecord != null) {
                    userRouteRecord.mRoute.select();
                    return;
                }
                int findSystemRouteRecord = findSystemRouteRecord(obj);
                if (findSystemRouteRecord >= 0) {
                    this.mSyncCallback.onSystemRouteSelectedByDescriptorId(this.mSystemRouteRecords.get(findSystemRouteRecord).mRouteDescriptorId);
                }
            }
        }

        @Override // android.support.v7.media.MediaRouterJellybean.Callback
        public void onRouteUnselected(int i, Object obj) {
        }

        @Override // android.support.v7.media.MediaRouterJellybean.Callback
        public void onRouteGrouped(Object obj, Object obj2, int i) {
        }

        @Override // android.support.v7.media.MediaRouterJellybean.Callback
        public void onRouteUngrouped(Object obj, Object obj2) {
        }

        @Override // android.support.v7.media.MediaRouterJellybean.VolumeCallback
        public void onVolumeSetRequest(Object obj, int i) {
            UserRouteRecord userRouteRecord = getUserRouteRecord(obj);
            if (userRouteRecord != null) {
                userRouteRecord.mRoute.requestSetVolume(i);
            }
        }

        @Override // android.support.v7.media.MediaRouterJellybean.VolumeCallback
        public void onVolumeUpdateRequest(Object obj, int i) {
            UserRouteRecord userRouteRecord = getUserRouteRecord(obj);
            if (userRouteRecord != null) {
                userRouteRecord.mRoute.requestUpdateVolume(i);
            }
        }

        @Override // android.support.v7.media.SystemMediaRouteProvider
        public void onSyncRouteAdded(MediaRouter.RouteInfo routeInfo) {
            if (routeInfo.getProviderInstance() != this) {
                Object createUserRoute = MediaRouterJellybean.createUserRoute(this.mRouterObj, this.mUserRouteCategoryObj);
                UserRouteRecord userRouteRecord = new UserRouteRecord(routeInfo, createUserRoute);
                MediaRouterJellybean.RouteInfo.setTag(createUserRoute, userRouteRecord);
                MediaRouterJellybean.UserRouteInfo.setVolumeCallback(createUserRoute, this.mVolumeCallbackObj);
                updateUserRouteProperties(userRouteRecord);
                this.mUserRouteRecords.add(userRouteRecord);
                MediaRouterJellybean.addUserRoute(this.mRouterObj, createUserRoute);
                return;
            }
            int findSystemRouteRecord = findSystemRouteRecord(MediaRouterJellybean.getSelectedRoute(this.mRouterObj, 8388611));
            if (findSystemRouteRecord >= 0 && this.mSystemRouteRecords.get(findSystemRouteRecord).mRouteDescriptorId.equals(routeInfo.getDescriptorId())) {
                routeInfo.select();
            }
        }

        @Override // android.support.v7.media.SystemMediaRouteProvider
        public void onSyncRouteRemoved(MediaRouter.RouteInfo routeInfo) {
            int findUserRouteRecord;
            if (routeInfo.getProviderInstance() != this && (findUserRouteRecord = findUserRouteRecord(routeInfo)) >= 0) {
                UserRouteRecord remove = this.mUserRouteRecords.remove(findUserRouteRecord);
                MediaRouterJellybean.RouteInfo.setTag(remove.mRouteObj, null);
                MediaRouterJellybean.UserRouteInfo.setVolumeCallback(remove.mRouteObj, null);
                MediaRouterJellybean.removeUserRoute(this.mRouterObj, remove.mRouteObj);
            }
        }

        @Override // android.support.v7.media.SystemMediaRouteProvider
        public void onSyncRouteChanged(MediaRouter.RouteInfo routeInfo) {
            int findUserRouteRecord;
            if (routeInfo.getProviderInstance() != this && (findUserRouteRecord = findUserRouteRecord(routeInfo)) >= 0) {
                updateUserRouteProperties(this.mUserRouteRecords.get(findUserRouteRecord));
            }
        }

        @Override // android.support.v7.media.SystemMediaRouteProvider
        public void onSyncRouteSelected(MediaRouter.RouteInfo routeInfo) {
            if (routeInfo.isSelected()) {
                if (routeInfo.getProviderInstance() != this) {
                    int findUserRouteRecord = findUserRouteRecord(routeInfo);
                    if (findUserRouteRecord >= 0) {
                        selectRoute(this.mUserRouteRecords.get(findUserRouteRecord).mRouteObj);
                        return;
                    }
                    return;
                }
                int findSystemRouteRecordByDescriptorId = findSystemRouteRecordByDescriptorId(routeInfo.getDescriptorId());
                if (findSystemRouteRecordByDescriptorId >= 0) {
                    selectRoute(this.mSystemRouteRecords.get(findSystemRouteRecordByDescriptorId).mRouteObj);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void publishRoutes() {
            MediaRouteProviderDescriptor.Builder builder = new MediaRouteProviderDescriptor.Builder();
            int size = this.mSystemRouteRecords.size();
            for (int i = 0; i < size; i++) {
                builder.addRoute(this.mSystemRouteRecords.get(i).mRouteDescriptor);
            }
            setDescriptor(builder.build());
        }

        /* access modifiers changed from: protected */
        public int findSystemRouteRecord(Object obj) {
            int size = this.mSystemRouteRecords.size();
            for (int i = 0; i < size; i++) {
                if (this.mSystemRouteRecords.get(i).mRouteObj == obj) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public int findSystemRouteRecordByDescriptorId(String str) {
            int size = this.mSystemRouteRecords.size();
            for (int i = 0; i < size; i++) {
                if (this.mSystemRouteRecords.get(i).mRouteDescriptorId.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public int findUserRouteRecord(MediaRouter.RouteInfo routeInfo) {
            int size = this.mUserRouteRecords.size();
            for (int i = 0; i < size; i++) {
                if (this.mUserRouteRecords.get(i).mRoute == routeInfo) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public UserRouteRecord getUserRouteRecord(Object obj) {
            Object tag = MediaRouterJellybean.RouteInfo.getTag(obj);
            if (tag instanceof UserRouteRecord) {
                return (UserRouteRecord) tag;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void updateSystemRouteDescriptor(SystemRouteRecord systemRouteRecord) {
            MediaRouteDescriptor.Builder builder = new MediaRouteDescriptor.Builder(systemRouteRecord.mRouteDescriptorId, getRouteName(systemRouteRecord.mRouteObj));
            onBuildSystemRouteDescriptor(systemRouteRecord, builder);
            systemRouteRecord.mRouteDescriptor = builder.build();
        }

        /* access modifiers changed from: protected */
        public String getRouteName(Object obj) {
            CharSequence name = MediaRouterJellybean.RouteInfo.getName(obj, getContext());
            return name != null ? name.toString() : "";
        }

        /* access modifiers changed from: protected */
        public void onBuildSystemRouteDescriptor(SystemRouteRecord systemRouteRecord, MediaRouteDescriptor.Builder builder) {
            int supportedTypes = MediaRouterJellybean.RouteInfo.getSupportedTypes(systemRouteRecord.mRouteObj);
            if ((supportedTypes & 1) != 0) {
                builder.addControlFilters(LIVE_AUDIO_CONTROL_FILTERS);
            }
            if ((supportedTypes & 2) != 0) {
                builder.addControlFilters(LIVE_VIDEO_CONTROL_FILTERS);
            }
            builder.setPlaybackType(MediaRouterJellybean.RouteInfo.getPlaybackType(systemRouteRecord.mRouteObj));
            builder.setPlaybackStream(MediaRouterJellybean.RouteInfo.getPlaybackStream(systemRouteRecord.mRouteObj));
            builder.setVolume(MediaRouterJellybean.RouteInfo.getVolume(systemRouteRecord.mRouteObj));
            builder.setVolumeMax(MediaRouterJellybean.RouteInfo.getVolumeMax(systemRouteRecord.mRouteObj));
            builder.setVolumeHandling(MediaRouterJellybean.RouteInfo.getVolumeHandling(systemRouteRecord.mRouteObj));
        }

        /* access modifiers changed from: protected */
        public void updateUserRouteProperties(UserRouteRecord userRouteRecord) {
            MediaRouterJellybean.UserRouteInfo.setName(userRouteRecord.mRouteObj, userRouteRecord.mRoute.getName());
            MediaRouterJellybean.UserRouteInfo.setPlaybackType(userRouteRecord.mRouteObj, userRouteRecord.mRoute.getPlaybackType());
            MediaRouterJellybean.UserRouteInfo.setPlaybackStream(userRouteRecord.mRouteObj, userRouteRecord.mRoute.getPlaybackStream());
            MediaRouterJellybean.UserRouteInfo.setVolume(userRouteRecord.mRouteObj, userRouteRecord.mRoute.getVolume());
            MediaRouterJellybean.UserRouteInfo.setVolumeMax(userRouteRecord.mRouteObj, userRouteRecord.mRoute.getVolumeMax());
            MediaRouterJellybean.UserRouteInfo.setVolumeHandling(userRouteRecord.mRouteObj, userRouteRecord.mRoute.getVolumeHandling());
        }

        /* access modifiers changed from: protected */
        public void updateCallback() {
            if (this.mCallbackRegistered) {
                this.mCallbackRegistered = false;
                MediaRouterJellybean.removeCallback(this.mRouterObj, this.mCallbackObj);
            }
            if (this.mRouteTypes != 0) {
                this.mCallbackRegistered = true;
                MediaRouterJellybean.addCallback(this.mRouterObj, this.mRouteTypes, this.mCallbackObj);
            }
        }

        /* access modifiers changed from: protected */
        public Object createCallbackObj() {
            return MediaRouterJellybean.createCallback(this);
        }

        /* access modifiers changed from: protected */
        public Object createVolumeCallbackObj() {
            return MediaRouterJellybean.createVolumeCallback(this);
        }

        /* access modifiers changed from: protected */
        public void selectRoute(Object obj) {
            if (this.mSelectRouteWorkaround == null) {
                this.mSelectRouteWorkaround = new MediaRouterJellybean.SelectRouteWorkaround();
            }
            this.mSelectRouteWorkaround.selectRoute(this.mRouterObj, 8388611, obj);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider
        public Object getDefaultRoute() {
            if (this.mGetDefaultRouteWorkaround == null) {
                this.mGetDefaultRouteWorkaround = new MediaRouterJellybean.GetDefaultRouteWorkaround();
            }
            return this.mGetDefaultRouteWorkaround.getDefaultRoute(this.mRouterObj);
        }

        /* access modifiers changed from: protected */
        public static final class SystemRouteRecord {
            public MediaRouteDescriptor mRouteDescriptor;
            public final String mRouteDescriptorId;
            public final Object mRouteObj;

            public SystemRouteRecord(Object obj, String str) {
                this.mRouteObj = obj;
                this.mRouteDescriptorId = str;
            }
        }

        /* access modifiers changed from: protected */
        public static final class UserRouteRecord {
            public final MediaRouter.RouteInfo mRoute;
            public final Object mRouteObj;

            public UserRouteRecord(MediaRouter.RouteInfo routeInfo, Object obj) {
                this.mRoute = routeInfo;
                this.mRouteObj = obj;
            }
        }

        protected static final class SystemRouteController extends MediaRouteProvider.RouteController {
            private final Object mRouteObj;

            public SystemRouteController(Object obj) {
                this.mRouteObj = obj;
            }

            @Override // android.support.v7.media.MediaRouteProvider.RouteController
            public void onSetVolume(int i) {
                MediaRouterJellybean.RouteInfo.requestSetVolume(this.mRouteObj, i);
            }

            @Override // android.support.v7.media.MediaRouteProvider.RouteController
            public void onUpdateVolume(int i) {
                MediaRouterJellybean.RouteInfo.requestUpdateVolume(this.mRouteObj, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class JellybeanMr1Impl extends JellybeanImpl implements MediaRouterJellybeanMr1.Callback {
        private MediaRouterJellybeanMr1.ActiveScanWorkaround mActiveScanWorkaround;
        private MediaRouterJellybeanMr1.IsConnectingWorkaround mIsConnectingWorkaround;

        public JellybeanMr1Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        @Override // android.support.v7.media.MediaRouterJellybeanMr1.Callback
        public void onRoutePresentationDisplayChanged(Object obj) {
            int findSystemRouteRecord = findSystemRouteRecord(obj);
            if (findSystemRouteRecord >= 0) {
                JellybeanImpl.SystemRouteRecord systemRouteRecord = (JellybeanImpl.SystemRouteRecord) this.mSystemRouteRecords.get(findSystemRouteRecord);
                Display presentationDisplay = MediaRouterJellybeanMr1.RouteInfo.getPresentationDisplay(obj);
                int displayId = presentationDisplay != null ? presentationDisplay.getDisplayId() : -1;
                if (displayId != systemRouteRecord.mRouteDescriptor.getPresentationDisplayId()) {
                    systemRouteRecord.mRouteDescriptor = new MediaRouteDescriptor.Builder(systemRouteRecord.mRouteDescriptor).setPresentationDisplayId(displayId).build();
                    publishRoutes();
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl
        public void onBuildSystemRouteDescriptor(JellybeanImpl.SystemRouteRecord systemRouteRecord, MediaRouteDescriptor.Builder builder) {
            super.onBuildSystemRouteDescriptor(systemRouteRecord, builder);
            if (!MediaRouterJellybeanMr1.RouteInfo.isEnabled(systemRouteRecord.mRouteObj)) {
                builder.setEnabled(false);
            }
            if (isConnecting(systemRouteRecord)) {
                builder.setConnecting(true);
            }
            Display presentationDisplay = MediaRouterJellybeanMr1.RouteInfo.getPresentationDisplay(systemRouteRecord.mRouteObj);
            if (presentationDisplay != null) {
                builder.setPresentationDisplayId(presentationDisplay.getDisplayId());
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl
        public void updateCallback() {
            super.updateCallback();
            if (this.mActiveScanWorkaround == null) {
                this.mActiveScanWorkaround = new MediaRouterJellybeanMr1.ActiveScanWorkaround(getContext(), getHandler());
            }
            this.mActiveScanWorkaround.setActiveScanRouteTypes(this.mActiveScan ? this.mRouteTypes : 0);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl
        public Object createCallbackObj() {
            return MediaRouterJellybeanMr1.createCallback(this);
        }

        /* access modifiers changed from: protected */
        public boolean isConnecting(JellybeanImpl.SystemRouteRecord systemRouteRecord) {
            if (this.mIsConnectingWorkaround == null) {
                this.mIsConnectingWorkaround = new MediaRouterJellybeanMr1.IsConnectingWorkaround();
            }
            return this.mIsConnectingWorkaround.isConnecting(systemRouteRecord.mRouteObj);
        }
    }

    /* access modifiers changed from: package-private */
    public static class JellybeanMr2Impl extends JellybeanMr1Impl {
        public JellybeanMr2Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanMr1Impl, android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl
        public void onBuildSystemRouteDescriptor(JellybeanImpl.SystemRouteRecord systemRouteRecord, MediaRouteDescriptor.Builder builder) {
            super.onBuildSystemRouteDescriptor(systemRouteRecord, builder);
            CharSequence description = MediaRouterJellybeanMr2.RouteInfo.getDescription(systemRouteRecord.mRouteObj);
            if (description != null) {
                builder.setDescription(description.toString());
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl
        public void selectRoute(Object obj) {
            MediaRouterJellybean.selectRoute(this.mRouterObj, 8388611, obj);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl, android.support.v7.media.SystemMediaRouteProvider
        public Object getDefaultRoute() {
            return MediaRouterJellybeanMr2.getDefaultRoute(this.mRouterObj);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl
        public void updateUserRouteProperties(JellybeanImpl.UserRouteRecord userRouteRecord) {
            super.updateUserRouteProperties(userRouteRecord);
            MediaRouterJellybeanMr2.UserRouteInfo.setDescription(userRouteRecord.mRouteObj, userRouteRecord.mRoute.getDescription());
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanMr1Impl, android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl
        public void updateCallback() {
            if (this.mCallbackRegistered) {
                MediaRouterJellybean.removeCallback(this.mRouterObj, this.mCallbackObj);
            }
            this.mCallbackRegistered = true;
            MediaRouterJellybeanMr2.addCallback(this.mRouterObj, this.mRouteTypes, this.mCallbackObj, (this.mActiveScan ? 1 : 0) | 2);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanMr1Impl
        public boolean isConnecting(JellybeanImpl.SystemRouteRecord systemRouteRecord) {
            return MediaRouterJellybeanMr2.RouteInfo.isConnecting(systemRouteRecord.mRouteObj);
        }
    }

    /* access modifiers changed from: package-private */
    public static class Api24Impl extends JellybeanMr2Impl {
        public Api24Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v7.media.SystemMediaRouteProvider.JellybeanMr2Impl, android.support.v7.media.SystemMediaRouteProvider.JellybeanMr1Impl, android.support.v7.media.SystemMediaRouteProvider.JellybeanImpl
        public void onBuildSystemRouteDescriptor(JellybeanImpl.SystemRouteRecord systemRouteRecord, MediaRouteDescriptor.Builder builder) {
            super.onBuildSystemRouteDescriptor(systemRouteRecord, builder);
            builder.setDeviceType(MediaRouterApi24.RouteInfo.getDeviceType(systemRouteRecord.mRouteObj));
        }
    }
}
