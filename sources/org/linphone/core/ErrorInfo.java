package org.linphone.core;
public interface ErrorInfo {
    String getDetails();

    String getPhrase();

    String getProtocol();

    int getProtocolCode();

    Reason getReason();

    ErrorInfo getSubErrorInfo();

    String getWarnings();

    void setPhrase(String str);

    void setProtocol(String str);

    void setProtocolCode(int i);

    void setReason(Reason reason);

    void setSubErrorInfo(ErrorInfo errorInfo);

    void setWarnings(String str);
}
