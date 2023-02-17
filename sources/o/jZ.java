package o;

import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.os.Looper;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import java.util.UUID;
public class jZ implements DrmSessionManager<FrameworkMediaCrypto>, DrmSession<FrameworkMediaCrypto> {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final UUID f7993 = AV.f4319;

    /* renamed from: ˊ  reason: contains not printable characters */
    private MediaDrm f7994 = AV.m3455((MediaDrm.OnEventListener) null);

    /* renamed from: ˋ  reason: contains not printable characters */
    private FrameworkMediaCrypto f7995;

    /* renamed from: ˎ  reason: contains not printable characters */
    private byte[] f7996 = this.f7994.openSession();

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f7997;

    public jZ(byte[] bArr) {
        this.f7994.restoreKeys(this.f7996, bArr);
        this.f7995 = new FrameworkMediaCrypto(new MediaCrypto(f7993, this.f7996), false);
        this.f7997 = 4;
        AV.m3467("OfflinePlayback_DrmSession", this.f7994, this.f7996);
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
        this.f7994.closeSession(this.f7996);
        this.f7994.release();
        this.f7997 = 0;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return this.f7997;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public FrameworkMediaCrypto getMediaCrypto() {
        return this.f7995;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public DrmSession.DrmSessionException getError() {
        return null;
    }
}
