package o;

import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.SubtitleTrackData;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
class hC {
    hC() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static List<C1864hv> m6806(jG jGVar, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (AudioSource audioSource : jGVar.m7907()) {
            for (Stream stream : audioSource.getStreams()) {
                if (list == null || list.contains(stream.downloadable_id)) {
                    C1864hv r10 = C1864hv.m7353(stream);
                    if (r10 != null) {
                        arrayList.add(r10);
                    }
                }
            }
            if (arrayList.size() >= 5) {
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static List<hK> m6803(jG jGVar, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (VideoTrack videoTrack : jGVar.m7934()) {
            Iterator<Stream> it = videoTrack.streams.iterator();
            while (true) {
                if (it.hasNext()) {
                    Stream next = it.next();
                    C1283.m16862("nf_downloadableSelect", "video_tracks has bitrate " + next.bitrate);
                    if (list == null || list.contains(next.downloadable_id)) {
                        hK r9 = hK.m6953(next);
                        if (r9 != null) {
                            arrayList.add(r9);
                            return arrayList;
                        }
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static List<hM> m6804(jG jGVar, List<String> list) {
        List<ISubtitleDef.SubtitleProfile> r2 = m6807();
        ArrayList arrayList = new ArrayList();
        for (SubtitleTrackData subtitleTrackData : jGVar.m7927(System.nanoTime())) {
            if (subtitleTrackData.getUrls().size() > 0) {
                subtitleTrackData.getSubtitleInfo().getLanguageCodeIso639_1();
                subtitleTrackData.getSubtitleInfo().getTrackType();
                HashMap hashMap = new HashMap();
                for (SubtitleUrl subtitleUrl : subtitleTrackData.getUrls()) {
                    if (list == null || list.contains(subtitleUrl.getDownloadableId())) {
                        if (hashMap.get(subtitleUrl.getProfile()) == null) {
                            hashMap.put(subtitleUrl.getProfile(), new ArrayList());
                        }
                        ((List) hashMap.get(subtitleUrl.getProfile())).add(subtitleUrl);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator<ISubtitleDef.SubtitleProfile> it = r2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ISubtitleDef.SubtitleProfile next = it.next();
                    if (hashMap.get(next) != null) {
                        arrayList2.addAll((Collection) hashMap.get(next));
                        break;
                    }
                }
                hM r10 = hM.m6955(subtitleTrackData, arrayList2);
                if (r10 != null) {
                    arrayList.add(r10);
                }
                if (arrayList.size() >= 5) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static List<hO> m6805(jG jGVar, List<String> list) {
        hO r6;
        ArrayList arrayList = new ArrayList();
        jM[] r2 = jGVar.m7936();
        for (jM jMVar : r2) {
            if ((list == null || list.contains(jMVar.m7964())) && jMVar.m7963() && (r6 = hO.m6960(jMVar)) != null) {
                arrayList.add(r6);
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static List<ISubtitleDef.SubtitleProfile> m6807() {
        List<ISubtitleDef.SubtitleProfile> asList = Arrays.asList(ISubtitleDef.SubtitleProfile.values());
        Collections.sort(asList, new Comparator<ISubtitleDef.SubtitleProfile>() { // from class: o.hC.3
            /* renamed from: ˊ  reason: contains not printable characters */
            public int compare(ISubtitleDef.SubtitleProfile subtitleProfile, ISubtitleDef.SubtitleProfile subtitleProfile2) {
                return subtitleProfile2.m1535() - subtitleProfile.m1535();
            }
        });
        return asList;
    }
}
