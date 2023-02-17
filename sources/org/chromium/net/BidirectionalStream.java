package org.chromium.net;

import java.nio.ByteBuffer;
import org.chromium.net.UrlResponseInfo;
public abstract class BidirectionalStream {

    public static abstract class Callback {
        public abstract void onFailed(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, CronetException cronetException);

        public abstract void onReadCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z);

        public abstract void onResponseHeadersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo);

        public abstract void onStreamReady(BidirectionalStream bidirectionalStream);

        public abstract void onSucceeded(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo);

        public abstract void onWriteCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z);

        public void onResponseTrailersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlResponseInfo.HeaderBlock headerBlock) {
        }

        public void onCanceled(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        }
    }
}
