package o;

import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.user.UserAgent;
/* renamed from: o.cs  reason: case insensitive filesystem */
public class C1627cs {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m5962(AbstractC1052 r1) {
        m5963(r1, true);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m5964(AbstractC1052 r1) {
        m5963(r1, false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m5963(AbstractC1052 r2, boolean z) {
        if (r2 instanceof C1260) {
            if (z) {
                PerformanceProfiler.INSTANCE.m663(Sessions.CONFIG_AGENT_LOADED);
            } else {
                PerformanceProfiler.INSTANCE.m672(Sessions.CONFIG_AGENT_LOADED);
            }
        } else if (r2 instanceof UserAgent) {
            if (z) {
                PerformanceProfiler.INSTANCE.m663(Sessions.USER_AGENT_LOADED);
            } else {
                PerformanceProfiler.INSTANCE.m672(Sessions.USER_AGENT_LOADED);
            }
        } else if (r2 instanceof N) {
            if (z) {
                PerformanceProfiler.INSTANCE.m663(Sessions.LOGGING_AGENT_LOADED);
            } else {
                PerformanceProfiler.INSTANCE.m672(Sessions.LOGGING_AGENT_LOADED);
            }
        } else if (r2 instanceof C2003ng) {
            if (z) {
                PerformanceProfiler.INSTANCE.m663(Sessions.RESOURCE_FETCHER_LOAD);
            } else {
                PerformanceProfiler.INSTANCE.m672(Sessions.RESOURCE_FETCHER_LOAD);
            }
        } else if (!(r2 instanceof C1926k)) {
        } else {
            if (z) {
                PerformanceProfiler.INSTANCE.m663(Sessions.FALKOR_AGENT_LOADED);
            } else {
                PerformanceProfiler.INSTANCE.m672(Sessions.FALKOR_AGENT_LOADED);
            }
        }
    }
}
