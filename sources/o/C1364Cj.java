package o;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Cj  reason: case insensitive filesystem */
public final class C1364Cj extends AbstractC1358Cd {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String f5158 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int f5159 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4436(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, C1359Ce ce, String str) {
        m4437(uIViewCommandName, modalView, ce, str, (JSONObject) null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4437(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, C1359Ce ce, String str, JSONObject jSONObject) {
        m4451(uIViewCommandName, modalView, null, null, ce, str, jSONObject, null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4451(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, CommandEndedEvent.InputMethod inputMethod, CommandEndedEvent.InputValue inputValue, C1359Ce ce, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIVIEW_CMD_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (modalView != null) {
            intent.putExtra("view", modalView.name());
        }
        if (inputMethod != null) {
            intent.putExtra("inputMethod", inputMethod.name());
        }
        if (inputValue != null) {
            intent.putExtra("inputValue", inputValue.name());
        }
        if (uIViewCommandName != null) {
            intent.putExtra("cmd", uIViewCommandName.name());
        }
        if (ce != null) {
            String str2 = null;
            try {
                str2 = ce.toJSONObject().toString();
            } catch (JSONException e) {
                C1283.m16865("nf_log", "failed to create dataContext: " + ce.toString());
            }
            intent.putExtra(Event.DATA_CONTEXT, str2);
        }
        if (C1349Bv.m4107(str)) {
            intent.putExtra("url", str);
        }
        if (jSONObject != null) {
            intent.putExtra(Device.MODEL, jSONObject.toString());
        }
        if (jSONObject2 != null) {
            intent.putExtra(Event.DATA, jSONObject2.toString());
        }
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4432() {
        m4449(null, null, null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4449(IClientLogging.ModalView modalView, CommandEndedEvent.InputMethod inputMethod, CommandEndedEvent.InputValue inputValue) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIVIEW_CMD_ENDED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (modalView != null) {
            intent.putExtra("view", modalView.name());
        }
        if (inputMethod != null) {
            intent.putExtra("inputMethod", inputMethod.name());
        }
        if (inputValue != null) {
            intent.putExtra("inputValue", inputValue.name());
        }
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4453(CommandEndedEvent.InputValue inputValue) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_LEFT_PANEL_VIEW_CMD_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("inputValue", inputValue.name());
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4439() {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_LEFT_PANEL_VIEW_CMD_ENDED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4435(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, CommandEndedEvent.InputMethod inputMethod, CommandEndedEvent.InputValue inputValue, C1359Ce ce) {
        m4451(uIViewCommandName, modalView, inputMethod, inputValue, ce, null, null, null);
        m4449(modalView, inputMethod, inputValue);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4454(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, CommandEndedEvent.InputMethod inputMethod, CommandEndedEvent.InputValue inputValue, JSONObject jSONObject) {
        m4451(uIViewCommandName, modalView, inputMethod, inputValue, null, null, null, jSONObject);
        m4449(modalView, inputMethod, inputValue);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4434(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, CommandEndedEvent.InputMethod inputMethod, CommandEndedEvent.InputValue inputValue) {
        m4451(uIViewCommandName, modalView, inputMethod, inputValue, null, null, null, null);
        m4449(modalView, inputMethod, inputValue);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4441(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, CommandEndedEvent.InputMethod inputMethod, CommandEndedEvent.InputValue inputValue, JSONObject jSONObject) {
        m4451(uIViewCommandName, modalView, inputMethod, inputValue, null, null, null, jSONObject);
        m4432();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4442(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, C1359Ce ce) {
        m4443(uIViewCommandName, modalView, ce, null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4443(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, C1359Ce ce, String str) {
        m4436(uIViewCommandName, modalView, ce, str);
        m4432();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4440(IClientLogging.ModalView modalView, String str) {
        if (!m4349((Object) modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIVIEW_MDL_VW_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            intent.putExtra("trackingInfo", str);
            LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4448(IClientLogging.ModalView modalView, boolean z, String str) {
        if (!m4349((Object) modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIVIEW_MDL_VW_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            intent.putExtra("isModalView", z);
            intent.putExtra("trackingInfo", str);
            LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4447(IClientLogging.ModalView modalView, String str) {
        m4433(modalView, str);
        m4450(modalView, str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4433(IClientLogging.ModalView modalView, String str) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIVIEW_FOCUS_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("view", modalView.name());
        intent.putExtra("trackingInfo", str);
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4450(IClientLogging.ModalView modalView, String str) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIVIEW_FOCUS_ENDED");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intent.putExtra("view", modalView.name());
        intent.putExtra("trackingInfo", str);
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4452(JSONObject jSONObject) {
        m4444("com.netflix.mediaclient.intent.action.LOG_LEFT_PANEL_VIEW_IMPRESSION_START", (Boolean) null, jSONObject);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4446(boolean z) {
        m4444("com.netflix.mediaclient.intent.action.LOG_LEFT_PANEL_VIEW_IMPRESSION_ENDED", Boolean.valueOf(z), (JSONObject) null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4445(JSONObject jSONObject) {
        m4444("com.netflix.mediaclient.intent.action.LOG_NOTIFICATION_IMPRESSION_START", (Boolean) null, jSONObject);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4438(boolean z) {
        m4444("com.netflix.mediaclient.intent.action.LOG_NOTIFICATION_IMPRESSION_ENDED", Boolean.valueOf(z), (JSONObject) null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m4444(String str, Boolean bool, JSONObject jSONObject) {
        Intent intent = new Intent(str);
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (bool != null) {
            intent.putExtra(FalkorPathResult.SUCCESS, bool);
        }
        if (jSONObject != null) {
            intent.putExtra(Device.MODEL, jSONObject.toString());
        }
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
    }
}
