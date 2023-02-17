package o;

import com.netflix.mediaclient.service.mdx.protocol.target.TargetSessionMessageType;
import o.C1834gt;
import org.json.JSONObject;
/* renamed from: o.gj  reason: case insensitive filesystem */
public abstract class AbstractC1824gj extends AbstractC1741fA {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected JSONObject f6980;

    protected AbstractC1824gj(String str) {
        super(str);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public JSONObject m6675() {
        return this.f6980;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1834gt.If m6674(JSONObject jSONObject) {
        String string = jSONObject.getString("sessionAction");
        char c = 65535;
        switch (string.hashCode()) {
            case -2082474693:
                if (string.equals("endSession")) {
                    c = 1;
                    break;
                }
                break;
            case 1456957493:
                if (string.equals("startSessionResponse")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_STARTSESSION, new C1819ge(jSONObject));
            case 1:
                return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_ENDSESSOIN, new C1826gl());
            default:
                String string2 = jSONObject.getString("appAction");
                JSONObject jSONObject2 = jSONObject.getJSONObject("appBody");
                char c2 = 65535;
                switch (string2.hashCode()) {
                    case -2088753260:
                        if (string2.equals("DIALOG_SHOW")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -2006733487:
                        if (string2.equals("DIALOG_CANCEL")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1183534128:
                        if (string2.equals("AUDIO_SUBTITLES_SETTINGS")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -878340337:
                        if (string2.equals("HANDSHAKE_ACCEPTED")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -861484972:
                        if (string2.equals("PLAYER_CAPABILITIES")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -243777799:
                        if (string2.equals("META_DATA_CHANGED")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 793034055:
                        if (string2.equals("AUDIO_SUBTITLES_CHANGED")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 828731546:
                        if (string2.equals("MDX_ACTION_PIN_VERIFICATION_NOT_REQUIRED")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 974516823:
                        if (string2.equals("PIN_VERIFICATION_SHOW")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1436783917:
                        if (string2.equals("PLAYER_CURRENT_STATE")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1602921562:
                        if (string2.equals("MESSAGE_IGNORED")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 1978639336:
                        if (string2.equals("PLAYER_STATE_CHANGED")) {
                            c2 = 7;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_HANDSHAKE, new C1766fZ(jSONObject2));
                    case 1:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_AUDIO_SUBTITLES_CHANGED, new C1761fU(jSONObject2));
                    case 2:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_AUDIO_SUBTITLE_SETTINGS, new C1762fV(jSONObject2));
                    case 3:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_DIALOG_CANCEL, new C1760fT(jSONObject2));
                    case 4:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_DIALOG_SHOW, new C1764fX(jSONObject2));
                    case 5:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_CAPABILITY, new C1818gd(jSONObject2));
                    case 6:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_CURRENT_STATE, new C1821gg(jSONObject2));
                    case 7:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_STATE_CHANGED, new C1822gh(jSONObject2));
                    case '\b':
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_PIN_VERIFICATION_SHOW, new C1816gb(jSONObject2));
                    case '\t':
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_PIN_VERIFICATION_NOT_REQUIRED, new C1815ga(jSONObject2));
                    case '\n':
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_META_DATA_CHANGED, new C1765fY(jSONObject2));
                    case 11:
                        return new C1834gt.If(TargetSessionMessageType.MESSAGE_TYPE_GENERIC, new C1817gc(jSONObject2));
                    default:
                        return null;
                }
        }
    }
}
