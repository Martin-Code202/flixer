package o;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import o.kT;
final class kU implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C0139[] f8346;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final LoaderErrorThrower f8347;

    /* renamed from: ʽ  reason: contains not printable characters */
    private MediaPeriod.Callback f8348;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f8349;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private DashManifest f8350;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AdaptiveMediaSourceEventListener.EventDispatcher f8351;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private ChunkSampleStream<DashChunkSource>[] f8352 = m8348(0);

    /* renamed from: ˎ  reason: contains not printable characters */
    final int f8353;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f8354;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private SequenceableLoader f8355 = m8344();

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f8356;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final kT.iF f8357;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1943kn f8358;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private List<AdaptationSet> f8359;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Allocator f8360;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final TrackGroupArray f8361;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private kT f8362;

    public kU(int i, DashManifest dashManifest, int i2, kT.iF iFVar, int i3, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher, long j, LoaderErrorThrower loaderErrorThrower, Allocator allocator, C1943kn knVar) {
        this.f8353 = i;
        this.f8350 = dashManifest;
        this.f8356 = i2;
        this.f8357 = iFVar;
        this.f8349 = i3;
        this.f8351 = eventDispatcher;
        this.f8354 = j;
        this.f8347 = loaderErrorThrower;
        this.f8360 = allocator;
        this.f8358 = knVar;
        this.f8359 = dashManifest.getPeriod(i2).adaptationSets;
        Pair<TrackGroupArray, C0139[]> r1 = m8342(this.f8359);
        this.f8361 = (TrackGroupArray) r1.first;
        this.f8346 = (C0139[]) r1.second;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8352(DashManifest dashManifest, int i) {
        this.f8350 = dashManifest;
        this.f8356 = i;
        this.f8359 = dashManifest.getPeriod(i).adaptationSets;
        if (this.f8352 != null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f8352) {
                chunkSampleStream.getChunkSource().updateManifest(dashManifest, i);
            }
            this.f8348.onContinueLoadingRequested(this);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8354() {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f8352) {
            chunkSampleStream.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.f8348 = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        this.f8347.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.f8361;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        SampleStream sampleStream;
        HashMap hashMap = new HashMap();
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (sampleStreamArr[i] instanceof ChunkSampleStream) {
                ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStreamArr[i];
                if (trackSelectionArr[i] == null || !zArr[i]) {
                    chunkSampleStream.release();
                    sampleStreamArr[i] = null;
                } else {
                    hashMap.put(Integer.valueOf(this.f8361.indexOf(trackSelectionArr[i].getTrackGroup())), chunkSampleStream);
                }
            }
            if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                int indexOf = this.f8361.indexOf(trackSelectionArr[i].getTrackGroup());
                C0139 r6 = this.f8346[indexOf];
                if (r6.f8363) {
                    ChunkSampleStream<DashChunkSource> r7 = m8350(r6, trackSelectionArr[i], j);
                    hashMap.put(Integer.valueOf(indexOf), r7);
                    sampleStreamArr[i] = r7;
                    zArr2[i] = true;
                }
            }
        }
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            if (((sampleStreamArr[i2] instanceof ChunkSampleStream.EmbeddedSampleStream) || (sampleStreamArr[i2] instanceof EmptySampleStream)) && (trackSelectionArr[i2] == null || !zArr[i2])) {
                m8343(sampleStreamArr[i2]);
                sampleStreamArr[i2] = null;
            }
            if (trackSelectionArr[i2] != null) {
                C0139 r62 = this.f8346[this.f8361.indexOf(trackSelectionArr[i2].getTrackGroup())];
                if (!r62.f8363) {
                    ChunkSampleStream<T> chunkSampleStream2 = (ChunkSampleStream) hashMap.get(Integer.valueOf(r62.f8365));
                    SampleStream sampleStream2 = sampleStreamArr[i2];
                    if (!(chunkSampleStream2 == null ? sampleStream2 instanceof EmptySampleStream : (sampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream) && ((ChunkSampleStream.EmbeddedSampleStream) sampleStream2).parent == chunkSampleStream2)) {
                        m8343(sampleStream2);
                        if (chunkSampleStream2 == null) {
                            sampleStream = new EmptySampleStream();
                        } else {
                            sampleStream = chunkSampleStream2.selectEmbeddedTrack(j, r62.f8364);
                        }
                        sampleStreamArr[i2] = sampleStream;
                        zArr2[i2] = true;
                    }
                }
            }
        }
        this.f8352 = m8348(hashMap.size());
        hashMap.values().toArray(this.f8352);
        this.f8355 = m8344();
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f8352) {
            chunkSampleStream.discardEmbeddedTracksTo(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.f8355.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.f8355.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.f8355.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        long r9 = m8346(j) + 1;
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f8352) {
            chunkSampleStream.seekToUs(r9);
        }
        return r9;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.f8348.onContinueLoadingRequested(this);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Pair<TrackGroupArray, C0139[]> m8342(List<AdaptationSet> list) {
        int[][] r8 = m8351(list);
        int length = r8.length;
        boolean[] zArr = new boolean[length];
        boolean[] zArr2 = new boolean[length];
        int i = length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m8345(list, r8[i2])) {
                zArr[i2] = true;
                i++;
            }
            if (m8347(list, r8[i2])) {
                zArr2[i2] = true;
                i++;
            }
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i];
        C0139[] r14 = new C0139[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int[] iArr = r8[i4];
            ArrayList arrayList = new ArrayList();
            int length2 = iArr.length;
            for (int i5 = 0; i5 < length2; i5++) {
                arrayList.addAll(list.get(iArr[i5]).representations);
            }
            Format[] formatArr = new Format[arrayList.size()];
            for (int i6 = 0; i6 < formatArr.length; i6++) {
                formatArr[i6] = ((Representation) arrayList.get(i6)).format;
            }
            AdaptationSet adaptationSet = list.get(iArr[0]);
            boolean z = zArr[i4];
            boolean z2 = zArr2[i4];
            trackGroupArr[i3] = new TrackGroup(formatArr);
            i3++;
            r14[i3] = new C0139(adaptationSet.type, iArr, i3, true, z, z2);
            if (z) {
                trackGroupArr[i3] = new TrackGroup(Format.createSampleFormat(adaptationSet.id + ":emsg", "application/x-emsg", null, -1, null));
                i3++;
                r14[i3] = new C0139(4, iArr, i3, false, false, false);
            }
            if (z2) {
                trackGroupArr[i3] = new TrackGroup(Format.createTextSampleFormat(adaptationSet.id + ":cea608", "application/cea-608", 0, null));
                i3++;
                r14[i3] = new C0139(3, iArr, i3, false, false, false);
            }
        }
        return Pair.create(new TrackGroupArray(trackGroupArr), r14);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int[][] m8351(List<AdaptationSet> list) {
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(list.get(i).id, i);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (!zArr[i3]) {
                zArr[i3] = true;
                Descriptor r9 = m8349(list.get(i3).supplementalProperties);
                if (r9 == null) {
                    i2++;
                    iArr[i2] = new int[]{i3};
                } else {
                    String[] split = r9.value.split(",");
                    int[] iArr2 = new int[(split.length + 1)];
                    iArr2[0] = i3;
                    for (int i4 = 0; i4 < split.length; i4++) {
                        int i5 = sparseIntArray.get(Integer.parseInt(split[i4]));
                        zArr[i5] = true;
                        iArr2[i4 + 1] = i5;
                    }
                    i2++;
                    iArr[i2] = iArr2;
                }
            }
        }
        if (i2 < size) {
            return (int[][]) Arrays.copyOf(iArr, i2);
        }
        return iArr;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private ChunkSampleStream<DashChunkSource> m8350(C0139 r18, TrackSelection trackSelection, long j) {
        int i = 0;
        int[] iArr = new int[2];
        boolean z = r18.f8366;
        if (z) {
            i = 0 + 1;
            iArr[0] = 4;
        }
        boolean z2 = r18.f8368;
        if (z2) {
            i++;
            iArr[i] = 3;
        }
        int length = iArr.length;
        if (i < 2) {
            iArr = Arrays.copyOf(iArr, i);
        }
        kT r15 = this.f8357.createDashChunkSource(this.f8347, this.f8350, this.f8356, r18.f8367, trackSelection, r18.f8364, this.f8354, z, z2);
        ChunkSampleStream<DashChunkSource> chunkSampleStream = new ChunkSampleStream<>(r18.f8364, iArr, r15, this, this.f8360, j, this.f8349, this.f8351);
        if (this.f8362 == null && r18.f8364 == 2) {
            this.f8362 = r15;
        }
        return chunkSampleStream;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Descriptor m8349(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m8345(List<AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            List<Representation> list2 = list.get(i).representations;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).inbandEventStreams.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m8347(List<AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            List<Descriptor> list2 = list.get(i).accessibilityDescriptors;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if ("urn:scte:dash:cc:cea-608:2015".equals(list2.get(i2).schemeIdUri)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private SequenceableLoader m8344() {
        return new kY(this.f8352, this.f8358);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static ChunkSampleStream<DashChunkSource>[] m8348(int i) {
        return new ChunkSampleStream[i];
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m8343(SampleStream sampleStream) {
        if (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
            ((ChunkSampleStream.EmbeddedSampleStream) sampleStream).release();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kU$ˋ  reason: contains not printable characters */
    public static final class C0139 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final boolean f8363;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final int f8364;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final int f8365;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean f8366;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final int[] f8367;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public final boolean f8368;

        public C0139(int i, int[] iArr, int i2, boolean z, boolean z2, boolean z3) {
            this.f8364 = i;
            this.f8367 = iArr;
            this.f8365 = i2;
            this.f8363 = z;
            this.f8366 = z2;
            this.f8368 = z3;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private long m8346(long j) {
        return this.f8362.m8331(j) + 1;
    }
}
