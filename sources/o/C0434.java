package o;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.ˌ  reason: contains not printable characters */
public class C0434 implements AUX, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1354COn f13452;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1518aux f13453;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Path f13454 = new Path();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f13455;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13456;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Path> f13457;

    public C0434(C1518aux aux, AbstractC0741 r3, C0364 r4) {
        this.f13455 = r4.m14064();
        this.f13453 = aux;
        this.f13457 = r4.m14063().mo14241();
        r3.m15134(this.f13457);
        this.f13457.mo5905(this);
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        m14281();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14281() {
        this.f13456 = false;
        this.f13453.invalidateSelf();
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        for (int i = 0; i < list.size(); i++) {
            AbstractC0420 r3 = list.get(i);
            if ((r3 instanceof C1354COn) && ((C1354COn) r3).m4285() == ShapeTrimPath.Type.Simultaneously) {
                this.f13452 = (C1354COn) r3;
                this.f13452.m4286(this);
            }
        }
    }

    @Override // o.AUX
    /* renamed from: ˏ */
    public Path mo3438() {
        if (this.f13456) {
            return this.f13454;
        }
        this.f13454.reset();
        this.f13454.set(this.f13457.mo5904());
        this.f13454.setFillType(Path.FillType.EVEN_ODD);
        C1026.m16011(this.f13454, this.f13452);
        this.f13456 = true;
        return this.f13454;
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f13455;
    }
}
