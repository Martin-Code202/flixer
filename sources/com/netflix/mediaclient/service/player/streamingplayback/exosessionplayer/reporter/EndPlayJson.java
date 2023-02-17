package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import android.text.TextUtils;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.CurrentNetworkInfo;
import com.netflix.mediaclient.servicemgr.Logblob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.AR;
import o.AbstractC1933kd;
import o.lC;
import o.lX;
public class EndPlayJson extends lC {
    @SerializedName("activitydata")
    private Map<String, Object> activityData;
    @SerializedName("audioSinkType")
    protected String audioSinkType;
    @SerializedName("audiodecoder")
    protected String audiodecoder;
    @SerializedName("avtp")
    protected long averageThroughput;
    @SerializedName("bytesread")
    protected Map<String, Long> bytesread;
    @SerializedName("carrier")
    protected String carrier;
    @SerializedName("cdnavtp")
    protected C0021[] cdnavtp;
    @SerializedName("cdndldist")
    protected List<If> cdnldist;
    @SerializedName("deviceerrorcode")
    protected String deviceErrorCode;
    @SerializedName("deviceerrorstring")
    protected String deviceErrorString;
    @SerializedName("endreason")
    protected EndReason endReason;
    @SerializedName("errorcode")
    protected String errorcode;
    @SerializedName("errorinbuffering")
    protected Boolean errorinbuffering;
    @SerializedName("errormsg")
    protected String errormsg;
    @SerializedName("errorstring")
    protected String errorstring;
    @SerializedName("AndroidDeviceID")
    protected String fesn3;
    @SerializedName("groupname")
    protected String groupname;
    @SerializedName("mcc")
    protected Integer mcc;
    @SerializedName("minconnecttime")
    protected Long minimumTcpConnectTime;
    @SerializedName("mnc")
    protected Integer mnc;
    @SerializedName("mid")
    protected long movieId;
    @SerializedName("networkdist")
    protected C0020[] networkdist;
    @SerializedName("playqualaudio")
    protected aux playqualaudio;
    @SerializedName("playqualvideo")
    protected aux playqualvideo;
    @SerializedName("deviceSerial")
    protected String serial;
    @SerializedName("totaltime")
    protected long totalTimeInSec;
    @SerializedName("videoStreamProfile")
    protected String videoStreamProfile;
    @SerializedName("videodecoder")
    protected String videodecoder;

    public enum EndReason {
        STOPPED,
        ENDED,
        ERROR,
        PLAYING
    }

    protected EndPlayJson() {
        this.cdnldist = new ArrayList();
        this.endReason = EndReason.ENDED;
    }

    protected EndPlayJson(String str, String str2) {
        super(str, str2);
        this.cdnldist = new ArrayList();
        this.endReason = EndReason.ENDED;
        this.serial = AR.m3403();
    }

    public EndPlayJson(String str) {
        this("endplay", str);
    }

    /* access modifiers changed from: protected */
    @Override // o.lC
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo1083() {
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public EndPlayJson m1076(Long l) {
        this.movieId = l.longValue();
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public EndPlayJson m1071(String str) {
        this.fesn3 = str;
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public EndPlayJson m1078(lX lXVar, boolean z) {
        if (lXVar == null) {
            m8546(lC.f8502);
            this.errorcode = null;
            this.errorstring = null;
            this.deviceErrorCode = null;
            this.deviceErrorString = null;
            this.errormsg = null;
            this.errorinbuffering = null;
        } else {
            m8546(Logblob.Severity.error);
            this.errorcode = lXVar.m8715();
            this.errorstring = lXVar.m8712();
            this.deviceErrorCode = lXVar.m8708();
            this.deviceErrorString = lXVar.m8716();
            this.errormsg = lXVar.m8709();
            this.endReason = EndReason.ERROR;
            this.errorinbuffering = Boolean.valueOf(z);
        }
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public EndPlayJson m1066(EndReason endReason2) {
        this.endReason = endReason2;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public EndPlayJson m1065(CurrentNetworkInfo currentNetworkInfo) {
        this.carrier = currentNetworkInfo.m1038();
        this.mcc = currentNetworkInfo.m1037();
        this.mnc = currentNetworkInfo.m1041();
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public EndPlayJson m1080(long j) {
        super.m8545(j);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public EndPlayJson m1075(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public EndPlayJson m1064(long j) {
        this.totalTimeInSec = j / 1000;
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1079(int i, AbstractC1933kd.iF iFVar, long j) {
        If r1 = null;
        Iterator<If> it = this.cdnldist.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            If next = it.next();
            if (next.cdnid == i) {
                r1 = next;
                break;
            }
        }
        if (r1 == null) {
            r1 = new If(i);
            this.cdnldist.add(r1);
        }
        r1.m1084(iFVar, j);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public EndPlayJson m1068(DecoderCounters decoderCounters) {
        this.playqualvideo = new aux(decoderCounters);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public EndPlayJson m1081(String str) {
        this.videodecoder = str;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public EndPlayJson m1070(DecoderCounters decoderCounters) {
        this.playqualaudio = new aux(decoderCounters);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public EndPlayJson m1077(String str) {
        this.audiodecoder = str;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public EndPlayJson m1073(C0020[] r1) {
        this.networkdist = r1;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public EndPlayJson m1074(C0021[] r1) {
        this.cdnavtp = r1;
        return this;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public EndPlayJson m1062(long j) {
        this.averageThroughput = j;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public EndPlayJson m1072(Map<String, Long> map) {
        this.bytesread = map;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public EndPlayJson m1067(String str) {
        this.audioSinkType = str;
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public EndPlayJson m1069(String str) {
        if (TextUtils.isEmpty(str)) {
            this.groupname = "control";
        } else {
            this.groupname = str;
        }
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public EndPlayJson m1082(Map<String, Object> map) {
        this.activityData = map;
        return this;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public EndPlayJson m1063(String str) {
        this.videoStreamProfile = str;
        return this;
    }

    /* renamed from: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.EndPlayJson$ˋ  reason: contains not printable characters */
    public static class C0021 {
        @SerializedName("avtp")
        protected Long avtp;
        @SerializedName("cdnid")
        protected Integer cdnid;
        @SerializedName("tm")
        protected Long tm;

        public C0021(int i, long j, long j2) {
            this.cdnid = Integer.valueOf(i);
            this.avtp = Long.valueOf(j);
            this.tm = Long.valueOf(j2);
        }
    }

    public static class If {
        @SerializedName("cdnid")
        protected int cdnid;
        @SerializedName("dls")
        protected List<C1289iF> dls = new ArrayList();

        public If(int i) {
            this.cdnid = i;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m1084(AbstractC1933kd.iF iFVar, long j) {
            C1289iF iFVar2 = null;
            Iterator<C1289iF> it = this.dls.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1289iF next = it.next();
                if (TextUtils.equals(next.dlid, iFVar.f8380)) {
                    iFVar2 = next;
                    break;
                }
            }
            if (iFVar2 == null) {
                iFVar2 = new C1289iF(iFVar);
                this.dls.add(iFVar2);
            }
            iFVar2.tm += j;
        }
    }

    /* renamed from: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.EndPlayJson$iF  reason: case insensitive filesystem */
    public static class C1289iF {
        @SerializedName("bitrate")
        protected long bitrate;
        @SerializedName("dlid")
        protected String dlid;
        @SerializedName("tm")
        protected long tm;

        public C1289iF(AbstractC1933kd.iF iFVar) {
            this.dlid = iFVar.f8380;
            this.bitrate = iFVar.f8379 / 1000;
        }
    }

    /* renamed from: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.EndPlayJson$ˊ  reason: contains not printable characters */
    public static class C0020 {
        @SerializedName("dist")
        protected Cif[] dist;
        @SerializedName("nettype")
        protected CurrentNetworkInfo.NetType nettype;

        public C0020(CurrentNetworkInfo.NetType netType, Cif[] ifVarArr) {
            this.nettype = netType;
            this.dist = ifVarArr;
        }
    }

    /* renamed from: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.EndPlayJson$if  reason: invalid class name */
    public static class Cif {
        @SerializedName("bytes")
        protected Long bytes;
        @SerializedName("netspec")
        protected CurrentNetworkInfo.NetSpec netspec;
        @SerializedName("tm")
        protected Long tm;

        public Cif(CurrentNetworkInfo.NetSpec netSpec, long j, long j2) {
            this.netspec = netSpec;
            this.tm = Long.valueOf(j);
            this.bytes = Long.valueOf(j2);
        }
    }

    public static class aux {
        @SerializedName("maxcontinousrendrop")
        protected Integer maxContinuousRendererDrop;
        @SerializedName("numdec")
        protected Integer numFramesDecoded;
        @SerializedName("numrendrop")
        protected Integer numFramesDecodedButNotRendered;
        @SerializedName("numren")
        protected Integer numFramesRendered;
        @SerializedName("numskip")
        protected Integer numFramesSkippedAndNotDecoded;

        public aux(DecoderCounters decoderCounters) {
            if (decoderCounters != null) {
                decoderCounters.ensureUpdated();
                this.maxContinuousRendererDrop = Integer.valueOf(decoderCounters.maxConsecutiveDroppedOutputBufferCount);
                this.numFramesSkippedAndNotDecoded = Integer.valueOf(decoderCounters.skippedOutputBufferCount);
                this.numFramesDecodedButNotRendered = Integer.valueOf(decoderCounters.droppedOutputBufferCount);
                this.numFramesRendered = Integer.valueOf(decoderCounters.renderedOutputBufferCount);
                this.numFramesDecoded = Integer.valueOf(decoderCounters.inputBufferCount);
            }
        }
    }
}
