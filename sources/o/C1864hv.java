package o;

import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.service.offline.download.DownloadableType;
import java.util.List;
/* renamed from: o.hv  reason: case insensitive filesystem */
public class C1864hv extends hL {
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

    private C1864hv(List<C1868hz> list, Long l, String str) {
        super(list, l.longValue(), str, DownloadableType.Audio);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C1864hv m7353(Stream stream) {
        List<C1868hz> r3 = hL.m6954(stream);
        if (r3 != null) {
            return new C1864hv(r3, stream.size, stream.downloadable_id);
        }
        return null;
    }
}
