package o;

import android.content.Intent;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.apm.model.Orientation;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONException;
class D implements CustomerServiceLogging {

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1570bs f5243;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1573bv f5244;

    /* renamed from: ˏ  reason: contains not printable characters */
    private K f5245;

    D(K k) {
        this.f5245 = k;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4573(CustomerServiceLogging.EntryPoint entryPoint) {
        C1283.m16854("nf_log_cs", "Help session start started");
        if (this.f5243 != null) {
            C1283.m16865("nf_log_cs", "Help session existed before! It should not happen!");
            return;
        }
        this.f5243 = new C1570bs(entryPoint);
        this.f5245.mo4786(this.f5243);
        C1283.m16854("nf_log_cs", "Help session start done.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4571(CustomerServiceLogging.Action action, String str, IClientLogging.CompletionReason completionReason, Error error) {
        if (this.f5243 != null) {
            C1283.m16854("nf_log_cs", "Help session end started");
            if (!(action == null || !action.equals(CustomerServiceLogging.Action.chat) || this.f5243 == null)) {
                str = str + C1349Bv.m4116("clSessionId", String.valueOf(this.f5243.mo5776().getId().getValue()), "&");
            }
            this.f5245.mo4783(this.f5243.m5797(action, str, completionReason, error));
            this.f5245.mo4785(this.f5243);
            this.f5243 = null;
            C1283.m16854("nf_log_cs", "help session end done.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4570(String str, CustomerServiceLogging.Sdk sdk, boolean z) {
        C1283.m16854("nf_log_cs", "Call session start started");
        if (this.f5244 != null) {
            C1283.m16865("nf_log_cs", "Call session existed before! It should not happen!");
            return;
        }
        this.f5244 = new C1573bv(str, sdk, z);
        this.f5245.mo4786(this.f5244);
        C1283.m16854("nf_log_cs", "Call session start done.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m4576(CustomerServiceLogging.TerminationReason terminationReason, IClientLogging.CompletionReason completionReason, Error error) {
        if (this.f5244 != null) {
            C1283.m16854("nf_log_cs", "Call session end started");
            this.f5245.mo4783(this.f5244.m5800(terminationReason, completionReason, error));
            this.f5245.mo4785(this.f5244);
            this.f5244 = null;
            C1283.m16854("nf_log_cs", "Call session end done.");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4572(CustomerServiceLogging.CallQuality callQuality) {
        if (this.f5244 != null) {
            C1283.m16854("nf_log_cs", "Call session exist, call connected");
            this.f5244.m5803(callQuality);
            return;
        }
        C1283.m16850("nf_log_cs", "Call session does NOT exist, and call connected API is called...");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4569(CustomerServiceLogging.CallQuality callQuality) {
        if (this.f5244 != null) {
            C1283.m16854("nf_log_cs", "Call session exist, change its quality");
            this.f5244.m5799(callQuality);
            return;
        }
        C1283.m16850("nf_log_cs", "Call session does NOT exist, and change call quality API is called...");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m4577(IClientLogging.ModalView modalView, Orientation orientation, CustomerServiceLogging.ReturnToDialScreenFrom returnToDialScreenFrom) {
        this.f5245.mo4783(new C1572bu(modalView, orientation, returnToDialScreenFrom));
        C1283.m16854("nf_log_cs", "Back to dial screen event posted.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m4574(CustomerServiceLogging.Action action) {
        this.f5245.mo4783(new C1575bx(action));
        C1283.m16854("nf_log_cs", "Dial screen dismissed event posted.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m4579() {
        m4576(CustomerServiceLogging.TerminationReason.canceledByUserAfterConnected, IClientLogging.CompletionReason.canceled, (Error) null);
        m4571(null, null, IClientLogging.CompletionReason.canceled, null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m4575() {
        if (this.f5243 != null) {
            return String.valueOf(this.f5243.mo5776().getId().getValue());
        }
        return "";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4578(Intent intent) {
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.LOG_CS_HELP_SESSION_START".equals(action)) {
            C1283.m16854("nf_log_cs", "HELP_SESSION_START");
            String stringExtra = intent.getStringExtra(NetflixActivity.EXTRA_ENTRY);
            CustomerServiceLogging.EntryPoint entryPoint = null;
            if (C1349Bv.m4107(stringExtra)) {
                entryPoint = CustomerServiceLogging.EntryPoint.valueOf(stringExtra);
            }
            m4573(entryPoint);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_CS_HELP_SESSION_ENDED".equals(action)) {
            C1283.m16854("nf_log_cs", "HELP_SESSION_ENDED");
            CustomerServiceLogging.Action valueOf = CustomerServiceLogging.Action.valueOf(intent.getStringExtra("action"));
            IClientLogging.CompletionReason valueOf2 = IClientLogging.CompletionReason.valueOf(intent.getStringExtra("reason"));
            UIError uIError = null;
            try {
                uIError = Error.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
            } catch (JSONException e) {
                C1283.m16847("nf_log_cs", "Failure to create Error", e);
            }
            m4571(valueOf, intent.getStringExtra("url"), valueOf2, uIError);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_CS_CALL_SESSION_START".equals(action)) {
            C1283.m16854("nf_log_cs", "CALL_SESSION_START");
            m4570(intent.getStringExtra("uuid"), CustomerServiceLogging.Sdk.valueOf(intent.getStringExtra("sdk")), intent.getBooleanExtra("displayed", false));
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_CS_CALL_SESSION_ENDED".equals(action)) {
            C1283.m16854("nf_log_cs", "CALL_SESSION_ENDED");
            IClientLogging.CompletionReason valueOf3 = IClientLogging.CompletionReason.valueOf(intent.getStringExtra("reason"));
            CustomerServiceLogging.TerminationReason valueOf4 = CustomerServiceLogging.TerminationReason.valueOf(intent.getStringExtra("terminationReason"));
            UIError uIError2 = null;
            try {
                uIError2 = Error.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
            } catch (JSONException e2) {
                C1283.m16847("nf_log_cs", "Failure to create Error", e2);
            }
            m4576(valueOf4, valueOf3, uIError2);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_CS_CALL_CONNECTED".equals(action)) {
            C1283.m16854("nf_log_cs", "CALL_CONNECTED");
            m4572(CustomerServiceLogging.CallQuality.valueOf(intent.getStringExtra("call_quality")));
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_CS_CALL_SESSION_QUALITY_CHANGED".equals(action)) {
            C1283.m16854("nf_log_cs", "CALL_SESSION_QUALITY_CHANGED");
            m4569(CustomerServiceLogging.CallQuality.valueOf(intent.getStringExtra("call_quality")));
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_CS_CALL_UI_EXIT".equals(action)) {
            C1283.m16854("nf_log_cs", "CALL_UI_EXIT");
            String stringExtra2 = intent.getStringExtra("action");
            CustomerServiceLogging.Action action2 = null;
            if (C1349Bv.m4107(stringExtra2)) {
                action2 = CustomerServiceLogging.Action.valueOf(stringExtra2);
            }
            m4574(action2);
            return true;
        } else if (!"com.netflix.mediaclient.intent.action.LOG_CS_CALL_UI_BACK_TO".equals(action)) {
            return false;
        } else {
            C1283.m16854("nf_log_cs", "CALL_UI_BACK_TO");
            String stringExtra3 = intent.getStringExtra(NetflixActivity.EXTRA_SOURCE);
            IClientLogging.ModalView modalView = null;
            if (C1349Bv.m4107(stringExtra3)) {
                modalView = IClientLogging.ModalView.valueOf(stringExtra3);
            }
            String stringExtra4 = intent.getStringExtra("using");
            CustomerServiceLogging.ReturnToDialScreenFrom returnToDialScreenFrom = null;
            if (C1349Bv.m4107(stringExtra4)) {
                returnToDialScreenFrom = CustomerServiceLogging.ReturnToDialScreenFrom.valueOf(stringExtra4);
            }
            String stringExtra5 = intent.getStringExtra("orientation");
            Orientation orientation = null;
            if (C1349Bv.m4107(stringExtra5)) {
                orientation = Orientation.valueOf(stringExtra5);
            }
            m4577(modalView, orientation, returnToDialScreenFrom);
            return true;
        }
    }
}
