package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.ISearchLogging;
import com.netflix.model.leafs.SearchCollectionEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.zt  reason: case insensitive filesystem */
public class C2387zt {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Long f12996 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Long f12997 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m13826() {
        Long r2 = Logger.INSTANCE.m142(new C1285());
        if (r2 != null) {
            Logger.INSTANCE.m140(r2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static long m13818(long j, Context context, IClientLogging.ModalView modalView, String str) {
        DeviceUniqueId deviceUniqueId = new DeviceUniqueId();
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_SESSION_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("view", modalView.name());
        intent.putExtra("id", j);
        intent.putExtra("session_id", deviceUniqueId.getValue());
        if (str != null) {
            intent.putExtra("term", str);
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        return deviceUniqueId.getValue();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static long m13811(long j, Context context, IClientLogging.ModalView modalView, String str) {
        if (f12997 != null) {
            Logger.INSTANCE.m140(f12997);
        }
        f12997 = Logger.INSTANCE.m142(new C1080(AppView.searchBox, null));
        DeviceUniqueId deviceUniqueId = new DeviceUniqueId();
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_SESSION_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("view", modalView);
        intent.putExtra("id", j);
        intent.putExtra("session_id", deviceUniqueId.getValue());
        if (str != null) {
            intent.putExtra("term", str);
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        return deviceUniqueId.getValue();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m13816(long j, Context context, long j2) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_SESSION_END");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("id", j);
        intent.putExtra("session_id", j2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m13812(long j, Context context, long j2) {
        if (f12997 != null) {
            Logger.INSTANCE.m140(f12997);
            f12997 = null;
        }
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_SESSION_END");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("id", j);
        intent.putExtra("session_id", j2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m13821(Context context) {
        if (f12996 != null) {
            Logger.INSTANCE.m140(f12996);
        }
        f12996 = Logger.INSTANCE.m142(new C0992());
        DeviceUniqueId deviceUniqueId = new DeviceUniqueId();
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_THROTTLE_SESSION_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("session_id", deviceUniqueId.getValue());
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        return deviceUniqueId.getValue();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m13823(Context context, long j) {
        if (f12996 != null) {
            Logger.INSTANCE.m140(f12996);
            f12996 = null;
        }
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_THROTTLE_SESSION_END");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("session_id", j);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m13817(long j, Context context, IClientLogging.ModalView modalView, String str, ISearchLogging.InputMode inputMode, ISearchLogging.SearchType searchType) {
        m13820(j, context, modalView, str, inputMode, searchType, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m13820(long j, Context context, IClientLogging.ModalView modalView, String str, ISearchLogging.InputMode inputMode, ISearchLogging.SearchType searchType, boolean z) {
        Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C1070(str)));
        Logger.INSTANCE.m137("VoiceInput");
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_EDIT");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("searchType", searchType);
        intent.putExtra("id", j);
        intent.putExtra("query", str);
        intent.putExtra("input_mode", inputMode);
        intent.putExtra("is_prequery", z);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zt$If */
    public static class If implements AbstractC0574 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final String f12999;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final String f13000;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f13001;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f13002;

        If(String str, String str2, String str3, String str4) {
            this.f13001 = str;
            this.f13002 = str2;
            this.f12999 = str3;
            this.f13000 = str4;
        }

        @Override // o.AbstractC0503
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("refId", this.f12999);
                if (!TextUtils.isEmpty(this.f13001)) {
                    jSONObject.put("query", this.f13001);
                }
                if (!TextUtils.isEmpty(this.f13002)) {
                    jSONObject.put("entityId", this.f13002);
                }
                if (!TextUtils.isEmpty(this.f13000)) {
                    jSONObject.put("parentRefId", this.f13000);
                }
            } catch (JSONException e) {
                C1283.m16847("SearchLogUtils", "SearchContextTrackingInfo", e);
            }
            return jSONObject;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static long m13815(AppView appView, String str, String str2, String str3, String str4) {
        AbstractC0675 r2;
        switch (appView) {
            case suggestionResults:
                r2 = new C1199(new If(str2, str, str3, str4));
                break;
            case suggestionTitleResults:
                r2 = new C1159(new If(str2, str, str3, str4));
                break;
            default:
                r2 = new C1196(new If(str2, str, str3, str4));
                break;
        }
        return Logger.INSTANCE.m127(r2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m13813(AppView appView) {
        switch (appView) {
            case suggestionResults:
                Logger.INSTANCE.m128(C1199.class);
                return;
            case suggestionTitleResults:
                Logger.INSTANCE.m128(C1159.class);
                return;
            default:
                Logger.INSTANCE.m128(C1196.class);
                return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zt$if  reason: invalid class name */
    public static class Cif implements AbstractC0574 {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f13009;

        Cif(String str) {
            this.f13009 = str;
        }

        @Override // o.AbstractC0503
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("referenceId", this.f13009);
            } catch (JSONException e) {
                C1283.m16847("SearchLogUtils", "SearchPresentionTrackingInfo", e);
            }
            return jSONObject;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Long m13825(AppView appView, String str) {
        return Logger.INSTANCE.m142(new C1224(new Cif(str), appView));
    }

    /* renamed from: o.zt$iF  reason: case insensitive filesystem */
    public static class C2388iF implements AbstractC0574 {

        /* renamed from: ʼ  reason: contains not printable characters */
        private final int f13003;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f13004;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final String f13005;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final int f13006;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f13007;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f13008;

        public C2388iF(String str, String str2, String str3, int i, int i2, int i3) {
            if (str3 == null && str2 == null) {
                throw new IllegalArgumentException("Either videoId or entityId must not be null");
            }
            this.f13008 = str;
            this.f13005 = str2;
            this.f13007 = str3;
            this.f13004 = i;
            this.f13006 = i2;
            this.f13003 = i3;
        }

        @Override // o.AbstractC0503
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("parentReferenceId", this.f13008);
                if (this.f13005 != null) {
                    jSONObject.put("entityId", this.f13005);
                }
                if (this.f13007 != null) {
                    jSONObject.put("videoId", this.f13007);
                }
                jSONObject.put("trackId", this.f13004);
                jSONObject.put("row", this.f13006);
                jSONObject.put("rank", this.f13003);
            } catch (JSONException e) {
                C1283.m16847("SearchLogUtils", "SearchEntityTrackingInfo", e);
            }
            return jSONObject;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m13824(AppView appView, SearchCollectionEntity searchCollectionEntity, int i, int i2) {
        AppView appView2 = AppView.boxArt;
        if (appView == AppView.suggestionResults) {
            appView2 = AppView.suggestionItem;
        }
        C1300Ac.m3524(false, appView2, new C2388iF(searchCollectionEntity.getReferenceId(), searchCollectionEntity.getEntityId(), null, searchCollectionEntity.getTrackId(), i, i2));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m13814(AppView appView, AbstractC2086qg qgVar, String str, String str2, int i, int i2) {
        AppView appView2 = AppView.boxArt;
        if (appView == AppView.suggestionResults) {
            appView2 = AppView.suggestionItem;
        }
        C1300Ac.m3524(false, appView2, new C2388iF(qgVar.getReferenceId(), str, str2, qgVar.getTrackId(), i, i2));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m13819(long j, Context context, AppView appView, String str, String[] strArr, int i, int i2, AppView appView2) {
        Long r1;
        if (!Logger.INSTANCE.m136() && (r1 = m13825(AppView.titleResults, str)) != null) {
            Logger.INSTANCE.m140(r1);
        }
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_IMPRESSION");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("id", j);
        intent.putExtra("reference", str);
        intent.putExtra(NetflixActivity.EXTRA_FROM, i);
        intent.putExtra("to", i2);
        intent.putExtra("childIds", strArr);
        intent.putExtra("modal_view", appView);
        intent.putExtra("view", appView2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m13822(long j, Context context, AppView appView, String str, String[] strArr, int i, int i2, AppView appView2) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_IMPRESSION");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("id", j);
        intent.putExtra("reference", str);
        intent.putExtra(NetflixActivity.EXTRA_FROM, i);
        intent.putExtra("to", i2);
        intent.putExtra("childIds", strArr);
        intent.putExtra("modal_view", appView);
        intent.putExtra("view", appView2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
