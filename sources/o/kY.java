package o;

import com.google.android.exoplayer2.source.SequenceableLoader;
public final class kY implements SequenceableLoader {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final SequenceableLoader[] f8369;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1943kn f8370;

    public kY(SequenceableLoader[] sequenceableLoaderArr, C1943kn knVar) {
        this.f8369 = sequenceableLoaderArr;
        this.f8370 = knVar;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        long j = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.f8369) {
            long bufferedPositionUs = sequenceableLoader.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                j = Math.min(j, bufferedPositionUs);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        long j = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.f8369) {
            long nextLoadPositionUs = sequenceableLoader.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                j = Math.min(j, nextLoadPositionUs);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        boolean z;
        boolean z2 = false;
        do {
            z = false;
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            SequenceableLoader[] sequenceableLoaderArr = this.f8369;
            for (SequenceableLoader sequenceableLoader : sequenceableLoaderArr) {
                long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                long j2 = nextLoadPositionUs2 - j;
                long j3 = nextLoadPositionUs - j;
                if (j2 < ((long) (this.f8370.f8424 * 1000)) && (j2 < ((long) (this.f8370.f8426 * 1000)) || nextLoadPositionUs2 < ((long) (this.f8370.f8430 * 1000)) + nextLoadPositionUs)) {
                    if (nextLoadPositionUs2 != nextLoadPositionUs) {
                        C1283.m16851("ASE-Loader", "continueLoading, min vs loader buffered:%d/%d", Long.valueOf(j3 / 1000), Long.valueOf(j2 / 1000));
                    }
                    z |= sequenceableLoader.continueLoading(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
