package o;

import com.facebook.network.connectionclass.ConnectionQuality;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: o.ﺗ  reason: contains not printable characters */
public class C1186 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private volatile boolean f15545;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1158 f15546;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AtomicReference<ConnectionQuality> f15547;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ArrayList<Object> f15548;

    /* renamed from: o.ﺗ$ˊ  reason: contains not printable characters */
    static class C1187 {

        /* renamed from: ॱ  reason: contains not printable characters */
        public static final C1186 f15550 = new C1186(null);
    }

    /* synthetic */ C1186(AnonymousClass1 r1) {
        this();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1186 m16443() {
        return C1187.f15550;
    }

    private C1186() {
        this.f15546 = new C1158(0.05d);
        this.f15545 = false;
        this.f15547 = new AtomicReference<>(ConnectionQuality.UNKNOWN);
        this.f15548 = new ArrayList<>();
    }

    /* renamed from: o.ﺗ$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: ˎ  reason: contains not printable characters */
        static final /* synthetic */ int[] f15549 = new int[ConnectionQuality.values().length];

        static {
            try {
                f15549[ConnectionQuality.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15549[ConnectionQuality.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15549[ConnectionQuality.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15549[ConnectionQuality.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized ConnectionQuality m16445() {
        if (this.f15546 == null) {
            return ConnectionQuality.UNKNOWN;
        }
        return m16442(this.f15546.m16346());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private ConnectionQuality m16442(double d) {
        if (d < 0.0d) {
            return ConnectionQuality.UNKNOWN;
        }
        if (d < 150.0d) {
            return ConnectionQuality.POOR;
        }
        if (d < 550.0d) {
            return ConnectionQuality.MODERATE;
        }
        if (d < 2000.0d) {
            return ConnectionQuality.GOOD;
        }
        return ConnectionQuality.EXCELLENT;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized double m16444() {
        double d;
        if (this.f15546 == null) {
            d = -1.0d;
        } else {
            d = this.f15546.m16346();
        }
        return d;
    }
}
