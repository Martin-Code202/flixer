package o;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.netflix.mediaclient.NetflixApplication;
import java.lang.Thread;
import java.util.Timer;
import java.util.TimerTask;
import o.C1529bE;
/* renamed from: o.ﾋ  reason: contains not printable characters */
public class C1273 implements C1529bE.AbstractC1530iF {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f15957 = 15;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f15958 = "Do you want to report it? You have %s seconds to do so.";

    /* renamed from: ˎ  reason: contains not printable characters */
    private AlertDialog f15959;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Handler f15960 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    static /* synthetic */ int m16813(C1273 r2) {
        int i = r2.f15957 - 1;
        r2.f15957 = i;
        return i;
    }

    @Override // o.C1529bE.AbstractC1530iF
    /* renamed from: ˏ */
    public void mo5740(boolean z, Thread thread, Throwable th, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (z) {
            m16807(thread, th, uncaughtExceptionHandler);
        } else {
            m16806(thread, th, uncaughtExceptionHandler);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16806(Thread thread, Throwable th, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        C1283.m16854("threadException", "Saving uncaughtException!!!");
        C1360Cf.m4370(th);
        m16810(NetflixApplication.getInstance());
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16807(Thread thread, final Throwable th, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        final String r6 = C1348Bu.m4096(thread, th);
        final String str = C1283.m16857(th).substring(0, 300) + "...";
        C1283.m16847("AndroidRuntime", th.getMessage(), th);
        new Thread() { // from class: o.ﾋ.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Looper.prepare();
                final Context r62 = NetflixApplication.m217();
                if (r62 != null) {
                    C1273.this.f15959 = new AlertDialog.Builder(r62).setTitle("Crash detected ! 🔥☢️🥀").setMessage(str + "\n\n" + String.format("Do you want to report it? You have %s seconds to do so.", Integer.valueOf(C1273.this.f15957))).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: o.ﾋ.4.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qC.m9873(r62, th, r6);
                            Process.killProcess(Process.myPid());
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: o.ﾋ.4.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Process.killProcess(Process.myPid());
                        }
                    }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: o.ﾋ.4.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            Process.killProcess(Process.myPid());
                        }
                    }).create();
                    C1273.this.f15959.show();
                }
                C1273.this.f15960 = new Handler();
                Looper.loop();
            }
        }.start();
        new Timer().scheduleAtFixedRate(new TimerTask() { // from class: o.ﾋ.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public synchronized void run() {
                if (C1273.this.f15960 != null) {
                    C1273.this.f15960.post(new Runnable() { // from class: o.ﾋ.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (C1273.this.f15959 != null) {
                                C1273.this.f15959.setMessage(str + "\n\n" + String.format("Do you want to report it? You have %s seconds to do so.", Integer.valueOf(C1273.m16813(C1273.this))));
                            }
                        }
                    });
                }
            }
        }, 1000, 1000);
        try {
            Thread.sleep((long) (this.f15957 * 1000));
        } catch (InterruptedException e) {
            C1283.m16850("AndroidRuntime", e.getMessage());
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
        m16810(NetflixApplication.getInstance());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m16810(Context context) {
        C1283.m16850("threadException", "Mark session as crashed");
        context.getSharedPreferences("ExportDebugData.PREFS_NAMES", 0).edit().putInt("ExportDebugData.PREF_CRASHED_PID", Process.myPid()).apply();
    }
}
