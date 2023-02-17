package o;

import com.netflix.android.moneyball.BuildConfig;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.mdx.protocol.target.TargetStateEvent;
import com.netflix.msl.MslCryptoException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;
/* renamed from: o.gv  reason: case insensitive filesystem */
public class C1836gv {

    /* renamed from: o.gv$If */
    public static class If {

        /* renamed from: ʻ  reason: contains not printable characters */
        private String f7006;

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f7007;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final TargetStateEvent f7008;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f7009;

        /* renamed from: ˏ  reason: contains not printable characters */
        private byte[] f7010;

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f7011;

        If(byte[] bArr, String str, String str2) {
            this.f7008 = TargetStateEvent.PairSucceed;
            this.f7010 = bArr;
            this.f7007 = str;
            this.f7009 = str2;
        }

        If(TargetStateEvent targetStateEvent, String str, String str2) {
            this.f7008 = targetStateEvent;
            this.f7011 = str;
            this.f7006 = str2;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m6743() {
            return TargetStateEvent.PairSucceed.equals(this.f7008);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public TargetStateEvent m6742() {
            return this.f7008;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public byte[] m6741() {
            return this.f7010;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m6740() {
            return this.f7007;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m6744() {
            return this.f7009;
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        public String m6739() {
            return String.format("{errorCode=%s, errorString=%s}", this.f7011, this.f7006);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m6737(boolean z, boolean z2, boolean z3, String str, String str2, String str3, AbstractC1386Dc dc, AbstractC1400Dq dq, C1407Dx dx) {
        String str4;
        String str5;
        String r4 = AbstractC1823gi.m6663();
        String str6 = str + AbstractC1823gi.m6666() + ":9080";
        if (z) {
            str5 = "regpairrequest";
            str4 = "2.0";
        } else {
            str5 = "pairingrequest";
            str4 = BuildConfig.VERSION_NAME;
        }
        String str7 = ((((("action=" + str5 + "\r\n") + "version=" + str4 + "\r\n") + "nonce=" + str2 + "\r\n") + "controllerurl=" + str6 + "\r\n") + "controlleruuid=" + r4 + "\r\n") + "cticket=" + str3 + "\r\n";
        if (!z || z3) {
            try {
                String str8 = "controlleruuid=" + URLEncoder.encode(r4, "UTF-8") + "&nonce=" + str2;
                synchronized (dc) {
                    str7 = str7 + "pairdatahmac=" + C1418Ei.m4892(dc.mo4325(str8.getBytes("UTF-8"), dq, dx)) + "\r\n";
                }
            } catch (UnsupportedEncodingException e) {
                C1283.m16847("MdxTargetPairing", "URLEncode exceptio %s", e);
            } catch (MslCryptoException e2) {
                C1283.m16847("MdxTargetPairing", "MslCrypto Exception %s", e2);
            } catch (Exception e3) {
                C1283.m16847("MdxTargetPairing", "getPairingMessage Exception %s", e3);
            }
        }
        if (z) {
            String str9 = "action=regpairrequest&nonce=" + str2;
            synchronized (dc) {
                if (z2) {
                    String r11 = m6736(dc, dq, dx, "00000".getBytes("UTF-8"));
                    str7 = str7 + "pin=" + r11 + "\r\n";
                    str9 = str9 + "&pin=" + URLEncoder.encode(r11, "UTF-8");
                }
                str7 = str7 + "hmac=" + C1418Ei.m4892(dc.mo4325(str9.getBytes("UTF-8"), dq, dx)) + "\r\n";
            }
        }
        return str7;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String m6736(AbstractC1386Dc dc, AbstractC1400Dq dq, C1407Dx dx, byte[] bArr) {
        return C1418Ei.m4892(dc.mo4323(bArr, dq, dx));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static If m6735(JSONObject jSONObject, AbstractC1386Dc dc, AbstractC1400Dq dq, C1407Dx dx, boolean z) {
        String optString = jSONObject.optString("errorcode");
        String optString2 = jSONObject.optString("errorstring");
        if (C1349Bv.m4107(optString)) {
            return m6734(optString, optString2);
        }
        String optString3 = jSONObject.optString("action");
        if ("regpairerror".equals(optString3)) {
            C1283.m16865("MdxTargetPairing", "regpairerror without errorcode. Treat it as regpair failure anyway");
            return m6734(optString, optString2);
        } else if ("regpairreply".equals(optString3)) {
            return m6738(jSONObject, z, dc, dq, dx);
        } else {
            if ("pairingresponse".equals(optString3)) {
                return m6738(jSONObject, z, dc, dq, dx);
            }
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static If m6734(String str, String str2) {
        TargetStateEvent targetStateEvent;
        C1283.m16863("MdxTargetPairing", "pairingFail errCode=%s errDesc=%s", str, str2);
        if ("30".equals(str) || "USER_MISMATCH".equals(str) || "20".equals(str)) {
            C1283.m16854("MdxTargetPairing", "TargetContext:  MDX_PAIRING_USER_MISMATCH");
            targetStateEvent = TargetStateEvent.PairFail;
        } else if ("31".equals(str)) {
            C1283.m16854("MdxTargetPairing", "TargetContext:  MDX_PAIRING_ALREADY_PAIRED");
            targetStateEvent = TargetStateEvent.PairFail;
        } else if ("22".equals(str) || "21".equals(str)) {
            C1283.m16854("MdxTargetPairing", "TargetContext:  PAIRING CTICKET error ");
            targetStateEvent = TargetStateEvent.PairFail;
        } else if ("99".equals(str) || "13".equals(str)) {
            C1283.m16854("MdxTargetPairing", "TargetContext:  PAIRING NETWORK error ");
            targetStateEvent = TargetStateEvent.PairFail;
        } else if ("11".equals(str) || "12".equals(str)) {
            C1283.m16854("MdxTargetPairing", "TargetContext:  PAIRING SERVER/TARGET error ");
            targetStateEvent = TargetStateEvent.PairFail;
        } else if ("0".equals(str)) {
            C1283.m16854("MdxTargetPairing", "TargetContext:  PAIRING NOERROR error ");
            targetStateEvent = TargetStateEvent.PairSucceed;
        } else if ("42".equals(str)) {
            C1283.m16854("MdxTargetPairing", "TargetContext:  MDX_REGISTRATION_PAIRING_IN_PROGRESS error ");
            targetStateEvent = TargetStateEvent.PairFail;
        } else {
            C1283.m16854("MdxTargetPairing", "TargetContext:  unknown error ");
            targetStateEvent = TargetStateEvent.PairFail;
        }
        return new If(targetStateEvent, str, str2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static If m6738(JSONObject jSONObject, boolean z, AbstractC1386Dc dc, AbstractC1400Dq dq, C1407Dx dx) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean equals = "2.0".equals(jSONObject.optString(LoggingRequest.VERSION));
        if (equals) {
            str = AbstractC1823gi.m6663();
        } else {
            str = jSONObject.optString("controlleruuid");
        }
        String optString = jSONObject.optString("controllersharedsecret");
        if (equals) {
            str3 = jSONObject.optString("userid");
            str2 = str3;
        } else {
            str3 = jSONObject.optString("controlleruserid");
            str2 = jSONObject.optString("targetuserid");
        }
        String optString2 = jSONObject.optString("nonce");
        String optString3 = jSONObject.optString("targetuuid");
        String optString4 = jSONObject.optString("grantdatahmac");
        if (!equals || z) {
            try {
                str4 = ((((("controllersharedsecret=" + URLEncoder.encode(optString, "UTF-8")) + "&controlleruserid=" + URLEncoder.encode(str3, "UTF-8")) + "&controlleruuid=" + URLEncoder.encode(str, "UTF-8")) + "&nonce=" + optString2) + "&targetuserid=" + URLEncoder.encode(str2, "UTF-8")) + "&targetuuid=" + URLEncoder.encode(optString3, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                C1283.m16847("MdxTargetPairing", "URLEncode exceptio %s", e);
                return null;
            } catch (MslCryptoException e2) {
                C1283.m16847("MdxTargetPairing", "MslCrypto Exception %s", e2);
                return null;
            } catch (Exception e3) {
                C1283.m16847("MdxTargetPairing", "parsePairResponse Exception %s", e3);
                return null;
            }
        } else {
            str4 = (("action=regpairreplycontrollersharedsecret=" + URLEncoder.encode(optString, "UTF-8")) + "&nonce=" + optString2) + "&userid=" + URLEncoder.encode(str3, "UTF-8");
        }
        synchronized (dc) {
            if (!dc.mo4324(str4.getBytes("UTF-8"), C1418Ei.m4894(optString4), dq)) {
                byte[] r15 = dc.mo4325(str4.getBytes("UTF-8"), dq, dx);
                C1283.m16855("MdxTargetPairing", "HMAC_MISMATCH hmacdata %s", str4);
                C1283.m16855("MdxTargetPairing", "b64hmac %s", C1418Ei.m4892(r15));
                C1283.m16855("MdxTargetPairing", "grantdatahmac %s", optString4);
                return new If(TargetStateEvent.PairFail, "HMAC_MISMATCH", "grantdatahmac mismatch");
            } else if (!z) {
                return null;
            } else {
                return new If(C1418Ei.m4894(new String(dc.mo4322(C1418Ei.m4894(optString), dq))), str3, str2);
            }
        }
    }
}
