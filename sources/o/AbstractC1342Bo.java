package o;

import android.os.SystemClock;
/* renamed from: o.Bo  reason: case insensitive filesystem */
public abstract class AbstractC1342Bo extends AA {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f4657;

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract void mo4058(boolean z);

    public AbstractC1342Bo(String str, int i, long j, boolean z, boolean z2) {
        super(str, i, j, z, z2);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public synchronized boolean m4057() {
        if (this.f4657 == 0) {
            this.f4267 = SystemClock.elapsedRealtime();
        }
        this.f4657++;
        C1283.m16851(this.f4270, "Events counter: %d", Integer.valueOf(this.f4657));
        if (!m3267()) {
            return false;
        }
        mo3266(true);
        return true;
    }

    @Override // o.AA
    /* renamed from: ʼ */
    public int mo3263() {
        return this.f4657;
    }

    @Override // o.AA
    /* renamed from: ˎ */
    public synchronized void mo3266(boolean z) {
        if (!this.f4268.get()) {
            C1283.m16865(this.f4270, "flushEvents:: can NOT flush queue, it is not started yet!");
            return;
        }
        C1283.m16851(this.f4270, "Flushing %d events, save if failed %b", Integer.valueOf(this.f4657), Boolean.valueOf(z));
        mo4058(z);
        this.f4267 = 0;
        this.f4657 = 0;
    }
}
