package o;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.cOn  reason: case insensitive filesystem */
public class C1595cOn implements AUX, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f6232;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1354COn f6233;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Path f6234 = new Path();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1518aux f6235;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final RectF f6236 = new RectF();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f6237;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, PointF> f6238;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f6239;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC1622coN<?, PointF> f6240;

    public C1595cOn(C1518aux aux, AbstractC0741 r3, C1022 r4) {
        this.f6237 = r4.m15990();
        this.f6235 = aux;
        this.f6238 = r4.m15989().mo14241();
        this.f6240 = r4.m15991().mo14241();
        this.f6232 = r4.m15988().mo14241();
        r3.m15134(this.f6238);
        r3.m15134(this.f6240);
        r3.m15134(this.f6232);
        this.f6238.mo5905(this);
        this.f6240.mo5905(this);
        this.f6232.mo5905(this);
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f6237;
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        m5835();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5835() {
        this.f6239 = false;
        this.f6235.invalidateSelf();
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        for (int i = 0; i < list.size(); i++) {
            AbstractC0420 r3 = list.get(i);
            if ((r3 instanceof C1354COn) && ((C1354COn) r3).m4285() == ShapeTrimPath.Type.Simultaneously) {
                this.f6233 = (C1354COn) r3;
                this.f6233.m4286(this);
            }
        }
    }

    @Override // o.AUX
    /* renamed from: ˏ */
    public Path mo3438() {
        if (this.f6239) {
            return this.f6234;
        }
        this.f6234.reset();
        PointF r6 = this.f6240.mo5904();
        float f = r6.x / 2.0f;
        float f2 = r6.y / 2.0f;
        float floatValue = this.f6232 == null ? 0.0f : this.f6232.mo5904().floatValue();
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF r11 = this.f6238.mo5904();
        this.f6234.moveTo(r11.x + f, (r11.y - f2) + floatValue);
        this.f6234.lineTo(r11.x + f, (r11.y + f2) - floatValue);
        if (floatValue > 0.0f) {
            this.f6236.set((r11.x + f) - (2.0f * floatValue), (r11.y + f2) - (2.0f * floatValue), r11.x + f, r11.y + f2);
            this.f6234.arcTo(this.f6236, 0.0f, 90.0f, false);
        }
        this.f6234.lineTo((r11.x - f) + floatValue, r11.y + f2);
        if (floatValue > 0.0f) {
            this.f6236.set(r11.x - f, (r11.y + f2) - (2.0f * floatValue), (r11.x - f) + (2.0f * floatValue), r11.y + f2);
            this.f6234.arcTo(this.f6236, 90.0f, 90.0f, false);
        }
        this.f6234.lineTo(r11.x - f, (r11.y - f2) + floatValue);
        if (floatValue > 0.0f) {
            this.f6236.set(r11.x - f, r11.y - f2, (r11.x - f) + (2.0f * floatValue), (r11.y - f2) + (2.0f * floatValue));
            this.f6234.arcTo(this.f6236, 180.0f, 90.0f, false);
        }
        this.f6234.lineTo((r11.x + f) - floatValue, r11.y - f2);
        if (floatValue > 0.0f) {
            this.f6236.set((r11.x + f) - (2.0f * floatValue), r11.y - f2, r11.x + f, (r11.y - f2) + (2.0f * floatValue));
            this.f6234.arcTo(this.f6236, 270.0f, 90.0f, false);
        }
        this.f6234.close();
        C1026.m16011(this.f6234, this.f6233);
        this.f6239 = true;
        return this.f6234;
    }
}
