package o;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class mR extends lW {

    /* renamed from: ʻ  reason: contains not printable characters */
    private mQ f8771;

    /* renamed from: ʼ  reason: contains not printable characters */
    private mP f8772;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected int f8773;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected boolean f8774;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f8775;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private List<mM> f8776 = new ArrayList();

    public mR(Element element, mT mTVar, mP mPVar, mQ mQVar) {
        if (element == null) {
            throw new IllegalArgumentException("P can not be null!");
        } else if (mTVar == null) {
            throw new IllegalArgumentException("Parser can not be null!");
        } else {
            this.f8596 = element.getAttribute("xml:id");
            if (this.f8596 == null) {
                C1283.m16865("nf_subtitles", "Block id is not specified, it will be faked.");
            }
            m8898(mTVar, mQVar, element);
            this.f8772 = mP.m8865(element, mTVar, mPVar);
            this.f8597 = m8894(element.getAttribute("begin"), mTVar.mo8726());
            this.f8599 = m8894(element.getAttribute("end"), mTVar.mo8726());
            m8899(mTVar, element);
            mP r3 = mTVar.mo8738();
            if (r3 != null) {
                C1283.m16854("nf_subtitles", "Use user overide for mMaxFontSizeMultiplier");
                this.f8598 = r3.m8876() != null ? (float) r3.m8876().intValue() : 100.0f;
            }
            if (this.f8598 < 0.0f) {
                C1283.m16854("nf_subtitles", "Max font size multplier set to 100! ");
                this.f8598 = 100.0f;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8898(mT mTVar, mQ mQVar, Element element) {
        String attribute = element.getAttribute("region");
        if (!C1349Bv.m4113(attribute)) {
            this.f8771 = mTVar.mo8731(attribute);
            mQ mQVar2 = this.f8771;
        } else if (mQVar != null) {
            C1283.m16854("nf_subtitles", "Region is not specified. Use body region.");
            this.f8771 = mQVar;
        } else {
            C1283.m16865("nf_subtitles", "Region is not specified and body region is not provided. Use default region.");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8899(mT mTVar, Element element) {
        NodeList childNodes = element.getChildNodes();
        int i = 0;
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node item = childNodes.item(i2);
            if (item.getNodeType() == 1) {
                i = m8893(mTVar, item, i, this.f8772);
            } else if (item.getNodeType() == 3) {
                m8896(mTVar, item, i, null);
                i = 0;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m8893(mT mTVar, Node node, int i, mP mPVar) {
        Element element = (Element) node;
        if (C1982mm.m9037(element)) {
            C1283.m16854("nf_subtitles", "Break line, increase br counter");
            return i + 1;
        } else if (C1982mm.m9038(element)) {
            return m8897(mTVar, element, i, mPVar);
        } else {
            return i;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private int m8897(mT mTVar, Element element, int i, mP mPVar) {
        C1283.m16854("nf_subtitles", "SPAN node, create subtitle block");
        mP r2 = mP.m8865(element, mTVar, mPVar);
        NodeList childNodes = element.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node item = childNodes.item(i2);
            if (item.getNodeType() == 1) {
                i = m8893(mTVar, item, i, r2);
            } else if (item.getNodeType() == 3) {
                m8896(mTVar, item, i, r2);
                i = 0;
            }
        }
        return i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8896(AbstractC1979mj mjVar, Node node, int i, mP mPVar) {
        C1283.m16854("nf_subtitles", "Text node, create subtitle block");
        mP mPVar2 = null;
        if (mPVar != null) {
            mPVar2 = new mP(mPVar);
            mPVar2.m8880(this.f8772);
        } else if (this.f8772 != null) {
            mPVar2 = new mP(this.f8772);
        }
        mM mMVar = new mM(mPVar2, node.getTextContent(), i);
        this.f8776.add(mMVar);
        m8895(mMVar);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8895(mM mMVar) {
        this.f8775 = this.f8775 + mMVar.m8849() + 1;
        if (mMVar.m8847() != null) {
            C1283.m16854("nf_subtitles", "Font size: " + mMVar.m8847().m8876());
        }
        if (mMVar.m8847() != null && mMVar.m8847().m8876() != null && this.f8598 < ((float) mMVar.m8847().m8876().intValue())) {
            this.f8598 = (float) mMVar.m8847().m8876().intValue();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private long m8894(String str, double d) {
        return C1984mo.m9041(str, d);
    }

    public int hashCode() {
        return (this.f8596 == null ? 0 : this.f8596.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AbstractC1976mg)) {
            return false;
        }
        mR mRVar = (mR) obj;
        if (this.f8596 == null) {
            if (mRVar.f8596 != null) {
                return false;
            }
            return true;
        } else if (!this.f8596.equals(mRVar.f8596)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public mQ m8901() {
        return this.f8771;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public List<mM> m8904() {
        return this.f8776;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public mP m8900() {
        return this.f8772;
    }

    @Override // o.lW
    public String toString() {
        return "TextSubtitleBlock [mId=" + this.f8596 + ", mRegion=" + this.f8771 + ", mTextNodes=" + this.f8776 + ", mStart=" + this.f8597 + ", mEnd=" + this.f8599 + ", mStyle=" + this.f8772 + ", mTotalNumberOfLines=" + this.f8775 + ", mMaxFontSizeMultiplier=" + this.f8598 + "]";
    }

    @Override // o.AbstractC1976mg
    /* renamed from: ˏ  reason: contains not printable characters */
    public int mo8902() {
        return this.f8773;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m8905() {
        if (!this.f8774) {
            this.f8774 = true;
            this.f8773++;
        }
    }

    @Override // o.AbstractC1976mg
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8903(long j) {
        if (j < this.f8599) {
            this.f8774 = false;
        }
    }
}
