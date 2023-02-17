package o;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NetflixExoLogUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class kT implements DashChunkSource {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f8321;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f8322;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f8323 = -9223372036854775807L;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final Cif[] f8324;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private DashManifest f8325;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int[] f8326;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final C1943kn f8327;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f8328;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final LoaderErrorThrower f8329;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f8330;

    /* renamed from: ͺ  reason: contains not printable characters */
    private IOException f8331;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final TrackSelection f8332;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f8333;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final C1939kj f8334;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final DataSource f8335;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final long f8336;

    public static final class iF implements DashChunkSource.Factory {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final C1939kj f8337;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final C1943kn f8338;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final C1939kj f8339;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final DataSource.Factory f8340;

        public iF(DataSource.Factory factory, C1943kn knVar, C1939kj kjVar, C1939kj kjVar2) {
            this.f8340 = factory;
            this.f8338 = knVar;
            this.f8337 = kjVar;
            this.f8339 = kjVar2;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public kT createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, long j, boolean z, boolean z2) {
            return new kT(loaderErrorThrower, dashManifest, i, iArr, trackSelection, i2, this.f8340.createDataSource(), j, this.f8338, z, z2, i2 == 1 ? this.f8337 : this.f8339);
        }
    }

    public kT(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, DataSource dataSource, long j, C1943kn knVar, boolean z, boolean z2, C1939kj kjVar) {
        this.f8329 = loaderErrorThrower;
        this.f8325 = dashManifest;
        this.f8326 = iArr;
        this.f8332 = trackSelection;
        this.f8328 = i2;
        this.f8335 = dataSource;
        this.f8330 = i;
        this.f8336 = j;
        this.f8321 = knVar.f8431;
        this.f8327 = knVar;
        this.f8322 = 0;
        this.f8334 = kjVar;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i);
        ArrayList<Representation> r9 = m8330();
        this.f8324 = new Cif[trackSelection.length()];
        for (int i3 = 0; i3 < this.f8324.length; i3++) {
            this.f8324[i3] = new Cif(periodDurationUs, r9.get(trackSelection.getIndexInTrackGroup(i3)), z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(DashManifest dashManifest, int i) {
        try {
            this.f8325 = dashManifest;
            this.f8330 = i;
            long periodDurationUs = this.f8325.getPeriodDurationUs(this.f8330);
            ArrayList<Representation> r4 = m8330();
            for (int i2 = 0; i2 < this.f8324.length; i2++) {
                this.f8324[i2].m8338(periodDurationUs, r4.get(this.f8332.getIndexInTrackGroup(i2)));
            }
        } catch (BehindLiveWindowException e) {
            this.f8331 = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() {
        if (this.f8331 != null) {
            throw this.f8331;
        }
        this.f8329.maybeThrowError();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private long m8329(Format format, long j) {
        if (format.sampleMimeType.indexOf("audio") >= 0) {
            return ((long) this.f8327.f8427) * 1000;
        }
        return Math.max(0L, ((3 * (((long) this.f8327.f8426) * 1000)) / 4) - (j / 2));
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void getNextChunk(MediaChunk mediaChunk, long j, ChunkHolder chunkHolder) {
        int i;
        int i2;
        if (this.f8331 == null) {
            long j2 = mediaChunk != null ? mediaChunk.endTimeUs - j : 0;
            if (j2 > 0 && this.f8322 > 0) {
                C1283.m16854("NetflixDashChunkSource", "resetting chunk load counter due to buffer remaining");
                this.f8322 = 0;
            }
            if (j2 > 0 && this.f8323 != -9223372036854775807L) {
                this.f8323 = -9223372036854775807L;
            } else if (j2 == 0 && this.f8323 == -9223372036854775807L) {
                this.f8323 = Clock.DEFAULT.elapsedRealtime();
            }
            this.f8332.updateSelectedTrack(j2);
            Cif ifVar = this.f8324[this.f8332.getSelectedIndex()];
            if (ifVar.f8341 != null) {
                Representation representation = ifVar.f8343;
                RangedUri rangedUri = null;
                RangedUri rangedUri2 = null;
                if (ifVar.f8341.getSampleFormats() == null) {
                    rangedUri = representation.getInitializationUri();
                }
                if (ifVar.f8342 == null) {
                    rangedUri2 = representation.getIndexUri();
                }
                if (!(rangedUri == null && rangedUri2 == null)) {
                    chunkHolder.chunk = m8327(ifVar, this.f8335, this.f8332.getSelectedFormat(), this.f8332.getSelectionReason(), this.f8332.getSelectionData(), rangedUri, rangedUri2);
                    this.f8334.m8395(this.f8328, chunkHolder.chunk);
                    return;
                }
            }
            long r13 = m8328();
            int r15 = ifVar.m8335();
            if (r15 == 0) {
                chunkHolder.endOfStream = !this.f8325.dynamic || this.f8330 < this.f8325.getPeriodCount() + -1;
                return;
            }
            int r16 = ifVar.m8339();
            if (r15 == -1) {
                long j3 = (r13 - (this.f8325.availabilityStartTime * 1000)) - (this.f8325.getPeriod(this.f8330).startMs * 1000);
                if (this.f8325.timeShiftBufferDepth != -9223372036854775807L) {
                    r16 = Math.max(r16, ifVar.m8340(j3 - (this.f8325.timeShiftBufferDepth * 1000)));
                }
                i = ifVar.m8340(j3) - 1;
            } else {
                i = (r16 + r15) - 1;
            }
            if (mediaChunk == null) {
                i2 = Util.constrainValue(ifVar.m8340(j), r16, i);
            } else {
                i2 = mediaChunk.getNextChunkIndex();
                if (i2 < r16) {
                    this.f8331 = new BehindLiveWindowException();
                    return;
                }
            }
            if (i2 > i || (this.f8333 && i2 >= i)) {
                NetflixExoLogUtil.Log("(0x%x) %s ChunkSource EOS.", Integer.valueOf(hashCode()), NetflixExoLogUtil.getTrackType(this.f8328));
                chunkHolder.endOfStream = !this.f8325.dynamic || this.f8330 < this.f8325.getPeriodCount() + -1;
                return;
            }
            chunkHolder.chunk = m8326(ifVar, this.f8335, this.f8328, this.f8332.getSelectedFormat(), this.f8332.getSelectionReason(), this.f8332.getSelectionData(), i2, Math.min(this.f8321, (i - i2) + 1), m8329(this.f8332.getSelectedFormat(), j2));
            this.f8334.m8395(this.f8328, chunkHolder.chunk);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        if (chunk instanceof InitializationChunk) {
            Cif ifVar = this.f8324[this.f8332.indexOf(((InitializationChunk) chunk).trackFormat)];
            if (ifVar.f8342 == null && (seekMap = ifVar.f8341.getSeekMap()) != null) {
                ifVar.f8342 = new DashWrappingSegmentIndex((ChunkIndex) seekMap);
            }
        }
        this.f8322 = 0;
        this.f8334.m8398(this.f8328, chunk);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc) {
        this.f8322++;
        int i = this.f8327.f8428;
        long elapsedRealtime = this.f8323 == -9223372036854775807L ? 0 : Clock.DEFAULT.elapsedRealtime() - this.f8323;
        if (this.f8322 >= this.f8327.f8425 && elapsedRealtime > ((long) this.f8327.f8429)) {
            i++;
        }
        boolean z2 = z && this.f8322 % i == 0;
        C1283.m16851("NetflixDashChunkSource", "error counter = %s, time since empty buffer = %s, max retries = %s, cancelable = %s, cancel = %s", Integer.valueOf(this.f8322), Long.valueOf(elapsedRealtime), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2));
        return z2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private ArrayList<Representation> m8330() {
        List<AdaptationSet> list = this.f8325.getPeriod(this.f8330).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i : this.f8326) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private long m8328() {
        if (this.f8336 != 0) {
            return (SystemClock.elapsedRealtime() + this.f8336) * 1000;
        }
        return System.currentTimeMillis() * 1000;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Chunk m8327(Cif ifVar, DataSource dataSource, Format format, int i, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        RangedUri rangedUri3;
        String str = ifVar.f8343.baseUrl;
        if (rangedUri != null) {
            rangedUri3 = rangedUri.attemptMerge(rangedUri2, str);
            if (rangedUri3 == null) {
                rangedUri3 = rangedUri;
            }
        } else {
            rangedUri3 = rangedUri2;
        }
        return new InitializationChunk(dataSource, new DataSpec(rangedUri3.resolveUri(str), rangedUri3.start, rangedUri3.length, ifVar.f8343.getCacheKey()), format, i, obj, ifVar.f8341);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Chunk m8326(Cif ifVar, DataSource dataSource, int i, Format format, int i2, Object obj, int i3, int i4, long j) {
        RangedUri attemptMerge;
        Representation representation = ifVar.f8343;
        long r16 = ifVar.m8336(i3);
        RangedUri r18 = ifVar.m8337(i3);
        String str = representation.baseUrl;
        if (ifVar.f8341 == null) {
            return new SingleSampleMediaChunk(dataSource, new DataSpec(r18.resolveUri(str), r18.start, r18.length, representation.getCacheKey()), format, i2, obj, r16, ifVar.m8341(i3), i3, i, format);
        }
        int i5 = 1;
        if (i2 == 10001) {
            i4 = 1;
        }
        long r21 = ifVar.m8341(i3);
        int i6 = 1;
        while (r21 - r16 < j && i6 < i4 && (attemptMerge = r18.attemptMerge(ifVar.m8337(i3 + i6), str)) != null) {
            r18 = attemptMerge;
            i5++;
            r21 = ifVar.m8341(i3 + i6);
            i6++;
        }
        return new ContainerMediaChunk(dataSource, new DataSpec(r18.resolveUri(str), r18.start, r18.length, representation.getCacheKey()), format, i2, obj, r16, ifVar.m8341((i3 + i5) - 1), i3, i5, -representation.presentationTimeOffsetUs, ifVar.f8341);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o.kT$if  reason: invalid class name */
    public static final class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        final ChunkExtractorWrapper f8341;

        /* renamed from: ˋ  reason: contains not printable characters */
        public DashSegmentIndex f8342;

        /* renamed from: ˎ  reason: contains not printable characters */
        public Representation f8343;

        /* renamed from: ˏ  reason: contains not printable characters */
        private long f8344;

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f8345;

        Cif(long j, Representation representation, boolean z, boolean z2) {
            Extractor extractor;
            this.f8344 = j;
            this.f8343 = representation;
            String str = representation.format.containerMimeType;
            if (m8333(str)) {
                this.f8341 = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    extractor = new RawCcExtractor(representation.format);
                } else if (m8334(str)) {
                    extractor = new MatroskaExtractor(1);
                } else {
                    int i = z ? 4 : 0;
                    extractor = new kQ(new FragmentedMp4Extractor(z2 ? i | 8 : i));
                }
                this.f8341 = new ChunkExtractorWrapper(extractor, representation.format);
            }
            this.f8342 = representation.getIndex();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public void m8338(long j, Representation representation) {
            int segmentCount;
            DashSegmentIndex index = this.f8343.getIndex();
            DashSegmentIndex index2 = representation.getIndex();
            this.f8344 = j;
            this.f8343 = representation;
            if (index != null) {
                this.f8342 = index2;
                if (index.isExplicit() && (segmentCount = index.getSegmentCount(this.f8344)) != 0) {
                    int firstSegmentNum = (index.getFirstSegmentNum() + segmentCount) - 1;
                    long timeUs = index.getTimeUs(firstSegmentNum) + index.getDurationUs(firstSegmentNum, this.f8344);
                    int firstSegmentNum2 = index2.getFirstSegmentNum();
                    long timeUs2 = index2.getTimeUs(firstSegmentNum2);
                    if (timeUs == timeUs2) {
                        this.f8345 += (firstSegmentNum + 1) - firstSegmentNum2;
                    } else if (timeUs < timeUs2) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.f8345 += index.getSegmentNum(timeUs2, this.f8344) - firstSegmentNum2;
                    }
                }
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m8339() {
            return this.f8342.getFirstSegmentNum() + this.f8345;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public int m8335() {
            return this.f8342.getSegmentCount(this.f8344);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public long m8336(int i) {
            return this.f8342.getTimeUs(i - this.f8345);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public long m8341(int i) {
            return m8336(i) + this.f8342.getDurationUs(i - this.f8345, this.f8344);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m8340(long j) {
            return this.f8342.getSegmentNum(j, this.f8344) + this.f8345;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public RangedUri m8337(int i) {
            return this.f8342.getSegmentUrl(i - this.f8345);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static boolean m8334(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private static boolean m8333(String str) {
            return MimeTypes.isText(str) || "application/ttml+xml".equals(str);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m8331(long j) {
        Cif[] ifVarArr = this.f8324;
        for (Cif ifVar : ifVarArr) {
            if (ifVar.f8343.format.containerMimeType.equals("video/mp4") && ifVar.f8342 != null) {
                return ifVar.m8336(ifVar.m8340(j));
            }
        }
        return j;
    }
}
