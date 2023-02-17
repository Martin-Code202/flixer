package o;

import android.content.Context;
import android.util.AttributeSet;
import com.netflix.mediaclient.R;
public class uK extends uC {
    public uK(Context context) {
        super(context);
    }

    public uK(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public uK(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @Override // o.uC
    /* renamed from: ˏ */
    public int mo11334() {
        return R.layout.trailer_view;
    }

    @Override // o.uC
    /* renamed from: ˊ */
    public String mo11331(AbstractC2074pw pwVar) {
        if (pwVar == null) {
            return null;
        }
        return pwVar.createModifiedStillUrl();
    }
}
