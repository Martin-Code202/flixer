package o;

import android.os.Looper;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
/* renamed from: o.kp  reason: case insensitive filesystem */
public class C1945kp implements DrmSessionManager<FrameworkMediaCrypto>, DrmSession<FrameworkMediaCrypto> {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final jA f8434;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final FrameworkMediaCrypto f8435 = new FrameworkMediaCrypto(this.f8434.m7834(), false);

    C1945kp(jA jAVar) {
        this.f8434 = jAVar;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public boolean canAcquireSession(DrmInitData drmInitData) {
        return true;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession<FrameworkMediaCrypto> acquireSession(Looper looper, DrmInitData drmInitData) {
        return this;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public void releaseSession(DrmSession<FrameworkMediaCrypto> drmSession) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return this.f8434.m7842();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public FrameworkMediaCrypto getMediaCrypto() {
        return this.f8435;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public DrmSession.DrmSessionException getError() {
        return null;
    }
}
