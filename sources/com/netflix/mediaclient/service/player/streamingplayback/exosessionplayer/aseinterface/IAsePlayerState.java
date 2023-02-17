package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface;

import android.util.Range;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.netflix.mediaclient.service.player.StreamProfileType;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import o.C1349Bv;
import o.C1950ku;
public interface IAsePlayerState {

    public enum AsePlayerState {
        ASE_PLAYER_BUFFERING,
        ASE_PLAYER_PLAYING,
        ASE_PLAYER_PAUSED,
        ASE_PLAYER_ENDED,
        ASE_PLAYER_IDLE
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    long mo1007();

    /* renamed from: ʼ  reason: contains not printable characters */
    Cif[] mo1008();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    C1288iF[] mo1009();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    If mo1010();

    /* renamed from: ᐝ  reason: contains not printable characters */
    AsePlayerState mo1011();

    /* renamed from: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState$iF  reason: case insensitive filesystem */
    public static class C1288iF extends C1950ku {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final DataSpec f1839;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final long f1840;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Format f1841;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f1842;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f1843;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private long f1844;

        public C1288iF(int i, Format format, long j, long j2, String str, DataSpec dataSpec) {
            super(j, j2 - j, dataSpec.position, dataSpec.length);
            this.f1842 = i;
            this.f1841 = format;
            this.f1840 = j2;
            this.f1839 = dataSpec;
            this.f1843 = str;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public long m1016() {
            return this.f1840;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m1019() {
            return this.f1843;
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        public boolean m1014() {
            return this.f1842 == 1;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m1018(DataSpec dataSpec) {
            return dataSpec.length == this.f1839.length && dataSpec.position == this.f1839.position && dataSpec.absoluteStreamPosition == this.f1839.absoluteStreamPosition && C1349Bv.m4126(dataSpec.key, this.f1839.key);
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        public long m1015() {
            return this.f1844;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m1017(long j) {
            this.f1844 = j;
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0013: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.String) */
        @Override // o.C1950ku
        public String toString() {
            Locale locale = Locale.US;
            Object[] objArr = new Object[4];
            objArr[0] = m1014() ? "A" : "V";
            objArr[1] = Integer.valueOf(this.f1841.bitrate);
            objArr[2] = Long.valueOf(TimeUnit.MICROSECONDS.toMillis(m8441()));
            objArr[3] = Long.valueOf(TimeUnit.MICROSECONDS.toMillis(this.f1840));
            return String.format(locale, "%s %6d %6d-%-6d", objArr);
        }
    }

    /* renamed from: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final C1288iF f1845;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final C1288iF[] f1846;

        public Cif(C1288iF[] iFVarArr, C1288iF iFVar) {
            this.f1846 = iFVarArr;
            this.f1845 = iFVar;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C1288iF[] m1020() {
            return this.f1846;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public long m1021(long j) {
            long j2 = 0;
            if (this.f1846 != null && this.f1846.length > 0) {
                j2 = this.f1846[this.f1846.length - 1].m1016() - j;
            }
            if (this.f1845 != null && this.f1845.m1015() > 0 && this.f1845.m8440() > 0) {
                long r6 = this.f1845.m8442();
                j2 = (long) (((double) j2) + (((double) r6) * (((double) this.f1845.m1015()) / ((double) this.f1845.m8440()))));
            }
            return C.usToMs(j2);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public long m1022() {
            long j = 0;
            if (this.f1846 != null) {
                for (C1288iF iFVar : this.f1846) {
                    j += iFVar.m8440();
                }
            }
            if (this.f1845 != null) {
                return j + this.f1845.m1015();
            }
            return j;
        }
    }

    public static class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        private Range<Integer> f1836;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final String f1837;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final StreamProfileType f1838;

        public If(StreamProfileType streamProfileType, String str) {
            this.f1838 = streamProfileType;
            this.f1837 = str;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public Range<Integer> m1013() {
            return this.f1836;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m1012(Range<Integer> range) {
            this.f1836 = range;
        }
    }
}
