package android.support.v7.media;

import android.os.Messenger;
abstract class MediaRouteProviderProtocol {
    MediaRouteProviderProtocol() {
    }

    public static boolean isValidRemoteMessenger(Messenger messenger) {
        if (messenger != null) {
            try {
                if (messenger.getBinder() != null) {
                    return true;
                }
            } catch (NullPointerException e) {
                return false;
            }
        }
        return false;
    }
}
