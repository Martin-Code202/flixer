package com.netflix.mediaclient.ui.launch;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import o.C0693;
public class NetflixComLaunchActivity extends Activity {
    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m2016(getIntent());
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m2016(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2016(Intent intent) {
        if (!C0693.m14983(intent) || !C0693.m14982(this, intent)) {
            intent.setComponent(new ComponentName(this, LaunchActivity.class));
            startActivity(intent);
            return;
        }
        intent.setData(null);
    }
}
