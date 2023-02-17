package o;

import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
/* renamed from: o.wu  reason: case insensitive filesystem */
public class C2279wu {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f11702;

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f11703;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f11704;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC2055pd f11705;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f11706;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final oX f11707;

    /* renamed from: ˎ  reason: contains not printable characters */
    private IPlayer.PlaybackType f11708;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final VideoType f11709;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f11710;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f11711;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f11712;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f11713;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private pF f11714;

    public C2279wu(pF pFVar, VideoType videoType, oX oXVar, int i) {
        this(pFVar, videoType, oXVar, i, AbstractC2055pd.f9383);
    }

    public C2279wu(pF pFVar, VideoType videoType, oX oXVar, int i, AbstractC2055pd pdVar) {
        this.f11708 = IPlayer.PlaybackType.StreamingPlayback;
        this.f11704 = -1;
        this.f11703 = -1;
        this.f11710 = false;
        this.f11712 = false;
        this.f11711 = pFVar.getPlayableId();
        this.f11709 = videoType;
        this.f11707 = oXVar;
        this.f11714 = pFVar;
        this.f11713 = i;
        this.f11713 = this.f11713 != -1 ? this.f11713 : this.f11714.getPlayableBookmarkPosition();
        this.f11703 = (long) (this.f11714.getRuntime() * 1000);
        this.f11704 = (long) (this.f11714.getEndtime() * 1000);
        if (this.f11704 < this.f11703 / 2 || this.f11704 > this.f11703) {
            this.f11704 = this.f11703;
        }
        this.f11705 = pdVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m12555() {
        return this.f11713;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m12548() {
        return this.f11703;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public IPlayer.PlaybackType m12556() {
        return this.f11708;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m12560() {
        return this.f11704;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m12554() {
        return this.f11702;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12553(boolean z) {
        this.f11702 = z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12552(IPlayer.PlaybackType playbackType) {
        this.f11708 = playbackType;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public VideoType m12546() {
        return this.f11709;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public oX m12563() {
        return this.f11707;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m12547() {
        return this.f11714 != null;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public pF m12545() {
        return this.f11714;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12551(int i) {
        this.f11713 = i;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m12562() {
        return this.f11711;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean m12559() {
        return this.f11710;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12549(boolean z) {
        this.f11710 = z;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean m12550() {
        return this.f11706;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12557(boolean z) {
        this.f11706 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12561(boolean z) {
        this.f11712 = z;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public AbstractC2055pd m12558() {
        return this.f11705;
    }
}
