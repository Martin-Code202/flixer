package org.linphone.core;

import java.util.Vector;
public interface LinphoneCallStats {
    long getCumulativePacketsLost();

    float getDownloadBandwidth();

    float getEstimatedDownloadBandwidth();

    IceState getIceState();

    int getIpFamilyOfRemote();

    float getJitterBufferSize();

    long getLatePacketsCumulativeNumber();

    float getLocalLateRate();

    float getLocalLossRate();

    MediaType getMediaType();

    long getNumberBytesReceived();

    long getNumberBytesSent();

    long getNumberPacketsReceived();

    long getNumberPacketsSent();

    float getReceiverInterarrivalJitter();

    float getReceiverLossRate();

    float getRoundTripDelay();

    float getSenderInterarrivalJitter();

    float getSenderLossRate();

    float getUploadBandwidth();

    public static class MediaType {
        public static MediaType Audio = new MediaType(0, "Audio");
        public static MediaType Text = new MediaType(2, "Text");
        public static MediaType Video = new MediaType(1, "Video");
        private static Vector<MediaType> values = new Vector<>();
        private final String mStringValue;
        protected final int mValue;

        private MediaType(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static MediaType fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                MediaType elementAt = values.elementAt(i2);
                if (elementAt.mValue == i) {
                    return elementAt;
                }
            }
            throw new RuntimeException("MediaType not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    public static class IceState {
        public static IceState Failed = new IceState(1, "Failed");
        public static IceState HostConnection = new IceState(3, "Host connection");
        public static IceState InProgress = new IceState(2, "In progress");
        public static IceState NotActivated = new IceState(0, "Not activated");
        public static IceState ReflexiveConnection = new IceState(4, "Reflexive connection");
        public static IceState RelayConnection = new IceState(5, "Relay connection");
        private static Vector<IceState> values = new Vector<>();
        private final String mStringValue;
        protected final int mValue;

        private IceState(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static IceState fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                IceState elementAt = values.elementAt(i2);
                if (elementAt.mValue == i) {
                    return elementAt;
                }
            }
            throw new RuntimeException("IceState not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    public enum LinphoneAddressFamily {
        INET(0),
        INET_6(1),
        UNSPEC(2);
        
        private int value;

        private LinphoneAddressFamily(int i) {
            this.value = i;
        }

        public int getInt() {
            return this.value;
        }
    }
}
