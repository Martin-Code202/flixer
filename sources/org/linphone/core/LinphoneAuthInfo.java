package org.linphone.core;
public interface LinphoneAuthInfo {
    LinphoneAuthInfo clone();

    String getDomain();

    String getHa1();

    String getPassword();

    String getRealm();

    String getTlsCertificate();

    String getTlsCertificatePath();

    String getTlsKey();

    String getTlsKeyPath();

    String getUserId();

    String getUsername();

    void setDomain(String str);

    void setHa1(String str);

    void setPassword(String str);

    void setRealm(String str);

    void setTlsCertificate(String str);

    void setTlsCertificatePath(String str);

    void setTlsKey(String str);

    void setTlsKeyPath(String str);

    void setUserId(String str);

    void setUsername(String str);
}
