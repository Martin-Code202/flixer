package com.netflix.mediaclient.ui.offline;

import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import o.AbstractC1853hl;
import o.AbstractC1854hm;
import o.C1339Bl;
import o.pV;
import o.vI;
import o.vM;
import o.vO;
public enum DownloadSummaryListener implements AbstractC1854hm {
    INSTANCE;
    

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f3348;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1853hl f3349;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Set<String> f3350 = new HashSet();

    private DownloadSummaryListener() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2186(AbstractC1853hl hlVar) {
        if (hlVar != null && this.f3349 != hlVar) {
            if (this.f3349 != null) {
                this.f3349.mo7135(this);
            }
            this.f3349 = hlVar;
            this.f3349.mo7124(this);
            m2171();
        }
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2173(String str) {
        this.f3350.add(str);
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo2185(String str, Status status) {
        this.f3350.remove(str);
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo2181(pV pVVar, int i) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2174(pV pVVar) {
        vO.m12024(NetflixApplication.getInstance());
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo2175(pV pVVar) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo2177(pV pVVar, StopReason stopReason) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo2180(String str, Status status, boolean z) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo2178(List<String> list, Status status) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo1758(Status status) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo2184(Status status) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo2176(pV pVVar, Status status) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo2179(pV pVVar, Status status) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo2182(boolean z) {
        m2171();
    }

    @Override // o.AbstractC1854hm
    public boolean aa_() {
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2171() {
        int i;
        if (this.f3349 != null) {
            long j = 0;
            long j2 = 0;
            int size = this.f3350.size();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int size2 = this.f3350.size();
            vM r14 = vO.m12029(this.f3349);
            long r15 = m2172();
            for (pV pVVar : r14.mo11971()) {
                switch (pVVar.mo6881()) {
                    case Creating:
                        size2++;
                        size++;
                        break;
                    case InProgress:
                        size++;
                        break;
                    case CreateFailed:
                        if (pVVar.mo6888() > r15) {
                            size++;
                            i2++;
                            break;
                        }
                        break;
                    case Unknown:
                        size++;
                        break;
                    case Complete:
                        if (pVVar.mo6888() > r15) {
                            i4++;
                            size++;
                            break;
                        }
                        break;
                    case Stopped:
                        if (pVVar.mo6911().m1581()) {
                            if (pVVar.mo6888() > r15) {
                                i2++;
                                size++;
                                break;
                            }
                        } else {
                            j += pVVar.mo6914();
                            j2 += pVVar.mo6887();
                            i3++;
                            size++;
                            break;
                        }
                        break;
                }
                if (pVVar.mo6881() == DownloadState.InProgress || (pVVar.mo6881() == DownloadState.Complete && pVVar.mo6888() > this.f3348)) {
                    j += pVVar.mo6914();
                    j2 += pVVar.mo6887();
                }
            }
            if (size <= 0 || j2 <= 0) {
                if (size2 > 0) {
                    i = 0;
                } else {
                    i = 100;
                }
            } else if (j == j2) {
                i = 0;
            } else {
                if (size2 > 0) {
                    j2 += (((long) size2) * j2) / ((long) (size - size2));
                }
                i = (int) ((100 * j) / j2);
            }
            vI r17 = vI.m11939().mo11951(i4).mo11952(size).mo11949(i3).mo11954(i2).mo11950(this.f3349.mo7131()).mo11953(i).mo11955();
            if (!r17.m11942()) {
                this.f3348 = System.currentTimeMillis();
            }
            vI.m11941(r17);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2183() {
        C1339Bl.m4043(NetflixApplication.getInstance(), "download_badge_clear_time", System.currentTimeMillis());
        m2171();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m2172() {
        return C1339Bl.m4044(NetflixApplication.getInstance(), "download_badge_clear_time", 0);
    }
}
