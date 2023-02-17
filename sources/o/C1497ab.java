package o;

import android.content.Intent;
import com.netflix.mediaclient.service.logging.client.model.CustomEvent;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogActionData;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogData;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ab  reason: case insensitive filesystem */
final class C1497ab implements UserActionLogging {

    /* renamed from: ˌ  reason: contains not printable characters */
    private static final HashSet<IClientLogging.ModalView> f5967 = new HashSet<>(Arrays.asList(IClientLogging.ModalView.movieDetails));

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1636dA f5968;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private C1677dq f5969;

    /* renamed from: ʼ  reason: contains not printable characters */
    private C1654dS f5970;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private C1648dM f5971;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1680dt f5972;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private C1644dI f5973;

    /* renamed from: ʾ  reason: contains not printable characters */
    private C1521ax f5974;

    /* renamed from: ʿ  reason: contains not printable characters */
    private C1683dw f5975;

    /* renamed from: ˈ  reason: contains not printable characters */
    private C1685dy f5976;

    /* renamed from: ˉ  reason: contains not printable characters */
    private C1643dH f5977;

    /* renamed from: ˊ  reason: contains not printable characters */
    private K f5978;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private C1686dz f5979;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private C1638dC f5980;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C1646dK f5981;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private C1641dF f5982;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1674dm f5983;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private C1676dp f5984;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1647dL f5985;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private Map<Long, C1640dE> f5986 = new ConcurrentHashMap(5);

    /* renamed from: ˍ  reason: contains not printable characters */
    private UserAgentInterface f5987;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private C1681du f5988;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1678dr f5989;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1639dD f5990;

    /* renamed from: ͺ  reason: contains not printable characters */
    private C1645dJ f5991;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1359Ce f5992;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1642dG f5993;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private C1682dv f5994;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private C1520aw f5995;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1684dx f5996;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private Cdo f5997;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1637dB f5998;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private C1514as f5999;

    C1497ab(K k, UserAgentInterface userAgentInterface) {
        this.f5978 = k;
        this.f5987 = userAgentInterface;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5502(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5983 != null) {
            C1283.m16850("nf_log", "AcknowledgeSignup session already started!");
            return;
        }
        C1283.m16854("nf_log", "AcknowledgeSignup session starting...");
        C1674dm dmVar = new C1674dm(commandName, modalView);
        this.f5978.mo4786(dmVar);
        this.f5983 = dmVar;
        C1283.m16854("nf_log", "AcknowledgeSignup session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5526(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        if (this.f5983 != null) {
            C1283.m16854("nf_log", "User session ended");
            C1651dP r2 = this.f5983.m6016(completionReason, uIError, modalView);
            if (r2 == null) {
                C1283.m16854("nf_log", "AcknowledgeSignup session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, modalView);
            this.f5978.mo4785(this.f5983);
            C1283.m16854("nf_log", "AcknowledgeSignup session end event posting...");
            this.f5978.mo4783(r2);
            this.f5983 = null;
            C1283.m16854("nf_log", "AcknowledgeSignup session end event posted.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5489(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5989 != null) {
            C1283.m16850("nf_log", "AddToPlaylist session already started!");
            return;
        }
        C1283.m16854("nf_log", "AddToPlaylist session starting...");
        C1678dr drVar = new C1678dr(commandName, modalView);
        this.f5978.mo4786(drVar);
        this.f5989 = drVar;
        C1283.m16854("nf_log", "AddToPlaylist session start done.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5496(IClientLogging.CompletionReason completionReason, UIError uIError, int i) {
        if (this.f5989 != null) {
            C1283.m16854("nf_log", "AddToPlaylist session ended");
            C1650dO r2 = this.f5989.m6020(completionReason, uIError, i);
            if (r2 == null) {
                C1283.m16854("nf_log", "AddToPlaylist session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5989.m6021());
            this.f5978.mo4785(this.f5989);
            C1283.m16854("nf_log", "AddToPlaylist session end event posting...");
            this.f5978.mo4783(r2);
            this.f5989 = null;
            C1283.m16854("nf_log", "AddToPlaylist session end event posted.");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5517(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5973 != null) {
            C1283.m16850("nf_log", "SurveySession session already started!");
            return;
        }
        C1283.m16854("nf_log", "SurveySession session starting...");
        C1644dI dIVar = new C1644dI(commandName, modalView);
        this.f5978.mo4786(dIVar);
        this.f5973 = dIVar;
        C1283.m16854("nf_log", "SurveySession session start done.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5487(IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        if (this.f5973 != null) {
            C1283.m16854("nf_log", "SurveySession session ended");
            C1727en r2 = this.f5973.m6004(completionReason, uIError, str);
            if (r2 == null) {
                C1283.m16854("nf_log", "SurveySession session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5973.m6021());
            this.f5978.mo4785(this.f5973);
            C1283.m16854("nf_log", "SurveySession session end event posting...");
            this.f5978.mo4783(r2);
            this.f5973 = null;
            C1283.m16854("nf_log", "SurveySession session end event posted.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5508(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5971 != null) {
            C1283.m16850("nf_log", "SurveyQuestionSession session already started!");
            return;
        }
        C1283.m16854("nf_log", "SurveyQuestionSession session starting...");
        C1648dM dMVar = new C1648dM(commandName, modalView);
        this.f5978.mo4786(dMVar);
        this.f5971 = dMVar;
        C1283.m16854("nf_log", "SurveyQuestionSession session start done.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5515(IClientLogging.CompletionReason completionReason, UIError uIError, String str, String str2) {
        if (this.f5971 != null) {
            C1283.m16854("nf_log", "SurveyQuestionSession session ended");
            C1726em r2 = this.f5971.m6008(completionReason, uIError, str, str2);
            if (r2 == null) {
                C1283.m16854("nf_log", "SurveyQuestionSession session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5971.m6021());
            this.f5978.mo4785(this.f5971);
            C1283.m16854("nf_log", "SurveyQuestionSession session end event posting...");
            this.f5978.mo4783(r2);
            this.f5971 = null;
            C1283.m16854("nf_log", "SurveyQuestionSession session end event posted.");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5533(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5970 != null) {
            C1283.m16850("nf_log", "changeValue session already started!");
            return;
        }
        C1283.m16854("nf_log", "changeValue session starting...");
        C1654dS dSVar = new C1654dS(commandName, modalView);
        this.f5978.mo4786(dSVar);
        this.f5970 = dSVar;
        C1283.m16854("nf_log", "changeValue session start done.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5514(IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        if (this.f5970 != null) {
            C1283.m16854("nf_log", "changeValue session ended");
            C1652dQ r2 = this.f5970.m6009(completionReason, uIError, str);
            if (r2 == null) {
                C1283.m16854("nf_log", "ChangeValue session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5970.m6021());
            this.f5978.mo4785(this.f5970);
            C1283.m16854("nf_log", "changeValue session end event posting...");
            this.f5978.mo4783(r2);
            this.f5970 = null;
            C1283.m16854("nf_log", "changeValue session end event posted.");
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m5484(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5996 != null) {
            C1283.m16850("nf_log", "Login session already started!");
            return;
        }
        C1283.m16854("nf_log", "Login session starting...");
        C1684dx dxVar = new C1684dx(commandName, modalView);
        this.f5978.mo4786(dxVar);
        this.f5996 = dxVar;
        C1283.m16854("nf_log", "Login session start done.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5505(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (this.f5996 != null) {
            C1283.m16854("nf_log", "Login session ended");
            C1660dY r2 = this.f5996.m6028(completionReason, uIError);
            if (r2 == null) {
                C1283.m16854("nf_log", "Login session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5996.m6021());
            this.f5978.mo4785(this.f5996);
            C1283.m16854("nf_log", "Login session end event posting...");
            this.f5978.mo4783(r2);
            this.f5996 = null;
            C1283.m16854("nf_log", "Login session end event posted.");
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m5482(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5972 != null) {
            C1283.m16854("nf_log", "Navigation session existed before, overwrite");
            this.f5978.mo4785(this.f5972);
        } else {
            C1283.m16854("nf_log", "Navigation session starting...");
        }
        C1680dt dtVar = new C1680dt(commandName, modalView);
        this.f5978.mo4786(dtVar);
        this.f5972 = dtVar;
        C1283.m16854("nf_log", "Navigation session start done.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5501(IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1680dt dtVar = this.f5972;
        if (dtVar != null) {
            if (f5967.contains(this.f5972.m6021())) {
                if (dtVar.m6024() == null) {
                    dtVar.m6022(modalView);
                    return;
                } else if (this.f5972.m6021() != modalView) {
                    dtVar.m6022(modalView);
                }
            }
            C1283.m16854("nf_log", "Navigation session ended");
            C1715eb r3 = dtVar.m6023(modalView, completionReason, uIError);
            if (r3 == null) {
                C1283.m16854("nf_log", "We stayed in same view, cancel session.");
            } else {
                C1283.m16854("nf_log", "Navigation session end event posting...");
                m5447(r3, this.f5992, this.f5972.m6021());
                this.f5978.mo4783(r3);
                C1283.m16854("nf_log", "Navigation session end event posted.");
            }
            this.f5978.mo4785(dtVar);
            this.f5972 = null;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m5480(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5998 != null) {
            C1283.m16850("nf_log", "RateTitle session already started!");
            return;
        }
        C1283.m16854("nf_log", "RateTitle session starting...");
        C1637dB dBVar = new C1637dB(commandName, modalView);
        this.f5978.mo4786(dBVar);
        this.f5998 = dBVar;
        C1283.m16854("nf_log", "RateTitle session start done.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5498(IClientLogging.CompletionReason completionReason, UIError uIError, Integer num, int i, String str, int i2, boolean z) {
        if (this.f5998 != null) {
            C1283.m16854("nf_log", "RateTitle  session ended");
            C1720eg r8 = this.f5998.m5997(completionReason, uIError, num, i, str, i2, z);
            if (r8 == null) {
                C1283.m16854("nf_log", "RateTitle  session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r8, this.f5992, this.f5998.m6021());
            this.f5978.mo4785(this.f5998);
            C1283.m16854("nf_log", "RateTitle session end event posting...");
            this.f5978.mo4783(r8);
            this.f5998 = null;
            C1283.m16854("nf_log", "RateTitle session end event posted.");
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m5538(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5968 != null) {
            C1283.m16850("nf_log", "Register session already started!");
            return;
        }
        C1283.m16854("nf_log", "Register session starting...");
        C1636dA dAVar = new C1636dA(commandName, modalView);
        this.f5978.mo4786(dAVar);
        this.f5968 = dAVar;
        C1283.m16854("nf_log", "Register session start done.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5495(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (this.f5968 != null) {
            C1283.m16854("nf_log", "Register session ended");
            C1719ef r2 = this.f5968.m5996(completionReason, uIError);
            if (r2 == null) {
                C1283.m16854("nf_log", "Register session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5968.m6021());
            this.f5978.mo4785(this.f5968);
            C1283.m16854("nf_log", "Register session end event posting...");
            this.f5978.mo4783(r2);
            this.f5968 = null;
            C1283.m16854("nf_log", "Register session end event posted.");
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m5540(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5990 != null) {
            C1283.m16850("nf_log", "RemoveFromPlaylist session already started!");
            return;
        }
        C1283.m16854("nf_log", "RemoveFromPlaylist session starting...");
        C1639dD dDVar = new C1639dD(commandName, modalView);
        this.f5978.mo4786(dDVar);
        this.f5990 = dDVar;
        C1283.m16854("nf_log", "RemoveFromPlaylist session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5524(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (this.f5990 != null) {
            C1283.m16854("nf_log", "RemoveFromPlaylist session ended");
            C1716ec r2 = this.f5990.m5999(completionReason, uIError);
            if (r2 == null) {
                C1283.m16854("nf_log", "RemoveFromPlaylist session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5990.m6021());
            this.f5978.mo4785(this.f5990);
            C1283.m16854("nf_log", "RemoveFromPlaylist session end event posting...");
            this.f5978.mo4783(r2);
            this.f5990 = null;
            C1283.m16854("nf_log", "RemoveFromPlaylist session end event posted.");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m5512(long j, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, String str) {
        C1283.m16854("nf_log", "Search session starting...");
        C1640dE dEVar = new C1640dE(j, commandName, modalView, m5442(str));
        this.f5978.mo4786(dEVar);
        this.f5986.put(Long.valueOf(j), dEVar);
        C1283.m16854("nf_log", "Search session start done.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m5442(String str) {
        if (C1349Bv.m4113(str)) {
            C1283.m16865("nf_log", "Query is empty, skip privacy check");
            return str;
        } else if (this.f5987 == null) {
            C1283.m16850("nf_log", "User agent is NULL, this should NOT happen, we can not check for privacy violation!");
            return null;
        } else if (!this.f5987.mo1327(str)) {
            return str;
        } else {
            C1283.m16865("nf_log", "Security violation found, do NOT log query");
            return "PRIVACY_VIOLATION";
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m5494(long j, IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1640dE dEVar = this.f5986.get(Long.valueOf(j));
        if (dEVar != null) {
            C1283.m16854("nf_log", "Search session ended");
            C1724ek r3 = dEVar.m6000(completionReason, uIError);
            if (r3 == null) {
                C1283.m16854("nf_log", "Search session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r3, this.f5992, dEVar.m6021());
            this.f5978.mo4785(dEVar);
            C1283.m16854("nf_log", "Search session end event posting...");
            this.f5978.mo4783(r3);
            C1283.m16854("nf_log", "Search session end event posted.");
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m5536(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5991 != null) {
            C1283.m16850("nf_log", "StartPlay session already started!");
            return;
        }
        C1283.m16854("nf_log", "StartPlay session starting...");
        C1645dJ dJVar = new C1645dJ(commandName, modalView);
        this.f5978.mo4786(dJVar);
        this.f5991 = dJVar;
        C1283.m16854("nf_log", "StartPlay session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5528(IClientLogging.CompletionReason completionReason, UIError uIError, Integer num, PlayLocationType playLocationType) {
        if (this.f5991 != null) {
            C1283.m16854("nf_log", "StartPlay session ended");
            C1721eh r2 = this.f5991.m6005(completionReason, uIError, num, playLocationType);
            if (r2 == null) {
                C1283.m16854("nf_log", "StartPlay session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5991.m6021());
            this.f5978.mo4785(this.f5991);
            C1283.m16854("nf_log", "StartPlay session end event posting...");
            this.f5978.mo4783(r2);
            this.f5991 = null;
            C1283.m16854("nf_log", "StartPlay session end event posted.");
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m5521(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5981 != null) {
            C1283.m16850("nf_log", "SubmitPayment session already started!");
            return;
        }
        C1283.m16854("nf_log", "SubmitPayment session starting...");
        C1646dK dKVar = new C1646dK(commandName, modalView);
        this.f5978.mo4786(dKVar);
        this.f5981 = dKVar;
        C1283.m16854("nf_log", "SubmitPayment session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5529(IClientLogging.CompletionReason completionReason, UIError uIError, boolean z, UserActionLogging.PaymentType paymentType, JSONObject jSONObject) {
        if (this.f5981 != null) {
            C1283.m16854("nf_log", "SubmitPayment session ended");
            C1728eo r6 = this.f5981.m6006(completionReason, uIError, z, paymentType, jSONObject);
            if (r6 == null) {
                C1283.m16854("nf_log", "SubmitPayment session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r6, this.f5992, this.f5981.m6021());
            this.f5978.mo4785(this.f5981);
            C1283.m16854("nf_log", "SubmitPayment session end event posting...");
            this.f5978.mo4783(r6);
            this.f5981 = null;
            C1283.m16854("nf_log", "SubmitPayment session end event posted.");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5535(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, UserActionLogging.Streams streams) {
        if (this.f5985 != null) {
            C1283.m16850("nf_log", "UpgradeStreams session already started!");
            return;
        }
        C1283.m16854("nf_log", "UpgradeStreams session starting...");
        C1647dL dLVar = new C1647dL(commandName, modalView, streams);
        this.f5978.mo4786(dLVar);
        this.f5985 = dLVar;
        C1283.m16854("nf_log", "UpgradeStreams session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5527(IClientLogging.CompletionReason completionReason, UIError uIError, UserActionLogging.Streams streams) {
        if (this.f5985 != null) {
            C1283.m16854("nf_log", "UpgradeStreams session ended");
            C1729ep r2 = this.f5985.m6007(completionReason, uIError, streams);
            if (r2 == null) {
                C1283.m16854("nf_log", "User session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5985.m6021());
            this.f5978.mo4785(this.f5985);
            C1283.m16854("nf_log", "UpgradeStreams session end event posting...");
            this.f5978.mo4783(r2);
            this.f5985 = null;
            C1283.m16854("nf_log", "UpgradeStreams session end event posted.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5511(String str, UserActionLogging.RememberProfile rememberProfile, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5993 != null) {
            C1283.m16850("nf_log", "Select profile session already started!");
            return;
        }
        C1283.m16854("nf_log", "Select profile session starting...");
        C1642dG dGVar = new C1642dG(str, rememberProfile, commandName, modalView);
        this.f5978.mo4786(dGVar);
        this.f5993 = dGVar;
        C1283.m16854("nf_log", "Select profile session start done.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5506(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError) {
        if (this.f5993 != null) {
            C1283.m16854("nf_log", "Select profile session ended");
            C1723ej r2 = this.f5993.m6002(completionReason, uIError, modalView);
            if (r2 == null) {
                C1283.m16854("nf_log", "Select profile session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5993.m6021());
            this.f5978.mo4785(this.f5993);
            C1283.m16854("nf_log", "Select profile session end event posting...");
            this.f5978.mo4783(r2);
            this.f5993 = null;
            C1283.m16854("nf_log", "Select profile session end event posted.");
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m5493(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5997 != null) {
            C1283.m16850("nf_log", "Add profile session already started!");
            return;
        }
        C1283.m16854("nf_log", "Add profile session starting...");
        Cdo doVar = new Cdo(commandName, modalView);
        this.f5978.mo4786(doVar);
        this.f5997 = doVar;
        C1283.m16854("nf_log", "Add profile session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5531(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError, UserActionLogging.C0029 r7) {
        if (this.f5997 != null) {
            C1283.m16854("nf_log", "Add profile session ended");
            C1649dN r2 = this.f5997.m6017(completionReason, uIError, modalView, r7);
            if (r2 == null) {
                C1283.m16854("nf_log", "Add profile session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5997.m6021());
            this.f5978.mo4785(this.f5997);
            C1283.m16854("nf_log", "Add profile session end event posting...");
            this.f5978.mo4783(r2);
            this.f5997 = null;
            C1283.m16854("nf_log", "Add profile session end event posted.");
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m5522(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5994 != null) {
            C1283.m16850("nf_log", "Edit profile session already started!");
            return;
        }
        C1283.m16854("nf_log", "Edit profile session starting...");
        C1682dv dvVar = new C1682dv(commandName, modalView);
        this.f5978.mo4786(dvVar);
        this.f5994 = dvVar;
        C1283.m16854("nf_log", "Edit profile session start done.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5500(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError, UserActionLogging.C0029 r7) {
        if (this.f5994 != null) {
            C1283.m16854("nf_log", "Edit profile session ended");
            C1658dW r2 = this.f5994.m6026(completionReason, uIError, modalView, r7);
            if (r2 == null) {
                C1283.m16854("nf_log", "Edit profile session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5994.m6021());
            this.f5978.mo4785(this.f5994);
            C1283.m16854("nf_log", "Edit profile session end event posting...");
            this.f5978.mo4783(r2);
            this.f5994 = null;
            C1283.m16854("nf_log", "Edit profile session end event posted.");
            C1283.m16854("nf_log", "Edit profile session end done.");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5518(String str, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5969 != null) {
            C1283.m16850("nf_log", "Delete profile session already started!");
            return;
        }
        C1283.m16854("nf_log", "Delete profile session starting...");
        C1677dq dqVar = new C1677dq(str, commandName, modalView);
        this.f5978.mo4786(dqVar);
        this.f5969 = dqVar;
        C1283.m16854("nf_log", "Delete profile session start done.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5499(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError) {
        if (this.f5969 != null) {
            C1283.m16854("nf_log", "Delete profile session ended");
            C1657dV r2 = this.f5969.m6019(completionReason, uIError, modalView);
            if (r2 == null) {
                C1283.m16854("nf_log", "Delete profile session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5969.m6021());
            this.f5978.mo4785(this.f5969);
            C1283.m16854("nf_log", "Delete profile session end event posting...");
            this.f5978.mo4783(r2);
            this.f5969 = null;
            C1283.m16854("nf_log", "Delete profile session end event posted.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5490(String str, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5995 != null) {
            C1283.m16850("nf_log", "ShareSheetSession session already started!");
            return;
        }
        C1283.m16854("nf_log", "ShareSheetSession session starting...");
        this.f5995 = new C1520aw(str, commandName, modalView);
        this.f5978.mo4786(this.f5995);
        C1283.m16854("nf_log", "ShareSheetSession  session start done.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5516(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError) {
        if (this.f5995 != null) {
            C1283.m16854("nf_log", "ShareSheetSession ended and posted to executor");
            C1519av r2 = this.f5995.m5702(completionReason, uIError, modalView);
            m5447(r2, this.f5992, modalView);
            this.f5978.mo4785(this.f5995);
            C1283.m16854("nf_log", "ShareSheetSession end event posting...");
            this.f5978.mo4783(r2);
            this.f5995 = null;
            C1283.m16854("nf_log", "ShareSheetSession end event posted.");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5503(String str, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5999 != null) {
            C1283.m16850("nf_log", "ShareSheetOpenSession session already started!");
            return;
        }
        C1283.m16854("nf_log", "ShareSheetOpenSession session starting...");
        this.f5999 = new C1514as(str, commandName, modalView);
        this.f5978.mo4786(this.f5999);
        C1283.m16854("nf_log", "ShareSheetOpenSession  session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5530(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError) {
        if (this.f5999 != null) {
            C1283.m16854("nf_log", "ShareSheetOpenSession ended");
            C1522ay r2 = this.f5999.m5642(completionReason, uIError, modalView);
            m5447(r2, this.f5992, modalView);
            this.f5978.mo4785(this.f5999);
            C1283.m16854("nf_log", "ShareSheetOpenSession end event posting...");
            this.f5978.mo4783(r2);
            this.f5999 = null;
            C1283.m16854("nf_log", "ShareSheetOpenSession end event posted.");
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m5504(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5975 != null) {
            C1283.m16850("nf_log", "NewLolomoSession session already started!");
            return;
        }
        C1283.m16854("nf_log", "NewLolomoSession session starting...");
        this.f5975 = new C1683dw(commandName, modalView);
        this.f5978.mo4786(this.f5975);
        C1283.m16854("nf_log", "NewLolomoSession session start done.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5488(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError, String str, String str2, long j, String str3, String str4) {
        if (this.f5975 != null) {
            C1283.m16854("nf_log", "NewLolomoSession ended");
            C1659dX r10 = this.f5975.m6027(completionReason, uIError, modalView, str, str2, j, str3, str4);
            if (r10 == null) {
                C1283.m16854("nf_log", "NewLolomoSession still waits on session id, do not post at this time.");
                return;
            }
            m5447(r10, this.f5992, modalView);
            this.f5978.mo4785(this.f5975);
            C1283.m16854("nf_log", "NewLolomoSession end event posting...");
            this.f5978.mo4783(r10);
            this.f5975 = null;
            C1283.m16854("nf_log", "NewLolomoSession end event posted.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5509(UserActionLogging.CommandName commandName, String str, String str2) {
        if (this.f5974 != null) {
            C1283.m16850("nf_log", "PreAppWidgetActionSession already started!");
            return;
        }
        C1283.m16854("nf_log", "PreAppWidgetActionSessionstarting...");
        C1521ax axVar = new C1521ax(commandName, str, str2);
        this.f5978.mo4786(axVar);
        this.f5974 = axVar;
        C1283.m16854("nf_log", "PreAppWidgetActionSession start done.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5485(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (this.f5974 != null) {
            C1283.m16854("nf_log", "PreAppWidgetActionSession session ended");
            C1516au r2 = this.f5974.m5703(completionReason, uIError);
            if (r2 == null) {
                C1283.m16854("nf_log", "PreAppWidgetActionSession still waits on session id, do not post at this time.");
                return;
            }
            this.f5978.mo4785(this.f5974);
            C1283.m16854("nf_log", "PreAppWidgetActionSession end event posting...");
            this.f5978.mo4783(r2);
            this.f5974 = null;
            C1283.m16854("nf_log", "PreAppWidgetActionSession end event posted.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5492(boolean z, int i, UserActionLogging.PostPlayExperience postPlayExperience) {
        if (this.f5976 != null) {
            C1283.m16850("nf_log", "PostPlaySession already started!");
            return;
        }
        C1283.m16854("nf_log", "PostPlaySession starting...");
        C1685dy dyVar = new C1685dy(null, IClientLogging.ModalView.postPlay, z, i, postPlayExperience);
        this.f5978.mo4786(dyVar);
        this.f5976 = dyVar;
        C1283.m16854("nf_log", "PostPlaySession start done.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5507(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError, boolean z, boolean z2, Integer num, Integer num2, int i) {
        if (this.f5976 != null) {
            C1283.m16854("nf_log", "PostPlaySession session ended");
            C1714ea r9 = this.f5976.m6029(completionReason, modalView, uIError, z, z2, num, num2, i);
            if (r9 == null) {
                C1283.m16854("nf_log", "PostPlaySession still waits on session id, do not post at this time.");
                return;
            }
            this.f5978.mo4785(this.f5976);
            C1283.m16854("nf_log", "PostPlaySession end event posting...");
            this.f5978.mo4783(r9);
            this.f5976 = null;
            C1283.m16854("nf_log", "PostPlaySession end event posted.");
        }
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public void m5537(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5980 != null) {
            C1283.m16850("nf_log", "PrefetchLolomoJobSession already started!");
            return;
        }
        C1283.m16854("nf_log", "PrefetchLolomoJobSession starting...");
        C1638dC dCVar = new C1638dC(commandName, modalView);
        this.f5978.mo4786(dCVar);
        this.f5980 = dCVar;
        C1283.m16854("nf_log", "PrefetchLolomoJobSession start done.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5513(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (this.f5980 != null) {
            C1283.m16854("nf_log", "PrefetchLolomoJobSession session ended");
            C1661dZ r2 = this.f5980.m5998(completionReason, uIError);
            if (r2 == null) {
                C1283.m16854("nf_log", "PrefetchLolomoJobSession still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5980.m6021());
            this.f5978.mo4785(this.f5980);
            C1283.m16854("nf_log", "PrefetchLolomoJobSession end event posting...");
            this.f5978.mo4783(r2);
            this.f5980 = null;
            C1283.m16854("nf_log", "PrefetchLolomoJob session end event posted.");
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public void m5481(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5984 != null) {
            C1283.m16850("nf_log", "DeserializeLolomoSession already started!");
            return;
        }
        C1283.m16854("nf_log", "DeserializeLolomoSession starting...");
        C1676dp dpVar = new C1676dp(commandName, modalView);
        this.f5978.mo4786(dpVar);
        this.f5984 = dpVar;
        C1283.m16854("nf_log", "PrefetchLolomoJobSession start done.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5497(IClientLogging.CompletionReason completionReason, UIError uIError, long j) {
        if (this.f5984 != null) {
            C1283.m16854("nf_log", "DeserializeLolomoSession session ended");
            C1656dU r2 = this.f5984.m6018(completionReason, uIError, j);
            if (r2 == null) {
                C1283.m16854("nf_log", "DeserializeLolomoSession still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5984.m6021());
            this.f5978.mo4785(this.f5984);
            C1283.m16854("nf_log", "DeserializeLolomoSession end event posting...");
            this.f5978.mo4783(r2);
            this.f5984 = null;
            C1283.m16854("nf_log", "DeserializeLolomoSession session end event posted.");
        }
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void m5539(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5977 != null) {
            C1283.m16850("nf_log", "SerializeLolomoSession already started!");
            return;
        }
        C1283.m16854("nf_log", "SerializeLolomoSession starting...");
        C1643dH dHVar = new C1643dH(commandName, modalView);
        this.f5978.mo4786(dHVar);
        this.f5977 = dHVar;
        C1283.m16854("nf_log", "PrefetchLolomoJobSession start done.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5486(IClientLogging.CompletionReason completionReason, UIError uIError, long j) {
        if (this.f5977 != null) {
            C1283.m16854("nf_log", "SerializeLolomoSession session ended");
            C1722ei r2 = this.f5977.m6003(completionReason, uIError, j);
            if (r2 == null) {
                C1283.m16854("nf_log", "SerializeLolomoSession still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5977.m6021());
            this.f5978.mo4785(this.f5977);
            C1283.m16854("nf_log", "SerializeLolomoSession end event posting...");
            this.f5978.mo4783(r2);
            this.f5977 = null;
            C1283.m16854("nf_log", "SerializeLolomoSession session end event posted.");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5532(IClientLogging.ModalView modalView) {
        if (this.f5979 != null) {
            C1283.m16850("nf_log", "RegisterForPushNotificationsSession already started!");
            return;
        }
        C1283.m16854("nf_log", "RegisterForPushNotificationsSession starting...");
        C1686dz dzVar = new C1686dz(null, modalView);
        this.f5978.mo4786(dzVar);
        this.f5979 = dzVar;
        C1717ed r3 = dzVar.m6030();
        m5447(r3, this.f5992, dzVar.m6021());
        this.f5978.mo4783(r3);
        C1283.m16854("nf_log", "RegisterForPushNotificationsSession start done.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5491(String str, boolean z, boolean z2, IClientLogging.CompletionReason completionReason, UIError uIError, String str2) {
        if (this.f5979 != null) {
            C1283.m16854("nf_log", "RegisterForPushNotificationsSession session ended");
            C1718ee r7 = this.f5979.m6031(str, z, z2, completionReason, uIError, str2);
            m5447(r7, this.f5992, this.f5979.m6021());
            this.f5978.mo4785(this.f5979);
            C1283.m16854("nf_log", "SRegisterForPushNotificationsSession end event posting...");
            this.f5978.mo4783(r7);
            this.f5979 = null;
            C1283.m16854("nf_log", "RegisterForPushNotificationsSession session end event posted.");
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void m5541(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (this.f5988 != null) {
            C1283.m16850("nf_log", "HideFromHistorySession session already started!");
            return;
        }
        C1283.m16854("nf_log", "HideFromHistorySession session starting...");
        C1681du duVar = new C1681du(commandName, modalView);
        this.f5978.mo4786(duVar);
        this.f5988 = duVar;
        C1283.m16854("nf_log", "HideFromHistorySession session start done.");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m5483(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (this.f5988 != null) {
            C1283.m16854("nf_log", "HideFromHistorySession session ended");
            C1655dT r2 = this.f5988.m6025(completionReason, uIError);
            if (r2 == null) {
                C1283.m16854("nf_log", "HideFromHistorySession session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5988.m6021());
            this.f5978.mo4785(this.f5988);
            C1283.m16854("nf_log", "HideFromHistorySession session end event posting...");
            this.f5978.mo4783(r2);
            this.f5988 = null;
            C1283.m16854("nf_log", "HideFromHistorySession session end event posted.");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5534(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, int i) {
        if (this.f5982 != null) {
            C1283.m16850("nf_log", "SelectPlan session already started!");
            return;
        }
        C1283.m16854("nf_log", "SelectPlan session starting...");
        C1641dF dFVar = new C1641dF(commandName, modalView);
        this.f5978.mo4786(dFVar);
        this.f5982 = dFVar;
        C1283.m16854("nf_log", "SelectPlan session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5525(IClientLogging.CompletionReason completionReason, UIError uIError, int i) {
        if (this.f5982 != null) {
            C1283.m16854("nf_log", "SelectPlan session ended");
            C1725el r2 = this.f5982.m6001(completionReason, uIError, i);
            if (r2 == null) {
                C1283.m16854("nf_log", "SelectPlan session still waits on session id, do not post at this time.");
                return;
            }
            m5447(r2, this.f5992, this.f5982.m6021());
            this.f5978.mo4785(this.f5982);
            C1283.m16854("nf_log", "SelectPlan session end event posting...");
            this.f5978.mo4783(r2);
            this.f5982 = null;
            C1283.m16854("nf_log", "SelectPlan session end event posted.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5510(String str, IClientLogging.ModalView modalView, JSONObject jSONObject) {
        this.f5978.mo4783(new CustomEvent(str, modalView, jSONObject));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5519(C1359Ce ce) {
        this.f5992 = ce;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m5523() {
        m5526(IClientLogging.CompletionReason.canceled, (UIError) null, IClientLogging.ModalView.logout);
        m5531(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.logout, (UIError) null, (UserActionLogging.C0029) null);
        m5496(IClientLogging.CompletionReason.canceled, (UIError) null, 0);
        m5499(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.logout, (UIError) null);
        m5500(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.logout, null, null);
        m5505(IClientLogging.CompletionReason.canceled, (UIError) null);
        m5501(IClientLogging.ModalView.logout, IClientLogging.CompletionReason.canceled, (UIError) null);
        m5488(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.logout, null, null, null, System.currentTimeMillis(), null, null);
        m5498(IClientLogging.CompletionReason.canceled, null, 0, 0, null, -1, false);
        m5495(IClientLogging.CompletionReason.canceled, (UIError) null);
        m5524(IClientLogging.CompletionReason.canceled, (UIError) null);
        m5506(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.logout, (UIError) null);
        m5528(IClientLogging.CompletionReason.canceled, (UIError) null, (Integer) 0, (PlayLocationType) null);
        m5529(IClientLogging.CompletionReason.canceled, null, false, null, null);
        m5527(IClientLogging.CompletionReason.canceled, (UIError) null, (UserActionLogging.Streams) null);
        m5530(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.logout, (UIError) null);
        m5516(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.logout, (UIError) null);
        m5507(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.logout, null, false, false, null, null, 0);
        m5485(IClientLogging.CompletionReason.canceled, (UIError) null);
        m5487(IClientLogging.CompletionReason.canceled, (UIError) null, (String) null);
        m5515(IClientLogging.CompletionReason.canceled, (UIError) null, "", (String) null);
        m5513(IClientLogging.CompletionReason.canceled, (UIError) null);
        m5497(IClientLogging.CompletionReason.canceled, (UIError) null, -1L);
        m5486(IClientLogging.CompletionReason.canceled, (UIError) null, -1);
        m5525(IClientLogging.CompletionReason.canceled, (UIError) null, -1);
        m5483(IClientLogging.CompletionReason.canceled, (UIError) null);
        HashSet<Long> hashSet = new HashSet(this.f5986.size());
        hashSet.addAll(this.f5986.keySet());
        for (Long l : hashSet) {
            m5494(l.longValue(), IClientLogging.CompletionReason.canceled, (UIError) null);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m5520(Intent intent, boolean z) {
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.LOG_UIA_ADD_TO_PLAYLIST_START".equals(action)) {
            C1283.m16854("nf_log", "ADD_TO_PLAYLIST_START");
            m5450(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_ADD_TO_PLAYLIST_ENDED".equals(action)) {
            C1283.m16854("nf_log", "ADD_TO_PLAYLIST_ENDED");
            m5452(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_START".equals(action)) {
            C1283.m16854("nf_log", "SURVEY_START");
            m5459(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SURVEY_ENDED");
            m5468(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_QUESTION_START".equals(action)) {
            C1283.m16854("nf_log", "SURVEY_QUESTION_START");
            m5461(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_QUESTION_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SURVEY_QUESTION_ENDED");
            m5421(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_CHANGE_VALUE_START".equals(action)) {
            C1283.m16854("nf_log", "CHANGE_VALUE_START");
            m5464(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_CHANGE_VALUE_ENDED".equals(action)) {
            C1283.m16854("nf_log", "CHANGE_VALUE_ENDED");
            m5460(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_LOGIN_START".equals(action)) {
            C1283.m16854("nf_log", "LOGIN_START");
            m5428(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_LOGIN_ENDED".equals(action)) {
            C1283.m16854("nf_log", "LOGIN_ENDED");
            m5425(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SIGNUP_START".equals(action)) {
            C1283.m16854("nf_log", "SIGNUP_START");
            m5438(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SIGNUP_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SIGNUP_ENDED");
            m5433(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_NAVIGATION_START".equals(action)) {
            C1283.m16854("nf_log", "NAVIGATION_START");
            m5426(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_NAVIGATION_ENDED".equals(action)) {
            C1283.m16854("nf_log", "NAVIGATION_ENDED");
            m5427(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_RATE_TITLE_START".equals(action)) {
            C1283.m16854("nf_log", "RATE_TITLE_START");
            m5423(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_RATE_TITLE_ENDED".equals(action)) {
            C1283.m16854("nf_log", "RATE_TITLE_ENDED");
            m5436(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_START".equals(action)) {
            C1283.m16854("nf_log", "REGISTER_START");
            m5431(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_ENDED".equals(action)) {
            C1283.m16854("nf_log", "REGISTER_ENDED");
            m5432(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_REMOVE_FROM_PLAYLIST_START".equals(action)) {
            C1283.m16854("nf_log", "REMOVE_FROM_PLAYLIST_START");
            m5434(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_REMOVE_FROM_PLAYLIST_ENDED".equals(action)) {
            C1283.m16854("nf_log", "REMOVE_FROM_PLAYLIST_ENDED");
            m5429(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SEARCH_START".equals(action)) {
            C1283.m16854("nf_log", "SEARCH_START");
            m5437(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SEARCH_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SEARCH_ENDED");
            m5444(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_START_PLAY_START".equals(action)) {
            C1283.m16854("nf_log", "START_PLAY_START");
            m5439(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_START_PLAY_ENDED".equals(action)) {
            C1283.m16854("nf_log", "START_PLAY_ENDED");
            m5440(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SUBMIT_PAYMENT_START".equals(action)) {
            C1283.m16854("nf_log", "SUBMIT_PAYMENT_START");
            m5441(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SUBMIT_PAYMENT_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SUBMIT_PAYMENT_ENDED");
            m5445(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_UPGRADE_STREAMS_START".equals(action)) {
            C1283.m16854("nf_log", "UPGRADE_STREAMS_START");
            m5449(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_UPGRADE_STREAMS_ENDED".equals(action)) {
            C1283.m16854("nf_log", "UPGRADE_STREAMS_ENDED");
            m5448(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PROFILE_START".equals(action)) {
            C1283.m16854("nf_log", "SELECT_PROFILE_START");
            m5453(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PROFILE_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SELECT_PROFILE_ENDED");
            m5451(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_ADD_PROFILE_START".equals(action)) {
            C1283.m16854("nf_log", "ADD_PROFILE_START");
            m5462(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_ADD_PROFILE_ENDED".equals(action)) {
            C1283.m16854("nf_log", "ADD_PROFILE_ENDED");
            m5458(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_EDIT_PROFILE_START".equals(action)) {
            C1283.m16854("nf_log", "EDIT_PROFILE_START");
            m5457(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_EDIT_PROFILE_ENDED".equals(action)) {
            C1283.m16854("nf_log", "EDIT_PROFILE_ENDED");
            m5470(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_DELETE_PROFILE_START".equals(action)) {
            C1283.m16854("nf_log", "DELETE_PROFILE_START");
            m5456(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_DELETE_PROFILE_ENDED".equals(action)) {
            C1283.m16854("nf_log", "DELETE_PROFILE_ENDED");
            m5454(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_START".equals(action)) {
            C1283.m16854("nf_log", "SHARE_SHEET_START");
            m5422(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SHARE_SHEET_ENDED");
            m5420(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_OPEN_START".equals(action)) {
            C1283.m16854("nf_log", "SHARE_SHEET_OPEN_START");
            m5463(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_OPEN_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SHARE_SHEET_OPEN_ENDED");
            m5465(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_NEW_LOLOMO_START".equals(action)) {
            C1283.m16854("nf_log", "NEW_LOLOMO_START");
            m5455(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_NEW_LOLOMO_ENDED".equals(action)) {
            C1283.m16854("nf_log", "NEW_LOLOMO_ENDED");
            m5424(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.PREAPP_WIDGET_ACTION_START".equals(action)) {
            C1283.m16854("nf_log", "PREAPP_WIDGET_ACTION_START");
            m5471(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.PREAPP_WIDGET_ACTION_ENDED".equals(action)) {
            C1283.m16854("nf_log", "PREAPP_WIDGET_ACTION_ENDED");
            m5466(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_POSTPLAY_START".equals(action)) {
            m5443(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_POSTPLAY_ENDED".equals(action)) {
            m5435(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_PREFETCH_LOLOMO_JOB_START".equals(action)) {
            C1283.m16854("nf_log", "PREFETCH_LOLOMO_JOB_STARTED");
            m5467(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_PREFETCH_LOLOMO_JOB_ENDED".equals(action)) {
            C1283.m16854("nf_log", "PREFETCH_LOLOMO_JOB_ENDED");
            m5469(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_DESERIALIZE_LOLOMO_START".equals(action)) {
            C1283.m16854("nf_log", "DESERIALIZE_LOLOMO_STARTED");
            m5476(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_DESERIALIZE_LOLOMO_ENDED".equals(action)) {
            C1283.m16854("nf_log", "DESERIALIZE_LOLOMO_ENDED");
            m5474(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SERIALIZE_LOLOMO_START".equals(action)) {
            C1283.m16854("nf_log", "SERIALIZE_LOLOMO_STARTED");
            m5472(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SERIALIZE_LOLOMO_ENDED".equals(action)) {
            C1283.m16854("nf_log", "SERIALIZE_LOLOMO_ENDED");
            m5475(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_CUSTOM_ACTION".equals(action)) {
            m5479(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_FOR_PUSH_NOTIFICATION_START".equals(action)) {
            m5446(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_FOR_PUSH_NOTIFICATION_ENDED".equals(action)) {
            m5430(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PLAN_START".equals(action)) {
            m5473(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PLAN_ENDED".equals(action)) {
            m5477(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_UIA_HIDE_FROM_HISTORY_START".equals(action)) {
            m5419(intent);
            return true;
        } else if (!"com.netflix.mediaclient.intent.action.LOG_UIA_HIDE_FROM_HISTORY_ENDED".equals(action)) {
            return false;
        } else {
            m5478(intent);
            return true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5446(Intent intent) {
        C1283.m16854("nf_log", "REGISTER_FOR_PUSH_NOTIFICATION_STARTED");
        String stringExtra = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra);
        }
        m5532(modalView);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5430(Intent intent) {
        C1283.m16854("nf_log", "REGISTER_FOR_PUSH_NOTIFICATION_ENDED");
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("deviceToken");
        String stringExtra4 = intent.getStringExtra("oldDeviceToken");
        boolean booleanExtra = intent.getBooleanExtra("userPushOptIn", false);
        boolean booleanExtra2 = intent.getBooleanExtra("infoPushOptIn", false);
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5491(stringExtra3, booleanExtra, booleanExtra2, completionReason, uIError, stringExtra4);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5443(Intent intent) {
        C1283.m16854("nf_log", "POSTPLAY_START_START");
        boolean booleanExtra = intent.getBooleanExtra("isAutoPlayCountdownEnabled", false);
        int intExtra = intent.getIntExtra("lengthOfAutoPlayCountdown", 0);
        String stringExtra = intent.getStringExtra("postPlayExperience");
        UserActionLogging.PostPlayExperience postPlayExperience = null;
        if (C1349Bv.m4107(stringExtra)) {
            postPlayExperience = UserActionLogging.PostPlayExperience.valueOf(stringExtra);
        }
        m5492(booleanExtra, intExtra, postPlayExperience);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5435(Intent intent) {
        C1283.m16854("nf_log", "POSTPLAY_START_ENDED");
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        boolean booleanExtra = intent.getBooleanExtra("wasAutoPlayCountdownInterrupted", false);
        boolean booleanExtra2 = intent.getBooleanExtra("didUserContinueWatching", false);
        int intExtra = intent.getIntExtra("chosenVideoId", -1);
        Integer valueOf = intExtra < 0 ? null : Integer.valueOf(intExtra);
        int intExtra2 = intent.getIntExtra("chosenIndex", -1);
        Integer valueOf2 = intExtra2 < 0 ? null : Integer.valueOf(intExtra2);
        int intExtra3 = intent.getIntExtra("trackId", 0);
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        m5507(completionReason, modalView, uIError, booleanExtra, booleanExtra2, valueOf, valueOf2, intExtra3);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5455(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5504(commandName, modalView);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m5424(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        String stringExtra4 = intent.getStringExtra("renoCause");
        String stringExtra5 = intent.getStringExtra("renoMessageGuid");
        long longExtra = intent.getLongExtra("renoCreationTimestamp", System.currentTimeMillis());
        String stringExtra6 = intent.getStringExtra("mercuryMessageGuid");
        String stringExtra7 = intent.getStringExtra("mercuryEventGuid");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        m5488(completionReason, modalView, uIError, stringExtra4, stringExtra5, longExtra, stringExtra6, stringExtra7);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m5422(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5490(intent.getStringExtra("url"), commandName, modalView);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m5420(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        m5516(completionReason, modalView, uIError);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m5463(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5503(intent.getStringExtra("url"), commandName, modalView);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m5465(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        m5530(completionReason, modalView, uIError);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m5438(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5502(commandName, modalView);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m5433(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        m5526(completionReason, uIError, modalView);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m5450(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5489(commandName, modalView);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m5452(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        int intExtra = intent.getIntExtra("title_rank", 0);
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5496(completionReason, uIError, intExtra);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m5459(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5517(commandName, modalView);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m5468(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("surveyType");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5487(completionReason, uIError, stringExtra3);
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m5461(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5508(commandName, modalView);
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m5421(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("question");
        String stringExtra4 = intent.getStringExtra("response");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5515(completionReason, uIError, stringExtra3, stringExtra4);
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m5464(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5533(commandName, modalView);
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m5460(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("new_value");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5514(completionReason, uIError, stringExtra3);
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private void m5428(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5484(commandName, modalView);
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private void m5425(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5505(completionReason, uIError);
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m5426(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5482(commandName, modalView);
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    private void m5427(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        UIError uIError = null;
        String stringExtra3 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5501(modalView, completionReason, uIError);
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private void m5423(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5480(commandName, modalView);
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m5436(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        int intExtra = intent.getIntExtra("rating", 0);
        int intExtra2 = intent.getIntExtra("rank", Integer.MIN_VALUE);
        String stringExtra3 = intent.getStringExtra("rating_type");
        int intExtra3 = intent.getIntExtra("score", -1);
        boolean booleanExtra = intent.getBooleanExtra("is_new", false);
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5498(completionReason, uIError, intExtra2 == Integer.MIN_VALUE ? null : Integer.valueOf(intExtra2), intExtra, stringExtra3, intExtra3, booleanExtra);
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private void m5431(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5538(commandName, modalView);
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private void m5432(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5495(completionReason, uIError);
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m5434(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5540(commandName, modalView);
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m5429(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5524(completionReason, uIError);
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private void m5437(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("term");
        String stringExtra3 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        m5512(intent.getLongExtra("id", -1), commandName, modalView, stringExtra2);
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m5444(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        long longExtra = intent.getLongExtra("id", -1);
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5494(longExtra, completionReason, uIError);
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m5439(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5536(commandName, modalView);
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private void m5440(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        int intExtra = intent.getIntExtra("rank", Integer.MIN_VALUE);
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5528(completionReason, uIError, intExtra == Integer.MIN_VALUE ? null : Integer.valueOf(intExtra), (PlayLocationType) intent.getSerializableExtra("playLocation"));
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private void m5441(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5521(commandName, modalView);
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private void m5445(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        boolean booleanExtra = intent.getBooleanExtra("sucess", false);
        String stringExtra2 = intent.getStringExtra("error_code");
        String stringExtra3 = intent.getStringExtra("payment_type");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        UserActionLogging.PaymentType paymentType = null;
        if (!C1349Bv.m4113(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        if (!C1349Bv.m4113(stringExtra3)) {
            paymentType = UserActionLogging.PaymentType.valueOf(stringExtra3);
        }
        JSONObject jSONObject = null;
        if (C1349Bv.m4107(stringExtra2)) {
            try {
                jSONObject = new JSONObject(stringExtra2);
            } catch (JSONException e2) {
                C1283.m16847("nf_log", "Failed JSON", e2);
            }
        }
        m5529(completionReason, uIError, booleanExtra, paymentType, jSONObject);
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private void m5449(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        UserActionLogging.Streams streams = null;
        String stringExtra3 = intent.getStringExtra("streams");
        if (C1349Bv.m4107(stringExtra3)) {
            streams = UserActionLogging.Streams.m1564(stringExtra3);
        }
        m5535(commandName, modalView, streams);
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private void m5448(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        UIError uIError = null;
        UserActionLogging.Streams r6 = UserActionLogging.Streams.m1564(intent.getStringExtra("streams"));
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5527(completionReason, uIError, r6);
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m5453(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (C1349Bv.m4107(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("profile_id");
        UserActionLogging.RememberProfile rememberProfile = null;
        String stringExtra4 = intent.getStringExtra("remember_profile");
        if (C1349Bv.m4107(stringExtra4)) {
            rememberProfile = UserActionLogging.RememberProfile.valueOf(stringExtra4);
        }
        m5511(stringExtra3, rememberProfile, commandName, modalView);
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    private void m5451(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (!C1349Bv.m4113(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5506(completionReason, modalView, uIError);
    }

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private void m5462(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (C1349Bv.m4107(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5493(commandName, modalView);
    }

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private void m5458(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (!C1349Bv.m4113(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5531(completionReason, modalView, uIError, new UserActionLogging.C0029(intent.getStringExtra("profile_id"), intent.getStringExtra("profile_name"), Integer.valueOf(intent.getIntExtra("profile_age", -1)), intent.getBooleanExtra("profile_is_kids", false)));
    }

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private void m5456(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (C1349Bv.m4107(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5518(intent.getStringExtra("profile_id"), commandName, modalView);
    }

    /* renamed from: ـ  reason: contains not printable characters */
    private void m5454(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (!C1349Bv.m4113(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5499(completionReason, modalView, uIError);
    }

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private void m5457(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (C1349Bv.m4107(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5522(commandName, modalView);
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    private void m5470(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        String stringExtra3 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra3)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra3);
        }
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (!C1349Bv.m4113(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5500(completionReason, modalView, uIError, new UserActionLogging.C0029(intent.getStringExtra("profile_id"), intent.getStringExtra("profile_name"), Integer.valueOf(intent.getIntExtra("profile_age", -1)), intent.getBooleanExtra("profile_is_kids", false)));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5447(Event event, C1359Ce ce, IClientLogging.ModalView modalView) {
        if (event != null) {
            event.setDataContext(ce);
            event.setModalView(modalView);
        }
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    private void m5471(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (C1349Bv.m4107(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        m5509(commandName, intent.getStringExtra(PreAppWidgetLogData.EXTRA_WIDGET_LOG_DATA), intent.getStringExtra(PreAppWidgetLogActionData.EXTRA_WIDGET_ACTION_DATA));
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private void m5466(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (!C1349Bv.m4113(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5485(completionReason, uIError);
    }

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private void m5467(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5537(commandName, modalView);
    }

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private void m5469(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5513(completionReason, uIError);
    }

    /* renamed from: ꜟ  reason: contains not printable characters */
    private void m5476(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5481(commandName, modalView);
    }

    /* renamed from: ꓸ  reason: contains not printable characters */
    private void m5474(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5497(completionReason, uIError, intent.getLongExtra("lolomoTtl", -1));
    }

    /* renamed from: ᶥ  reason: contains not printable characters */
    private void m5472(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5539(commandName, modalView);
    }

    /* renamed from: ꜞ  reason: contains not printable characters */
    private void m5475(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5486(completionReason, uIError, intent.getLongExtra("lolomoFetchedTime", -1));
    }

    /* renamed from: ㆍ  reason: contains not printable characters */
    private void m5473(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5534(commandName, modalView, intent.getIntExtra("plan_id", 0));
    }

    /* renamed from: ꞌ  reason: contains not printable characters */
    private void m5477(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        int intExtra = intent.getIntExtra("plan_id", 0);
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(stringExtra2);
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5525(completionReason, uIError, intExtra);
    }

    /* renamed from: ʹ  reason: contains not printable characters */
    private void m5419(Intent intent) {
        String stringExtra = intent.getStringExtra("cmd");
        UserActionLogging.CommandName commandName = null;
        if (!C1349Bv.m4113(stringExtra)) {
            commandName = UserActionLogging.CommandName.valueOf(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        m5541(commandName, modalView);
    }

    /* renamed from: ﹳ  reason: contains not printable characters */
    private void m5478(Intent intent) {
        String stringExtra = intent.getStringExtra("reason");
        UIError uIError = null;
        try {
            uIError = UIError.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
        } catch (JSONException e) {
            C1283.m16847("nf_log", "Failed JSON", e);
        }
        IClientLogging.CompletionReason completionReason = null;
        if (C1349Bv.m4107(stringExtra)) {
            completionReason = IClientLogging.CompletionReason.valueOf(stringExtra);
        }
        m5483(completionReason, uIError);
    }

    /* renamed from: ﾞ  reason: contains not printable characters */
    private void m5479(Intent intent) {
        C1283.m16854("nf_log", "CUSTOM_ACTION");
        String stringExtra = intent.getStringExtra("cmd");
        String stringExtra2 = intent.getStringExtra("view");
        IClientLogging.ModalView modalView = null;
        if (C1349Bv.m4107(stringExtra2)) {
            modalView = IClientLogging.ModalView.valueOf(stringExtra2);
        }
        JSONObject jSONObject = null;
        String stringExtra3 = intent.getStringExtra(Event.CUSTOM);
        if (stringExtra3 != null) {
            try {
                jSONObject = new JSONObject(stringExtra3);
            } catch (JSONException e) {
                C1276.m16820().mo5729("handleCustomAction", e);
            }
        }
        m5510(stringExtra, modalView, jSONObject);
    }
}
