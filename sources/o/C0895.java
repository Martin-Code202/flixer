package o;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
/* renamed from: o.ᕑ  reason: contains not printable characters */
public final class C0895 {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int f14769 = Runtime.getRuntime().availableProcessors();

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m15619(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m15616(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m15617(Intent intent, String str) {
        if (intent != null) {
            return m15618(intent.getExtras(), str);
        }
        m15616("BillingHelper", "Got null intent!");
        return 6;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m15618(Bundle bundle, String str) {
        if (bundle == null) {
            m15616(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            m15619(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            m15616(str, "Unexpected type for bundle response code: " + obj.getClass().getName());
            return 6;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static List<C0738> m15614(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            m15616("BillingHelper", "Couldn't find purchase lists, trying to find single data.");
            C0738 r7 = m15615(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (r7 == null) {
                m15616("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(r7);
        } else {
            int i = 0;
            while (i < stringArrayList.size() && i < stringArrayList2.size()) {
                C0738 r6 = m15615(stringArrayList.get(i), stringArrayList2.get(i));
                if (r6 != null) {
                    arrayList.add(r6);
                }
                i++;
            }
        }
        return arrayList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static C0738 m15615(String str, String str2) {
        if (str == null || str2 == null) {
            m15616("BillingHelper", "Received a bad purchase data.");
            return null;
        }
        try {
            return new C0738(str, str2);
        } catch (JSONException e) {
            m15616("BillingHelper", "Got JSONException while parsing purchase data: " + e);
            return null;
        }
    }
}
