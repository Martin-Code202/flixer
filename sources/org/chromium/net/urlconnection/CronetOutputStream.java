package org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.OutputStream;
import org.chromium.net.UploadDataProvider;
/* access modifiers changed from: package-private */
public abstract class CronetOutputStream extends OutputStream {
    private boolean mClosed;
    private IOException mException;
    private boolean mRequestCompleted;

    /* access modifiers changed from: package-private */
    public abstract void checkReceivedEnoughContent();

    /* access modifiers changed from: package-private */
    public abstract UploadDataProvider getUploadDataProvider();

    /* access modifiers changed from: package-private */
    public abstract void setConnected();

    CronetOutputStream() {
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
    }

    /* access modifiers changed from: package-private */
    public void setRequestCompleted(IOException iOException) {
        this.mException = iOException;
        this.mRequestCompleted = true;
    }

    /* access modifiers changed from: protected */
    public void checkNotClosed() {
        if (this.mRequestCompleted) {
            checkNoException();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* access modifiers changed from: protected */
    public void checkNoException() {
        if (this.mException != null) {
            throw this.mException;
        }
    }
}
