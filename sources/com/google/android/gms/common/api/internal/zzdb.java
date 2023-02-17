package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
public final class zzdb extends Fragment implements zzcg {
    private static WeakHashMap<FragmentActivity, WeakReference<zzdb>> zzfoo = new WeakHashMap<>();
    private int zzbyy = 0;
    private Map<String, LifecycleCallback> zzfop = new ArrayMap();
    private Bundle zzfoq;

    public static zzdb zza(FragmentActivity fragmentActivity) {
        zzdb zzdb;
        WeakReference<zzdb> weakReference = zzfoo.get(fragmentActivity);
        if (weakReference != null && (zzdb = weakReference.get()) != null) {
            return zzdb;
        }
        try {
            zzdb zzdb2 = (zzdb) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzdb2 == null || zzdb2.isRemoving()) {
                zzdb2 = new zzdb();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add(zzdb2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzfoo.put(fragmentActivity, new WeakReference<>(zzdb2));
            return zzdb2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbyy = 1;
        this.zzfoq = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.zzfop.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.zzbyy = 5;
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.zzbyy = 3;
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onResume();
        }
    }

    @Override // android.support.v4.app.Fragment
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

    @Override // android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        this.zzbyy = 2;
        for (LifecycleCallback lifecycleCallback : this.zzfop.values()) {
            lifecycleCallback.onStart();
        }
    }

    @Override // android.support.v4.app.Fragment
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
                new Handler(Looper.getMainLooper()).post(new zzdc(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
    }

    @Override // com.google.android.gms.common.api.internal.zzcg
    public final /* synthetic */ Activity zzaik() {
        return getActivity();
    }
}
