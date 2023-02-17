package o;

import android.content.Context;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.PlayerManifestData;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import com.netflix.mediaclient.service.offline.download.DownloadableType;
import java.util.List;
import o.AbstractC1897iy;
import o.C1355Ca;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ia  reason: case insensitive filesystem */
public class C1874ia implements AbstractC1897iy.If {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f7685;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final Long f7686;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AudioSubtitleDefaultOrderInfo[] f7687;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f7688;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f7689;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final C1618cl f7690;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AudioSource[] f7691;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final PlayerManifestData f7692;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final DashManifest f7693;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final byte[] f7694;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final JSONObject f7695;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Watermark f7696;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Subtitle[] f7697;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final JSONObject f7698;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final byte[] f7699;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final Context f7700;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final List<VideoTrack> f7701;

    public C1874ia(Context context, String str, jG jGVar, byte[] bArr, String str2, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str3, String str4, C1618cl clVar) {
        this.f7700 = context;
        this.f7694 = bArr;
        this.f7688 = str3;
        this.f7685 = str4;
        this.f7691 = C1889iq.m7723(jGVar, list);
        this.f7701 = C1889iq.m7731(jGVar, list2);
        this.f7697 = C1889iq.m7724(jGVar, list3, str);
        if (list4.size() > 0) {
            this.f7689 = C1888ip.m7720(str, list4.get(0), DownloadableType.TrickPlay);
        } else {
            this.f7689 = null;
        }
        this.f7687 = jGVar.m7928();
        String str5 = null;
        if (this.f7687 != null && this.f7687.length > 0) {
            str5 = jJ.m7941(jGVar, m7627(false));
        }
        hU hUVar = new hU(str, jGVar, list, list2, str5);
        this.f7698 = jGVar.mo7915();
        this.f7690 = clVar;
        this.f7693 = hUVar.m6982();
        this.f7696 = jGVar.m7918();
        this.f7692 = jGVar.m7930();
        this.f7699 = jGVar.m7935();
        this.f7695 = m7626(str2);
        this.f7686 = jGVar.m7933();
        m7625();
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ˊ  reason: contains not printable characters */
    public Subtitle mo7631() {
        String r1 = m7627(true);
        Subtitle[] subtitleArr = this.f7697;
        for (Subtitle subtitle : subtitleArr) {
            if (subtitle.getId().equals(r1)) {
                return subtitle;
            }
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m7627(boolean z) {
        C1355Ca.Cif r5 = C1355Ca.m4327(this.f7700);
        if (r5 == null) {
            return z ? this.f7687[0].getSubtitleTrackId() : this.f7687[0].getAudioTrackId();
        }
        AN r6 = C1355Ca.m4334(r5, mo7639(), mo7636(), mo7633());
        if (r6 == null || r6.m3394() == null) {
            C1283.m16865("nf_offline_manifest", "Unable to find user forced audio, use default one");
            return z ? this.f7687[0].getSubtitleTrackId() : this.f7687[0].getAudioTrackId();
        }
        C1283.m16851("nf_offline_manifest", "Found forced audio, use it %s", r6.m3394().getId());
        Subtitle r7 = r6.m3395();
        if (!z) {
            return r6.m3394().getId();
        }
        if (r7 == null) {
            return null;
        }
        return r7.getId();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m7625() {
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ˎ  reason: contains not printable characters */
    public Object mo7635() {
        return this.f7693;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ˏ  reason: contains not printable characters */
    public AudioSource[] mo7636() {
        return this.f7691;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ॱ  reason: contains not printable characters */
    public Subtitle[] mo7639() {
        return this.f7697;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ˋ  reason: contains not printable characters */
    public AudioSubtitleDefaultOrderInfo[] mo7633() {
        return this.f7687;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ʻ  reason: contains not printable characters */
    public PlayerManifestData mo7628() {
        return this.f7692;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ʼ  reason: contains not printable characters */
    public String mo7629() {
        return this.f7689;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public byte[] mo7642() {
        return this.f7694;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ʽ  reason: contains not printable characters */
    public JSONObject mo7630() {
        return this.f7695;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ᐝ  reason: contains not printable characters */
    public byte[] mo7643() {
        return this.f7699;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ͺ  reason: contains not printable characters */
    public List<VideoTrack> mo7638() {
        return this.f7701;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public String mo7637() {
        return this.f7688;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public String mo7632() {
        return this.f7685;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public Watermark mo7640() {
        return this.f7696;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public Long mo7634() {
        return this.f7686;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public JSONObject mo7641() {
        return this.f7698;
    }

    @Override // o.AbstractC1897iy.If
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public C1618cl mo7644() {
        return this.f7690;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private JSONObject m7626(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C1283.m16847("nf_offline_manifest", "convertLicense link is malformed", e);
            return null;
        }
    }
}
