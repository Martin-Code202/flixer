package o;

import android.app.Activity;
import android.os.Handler;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/* renamed from: o.By  reason: case insensitive filesystem */
public class C1352By {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m4137(int i) {
        return (int) ((((float) i) / 60.0f) + 0.5f);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static long m4136(long j) {
        return j / 1000000;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static long m4139(long j) {
        return (System.nanoTime() - j) / 1000000;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4138(long j) {
        SimpleDateFormat simpleDateFormat;
        if (j <= 0) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        if (instance2.get(1) == instance.get(1)) {
            simpleDateFormat = new SimpleDateFormat("MMM d", Locale.getDefault());
        } else {
            simpleDateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
        }
        return simpleDateFormat.format(instance2.getTime());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m4135(int i, int i2, int i3) {
        if (i2 > 0 && i >= i2) {
            return 0;
        }
        if ((i3 <= 0 || i < i3 - 30) && i >= 0) {
            return i;
        }
        return 0;
    }

    /* renamed from: o.By$ˋ  reason: contains not printable characters */
    public static class C0072 {

        /* renamed from: ʻ  reason: contains not printable characters */
        private final Runnable f4667 = new Runnable() { // from class: o.By.ˋ.5
            @Override // java.lang.Runnable
            public void run() {
                if (C0072.this.f4668) {
                    C0072.m4143(C0072.this);
                    if (C0072.this.f4671 != null) {
                        C0072.this.f4671.run();
                    }
                    if (C0072.this.f4670 > 0) {
                        C0072.this.f4669.postDelayed(this, 1000);
                        return;
                    }
                    if (C0072.this.f4673 != null) {
                        C0072.this.f4673.run();
                    }
                    C0072.this.m4150();
                }
            }
        };

        /* renamed from: ʼ  reason: contains not printable characters */
        private boolean f4668;

        /* renamed from: ˊ  reason: contains not printable characters */
        private Handler f4669;

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f4670;

        /* renamed from: ˎ  reason: contains not printable characters */
        private Runnable f4671;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final Activity f4672;

        /* renamed from: ॱ  reason: contains not printable characters */
        private Runnable f4673;

        /* renamed from: ˎ  reason: contains not printable characters */
        static /* synthetic */ int m4143(C0072 r2) {
            int i = r2.f4670;
            r2.f4670 = i - 1;
            return i;
        }

        public C0072(Activity activity) {
            this.f4672 = activity;
            this.f4669 = new Handler(activity.getMainLooper());
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m4151() {
            if (!this.f4668 && this.f4670 > 0) {
                this.f4668 = true;
                this.f4669.postDelayed(this.f4667, 1000);
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m4150() {
            this.f4668 = false;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m4149(Runnable runnable) {
            this.f4671 = runnable;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m4147(Runnable runnable) {
            this.f4673 = runnable;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public int m4146() {
            return this.f4670;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m4148(int i) {
            this.f4670 = i;
        }
    }
}
