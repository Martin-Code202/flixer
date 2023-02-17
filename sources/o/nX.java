package o;

import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.ListSummary;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitlePreference;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.User;
import com.netflix.mediaclient.service.webclient.model.leafs.UserProfile;
import java.util.ArrayList;
public final class nX {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static AccountData m9207(String str, boolean z) {
        JsonObject r3 = C0848.m15512("nf_service_user", str);
        if (C0848.m15504(r3)) {
            throw new FalkorException("UserProfiles empty!!!");
        }
        try {
            JsonObject asJsonObject = r3.getAsJsonObject("profilesList");
            int i = 5;
            if (asJsonObject.has("summary")) {
                i = ((ListSummary) C0848.m15506(asJsonObject, "summary", ListSummary.class)).getLength();
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 <= i; i2++) {
                String num = Integer.toString(i2);
                if (asJsonObject.has(num)) {
                    JsonObject asJsonObject2 = asJsonObject.getAsJsonObject(num);
                    UserProfile userProfile = new UserProfile();
                    userProfile.summary = (UserProfile.Summary) C0848.m15506(asJsonObject2, "summary", UserProfile.Summary.class);
                    if (userProfile.summary == null || C1349Bv.m4113(userProfile.getProfileToken())) {
                        throw new FalkorException("response missing summary" + str);
                    }
                    userProfile.subtitlePreference = (SubtitlePreference) C0848.m15506(asJsonObject2, "subtitlePreference", SubtitlePreference.class);
                    arrayList.add(userProfile);
                }
            }
            AccountData accountData = new AccountData(arrayList);
            if (z) {
                User user = new User();
                try {
                    JsonObject asJsonObject3 = r3.getAsJsonObject("user");
                    user.summary = (User.Summary) C0848.m15506(asJsonObject3, "summary", User.Summary.class);
                    if (user.summary == null || C1349Bv.m4113(user.getUserToken())) {
                        throw new FalkorException("response missing summary" + str);
                    }
                    user.subtitleDefaults = (SubtitlePreference) C0848.m15506(asJsonObject3, "subtitleDefaults", SubtitlePreference.class);
                    user.eogAlert = m9206(asJsonObject3);
                    user.setUmaAlert(m9208(asJsonObject3));
                    accountData.setUser(user);
                } catch (Exception e) {
                    C1283.m16846("nf_service_user", "String response to parse = " + str);
                    throw new FalkorException("response missing user json objects", e);
                }
            }
            return accountData;
        } catch (Exception e2) {
            C1283.m16846("nf_service_user", "String response to parse = " + str);
            throw new FalkorException("response missing user json objects", e2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static EogAlert m9206(JsonObject jsonObject) {
        EogAlert eogAlert = (EogAlert) C0848.m15506(jsonObject, "umaEog", EogAlert.class);
        if (eogAlert != null) {
            return eogAlert;
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static UmaAlert m9208(JsonObject jsonObject) {
        UmaAlert umaAlert = (UmaAlert) C0848.m15506(jsonObject, "uma", UmaAlert.class);
        if (umaAlert != null) {
            return umaAlert;
        }
        return null;
    }
}
