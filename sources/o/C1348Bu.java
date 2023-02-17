package o;

import android.os.Handler;
import android.os.Looper;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
/* renamed from: o.Bu  reason: case insensitive filesystem */
public class C1348Bu {

    /* renamed from: o.Bu$If */
    public static class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static Handler f4662 = new Handler(Looper.getMainLooper());

        /* renamed from: ˊ  reason: contains not printable characters */
        public static boolean m4098(Runnable runnable) {
            return f4662.post(runnable);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static boolean m4100(Runnable runnable, long j) {
            return f4662.postDelayed(runnable, j);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static void m4099(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("runnable cannot be null");
            }
            f4662.removeCallbacks(runnable);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4093() {
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4094() {
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m4095() {
        return m4096(null, null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m4096(Thread thread, Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        ArrayList<Thread> arrayList = new ArrayList(allStackTraces.keySet());
        Collections.sort(arrayList, new Comparator<Thread>() { // from class: o.Bu.5
            /* renamed from: ˏ  reason: contains not printable characters */
            public int compare(Thread thread2, Thread thread3) {
                if (thread2 == thread3) {
                    return 0;
                }
                if (thread2 == null) {
                    return -1;
                }
                if (thread3 == null) {
                    return 1;
                }
                return (thread2.getThreadGroup() + thread2.toString()).compareTo(thread3.getThreadGroup() + thread3.toString());
            }
        });
        if (thread != null) {
            arrayList.add(0, thread);
        }
        if (!arrayList.contains(Thread.currentThread())) {
            arrayList.add(0, Thread.currentThread());
        }
        for (Thread thread2 : arrayList) {
            printWriter.println((thread2 == thread ? "CRASHED " : "") + "\"" + thread2.getName() + "\" " + (thread2.getThreadGroup() == null ? "" : "group=\"" + thread2.getThreadGroup().getName() + "\"") + " priority=" + thread2.getPriority() + " tid=" + thread2.getId() + " state=" + thread2.getState() + " alive=" + thread2.isAlive() + " daemon=" + thread2.isDaemon() + " interrupted=" + thread2.isInterrupted());
            StackTraceElement[] stackTraceElementArr = null;
            if (thread == null || thread != thread2) {
                if (Thread.currentThread() == thread2) {
                    stackTraceElementArr = new Throwable().getStackTrace();
                } else {
                    stackTraceElementArr = allStackTraces.get(thread2);
                }
            } else if (th != null) {
                stackTraceElementArr = th.getStackTrace();
            } else {
                C1283.m16865("ThreadUtils", "If crashed is not null cause should not be null !");
            }
            if (stackTraceElementArr != null) {
                int length = stackTraceElementArr.length;
                for (int i = 0; i < length; i++) {
                    printWriter.println("\tat " + stackTraceElementArr[i]);
                }
            } else {
                printWriter.println("\tno trace available");
            }
            printWriter.println();
        }
        printWriter.flush();
        return byteArrayOutputStream.toString();
    }
}
