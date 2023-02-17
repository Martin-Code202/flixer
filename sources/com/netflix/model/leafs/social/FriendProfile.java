package com.netflix.model.leafs.social;

import com.google.gson.JsonElement;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.Map;
import o.AbstractC0852;
import o.C1349Bv;
public class FriendProfile implements AbstractC0852 {
    private static final String TAG = "FriendProfile";
    private String firstName;
    private String id;
    private String image145x145;
    private String imageUrl;
    private String lastName;

    public FriendProfile() {
    }

    public FriendProfile(String str, String str2, String str3, String str4) {
        this.id = str;
        this.firstName = str2;
        this.lastName = str3;
        this.imageUrl = str4;
    }

    public FriendProfile(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4);
        this.image145x145 = str5;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1459599807:
                    if (key.equals(SignupConstants.Field.LAST_NAME)) {
                        c = 2;
                        break;
                    }
                    break;
                case -859610604:
                    if (key.equals("imageUrl")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 132835675:
                    if (key.equals(SignupConstants.Field.FIRST_NAME)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1012902577:
                    if (key.equals("image145x145")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.id = value.getAsString();
                    break;
                case 1:
                    this.firstName = value.getAsString();
                    break;
                case 2:
                    this.lastName = value.getAsString();
                    break;
                case 3:
                    this.imageUrl = value.getAsString();
                    break;
                case 4:
                    this.image145x145 = value.getAsString();
                    break;
            }
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getBigImageUrl() {
        return this.image145x145;
    }

    public String getId() {
        return this.id;
    }

    public String getFullName() {
        if (!C1349Bv.m4107(getFirstName()) && !C1349Bv.m4107(getLastName())) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (C1349Bv.m4107(getFirstName())) {
            sb.append(getFirstName()).append(" ");
        }
        if (C1349Bv.m4107(getLastName())) {
            sb.append(getLastName());
        }
        return sb.toString().trim();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FriendProfile friendProfile = (FriendProfile) obj;
        if (this.firstName == null) {
            if (friendProfile.firstName != null) {
                return false;
            }
        } else if (!this.firstName.equals(friendProfile.firstName)) {
            return false;
        }
        if (this.id == null) {
            if (friendProfile.id != null) {
                return false;
            }
        } else if (!this.id.equals(friendProfile.id)) {
            return false;
        }
        if (this.imageUrl == null) {
            if (friendProfile.imageUrl != null) {
                return false;
            }
        } else if (!this.imageUrl.equals(friendProfile.imageUrl)) {
            return false;
        }
        if (this.image145x145 == null) {
            if (friendProfile.image145x145 != null) {
                return false;
            }
        } else if (!this.image145x145.equals(friendProfile.image145x145)) {
            return false;
        }
        if (this.lastName == null) {
            if (friendProfile.lastName != null) {
                return false;
            }
            return true;
        } else if (!this.lastName.equals(friendProfile.lastName)) {
            return false;
        } else {
            return true;
        }
    }
}
