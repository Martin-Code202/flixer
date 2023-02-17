package o;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.ᐤ  reason: contains not printable characters */
public abstract class AbstractC0741 implements AbstractC0423, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Paint f14314 = new Paint(1);

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final List<AbstractC1622coN<?, ?>> f14315 = new ArrayList();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Paint f14316 = new Paint();

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Paint f14317 = new Paint(1);

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean f14318 = true;

    /* renamed from: ˊ  reason: contains not printable characters */
    final Matrix f14319 = new Matrix();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final RectF f14320 = new RectF();

    /* renamed from: ˋ  reason: contains not printable characters */
    final C1518aux f14321;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final RectF f14322 = new RectF();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Path f14323 = new Path();

    /* renamed from: ˏ  reason: contains not printable characters */
    final Layer f14324;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final RectF f14325 = new RectF();

    /* renamed from: ͺ  reason: contains not printable characters */
    private final RectF f14326 = new RectF();

    /* renamed from: ॱ  reason: contains not printable characters */
    final C1164 f14327;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final String f14328;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private AbstractC0741 f14329;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private AbstractC0741 f14330;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Matrix f14331 = new Matrix();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C0745 f14332;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Paint f14333 = new Paint(1);

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private List<AbstractC0741> f14334;

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ */
    public abstract void mo14760(Canvas canvas, Matrix matrix, int i);

    /* renamed from: ˋ  reason: contains not printable characters */
    static AbstractC0741 m15123(Layer layer, C1518aux aux, C0433 r5) {
        switch (layer.m66()) {
            case Shape:
                return new C0632(aux, layer);
            case PreComp:
                return new C0700(aux, layer, r5.m14264(layer.m60()), r5);
            case Solid:
                return new C0781(aux, layer);
            case Image:
                return new C0780(aux, layer, r5.m14266());
            case Null:
                return new C0720(aux, layer);
            case Text:
                return new C1017(aux, layer);
            case Unknown:
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.m66());
                return null;
        }
    }

    AbstractC0741(C1518aux aux, Layer layer) {
        this.f14321 = aux;
        this.f14324 = layer;
        this.f14328 = layer.m80() + "#draw";
        this.f14316.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f14317.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        if (layer.m72() == Layer.MatteType.Invert) {
            this.f14333.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f14333.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.f14327 = layer.m75().m15920();
        this.f14327.m16355(this);
        this.f14327.m16357(this);
        if (layer.m78() != null && !layer.m78().isEmpty()) {
            this.f14332 = new C0745(layer.m78());
            for (AbstractC1622coN<C0445, Path> con : this.f14332.m15159()) {
                m15134(con);
                con.mo5905(this);
            }
            for (AbstractC1622coN<Integer, Integer> con2 : this.f14332.m15161()) {
                m15134(con2);
                con2.mo5905(this);
            }
        }
        m15121();
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        m15130();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public Layer m15132() {
        return this.f14324;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15136(AbstractC0741 r1) {
        this.f14329 = r1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m15137() {
        return this.f14329 != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15133(AbstractC0741 r1) {
        this.f14330 = r1;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m15121() {
        if (!this.f14324.m69().isEmpty()) {
            final C1594cON con = new C1594cON(this.f14324.m69());
            con.m5906();
            con.mo5905(new AbstractC1622coN.AbstractC0107() { // from class: o.ᐤ.3
                @Override // o.AbstractC1622coN.AbstractC0107
                /* renamed from: ˎ */
                public void mo3789() {
                    AbstractC0741.this.m15127(((Float) con.mo5904()).floatValue() == 1.0f);
                }
            });
            m15127(((Float) con.mo5904()).floatValue() == 1.0f);
            m15134(con);
            return;
        }
        m15127(true);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m15130() {
        this.f14321.invalidateSelf();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15134(AbstractC1622coN<?, ?> con) {
        if (!(con instanceof C0418)) {
            this.f14315.add(con);
        }
    }

    @Override // o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        this.f14319.set(matrix);
        this.f14319.preConcat(this.f14327.m16353());
    }

    @Override // o.AbstractC0423
    @SuppressLint({"WrongConstant"})
    /* renamed from: ˎ */
    public void mo5647(Canvas canvas, Matrix matrix, int i) {
        C1466If.m5165(this.f14328);
        if (!this.f14318) {
            C1466If.m5166(this.f14328);
            return;
        }
        m15131();
        C1466If.m5165("Layer#parentMatrix");
        this.f14331.reset();
        this.f14331.set(matrix);
        for (int size = this.f14334.size() - 1; size >= 0; size--) {
            this.f14331.preConcat(this.f14334.get(size).f14327.m16353());
        }
        C1466If.m5166("Layer#parentMatrix");
        int intValue = (int) ((((((float) i) / 255.0f) * ((float) this.f14327.m16356().mo5904().intValue())) / 100.0f) * 255.0f);
        if (m15137() || m15135()) {
            C1466If.m5165("Layer#computeBounds");
            this.f14326.set(0.0f, 0.0f, 0.0f, 0.0f);
            mo5650(this.f14326, this.f14331);
            m15125(this.f14326, this.f14331);
            this.f14331.preConcat(this.f14327.m16353());
            m15128(this.f14326, this.f14331);
            this.f14326.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            C1466If.m5166("Layer#computeBounds");
            C1466If.m5165("Layer#saveLayer");
            canvas.saveLayer(this.f14326, this.f14314, 31);
            C1466If.m5166("Layer#saveLayer");
            m15124(canvas);
            C1466If.m5165("Layer#drawLayer");
            mo14760(canvas, this.f14331, intValue);
            C1466If.m5166("Layer#drawLayer");
            if (m15135()) {
                m15122(canvas, this.f14331);
            }
            if (m15137()) {
                C1466If.m5165("Layer#drawMatte");
                C1466If.m5165("Layer#saveLayer");
                canvas.saveLayer(this.f14326, this.f14333, 19);
                C1466If.m5166("Layer#saveLayer");
                m15124(canvas);
                this.f14329.mo5647(canvas, matrix, intValue);
                C1466If.m5165("Layer#restoreLayer");
                canvas.restore();
                C1466If.m5166("Layer#restoreLayer");
                C1466If.m5166("Layer#drawMatte");
            }
            C1466If.m5165("Layer#restoreLayer");
            canvas.restore();
            C1466If.m5166("Layer#restoreLayer");
            m15126(C1466If.m5166(this.f14328));
            return;
        }
        this.f14331.preConcat(this.f14327.m16353());
        C1466If.m5165("Layer#drawLayer");
        mo14760(canvas, this.f14331, intValue);
        C1466If.m5166("Layer#drawLayer");
        m15126(C1466If.m5166(this.f14328));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15126(float f) {
        this.f14321.m5698().m14261().m5161(this.f14324.m80(), f);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15124(Canvas canvas) {
        C1466If.m5165("Layer#clearLayer");
        canvas.drawRect(this.f14326.left - 1.0f, this.f14326.top - 1.0f, this.f14326.right + 1.0f, this.f14326.bottom + 1.0f, this.f14316);
        C1466If.m5166("Layer#clearLayer");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15128(RectF rectF, Matrix matrix) {
        this.f14325.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (m15135()) {
            int size = this.f14332.m15160().size();
            for (int i = 0; i < size; i++) {
                this.f14332.m15160().get(i);
                this.f14323.set(this.f14332.m15159().get(i).mo5904());
                this.f14323.transform(matrix);
                switch (r8.m23()) {
                    case MaskModeSubtract:
                        return;
                    case MaskModeIntersect:
                        return;
                    case MaskModeUnknown:
                        return;
                    case MaskModeAdd:
                    default:
                        this.f14323.computeBounds(this.f14322, false);
                        if (i == 0) {
                            this.f14325.set(this.f14322);
                        } else {
                            this.f14325.set(Math.min(this.f14325.left, this.f14322.left), Math.min(this.f14325.top, this.f14322.top), Math.max(this.f14325.right, this.f14322.right), Math.max(this.f14325.bottom, this.f14322.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.f14325.left), Math.max(rectF.top, this.f14325.top), Math.min(rectF.right, this.f14325.right), Math.min(rectF.bottom, this.f14325.bottom));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15125(RectF rectF, Matrix matrix) {
        if (m15137() && this.f14324.m72() != Layer.MatteType.Invert) {
            this.f14329.mo5650(this.f14320, matrix);
            rectF.set(Math.max(rectF.left, this.f14320.left), Math.max(rectF.top, this.f14320.top), Math.min(rectF.right, this.f14320.right), Math.min(rectF.bottom, this.f14320.bottom));
        }
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15122(Canvas canvas, Matrix matrix) {
        C1466If.m5165("Layer#drawMask");
        C1466If.m5165("Layer#saveLayer");
        canvas.saveLayer(this.f14326, this.f14317, 19);
        C1466If.m5166("Layer#saveLayer");
        m15124(canvas);
        int size = this.f14332.m15160().size();
        for (int i = 0; i < size; i++) {
            this.f14332.m15160().get(i);
            this.f14323.set(this.f14332.m15159().get(i).mo5904());
            this.f14323.transform(matrix);
            switch (r5.m23()) {
                case MaskModeSubtract:
                    this.f14323.setFillType(Path.FillType.INVERSE_WINDING);
                    break;
                case MaskModeAdd:
                default:
                    this.f14323.setFillType(Path.FillType.WINDING);
                    break;
            }
            AbstractC1622coN<Integer, Integer> con = this.f14332.m15161().get(i);
            int alpha = this.f14314.getAlpha();
            this.f14314.setAlpha((int) (((float) con.mo5904().intValue()) * 2.55f));
            canvas.drawPath(this.f14323, this.f14314);
            this.f14314.setAlpha(alpha);
        }
        C1466If.m5165("Layer#restoreLayer");
        canvas.restore();
        C1466If.m5166("Layer#restoreLayer");
        C1466If.m5166("Layer#drawMask");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m15135() {
        return this.f14332 != null && !this.f14332.m15159().isEmpty();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15127(boolean z) {
        if (z != this.f14318) {
            this.f14318 = z;
            m15130();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public void mo15013(float f) {
        if (this.f14324.m70() != 0.0f) {
            f /= this.f14324.m70();
        }
        if (this.f14329 != null) {
            this.f14329.mo15013(f);
        }
        for (int i = 0; i < this.f14315.size(); i++) {
            this.f14315.get(i).mo5907(f);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m15131() {
        if (this.f14334 == null) {
            if (this.f14330 == null) {
                this.f14334 = Collections.emptyList();
                return;
            }
            this.f14334 = new ArrayList();
            for (AbstractC0741 r1 = this.f14330; r1 != null; r1 = r1.f14330) {
                this.f14334.add(r1);
            }
        }
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f14324.m80();
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
    }
}
