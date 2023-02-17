package o;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
public class kQ implements Extractor {

    /* renamed from: ˊ  reason: contains not printable characters */
    boolean f8271;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0135 f8272;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Extractor f8273;

    public kQ(Extractor extractor) {
        this.f8273 = extractor;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f8273.init(new C0136(extractorOutput));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        if (this.f8272 == null || !this.f8272.m8294(extractorInput)) {
            this.f8271 = false;
            this.f8272 = new C0135(extractorInput);
        }
        return this.f8273.read(this.f8272, positionHolder);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f8273.seek(j, j2);
    }

    /* renamed from: o.kQ$ˋ  reason: contains not printable characters */
    class C0136 implements ExtractorOutput {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final ExtractorOutput f8276;

        public C0136(ExtractorOutput extractorOutput) {
            this.f8276 = extractorOutput;
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public TrackOutput track(int i, int i2) {
            return this.f8276.track(i, i2);
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void endTracks() {
            this.f8276.endTracks();
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void seekMap(SeekMap seekMap) {
            kQ.this.f8271 = true;
            this.f8276.seekMap(seekMap);
        }
    }

    /* renamed from: o.kQ$ˊ  reason: contains not printable characters */
    public class C0135 implements ExtractorInput {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final ExtractorInput f8275;

        public C0135(ExtractorInput extractorInput) {
            this.f8275 = extractorInput;
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public int read(byte[] bArr, int i, int i2) {
            return this.f8275.read(bArr, i, i2);
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public boolean readFully(byte[] bArr, int i, int i2, boolean z) {
            if (!kQ.this.f8271) {
                return this.f8275.readFully(bArr, i, i2, z);
            }
            kQ.this.f8271 = false;
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public void readFully(byte[] bArr, int i, int i2) {
            this.f8275.readFully(bArr, i, i2);
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public int skip(int i) {
            return this.f8275.skip(i);
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public void skipFully(int i) {
            this.f8275.skipFully(i);
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public void peekFully(byte[] bArr, int i, int i2) {
            this.f8275.peekFully(bArr, i, i2);
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public void resetPeekPosition() {
            this.f8275.resetPeekPosition();
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public long getPosition() {
            return this.f8275.getPosition();
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorInput
        public long getLength() {
            return this.f8275.getLength();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m8294(ExtractorInput extractorInput) {
            return this.f8275 == extractorInput;
        }
    }
}
