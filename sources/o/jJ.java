package o;

import android.util.Pair;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import java.util.Iterator;
public class jJ {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static Pair<VideoTrack, Stream> m7940(jG jGVar, String str) {
        for (VideoTrack videoTrack : jGVar.m7934()) {
            Iterator<Stream> it = videoTrack.streams.iterator();
            while (true) {
                if (it.hasNext()) {
                    Stream next = it.next();
                    if (C1349Bv.m4123(next.downloadable_id, str)) {
                        return new Pair<>(videoTrack, next);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AudioSource m7943(jG jGVar, String str) {
        AudioSource[] r1 = jGVar.m7907();
        for (AudioSource audioSource : r1) {
            for (Stream stream : audioSource.getStreams()) {
                if (C1349Bv.m4123(stream.downloadable_id, str)) {
                    return audioSource;
                }
            }
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Pair<AudioSource, Stream> m7942(jG jGVar, String str) {
        AudioSource[] r1 = jGVar.m7907();
        for (AudioSource audioSource : r1) {
            for (Stream stream : audioSource.getStreams()) {
                if (C1349Bv.m4123(stream.downloadable_id, str)) {
                    return new Pair<>(audioSource, stream);
                }
            }
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m7941(jG jGVar, String str) {
        AudioSource[] r2 = jGVar.m7907();
        for (AudioSource audioSource : r2) {
            if (C1349Bv.m4123(audioSource.getId(), str)) {
                return audioSource.getStreams().get(0).downloadable_id;
            }
        }
        return null;
    }
}
