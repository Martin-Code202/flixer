package o;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
/* renamed from: o.eZ  reason: case insensitive filesystem */
public class C1713eZ implements AbstractC0390 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC0457 f6650;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1699eL f6651;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Handler f6652;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean f6653;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Looper f6654;

    public C1713eZ(Looper looper, boolean z, AbstractC0457 r4, C1699eL eLVar) {
        this.f6654 = looper;
        this.f6653 = z;
        this.f6650 = r4;
        this.f6651 = eLVar;
        this.f6652 = new Handler(looper);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6339() {
        C1283.m16862("CastBackgroundDiscoveryManager", "Started CastBackgroundDiscoveryManager - background discovery is " + (this.f6653 ? "disabled" : "enabled"));
        if (this.f6653) {
            this.f6650.mo14206(this);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6338() {
        C1283.m16862("CastBackgroundDiscoveryManager", "Stopped CastBackgroundDiscoveryManager");
        this.f6650.mo14208(this);
    }

    @Override // o.AbstractC0390
    /* renamed from: ˎ */
    public void mo211(AbstractC0457 r3, Intent intent) {
        C1283.m16846("CastBackgroundDiscoveryManager", "App entered foregound, so enabling Cast discovery");
        this.f6652.post(new Runnable() { // from class: o.eZ.2
            @Override // java.lang.Runnable
            public void run() {
                C1713eZ.this.f6651.m6207();
            }
        });
    }

    @Override // o.AbstractC0390
    /* renamed from: ॱ */
    public void mo213(AbstractC0457 r3) {
        C1283.m16846("CastBackgroundDiscoveryManager", "App entered background, so disabling Cast discovery");
        this.f6652.post(new Runnable() { // from class: o.eZ.3
            @Override // java.lang.Runnable
            public void run() {
                C1713eZ.this.f6651.m6208();
            }
        });
    }

    @Override // o.AbstractC0390
    /* renamed from: ˋ */
    public void mo209(AbstractC0457 r1) {
    }

    @Override // o.AbstractC0390
    /* renamed from: ˏ */
    public void mo212(AbstractC0457 r1) {
    }

    @Override // o.AbstractC0390
    /* renamed from: ˊ */
    public void mo208(AbstractC0457 r1) {
    }

    @Override // o.AbstractC0390
    /* renamed from: ˎ */
    public void mo210(AbstractC0457 r1) {
    }
}
