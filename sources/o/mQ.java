package o;

import com.netflix.mediaclient.service.player.subtitles.text.HorizontalAlignment;
import com.netflix.mediaclient.service.player.subtitles.text.VerticalAlignment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class mQ {

    /* renamed from: ʻ  reason: contains not printable characters */
    private mP f8764;

    /* renamed from: ˊ  reason: contains not printable characters */
    private VerticalAlignment f8765;

    /* renamed from: ˋ  reason: contains not printable characters */
    private lZ f8766;

    /* renamed from: ˎ  reason: contains not printable characters */
    private lZ f8767;

    /* renamed from: ˏ  reason: contains not printable characters */
    private HorizontalAlignment f8768;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f8769;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private mN f8770;

    private mQ(lY lYVar, Element element, mN mNVar, mP mPVar) {
        this.f8769 = element.getAttribute("xml:id");
        this.f8770 = mNVar;
        mP r3 = mP.m8865(element, lYVar, mPVar);
        if (r3 != null) {
            if (r3.m8883() != null) {
                C1283.m16854("nf_subtitles", "Hor alig found as attribute " + r3.m8883());
                this.f8768 = r3.m8883();
            }
            if (r3.m8867() != null) {
                C1283.m16854("nf_subtitles", "Vert alig found as attribute " + r3.m8867());
                this.f8765 = r3.m8867();
            }
            if (r3.m8877() != null) {
                C1283.m16854("nf_subtitles", "Extent as attribute " + r3.m8877());
                this.f8766 = r3.m8877();
            }
            if (r3.m8878() != null) {
                C1283.m16854("nf_subtitles", "Origin as attribute " + r3.m8878());
                this.f8767 = r3.m8878();
            }
        }
        mP r4 = m8887(element);
        this.f8764 = new mP();
        if (r4 != null) {
            C1283.m16854("nf_subtitles", "Region parsed styles found use them first");
            this.f8764.m8880(r4);
        }
        if (r3 != null) {
            C1283.m16854("nf_subtitles", "Region Attribute styles found use them second");
            this.f8764.m8880(r3);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private mP m8887(Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("style");
        if (elementsByTagName == null || elementsByTagName.getLength() < 1) {
            C1283.m16850("nf_subtitles", "Styles element(s) not found in region");
            return null;
        }
        mP mPVar = new mP();
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (item instanceof Element) {
                Element element2 = (Element) item;
                if (mPVar.m8875(element2)) {
                    C1283.m16854("nf_subtitles", "Style added");
                } else {
                    C1283.m16854("nf_subtitles", "Style not added, check to see if it they are region attributes.");
                    m8886(element2);
                }
            }
        }
        return mPVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8886(Element element) {
        String attribute = element.getAttribute("tts:textAlign");
        if (!C1349Bv.m4113(attribute)) {
            this.f8768 = HorizontalAlignment.m1172(attribute);
        }
        String attribute2 = element.getAttribute("tts:displayAlign");
        if (!C1349Bv.m4113(attribute2)) {
            this.f8765 = VerticalAlignment.m1178(attribute2);
        }
        String attribute3 = element.getAttribute("tts:extent");
        if (!C1349Bv.m4113(attribute3)) {
            this.f8766 = lZ.m8739(attribute3, this.f8770);
        }
        String attribute4 = element.getAttribute("tts:origin");
        if (!C1349Bv.m4113(attribute4)) {
            this.f8767 = lZ.m8739(attribute4, this.f8770);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static mQ m8885(lY lYVar, Element element, mN mNVar, mP mPVar) {
        return new mQ(lYVar, element, mNVar, mPVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m8888() {
        return this.f8769;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public HorizontalAlignment m8891() {
        return this.f8768;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public VerticalAlignment m8892() {
        return this.f8765;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public lZ m8890() {
        return this.f8766;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public lZ m8889() {
        return this.f8767;
    }

    public String toString() {
        return "Region [mId=" + this.f8769 + ", mExtent=" + this.f8766 + ", mOrigin=" + this.f8767 + ", mHorizontalAlignment=" + this.f8768 + ", mVerticalAlignment=" + this.f8765 + ", mCellResolution=" + this.f8770 + ", mTextStyle=" + this.f8764 + "]";
    }
}
