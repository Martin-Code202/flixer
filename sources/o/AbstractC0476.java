package o;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.service.error.crypto.ErrorSource;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import o.AbstractC0472;
/* renamed from: o.Ϯ  reason: contains not printable characters */
public abstract class AbstractC0476 implements AbstractC0472, MediaDrm.OnEventListener {

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static String f13527 = "nf_msl";

    /* renamed from: ͺ  reason: contains not printable characters */
    public static int f13528;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected static final byte[] f13529 = new byte[0];

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static int f13530;

    /* renamed from: ʻ  reason: contains not printable characters */
    protected CryptoProvider f13531;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected AtomicInteger f13532 = new AtomicInteger();

    /* renamed from: ʽ  reason: contains not printable characters */
    protected AtomicBoolean f13533 = new AtomicBoolean(false);

    /* renamed from: ˊ  reason: contains not printable characters */
    protected AbstractC0472.AbstractC0473 f13534;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C1800gF f13535;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final byte[] f13536 = {10, 122, 0, 108, 56, 43};

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final CryptoErrorManager f13537;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected Context f13538;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected MediaDrm f13539;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Cif f13540 = new Cif();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected AbstractC1221 f13541;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private List<AbstractC0472.C0474> f13542 = new ArrayList();

    /* access modifiers changed from: protected */
    public abstract UUID y_();

    /* access modifiers changed from: protected */
    public abstract void z_();

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract String mo14398();

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract void mo14405();

    public AbstractC0476(Context context, CryptoProvider cryptoProvider, AbstractC1221 r5, AbstractC0472.AbstractC0473 r6, CryptoErrorManager cryptoErrorManager) {
        f13527 = mo14398();
        if (r6 == null) {
            throw new IllegalArgumentException("Calllback is null!");
        }
        this.f13531 = cryptoProvider;
        this.f13537 = cryptoErrorManager;
        this.f13534 = r6;
        this.f13541 = r5;
        this.f13538 = context;
        m14379();
        m14380();
        m14389();
        m14394();
        mo14405();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m14379() {
        this.f13539 = m14402();
        this.f13539.setOnEventListener(this);
        z_();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public MediaDrm m14402() {
        return new MediaDrm(y_());
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m14380() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_STARTED");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_ENDED");
        LocalBroadcastManager.getInstance(this.f13538).registerReceiver(this.f13540, intentFilter);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m14389() {
    }

    @Override // o.AbstractC0472
    /* renamed from: ˊ */
    public void mo14356(AbstractC0472.C0474 r1) {
        m14388(r1);
        m14399(r1);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14399(AbstractC0472.C0474 r2) {
        if (r2 != null && this.f13539 != null && r2.f13526 != null) {
            m14384(r2.f13526);
            r2.f13526 = null;
            r2.f13524 = null;
            m14381(r2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14384(byte[] bArr) {
        try {
            this.f13539.closeSession(bArr);
            this.f13532.decrementAndGet();
        } catch (Throwable th) {
            C1283.m16867(f13527, th, "closeCryptoSessions failed !");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14388(AbstractC0472.C0474 r5) {
        if (r5 != null && this.f13539 != null && r5.f13526 != null) {
            if (r5.f13524 == null) {
                C1283.m16854(f13527, "Nothing to remove! Skip!");
                return;
            }
            C1283.m16854(f13527, "removeSessionKeys");
            try {
                this.f13539.removeKeys(r5.f13526);
            } catch (Exception e) {
                C1283.m16856(f13527, e, "removeSessionKeys ", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public MediaDrm.CryptoSession m14401(AbstractC0472.C0474 r5) {
        if (r5 == null) {
            return null;
        }
        m14392(r5);
        byte[] bArr = r5.f13526;
        if (bArr != null) {
            return this.f13539.getCryptoSession(bArr, m14397(), m14395());
        }
        C1283.m16865(f13527, "findMediaDrmCryptoSession:: session found but without session ID: " + r5);
        return null;
    }

    @Override // o.AbstractC0472
    @TargetApi(23)
    /* renamed from: ˎ */
    public byte[] mo14361(AbstractC0472.C0474 r5, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            bArr3 = m14404(r5, ifVar, bArr, bArr2);
        } catch (Throwable th) {
            m14393(th);
        }
        if (bArr3 != null) {
            return bArr3;
        }
        return f13529;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public byte[] m14404(AbstractC0472.C0474 r7, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        MediaDrm.CryptoSession r3 = m14401(r7);
        if (r3 == null) {
            C1283.m16865(f13527, "decrypt - session NOT found!");
            return null;
        } else if (null == ifVar) {
            C1283.m16865(f13527, "decrypt - kce is null!");
            return null;
        } else {
            try {
                return C1324Ax.m3814(r3.decrypt(ifVar.m14369(), bArr, bArr2), 16);
            } catch (Throwable th) {
                C1283.m16856(f13527, th, "Failed to decrypt ", new Object[0]);
                m14383(StatusCode.DRM_FAILURE_MEDIADRM_DECRYPT, th);
                return null;
            }
        }
    }

    @Override // o.AbstractC0472
    @TargetApi(23)
    /* renamed from: ˊ */
    public byte[] mo14357(AbstractC0472.C0474 r6, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        C1283.m16854(f13527, "BaseCryptoManager::encrypt...");
        byte[] bArr3 = null;
        try {
            bArr3 = m14400(r6, ifVar, bArr, bArr2);
        } catch (Throwable th) {
            m14393(th);
        }
        if (bArr3 != null) {
            return bArr3;
        }
        return f13529;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m14403(Throwable th) {
        if (!C1317As.m3766() || !(th instanceof MediaDrmResetException)) {
            return false;
        }
        C1283.m16850(f13527, "MediaDrm instance is not usable anymore, recreate!");
        try {
            this.f13539.release();
        } catch (Throwable th2) {
        }
        try {
            m14379();
            m14394();
            mo14405();
            return true;
        } catch (Throwable th3) {
            C1283.m16856(f13527, th3, "Failed to recreate MediaDrm, abort", new Object[0]);
            return false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m14393(Throwable th) {
        if (!C1317As.m3766() || !(th instanceof MediaDrmResetException)) {
            return false;
        }
        m14383(StatusCode.DRM_FAILURE_MEDIADRM_RESET, th);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public byte[] m14400(AbstractC0472.C0474 r14, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        MediaDrm.CryptoSession r3 = m14401(r14);
        if (r3 == null) {
            C1283.m16865(f13527, "encrypt - session NOT found!");
            return null;
        } else if (ifVar == null) {
            C1283.m16865(f13527, "encrypt - kce is null!");
            return null;
        } else {
            try {
                int length = bArr.length;
                if (length <= 16384) {
                    bArr3 = r3.encrypt(ifVar.m14369(), C1324Ax.m3811(bArr, 16), bArr2);
                } else {
                    C1283.m16865(f13527, "encrypt piecewise");
                    byte[] bArr4 = new byte[(length + (16 - (length % 16)))];
                    int i = 0;
                    byte[] bArr5 = bArr2;
                    do {
                        byte[] encrypt = r3.encrypt(ifVar.m14369(), Arrays.copyOfRange(bArr, i, i + 16384), bArr5);
                        bArr5 = Arrays.copyOfRange(encrypt, 16368, 16384);
                        System.arraycopy(encrypt, 0, bArr4, i, 16384);
                        i += 16384;
                    } while (length - i > 16384);
                    if (length - i > 0) {
                        byte[] encrypt2 = r3.encrypt(ifVar.m14369(), C1324Ax.m3811(Arrays.copyOfRange(bArr, i, length), 16), bArr5);
                        System.arraycopy(encrypt2, 0, bArr4, i, encrypt2.length);
                    }
                    bArr3 = bArr4;
                }
                m14391(length, bArr3.length);
                return bArr3;
            } catch (Throwable th) {
                C1283.m16856(f13527, th, "Failed to encrypt ", new Object[0]);
                m14383(StatusCode.DRM_FAILURE_MEDIADRM_ENCRYPT, th);
                return null;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14391(int i, int i2) {
        if (!C1317As.m3766() && i > 0 && i2 < i) {
            this.f13537.mo1737(ErrorSource.msl, StatusCode.DRM_FAILURE_MEDIADRM_RESET, null);
        }
    }

    @Override // o.AbstractC0472
    /* renamed from: ˏ */
    public byte[] mo14362(AbstractC0472.C0474 r5, AbstractC0472.Cif ifVar, byte[] bArr) {
        byte[] bArr2 = null;
        try {
            bArr2 = m14386(r5, ifVar, bArr);
        } catch (Throwable th) {
            if (!m14393(th)) {
                m14383(StatusCode.DRM_FAILURE_MEDIADRM_SIGN, th);
                return f13529;
            }
        }
        if (bArr2 != null) {
            return bArr2;
        }
        return f13529;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private byte[] m14386(AbstractC0472.C0474 r4, AbstractC0472.Cif ifVar, byte[] bArr) {
        MediaDrm.CryptoSession r2 = m14401(r4);
        if (r2 == null) {
            C1283.m16865(f13527, "sign - session NOT found!");
            return null;
        } else if (ifVar != null) {
            return r2.sign(ifVar.m14369(), bArr);
        } else {
            C1283.m16865(f13527, "sign - kch is null!");
            return null;
        }
    }

    @Override // o.AbstractC0472
    /* renamed from: ॱ */
    public boolean mo14363(AbstractC0472.C0474 r5, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        try {
            return m14378(r5, ifVar, bArr, bArr2);
        } catch (Throwable th) {
            if (m14393(th)) {
                return false;
            }
            m14383(StatusCode.DRM_FAILURE_MEDIADRM_VERIFY, th);
            return false;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m14378(AbstractC0472.C0474 r4, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        MediaDrm.CryptoSession r2 = m14401(r4);
        if (r2 == null) {
            C1283.m16865(f13527, "verify - session NOT found!");
            return false;
        } else if (ifVar != null) {
            return r2.verify(ifVar.m14369(), bArr, bArr2);
        } else {
            C1283.m16865(f13527, "verify - kch is null!");
            return false;
        }
    }

    @Override // android.media.MediaDrm.OnEventListener
    public void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        if (i == 1) {
            C1283.m16854(f13527, "Provisioning is required");
        } else if (i == 2) {
            C1283.m16854(f13527, "MediaDrm event: Key required");
        } else if (i == 3) {
            C1283.m16854(f13527, "MediaDrm event: Key expired");
        } else if (i != 4 && i == 5) {
            m14384(bArr);
            m14385(bArr);
            this.f13534.mo14371();
        }
    }

    @Override // o.AbstractC0472
    /* renamed from: ˎ */
    public synchronized AbstractC0472.C0474 mo14359(DF df, byte[] bArr, AbstractC0472.Cif ifVar, AbstractC0472.Cif ifVar2) {
        C1283.m16854(f13527, "Provide key response...");
        AbstractC0472.C0474 r3 = m14382(df);
        byte[] bArr2 = null;
        try {
            bArr2 = this.f13539.provideKeyResponse(r3.f13526, bArr);
        } catch (Throwable th) {
            C1283.m16856(f13527, th, "Failed to provide key response", new Object[0]);
            this.f13537.mo1737(ErrorSource.msl, StatusCode.DRM_FAILURE_MEDIADRM_PROVIDE_KEY_RESPONSE, th);
        }
        C1283.m16854(f13527, "Save keys...");
        if (bArr2 == null) {
            C1283.m16850(f13527, "Something is wrong, this should not happen! KeySetId is null!");
            return null;
        }
        r3.f13524 = new AbstractC0472.Cif(bArr2);
        return r3;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0472.C0474 m14382(DF df) {
        if (!(df instanceof C1800gF)) {
            throw new IllegalStateException("Not original request! But: " + df);
        }
        C1800gF gFVar = (C1800gF) df;
        if (this.f13535 != gFVar) {
            throw new IllegalStateException("Not original request! Instead of: " + this.f13535 + ", we got: " + df);
        }
        this.f13535 = null;
        AbstractC0472.C0474 r4 = gFVar.m6537();
        if (r4 == null) {
            throw new IllegalArgumentException("updateKeyResponse:: pending crypto session can NOT be null!");
        }
        if (gFVar.m4598() == null || gFVar.m4598().equals(gFVar.m6537().m14375())) {
            C1283.m16854(f13527, "Key request is as expected.");
        }
        return r4;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected static String m14397() {
        return "AES/CBC/NoPadding";
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected static String m14395() {
        return "HmacSHA256";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Ϯ$if  reason: invalid class name */
    public class Cif extends BroadcastReceiver {
        private Cif() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_STARTED".equals(intent.getAction())) {
                AbstractC0476.this.f13533.set(true);
            } else if ("com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_ENDED".equals(intent.getAction())) {
                AbstractC0476.this.f13533.set(false);
            }
        }
    }

    @Override // o.AbstractC0472
    /* renamed from: ʻ */
    public synchronized DF mo14354() {
        if (this.f13535 == null || this.f13535.m6537().m14377()) {
            C1283.m16854(f13527, "valid keyRequestData does not exist, create it!");
            AbstractC0472.C0474 r2 = m14387();
            if (r2 == null) {
                throw new IllegalStateException("Crypto session can not be null after ");
            }
            this.f13535 = new C1800gF(r2);
        } else {
            C1283.m16854(f13527, "Key request is already pending, return it");
        }
        return this.f13535;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private AbstractC0472.C0474 m14387() {
        boolean z;
        AbstractC0472.C0474 r6 = null;
        try {
            C1283.m16854(f13527, "createCryptoSession:: before open session");
            r6 = new AbstractC0472.C0474();
            r6.f13526 = this.f13539.openSession();
            m14390();
            C1283.m16854(f13527, "createCryptoSession:: after open session");
            r6.f13525 = this.f13539.getKeyRequest(r6.f13526, this.f13536, "application/xml", 2, new HashMap<>()).getData();
            if (r6.m14377()) {
                C1283.m16850(f13527, "keyRequestData is null or empty, doCloseCryptoSession to avoid session leaks");
                m14399(r6);
            }
            C1283.m16851(f13527, "Number of all opened crypto sessions: %d", Integer.valueOf(this.f13532.get()));
        } catch (Throwable th) {
            C1283.m16856(f13527, th, "Failed to get key request on retry, report an error", new Object[0]);
        }
        return r6;
        if (z) {
            m14399((AbstractC0472.C0474) null);
            f13528 = this.f13532.get();
            this.f13537.mo1737(ErrorSource.msl, StatusCode.DRM_FAILURE_MEDIADRM_GET_KEY_REQUEST, th);
        }
        return r6;
    }

    @Override // o.AbstractC0472
    /* renamed from: ˎ */
    public AbstractC0472.C0474 mo14360(AbstractC0472.Cif ifVar) {
        AbstractC0472.C0474 r0 = new AbstractC0472.C0474();
        r0.f13524 = ifVar;
        return r0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14383(StatusCode statusCode, Throwable th) {
        this.f13537.mo1737(ErrorSource.msl, statusCode, th);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m14390() {
        int r3 = C1339Bl.m4037(this.f13538, "max_msl_drm_session_count", 0);
        int incrementAndGet = this.f13532.incrementAndGet();
        if (incrementAndGet > r3) {
            C1339Bl.m4042(this.f13538, "max_msl_drm_session_count", incrementAndGet);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m14394() {
        f13530 = C1339Bl.m4037(this.f13538, "max_msl_drm_session_count", 0);
        C1339Bl.m4042(this.f13538, "max_msl_drm_session_count", 0);
        this.f13532.set(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14392(o.AbstractC0472.C0474 r6) {
        /*
            r5 = this;
            byte[] r0 = r6.f13526
            if (r0 != 0) goto L_0x0077
            o.ϝ$if r0 = r6.f13524
            if (r0 == 0) goto L_0x0077
            android.media.MediaDrm r0 = r5.f13539     // Catch:{ Throwable -> 0x0021 }
            byte[] r0 = r0.openSession()     // Catch:{ Throwable -> 0x0021 }
            r6.f13526 = r0     // Catch:{ Throwable -> 0x0021 }
            r5.m14390()     // Catch:{ Throwable -> 0x0021 }
            android.media.MediaDrm r0 = r5.f13539     // Catch:{ Throwable -> 0x0021 }
            byte[] r1 = r6.f13526     // Catch:{ Throwable -> 0x0021 }
            o.ϝ$if r2 = r6.f13524     // Catch:{ Throwable -> 0x0021 }
            byte[] r2 = r2.m14369()     // Catch:{ Throwable -> 0x0021 }
            r0.restoreKeys(r1, r2)     // Catch:{ Throwable -> 0x0021 }
            goto L_0x0074
        L_0x0021:
            r3 = move-exception
            java.lang.String r0 = o.AbstractC0476.f13527
            java.lang.String r1 = "Failed to restore keys!"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            o.C1283.m16856(r0, r3, r1, r2)
            o.ｕ r0 = o.C1276.m16820()     // Catch:{ Throwable -> 0x003a }
            com.netflix.mediaclient.StatusCode r1 = com.netflix.mediaclient.StatusCode.DRM_FAILURE_MEDIADRM_KEYS_RESTORE_FAILED     // Catch:{ Throwable -> 0x003a }
            java.lang.String r1 = r1.name()     // Catch:{ Throwable -> 0x003a }
            r0.mo5725(r1)     // Catch:{ Throwable -> 0x003a }
            goto L_0x0045
        L_0x003a:
            r4 = move-exception
            java.lang.String r0 = o.AbstractC0476.f13527
            java.lang.String r1 = "Failed to log?"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            o.C1283.m16856(r0, r4, r1, r2)
        L_0x0045:
            r5.m14399(r6)     // Catch:{ Throwable -> 0x0049 }
            goto L_0x0054
        L_0x0049:
            r4 = move-exception
            java.lang.String r0 = o.AbstractC0476.f13527
            java.lang.String r1 = "Failed to close crypto session?"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            o.C1283.m16856(r0, r4, r1, r2)
        L_0x0054:
            o.ϝ$ˊ r0 = r5.f13534
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = o.AbstractC0476.f13527
            java.lang.String r1 = "Reset MSL store starts..."
            o.C1283.m16854(r0, r1)
            o.ϝ$ˊ r0 = r5.f13534
            r0.mo14372()
            java.lang.String r0 = o.AbstractC0476.f13527
            java.lang.String r1 = "Reset MSL store done!"
            o.C1283.m16854(r0, r1)
            goto L_0x0073
        L_0x006c:
            java.lang.String r0 = o.AbstractC0476.f13527
            java.lang.String r1 = "Unable to reset MSL store, callback is missing!"
            o.C1283.m16850(r0, r1)
        L_0x0073:
            return
        L_0x0074:
            r5.m14396(r6)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.AbstractC0476.m14392(o.ϝ$ˋ):void");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m14396(AbstractC0472.C0474 r8) {
        synchronized (this.f13542) {
            this.f13542.add(r8);
            int size = this.f13542.size() - 2;
            for (int i = 0; i < size; i++) {
                AbstractC0472.C0474 remove = this.f13542.remove(0);
                if (!(remove == null || remove.f13526 == null)) {
                    m14384(remove.f13526);
                    remove.f13526 = null;
                }
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m14381(AbstractC0472.C0474 r4) {
        synchronized (this.f13542) {
            this.f13542.remove(r4);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14385(byte[] bArr) {
        AbstractC0472.C0474 r1 = null;
        synchronized (this.f13542) {
            Iterator<AbstractC0472.C0474> it = this.f13542.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC0472.C0474 next = it.next();
                if (bArr.equals(next.f13526)) {
                    r1 = next;
                    break;
                }
            }
            if (r1 != null) {
                this.f13542.remove(r1);
            }
        }
    }
}
