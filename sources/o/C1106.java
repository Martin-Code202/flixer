package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import o.C0602;
/* renamed from: o.灬  reason: contains not printable characters */
public final class C1106 extends ViewGroup {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C1107 f15310 = new C1107(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f15311;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f15312;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f15313;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Drawable f15314;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f15315;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final View.OnClickListener f15316;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<Integer> f15317;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f15318;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Cif f15319;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f15320;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC2410iF f15321;

    /* renamed from: o.灬$iF  reason: case insensitive filesystem */
    public interface AbstractC2410iF {
        /* renamed from: ˊ */
        int mo10300();

        /* renamed from: ˊ */
        CharSequence mo10301(int i);

        /* renamed from: ˏ */
        boolean mo10303(int i);

        /* renamed from: ॱ */
        void mo10304(int i);
    }

    /* renamed from: o.灬$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˏ */
        void mo10297(View view, int i);
    }

    public C1106(Context context) {
        this(context, null, 0, 6, null);
    }

    public C1106(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1106(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f15318 = -1;
        this.f15315 = getResources().getDimensionPixelOffset(C0602.C0603.tags_separator_padding);
        this.f15317 = new ArrayList();
        this.f15320 = Integer.MAX_VALUE;
        this.f15312 = 8388611;
        this.f15316 = new If(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0602.aux.TagsLayout);
            try {
                this.f15320 = obtainStyledAttributes.getInt(C0602.aux.TagsLayout_tl_maxLines, this.f15320);
                this.f15311 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.TagsLayout_tl_horizontalSpacing, 0);
                this.f15313 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.TagsLayout_tl_verticalSpacing, 0);
                this.f15318 = obtainStyledAttributes.getResourceId(C0602.aux.TagsLayout_tl_layoutRes, this.f15318);
                setGravity(obtainStyledAttributes.getLayoutDimension(C0602.aux.TagsLayout_android_gravity, 8388611));
                this.f15315 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.TagsLayout_tl_separatorPadding, this.f15315);
                if (obtainStyledAttributes.hasValue(C0602.aux.TagsLayout_tl_separatorDrawable)) {
                    m16227(obtainStyledAttributes.getDrawable(C0602.aux.TagsLayout_tl_separatorDrawable));
                }
                if (this.f15318 == -1) {
                    throw new IllegalArgumentException("Attribute tl_layoutRes is mandatory and should be a layout res id");
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1106(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.灬$ˊ  reason: contains not printable characters */
    public static final class C1107 {
        private C1107() {
        }

        public /* synthetic */ C1107(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final int m16233(int i, int i2, int i3, int i4) {
            int i5;
            int i6 = i4 - i3;
            switch (i) {
                case 1:
                    i5 = i6 / 2;
                    break;
                case 5:
                    i5 = i6;
                    break;
                case 17:
                    i5 = i6 / 2;
                    break;
                case 8388613:
                    i5 = i6;
                    break;
                default:
                    i5 = 0;
                    break;
            }
            return i2 == 1 ? -i5 : i5;
        }
    }

    public final void setTagLayoutRes(int i) {
        this.f15318 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m16227(Drawable drawable) {
        this.f15314 = drawable;
        setWillNotDraw(this.f15314 == null);
        invalidate();
    }

    public final void setSeparatorPadding(int i) {
        this.f15315 = i;
    }

    public final void setMaxLines(int i) {
        this.f15320 = i;
    }

    public final void setHorizontalSpacing(int i) {
        this.f15311 = i;
    }

    public final void setVerticalSpacing(int i) {
        this.f15313 = i;
    }

    public final void setGravity(int i) {
        this.f15312 = i;
        requestLayout();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final AbstractC2410iF m16229() {
        return this.f15321;
    }

    public final void setAdapter(AbstractC2410iF iFVar) {
        for (View view : C0549.m14593(this)) {
            view.setVisibility(8);
        }
        this.f15321 = iFVar;
        requestLayout();
    }

    /* renamed from: o.灬$If */
    static final class If implements View.OnClickListener {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C1106 f15322;

        If(C1106 r1) {
            this.f15322 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Cif r0 = this.f15322.m16232();
            if (r0 != null) {
                C1457Fr.m5016((Object) view, "view");
                r0.mo10297(view, this.f15322.indexOfChild(view));
            }
        }
    }

    public final void setOnTagClickListener(Cif ifVar) {
        this.f15319 = ifVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final Cif m16232() {
        return this.f15319;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final View m16226(int i) {
        if (i >= m16225()) {
            return null;
        }
        AbstractC2410iF r0 = m16229();
        boolean z = r0 != null && r0.mo10303(i);
        View childAt = getChildAt(i);
        if (childAt == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f15318, (ViewGroup) this, false);
            addViewInLayout(inflate, -1, new C1108(-2, -2), true);
            childAt = inflate;
        }
        C1457Fr.m5016((Object) childAt, "tag");
        childAt.setVisibility(0);
        View findViewById = childAt.findViewById(C0602.IF.text);
        C1457Fr.m5016((Object) findViewById, "tag.findViewById<TextView>(R.id.text)");
        TextView textView = (TextView) findViewById;
        AbstractC2410iF r1 = m16229();
        textView.setText(r1 != null ? r1.mo10301(i) : null);
        childAt.setOnClickListener(z ? this.f15316 : null);
        childAt.setClickable(z);
        return childAt;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        C1457Fr.m5025(canvas, "canvas");
        Drawable drawable = this.f15314;
        if (drawable != null) {
            int size = this.f15317.size();
            for (int i = 0; i < size; i++) {
                int intValue = this.f15317.get(i).intValue();
                int measuredHeight = (getMeasuredHeight() / 2) - (drawable.getIntrinsicHeight() / 2);
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                canvas.save();
                drawable.setBounds(intValue, measuredHeight, intValue + intrinsicWidth, measuredHeight + intrinsicHeight);
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int m16225() {
        AbstractC2410iF r0 = m16229();
        if (r0 != null) {
            return r0.mo10300();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int mode = View.MeasureSpec.getMode(i);
        int layoutDirection = getLayoutDirection();
        boolean z = mode != 0;
        int i4 = 0;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        int r14 = m16225();
        int i8 = 0;
        ArrayList arrayList = new ArrayList();
        while (i8 < r14 && i6 <= this.f15320) {
            View r17 = m16226(i8);
            if (r17 == null || r17.getVisibility() == 8) {
                i8++;
            } else {
                measureChild(r17, i, i2);
                ViewGroup.LayoutParams layoutParams = r17.getLayoutParams();
                if (layoutParams == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.widgetry.widget.TagsLayout.LayoutParams");
                }
                C1108 r18 = (C1108) layoutParams;
                Drawable drawable = this.f15314;
                int intrinsicWidth = drawable != null ? drawable.getIntrinsicWidth() : 0;
                i7 = this.f15311;
                if (this.f15314 != null) {
                    i7 += (this.f15315 * 2) + intrinsicWidth;
                }
                if (z && r17.getMeasuredWidth() + paddingLeft > size) {
                    if (i6 == this.f15320) {
                        removeViewInLayout(r17);
                        if (i8 >= r14) {
                            break;
                        }
                        i8++;
                    } else {
                        paddingTop += this.f15313 + i5;
                        i5 = 0;
                        i4 = Math.max(i4, paddingLeft - i7);
                        paddingLeft = getPaddingLeft();
                        i6++;
                    }
                }
                if (layoutDirection == 1) {
                    r18.m16236((size - paddingLeft) - r17.getMeasuredWidth());
                } else {
                    r18.m16236(paddingLeft);
                }
                r18.m16238(paddingTop);
                paddingLeft += r17.getMeasuredWidth() + i7;
                i5 = Math.max(i5, r17.getMeasuredHeight());
                if (this.f15314 != null) {
                    if (layoutDirection == 1) {
                        i3 = (size - paddingLeft) - this.f15315;
                    } else {
                        i3 = (paddingLeft - this.f15315) - intrinsicWidth;
                    }
                    if (!arrayList.contains(Integer.valueOf(i3))) {
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
                AbstractC2410iF r0 = m16229();
                if (r0 != null) {
                    r0.mo10304(i8);
                }
                i8++;
            }
        }
        int max = Math.max(i4, paddingLeft - i7) + getPaddingRight();
        int paddingBottom = paddingTop + getPaddingBottom() + i5;
        if (layoutDirection == 1 && getLayoutParams().width == -2 && size != max) {
            int i9 = size - max;
            for (View view : C0549.m14593(this)) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.widgetry.widget.TagsLayout.LayoutParams");
                }
                C1108 r22 = (C1108) layoutParams2;
                r22.m16236(r22.m16237() - i9);
            }
        }
        if (size > 0 && i8 == r14 && this.f15312 != 8388611 && this.f15312 != 3) {
            int r172 = f15310.m16233(this.f15312, layoutDirection, max, size);
            for (View view2 : C0549.m14593(this)) {
                view2.setTranslationX((float) r172);
            }
            if (this.f15314 != null) {
                int size2 = arrayList.size() - 1;
                for (int i10 = 0; i10 < size2; i10++) {
                    this.f15317.add(Integer.valueOf(((Number) arrayList.get(i10)).intValue() + r172));
                }
            }
        }
        setMeasuredDimension(View.resolveSize(max, i), View.resolveSize(paddingBottom, i2));
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Iterable<View> r5 = C0549.m14593(this);
        ArrayList<View> arrayList = new ArrayList();
        for (View view : r5) {
            if (view.getVisibility() != 8) {
                arrayList.add(view);
            }
        }
        for (View view2 : arrayList) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.widgetry.widget.TagsLayout.LayoutParams");
            }
            C1108 r9 = (C1108) layoutParams;
            view2.layout(r9.m16237(), r9.m16235(), r9.m16237() + view2.getMeasuredWidth(), r9.m16235() + view2.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C1457Fr.m5025(layoutParams, "p");
        return layoutParams instanceof C1108;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1108 generateDefaultLayoutParams() {
        return new C1108(-2, -2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1108 generateLayoutParams(AttributeSet attributeSet) {
        C1457Fr.m5025(attributeSet, "attrs");
        Context context = getContext();
        C1457Fr.m5016((Object) context, "context");
        return new C1108(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public C1108 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C1457Fr.m5025(layoutParams, "p");
        return new C1108(layoutParams.width, layoutParams.height);
    }

    /* renamed from: o.灬$ˋ  reason: contains not printable characters */
    public static final class C1108 extends ViewGroup.LayoutParams {

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f15323;

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f15324;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m16236(int i) {
            this.f15324 = i;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final int m16237() {
            return this.f15324;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final int m16235() {
            return this.f15323;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m16238(int i) {
            this.f15323 = i;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1108(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C1457Fr.m5025(context, "context");
            C1457Fr.m5025(attributeSet, "attrs");
        }

        public C1108(int i, int i2) {
            super(i, i2);
        }
    }
}
