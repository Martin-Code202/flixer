package o;

import com.netflix.mediaclient.servicemgr.LogArguments;
import org.json.JSONArray;
import org.json.JSONObject;
public class jO extends jN {
    public jO(LogArguments.LogLevel logLevel, long j, long j2, String str, String str2, String str3, long j3, long j4, long j5, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, String str5, String str6, String str7, String str8, JSONArray jSONArray, String str9) {
        super(str, str2, str3);
        m7966(logLevel);
        this.f6134.put("level", logLevel.m1554());
        this.f6134.put("playbackoffline", true);
        this.f6134.put("mid", j);
        this.f6134.put("trackid", j2);
        this.f6134.put("soffms", j3);
        this.f6134.put("moffms", j4);
        this.f6134.put("endreason", str4);
        this.f6134.put("totaltime", j5);
        if (jSONObject != null) {
            this.f6134.put("playstat", jSONObject);
        }
        if (jSONObject2 != null) {
            this.f6134.put("batterystat", jSONObject2);
        }
        this.f6134.put("offlinenetworkstatus", !z);
        if (C1349Bv.m4107(str6)) {
            this.f6134.put("errormsg", str6);
        }
        if (C1349Bv.m4107(str5)) {
            this.f6134.put("errorcode", str5);
        }
        if (C1349Bv.m4107(str7)) {
            this.f6134.put("errorstring", str7);
        }
        if (C1349Bv.m4107(str8)) {
            this.f6134.put("activitydata", str8);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            this.f6134.put("subtitleqoe", jSONArray);
        }
        this.f6134.put("deviceSerial", AR.m3403());
        this.f6134.put("AndroidDeviceID", str9);
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "endplay";
    }

    @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˏ */
    public boolean mo1556() {
        return true;
    }
}
