package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.User;
import com.netflix.mediaclient.service.webclient.model.leafs.UserProfile;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
public final class nD {
    nD() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static List<UserProfile> m9126(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = (JSONArray) new JSONTokener(str).nextValue();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new UserProfile(jSONArray.opt(i).toString()));
            }
        } catch (JSONException e) {
            C1283.m16850("nf_service_useragent", "error while populateListOfUserProfiles " + e);
        }
        return arrayList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m9125(Context context, List<UserProfile> list) {
        JSONArray jSONArray = new JSONArray();
        for (UserProfile userProfile : list) {
            jSONArray.put(userProfile.toString());
        }
        C1339Bl.m4039(context, "useragent_userprofiles_data", jSONArray.toString());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static User m9128(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return new User(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m9127(Context context, User user) {
        C1339Bl.m4039(context, "useragent_user_data", user.toString());
    }
}
