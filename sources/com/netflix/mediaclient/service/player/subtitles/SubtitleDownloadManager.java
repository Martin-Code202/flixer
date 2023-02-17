package com.netflix.mediaclient.service.player.subtitles;

import android.os.Handler;
import com.netflix.mediaclient.media.SubtitleTrackData;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import o.AbstractC1221;
import o.AbstractC1370Co;
import o.AbstractC1977mh;
import o.AbstractC1979mj;
import o.AbstractC1981ml;
import o.AbstractC2055pd;
import o.C1283;
import o.C1349Bv;
import o.C1375Cr;
import o.C1980mk;
import o.C1986mq;
import o.mP;
public class SubtitleDownloadManager implements AbstractC1979mj.iF {

    /* renamed from: ʻ  reason: contains not printable characters */
    private float f1990;

    /* renamed from: ʼ  reason: contains not printable characters */
    private AbstractC1981ml f1991;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Handler f1992;

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC1221 f1993;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C1986mq f1994 = new C1986mq();

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1977mh f1995;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private long f1996;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1979mj f1997;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f1998;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private long f1999;

    /* renamed from: ͺ  reason: contains not printable characters */
    private AbstractC1370Co f2000;

    /* renamed from: ॱ  reason: contains not printable characters */
    private UserAgentInterface f2001;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private AbstractC2055pd f2002;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private SubtitleTrackData f2003;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private SubtitleUrl f2004;

    /* access modifiers changed from: package-private */
    public enum DownloadPolicy {
        downloading,
        canNotDownload,
        retry
    }

    public SubtitleDownloadManager(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, AbstractC1221 r6, UserAgentInterface userAgentInterface, long j, AbstractC2055pd pdVar) {
        if (mhVar == null) {
            throw new IllegalArgumentException("Player is null!");
        } else if (r6 == null) {
            throw new IllegalArgumentException("Config is null!");
        } else if (handler == null) {
            throw new IllegalArgumentException("Handler is null!");
        } else if (userAgentInterface == null) {
            throw new IllegalArgumentException("User is null!");
        } else {
            this.f2000 = m1144(r6);
            this.f1995 = mhVar;
            this.f2001 = userAgentInterface;
            this.f1993 = r6;
            this.f1992 = handler;
            this.f1998 = j;
            this.f2002 = pdVar;
            if (this.f2002.mo9712()) {
                this.f1991 = mlVar;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m1149(SubtitleTrackData subtitleTrackData, float f, long j, long j2, boolean z) {
        this.f1990 = f;
        this.f1996 = j;
        this.f1999 = j2;
        m1142(z);
        if (subtitleTrackData != null) {
            if (!m1143(subtitleTrackData)) {
                if (this.f2002.mo9712() && this.f1991 != null) {
                    this.f1991.mo910();
                }
                this.f1997 = null;
                return;
            }
            this.f2003 = subtitleTrackData;
            this.f2000 = m1144(this.f1993);
            m1145();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized AbstractC1979mj m1147() {
        return this.f1997;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private DownloadPolicy m1145() {
        SubtitleTrackData subtitleTrackData = this.f2003;
        if (subtitleTrackData == null) {
            return DownloadPolicy.canNotDownload;
        }
        this.f2004 = subtitleTrackData.pop();
        if (this.f2004 == null) {
            C1283.m16854("nf_subtitles", "We tried all URLs, see if we should retry from start...");
            if (!this.f2000.mo4514()) {
                C1283.m16854("nf_subtitles", "We can not retry again...");
                return DownloadPolicy.canNotDownload;
            }
            long r16 = this.f2000.mo4515();
            this.f2003.reset();
            this.f1992.postDelayed(new Runnable() { // from class: com.netflix.mediaclient.service.player.subtitles.SubtitleDownloadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    C1283.m16854("nf_subtitles", "Execute retry...");
                    SubtitleDownloadManager.this.m1145();
                }
            }, r16);
            return DownloadPolicy.retry;
        }
        this.f1997 = C1980mk.m9036(this.f1992, this.f1995, this.f1991, this.f2004, mP.m8863(this.f2001.mo1377()), mP.m8863(this.f2001.mo1378()), this.f1990, this.f1996, this.f1998, this, this.f1999, this.f2002);
        this.f1997.mo7692();
        return DownloadPolicy.downloading;
    }

    @Override // o.AbstractC1979mj.iF
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized boolean mo1148(SubtitleUrl subtitleUrl, ISubtitleDef.SubtitleFailure subtitleFailure, String str) {
        if (this.f2004 != subtitleUrl) {
            return false;
        }
        C1283.m16854("nf_subtitles", "Failed to download current subtitle, go for next...");
        DownloadPolicy r2 = m1145();
        if (r2 == DownloadPolicy.downloading) {
            C1283.m16854("nf_subtitles", "Parser created...");
            return true;
        } else if (r2 == DownloadPolicy.retry) {
            C1283.m16854("nf_subtitles", "Will retry download...");
            return true;
        } else {
            C1283.m16850("nf_subtitles", "We failed all available links, report final failure!");
            return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private synchronized void m1142(boolean z) {
        if (z) {
            AbstractC1979mj r5 = m1147();
            if (r5 != null) {
                int r6 = r5.mo8737();
                int r7 = r5.mo8727();
                SubtitleUrl E_ = r5.E_();
                String str = "";
                if (E_ != null) {
                    String downloadableId = E_.getDownloadableId();
                    if (C1349Bv.m4107(downloadableId)) {
                        str = downloadableId;
                    }
                }
                C1283.m16851("nf_subtitles", "QoE: for subtitle %s we where expected to show %d and we showed %d subtitles.", str, Integer.valueOf(r6), Integer.valueOf(r7));
                this.f1994.m9063(str, r6, r7);
            } else {
                C1283.m16865("nf_subtitles", "Parser is null, nothing to report!");
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C1375Cr m1144(AbstractC1221 r9) {
        SubtitleDownloadRetryPolicy r8 = r9.mo16528();
        return new C1375Cr(r8.getInitialIntervalInMs(), r8.getRandomizationFactor(), r8.getMultiplier(), r8.getMaxIntervalInMs(), r8.getMaxElapsedTimeInMs());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m1143(SubtitleTrackData subtitleTrackData) {
        return subtitleTrackData.getUrls().size() != 0;
    }
}
