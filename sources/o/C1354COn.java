package o;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.COn  reason: case insensitive filesystem */
public class C1354COn implements AbstractC0420, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f4990;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ShapeTrimPath.Type f4991;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<AbstractC1622coN.AbstractC0107> f4992 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f4993;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f4994;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f4995;

    public C1354COn(AbstractC0741 r2, ShapeTrimPath shapeTrimPath) {
        this.f4990 = shapeTrimPath.m56();
        this.f4991 = shapeTrimPath.m54();
        this.f4994 = shapeTrimPath.m53().mo14241();
        this.f4993 = shapeTrimPath.m55().mo14241();
        this.f4995 = shapeTrimPath.m57().mo14241();
        r2.m15134(this.f4994);
        r2.m15134(this.f4993);
        r2.m15134(this.f4995);
        this.f4994.mo5905(this);
        this.f4993.mo5905(this);
        this.f4995.mo5905(this);
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        for (int i = 0; i < this.f4992.size(); i++) {
            this.f4992.get(i).mo3789();
        }
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f4990;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4286(AbstractC1622coN.AbstractC0107 r2) {
        this.f4992.add(r2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public ShapeTrimPath.Type m4285() {
        return this.f4991;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1622coN<?, Float> m4288() {
        return this.f4994;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC1622coN<?, Float> m4287() {
        return this.f4993;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public AbstractC1622coN<?, Float> m4289() {
        return this.f4995;
    }
}
