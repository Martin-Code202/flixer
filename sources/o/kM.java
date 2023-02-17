package o;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import o.jD;
import o.kL;
import o.kO;
import org.json.JSONException;
public class kM {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Queue<C2054pc> f8217 = new LinkedList();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final jE f8218;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final PriorityTaskManager f8219;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f8220;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC0661 f8221;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C1938ki f8222;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AtomicBoolean f8223 = new AtomicBoolean(false);

    public kM(Context context, C1938ki kiVar, jE jEVar, PriorityTaskManager priorityTaskManager, AbstractC0661 r7) {
        this.f8220 = context;
        this.f8222 = kiVar;
        this.f8218 = jEVar;
        this.f8219 = priorityTaskManager;
        this.f8221 = r7;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8260() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m8262(List<C2054pc> list) {
        synchronized (this.f8217) {
            this.f8217.addAll(list);
        }
        if (!this.f8223.getAndSet(true)) {
            m8251();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8261(PlayerPrefetchSource playerPrefetchSource) {
        synchronized (this.f8217) {
            Iterator<C2054pc> it = this.f8217.iterator();
            while (it.hasNext()) {
                C2054pc next = it.next();
                if (next.f9380 == playerPrefetchSource) {
                    C1283.m16848("nf_cache", "aborting prefetch request %s", next);
                    it.remove();
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m8259() {
        if (C0578.m14693() && !((ConnectivityManager) this.f8220.getSystemService("connectivity")).isActiveNetworkMetered()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8251() {
        final C2054pc poll;
        synchronized (this.f8217) {
            poll = this.f8217.poll();
        }
        if (poll != null) {
            C1283.m16851("nf_cache", "processing %s for prefetch", poll);
            if (!m8259()) {
                m8251();
            } else {
                this.f8218.mo7860(Long.valueOf(poll.f9381), (jD.If) new jD.If() { // from class: o.kM.1
                    @Override // o.jD.If
                    /* renamed from: ˊ */
                    public void mo7495(jG jGVar) {
                        kM.this.m8250(poll, jGVar);
                    }

                    @Override // o.jD.If
                    /* renamed from: ॱ */
                    public void mo7506(Long l, Status status) {
                        kM.this.m8251();
                    }
                }, false);
            }
        } else {
            this.f8223.set(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8250(final C2054pc pcVar, final jG jGVar) {
        if (jGVar instanceof jH) {
            try {
                ((jH) jGVar).m7939();
            } catch (JSONException e) {
                C1283.m16847("nf_cache", "failed to load Manifest %s", e);
                return;
            }
        }
        new kN(jGVar, new kO.iF() { // from class: o.kM.3
            @Override // o.kO.iF
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo8264(kS kSVar) {
                m8263();
                kM.this.m8253(pcVar, kSVar);
            }

            @Override // o.kO.iF
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo8265(String str) {
                m8263();
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            private void m8263() {
                if (jGVar instanceof jH) {
                    ((jH) jGVar).m7937();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8253(C2054pc pcVar, kS kSVar) {
        long millis = TimeUnit.SECONDS.toMillis(pcVar.f9378);
        Object r9 = this.f8222.mo8388$5e5740c4(kSVar.m8323(), "Default");
        C1957lk lkVar = new C1957lk(kSVar.m8325(), null, ((Class) C1235.m16591(3, 4, 51741)).getField("maxThrottledNetworkFailures").getInt(r9), ((Class) C1235.m16591(3, 4, 51741)).getField("throttledNetworkFailureThresholdMs").getInt(r9));
        kK kKVar = new kK(this.f8220, kSVar.m8322(), kSVar.m8324(), lkVar);
        long r12 = m8257$7512b817(r9, lkVar, kSVar, millis);
        kJ kJVar = new kJ(AbstractApplicationC1258.m16692(), kSVar.m8322(), kKVar, this.f8219);
        kJVar.m8219(m8255(kSVar.m8323(), "Default", kSVar, kJVar.mo8178(-1, C.msToUs(millis)), r12), millis, new kL.If() { // from class: o.kM.4
            @Override // o.kL.If
            /* renamed from: ˎ */
            public void mo8222(Object obj) {
                kM.this.m8251();
            }

            @Override // o.kL.If
            /* renamed from: ॱ */
            public void mo8223() {
                kM.this.m8251();
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private List<Representation> m8255(StreamProfileType streamProfileType, String str, kS kSVar, List<C1948ks> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (AdaptationSet adaptationSet : kSVar.getPeriod(0).adaptationSets) {
            if (adaptationSet.type == 2) {
                List<Representation> r9 = m8254(streamProfileType, str, adaptationSet, j);
                m8252(adaptationSet, list, 2, r9);
                arrayList.addAll(r9);
            } else {
                List<Representation> r92 = m8247(adaptationSet);
                m8252(adaptationSet, list, 1, r92);
                arrayList.addAll(r92);
            }
        }
        return arrayList;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private List<Representation> m8254(StreamProfileType streamProfileType, String str, AdaptationSet adaptationSet, long j) {
        ArrayList arrayList = new ArrayList();
        Representation representation = adaptationSet.representations.isEmpty() ? null : adaptationSet.representations.get(0);
        for (Representation representation2 : adaptationSet.representations) {
            if (!this.f8222.m8390(streamProfileType, str, representation2.format.bitrate, (int) j)) {
                break;
            }
            representation = representation2;
        }
        if (representation != null) {
            C1283.m16851("nf_cache", "prefetching %s kbps video bitrate based on estimated throughput %s kbps", Integer.valueOf(representation.format.bitrate / 1000), Long.valueOf(j));
            arrayList.add(representation);
        }
        return arrayList;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private List<Representation> m8247(AdaptationSet adaptationSet) {
        ArrayList arrayList = new ArrayList();
        Iterator<Representation> it = adaptationSet.representations.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Representation next = it.next();
            if ((next.format.selectionFlags & 1) != 0) {
                arrayList.add(next);
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: ˏ$7512b817  reason: contains not printable characters */
    private long m8257$7512b817(Object obj, kw kwVar, kS kSVar, long j) {
        Throwable cause;
        C0131 r0 = new C0131(kSVar, j);
        C1938ki kiVar = this.f8222;
        try {
            Object[] objArr = new Object[4];
            objArr[3] = obj;
            objArr[2] = kwVar;
            objArr[1] = kiVar;
            objArr[0] = r0;
            Object newInstance = ((Class) C1235.m16591(717, 4, 4771)).getDeclaredConstructor(IAsePlayerState.class, AbstractC1949kt.class, kw.class, (Class) C1235.m16591(3, 4, 51741)).newInstance(objArr);
            try {
                Object[] objArr2 = new Object[3];
                objArr2[2] = newInstance;
                objArr2[1] = null;
                objArr2[0] = obj;
                try {
                    long longValue = ((Long) ((Class) C1235.m16591(15, 106, 0)).getMethod("getBitrateEstimate", null).invoke(((Class) C1235.m16591(15, 106, 0)).getDeclaredConstructor((Class) C1235.m16591(3, 4, 51741), kZ.class, (Class) C1235.m16591(717, 4, 4771)).newInstance(objArr2), null)).longValue();
                    if (longValue > 0) {
                        return longValue / 1000;
                    }
                    return (long) this.f8221.mo14821();
                } catch (Throwable th) {
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } finally {
                if (cause != null) {
                    throw cause;
                }
            }
        } finally {
            cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m8252(AdaptationSet adaptationSet, List<C1948ks> list, int i, List<Representation> list2) {
        Format r7;
        if (!list2.isEmpty()) {
            for (C1948ks ksVar : list) {
                if (ksVar.m8438() == i && (r7 = m8258(adaptationSet, ksVar.m8439())) != null) {
                    Iterator<Representation> it = list2.iterator();
                    while (it.hasNext()) {
                        Format format = it.next().format;
                        if (format.bitrate < r7.bitrate) {
                            C1283.m16863("nf_cache", "skipping prefetch (already cached): wanted=%s , cached=%s", Integer.valueOf(format.bitrate), Integer.valueOf(r7.bitrate));
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Format m8258(AdaptationSet adaptationSet, String str) {
        for (Representation representation : adaptationSet.representations) {
            if (representation.format.id.equals(str)) {
                return representation.format;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kM$ˋ  reason: contains not printable characters */
    public static class C0131 implements IAsePlayerState {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final long f8230;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final kS f8231;

        public C0131(kS kSVar, long j) {
            this.f8231 = kSVar;
            this.f8230 = j;
        }

        @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
        /* renamed from: ᐝ */
        public IAsePlayerState.AsePlayerState mo1011() {
            return IAsePlayerState.AsePlayerState.ASE_PLAYER_BUFFERING;
        }

        @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
        /* renamed from: ʻ */
        public long mo1007() {
            return C.msToUs(this.f8230);
        }

        @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
        /* renamed from: ʼ */
        public IAsePlayerState.Cif[] mo1008() {
            return new IAsePlayerState.Cif[2];
        }

        @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
        /* renamed from: ˏॱ */
        public IAsePlayerState.C1288iF[] mo1009() {
            return new IAsePlayerState.C1288iF[2];
        }

        @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
        /* renamed from: ॱˊ */
        public IAsePlayerState.If mo1010() {
            return new IAsePlayerState.If(this.f8231.m8323(), C2036ol.m9673());
        }
    }
}
