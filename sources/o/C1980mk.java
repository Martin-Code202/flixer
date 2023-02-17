package o;

import android.os.Handler;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import o.AbstractC1979mj;
/* renamed from: o.mk  reason: case insensitive filesystem */
public class C1980mk {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static AbstractC1979mj m9036(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, SubtitleUrl subtitleUrl, mP mPVar, mP mPVar2, float f, long j, long j2, AbstractC1979mj.iF iFVar, long j3, AbstractC2055pd pdVar) {
        if (subtitleUrl == null) {
            throw new IllegalArgumentException("Metadata object is null!");
        }
        ISubtitleDef.SubtitleProfile profile = subtitleUrl.getProfile();
        if (profile == ISubtitleDef.SubtitleProfile.IMAGE) {
            return new C1972mc(handler, mhVar, mlVar, subtitleUrl, j, iFVar, j3, j2, pdVar);
        }
        if (profile == ISubtitleDef.SubtitleProfile.ENHANCED_ENC || profile == ISubtitleDef.SubtitleProfile.SIMPLE_ENC) {
            return new C1974me(handler, mhVar, mlVar, subtitleUrl, mPVar, mPVar2, f, iFVar, j3, j2, pdVar);
        }
        if (profile == ISubtitleDef.SubtitleProfile.ENHANCED || profile == ISubtitleDef.SubtitleProfile.SIMPLE) {
            return new C1973md(handler, mhVar, mlVar, subtitleUrl, mPVar, mPVar2, f, iFVar, j3, j2, pdVar);
        }
        if (profile == ISubtitleDef.SubtitleProfile.IMAGE_ENC) {
            return new C1975mf(handler, mhVar, mlVar, subtitleUrl, j, iFVar, j3, j2, pdVar);
        }
        throw new IllegalArgumentException("Not supported profile: " + profile);
    }
}
