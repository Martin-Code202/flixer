package o;

import android.content.Intent;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import org.json.JSONException;
/* renamed from: o.ae  reason: case insensitive filesystem */
final class C1500ae implements SignInLogging {

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1600cT f6018;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1359Ce f6019;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1597cQ f6020;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1599cS f6021;

    /* renamed from: ॱ  reason: contains not printable characters */
    private K f6022;

    C1500ae(K k) {
        this.f6022 = k;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5597(SignInLogging.SignInType signInType) {
        if (this.f6021 == null) {
            C1283.m16854("nf_log_signin", "SignInRequest session starting...");
            this.f6021 = new C1599cS(signInType);
            this.f6022.mo4786(this.f6021);
            C1283.m16854("nf_log_signin", "SignInRequest session start done.");
        } else {
            C1283.m16850("nf_log_signin", "SignInRequest session already exist!");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m5601(SignInLogging.SignInType signInType, IClientLogging.CompletionReason completionReason, Error error, SignInLogging.CredentialSaved credentialSaved) {
        C1599cS cSVar = this.f6021;
        this.f6021 = null;
        if (cSVar == null) {
            C1283.m16850("nf_log_signin", "SignInRequest session for sign-in type " + signInType + " does NOT exist!");
            return;
        }
        C1283.m16854("nf_log_signin", "SignInRequest session ended");
        C1605cY r4 = cSVar.m5837(completionReason, error, credentialSaved);
        m5591(r4, this.f6019);
        this.f6022.mo4785(cSVar);
        C1283.m16854("nf_log_signin", "SignInRequest session end event posting...");
        this.f6022.mo4783(r4);
        C1283.m16854("nf_log_signin", "SignInRequest session end event posted.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5596(SignInLogging.CredentialService credentialService) {
        if (this.f6020 != null) {
            C1283.m16850("nf_log_signin", "Credential retrieval session already exist!");
            return;
        }
        C1283.m16854("nf_log_signin", "Credential retrieval session starting...");
        C1597cQ cQVar = new C1597cQ(credentialService);
        this.f6022.mo4786(cQVar);
        this.f6020 = cQVar;
        C1283.m16854("nf_log_signin", "Credential retrieval session done.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m5599(IClientLogging.CompletionReason completionReason, Error error) {
        C1597cQ cQVar = this.f6020;
        this.f6020 = null;
        if (cQVar == null) {
            C1283.m16850("nf_log_signin", "CredentialService retrieval session does NOT exist!");
            return;
        }
        C1283.m16854("nf_log_signin", "CredentialService retrieval session ended");
        C1598cR r3 = cQVar.m5836(completionReason, error);
        m5591(r3, this.f6019);
        this.f6022.mo4785(cQVar);
        C1283.m16854("nf_log_signin", "CredentialService retrieval session end event posting...");
        this.f6022.mo4783(r3);
        C1283.m16854("nf_log_signin", "CredentialService retrieval session end event posted.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m5598(SignInLogging.CredentialService credentialService) {
        if (this.f6018 != null) {
            C1283.m16850("nf_log_signin", "Credential store session already exist!");
            return;
        }
        C1283.m16854("nf_log_signin", "Credential store session starting...");
        C1600cT cTVar = new C1600cT(credentialService);
        this.f6022.mo4786(cTVar);
        this.f6018 = cTVar;
        C1283.m16854("nf_log_signin", "Credential store session done.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5595(IClientLogging.CompletionReason completionReason, Error error) {
        C1600cT cTVar = this.f6018;
        this.f6018 = null;
        if (cTVar == null) {
            C1283.m16850("nf_log_signin", "CredentialService store session does NOT exist!");
            return;
        }
        C1283.m16854("nf_log_signin", "CredentialService store session ended");
        C1602cV r3 = cTVar.m5838(completionReason, error);
        m5591(r3, this.f6019);
        this.f6022.mo4785(cTVar);
        C1283.m16854("nf_log_signin", "CredentialService store session end event posting...");
        this.f6022.mo4783(r3);
        C1283.m16854("nf_log_signin", "CredentialService store session end event posted.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m5600() {
        m5601(null, IClientLogging.CompletionReason.canceled, null, null);
        m5595(IClientLogging.CompletionReason.canceled, null);
        m5599(IClientLogging.CompletionReason.canceled, null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5591(Event event, C1359Ce ce) {
        if (event != null) {
            event.setDataContext(ce);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5590(Intent intent) {
        C1283.m16854("nf_log_signin", "SIGNIN_START");
        String stringExtra = intent.getStringExtra("type");
        SignInLogging.SignInType signInType = null;
        if (C1349Bv.m4107(stringExtra)) {
            signInType = SignInLogging.SignInType.valueOf(stringExtra);
        }
        m5597(signInType);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5592(Intent intent) {
        C1283.m16854("nf_log_signin", "SIGNIN_ENDED");
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("type");
        String stringExtra4 = intent.getStringExtra("credSavedState");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log_signin", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        SignInLogging.SignInType signInType = null;
        if (C1349Bv.m4107(stringExtra3)) {
            signInType = SignInLogging.SignInType.valueOf(stringExtra3);
        }
        SignInLogging.CredentialSaved credentialSaved = null;
        if (C1349Bv.m4107(stringExtra4)) {
            credentialSaved = SignInLogging.CredentialSaved.valueOf(stringExtra4);
        }
        m5601(signInType, completionReason, uIError, credentialSaved);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5589(Intent intent) {
        C1283.m16854("nf_log_signin", "CREDENTIAL_RETRIEVAL_START");
        String stringExtra = intent.getStringExtra("credSavedService");
        SignInLogging.CredentialService credentialService = null;
        if (C1349Bv.m4107(stringExtra)) {
            credentialService = SignInLogging.CredentialService.valueOf(stringExtra);
        }
        m5596(credentialService);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5593(Intent intent) {
        C1283.m16854("nf_log_signin", "CREDENTIAL_RETRIEVAL_ENDED");
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log_signin", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5599(completionReason, uIError);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m5594(Intent intent) {
        C1283.m16854("nf_log_signin", "CREDENTIAL_SAVE_START");
        String stringExtra = intent.getStringExtra("credSavedService");
        SignInLogging.CredentialService credentialService = null;
        if (C1349Bv.m4107(stringExtra)) {
            credentialService = SignInLogging.CredentialService.valueOf(stringExtra);
        }
        m5598(credentialService);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m5588(Intent intent) {
        C1283.m16854("nf_log_signin", "CREDENTIAL_SAVE_ENDED");
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log_signin", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5595(completionReason, uIError);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m5602(Intent intent) {
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.LOG_SIGNIN_START".equals(action)) {
            m5590(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SIGNIN_ENDED".equals(action)) {
            m5592(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_RETRIEVAL_START".equals(action)) {
            m5589(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_RETRIEVAL_ENDED".equals(action)) {
            m5593(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_SAVE_START".equals(action)) {
            m5594(intent);
            return true;
        } else if (!"com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_SAVE_ENDED".equals(action)) {
            return false;
        } else {
            m5588(intent);
            return true;
        }
    }
}
