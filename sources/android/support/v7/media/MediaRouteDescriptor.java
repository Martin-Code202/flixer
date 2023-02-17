package android.support.v7.media;

import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public final class MediaRouteDescriptor {
    final Bundle mBundle;
    List<IntentFilter> mControlFilters;

    MediaRouteDescriptor(Bundle bundle, List<IntentFilter> list) {
        this.mBundle = bundle;
        this.mControlFilters = list;
    }

    public String getId() {
        return this.mBundle.getString("id");
    }

    public List<String> getGroupMemberIds() {
        return this.mBundle.getStringArrayList("groupMemberIds");
    }

    public String getName() {
        return this.mBundle.getString("name");
    }

    public String getDescription() {
        return this.mBundle.getString("status");
    }

    public Uri getIconUri() {
        String string = this.mBundle.getString("iconUri");
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public boolean isEnabled() {
        return this.mBundle.getBoolean("enabled", true);
    }

    @Deprecated
    public boolean isConnecting() {
        return this.mBundle.getBoolean("connecting", false);
    }

    public int getConnectionState() {
        return this.mBundle.getInt("connectionState", 0);
    }

    public boolean canDisconnectAndKeepPlaying() {
        return this.mBundle.getBoolean("canDisconnect", false);
    }

    public IntentSender getSettingsActivity() {
        return (IntentSender) this.mBundle.getParcelable("settingsIntent");
    }

    public List<IntentFilter> getControlFilters() {
        ensureControlFilters();
        return this.mControlFilters;
    }

    /* access modifiers changed from: package-private */
    public void ensureControlFilters() {
        if (this.mControlFilters == null) {
            this.mControlFilters = this.mBundle.getParcelableArrayList("controlFilters");
            if (this.mControlFilters == null) {
                this.mControlFilters = Collections.emptyList();
            }
        }
    }

    public int getPlaybackType() {
        return this.mBundle.getInt("playbackType", 1);
    }

    public int getPlaybackStream() {
        return this.mBundle.getInt("playbackStream", -1);
    }

    public int getDeviceType() {
        return this.mBundle.getInt("deviceType");
    }

    public int getVolume() {
        return this.mBundle.getInt("volume");
    }

    public int getVolumeMax() {
        return this.mBundle.getInt("volumeMax");
    }

    public int getVolumeHandling() {
        return this.mBundle.getInt("volumeHandling", 0);
    }

    public int getPresentationDisplayId() {
        return this.mBundle.getInt("presentationDisplayId", -1);
    }

    public Bundle getExtras() {
        return this.mBundle.getBundle("extras");
    }

    public int getMinClientVersion() {
        return this.mBundle.getInt("minClientVersion", 1);
    }

    public int getMaxClientVersion() {
        return this.mBundle.getInt("maxClientVersion", Integer.MAX_VALUE);
    }

    public boolean isValid() {
        ensureControlFilters();
        if (TextUtils.isEmpty(getId()) || TextUtils.isEmpty(getName()) || this.mControlFilters.contains(null)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaRouteDescriptor{ ");
        sb.append("id=").append(getId());
        sb.append(", groupMemberIds=").append(getGroupMemberIds());
        sb.append(", name=").append(getName());
        sb.append(", description=").append(getDescription());
        sb.append(", iconUri=").append(getIconUri());
        sb.append(", isEnabled=").append(isEnabled());
        sb.append(", isConnecting=").append(isConnecting());
        sb.append(", connectionState=").append(getConnectionState());
        sb.append(", controlFilters=").append(Arrays.toString(getControlFilters().toArray()));
        sb.append(", playbackType=").append(getPlaybackType());
        sb.append(", playbackStream=").append(getPlaybackStream());
        sb.append(", deviceType=").append(getDeviceType());
        sb.append(", volume=").append(getVolume());
        sb.append(", volumeMax=").append(getVolumeMax());
        sb.append(", volumeHandling=").append(getVolumeHandling());
        sb.append(", presentationDisplayId=").append(getPresentationDisplayId());
        sb.append(", extras=").append(getExtras());
        sb.append(", isValid=").append(isValid());
        sb.append(", minClientVersion=").append(getMinClientVersion());
        sb.append(", maxClientVersion=").append(getMaxClientVersion());
        sb.append(" }");
        return sb.toString();
    }

    public Bundle asBundle() {
        return this.mBundle;
    }

    public static MediaRouteDescriptor fromBundle(Bundle bundle) {
        if (bundle != null) {
            return new MediaRouteDescriptor(bundle, null);
        }
        return null;
    }

    public static final class Builder {
        private final Bundle mBundle;
        private ArrayList<IntentFilter> mControlFilters;
        private ArrayList<String> mGroupMemberIds;

        public Builder(String str, String str2) {
            this.mBundle = new Bundle();
            setId(str);
            setName(str2);
        }

        public Builder(MediaRouteDescriptor mediaRouteDescriptor) {
            if (mediaRouteDescriptor == null) {
                throw new IllegalArgumentException("descriptor must not be null");
            }
            this.mBundle = new Bundle(mediaRouteDescriptor.mBundle);
            mediaRouteDescriptor.ensureControlFilters();
            if (!mediaRouteDescriptor.mControlFilters.isEmpty()) {
                this.mControlFilters = new ArrayList<>(mediaRouteDescriptor.mControlFilters);
            }
        }

        public Builder setId(String str) {
            this.mBundle.putString("id", str);
            return this;
        }

        public Builder setName(String str) {
            this.mBundle.putString("name", str);
            return this;
        }

        public Builder setDescription(String str) {
            this.mBundle.putString("status", str);
            return this;
        }

        public Builder setEnabled(boolean z) {
            this.mBundle.putBoolean("enabled", z);
            return this;
        }

        @Deprecated
        public Builder setConnecting(boolean z) {
            this.mBundle.putBoolean("connecting", z);
            return this;
        }

        public Builder addControlFilter(IntentFilter intentFilter) {
            if (intentFilter == null) {
                throw new IllegalArgumentException("filter must not be null");
            }
            if (this.mControlFilters == null) {
                this.mControlFilters = new ArrayList<>();
            }
            if (!this.mControlFilters.contains(intentFilter)) {
                this.mControlFilters.add(intentFilter);
            }
            return this;
        }

        public Builder addControlFilters(Collection<IntentFilter> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("filters must not be null");
            }
            if (!collection.isEmpty()) {
                for (IntentFilter intentFilter : collection) {
                    addControlFilter(intentFilter);
                }
            }
            return this;
        }

        public Builder setPlaybackType(int i) {
            this.mBundle.putInt("playbackType", i);
            return this;
        }

        public Builder setPlaybackStream(int i) {
            this.mBundle.putInt("playbackStream", i);
            return this;
        }

        public Builder setDeviceType(int i) {
            this.mBundle.putInt("deviceType", i);
            return this;
        }

        public Builder setVolume(int i) {
            this.mBundle.putInt("volume", i);
            return this;
        }

        public Builder setVolumeMax(int i) {
            this.mBundle.putInt("volumeMax", i);
            return this;
        }

        public Builder setVolumeHandling(int i) {
            this.mBundle.putInt("volumeHandling", i);
            return this;
        }

        public Builder setPresentationDisplayId(int i) {
            this.mBundle.putInt("presentationDisplayId", i);
            return this;
        }

        public MediaRouteDescriptor build() {
            if (this.mControlFilters != null) {
                this.mBundle.putParcelableArrayList("controlFilters", this.mControlFilters);
            }
            if (this.mGroupMemberIds != null) {
                this.mBundle.putStringArrayList("groupMemberIds", this.mGroupMemberIds);
            }
            return new MediaRouteDescriptor(this.mBundle, this.mControlFilters);
        }
    }
}
