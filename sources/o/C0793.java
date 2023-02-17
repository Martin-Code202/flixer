package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
/* renamed from: o.ᒮ  reason: contains not printable characters */
public final class C0793 extends ConstraintLayout {

    /* renamed from: ˊ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f14456 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0793.class), "topBox", "getTopBox()Lcom/netflix/mediaclient/android/widget/AdvancedImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0793.class), "middleBox", "getMiddleBox()Landroid/widget/ImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0793.class), "bottomBox", "getBottomBox()Landroid/widget/ImageView;"))};

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0794 f14457 = new C0794(null);

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f14458 = m15267(5.0f);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final FI f14459 = C1197.m16465(this, (int) R.id.middle_box);

    /* renamed from: ˏ  reason: contains not printable characters */
    private final FI f14460 = C1197.m16465(this, (int) R.id.bottom_box);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final FI f14461 = C1197.m16465(this, (int) R.id.top_box);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f14462 = m15267(2.0f);

    /* renamed from: ˋ  reason: contains not printable characters */
    public final ImageView m15270() {
        return (ImageView) this.f14459.mo4986(this, f14456[1]);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final ImageView m15271() {
        return (ImageView) this.f14460.mo4986(this, f14456[2]);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final C0522 m15272() {
        return (C0522) this.f14461.mo4986(this, f14456[0]);
    }

    /* renamed from: o.ᒮ$ˋ  reason: contains not printable characters */
    public static final class C0794 {
        private C0794() {
        }

        public /* synthetic */ C0794(C1456Fq fq) {
            this();
        }
    }

    public final void setStartMargin(int i) {
        this.f14458 = i;
    }

    public final void setTopMargin(int i) {
        this.f14462 = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0793(Context context) {
        super(context);
        C1457Fr.m5025(context, "context");
        ConstraintLayout.inflate(getContext(), R.layout.multi_title_notifications_stack, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0793(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(attributeSet, "attrs");
        ConstraintLayout.inflate(getContext(), R.layout.multi_title_notifications_stack, this);
        setupAttributes(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0793(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(attributeSet, "attrs");
        ConstraintLayout.inflate(getContext(), R.layout.multi_title_notifications_stack, this);
        setupAttributes(attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.constraint.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        m15266(m15272(), size, size2);
        m15266(m15270(), size, size2);
        m15266(m15271(), size, size2);
        super.onMeasure(i, i2);
    }

    public final void setupAttributes(AttributeSet attributeSet) {
        C1457Fr.m5025(attributeSet, "attrs");
        Context context = getContext();
        C1457Fr.m5016((Object) context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.C0006.NotificationsStackView, 0, 0);
        try {
            int color = obtainStyledAttributes.getColor(3, ContextCompat.getColor(getContext(), R.color.top_box_color));
            int color2 = obtainStyledAttributes.getColor(1, ContextCompat.getColor(getContext(), R.color.middle_box_color));
            int color3 = obtainStyledAttributes.getColor(0, ContextCompat.getColor(getContext(), R.color.bottom_box_color));
            this.f14458 = m15267(obtainStyledAttributes.getDimension(2, 5.0f));
            this.f14462 = m15267(obtainStyledAttributes.getDimension(4, 2.0f));
            m15272().setBorderColor(color);
            m15272().setBackground(new ColorDrawable(color));
            m15270().setBackground(new ColorDrawable(color2));
            m15271().setBackground(new ColorDrawable(color3));
            m15269(m15270(), this.f14458, this.f14462);
            m15269(m15271(), this.f14458, this.f14462);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m15269(ImageView imageView, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        requestLayout();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean m15268(int i, int i2) {
        return i - (this.f14458 * 2) > 0 && i2 - (this.f14462 * 2) > 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int m15267(float f) {
        Resources resources = getResources();
        C1457Fr.m5016((Object) resources, "resources");
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m15266(ImageView imageView, int i, int i2) {
        if (m15268(i, i2)) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = i - (this.f14458 * 2);
            marginLayoutParams.height = i2 - (this.f14462 * 2);
            requestLayout();
        }
    }
}
