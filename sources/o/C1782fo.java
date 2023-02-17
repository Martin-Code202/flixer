package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.mdx.logging.connection.MdxConnectionLogblobLogger;
import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.fo  reason: case insensitive filesystem */
public class C1782fo extends AbstractC1779fl implements AbstractC1709eV, AbstractC1833gs {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Context f6785;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC1700eM f6786;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1767fa f6787;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1710eW f6788;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Handler f6789;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final oD f6790;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6791;

    public C1782fo(Context context, C1710eW eWVar, oD oDVar, AbstractC1700eM eMVar, Looper looper, C1767fa faVar) {
        this.f6788 = eWVar;
        this.f6790 = oDVar;
        this.f6786 = eMVar;
        this.f6785 = context;
        this.f6789 = new Handler(looper);
        this.f6787 = faVar;
        this.f6788.m6322(this);
    }

    @Override // o.AbstractC1779fl
    /* renamed from: ˊ */
    public AbstractC1823gi mo741(String str) {
        return m6440(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6448(String str) {
        this.f6791 = str;
        m6408(this.f6791);
        if (m6440(str) != null) {
            MdxConnectionLogblobLogger.m694();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6444() {
        this.f6788.m6320();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6447() {
        this.f6788.m6326();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6445() {
        this.f6788.m6312();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6443() {
        this.f6788.m6311();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m6442(String str) {
        C1283.m16863("MdxControllerCast", "launchNetflix %s", str);
        this.f6788.m6325(str, true);
    }

    @Override // o.AbstractC1833gs
    public void a_(String str, String str2, String str3) {
        this.f6788.m6327(str);
    }

    @Override // o.AbstractC1833gs
    /* renamed from: ᐝ */
    public Looper mo749() {
        return this.f6788.m6323();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m6441() {
        this.f6788.m6330();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6446(String str, final boolean z, String str2, String str3) {
        C1283.m16863("MdxControllerCast", "setMdxNetworkInterface %s %b", str, Boolean.valueOf(z));
        this.f6789.post(new Runnable() { // from class: o.fo.2
            @Override // java.lang.Runnable
            public void run() {
                C1782fo.this.m6447();
                C1782fo.this.m6407();
                C1782fo.this.f6786.mo6062();
                if (z) {
                    C1283.m16862("MdxControllerCast", "setMdxNetworkInterface, connected");
                    C1782fo.this.m6444();
                }
            }
        });
    }

    @Override // o.AbstractC1709eV
    /* renamed from: ˎ */
    public void mo6272(String str, String str2, String str3) {
        C1283.m16863("MdxControllerCast", "onDeviceFound friendlyName=%s uuid=%s", str3, str);
        C1825gk r6 = m6440(str);
        synchronized (this.f6762) {
            if (r6 == null) {
                r6 = new C1825gk(str, str3, str2, this, this.f6787);
                this.f6762.add(r6);
                this.f6786.mo6062();
                this.f6787.m6375("uuid=" + str);
                C1283.m16863("MdxControllerCast", "onDeviceFound, add device %s", str);
                C1357Cc.m4344(this.f6785, str, str2, str3);
            } else {
                r6.mo6672(str2, str3);
                C1283.m16863("MdxControllerCast", "onDeviceFound, device %s already existed", str);
            }
            m6438(r6);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6438(AbstractC1823gi giVar) {
        if (giVar.mo6670(this.f6791)) {
            C1825gk gkVar = (C1825gk) giVar;
            if (!gkVar.m6677() && !gkVar.m6680()) {
                C1283.m16863("MdxControllerCast", "join Netflix on device %s", this.f6791);
                this.f6788.m6325(this.f6791, false);
                gkVar.m6676();
            }
        }
    }

    @Override // o.AbstractC1709eV
    /* renamed from: ˎ */
    public void mo6271(String str) {
        C1283.m16863("MdxControllerCast", "onDeviceLost uuid=%s", str);
        mo6275(false, str);
        synchronized (this.f6762) {
            Iterator it = this.f6762.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC1823gi giVar = (AbstractC1823gi) it.next();
                if (giVar.mo6670(str)) {
                    if (giVar.mo6670(this.f6791)) {
                        this.f6786.mo6057(str, 200, giVar.m6669());
                    }
                    this.f6786.mo6062();
                    it.remove();
                    this.f6787.m6376("uuid=" + str);
                }
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0020: APUT  (r2v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r3v1 java.lang.String) */
    @Override // o.AbstractC1709eV
    /* renamed from: ˏ */
    public void mo6275(boolean z, String str) {
        C1825gk r5 = m6440(str);
        if (r5 != null) {
            r5.mo6678(z, this.f6790, this.f6786);
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = z ? FalkorPathResult.SUCCESS : "failed";
        C1283.m16863("MdxControllerCast", "launch %s %s", objArr);
    }

    @Override // o.AbstractC1709eV
    /* renamed from: ˎ */
    public void mo6273(boolean z, String str) {
        C1825gk r5 = m6440(str);
        if (r5 == null) {
            C1283.m16863("MdxControllerCast", "onSendMessageResult, no target to handle message. %s", str);
            return;
        }
        SessionMdxTarget r6 = r5.mo791();
        if (r6 != null) {
            r6.m794(z);
        } else {
            C1283.m16863("MdxControllerCast", "onSendMessageResult, no target to handle message. %s %b", str, Boolean.valueOf(z));
        }
    }

    @Override // o.AbstractC1709eV
    /* renamed from: ˏ */
    public void mo6274(String str, String str2, String str3) {
        C1825gk r4 = m6440(str2);
        if (r4 == null) {
            C1283.m16863("MdxControllerCast", "onMessageReceived, no target to handle message. %s", str2);
            return;
        }
        SessionMdxTarget r5 = r4.mo791();
        if (r5 == null) {
            C1283.m16863("MdxControllerCast", "onMessageReceived, no target to handle message. %s %s", str2, str3);
            return;
        }
        try {
            JSONObject r6 = C1829go.m6692(str);
            if ("/pairingresponse".equals(str3) || "/regpairreply".equals(str3) || "/regpairerror".equals(str3)) {
                r5.m785(r6);
            } else if ("/session".equals(str3)) {
                r5.m780(r6);
            } else if ("/broadcast".equals(str3)) {
                C1283.m16862("MdxControllerCast", "onMessageReceived, CAST not handle broadcast message");
            } else if ("/error".equals(str3)) {
                r5.m787(r6);
            } else {
                C1283.m16863("MdxControllerCast", "onMessageReceived, not handling %s", str3);
            }
        } catch (JSONException e) {
            C1283.m16863("MdxControllerCast", "handleIncommingMdxMessage, JSONException %s", e);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1825gk m6440(String str) {
        synchronized (this.f6762) {
            Iterator it = this.f6762.iterator();
            while (it.hasNext()) {
                AbstractC1823gi giVar = (AbstractC1823gi) it.next();
                if (giVar.mo6670(str)) {
                    return (C1825gk) giVar;
                }
            }
            return null;
        }
    }
}
