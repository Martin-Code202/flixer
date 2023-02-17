package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.api.internal.zzca;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzccw;
import com.google.android.gms.internal.zzcdw;
import com.google.android.gms.internal.zzcfw;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import java.util.List;
import java.util.Map;
@Keep
@Deprecated
public class AppMeasurement {
    private final zzccw zzikh;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            zzbp.zzu(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = zzcfw.zzad(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mValue = conditionalUserProperty.mValue;
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    public static final class Event extends FirebaseAnalytics.Event {
        public static final String[] zziki = {"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", ExceptionClEvent.CATEGORY_VALUE, "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"};
        public static final String[] zzikj = {"_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_vs", "_ep"};

        public static String zzil(String str) {
            return zzcfw.zza(str, zziki, zzikj);
        }
    }

    public interface EventInterceptor {
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    public interface OnEventListener {
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public static final class Param extends FirebaseAnalytics.Param {
        public static final String[] zzikk = {"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "firebase_event_id", "firebase_extra_params_ct", "firebase_group_name", "firebase_list_length", "firebase_index", "firebase_event_name"};
        public static final String[] zzikl = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en"};

        public static String zzil(String str) {
            return zzcfw.zza(str, zzikk, zzikl);
        }
    }

    public static final class UserProperty extends FirebaseAnalytics.UserProperty {
        public static final String[] zzikp = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install"};
        public static final String[] zzikq = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi"};

        public static String zzil(String str) {
            return zzcfw.zza(str, zzikp, zzikq);
        }
    }

    public interface zza {
        boolean zza(zzb zzb, zzb zzb2);
    }

    public static class zzb {
        public String zzikm;
        public String zzikn;
        public long zziko;

        public zzb() {
        }

        public zzb(zzb zzb) {
            this.zzikm = zzb.zzikm;
            this.zzikn = zzb.zzikn;
            this.zziko = zzb.zziko;
        }
    }

    public AppMeasurement(zzccw zzccw) {
        zzbp.zzu(zzccw);
        this.zzikh = zzccw;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zzccw.zzdn(context).zzayz();
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zzikh.zzaty().beginAdUnitExposure(str);
    }

    /* access modifiers changed from: protected */
    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzikh.zzaua().clearConditionalUserProperty(str, str2, bundle);
    }

    /* access modifiers changed from: protected */
    @Keep
    public void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        this.zzikh.zzaua().clearConditionalUserPropertyAs(str, str2, str3, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zzikh.zzaty().endAdUnitExposure(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzikh.zzaui().zzazy();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzikh.zzaua().zzayo();
    }

    /* access modifiers changed from: protected */
    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.zzikh.zzaua().getConditionalUserProperties(str, str2);
    }

    /* access modifiers changed from: protected */
    @Keep
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        return this.zzikh.zzaua().getConditionalUserPropertiesAs(str, str2, str3);
    }

    @Keep
    public String getCurrentScreenClass() {
        zzb zzazp = this.zzikh.zzaue().zzazp();
        if (zzazp != null) {
            return zzazp.zzikn;
        }
        return null;
    }

    @Keep
    public String getCurrentScreenName() {
        zzb zzazp = this.zzikh.zzaue().zzazp();
        if (zzazp != null) {
            return zzazp.zzikm;
        }
        return null;
    }

    @Keep
    public String getGmpAppId() {
        try {
            return zzca.zzaie();
        } catch (IllegalStateException e) {
            this.zzikh.zzaum().zzaye().zzj("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    public int getMaxUserProperties(String str) {
        this.zzikh.zzaua();
        return zzcdw.getMaxUserProperties(str);
    }

    /* access modifiers changed from: protected */
    @Keep
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzikh.zzaua().getUserProperties(str, str2, z);
    }

    /* access modifiers changed from: protected */
    @Keep
    public Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        return this.zzikh.zzaua().getUserPropertiesAs(str, str2, str3, z);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzikh.zzaua().zzc(str, str2, bundle);
    }

    @Keep
    public void registerOnScreenChangeCallback(zza zza2) {
        this.zzikh.zzaue().registerOnScreenChangeCallback(zza2);
    }

    /* access modifiers changed from: protected */
    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.zzikh.zzaua().setConditionalUserProperty(conditionalUserProperty);
    }

    /* access modifiers changed from: protected */
    @Keep
    public void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.zzikh.zzaua().setConditionalUserPropertyAs(conditionalUserProperty);
    }

    public void setUserPropertyInternal(String str, String str2, Object obj) {
        this.zzikh.zzaua().zzb(str, str2, obj);
    }

    @Keep
    public void unregisterOnScreenChangeCallback(zza zza2) {
        this.zzikh.zzaue().unregisterOnScreenChangeCallback(zza2);
    }
}
