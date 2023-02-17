package org.chromium.net;
public abstract class UploadDataSink {
    public abstract void onReadSucceeded(boolean z);

    public abstract void onRewindError(Exception exc);

    public abstract void onRewindSucceeded();
}
