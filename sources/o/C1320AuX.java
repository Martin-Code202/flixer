package o;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.AuX  reason: case insensitive filesystem */
public class C1320AuX implements AUX, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private C1354COn f4538;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f4539;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1518aux f4540;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1622coN<?, PointF> f4541;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1622coN<?, PointF> f4542;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f4543;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Path f4544 = new Path();

    public C1320AuX(C1518aux aux, AbstractC0741 r3, C0862 r4) {
        this.f4543 = r4.m15555();
        this.f4540 = aux;
        this.f4541 = r4.m15554().mo14241();
        this.f4542 = r4.m15553().mo14241();
        r3.m15134(this.f4541);
        r3.m15134(this.f4542);
        this.f4541.mo5905(this);
        this.f4542.mo5905(this);
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo3789() {
        m3787();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3787() {
        this.f4539 = false;
        this.f4540.invalidateSelf();
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        for (int i = 0; i < list.size(); i++) {
            AbstractC0420 r3 = list.get(i);
            if ((r3 instanceof C1354COn) && ((C1354COn) r3).m4285() == ShapeTrimPath.Type.Simultaneously) {
                this.f4538 = (C1354COn) r3;
                this.f4538.m4286(this);
            }
        }
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo3788() {
        return this.f4543;
    }

    @Override // o.AUX
    /* renamed from: ˏ */
    public Path mo3438() {
        if (this.f4539) {
            return this.f4544;
        }
        this.f4544.reset();
        PointF r7 = this.f4541.mo5904();
        float f = r7.x / 2.0f;
        float f2 = r7.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.f4544.reset();
        this.f4544.moveTo(0.0f, -f2);
        this.f4544.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
        this.f4544.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
        this.f4544.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
        this.f4544.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        PointF r12 = this.f4542.mo5904();
        this.f4544.offset(r12.x, r12.y);
        this.f4544.close();
        C1026.m16011(this.f4544, this.f4538);
        this.f4539 = true;
        return this.f4544;
    }
}
