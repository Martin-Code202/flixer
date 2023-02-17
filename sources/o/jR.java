package o;
public class jR extends jN {
    public jR(long j, long j2, String str, String str2, String str3, String str4) {
        super(str2, str3, str4);
        this.f6134.put("soffms", j2);
        this.f6134.put("moffms", j);
        this.f6134.put("moff", j / 1000);
        this.f6134.put("exittype", str);
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "exitpipplay";
    }
}
