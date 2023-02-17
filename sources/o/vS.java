package o;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.ui.offline.OfflineAdapterData;
import com.netflix.mediaclient.util.ConnectivityUtils;
import io.realm.Realm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class vS implements vM {

    /* renamed from: ˋ  reason: contains not printable characters */
    private Map<String, pV> f11244;

    /* renamed from: ˎ  reason: contains not printable characters */
    private List<OfflineAdapterData> f11245 = new ArrayList();

    @Override // o.AbstractC1345Br
    /* renamed from: ˋ */
    public int mo4074() {
        return this.f11245.size();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public OfflineAdapterData mo4075(int i) {
        return this.f11245.get(i);
    }

    @Override // o.vM
    /* renamed from: ˋ */
    public int mo11969(int i) {
        return this.f11245.get(i).m2188(this.f11244);
    }

    @Override // o.vM
    /* renamed from: ˎ */
    public CharSequence mo11970(Context context, int i, String str, VideoType videoType) {
        int i2 = R.color.download_button;
        String str2 = "";
        if (videoType == VideoType.SHOW) {
            str2 = m12037(context, i);
        } else if (videoType == VideoType.EPISODE || videoType == VideoType.MOVIE) {
            pV pVVar = this.f11244.get(str);
            if (pVVar == null) {
                return null;
            }
            int r7 = pVVar.mo6916();
            DownloadState r8 = this.f11244.get(str).mo6881();
            switch (r8) {
                case InProgress:
                    str2 = context.getString(R.string.offline_state_downloading);
                    break;
                case Stopped:
                    if (!pVVar.mo6911().m1581()) {
                        if (r7 <= 0) {
                            str2 = context.getString(R.string.offline_state_downloading);
                            break;
                        } else {
                            str2 = context.getString(R.string.offline_state_paused);
                            break;
                        }
                    }
                    break;
                case Complete:
                    switch (pVVar.mo6912()) {
                        case WATCHING_ALLOWED:
                            long r11 = pVVar.mo6886();
                            if (r11 > 0) {
                                if (r11 > TimeUnit.DAYS.toMillis(1)) {
                                    str2 = C0403.m14185(context, R.string.offline_state_expiring_days).m14187((int) TimeUnit.MILLISECONDS.toDays(r11)).m14188();
                                } else if (r11 > TimeUnit.HOURS.toMillis(1)) {
                                    str2 = C0403.m14185(context, R.string.offline_state_expiring_hours).m14187((int) TimeUnit.MILLISECONDS.toHours(r11)).m14188();
                                } else {
                                    str2 = C0403.m14185(context, R.string.offline_state_expiring_minutes).m14187((int) TimeUnit.MILLISECONDS.toMinutes(r11)).m14188();
                                }
                                i2 = R.color.info_orange;
                                break;
                            }
                            break;
                        case LICENSE_EXPIRED:
                        case PLAY_WINDOW_EXPIRED_FINAL:
                        case VIEW_WINDOW_EXPIRED:
                            str2 = context.getString(R.string.offline_state_expired);
                            i2 = R.color.info_orange;
                            break;
                        case GEO_BLOCKED:
                            i2 = R.color.info_orange;
                            str2 = context.getString(R.string.offline_state_not_available);
                            break;
                    }
                case Creating:
                    str2 = context.getString(R.string.offline_state_downloading);
                    break;
                case CreateFailed:
                case Unknown:
                case Deleted:
                case DeleteComplete:
                    break;
                default:
                    C1276.m16820().mo5725("Wrong DownloadState (=" + r8 + ")");
                    return null;
            }
        } else {
            C1276.m16820().mo5725("Wrong VideoType (=" + videoType + ")");
            return null;
        }
        if (str2 == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i2)), 0, str2.length(), 33);
        return spannableString;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String m12037(Context context, int i) {
        C2098qr[] r3 = this.f11245.get(i).m2190();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (C2098qr qrVar : r3) {
            if (C2093qn.m10093(qrVar) && qrVar.getType() == VideoType.EPISODE) {
                DownloadState r13 = this.f11244.get(qrVar.getId()).mo6881();
                int r14 = mo11976(qrVar.getPlayable().getPlayableId()).mo6916();
                if (r13 == DownloadState.InProgress) {
                    i3++;
                } else if ((r13 == DownloadState.Stopped && r14 == 0) || r13 == DownloadState.Creating || r13 == DownloadState.CreateFailed) {
                    i5++;
                } else if (r13 == DownloadState.Stopped && r14 > 0) {
                    i4++;
                }
                if (r13 != DownloadState.Complete) {
                    i2++;
                }
            }
        }
        if (i3 > 0) {
            return context.getString(R.string.offline_state_downloading_multiple, Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if (i4 > 0) {
            return C0403.m14185(context, R.string.offline_state_paused_multiple).m14187(i4 + i5).m14188();
        }
        if (i5 > 0) {
            return context.getString(R.string.offline_state_queued_multiple, Integer.valueOf(i5));
        }
        return null;
    }

    @Override // o.vM
    /* renamed from: ˊ */
    public long mo11968(int i) {
        return this.f11245.get(i).m2191(this.f11244);
    }

    @Override // o.vM
    /* renamed from: ˏ */
    public int mo11972() {
        return mo11975((AbstractC2089qj) null);
    }

    @Override // o.vM
    /* renamed from: ॱ */
    public int mo11975(AbstractC2089qj qjVar) {
        if (this.f11245 == null) {
            return 0;
        }
        int i = 0;
        for (OfflineAdapterData offlineAdapterData : this.f11245) {
            if (C2093qn.m10093(offlineAdapterData.m2192().f3357)) {
                switch (offlineAdapterData.m2192().f3356) {
                    case SHOW:
                    case MOVIE:
                        if (qjVar == null || offlineAdapterData.m2192().f3357 == null || TextUtils.equals(offlineAdapterData.m2192().f3357.getProfileId(), qjVar.getProfileGuid())) {
                            if (offlineAdapterData.m2192().f3357 == null) {
                                C1276.m16820().mo5725("adapterData.getVideoAndProfileData().video not supposed to be null but found null");
                            }
                            i++;
                            break;
                        } else {
                            continue;
                        }
                        break;
                }
            }
        }
        return i;
    }

    @Override // o.vM
    /* renamed from: ˊ */
    public int mo11967() {
        if (this.f11244 == null) {
            return 0;
        }
        int i = 0;
        for (pV pVVar : this.f11244.values()) {
            if (pVVar.mo6881() == DownloadState.InProgress) {
                i++;
            }
        }
        return i;
    }

    @Override // o.vM
    /* renamed from: ॱ */
    public int mo11974() {
        if (this.f11244 == null) {
            return 0;
        }
        int i = 0;
        for (pV pVVar : this.f11244.values()) {
            if (pVVar.mo6881() != DownloadState.Complete) {
                i++;
            }
        }
        return i;
    }

    @Override // o.vM
    /* renamed from: ॱ */
    public pV mo11976(String str) {
        if (this.f11244 == null || str == null) {
            return null;
        }
        return this.f11244.get(str);
    }

    @Override // o.vM
    /* renamed from: ˎ */
    public Collection<pV> mo11971() {
        return this.f11244.values();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12039(Realm realm, Map<String, pV> map, boolean z) {
        C1283.m16862("OfflinePlayableUiListImpl", "Regenerating the list...");
        ArrayList arrayList = new ArrayList();
        Iterator it = realm.where(C2091ql.class).findAll().iterator();
        while (it.hasNext()) {
            C2091ql qlVar = (C2091ql) it.next();
            ArrayList arrayList2 = null;
            HashSet hashSet = new HashSet();
            if (!z || qlVar.isKids()) {
                Iterator it2 = realm.where(C2098qr.class).equalTo("profileId", qlVar.getId()).notEqualTo("videoType", Integer.valueOf(VideoType.SHOW.getKey())).findAll().iterator();
                while (it2.hasNext()) {
                    C2098qr qrVar = (C2098qr) it2.next();
                    ArrayList arrayList3 = null;
                    boolean z2 = false;
                    if (qrVar.getType() != VideoType.EPISODE) {
                        z2 = map.containsKey(qrVar.getId());
                    } else if (!hashSet.contains(qrVar.getPlayable().getTopLevelId())) {
                        qrVar = C2093qn.m10096(qrVar.getPlayable().getTopLevelId());
                        if (qrVar == null) {
                            C1276.m16820().mo5727("SPY-10714: getOfflineVideoDetails is null, probably deleted");
                            C1283.m16850("OfflinePlayableUiListImpl", "SPY-10714: getOfflineVideoDetails is null, probably deleted");
                        } else {
                            arrayList3 = new ArrayList(realm.where(C2098qr.class).equalTo("profileId", qlVar.getId()).equalTo("videoType", Integer.valueOf(VideoType.EPISODE.getKey())).equalTo("playable.parentId", qrVar.getId()).findAll());
                            Collections.sort(arrayList3, new Comparator<C2098qr>() { // from class: o.vS.2
                                /* renamed from: ॱ  reason: contains not printable characters */
                                public int compare(C2098qr qrVar2, C2098qr qrVar3) {
                                    if (qrVar2.getPlayable().getSeasonNumber() != qrVar3.getPlayable().getSeasonNumber()) {
                                        return qrVar2.getPlayable().getSeasonNumber() - qrVar3.getPlayable().getSeasonNumber();
                                    }
                                    return qrVar2.getPlayable().getEpisodeNumber() - qrVar3.getPlayable().getEpisodeNumber();
                                }
                            });
                            Iterator it3 = arrayList3.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (map.containsKey(((pT) it3.next()).getId())) {
                                        z2 = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            hashSet.add(qrVar.getId());
                        }
                    }
                    if (z2) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(new OfflineAdapterData(qrVar, arrayList3, map));
                    }
                }
                if (arrayList2 != null) {
                    arrayList.addAll(arrayList2);
                    hashSet.clear();
                }
            }
        }
        this.f11244 = map;
        this.f11245 = arrayList;
    }

    @Override // o.vM
    /* renamed from: ˏ */
    public pX mo11973(Context context, AbstractC1853hl hlVar) {
        pX pXVar;
        pX pXVar2;
        if (this.f11244 == null || this.f11244.size() == 0) {
            return null;
        }
        int r5 = vO.m12028(context);
        C1283.m16863("OfflinePlayableUiListImpl", "getSnackbarStatus downloadCompleteSinceSwipe=%d", Integer.valueOf(r5));
        boolean r6 = hlVar.mo7131();
        boolean z = !ConnectivityUtils.m2955(context);
        boolean z2 = !ConnectivityUtils.m2954(context);
        String str = null;
        if (r6 && z) {
            str = context.getString(R.string.offline_snackbar_waiting_wifi);
        } else if (z2) {
            str = context.getString(R.string.offline_snackbar_waiting_network);
        }
        Collection<pV> values = this.f11244.values();
        if (values.size() == 1) {
            pV next = values.iterator().next();
            if (vO.m12019(next)) {
                return new pX(context.getResources().getString(R.string.offline_state_single_error), 1, true);
            }
            if (m12038(next)) {
                return new pX(C0403.m14185(context, R.string.offline_snackbar_download_complete_multiple_no_subtitles).m14187(1).m14188(), 0, true);
            }
            if (m12036(next)) {
                if (str != null) {
                    pXVar2 = new pX(context.getResources().getString(R.string.offline_snackbar_downloading, str), 0);
                } else {
                    pXVar2 = new pX(context.getResources().getString(R.string.offline_snackbar_downloading_paused), 0);
                }
                pXVar2.f9372 = true;
                return pXVar2;
            } else if (m12035() == null && str == null) {
                return null;
            } else {
                return !TextUtils.isEmpty(str) ? new pX(C0403.m14185(context, R.string.offline_snackbar_downloading_multiple_with_subtitle).m14187(1).m14186("status", str).m14188(), 0) : new pX(C0403.m14185(context, R.string.offline_snackbar_downloading_multiple).m14187(1).m14188(), 0);
            }
        } else {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (pV pVVar : this.f11244.values()) {
                i++;
                if (vO.m12019(pVVar)) {
                    i2++;
                } else if (m12038(pVVar)) {
                    i3++;
                } else if (m12036(pVVar)) {
                    i4++;
                } else {
                    i5++;
                }
            }
            C1283.m16863("OfflinePlayableUiListImpl", "total=%d failed=%d completed=%d paused=%d queued=%d downloadCompletedSinceSwipe=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(r5));
            if (i == i3) {
                str = null;
            }
            if (r5 < i3) {
                i3 = r5;
            }
            int i6 = i5 + i4;
            if (i == i3) {
                return new pX(C0403.m14185(context, R.string.offline_snackbar_download_complete_multiple_no_subtitles).m14187(i3).m14188(), i2, true);
            }
            if (i4 == i) {
                pX pXVar3 = new pX(context.getResources().getString(R.string.offline_snackbar_downloading_paused), 0);
                pXVar3.f9372 = true;
                return pXVar3;
            } else if (i2 == i) {
                return new pX(C0403.m14185(context, R.string.offline_snackbar_failed_multiple).m14187(i2).m14188(), i2);
            } else {
                String str2 = null;
                if (str != null) {
                    str2 = str;
                } else if (i2 > 0) {
                    str2 = C0403.m14185(context, R.string.offline_state_error).m14187(i2).m14188();
                }
                if (i4 > 0 && i6 == i4) {
                    if (str == null) {
                        pXVar = new pX(context.getResources().getString(R.string.offline_snackbar_downloading_paused), 0);
                    } else {
                        pXVar = new pX(context.getResources().getString(R.string.offline_snackbar_downloading_paused_with_subtitle, str), 0);
                    }
                    pXVar.f9372 = true;
                    return pXVar;
                } else if (i6 > 0) {
                    int i7 = i6 + i3;
                    return !TextUtils.isEmpty(str2) ? new pX(C0403.m14185(context, R.string.offline_snackbar_downloading_multiple_with_subtitle).m14187(i7).m14186("status", str2).m14188(), i2) : new pX(C0403.m14185(context, R.string.offline_snackbar_downloading_multiple).m14187(i7).m14188(), i2);
                } else if (i3 > 0) {
                    if (TextUtils.isEmpty(str2)) {
                        return new pX(C0403.m14185(context, R.string.offline_snackbar_download_complete_multiple_no_subtitles).m14187(i3).m14188(), i2, true);
                    }
                    return new pX(C0403.m14185(context, R.string.offline_snackbar_download_complete_multiple).m14187(i3).m14186("status", str2).m14188(), i2, true);
                } else if (i2 > 0) {
                    return new pX(C0403.m14185(context, R.string.offline_snackbar_failed_multiple).m14187(i2).m14188(), i2, true);
                } else {
                    return null;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0014  */
    @Override // o.vM
    /* renamed from: ॱॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo11977() {
        /*
            r4 = this;
            java.util.Map<java.lang.String, o.pV> r0 = r4.f11244
            if (r0 == 0) goto L_0x002e
            java.util.Map<java.lang.String, o.pV> r0 = r4.f11244
            java.util.Collection r0 = r0.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x000e:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002e
            java.lang.Object r0 = r2.next()
            r3 = r0
            o.pV r3 = (o.pV) r3
            com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState r0 = r3.mo6881()
            com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState r1 = com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState.Creating
            if (r0 == r1) goto L_0x002b
            com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState r0 = r3.mo6881()
            com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState r1 = com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState.CreateFailed
            if (r0 != r1) goto L_0x002d
        L_0x002b:
            r0 = 1
            return r0
        L_0x002d:
            goto L_0x000e
        L_0x002e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.vS.mo11977():boolean");
    }

    @Override // o.vM
    /* renamed from: ʼ */
    public int mo11966() {
        int i = 0;
        if (this.f11244 != null) {
            for (pV pVVar : this.f11244.values()) {
                if (pVVar.mo6881() == DownloadState.Creating || pVVar.mo6881() == DownloadState.CreateFailed) {
                    i++;
                }
            }
        }
        return i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m12038(pV pVVar) {
        return pVVar.mo6881() == DownloadState.Complete;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m12036(pV pVVar) {
        return !vO.m12019(pVVar) && pVVar.mo6881() == DownloadState.Stopped;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private pV m12035() {
        if (this.f11244 == null) {
            return null;
        }
        for (pV pVVar : this.f11244.values()) {
            if (pVVar.mo6881() == DownloadState.InProgress) {
                return pVVar;
            }
        }
        return null;
    }
}
