package o;

import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Queue;
/* renamed from: o.sy  reason: case insensitive filesystem */
public class C2167sy {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static C2167sy f10297;

    /* renamed from: ˊ  reason: contains not printable characters */
    private WeakReference<ActivityC2153sl> f10298;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f10299;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Queue<AbstractC2164sv> f10300 = new ArrayDeque();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C2167sy m10860(ActivityC2153sl slVar) {
        if (f10297 == null) {
            f10297 = new C2167sy();
        }
        f10297.m10858(slVar);
        return f10297;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public ActivityC2153sl m10862() {
        ActivityC2153sl slVar = this.f10298.get();
        if (C1317As.m3750(slVar)) {
            return null;
        }
        return slVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10858(ActivityC2153sl slVar) {
        this.f10298 = new WeakReference<>(slVar);
    }

    private C2167sy() {
        C1283.m16854("DialogManager", "DialogManager initialized");
        this.f10300.add(new C2165sw(this));
        this.f10300.add(new C2166sx(this));
        this.f10300.add(new sA(this));
        this.f10300.add(new sD(this));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m10859(ActivityC2153sl slVar) {
        if (slVar.isDialogFragmentVisible()) {
            C1283.m16854("DialogManager", "a DialogFragment is already visible - can't display dialog");
            return false;
        } else if (slVar.isInstanceStateSaved()) {
            C1283.m16854("DialogManager", "Activity has saved instance state - can't display dialog");
            return false;
        } else if (C1317As.m3750(slVar)) {
            C1283.m16854("DialogManager", "Activity is destroyed - can't display dialog");
            return false;
        } else {
            C1283.m16854("DialogManager", "Dialog can be safely shown.");
            return true;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m10861() {
        C1283.m16854("DialogManager", "displayDialogsIfNeeded;");
        ActivityC2153sl r3 = m10862();
        if (r3 == null) {
            C1283.m16854("DialogManager", "Owner is null!");
            return false;
        } else if (this.f10299 || !m10859(r3)) {
            C1283.m16854("DialogManager", "..could display dialog... isLocked: " + this.f10299);
            return false;
        } else {
            while (!this.f10300.isEmpty()) {
                AbstractC2164sv remove = this.f10300.remove();
                if (remove.mo10502()) {
                    C1283.m16854("DialogManager", "showing something! -> " + remove.getClass());
                    return remove.mo10503();
                }
            }
            return false;
        }
    }
}
