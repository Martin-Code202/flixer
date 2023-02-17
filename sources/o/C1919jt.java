package o;

import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.drm.NfDrmManagerInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.AbstractC0499;
import o.jD;
import org.json.JSONObject;
/* renamed from: o.jt  reason: case insensitive filesystem */
public class C1919jt implements NfDrmManagerInterface, jD.If, MediaDrm.OnEventListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private Map<Long, jA> f8041 = new HashMap();

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f8042;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f8043;

    /* renamed from: ˊ  reason: contains not printable characters */
    private iT f8044;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f8045;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private P f8046;

    /* renamed from: ˎ  reason: contains not printable characters */
    private jD f8047;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Handler f8048;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f8049 = 5;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private List<BC<Long, Integer, oX>> f8050 = new ArrayList();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private MediaDrm f8051;

    public C1919jt(Looper looper, jD jDVar, iT iTVar, final boolean z, P p) {
        this.f8044 = iTVar;
        this.f8047 = jDVar;
        this.f8048 = new Handler(looper) { // from class: o.jt.1
            /* renamed from: ˋ  reason: contains not printable characters */
            private Long m8077(int i, int i2) {
                return Long.valueOf((((long) i) << 32) | (((long) i2) & -1));
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Long r5 = m8077(message.arg1, message.arg2);
                switch (message.what) {
                    case 0:
                        if (message.obj == null || !(message.obj instanceof Exception)) {
                            C1283.m16865("NfDrmManager", "DrmSession reported error, unknown cause.BUG!!!");
                            return;
                        }
                        Exception exc = (Exception) message.obj;
                        if (!C1317As.m3766()) {
                            C1283.m16855("NfDrmManager", "DrmSession reported Exception %s with session %d", exc, r5);
                            return;
                        } else if (exc instanceof MediaDrmResetException) {
                            C1283.m16855("NfDrmManager", "DrmSession reported MediaDrmResetException with session %d", r5);
                            try {
                                C1919jt.this.f8051.release();
                            } catch (Throwable th) {
                            }
                            C1919jt.this.f8041.clear();
                            C1919jt.this.m8065();
                            return;
                        } else {
                            C1283.m16855("NfDrmManager", "DrmSession reported Exception %s with session %d", exc, r5);
                            return;
                        }
                    case 1:
                        if (message.obj != null && (message.obj instanceof MediaDrm.ProvisionRequest) && !C1919jt.this.f8043) {
                            C1919jt.this.m8048((MediaDrm.ProvisionRequest) message.obj);
                        }
                        jA jAVar = (jA) C1919jt.this.f8041.get(r5);
                        if (jAVar != null) {
                            jAVar.m7844(AbstractC0367.f13215, false);
                            return;
                        }
                        return;
                    case 2:
                    case 3:
                        boolean z2 = message.what == 3;
                        if (message.obj != null && (message.obj instanceof C1923jx)) {
                            C1923jx jxVar = (C1923jx) message.obj;
                            C1283.m16851("NfDrmManager", "about to fetchStreamingLicense for session %s, challenge [%d], %s", r5, Integer.valueOf(jxVar.m8092().length()), jxVar.m8085());
                            C1919jt.this.f8044.m7575(jxVar, C1919jt.this.m8064(r5, z2));
                            return;
                        }
                        return;
                    case 4:
                    default:
                        return;
                    case 5:
                        C1283.m16854("NfDrmManager", "handling releaseLicense MSG_RELEASE_LICENSE");
                        if (message.obj != null && (message.obj instanceof C1923jx)) {
                            C1923jx jxVar2 = (C1923jx) message.obj;
                            String r9 = jxVar2.m8089();
                            C1283.m16851("NfDrmManager", "handling releaseLicense link: %s", r9);
                            if (C1349Bv.m4107(r9)) {
                                C1919jt.this.f8046.mo5229(iT.m7555(r9, jxVar2.m8094()));
                                return;
                            } else {
                                C1283.m16854("NfDrmManager", "dropping releaseLicense - no link");
                                return;
                            }
                        } else {
                            return;
                        }
                    case 6:
                        if (message.obj != null && (message.obj instanceof JSONObject)) {
                            JSONObject jSONObject = (JSONObject) message.obj;
                            return;
                        }
                        return;
                }
            }
        };
        this.f8046 = p;
        this.f8046.mo5230(this.f8048);
        this.f8048.post(new Runnable() { // from class: o.jt.4
            @Override // java.lang.Runnable
            public void run() {
                C1919jt.this.m8057(z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8057(boolean z) {
        m8065();
        int i = 8;
        try {
            i = Integer.valueOf(this.f8051.getPropertyString("maxNumberOfSessions")).intValue();
            C1283.m16851("NfDrmManager", "maxNumberOfSessions is %d", Integer.valueOf(i));
        } catch (Exception e) {
            C1283.m16851("NfDrmManager", "default maxNumberOfSessions is %d", Integer.valueOf(i));
        }
        this.f8042 = z || i < 8;
        if (z) {
            C1283.m16854("NfDrmManager", "license prefetch is disabled by config");
        } else if (this.f8042) {
            C1283.m16854("NfDrmManager", "license prefetch is disabled due to insufficient session");
        }
        this.f8049 = Math.min(i - 3, 20);
        this.f8045 = this.f8049 <= 8;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8065() {
        try {
            this.f8051 = AV.m3455(this);
        } catch (NotProvisionedException | UnsupportedSchemeException e) {
            C1283.m16847("NfDrmManager", "fail to instantiate MediaDrm %s", e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC1903jd m8064(final Long l, final boolean z) {
        return new AbstractC1903jd() { // from class: o.jt.5
            @Override // o.AbstractC1903jd, o.iX
            /* renamed from: ॱ */
            public void mo7616(final JSONObject jSONObject, final Status status) {
                C1283.m16851("NfDrmManager", "fetchStreamingLicense movie %d, result %s", l, status);
                final boolean r5 = status.mo298();
                C1919jt.this.f8048.post(new Runnable() { // from class: o.jt.5.4
                    @Override // java.lang.Runnable
                    public void run() {
                        jA r3 = C1919jt.this.mo8074(l, (C1923jx) null);
                        if (r3 == null) {
                            C1283.m16854("NfDrmManager", "fetchStreamingLicense returned, no matching session");
                        } else if (!r5 || jSONObject == null) {
                            C1283.m16854("NfDrmManager", "fetchStreamingLicense failed");
                            r3.m7844(status, z);
                        } else {
                            C1923jx r4 = r3.m7836();
                            r4.m8090(jSONObject);
                            if (r3.m7841()) {
                                r3.m7845(r4.m8096());
                            }
                        }
                    }
                });
            }
        };
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0071: APUT  (r2v3 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r3v3 java.lang.String) */
    @Override // o.AbstractC1924jy
    /* renamed from: ˎ  reason: contains not printable characters */
    public jA mo8074(Long l, C1923jx jxVar) {
        m8059();
        if (jxVar != null) {
            jA jAVar = this.f8041.get(l);
            if (jAVar == null || !jAVar.m7836().equals(jxVar) || jAVar.m7830()) {
                if (jAVar != null) {
                    Object[] objArr = new Object[3];
                    objArr[0] = l;
                    objArr[1] = jAVar.m7836().equals(jxVar) ? "for" : "not for";
                    objArr[2] = jAVar.m7830() ? ", already closed." : ".";
                    C1283.m16851("NfDrmManager", "%d has cached drm session %s this manifest %s", objArr);
                    m8060(l);
                }
                m8047(this.f8049 - 1);
                try {
                    this.f8041.put(l, jA.m7826(this.f8048, this.f8051, Long.valueOf(l.longValue()), jxVar));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                jAVar.m7838(jxVar);
                if (jxVar.m8085().equals(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_STANDARD) && !jAVar.m7836().m8097()) {
                    C1283.m16851("NfDrmManager", "%d has pending LDL session, promote pending request.", l);
                    this.f8044.m7568(jAVar.m7836(), m8064(l, false));
                }
                return jAVar;
            }
        }
        return this.f8041.get(l);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8073(final List<C2054pc> list) {
        if (!this.f8042) {
            this.f8048.post(new Runnable() { // from class: o.jt.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C1919jt.this.f8043) {
                        C1283.m16854("NfDrmManager", "provision pending, skip prefetch");
                        return;
                    }
                    for (C2054pc pcVar : list) {
                        long j = pcVar.f9381;
                        Integer valueOf = Integer.valueOf(pcVar.f9380.m1561());
                        oX oXVar = pcVar.f9379;
                        if (C1919jt.this.f8041.get(Long.valueOf(j)) != null) {
                            C1283.m16851("NfDrmManager", "movieId=%d priority=%d already cached", Long.valueOf(j), valueOf);
                        } else if (!pcVar.f9380.m1560() || !C1919jt.this.f8045) {
                            C1283.m16851("NfDrmManager", "movieId=%d priority=%d request manifest", Long.valueOf(j), valueOf);
                            C1919jt.this.f8050.add(BC.m3837(Long.valueOf(j), valueOf, oXVar));
                            C1919jt.this.f8047.mo7860(Long.valueOf(j), C1919jt.this, false);
                        } else {
                            C1283.m16851("NfDrmManager", "movieId=%d priority=%d skip", Long.valueOf(j), valueOf);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8076() {
        m8066(true);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8066(final boolean z) {
        this.f8048.post(new Runnable() { // from class: o.jt.7
            @Override // java.lang.Runnable
            public void run() {
                if (!C1919jt.this.f8041.isEmpty()) {
                    Iterator it = C1919jt.this.f8041.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (!z || !((jA) entry.getValue()).m7841()) {
                            ((jA) entry.getValue()).m7839();
                            it.remove();
                        }
                    }
                }
                C1919jt.this.f8050.clear();
            }
        });
    }

    @Override // o.AbstractC1925jz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8071(final Long l) {
        this.f8048.post(new Runnable() { // from class: o.jt.9
            @Override // java.lang.Runnable
            public void run() {
                C1919jt.this.m8060(l);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8060(Long l) {
        this.f8041.remove(l);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8055(Long l) {
        jA remove = this.f8041.remove(l);
        if (remove != null) {
            remove.m7839();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8072() {
        m8066(false);
        if (this.f8051 != null) {
            this.f8051.release();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8070() {
        m8066(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public jA m8075(byte[] bArr) {
        if (this.f8041.isEmpty()) {
            return null;
        }
        for (Map.Entry<Long, jA> entry : this.f8041.entrySet()) {
            jA value = entry.getValue();
            if (Arrays.equals(value.m7846(), bArr)) {
                return value;
            }
        }
        return null;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public void onEvent(MediaDrm mediaDrm, final byte[] bArr, int i, int i2, byte[] bArr2) {
        C1283.m16860("NfDrmManager", "onEvent [" + i + "]", bArr);
        if (i == 3) {
            C1283.m16854("NfDrmManager", "EVENT_KEY_EXPIRED - error");
        } else if (i == 2) {
            C1283.m16854("NfDrmManager", "EVENT_KEY_REQUIRED - to renew");
            this.f8048.post(new Runnable() { // from class: o.jt.8
                @Override // java.lang.Runnable
                public void run() {
                    jA r4 = C1919jt.this.m8075(bArr);
                    if (r4 != null) {
                        try {
                            r4.m7847();
                        } catch (NotProvisionedException e) {
                            C1283.m16855("NfDrmManager", "exception trying to renew %s", e);
                        } catch (Exception e2) {
                            C1283.m16855("NfDrmManager", "exception trying to renew %s", e2);
                        }
                    }
                }
            });
        } else if (i == 5) {
            C1283.m16854("NfDrmManager", "EVENT_SESSION_RECLAIMED.");
            this.f8048.post(new Runnable() { // from class: o.jt.6
                @Override // java.lang.Runnable
                public void run() {
                    jA r2 = C1919jt.this.m8075(bArr);
                    if (r2 != null) {
                        C1919jt.this.m8055(r2.m7840());
                    }
                }
            });
        } else if (i == 4) {
            C1283.m16854("NfDrmManager", "EVENT_VENDOR_DEFINED");
        } else if (i == 1) {
            C1283.m16854("NfDrmManager", "EVENT_PROVISION_REQUIRED -  shouldn't happen, will handle later.");
        } else {
            C1283.m16854("NfDrmManager", "EVENT_UNKNOWN");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8059() {
        if (!this.f8041.isEmpty()) {
            Iterator<Map.Entry<Long, jA>> it = this.f8041.entrySet().iterator();
            while (it.hasNext()) {
                jA value = it.next().getValue();
                if (value.m7835() >= 900000 && !value.m7841()) {
                    value.m7839();
                    it.remove();
                } else if (value.m7830()) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8047(int i) {
        if (!this.f8041.isEmpty()) {
            C1283.m16851("NfDrmManager", "purgeCachedSessions has  %d, target is %d", Integer.valueOf(this.f8041.size()), Integer.valueOf(i));
            int size = this.f8041.size();
            if (size > i) {
                ArrayList<jA> arrayList = new ArrayList(this.f8041.values());
                Collections.sort(arrayList);
                for (jA jAVar : arrayList) {
                    if (!jAVar.m7841() && size > i) {
                        size--;
                        Long r9 = jAVar.m7840();
                        m8055(r9);
                        C1283.m16851("NfDrmManager", "purgeCachedSessions remove a cached session %d", r9);
                    }
                }
            }
        }
    }

    @Override // o.jD.If
    /* renamed from: ˊ */
    public void mo7495(jG jGVar) {
        Long r6 = jGVar.m7933();
        if (this.f8041.get(r6) == null) {
            C1923jx jxVar = new C1923jx(Long.toString(System.nanoTime()), jGVar.m7935(), jGVar.m7924(), jGVar.m7921(), jGVar.m7933());
            jxVar.m8088(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_LDL);
            if (!jGVar.m7910() || mo8074(Long.valueOf(r6.longValue()), jxVar) != null) {
                for (BC<Long, Integer, oX> bc : this.f8050) {
                    if (bc.f4573.equals(r6)) {
                        this.f8050.remove(bc);
                        return;
                    }
                }
            }
        }
    }

    @Override // o.jD.If
    /* renamed from: ॱ */
    public void mo7506(Long l, Status status) {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8048(MediaDrm.ProvisionRequest provisionRequest) {
        this.f8043 = true;
        new AsyncTaskC0486(provisionRequest.getData(), new AbstractC0499.iF() { // from class: o.jt.10
            @Override // o.AbstractC0499.iF
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo8079(byte[] bArr) {
                C1283.m16850("NfDrmManager", "provision request has reponse.");
                C1919jt.this.m8053(bArr);
            }

            @Override // o.AbstractC0499.iF
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo8078() {
                C1283.m16850("NfDrmManager", "provision request aborted.");
                C1919jt.this.m8053((byte[]) null);
            }
        }).execute(provisionRequest.getDefaultUrl());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8053(final byte[] bArr) {
        this.f8048.post(new Runnable() { // from class: o.jt.3
            @Override // java.lang.Runnable
            public void run() {
                if (bArr != null) {
                    try {
                        C1919jt.this.f8051.provideProvisionResponse(bArr);
                    } catch (Exception e) {
                        C1283.m16847("NfDrmManager", "provision failed %s", e);
                    }
                }
                C1919jt.this.f8043 = false;
            }
        });
    }
}
