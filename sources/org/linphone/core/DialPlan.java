package org.linphone.core;
public interface DialPlan {
    String getCountryCallingCode();

    String getCountryCode();

    String getCountryName();

    int getNumberLength();

    String getUsualPrefix();
}
