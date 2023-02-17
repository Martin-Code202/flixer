package o;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;
import o.C1348Bu;
/* renamed from: o.Cl  reason: case insensitive filesystem */
public final class C1366Cl {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final Cif f5160 = new Cif(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final HashSet<Integer> f5161 = new HashSet<>();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final SparseArray<LinkedList<C0079>> f5162 = new SparseArray<>();

    /* renamed from: ʽ  reason: contains not printable characters */
    private final RunnableC0080 f5163 = new RunnableC0080(this);

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f5164 = -1;

    /* renamed from: ˋ  reason: contains not printable characters */
    private If f5165 = new If() { // from class: o.Cl.1
        @Override // o.C1366Cl.If
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo4494() {
            if (!Logger.INSTANCE.m136()) {
                Logger.INSTANCE.m142(new C0634());
            }
        }

        @Override // o.C1366Cl.If
        /* renamed from: ˊ  reason: contains not printable characters */
        public long mo4492(AppView appView, AbstractC0574 r5) {
            if (Logger.INSTANCE.m136() || appView == null) {
                if (appView == null) {
                    C1276.m16820().mo5725("appView is null");
                }
                return -1;
            }
            Long r2 = Logger.INSTANCE.m142(new C1212(appView, r5));
            if (r2 == null) {
                r2 = -1L;
            }
            C1457Fr.m5016((Object) r2, "sessionId");
            return r2.longValue();
        }

        @Override // o.C1366Cl.If
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo4493(Long l) {
            if (!Logger.INSTANCE.m136()) {
                Logger.INSTANCE.m147(C1212.m16815(l));
            }
        }

        @Override // o.C1366Cl.If
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo4496() {
            if (!Logger.INSTANCE.m136()) {
                Logger.INSTANCE.m133(new C0634().m16817());
            }
        }

        @Override // o.C1366Cl.If
        /* renamed from: ॱ  reason: contains not printable characters */
        public AbstractC1274 mo4495(String str) {
            if (Logger.INSTANCE.m136()) {
                return null;
            }
            return Logger.INSTANCE.m148(str);
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f5166 = 1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final SparseArray<ArrayList<Integer>> f5167 = new SparseArray<>();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final WeakHashMap<Activity, Integer> f5168 = new WeakHashMap<>();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C1367iF f5169 = new C1367iF(this);

    /* renamed from: o.Cl$If */
    public interface If {
        /* renamed from: ˊ */
        long mo4492(AppView appView, AbstractC0574 v);

        /* renamed from: ˊ */
        void mo4493(Long l);

        /* renamed from: ˏ */
        void mo4494();

        /* renamed from: ॱ */
        AbstractC1274 mo4495(String str);

        /* renamed from: ॱ */
        void mo4496();
    }

    /* renamed from: o.Cl$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: o.Cl$ˋ  reason: contains not printable characters */
    public static final class RunnableC0080 implements Runnable {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C1366Cl f5174;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        RunnableC0080(C1366Cl cl) {
            this.f5174 = cl;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5174.m4489();
        }
    }

    /* renamed from: o.Cl$iF  reason: case insensitive filesystem */
    public static final class C1367iF implements Application.ActivityLifecycleCallbacks {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C1366Cl f5170;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1367iF(C1366Cl cl) {
            this.f5170 = cl;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (activity instanceof NetflixActivity) {
                C1366Cl cl = this.f5170;
                try {
                    this.f5170.m4473((NetflixActivity) activity);
                } catch (Throwable th) {
                    C1276.m16820().mo5729("SPY-13864 . " + th.getMessage(), th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity instanceof NetflixActivity) {
                C1366Cl cl = this.f5170;
                try {
                    this.f5170.m4485((NetflixActivity) activity);
                } catch (Throwable th) {
                    C1276.m16820().mo5729("SPY-13864 . " + th.getMessage(), th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof NetflixActivity) {
                C1366Cl cl = this.f5170;
                try {
                    this.f5170.m4478((NetflixActivity) activity);
                } catch (Throwable th) {
                    C1276.m16820().mo5729("SPY-13864 . " + th.getMessage(), th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof NetflixActivity) {
                C1366Cl cl = this.f5170;
                try {
                    this.f5170.m4470((NetflixActivity) activity, bundle);
                } catch (Throwable th) {
                    C1276.m16820().mo5729("SPY-13864 . " + th.getMessage(), th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            if ((activity instanceof NetflixActivity) && bundle != null) {
                C1366Cl cl = this.f5170;
                try {
                    this.f5170.m4475((NetflixActivity) activity, bundle);
                } catch (Throwable th) {
                    C1276.m16820().mo5729("SPY-13864 . " + th.getMessage(), th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            C1366Cl cl = this.f5170;
            try {
                this.f5170.m4482();
            } catch (Throwable th) {
                C1276.m16820().mo5729("SPY-13864 . " + th.getMessage(), th);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m4487() {
        AbstractApplicationC1258.m16691().registerActivityLifecycleCallbacks(this.f5169);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final synchronized Bundle m4472(int i) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putIntegerArrayList("BottomTabActivityIds", new ArrayList<>(this.f5161));
        if (this.f5164 > -1) {
            bundle.putInt("ActivityId", i);
            ArrayList<Integer> arrayList = this.f5167.get(this.f5164);
            if (arrayList != null) {
                bundle.putIntegerArrayList("TaskActivityIds", arrayList);
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    LinkedList<C0079> linkedList = this.f5162.get(intValue);
                    if (linkedList != null) {
                        Iterator<T> it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(it2.next().m4501().name());
                        }
                    }
                    bundle.putStringArrayList(String.valueOf(intValue), arrayList2);
                }
            }
        }
        return bundle;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final synchronized void m4465(Activity activity, Bundle bundle) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("TaskActivityIds");
        if (integerArrayList != null) {
            C1276.m16820().mo5728("NavigationLevelManager wasRestored " + EI.m4836(integerArrayList, ",", null, null, 0, null, null, 62, null));
            this.f5161.addAll(bundle.getIntegerArrayList("BottomTabActivityIds"));
            this.f5167.put(activity.getTaskId(), integerArrayList);
            for (T t : integerArrayList) {
                int taskId = activity.getTaskId();
                C1457Fr.m5016((Object) t, "activityId");
                m4469(taskId, t.intValue(), bundle);
            }
        } else {
            C1276.m16820().mo5728("NavigationLevelManager wasRestored but taskActivityIds was null");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final synchronized void m4469(int i, int i2, Bundle bundle) {
        if (i2 > 0) {
            if (this.f5167.get(i) != null) {
                if (!this.f5167.get(i).contains(Integer.valueOf(i2))) {
                    this.f5167.get(i).add(Integer.valueOf(i2));
                }
                if (this.f5162.get(i2) == null) {
                    LinkedList<C0079> linkedList = new LinkedList<>();
                    ArrayList<String> stringArrayList = bundle.getStringArrayList(String.valueOf(i2));
                    if (stringArrayList != null) {
                        for (T t : stringArrayList) {
                            C1457Fr.m5016((Object) t, "name");
                            linkedList.add(new C0079(AppView.valueOf(t), 0, null, 6, null));
                        }
                    }
                    this.f5162.put(i2, linkedList);
                }
            }
        }
        C1276.m16820().mo5728("NavigationLevelManager wasRestored but activityId was missing from bundle or task was missing.  activityId: " + i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final synchronized void m4475(NetflixActivity netflixActivity, Bundle bundle) {
        Integer num = this.f5168.get(netflixActivity);
        if (num != null) {
            C1457Fr.m5016((Object) num, "it");
            bundle.putBundle("NavLevelManagerBundle", m4472(num.intValue()));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final synchronized void m4488(NetflixActivity netflixActivity, AppView appView, AbstractC0574 r8) {
        C1457Fr.m5025(netflixActivity, "activity");
        C1457Fr.m5025(appView, "appView");
        m4467();
        Integer num = this.f5168.get(netflixActivity);
        if (num != null) {
            if (this.f5162.get(num.intValue()) == null) {
                this.f5162.put(num.intValue(), new LinkedList<>());
            }
            C0079 r4 = new C0079(appView, this.f5165.mo4492(appView, r8), r8);
            LinkedList<C0079> linkedList = this.f5162.get(num.intValue());
            if (linkedList != null) {
                linkedList.add(r4);
            }
        } else {
            C1276.m16820().mo5725("addNavigationLevel() activityId not found " + netflixActivity);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final synchronized void m4491(NetflixActivity netflixActivity, AppView appView, boolean z) {
        T t;
        T t2;
        List r0;
        Object obj;
        C1457Fr.m5025(netflixActivity, "activity");
        C1457Fr.m5025(appView, "appView");
        Integer num = this.f5168.get(netflixActivity);
        if (num != null) {
            m4467();
            if (z) {
                LinkedList<C0079> linkedList = this.f5162.get(num.intValue());
                if (linkedList == null || (r0 = EI.m4845((List) linkedList)) == null) {
                    t = null;
                } else {
                    Iterator it = r0.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        Object next = it.next();
                        if (C1457Fr.m5018(((C0079) next).m4501(), appView)) {
                            obj = next;
                            break;
                        }
                    }
                    t = (C0079) obj;
                }
            } else {
                LinkedList<C0079> linkedList2 = this.f5162.get(num.intValue());
                if (linkedList2 != null) {
                    Iterator<T> it2 = linkedList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t2 = null;
                            break;
                        }
                        T next2 = it2.next();
                        if (C1457Fr.m5018(next2.m4501(), appView)) {
                            t2 = next2;
                            break;
                        }
                    }
                    t = t2;
                } else {
                    t = null;
                }
            }
            if (t != null) {
                LinkedList<C0079> linkedList3 = this.f5162.get(num.intValue());
                if (linkedList3 != null) {
                    linkedList3.remove(t);
                }
                if (t.m4502()) {
                    this.f5165.mo4493(Long.valueOf(t.m4499()));
                    t.m4497();
                }
            } else {
                C1276.m16820().mo5725("removeNavigationLevel couldn't find appView: " + appView);
            }
        } else {
            C1276.m16820().mo5725("removeNavigationLevel() activityId not found " + netflixActivity);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final synchronized void m4490() {
        m4467();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final synchronized void m4489() {
        if (this.f5165.mo4495(new C0634().m16817()) != null) {
            this.f5165.mo4496();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084 A[LOOP:1: B:14:0x0061->B:25:0x0084, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0082 A[SYNTHETIC] */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m4470(com.netflix.mediaclient.android.activity.NetflixActivity r10, android.os.Bundle r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            if (r11 != 0) goto L_0x003a
            int r0 = r9.f5166     // Catch:{ all -> 0x00c8 }
            r3 = r0
            int r0 = r0 + 1
            r9.f5166 = r0     // Catch:{ all -> 0x00c8 }
            r2 = r3
        L_0x000b:
            java.util.WeakHashMap<android.app.Activity, java.lang.Integer> r0 = r9.f5168     // Catch:{ all -> 0x00c8 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c8 }
            boolean r0 = r0.containsValue(r1)     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x0020
            int r0 = r9.f5166     // Catch:{ all -> 0x00c8 }
            r3 = r0
            int r0 = r0 + 1
            r9.f5166 = r0     // Catch:{ all -> 0x00c8 }
            r2 = r3
            goto L_0x000b
        L_0x0020:
            java.util.WeakHashMap<android.app.Activity, java.lang.Integer> r0 = r9.f5168     // Catch:{ all -> 0x00c8 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c8 }
            r0.put(r10, r1)     // Catch:{ all -> 0x00c8 }
            boolean r0 = r10.hasBottomNavBar()     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x0038
            java.util.HashSet<java.lang.Integer> r0 = r9.f5161     // Catch:{ all -> 0x00c8 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c8 }
            r0.add(r1)     // Catch:{ all -> 0x00c8 }
        L_0x0038:
            goto L_0x00c6
        L_0x003a:
            java.lang.String r0 = "NavLevelManagerBundle"
            android.os.Bundle r0 = r11.getBundle(r0)     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x00c6
            java.lang.String r0 = "NavLevelManagerBundle"
            android.os.Bundle r2 = r11.getBundle(r0)     // Catch:{ all -> 0x00c8 }
            java.lang.String r0 = "ActivityId"
            int r3 = r2.getInt(r0)     // Catch:{ all -> 0x00c8 }
            java.util.WeakHashMap<android.app.Activity, java.lang.Integer> r0 = r9.f5168     // Catch:{ all -> 0x00c8 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x00c8 }
            java.lang.String r1 = "activityIds.entries"
            o.C1457Fr.m5016(r0, r1)     // Catch:{ all -> 0x00c8 }
            r4 = r0
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x00c8 }
            r5 = r4
            java.util.Iterator r6 = r5.iterator()     // Catch:{ all -> 0x00c8 }
        L_0x0061:
            boolean r0 = r6.hasNext()     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x0085
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x00c8 }
            r8 = r7
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ all -> 0x00c8 }
            java.lang.Object r0 = r8.getValue()     // Catch:{ all -> 0x00c8 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00c8 }
            if (r0 != 0) goto L_0x0077
            goto L_0x007f
        L_0x0077:
            int r0 = r0.intValue()     // Catch:{ all -> 0x00c8 }
            if (r0 != r3) goto L_0x007f
            r0 = 1
            goto L_0x0080
        L_0x007f:
            r0 = 0
        L_0x0080:
            if (r0 == 0) goto L_0x0084
            r0 = r7
            goto L_0x0086
        L_0x0084:
            goto L_0x0061
        L_0x0085:
            r0 = 0
        L_0x0086:
            r4 = r0
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x00c8 }
            if (r4 == 0) goto L_0x0099
            r5 = r4
            java.util.WeakHashMap<android.app.Activity, java.lang.Integer> r0 = r9.f5168     // Catch:{ all -> 0x00c8 }
            java.lang.Object r1 = r5.getKey()     // Catch:{ all -> 0x00c8 }
            java.lang.Object r0 = r0.remove(r1)     // Catch:{ all -> 0x00c8 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00c8 }
        L_0x0099:
            java.util.WeakHashMap<android.app.Activity, java.lang.Integer> r0 = r9.f5168     // Catch:{ all -> 0x00c8 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c8 }
            r0.put(r10, r1)     // Catch:{ all -> 0x00c8 }
            android.util.SparseArray<java.util.ArrayList<java.lang.Integer>> r0 = r9.f5167     // Catch:{ all -> 0x00c8 }
            int r1 = r10.getTaskId()     // Catch:{ all -> 0x00c8 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00c8 }
            if (r0 != 0) goto L_0x00ba
            r0 = r10
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ all -> 0x00c8 }
            java.lang.String r1 = "b"
            o.C1457Fr.m5016(r2, r1)     // Catch:{ all -> 0x00c8 }
            r9.m4465(r0, r2)     // Catch:{ all -> 0x00c8 }
            goto L_0x00c6
        L_0x00ba:
            int r0 = r10.getTaskId()     // Catch:{ all -> 0x00c8 }
            java.lang.String r1 = "b"
            o.C1457Fr.m5016(r2, r1)     // Catch:{ all -> 0x00c8 }
            r9.m4469(r0, r3, r2)     // Catch:{ all -> 0x00c8 }
        L_0x00c6:
            monitor-exit(r9)
            return
        L_0x00c8:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1366Cl.m4470(com.netflix.mediaclient.android.activity.NetflixActivity, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final synchronized void m4473(NetflixActivity netflixActivity) {
        Integer num = this.f5168.get(netflixActivity);
        if (num == null) {
            C1276.m16820().mo5725("activityStarted() Activity Id not found " + netflixActivity);
            return;
        }
        ArrayList<Integer> arrayList = this.f5167.get(netflixActivity.getTaskId());
        boolean z = arrayList != null && arrayList.remove(num);
        if (z) {
            this.f5167.get(netflixActivity.getTaskId()).add(num);
        }
        if (!z) {
            m4484(num.intValue(), netflixActivity);
            if (netflixActivity.hasBottomNavBar()) {
                m4474(netflixActivity, num.intValue());
            }
        } else if (this.f5164 != netflixActivity.getTaskId()) {
            m4483(netflixActivity.getTaskId());
        } else {
            m4468(num.intValue());
            if (netflixActivity.hasBottomNavBar()) {
                m4474(netflixActivity, num.intValue());
            }
        }
        this.f5164 = netflixActivity.getTaskId();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private final synchronized void m4482() {
        C1348Bu.If.m4100(this.f5163, 500);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final synchronized void m4474(NetflixActivity netflixActivity, int i) {
        ArrayList<Integer> arrayList = this.f5167.get(netflixActivity.getTaskId());
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue != i && this.f5161.contains(Integer.valueOf(intValue))) {
                    m4477(intValue);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private final synchronized void m4485(NetflixActivity netflixActivity) {
        Integer num = this.f5168.get(netflixActivity);
        if (num != null) {
            if (netflixActivity.isChangingConfigurations()) {
                this.f5168.remove(netflixActivity);
            } else if (netflixActivity.isFinishing()) {
                m4477(num.intValue());
                m4486(netflixActivity, num.intValue());
                this.f5168.remove(netflixActivity);
            } else {
                ArrayList<Integer> arrayList = this.f5167.get(netflixActivity.getTaskId());
                if (C1457Fr.m5018(arrayList != null ? (Integer) EI.m4840((List<? extends Object>) arrayList) : null, num)) {
                    m4464(netflixActivity.getTaskId());
                    this.f5164 = -1;
                }
            }
        }
        m4489();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final synchronized void m4478(NetflixActivity netflixActivity) {
        if (netflixActivity.isChangingConfigurations()) {
            this.f5168.remove(netflixActivity);
        } else {
            Integer num = this.f5168.get(netflixActivity);
            if (num != null) {
                C1457Fr.m5016((Object) num, "it");
                m4477(num.intValue());
                m4486(netflixActivity, num.intValue());
                this.f5168.remove(netflixActivity);
                m4489();
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final synchronized void m4484(int i, NetflixActivity netflixActivity) {
        m4463(netflixActivity.getTaskId());
        ArrayList<Integer> arrayList = this.f5167.get(netflixActivity.getTaskId());
        if (arrayList != null) {
            arrayList.add(Integer.valueOf(i));
        }
        UIScreen uiScreen = netflixActivity.getUiScreen();
        if (!(uiScreen == null || uiScreen.f4083 == null)) {
            AppView appView = netflixActivity.getUiScreen().f4083;
            C1457Fr.m5016((Object) appView, "activity.uiScreen.appView");
            m4488(netflixActivity, appView, netflixActivity.getDataContext());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final synchronized void m4486(NetflixActivity netflixActivity, int i) {
        Integer num = this.f5168.get(netflixActivity);
        if (num != null) {
            if (num.intValue() == i) {
                int size = this.f5167.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ArrayList<Integer> valueAt = this.f5167.valueAt(i2);
                    if (valueAt != null) {
                        valueAt.remove(Integer.valueOf(i));
                    }
                }
                this.f5162.remove(i);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final synchronized void m4464(int i) {
        m4467();
        ArrayList<Integer> arrayList = this.f5167.get(i);
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                m4477(it.next().intValue());
            }
        }
        m4489();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final synchronized void m4477(int i) {
        LinkedList<C0079> linkedList = this.f5162.get(i);
        if (linkedList != null) {
            for (T t : linkedList) {
                if (t.m4502()) {
                    m4467();
                    this.f5165.mo4493(Long.valueOf(t.m4499()));
                    t.m4497();
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final synchronized void m4483(int i) {
        Object obj;
        m4467();
        ArrayList<Integer> arrayList = this.f5167.get(i);
        if (arrayList != null) {
            Iterator it = EI.m4845((List) arrayList).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (this.f5161.contains(Integer.valueOf(((Number) next).intValue()))) {
                    obj = next;
                    break;
                }
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : -1;
            Iterator<T> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (!this.f5161.contains(Integer.valueOf(intValue2))) {
                    m4468(intValue2);
                } else if (intValue2 == intValue) {
                    m4468(intValue2);
                }
            }
        }
        this.f5164 = i;
        m4489();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final synchronized void m4468(int i) {
        LinkedList<C0079> linkedList = this.f5162.get(i);
        if (linkedList != null) {
            for (T t : linkedList) {
                if (!t.m4502()) {
                    m4467();
                    t.m4498(this.f5165.mo4492(t.m4501(), t.m4500()));
                }
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private final synchronized void m4463(int i) {
        if (this.f5167.indexOfKey(i) < 0) {
            this.f5167.put(i, new ArrayList<>());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final synchronized void m4467() {
        C1348Bu.If.m4099(this.f5163);
        if (this.f5165.mo4495(new C0634().m16817()) == null) {
            this.f5165.mo4494();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Cl$ˊ  reason: contains not printable characters */
    public static final class C0079 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private AbstractC0574 f5171;

        /* renamed from: ˏ  reason: contains not printable characters */
        private AppView f5172;

        /* renamed from: ॱ  reason: contains not printable characters */
        private long f5173;

        public C0079(AppView appView, long j, AbstractC0574 r5) {
            C1457Fr.m5025(appView, "appView");
            this.f5172 = appView;
            this.f5173 = j;
            this.f5171 = r5;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0079(AppView appView, long j, AbstractC0574 r6, int i, C1456Fq fq) {
            this(appView, (i & 2) != 0 ? -1 : j, (i & 4) != 0 ? null : r6);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m4498(long j) {
            this.f5173 = j;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final long m4499() {
            return this.f5173;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final AbstractC0574 m4500() {
            return this.f5171;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final AppView m4501() {
            return this.f5172;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final boolean m4502() {
            return this.f5173 != -1;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m4497() {
            this.f5173 = -1;
        }
    }
}
