package o;

import android.content.Context;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import o.oD;
/* renamed from: o.gG  reason: case insensitive filesystem */
public class C1801gG implements AbstractC1417Eh, AbstractC2064pm {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected final Map<Long, Set<DU>> f6881 = new HashMap();

    /* renamed from: ʼ  reason: contains not printable characters */
    protected final Map<Long, Set<DU>> f6882 = new HashMap();

    /* renamed from: ʽ  reason: contains not printable characters */
    protected final Map<String, AuthorizationCredentials> f6883 = new HashMap();

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final Map<DV, AbstractC1386Dc> f6884 = new ConcurrentHashMap();

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final Map<Long, Long> f6885 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    protected Context f6886;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final Set<DU> f6887 = new HashSet();

    /* renamed from: ͺ  reason: contains not printable characters */
    protected oD.If f6888;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final Map<String, C1411Eb> f6889 = new ConcurrentHashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected C1805gK f6890;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected UserAgentInterface f6891;

    public C1801gG(Context context, UserAgentInterface userAgentInterface, C1805gK gKVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null!");
        } else if (userAgentInterface == null) {
            throw new IllegalArgumentException("User can not be null!");
        } else {
            this.f6886 = context;
            this.f6891 = userAgentInterface;
            this.f6890 = gKVar;
        }
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˏ */
    public synchronized void mo4886(DV dv, AbstractC1386Dc dc) {
        C1283.m16854("nf_msl_store", "setCryptoContex:: starts...");
        if (dc == null) {
            mo4881(dv);
        } else {
            this.f6884.put(dv, dc);
            m6539();
        }
        C1283.m16854("nf_msl_store", "setCryptoContex:: done.");
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˎ */
    public synchronized DV mo4884() {
        DV dv;
        dv = null;
        for (DV dv2 : this.f6884.keySet()) {
            if (dv == null || dv2.m4694(dv)) {
                dv = dv2;
            }
        }
        return dv;
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˋ */
    public synchronized void mo4881(DV dv) {
        m6541(dv);
        m6539();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6541(DV dv) {
        m6552();
        AbstractC1386Dc remove = this.f6884.remove(dv);
        if (remove == null) {
            C1283.m16844("nf_msl_store", "Crypto context not found for %s", dv);
            C1276.m16820().mo5725("Crypto context not found for master token!");
        } else if (remove instanceof C1803gI) {
            ((C1803gI) remove).m6565();
            long r5 = dv.m4698();
            for (DV dv2 : this.f6884.keySet()) {
                if (dv2.m4698() == r5) {
                    return;
                }
            }
            this.f6885.remove(Long.valueOf(r5));
            for (C1411Eb eb : this.f6889.values()) {
                if (eb.m4871(dv)) {
                    m6551(eb);
                }
            }
            try {
                m6546(null, dv, null);
            } catch (MslException e) {
                throw new MslInternalException("Unexpected exception while removing master token bound service tokens.", e);
            }
        } else {
            C1283.m16850("nf_msl_store", "NOT Widevine crypto session! This should NOT happen!");
            throw new IllegalStateException("Not Widevine crypto context: " + remove);
        }
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˎ */
    public synchronized long mo4882(DV dv) {
        long r7;
        long r3 = dv.m4698();
        r7 = m6538(this.f6885.containsKey(Long.valueOf(r3)) ? this.f6885.get(Long.valueOf(r3)).longValue() : 0);
        this.f6885.put(Long.valueOf(r3), Long.valueOf(r7));
        m6539();
        return r7;
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ॱ */
    public synchronized AbstractC1386Dc mo4888(DV dv) {
        return this.f6884.get(dv);
    }

    @Override // o.AbstractC2064pm
    /* renamed from: ˏ */
    public AuthorizationCredentials mo6502(String str) {
        AuthorizationCredentials authorizationCredentials;
        synchronized (this.f6883) {
            authorizationCredentials = this.f6883.get(str);
        }
        return authorizationCredentials;
    }

    @Override // o.AbstractC2064pm
    /* renamed from: ˏ */
    public void mo6504(String str, AuthorizationCredentials authorizationCredentials) {
        boolean z = false;
        synchronized (this.f6883) {
            if (authorizationCredentials != null) {
                AuthorizationCredentials authorizationCredentials2 = this.f6883.get(str);
                if (authorizationCredentials2 == null) {
                    z = true;
                } else {
                    z = !authorizationCredentials2.equals(authorizationCredentials);
                }
                this.f6883.put(str, authorizationCredentials);
            } else if (this.f6883.remove(str) != null) {
                z = true;
            }
            if (z) {
                m6553();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String m6542(AbstractC1399Dp dp) {
        return C1323Aw.m3795(dp.mo3114(this.f6890, C1407Dx.f5471));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private synchronized void m6539() {
        C1283.m16854("nf_msl_store", "saveSecureStore:: started.");
        try {
            C0355 r4 = new C0355();
            C0572 r5 = new C0572();
            r4.m13986("cryptoContexts", r5);
            for (AbstractC1399Dp dp : this.f6884.keySet()) {
                C0355 r8 = new C0355();
                r8.m13986("masterToken", m6542(dp));
                r8.m13986("cryptoContext", ((C1803gI) this.f6884.get(dp)).m6564());
                r5.m14672(r8);
            }
            C0572 r6 = new C0572();
            r4.m13986("userIdTokens", r6);
            for (String str : this.f6889.keySet()) {
                C0355 r9 = new C0355();
                C1411Eb eb = this.f6889.get(str);
                r9.m13986("userId", str);
                r9.m13986("userIdToken", m6542(eb));
                r9.m13981("mtSerialNumber", eb.m4869());
                r6.m14672(r9);
            }
            C0572 r7 = new C0572();
            r4.m13986("nonReplayableIds", r7);
            for (Long l : this.f6885.keySet()) {
                C0355 r10 = new C0355();
                r10.m13986("mtSerialNumber", l);
                r10.m13986("nonReplayableId", this.f6885.get(l));
                r7.m14672(r10);
            }
            C0572 r82 = new C0572();
            r4.m13986("unboundServiceTokens", r82);
            for (AbstractC1399Dp dp2 : this.f6887) {
                r82.m14672(m6542(dp2));
            }
            C0572 r92 = new C0572();
            r4.m13986("mtServiceTokens", r92);
            for (Object obj : this.f6882.keySet()) {
                C0355 r12 = new C0355();
                r92.m14672(r12);
                r12.m13986("mtSerialNumber", obj);
                C0572 r13 = new C0572();
                r12.m13986("serviceTokenSet", r13);
                Set<DU> set = this.f6882.get(obj);
                if (set != null) {
                    for (DU du : set) {
                        C0355 r17 = new C0355();
                        r13.m14672(r17);
                        if (du.m4681()) {
                            r17.m13981("uitSerialNumber", du.m4689());
                        }
                        r17.m13986("serviceToken", m6542(du));
                    }
                }
            }
            C0572 r102 = new C0572();
            r4.m13986("uitServiceTokens", r102);
            for (Object obj2 : this.f6881.keySet()) {
                C0355 r132 = new C0355();
                r102.m14672(r132);
                r132.m13986("uitSerialNumber", obj2);
                C0572 r14 = new C0572();
                r132.m13986("serviceTokenSet", r14);
                Set<DU> set2 = this.f6881.get(obj2);
                if (set2 != null) {
                    for (DU du2 : set2) {
                        C0355 r18 = new C0355();
                        r14.m14672(r18);
                        if (du2.m4686()) {
                            r18.m13981("mtSerialNumber", du2.m4683());
                        }
                        r18.m13986("serviceToken", m6542(du2));
                    }
                }
            }
            C1339Bl.m4039(this.f6886, "nf_msl_store_json", r4.toString());
            C1283.m16854("nf_msl_store", "saveSecureStore:: done.");
        } catch (Throwable th) {
            C1283.m16856("nf_msl_store", th, "Failed to saveSecureStore MSL store: ", new Object[0]);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m6558() {
        C1283.m16854("nf_msl_store", "clearCryptoContexts::");
        this.f6884.clear();
        this.f6885.clear();
        this.f6889.clear();
        this.f6881.clear();
        this.f6882.clear();
        m6539();
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ॱ */
    public synchronized void mo4891(String str, C1411Eb eb) {
        C1283.m16851("nf_msl_store", "addUserIdToken:: userId: %s", str);
        boolean z = false;
        Iterator<DV> it = this.f6884.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (eb.m4871(it.next())) {
                z = true;
                break;
            }
        }
        if (!z) {
            throw new MslException(CK.f4863, "uit mtserialnumber " + eb.m4869());
        }
        C1411Eb eb2 = this.f6889.get(str);
        this.f6889.put(str, eb);
        if (eb2 == null || !eb2.equals(eb)) {
            C1283.m16854("nf_msl_store", "UserIDToken is changed, saveSecureStore MSL store");
            m6539();
        } else {
            C1283.m16854("nf_msl_store", "UserIDToken is NOT changed, do NOT saveSecureStore MSL store");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m6557(String str, String str2) {
        if (str == null) {
            throw new MslException(CK.f4867, "Old userId can not be null");
        } else if (str2 == null) {
            throw new MslException(CK.f4867, "New userId can not be null");
        } else {
            C1411Eb remove = this.f6889.remove(str);
            if (remove == null) {
                throw new MslException(CK.f4767, "UserIdToken not found for given old user ID: " + str);
            }
            this.f6889.put(str2, remove);
            m6539();
        }
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ॱ */
    public synchronized C1411Eb mo4889(String str) {
        C1283.m16851("nf_msl_store", "getUserIdToken:: userId: %s", str);
        return str != null ? this.f6889.get(str) : null;
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˏ */
    public synchronized void mo4887(C1411Eb eb) {
        m6551(eb);
        m6539();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6551(C1411Eb eb) {
        DV dv = null;
        Iterator<DV> it = this.f6884.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DV next = it.next();
            if (eb.m4871(next)) {
                dv = next;
                break;
            }
        }
        for (Map.Entry<String, C1411Eb> entry : this.f6889.entrySet()) {
            if (entry.getValue().equals(eb)) {
                this.f6889.remove(entry.getKey());
                try {
                    m6546(null, dv, eb);
                    return;
                } catch (MslException e) {
                    throw new MslInternalException("Unexpected exception while removing user ID token bound service tokens.", e);
                }
            }
        }
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ॱ */
    public synchronized void mo4890(String str, DV dv, C1411Eb eb) {
        if (m6546(str, dv, eb)) {
            m6539();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m6548(String str, DV dv) {
        boolean z = false;
        Set<DU> set = this.f6882.get(Long.valueOf(dv.m4698()));
        if (set != null) {
            Iterator<DU> it = set.iterator();
            while (it.hasNext()) {
                DU next = it.next();
                if (str == null || next.m4685().equals(str)) {
                    it.remove();
                    z = true;
                }
            }
        }
        for (Map.Entry<Long, Set<DU>> entry : this.f6881.entrySet()) {
            Long key = entry.getKey();
            Set<DU> value = entry.getValue();
            Iterator<DU> it2 = value.iterator();
            while (it2.hasNext()) {
                DU next2 = it2.next();
                if (str == null || next2.m4685().equals(str)) {
                    if (next2.m4684(dv)) {
                        it2.remove();
                        z = true;
                    }
                }
            }
            if (value.size() > 0) {
                this.f6881.put(key, value);
            } else {
                this.f6881.remove(key);
            }
        }
        return z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m6543(String str, DV dv, C1411Eb eb) {
        boolean z = false;
        Set<DU> set = this.f6881.get(Long.valueOf(eb.m4868()));
        if (set != null) {
            Iterator<DU> it = set.iterator();
            while (it.hasNext()) {
                DU next = it.next();
                if (str == null || next.m4685().equals(str)) {
                    if (dv == null || next.m4684(dv)) {
                        it.remove();
                        z = true;
                    }
                }
            }
            if (set.size() > 0) {
                this.f6881.put(Long.valueOf(eb.m4868()), set);
            } else {
                this.f6881.remove(Long.valueOf(eb.m4868()));
            }
        }
        Set<DU> set2 = this.f6882.get(Long.valueOf(eb.m4869()));
        if (set2 != null) {
            Iterator<DU> it2 = set2.iterator();
            while (it2.hasNext()) {
                DU next2 = it2.next();
                if (str == null || next2.m4685().equals(str)) {
                    if (dv == null || next2.m4684(dv)) {
                        if (next2.m4688(eb)) {
                            it2.remove();
                            z = true;
                        }
                    }
                }
            }
            if (set2.size() > 0) {
                this.f6882.put(Long.valueOf(eb.m4869()), set2);
            } else {
                this.f6882.remove(Long.valueOf(eb.m4869()));
            }
        }
        return z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m6545(String str) {
        boolean z = false;
        Iterator<DU> it = this.f6887.iterator();
        while (it.hasNext()) {
            if (it.next().m4685().equals(str)) {
                it.remove();
                z = true;
            }
        }
        for (Map.Entry<Long, Set<DU>> entry : this.f6882.entrySet()) {
            Long key = entry.getKey();
            Set<DU> value = entry.getValue();
            Iterator<DU> it2 = value.iterator();
            while (it2.hasNext()) {
                if (it2.next().m4685().equals(str)) {
                    it2.remove();
                    z = true;
                }
            }
            if (value.size() > 0) {
                this.f6882.put(key, value);
            } else {
                this.f6882.remove(key);
            }
        }
        for (Map.Entry<Long, Set<DU>> entry2 : this.f6881.entrySet()) {
            Long key2 = entry2.getKey();
            Set<DU> value2 = entry2.getValue();
            Iterator<DU> it3 = value2.iterator();
            while (it3.hasNext()) {
                if (it3.next().m4685().equals(str)) {
                    it3.remove();
                    z = true;
                }
            }
            if (value2.size() > 0) {
                this.f6881.put(key2, value2);
            } else {
                this.f6881.remove(key2);
            }
        }
        return z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m6546(String str, DV dv, C1411Eb eb) {
        if (eb != null && dv != null && !eb.m4871(dv)) {
            throw new MslException(CK.f4807, "uit mtserialnumber " + eb.m4869() + "; mt " + dv.m4698());
        } else if (str != null && dv == null && eb == null) {
            return m6545(str);
        } else {
            if (dv != null && eb == null) {
                return m6548(str, dv);
            }
            if (eb != null) {
                return m6543(str, dv, eb);
            }
            C1283.m16855("nf_msl_store", "doRemoveServiceToken:: service token %s was not removed", str);
            return false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m6559() {
        this.f6887.clear();
        this.f6882.clear();
        this.f6881.clear();
        m6539();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m6556() {
        C1283.m16854("nf_msl_store", "clearUserIdTokens::");
        ArrayList<C1411Eb> arrayList = new ArrayList();
        arrayList.addAll(this.f6889.values());
        for (C1411Eb eb : arrayList) {
            m6551(eb);
        }
        if (this.f6889.size() > 0) {
            C1283.m16865("nf_msl_store", "Failed to remove all user IDs!");
        }
        m6539();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m6553() {
        C1283.m16854("nf_msl_store", "saveCookies:: started.");
        synchronized (this.f6883) {
            C0572 r3 = new C0572();
            for (String str : this.f6883.keySet()) {
                C0355 r6 = new C0355();
                r3.m14672(r6);
                r6.m13986("userId", str);
                AuthorizationCredentials authorizationCredentials = this.f6883.get(str);
                r6.m13986("netflixID", authorizationCredentials.netflixId);
                r6.m13986("secureNetflixID", authorizationCredentials.secureNetflixId);
            }
            m6540(r3.toString());
        }
        C1283.m16854("nf_msl_store", "saveCookies:: done.");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m6561() {
        return this.f6884.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f A[DONT_GENERATE] */
    @Override // o.AbstractC1417Eh
    /* renamed from: ˎ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo4885(java.util.Set<o.DU> r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            if (r11 == 0) goto L_0x000b
            int r0 = r11.size()     // Catch:{ all -> 0x0051 }
            if (r0 <= 0) goto L_0x000b
            r5 = 1
            goto L_0x000c
        L_0x000b:
            r5 = 0
        L_0x000c:
            java.lang.String r0 = "nf_msl_store"
            java.lang.String r1 = "addServiceTokens:: %b"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0051 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0051 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x0051 }
            o.C1283.m16851(r0, r1, r2)     // Catch:{ all -> 0x0051 }
            if (r5 != 0) goto L_0x0021
            monitor-exit(r10)     // Catch:{ all -> 0x0051 }
            return
        L_0x0021:
            r6 = 0
            r10.m6550(r11)     // Catch:{ all -> 0x0051 }
            java.util.Iterator r7 = r11.iterator()     // Catch:{ all -> 0x0051 }
        L_0x0029:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0042
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0051 }
            r8 = r0
            o.DU r8 = (o.DU) r8     // Catch:{ all -> 0x0051 }
            boolean r9 = r10.m6549(r8)     // Catch:{ all -> 0x0051 }
            if (r6 != 0) goto L_0x003e
            if (r9 == 0) goto L_0x0040
        L_0x003e:
            r6 = 1
            goto L_0x0041
        L_0x0040:
            r6 = 0
        L_0x0041:
            goto L_0x0029
        L_0x0042:
            if (r6 == 0) goto L_0x0048
            r10.m6539()     // Catch:{ all -> 0x0051 }
            goto L_0x004f
        L_0x0048:
            java.lang.String r0 = "nf_msl_store"
            java.lang.String r1 = "No changes with service tokens, no need to saveSecureStore."
            o.C1283.m16854(r0, r1)     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r10)
            return
        L_0x0051:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1801gG.mo4885(java.util.Set):void");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m6549(DU du) {
        boolean z = false;
        if (du.m4680()) {
            return m6544(this.f6887, du);
        }
        if (du.m4686()) {
            Set<DU> set = this.f6882.get(Long.valueOf(du.m4683()));
            if (set == null) {
                set = new HashSet<>();
                this.f6882.put(Long.valueOf(du.m4683()), set);
            }
            z = m6544(set, du);
        }
        if (!du.m4681()) {
            return z;
        }
        Set<DU> set2 = this.f6881.get(Long.valueOf(du.m4689()));
        if (set2 == null) {
            set2 = new HashSet<>();
            this.f6881.put(Long.valueOf(du.m4689()), set2);
        }
        return m6544(set2, du);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m6544(Set<DU> set, DU du) {
        for (DU du2 : set) {
            if (m6547(du, du2)) {
                return false;
            }
        }
        set.add(du);
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m6547(DU du, DU du2) {
        if (du == null || du2 == null || !du.equals(du2) || du.m4687() || du2.m4687()) {
            return false;
        }
        return Arrays.equals(du.m4682(), du2.m4682());
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˎ */
    public synchronized Set<DU> mo4883(DV dv, C1411Eb eb) {
        HashSet hashSet;
        Set<DU> set;
        Set<DU> set2;
        if (eb != null) {
            if (dv == null) {
                throw new MslException(CK.f4857);
            } else if (!eb.m4871(dv)) {
                throw new MslException(CK.f4807, "uit mtserialnumber " + eb.m4869() + "; mt " + dv.m4698());
            }
        }
        hashSet = new HashSet();
        hashSet.addAll(this.f6887);
        if (!(dv == null || (set2 = this.f6882.get(Long.valueOf(dv.m4698()))) == null)) {
            for (DU du : set2) {
                if (!du.m4681()) {
                    hashSet.add(du);
                }
            }
        }
        if (!(eb == null || (set = this.f6881.get(Long.valueOf(eb.m4868()))) == null)) {
            for (DU du2 : set) {
                if (du2.m4684(dv)) {
                    hashSet.add(du2);
                }
            }
        }
        return hashSet;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static long m6538(long j) {
        if (j < 0 || j > 9007199254740992L) {
            throw new MslInternalException("Non-replayable ID " + j + " is outside the valid range.");
        } else if (j == 9007199254740992L) {
            return 0;
        } else {
            return 1 + j;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6550(Set<DU> set) {
        for (DU du : set) {
            if (du.m4686()) {
                boolean z = false;
                Iterator<DV> it = this.f6884.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (du.m4684(it.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    throw new MslException(CK.f4902, "st mtserialnumber " + du.m4683());
                }
            }
            if (du.m4681()) {
                boolean z2 = false;
                Iterator<C1411Eb> it2 = this.f6889.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (du.m4688(it2.next())) {
                            z2 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z2) {
                    throw new MslException(CK.f4903, "st uitserialnumber " + du.m4689());
                }
            }
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m6552() {
        String r4 = this.f6891.mo1340();
        String r5 = this.f6891.mo1361().mo1403();
        if (r4 == null || !r4.equals(r5)) {
            C1283.m16851("nf_msl_store", "Last known profile %s is not in sync in user agent %s", r5, r4);
        } else {
            C1283.m16851("nf_msl_store", "Last known profile %s", r4);
        }
        C1411Eb r6 = mo4889(r5);
        if (r6 != null) {
            this.f6888 = new oD.If(r5, mo4884(), r6);
            return;
        }
        C1283.m16850("nf_msl_store", "Unable to find userID token for last known profile ID. This should NOT happen! Log user out!");
        this.f6891.mo1360();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public synchronized oD.If m6560() {
        return this.f6888;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public synchronized void m6555() {
        this.f6888 = null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6540(String str) {
        try {
            SecurityRepository.saveSecureStore(this.f6886, str);
        } catch (Throwable th) {
            C1283.m16856("nf_msl_store", th, "Failed to saveSecureStore MSL store to secure store", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʼ  reason: contains not printable characters */
    public void m6554() {
        String r4 = C1339Bl.m4045(this.f6886, "useragent_current_profile_id", (String) null);
        if (C1349Bv.m4113(r4)) {
            C1283.m16854("nf_msl_store", "saveLastProfileCredentialsOnMslStoreLoadSuccess::No profile ID, user is not logged in, do NOT try to recover.");
            return;
        }
        C1283.m16851("nf_msl_store", "saveLastProfileCredentialsOnMslStoreLoadSuccess::Current profile ID: %s, user is logged in, try to recover", r4);
        DV r5 = mo4884();
        C1411Eb r6 = mo4889(r4);
        if (r5 == null || r6 == null) {
            C1283.m16855("nf_msl_store", "saveLastProfileCredentialsOnMslStoreLoadSuccess:: Missing master token/user Id token for profile %s", r4);
            return;
        }
        C1283.m16851("nf_msl_store", "saveLastProfileCredentialsOnMslStoreLoadSuccess:: recovery data found, we will attempt recoveryfor %s ", r4);
        this.f6888 = new oD.If(r4, r5, r6);
    }
}
