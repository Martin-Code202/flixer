package o;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import o.C1845hd;
import o.gY;
import o.gZ;
/* renamed from: o.ha  reason: case insensitive filesystem */
public class C1842ha extends AbstractC1052 implements Handler.Callback {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final long f7190 = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final long f7191 = TimeUnit.SECONDS.toMillis(30);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final long f7192 = TimeUnit.DAYS.toMillis(1);

    /* renamed from: ʻ  reason: contains not printable characters */
    private Handler f7193;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f7194;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f7195;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC0661 f7196;

    /* renamed from: ˎ  reason: contains not printable characters */
    private HandlerThread f7197;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private AbstractC0677 f7198 = new AbstractC0677() { // from class: o.ha.3
        @Override // o.AbstractC0677
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo7028(AbstractC0633 r3) {
            C1842ha.this.f7193.obtainMessage(4099, r3).sendToTarget();
        }
    };

    /* renamed from: ͺ  reason: contains not printable characters */
    private AbstractC1370Co f7199;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1845hd.AbstractC0114 f7200 = new C1845hd.AbstractC0114() { // from class: o.ha.5
        @Override // o.C1845hd.AbstractC0114
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo7029(String str, int i) {
            C1842ha.this.f7193.obtainMessage(4102, i, 0, str).sendToTarget();
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Map<String, C1846he> f7201 = new HashMap();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private gY f7202;

    public C1842ha(AbstractC0661 r2) {
        this.f7196 = r2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        if (m7022()) {
            this.f7199 = new C1375Cr((int) f7191, 0.0d, 2.0d, (int) (f7191 << 3), (int) (f7191 << 5));
            this.f7197 = new HandlerThread("nf_probe", 1);
            this.f7197.start();
            this.f7193 = new Handler(this.f7197.getLooper(), this);
            this.f7193.sendEmptyMessageDelayed(4096, f7191);
        }
        m16090(AbstractC0367.f13235);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m7022() {
        long currentTimeMillis = System.currentTimeMillis();
        long r8 = C1339Bl.m4044(m16093(), "prefs_last_probe_timestamp", 0);
        if (currentTimeMillis > f7192 + r8) {
            C1339Bl.m4043(m16093(), "prefs_last_probe_timestamp", currentTimeMillis);
            return true;
        }
        C1283.m16851("nf_probe", "probe test disabled for this app session (%d minutes since previous)", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis - r8)));
        return false;
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        m7020();
        super.mo1236();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 4096:
                m7025();
                return false;
            case 4097:
                m7016();
                return false;
            case 4098:
                m7026((gY) message.obj);
                return false;
            case 4099:
                m7027((AbstractC0633) message.obj);
                return false;
            case 4100:
                m7017();
                return false;
            case 4101:
                m7015();
                return false;
            case 4102:
                m7023((String) message.obj, message.arg1);
                return false;
            default:
                return false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7025() {
        AbstractC1250 t_ = t_();
        if (t_ == null || t_.mo15845()) {
            C1283.m16854("nf_probe", "delaying probe for playback");
            this.f7193.sendEmptyMessageDelayed(4096, f7191);
            return;
        }
        C1283.m16854("nf_probe", "sending probe config request");
        m16092(new gZ(this.f7195, m7021(), new gZ.If() { // from class: o.ha.2
            @Override // o.gZ.If
            /* renamed from: ॱ */
            public void mo6643(gY gYVar) {
                C1842ha.this.f7193.obtainMessage(4098, gYVar).sendToTarget();
            }

            @Override // o.gZ.If
            /* renamed from: ˎ */
            public void mo6642() {
                long r2 = C1842ha.this.f7199.mo4515();
                if (r2 > 0) {
                    C1842ha.this.f7193.sendEmptyMessageDelayed(4096, r2);
                }
            }
        }));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7026(gY gYVar) {
        C1283.m16851("nf_probe", "iteration %d: received probe config: %s probes, %s iterations", Integer.valueOf(this.f7194), Integer.valueOf(gYVar.m6636().length), Integer.valueOf(gYVar.m6633()));
        this.f7202 = gYVar;
        this.f7201.clear();
        this.f7194 = 0;
        this.f7196.mo14825(this.f7198);
        gY.If[] r5 = gYVar.m6636();
        for (gY.If r9 : r5) {
            if (r9.m6639()) {
                this.f7201.put(r9.m6638(), new C1846he(r9));
            }
        }
        if (this.f7201.isEmpty() || gYVar.m6633() == 0) {
            this.f7193.sendEmptyMessage(4100);
            return;
        }
        this.f7193.sendEmptyMessage(4097);
        this.f7193.sendEmptyMessageDelayed(4101, f7190);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7016() {
        for (Map.Entry<String, C1846he> entry : this.f7201.entrySet()) {
            C1283.m16851("nf_probe", "iteration %d: sending probe to %s", Integer.valueOf(this.f7194), entry.getKey());
            entry.getValue().m7043();
            m16092(new C1845hd(entry.getKey(), this.f7200));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7023(String str, int i) {
        if (this.f7201.containsKey(str)) {
            C1283.m16851("nf_probe", "iteration %d: received http response from %s", Integer.valueOf(this.f7194), str);
            this.f7201.get(str).m7045((long) i);
            m7019();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7027(AbstractC0633 r6) {
        if (this.f7201.containsKey(r6.mo14768())) {
            C1283.m16851("nf_probe", "iteration %d: received probe response from %s", Integer.valueOf(this.f7194), r6.mo14768());
            this.f7201.get(r6.mo14768()).m7044(r6);
            m7019();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7019() {
        boolean z = true;
        Iterator<C1846he> it = this.f7201.values().iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().m7046()) {
                    z = false;
                    break;
                }
            } else {
                break;
            }
        }
        if (this.f7202 != null && z) {
            this.f7194++;
            if (this.f7194 < this.f7202.m6633()) {
                C1283.m16851("nf_probe", "iteration %d: received all probe responses - scheduling another iteration in %s", Integer.valueOf(this.f7194 - 1), Long.valueOf(this.f7202.m6634()));
                this.f7193.sendEmptyMessageDelayed(4097, this.f7202.m6634());
                return;
            }
            this.f7193.sendEmptyMessage(4100);
        }
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m7017() {
        C1283.m16854("nf_probe", "probing test finished");
        this.f7193.removeMessages(4101);
        this.f7196.mo14828(this.f7198);
        if (this.f7202 != null && !this.f7201.isEmpty()) {
            gW gWVar = new gW(this.f7202.m6630(), this.f7202.m6631(), this.f7201.values());
            m16086().mo1512().mo5226(gWVar);
            C1283.m16846("nf_probe", gWVar.mo5756());
        }
        if (this.f7202 == null || !this.f7202.m6635()) {
            C1283.m16854("nf_probe", "config instructed us to keep away - disabling future probing");
            this.f7197.quitSafely();
        } else {
            C1283.m16851("nf_probe", "scheduling another probe cycle in %s", Long.valueOf(this.f7202.m6632()));
            this.f7193.sendEmptyMessageDelayed(4096, this.f7202.m6632());
        }
        this.f7201.clear();
        this.f7202 = null;
        this.f7195++;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m7015() {
        C1283.m16850("nf_probe", "FTL probe timeout");
        m7020();
        this.f7201.clear();
        this.f7202 = null;
        m7017();
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private void m7020() {
        if (this.f7193 != null) {
            this.f7193.removeMessages(4096);
            this.f7193.removeMessages(4097);
            this.f7193.removeMessages(4098);
            this.f7193.removeMessages(4099);
            this.f7193.removeMessages(4100);
            this.f7193.removeMessages(4101);
        }
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private boolean m7021() {
        return false;
    }
}
