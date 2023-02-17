package o;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import o.kT;
public final class kR implements MediaSource {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Object f8278;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private LoaderErrorThrower f8279;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final SparseArray<kU> f8280;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private Handler f8281;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AdaptiveMediaSourceEventListener.EventDispatcher f8282;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private long f8283;

    /* renamed from: ʾ  reason: contains not printable characters */
    private int f8284;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final C1943kn f8285;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f8286;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final Runnable f8287;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final kT.iF f8288;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private DataSource f8289;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean f8290;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final DataSource.Factory f8291;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private MediaSource.Listener f8292;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Runnable f8293;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f8294;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Loader f8295;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private Uri f8296;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private DashManifest f8297;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final ParsingLoadable.Parser<? extends DashManifest> f8298;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private long f8299;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C0138 f8300;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private long f8301;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    public kR(DashManifest dashManifest, kT.iF iFVar, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, C1943kn knVar) {
        this(dashManifest, iFVar, knVar.f8428 - 1, handler, adaptiveMediaSourceEventListener, knVar);
    }

    public kR(DashManifest dashManifest, kT.iF iFVar, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, C1943kn knVar) {
        this(dashManifest, null, null, null, iFVar, i, -1, handler, adaptiveMediaSourceEventListener, knVar);
    }

    private kR(DashManifest dashManifest, Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, kT.iF iFVar, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, C1943kn knVar) {
        this.f8297 = dashManifest;
        this.f8296 = uri;
        this.f8291 = factory;
        this.f8298 = parser;
        this.f8288 = iFVar;
        this.f8286 = i;
        this.f8294 = j;
        this.f8290 = dashManifest != null;
        this.f8282 = new AdaptiveMediaSourceEventListener.EventDispatcher(handler, adaptiveMediaSourceEventListener);
        this.f8285 = knVar;
        this.f8278 = new Object();
        this.f8280 = new SparseArray<>();
        if (dashManifest instanceof kS) {
            kS kSVar = (kS) dashManifest;
        }
        if (this.f8290) {
            Assertions.checkState(!dashManifest.dynamic);
            this.f8300 = null;
            this.f8287 = null;
            this.f8293 = null;
            return;
        }
        this.f8300 = new C0138();
        this.f8287 = new Runnable() { // from class: o.kR.1
            @Override // java.lang.Runnable
            public void run() {
                kR.this.m8299();
            }
        };
        this.f8293 = new Runnable() { // from class: o.kR.3
            @Override // java.lang.Runnable
            public void run() {
                kR.this.m8297(false);
            }
        };
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        this.f8292 = listener;
        if (this.f8290) {
            this.f8279 = new LoaderErrorThrower.Dummy();
            m8297(false);
            return;
        }
        this.f8289 = this.f8291.createDataSource();
        this.f8295 = new Loader("Loader:DashMediaSource");
        this.f8279 = this.f8295;
        this.f8281 = new Handler();
        m8299();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        this.f8279.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        int i = mediaPeriodId.periodIndex;
        kU kUVar = new kU(this.f8284 + i, this.f8297, i, this.f8288, this.f8286, this.f8282.copyWithMediaTimeOffsetMs(this.f8297.getPeriod(i).startMs), this.f8283, this.f8279, allocator, this.f8285);
        this.f8280.put(kUVar.f8353, kUVar);
        return kUVar;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        kU kUVar = (kU) mediaPeriod;
        kUVar.m8354();
        this.f8280.remove(kUVar.f8353);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.f8289 = null;
        this.f8279 = null;
        if (this.f8295 != null) {
            this.f8295.release();
            this.f8295 = null;
        }
        this.f8301 = 0;
        this.f8299 = 0;
        this.f8297 = null;
        if (this.f8281 != null) {
            this.f8281.removeCallbacksAndMessages(null);
            this.f8281 = null;
        }
        this.f8283 = 0;
        this.f8280.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8311(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
        this.f8282.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        DashManifest result = parsingLoadable.getResult();
        int periodCount = this.f8297 == null ? 0 : this.f8297.getPeriodCount();
        int i = 0;
        long j3 = result.getPeriod(0).startMs;
        while (i < periodCount && this.f8297.getPeriod(i).startMs < j3) {
            i++;
        }
        if (periodCount - i > result.getPeriodCount()) {
            Log.w("NetflixMediaSource", "Out of sync manifest");
            m8303();
            return;
        }
        this.f8297 = result;
        this.f8301 = j - j2;
        this.f8299 = j;
        if (this.f8297.location != null) {
            synchronized (this.f8278) {
                if (parsingLoadable.dataSpec.uri == this.f8296) {
                    this.f8296 = this.f8297.location;
                }
            }
        }
        if (periodCount != 0) {
            this.f8284 += i;
            m8297(true);
        } else if (this.f8297.utcTiming != null) {
            m8301(this.f8297.utcTiming);
        } else {
            m8297(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public int m8309(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.f8282.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, z);
        return z ? 3 : 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8308(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
        this.f8282.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        m8300(parsingLoadable.getResult().longValue() - j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public int m8310(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
        this.f8282.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, true);
        m8305(iOException);
        return 2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8307(ParsingLoadable<?> parsingLoadable, long j, long j2) {
        this.f8282.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8299() {
        Uri uri;
        synchronized (this.f8278) {
            uri = this.f8296;
        }
        m8296(new ParsingLoadable(this.f8289, uri, 4, this.f8298), this.f8300, this.f8286);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8301(UtcTimingElement utcTimingElement) {
        String str = utcTimingElement.schemeIdUri;
        if (Util.areEqual(str, "urn:mpeg:dash:utc:direct:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
            m8295(utcTimingElement);
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            m8304(utcTimingElement, new C1928If());
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            m8304(utcTimingElement, new IF());
        } else {
            m8305(new IOException("Unsupported UTC timing scheme"));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8295(UtcTimingElement utcTimingElement) {
        try {
            m8300(Util.parseXsDateTime(utcTimingElement.value) - this.f8299);
        } catch (ParserException e) {
            m8305(e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8304(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        m8296(new ParsingLoadable(this.f8289, Uri.parse(utcTimingElement.value), 5, parser), new C1929iF(), 1);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8300(long j) {
        this.f8283 = j;
        m8297(true);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8305(IOException iOException) {
        Log.e("NetflixMediaSource", "Failed to resolve UtcTiming element.", iOException);
        m8297(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8297(boolean z) {
        for (int i = 0; i < this.f8280.size(); i++) {
            int keyAt = this.f8280.keyAt(i);
            if (keyAt >= this.f8284) {
                this.f8280.valueAt(i).m8352(this.f8297, keyAt - this.f8284);
            }
        }
        boolean z2 = false;
        int periodCount = this.f8297.getPeriodCount() - 1;
        Cif r15 = Cif.m8317(this.f8297.getPeriod(0), this.f8297.getPeriodDurationUs(0));
        Cif r16 = Cif.m8317(this.f8297.getPeriod(periodCount), this.f8297.getPeriodDurationUs(periodCount));
        long j = r15.f8305;
        long j2 = r16.f8307;
        if (this.f8297.dynamic && !r16.f8306) {
            j2 = Math.min((m8302() - C.msToUs(this.f8297.availabilityStartTime)) - C.msToUs(this.f8297.getPeriod(periodCount).startMs), j2);
            if (this.f8297.timeShiftBufferDepth != -9223372036854775807L) {
                long msToUs = j2 - C.msToUs(this.f8297.timeShiftBufferDepth);
                int i2 = periodCount;
                while (msToUs < 0 && i2 > 0) {
                    i2--;
                    msToUs += this.f8297.getPeriodDurationUs(i2);
                }
                if (i2 == 0) {
                    j = Math.max(j, msToUs);
                } else {
                    j = this.f8297.getPeriodDurationUs(0);
                }
            }
            z2 = true;
        }
        long j3 = j2 - j;
        for (int i3 = 0; i3 < this.f8297.getPeriodCount() - 1; i3++) {
            j3 += this.f8297.getPeriodDurationUs(i3);
        }
        long j4 = 0;
        if (this.f8297.dynamic) {
            long j5 = this.f8294;
            if (j5 == -1) {
                j5 = this.f8297.suggestedPresentationDelay != -9223372036854775807L ? this.f8297.suggestedPresentationDelay : 30000;
            }
            j4 = j3 - C.msToUs(j5);
            if (j4 < 5000000) {
                j4 = Math.min(5000000L, j3 / 2);
            }
        }
        this.f8292.onSourceInfoRefreshed(new C0137(this.f8297.availabilityStartTime, this.f8297.availabilityStartTime + this.f8297.getPeriod(0).startMs + C.usToMs(j), this.f8284, j, j3, j4, this.f8297), this.f8297);
        if (!this.f8290) {
            this.f8281.removeCallbacks(this.f8293);
            if (z2) {
                this.f8281.postDelayed(this.f8293, 5000);
            }
            if (z) {
                m8303();
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8303() {
        if (this.f8297.dynamic) {
            long j = this.f8297.minUpdatePeriod;
            if (j == 0) {
                j = 5000;
            }
            this.f8281.postDelayed(this.f8287, Math.max(0L, (this.f8301 + j) - SystemClock.elapsedRealtime()));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private <T> void m8296(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i) {
        this.f8282.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.f8295.startLoading(parsingLoadable, callback, i));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private long m8302() {
        if (this.f8283 != 0) {
            return C.msToUs(SystemClock.elapsedRealtime() + this.f8283);
        }
        return C.msToUs(System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kR$if  reason: invalid class name */
    public static final class Cif {

        /* renamed from: ˎ  reason: contains not printable characters */
        public final long f8305;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean f8306;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final long f8307;

        /* renamed from: ˎ  reason: contains not printable characters */
        public static Cif m8317(Period period, long j) {
            int size = period.adaptationSets.size();
            long j2 = 0;
            long j3 = Long.MAX_VALUE;
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < size; i++) {
                DashSegmentIndex index = period.adaptationSets.get(i).representations.get(0).getIndex();
                if (index == null) {
                    return new Cif(true, 0, j);
                }
                z |= index.isExplicit();
                int segmentCount = index.getSegmentCount(j);
                if (segmentCount == 0) {
                    z2 = true;
                    j2 = 0;
                    j3 = 0;
                } else if (!z2) {
                    int firstSegmentNum = index.getFirstSegmentNum();
                    j2 = Math.max(j2, index.getTimeUs(firstSegmentNum));
                    if (segmentCount != -1) {
                        int i2 = (firstSegmentNum + segmentCount) - 1;
                        j3 = Math.min(j3, index.getTimeUs(i2) + index.getDurationUs(i2, j));
                    }
                }
            }
            return new Cif(z, j2, j3);
        }

        private Cif(boolean z, long j, long j2) {
            this.f8306 = z;
            this.f8305 = j;
            this.f8307 = j2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kR$ˊ  reason: contains not printable characters */
    public static final class C0137 extends Timeline {

        /* renamed from: ʽ  reason: contains not printable characters */
        private final long f8308;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final long f8309;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final long f8310;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final int f8311;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final long f8312;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final long f8313;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final DashManifest f8314;

        public C0137(long j, long j2, int i, long j3, long j4, long j5, DashManifest dashManifest) {
            this.f8309 = j;
            this.f8312 = j2;
            this.f8311 = i;
            this.f8313 = j3;
            this.f8310 = j4;
            this.f8308 = j5;
            this.f8314 = dashManifest;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.f8314.getPeriodCount();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Assertions.checkIndex(i, 0, this.f8314.getPeriodCount());
            return period.set(z ? this.f8314.getPeriod(i).id : null, z ? Integer.valueOf(this.f8311 + Assertions.checkIndex(i, 0, this.f8314.getPeriodCount())) : null, 0, this.f8314.getPeriodDurationUs(i), C.msToUs(this.f8314.getPeriod(i).startMs - this.f8314.getPeriod(0).startMs) - this.f8313);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
            Assertions.checkIndex(i, 0, 1);
            return window.set(null, this.f8309, this.f8312, true, this.f8314.dynamic, m8318(j), this.f8310, 0, this.f8314.getPeriodCount() - 1, this.f8313);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.f8311 && intValue < this.f8311 + getPeriodCount()) {
                return intValue - this.f8311;
            }
            return -1;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private long m8318(long j) {
            DashSegmentIndex index;
            long j2 = this.f8308;
            if (!this.f8314.dynamic) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.f8310) {
                    return -9223372036854775807L;
                }
            }
            int i = 0;
            long j3 = this.f8313 + j2;
            long periodDurationUs = this.f8314.getPeriodDurationUs(0);
            while (i < this.f8314.getPeriodCount() - 1 && j3 >= periodDurationUs) {
                j3 -= periodDurationUs;
                i++;
                periodDurationUs = this.f8314.getPeriodDurationUs(i);
            }
            Period period = this.f8314.getPeriod(i);
            int adaptationSetIndex = period.getAdaptationSetIndex(2);
            if (adaptationSetIndex == -1 || (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) == null || index.getSegmentCount(periodDurationUs) == 0) {
                return j2;
            }
            return (index.getTimeUs(index.getSegmentNum(j3, periodDurationUs)) + j2) - j3;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kR$ˋ  reason: contains not printable characters */
    public final class C0138 implements Loader.Callback<ParsingLoadable<DashManifest>> {
        private C0138() {
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void onLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
            kR.this.m8311(parsingLoadable, j, j2);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void onLoadCanceled(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, boolean z) {
            kR.this.m8307(parsingLoadable, j, j2);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public int onLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException) {
            return kR.this.m8309(parsingLoadable, j, j2, iOException);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kR$iF  reason: case insensitive filesystem */
    public final class C1929iF implements Loader.Callback<ParsingLoadable<Long>> {
        private C1929iF() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void onLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
            kR.this.m8308(parsingLoadable, j, j2);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void onLoadCanceled(ParsingLoadable<Long> parsingLoadable, long j, long j2, boolean z) {
            kR.this.m8307(parsingLoadable, j, j2);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public int onLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
            return kR.this.m8310(parsingLoadable, j, j2, iOException);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class IF implements ParsingLoadable.Parser<Long> {
        private IF() {
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public Long parse(Uri uri, InputStream inputStream) {
            return Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kR$If  reason: case insensitive filesystem */
    public static final class C1928If implements ParsingLoadable.Parser<Long> {
        private C1928If() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public Long parse(Uri uri, InputStream inputStream) {
            String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
            } catch (ParseException e) {
                throw new ParserException(e);
            }
        }
    }
}
