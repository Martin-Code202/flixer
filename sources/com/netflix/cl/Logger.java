package com.netflix.cl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import o.AbstractC0470;
import o.AbstractC0479;
import o.AbstractC0514;
import o.AbstractC0556;
import o.AbstractC0622;
import o.AbstractC0675;
import o.AbstractC0783;
import o.AbstractC1100;
import o.AbstractC1274;
import o.C0386;
import o.C0389;
import o.C0441;
import o.C0510;
import o.C0558;
import o.C0566;
import o.C0641;
import o.C0713;
import o.C0788;
import o.C1062;
import o.C1229;
import o.C1275;
public enum Logger {
    INSTANCE;
    

    /* renamed from: ʻ  reason: contains not printable characters */
    private SortedMap<Long, AbstractC0675> f189 = Collections.synchronizedSortedMap(new TreeMap());

    /* renamed from: ʼ  reason: contains not printable characters */
    private Map<String, AbstractC1274> f190 = new HashMap();

    /* renamed from: ʽ  reason: contains not printable characters */
    private Map<String, AbstractC0675> f191 = new HashMap();

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0479 f192;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private Long f193;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC0622 f194;

    /* renamed from: ˏ  reason: contains not printable characters */
    private State f195 = State.not_initialized;

    /* renamed from: ॱ  reason: contains not printable characters */
    private SortedMap<Long, AbstractC0556> f196 = Collections.synchronizedSortedMap(new TreeMap());

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0713 f197 = new C0713();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private List<C0713> f198 = new LinkedList();

    /* access modifiers changed from: package-private */
    public enum State {
        not_initialized,
        initialized,
        ready_to_deliver,
        disabled
    }

    private Logger() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m144(C0441.Cif ifVar) {
        if (ifVar == null) {
            throw new IllegalArgumentException("Platform can not be null");
        } else if (this.f195 == State.not_initialized) {
            C0441.m14303(ifVar);
            m121();
            this.f195 = State.initialized;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m121() {
        this.f193 = m142(new C1062());
        m131(new C0788());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized long m127(AbstractC0675 r7) {
        if (m136()) {
            return 0;
        }
        if (r7 == null) {
            throw new IllegalArgumentException("Context can not be null!");
        }
        this.f189.put(Long.valueOf(r7.m14625()), r7);
        String simpleName = r7.getClass().getSimpleName();
        if (r7 instanceof AbstractC0514) {
            C0441.m14304().mo4532("addContext:: Context %s is exclusive. Added", simpleName);
            AbstractC0675 r5 = this.f191.get(simpleName);
            if (r5 == r7) {
                C0441.m14304().mo4532("addContext:: Old context for %s same as new, do nothing", simpleName);
                return r7.m14625();
            }
            if (r5 != null) {
                C0441.m14304().mo4532("addContext:: Old context for %s found and removed", simpleName);
                m132(Long.valueOf(r5.m14625()));
            }
            this.f191.put(simpleName, r7);
        } else {
            C0441.m14304().mo4532("addContext:: Context %s is NON exclusive. Added", simpleName);
        }
        return r7.m14625();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized boolean m128(Class cls) {
        if (cls == null) {
            return false;
        }
        return m137(cls.getSimpleName());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized boolean m137(String str) {
        if (m136()) {
            return false;
        }
        if (str == null) {
            return false;
        }
        AbstractC0675 r2 = this.f191.get(str);
        if (r2 == null) {
            return false;
        }
        return m132(Long.valueOf(r2.m14625()));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized boolean m132(Long l) {
        if (m136()) {
            return false;
        }
        if (l == null) {
            return false;
        }
        AbstractC0675 remove = this.f189.remove(l);
        if (remove != null) {
            m122(remove);
            C0441.m14304().mo4532("Context found in pending contexts for ID:  %d", l);
            return true;
        } else if (this.f196.get(l) instanceof AbstractC1274) {
            throw new IllegalStateException("removeContext:: id is session. We are trying to remove session, instead of context!");
        } else {
            AbstractC0675 r4 = (AbstractC0675) this.f196.remove(l);
            if (r4 != null) {
                m122(r4);
                C0441.m14304().mo4532("Context found in current contexts for ID:  %d", l);
                this.f197.m15039(new C0641(r4));
                return true;
            }
            C0441.m14304().mo4532("Context not found for ID %d.", l);
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m122(AbstractC0675 r3) {
        if (r3 instanceof AbstractC0514) {
            this.f191.remove(r3.getClass().getSimpleName());
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized AbstractC1274 m135(Long l) {
        if (l == null) {
            return null;
        }
        if (m136()) {
            return null;
        }
        AbstractC0556 r1 = this.f196.get(l);
        if (!(r1 instanceof AbstractC1274)) {
            return null;
        }
        return (AbstractC1274) r1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m131(AbstractC0783 r6) {
        if (!m136() && r6 != null) {
            r6.mo15060();
            if (this.f192 == null || this.f192.mo4161(r6.m15243())) {
                if (this.f194 != null) {
                    this.f194.m14753(r6);
                }
                m123(r6);
                return;
            }
            C0441.m14304().mo4532("Sampling event %s", r6.m15243());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized boolean m141(String str) {
        boolean z;
        if (str != null) {
            if (this.f190.get(str) != null) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized Long m142(AbstractC1274 r8) {
        if (m136()) {
            return null;
        }
        if (r8 == null) {
            throw new IllegalArgumentException("Session can not be null!");
        }
        r8.mo15060();
        if (this.f192 == null || this.f192.mo4161(r8.m16817())) {
            if (r8 instanceof AbstractC0514) {
                String r5 = r8.m16817();
                AbstractC1274 r6 = this.f190.get(r5);
                if (r6 != null) {
                    C0441.m14304().mo4535("Session already exist %s. Cancel it!", r5);
                    m147(AbstractC1274.m16814(Long.valueOf(r6.m16816())));
                }
                this.f190.put(r5, r8);
            }
            this.f196.put(Long.valueOf(r8.m14625()), r8);
            C0441.m14304().mo4533("Added session id " + r8.m14625() + ", session name " + r8.getClass().getSimpleName());
            m119();
            return Long.valueOf(r8.m14625());
        }
        C0441.m14304().mo4532("Sampling event %s", r8.m16817());
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized boolean m147(C1275 r7) {
        if (m136()) {
            return false;
        }
        if (r7 == null) {
            return false;
        }
        r7.mo15060();
        if (this.f192 == null || this.f192.mo4161(r7.m16819())) {
            AbstractC1274 r5 = (AbstractC1274) this.f196.remove(Long.valueOf(r7.m16818()));
            if (r5 == null) {
                C0441.m14304().mo4535("endSession:: session can not be found for id %d", Long.valueOf(r7.m16818()));
                return false;
            }
            C0441.m14304().mo4532("endSession:: for id %d removing session %s ", Long.valueOf(r7.m16818()), r5.getClass().getSimpleName());
            if (r5 instanceof AbstractC0514) {
                this.f190.remove(r5.m16817());
            }
            m124(r5, r7);
            return true;
        }
        C0441.m14304().mo4532("Sampling event %s", r7.m16819());
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized boolean m129(Long l) {
        if (m136()) {
            return false;
        }
        if (l == null) {
            return false;
        }
        C0386 r1 = AbstractC1274.m16814(l);
        if (r1 == null) {
            return false;
        }
        return m147(r1);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized boolean m145(Long l, C0510 r4) {
        if (m136()) {
            return false;
        }
        if (l == null) {
            return false;
        }
        C0389 r1 = AbstractC0470.m14366(l, r4);
        if (r1 == null) {
            return false;
        }
        return INSTANCE.m147(r1);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized boolean m130(String str) {
        if (m136()) {
            return false;
        }
        AbstractC1100 r1 = m118(str);
        if (r1 == null) {
            return false;
        }
        return m147(new C1275(r1));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized boolean m140(Long l) {
        if (m136()) {
            return false;
        }
        if (l == null) {
            return false;
        }
        C1275 r1 = AbstractC1274.m16815(l);
        if (r1 == null) {
            return false;
        }
        return m147(r1);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized boolean m133(String str) {
        if (m136()) {
            return false;
        }
        AbstractC0470 r1 = m126(str);
        if (r1 == null) {
            return false;
        }
        return m147(new C1275(r1));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized boolean m146(String str) {
        if (m136()) {
            return false;
        }
        AbstractC0470 r1 = m126(str);
        if (r1 == null) {
            return false;
        }
        return m147(new C0386(r1));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized boolean m134(String str, C0510 r5) {
        if (m136()) {
            return false;
        }
        AbstractC0470 r1 = m126(str);
        if (r1 == null) {
            return false;
        }
        return m147(new C0389(r1, r5));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m120() {
        ArrayList<AbstractC0675> arrayList = new ArrayList();
        for (AbstractC0675 r5 : this.f189.values()) {
            C0441.m14304().mo4533("resetContext:: add pendingContexts to pending removal " + r5);
            arrayList.add(r5);
        }
        for (AbstractC0556 r52 : this.f196.values()) {
            if (r52 instanceof AbstractC0675) {
                AbstractC0675 r6 = (AbstractC0675) r52;
                C0441.m14304().mo4533("resetContext:: add currentState to pending removal " + r6);
                arrayList.add(r6);
            }
        }
        for (AbstractC0675 r53 : arrayList) {
            C0441.m14304().mo4533("resetContext:: removing " + r53);
            m132(Long.valueOf(r53.m14625()));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m138() {
        C0441.m14304().mo4533("reinitForVppa starts...");
        C0441.m14304().mo4533("vpaReset...");
        Long valueOf = Long.valueOf(INSTANCE.m127(new C1229()));
        m120();
        INSTANCE.m132(valueOf);
        m143();
        C0441.m14307();
        m121();
        C0441.m14300();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m143() {
        if (!m136()) {
            boolean z = this.f192 == null;
            int size = this.f198.size();
            if (!z || size >= 1) {
                C0558 r7 = new C0558(this.f196, this.f198);
                this.f198.clear();
                this.f192.mo4164(r7);
                return;
            }
            C0441.m14304().mo4535("Unable to flush, evet send is missing %b and/or snapshot size %d is less than 1!", Boolean.valueOf(z), Integer.valueOf(size));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m139(AbstractC0479 r3) {
        if (!m136()) {
            if (r3 == null) {
                throw new IllegalArgumentException("Event sender can not be null!");
            }
            this.f192 = r3;
            this.f195 = State.ready_to_deliver;
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int m125() {
        int i = 1;
        for (AbstractC0675 r5 : this.f189.values()) {
            this.f196.put(Long.valueOf(r5.m14625()), r5);
            i++;
        }
        if (i > 0) {
            this.f197.m15039(new C0566(i));
        }
        this.f189.clear();
        return i;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m119() {
        C0441.m14304().mo4533("Create snapshot for season start...");
        m125();
        this.f197 = new C0713();
        this.f198.add(this.f197);
        m117();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m123(AbstractC0783 r3) {
        C0441.m14304().mo4533("Create snapshot for discrete event...");
        m125();
        this.f197 = new C0713();
        this.f197.m15039(new C0641(r3));
        this.f198.add(this.f197);
        m117();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m117() {
        AbstractC0479 r2 = this.f192;
        if (r2 != null) {
            r2.mo4162();
        } else {
            C0441.m14304().mo4533("Event sender not set yet!");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m124(AbstractC1274 r3, C1275 r4) {
        m125();
        this.f197 = new C0713();
        C0441.m14304().mo4533("Create snapshot for season end...");
        this.f197.m15039(new C0641(r4));
        this.f197.m15039(new C0641(r3));
        this.f198.add(this.f197);
        m117();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC0470 m126(String str) {
        if (str == null) {
            return null;
        }
        AbstractC1274 r5 = m148(str);
        if (r5 == null) {
            C0441.m14304().mo4535("Action %s not found!", str);
            return null;
        } else if (r5 instanceof AbstractC0470) {
            return (AbstractC0470) r5;
        } else {
            C0441.m14304().mo4535("%s is not action session instance, but %s", str, r5.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private AbstractC1100 m118(String str) {
        if (str == null) {
            return null;
        }
        AbstractC1274 r5 = m148(str);
        if (r5 == null) {
            C0441.m14304().mo4535("Command %s not found!", str);
            return null;
        } else if (r5 instanceof AbstractC1100) {
            return (AbstractC1100) r5;
        } else {
            C0441.m14304().mo4535("%s is not command session instance, but %s", str, r5.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public synchronized AbstractC1274 m148(String str) {
        if (str == null) {
            return null;
        }
        return this.f190.get(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m136() {
        return this.f195 == State.disabled;
    }
}
