package o;

import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
/* renamed from: o.lv  reason: case insensitive filesystem */
public final class C1963lv extends UploadDataProvider {

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f8659;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final byte[] f8660;

    public C1963lv(byte[] bArr) {
        this.f8660 = bArr;
    }

    @Override // org.chromium.net.UploadDataProvider
    public long getLength() {
        return (long) this.f8660.length;
    }

    @Override // org.chromium.net.UploadDataProvider
    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        int min = Math.min(byteBuffer.remaining(), this.f8660.length - this.f8659);
        byteBuffer.put(this.f8660, this.f8659, min);
        this.f8659 += min;
        uploadDataSink.onReadSucceeded(false);
    }

    @Override // org.chromium.net.UploadDataProvider
    public void rewind(UploadDataSink uploadDataSink) {
        this.f8659 = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
