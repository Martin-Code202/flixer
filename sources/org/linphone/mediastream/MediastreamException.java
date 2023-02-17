package org.linphone.mediastream;
public class MediastreamException extends Exception {
    public MediastreamException() {
    }

    public MediastreamException(String str) {
        super(str);
    }

    public MediastreamException(Throwable th) {
        super(th);
    }

    public MediastreamException(String str, Throwable th) {
        super(str, th);
    }
}
