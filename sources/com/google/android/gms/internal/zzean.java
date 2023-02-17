package com.google.android.gms.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicReference;
public final class zzean {
    private static final AtomicReference<zzean> zzlgm = new AtomicReference<>();

    private zzean(Context context) {
    }

    public static void zze(FirebaseApp firebaseApp) {
    }

    public static zzean zzep(Context context) {
        zzlgm.compareAndSet(null, new zzean(context));
        return zzlgm.get();
    }
}
