package o;
public class jS extends jN {
    public jS(String str, String str2, String str3, long j, long j2, String str4, String str5) {
        super(str, str2, str3);
        this.f6134.put("soffms", j);
        this.f6134.put("moffms", j2);
        this.f6134.put("moff", j2 / 1000);
        this.f6134.put("oldstate", str4);
        this.f6134.put("newstate", str5);
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "statechanged";
    }
}
