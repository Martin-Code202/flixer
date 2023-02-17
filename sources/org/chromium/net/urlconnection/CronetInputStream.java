package org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.linphone.core.Privacy;
/* access modifiers changed from: package-private */
public class CronetInputStream extends InputStream {
    private ByteBuffer mBuffer;
    private IOException mException;
    private final CronetHttpURLConnection mHttpURLConnection;
    private boolean mResponseDataCompleted;

    public CronetInputStream(CronetHttpURLConnection cronetHttpURLConnection) {
        this.mHttpURLConnection = cronetHttpURLConnection;
    }

    @Override // java.io.InputStream
    public int read() {
        getMoreDataIfNeeded();
        if (hasUnreadData()) {
            return this.mBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            getMoreDataIfNeeded();
            if (!hasUnreadData()) {
                return -1;
            }
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
    }

    /* access modifiers changed from: package-private */
    public void setResponseDataCompleted(IOException iOException) {
        this.mException = iOException;
        this.mResponseDataCompleted = true;
        this.mBuffer = null;
    }

    private void getMoreDataIfNeeded() {
        if (this.mResponseDataCompleted) {
            if (this.mException != null) {
                throw this.mException;
            }
        } else if (!hasUnreadData()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(Privacy.DEFAULT);
            }
            this.mBuffer.clear();
            this.mHttpURLConnection.getMoreData(this.mBuffer);
            if (this.mException != null) {
                throw this.mException;
            } else if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean hasUnreadData() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
