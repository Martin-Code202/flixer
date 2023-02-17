package o;

import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.service.offline.download.DownloadableType;
import java.util.List;
public class hK extends hL {
    @Override // o.hL, o.hD
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ String mo6809() {
        return super.mo6809();
    }

    @Override // o.hL, o.hD
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ List mo6810() {
        return super.mo6810();
    }

    @Override // o.hL, o.hD
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ DownloadableType mo6811() {
        return super.mo6811();
    }

    @Override // o.hL, o.hD
    /* renamed from: ॱ */
    public /* bridge */ /* synthetic */ long mo6812() {
        return super.mo6812();
    }

    private hK(List<C1868hz> list, Long l, String str) {
        super(list, l.longValue(), str, DownloadableType.Video);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static hK m6953(Stream stream) {
        List<C1868hz> r3 = m6954(stream);
        if (r3 != null) {
            return new hK(r3, stream.size, stream.downloadable_id);
        }
        return null;
    }
}
