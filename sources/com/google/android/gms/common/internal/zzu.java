package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzcg;
public abstract class zzu implements DialogInterface.OnClickListener {
    public static zzu zza(Activity activity, Intent intent, int i) {
        return new zzv(intent, activity, i);
    }

    public static zzu zza(Fragment fragment, Intent intent, int i) {
        return new zzw(intent, fragment, i);
    }

    public static zzu zza(zzcg zzcg, Intent intent, int i) {
        return new zzx(intent, zzcg, 2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zzakb();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzakb();
}
