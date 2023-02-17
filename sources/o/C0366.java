package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.util.Pools;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.android.widgetry.widget.tabs.BadgeView;
import java.util.ArrayList;
import java.util.List;
import o.C0602;
/* renamed from: o.ɔ  reason: contains not printable characters */
public class C0366 extends ViewGroup {

    /* renamed from: ʻ  reason: contains not printable characters */
    private ColorStateList f13195;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f13196;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f13197;

    /* renamed from: ˊ  reason: contains not printable characters */
    private If f13198;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private List<C0383> f13199;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Pools.Pool<C1208> f13200;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int[] f13201;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final View.OnClickListener f13202;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f13203;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f13204;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f13205;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C0369 f13206;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private ColorStateList f13207;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1208[] f13208;

    /* access modifiers changed from: package-private */
    /* renamed from: o.ɔ$If */
    public interface If {
        /* renamed from: ˎ  reason: contains not printable characters */
        boolean mo14078(C0383 v);
    }

    public C0366(Context context) {
        this(context, null);
    }

    public C0366(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13200 = new Pools.SynchronizedPool(5);
        this.f13196 = 0;
        this.f13197 = 0;
        this.f13199 = new ArrayList(5);
        this.f13203 = getResources().getDimensionPixelSize(C0602.C0603.bottom_navigation_active_item_max_width);
        this.f13205 = getResources().getDimensionPixelSize(C0602.C0603.bottom_navigation_height);
        this.f13202 = new View.OnClickListener() { // from class: o.ɔ.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0383 r2 = ((C1208) view).m16491();
                if (C0366.this.f13198.mo14078(r2)) {
                    C0366.this.setSelectedTab(r2);
                }
            }
        };
        this.f13201 = new int[5];
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14075(List<C0383> list) {
        this.f13199.clear();
        this.f13199.addAll(list);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setLabelVisibility(m14069(size));
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f13205, 1073741824);
        int min = Math.min(size / (childCount == 0 ? 1 : childCount), this.f13203);
        int i3 = size - (min * childCount);
        for (int i4 = 0; i4 < childCount; i4++) {
            this.f13201[i4] = min;
            if (i3 > 0) {
                int[] iArr = this.f13201;
                iArr[i4] = iArr[i4] + 1;
                i3--;
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f13201[i6], 1073741824), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i5 += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i5, View.MeasureSpec.makeMeasureSpec(i5, 1073741824), 0), ViewCompat.resolveSizeAndState(this.f13205, makeMeasureSpec, 0));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m14069(int i) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return true;
        }
        int i2 = i / childCount;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof C1208) && !((C1208) childAt).m16492(i2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    childAt.layout((i5 - i7) - childAt.getMeasuredWidth(), 0, i5 - i7, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f13207 = colorStateList;
        if (this.f13208 != null) {
            for (C1208 r4 : this.f13208) {
                r4.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f13195 = colorStateList;
        if (this.f13208 != null) {
            for (C1208 r4 : this.f13208) {
                r4.setTextColor(colorStateList);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.f13204 = i;
        if (this.f13208 != null) {
            for (C1208 r4 : this.f13208) {
                r4.setItemBackground(i);
            }
        }
    }

    public void setTabView(C0369 r1) {
        this.f13206 = r1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14076() {
        this.f13206.setUpdateSuspended(true);
        removeAllViews();
        if (this.f13208 != null) {
            for (C1208 r5 : this.f13208) {
                this.f13200.release(r5);
            }
        }
        if (this.f13199.size() == 0) {
            this.f13196 = 0;
            this.f13197 = 0;
            this.f13208 = null;
            return;
        }
        this.f13208 = new C1208[this.f13199.size()];
        for (int i = 0; i < this.f13199.size(); i++) {
            C1208 r3 = m14071();
            this.f13208[i] = r3;
            r3.setIconTintList(this.f13207);
            r3.setTextColor(this.f13195);
            r3.setItemBackground(this.f13204);
            r3.m16490(this.f13199.get(i));
            r3.setItemPosition(i);
            r3.setClickable(true);
            r3.setOnClickListener(this.f13202);
            addView(r3);
        }
        this.f13197 = Math.min(this.f13199.size() - 1, this.f13197);
        this.f13199.get(this.f13197).m14148(true);
        this.f13206.setUpdateSuspended(false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14073() {
        int size = this.f13199.size();
        if (size != this.f13208.length) {
            m14076();
            return;
        }
        int i = this.f13196;
        for (int i2 = 0; i2 < size; i2++) {
            C0383 r5 = this.f13199.get(i2);
            if (r5.m14146()) {
                this.f13196 = r5.m14144();
                this.f13197 = i2;
            }
        }
        int i3 = this.f13196;
        for (int i4 = 0; i4 < size; i4++) {
            this.f13206.setUpdateSuspended(true);
            this.f13208[i4].m16490(this.f13199.get(i4));
            this.f13206.setUpdateSuspended(false);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1208 m14071() {
        C1208 acquire = this.f13200.acquire();
        if (acquire == null) {
            return new C1208(getContext());
        }
        return acquire;
    }

    public void setLabelVisibility(boolean z) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof C1208) {
                ((C1208) childAt).setLabelVisibility(z);
            }
        }
    }

    public void setSelectedTab(C0383 r4) {
        for (C0383 r2 : this.f13199) {
            r2.m14148(r2.equals(r4));
        }
        m14073();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m14074() {
        return this.f13196;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14077(int i) {
        int size = this.f13199.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0383 r3 = this.f13199.get(i2);
            if (i == r3.m14144()) {
                this.f13196 = i;
                this.f13197 = i2;
                r3.m14148(true);
                return;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public BadgeView m14072(int i) {
        if (this.f13208 == null) {
            return null;
        }
        C1208[] r1 = this.f13208;
        for (C1208 r4 : r1) {
            if (r4.getId() == i) {
                return r4.m16489();
            }
        }
        return null;
    }

    public void setTabClickListener(If r1) {
        this.f13198 = r1;
    }
}
