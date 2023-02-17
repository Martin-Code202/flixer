package o;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* renamed from: o.kj  reason: case insensitive filesystem */
public class C1939kj {

    /* renamed from: ˋ  reason: contains not printable characters */
    private IAsePlayerState.C1288iF f8397;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Chunk f8398;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<IAsePlayerState.C1288iF> f8399 = new ArrayList();

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8395(int i, Chunk chunk) {
        if (chunk.startTimeUs >= 0) {
            this.f8397 = new IAsePlayerState.C1288iF(i, chunk.trackFormat, chunk.startTimeUs, chunk.endTimeUs, chunk.trackFormat.id, chunk.dataSpec);
            this.f8398 = chunk;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8398(int i, Chunk chunk) {
        if (chunk.startTimeUs >= 0) {
            String str = chunk.trackFormat.id;
            DataSpec dataSpec = chunk.dataSpec;
            synchronized (this.f8399) {
                if (this.f8397 == null || !this.f8397.m1018(dataSpec)) {
                    IAsePlayerState.C1288iF iFVar = new IAsePlayerState.C1288iF(i, chunk.trackFormat, chunk.startTimeUs, chunk.endTimeUs, str, dataSpec);
                    iFVar.m1017(chunk.dataSpec.length);
                    this.f8399.add(iFVar);
                } else {
                    this.f8397.m1017(chunk.dataSpec.length);
                    this.f8399.add(this.f8397);
                }
                this.f8397 = null;
                this.f8398 = null;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8396(long j, DataSpec dataSpec) {
        if (j >= 0) {
            synchronized (this.f8399) {
                if (this.f8397 != null && this.f8397.m1018(dataSpec)) {
                    this.f8397 = null;
                    this.f8398 = null;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public IAsePlayerState.Cif m8394(long j) {
        IAsePlayerState.Cif ifVar;
        synchronized (this.f8399) {
            m8393(this.f8399, j);
            ifVar = new IAsePlayerState.Cif((IAsePlayerState.C1288iF[]) this.f8399.toArray(new IAsePlayerState.C1288iF[0]), this.f8397);
        }
        return ifVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public IAsePlayerState.C1288iF m8397() {
        synchronized (this.f8399) {
            if (this.f8397 != null) {
                this.f8397.m1017(this.f8398 == null ? 0 : this.f8398.bytesLoaded());
                return this.f8397;
            } else if (this.f8399.isEmpty()) {
                return null;
            } else {
                return this.f8399.get(this.f8399.size() - 1);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8393(List<IAsePlayerState.C1288iF> list, long j) {
        ListIterator<IAsePlayerState.C1288iF> listIterator = list.listIterator();
        long msToUs = C.msToUs(j);
        long msToUs2 = C.msToUs(1 + j);
        boolean z = false;
        while (listIterator.hasNext()) {
            IAsePlayerState.C1288iF next = listIterator.next();
            long r8 = next.m1016();
            if (!z && msToUs <= r8 && msToUs2 >= next.m8441()) {
                z = true;
            }
            if (r8 <= msToUs || !z) {
                listIterator.remove();
            } else {
                return;
            }
        }
    }
}
