package o;

import android.content.Intent;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import java.util.HashMap;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ac  reason: case insensitive filesystem */
public final class C1498ac implements UIViewLogging {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1734eu f6000;

    /* renamed from: ʼ  reason: contains not printable characters */
    private C1359Ce f6001;

    /* renamed from: ʽ  reason: contains not printable characters */
    private HashMap<IClientLogging.ModalView, C1731er> f6002 = new HashMap<>();

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6003;

    /* renamed from: ˋ  reason: contains not printable characters */
    private K f6004;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1734eu f6005;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Stack<C1734eu> f6006 = new Stack<>();

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1732es f6007;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1733et f6008;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Stack<C1734eu> f6009 = new Stack<>();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1732es f6010;

    public C1498ac(K k) {
        this.f6004 = k;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5563(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, CommandEndedEvent.InputMethod inputMethod, CommandEndedEvent.InputValue inputValue, C1359Ce ce, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.f6007 != null) {
            C1283.m16850("nf_log", "uiView command session already started!");
            return;
        }
        C1283.m16854("nf_log", "uiView command session starting...");
        C1732es esVar = new C1732es(uIViewCommandName, modalView, str, inputMethod, inputValue, jSONObject, jSONObject2);
        this.f6004.mo4786(esVar);
        this.f6007 = esVar;
        this.f6001 = ce;
        this.f6003 = str;
        C1283.m16854("nf_log", "uiView command session start done.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5560() {
        if (this.f6007 != null) {
            C1283.m16854("nf_log", "uiView command session ended");
            CommandEndedEvent r2 = this.f6007.m6344();
            if (r2 == null) {
                C1283.m16854("nf_log", "uiView command session still waits on session id, do not post at this time.");
                return;
            }
            m5549(r2, this.f6001, this.f6007.m6340());
            this.f6004.mo4785(this.f6007);
            C1283.m16854("nf_log", "uiView command session end event posting...");
            this.f6004.mo4783(r2);
            this.f6007 = null;
            C1283.m16854("nf_log", "uiView command session end event posted.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m5567(Intent intent, boolean z) {
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.LOG_UIVIEW_CMD_START".equals(action)) {
            C1283.m16854("nf_log", "COMMAND_START");
            m5544(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIVIEW_CMD_ENDED".equals(action)) {
            C1283.m16854("nf_log", "COMMAND_ENDED");
            m5557(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_LEFT_PANEL_VIEW_CMD_START".equals(action)) {
            C1283.m16854("nf_log", "LEFT_PANEL_VIEW_COMMAND_START");
            m5545(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_LEFT_PANEL_VIEW_CMD_ENDED".equals(action)) {
            C1283.m16854("nf_log", "LEFT_PANEL_VIEW_COMMAND_ENDED");
            m5547(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_LEFT_PANEL_VIEW_IMPRESSION_START".equals(action)) {
            C1283.m16854("nf_log", "LEFT_PANEL_VIEW_IMPRESSION_START");
            m5553(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_LEFT_PANEL_VIEW_IMPRESSION_ENDED".equals(action)) {
            C1283.m16854("nf_log", "LEFT_PANEL_VIEW_IMPRESSION_ENDED");
            m5550(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_NOTIFICATION_IMPRESSION_START".equals(action)) {
            C1283.m16854("nf_log", "NOTIFICATION_IMPRESSION_START");
            m5554(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_NOTIFICATION_IMPRESSION_ENDED".equals(action)) {
            C1283.m16854("nf_log", "NOTIFICATION_IMPRESSION_ENDED");
            m5556(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_IKO_NOTIFICATION_IMPRESSION_START".equals(action)) {
            C1283.m16854("nf_log", "IKO_NOTIFICATION_IMPRESSION_START");
            m5559(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_IKO_NOTIFICATION_IMPRESSION_ENDED".equals(action)) {
            C1283.m16854("nf_log", "IKO_NOTIFICATION_IMPRESSION_ENDED");
            m5543(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIVIEW_IMPRESSION".equals(action)) {
            C1283.m16854("nf_log", "IMPRESSION");
            m5558(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIVIEW_IMPRESSION_SESSION_STARTED".equals(action)) {
            C1283.m16854("nf_log", "IMPRESSION_SESSION_STARTED");
            m5555(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIVIEW_IMPRESSION_SESSION_ENDED".equals(action)) {
            C1283.m16854("nf_log", "IMPRESSION_SESSION_ENDED");
            m5548(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIVIEW_MDL_VW_START".equals(action)) {
            C1283.m16854("nf_log", "MODAL_VIEW_START");
            m5551(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIVIEW_MDL_VW_ENDED".equals(action)) {
            C1283.m16854("nf_log", "MODAL_VIEW_ENDED");
            m5542(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIVIEW_FOCUS_START".equals(action)) {
            C1283.m16854("nf_log", "FOCUS_START");
            m5552(intent);
            return true;
        } else if (!"com.netflix.mediaclient.intent.action.LOG_UIVIEW_FOCUS_ENDED".equals(action)) {
            return false;
        } else {
            C1283.m16854("nf_log", "FOCUS_ENDED");
            m5546(intent);
            return true;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5555(Intent intent) {
        String stringExtra = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra);
        }
        m5570(modalView, intent.getStringExtra("guid"));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5548(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(FalkorPathResult.SUCCESS, false);
        UIError uIError = null;
        try {
            uIError = Error.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
        }
        m5564(booleanExtra, uIError);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5552(Intent intent) {
        String stringExtra = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra);
        }
        m5561(modalView, null, intent.getStringExtra("trackingInfo"));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5546(Intent intent) {
        String stringExtra = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("trackingInfo");
        intent.getBooleanExtra("isModalView", true);
        m5569(modalView, stringExtra2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5551(Intent intent) {
        String stringExtra = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra);
        }
        m5565(modalView, intent.getStringExtra("trackingInfo"));
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m5542(Intent intent) {
        String stringExtra = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra);
        }
        m5566(modalView, intent.getStringExtra("trackingInfo"), intent.getBooleanExtra("isModalView", true));
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m5558(Intent intent) {
        int intExtra = intent.getIntExtra("trackId", 0);
        String stringExtra = intent.getStringExtra("cmd");
        UIViewLogging.UIViewCommandName uIViewCommandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            uIViewCommandName = UIViewLogging.UIViewCommandName.valueOf(stringExtra);
        }
        m5562(uIViewCommandName, intExtra);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m5544(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UIViewLogging.UIViewCommandName uIViewCommandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            uIViewCommandName = UIViewLogging.UIViewCommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("inputMethod");
        CommandEndedEvent.InputMethod inputMethod = null;
        if (!C1349Bv.m4113(stringExtra3)) {
            inputMethod = CommandEndedEvent.InputMethod.valueOf(stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("inputValue");
        CommandEndedEvent.InputValue inputValue = CommandEndedEvent.InputValue.tap;
        if (!C1349Bv.m4113(stringExtra4)) {
            inputValue = CommandEndedEvent.InputValue.valueOf(stringExtra4);
        }
        C1359Ce ce = null;
        String stringExtra5 = intent.getStringExtra(Event.DATA_CONTEXT);
        if (C1349Bv.m4107(stringExtra5)) {
            try {
                ce = C1359Ce.m4360(new JSONObject(stringExtra5));
            } catch (JSONException e) {
                C1283.m16865("nf_log", "failed to create dataContext: " + stringExtra5);
            }
        }
        String stringExtra6 = intent.getStringExtra("url");
        JSONObject jSONObject = null;
        if (intent.hasExtra(Device.MODEL)) {
            try {
                jSONObject = new JSONObject(intent.getStringExtra(Device.MODEL));
            } catch (JSONException e2) {
            }
        }
        JSONObject jSONObject2 = null;
        if (intent.hasExtra(Event.DATA)) {
            try {
                jSONObject2 = new JSONObject(intent.getStringExtra(Event.DATA));
            } catch (JSONException e3) {
            }
        }
        m5563(uIViewCommandName, modalView, inputMethod, inputValue, ce, stringExtra6, jSONObject, jSONObject2);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m5557(Intent intent) {
        m5560();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m5545(Intent intent) {
        if (this.f6010 != null) {
            C1283.m16850("nf_log", "LeftPanelCommandSession command session already started!");
            return;
        }
        C1283.m16854("nf_log", "LeftPanelCommandSession command session starting...");
        this.f6010 = new C1732es(UIViewLogging.UIViewCommandName.viewMenu, null, null, CommandEndedEvent.InputValue.valueOf(intent.getStringExtra("inputValue")), null);
        this.f6004.mo4786(this.f6010);
        C1283.m16854("nf_log", "LeftPanelCommandSession command session start done.");
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m5547(Intent intent) {
        if (this.f6010 != null) {
            C1283.m16854("nf_log", "LeftPanelCommandSession command session ended");
            CommandEndedEvent r2 = this.f6010.m6344();
            if (r2 == null) {
                C1283.m16854("nf_log", "LeftPanelCommandSession command session still waits on session id, do not post at this time.");
                return;
            }
            m5549(r2, this.f6001, this.f6010.m6340());
            this.f6004.mo4785(this.f6010);
            C1283.m16854("nf_log", "LeftPanelCommandSession command session end event posting...");
            this.f6004.mo4783(r2);
            this.f6010 = null;
            C1283.m16854("nf_log", "LeftPanelCommandSession command session end event posted.");
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m5553(Intent intent) {
        if (this.f6000 != null) {
            C1283.m16850("nf_log", "LeftPanelImpressionStart impression session already started!");
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(intent.getStringExtra(Device.MODEL));
        } catch (JSONException e) {
        }
        C1283.m16854("nf_log", "LeftPanelImpressionStart impression session starting...");
        this.f6000 = new C1734eu(IClientLogging.ModalView.menuPanel, intent.getStringExtra("guid"), jSONObject);
        this.f6004.mo4786(this.f6000);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m5550(Intent intent) {
        if (this.f6000 != null) {
            boolean booleanExtra = intent.getBooleanExtra(FalkorPathResult.SUCCESS, false);
            C1283.m16854("nf_log", "LeftPanelImpressionEnd impression session ended");
            C1737ex r3 = this.f6000.m6347(booleanExtra, null);
            m5549(r3, this.f6001, this.f6000.m6340());
            this.f6004.mo4785(this.f6000);
            C1283.m16854("nf_log", "LeftPanelImpressionEnd impression session end event posting...");
            this.f6004.mo4783(r3);
            this.f6000 = null;
            C1283.m16854("nf_log", "LeftPanelImpressionEnd impression session end event posted.");
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m5554(Intent intent) {
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(intent.getStringExtra(Device.MODEL));
        } catch (JSONException e) {
        }
        C1283.m16854("nf_log", "NotificationImpressionStart impression session starting...");
        C1734eu euVar = new C1734eu(IClientLogging.ModalView.notification, intent.getStringExtra("guid"), jSONObject);
        this.f6009.push(euVar);
        this.f6004.mo4786(euVar);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m5556(Intent intent) {
        if (this.f6009.size() != 0) {
            boolean booleanExtra = intent.getBooleanExtra(FalkorPathResult.SUCCESS, false);
            C1283.m16854("nf_log", "NotificationImpressionEnd impression session ended");
            C1734eu pop = this.f6009.pop();
            C1737ex r4 = pop.m6347(booleanExtra, null);
            m5549(r4, this.f6001, pop.m6340());
            this.f6004.mo4785(pop);
            C1283.m16854("nf_log", "NotificationImpressionEnd impression session end event posting...");
            this.f6004.mo4783(r4);
            C1283.m16854("nf_log", "NotificationImpressionEnd impression session end event posted.");
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m5559(Intent intent) {
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(intent.getStringExtra(Device.MODEL));
        } catch (JSONException e) {
        }
        C1283.m16854("nf_log", "IkoNotificationImpressionStart impression session starting...");
        C1734eu euVar = new C1734eu(IClientLogging.ModalView.ikoNotification, intent.getStringExtra("guid"), jSONObject);
        this.f6006.push(euVar);
        this.f6004.mo4786(euVar);
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m5543(Intent intent) {
        if (this.f6006.size() != 0) {
            boolean booleanExtra = intent.getBooleanExtra(FalkorPathResult.SUCCESS, false);
            C1283.m16854("nf_log", "IkoNotificationImpressionEnd impression session ended");
            C1734eu pop = this.f6006.pop();
            C1737ex r4 = pop.m6347(booleanExtra, null);
            m5549(r4, this.f6001, pop.m6340());
            this.f6004.mo4785(pop);
            C1283.m16854("nf_log", "IkoNotificationImpressionEnd impression session end event posting...");
            this.f6004.mo4783(r4);
            C1283.m16854("nf_log", "IkoNotificationImpressionEnd impression session end event posted.");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5549(Event event, C1359Ce ce, IClientLogging.ModalView modalView) {
        if (event != null) {
            event.setDataContext(ce);
            event.setModalView(modalView);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5562(UIViewLogging.UIViewCommandName uIViewCommandName, int i) {
        C1738ey eyVar = new C1738ey(uIViewCommandName, i);
        m5549(eyVar, this.f6001, null);
        this.f6004.mo4783(eyVar);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m5570(IClientLogging.ModalView modalView, String str) {
        if (this.f6005 != null) {
            C1283.m16850("nf_log", "uiView impression session already started!");
            return;
        }
        C1283.m16854("nf_log", "uiView impression session starting...");
        C1734eu euVar = new C1734eu(modalView, str);
        this.f6004.mo4786(euVar);
        this.f6005 = euVar;
        C1283.m16854("nf_log", "uiView impression session start done.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5564(boolean z, Error error) {
        if (this.f6005 != null) {
            C1283.m16854("nf_log", "uiView impression session ended");
            C1737ex r2 = this.f6005.m6347(z, error);
            m5549(r2, this.f6001, this.f6005.m6340());
            this.f6004.mo4785(this.f6005);
            C1283.m16854("nf_log", "uiView impression session end event posting...");
            this.f6004.mo4783(r2);
            this.f6005 = null;
            C1283.m16854("nf_log", "uiView impression session end event posted.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5561(IClientLogging.ModalView modalView, String str, String str2) {
        C1283.m16854("nf_log", "uiView focus session starting...");
        C1733et etVar = new C1733et(modalView);
        C1688eA r3 = etVar.m6345(str);
        C1359Ce ce = null;
        if (C1349Bv.m4107(str2)) {
            ce = new C1359Ce();
            ce.m4364(str2);
        }
        m5549(r3, ce, etVar.m6340());
        C1283.m16854("nf_log", "uiView focus session start event posting...");
        this.f6004.mo4783(r3);
        this.f6004.mo4786(etVar);
        this.f6008 = etVar;
        C1283.m16854("nf_log", "uiView focus session start done.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m5569(IClientLogging.ModalView modalView, String str) {
        if (this.f6008 != null) {
            C1283.m16854("nf_log", "uiView focus session ended");
            C1739ez r2 = this.f6008.m6346();
            C1359Ce ce = null;
            if (C1349Bv.m4107(str)) {
                ce = new C1359Ce();
                ce.m4364(str);
            }
            m5549(r2, ce, this.f6008.m6340());
            this.f6004.mo4785(this.f6008);
            C1283.m16854("nf_log", "uiView focus session end event posting...");
            this.f6004.mo4783(r2);
            this.f6008 = null;
            C1283.m16854("nf_log", "uiView focus session end event posted.");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m5565(IClientLogging.ModalView modalView, String str) {
        if (this.f6002.get(modalView) != null) {
            C1283.m16850("nf_log", "uiView modalView session already started!");
            return;
        }
        C1283.m16854("nf_log", "uiView modalView session starting...");
        C1731er erVar = new C1731er(modalView);
        C1691eD r3 = erVar.m6341();
        C1359Ce ce = null;
        if (C1349Bv.m4107(str)) {
            ce = new C1359Ce();
            ce.m4364(str);
        }
        m5549(r3, ce, erVar.m6340());
        C1283.m16854("nf_log", "uiView modalView session start event posting...");
        this.f6004.mo4783(r3);
        this.f6004.mo4786(erVar);
        this.f6002.put(modalView, erVar);
        C1283.m16854("nf_log", "uiView modalView session start done.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m5566(IClientLogging.ModalView modalView, String str, boolean z) {
        C1731er erVar = this.f6002.get(modalView);
        if (erVar != null) {
            C1283.m16854("nf_log", "uiView modalView session ended");
            this.f6002.remove(modalView);
            C1736ew r3 = erVar.m6342(z);
            C1359Ce ce = null;
            if (C1349Bv.m4107(str)) {
                ce = new C1359Ce();
                ce.m4364(str);
            }
            m5549(r3, ce, erVar.m6340());
            this.f6004.mo4785(erVar);
            C1283.m16854("nf_log", "uiView modalView session end event posting...");
            this.f6004.mo4783(r3);
            C1283.m16854("nf_log", "uiView modalView session end event posted.");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5568() {
        m5560();
        m5564(true, (Error) null);
    }
}
