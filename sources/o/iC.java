package o;

import android.content.Context;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import o.C1348Bu;
import o.oM;
class iC {
    iC() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static boolean m7414(AbstractC1853hl hlVar, String str) {
        pV r2;
        return hlVar != null && hlVar.mo7118() && (r2 = ((AbstractC2102qv) C1281.m16832(AbstractC2102qv.class)).mo10119(str)) != null && r2.mo6881() == DownloadState.Complete;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static void m7413(final Context context, final oM.AbstractC0160 r2) {
        if (r2 != null) {
            C1348Bu.If.m4098(new Runnable() { // from class: o.iC.1
                @Override // java.lang.Runnable
                public void run() {
                    r2.mo2352(new C1934ke(((AbstractC2101qu) C1281.m16832(AbstractC2101qu.class)).mo10113(context), "", null));
                }
            });
        }
    }
}
