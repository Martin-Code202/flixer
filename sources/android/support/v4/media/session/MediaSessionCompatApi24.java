package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi23;
/* access modifiers changed from: package-private */
public class MediaSessionCompatApi24 {

    public interface Callback extends MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String str, Bundle bundle);

        void onPrepareFromSearch(String str, Bundle bundle);

        void onPrepareFromUri(Uri uri, Bundle bundle);
    }

    MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* access modifiers changed from: package-private */
    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String str, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromMediaId(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String str, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromSearch(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromUri(uri, bundle);
        }
    }
}
