package o;

import android.view.View;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
public final class xC {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static AbstractC1978mi m12739(ISubtitleDef.SubtitleProfile subtitleProfile, View view) {
        if (ISubtitleDef.SubtitleProfile.IMAGE.equals(subtitleProfile) || ISubtitleDef.SubtitleProfile.IMAGE_ENC.equals(subtitleProfile)) {
            return new C2330xx(view);
        }
        return new C2331xy(view);
    }
}
