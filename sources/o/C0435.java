package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import o.AbstractC1622coN;
/* renamed from: o.ˍ  reason: contains not printable characters */
public class C0435 implements AbstractC0423, AUX, AbstractC1372Con, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1517auX f13458;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C1164 f13459;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Path f13460 = new Path();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1518aux f13461;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0741 f13462;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f13463;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Matrix f13464 = new Matrix();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1622coN<Float, Float> f13465;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC1622coN<Float, Float> f13466;

    public C0435(C1518aux aux, AbstractC0741 r3, C0438 r4) {
        this.f13461 = aux;
        this.f13462 = r3;
        this.f13463 = r4.m14287();
        this.f13465 = r4.m14286().mo14241();
        r3.m15134(this.f13465);
        this.f13465.mo5905(this);
        this.f13466 = r4.m14285().mo14241();
        r3.m15134(this.f13466);
        this.f13466.mo5905(this);
        this.f13459 = r4.m14288().m15920();
        this.f13459.m16357(r3);
        this.f13459.m16355(this);
    }

    @Override // o.AbstractC1372Con
    /* renamed from: ˎ */
    public void mo4517(ListIterator<AbstractC0420> listIterator) {
        if (this.f13458 == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.f13458 = new C1517auX(this.f13461, this.f13462, "Repeater", arrayList, null);
        }
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f13463;
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        this.f13458.mo3790(list, list2);
    }

    @Override // o.AUX
    /* renamed from: ˏ */
    public Path mo3438() {
        Path r3 = this.f13458.mo3438();
        this.f13460.reset();
        float floatValue = this.f13465.mo5904().floatValue();
        float floatValue2 = this.f13466.mo5904().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f13464.set(this.f13459.m16354(((float) i) + floatValue2));
            this.f13460.addPath(r3, this.f13464);
        }
        return this.f13460;
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5647(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f13465.mo5904().floatValue();
        float floatValue2 = this.f13466.mo5904().floatValue();
        float floatValue3 = this.f13459.m16359().mo5904().floatValue() / 100.0f;
        float floatValue4 = this.f13459.m16358().mo5904().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f13464.set(matrix);
            this.f13464.preConcat(this.f13459.m16354(((float) i2) + floatValue2));
            this.f13458.mo5647(canvas, this.f13464, (int) (((float) i) * C1150.m16323(floatValue3, floatValue4, ((float) i2) / floatValue)));
        }
    }

    @Override // o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        this.f13458.mo5650(rectF, matrix);
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
        this.f13458.mo5648(str, str2, colorFilter);
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        this.f13461.invalidateSelf();
    }
}
