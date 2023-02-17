package com.netflix.mediaclient.service.webclient.model.leafs;

import java.util.List;
public class AccountData {
    private User user;
    private List<UserProfile> userProfiles;

    public AccountData(List<UserProfile> list) {
        this.userProfiles = list;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public List<UserProfile> getUserProfiles() {
        return this.userProfiles;
    }

    public void setUserProfiles(List<UserProfile> list) {
        this.userProfiles = list;
    }

    public UserProfile getPrimaryProfile() {
        if (this.userProfiles == null || this.userProfiles.size() < 1) {
            return null;
        }
        for (UserProfile userProfile : this.userProfiles) {
            if (userProfile != null && userProfile.isPrimaryProfile()) {
                return userProfile;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccountData{ user= ").append(this.user).append(". userProfiles= [");
        if (this.userProfiles != null) {
            boolean z = true;
            for (UserProfile userProfile : this.userProfiles) {
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(userProfile);
            }
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
}
