package o;

import android.content.Context;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.netflix.mediaclient.service.player.streamingplayback.StreamingPlaybackErrorCode;
import o.kO;
import org.json.JSONObject;
/* renamed from: o.kq  reason: case insensitive filesystem */
public class C1946kq implements AbstractC1930ka {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final lH f8436;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C1938ki f8437;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C1962lu f8438;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f8439 = true;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f8440;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1933kd f8441;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1941kl f8442;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final String f8443;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Long f8444;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f8445;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final PriorityTaskManager f8446;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Surface f8447;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private kO f8448;

    public C1946kq(Context context, C1938ki kiVar, C1962lu luVar, AbstractC1933kd kdVar, Handler handler, lH lHVar, String str, PriorityTaskManager priorityTaskManager) {
        this.f8445 = context;
        this.f8441 = kdVar;
        this.f8440 = handler;
        this.f8437 = kiVar;
        this.f8438 = luVar;
        this.f8436 = lHVar;
        this.f8443 = str;
        this.f8446 = priorityTaskManager;
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˊ */
    public void mo8361(final jG jGVar, String str, String str2, final long j, final jA jAVar) {
        this.f8439 = false;
        this.f8448 = new kN(jGVar, new kO.iF() { // from class: o.kq.2
            @Override // o.kO.iF
            /* renamed from: ˎ */
            public void mo8264(kS kSVar) {
                C1283.m16862("StreamingPlayback_ExoSessionPlayer", "ready to open ExoSessionPlayerInternal");
                C1946kq.this.f8436.mo8589("dashManifestAvailable");
                C1946kq.this.f8444 = jGVar.m7933();
                C1945kp kpVar = jAVar != null ? new C1945kp(jAVar) : null;
                try {
                    Object newInstance = ((Class) C1235.m16591(3, 4, 51741)).getDeclaredConstructor(null).newInstance(null);
                    kK kKVar = new kK(C1946kq.this.f8445, kSVar.m8322(), kSVar.m8324(), new C1957lk(kSVar.m8325(), null, ((Class) C1235.m16591(3, 4, 51741)).getField("maxThrottledNetworkFailures").getInt(newInstance), ((Class) C1235.m16591(3, 4, 51741)).getField("throttledNetworkFailureThresholdMs").getInt(newInstance)));
                    C1946kq.this.f8442 = new C1941kl(C1946kq.this.f8445, C1946kq.this.f8440, C1946kq.this.f8441, kSVar, kpVar, j, kKVar, new kJ(C1946kq.this.f8445, C1946kq.this.f8444, kKVar, C1946kq.this.f8446), kSVar.m8325(), C1946kq.this.f8437, C1946kq.this.f8436, C1946kq.this.f8438, C1946kq.this.f8443, C1946kq.this.f8446);
                    if (C1946kq.this.f8447 != null) {
                        C1946kq.this.f8442.m8035(C1946kq.this.f8447);
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }

            @Override // o.kO.iF
            /* renamed from: ॱ */
            public void mo8265(String str3) {
                C1283.m16863("StreamingPlayback_ExoSessionPlayer", "dashManifestError %s", str3);
                C1946kq.this.f8441.mo908(new C1934ke(StreamingPlaybackErrorCode.MANIFEST_PROCESS_ERROR));
            }
        });
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˋ */
    public void mo8362() {
        this.f8439 = true;
        if (this.f8442 != null) {
            this.f8442.m8037();
        }
        if (this.f8448 != null) {
            this.f8448.m8291();
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ॱ */
    public void mo8372() {
        if (this.f8442 != null) {
            this.f8442.m8034();
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˎ */
    public void mo8365() {
        if (this.f8442 != null) {
            this.f8442.m8038();
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˎ */
    public void mo8366(long j, boolean z) {
        if (this.f8442 != null) {
            this.f8442.m8414(j);
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˋ */
    public void mo8363(int i, int i2) {
        if (this.f8442 != null) {
            this.f8442.m8414(this.f8442.m8036() + ((long) i));
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˏ */
    public void mo8369(int i, int i2) {
        if (this.f8442 != null) {
            this.f8442.m8415(i, i2);
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˎ */
    public void mo8367(String str) {
        if (this.f8442 != null) {
            this.f8442.m8039(str);
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˏ */
    public void mo8370(JSONObject jSONObject) {
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˏ */
    public boolean mo8371() {
        return this.f8439;
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ॱ */
    public void mo8373(Surface surface) {
        C1283.m16863("StreamingPlayback_ExoSessionPlayer", "setSurface %s", surface);
        this.f8447 = surface;
        if (this.f8442 != null) {
            this.f8442.m8035(surface);
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˊ */
    public void mo8359() {
        if (this.f8442 != null) {
            this.f8442.mo7981();
        }
        this.f8437.m8389();
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˊ */
    public void mo8360(String str) {
        this.f8436.mo8589("licenseReceived");
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˋ */
    public void mo8364(boolean z) {
        if (this.f8442 != null) {
            this.f8442.m8033(z);
        }
    }

    @Override // o.AbstractC1930ka
    /* renamed from: ˏ */
    public void mo8368(float f) {
        if (this.f8442 != null) {
            this.f8442.m8031(f);
        }
    }
}
