package o;

import android.content.Context;
import com.android.volley.Request;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.preapp.PreAppAgentEventType;
import com.netflix.mediaclient.service.pservice.PDiskData;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.BP;
import o.mX;
public class mS {

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1052 f8777;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Context f8778;

    public mS(Context context, AbstractC1052 r2) {
        this.f8778 = context;
        this.f8777 = r2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8942(final PreAppAgentEventType preAppAgentEventType) {
        final PDiskData pDiskData = new PDiskData();
        final HashSet hashSet = new HashSet();
        m8913(pDiskData);
        m8922(hashSet, preAppAgentEventType);
        final AnonymousClass3 r12 = new AbstractC1222() { // from class: o.mS.3
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˋ */
            public void mo7396(List<AbstractC2077pz> list, Status status) {
                C1283.m16854("nf_preappagentdatahandler", String.format("BB fetched videos:%s", list));
                mS.this.m8909(pDiskData, list);
                hashSet.remove(PDiskData.ListType.BILLBOARD);
                mS.this.m8910(hashSet, pDiskData, preAppAgentEventType);
            }

            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˊ */
            public void mo7395(List<AbstractC2074pw> list, Status status) {
                C1283.m16854("nf_preappagentdatahandler", String.format("IQ fetched videos:%s", list));
                mS.this.m8935(pDiskData, list);
                hashSet.remove(PDiskData.ListType.CW);
                mS.this.m8910(hashSet, pDiskData, preAppAgentEventType);
            }
        };
        final AnonymousClass8 r13 = new AbstractC1222() { // from class: o.mS.8
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ॱॱ */
            public void mo7398(List<pJ> list, Status status) {
                C1283.m16854("nf_preappagentdatahandler", String.format("IQ fetched videos:%s", list));
                mS.this.m8926(pDiskData, list, PDiskData.ListType.IQ);
                hashSet.remove(PDiskData.ListType.IQ);
                mS.this.m8910(hashSet, pDiskData, preAppAgentEventType);
            }
        };
        final AnonymousClass6 r14 = new AbstractC1222() { // from class: o.mS.6
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ॱॱ */
            public void mo7398(List<pJ> list, Status status) {
                C1283.m16854("nf_preappagentdatahandler", String.format("STANDARD_FIRST fetched videos:%s", list));
                mS.this.m8926(pDiskData, list, PDiskData.ListType.STANDARD_FIRST);
                hashSet.remove(PDiskData.ListType.STANDARD_FIRST);
                mS.this.m8910(hashSet, pDiskData, preAppAgentEventType);
            }
        };
        final AnonymousClass7 r0 = new AbstractC1222() { // from class: o.mS.7
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ॱॱ */
            public void mo7398(List<pJ> list, Status status) {
                C1283.m16854("nf_preappagentdatahandler", String.format("STANDARD_SECOND fetched videos:%s", list));
                mS.this.m8926(pDiskData, list, PDiskData.ListType.STANDARD_SECOND);
                hashSet.remove(PDiskData.ListType.STANDARD_SECOND);
                mS.this.m8910(hashSet, pDiskData, preAppAgentEventType);
            }
        };
        final AnonymousClass14 r02 = new AbstractC1222() { // from class: o.mS.14
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ॱॱ */
            public void mo7398(List<pJ> list, Status status) {
                C1283.m16854("nf_preappagentdatahandler", String.format("nonMemberVideos fetched videos:%s", list));
                mS.this.m8926(pDiskData, list, PDiskData.ListType.NON_MEMBER);
                hashSet.remove(PDiskData.ListType.NON_MEMBER);
                mS.this.m8910(hashSet, pDiskData, preAppAgentEventType);
            }
        };
        AnonymousClass15 r03 = new AbstractC1222() { // from class: o.mS.15
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˎ */
            public void mo7393(List<pC> list, Status status) {
                C1283.m16854("nf_preappagentdatahandler", String.format("LoMos fetched ", new Object[0]));
                if (status.mo298()) {
                    mS.this.m8915(pDiskData, list);
                    hashSet.remove(PDiskData.ListType.LOMO_INFO);
                    mS.this.m8934(preAppAgentEventType, r12, r13, r14, r0, r02);
                    return;
                }
                C1283.m16850("nf_preappagentdatahandler", String.format(" updateType: %s - skip fetching data for widget because lomo fetch failed - avoid triggering multiple lolomos", preAppAgentEventType));
            }
        };
        if (PreAppAgentEventType.NON_MEMBER_UPDATED.equals(preAppAgentEventType)) {
            m8934(preAppAgentEventType, r12, r13, r14, r0, r02);
        } else {
            this.f8777.m16095().mo7816(null, 0, 21, r03);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8910(Set<PDiskData.ListType> set, PDiskData pDiskData, PreAppAgentEventType preAppAgentEventType) {
        if (!set.isEmpty()) {
            C1283.m16854("nf_preappagentdatahandler", String.format("waiting for %s", set));
            return;
        }
        C1283.m16854("nf_preappagentdatahandler", "lists/videos fetched");
        m8908(pDiskData, preAppAgentEventType);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8908(final PDiskData pDiskData, final PreAppAgentEventType preAppAgentEventType) {
        m8911(new mX.C1969iF() { // from class: o.mS.13
            @Override // o.mX.C1969iF
            /* renamed from: ˏ */
            public void mo2751(final PDiskData pDiskData2) {
                if (pDiskData2 == null) {
                    C1283.m16854("nf_preappagentdatahandler", "data on disk is null, first time");
                }
                mS.this.f8777.s_().post(new Runnable() { // from class: o.mS.13.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final PDiskData r4 = mS.this.m8920(pDiskData, pDiskData2, preAppAgentEventType);
                        mS.this.m8921(r4);
                        C1283.m16854("nf_preappagentdatahandler", "old not needed data on disk cleared - merged data is");
                        r4.print();
                        new BackgroundTask().m285(new Runnable() { // from class: o.mS.13.3.4
                            @Override // java.lang.Runnable
                            public void run() {
                                C1283.m16854("nf_preappagentdatahandler", "saving merged data... ");
                                mX.m8977(mS.this.f8778, r4.toJsonString(), null);
                            }
                        });
                        mS.this.m8914(r4, preAppAgentEventType);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8914(final PDiskData pDiskData, final PreAppAgentEventType preAppAgentEventType) {
        final int r5 = m8906(pDiskData);
        AnonymousClass12 r6 = new C2005ni() { // from class: o.mS.12

            /* renamed from: ˋ  reason: contains not printable characters */
            private int f8788 = r5;

            @Override // o.C2005ni, o.AbstractC2006nj
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo8943(String str, String str2, Status status) {
                C1283.m16854("nf_preappagentdatahandler", String.format("onResourceFetched mCount: %d, reqUrl: %s, localUrl: %s", Integer.valueOf(this.f8788), str, str2));
                pDiskData.urlMap.put(mZ.m8984(str), str2);
                int i = this.f8788 - 1;
                this.f8788 = i;
                if (i <= 0) {
                    C1283.m16854("nf_preappagentdatahandler", "fetching of images done. store newData");
                    mS.this.m8925(pDiskData, preAppAgentEventType);
                }
            }
        };
        C1283.m16854("nf_preappagentdatahandler", String.format("urlFetchCount=%d", Integer.valueOf(r5)));
        if (r5 <= 0) {
            C1283.m16854("nf_preappagentdatahandler", "no images to fetch - store newData");
            m8925(pDiskData, preAppAgentEventType);
            return;
        }
        m8916(pDiskData.billboardList, pDiskData.urlMap, PDiskData.ListType.BILLBOARD, r6);
        m8916(pDiskData.cwList, pDiskData.urlMap, PDiskData.ListType.CW, r6);
        m8916(pDiskData.iqList, pDiskData.urlMap, PDiskData.ListType.IQ, r6);
        m8916(pDiskData.standardFirstList, pDiskData.urlMap, PDiskData.ListType.STANDARD_FIRST, r6);
        m8916(pDiskData.standardSecondList, pDiskData.urlMap, PDiskData.ListType.STANDARD_SECOND, r6);
        m8916(pDiskData.nonMemberList, pDiskData.urlMap, PDiskData.ListType.NON_MEMBER, r6);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8916(List<mZ> list, Map<String, String> map, PDiskData.ListType listType, C2005ni niVar) {
        if (list != null) {
            for (mZ mZVar : list) {
                if (PDiskData.ListType.CW.equals(listType)) {
                    String r7 = mZ.m8985(mZVar, PDiskData.ImageType.TRICKPLAY);
                    if (!map.containsKey(r7)) {
                        m8936(mZVar.id, r7, niVar);
                    } else {
                        C1283.m16854("nf_preappagentdatahandler", String.format("%s(%s), url:%s exists in urlMap - skip", mZVar.id, PDiskData.ImageType.TRICKPLAY, r7));
                    }
                }
                String r72 = mZ.m8985(mZVar, PDiskData.ImageType.HORIZONTAL_ART);
                if (!map.containsKey(r72)) {
                    m8936(mZVar.id, r72, niVar);
                } else {
                    C1283.m16854("nf_preappagentdatahandler", String.format("%s(%s), url:%s exists in urlMap - skip", mZVar.id, PDiskData.ImageType.HORIZONTAL_ART, r72));
                }
                String r73 = mZ.m8985(mZVar, PDiskData.ImageType.TITLE_CARD);
                if (map.containsKey(r73) || !C1349Bv.m4107(r73)) {
                    C1283.m16854("nf_preappagentdatahandler", String.format("%s(%s), url:%s exists in urlMap - skip", mZVar.id, PDiskData.ImageType.TITLE_CARD, r73));
                } else {
                    m8936(mZVar.id, r73, niVar);
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8936(String str, final String str2, final C2005ni niVar) {
        if (str2 != null) {
            new BackgroundTask().m285(new Runnable() { // from class: o.mS.11
                @Override // java.lang.Runnable
                public void run() {
                    mS.this.f8777.u_().m9303(str2, AssetType.boxArt, Request.Priority.LOW, niVar);
                }
            });
        } else {
            C1283.m16854("nf_preappagentdatahandler", String.format("video.id: %s, url is null", str));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8925(final PDiskData pDiskData, final PreAppAgentEventType preAppAgentEventType) {
        if (pDiskData == null) {
            C1283.m16850("nf_preappagentdatahandler", "newData is null");
            return;
        }
        final AnonymousClass1 r2 = new BP.Cif() { // from class: o.mS.1
            @Override // o.BP.Cif
            /* renamed from: ˏ */
            public void mo3906(String str) {
                C1283.m16854("nf_preappagentdatahandler", "onDataSaved");
                mS.this.m8907(mS.this.f8778, preAppAgentEventType, pDiskData);
            }
        };
        pDiskData.print();
        new BackgroundTask().m285(new Runnable() { // from class: o.mS.5
            @Override // java.lang.Runnable
            public void run() {
                mX.m8977(mS.this.f8778, pDiskData.toJsonString(), r2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8907(Context context, PreAppAgentEventType preAppAgentEventType, PDiskData pDiskData) {
        C1283.m16854("nf_preappagentdatahandler", "notifyOthers updateType:" + preAppAgentEventType);
        if (C1317As.m3774()) {
            this.f8777.m16089().mo8944(context);
        }
        if (((AbstractC2104qx) C1281.m16832(AbstractC2104qx.class)).mo10123(context)) {
            ((AbstractC2104qx) C1281.m16832(AbstractC2104qx.class)).mo10124(context, preAppAgentEventType, pDiskData);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8909(PDiskData pDiskData, List<AbstractC2077pz> list) {
        if (!(list == null || pDiskData == null)) {
            for (AbstractC2077pz pzVar : list) {
                pDiskData.billboardList.add(mW.m8970(pzVar));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8935(PDiskData pDiskData, List<AbstractC2074pw> list) {
        if (!(list == null || pDiskData == null)) {
            for (AbstractC2074pw pwVar : list) {
                pDiskData.cwList.add(mW.m8971(pwVar));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8926(PDiskData pDiskData, List<pJ> list, PDiskData.ListType listType) {
        List<mZ> list2 = null;
        if (PDiskData.ListType.IQ.equals(listType)) {
            list2 = pDiskData.iqList;
        } else if (PDiskData.ListType.STANDARD_FIRST.equals(listType)) {
            list2 = pDiskData.standardFirstList;
        } else if (PDiskData.ListType.STANDARD_SECOND.equals(listType)) {
            list2 = pDiskData.standardSecondList;
        } else if (PDiskData.ListType.NON_MEMBER.equals(listType)) {
            list2 = pDiskData.nonMemberList;
        }
        if (list2 != null && pDiskData != null && list != null) {
            Iterator<pJ> it = list.iterator();
            while (it.hasNext()) {
                list2.add(mW.m8968((CH) it.next()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8915(PDiskData pDiskData, List<pC> list) {
        Map<String, String> map = pDiskData.lomoMap;
        map.clear();
        for (pC pCVar : list) {
            if (LoMoType.BILLBOARD.equals(pCVar.getType())) {
                map.put(PDiskData.ListType.BILLBOARD.m1188(), pCVar.getTitle());
            } else if (LoMoType.CONTINUE_WATCHING.equals(pCVar.getType())) {
                map.put(PDiskData.ListType.CW.m1188(), pCVar.getTitle());
            } else if (LoMoType.INSTANT_QUEUE.equals(pCVar.getType())) {
                map.put(PDiskData.ListType.IQ.m1188(), pCVar.getTitle());
            } else if (LoMoType.m1574(pCVar.getType()) && map.get(PDiskData.ListType.STANDARD_FIRST.m1188()) == null) {
                map.put(PDiskData.ListType.STANDARD_FIRST.m1188(), pCVar.getTitle());
            } else if (LoMoType.m1574(pCVar.getType()) && map.get(PDiskData.ListType.STANDARD_SECOND.m1188()) == null) {
                map.put(PDiskData.ListType.STANDARD_SECOND.m1188(), pCVar.getTitle());
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m8906(PDiskData pDiskData) {
        return m8919(pDiskData.billboardList, pDiskData.urlMap, false) + 0 + m8919(pDiskData.cwList, pDiskData.urlMap, true) + m8919(pDiskData.iqList, pDiskData.urlMap, false) + m8919(pDiskData.standardFirstList, pDiskData.urlMap, false) + m8919(pDiskData.standardSecondList, pDiskData.urlMap, false) + m8919(pDiskData.nonMemberList, pDiskData.urlMap, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private int m8919(List<mZ> list, Map<String, String> map, boolean z) {
        String r5;
        if (list == null) {
            return 0;
        }
        int i = 0;
        AbstractC2104qx qxVar = (AbstractC2104qx) C1281.m16832(AbstractC2104qx.class);
        for (mZ mZVar : list) {
            String r52 = mZ.m8985(mZVar, PDiskData.ImageType.HORIZONTAL_ART);
            if (r52 != null && !map.containsKey(r52)) {
                i++;
            }
            String r53 = mZ.m8985(mZVar, PDiskData.ImageType.TITLE_CARD);
            if (r53 != null && !map.containsKey(r53)) {
                i++;
            }
            if (z && (r5 = mZ.m8985(mZVar, PDiskData.ImageType.TRICKPLAY)) != null && !map.containsKey(r5)) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8922(Set<PDiskData.ListType> set, PreAppAgentEventType preAppAgentEventType) {
        if (PreAppAgentEventType.m1183(preAppAgentEventType)) {
            set.add(PDiskData.ListType.BILLBOARD);
        }
        if (PreAppAgentEventType.m1181(preAppAgentEventType)) {
            set.add(PDiskData.ListType.CW);
        }
        if (PreAppAgentEventType.m1187(preAppAgentEventType)) {
            set.add(PDiskData.ListType.IQ);
        }
        if (PreAppAgentEventType.m1184(preAppAgentEventType)) {
            set.add(PDiskData.ListType.STANDARD_FIRST);
        }
        if (PreAppAgentEventType.m1185(preAppAgentEventType)) {
            set.add(PDiskData.ListType.STANDARD_SECOND);
        }
        if (PreAppAgentEventType.m1182(preAppAgentEventType)) {
            set.add(PDiskData.ListType.NON_MEMBER);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8934(PreAppAgentEventType preAppAgentEventType, AbstractC1222 r9, AbstractC1222 r10, AbstractC1222 r11, AbstractC1222 r12, AbstractC1222 r13) {
        AbstractC1899j r6 = this.f8777.m16095();
        if (PreAppAgentEventType.m1183(preAppAgentEventType)) {
            r6.mo7808(6, false, r9);
        }
        if (PreAppAgentEventType.m1181(preAppAgentEventType)) {
            r6.mo7813(6, false, r9);
        }
        if (PreAppAgentEventType.m1187(preAppAgentEventType)) {
            r6.mo7809(6, false, true, r10);
        }
        if (PreAppAgentEventType.m1184(preAppAgentEventType)) {
            r6.mo7820(null, 0, 6, false, r11);
        }
        if (PreAppAgentEventType.m1185(preAppAgentEventType)) {
            r6.mo7820(null, 1, 6, false, r12);
        }
        if (PreAppAgentEventType.m1182(preAppAgentEventType)) {
            r6.mo7804(12, true, (AbstractC1203) r13);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8911(final mX.C1969iF iFVar) {
        new BackgroundTask().m285(new Runnable() { // from class: o.mS.2
            @Override // java.lang.Runnable
            public void run() {
                mX.m8972(mS.this.f8778, iFVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private PDiskData m8920(PDiskData pDiskData, PDiskData pDiskData2, PreAppAgentEventType preAppAgentEventType) {
        PDiskData pDiskData3;
        if (pDiskData2 == null) {
            return pDiskData;
        }
        C1283.m16854("nf_preappagentdatahandler", String.format("mergeData updateType:%s", preAppAgentEventType));
        switch (preAppAgentEventType) {
            case ALL_MEMBER_UPDATED:
                pDiskData3 = new PDiskData(pDiskData);
                pDiskData3.nonMemberList = pDiskData2.nonMemberList;
                pDiskData3.urlMap = pDiskData2.urlMap;
                break;
            case CW_UPDATED:
                pDiskData3 = new PDiskData(pDiskData2);
                pDiskData3.cwList = pDiskData.cwList;
                break;
            case IQ_UPDATED:
                pDiskData3 = new PDiskData(pDiskData2);
                pDiskData3.iqList = pDiskData.iqList;
                break;
            case NON_MEMBER_UPDATED:
                pDiskData3 = new PDiskData(pDiskData2);
                pDiskData3.nonMemberList = pDiskData.nonMemberList;
                break;
            default:
                pDiskData3 = new PDiskData(pDiskData);
                break;
        }
        C1283.m16854("nf_preappagentdatahandler", "merged data:");
        pDiskData3.print();
        return pDiskData3;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8921(PDiskData pDiskData) {
        ArrayList arrayList = new ArrayList();
        for (String str : pDiskData.urlMap.keySet()) {
            if (!m8939(str, pDiskData)) {
                arrayList.add(str);
            }
        }
        C1283.m16854("nf_preappagentdatahandler", "clearImagesNotPresentInNewList, " + arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            m8927(pDiskData.urlMap.get(str2));
            pDiskData.urlMap.remove(str2);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m8939(String str, PDiskData pDiskData) {
        return m8940(str, pDiskData.billboardList) || m8940(str, pDiskData.cwList) || m8940(str, pDiskData.iqList) || m8940(str, pDiskData.standardFirstList) || m8940(str, pDiskData.standardSecondList) || m8940(str, pDiskData.nonMemberList);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m8940(String str, List<mZ> list) {
        if (list == null) {
            return false;
        }
        for (mZ mZVar : list) {
            if (mZVar.m8986(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8927(final String str) {
        if (!C1349Bv.m4113(str)) {
            final String str2 = str;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > 0 && lastIndexOf < str.length() - 1) {
                str2 = str.substring(lastIndexOf + 1);
            }
            new BackgroundTask().m285(new Runnable() { // from class: o.mS.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!mS.this.f8777.u_().m9304(str2)) {
                        C1283.m16865("nf_preappagentdatahandler", String.format("localFilename: %s, filename: %s delete failed", str, str2));
                    } else {
                        C1283.m16854("nf_preappagentdatahandler", String.format("deleted local file: %s", str));
                    }
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8913(PDiskData pDiskData) {
        String p_ = this.f8777.m16101().p_();
        if (C1349Bv.m4113(p_)) {
            p_ = "default";
        }
        pDiskData.preAppPartnerExperience = p_;
        String o_ = this.f8777.m16101().o_();
        if (C1349Bv.m4113(o_)) {
            o_ = "default";
        }
        pDiskData.preAppWidgetExperience = o_;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8941(final PreAppAgentEventType preAppAgentEventType) {
        if (!PreAppAgentEventType.m1186(preAppAgentEventType)) {
            C1283.m16865("nf_preappagentdatahandler", String.format("skip clearing data - invalid updateType= %s", preAppAgentEventType));
        } else {
            m8911(new mX.C1969iF() { // from class: o.mS.9
                @Override // o.mX.C1969iF
                /* renamed from: ˏ */
                public void mo2751(final PDiskData pDiskData) {
                    if (pDiskData == null) {
                        C1283.m16854("nf_preappagentdatahandler", "data on disk is null, first time");
                    }
                    mS.this.f8777.s_().post(new Runnable() { // from class: o.mS.9.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (pDiskData != null) {
                                mX.m8974(mS.this.f8778);
                                pDiskData.clearMemberlists();
                                mS.this.m8921(pDiskData);
                                C1283.m16854("nf_preappagentdatahandler", "preapp member data cleared. storing rest of data?");
                                mS.this.m8925(pDiskData, preAppAgentEventType);
                                return;
                            }
                            mS.this.m8907(mS.this.f8778, preAppAgentEventType, (PDiskData) null);
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.mS$10  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final /* synthetic */ int[] f8782 = new int[PDiskData.ImageType.values().length];

        static {
            try {
                f8782[PDiskData.ImageType.TITLE_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8782[PDiskData.ImageType.TRICKPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8782[PDiskData.ImageType.HORIZONTAL_ART.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f8783 = new int[PreAppAgentEventType.values().length];
            try {
                f8783[PreAppAgentEventType.ALL_MEMBER_UPDATED.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8783[PreAppAgentEventType.CW_UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8783[PreAppAgentEventType.IQ_UPDATED.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8783[PreAppAgentEventType.NON_MEMBER_UPDATED.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }
}
