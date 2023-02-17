package o;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
public class kG implements DataSink {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f8157;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f8158;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final CacheDataSink f8159;

    public kG(Cache cache, int i) {
        this.f8159 = new CacheDataSink(cache, 2097152);
        this.f8157 = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec) {
        this.f8158 = dataSpec.isFlagSet(this.f8157);
        if (this.f8158) {
            this.f8159.open(dataSpec);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) {
        if (this.f8158) {
            this.f8159.write(bArr, i, i2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() {
        if (this.f8158) {
            this.f8159.close();
        }
    }
}
