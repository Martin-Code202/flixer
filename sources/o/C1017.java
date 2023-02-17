package o;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: o.ᵓ  reason: contains not printable characters */
public class C1017 extends AbstractC0741 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final RectF f15099 = new RectF();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Matrix f15100 = new Matrix();

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Paint f15101 = new Paint(1) { // from class: o.ᵓ.2
        {
            setStyle(Paint.Style.FILL);
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AbstractC1622coN<Integer, Integer> f15102;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final C0539 f15103;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final char[] f15104 = new char[1];

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final C1518aux f15105;

    /* renamed from: ͺ  reason: contains not printable characters */
    private AbstractC1622coN<Integer, Integer> f15106;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final C0433 f15107;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private AbstractC1622coN<Float, Float> f15108;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private AbstractC1622coN<Float, Float> f15109;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Paint f15110 = new Paint(1) { // from class: o.ᵓ.4
        {
            setStyle(Paint.Style.STROKE);
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Map<C0428, List<C1517auX>> f15111 = new HashMap();

    C1017(C1518aux aux, Layer layer) {
        super(aux, layer);
        this.f15105 = aux;
        this.f15107 = layer.m65();
        this.f15103 = layer.m81().mo14241();
        this.f15103.mo5905(this);
        m15134(this.f15103);
        C1035 r2 = layer.m76();
        if (!(r2 == null || r2.f15149 == null)) {
            this.f15102 = r2.f15149.mo14241();
            this.f15102.mo5905(this);
            m15134(this.f15102);
        }
        if (!(r2 == null || r2.f15152 == null)) {
            this.f15106 = r2.f15152.mo14241();
            this.f15106.mo5905(this);
            m15134(this.f15106);
        }
        if (!(r2 == null || r2.f15151 == null)) {
            this.f15109 = r2.f15151.mo14241();
            this.f15109.mo5905(this);
            m15134(this.f15109);
        }
        if (r2 != null && r2.f15150 != null) {
            this.f15108 = r2.f15150.mo14241();
            this.f15108.mo5905(this);
            m15134(this.f15108);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC0741
    /* renamed from: ॱ */
    public void mo14760(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.f15105.m5666()) {
            canvas.setMatrix(matrix);
        }
        C1249 r3 = (C1249) this.f15103.mo5904();
        C0413 r4 = this.f15107.m14265().get(r3.f15816);
        if (r4 == null) {
            canvas.restore();
            return;
        }
        if (this.f15102 != null) {
            this.f15101.setColor(this.f15102.mo5904().intValue());
        } else {
            this.f15101.setColor(r3.f15812);
        }
        if (this.f15106 != null) {
            this.f15110.setColor(this.f15106.mo5904().intValue());
        } else {
            this.f15110.setColor(r3.f15819);
        }
        int intValue = (this.f14327.m16356().mo5904().intValue() * 255) / 100;
        this.f15101.setAlpha(intValue);
        this.f15110.setAlpha(intValue);
        if (this.f15109 != null) {
            this.f15110.setStrokeWidth(this.f15109.mo5904().floatValue());
        } else {
            this.f15110.setStrokeWidth(((float) r3.f15811) * this.f15107.m14266() * C1026.m16010(matrix));
        }
        if (this.f15105.m5666()) {
            m15979(r3, matrix, r4, canvas);
        } else {
            m15980(r3, r4, matrix, canvas);
        }
        canvas.restore();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15979(C1249 r16, Matrix matrix, C0413 r18, Canvas canvas) {
        float f = ((float) r16.f15814) / 100.0f;
        float r7 = C1026.m16010(matrix);
        String str = r16.f15815;
        for (int i = 0; i < str.length(); i++) {
            C0428 r12 = this.f15107.m14253().get(C0428.m14237(str.charAt(i), r18.m14219(), r18.m14218()));
            if (r12 != null) {
                m15978(r12, matrix, f, r16, canvas);
                float r13 = ((float) r12.m14239()) * f * this.f15107.m14266() * r7;
                float f2 = ((float) r16.f15817) / 10.0f;
                if (this.f15108 != null) {
                    f2 += this.f15108.mo5904().floatValue();
                }
                canvas.translate(r13 + (f2 * r7), 0.0f);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15980(C1249 r14, C0413 r15, Matrix matrix, Canvas canvas) {
        float r4 = C1026.m16010(matrix);
        Typeface r5 = this.f15105.m5675(r15.m14219(), r15.m14218());
        if (r5 != null) {
            String str = r14.f15815;
            C1490aUx r7 = this.f15105.m5664();
            if (r7 != null) {
                str = r7.m5401(str);
            }
            this.f15101.setTypeface(r5);
            this.f15101.setTextSize(((float) r14.f15814) * this.f15107.m14266());
            this.f15110.setTypeface(this.f15101.getTypeface());
            this.f15110.setTextSize(this.f15101.getTextSize());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                m15976(charAt, r14, canvas);
                this.f15104[0] = charAt;
                float measureText = this.f15101.measureText(this.f15104, 0, 1);
                float f = ((float) r14.f15817) / 10.0f;
                if (this.f15108 != null) {
                    f += this.f15108.mo5904().floatValue();
                }
                canvas.translate(measureText + (f * r4), 0.0f);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15978(C0428 r6, Matrix matrix, float f, C1249 r9, Canvas canvas) {
        List<C1517auX> r2 = m15975(r6);
        for (int i = 0; i < r2.size(); i++) {
            Path r4 = r2.get(i).mo3438();
            r4.computeBounds(this.f15099, false);
            this.f15100.set(matrix);
            this.f15100.preScale(f, f);
            r4.transform(this.f15100);
            if (r9.f15820) {
                m15977(r4, this.f15101, canvas);
                m15977(r4, this.f15110, canvas);
            } else {
                m15977(r4, this.f15110, canvas);
                m15977(r4, this.f15101, canvas);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15977(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15976(char c, C1249 r4, Canvas canvas) {
        this.f15104[0] = c;
        if (r4.f15820) {
            m15981(this.f15104, this.f15101, canvas);
            m15981(this.f15104, this.f15110, canvas);
            return;
        }
        m15981(this.f15104, this.f15110, canvas);
        m15981(this.f15104, this.f15101, canvas);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15981(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private List<C1517auX> m15975(C0428 r8) {
        if (this.f15111.containsKey(r8)) {
            return this.f15111.get(r8);
        }
        List<C0551> r2 = r8.m14238();
        int size = r2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new C1517auX(this.f15105, this, r2.get(i)));
        }
        this.f15111.put(r8, arrayList);
        return arrayList;
    }
}
