package o;

import android.content.Context;
import android.util.AttributeSet;
import com.netflix.android.widgetry.widget.TrackedRecyclerView;
/* renamed from: o.ᓱ  reason: contains not printable characters */
public class C0840 extends TrackedRecyclerView {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f14670 = "RowRecyclerView";

    public C0840(Context context) {
        super(context);
    }

    public C0840(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C0840(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTrackingName(String str) {
        this.f14670 = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.android.widgetry.widget.TrackedRecyclerView
    /* renamed from: ˎ */
    public String mo110() {
        return this.f14670;
    }
}
