package o;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.PlayerStateMachine;
import com.netflix.mediaclient.servicemgr.Logblob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* renamed from: o.lx  reason: case insensitive filesystem */
public class C1965lx extends lC {
    @SerializedName("strmsel")
    protected ArrayList<iF> strmsel = new ArrayList<>();

    @Override // o.lC
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ Logblob mo8548() {
        return super.mo8548();
    }

    @Override // o.lC
    /* renamed from: ॱ */
    public /* bridge */ /* synthetic */ lC mo8549(long j, IAsePlayerState iAsePlayerState) {
        return super.mo8549(j, iAsePlayerState);
    }

    public C1965lx(String str) {
        super("asereport", str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8766(int i, PlayerStateMachine.State state, int[] iArr, long j, int i2, long j2, long j3, long j4, int i3, int i4) {
        int r13 = m8761(i);
        int r14 = m8762(state);
        iF iFVar = null;
        Iterator<iF> it = this.strmsel.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            iF next = it.next();
            if (next.dltype == r13) {
                iFVar = next;
                break;
            }
        }
        if (iFVar == null) {
            iFVar = new iF(r13, iArr);
            this.strmsel.add(iFVar);
        }
        iFVar.m8769(j, i2, j2, j3, j4, i3, i4, r14);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m8763(int i, int[] iArr) {
        int r1 = m8761(i);
        Iterator<iF> it = this.strmsel.iterator();
        while (it.hasNext()) {
            iF next = it.next();
            if (next.dltype == r1 && !Arrays.equals(next.bitrates, iArr)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m8765() {
        Iterator<iF> it = this.strmsel.iterator();
        while (it.hasNext()) {
            if (!it.next().m8770()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8764() {
        this.strmsel.clear();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int m8761(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return -1;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final int m8762(PlayerStateMachine.State state) {
        switch (state) {
            case INITIALIZING:
                return 0;
            case PAUSED:
                return 5;
            case PLAYING:
                return 3;
            case REBUFFERING:
                return 2;
            case SEEKING:
            case SKIPPING:
            case AUDIO:
                return 1;
            default:
                return -1;
        }
    }

    /* renamed from: o.lx$iF */
    public static class iF {
        @SerializedName("bitrates")
        private int[] bitrates;
        @SerializedName("dltype")
        private int dltype;
        @SerializedName("seltrace")
        private ArrayList<long[]> seltrace = new ArrayList<>();

        /* renamed from: ˏ  reason: contains not printable characters */
        private transient long[] f8662;

        public iF(int i, int[] iArr) {
            this.dltype = i;
            this.bitrates = iArr;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m8769(long j, int i, long j2, long j3, long j4, int i2, int i3, int i4) {
            long[] jArr = {(long) i, j, j2, j3, j4, (long) i3, (long) i2, (long) i4};
            if (this.f8662 == null) {
                this.seltrace.add(jArr);
            } else {
                this.seltrace.add(new long[]{((long) i) - this.f8662[0], j - this.f8662[1], j2 - this.f8662[2], j3 - this.f8662[3], j4 - this.f8662[4], ((long) i3) - this.f8662[5], ((long) i2) - this.f8662[6], ((long) i4) - this.f8662[7]});
            }
            this.f8662 = jArr;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public boolean m8770() {
            return this.seltrace.isEmpty();
        }
    }
}
