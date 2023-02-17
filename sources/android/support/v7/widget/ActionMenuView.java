package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (4.0f * f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        this.mPresenter.setMenuView(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mPresenter != null) {
            this.mPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z = this.mFormatItems;
        this.mFormatItems = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.mFormatItems || this.mMenu == null || size == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = size;
            this.mMenu.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        onMeasureExactFormat(i, i2);
    }

    private void onMeasureExactFormat(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.mMinCellSize;
        int i5 = i3 % this.mMinCellSize;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i6 = this.mMinCellSize + (i5 / i4);
        int i7 = i4;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        boolean z = false;
        long j = 0;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                boolean z2 = childAt instanceof ActionMenuItemView;
                i11++;
                if (z2) {
                    childAt.setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = false;
                layoutParams.extraPixels = 0;
                layoutParams.cellsUsed = 0;
                layoutParams.expandable = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.preventEdgeOffset = z2 && ((ActionMenuItemView) childAt).hasText();
                int measureChildForCells = measureChildForCells(childAt, i6, layoutParams.isOverflowButton ? 1 : i7, childMeasureSpec, paddingTop);
                i9 = Math.max(i9, measureChildForCells);
                if (layoutParams.expandable) {
                    i10++;
                }
                if (layoutParams.isOverflowButton) {
                    z = true;
                }
                i7 -= measureChildForCells;
                i8 = Math.max(i8, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j |= (long) (1 << i12);
                }
            }
        }
        boolean z3 = z && i11 == 2;
        boolean z4 = false;
        while (i10 > 0 && i7 > 0) {
            int i13 = Integer.MAX_VALUE;
            long j2 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < childCount; i15++) {
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i15).getLayoutParams();
                if (layoutParams2.expandable) {
                    if (layoutParams2.cellsUsed < i13) {
                        i13 = layoutParams2.cellsUsed;
                        j2 = 1 << i15;
                        i14 = 1;
                    } else if (layoutParams2.cellsUsed == i13) {
                        j2 |= 1 << i15;
                        i14++;
                    }
                }
            }
            j |= j2;
            if (i14 > i7) {
                break;
            }
            int i16 = i13 + 1;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt2 = getChildAt(i17);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                if ((((long) (1 << i17)) & j2) != 0) {
                    if (z3 && layoutParams3.preventEdgeOffset && i7 == 1) {
                        childAt2.setPadding(this.mGeneratedItemPadding + i6, 0, this.mGeneratedItemPadding, 0);
                    }
                    layoutParams3.cellsUsed++;
                    layoutParams3.expanded = true;
                    i7--;
                } else if (layoutParams3.cellsUsed == i16) {
                    j |= (long) (1 << i17);
                }
            }
            z4 = true;
        }
        boolean z5 = !z && i11 == 1;
        if (i7 > 0 && j != 0 && (i7 < i11 - 1 || z5 || i9 > 1)) {
            float bitCount = (float) Long.bitCount(j);
            if (!z5) {
                if ((1 & j) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
                if ((((long) (1 << (childCount - 1))) & j) != 0 && !((LayoutParams) getChildAt(childCount - 1).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
            }
            int i18 = bitCount > 0.0f ? (int) (((float) (i7 * i6)) / bitCount) : 0;
            for (int i19 = 0; i19 < childCount; i19++) {
                if ((((long) (1 << i19)) & j) != 0) {
                    View childAt3 = getChildAt(i19);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.extraPixels = i18;
                        layoutParams4.expanded = true;
                        if (i19 == 0 && !layoutParams4.preventEdgeOffset) {
                            layoutParams4.leftMargin = (-i18) / 2;
                        }
                        z4 = true;
                    } else if (layoutParams4.isOverflowButton) {
                        layoutParams4.extraPixels = i18;
                        layoutParams4.expanded = true;
                        layoutParams4.rightMargin = (-i18) / 2;
                        z4 = true;
                    } else {
                        if (i19 != 0) {
                            layoutParams4.leftMargin = i18 / 2;
                        }
                        if (i19 != childCount - 1) {
                            layoutParams4.rightMargin = i18 / 2;
                        }
                    }
                }
            }
        }
        if (z4) {
            for (int i20 = 0; i20 < childCount; i20++) {
                View childAt4 = getChildAt(i20);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.expanded) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i6) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode != 1073741824) {
            size2 = i8;
        }
        setMeasuredDimension(i3, size2);
    }

    static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.hasText();
        int i5 = 0;
        if (i2 > 0 && (!z || i2 >= 2)) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && i5 < 2) {
                i5 = 2;
            }
        }
        layoutParams.expandable = !layoutParams.isOverflowButton && z;
        layoutParams.cellsUsed = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (!this.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = 0;
        int i9 = 0;
        int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
        boolean z2 = false;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i5 = getPaddingLeft() + layoutParams.leftMargin;
                        i6 = i5 + measuredWidth;
                    } else {
                        i6 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i5 = i6 - measuredWidth;
                    }
                    int i11 = i7 - (measuredHeight / 2);
                    childAt.layout(i5, i11, i6, i11 + measuredHeight);
                    paddingRight -= measuredWidth;
                    z2 = true;
                } else {
                    int measuredWidth2 = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    i8 += measuredWidth2;
                    paddingRight -= measuredWidth2;
                    if (hasSupportDividerBeforeChildAt(i10)) {
                        i8 += dividerWidth;
                    }
                    i9++;
                }
            }
        }
        if (childCount != 1 || z2) {
            int i12 = i9 - (z2 ? 0 : 1);
            int max = Math.max(0, i12 > 0 ? paddingRight / i12 : 0);
            if (isLayoutRtl) {
                int width = getWidth() - getPaddingRight();
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt2 = getChildAt(i13);
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                        int i14 = width - layoutParams2.rightMargin;
                        int measuredWidth3 = childAt2.getMeasuredWidth();
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        int i15 = i7 - (measuredHeight2 / 2);
                        childAt2.layout(i14 - measuredWidth3, i15, i14, i15 + measuredHeight2);
                        width = i14 - ((layoutParams2.leftMargin + measuredWidth3) + max);
                    }
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                    int i17 = paddingLeft + layoutParams3.leftMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17, i18, i17 + measuredWidth4, i18 + measuredHeight3);
                    paddingLeft = i17 + layoutParams3.rightMargin + measuredWidth4 + max;
                }
            }
            return;
        }
        View childAt4 = getChildAt(0);
        int measuredWidth5 = childAt4.getMeasuredWidth();
        int measuredHeight4 = childAt4.getMeasuredHeight();
        int i19 = ((i3 - i) / 2) - (measuredWidth5 / 2);
        int i20 = i7 - (measuredHeight4 / 2);
        childAt4.layout(i19, i20, i19 + measuredWidth5, i20 + measuredHeight4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    @Override // android.support.v7.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    @Override // android.support.v7.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            this.mMenu = new MenuBuilder(context);
            this.mMenu.setCallback(new MenuBuilderCallback());
            this.mPresenter = new ActionMenuPresenter(context);
            this.mPresenter.setReserveOverflow(true);
            this.mPresenter.setCallback(this.mActionMenuPresenterCallback != null ? this.mActionMenuPresenterCallback : new ActionMenuPresenterCallback());
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public boolean showOverflowMenu() {
        return this.mPresenter != null && this.mPresenter.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.mPresenter != null && this.mPresenter.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowing() {
        return this.mPresenter != null && this.mPresenter.isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPresenter != null && this.mPresenter.isOverflowMenuShowPending();
    }

    public void dismissPopupMenus() {
        if (this.mPresenter != null) {
            this.mPresenter.dismissPopupMenus();
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasSupportDividerBeforeChildAt(int i) {
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        boolean z = false;
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = ((ActionMenuChildView) childAt).needsDividerAfter() | false;
        }
        if (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) {
            return z;
        }
        return z | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.setExpandedActionViewsExclusive(z);
    }

    /* access modifiers changed from: package-private */
    public class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.mMenuBuilderCallback != null) {
                ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }
    }
}
