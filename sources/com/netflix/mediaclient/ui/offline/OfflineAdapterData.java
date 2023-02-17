package com.netflix.mediaclient.ui.offline;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.C2091ql;
import o.C2092qm;
import o.C2093qn;
import o.C2098qr;
import o.pT;
import o.pV;
public class OfflineAdapterData {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final If f3352;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C2098qr[] f3353;

    public enum ViewType {
        MOVIE,
        SHOW
    }

    public static class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final int f3355;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final ViewType f3356;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final C2098qr f3357;

        public If(ViewType viewType, C2091ql qlVar, C2098qr qrVar, int i) {
            this.f3356 = viewType;
            this.f3357 = qrVar;
            this.f3355 = i;
        }
    }

    public OfflineAdapterData(C2098qr qrVar, List<C2098qr> list, Map<String, pV> map) {
        if (qrVar.getType() == VideoType.MOVIE) {
            this.f3352 = new If(ViewType.MOVIE, null, qrVar, 1);
            this.f3353 = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            C2098qr qrVar2 = list.get(i2);
            int seasonNumber = qrVar2.getPlayable().getSeasonNumber();
            if (map.get(qrVar2.getId()) != null) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(qrVar2);
                i++;
            }
            if ((i2 == list.size() - 1 || seasonNumber != list.get(i2 + 1).getPlayable().getSeasonNumber()) && arrayList2 != null) {
                pT pTVar = (pT) arrayList2.get(0);
                C2098qr qrVar3 = new C2098qr();
                qrVar3.fillForRealm(pTVar);
                qrVar3.setPlayableAndVideoType((C2092qm) pTVar.getPlayable(), VideoType.SEASON, qrVar.getSeasonTitle(seasonNumber));
                arrayList.add(qrVar3);
                arrayList.addAll(arrayList2);
                arrayList2 = null;
            }
        }
        this.f3353 = (C2098qr[]) arrayList.toArray(new C2098qr[arrayList.size()]);
        this.f3352 = new If(ViewType.SHOW, null, qrVar, i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C2098qr[] m2190() {
        return this.f3353;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public If m2192() {
        return this.f3352;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m2188(Map<String, pV> map) {
        switch (this.f3352.f3356) {
            case MOVIE:
                return map.get(this.f3352.f3357.getId()).mo6916();
            case SHOW:
                int i = 0;
                int i2 = 0;
                C2098qr[] qrVarArr = this.f3353;
                for (C2098qr qrVar : qrVarArr) {
                    if (qrVar.getType() == VideoType.EPISODE) {
                        i += map.get(qrVar.getId()).mo6916();
                        i2++;
                    }
                }
                return i / i2;
            default:
                return 0;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m2191(Map<String, pV> map) {
        switch (this.f3352.f3356) {
            case MOVIE:
                return map.get(this.f3352.f3357.getId()).mo6887();
            case SHOW:
                long j = 0;
                C2098qr[] qrVarArr = this.f3353;
                for (C2098qr qrVar : qrVarArr) {
                    if (C2093qn.m10093(qrVar) && qrVar.getType() == VideoType.EPISODE) {
                        j += map.get(qrVar.getId()).mo6887();
                    }
                }
                return j;
            default:
                return 0;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m2189(String str) {
        switch (this.f3352.f3356) {
            case MOVIE:
                return this.f3352.f3357.getId().equalsIgnoreCase(str);
            case SHOW:
                if (m2187(str) != null) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private pT m2187(String str) {
        C2098qr[] qrVarArr = this.f3353;
        for (C2098qr qrVar : qrVarArr) {
            if (str.equalsIgnoreCase(qrVar.getId())) {
                return qrVar;
            }
        }
        return null;
    }
}
