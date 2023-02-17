package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.chromecast.background.Channel;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.mdx.logging.MdxErrorCode;
import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import com.netflix.mediaclient.service.mdx.logging.connection.ConnectLogblob;
import com.netflix.mediaclient.service.mdx.logging.connection.MdxConnectionLogblobLogger;
import java.util.HashMap;
import java.util.Map;
import o.C1771fe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.eW  reason: case insensitive filesystem */
public class C1710eW extends MediaRouter.Callback implements C1771fe.AbstractC0109 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f6605 = C1710eW.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private MediaRouteSelector f6606;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private long f6607 = 0;

    /* renamed from: ʼ  reason: contains not printable characters */
    private MediaRouter f6608;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Map<String, MediaRouter.RouteInfo> f6609 = new HashMap();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f6610;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Context f6611;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f6612;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Handler f6613;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Handler f6614;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f6615;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f6616;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6617 = "CA5E8412";

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private AbstractC1709eV f6618;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f6619;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private MediaRouter.RouteInfo f6620;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1767fa f6621;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1771fe f6622;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean f6623;

    public C1710eW(Context context, Handler handler, Handler handler2, String str, C1767fa faVar) {
        if (str == null) {
            throw new IllegalArgumentException("ESN can not be null!");
        }
        this.f6611 = context.getApplicationContext();
        this.f6614 = handler;
        this.f6613 = handler2;
        this.f6616 = str;
        this.f6621 = faVar;
        handler.post(new Runnable() { // from class: o.eW.3
            @Override // java.lang.Runnable
            public void run() {
                C1710eW.this.f6608 = MediaRouter.getInstance(C1710eW.this.f6611);
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Looper m6323() {
        return this.f6613.getLooper();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6322(AbstractC1709eV eVVar) {
        this.f6618 = eVVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6328(JSONArray jSONArray) {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m6320() {
        if (this.f6623) {
            C1283.m16854(f6605, "CastManager already started. You must stop it before starting it.");
            return;
        }
        this.f6623 = true;
        if (C1349Bv.m4107(C0352.m13955(this.f6611))) {
            this.f6617 = C0352.m13955(this.f6611);
        }
        C0352.m13954(this.f6611, this.f6617);
        try {
            this.f6606 = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.f6617)).build();
            m6312();
        } catch (IllegalArgumentException e) {
            C1283.m16850(f6605, "MediaRouteSelector: " + e);
            C0352.m13954(this.f6611, "==invalid ApplicationId==");
            C1004.m15961(this.f6611, "Invalid ApplicationId, Enter New One", 1);
            throw new IllegalArgumentException("Invalid ApplicationId!");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m6326() {
        this.f6623 = false;
        m6311();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6317() {
        this.f6613.post(new Runnable() { // from class: o.eW.4
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854(C1710eW.f6605, "disconnect ApiClient");
                if (null != C1710eW.this.f6622) {
                    C1710eW.this.f6622.m6390();
                    C1710eW.this.f6622 = null;
                }
                C1710eW.this.mo6315("user disconnect");
                C1283.m16854(C1710eW.f6605, "ApiClient disconnected");
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6314() {
        this.f6621 = null;
        this.f6618 = null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6325(final String str, final boolean z) {
        this.f6614.post(new Runnable() { // from class: o.eW.2
            @Override // java.lang.Runnable
            public void run() {
                C1710eW.this.f6620 = null;
                for (MediaRouter.RouteInfo routeInfo : C1710eW.this.f6608.getRoutes()) {
                    if (str.equalsIgnoreCase(C1710eW.this.m6309(routeInfo.getId()))) {
                        C1710eW.this.f6620 = routeInfo;
                        C1710eW.this.f6615 = str;
                    }
                }
                if (null == C1710eW.this.f6620) {
                    C1283.m16850(C1710eW.f6605, "launchNetflix failed, there is no route for" + str);
                    return;
                }
                C1710eW.this.f6610 = z;
                if (!C1710eW.this.f6608.getSelectedRoute().equals(C1710eW.this.f6620)) {
                    C1710eW.this.f6608.selectRoute(C1710eW.this.f6620);
                } else {
                    C1710eW.this.m6286(C1710eW.this.f6620);
                }
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6327(String str) {
        m6280(m6276(str));
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m6330() {
        C1283.m16854(f6605, "restartCastDiscoveryIfNeeded");
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f6607 > 0 && currentTimeMillis > this.f6607 + 16000 && this.f6608 != null) {
            this.f6607 = currentTimeMillis;
            m6301();
            C1283.m16854(f6605, "restartCastDiscoveryIfNeeded, restarted");
            m6306();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m6312() {
        this.f6614.post(new Runnable() { // from class: o.eW.9
            @Override // java.lang.Runnable
            public void run() {
                C1710eW.this.f6607 = System.currentTimeMillis();
                C1710eW.this.f6609.clear();
                C1710eW.this.m6306();
                try {
                    MediaRouter.RouteInfo selectedRoute = C1710eW.this.f6608.getSelectedRoute();
                    if (null != selectedRoute && selectedRoute.matchesSelector(C1710eW.this.f6606)) {
                        C1710eW.this.f6620 = selectedRoute;
                        C1710eW.this.onRouteAdded(C1710eW.this.f6608, C1710eW.this.f6620);
                    }
                } catch (Exception e) {
                    C1283.m16851(C1710eW.f6605, "startDiscovery ", e);
                }
            }
        });
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m6311() {
        this.f6614.post(new Runnable() { // from class: o.eW.8
            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0019: APUT  
              (r2v1 java.lang.Object[])
              (0 ??[int, short, byte, char])
              (wrap: java.lang.Boolean : 0x0014: INVOKE  (r3v3 java.lang.Boolean) = (r3v2 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
             */
            @Override // java.lang.Runnable
            public void run() {
                String str = C1710eW.f6605;
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(C1710eW.this.f6620 != null);
                C1283.m16851(str, "stopDiscovery hasSelectedRoute=%b", objArr);
                C1710eW.this.m6301();
                C1710eW.this.f6607 = 0;
                C1710eW.this.f6609.clear();
                C1283.m16854(C1710eW.f6605, "stopDiscovery done");
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6286(MediaRouter.RouteInfo routeInfo) {
        if (null == routeInfo) {
            mo6316("castLaunchApplication - Launch route is null", null);
            return;
        }
        CastDevice fromBundle = CastDevice.getFromBundle(routeInfo.getExtras());
        if (null == fromBundle) {
            mo6316("castLaunchApplication - Launch CastDevice is null", null);
        } else {
            this.f6622 = new C1771fe(this.f6611, this.f6617, fromBundle, this, this.f6610, this.f6621);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private String m6309(String str) {
        int indexOf;
        int length;
        if (str != null && (indexOf = str.indexOf("CastMediaRouteProviderService:")) >= 0 && str.length() > (length = indexOf + "CastMediaRouteProviderService:".length())) {
            return str.substring(length);
        }
        return null;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m6280(String str) {
        if (null != this.f6622) {
            try {
                this.f6622.m6391(str);
            } catch (Exception e) {
                C1283.m16850(f6605, "sendCastMessage caught an exception " + e);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6283(final String str, final String str2, final String str3) {
        if (this.f6618 == null) {
            C1283.m16865(f6605, "CastManagerListener is not set");
        } else {
            this.f6613.post(new Runnable() { // from class: o.eW.10
                @Override // java.lang.Runnable
                public void run() {
                    C1710eW.this.f6618.mo6272(str, str2, str3);
                }
            });
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m6308(final String str) {
        if (this.f6618 == null) {
            C1283.m16865(f6605, "CastManagerListener is not set");
        } else {
            this.f6613.post(new Runnable() { // from class: o.eW.7
                @Override // java.lang.Runnable
                public void run() {
                    C1710eW.this.f6618.mo6271(str);
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6299(final boolean z, final String str) {
        if (this.f6618 == null) {
            C1283.m16865(f6605, "CastManagerListener is not set");
        } else {
            this.f6613.post(new Runnable() { // from class: o.eW.6
                @Override // java.lang.Runnable
                public void run() {
                    C1710eW.this.f6618.mo6275(z, str);
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6288(final boolean z, final String str) {
        if (this.f6618 == null) {
            C1283.m16865(f6605, "CastManagerListener is not set");
        } else {
            this.f6613.post(new Runnable() { // from class: o.eW.13
                @Override // java.lang.Runnable
                public void run() {
                    C1710eW.this.f6618.mo6273(z, str);
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6287(final String str, final String str2, final String str3) {
        if (this.f6618 == null) {
            C1283.m16865(f6605, "CastManagerListener is not set");
        } else {
            this.f6613.post(new Runnable() { // from class: o.eW.1
                @Override // java.lang.Runnable
                public void run() {
                    C1710eW.this.f6618.mo6274(str, str2, str3);
                }
            });
        }
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        if (!this.f6608.getSelectedRoute().equals(this.f6620)) {
            this.f6620 = this.f6608.getSelectedRoute();
        }
        m6286(this.f6620);
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        if (null != this.f6622) {
            this.f6622.m6390();
            this.f6622 = null;
        }
        this.f6620 = null;
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        if (null == CastDevice.getFromBundle(routeInfo.getExtras())) {
            C1283.m16854(f6605, "device is not whitelisted");
        } else {
            m6283(m6309(routeInfo.getId()), m6282(routeInfo), C1349Bv.m4113(this.f6612) ? routeInfo.getName() : this.f6612 + routeInfo.getName());
        }
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        this.f6609.remove(m6309(routeInfo.getId()));
        if (null != routeInfo) {
            m6308(m6309(routeInfo.getId()));
        }
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        onRouteAdded(mediaRouter, routeInfo);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6294(final CastDevice castDevice, final String str) {
        this.f6613.post(new Runnable() { // from class: o.eW.5
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854(C1710eW.f6605, "send message to cast device, " + castDevice + ", " + str);
                C1283.m16854(C1710eW.f6605, "returns " + Channel.sendMessage(castDevice, str));
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6324(String str) {
        C1283.m16854(f6605, "sending prefetch message, " + str);
        for (MediaRouter.RouteInfo routeInfo : this.f6609.values()) {
            CastDevice fromBundle = CastDevice.getFromBundle(routeInfo.getExtras());
            C1283.m16854(f6605, "schedule sending message to cast device, " + fromBundle);
            m6294(fromBundle, str);
        }
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onProviderAdded(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onProviderChanged(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
    }

    @Override // android.support.v7.media.MediaRouter.Callback
    public void onProviderRemoved(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m6291(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "castHandShake").put("uuid", str).put("controlleruuid", this.f6616).put("friendlyName", str2).put("payload", "intent=sync");
            return jSONObject.toString();
        } catch (JSONException e) {
            C1283.m16850(f6605, "createCastHandShakeMessage failed, e");
            return null;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private String m6276(String str) {
        String r2 = m6278(str);
        if (C1349Bv.m4113(r2)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FalkorPathResult.PATH, r2).put("body", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            C1283.m16850(f6605, "createMessage failed");
            return null;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private String m6278(String str) {
        int length;
        int indexOf;
        int indexOf2 = str.indexOf("action=");
        if (indexOf2 < 0 || (indexOf = str.indexOf("\r\n", indexOf2)) <= (length = indexOf2 + "action=".length())) {
            return null;
        }
        return str.substring(length, indexOf);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m6282(MediaRouter.RouteInfo routeInfo) {
        return CastDevice.getFromBundle(routeInfo.getExtras()).getIpAddress().getHostAddress();
    }

    @Override // o.C1771fe.AbstractC0109
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6319(String str, Integer num) {
        C1283.m16854(f6605, "onFailToConnect");
        if (null != this.f6620) {
            this.f6621.m6374(this.f6620.getName() + ": cannot connect to netflix, " + str);
            m6298(str, num);
        } else {
            C1283.m16854(f6605, "onFailToConnect, no selected route");
        }
        m6289();
    }

    @Override // o.C1771fe.AbstractC0109
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6316(String str, Integer num) {
        C1283.m16854(f6605, "onFailToLaunch");
        if (null != this.f6620) {
            this.f6621.m6368(this.f6620.getName() + ": cannot launch netflix, " + str);
            m6298(str, num);
            m6299(false, m6309(this.f6620.getId()));
            return;
        }
        C1283.m16854(f6605, "onFailToLaunch, no selected route");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6298(String str, Integer num) {
        String str2;
        String str3;
        if (null == this.f6620) {
            return;
        }
        if (!MdxConnectionLogblobLogger.m688()) {
            MdxConnectionLogblobLogger r0 = this.f6621.m6373();
            ConnectLogblob.LaunchOrigin launchOrigin = ConnectLogblob.LaunchOrigin.Launch;
            MdxTargetType mdxTargetType = MdxTargetType.Cast;
            String r3 = m6309(this.f6620.getId());
            String name = this.f6620.getName();
            MdxErrorCode mdxErrorCode = MdxErrorCode.ConnectFailed;
            if (num != null) {
                str3 = num.toString();
            } else {
                str3 = null;
            }
            r0.m700(launchOrigin, mdxTargetType, r3, name, false, mdxErrorCode, null, str3, str, null);
            return;
        }
        MdxConnectionLogblobLogger r02 = this.f6621.m6373();
        MdxTargetType mdxTargetType2 = MdxTargetType.Cast;
        String r2 = m6309(this.f6620.getId());
        String name2 = this.f6620.getName();
        MdxErrorCode mdxErrorCode2 = MdxErrorCode.ReconnectFailed;
        if (num != null) {
            str2 = num.toString();
        } else {
            str2 = null;
        }
        r02.m703(mdxTargetType2, r2, name2, false, mdxErrorCode2, null, str2, str, null);
    }

    @Override // o.C1771fe.AbstractC0109
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void mo6329() {
        C1283.m16854(f6605, "onLaunched");
        if (null != this.f6620) {
            m6280(m6291(m6309(this.f6620.getId()), this.f6620.getName()));
        } else {
            C1283.m16854(f6605, "onLaunched, no selected route");
        }
    }

    @Override // o.C1771fe.AbstractC0109
    /* renamed from: ʽ  reason: contains not printable characters */
    public void mo6313() {
        C1283.m16854(f6605, "onMessageSent");
        if (null != this.f6620) {
            m6288(true, m6309(this.f6620.getId()));
        } else {
            C1283.m16854(f6605, "onMessageSent, no selected route");
        }
    }

    @Override // o.C1771fe.AbstractC0109
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6318(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("body");
            String optString2 = jSONObject.optString("url");
            if (optString2.indexOf("/") >= 0) {
                str2 = optString2.substring(optString2.lastIndexOf("/"));
            } else {
                str2 = optString2;
            }
            String optString3 = jSONObject.optString("type");
            if (optString3.equals("castHandShakeAck") && null != this.f6620) {
                m6299(true, m6309(this.f6620.getId()));
            } else if (optString3.equals("castHandShakeRequest")) {
                C1283.m16854(f6605, "onMessageReceived castHandShakeRequest");
                mo6329();
            } else if (null != this.f6620) {
                m6287(optString, m6309(this.f6620.getId()), str2);
            } else {
                C1283.m16854(f6605, "onMessageReceived, no selected route");
            }
        } catch (JSONException e) {
            C1283.m16847(f6605, "error onMessageReceived ", e);
        }
    }

    @Override // o.C1771fe.AbstractC0109
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6321(String str) {
        C1283.m16854(f6605, "onFailToSendMessage");
        if (null != this.f6620) {
            this.f6621.m6372(this.f6620.getName() + ": cannot send message, " + str);
            m6288(false, m6309(this.f6620.getId()));
            return;
        }
        C1283.m16854(f6605, "onFailToSendMessage, no selected route");
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m6289() {
        if (null != this.f6620) {
            String r3 = m6309(this.f6620.getId());
            if (C1349Bv.m4107(this.f6615) && !this.f6615.equalsIgnoreCase(r3)) {
                r3 = this.f6615;
            }
            m6287("action=endCastSession\r\nfromuuid=" + r3 + "\r\n", m6309(this.f6620.getId()), "session");
        }
    }

    @Override // o.C1771fe.AbstractC0109
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6315(String str) {
        MediaRouter.RouteInfo routeInfo = this.f6620;
        if (null != routeInfo) {
            this.f6621.m6371(routeInfo.getName() + ": netflix stopped, " + str);
            String r4 = m6309(routeInfo.getId());
            m6289();
            m6299(false, r4);
        }
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0027: APUT  
      (r2v1 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x0022: INVOKE  (r3v2 java.lang.Boolean) = (r3v1 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m6306() {
        if (this.f6608 == null || this.f6619) {
            String str = f6605;
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f6608 == null);
            objArr[1] = Boolean.valueOf(this.f6619);
            C1283.m16851(str, "addCallback mediaRouterIsNull=%b mCallbackAdded=%b", objArr);
            return;
        }
        this.f6608.addCallback(this.f6606, this, 1);
        this.f6619 = true;
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0024: APUT  
      (r2v1 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x001f: INVOKE  (r3v2 java.lang.Boolean) = (r3v1 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m6301() {
        if (!this.f6619 || this.f6608 == null) {
            String str = f6605;
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f6608 == null);
            objArr[1] = Boolean.valueOf(this.f6619);
            C1283.m16851(str, "removeCallback mediaRouterIsNull=%b mCallbackAdded=%b", objArr);
            return;
        }
        this.f6608.removeCallback(this);
        this.f6619 = false;
    }
}
