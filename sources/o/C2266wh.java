package o;

import android.content.Context;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.Subtitle;
import java.util.Arrays;
/* renamed from: o.wh  reason: case insensitive filesystem */
public class C2266wh {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AudioSource[] f11609;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Subtitle[] f11610;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AudioSubtitleDefaultOrderInfo[] f11611;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AudioSource f11612;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Subtitle f11613;

    public C2266wh(Context context, Subtitle[] subtitleArr, AudioSource[] audioSourceArr, AudioSubtitleDefaultOrderInfo[] audioSubtitleDefaultOrderInfoArr, boolean z) {
        m12428(subtitleArr, audioSourceArr, audioSubtitleDefaultOrderInfoArr, z ? C1355Ca.m4334(C1355Ca.m4327(context), subtitleArr, audioSourceArr, audioSubtitleDefaultOrderInfoArr) : null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12428(Subtitle[] subtitleArr, AudioSource[] audioSourceArr, AudioSubtitleDefaultOrderInfo[] audioSubtitleDefaultOrderInfoArr, AN an) {
        AudioSource.dumpLog(audioSourceArr, "nf-l10n");
        C1984mo.m9060(subtitleArr, "nf-l10n");
        AudioSubtitleDefaultOrderInfo.dumpLog(audioSubtitleDefaultOrderInfoArr, "nf-l10n");
        if (subtitleArr == null) {
            this.f11610 = new Subtitle[0];
        } else {
            Arrays.sort(subtitleArr);
            C1984mo.m9060(subtitleArr, "nf-l10n");
            this.f11610 = subtitleArr;
        }
        if (audioSourceArr == null) {
            this.f11609 = new AudioSource[0];
        } else {
            Arrays.sort(audioSourceArr);
            AudioSource.dumpLog(audioSourceArr, "nf-l10n");
            this.f11609 = audioSourceArr;
        }
        if (audioSubtitleDefaultOrderInfoArr == null) {
            this.f11611 = new AudioSubtitleDefaultOrderInfo[0];
        } else {
            Arrays.sort(audioSubtitleDefaultOrderInfoArr);
            AudioSubtitleDefaultOrderInfo.dumpLog(audioSubtitleDefaultOrderInfoArr, "nf-l10n");
            this.f11611 = audioSubtitleDefaultOrderInfoArr;
        }
        if (an != null) {
            if (an.m3395() != null) {
                this.f11613 = m12425(an.m3395().getId());
            } else {
                C1283.m16854("nf-l10n", "User choice for subtitle did not existed!");
            }
            if (an.m3394() != null) {
                this.f11612 = m12426(an.m3394().getId());
            } else {
                C1283.m16854("nf-l10n", "User choice for audio did not existed!");
            }
        } else {
            C1283.m16854("nf-l10n", "User choice for audio AND subtitle did not existed!");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public AN m12429() {
        if (this.f11613 != null) {
            C1283.m16854("nf-l10n", "We found user preference for subtitle!");
        }
        if (this.f11612 != null) {
            if (this.f11613 == null) {
                C1283.m16854("nf-l10n", "No user preferences for subtitle.");
            }
            if (this.f11612.isAllowedSubtitle(this.f11613)) {
                C1283.m16854("nf-l10n", "Using user preference for language");
                return new AN(this.f11613, this.f11612);
            }
            C1283.m16854("nf-l10n", "Using user preference is not allowed, go for NCCP default");
            return new AN(m12427(), m12424());
        }
        C1283.m16854("nf-l10n", "No user preference for audio!");
        AudioSource r3 = m12424();
        if (r3 == null) {
            C1283.m16850("nf-l10n", "Initial audio not found!");
            return new AN(null, null);
        } else if (this.f11613 == null) {
            C1283.m16854("nf-l10n", "No user preferences for audio and subtitle. Use NCCP defaults.");
            return new AN(m12427(), r3);
        } else if (r3.isAllowedSubtitle(this.f11613)) {
            C1283.m16854("nf-l10n", "Using user preference for language");
            return new AN(this.f11613, r3);
        } else {
            C1283.m16854("nf-l10n", "Using user preference is not allowed, go for NCCP default");
            return new AN(m12427(), r3);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private Subtitle m12427() {
        if (this.f11610.length < 1) {
            return null;
        }
        if (this.f11611.length < 1) {
            C1283.m16865("nf-l10n", "No defaults found. No subtitles.");
            return null;
        }
        String subtitleTrackId = this.f11611[0].getSubtitleTrackId();
        if (subtitleTrackId == null || "none".equalsIgnoreCase(subtitleTrackId) || "".equals(subtitleTrackId)) {
            return null;
        }
        Subtitle r4 = m12425(subtitleTrackId);
        if (r4 == null) {
            C1283.m16850("nf-l10n", "Default exist: " + subtitleTrackId + ", but soubtitle with it not found!");
        }
        return r4;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private AudioSource m12424() {
        if (this.f11609.length < 1) {
            C1283.m16865("nf-l10n", "No audio source found!");
            return null;
        } else if (this.f11611.length < 1) {
            C1283.m16854("nf-l10n", "No defaults found. Return null to keep initial audio source.");
            return null;
        } else {
            String audioTrackId = this.f11611[0].getAudioTrackId();
            if (audioTrackId == null) {
                C1283.m16850("nf-l10n", "Audio source track id is NULL for default: " + this.f11611[0]);
                return null;
            }
            AudioSource r5 = m12426(audioTrackId);
            if (r5 == null) {
                C1283.m16850("nf-l10n", "Default exist: " + audioTrackId + ", but source with it not found!");
            }
            return r5;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private AudioSource m12426(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Audio track id can NOT be null!");
        }
        for (int i = 0; i < this.f11609.length; i++) {
            if (str.equals(this.f11609[i].getId())) {
                return this.f11609[i];
            }
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Subtitle m12425(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Subtitle id can NOT be null!");
        }
        for (int i = 0; i < this.f11610.length; i++) {
            if (str.equals(this.f11610[i].getId())) {
                return this.f11610[i];
            }
        }
        return null;
    }
}
