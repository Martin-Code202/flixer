package android.support.v7.media;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public final class MediaRouteProviderDescriptor {
    private final Bundle mBundle;
    private List<MediaRouteDescriptor> mRoutes;

    private MediaRouteProviderDescriptor(Bundle bundle, List<MediaRouteDescriptor> list) {
        this.mBundle = bundle;
        this.mRoutes = list;
    }

    public List<MediaRouteDescriptor> getRoutes() {
        ensureRoutes();
        return this.mRoutes;
    }

    private void ensureRoutes() {
        if (this.mRoutes == null) {
            ArrayList parcelableArrayList = this.mBundle.getParcelableArrayList("routes");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                this.mRoutes = Collections.emptyList();
                return;
            }
            int size = parcelableArrayList.size();
            this.mRoutes = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                this.mRoutes.add(MediaRouteDescriptor.fromBundle((Bundle) parcelableArrayList.get(i)));
            }
        }
    }

    public boolean isValid() {
        ensureRoutes();
        int size = this.mRoutes.size();
        for (int i = 0; i < size; i++) {
            MediaRouteDescriptor mediaRouteDescriptor = this.mRoutes.get(i);
            if (mediaRouteDescriptor == null || !mediaRouteDescriptor.isValid()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaRouteProviderDescriptor{ ");
        sb.append("routes=").append(Arrays.toString(getRoutes().toArray()));
        sb.append(", isValid=").append(isValid());
        sb.append(" }");
        return sb.toString();
    }

    public static MediaRouteProviderDescriptor fromBundle(Bundle bundle) {
        if (bundle != null) {
            return new MediaRouteProviderDescriptor(bundle, null);
        }
        return null;
    }

    public static final class Builder {
        private final Bundle mBundle = new Bundle();
        private ArrayList<MediaRouteDescriptor> mRoutes;

        public Builder addRoute(MediaRouteDescriptor mediaRouteDescriptor) {
            if (mediaRouteDescriptor == null) {
                throw new IllegalArgumentException("route must not be null");
            }
            if (this.mRoutes == null) {
                this.mRoutes = new ArrayList<>();
            } else if (this.mRoutes.contains(mediaRouteDescriptor)) {
                throw new IllegalArgumentException("route descriptor already added");
            }
            this.mRoutes.add(mediaRouteDescriptor);
            return this;
        }

        public MediaRouteProviderDescriptor build() {
            if (this.mRoutes != null) {
                int size = this.mRoutes.size();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(this.mRoutes.get(i).asBundle());
                }
                this.mBundle.putParcelableArrayList("routes", arrayList);
            }
            return new MediaRouteProviderDescriptor(this.mBundle, this.mRoutes);
        }
    }
}
