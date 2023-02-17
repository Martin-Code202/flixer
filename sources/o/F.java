package o;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import java.util.concurrent.ScheduledExecutorService;
public final class F implements A {

    /* renamed from: ˊ  reason: contains not printable characters */
    private A f5650;

    /* renamed from: ˎ  reason: contains not printable characters */
    private A f5651;

    F(Context context, N n, UserAgentInterface userAgentInterface, AbstractC1221 r5) {
        this.f5651 = new E(context, n, userAgentInterface, r5);
        this.f5650 = new C(context, n, userAgentInterface, r5);
    }

    @Override // o.A
    /* renamed from: ˋ */
    public void mo3254(C1359Ce ce) {
        this.f5651.mo3254(ce);
        this.f5650.mo3254(ce);
    }

    @Override // o.A
    /* renamed from: ˊॱ */
    public String mo3252() {
        return this.f5651.mo3252();
    }

    @Override // o.A
    /* renamed from: ˊ */
    public void mo3251(boolean z, Object obj) {
        this.f5651.mo3251(z, obj);
        this.f5650.mo3251(z, obj);
    }

    @Override // o.A
    /* renamed from: ʽ */
    public void mo3250() {
        this.f5651.mo3250();
        this.f5650.mo3250();
    }

    @Override // o.A
    /* renamed from: ᐝ */
    public void mo3261() {
        this.f5651.mo3261();
        this.f5650.mo3261();
    }

    @Override // o.A
    /* renamed from: ˎ */
    public void mo3257(boolean z) {
        this.f5651.mo3257(z);
        this.f5650.mo3257(z);
    }

    @Override // o.A
    /* renamed from: ʼ */
    public void mo3249() {
        this.f5651.mo3249();
        this.f5650.mo3249();
    }

    @Override // o.A
    /* renamed from: ˏॱ */
    public void mo3258() {
        this.f5651.mo3258();
        this.f5650.mo3258();
    }

    @Override // o.A
    /* renamed from: ˋ */
    public void mo3253(ScheduledExecutorService scheduledExecutorService) {
        this.f5651.mo3253(scheduledExecutorService);
        this.f5650.mo3253(scheduledExecutorService);
    }

    @Override // o.A
    /* renamed from: ˎ */
    public void mo3256(IntentFilter intentFilter) {
        this.f5651.mo3256(intentFilter);
    }

    @Override // o.A
    /* renamed from: ॱ */
    public void mo3259() {
        this.f5651.mo3259();
        this.f5650.mo3259();
    }

    @Override // o.A
    /* renamed from: ʻॱ */
    public void mo3248() {
        this.f5651.mo3248();
        this.f5650.mo3248();
    }

    @Override // o.A
    /* renamed from: ॱ */
    public void mo3260(boolean z) {
        this.f5651.mo3260(z);
        this.f5650.mo3260(z);
    }

    @Override // o.A
    /* renamed from: ˎ */
    public void mo3255(Intent intent) {
        this.f5651.mo3255(intent);
        this.f5650.mo3255(intent);
    }

    @Override // o.A
    /* renamed from: ᐝॱ */
    public boolean mo3262() {
        return false;
    }
}
