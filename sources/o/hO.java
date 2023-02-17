package o;

import com.netflix.mediaclient.service.offline.download.DownloadableType;
import java.util.ArrayList;
import java.util.List;
public class hO implements hD {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f7140;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final long f7141;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<C1868hz> f7142 = new ArrayList();

    private hO(List<C1868hz> list, String str, long j) {
        this.f7142.addAll(list);
        C1868hz.m7373(this.f7142);
        this.f7140 = str;
        this.f7141 = j;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static hO m6960(jM jMVar) {
        if (jMVar == null || jMVar.m7961() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] r5 = jMVar.m7965();
        for (String str : r5) {
            if (C1349Bv.m4107(str)) {
                arrayList.add(new C1868hz(str, 1, 1));
            }
        }
        if (arrayList.size() > 0) {
            return new hO(arrayList, jMVar.m7964(), jMVar.m7961());
        }
        return null;
    }

    @Override // o.hD
    /* renamed from: ˎ */
    public List<C1868hz> mo6810() {
        return this.f7142;
    }

    @Override // o.hD
    /* renamed from: ॱ */
    public long mo6812() {
        return this.f7141;
    }

    @Override // o.hD
    /* renamed from: ˋ */
    public String mo6809() {
        return this.f7140;
    }

    @Override // o.hD
    /* renamed from: ˏ */
    public DownloadableType mo6811() {
        return DownloadableType.TrickPlay;
    }
}
