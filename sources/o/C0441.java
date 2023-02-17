package o;

import com.netflix.cl.model.AllocationMode;
import com.netflix.cl.model.ComputationMode;
import com.netflix.cl.model.InteractionMode;
import com.netflix.cl.model.LoggingSource;
import java.util.concurrent.atomic.AtomicLong;
/* renamed from: o.ˠ  reason: contains not printable characters */
public final class C0441 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Cif f13476;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static AtomicLong f13477 = new AtomicLong(0);

    /* renamed from: o.ˠ$If */
    public interface If {
        /* renamed from: ˏ */
        void mo4537(String str);
    }

    /* renamed from: o.ˠ$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ʻ */
        InteractionMode mo4518();

        /* renamed from: ʼ */
        String mo4519();

        /* renamed from: ʽ */
        String mo4520();

        /* renamed from: ˊ */
        String mo4521();

        /* renamed from: ˊॱ */
        String mo4522();

        /* renamed from: ˋ */
        LoggingSource mo4523();

        /* renamed from: ˋॱ */
        long mo4524();

        /* renamed from: ˎ */
        AbstractC0442 mo4525();

        /* renamed from: ˏ */
        long mo4526();

        /* renamed from: ˏॱ */
        String mo4527();

        /* renamed from: ॱ */
        If mo4528();

        /* renamed from: ॱˊ */
        void mo4529();

        /* renamed from: ॱॱ */
        AllocationMode mo4530();

        /* renamed from: ᐝ */
        ComputationMode mo4531();
    }

    /* renamed from: o.ˠ$ˊ  reason: contains not printable characters */
    public interface AbstractC0442 {
        /* renamed from: ˊ */
        void mo4532(String str, Object... objArr);

        /* renamed from: ˋ */
        void mo4533(String str);

        /* renamed from: ˋ */
        boolean mo4534();

        /* renamed from: ˎ */
        void mo4535(String str, Object... objArr);

        /* renamed from: ˏ */
        void mo4536(String str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m14303(Cif ifVar) {
        f13476 = ifVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m14299() {
        return f13476.mo4526();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static long m14302() {
        return f13477.incrementAndGet();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static LoggingSource m14298() {
        return f13476.mo4523();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m14296() {
        return f13476.mo4521();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static AllocationMode m14294() {
        return f13476.mo4530();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static ComputationMode m14306() {
        return f13476.mo4531();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static InteractionMode m14293() {
        return f13476.mo4518();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m14291() {
        return f13476.mo4520();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m14292() {
        return f13476.mo4519();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static long m14305() {
        return f13476.mo4524();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public static String m14301() {
        return f13476.mo4522();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static String m14297() {
        return f13476.mo4527();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static AbstractC0442 m14304() {
        return f13476.mo4525();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static If m14295() {
        return f13476.mo4528();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static void m14300() {
        f13476.mo4529();
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public static void m14307() {
        f13477.set(0);
    }
}
