package o;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.PriorityDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.cronetdatasource.CronetDataSource;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
public class kL {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final CacheDataSource f8204;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Handler.Callback f8205 = new Handler.Callback() { // from class: o.kL.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 4096:
                    kL.this.m8242();
                    return true;
                default:
                    return true;
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final kI f8206;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f8207;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final CronetDataSource f8208;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final DataSource f8209;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final PriorityTaskManager f8210;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Queue<Cif> f8211 = new LinkedList();

    public interface If<T> {
        /* renamed from: ˎ */
        void mo8222(T t);

        /* renamed from: ॱ */
        void mo8223();
    }

    public kL(kI kIVar, C1962lu luVar, PriorityTaskManager priorityTaskManager) {
        this.f8207 = new Handler(kIVar.m8210(), this.f8205);
        this.f8206 = kIVar;
        this.f8210 = priorityTaskManager;
        this.f8208 = luVar.m8759(8192);
        if (priorityTaskManager != null) {
            this.f8209 = new PriorityDataSource(this.f8208, priorityTaskManager, -1000);
        } else {
            this.f8209 = this.f8208;
        }
        this.f8204 = new CacheDataSource(this.f8206, this.f8209, 3);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8245(DataSpec dataSpec, If<Void> r8) {
        synchronized (this.f8211) {
            this.f8211.add(new Cif(dataSpec, null, false, r8));
        }
        this.f8207.sendEmptyMessage(4096);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8246(DataSpec dataSpec, lS lSVar, If<byte[]> r8) {
        synchronized (this.f8211) {
            this.f8211.add(new Cif(dataSpec, lSVar, true, r8));
        }
        this.f8207.sendEmptyMessage(4096);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8242() {
        Cif poll;
        synchronized (this.f8211) {
            poll = this.f8211.poll();
        }
        if (poll != null) {
            if (this.f8210 != null) {
                this.f8210.add(-1000);
            }
            byte[] bArr = null;
            try {
                if (!poll.f8214) {
                    m8241(poll.f8213);
                } else {
                    bArr = m8244(poll.f8213, poll.f8215);
                }
                if (poll.f8216 != null) {
                    poll.f8216.mo8222(bArr);
                }
                C1283.m16848("nf_cache", "prefetching content -> %s cache: %s (%s KB) finished", this.f8206.m8209(), poll.f8213.key, Long.valueOf(poll.f8213.length / 1000));
                if (this.f8210 != null) {
                    this.f8210.remove(-1000);
                }
            } catch (IOException e) {
                C1283.m16868("nf_cache", e, "encountered exception caching content %s", poll.f8213.key);
                if (poll.f8216 != null) {
                    poll.f8216.mo8223();
                }
                if (this.f8210 != null) {
                    this.f8210.remove(-1000);
                }
            } catch (InterruptedException e2) {
                C1283.m16844("nf_cache", "encountered interruption caching content %s: %s", poll.f8213.key, e2.getMessage());
                if (poll.f8216 != null) {
                    poll.f8216.mo8223();
                }
                if (this.f8210 != null) {
                    this.f8210.remove(-1000);
                }
            } catch (Throwable th) {
                if (this.f8210 != null) {
                    this.f8210.remove(-1000);
                }
                throw th;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private long m8241(DataSpec dataSpec) {
        byte[] bArr = new byte[8192];
        long j = dataSpec.absoluteStreamPosition;
        long j2 = dataSpec.length;
        long j3 = 0;
        while (true) {
            if (this.f8210 != null) {
                this.f8210.proceed(-1000);
            }
            try {
                break;
            } catch (PriorityTaskManager.PriorityTooLowException e) {
                C1283.m16848("nf_cache", "prefetch interrupted after reading %s bytes. rescheduling %d remaining", 0L, Long.valueOf(j2 - 0));
                dataSpec = new DataSpec(dataSpec.uri, dataSpec.postBody, j + 0, j + 0, j2 - 0, dataSpec.key, dataSpec.flags);
            } finally {
                Util.closeQuietly(this.f8204);
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        this.f8204.open(dataSpec);
        while (j3 != j2) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            CacheDataSource cacheDataSource = this.f8204;
            int length = bArr.length;
            int read = cacheDataSource.read(bArr, 0, (int) Math.min(8192L, j2 - j3));
            if (read == -1) {
                return j3;
            }
            j3 = ((long) read) + j3;
        }
        Util.closeQuietly(this.f8204);
        return j3;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private byte[] m8244(DataSpec dataSpec, lS lSVar) {
        byte[] bArr = new byte[((int) dataSpec.length)];
        try {
            this.f8208.m1035(lSVar);
            this.f8204.open(dataSpec);
            int i = 0;
            do {
                int read = this.f8204.read(bArr, i, bArr.length - i);
                i += read;
                if (read <= 0) {
                    break;
                }
            } while (i < bArr.length);
            this.f8208.m1035((lS) null);
            try {
                this.f8204.close();
            } catch (IOException | NullPointerException e) {
                C1283.m16856("nf_cache", e, "encountered error when closing cache data source during prefetch", new Object[0]);
            }
            return bArr;
        } catch (Throwable th) {
            this.f8208.m1035((lS) null);
            try {
                this.f8204.close();
            } catch (IOException | NullPointerException e2) {
                C1283.m16856("nf_cache", e2, "encountered error when closing cache data source during prefetch", new Object[0]);
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kL$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final DataSpec f8213;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final boolean f8214;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final lS f8215;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final If f8216;

        public Cif(DataSpec dataSpec, lS lSVar, boolean z, If r4) {
            this.f8213 = dataSpec;
            this.f8215 = lSVar;
            this.f8216 = r4;
            this.f8214 = z;
        }
    }
}
