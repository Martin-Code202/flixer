package o;

import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.CurrentNetworkInfo;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.EndPlayJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import o.kP;
import org.chromium.net.RequestFinishedInfo;
public class lS {

    /* renamed from: ʻ  reason: contains not printable characters */
    private Map<String, Long> f8556 = new HashMap();

    /* renamed from: ʼ  reason: contains not printable characters */
    private CurrentNetworkInfo f8557;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f8558;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Handler f8559;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<AbstractC0146> f8560 = new CopyOnWriteArrayList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0145 f8561 = new C0145();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1956iF f8562 = new C1956iF();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<DataSpec, IF> f8563 = new HashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C1955If f8564 = new C1955If();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f8565;

    /* renamed from: o.lS$ˋ  reason: contains not printable characters */
    public interface AbstractC0146 {
        /* renamed from: ˎ */
        void mo8596(RequestFinishedInfo requestFinishedInfo, DataSpec dataSpec, IF v);
    }

    public lS(Handler handler) {
        this.f8559 = handler;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8674() {
        this.f8558 = true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8677(AbstractC0146 r2) {
        this.f8560.add(r2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8676(CurrentNetworkInfo currentNetworkInfo) {
        this.f8557 = currentNetworkInfo;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8675(int i) {
        this.f8565 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m8680() {
        return this.f8562.m8695();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public EndPlayJson.C0020[] m8672() {
        return this.f8561.m8701();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public EndPlayJson.C0021[] m8682() {
        return this.f8564.m8690();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Map<String, Long> m8679() {
        HashMap hashMap;
        synchronized (this.f8556) {
            hashMap = new HashMap(this.f8556);
        }
        return hashMap;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public CacheDataSource.EventListener m8673(final String str) {
        return new CacheDataSource.EventListener() { // from class: o.lS.1
            @Override // com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener
            public void onCachedBytesRead(long j, long j2) {
                lS.this.m8669(str, j2);
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8669(String str, long j) {
        synchronized (this.f8556) {
            Long l = this.f8556.get(str);
            if (l == null) {
                l = 0L;
            }
            this.f8556.put(str, Long.valueOf(l.longValue() + j));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8678(final RequestFinishedInfo requestFinishedInfo) {
        this.f8559.post(new Runnable() { // from class: o.lS.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z = requestFinishedInfo.getFinishedReason() == 1 || (requestFinishedInfo.getResponseInfo() != null && requestFinishedInfo.getResponseInfo().getHttpStatusCode() >= 400);
                lS.this.f8562.m8692(requestFinishedInfo.getMetrics());
                lS.this.f8564.m8689(lS.this.f8565, requestFinishedInfo.getMetrics());
                lS.this.f8561.m8700(lS.this.f8557, requestFinishedInfo.getMetrics());
                if (!(requestFinishedInfo.getMetrics() == null || requestFinishedInfo.getMetrics().getReceivedByteCount() == null)) {
                    lS.this.m8669("network", requestFinishedInfo.getMetrics().getReceivedByteCount().longValue());
                }
                if (lS.this.f8558 || z) {
                    DataSpec dataSpec = null;
                    Iterator<Object> it = requestFinishedInfo.getAnnotations().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (next instanceof DataSpec) {
                            dataSpec = (DataSpec) next;
                            break;
                        }
                    }
                    if (dataSpec == null) {
                        C1283.m16844("nf_playreport", "unable to find dataspec for %s", requestFinishedInfo.getUrl());
                        return;
                    }
                    IF r7 = (IF) lS.this.f8563.get(dataSpec);
                    if (r7 == null) {
                        if (z) {
                            r7 = new IF(dataSpec.key);
                        } else {
                            C1283.m16844("nf_playreport", "unable to find info for %s -- %s", dataSpec, requestFinishedInfo.getUrl());
                            return;
                        }
                    }
                    lS.this.f8563.remove(dataSpec);
                    if (r7.m8687() != null || z) {
                        r7.m8683(requestFinishedInfo);
                        for (AbstractC0146 r9 : lS.this.f8560) {
                            r9.mo8596(requestFinishedInfo, dataSpec, r7);
                        }
                        return;
                    }
                    C1283.m16848("nf_playreport", "ignoring cached request %s", requestFinishedInfo.getUrl());
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8671(final DataSpec dataSpec) {
        if (this.f8558) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f8559.post(new Runnable() { // from class: o.lS.4
                @Override // java.lang.Runnable
                public void run() {
                    IF r2 = new IF(dataSpec.key);
                    r2.m8684(elapsedRealtime);
                    lS.this.f8563.put(dataSpec, r2);
                }
            });
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8681(final DataSpec dataSpec, final long j) {
        if (this.f8558) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f8559.post(new Runnable() { // from class: o.lS.3
                @Override // java.lang.Runnable
                public void run() {
                    IF r5 = (IF) lS.this.f8563.get(dataSpec);
                    if (r5 == null) {
                        C1283.m16844("nf_playreport", "unable to find info for trace %s", dataSpec);
                    } else {
                        r5.m8686(elapsedRealtime, j);
                    }
                }
            });
        }
    }

    public static class IF {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final String f8577;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final int f8578;

        /* renamed from: ˎ  reason: contains not printable characters */
        private long f8579 = -9223372036854775807L;

        /* renamed from: ˏ  reason: contains not printable characters */
        private long f8580 = -9223372036854775807L;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final List<Long> f8581 = new ArrayList();

        public IF(String str) {
            kP.C0134 r2 = kP.m8293(str);
            if (r2 != null) {
                this.f8578 = r2.f8268;
                this.f8577 = r2.f8270;
                return;
            }
            this.f8578 = 0;
            this.f8577 = "";
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m8684(long j) {
            this.f8580 = j;
            this.f8579 = j;
            this.f8581.add(0L);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m8683(RequestFinishedInfo requestFinishedInfo) {
            RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
            if (metrics != null && !this.f8581.isEmpty()) {
                Long totalTimeMs = metrics.getTotalTimeMs();
                Long ttfbMs = metrics.getTtfbMs();
                if (totalTimeMs != null && ttfbMs != null) {
                    long longValue = totalTimeMs.longValue() - ttfbMs.longValue();
                    if (longValue > m8685()) {
                        this.f8581.set(0, Long.valueOf(Math.min(longValue, (long) Math.max(0, (this.f8581.size() * 1000) - 1001))));
                        return;
                    }
                    this.f8581.set(0, Long.valueOf(longValue));
                    long j = (longValue / 1000) + 1;
                    while (((long) (this.f8581.size() - 1)) > j) {
                        this.f8581.set(this.f8581.size() - 2, Long.valueOf(this.f8581.get(this.f8581.size() - 2).longValue() + this.f8581.get(this.f8581.size() - 1).longValue()));
                        this.f8581.remove(this.f8581.size() - 1);
                    }
                }
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m8686(long j, long j2) {
            if (this.f8580 == -9223372036854775807L) {
                C1283.m16850("nf_playreport", "request was never started - cannot generate download trace");
                return;
            }
            this.f8581.set(0, Long.valueOf(j - this.f8580));
            long j3 = j - this.f8580;
            long max = Math.max(0L, j - this.f8579);
            long max2 = Math.max(0L, j3 - max);
            int max3 = Math.max(1, ((int) TimeUnit.MILLISECONDS.toSeconds(max2)) + 1);
            int max4 = Math.max(max3, ((int) TimeUnit.MILLISECONDS.toSeconds(j3)) + 1);
            while (this.f8581.size() <= max4) {
                this.f8581.add(0L);
            }
            if (max3 == max4) {
                this.f8581.set(max3, Long.valueOf(this.f8581.get(max3).longValue() + j2));
            } else {
                double d = ((double) j2) / ((double) max);
                long j4 = 0;
                for (int i = max3; i <= max4; i++) {
                    long j5 = 1000;
                    long millis = max2 - TimeUnit.SECONDS.toMillis((long) (i - 1));
                    if (millis > 0) {
                        j5 = 1000 - millis;
                    }
                    long millis2 = TimeUnit.SECONDS.toMillis((long) i) - j3;
                    if (millis2 > 0) {
                        j5 -= millis2;
                    }
                    long max5 = Math.max(0L, (long) (((double) j5) * d));
                    this.f8581.set(i, Long.valueOf(this.f8581.get(i).longValue() + max5));
                    j4 += max5;
                }
                if (j4 < j2) {
                    this.f8581.set(max4, Long.valueOf(this.f8581.get(max4).longValue() + (j2 - j4)));
                }
            }
            this.f8579 = j;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public long m8685() {
            if (this.f8580 != -9223372036854775807L) {
                return this.f8581.get(0).longValue();
            }
            C1283.m16865("nf_playreport", "request was never started - cannot generate duration");
            return 0;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public Long[] m8687() {
            if (this.f8580 == -9223372036854775807L || this.f8581.size() <= 1) {
                return null;
            }
            return (Long[]) this.f8581.toArray(new Long[this.f8581.size()]);
        }
    }

    /* renamed from: o.lS$iF  reason: case insensitive filesystem */
    public static class C1956iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private long f8583 = -9223372036854775807L;

        /* renamed from: ˋ  reason: contains not printable characters */
        private long f8584 = -9223372036854775807L;

        /* renamed from: ˎ  reason: contains not printable characters */
        private long f8585;

        /* renamed from: ˏ  reason: contains not printable characters */
        private long f8586;

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m8692(RequestFinishedInfo.Metrics metrics) {
            if (metrics != null && metrics.getTotalTimeMs() != null && metrics.getTtfbMs() != null && metrics.getReceivedByteCount() != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                m8694((elapsedRealtime - metrics.getTotalTimeMs().longValue()) + metrics.getTtfbMs().longValue(), elapsedRealtime, metrics.getReceivedByteCount().longValue());
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m8694(long j, long j2, long j3) {
            if (j2 >= this.f8584) {
                this.f8585 += j3;
                this.f8586 += j2 - j;
                if (this.f8584 != -9223372036854775807L && j <= this.f8584) {
                    this.f8586 -= this.f8584 - j;
                    if (this.f8583 != -9223372036854775807L && j < this.f8583) {
                        this.f8586 += this.f8583 - j;
                    }
                }
                if (this.f8584 == -9223372036854775807L || j2 > this.f8584) {
                    this.f8584 = j2;
                }
                if (this.f8583 == -9223372036854775807L || j < this.f8583 || j < this.f8584) {
                    this.f8583 = j;
                }
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public long m8695() {
            if (this.f8586 > 0) {
                return (this.f8585 * 8) / this.f8586;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public long m8691() {
            return this.f8585;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public long m8693() {
            return this.f8586;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.lS$if  reason: invalid class name */
    public static final class Cif {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final Map<CurrentNetworkInfo.NetSpec, C1956iF> f8587;

        private Cif() {
            this.f8587 = new HashMap();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private void m8696(CurrentNetworkInfo.NetSpec netSpec, RequestFinishedInfo.Metrics metrics) {
            C1956iF iFVar = this.f8587.get(netSpec);
            if (iFVar == null) {
                iFVar = new C1956iF();
                this.f8587.put(netSpec, iFVar);
            }
            iFVar.m8692(metrics);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public EndPlayJson.Cif[] m8698() {
            EndPlayJson.Cif[] ifVarArr = new EndPlayJson.Cif[this.f8587.size()];
            int i = 0;
            for (Map.Entry<CurrentNetworkInfo.NetSpec, C1956iF> entry : this.f8587.entrySet()) {
                i++;
                ifVarArr[i] = new EndPlayJson.Cif(entry.getKey(), entry.getValue().m8693(), entry.getValue().m8691());
            }
            return ifVarArr;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.lS$ˊ  reason: contains not printable characters */
    public static final class C0145 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final Map<CurrentNetworkInfo.NetType, Cif> f8588;

        private C0145() {
            this.f8588 = new HashMap();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private void m8700(CurrentNetworkInfo currentNetworkInfo, RequestFinishedInfo.Metrics metrics) {
            if (currentNetworkInfo != null && metrics != null) {
                Cif ifVar = this.f8588.get(currentNetworkInfo.m1039());
                if (ifVar == null) {
                    ifVar = new Cif();
                    this.f8588.put(currentNetworkInfo.m1039(), ifVar);
                }
                ifVar.m8696(currentNetworkInfo.m1040(), metrics);
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public EndPlayJson.C0020[] m8701() {
            EndPlayJson.C0020[] r4 = new EndPlayJson.C0020[this.f8588.size()];
            int i = 0;
            for (Map.Entry<CurrentNetworkInfo.NetType, Cif> entry : this.f8588.entrySet()) {
                i++;
                r4[i] = new EndPlayJson.C0020(entry.getKey(), entry.getValue().m8698());
            }
            return r4;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.lS$If  reason: case insensitive filesystem */
    public static final class C1955If {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final SparseArray<C1956iF> f8582;

        private C1955If() {
            this.f8582 = new SparseArray<>();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private void m8689(int i, RequestFinishedInfo.Metrics metrics) {
            if (i != 0 && metrics != null) {
                C1956iF iFVar = this.f8582.get(i);
                if (iFVar == null) {
                    iFVar = new C1956iF();
                    this.f8582.put(i, iFVar);
                }
                iFVar.m8692(metrics);
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public EndPlayJson.C0021[] m8690() {
            EndPlayJson.C0021[] r6 = new EndPlayJson.C0021[this.f8582.size()];
            for (int i = 0; i < this.f8582.size(); i++) {
                int keyAt = this.f8582.keyAt(i);
                C1956iF valueAt = this.f8582.valueAt(i);
                r6[i] = new EndPlayJson.C0021(keyAt, valueAt.m8695(), valueAt.m8693());
            }
            return r6;
        }
    }
}
