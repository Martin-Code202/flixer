package o;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
public abstract class AA {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected long f4266;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected long f4267;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected AtomicBoolean f4268;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected List<AbstractC0061> f4269;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected String f4270;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected AtomicBoolean f4271;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected int f4272;

    /* renamed from: o.AA$ˋ  reason: contains not printable characters */
    public interface AbstractC0061 {
        /* renamed from: ˎ */
        boolean mo3271(int i, long j);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public abstract int mo3263();

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void mo3266(boolean z);

    public AA(String str, boolean z, boolean z2) {
        this(str, 100, 300000, z, z2);
    }

    public AA(String str, int i, long j, boolean z, boolean z2) {
        this.f4270 = "nf_event";
        this.f4272 = 100;
        this.f4266 = 300000;
        this.f4271 = new AtomicBoolean(false);
        this.f4268 = new AtomicBoolean(false);
        this.f4269 = Collections.synchronizedList(new ArrayList());
        if (C1349Bv.m4107(str)) {
            this.f4270 = str;
        }
        if (i <= 0) {
            throw new IllegalArgumentException("Number of events must be higher than 0!");
        } else if (j <= 0) {
            throw new IllegalArgumentException("Stay time in queue must be higher than 0!");
        } else {
            this.f4272 = i;
            this.f4266 = j;
            if (z) {
                this.f4269.add(new iF());
            }
            if (z2) {
                this.f4269.add(new Cif());
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3265() {
        this.f4271.set(true);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m3270() {
        this.f4268.set(true);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3268(boolean z) {
        this.f4271.set(false);
        if (z) {
            mo3266(true);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m3269() {
        if (!m3267()) {
            return false;
        }
        mo3266(true);
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m3267() {
        if (!this.f4268.get()) {
            C1283.m16865(this.f4270, "Not started state::  we can not flush events");
            return false;
        } else if (this.f4271.get()) {
            C1283.m16854(this.f4270, "Paused state:: we can not flush events");
            return false;
        } else if (this.f4269.size() > 0) {
            for (AbstractC0061 r0 : this.f4269) {
                if (r0.mo3271(mo3263(), this.f4267)) {
                    return true;
                }
            }
            return false;
        } else {
            C1283.m16854(this.f4270, "No rules to flush queue, go and flush queue");
            return true;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m3264() {
        return this.f4271.get();
    }

    class iF implements AbstractC0061 {
        private iF() {
        }

        @Override // o.AA.AbstractC0061
        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean mo3271(int i, long j) {
            if (AA.this.mo3263() >= AA.this.f4272) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: o.AA$if  reason: invalid class name */
    class Cif implements AbstractC0061 {
        private Cif() {
        }

        @Override // o.AA.AbstractC0061
        /* renamed from: ˎ */
        public boolean mo3271(int i, long j) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (j <= 0 || elapsedRealtime <= AA.this.f4266) {
                return false;
            }
            return true;
        }
    }
}
