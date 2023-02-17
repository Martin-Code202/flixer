package o;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* renamed from: o.ঽ  reason: contains not printable characters */
public final class C0670 extends ExploreByTouchHelper {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Map<String, CharSequence> f14036;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0662 f14037;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<C0926> f14038;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map<java.lang.String, ? extends java.lang.CharSequence> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0670(C0662 r5, Map<String, ? extends CharSequence> map, List<C0926> list) {
        super(r5);
        C1457Fr.m5025(r5, "netflixLottieAnimationView");
        C1457Fr.m5025(map, "accessibilityStringByTag");
        this.f14037 = r5;
        this.f14036 = map;
        List<C0926> list2 = list;
        this.f14038 = list2 == null ? C0662.m14841(this.f14037, 0, 1, null) : list2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean m14868(int i) {
        return i < this.f14038.size() && i >= 0;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.widget.ExploreByTouchHelper
    public int getVirtualViewAt(float f, float f2) {
        C0926 r2 = this.f14037.m14845(f, f2);
        if (r2 == null) {
            return 0;
        }
        int i = 0;
        Iterator<T> it = this.f14038.iterator();
        while (it.hasNext()) {
            i++;
            if (C1457Fr.m5018((Object) r2.m15734(), (Object) it.next().m15734())) {
                return i;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.widget.ExploreByTouchHelper
    public void getVisibleVirtualViews(List<Integer> list) {
        C1457Fr.m5025(list, "virtualViewIds");
        FE r2 = FF.m4991(0, this.f14038.size());
        ArrayList arrayList = new ArrayList(EI.m4812(r2, 10));
        Iterator it = r2.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(list.add(Integer.valueOf(((EU) it).mo4855()))));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.widget.ExploreByTouchHelper
    public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.widget.ExploreByTouchHelper
    public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        C1457Fr.m5025(accessibilityNodeInfoCompat, "node");
        if (m14868(i)) {
            C0926 r3 = this.f14038.get(i);
            accessibilityNodeInfoCompat.setContentDescription(this.f14036.get(r3.m15734()));
            accessibilityNodeInfoCompat.setBoundsInParent(r3.m15740());
            accessibilityNodeInfoCompat.addAction(16);
            accessibilityNodeInfoCompat.setSelected(true);
            return;
        }
        C1276.m16820().mo5725("VirtualViewId is invalid (" + i + " no between 0.." + this.f14038 + ".size)- Accessibility may not work");
        accessibilityNodeInfoCompat.setContentDescription("");
        accessibilityNodeInfoCompat.setBoundsInParent(new Rect());
        accessibilityNodeInfoCompat.setSelected(false);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.widget.ExploreByTouchHelper
    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        C1457Fr.m5025(accessibilityEvent, "event");
        if (m14868(i)) {
            accessibilityEvent.setContentDescription(this.f14036.get(this.f14038.get(i).m15734()));
            return;
        }
        C1276.m16820().mo5725("VirtualViewId is invalid (" + i + " no between 0.." + this.f14038 + ".size)- Accessibility may not work");
        accessibilityEvent.setContentDescription("");
    }
}
