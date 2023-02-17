package com.crittercism.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import java.util.ArrayDeque;
import java.util.Deque;
public final class br extends bn {
    public au b;
    public Deque<String> c = new ArrayDeque();

    public br(Application application, au auVar) {
        super(application);
        if (Build.VERSION.SDK_INT < 9) {
            throw new IllegalStateException("Activity monitoring is only supported on API 9 and later");
        }
        this.b = auVar;
        a();
    }

    private static String d(Activity activity) {
        if (activity == null) {
            return null;
        }
        return activity.getComponentName().flattenToShortString().replace("/", "");
    }

    private void g() {
        this.b.g = this.c.peekFirst();
    }

    @Override // com.crittercism.internal.bn
    public final void b(Activity activity) {
        if (this.c.size() >= 10000) {
            this.c.removeLast();
        }
        String d = d(activity);
        if (d != null) {
            this.c.addFirst(d);
            g();
        }
    }

    @Override // com.crittercism.internal.bn
    public final void c(Activity activity) {
        String d = d(activity);
        if (d != null) {
            this.c.removeFirstOccurrence(d);
            g();
        }
    }

    @Override // com.crittercism.internal.bn
    public final void e() {
    }
}
