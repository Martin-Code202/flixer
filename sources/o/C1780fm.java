package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.media.MediaRouter;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.CastState;
import com.google.android.gms.cast.framework.CastStateListener;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.mdx.logging.connection.MdxConnectionLogblobLogger;
import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.fm  reason: case insensitive filesystem */
public class C1780fm extends AbstractC1779fl implements AbstractC1833gs, AbstractC1705eR, AbstractC1711eX, CastStateListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f6763;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Context f6764;

    /* renamed from: ʽ  reason: contains not printable characters */
    private CastContext f6765;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1767fa f6766;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f6767;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1708eU f6768;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final oD f6769;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f6770;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Handler f6771;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1706eS f6772;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private MediaRouter f6773;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC1700eM f6774;

    public C1780fm(Context context, oD oDVar, AbstractC1700eM eMVar, Looper looper, Handler handler, C1767fa faVar, String str) {
        C1283.m16854("MdxStackCaf", "Initializing MdxStackCaf...");
        this.f6769 = oDVar;
        this.f6774 = eMVar;
        this.f6764 = context;
        this.f6771 = new Handler(looper);
        this.f6767 = handler;
        this.f6766 = faVar;
        this.f6763 = str;
        this.f6767.post(new Runnable() { // from class: o.fm.2
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("MdxStackCaf", "Initializing CastContext and getting MediaRouter...");
                C1780fm.this.f6765 = CastContext.getSharedInstance(C1780fm.this.f6764);
                C1780fm.this.f6773 = MediaRouter.getInstance(C1780fm.this.f6764.getApplicationContext());
                C1780fm.this.f6765.addCastStateListener(C1780fm.this);
                C1780fm.this.f6772 = new C1706eS(C1780fm.this.f6765, C1780fm.this.f6767, C1780fm.this.f6763, C1780fm.this.f6766, C1780fm.this);
            }
        });
    }

    @Override // o.AbstractC1779fl
    /* renamed from: ˊ */
    public AbstractC1823gi mo741(String str) {
        return m6426(str);
    }

    @Override // o.AbstractC1833gs
    /* renamed from: ᐝ */
    public Looper mo749() {
        return this.f6771.getLooper();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6433(String str) {
        C1283.m16851("MdxStackCaf", "setCurrentTarget - uuid: %s", str);
        this.f6770 = str;
        m6408(this.f6770);
        if (m6426(str) != null) {
            C1283.m16854("MdxStackCaf", "setCurrentTarget - target is a Cast device");
            MdxConnectionLogblobLogger.m694();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6431(String str, final boolean z, String str2, String str3) {
        C1283.m16863("MdxStackCaf", "setMdxNetworkInterface - name: %s, connected: %b", str, Boolean.valueOf(z));
        this.f6771.post(new Runnable() { // from class: o.fm.1
            @Override // java.lang.Runnable
            public void run() {
                C1780fm.this.m6429();
                C1780fm.this.m6407();
                C1780fm.this.f6774.mo6062();
                if (z) {
                    C1283.m16862("MdxStackCaf", "setMdxNetworkInterface - connected");
                    C1780fm.this.m6436();
                }
            }
        });
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m6436() {
        C1283.m16854("MdxStackCaf", "enable - enabling Cast CAF stack");
        if (this.f6768 == null) {
            this.f6767.post(new Runnable() { // from class: o.fm.4
                @Override // java.lang.Runnable
                public void run() {
                    C1780fm.this.f6768 = new C1708eU(C1780fm.this);
                    C1780fm.this.f6773.addCallback(C1780fm.this.f6765.getMergedSelector(), C1780fm.this.f6768, 1);
                }
            });
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m6429() {
        C1283.m16854("MdxStackCaf", "disable - disabling Cast CAF stack");
        if (this.f6768 != null) {
            this.f6767.post(new Runnable() { // from class: o.fm.3
                @Override // java.lang.Runnable
                public void run() {
                    C1780fm.this.f6773.removeCallback(C1780fm.this.f6768);
                    C1780fm.this.f6768 = null;
                }
            });
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m6432() {
        C1283.m16854("MdxStackCaf", "restartDiscovery");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m6430(final String str) {
        C1283.m16851("MdxStackCaf", "launchNetflix - uuid: %s", str);
        this.f6767.post(new Runnable() { // from class: o.fm.5
            @Override // java.lang.Runnable
            public void run() {
                MediaRouter.RouteInfo r5 = C1780fm.this.m6427(str);
                if (r5 == null) {
                    C1283.m16844("MdxStackCaf", "launchNetflix - ERROR - can't find RouteInfo for uuid: %s", str);
                    return;
                }
                CastSession currentCastSession = C1780fm.this.f6765.getSessionManager().getCurrentCastSession();
                if (currentCastSession == null || !currentCastSession.isConnected()) {
                    C1780fm.this.f6773.selectRoute(r5);
                    return;
                }
                C1283.m16850("MdxStackCaf", "MdxStackCaf launchNetflix - session already connected");
                C1780fm.this.m6424();
            }
        });
    }

    @Override // o.AbstractC1833gs
    public void a_(String str, String str2, String str3) {
        C1283.m16851("MdxStackCaf", "sendMessage - uuid: %s, url: %s, message: %s", str3, str2, str);
        this.f6772.m6262(str);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m6434() {
        this.f6765.getSessionManager().endCurrentSession(true);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1827gm m6426(String str) {
        synchronized (this.f6762) {
            Iterator it = this.f6762.iterator();
            while (it.hasNext()) {
                AbstractC1823gi giVar = (AbstractC1823gi) it.next();
                if (giVar.mo6670(str)) {
                    return (C1827gm) giVar;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private MediaRouter.RouteInfo m6427(String str) {
        for (MediaRouter.RouteInfo routeInfo : this.f6773.getRoutes()) {
            if (str.equalsIgnoreCase(AU.m3419(routeInfo.getId()))) {
                return routeInfo;
            }
        }
        return null;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0020: APUT  (r2v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r3v1 java.lang.String) */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6418(boolean z, String str) {
        C1827gm r5 = m6426(str);
        if (r5 != null) {
            r5.mo6678(z, this.f6769, this.f6774);
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = z ? FalkorPathResult.SUCCESS : "failed";
        C1283.m16863("MdxStackCaf", "launch %s %s", objArr);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m6424() {
        C1283.m16854("MdxStackCaf", "onLaunched");
        MediaRouter.RouteInfo r3 = m6427(this.f6770);
        if (null != r3) {
            this.f6772.m6261(this.f6770, r3.getName());
        } else {
            C1283.m16854("MdxStackCaf", "onLaunched, no selected route");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6435(String str, String str2, String str3) {
        C1827gm r4 = m6426(str2);
        if (r4 == null) {
            C1283.m16863("MdxStackCaf", "onMessageReceived, no target to handle message. %s", str2);
            return;
        }
        SessionMdxTarget r5 = r4.mo791();
        if (r5 == null) {
            C1283.m16863("MdxStackCaf", "onMessageReceived, no target to handle message. %s %s", str2, str3);
            return;
        }
        try {
            JSONObject r6 = C1829go.m6692(str);
            if ("/pairingresponse".equals(str3) || "/regpairreply".equals(str3) || "/regpairerror".equals(str3)) {
                r5.m785(r6);
            } else if ("/session".equals(str3)) {
                r5.m780(r6);
            } else if ("/broadcast".equals(str3)) {
                C1283.m16862("MdxStackCaf", "onMessageReceived, CAST not handle broadcast message");
            } else if ("/error".equals(str3)) {
                r5.m787(r6);
            } else {
                C1283.m16863("MdxStackCaf", "onMessageReceived, not handling %s", str3);
            }
        } catch (JSONException e) {
            C1283.m16863("MdxStackCaf", "handleIncommingMdxMessage, JSONException %s", e);
        }
    }

    @Override // com.google.android.gms.cast.framework.CastStateListener
    public void onCastStateChanged(int i) {
        C1283.m16851("MdxStackCaf", "onCastStateChanged - newState: %s", CastState.toString(i));
    }

    @Override // o.AbstractC1705eR
    /* renamed from: ˊ */
    public void mo6252(String str, String str2, String str3, boolean z) {
        C1827gm r6 = m6426(str);
        synchronized (this.f6762) {
            if (r6 == null) {
                C1283.m16851("MdxStackCaf", "MdxStackCaf onRouteAdded - new target - uuid: %s, name: %s", str, str2);
                this.f6762.add(new C1827gm(str, str2, str3, this, this.f6766));
                this.f6774.mo6062();
                this.f6766.m6375("uuid=" + str);
                C1357Cc.m4344(this.f6764, str, str3, str2);
            } else {
                C1283.m16851("MdxStackCaf", "MdxStackCaf onRouteAdded - existing target - uuid: %s, name: %s", str, str2);
                r6.mo6672(str3, str2);
            }
            if (z) {
                C1283.m16854("MdxStackCaf", "MdxStackCaf onRouteAdded - route isSelected");
                CastSession currentCastSession = this.f6765.getSessionManager().getCurrentCastSession();
                if (currentCastSession != null && currentCastSession.isConnected()) {
                    C1283.m16854("MdxStackCaf", "MdxStackCaf onRouteAdded - session is connected");
                    this.f6770 = str;
                    m6424();
                }
            }
        }
    }

    @Override // o.AbstractC1705eR
    /* renamed from: ॱ */
    public void mo6253(String str) {
        C1827gm r4 = m6426(str);
        if (r4 != null) {
            C1283.m16851("MdxStackCaf", "MdxStackCaf onRouteRemoved - target found, notifying - uuid: %s", str);
            r4.mo6678(false, this.f6769, this.f6774);
        }
        synchronized (this.f6762) {
            Iterator it = this.f6762.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC1823gi giVar = (AbstractC1823gi) it.next();
                if (giVar.mo6670(str)) {
                    if (giVar.mo6670(this.f6770)) {
                        C1283.m16844("MdxStackCaf", "MdxStackCaf onRouteRemoved - removed route is the currently selected target - uuid: %s", str);
                        this.f6774.mo6057(str, 200, giVar.m6669());
                    }
                    C1283.m16851("MdxStackCaf", "MdxStackCaf onRouteRemoved - found target in device list, removing - uuid: %s", str);
                    this.f6774.mo6062();
                    it.remove();
                    this.f6766.m6376("uuid=" + str);
                }
            }
        }
    }

    @Override // o.AbstractC1711eX
    /* renamed from: ॱ */
    public void mo6336() {
        m6424();
    }

    @Override // o.AbstractC1711eX
    /* renamed from: ˊ */
    public void mo6331() {
        C1827gm r3 = m6426(this.f6770);
        if (r3 != null) {
            r3.mo6678(false, this.f6769, this.f6774);
        } else {
            C1283.m16850("MdxStackCaf", "MdxStackCaf onSessionStartFailed - can't notify target launch failed because target not found");
        }
    }

    @Override // o.AbstractC1711eX
    /* renamed from: ˋ */
    public void mo6332() {
        C1827gm r4 = m6426(this.f6770);
        if (r4 != null) {
            r4.m6668(true);
        } else {
            C1283.m16854("MdxStackCaf", "MdxStackCaf onSessionEnded - target is null");
        }
        this.f6774.mo6070(this.f6770, null, false);
        this.f6774.mo6071(false);
    }

    @Override // o.AbstractC1711eX
    /* renamed from: ˏ */
    public void mo6335() {
        m6424();
    }

    @Override // o.AbstractC1711eX
    /* renamed from: ˋ */
    public void mo6334(boolean z) {
        C1827gm r5 = m6426(this.f6770);
        if (r5 == null) {
            C1283.m16863("MdxStackCaf", "onSendMessageResult, no target to handle message. %s", this.f6770);
            return;
        }
        SessionMdxTarget r6 = r5.mo791();
        if (r6 != null) {
            r6.m794(z);
        } else {
            C1283.m16863("MdxStackCaf", "onSendMessageResult, no session target to handle message. %s %b", this.f6770, Boolean.valueOf(z));
        }
    }

    @Override // o.AbstractC1711eX
    /* renamed from: ˋ */
    public void mo6333(String str, String str2, String str3) {
        if (str.equals("castHandShakeAck") && null != this.f6770) {
            m6418(true, this.f6770);
        } else if (str.equals("castHandShakeRequest")) {
            C1283.m16854("MdxStackCaf", "onMessageReceived castHandShakeRequest");
            m6424();
        } else if (null != this.f6770) {
            m6435(str3, this.f6770, str2);
        } else {
            C1283.m16854("MdxStackCaf", "onMessageReceived, no selected route");
        }
    }
}
