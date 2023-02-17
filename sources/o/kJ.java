package o;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import o.AbstractC1951ky;
import o.kL;
import o.kP;
public class kJ implements kA {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f8177;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f8178;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1951ky f8179;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final kL f8180;

    /* renamed from: ˏ  reason: contains not printable characters */
    private List<C1948ks> f8181;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final kI f8182;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static kI m8217(Context context) {
        return kI.m8208(context, "fragment", C1330Bc.m4001());
    }

    public kJ(Context context, Long l, AbstractC1951ky kyVar, PriorityTaskManager priorityTaskManager) {
        this.f8182 = m8217(context);
        this.f8180 = new kL(this.f8182, new C1962lu(context), priorityTaskManager);
        this.f8179 = kyVar;
        this.f8178 = l.toString();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8219(List<Representation> list, long j, kL.If r16) {
        If r9 = new If(list.size(), r16);
        for (Representation representation : list) {
            this.f8179.mo8237(representation.format.id, new Cif(Uri.parse(representation.baseUrl), representation.getCacheKey(), j, r9));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized List<C1948ks> m8218() {
        C1948ks r19;
        if (!C0578.m14693()) {
            return Collections.emptyList();
        }
        int r7 = this.f8182.m8212(this.f8178);
        if (this.f8181 != null && this.f8177 == r7) {
            return this.f8181;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f8182.m8213(this.f8178)) {
            kP.C0134 r11 = kP.m8293(str);
            if (r11 != null) {
                String str2 = r11.f8270;
                List<C1950ku> r13 = this.f8179.mo8234(str2, -9223372036854775807L, -9223372036854775807L);
                if (r13 != null) {
                    NavigableSet<CacheSpan> cachedSpans = this.f8182.getCachedSpans(str);
                    if (cachedSpans != null) {
                        if (!cachedSpans.isEmpty()) {
                            long j = -1;
                            long j2 = -1;
                            for (CacheSpan cacheSpan : cachedSpans) {
                                if (j != -1) {
                                    if (cacheSpan.position <= j || cacheSpan.position > j + j2 + 1) {
                                        C1948ks r21 = C1948ks.m8437(str2, r13, j, j2, r11.f8268);
                                        if (r21 != null) {
                                            arrayList.add(r21);
                                        }
                                    } else {
                                        j2 = (cacheSpan.position + cacheSpan.length) - j;
                                    }
                                }
                                j2 = cacheSpan.length;
                                j = cacheSpan.position;
                            }
                            if (!(j == -1 || (r19 = C1948ks.m8437(str2, r13, j, j2, r11.f8268)) == null)) {
                                arrayList.add(r19);
                            }
                        }
                    }
                } else {
                    C1283.m16855("nf_cache", "abandoned fragment (missing header): %s", str2);
                }
            }
        }
        this.f8181 = arrayList;
        this.f8177 = r7;
        return arrayList;
    }

    @Override // o.kA
    /* renamed from: ˋ */
    public List<C1948ks> mo8178(int i, long j) {
        ArrayList arrayList = null;
        for (C1948ks ksVar : m8218()) {
            if (i == -1 || ksVar.m8438() == i) {
                if (ksVar.m8441() <= j && ksVar.m8445() >= j) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(ksVar);
                }
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }

    /* renamed from: o.kJ$if  reason: invalid class name */
    public class Cif implements AbstractC1951ky.If {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Uri f8186;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final long f8187;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final String f8188;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final kL.If f8189;

        public Cif(Uri uri, String str, long j, kL.If r6) {
            this.f8186 = uri;
            this.f8187 = j;
            this.f8188 = str;
            this.f8189 = r6;
        }

        @Override // o.AbstractC1951ky.If
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo8224(String str, List<C1950ku> list) {
            if (kJ.this.f8182.m8211() <= 0) {
                C1283.m16865("nf_cache", "cache size too low - disabling prefetch");
                return;
            }
            long micros = TimeUnit.MILLISECONDS.toMicros(this.f8187);
            long micros2 = TimeUnit.SECONDS.toMicros((long) C0578.m14694());
            if (micros2 <= 0) {
                C1283.m16844("nf_cache", "invalid fetch duration %s", Long.valueOf(micros2));
                this.f8189.mo8223();
                return;
            }
            List<C1950ku> r11 = kC.m8185(list, micros, micros2);
            if (!r11.isEmpty()) {
                C1950ku kuVar = r11.get(0);
                C1950ku kuVar2 = r11.get(r11.size() - 1);
                long r14 = kuVar.m8443();
                long r16 = kuVar2.m8443() + kuVar2.m8440();
                C1283.m16851("nf_cache", "prefetching %s KB (%s-%s) for %s - %s (bookmark=%s)", Long.valueOf((r16 - r14) / 1024), Long.valueOf(r14), Long.valueOf(r16), Long.valueOf(kuVar.m8441()), Long.valueOf(kuVar2.m8445()), Long.valueOf(this.f8187));
                kJ.this.f8180.m8245(new DataSpec(this.f8186, r14, r16 - r14, this.f8188), this.f8189);
                return;
            }
            this.f8189.mo8223();
            C1283.m16844("nf_cache", "could not find chunk info for %s", Long.valueOf(this.f8187));
        }

        @Override // o.AbstractC1951ky.If
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo8225(String str) {
            this.f8189.mo8223();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class If implements kL.If<Void> {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final AtomicBoolean f8183 = new AtomicBoolean(false);

        /* renamed from: ˎ  reason: contains not printable characters */
        private final kL.If f8184;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final AtomicInteger f8185;

        public If(int i, kL.If r4) {
            this.f8184 = r4;
            this.f8185 = new AtomicInteger(i);
            if (i == 0 && r4 != null) {
                r4.mo8222(null);
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo8222(Void r1) {
            m8220();
        }

        @Override // o.kL.If
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo8223() {
            this.f8183.set(true);
            m8220();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m8220() {
            if (this.f8185.decrementAndGet() == 0 && this.f8184 != null) {
                if (this.f8183.get()) {
                    this.f8184.mo8223();
                } else {
                    this.f8184.mo8222(null);
                }
            }
        }
    }
}
