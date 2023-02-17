package org.linphone.core;
public interface TunnelConfig {
    int getDelay();

    String getHost();

    String getHost2();

    int getPort();

    int getPort2();

    int getRemoteUdpMirrorPort();

    void setDelay(int i);

    void setHost(String str);

    void setHost2(String str);

    void setPort(int i);

    void setPort2(int i);

    void setRemoteUdpMirrorPort(int i);
}
