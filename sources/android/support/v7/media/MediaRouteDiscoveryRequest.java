package android.support.v7.media;

import android.os.Bundle;
public final class MediaRouteDiscoveryRequest {
    private final Bundle mBundle;
    private MediaRouteSelector mSelector;

    public MediaRouteDiscoveryRequest(MediaRouteSelector mediaRouteSelector, boolean z) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        this.mBundle = new Bundle();
        this.mSelector = mediaRouteSelector;
        this.mBundle.putBundle("selector", mediaRouteSelector.asBundle());
        this.mBundle.putBoolean("activeScan", z);
    }

    public MediaRouteSelector getSelector() {
        ensureSelector();
        return this.mSelector;
    }

    private void ensureSelector() {
        if (this.mSelector == null) {
            this.mSelector = MediaRouteSelector.fromBundle(this.mBundle.getBundle("selector"));
            if (this.mSelector == null) {
                this.mSelector = MediaRouteSelector.EMPTY;
            }
        }
    }

    public boolean isActiveScan() {
        return this.mBundle.getBoolean("activeScan");
    }

    public boolean isValid() {
        ensureSelector();
        return this.mSelector.isValid();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaRouteDiscoveryRequest)) {
            return false;
        }
        MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest = (MediaRouteDiscoveryRequest) obj;
        return getSelector().equals(mediaRouteDiscoveryRequest.getSelector()) && isActiveScan() == mediaRouteDiscoveryRequest.isActiveScan();
    }

    public int hashCode() {
        return getSelector().hashCode() ^ (isActiveScan() ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DiscoveryRequest{ selector=").append(getSelector());
        sb.append(", activeScan=").append(isActiveScan());
        sb.append(", isValid=").append(isValid());
        sb.append(" }");
        return sb.toString();
    }

    public Bundle asBundle() {
        return this.mBundle;
    }
}
