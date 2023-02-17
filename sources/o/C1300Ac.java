package o;

import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.cl.model.GestureInputKind;
import com.netflix.cl.model.MaturityLevel;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Ac  reason: case insensitive filesystem */
public class C1300Ac {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean f4352 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0510 m3532(Status status) {
        StatusCode statusCode;
        if (status == null || status.mo302() == null) {
            statusCode = StatusCode.UNKNOWN;
        } else {
            statusCode = status.mo302();
        }
        return m3526(statusCode);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0510 m3526(StatusCode statusCode) {
        return m3538(statusCode, (JSONObject) null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0510 m3538(StatusCode statusCode, JSONObject jSONObject) {
        return C1343Bp.m4061(statusCode, jSONObject);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0557 m3539(AbstractC2089qj qjVar) {
        if (qjVar == null) {
            return null;
        }
        return new C0557(qjVar.getProfileName(), qjVar.getAvatarUrl(), qjVar.isKidsProfile(), qjVar.getLanguagesInCsv(), m3525(qjVar));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static MaturityLevel m3525(AbstractC2089qj qjVar) {
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3537(AbstractC1100 r2) {
        if (r2 != null) {
            Logger.INSTANCE.m140(Logger.INSTANCE.m142(r2));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3533() {
        Logger.INSTANCE.m142(new C1085());
        Logger.INSTANCE.m130("BackCommand");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3529() {
        Logger.INSTANCE.m142(new C0455());
        Logger.INSTANCE.m130("BackCommand");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3530(String str, AbstractC2087qh qhVar, String str2, String str3, JSONObject jSONObject, int i, AppView appView) {
        try {
            m3524(false, appView, new C1369Cn(str, qhVar, Integer.parseInt(str2), str3, i, System.currentTimeMillis(), jSONObject));
        } catch (NumberFormatException | JSONException e) {
            if ((e instanceof NumberFormatException) && !f4352) {
                C1276.m16820().mo5727("Invalid video id format : " + str2 + " found in " + qhVar);
                f4352 = true;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3523(String str, AbstractC2087qh qhVar, List<String> list, List<String> list2, JSONObject jSONObject, int i, AppView appView) {
        int i2 = i;
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str2 = null;
            if (list2 != null && list2.size() > i3) {
                str2 = list2.get(i3);
            }
            m3530(str, qhVar, list.get(i3), str2, jSONObject, i2, appView);
            i2++;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3524(boolean z, AppView appView, AbstractC0574 r4) {
        Logger.INSTANCE.m131(new C0785(z, appView, r4));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static AbstractC0574 m3528(final CH ch) {
        return new AbstractC0574() { // from class: o.Ac.2
            @Override // o.AbstractC0503
            public JSONObject toJSONObject() {
                JSONObject jSONObject = new JSONObject();
                if (!(ch == null || ch.getSummary() == null || ch.getSummary().getId() == null)) {
                    jSONObject.put("id", ch.getSummary().getId());
                }
                return jSONObject;
            }
        };
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static AbstractC0574 m3527(final String str) {
        return new AbstractC0574() { // from class: o.Ac.4
            @Override // o.AbstractC0503
            public JSONObject toJSONObject() {
                JSONObject jSONObject = new JSONObject();
                if (str != null) {
                    jSONObject.put("lolomoId", str);
                }
                return jSONObject;
            }
        };
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AbstractC0574 m3534(final JSONObject jSONObject) {
        return new AbstractC0574() { // from class: o.Ac.5
            @Override // o.AbstractC0503
            public JSONObject toJSONObject() {
                return jSONObject != null ? jSONObject : new JSONObject();
            }
        };
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static AbstractC0574 m3522(final Map<String, String> map) {
        return new AbstractC0574() { // from class: o.Ac.1
            @Override // o.AbstractC0503
            public JSONObject toJSONObject() {
                if (map != null) {
                    return new JSONObject(map);
                }
                return null;
            }
        };
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3540(C1080 r1, AbstractC1100 r2) {
        m3531(r1, r2, false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3531(C1080 r3, AbstractC1100 r4, boolean z) {
        Long r1 = Logger.INSTANCE.m142(r3);
        Long r2 = Logger.INSTANCE.m142(r4);
        if (z) {
            NetflixApplication.getInstance().m242().m4490();
        }
        Logger.INSTANCE.m140(r2);
        Logger.INSTANCE.m140(r1);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3535(C1080 r4, AbstractC1100 r5, AbstractC0401 r6) {
        Long r2 = Logger.INSTANCE.m142(r4);
        Long r3 = Logger.INSTANCE.m142(r5);
        Logger.INSTANCE.m127(r6);
        Logger.INSTANCE.m140(r3);
        Logger.INSTANCE.m140(r2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3536(C1080 r6, boolean z, boolean z2, long j) {
        Long r4 = Logger.INSTANCE.m142(r6);
        Long r5 = Logger.INSTANCE.m142(z ? new C0512() : new C0513());
        Logger.INSTANCE.m127(new C1112(j));
        Logger.INSTANCE.m127(new C0944(1.0f, z2 ? GestureInputKind.doubleTap : GestureInputKind.tap));
        Logger.INSTANCE.m140(r5);
        Logger.INSTANCE.m140(r4);
    }
}
