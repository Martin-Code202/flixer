package o;

import org.json.JSONObject;
/* renamed from: o.ন  reason: contains not printable characters */
public class C0660 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f14004;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f14005;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f14006;

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m14831() {
        return this.f14004;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m14833() {
        return this.f14005;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public long m14830() {
        return this.f14006;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m14832(Long l, Long l2) {
        this.f14004++;
        if (l != null) {
            this.f14005 += l.longValue();
        } else {
            C1283.m16865("nf_net_stats", "SentByteCount is missing!");
        }
        if (l2 != null) {
            this.f14006 += l2.longValue();
        } else {
            C1283.m16865("nf_net_stats", "ReceivedByteCount is missing!");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized JSONObject m14829() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("count", m14831());
        jSONObject.put("receivedBytes", m14830());
        jSONObject.put("sentBytes", m14833());
        return jSONObject;
    }
}
