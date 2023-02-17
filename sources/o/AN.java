package o;

import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.Subtitle;
public final class AN {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Subtitle f4286;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AudioSource f4287;

    public AN(Subtitle subtitle, AudioSource audioSource) {
        this.f4286 = subtitle;
        this.f4287 = audioSource;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Subtitle m3395() {
        return this.f4286;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public AudioSource m3394() {
        return this.f4287;
    }

    public String toString() {
        return "LanguageChoice [subtitle=" + this.f4286 + ", audio=" + this.f4287 + "]";
    }
}
