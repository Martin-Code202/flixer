package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import o.C0602;
/* renamed from: o.ﮄ  reason: contains not printable characters */
public final class C1133 extends ViewGroup {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C1134 f15368 = new C1134(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f15369;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f15370;

    /* renamed from: ʽ  reason: contains not printable characters */
    private float f15371;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f15372;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final List<Cif> f15373;

    /* renamed from: ˋ  reason: contains not printable characters */
    private float f15374;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f15375;

    /* renamed from: ˎ  reason: contains not printable characters */
    private float f15376;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f15377;

    /* renamed from: ॱ  reason: contains not printable characters */
    private float f15378;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private If f15379;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f15380;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f15381;

    public C1133(Context context) {
        this(context, null, 0, 6, null);
    }

    public C1133(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1133(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f15372 = 3;
        this.f15376 = 0.5f;
        this.f15378 = 1.67f;
        this.f15373 = new ArrayList();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0602.aux.ScaledItemListView);
            try {
                this.f15372 = obtainStyledAttributes.getInt(C0602.aux.ScaledItemListView_silv_num_items, this.f15372);
                this.f15376 = obtainStyledAttributes.getFloat(C0602.aux.ScaledItemListView_silv_first_item_proportion, this.f15376);
                this.f15378 = obtainStyledAttributes.getFloat(C0602.aux.ScaledItemListView_silv_magnification_factor, this.f15378);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1133(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.ﮄ$ˊ  reason: contains not printable characters */
    public static final class C1134 {
        private C1134() {
        }

        public /* synthetic */ C1134(C1456Fq fq) {
            this();
        }
    }

    public final void setCurrScrollRatio(float f) {
        this.f15374 = f;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final float m16295() {
        return this.f15374;
    }

    public final void setAdapter(If r1) {
        this.f15379 = r1;
        m16291();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == i3 && i2 == i4) && this.f15370 == 0) {
            this.f15370 = (int) (((float) ((i - getPaddingStart()) - getPaddingEnd())) * this.f15376);
            if (this.f15370 == 0) {
                this.f15370 = (i - getPaddingStart()) - getPaddingEnd();
            }
            this.f15380 = (int) ((((float) ((i - getPaddingStart()) - getPaddingEnd())) * (1.0f - this.f15376)) / ((float) (this.f15372 - 1)));
            this.f15377 = (i2 - getPaddingTop()) - getPaddingBottom();
            this.f15381 = (int) (((float) this.f15377) / this.f15378);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m16291() {
        if (this.f15373.isEmpty()) {
            If r2 = this.f15379;
            if (r2 != null) {
                int i = this.f15372 + 1;
                for (int i2 = 0; i2 < i; i2++) {
                    Cif r5 = r2.mo13596(this);
                    addView(r5.m16309());
                    this.f15373.add(r5);
                }
            } else {
                return;
            }
        } else {
            int size = this.f15373.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f15373.get(i3).mo13602();
            }
        }
        this.f15369 = true;
        requestLayout();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m16300() {
        if (!(this.f15373.isEmpty() || this.f15379 == null)) {
            int i = -1;
            int size = this.f15373.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i == -1) {
                    i = this.f15373.get(i2).m16306();
                } else {
                    this.f15373.get(i2).mo13603(i);
                }
                i++;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int m16288(int i) {
        int paddingStart = i - getPaddingStart();
        if (paddingStart > this.f15370) {
            return this.f15380;
        }
        if (paddingStart < 0) {
            return this.f15370;
        }
        return this.f15380 + ((int) ((((float) (this.f15370 - this.f15380)) * ((float) (this.f15370 - Math.abs(paddingStart)))) / ((float) this.f15370)));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int m16293(int i) {
        int paddingStart = i - getPaddingStart();
        if (paddingStart > this.f15370) {
            return this.f15381;
        }
        if (paddingStart < 0) {
            return this.f15377;
        }
        return this.f15381 + ((int) ((((float) (this.f15377 - this.f15381)) * ((float) (this.f15370 - Math.abs(paddingStart)))) / ((float) this.f15370)));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final float m16290(int i) {
        if (i > 0) {
            return 1.0f;
        }
        return ((float) (this.f15370 - Math.abs(i))) / ((float) this.f15370);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m16298(float f) {
        if (f != this.f15374 && this.f15379 != null) {
            this.f15371 = f;
            Log.d("ScaledItemListView", "onScrollRatioChanged: currScrollRatio = " + this.f15374 + ", pendingScrollRatio = " + f);
            requestLayout();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m16299(int i) {
        If r2 = this.f15379;
        if (r2 != null) {
            int size = r2.m16302().size();
            if (0 <= i && size >= i) {
                this.f15375 = i;
                this.f15374 = 0.0f;
                this.f15371 = 0.0f;
                m16291();
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m16292() {
        int i;
        if (!this.f15373.isEmpty()) {
            Log.d("ScaledItemListView", "recomputeLayout: BEFORE " + this.f15373);
            int i2 = ((int) (this.f15374 * ((float) this.f15370))) - ((int) (this.f15371 * ((float) this.f15370)));
            this.f15374 = this.f15371;
            if (this.f15369) {
                i = getPaddingStart();
            } else {
                i = i2 + this.f15373.get(0).m16303().m16310();
            }
            int i3 = -1;
            int size = this.f15373.size();
            for (int i4 = 0; i4 < size; i4++) {
                Cif ifVar = this.f15373.get(i4);
                C1135 r9 = ifVar.m16303();
                r9.m16311(i);
                r9.width = m16288(r9.m16310());
                r9.height = m16293(r9.m16310());
                ifVar.m16309().setAlpha(m16290(r9.m16310()));
                i += r9.width;
                if (r9.m16310() > getWidth() || r9.m16310() + ifVar.m16309().getWidth() < 0) {
                    i3 = i4;
                }
            }
            Log.d("ScaledItemListView", "recomputeLayout: INTERM " + this.f15373);
            if (!this.f15369) {
                m16289(i3);
            }
            Log.d("ScaledItemListView", "recomputeLayout: AFTER " + this.f15373);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m16289(int i) {
        int i2;
        if (i != -1 && i < this.f15373.size()) {
            Cif remove = this.f15373.remove(i);
            remove.mo13602();
            boolean z = i == 0;
            Cif ifVar = z ? (Cif) EI.m4840((List<? extends Object>) this.f15373) : (Cif) EI.m4833((List<? extends Object>) this.f15373);
            remove.m16303().width = this.f15370;
            C1135 r0 = remove.m16303();
            int r1 = ifVar.m16303().m16310();
            if (z) {
                i2 = ifVar.m16303().width;
            } else {
                i2 = -remove.m16303().width;
            }
            r0.m16311(r1 + i2);
            remove.m16303().height = m16293(remove.m16303().m16310());
            remove.m16309().setAlpha(m16290(remove.m16303().m16310()));
            int i3 = -1;
            if (z) {
                this.f15373.add(remove);
                if (ifVar.m16306() != -1) {
                    i3 = ifVar.m16306() + 1;
                }
            } else {
                this.f15373.add(0, remove);
                if (ifVar.m16306() != -1) {
                    i3 = ifVar.m16306() - 1;
                }
            }
            Log.d("ScaledItemListView", "recycleDisplacedView: oldPosition = " + i + ", newPosition = " + i3);
            remove.m16304(i3);
            remove.m16307(true);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int size = this.f15373.size();
        for (int i5 = 0; i5 < size; i5++) {
            Cif ifVar = this.f15373.get(i5);
            C1135 r8 = ifVar.m16303();
            ifVar.m16309().layout(r8.m16310(), getPaddingTop(), r8.m16310() + r8.width, i4 - getPaddingBottom());
            if (this.f15369) {
                ifVar.mo13603(this.f15375 + i5);
            } else if (ifVar.m16305()) {
                ifVar.mo13603(ifVar.m16306());
            }
        }
        this.f15369 = false;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m16292();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                measureChild(childAt, i, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C1457Fr.m5025(layoutParams, "lp");
        return layoutParams instanceof C1135;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1135 generateDefaultLayoutParams() {
        return new C1135(-2, -2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1135 generateLayoutParams(AttributeSet attributeSet) {
        C1457Fr.m5025(attributeSet, "attrs");
        Context context = getContext();
        C1457Fr.m5016((Object) context, "context");
        return new C1135(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public C1135 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C1457Fr.m5025(layoutParams, "lp");
        return new C1135(layoutParams.width, layoutParams.height);
    }

    /* renamed from: o.ﮄ$ˋ  reason: contains not printable characters */
    public static final class C1135 extends ViewGroup.LayoutParams {

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f15387;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final int m16310() {
            return this.f15387;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m16311(int i) {
            this.f15387 = i;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1135(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C1457Fr.m5025(context, "context");
            C1457Fr.m5025(attributeSet, "attrs");
        }

        public C1135(int i, int i2) {
            super(i, i2);
        }
    }

    /* renamed from: o.ﮄ$If */
    public static abstract class If {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final List<Object> f15382;

        public If() {
            this(null, 1, null);
        }

        /* renamed from: ˋ */
        public abstract Cif mo13596(ViewGroup viewGroup);

        public If(List<Object> list) {
            C1457Fr.m5025(list, "dataList");
            this.f15382 = list;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ If(List list, int i, C1456Fq fq) {
            this((i & 1) != 0 ? new ArrayList() : list);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final List<Object> m16302() {
            return this.f15382;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final Object m16301(int i) {
            if (i < 0 || i >= this.f15382.size()) {
                return null;
            }
            return this.f15382.get(i);
        }
    }

    /* renamed from: o.ﮄ$if  reason: invalid class name */
    public static abstract class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean f15383;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final View f15384;

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f15385;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final If f15386;

        /* renamed from: ˋ */
        public abstract void mo13601(Object obj);

        public Cif(View view, If r3) {
            C1457Fr.m5025(view, "itemView");
            C1457Fr.m5025(r3, "adapter");
            this.f15384 = view;
            this.f15386 = r3;
        }

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public final If m16308() {
            return this.f15386;
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        public final View m16309() {
            return this.f15384;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m16304(int i) {
            this.f15385 = i;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final int m16306() {
            return this.f15385;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final boolean m16305() {
            return this.f15383;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m16307(boolean z) {
            this.f15383 = z;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final C1135 m16303() {
            ViewGroup.LayoutParams layoutParams = this.f15384.getLayoutParams();
            if (layoutParams != null) {
                return (C1135) layoutParams;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.widgetry.widget.ScaledItemListView.LayoutParams");
        }

        /* renamed from: ˊ */
        public void mo13600() {
        }

        /* renamed from: ॱ */
        public void mo13603(int i) {
            if (i >= this.f15386.m16302().size() || i < 0) {
                this.f15384.setVisibility(4);
                this.f15385 = -1;
            } else {
                this.f15384.setVisibility(0);
                this.f15385 = i;
                Object r2 = this.f15386.m16301(i);
                if (r2 != null) {
                    mo13601(r2);
                }
            }
            this.f15383 = false;
        }

        /* renamed from: ॱ */
        public void mo13602() {
            this.f15384.setVisibility(4);
            this.f15385 = -1;
            this.f15383 = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        while (true) {
            if (!this.f15373.isEmpty()) {
                Cif remove = this.f15373.remove(0);
                remove.mo13602();
                remove.mo13600();
                removeView(remove.m16309());
            } else {
                return;
            }
        }
    }
}
