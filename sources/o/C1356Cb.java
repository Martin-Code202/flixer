package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.apm.model.Orientation;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONException;
/* renamed from: o.Cb  reason: case insensitive filesystem */
public final class C1356Cb extends AbstractC1358Cd {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4339(Context context, CustomerServiceLogging.EntryPoint entryPoint) {
        if (!m4349(context, "Context can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_CS_HELP_SESSION_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            if (entryPoint != null) {
                intent.putExtra(NetflixActivity.EXTRA_ENTRY, entryPoint.name());
            }
            LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4338(Context context, CustomerServiceLogging.Action action, String str, IClientLogging.CompletionReason completionReason, Error error) {
        if (!m4349(context, "Context can not be null!") && !m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_CS_HELP_SESSION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (action != null) {
                intent.putExtra("action", action.name());
            }
            if (C1349Bv.m4107(str)) {
                intent.putExtra("url", str);
            }
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4336(Context context, CustomerServiceLogging.Sdk sdk, String str, boolean z) {
        if (!m4349(context, "Context can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_CS_CALL_SESSION_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("uuid", str);
            intent.putExtra("displayed", z);
            intent.putExtra("sdk", sdk.name());
            LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4342(CustomerServiceLogging.TerminationReason terminationReason, IClientLogging.CompletionReason completionReason, Error error) {
        if (!m4349(completionReason, "Reason can not be null!") && !m4349(terminationReason, "Termination reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_CS_CALL_SESSION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("terminationReason", terminationReason.name());
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4340(CustomerServiceLogging.CallQuality callQuality) {
        if (!m4349(callQuality, "Initial call quality can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_CS_CALL_CONNECTED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("call_quality", callQuality.name());
            LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4337(CustomerServiceLogging.Action action) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_CS_CALL_UI_EXIT");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (action != null) {
            intent.putExtra("action", action.name());
        }
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4341(IClientLogging.ModalView modalView, Orientation orientation, CustomerServiceLogging.ReturnToDialScreenFrom returnToDialScreenFrom) {
        if (!m4349(orientation, "Orientation can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_CS_CALL_UI_BACK_TO");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            if (modalView != null) {
                intent.putExtra(NetflixActivity.EXTRA_SOURCE, modalView.name());
            }
            intent.putExtra("orientation", orientation.name());
            if (returnToDialScreenFrom != null) {
                intent.putExtra("using", returnToDialScreenFrom.name());
            }
            LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        }
    }
}
