package o;

import com.netflix.mediaclient.service.player.subtitles.SizeMapping;
import com.netflix.mediaclient.service.player.subtitles.text.CharacterEdgeTypeMapping;
import com.netflix.mediaclient.service.player.subtitles.text.ColorMapping;
import com.netflix.mediaclient.service.player.subtitles.text.FontFamilyMapping;
import com.netflix.mediaclient.service.player.subtitles.text.FontWeight;
import com.netflix.mediaclient.service.player.subtitles.text.HorizontalAlignment;
import com.netflix.mediaclient.service.player.subtitles.text.OpacityMapping;
import com.netflix.mediaclient.service.player.subtitles.text.VerticalAlignment;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitlePreference;
import org.w3c.dom.Element;
public class mP {

    /* renamed from: ʻ  reason: contains not printable characters */
    private Boolean f8745;

    /* renamed from: ʼ  reason: contains not printable characters */
    private FontFamilyMapping f8746;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Boolean f8747;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f8748;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Float f8749;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f8750;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private Float f8751;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f8752;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f8753;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Float f8754;

    /* renamed from: ͺ  reason: contains not printable characters */
    private lZ f8755;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f8756;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private FontWeight f8757;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private HorizontalAlignment f8758;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private mN f8759;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private mO f8760;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private VerticalAlignment f8761;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Integer f8762;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private lZ f8763;

    public mP() {
    }

    public mP(String str, String str2, String str3, String str4, Integer num, mO mOVar, FontFamilyMapping fontFamilyMapping, Boolean bool, Boolean bool2, FontWeight fontWeight, Float f, Float f2, Float f3) {
        this.f8756 = str;
        this.f8750 = str2;
        this.f8752 = str3;
        this.f8748 = str4;
        this.f8762 = num;
        this.f8760 = mOVar;
        this.f8746 = fontFamilyMapping;
        this.f8747 = bool;
        this.f8757 = fontWeight;
        this.f8745 = bool2;
        this.f8751 = f;
        this.f8749 = f2;
        this.f8754 = f3;
    }

    public mP(mP mPVar) {
        if (mPVar == null) {
            throw new IllegalArgumentException("Copy constructor must have object to work with, Null passed!");
        }
        this.f8756 = mPVar.f8756;
        this.f8753 = mPVar.f8753;
        this.f8750 = mPVar.f8750;
        this.f8752 = mPVar.f8752;
        this.f8748 = mPVar.f8748;
        this.f8762 = mPVar.f8762;
        this.f8760 = mPVar.f8760;
        this.f8746 = mPVar.f8746;
        this.f8747 = mPVar.f8747;
        this.f8745 = mPVar.f8745;
        this.f8751 = mPVar.f8751;
        this.f8749 = mPVar.f8749;
        this.f8754 = mPVar.f8754;
        this.f8757 = mPVar.f8757;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static mP m8865(Element element, mT mTVar, mP mPVar) {
        if (element == null) {
            throw new IllegalArgumentException("Element can not be null!");
        } else if (mTVar == null) {
            throw new IllegalArgumentException("Parser can not be null!");
        } else {
            mP mPVar2 = new mP();
            mPVar2.m8861(element);
            mPVar2.f8759 = mTVar.mo8736();
            if (mPVar2.f8753 != null) {
                mP r3 = mTVar.mo8729(mPVar2.f8753);
                if (r3 != null) {
                    mPVar2.m8880(r3);
                } else {
                    C1283.m16865("nf_subtitles", "Parent style NOT found!");
                }
            }
            if (mPVar != null) {
                C1283.m16846("nf_subtitles", "Apply default style");
                mPVar2.m8880(mPVar);
            }
            return mPVar2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m8875(Element element) {
        return m8861(element);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m8861(Element element) {
        boolean z = false;
        String attribute = element.getAttribute("xml:id");
        if (!C1349Bv.m4113(attribute)) {
            this.f8756 = attribute;
            z = true;
        }
        String attribute2 = element.getAttribute("style");
        if (!C1349Bv.m4113(attribute2)) {
            this.f8753 = attribute2;
            z = true;
        }
        this.f8750 = ColorMapping.m1159(element.getAttribute("tts:color"));
        if (this.f8750 != null) {
            z = true;
        }
        this.f8748 = ColorMapping.m1159(element.getAttribute("tts:backgroundColor"));
        if (this.f8748 != null) {
            z = true;
        }
        this.f8752 = ColorMapping.m1159(element.getAttribute("tts:windowColor"));
        if (this.f8752 != null) {
            z = true;
        }
        this.f8762 = C1334Bg.m4021(element.getAttribute("tts:fontSize"), 25, 200, true);
        if (this.f8762 != null) {
            z = true;
        }
        this.f8760 = mO.m8852(element.getAttribute("tts:textOutline"));
        if (this.f8760 != null) {
            z = true;
        }
        this.f8746 = FontFamilyMapping.m1163(element.getAttribute("tts:fontFamily"));
        if (this.f8746 != null) {
            z = true;
        }
        this.f8747 = m8862(element.getAttribute("tts:fontStyle"));
        if (this.f8747 != null) {
            z = true;
        }
        this.f8757 = m8864(element.getAttribute("tts:fontWeight"));
        if (this.f8757 != null) {
            z = true;
        } else if (this.f8746 != null) {
            this.f8757 = C1984mo.m9054(this.f8746);
        }
        this.f8751 = OpacityMapping.m1176(element.getAttribute("tts:opacity"));
        if (this.f8751 != null) {
            z = true;
        }
        this.f8749 = this.f8751;
        this.f8754 = this.f8751;
        String attribute3 = element.getAttribute("tts:textAlign");
        if (!C1349Bv.m4113(attribute3)) {
            this.f8758 = HorizontalAlignment.m1172(attribute3);
        }
        String attribute4 = element.getAttribute("tts:displayAlign");
        if (!C1349Bv.m4113(attribute4)) {
            this.f8761 = VerticalAlignment.m1178(attribute4);
        }
        String attribute5 = element.getAttribute("tts:extent");
        if (!C1349Bv.m4113(attribute5)) {
            this.f8755 = lZ.m8739(attribute5, this.f8759);
        }
        String attribute6 = element.getAttribute("tts:origin");
        if (!C1349Bv.m4113(attribute6)) {
            this.f8763 = lZ.m8739(attribute6, this.f8759);
        }
        return z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static Boolean m8862(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return Boolean.valueOf("italic".equalsIgnoreCase(str));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static FontWeight m8864(String str) {
        return FontWeight.m1169(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m8872() {
        return this.f8756;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m8879() {
        return this.f8750;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m8870() {
        return this.f8752;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m8874() {
        return this.f8748;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Integer m8876() {
        return this.f8762;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public mO m8884() {
        return this.f8760;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public FontFamilyMapping m8866() {
        return this.f8746;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public Boolean m8869() {
        return this.f8747;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public Boolean m8868() {
        return this.f8745;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public Float m8882() {
        return this.f8751;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public Float m8873() {
        return this.f8749;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public Float m8871() {
        return this.f8754;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8880(mP mPVar) {
        if (mPVar != null) {
            if (this.f8750 == null && mPVar.f8750 != null) {
                this.f8750 = mPVar.f8750;
            }
            if (this.f8752 == null && mPVar.f8752 != null) {
                this.f8752 = mPVar.f8752;
            }
            if (this.f8748 == null && mPVar.f8748 != null) {
                this.f8748 = mPVar.f8748;
            }
            if (this.f8762 == null && mPVar.f8762 != null) {
                this.f8762 = mPVar.f8762;
            }
            if (this.f8760 == null && mPVar.f8760 != null) {
                this.f8760 = mPVar.f8760;
            }
            if (this.f8746 == null && mPVar.f8746 != null) {
                this.f8746 = mPVar.f8746;
            }
            if (this.f8747 == null && mPVar.f8747 != null) {
                this.f8747 = mPVar.f8747;
            }
            if (this.f8745 == null && mPVar.f8745 != null) {
                this.f8745 = mPVar.f8745;
            }
            if (this.f8757 == null && mPVar.f8757 != null) {
                this.f8757 = mPVar.f8757;
            }
            if (this.f8751 == null && mPVar.f8751 != null) {
                this.f8751 = mPVar.f8751;
            }
            if (this.f8749 == null && mPVar.f8749 != null) {
                this.f8749 = mPVar.f8749;
            }
            if (this.f8754 == null && mPVar.f8754 != null) {
                this.f8754 = mPVar.f8754;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TextStyle [");
        if (this.f8756 != null) {
            sb.append(" id=").append(this.f8756);
        }
        if (this.f8753 != null) {
            sb.append(", ParentStyleId=").append(this.f8753);
        }
        if (this.f8750 != null) {
            sb.append(", Color=").append(this.f8750);
        }
        if (this.f8752 != null) {
            sb.append(", WindowColor=").append(this.f8752);
        }
        if (this.f8748 != null) {
            sb.append(", BackgroundColor=").append(this.f8748);
        }
        if (this.f8762 != null) {
            sb.append(", FontSize=").append(this.f8762);
        }
        if (this.f8746 != null) {
            sb.append(", FontFamily=").append(this.f8746);
        }
        if (this.f8760 != null) {
            sb.append(", Outline=").append(this.f8760);
        }
        if (this.f8747 != null) {
            sb.append(", Italic=").append(this.f8747);
        }
        if (this.f8745 != null) {
            sb.append(", Underline=").append(this.f8745);
        }
        if (this.f8757 != null) {
            sb.append(", Font weight=").append(this.f8757);
        }
        if (this.f8751 != null) {
            sb.append(", Opacity=").append(this.f8751);
        }
        if (this.f8749 != null) {
            sb.append(", WindowOpacity=").append(this.f8749);
        }
        if (this.f8754 != null) {
            sb.append(", BackgroundOpacity=").append(this.f8754);
        }
        if (this.f8763 != null) {
            sb.append(", Origin=").append(this.f8763);
        }
        if (this.f8755 != null) {
            sb.append(", Extent=").append(this.f8755);
        }
        if (this.f8758 != null) {
            sb.append(", HorizontalAlignment=").append(this.f8758);
        }
        if (this.f8761 != null) {
            sb.append(", VerticalAlignment=").append(this.f8761);
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public FontWeight m8881() {
        return this.f8757;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public lZ m8877() {
        return this.f8755;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public lZ m8878() {
        return this.f8763;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public HorizontalAlignment m8883() {
        return this.f8758;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public VerticalAlignment m8867() {
        return this.f8761;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static mP m8863(SubtitlePreference subtitlePreference) {
        ColorMapping r2;
        ColorMapping r22;
        ColorMapping r23;
        ColorMapping r3;
        if (subtitlePreference == null) {
            return null;
        }
        if (subtitlePreference.getCharEdgeAttrs() == null && subtitlePreference.getCharEdgeColor() == null && subtitlePreference.getCharColor() == null && subtitlePreference.getWindowColor() == null && subtitlePreference.getBackgroundColor() == null && subtitlePreference.getCharStyle() == null && subtitlePreference.getCharSize() == null && subtitlePreference.getCharOpacity() == null && subtitlePreference.getWindowOpacity() == null && subtitlePreference.getBackgroundOpacity() == null) {
            return null;
        }
        mP mPVar = new mP();
        if (!(subtitlePreference.getCharEdgeAttrs() == null && subtitlePreference.getCharEdgeColor() == null)) {
            mO r24 = mO.m8853();
            if (subtitlePreference.getCharEdgeAttrs() != null) {
                r24.m8859(CharacterEdgeTypeMapping.valueOf(subtitlePreference.getCharEdgeAttrs()));
            }
            if (!(subtitlePreference.getCharEdgeColor() == null || (r3 = ColorMapping.m1160(subtitlePreference.getCharEdgeColor())) == null)) {
                r24.m8857(r3.m1162());
            }
            mPVar.f8760 = r24;
        }
        if (!(subtitlePreference.getCharColor() == null || (r23 = ColorMapping.m1160(subtitlePreference.getCharColor())) == null)) {
            mPVar.f8750 = r23.m1162();
        }
        if (!(subtitlePreference.getWindowColor() == null || (r22 = ColorMapping.m1160(subtitlePreference.getWindowColor())) == null)) {
            mPVar.f8752 = r22.m1162();
        }
        if (!(subtitlePreference.getBackgroundColor() == null || (r2 = ColorMapping.m1160(subtitlePreference.getBackgroundColor())) == null)) {
            mPVar.f8748 = r2.m1162();
        }
        if (subtitlePreference.getCharStyle() != null) {
            mPVar.f8746 = FontFamilyMapping.m1163(subtitlePreference.getCharStyle());
        }
        if (subtitlePreference.getCharSize() != null) {
            mPVar.f8762 = Integer.valueOf(SizeMapping.m1140(subtitlePreference.getCharSize()));
        }
        if (subtitlePreference.getCharOpacity() != null) {
            mPVar.f8751 = OpacityMapping.m1176(subtitlePreference.getCharOpacity());
        }
        if (subtitlePreference.getWindowOpacity() != null) {
            mPVar.f8749 = OpacityMapping.m1176(subtitlePreference.getWindowOpacity());
        }
        if (subtitlePreference.getBackgroundOpacity() != null) {
            mPVar.f8754 = OpacityMapping.m1176(subtitlePreference.getBackgroundOpacity());
        }
        return mPVar;
    }
}
