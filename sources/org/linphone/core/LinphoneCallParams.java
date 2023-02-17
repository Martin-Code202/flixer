package org.linphone.core;

import org.linphone.core.LinphoneCore;
public interface LinphoneCallParams {
    void addCustomHeader(String str, String str2);

    void addCustomSdpAttribute(String str, String str2);

    void addCustomSdpMediaAttribute(LinphoneCore.StreamType streamType, String str, String str2);

    boolean audioMulticastEnabled();

    void clearCustomSdpAttributes();

    void clearCustomSdpMediaAttributes(LinphoneCore.StreamType streamType);

    void enableAudioMulticast(boolean z);

    void enableLowBandwidth(boolean z);

    void enableRealTimeText(boolean z);

    void enableVideoMulticast(boolean z);

    LinphoneCore.MediaDirection getAudioDirection();

    String getCustomHeader(String str);

    String getCustomSdpAttribute(String str);

    String getCustomSdpMediaAttribute(LinphoneCore.StreamType streamType, String str);

    LinphoneCore.MediaEncryption getMediaEncryption();

    int getPrivacy();

    float getReceivedFramerate();

    VideoSize getReceivedVideoSize();

    float getSentFramerate();

    VideoSize getSentVideoSize();

    String getSessionName();

    PayloadType getUsedAudioCodec();

    PayloadType getUsedVideoCodec();

    LinphoneCore.MediaDirection getVideoDirection();

    boolean getVideoEnabled();

    boolean isLowBandwidthEnabled();

    boolean realTimeTextEnabled();

    void setAudioBandwidth(int i);

    void setAudioDirection(LinphoneCore.MediaDirection mediaDirection);

    void setMediaEnctyption(LinphoneCore.MediaEncryption mediaEncryption);

    void setPrivacy(int i);

    void setRecordFile(String str);

    void setSessionName(String str);

    void setVideoDirection(LinphoneCore.MediaDirection mediaDirection);

    void setVideoEnabled(boolean z);

    boolean videoMulticastEnabled();
}
