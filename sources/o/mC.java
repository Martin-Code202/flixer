package o;

import com.netflix.mediaclient.service.player.subtitles.image.v2.SegmentEncryptionInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public final class mC {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Map<SegmentEncryptionInfo.EncryptionMode, mE> f8688 = new ConcurrentHashMap();

    static {
        f8688.put(SegmentEncryptionInfo.EncryptionMode.NONE, new mJ());
        f8688.put(SegmentEncryptionInfo.EncryptionMode.AES_CBC, new C1993mx());
        f8688.put(SegmentEncryptionInfo.EncryptionMode.AES_CTR, new C1995mz());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static mE m8801(SegmentEncryptionInfo.C0022 r4) {
        if (r4 == null) {
            return f8688.get(SegmentEncryptionInfo.EncryptionMode.NONE);
        }
        if (r4.m1154() == null) {
            throw new IllegalArgumentException("Missing enc mode!");
        }
        mE mEVar = f8688.get(r4.m1154());
        if (mEVar != null) {
            return mEVar;
        }
        throw new IllegalArgumentException("Encryption mode " + r4.m1154() + " not supported!");
    }
}
