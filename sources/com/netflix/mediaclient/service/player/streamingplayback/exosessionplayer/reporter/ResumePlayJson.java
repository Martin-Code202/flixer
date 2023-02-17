package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.CurrentNetworkInfo;
import o.AbstractC1952kz;
import o.lC;
public class ResumePlayJson extends lC {
    @SerializedName("actualbt")
    protected Long actualbt;
    @SerializedName("actualbw")
    protected Long actualbw;
    @SerializedName("adlid")
    protected String adlid;
    @SerializedName("abitrate")
    protected Integer audioBitrate;
    @SerializedName("brokendlid")
    protected Long brokendlid;
    @SerializedName("carrier")
    protected String carrier;
    @SerializedName("cdnid")
    protected String cdnid;
    @SerializedName("cdnname")
    protected String cdnname;
    @SerializedName("deviceerrorstring")
    protected String deviceErrorString;
    @SerializedName("deviceerrorcode")
    protected String deviceerrorcode;
    @SerializedName("errorcode")
    protected String errorcode;
    @SerializedName("errormsg")
    protected String errormsg;
    @SerializedName("errorstring")
    protected String errorstring;
    @SerializedName("groupname")
    protected String groupname;
    @SerializedName("httperr")
    protected Long httperr;
    @SerializedName("mcc")
    protected Integer mcc;
    @SerializedName("mnc")
    protected Integer mnc;
    @SerializedName("mid")
    protected Long movieId;
    @SerializedName("nccperr")
    protected Long nccperr;
    @SerializedName("netspec")
    protected CurrentNetworkInfo.NetSpec netspec;
    @SerializedName("nettype")
    protected CurrentNetworkInfo.NetType nettype;
    @SerializedName("nwerr")
    protected NetworkErrorJson nwerr;
    @SerializedName("playdelay")
    protected Long playdelay;
    @SerializedName("reason")
    protected Reason reason;
    @SerializedName("vdlid")
    protected String vdlId;
    @SerializedName("vbitrate")
    protected Integer videoBitrate;

    public enum Reason {
        REPOS,
        REBUFFER,
        SKIP
    }

    protected ResumePlayJson() {
    }

    public ResumePlayJson(String str) {
        super("resumeplay", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public ResumePlayJson m1115(Long l) {
        this.movieId = l;
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public ResumePlayJson m1116(long j) {
        super.m8545(j);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public ResumePlayJson m1117(Long l) {
        this.playdelay = l;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public ResumePlayJson m1114(AbstractC1952kz.If r7) {
        if (r7 != null) {
            this.cdnid = Integer.toString(r7.f8472);
            AbstractC1952kz.C0141[] r2 = r7.f8467;
            int length = r2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AbstractC1952kz.C0141 r5 = r2[i];
                if (this.cdnid.equals(r5.f8480)) {
                    this.cdnname = r5.f8483;
                    break;
                }
                i++;
            }
        }
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ResumePlayJson m1111(Long l) {
        this.actualbw = l;
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public ResumePlayJson m1112(Long l) {
        this.actualbt = l;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ResumePlayJson m1110(CurrentNetworkInfo currentNetworkInfo) {
        this.carrier = currentNetworkInfo.m1038();
        this.mcc = currentNetworkInfo.m1037();
        this.mnc = currentNetworkInfo.m1041();
        this.nettype = currentNetworkInfo.m1039();
        this.netspec = currentNetworkInfo.m1040();
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ResumePlayJson m1109(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public ResumePlayJson m1113(Reason reason2) {
        this.reason = reason2;
        return this;
    }
}
