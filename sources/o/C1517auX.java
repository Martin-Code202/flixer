package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.auX  reason: case insensitive filesystem */
public class C1517auX implements AbstractC0423, AUX, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1164 f6059;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f6060;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Path f6061;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final RectF f6062;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<AbstractC0420> f6063;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Matrix f6064;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private List<AUX> f6065;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C1518aux f6066;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static List<AbstractC0420> m5645(C1518aux aux, AbstractC0741 r5, List<AbstractC0342> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            AbstractC0420 r3 = list.get(i).mo27(aux, r5);
            if (r3 != null) {
                arrayList.add(r3);
            }
        }
        return arrayList;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static C0984 m5644(List<AbstractC0342> list) {
        for (int i = 0; i < list.size(); i++) {
            AbstractC0342 r2 = list.get(i);
            if (r2 instanceof C0984) {
                return (C0984) r2;
            }
        }
        return null;
    }

    public C1517auX(C1518aux aux, AbstractC0741 r8, C0551 r9) {
        this(aux, r8, r9.m14597(), m5645(aux, r8, r9.m14598()), m5644(r9.m14598()));
    }

    C1517auX(C1518aux aux, AbstractC0741 r7, String str, List<AbstractC0420> list, C0984 r10) {
        this.f6064 = new Matrix();
        this.f6061 = new Path();
        this.f6062 = new RectF();
        this.f6060 = str;
        this.f6066 = aux;
        this.f6063 = list;
        if (r10 != null) {
            this.f6059 = r10.m15920();
            this.f6059.m16357(r7);
            this.f6059.m16355(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            AbstractC0420 r4 = list.get(size);
            if (r4 instanceof AbstractC1372Con) {
                arrayList.add((AbstractC1372Con) r4);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((AbstractC1372Con) arrayList.get(size2)).mo4517(list.listIterator(list.size()));
        }
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        this.f6066.invalidateSelf();
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f6060;
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
        for (int i = 0; i < this.f6063.size(); i++) {
            AbstractC0420 r2 = this.f6063.get(i);
            if (r2 instanceof AbstractC0423) {
                AbstractC0423 r3 = (AbstractC0423) r2;
                if (str2 == null || str2.equals(r2.mo3788())) {
                    r3.mo5648(str, (String) null, colorFilter);
                } else {
                    r3.mo5648(str, str2, colorFilter);
                }
            }
        }
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f6063.size());
        arrayList.addAll(list);
        for (int size = this.f6063.size() - 1; size >= 0; size--) {
            AbstractC0420 r4 = this.f6063.get(size);
            r4.mo3790(arrayList, this.f6063.subList(0, size));
            arrayList.add(r4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public List<AUX> m5646() {
        if (this.f6065 == null) {
            this.f6065 = new ArrayList();
            for (int i = 0; i < this.f6063.size(); i++) {
                AbstractC0420 r3 = this.f6063.get(i);
                if (r3 instanceof AUX) {
                    this.f6065.add((AUX) r3);
                }
            }
        }
        return this.f6065;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Matrix m5649() {
        if (this.f6059 != null) {
            return this.f6059.m16353();
        }
        this.f6064.reset();
        return this.f6064;
    }

    @Override // o.AUX
    /* renamed from: ˏ */
    public Path mo3438() {
        this.f6064.reset();
        if (this.f6059 != null) {
            this.f6064.set(this.f6059.m16353());
        }
        this.f6061.reset();
        for (int size = this.f6063.size() - 1; size >= 0; size--) {
            AbstractC0420 r4 = this.f6063.get(size);
            if (r4 instanceof AUX) {
                this.f6061.addPath(((AUX) r4).mo3438(), this.f6064);
            }
        }
        return this.f6061;
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5647(Canvas canvas, Matrix matrix, int i) {
        int i2;
        this.f6064.set(matrix);
        if (this.f6059 != null) {
            this.f6064.preConcat(this.f6059.m16353());
            i2 = (int) ((((((float) this.f6059.m16356().mo5904().intValue()) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
        } else {
            i2 = i;
        }
        for (int size = this.f6063.size() - 1; size >= 0; size--) {
            AbstractC0420 r4 = this.f6063.get(size);
            if (r4 instanceof AbstractC0423) {
                ((AbstractC0423) r4).mo5647(canvas, this.f6064, i2);
            }
        }
    }

    @Override // o.AbstractC0423
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo5650(RectF rectF, Matrix matrix) {
        this.f6064.set(matrix);
        if (this.f6059 != null) {
            this.f6064.preConcat(this.f6059.m16353());
        }
        this.f6062.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f6063.size() - 1; size >= 0; size--) {
            AbstractC0420 r6 = this.f6063.get(size);
            if (r6 instanceof AbstractC0423) {
                ((AbstractC0423) r6).mo5650(this.f6062, this.f6064);
                if (rectF.isEmpty()) {
                    rectF.set(this.f6062);
                } else {
                    rectF.set(Math.min(rectF.left, this.f6062.left), Math.min(rectF.top, this.f6062.top), Math.max(rectF.right, this.f6062.right), Math.max(rectF.bottom, this.f6062.bottom));
                }
            }
        }
    }
}
