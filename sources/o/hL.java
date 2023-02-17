package o;

import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.media.manifest.Url;
import com.netflix.mediaclient.service.offline.download.DownloadableType;
import java.util.ArrayList;
import java.util.List;
/* access modifiers changed from: package-private */
public abstract class hL implements hD {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final DownloadableType f7126;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final long f7127;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<C1868hz> f7128 = new ArrayList();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f7129;

    hL(List<C1868hz> list, long j, String str, DownloadableType downloadableType) {
        this.f7128.addAll(list);
        this.f7127 = j;
        this.f7129 = str;
        this.f7126 = downloadableType;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static List<C1868hz> m6954(Stream stream) {
        if (stream == null || stream.size.longValue() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Url url : stream.urls) {
            if (C1349Bv.m4107(url.url)) {
                arrayList.add(new C1868hz(url.url, url.store != null ? url.store.rank : 1, (long) url.cdn_id));
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    @Override // o.hD
    /* renamed from: ˎ */
    public List<C1868hz> mo6810() {
        return this.f7128;
    }

    @Override // o.hD
    /* renamed from: ॱ */
    public long mo6812() {
        return this.f7127;
    }

    @Override // o.hD
    /* renamed from: ˋ */
    public String mo6809() {
        return this.f7129;
    }

    @Override // o.hD
    /* renamed from: ˏ */
    public DownloadableType mo6811() {
        return this.f7126;
    }
}
