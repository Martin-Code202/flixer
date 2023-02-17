package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.々  reason: contains not printable characters */
public class C1068 implements AbstractC2057pf {

    /* renamed from: ʻ  reason: contains not printable characters */
    private List<C2054pc> f15217;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Handler f15218;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f15219;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final iE f15220;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f15221;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final oE f15222;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ConnectivityUtils.NetType f15223;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private iF f15224;

    public C1068(Context context, oE oEVar, iE iEVar) {
        this.f15221 = context;
        this.f15222 = oEVar;
        this.f15220 = iEVar;
        m16134();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16140() {
        if (this.f15224 == null) {
            this.f15224 = new iF();
            AG.m3334(this.f15221, this.f15224, null, "com.netflix.mediaclient.intent.action.HOME_TTR_DONE");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16139() {
        m16133();
        m16132();
    }

    @Override // o.AbstractC2057pf
    /* renamed from: ˋ */
    public void mo9729(String str, long j, PlayerPrefetchSource playerPrefetchSource, oX oXVar) {
        oG r8;
        if (!playerPrefetchSource.m1562(this.f15223)) {
            try {
                C2054pc pcVar = new C2054pc(str, j, playerPrefetchSource, oXVar);
                if (!this.f15219) {
                    if (this.f15217 == null) {
                        this.f15217 = new ArrayList();
                    }
                    this.f15217.add(pcVar);
                    if (this.f15217.size() > 20) {
                        this.f15217.remove(0);
                    }
                    m16137();
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(pcVar);
                if (!this.f15222.mo9424().mo16543() && (r8 = this.f15222.mo9411()) != null) {
                    r8.mo6181(arrayList);
                }
                this.f15220.m7426().mo7795(arrayList);
            } catch (NumberFormatException e) {
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16138() {
        m16134();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16134() {
        this.f15223 = ConnectivityUtils.m2958(this.f15221);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16133() {
        if (this.f15224 != null) {
            AG.m3329(this.f15221, this.f15224);
            this.f15224 = null;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m16132() {
        if (this.f15218 != null) {
            this.f15218.removeCallbacks(null);
            this.f15218 = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.々$iF */
    public final class iF extends BroadcastReceiver {
        private iF() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16862("nf_prepareHelperImpl", "TTR done broadcast received, process any pending items.");
            C1068.this.m16136();
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m16137() {
        if (this.f15218 == null) {
            this.f15218 = new Handler();
            this.f15218.postDelayed(new Runnable() { // from class: o.々.2
                @Override // java.lang.Runnable
                public void run() {
                    C1283.m16862("nf_prepareHelperImpl", "ttr timed-out, process any pending requests");
                    C1068.this.m16136();
                }
            }, 10000);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m16136() {
        this.f15219 = true;
        m16133();
        m16132();
        if (this.f15217 != null) {
            for (C2054pc pcVar : this.f15217) {
                mo9729(pcVar.f9382, pcVar.f9378, pcVar.f9380, pcVar.f9379);
            }
            this.f15217.clear();
            this.f15217 = null;
        }
    }
}
