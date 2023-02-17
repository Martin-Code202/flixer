package com.netflix.mediaclient.util.net;

import o.C1349Bv;
public final class AuthorizationCredentials {
    public String netflixId;
    public String secureNetflixId;
    public String userId;

    public AuthorizationCredentials(String str, String str2, String str3) {
        this.userId = str;
        this.netflixId = str2;
        this.secureNetflixId = str3;
    }

    public boolean isValid() {
        return C1349Bv.m4107(this.netflixId) && C1349Bv.m4107(this.secureNetflixId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AuthorizationCredentials authorizationCredentials = (AuthorizationCredentials) obj;
        if (this.userId != null) {
            if (!this.userId.equals(authorizationCredentials.userId)) {
                return false;
            }
        } else if (authorizationCredentials.userId != null) {
            return false;
        }
        if (this.netflixId != null) {
            if (!this.netflixId.equals(authorizationCredentials.netflixId)) {
                return false;
            }
        } else if (authorizationCredentials.netflixId != null) {
            return false;
        }
        if (this.secureNetflixId != null) {
            return this.secureNetflixId.equals(authorizationCredentials.secureNetflixId);
        }
        return authorizationCredentials.secureNetflixId == null;
    }

    public int hashCode() {
        return ((((this.userId != null ? this.userId.hashCode() : 0) * 31) + (this.netflixId != null ? this.netflixId.hashCode() : 0)) * 31) + (this.secureNetflixId != null ? this.secureNetflixId.hashCode() : 0);
    }

    public String toString() {
        return "AuthorizationCredentials{userId='" + this.userId + "'netflixId='" + this.netflixId + "', secureNetflixId='" + this.secureNetflixId + "'}";
    }
}
