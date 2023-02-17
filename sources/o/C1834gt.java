package o;

import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.mdx.protocol.target.TargetSessionMessageType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.gt  reason: case insensitive filesystem */
public class C1834gt {

    /* renamed from: o.gt$If */
    public static class If {

        /* renamed from: ˎ  reason: contains not printable characters */
        private TargetSessionMessageType f6996;

        /* renamed from: ˏ  reason: contains not printable characters */
        private AbstractC1824gj f6997;

        public If(TargetSessionMessageType targetSessionMessageType, AbstractC1824gj gjVar) {
            this.f6996 = targetSessionMessageType;
            this.f6997 = gjVar;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public AbstractC1824gj m6710() {
            return this.f6997;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public TargetSessionMessageType m6709() {
            return this.f6996;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m6707(String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr) {
        String r4 = AbstractC1823gi.m6663();
        String str7 = str + AbstractC1823gi.m6666() + ":9080";
        String r6 = C1831gq.m6694(bArr, str6);
        if (C1349Bv.m4113(r6)) {
            return null;
        }
        String[] strArr = {"action=session", "version=1.0", "fromurl=" + str7, "fromuuid=" + r4, "fromuserid=" + str2, "touuid=" + str3, "touserid=" + str4, "nonce=" + str5, "ciphertext=" + r6};
        String r8 = m6702(strArr);
        Arrays.sort(strArr);
        String r9 = m6705(strArr);
        C1283.m16863("MdxTargetSession", "cform [%s]", r9);
        return r8 + "hmac=" + C1831gq.m6695(bArr, r9) + "\r\n";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static If m6706(JSONObject jSONObject, byte[] bArr, AbstractC1700eM eMVar, String str) {
        try {
            String optString = jSONObject.optString("action");
            if ("endCastSession".equals(optString)) {
                C1283.m16863("MdxTargetSession", "handle %s", optString);
                return new If(TargetSessionMessageType.MESSAGE_TYPE_ENDSESSOIN, null);
            } else if (ExceptionClEvent.CATEGORY_VALUE.equals(optString)) {
                C1283.m16865("MdxTargetSession", "get a session error massage");
                return m6708(jSONObject);
            } else if (!"session".equals(optString)) {
                C1283.m16855("MdxTargetSession", "not a session massage %s. BUG!!!", optString);
                return new If(TargetSessionMessageType.MESSAGE_TYPE_ENDSESSOIN, null);
            } else {
                String optString2 = jSONObject.optString("ciphertext");
                if (C1349Bv.m4113(optString2)) {
                    return null;
                }
                String r6 = C1831gq.m6696(bArr, optString2);
                if (!C1349Bv.m4113(r6)) {
                    return AbstractC1824gj.m6674(C1829go.m6692(r6));
                }
                C1283.m16850("MdxTargetSession", "appMsg is empty");
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static If m6708(JSONObject jSONObject) {
        String optString = jSONObject.optString("errorcode");
        String optString2 = jSONObject.optString("errorstring");
        if ("6".equals(optString) || "5".equals(optString) || "9".equals(optString) || "8".equals(optString)) {
            C1283.m16855("MdxTargetSession", "session error %s, %s, redo pairing", optString, optString2);
            return new If(TargetSessionMessageType.MESSAGE_TYPE_ERROR_BADPAIR, null);
        }
        C1283.m16855("MdxTargetSession", "session error %s, %s, restart sesssion", optString, optString2);
        return new If(TargetSessionMessageType.MESSAGE_TYPE_ERROR_BADSESSION, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m6703() {
        return "sessionAction=createSession\r\n";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m6702(String[] strArr) {
        String str = new String();
        for (String str2 : strArr) {
            if (C1349Bv.m4107(str2)) {
                str = str + str2 + "\r\n";
            }
        }
        return str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String m6705(String[] strArr) {
        if (strArr.length < 1) {
            return null;
        }
        String str = strArr[0];
        if (C1349Bv.m4113(m6704(strArr[0]))) {
            return null;
        }
        for (int i = 1; i < strArr.length; i++) {
            String r5 = m6704(strArr[i]);
            if (C1349Bv.m4113(r5)) {
                return null;
            }
            str = str + "&" + r5;
        }
        return str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String m6704(String str) {
        String[] split = str.split("=", 2);
        try {
            return split[0] + "=" + URLEncoder.encode(split[1], "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
