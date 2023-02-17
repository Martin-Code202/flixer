package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.logging.apm.model.Display;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
public final class BW extends AbstractC1358Cd {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static ApplicationPerformanceMetricsLogging f4628;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static ApplicationPerformanceMetricsLogging m3931() {
        return f4628;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3933(ApplicationPerformanceMetricsLogging applicationPerformanceMetricsLogging) {
        f4628 = applicationPerformanceMetricsLogging;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3936(DiscreteEvent discreteEvent) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report request result");
        } else if (discreteEvent != null) {
            f4628.mo1496(discreteEvent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3939(C1626cr crVar) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable");
        } else if (crVar != null) {
            f4628.mo1483(crVar);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3934(C1626cr crVar) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable");
        } else if (crVar != null) {
            f4628.mo1494(crVar);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3944(String str, AssetType assetType, String str2) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report asset request result");
        } else if (!C1349Bv.m4113(str)) {
            f4628.mo1495(str, assetType, str2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3937(String str, VolleyError volleyError) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report asset request result");
        } else if (!C1349Bv.m4113(str)) {
            f4628.mo1489(str, IClientLogging.CompletionReason.failed, null, m4346(volleyError, str), null);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3938(String str, StatusCode statusCode, String str2) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report asset request result");
        } else if (!C1349Bv.m4113(str)) {
            IClientLogging.CompletionReason completionReason = IClientLogging.CompletionReason.failed;
            Error r8 = m4352(statusCode, str);
            if (r8 == null) {
                completionReason = IClientLogging.CompletionReason.success;
            }
            f4628.mo1489(str, completionReason, null, r8, str2);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3942(IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_APM_UI_MODAL_VIEW_CHANGED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3943(String str, long j) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_APM_PREAPP_ADD_WIDGET");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("widgetData", str);
        intent.putExtra("eventTime", j);
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3930(String str, long j) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_APM_PREAPP_DELETE_WIDGET");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("widgetData", str);
        intent.putExtra("eventTime", j);
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3929(String str) {
        if (!m4349(str, "UUID can not be null")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_APM_DATA_SHARED_CONTEXT_SESSION_STARTED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("uuid", str);
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3941(ApplicationPerformanceMetricsLogging.Trigger trigger) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report request result");
        } else {
            f4628.mo1486(trigger);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3935(boolean z, boolean z2) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report request result");
        } else {
            f4628.mo1498(z, z2);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3940(Context context) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report request result");
        } else {
            f4628.mo1493(context);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3946(boolean z, IClientLogging.ModalView modalView, long j) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report request result");
        } else {
            f4628.mo1484(z, modalView, j);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3928(ApplicationPerformanceMetricsLogging.UiStartupTrigger uiStartupTrigger, IClientLogging.ModalView modalView, Long l, Display display, C1487aS aSVar, C1491aV aVVar) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report request result");
        } else {
            f4628.mo1487(uiStartupTrigger, modalView, l, display, aSVar, aVVar);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3945(long j) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report request result");
        } else {
            f4628.mo1492(j);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3932(long j, boolean z, UIError uIError) {
        if (f4628 == null) {
            C1283.m16850("nf_log", "sApm is unavailable, can not report request result");
        } else {
            f4628.mo1485(j, z, uIError);
        }
    }
}
