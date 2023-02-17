package o;

import java.util.HashMap;
import java.util.Map;
/* renamed from: o.mq  reason: case insensitive filesystem */
public final class C1986mq {

    /* renamed from: ˏ  reason: contains not printable characters */
    private Map<String, C1985mp> f8922 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m9063(String str, int i, int i2) {
        C1283.m16851("nf_subtitles_qoe", "reportSubtitleQoe:: did %s, expected %d, displayed %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        C1985mp mpVar = this.f8922.get(str);
        if (mpVar != null) {
            mpVar.m9061(i, i2);
            C1283.m16854("nf_subtitles_qoe", "reportSubtitleQoe:: update existing " + mpVar);
        } else {
            C1985mp mpVar2 = new C1985mp(str, i, i2);
            C1283.m16854("nf_subtitles_qoe", "reportSubtitleQoe:: new");
            this.f8922.put(str, mpVar2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m9062() {
        this.f8922.clear();
    }
}
