package o;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import java.util.concurrent.ScheduledExecutorService;
import o.AbstractC2285x;
public class C extends AbstractC2285x implements AbstractC0479 {

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private HandlerThread f4681;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final Cif f4682 = new Cif();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected final S f4683 = new S();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private Handler f4684;

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ʼ */
    public /* bridge */ /* synthetic */ void mo3249() {
        super.mo3249();
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˊ */
    public /* bridge */ /* synthetic */ void mo208(AbstractC0457 r1) {
        super.mo208(r1);
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ void mo3253(ScheduledExecutorService scheduledExecutorService) {
        super.mo3253(scheduledExecutorService);
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ void mo209(AbstractC0457 r1) {
        super.mo209(r1);
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ void mo210(AbstractC0457 r1) {
        super.mo210(r1);
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ void mo211(AbstractC0457 r1, Intent intent) {
        super.mo211(r1, intent);
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ void mo3257(boolean z) {
        super.mo3257(z);
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo212(AbstractC0457 r1) {
        super.mo212(r1);
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ॱ */
    public /* bridge */ /* synthetic */ void mo3259() {
        super.mo3259();
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ॱ */
    public /* bridge */ /* synthetic */ void mo213(AbstractC0457 r1) {
        super.mo213(r1);
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ᐝ */
    public /* bridge */ /* synthetic */ void mo3261() {
        super.mo3261();
    }

    C(Context context, N n, UserAgentInterface userAgentInterface, AbstractC1221 r6) {
        super(context, n, userAgentInterface, r6);
        this.f4683.m5253(context);
        this.f4681 = new HandlerThread("CLv2Sender");
        this.f4681.start();
        this.f4684 = new Handler(this.f4681.getLooper());
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2285x
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo4163() {
        Logger.INSTANCE.m139(this);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2285x
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo4166(Intent intent) {
    }

    @Override // o.A
    /* renamed from: ˏॱ */
    public void mo3258() {
        m12736();
        m4159();
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m4159() {
        if (this.f11932.get()) {
            C1283.m16854("nf_log_clv2", "Local playback is in progress, consider that user just interacted with UI. Exit.");
            this.f11921.mo14203();
            return;
        }
        C1283.m16854("nf_log_clv2", "Local playback is NOT in progress, check last user interaction");
        long r3 = this.f11921.mo14207();
        long r5 = m12729();
        if (r3 >= r5 && Logger.INSTANCE.m141(C1241.class.getSimpleName())) {
            C1283.m16854("nf_log_clv2", "It is more than 30 minutes and user session exist. End user session");
            Logger.INSTANCE.m147(C1241.m16596(System.currentTimeMillis() - r3));
        } else if (r3 < r5 && !Logger.INSTANCE.m141(C1241.class.getSimpleName())) {
            C1283.m16854("nf_log_clv2", "It is less than 30 minutes and user session does NOT exist. Start user session");
            Logger.INSTANCE.m142(new C1241());
        }
    }

    @Override // o.AbstractC0479
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo4164(final AbstractC0611 r3) {
        this.f4684.post(new Runnable() { // from class: o.C.2
            @Override // java.lang.Runnable
            public void run() {
                C.this.m4157(r3);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m4157(AbstractC0611 r5) {
        C1348Bu.m4094();
        try {
            String jSONObject = r5.toJSONObject().toString();
            String r3 = m12733(jSONObject);
            this.f11922.add(r3);
            mo4167(r3, this.f11923.mo1340(), jSONObject, new AbstractC2285x.iF(jSONObject));
        } catch (Exception e) {
            C1283.m16847("nf_log_clv2", "Failed to create JSON object for logging request", e);
        }
    }

    @Override // o.AbstractC0479
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo4162() {
        this.f4682.m4057();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2285x
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo4167(String str, String str2, String str3, AbstractC1562bk bkVar) {
        C1283.m16854("nf_log_clv2", "sendLoggingEvents starts...");
        this.f11928.m16092(this.f11926.m5792(str2, str, str3, bkVar));
        C1283.m16854("nf_log_clv2", "sendLoggingEvents done.");
    }

    /* renamed from: o.C$if  reason: invalid class name */
    class Cif extends AbstractC1342Bo {
        public Cif() {
            super("nf_icl_queue", 30, 60000, true, true);
        }

        /* access modifiers changed from: protected */
        @Override // o.AbstractC1342Bo
        /* renamed from: ˋ */
        public void mo4058(boolean z) {
            Logger.INSTANCE.m143();
        }
    }

    @Override // o.A
    /* renamed from: ॱ */
    public void mo3260(boolean z) {
        Logger.INSTANCE.m143();
    }

    @Override // o.A
    /* renamed from: ʻॱ */
    public void mo3248() {
        mo3261();
        Logger.INSTANCE.m138();
        mo3257(false);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2285x
    /* renamed from: ˊ  reason: contains not printable characters */
    public AA mo4160() {
        return this.f4682;
    }

    @Override // o.AbstractC2285x
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo4165() {
        return "icleventsv2";
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ʽ */
    public void mo3250() {
        super.mo3250();
        this.f4683.m5253(this.f11924);
    }

    @Override // o.A
    /* renamed from: ˋ */
    public void mo3254(C1359Ce ce) {
    }

    @Override // o.A
    /* renamed from: ˊॱ */
    public String mo3252() {
        AbstractC1274 r2 = Logger.INSTANCE.m148("TODO");
        if (r2 == null) {
            return null;
        }
        return String.valueOf(r2.m16816());
    }

    @Override // o.A
    /* renamed from: ˊ */
    public void mo3251(boolean z, Object obj) {
    }

    @Override // o.A
    /* renamed from: ˎ */
    public void mo3256(IntentFilter intentFilter) {
    }

    @Override // o.AbstractC2285x, o.AbstractC0479
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo4161(String str) {
        return this.f11933.m5169(str);
    }

    @Override // o.A
    /* renamed from: ˎ */
    public void mo3255(Intent intent) {
    }

    @Override // o.A
    /* renamed from: ᐝॱ */
    public boolean mo3262() {
        return true;
    }
}
