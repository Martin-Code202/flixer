package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
public final class zzch extends Fragment implements zzcg {
    private static WeakHashMap<Activity, WeakReference<zzch>> zzfoo = new WeakHashMap<>();
    private int zzbyy = 0;
    private Map<String, LifecycleCallback> zzfop = new ArrayMap();
    private Bundle zzfoq;

    public static zzch zzo(Activity activity) {
        zzch zzch;
        WeakReference<zzch> weakReference = zzfoo.get(activity);
        if (weakReference != null && (zzch = weakReference.get()) != null) {
            return zzch;
        }
        try {
            zzch zzch2 = (zzch) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzch2 == null || zzch2.isRemoving()) {
                zzch2 = new zzch();
                activity.getFragmentManager().beginTransaction().add(zzch2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzfoo.put(activity, new WeakReference<>(zzch2));
            return zzch2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbyy = 1;
        this.zzfoq = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.zzfop.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.zzbyy = 5;
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.zzbyy = 3;
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onResume();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry<String, LifecycleCallback> entry : this.zzfop.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().onSaveInstanceState(bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.zzbyy = 2;
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.zzbyy = 4;
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onStop();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcg
    public final <T extends LifecycleCallback> T zza(String str, Class<T> cls) {
        return cls.cast(this.zzfop.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.zzcg
    public final void zza(String str, LifecycleCallback lifecycleCallback) {
        if (!this.zzfop.containsKey(str)) {
            this.zzfop.put(str, lifecycleCallback);
            if (this.zzbyy > 0) {
                new Handler(Looper.getMainLooper()).post(new zzci(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
    }

    @Override // com.google.android.gms.common.api.internal.zzcg
    public final Activity zzaik() {
        return getActivity();
    }
}
