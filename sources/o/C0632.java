package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.Layer;
import java.util.Collections;
/* renamed from: o.ۦ  reason: contains not printable characters */
public class C0632 extends AbstractC0741 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1517auX f13945;

    C0632(C1518aux aux, Layer layer) {
        super(aux, layer);
        this.f13945 = new C1517auX(aux, this, new C0551(layer.m80(), layer.m73()));
        this.f13945.mo3790(Collections.emptyList(), Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC0741
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo14760(Canvas canvas, Matrix matrix, int i) {
        this.f13945.mo5647(canvas, matrix, i);
    }

    @Override // o.AbstractC0741, o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        super.mo5650(rectF, matrix);
        this.f13945.mo5650(rectF, this.f14319);
    }

    @Override // o.AbstractC0741, o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
        this.f13945.mo5648(str, str2, colorFilter);
    }
}
