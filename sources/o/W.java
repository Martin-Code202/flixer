package o;

import android.content.Intent;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.ISearchLogging;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
public class W implements ISearchLogging {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Map<Long, AbstractC1523az> f5848 = new Hashtable();

    /* renamed from: ˋ  reason: contains not printable characters */
    private Map<Long, AbstractC1523az> f5849 = new Hashtable();

    /* renamed from: ˏ  reason: contains not printable characters */
    private K f5850;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Map<Long, AbstractC1523az> f5851 = new Hashtable();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private UserAgentInterface f5852;

    W(K k, UserAgentInterface userAgentInterface) {
        this.f5850 = k;
        this.f5852 = userAgentInterface;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m5316(Intent intent) {
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_SESSION_START".equals(action)) {
            m5321(intent);
            C1283.m16854("nf_log_search", "SEARCH_SESSION_START");
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_SESSION_END".equals(action)) {
            m5318(intent);
            C1283.m16854("nf_log_search", "SEARCH_SESSION_END");
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_SESSION_START".equals(action)) {
            m5320(intent);
            C1283.m16854("nf_log_search", "SEARCH_FOCUS_SESSION_START");
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_SESSION_END".equals(action)) {
            m5315(intent);
            C1283.m16854("nf_log_search", "SEARCH_FOCUS_SESSION_END");
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_THROTTLE_SESSION_START".equals(action)) {
            m5322(intent);
            C1283.m16854("nf_log_search", "SEARCH_THROTTLE_SESSION_START");
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SUS_SEARCH_THROTTLE_SESSION_END".equals(action)) {
            m5314(intent);
            C1283.m16854("nf_log_search", "SEARCH_THROTTLE_SESSION_END");
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_EDIT".equals(action)) {
            m5312(intent);
            C1283.m16854("nf_log_search", "SEARCH_EDIT");
            return true;
        } else if (!"com.netflix.mediaclient.intent.action.LOG_SUS_FOCUS_SEARCH_IMPRESSION".equals(action)) {
            return false;
        } else {
            m5313(intent);
            C1283.m16854("nf_log_search", "SEARCH_IMPRESSION");
            return true;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m5321(Intent intent) {
        if (this.f5850 != null) {
            long longExtra = intent.getLongExtra("session_id", 0);
            if (longExtra != 0) {
                C1585cG cGVar = new C1585cG(longExtra);
                this.f5848.put(Long.valueOf(longExtra), cGVar);
                this.f5850.mo4786(cGVar);
                this.f5850.mo4783(cGVar.m5820());
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m5318(Intent intent) {
        m5310(intent.getLongExtra("session_id", 0));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5310(long j) {
        C1585cG cGVar;
        if (this.f5850 != null && j != 0 && (cGVar = (C1585cG) this.f5848.get(Long.valueOf(j))) != null) {
            this.f5850.mo4785(cGVar);
            this.f5850.mo4783(cGVar.m5819());
            this.f5848.remove(Long.valueOf(j));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m5320(Intent intent) {
        if (this.f5850 != null) {
            long longExtra = intent.getLongExtra("session_id", 0);
            if (longExtra != 0) {
                C1587cI cIVar = new C1587cI(longExtra);
                this.f5851.put(Long.valueOf(longExtra), cIVar);
                this.f5850.mo4786(cIVar);
                this.f5850.mo4783(cIVar.m5823(m5308(intent.getStringExtra("term"))));
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m5308(String str) {
        if (C1349Bv.m4113(str)) {
            C1283.m16865("nf_log_search", "Query is empty, skip privacy check");
            return str;
        } else if (this.f5852 == null) {
            C1283.m16850("nf_log_search", "User agent is NULL, this should NOT happen, we can not check for privacy violation!");
            return null;
        } else if (!this.f5852.mo1327(str)) {
            return str;
        } else {
            C1283.m16865("nf_log_search", "Security violation found, do NOT log query");
            return "PRIVACY_VIOLATION";
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m5315(Intent intent) {
        m5311(intent.getLongExtra("session_id", 0));
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public synchronized void m5322(Intent intent) {
        if (this.f5850 != null) {
            long longExtra = intent.getLongExtra("session_id", 0);
            if (longExtra != 0) {
                C1586cH cHVar = new C1586cH(longExtra);
                this.f5849.put(Long.valueOf(longExtra), cHVar);
                this.f5850.mo4786(cHVar);
                this.f5850.mo4783(cHVar.m5822());
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public synchronized void m5314(Intent intent) {
        m5319(intent.getLongExtra("session_id", 0));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m5319(long j) {
        if (this.f5850 != null && j != 0) {
            C1586cH cHVar = (C1586cH) this.f5849.get(Long.valueOf(j));
            if (cHVar != null) {
                this.f5850.mo4785(cHVar);
                this.f5850.mo4783(cHVar.m5821());
                this.f5849.remove(Long.valueOf(j));
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private synchronized void m5311(long j) {
        if (this.f5850 != null && j != 0) {
            C1587cI cIVar = (C1587cI) this.f5851.get(Long.valueOf(j));
            if (cIVar != null) {
                this.f5850.mo4785(cIVar);
                this.f5850.mo4783(cIVar.m5824());
                this.f5851.remove(Long.valueOf(j));
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m5312(Intent intent) {
        ISearchLogging.InputMode inputMode;
        if (this.f5850 != null) {
            String r2 = m5308(intent.getStringExtra("query"));
            if (intent.hasExtra("input_mode")) {
                inputMode = (ISearchLogging.InputMode) intent.getSerializableExtra("input_mode");
            } else {
                inputMode = ISearchLogging.InputMode.keyboard;
            }
            this.f5850.mo4783(new C1584cF(r2, inputMode, (ISearchLogging.SearchType) intent.getSerializableExtra("searchType"), intent.getBooleanExtra("is_prequery", false)));
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m5313(Intent intent) {
        if (this.f5850 != null) {
            int intExtra = intent.getIntExtra(NetflixActivity.EXTRA_FROM, 0);
            int intExtra2 = intent.getIntExtra("to", 0);
            String stringExtra = intent.getStringExtra("reference");
            IClientLogging.ModalView r10 = m5309((AppView) intent.getSerializableExtra("view"));
            String[] stringArrayExtra = intent.getStringArrayExtra("childIds");
            IClientLogging.ModalView modalView = null;
            if (intent.hasExtra("modal_view")) {
                modalView = m5309((AppView) intent.getSerializableExtra("modal_view"));
            }
            this.f5850.mo4783(new C1590cL(stringExtra, intExtra, intExtra2, stringArrayExtra, modalView, r10));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m5317() {
        HashSet<Long> hashSet = new HashSet(this.f5849.size());
        hashSet.addAll(this.f5849.keySet());
        for (Long l : hashSet) {
            m5319(l.longValue());
        }
        HashSet<Long> hashSet2 = new HashSet(this.f5851.size());
        hashSet2.addAll(this.f5851.keySet());
        for (Long l2 : hashSet2) {
            m5311(l2.longValue());
        }
        HashSet<Long> hashSet3 = new HashSet(this.f5848.size());
        hashSet3.addAll(this.f5848.keySet());
        for (Long l3 : hashSet3) {
            m5310(l3.longValue());
        }
        this.f5851.clear();
        this.f5848.clear();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static IClientLogging.ModalView m5309(AppView appView) {
        if (appView == null) {
            return null;
        }
        try {
            return IClientLogging.ModalView.valueOf(appView.toString());
        } catch (IllegalArgumentException e) {
            C1276.m16820().mo5730(e);
            return null;
        }
    }
}
