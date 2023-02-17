package o;

import android.content.Context;
import android.os.Handler;
import com.netflix.cl.Logger;
import com.netflix.cl.util.NamedLogSessionLookup;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import com.netflix.mediaclient.service.offline.registry.OfflineRegistry;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* access modifiers changed from: package-private */
/* renamed from: o.hp  reason: case insensitive filesystem */
public class C1857hp {
    C1857hp() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static List<String> m7305(List<hI> list) {
        ArrayList arrayList = new ArrayList();
        for (hI hIVar : list) {
            if (hIVar.mo6881() == DownloadState.Complete) {
                arrayList.add(hIVar.mo6915());
            }
        }
        return arrayList;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static boolean m7295(long j, String str, List<hI> list) {
        long j2 = 50000000;
        for (hI hIVar : list) {
            if (hIVar.mo6881() != DownloadState.Complete && hIVar.mo6884().startsWith(str)) {
                j2 += hIVar.mo6887() - hIVar.mo6914();
            }
        }
        if (j2 <= j) {
            return true;
        }
        C1283.m16850("nf_offlineAgent", "ensureEnoughDiskSpaceForNewRequest freeSpaceNeeded=" + j2 + " freeSpace=" + j);
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static hI m7298(String str, List<hI> list) {
        if (str == null) {
            return null;
        }
        for (hI hIVar : list) {
            if (str.equals(hIVar.mo6915())) {
                return hIVar;
            }
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static boolean m7300(UserAgentInterface userAgentInterface, OfflineRegistry offlineRegistry) {
        String r3 = userAgentInterface.mo1384();
        String r4 = offlineRegistry.m855();
        if (!C1349Bv.m4107(r3) || !C1349Bv.m4107(r4) || r3.equals(r4)) {
            return false;
        }
        C1283.m16850("nf_offlineAgent", "primaryProfileGuid don't match... going to delete all content");
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static void m7294(Map<String, Boolean> map, List<hI> list) {
        if (map != null && map.size() > 0) {
            for (hI hIVar : list) {
                Boolean bool = map.get(hIVar.mo6915());
                if (bool != null) {
                    hIVar.mo6890().setGeoBlocked(!bool.booleanValue());
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static hI m7302(List<hI> list) {
        for (hI hIVar : list) {
            if (hIVar.mo6881() == DownloadState.Creating) {
                return hIVar;
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static boolean m7306(Context context) {
        return System.currentTimeMillis() - C1339Bl.m4044(context, "pref_offline_license_sync_time", 0) > TimeUnit.HOURS.toMillis(24);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static void m7307(Context context) {
        C1339Bl.m4043(context, "pref_offline_license_sync_time", 0L);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static void m7299(Context context) {
        C1339Bl.m4043(context, "pref_offline_license_sync_time", System.currentTimeMillis());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static int m7301(Context context) {
        return C1339Bl.m4037(context, "pref_offline_license_sync_count_zero", 0);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static void m7308(Context context, int i) {
        C1339Bl.m4042(context, "pref_offline_license_sync_count_zero", i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m7296(java.util.List<o.hI> r4) {
        /*
            java.util.Iterator r2 = r4.iterator()
        L_0x0004:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r2.next()
            r3 = r0
            o.hI r3 = (o.hI) r3
            com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState r0 = r3.mo6881()
            com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState r1 = com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState.Creating
            if (r0 == r1) goto L_0x0021
            com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState r0 = r3.mo6881()
            com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState r1 = com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState.CreateFailed
            if (r0 != r1) goto L_0x0023
        L_0x0021:
            r0 = 1
            return r0
        L_0x0023:
            goto L_0x0004
        L_0x0024:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1857hp.m7296(java.util.List):boolean");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static List<String> m7297(List<OfflinePlayablePersistentData> list) {
        ArrayList arrayList = new ArrayList();
        for (OfflinePlayablePersistentData offlinePlayablePersistentData : list) {
            String str = offlinePlayablePersistentData.mLicenseData.mLinkDeactivate;
            if (C1349Bv.m4107(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static void m7303(Context context, Status status, hI hIVar) {
        String str = hIVar.mo6890().mOxId;
        if (hIVar.mo6881() != DownloadState.Complete) {
            C0590.m14709(str);
            C1365Ck.m4458(str, null, IClientLogging.CompletionReason.canceled, C1343Bp.m4064(status));
        }
        Long r4 = NamedLogSessionLookup.INSTANCE.m151(str);
        if (status.mo301()) {
            Logger.INSTANCE.m145(r4, C1343Bp.m4068(status));
            C1365Ck.m4455(str, null, IClientLogging.CompletionReason.failed, C1343Bp.m4064(status));
            return;
        }
        Logger.INSTANCE.m140(r4);
        C1365Ck.m4455(str, null, IClientLogging.CompletionReason.success, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static void m7304(Handler handler, String str) {
    }
}
