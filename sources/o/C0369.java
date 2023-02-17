package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.netflix.android.widgetry.widget.tabs.BadgeView;
import java.util.ArrayList;
import java.util.List;
import o.C0366;
import o.C0602;
/* renamed from: o.ɟ  reason: contains not printable characters */
public class C0369 extends FrameLayout {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final int[] f13274 = {-16842910};

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final int[] f13275 = {16842912};

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f13276;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0366 f13277;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<C0383> f13278;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private AbstractC2396iF f13279;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC0370 f13280;

    /* renamed from: o.ɟ$iF  reason: case insensitive filesystem */
    public interface AbstractC2396iF {
        /* renamed from: ˏ */
        boolean mo445(C0383 v);
    }

    /* renamed from: o.ɟ$ˊ  reason: contains not printable characters */
    public interface AbstractC0370 {
        /* renamed from: ˎ */
        void mo282(C0383 v);
    }

    public C0369(Context context) {
        this(context, null);
    }

    public C0369(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0369(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13278 = new ArrayList(5);
        this.f13276 = false;
        this.f13277 = new C0366(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f13277.setLayoutParams(layoutParams);
        this.f13277.setTabView(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0602.aux.BottomTabView, i, 0);
        if (obtainStyledAttributes.hasValue(C0602.aux.BottomTabView_itemIconTint)) {
            this.f13277.setIconTintList(obtainStyledAttributes.getColorStateList(C0602.aux.BottomTabView_itemIconTint));
        } else {
            this.f13277.setIconTintList(m14089(16842808));
        }
        if (obtainStyledAttributes.hasValue(C0602.aux.BottomTabView_itemTextColor)) {
            this.f13277.setItemTextColor(obtainStyledAttributes.getColorStateList(C0602.aux.BottomTabView_itemTextColor));
        } else {
            this.f13277.setItemTextColor(m14089(16842808));
        }
        if (obtainStyledAttributes.hasValue(C0602.aux.BottomTabView_elevation)) {
            ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(C0602.aux.BottomTabView_elevation, 0));
        }
        this.f13277.setItemBackgroundRes(obtainStyledAttributes.getResourceId(C0602.aux.BottomTabView_itemBackground, 0));
        obtainStyledAttributes.recycle();
        addView(this.f13277, layoutParams);
        this.f13277.setTabClickListener(new C0366.If() { // from class: o.ɟ.3
            @Override // o.C0366.If
            /* renamed from: ˎ */
            public boolean mo14078(C0383 r2) {
                return C0369.this.m14092(r2);
            }
        });
    }

    public void setOnTabSelectedListener(AbstractC2396iF iFVar) {
        this.f13279 = iFVar;
    }

    public void setOnTabReselectedListener(AbstractC0370 r1) {
        this.f13280 = r1;
    }

    public void setTabs(List<C0383> list) {
        if (list == null || list.size() <= 5) {
            setUpdateSuspended(true);
            this.f13278.clear();
            this.f13278.addAll(list);
            this.f13277.m14075(list);
            setUpdateSuspended(false);
            m14094(true);
            return;
        }
        throw new IllegalArgumentException("BottomTabView only supports 5 tabs");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public BadgeView m14091(int i) {
        return this.f13277.m14072(i);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f13277.setIconTintList(colorStateList);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f13277.setItemTextColor(colorStateList);
    }

    public void setItemBackgroundResource(int i) {
        this.f13277.setItemBackgroundRes(i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m14090() {
        return this.f13277.m14074();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public C0383 m14093(int i) {
        for (C0383 r2 : this.f13278) {
            if (r2.m14144() == i) {
                return r2;
            }
        }
        return null;
    }

    public void setSelectedTabId(int i, boolean z) {
        C0383 r1 = m14093(i);
        if (r1 == null) {
            return;
        }
        if (!z) {
            this.f13277.setSelectedTab(r1);
        } else if (m14092(r1)) {
            this.f13277.setSelectedTab(r1);
        }
    }

    public void setLabelVisibility(boolean z) {
        this.f13277.setLabelVisibility(z);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private ColorStateList m14089(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{f13274, f13275, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(f13274, defaultColor), i2, defaultColor});
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        If r2 = new If(super.onSaveInstanceState());
        r2.f13283 = this.f13277.m14074();
        r2.f13282 = new Bundle();
        return r2;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof If)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(((If) parcelable).getSuperState());
        this.f13277.m14077(((If) parcelable).f13283);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ɟ$If */
    public static class If extends AbsSavedState {
        public static final Parcelable.Creator<If> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<If>() { // from class: o.ɟ.If.3
            /* renamed from: ॱ  reason: contains not printable characters */
            public If createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new If(parcel, classLoader);
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public If[] newArray(int i) {
                return new If[i];
            }
        });

        /* renamed from: ˎ  reason: contains not printable characters */
        Bundle f13282;

        /* renamed from: ˏ  reason: contains not printable characters */
        int f13283;

        public If(Parcelable parcelable) {
            super(parcelable);
        }

        public If(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m14095(parcel, classLoader);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f13283);
            parcel.writeBundle(this.f13282);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m14095(Parcel parcel, ClassLoader classLoader) {
            this.f13283 = parcel.readInt();
            this.f13282 = parcel.readBundle(classLoader);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14094(boolean z) {
        if (!this.f13276) {
            if (z) {
                this.f13277.m14076();
            } else {
                this.f13277.m14073();
            }
        }
    }

    public void setUpdateSuspended(boolean z) {
        this.f13276 = z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m14092(C0383 r3) {
        if (this.f13280 == null || r3.m14144() != m14090()) {
            return this.f13279 != null && this.f13279.mo445(r3);
        }
        this.f13280.mo282(r3);
        return true;
    }
}
