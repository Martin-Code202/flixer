package com.crittercism.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@SuppressLint({"NewApi"})
public abstract class bn {
    private static final int[] g = {32, 544, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 8224};
    boolean a = false;
    private int b = 0;
    private boolean c = false;
    private boolean d = false;
    private Application e = null;
    private a f = null;

    static /* synthetic */ int f(bn bnVar) {
        int i = bnVar.b;
        bnVar.b = i + 1;
        return i;
    }

    static /* synthetic */ int h(bn bnVar) {
        int i = bnVar.b;
        bnVar.b = i - 1;
        return i;
    }

    public bn(Application application) {
        if (Build.VERSION.SDK_INT < 14) {
            throw new IllegalStateException("App lifecycle monitoring is only supported on API 14 and later");
        }
        this.e = application;
    }

    public final void a() {
        if (this.f == null) {
            this.f = new a(this, (byte) 0);
            this.e.registerActivityLifecycleCallbacks(this.f);
            if (a(this.e)) {
                g();
            }
        }
    }

    class a implements Application.ActivityLifecycleCallbacks {
        private a() {
        }

        /* synthetic */ a(bn bnVar, byte b) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            if (activity != null) {
                try {
                    bn.this.b(activity);
                    bn.this.g();
                    if (!bn.this.d) {
                        bn.this.d = true;
                    }
                    if (bn.this.c) {
                        cf.d("not a foreground. rotation event.");
                        bn.this.c = false;
                    } else {
                        if (bn.this.b == 0) {
                            bn.this.b();
                        }
                        bn.this.a(activity);
                    }
                    bn.f(bn.this);
                } catch (ThreadDeath e) {
                    throw e;
                } catch (Throwable th) {
                    cf.b(th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            if (activity != null) {
                try {
                    bn.this.c(activity);
                    if (!bn.this.d) {
                        int unused = bn.this.b;
                        bn.this.b = 1;
                        bn.this.d = true;
                    }
                    bn.this.g();
                } catch (ThreadDeath e) {
                    throw e;
                } catch (Throwable th) {
                    cf.b(th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            if (activity != null) {
                try {
                    bn.this.e();
                    if (!bn.this.d) {
                        int unused = bn.this.b;
                        bn.this.b = 1;
                        bn.this.d = true;
                    }
                    bn.h(bn.this);
                    if (activity.isChangingConfigurations()) {
                        cf.d("not a background. rotation event.");
                        bn.this.c = true;
                    } else if (bn.this.b == 0) {
                        bn.this.c();
                    }
                } catch (ThreadDeath e) {
                    throw e;
                } catch (Throwable th) {
                    cf.b(th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g() {
        if (!this.a) {
            this.a = true;
            d();
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void a(Activity activity) {
    }

    public void b(Activity activity) {
    }

    public void c(Activity activity) {
    }

    public void e() {
    }

    private static boolean a(Context context) {
        if (context instanceof Activity) {
            return true;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method method = cls.getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            if (!cls.isAssignableFrom(method.getReturnType())) {
                throw new NoSuchMethodException("currentActivityThread");
            }
            Object invoke = method.invoke(null, new Object[0]);
            Class cls2 = Integer.TYPE;
            Field declaredField = cls.getDeclaredField("mNumVisibleActivities");
            declaredField.setAccessible(true);
            if (cls2.isAssignableFrom(declaredField.getType())) {
                return ((Integer) declaredField.get(invoke)).intValue() > 0;
            }
            throw new NoSuchFieldException("mNumVisibleActivities");
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            cf.a("Unable to detect if app has finished launching", th);
            return false;
        }
    }

    public static long f() {
        long[] jArr = new long[1];
        Boolean bool = false;
        Throwable e2 = null;
        try {
            bool = (Boolean) Process.class.getDeclaredMethod("readProcFile", String.class, int[].class, String[].class, long[].class, float[].class).invoke(null, "/proc/" + Process.myPid() + "/stat", g, null, jArr, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            e2 = e3;
        }
        if (bool.booleanValue()) {
            return System.currentTimeMillis() - (SystemClock.elapsedRealtime() - (jArr[0] * 10));
        }
        throw new IOException("Unable to determine process start time", e2);
    }
}
