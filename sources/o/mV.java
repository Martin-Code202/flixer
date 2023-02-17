package o;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.preapp.PreAppAgentEventType;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.model.leafs.LoLoMoSummary;
import java.util.List;
public class mV extends AbstractC1052 implements mU {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Runnable f8840 = new Runnable() { // from class: o.mV.2
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16862("nf_preappagent", "inform prefetch done via runnable");
            if (mV.this.m16093() != null) {
                mV.m8963(mV.this.m16093());
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC2023o f8841;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0149 f8842 = new C0149();

    /* renamed from: ˎ  reason: contains not printable characters */
    public final BroadcastReceiver f8843 = new BroadcastReceiver() { // from class: o.mV.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE".equals(intent.getAction())) {
                C1283.m16862("nf_preappagent", "UserAgentIntentReceiver invoked and received Intent with Action NOTIFY_USER_ACCOUNT_DEACTIVE");
                mV.this.m8946(context);
            }
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    private final UserAgentInterface f8844;

    /* renamed from: ॱ  reason: contains not printable characters */
    private mS f8845;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final BroadcastReceiver f8846 = new BroadcastReceiver() { // from class: o.mV.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (!((AbstractC2104qx) C1281.m16832(AbstractC2104qx.class)).mo10123(context)) {
                    C1283.m16854("nf_preappagent", "widget not installed - skip fetching data");
                } else if ("com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_ALL_MEMBER_UPDATED".equals(action)) {
                    mV.this.f8845.m8942(PreAppAgentEventType.ALL_MEMBER_UPDATED);
                } else if ("com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_CW_UPDATED".equals(action)) {
                    mV.this.f8845.m8942(PreAppAgentEventType.CW_UPDATED);
                } else if ("com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_IQ_UPDATED".equals(action)) {
                    mV.this.f8845.m8942(PreAppAgentEventType.IQ_UPDATED);
                } else if ("com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_NON_MEMBER_UPDATED".equals(action)) {
                    mV.this.f8845.m8942(PreAppAgentEventType.NON_MEMBER_UPDATED);
                }
            }
        }
    };

    public mV(AbstractC2023o oVar, UserAgentInterface userAgentInterface) {
        this.f8841 = oVar;
        this.f8844 = userAgentInterface;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        this.f8845 = new mS(m16093(), this);
        m8949();
        m8956();
        m8954();
        m16090(AbstractC0367.f13235);
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        m8962();
        m8952();
        m8950();
        m8947();
        super.mo1236();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8949() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_ALL_MEMBER_UPDATED");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_CW_UPDATED");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_IQ_UPDATED");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_NON_MEMBER_UPDATED");
        LocalBroadcastManager.getInstance(m16093()).registerReceiver(this.f8846, intentFilter);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8962() {
        try {
            s_().removeCallbacks(this.f8840);
        } catch (Exception e) {
            C1283.m16862("nf_preappagent", "fail removing informPrefetchRunnable " + e);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8952() {
        try {
            LocalBroadcastManager.getInstance(m16093()).unregisterReceiver(this.f8846);
        } catch (Exception e) {
            C1283.m16862("nf_preappagent", "unregisterDataUpdateReceiver " + e);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8956() {
        LocalBroadcastManager.getInstance(m16093()).registerReceiver(this.f8843, C2018nv.m9354());
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m8950() {
        try {
            LocalBroadcastManager.getInstance(m16093()).unregisterReceiver(this.f8843);
        } catch (Exception e) {
            C1283.m16862("nf_preappagent", "unregisterUserAgentIntentReceiver " + e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m8946(Context context) {
        this.f8845.m8941(PreAppAgentEventType.ACCOUNT_DEACTIVATED);
    }

    @Override // o.mU
    /* renamed from: ˊ */
    public void mo8945(Context context) {
        s_().removeCallbacks(this.f8840);
        s_().postDelayed(this.f8840, 5000);
        m16095().mo7804(12, false, (AbstractC1203) new AbstractC1222() { // from class: o.mV.4
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ॱॱ */
            public void mo7398(List<pJ> list, Status status) {
                super.mo7398(list, status);
                mV.m8965(mV.this.m16093());
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m8953(Context context) {
        m8963(context);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m8963(Context context) {
        m8958(context, "com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_ALL_MEMBER_UPDATED");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m8960(Context context) {
        m8958(context, "com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_CW_UPDATED");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m8957(Context context) {
        m8958(context, "com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_IQ_UPDATED");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static void m8965(Context context) {
        m8958(context, "com.netflix.mediaclient.intent.action.PREAPP_AGENT_TO_NON_MEMBER_UPDATED");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m8958(Context context, String str) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(str));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m8967(Intent intent) {
        if (intent == null) {
            C1283.m16865("nf_preappagent", "Intent is null");
            return false;
        }
        String action = intent.getAction();
        AbstractC1899j r3 = m16095();
        if (r3 == null) {
            C1283.m16865("nf_preappagent", "browseAgent null?");
            return false;
        }
        AnonymousClass5 r4 = new AbstractC1222() { // from class: o.mV.5
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ॱॱ */
            public void mo7398(List<pJ> list, Status status) {
                super.mo7398(list, status);
                mV.m8965(mV.this.m16093());
            }
        };
        if (!"com.netflix.mediaclient.intent.action.REFRESH_DATA".equals(action)) {
            C1283.m16850("nf_preappagent", "Unknown command!");
            return false;
        } else if (this.f8844.mo1333()) {
            m8953(m16093());
            return true;
        } else {
            r3.mo7804(12, false, (AbstractC1203) r4);
            return true;
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static Notification m8966(Context context) {
        C1283.m16854("nf_preappagent", "building preApp foreground notification");
        return ((AbstractC2104qx) C1281.m16832(AbstractC2104qx.class)).mo10122(context);
    }

    @Override // o.mU
    /* renamed from: ʻ */
    public void mo8944(Context context) {
        C1283.m16854("nf_preappagent", "removing preApp foreground notification");
        s_().post(new Runnable() { // from class: o.mV.6
            @Override // java.lang.Runnable
            public void run() {
                mV.this.m16096().mo9578(32, true);
            }
        });
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m8947() {
        this.f8841.mo8790(this.f8842);
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private void m8954() {
        if (((AbstractC2104qx) C1281.m16832(AbstractC2104qx.class)).mo10123(m16093())) {
            C1283.m16854("nf_preappagent", "registering app widget maintenance action");
            this.f8841.mo8791(this.f8842);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.mV$ˊ  reason: contains not printable characters */
    public class C0149 implements AbstractC2078q {
        private C0149() {
        }

        @Override // o.AbstractC2078q
        /* renamed from: ˎ */
        public void mo7293(final int i) {
            C1283.m16854("nf_preappagent", "starting maintenance for app widget");
            if (mV.this.m16085().mo1333()) {
                C1283.m16854("nf_preappagent", "user logged in - prefetch lolomo for app widget ");
                mV.this.m16095().mo7819(6, 6, new AbstractC1222() { // from class: o.mV.ˊ.1
                    @Override // o.AbstractC1222, o.AbstractC1203
                    /* renamed from: ˎ */
                    public void mo7402(LoLoMoSummary loLoMoSummary, Status status) {
                        C1283.m16854("nf_preappagent", "fetchPreAppData - prefetch done");
                        mV.this.f8841.mo8793(mV.this.f8842, i);
                    }
                });
                return;
            }
            C1283.m16854("nf_preappagent", "user not logged in - fetch non member data for app widget");
            mV.this.m16095().mo7804(12, false, (AbstractC1203) new AbstractC1222() { // from class: o.mV.ˊ.4
                @Override // o.AbstractC1222, o.AbstractC1203
                /* renamed from: ॱॱ */
                public void mo7398(List<pJ> list, Status status) {
                    super.mo7398(list, status);
                    mV.m8965(mV.this.m16093());
                    mV.this.f8841.mo8793(mV.this.f8842, i);
                }
            });
        }

        @Override // o.AbstractC2078q
        /* renamed from: ˋ */
        public void mo7292() {
        }
    }
}
