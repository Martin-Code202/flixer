package o;

import android.os.Handler;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.AbstractC1979mj;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public abstract class lY extends AbstractC1970ma implements mT {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    protected final float f8608;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected final List<AbstractC1976mg> f8609 = new ArrayList();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    protected mN f8610;

    /* renamed from: ʾ  reason: contains not printable characters */
    protected final mP f8611;

    /* renamed from: ʿ  reason: contains not printable characters */
    protected final mP f8612;

    /* renamed from: ˈ  reason: contains not printable characters */
    protected final mP f8613;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected double f8614;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    protected final mP f8615 = new mP();

    /* renamed from: ˎ  reason: contains not printable characters */
    protected ISubtitleDef.SubtitleProfile f8616;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final Map<String, mQ> f8617 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final Map<String, mP> f8618 = new HashMap();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected String f8619;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected String f8620;

    public lY(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, SubtitleUrl subtitleUrl, mP mPVar, mP mPVar2, float f, AbstractC1979mj.iF iFVar, long j, long j2, AbstractC2055pd pdVar) {
        super(handler, mhVar, mlVar, subtitleUrl, iFVar, j, j2, pdVar);
        m8730();
        this.f8608 = f;
        this.f8612 = mPVar;
        this.f8613 = mPVar2;
        this.f8611 = C1984mo.m9058(mPVar, mPVar2);
        m8730();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8730() {
        this.f8615.m8880(this.f8613);
        this.f8615.m8880(this.f8611);
        C1283.m16851("nf_subtitles", "Default text style %s", this.f8615);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8728(String str) {
        C1283.m16854("nf_subtitles", "==> Subtitle parsing started...");
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Subtitle data xml is empty!");
        }
        Element documentElement = BI.m3863(str).getDocumentElement();
        m8725(documentElement);
        m8720(BI.m3864(documentElement, "head"));
        C1283.m16854("nf_subtitles", "Ready to serve subtitles...");
        this.f8870 = true;
        m8717(BI.m3864(documentElement, "body"));
        C1283.m16854("nf_subtitles", "==> Subtitle parsing completed.");
        mo7696();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8725(Element element) {
        if (element == null) {
            throw new IllegalArgumentException("Root element can not be null!");
        }
        String attribute = element.getAttribute("ttp:tickRate");
        if (!C1349Bv.m4113(attribute)) {
            double parseDouble = Double.parseDouble(attribute);
            if (parseDouble <= 0.0d) {
                C1283.m16854("nf_subtitles", "Tickrate defaults to 1000");
                this.f8614 = 1000.0d;
            } else {
                C1283.m16854("nf_subtitles", "Tickrate calculate");
                this.f8614 = 1000.0d / parseDouble;
            }
        } else {
            C1283.m16854("nf_subtitles", "Tickrate defaults to 1000 on empty tag");
            this.f8614 = 1000.0d;
        }
        this.f8619 = element.getAttribute("ttp:pixelAspectRatio");
        this.f8620 = element.getAttribute("tts:extent");
        String attribute2 = element.getAttribute("ttp:cellResolution");
        if (!C1349Bv.m4113(attribute2)) {
            this.f8610 = mN.m8850(attribute2, this.f8620, this.f8619, this.f8608);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8720(Element element) {
        if (element == null) {
            throw new IllegalArgumentException("Head element can not be null!");
        }
        this.f8616 = ISubtitleDef.SubtitleProfile.m1534(element.getAttribute("use"));
        m8723(element);
        m8722(element);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8722(Element element) {
        C1283.m16854("nf_subtitles", "Parsing regions started");
        Element r3 = BI.m3865(element, "layout");
        if (r3 == null) {
            C1283.m16850("nf_subtitles", "Layout element not found!");
            return;
        }
        NodeList elementsByTagName = r3.getElementsByTagName("region");
        if (elementsByTagName == null || elementsByTagName.getLength() < 1) {
            C1283.m16850("nf_subtitles", "Region element(s) not found!");
            return;
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (item instanceof Element) {
                mQ r7 = mQ.m8885(this, (Element) item, this.f8610, this.f8615);
                if (r7 == null) {
                    C1283.m16865("nf_subtitles", "Region not found!");
                } else if (r7.m8888() != null) {
                    this.f8617.put(r7.m8888(), r7);
                }
            } else {
                C1283.m16850("nf_subtitles", "Node is not instance of element for region!");
            }
        }
        C1283.m16854("nf_subtitles", "Parsing regions done");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8723(Element element) {
        C1283.m16854("nf_subtitles", "Parsing styling started");
        Element r2 = BI.m3865(element, "styling");
        if (r2 == null) {
            C1283.m16854("nf_subtitles", "Styling element not found!");
            return;
        }
        NodeList elementsByTagName = r2.getElementsByTagName("style");
        if (elementsByTagName == null || elementsByTagName.getLength() < 1) {
            C1283.m16854("nf_subtitles", "Style element(s) not found!");
            return;
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (item instanceof Element) {
                mP r6 = mP.m8865((Element) item, this, this.f8615);
                if (r6 == null) {
                    C1283.m16865("nf_subtitles", "Style not found!");
                } else if (r6.m8872() != null) {
                    this.f8618.put(r6.m8872(), r6);
                }
            } else {
                C1283.m16850("nf_subtitles", "Node is not instance of element for style!");
            }
        }
        C1283.m16854("nf_subtitles", "Parsing styling done");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8717(Element element) {
        if (element == null) {
            throw new IllegalArgumentException("Body element can not be null!");
        }
        C1283.m16854("nf_subtitles", "Parsing body started");
        mP r2 = mP.m8865(element, this, this.f8615);
        Element r3 = BI.m3865(element, "div");
        if (r3 == null) {
            C1283.m16850("nf_subtitles", "DIV element not found!");
            return;
        }
        mP r4 = mP.m8865(r3, this, r2);
        NodeList elementsByTagName = r3.getElementsByTagName("p");
        if (elementsByTagName == null || elementsByTagName.getLength() < 1) {
            C1283.m16850("nf_subtitles", "P element(s) not found!");
            return;
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (item instanceof Element) {
                mR mRVar = new mR((Element) item, this, r4, null);
                synchronized (this.f8609) {
                    this.f8609.add(mRVar);
                }
            } else {
                C1283.m16850("nf_subtitles", "Node is not instance of element for P!");
            }
        }
        C1283.m16854("nf_subtitles", "Parsing body done");
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˏ  reason: contains not printable characters */
    public C1987mr mo8732(long j) {
        long j2 = j + 2000;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int r11 = m8721(j);
        boolean z = false;
        synchronized (this.f8609) {
            int size = this.f8609.size();
            int i = r11;
            while (true) {
                if (i >= size) {
                    break;
                }
                AbstractC1976mg mgVar = this.f8609.get(i);
                if (mgVar.mo8705() > j2) {
                    C1283.m16854("nf_subtitles", "Subtitle block start is in future more than 2 sec, break search");
                    break;
                }
                if (mgVar.mo8704(j)) {
                    if (!z) {
                        z = true;
                        this.f8875 = i;
                    }
                    arrayList.add(mgVar);
                } else if (mgVar.mo8706(j, j2)) {
                    arrayList2.add(mgVar);
                }
                i++;
            }
        }
        this.f8871 = j;
        return new C1987mr(this, arrayList, arrayList2, 2000, j);
    }

    @Override // o.mT
    /* renamed from: ॱ  reason: contains not printable characters */
    public mP mo8735() {
        return this.f8615;
    }

    @Override // o.mT
    /* renamed from: ʻ  reason: contains not printable characters */
    public double mo8726() {
        return this.f8614;
    }

    @Override // o.AbstractC1979mj
    public ISubtitleDef.SubtitleProfile D_() {
        return this.f8616;
    }

    @Override // o.mT
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public mN mo8736() {
        return this.f8610;
    }

    @Override // o.mT
    /* renamed from: ˎ  reason: contains not printable characters */
    public mQ mo8731(String str) {
        if (str == null) {
            return null;
        }
        return this.f8617.get(str);
    }

    @Override // o.mT
    /* renamed from: ˋ  reason: contains not printable characters */
    public mP mo8729(String str) {
        if (str == null) {
            return null;
        }
        return this.f8618.get(str);
    }

    @Override // o.mT
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public mQ[] mo8734() {
        if (this.f8617 == null || this.f8617.size() < 1) {
            return new mQ[0];
        }
        return (mQ[]) this.f8617.values().toArray(new mQ[this.f8617.size()]);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private int m8721(long j) {
        if (this.f8875 < 0) {
            this.f8875 = m8724(j);
        }
        return this.f8875;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m8724(long j) {
        if (j <= 30000) {
            C1283.m16854("nf_subtitles", "Less than treshold, return 0");
            return 0;
        }
        C1283.m16854("nf_subtitles", "Try to guess");
        int r2 = m8718(j);
        if (r2 > 0) {
            C1283.m16854("nf_subtitles", "Lets see if index is first in array or just first found");
            int i = r2 - 1;
            while (i > 0 && m8719(j, i) == 0) {
                r2 = i;
                i--;
            }
        }
        return r2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int m8718(long j) {
        int i = 0;
        int size = this.f8609.size() - 1;
        while (size >= i) {
            int i2 = i + ((size - i) / 2);
            int r5 = m8719(j, i2);
            if (r5 == 0) {
                return i2;
            }
            if (r5 < 0) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int m8719(long j, int i) {
        synchronized (this.f8609) {
            if (this.f8609.size() <= i) {
                C1283.m16850("nf_subtitles", "Index (" + i + ") is higher than numbet of blocks  " + this.f8609.size());
                return -1;
            }
            AbstractC1976mg mgVar = this.f8609.get(i);
            if (mgVar.mo8704(j)) {
                return 0;
            }
            if (mgVar.mo8705() < j) {
                return -1;
            }
            return 1;
        }
    }

    @Override // o.mT
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public mP mo8738() {
        return this.f8612;
    }

    @Override // o.AbstractC1970ma, o.AbstractC1979mj
    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void mo8733(int i) {
        super.mo8733(i);
        int i2 = 0;
        synchronized (this.f8609) {
            for (AbstractC1976mg mgVar : this.f8609) {
                if (mgVar.mo8706(this.f8869, this.f8871)) {
                    i2++;
                }
                mgVar.mo8903((long) i);
            }
        }
        this.f8876 += i2;
        this.f8869 = (long) i;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public synchronized int mo8737() {
        if (this.f8875 == -1) {
            return this.f8876;
        }
        int i = 0;
        synchronized (this.f8609) {
            for (AbstractC1976mg mgVar : this.f8609) {
                if (mgVar.mo8706(this.f8869, this.f8871)) {
                    i++;
                }
            }
        }
        return this.f8876 + i;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ʻॱ  reason: contains not printable characters */
    public synchronized int mo8727() {
        int i;
        i = 0;
        synchronized (this.f8609) {
            for (AbstractC1976mg mgVar : this.f8609) {
                i += mgVar.mo8902();
            }
        }
        return i;
    }
}
