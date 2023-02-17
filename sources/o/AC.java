package o;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public abstract class AC<T> extends AA {

    /* renamed from: ˊ  reason: contains not printable characters */
    private List<T> f4275 = Collections.synchronizedList(new ArrayList());

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract void mo3277(List<T> list, boolean z);

    public AC(String str, boolean z, boolean z2) {
        super(str, z, z2);
    }

    public AC(String str, int i, long j, boolean z, boolean z2) {
        super(str, i, j, z, z2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final synchronized boolean m3276(T t) {
        if (t == null) {
            return false;
        }
        synchronized (this.f4275) {
            if (this.f4275.isEmpty()) {
                this.f4267 = SystemClock.elapsedRealtime();
            }
            this.f4275.add(t);
        }
        if (!m3267()) {
            return false;
        }
        mo3266(true);
        return true;
    }

    @Override // o.AA
    /* renamed from: ˎ */
    public synchronized void mo3266(boolean z) {
        if (!this.f4268.get()) {
            C1283.m16865(this.f4270, "flushEvents:: can NOT flush queue, it is not started yet!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f4275) {
            arrayList.addAll(this.f4275);
            this.f4275.clear();
            this.f4267 = 0;
        }
        mo3277(arrayList, z);
    }

    @Override // o.AA
    /* renamed from: ʼ */
    public int mo3263() {
        return this.f4275.size();
    }
}
