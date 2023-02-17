package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.ClientActionFromLase;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import o.hQ;
import o.hS;
public class hR implements hS, hQ.If {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final IClientLogging f7166;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Queue<hN> f7167 = new LinkedList();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Queue<hQ> f7168 = new LinkedList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final iT f7169;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Queue<hP> f7170 = new LinkedList();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Handler f7171;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Context f7172;

    public hR(Context context, Looper looper, iT iTVar, IClientLogging iClientLogging) {
        this.f7172 = context;
        this.f7171 = new Handler(looper);
        this.f7169 = iTVar;
        this.f7166 = iClientLogging;
    }

    @Override // o.hS
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6973(String str, byte[] bArr, String str2, String str3, String str4, hT hTVar) {
        C1283.m16863("nf_offlineLicenseMgr", "requestNewLicense playableId=%s", str);
        hQ hQVar = new hQ(str, bArr, str2, hTVar, this, this.f7169, this.f7171, str3, str4);
        this.f7168.add(hQVar);
        if (this.f7170.size() + this.f7168.size() + this.f7167.size() <= 1) {
            hQVar.mo6958();
        } else {
            C1283.m16862("nf_offlineLicenseMgr", "requestNewLicense serializing the request");
        }
    }

    @Override // o.hS
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6974(IBladeRunnerClient.OfflineRefreshInvoke offlineRefreshInvoke, String str, byte[] bArr, byte[] bArr2, String str2, String str3, String str4, hT hTVar) {
        C1283.m16862("nf_offlineLicenseMgr", "refreshLicense playableId=" + str);
        hP hPVar = new hP(offlineRefreshInvoke, str, bArr, str2, hTVar, this, this.f7169, this.f7171, bArr2, str3, str4);
        this.f7170.add(hPVar);
        if (this.f7170.size() + this.f7168.size() + this.f7167.size() <= 1) {
            hPVar.mo6958();
        } else {
            C1283.m16862("nf_offlineLicenseMgr", "refreshLicense serializing the request");
        }
    }

    @Override // o.hS
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6976(String str, byte[] bArr, boolean z, String str2, String str3, String str4, hT hTVar) {
        C1283.m16862("nf_offlineLicenseMgr", "deleteLicense playableId=" + str);
        hN hNVar = new hN(str, bArr, z, hTVar, this, this.f7169, str2, this.f7171, str3, str4);
        this.f7167.add(hNVar);
        if (this.f7170.size() + this.f7168.size() + this.f7167.size() <= 1) {
            hNVar.mo6958();
        } else {
            C1283.m16862("nf_offlineLicenseMgr", "deleteLicense serializing the request");
        }
    }

    @Override // o.hS
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6972() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6971() {
        C1283.m16863("nf_offlineLicenseMgr", "trySendingNextRequest %d %d %d", Integer.valueOf(this.f7168.size()), Integer.valueOf(this.f7170.size()), Integer.valueOf(this.f7167.size()));
        hQ peek = this.f7168.peek();
        if (peek != null) {
            peek.mo6958();
            return;
        }
        hP peek2 = this.f7170.peek();
        if (peek2 != null) {
            peek2.mo6958();
            return;
        }
        hN peek3 = this.f7167.peek();
        if (peek3 != null) {
            peek3.mo6958();
        }
    }

    @Override // o.hQ.If
    /* renamed from: ˏ */
    public void mo6970(hQ hQVar, Status status) {
        C1283.m16863("nf_offlineLicenseMgr", "onLicenseRequestDone %s %s %d %d %d", hQVar.f7151, hQVar.getClass().getSimpleName(), Integer.valueOf(this.f7168.size()), Integer.valueOf(this.f7170.size()), Integer.valueOf(this.f7167.size()));
        if (!(hQVar instanceof hP)) {
            if (!(hQVar instanceof hN)) {
                Iterator<hQ> it = this.f7168.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().f7151.equals(hQVar.f7151)) {
                            C1283.m16862("nf_offlineLicenseMgr", "onLicenseRequestDone removing from mNewLicenseRequestQueue");
                            it.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                Iterator<hN> it2 = this.f7167.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().f7151.equals(hQVar.f7151)) {
                            C1283.m16862("nf_offlineLicenseMgr", "onLicenseRequestDone removing from mDeactivateOfflineLicenseRequestQueue");
                            it2.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            Iterator<hP> it3 = this.f7170.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (it3.next().f7151.equals(hQVar.f7151)) {
                        C1283.m16862("nf_offlineLicenseMgr", "onLicenseRequestDone removing from mRefreshLicenseRequestQueue");
                        it3.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (status.mo301()) {
            hW.m6997(this.f7166.mo1512(), hQVar.f7151, hQVar.f7153, hQVar.f7155, status);
            C1614ch.m5845(this.f7172, hQVar.f7151, status);
        }
        m6971();
    }

    @Override // o.hS
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6975(List<String> list, final hS.AbstractC0113 r7) {
        C1283.m16863("nf_offlineLicenseMgr", "sendSyncActiveLicensesToServer %d", Integer.valueOf(list.size()));
        this.f7169.m7574(list, new AbstractC1903jd() { // from class: o.hR.1
            @Override // o.AbstractC1903jd, o.iX
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo6977(Map<String, ClientActionFromLase> map, Status status) {
                C1283.m16863("nf_offlineLicenseMgr", "onSyncLicenseDone res=%s", status);
                r7.mo6978(map, status);
            }
        });
    }
}
