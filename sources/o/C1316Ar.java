package o;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.netflix.mediaclient.R;
import java.util.List;
/* renamed from: o.Ar  reason: case insensitive filesystem */
public final class C1316Ar {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3741(Context context) {
        AccessibilityManager accessibilityManager;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        return (context == null || (accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility")) == null || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || enabledAccessibilityServiceList.size() <= 0) ? false : true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3739(Context context, String str) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null && m3741(context)) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            obtain.getText().add(str);
            obtain.setEnabled(true);
            obtain.setPackageName(context.getPackageName());
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3740(ViewGroup viewGroup, View view, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != view) {
                if (z) {
                    childAt.setTag(R.id.original_accessibility_importance, Integer.valueOf(ViewCompat.getImportantForAccessibility(childAt)));
                    ViewCompat.setImportantForAccessibility(childAt, 4);
                } else {
                    Integer num = (Integer) childAt.getTag(R.id.original_accessibility_importance);
                    if (num == null) {
                        num = 0;
                    }
                    ViewCompat.setImportantForAccessibility(childAt, num.intValue());
                }
            }
        }
    }
}
