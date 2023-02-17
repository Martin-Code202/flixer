package o;

import android.os.Process;
/* renamed from: o.ｬ$3  reason: invalid class name */
class $3 implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            Object[] objArr = new Object[2];
            objArr[1] = 5;
            objArr[0] = 0;
            int intValue = ((Integer) ((Class) C1235.m16591(0, 3, 0)).getDeclaredMethod("ˏ", Integer.TYPE, Integer.TYPE).invoke(null, objArr)).intValue();
            int myPid = Process.myPid();
            if (intValue == 0) {
                Process.killProcess(myPid);
                return;
            }
            try {
                Thread.sleep((long) (intValue * 1000));
            } catch (InterruptedException e) {
            }
            Process.killProcess(myPid);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
