package o;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.widget.AdapterView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import java.util.List;
/* renamed from: o.rv  reason: case insensitive filesystem */
public class C2133rv extends AppCompatSpinner {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AdapterView.OnItemSelectedListener f9947;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Drawable f9948;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AdapterView.OnItemSelectedListener f9949;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Drawable f9950;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected AbstractC0774 f9951 = new C0521(this);

    public C2133rv(Context context) {
        super(context, null);
        m10483();
    }

    public C2133rv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10483();
    }

    public C2133rv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10483();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10483() {
        this.f9948 = getBackground();
        getBackground().setColorFilter(BrowseExperience.m1767((Activity) C1322Av.m3791(getContext(), Activity.class), 16842806), PorterDuff.Mode.SRC_ATOP);
        this.f9950 = getResources().getDrawable(R.color.transparent);
        setId(R.id.season_selector);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m10486(int i) {
        return ((C2130rs) getAdapter()).m10476(i);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f9947 = onItemSelectedListener;
    }

    public void setOnItemTouchListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f9949 = onItemSelectedListener;
    }

    @Override // android.widget.AbsSpinner, android.widget.AdapterView
    public void setSelection(int i) {
        C1283.m16846("SeasonsSpinner", "Setting selection to position: " + i);
        super.setSelection(i);
        if (this.f9947 != null) {
            this.f9947.onItemSelected(this, this, i, 1);
        }
        if (this.f9949 != null) {
            this.f9949.onItemSelected(this, this, i, getSelectedItemId());
        }
    }

    public void setNonTouchSelection(int i) {
        C1283.m16846("SeasonsSpinner", "Setting selection to position: " + i);
        super.setSelection(i);
        if (this.f9947 != null) {
            this.f9947.onItemSelected(this, this, i, 0);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m10484(List<pS> list) {
        ((C2130rs) getAdapter()).m10477(list);
        boolean z = getAdapter().getCount() > 1;
        setEnabled(z);
        if (z) {
            setBackground(this.f9948);
        } else {
            setBackground(this.f9950);
        }
        if (BX.m3957() && getPaddingRight() > getPaddingLeft()) {
            setPadding(getPaddingRight(), getPaddingTop(), getPaddingLeft(), getPaddingBottom());
        }
    }

    public void setBackground(Drawable drawable, Drawable drawable2) {
        this.f9948 = drawable;
        this.f9950 = drawable2;
    }

    public void setPressedStateHandlerEnabled(boolean z) {
        this.f9951.m15233(z);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSetPressed(boolean z) {
        if (m10485()) {
            this.f9951.m15231(z);
        }
        super.dispatchSetPressed(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m10485() {
        return true;
    }
}
