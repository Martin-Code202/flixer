package com.netflix.mediaclient.service.webclient.model.leafs;
public class UserBoundCookies {
    private String NetflixId;
    private String NetflixIdTest;
    private String SecureNetflixId;
    private String SecureNetflixIdTest;

    public String getUserBoundNetflixId() {
        return this.NetflixId;
    }

    public String getUserBoundSecureNetflixId() {
        return this.SecureNetflixId;
    }
}
