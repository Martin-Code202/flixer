package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.netflix.mediaclient.R;
/* renamed from: o.ᒌ  reason: contains not printable characters */
public final class C0772 extends Toolbar {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final If f14409 = new If(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f14410;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f14411;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f14412;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f14413;

    /* renamed from: o.ᒌ$If */
    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0772(Context context) {
        super(context);
        C1457Fr.m5025(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842806, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.data, new int[]{16842806});
        this.f14413 = obtainStyledAttributes.getColor(0, -1);
        this.f14412 = obtainStyledAttributes.getColor(0, -1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0772(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
        C1457Fr.m5025(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0772(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        m15225(attributeSet, i);
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m15225(AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, android.support.v7.appcompat.R.styleable.Toolbar, i, 0);
        this.f14410 = obtainStyledAttributes.getResourceId(27, 0);
        this.f14411 = obtainStyledAttributes.getResourceId(18, 0);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        if (this.f14410 != 0) {
            appCompatTextView.setTextAppearance(getContext(), this.f14410);
        }
        if (obtainStyledAttributes.hasValue(28)) {
            i2 = obtainStyledAttributes.getColor(28, 0);
        } else {
            i2 = appCompatTextView.getCurrentTextColor();
        }
        this.f14413 = i2;
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(getContext());
        if (this.f14411 != 0) {
            appCompatTextView2.setTextAppearance(getContext(), this.f14411);
        }
        if (obtainStyledAttributes.hasValue(19)) {
            i3 = obtainStyledAttributes.getColor(19, 0);
        } else {
            i3 = appCompatTextView2.getCurrentTextColor();
        }
        this.f14412 = i3;
        obtainStyledAttributes.recycle();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final int m15226() {
        return this.f14410;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final int m15229() {
        return this.f14413;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final int m15228() {
        return this.f14411;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final int m15227() {
        return this.f14412;
    }
}
