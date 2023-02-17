package o;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Ci  reason: case insensitive filesystem */
public final class C1363Ci extends AbstractC1358Cd {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4428(SignInLogging.SignInType signInType) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SIGNIN_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (signInType != null) {
            intent.putExtra("type", signInType.name());
        }
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4425(SignInLogging.SignInType signInType, IClientLogging.CompletionReason completionReason, Error error) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SIGNIN_ENDED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (signInType != null) {
            intent.putExtra("type", signInType.name());
        }
        if (completionReason != null) {
            intent.putExtra("reason", completionReason.name());
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

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4431(SignInLogging.CredentialService credentialService) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_RETRIEVAL_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (credentialService != null) {
            intent.putExtra("credSavedService", credentialService.name());
        }
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4427(SignInLogging.CredentialService credentialService, IClientLogging.CompletionReason completionReason, Error error) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_RETRIEVAL_ENDED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (credentialService != null) {
            intent.putExtra("credSavedService", credentialService.name());
        }
        if (completionReason != null) {
            intent.putExtra("reason", completionReason.name());
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

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4426(SignInLogging.CredentialService credentialService) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_SAVE_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (credentialService != null) {
            intent.putExtra("credSavedService", credentialService.name());
        }
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4429(SignInLogging.CredentialService credentialService, IClientLogging.CompletionReason completionReason, Error error) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_SAVE_ENDED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (credentialService != null) {
            intent.putExtra("credSavedService", credentialService.name());
        }
        if (completionReason != null) {
            intent.putExtra("reason", completionReason.name());
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

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Error m4430(Status status) {
        if (status == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        deepErrorElement.setFatal(true);
        deepErrorElement.setErrorCode(String.valueOf(status.getStatusCode()));
        DeepErrorElement.Debug debug = new DeepErrorElement.Debug();
        deepErrorElement.setDebug(debug);
        arrayList.add(deepErrorElement);
        Error error = new Error(RootCause.serverFailure, arrayList);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeepErrorElement.Debug.MESSAGE, status.getStatusMessage());
            jSONObject.put("code", status.getStatusCode());
            debug.setMessage(jSONObject);
        } catch (Throwable th) {
        }
        return error;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Error m4424(int i) {
        ArrayList arrayList = new ArrayList();
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        deepErrorElement.setFatal(true);
        deepErrorElement.setErrorCode(String.valueOf(i));
        DeepErrorElement.Debug debug = new DeepErrorElement.Debug();
        deepErrorElement.setDebug(debug);
        arrayList.add(deepErrorElement);
        Error error = new Error(RootCause.serverFailure, arrayList);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            debug.setMessage(jSONObject);
        } catch (Throwable th) {
        }
        return error;
    }
}
