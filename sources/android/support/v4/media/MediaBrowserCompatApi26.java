package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi21;
import java.util.List;
class MediaBrowserCompatApi26 {

    interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback {
        void onChildrenLoaded(String str, List<?> list, Bundle bundle);

        void onError(String str, Bundle bundle);
    }

    MediaBrowserCompatApi26() {
    }

    static Object createSubscriptionCallback(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        SubscriptionCallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list, Bundle bundle) {
            ((SubscriptionCallback) this.mSubscriptionCallback).onChildrenLoaded(str, list, bundle);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            ((SubscriptionCallback) this.mSubscriptionCallback).onError(str, bundle);
        }
    }
}
