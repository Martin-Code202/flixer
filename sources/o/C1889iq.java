package o;

import android.content.Context;
import android.util.Base64;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleTrackData;
import com.netflix.mediaclient.service.offline.download.DownloadablePersistentData;
import com.netflix.mediaclient.service.offline.download.DownloadableType;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* renamed from: o.iq  reason: case insensitive filesystem */
public class C1889iq {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m7739(AbstractC1853hl hlVar, Context context) {
        return (!hlVar.mo7131() || ConnectivityUtils.m2955(context)) && ConnectivityUtils.m2964(context);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m7735(hI hIVar) {
        return hIVar.mo6881() == DownloadState.Stopped && hIVar.mo6902();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m7738(hI hIVar) {
        return hIVar.mo6881() == DownloadState.InProgress;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static List<String> m7722(List<DownloadablePersistentData> list) {
        ArrayList arrayList = new ArrayList();
        for (DownloadablePersistentData downloadablePersistentData : list) {
            arrayList.add(downloadablePersistentData.mDownloadableId);
        }
        return arrayList;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m7730(byte[] bArr) {
        try {
            return new String(Base64.encode(bArr, 0), "utf-8");
        } catch (UnsupportedEncodingException e) {
            C1283.m16856("nf_offlineUtils", e, "keySetIdToString UnsupportedEncodingException", new Object[0]);
            return "";
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static byte[] m7740(OfflinePlayablePersistentData offlinePlayablePersistentData) {
        if (C1349Bv.m4107(offlinePlayablePersistentData.mLicenseData.mKeySetId)) {
            return m7741(offlinePlayablePersistentData.mLicenseData.mKeySetId);
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static byte[] m7741(String str) {
        try {
            return Base64.decode(str.getBytes("utf-8"), 0);
        } catch (UnsupportedEncodingException e) {
            C1283.m16856("nf_offlineUtils", e, "keySetIdFromString UnsupportedEncodingException", new Object[0]);
            return new byte[0];
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m7729(String str) {
        File file = new File(str);
        if (file.exists()) {
            return C1317As.m3762(file);
        }
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m7728(int i) {
        return i == 403 || i == 404;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m7737(int i) {
        return i == 420;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m7736(jG jGVar) {
        long currentTimeMillis = System.currentTimeMillis() - jGVar.m7912();
        if (currentTimeMillis <= 0) {
            return false;
        }
        C1283.m16850("nf_offlineUtils", "manifestExpired by " + TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis) + " seconds");
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m7734(OfflinePlayablePersistentData offlinePlayablePersistentData, List<C1864hv> list, List<hK> list2, List<hM> list3, List<hO> list4) {
        if (list.size() != offlinePlayablePersistentData.mAudioDownloadablePersistentList.size()) {
            C1283.m16850("nf_offlineUtils", "missing audio downloadables. expected=" + offlinePlayablePersistentData.mAudioDownloadablePersistentList.size() + " got=" + list.size());
            return false;
        } else if (list2.size() != offlinePlayablePersistentData.mVideoDownloadablePersistentList.size()) {
            C1283.m16850("nf_offlineUtils", "missing video downloadables. expected=" + offlinePlayablePersistentData.mVideoDownloadablePersistentList.size() + " got=" + list2.size());
            return false;
        } else if (list3.size() != offlinePlayablePersistentData.mSubtitleDownloadablePersistentList.size()) {
            C1283.m16850("nf_offlineUtils", "missing timed-text downloadables. expected=" + offlinePlayablePersistentData.mSubtitleDownloadablePersistentList.size() + " got=" + list3.size());
            return false;
        } else if (list4.size() == offlinePlayablePersistentData.mTrickPlayDownloadablePersistentList.size()) {
            return true;
        } else {
            C1283.m16850("nf_offlineUtils", "missing tickPlay downloadables. expected=" + offlinePlayablePersistentData.mTrickPlayDownloadablePersistentList.size() + " got=" + list4.size());
            return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static AudioSource[] m7723(jG jGVar, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            AudioSource r5 = jJ.m7943(jGVar, str);
            if (r5 != null) {
                arrayList.add(r5);
            }
        }
        return (AudioSource[]) arrayList.toArray(new AudioSource[arrayList.size()]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x000d A[EDGE_INSN: B:16:0x000d->B:15:0x000d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0026  */
    /* renamed from: ˏ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.netflix.mediaclient.media.manifest.VideoTrack> m7731(o.jG r6, java.util.List<java.lang.String> r7) {
        /*
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r0 = r6.m7934()
            java.util.Iterator r2 = r0.iterator()
        L_0x000d:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x003c
            java.lang.Object r0 = r2.next()
            r3 = r0
            com.netflix.mediaclient.media.manifest.VideoTrack r3 = (com.netflix.mediaclient.media.manifest.VideoTrack) r3
            java.util.List<com.netflix.mediaclient.media.manifest.Stream> r0 = r3.streams
            java.util.Iterator r4 = r0.iterator()
        L_0x0020:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x003b
            java.lang.Object r0 = r4.next()
            r5 = r0
            com.netflix.mediaclient.media.manifest.Stream r5 = (com.netflix.mediaclient.media.manifest.Stream) r5
            if (r7 == 0) goto L_0x0038
            java.lang.String r0 = r5.downloadable_id
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto L_0x0038
            goto L_0x0020
        L_0x0038:
            r1.add(r3)
        L_0x003b:
            goto L_0x000d
        L_0x003c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1889iq.m7731(o.jG, java.util.List):java.util.List");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Subtitle[] m7724(jG jGVar, List<String> list, String str) {
        Collection<Subtitle> values = m7726(jGVar, list, str).values();
        return (Subtitle[]) values.toArray(new Subtitle[values.size()]);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Map<String, Subtitle> m7726(jG jGVar, List<String> list, String str) {
        HashMap hashMap = new HashMap();
        for (SubtitleTrackData subtitleTrackData : jGVar.m7927(System.nanoTime())) {
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (subtitleTrackData.getUrls().size() > 0 && C1349Bv.m4123(subtitleTrackData.getUrls().get(0).getDownloadableId(), next)) {
                    AbstractC1884il r14 = AbstractC1884il.m7703(subtitleTrackData.getSubtitleInfo(), subtitleTrackData.getUrls().get(0), C1888ip.m7720(str, next, DownloadableType.Subtitle));
                    hashMap.put(next, r14);
                    C1283.m16851("nf_offlineUtils", "Downloadable ID: %s: %s", next, r14.toString());
                    break;
                }
            }
            if (hashMap.size() == list.size()) {
                break;
            }
        }
        return hashMap;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m7733(List<File> list, String str, List<DownloadablePersistentData> list2, DownloadableType downloadableType) {
        for (DownloadablePersistentData downloadablePersistentData : list2) {
            list.add(C1888ip.m7716(str, downloadablePersistentData.mDownloadableId, downloadableType));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m7727(String str, OfflinePlayablePersistentData offlinePlayablePersistentData) {
        C1283.m16862("nf_offlineUtils", "deleteAllDownloadables");
        ArrayList<File> arrayList = new ArrayList();
        m7733(arrayList, str, offlinePlayablePersistentData.mAudioDownloadablePersistentList, DownloadableType.Audio);
        m7733(arrayList, str, offlinePlayablePersistentData.mVideoDownloadablePersistentList, DownloadableType.Video);
        m7733(arrayList, str, offlinePlayablePersistentData.mSubtitleDownloadablePersistentList, DownloadableType.Subtitle);
        m7733(arrayList, str, offlinePlayablePersistentData.mTrickPlayDownloadablePersistentList, DownloadableType.TrickPlay);
        boolean z = true;
        for (File file : arrayList) {
            if (file.exists()) {
                z = z && file.delete();
            }
        }
        return z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C1618cl m7732(OfflinePlayablePersistentData offlinePlayablePersistentData) {
        return new C1618cl(offlinePlayablePersistentData.mOxId, m7725(offlinePlayablePersistentData), offlinePlayablePersistentData.mDownloadContextInitTimeMs, offlinePlayablePersistentData.mDownloadContextRequestId, offlinePlayablePersistentData.mDownloadContextTrackId, offlinePlayablePersistentData.mDownloadContextVideoPos, offlinePlayablePersistentData.mDownloadContextListPos);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m7725(OfflinePlayablePersistentData offlinePlayablePersistentData) {
        if (offlinePlayablePersistentData.getProfileGuidList() == null || offlinePlayablePersistentData.getProfileGuidList().size() <= 0) {
            return null;
        }
        return offlinePlayablePersistentData.getProfileGuidList().get(0);
    }
}
