package org.linphone.core;
public interface LinphoneNatPolicy {
    void clear();

    void enableIce(boolean z);

    void enableStun(boolean z);

    void enableTurn(boolean z);

    void enableUpnp(boolean z);

    String getStunServer();

    String getStunServerUsername();

    boolean iceEnabled();

    void setStunServer(String str);

    void setStunServerUsername(String str);

    boolean stunEnabled();

    boolean turnEnabled();

    boolean upnpEnabled();
}
