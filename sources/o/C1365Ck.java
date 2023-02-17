package o;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONException;
/* renamed from: o.Ck  reason: case insensitive filesystem */
public final class C1365Ck extends AbstractC1358Cd {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4456(String str) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_OFFLINE_ADD_CACHED_VIDEO_SESSION_STARTED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("oxid", str);
        intent.putExtra("cmd", UserActionLogging.CommandName.AddCachedVideoCommand.name());
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4461(String str, IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, Error error) {
        if (!m4349(completionReason, "Reason can not be null!") && !m4349(str, "OXID can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_OFFLINE_ADD_CACHED_VIDEO_SESSION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("oxid", str);
            if (modalView != null) {
                intent.putExtra("view", modalView.name());
            }
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4460(String str) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_OFFLINE_REMOVE_CACHED_VIDEO_SESSION_STARTED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("oxid", str);
        intent.putExtra("cmd", UserActionLogging.CommandName.RemoveCachedVideoCommand.name());
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4455(String str, IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, Error error) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_OFFLINE_REMOVE_CACHED_VIDEO_SESSION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("oxid", str);
            if (modalView != null) {
                intent.putExtra("view", modalView.name());
            }
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4457(String str, boolean z) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_OFFLINE_DOWNLOAD_SESSION_STARTED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("dxid", str);
        if (z) {
            intent.putExtra("cmd", UserActionLogging.CommandName.RetryDownloadCommand.name());
        } else {
            intent.putExtra("cmd", UserActionLogging.CommandName.ResumeDownloadCommand.name());
        }
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4458(String str, IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, Error error) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_OFFLINE_DOWNLOAD_SESSION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("dxid", str);
            if (modalView != null) {
                intent.putExtra("view", modalView.name());
            }
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4462(String str, String str2, int i, int i2, int i3) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_OFFLINE_CACHED_PLAY_SESSION_STARTED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("oxid", str);
        intent.putExtra("videoid", str2);
        intent.putExtra("runtime", i);
        intent.putExtra("logicalStart", i2);
        intent.putExtra("logicalEnd", i3);
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4459(IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, Error error) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_OFFLINE_CACHED_PLAY_SESSION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (modalView != null) {
                intent.putExtra("view", modalView.name());
            }
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }
}
