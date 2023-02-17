package o;
public class jV extends jN {
    public jV(long j, long j2, long j3, String str, String str2, String str3, String str4, String str5, long j4, String str6, long j5) {
        super(str, str2, str3);
        this.f6134.put("mid", j);
        this.f6134.put("soffms", j3);
        this.f6134.put("soff", j3 / 1000);
        this.f6134.put("moffms", j2);
        this.f6134.put("moff", j2 / 1000);
        if (C1349Bv.m4107(str5)) {
            this.f6134.put("vdlid", str5);
            this.f6134.put("vBitrate", j4);
        }
        if (C1349Bv.m4107(str6)) {
            this.f6134.put("adlid", str6);
            this.f6134.put("abitrate", j5);
        }
        this.f6134.put("reason", str4);
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "resumeplay";
    }
}
