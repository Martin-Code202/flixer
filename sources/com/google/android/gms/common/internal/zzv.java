package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
/* access modifiers changed from: package-private */
public final class zzv extends zzu {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ int val$requestCode;

    zzv(Intent intent, Activity activity, int i) {
        this.val$intent = intent;
        this.val$activity = activity;
        this.val$requestCode = i;
    }

    @Override // com.google.android.gms.common.internal.zzu
    public final void zzakb() {
        if (this.val$intent != null) {
            this.val$activity.startActivityForResult(this.val$intent, this.val$requestCode);
        }
    }
}
