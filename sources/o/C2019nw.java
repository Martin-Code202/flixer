package o;

import android.content.Context;
import android.util.Pair;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import org.json.JSONObject;
/* renamed from: o.nw  reason: case insensitive filesystem */
public class C2019nw {
    /* renamed from: ˎ  reason: contains not printable characters */
    private static Pair<String, String> m9360(Context context) {
        String r4 = C1339Bl.m4045(context, "useragent_profilemap", "{}");
        C1339Bl.m4041(context, "useragent_profilemap");
        C1283.m16851("nf_service_useragent", "UserProfileMap json %s ", r4);
        JSONObject jSONObject = new JSONObject(r4);
        String optString = jSONObject.optString("currentAcc");
        if (C1349Bv.m4113(optString)) {
            C1283.m16854("nf_service_useragent", "Current account NOT found!");
            return null;
        }
        C1283.m16851("nf_service_useragent", "Current account found, profile ID: %s", optString);
        String optString2 = jSONObject.optString(optString);
        if (C1349Bv.m4113(optString2)) {
            C1283.m16854("nf_service_useragent", "Current account key NOT found!");
            return null;
        }
        C1283.m16851("nf_service_useragent", "Current account key found: %s", optString2);
        return new Pair<>(optString, optString2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static AuthorizationCredentials m9359(Context context, String str, String str2) {
        JSONObject oldSecureStore = SecurityRepository.getOldSecureStore(context);
        if (oldSecureStore == null) {
            C1283.m16854("nf_service_useragent", "User not known, go to NML page");
            return null;
        }
        C1283.m16851("nf_service_useragent", "User is known, try to migrate user: %s", oldSecureStore);
        String optString = oldSecureStore.optString(str2 + "/NflxID", "");
        String optString2 = oldSecureStore.optString(str2 + "/SNflxID", "");
        if (C1349Bv.m4113(optString) || C1349Bv.m4113(optString2)) {
            return null;
        }
        return new AuthorizationCredentials(str, optString, optString2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Pair<String, AuthorizationCredentials> m9361(Context context) {
        try {
            Pair<String, String> r5 = m9360(context);
            if (r5 == null) {
                return null;
            }
            C1283.m16851("nf_service_useragent", "Current profile %s, account key %s", r5.first, r5.second);
            AuthorizationCredentials r6 = m9359(context, (String) r5.first, (String) r5.second);
            if (r6 == null) {
                C1283.m16854("nf_service_useragent", "Credentials not found!");
                return null;
            }
            C1283.m16851("nf_service_useragent", "For current profile %s, credentials found %s", r5.first, r6);
            return new Pair<>(r5.first, r6);
        } catch (Throwable th) {
            C1283.m16856("nf_service_useragent", th, "Failed to get credentials", new Object[0]);
            return null;
        }
    }
}
