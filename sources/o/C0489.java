package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
/* renamed from: o.Ч  reason: contains not printable characters */
public class C0489 extends FrameLayout {
    public C0489(Context context) {
        super(context);
        m14453();
    }

    public C0489(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14453();
    }

    public C0489(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14453();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14453() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.loading_inset, this);
    }
}
