package o;

import com.netflix.mediaclient.servicemgr.ISubtitleDef;
/* renamed from: o.ir  reason: case insensitive filesystem */
public class C1890ir {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static AbstractC1883ik m7742(AbstractC1977mh mhVar, AbstractC1981ml mlVar, AbstractC1884il ilVar, mP mPVar, mP mPVar2, float f, long j, long j2, AbstractC2055pd pdVar, boolean z) {
        if (ilVar == null) {
            throw new IllegalArgumentException("Metadata object is null!");
        }
        ISubtitleDef.SubtitleProfile r14 = ilVar.m7707();
        if (r14 == ISubtitleDef.SubtitleProfile.IMAGE) {
            return new C1880ih(null, mhVar, mlVar, (C1879ig) ilVar, j, null, 0, j2, pdVar, z);
        }
        if (r14 == ISubtitleDef.SubtitleProfile.ENHANCED_ENC || r14 == ISubtitleDef.SubtitleProfile.SIMPLE_ENC) {
            return new C1878ie(null, mhVar, mlVar, ilVar, mPVar, mPVar2, f, j2, pdVar, z);
        }
        if (r14 == ISubtitleDef.SubtitleProfile.ENHANCED || r14 == ISubtitleDef.SubtitleProfile.SIMPLE) {
            return new C1885im(null, mhVar, mlVar, ilVar, mPVar, mPVar2, f, j2, pdVar, Boolean.valueOf(z));
        }
        if (r14 == ISubtitleDef.SubtitleProfile.IMAGE_ENC) {
            return new C1881ii(null, mhVar, mlVar, (C1879ig) ilVar, j, null, 0, j2, pdVar, z);
        }
        throw new IllegalArgumentException("Not supported profile: " + r14);
    }
}
