package o;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import com.netflix.mediaclient.service.offline.download.DownloadableType;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipConfiguration;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.hV;
public class hU {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f7175;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<String> f7176;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<String> f7177;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final jG f7178;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f7179;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long[] f7180;

    public hU(String str, jG jGVar, List<String> list, List<String> list2, String str2) {
        this.f7179 = str;
        this.f7178 = jGVar;
        this.f7176 = list;
        this.f7177 = list2;
        this.f7175 = str2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public DashManifest m6982() {
        ArrayList arrayList = new ArrayList();
        int i = 0 + 1;
        arrayList.add(m6979(0, this.f7177));
        for (String str : this.f7176) {
            i++;
            arrayList.add(m6980(i, str));
        }
        return new jW(0, this.f7178.m7920(), -1, false, -1, -1, 0, null, null, Collections.singletonList(new Period(null, 0, arrayList)), this.f7180);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private AdaptationSet m6980(int i, String str) {
        Pair<AudioSource, Stream> r10 = jJ.m7942(this.f7178, str);
        if (r10 == null || r10.first == null || r10.second == null) {
            return null;
        }
        AudioSource audioSource = (AudioSource) r10.first;
        Stream stream = (Stream) r10.second;
        String id = audioSource.getId();
        String str2 = stream.content_profile;
        String str3 = "audio/mp4a-latm";
        if (C1349Bv.m4107(str2)) {
            if (str2.startsWith("heaac-")) {
                str3 = "audio/mp4a-latm";
            } else if (str2.startsWith("ddplus-")) {
                str3 = "audio/eac3";
            }
        }
        int i2 = this.f7175.equals(str) ? 1 : 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1921jv(id));
        return new AdaptationSet(i, 1, Collections.singletonList(m6981(id, Format.createAudioContainerFormat(str, "audio/mp4", str3, null, stream.bitrate * 1000, audioSource.getNumChannels(), VoipConfiguration.MAX_SAMPLERATE_48K, null, i2, audioSource.getLanguageCodeIso639_1()).copyWithMetadata(new Metadata(arrayList)), C1888ip.m7720(this.f7179, str, DownloadableType.Audio))), null, null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private AdaptationSet m6979(int i, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Pair<VideoTrack, Stream> r13 = jJ.m7940(this.f7178, str);
            if (!(r13 == null || r13.first == null || r13.second == null)) {
                VideoTrack videoTrack = (VideoTrack) r13.first;
                Stream stream = (Stream) r13.second;
                String str2 = videoTrack.track_id;
                String str3 = stream.content_profile;
                String str4 = "video/avc";
                if (C1349Bv.m4107(str3)) {
                    if (str3.startsWith("hevc-")) {
                        str4 = "video/hevc";
                    } else if (str3.startsWith("vp9-")) {
                        str4 = "video/x-vnd.on2.vp9";
                    }
                }
                arrayList.add(m6981(str2, Format.createVideoContainerFormat(str, "video/mp4", str4, null, stream.bitrate * 1000, -1, -1, -1.0f, null, 0), C1888ip.m7720(this.f7179, str, DownloadableType.Video)));
            }
        }
        return new AdaptationSet(i, 2, arrayList, null, null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Representation m6981(String str, Format format, String str2) {
        hV.iF r10 = hV.m6984(str2);
        if (r10 != null) {
            if (format.containerMimeType.equals("video/mp4") && this.f7180 == null) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(str2, "r");
                    byte[] bArr = new byte[((int) r10.m6985())];
                    randomAccessFile.seek((long) ((int) r10.m6986()));
                    for (int i = 0; ((long) i) < r10.m6985(); i += randomAccessFile.read(bArr, i, ((int) r10.m6985()) - i)) {
                    }
                    this.f7180 = jW.m7975(bArr);
                    randomAccessFile.close();
                } catch (Exception e) {
                    C1283.m16844("nf_offline_DashManifestBuilder", "fail to parse sidx %s %s", str2, e);
                }
            }
            String str3 = "file://" + str2;
            long r12 = r10.m6986() + r10.m6985();
            return Representation.newInstance(str, -1, format, str3, new SegmentBase.SingleSegmentBase(new RangedUri(str3, 0, r12), 1, 0, 0, r12));
        }
        throw new Exception("filename=" + str2 + "sidx is null.");
    }
}
