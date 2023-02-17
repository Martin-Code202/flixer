package o;

import com.netflix.mediaclient.servicemgr.LogArguments;
public class jU extends jN {
    public jU(LogArguments.LogLevel logLevel, long j, long j2, String str, String str2, String str3, long j3, long j4, String str4, long j5, String str5, long j6, long j7, boolean z, String str6, String str7, String str8, String str9) {
        super(str, str2, str3);
        this.f6134.put("level", logLevel.m1554());
        m7966(logLevel);
        this.f6134.put("trackid", j2);
        this.f6134.put("mid", j);
        this.f6134.put("soffms", j3);
        this.f6134.put("soff", j3 / 1000);
        this.f6134.put("moffms", j4);
        this.f6134.put("moff", j4 / 1000);
        if (C1349Bv.m4107(str4)) {
            this.f6134.put("vdlid", str4);
            this.f6134.put("vBitrate", j5);
        }
        if (C1349Bv.m4107(str5)) {
            this.f6134.put("adlid", str5);
            this.f6134.put("abitrate", j6);
        }
        this.f6134.put("playdelay", j7);
        this.f6134.put("offlinenetworkstatus", !z);
        if (C1349Bv.m4107(str7)) {
            this.f6134.put("errormsg", str7);
        }
        if (C1349Bv.m4107(str6)) {
            this.f6134.put("errorcode", str6);
        }
        if (C1349Bv.m4107(str8)) {
            this.f6134.put("errorstring", str8);
        }
        if (C1349Bv.m4107(str9)) {
            this.f6134.put("uiLabel", str9);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "startplay";
    }
}
