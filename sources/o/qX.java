package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import com.netflix.mediaclient.service.logging.perf.Events;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public final class qX {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static volatile Map<String, CountDownLatch> f9566;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final HashMap<AbstractC2072pu, AbstractC1203> f9567 = new HashMap<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final ArrayDeque<AbstractC2072pu> f9568 = new ArrayDeque<>();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static volatile Set<String> f9569;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Object f9570 = new Object();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final AtomicInteger f9571 = new AtomicInteger();

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m10006(C2059ph phVar, List<? extends AbstractC2072pu> list) {
        if (!m10016(phVar, list)) {
            C1283.m16854("DPPrefetchManager", "List is null, empty or manager is not ready ");
        } else {
            m10018(phVar, list, Math.min(1, list.size()));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m10011(C2059ph phVar, List<? extends AbstractC2072pu> list) {
        if (!m10016(phVar, list)) {
            C1283.m16854("DPPrefetchManager", "Video list is null, empty or manager is not ready");
        } else {
            m10018(phVar, list, Math.min(3, list.size()));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m10003(C2059ph phVar, List<? extends AbstractC2072pu> list) {
        if (!m10016(phVar, list)) {
            C1283.m16854("DPPrefetchManager", "List is null, empty or manager is not ready");
        } else {
            m10018(phVar, list, Math.min(1, list.size()));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m10002(String str) {
        C1348Bu.m4094();
        if (f9569 == null) {
            f9569 = Collections.synchronizedSet(new HashSet());
        }
        f9569.add(str);
        C1283.m16851("DPPrefetchManager", "Start prefetch DP request for videoId - %s", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m10014(String str) {
        m10007();
        if (f9569 != null) {
            f9569.remove(str);
            C1283.m16851("DPPrefetchManager", "Received prefetch DP response for videoId - %s", str);
            if (f9566 != null && f9566.containsKey(str)) {
                CountDownLatch countDownLatch = f9566.get(str);
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                f9566.remove(str);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m10009(String str) {
        C1348Bu.m4094();
        if (m10019(str)) {
            CountDownLatch countDownLatch = null;
            if (f9566 == null) {
                f9566 = Collections.synchronizedMap(new HashMap());
            }
            if (f9566.containsKey(str)) {
                countDownLatch = f9566.get(str);
            }
            if (countDownLatch == null) {
                countDownLatch = new CountDownLatch(1);
            }
            f9566.put(str, countDownLatch);
            try {
                C1283.m16851("DPPrefetchManager", "Waiting on prefetch DP response for videoId - %s", str);
                PerformanceProfiler.INSTANCE.m669(Events.DP_PREFETCH_REQUEST_IN_FLIGHT_EVENT, (Map<String, String>) null);
                C1283.m16851("DPPrefetchManager", "latchToPrefetchRequestIfExists: latch await countdown complete = %b", Boolean.valueOf(countDownLatch.await(20000, TimeUnit.MILLISECONDS)));
            } catch (InterruptedException e) {
                C1283.m16854("DPPrefetchManager", "latchToPrefetchRequestIfExists: latch interrupted");
            } finally {
                f9566.remove(str);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m10019(String str) {
        return f9569 != null && f9569.contains(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m10008(Status status) {
        boolean z = false;
        if (status instanceof FalkorAgentStatus) {
            z = ((FalkorAgentStatus) status).m546();
        }
        PerformanceProfiler.INSTANCE.m669(Events.DP_METADATA_FETCHED_EVENT, Collections.singletonMap("isFromCache", String.valueOf(z)));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Object m10005() {
        return f9570;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m10015(C2059ph phVar) {
        if (phVar != null) {
            phVar.m9816(m10005());
        }
        f9568.clear();
        f9567.clear();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m10010(List<? extends AbstractC2072pu> list, AbstractC1203 r5) {
        if (!(list == null || list.isEmpty())) {
            for (int size = list.size() - 1; size >= 0; size--) {
                AbstractC2072pu puVar = (AbstractC2072pu) list.get(size);
                if (f9568.remove(puVar)) {
                    f9567.remove(puVar);
                }
                f9568.addFirst(puVar);
                f9567.put(puVar, r5);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m10004() {
        return f9568.isEmpty();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AbstractC2072pu m10012() {
        try {
            if (f9568.isEmpty()) {
                return null;
            }
            return f9568.pop();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AbstractC1203 m10013(AbstractC2072pu puVar) {
        AbstractC1203 remove = f9567.remove(puVar);
        if (remove == null) {
            return AbstractC1222.m16563();
        }
        return remove;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m10017() {
        return f9571.get();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m10007() {
        return f9571.getAndDecrement();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static int m10001() {
        return f9571.getAndIncrement();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m10018(C2059ph phVar, List<? extends AbstractC2072pu> list, int i) {
        if (m10016(phVar, list)) {
            phVar.m9764().mo9486(list.subList(0, Math.min(i, list.size())), new AbstractC2061pj() { // from class: o.qX.4
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m10016(C2059ph phVar, List<? extends AbstractC2072pu> list) {
        if (list == null || list.isEmpty()) {
            C1283.m16854("DPPrefetchManager", "isInputValid: videos list is empty");
            return false;
        } else if (phVar != null && phVar.mo9519()) {
            return true;
        } else {
            C1283.m16854("DPPrefetchManager", "isInputValid: manager not ready or not in AB test");
            return false;
        }
    }
}
