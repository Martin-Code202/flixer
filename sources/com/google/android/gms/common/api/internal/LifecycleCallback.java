package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;
public class LifecycleCallback {
    protected final zzcg zzfon;

    protected LifecycleCallback(zzcg zzcg) {
        this.zzfon = zzcg;
    }

    @Keep
    private static zzcg getChimeraLifecycleFragmentImpl(zzcf zzcf) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    protected static zzcg zzb(zzcf zzcf) {
        if (zzcf.zzaig()) {
            return zzdb.zza(zzcf.zzaij());
        }
        if (zzcf.zzaih()) {
            return zzch.zzo(zzcf.zzaii());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Activity getActivity() {
        return this.zzfon.zzaik();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
