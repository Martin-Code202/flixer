package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.FocusStrategy;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;
import org.linphone.core.Privacy;
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: android.support.v4.widget.ExploreByTouchHelper.1
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: android.support.v4.widget.ExploreByTouchHelper.2
    };
    private int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private final View mHost;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;
    private int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    public abstract int getVirtualViewAt(float f, float f2);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(view) == 0) {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 7:
            case 9:
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                updateHoveredVirtualView(virtualViewAt);
                return virtualViewAt != Integer.MIN_VALUE;
            case 8:
            default:
                return false;
            case 10:
                if (this.mAccessibilityFocusedVirtualViewId == Integer.MIN_VALUE) {
                    return false;
                }
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
        }
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, createEvent(i, i2));
    }

    /* access modifiers changed from: protected */
    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    private void updateHoveredVirtualView(int i) {
        if (this.mHoveredVirtualViewId != i) {
            int i2 = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        switch (i) {
            case -1:
                return createEventForHost(i2);
            default:
                return createEventForChild(i, i2);
        }
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.getText());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
            AccessibilityRecordCompat.setSource(obtain, this.mHost, i);
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    /* access modifiers changed from: package-private */
    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                obtain.addChild(this.mHost, ((Integer) arrayList.get(i)).intValue());
            }
            return obtain;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int i) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName("android.view.View");
        obtain.setBoundsInParent(INVALID_PARENT_BOUNDS);
        obtain.setBoundsInScreen(INVALID_PARENT_BOUNDS);
        obtain.setParent(this.mHost);
        onPopulateNodeForVirtualView(i, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            obtain.setSource(this.mHost, i);
            if (this.mAccessibilityFocusedVirtualViewId == i) {
                obtain.setAccessibilityFocused(true);
                obtain.addAction(128);
            } else {
                obtain.setAccessibilityFocused(false);
                obtain.addAction(64);
            }
            boolean z = this.mKeyboardFocusedVirtualViewId == i;
            if (z) {
                obtain.addAction(2);
            } else if (obtain.isFocusable()) {
                obtain.addAction(1);
            }
            obtain.setFocused(z);
            this.mHost.getLocationOnScreen(this.mTempGlobalRect);
            obtain.getBoundsInScreen(this.mTempScreenRect);
            if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                obtain.getBoundsInParent(this.mTempScreenRect);
                if (obtain.mParentVirtualDescendantId != -1) {
                    AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                    for (int i2 = obtain.mParentVirtualDescendantId; i2 != -1; i2 = obtain2.mParentVirtualDescendantId) {
                        obtain2.setParent(this.mHost, -1);
                        obtain2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                        onPopulateNodeForVirtualView(i2, obtain2);
                        obtain2.getBoundsInParent(this.mTempParentRect);
                        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                    }
                    obtain2.recycle();
                }
                this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            }
            if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                    obtain.setBoundsInScreen(this.mTempScreenRect);
                    if (isVisibleToUser(this.mTempScreenRect)) {
                        obtain.setVisibleToUser(true);
                    }
                }
            }
            return obtain;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean performAction(int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return performActionForHost(i2, bundle);
            default:
                return performActionForChild(i, i2, bundle);
        }
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, i, bundle);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 1:
                return requestKeyboardFocusForVirtualView(i);
            case 2:
                return clearKeyboardFocusForVirtualView(i);
            case 64:
                return requestAccessibilityFocus(i);
            case 128:
                return clearAccessibilityFocus(i);
            default:
                return onPerformActionForVirtualView(i, i2, bundle);
        }
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean requestAccessibilityFocus(int i) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || this.mAccessibilityFocusedVirtualViewId == i) {
            return false;
        }
        if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
        }
        this.mAccessibilityFocusedVirtualViewId = i;
        this.mHost.invalidate();
        sendEventForVirtualView(i, Privacy.DEFAULT);
        return true;
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || this.mKeyboardFocusedVirtualViewId == i) {
            return false;
        }
        if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i));
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i, i2, bundle);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i2);
        }
    }
}
