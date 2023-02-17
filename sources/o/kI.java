package o;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import o.kP;
public class kI implements Cache {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Map<String, kI> f8164 = new HashMap();

    /* renamed from: ʻ  reason: contains not printable characters */
    private final HandlerThread f8165;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Map<String, Integer> f8166 = new HashMap();

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Handler f8167;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final ConditionVariable f8168 = new ConditionVariable();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f8169;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f8170;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Cache f8171;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static synchronized kI m8208(Context context, String str, int i) {
        kI kIVar;
        synchronized (kI.class) {
            if (!f8164.containsKey(str)) {
                f8164.put(str, new kI(context, str, i));
            }
            kIVar = f8164.get(str);
        }
        return kIVar;
    }

    private kI(Context context, String str, int i) {
        this.f8169 = str;
        this.f8170 = i;
        this.f8165 = new HandlerThread("cache" + str, 0);
        this.f8165.start();
        this.f8167 = new Handler(this.f8165.getLooper());
        final File file = new File(context.getCacheDir(), str);
        final LeastRecentlyUsedCacheEvictor leastRecentlyUsedCacheEvictor = new LeastRecentlyUsedCacheEvictor((long) i);
        this.f8167.post(new Runnable() { // from class: o.kI.5
            @Override // java.lang.Runnable
            public void run() {
                kI.this.f8171 = new SimpleCache(file, new If(leastRecentlyUsedCacheEvictor));
                kI.this.f8168.open();
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public NavigableSet<CacheSpan> getCachedSpans(String str) {
        this.f8168.block();
        return this.f8171.getCachedSpans(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public Set<String> getKeys() {
        this.f8168.block();
        return this.f8171.getKeys();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public long getCacheSpace() {
        this.f8168.block();
        return this.f8171.getCacheSpace();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public CacheSpan startReadWrite(String str, long j) {
        this.f8168.block();
        return this.f8171.startReadWrite(str, j);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public CacheSpan startReadWriteNonBlocking(String str, long j) {
        this.f8168.block();
        return this.f8171.startReadWriteNonBlocking(str, j);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public File startFile(String str, long j, long j2) {
        this.f8168.block();
        return this.f8171.startFile(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void commitFile(File file) {
        this.f8168.block();
        this.f8171.commitFile(file);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void releaseHoleSpan(CacheSpan cacheSpan) {
        this.f8168.block();
        this.f8171.releaseHoleSpan(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void removeSpan(CacheSpan cacheSpan) {
        this.f8168.block();
        this.f8171.removeSpan(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void setContentLength(String str, long j) {
        this.f8168.block();
        this.f8171.setContentLength(str, j);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public long getContentLength(String str) {
        this.f8168.block();
        return this.f8171.getContentLength(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m8209() {
        return this.f8169;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public List<String> m8213(String str) {
        this.f8168.block();
        ArrayList arrayList = new ArrayList();
        for (String str2 : this.f8171.getKeys()) {
            if (str2.endsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Looper m8210() {
        return this.f8165.getLooper();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m8211() {
        return this.f8170;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m8212(String str) {
        int intValue;
        synchronized (this.f8166) {
            Integer num = this.f8166.get(str);
            intValue = num == null ? 0 : num.intValue();
        }
        return intValue;
    }

    class If implements CacheEvictor {

        /* renamed from: ॱ  reason: contains not printable characters */
        private CacheEvictor f8176;

        public If(CacheEvictor cacheEvictor) {
            this.f8176 = cacheEvictor;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
        public void onCacheInitialized() {
            this.f8176.onCacheInitialized();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
        public void onStartFile(Cache cache, String str, long j, long j2) {
            this.f8176.onStartFile(cache, str, j, j2);
            m8214(str);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
        public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
            this.f8176.onSpanAdded(cache, cacheSpan);
            m8214(cacheSpan.key);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
        public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
            this.f8176.onSpanRemoved(cache, cacheSpan);
            m8214(cacheSpan.key);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
        public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
            this.f8176.onSpanTouched(cache, cacheSpan, cacheSpan2);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m8214(String str) {
            kP.C0134 r2 = kP.m8293(str);
            if (r2 != null) {
                synchronized (kI.this.f8166) {
                    Integer num = (Integer) kI.this.f8166.get(r2.f8269);
                    if (num == null) {
                        num = 0;
                    }
                    kI.this.f8166.put(r2.f8269, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }
}
