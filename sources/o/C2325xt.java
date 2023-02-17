package o;

import com.netflix.mediaclient.ui.player.pivots.PivotsUIView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: o.xt  reason: case insensitive filesystem */
public final class C2325xt extends AbstractC0409<C2325xt> {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0296 f12255 = new C0296(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final PivotsUIView.PivotsListAssetType f12256;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final List<CH> f12257;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f12258;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean f12259;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final PivotsUIView.PivotsListVisibility f12260;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean f12261;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final boolean f12262;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final CH f12263;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int f12264;

    public C2325xt() {
        this(false, null, false, false, null, null, null, 0, false, 511, null);
    }

    public C2325xt(boolean z, PivotsUIView.PivotsListVisibility pivotsListVisibility, boolean z2, boolean z3, List<CH> list, PivotsUIView.PivotsListAssetType pivotsListAssetType, CH ch, int i, boolean z4) {
        C1457Fr.m5025(pivotsListVisibility, "visibility");
        C1457Fr.m5025(list, "videoList");
        C1457Fr.m5025(pivotsListAssetType, "listAssetType");
        this.f12259 = z;
        this.f12260 = pivotsListVisibility;
        this.f12261 = z2;
        this.f12262 = z3;
        this.f12257 = list;
        this.f12256 = pivotsListAssetType;
        this.f12263 = ch;
        this.f12264 = i;
        this.f12258 = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2325xt(boolean z, PivotsUIView.PivotsListVisibility pivotsListVisibility, boolean z2, boolean z3, List list, PivotsUIView.PivotsListAssetType pivotsListAssetType, CH ch, int i, boolean z4, int i2, C1456Fq fq) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? PivotsUIView.PivotsListVisibility.SHOW : pivotsListVisibility, (i2 & 4) != 0 ? true : z2, (i2 & 8) != 0 ? true : z3, (i2 & 16) != 0 ? new ArrayList() : list, (i2 & 32) != 0 ? PivotsUIView.PivotsListAssetType.HORIZONTAL_BOX_ART : pivotsListAssetType, (i2 & 64) != 0 ? null : ch, (i2 & 128) != 0 ? -1 : i, (i2 & 256) != 0 ? false : z4);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final boolean m12993() {
        return this.f12259;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final PivotsUIView.PivotsListVisibility m12995() {
        return this.f12260;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final boolean m12996() {
        return this.f12261;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final boolean m12998() {
        return this.f12262;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final List<CH> m12994() {
        return this.f12257;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final PivotsUIView.PivotsListAssetType m12991() {
        return this.f12256;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final CH m13000() {
        return this.f12263;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final int m12999() {
        return this.f12264;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final boolean m12992() {
        return this.f12258;
    }

    /* renamed from: o.xt$ˋ  reason: contains not printable characters */
    public static final class C0296 {
        private C0296() {
        }

        public /* synthetic */ C0296(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int compareTo(AbstractC0409<C2325xt> r3) {
        C1457Fr.m5025(r3, "other");
        C2325xt xtVar = (C2325xt) r3;
        if (this.f12259 == ((C2325xt) r3).f12259 && !(!C1457Fr.m5018(this.f12260, ((C2325xt) r3).f12260)) && this.f12261 == ((C2325xt) r3).f12261 && this.f12262 == ((C2325xt) r3).f12262 && !(!C1457Fr.m5018(this.f12257, ((C2325xt) r3).f12257)) && !(!C1457Fr.m5018(this.f12256, ((C2325xt) r3).f12256)) && !(!C1457Fr.m5018(this.f12263, ((C2325xt) r3).f12263)) && this.f12264 == ((C2325xt) r3).f12264 && this.f12258 == ((C2325xt) r3).f12258) {
            return 0;
        }
        return -1;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof C2325xt) && compareTo((AbstractC0409) obj) == 0;
    }

    @Override // java.lang.Object
    public String toString() {
        Object[] objArr = {Boolean.valueOf(this.f12259), this.f12260, Boolean.valueOf(this.f12261), Boolean.valueOf(this.f12262), Integer.valueOf(this.f12257.size()), this.f12256.toString(), this.f12263, Integer.valueOf(this.f12264)};
        int length = objArr.length;
        String format = String.format("PivotsUIState --> enable: %s, visibility: %s, showButton: %s, showBottomPanelButtons: %s, videoListSize: %s, listAssetType: %s, nextEpisode: %s, postPlayTimer: %s", Arrays.copyOf(objArr, 8));
        C1457Fr.m5016((Object) format, "java.lang.String.format(this, *args)");
        return format;
    }
}
