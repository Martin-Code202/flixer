package o;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.netflix.mediaclient.net.NetworkRequestLogger;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.cronetdatasource.CronetDataSource;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import o.kP;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.RequestFinishedInfo;
/* renamed from: o.lu  reason: case insensitive filesystem */
public class C1962lu {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Executor f8655 = new Executor() { // from class: o.lu.3
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    private static ExperimentalCronetEngine f8656;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f8657;

    public C1962lu(Context context) {
        this.f8657 = context;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static synchronized void m8758(Context context) {
        synchronized (C1962lu.class) {
            if (f8656 == null) {
                f8656 = new ExperimentalCronetEngine.Builder(context).build();
                f8656.addRequestFinishedListener(new If());
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public DataSource m8760(AbstractC1966ly lyVar, C1940kk kkVar, AbstractC1959lq lqVar, C1942km kmVar) {
        CacheDataSource.EventListener eventListener;
        CacheDataSource.EventListener eventListener2;
        m8758(this.f8657);
        lS r11 = kkVar == null ? null : kkVar.m8412();
        CronetDataSource cronetDataSource = new CronetDataSource(f8656, m8757(), null, lyVar, kmVar.f8422, kmVar.f8423, false, r11, lqVar, kmVar.f8421);
        kI r14 = kK.m8229(this.f8657);
        FileDataSource fileDataSource = new FileDataSource();
        kG kGVar = new kG(r14, 65536);
        if (r11 == null) {
            eventListener = null;
        } else {
            eventListener = r11.m8673("header");
        }
        CacheDataSource cacheDataSource = new CacheDataSource(r14, cronetDataSource, fileDataSource, kGVar, 3, eventListener);
        kI r16 = kJ.m8217(this.f8657);
        FileDataSource fileDataSource2 = new FileDataSource();
        kG kGVar2 = new kG(r16, 131072);
        if (r11 == null) {
            eventListener2 = null;
        } else {
            eventListener2 = r11.m8673("fragment");
        }
        return new CacheDataSource(r16, cacheDataSource, fileDataSource2, kGVar2, 2, eventListener2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public CronetDataSource m8759(int i) {
        m8758(this.f8657);
        return new CronetDataSource(f8656, m8757(), null, null, 12000, 12000, false, null, null, i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Executor m8757() {
        if (C0915.m15716()) {
            return f8655;
        }
        return AbstractC0661.f14007;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.lu$If */
    public static final class If extends RequestFinishedInfo.Listener {

        /* renamed from: ˏ  reason: contains not printable characters */
        private static final Executor f8658 = Executors.newFixedThreadPool(1);

        public If() {
            super(f8658);
        }

        @Override // org.chromium.net.RequestFinishedInfo.Listener
        public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
            for (Object obj : requestFinishedInfo.getAnnotations()) {
                if (obj instanceof lS) {
                    ((lS) obj).m8678(requestFinishedInfo);
                }
                if (obj instanceof DataSpec) {
                    RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
                    kP.C0134 r7 = kP.m8293(((DataSpec) obj).key);
                    if (!(r7 == null || metrics == null)) {
                        NetworkRequestLogger.INSTANCE.mo474(r7.f8268 == 1 ? NetworkRequestType.CONTENT_AUDIO : NetworkRequestType.CONTENT_VIDEO, requestFinishedInfo.getUrl(), metrics.getSentByteCount(), metrics.getReceivedByteCount());
                    }
                }
            }
        }
    }
}
