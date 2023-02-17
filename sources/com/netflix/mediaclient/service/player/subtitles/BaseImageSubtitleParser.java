package com.netflix.mediaclient.service.player.subtitles;

import android.os.Handler;
import com.netflix.mediaclient.media.SubtitleUrl;
import o.AbstractC1970ma;
import o.AbstractC1977mh;
import o.AbstractC1979mj;
import o.AbstractC1981ml;
import o.AbstractC2055pd;
import o.C1283;
public abstract class BaseImageSubtitleParser extends AbstractC1970ma {

    /* renamed from: ʽ  reason: contains not printable characters */
    protected boolean f1974 = true;

    /* renamed from: ˊ  reason: contains not printable characters */
    private StreamingSubtitleState f1975;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected String f1976;

    /* renamed from: ॱ  reason: contains not printable characters */
    public long f1977;

    /* renamed from: ʻ  reason: contains not printable characters */
    public abstract String mo1134();

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void mo1136(int i);

    public enum StreamingSubtitleState {
        UNLOADED(0, "SUBTITLE_NOTREADY"),
        STREAMING(1, "SUBTITLE_STREAMING"),
        STALLED(2, "SUBTITLE_STALLED");
        

        /* renamed from: ˋ  reason: contains not printable characters */
        int f1982;

        /* renamed from: ˏ  reason: contains not printable characters */
        String f1983;

        private StreamingSubtitleState(int i, String str) {
            this.f1982 = i;
            this.f1983 = str;
        }
    }

    public BaseImageSubtitleParser(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, SubtitleUrl subtitleUrl, long j, AbstractC1979mj.iF iFVar, long j2, long j3, AbstractC2055pd pdVar) {
        super(handler, mhVar, mlVar, subtitleUrl, iFVar, j2, j3, pdVar);
        this.f1977 = j;
        this.f1975 = StreamingSubtitleState.UNLOADED;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1139(int i) {
        mo1136(i);
        mo1136(i + 1);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo1138(String str, byte[] bArr) {
        try {
            this.f8872.mo7759().mo7412(this.f1976, str, bArr);
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "Failed to save " + str, th);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public StreamingSubtitleState m1135() {
        return this.f1975;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1137(StreamingSubtitleState streamingSubtitleState) {
        this.f1975 = streamingSubtitleState;
    }
}
