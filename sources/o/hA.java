package o;

import com.netflix.mediaclient.service.offline.download.DownloadableType;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
class hA {

    /* renamed from: ˊ  reason: contains not printable characters */
    final String f7055;

    /* renamed from: ˋ  reason: contains not printable characters */
    final String f7056;

    /* renamed from: ˎ  reason: contains not printable characters */
    final DownloadableType f7057;

    /* renamed from: ˏ  reason: contains not printable characters */
    final String f7058;

    /* renamed from: ॱ  reason: contains not printable characters */
    final String f7059;

    private hA(String str, String str2, String str3, DownloadableType downloadableType, String str4) {
        this.f7056 = str;
        this.f7059 = str2;
        this.f7057 = downloadableType;
        this.f7055 = str3;
        this.f7058 = str4;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static hA m6802(OfflinePlayablePersistentData offlinePlayablePersistentData, hD hDVar, String str) {
        return new hA(offlinePlayablePersistentData.mOxId, offlinePlayablePersistentData.mDxId, hDVar.mo6809(), hDVar.mo6811(), str);
    }
}
