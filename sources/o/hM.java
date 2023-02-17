package o;

import com.netflix.mediaclient.media.SubtitleTrackData;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.service.offline.download.DownloadableType;
import java.util.ArrayList;
import java.util.List;
public class hM implements hD {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<C1868hz> f7130 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f7131;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f7132;

    private hM(List<C1868hz> list, long j, String str) {
        this.f7130.addAll(list);
        C1868hz.m7373(this.f7130);
        this.f7131 = j;
        this.f7132 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static hM m6955(SubtitleTrackData subtitleTrackData, List<SubtitleUrl> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long j = 0;
        String str = null;
        for (SubtitleUrl subtitleUrl : list) {
            if (C1349Bv.m4107(subtitleUrl.getDownloadUrl())) {
                if (str == null) {
                    str = subtitleUrl.getDownloadableId();
                } else if (!str.equals(subtitleUrl.getDownloadableId())) {
                    C1283.m16850("nf_subtitleDlInfo", "subtitleUrl has different downloadableId.. ignore");
                }
                arrayList.add(new C1868hz(subtitleUrl.getDownloadUrl(), subtitleTrackData.getRankForCdn(subtitleUrl.getCdnId() + ""), subtitleUrl.getCdnId()));
                j = subtitleUrl.getSize();
            }
        }
        if (arrayList.size() <= 0 || j <= 0) {
            return null;
        }
        return new hM(arrayList, j, str);
    }

    @Override // o.hD
    /* renamed from: ˎ */
    public List<C1868hz> mo6810() {
        return this.f7130;
    }

    @Override // o.hD
    /* renamed from: ॱ */
    public long mo6812() {
        return this.f7131;
    }

    @Override // o.hD
    /* renamed from: ˋ */
    public String mo6809() {
        return this.f7132;
    }

    @Override // o.hD
    /* renamed from: ˏ */
    public DownloadableType mo6811() {
        return DownloadableType.Subtitle;
    }
}
