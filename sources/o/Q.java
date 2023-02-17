package o;

import android.content.Intent;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
final class Q implements R {

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1359Ce f5799;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Map<String, C1548bW> f5800 = new HashMap();

    /* renamed from: ˋ  reason: contains not printable characters */
    private Map<String, C1545bT> f5801 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    private K f5802;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Map<String, C1551bZ> f5803 = new HashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1549bX f5804;

    Q(K k) {
        this.f5802 = k;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5240() {
        m5244(null, IClientLogging.CompletionReason.canceled, null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5234(Event event, IClientLogging.ModalView modalView) {
        if (event != null) {
            event.setDataContext(this.f5799);
            event.setModalView(modalView);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5249(C1359Ce ce) {
        this.f5799 = ce;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m5246(String str, UserActionLogging.CommandName commandName) {
        if (str != null) {
            C1283.m16851("nf_log_offline", "Add cached video session started with oxid %s", str);
            if (this.f5801.get(str) != null) {
                C1283.m16865("nf_log_offline", "AddCachedVideoSession session already exist! You can not start it!");
                return;
            }
            C1283.m16854("nf_log_offline", "AddCachedVideoSession session created");
            C1545bT bTVar = new C1545bT(str, commandName);
            this.f5801.put(str, bTVar);
            this.f5802.mo4786(bTVar);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m5242(String str, IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (str != null) {
            C1283.m16851("nf_log_offline", "Add cached video session ends with oxid %s", str);
            C1545bT remove = this.f5801.remove(str);
            if (remove == null) {
                C1283.m16865("nf_log_offline", "endAddCachedVideoSession:: AddCachedVideoSession session does NOT exist! This should NOT happen!");
                return;
            }
            C1283.m16854("nf_log_offline", "AddCachedVideoSession session ended");
            C1550bY r5 = remove.m5762(completionReason, uIError, modalView);
            m5234(r5, modalView);
            this.f5802.mo4783(r5);
            this.f5802.mo4785(remove);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m5250(String str, UserActionLogging.CommandName commandName) {
        if (str == null) {
            throw new IllegalArgumentException("OXID can not be null!");
        }
        C1283.m16851("nf_log_offline", "Remove cached video session started with oxid %s", str);
        if (this.f5803.get(str) != null) {
            C1283.m16865("nf_log_offline", "RemoveCachedVideoSession session already exist! You can not start it!");
            return;
        }
        C1283.m16854("nf_log_offline", "RemoveCachedVideoSession session created");
        C1551bZ bZVar = new C1551bZ(str, commandName);
        this.f5803.put(str, bZVar);
        this.f5802.mo4786(bZVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m5247(String str, IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (str != null) {
            C1283.m16851("nf_log_offline", "Remove cached video session ends with oxid %s", str);
            C1551bZ remove = this.f5803.remove(str);
            if (remove == null) {
                C1283.m16865("nf_log_offline", "endRemoveCachedVideoSession:: RemoveCachedVideoSession session does NOT exist! This should NOT happen!");
                return;
            }
            C1283.m16854("nf_log_offline", "AddCachedVideoSession session ended");
            C1611ce r5 = remove.m5774(completionReason, uIError, modalView);
            m5234(r5, modalView);
            this.f5802.mo4783(r5);
            this.f5802.mo4785(remove);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m5245(UserActionLogging.CommandName commandName, String str, String str2, int i, int i2, int i3) {
        if (str != null) {
            C1283.m16851("nf_log_offline", "Start cached play session with oxid %s", str);
            if (this.f5804 != null) {
                C1283.m16865("nf_log_offline", "Cached playback session exist, cancel it!");
                m5244(null, IClientLogging.CompletionReason.canceled, null);
            }
            C1549bX bXVar = new C1549bX(commandName, null);
            this.f5804 = bXVar;
            this.f5802.mo4786(bXVar);
            C1609cc r7 = bXVar.m5773(str, str2, i, i2, i3);
            m5234(r7, null);
            this.f5802.mo4783(r7);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m5244(IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1283.m16854("nf_log_offline", "End cached play session");
        if (this.f5804 == null) {
            C1283.m16865("nf_log_offline", "Cached playback session Does NOT exist!");
            return;
        }
        C1610cd r2 = this.f5804.m5772(completionReason, uIError, modalView);
        m5234(r2, modalView);
        this.f5802.mo4783(r2);
        this.f5802.mo4785(this.f5804);
        this.f5804 = null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m5248(String str, UserActionLogging.CommandName commandName) {
        if (str != null) {
            C1283.m16851("nf_log_offline", "Start download session with dxid %s", str);
            if (this.f5800.get(str) != null) {
                C1283.m16865("nf_log_offline", "startDownloadSession:: DownloadSession session already exist! You can not start it!");
                return;
            }
            C1283.m16854("nf_log_offline", "DownloadSession session created");
            C1548bW bWVar = new C1548bW(commandName, null);
            this.f5800.put(str, bWVar);
            this.f5802.mo4786(bWVar);
            C1608cb r5 = bWVar.m5771(str);
            m5234(r5, null);
            this.f5802.mo4783(r5);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5241(String str, IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (str != null) {
            C1283.m16851("nf_log_offline", "Download session ends with dxid %s", str);
            C1548bW remove = this.f5800.remove(str);
            if (remove == null) {
                C1283.m16854("nf_log_offline", "endDownloadSession:: DownloadSession session does NOT exist! Recreate it, but do NOT post start event!");
                remove = new C1548bW(null, null);
                this.f5802.mo4786(remove);
            }
            C1283.m16854("nf_log_offline", "Download session ended");
            C1612cf r5 = remove.m5770(completionReason, uIError, modalView);
            m5234(r5, modalView);
            this.f5802.mo4783(r5);
            this.f5802.mo4785(remove);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m5243(Intent intent) {
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.LOG_OFFLINE_ADD_CACHED_VIDEO_SESSION_STARTED".equals(action)) {
            m5239(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_OFFLINE_ADD_CACHED_VIDEO_SESSION_ENDED".equals(action)) {
            m5231(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_OFFLINE_REMOVE_CACHED_VIDEO_SESSION_STARTED".equals(action)) {
            m5232(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_OFFLINE_REMOVE_CACHED_VIDEO_SESSION_ENDED".equals(action)) {
            m5238(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_OFFLINE_DOWNLOAD_SESSION_STARTED".equals(action)) {
            m5236(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_OFFLINE_DOWNLOAD_SESSION_ENDED".equals(action)) {
            m5233(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_OFFLINE_CACHED_PLAY_SESSION_STARTED".equals(action)) {
            m5235(intent);
            return true;
        } else if (!"com.netflix.mediaclient.intent.action.LOG_OFFLINE_CACHED_PLAY_SESSION_ENDED".equals(action)) {
            return false;
        } else {
            m5237(intent);
            return true;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5235(Intent intent) {
        C1283.m16854("nf_log_offline", "CACHED_PLAYBACK_START");
        String stringExtra = intent.getStringExtra("oxid");
        String stringExtra2 = intent.getStringExtra("videoid");
        int intExtra = intent.getIntExtra("runtime", 0);
        int intExtra2 = intent.getIntExtra("logicalStart", 0);
        int intExtra3 = intent.getIntExtra("logicalEnd", 0);
        String stringExtra3 = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra3)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra3);
        }
        m5245(commandName, stringExtra, stringExtra2, intExtra, intExtra2, intExtra3);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5237(Intent intent) {
        C1283.m16854("nf_log_offline", "CACHED_PLAYBACK_END");
        String stringExtra = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("reason");
        String stringExtra3 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        intent.getStringExtra("surveyType");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra3);
        } catch (JSONException e) {
            C1283.m16847("nf_log_offline", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra2)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra2);
        }
        m5244(modalView, completionReason, uIError);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5236(Intent intent) {
        C1283.m16854("nf_log_offline", "DOWNLOAD_START");
        String stringExtra = intent.getStringExtra("dxid");
        String stringExtra2 = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra2)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra2);
        }
        m5248(stringExtra, commandName);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5233(Intent intent) {
        C1283.m16854("nf_log_offline", "DOWNLOAD_END");
        String stringExtra = intent.getStringExtra("dxid");
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("reason");
        String stringExtra4 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        intent.getStringExtra("surveyType");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra4);
        } catch (JSONException e) {
            C1283.m16847("nf_log_offline", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra3)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra3);
        }
        m5241(stringExtra, modalView, completionReason, uIError);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m5232(Intent intent) {
        C1283.m16854("nf_log_offline", "REMOVE_CACHED_VIDEO_SESSION_START");
        String stringExtra = intent.getStringExtra("oxid");
        String stringExtra2 = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra2)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra2);
        }
        m5250(stringExtra, commandName);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m5238(Intent intent) {
        C1283.m16854("nf_log_offline", "REMOVE_CACHED_VIDEO_SESSION_END");
        String stringExtra = intent.getStringExtra("oxid");
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("reason");
        String stringExtra4 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        intent.getStringExtra("surveyType");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra4);
        } catch (JSONException e) {
            C1283.m16847("nf_log_offline", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra3)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra3);
        }
        m5247(stringExtra, modalView, completionReason, uIError);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m5239(Intent intent) {
        C1283.m16854("nf_log_offline", "ADD_CACHED_VIDEO_SESSION_START");
        String stringExtra = intent.getStringExtra("oxid");
        String stringExtra2 = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra2)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra2);
        }
        m5246(stringExtra, commandName);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m5231(Intent intent) {
        C1283.m16854("nf_log_offline", "ADD_CACHED_VIDEO_SESSION_END");
        String stringExtra = intent.getStringExtra("oxid");
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("reason");
        String stringExtra4 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        intent.getStringExtra("surveyType");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra4);
        } catch (JSONException e) {
            C1283.m16847("nf_log_offline", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra3)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra3);
        }
        m5242(stringExtra, modalView, completionReason, uIError);
    }
}
