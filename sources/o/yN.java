package o;

import android.content.Context;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import java.util.ArrayList;
import java.util.List;
public final class yN extends C1277 {

    /* renamed from: ˊ */
    public static final yN f12408 = new yN();

    /* renamed from: ˎ */
    private static final boolean f12409 = f12409;

    private yN() {
        super("PreviewsMediaPrefetch");
    }

    /* renamed from: ॱ */
    private final C2059ph m13221(Context context) {
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
        C2059ph serviceManager = netflixActivity != null ? netflixActivity.getServiceManager() : null;
        if (serviceManager != null && serviceManager.mo9519()) {
            return serviceManager;
        }
        return null;
    }

    /* renamed from: ॱ */
    public static /* synthetic */ void m13222(yN yNVar, List list, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size() - 1;
        }
        yNVar.m13225(list, context, i, i2);
    }

    /* renamed from: ॱ */
    public final void m13225(List<yR> list, Context context, int i, int i2) {
        AbstractC2056pe r0;
        C1457Fr.m5025(list, "prefetchList");
        C1457Fr.m5025(context, "context");
        int size = list.size();
        if (0 <= i2 && size > i2) {
            int size2 = list.size();
            if (0 <= i && size2 > i) {
                if (f12409) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = i;
                    if (i3 <= i2) {
                        while (true) {
                            arrayList.add(new C2054pc(list.get(i3).getSupplementalVideoId(), 0, PlayerPrefetchSource.Previews, list.get(i3).m13247()));
                            if (i3 == i2) {
                                break;
                            }
                            i3++;
                        }
                    }
                    C2059ph r02 = m13221(context);
                    if (r02 != null && (r0 = r02.m9759()) != null) {
                        r0.mo7795(arrayList);
                    }
                }
            }
        }
    }

    /* renamed from: ˏ */
    public final void m13224(yR yRVar, Context context) {
        AbstractC2056pe r0;
        C1457Fr.m5025(yRVar, "item");
        C1457Fr.m5025(context, "context");
        if (f12409) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C2054pc(yRVar.getSupplementalVideoId(), 0, PlayerPrefetchSource.Previews, yRVar.m13247()));
            C2059ph r02 = m13221(context);
            if (r02 != null && (r0 = r02.m9759()) != null) {
                r0.mo7795(arrayList);
            }
        }
    }

    /* renamed from: ˏ */
    public final void m13223(Context context) {
        AbstractC2056pe r0;
        C1457Fr.m5025(context, "context");
        C2059ph r02 = m13221(context);
        if (r02 != null && (r0 = r02.m9759()) != null) {
            r0.mo7801(PlayerPrefetchSource.Previews);
        }
    }
}
