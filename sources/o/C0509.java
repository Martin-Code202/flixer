package o;

import java.util.ArrayList;
import java.util.List;
/* renamed from: o.і  reason: contains not printable characters */
public class C0509 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String f13642 = "VolleyLog";

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m14523(String str, Object... objArr) {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m14520(String str, Object... objArr) {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m14519(String str, Object... objArr) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m14522(Throwable th, String str, Object... objArr) {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m14521(String str, Object... objArr) {
    }

    /* renamed from: o.і$iF */
    public static class iF {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final List<If> f13643 = new ArrayList();

        /* renamed from: ॱ  reason: contains not printable characters */
        private boolean f13644 = false;

        /* access modifiers changed from: package-private */
        /* renamed from: o.і$iF$If */
        public static class If {

            /* renamed from: ˊ  reason: contains not printable characters */
            public final long f13645;
        }

        iF() {
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public synchronized void m14525(String str) {
            this.f13644 = true;
            long r4 = m14524();
            if (r4 > 0) {
                long j = this.f13643.get(0).f13645;
                C0509.m14520("(%-4d ms) %s", Long.valueOf(r4), str);
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            if (!this.f13644) {
                m14525("Request on the loose");
                C0509.m14519("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private long m14524() {
            if (this.f13643.size() == 0) {
                return 0;
            }
            return this.f13643.get(this.f13643.size() - 1).f13645 - this.f13643.get(0).f13645;
        }
    }
}
