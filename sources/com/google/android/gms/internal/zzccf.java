package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzbp;
/* access modifiers changed from: package-private */
public class zzccf extends BroadcastReceiver {
    private static String zzdti = zzccf.class.getName();
    private boolean mRegistered;
    private boolean zzdtj;
    private final zzccw zzikh;

    zzccf(zzccw zzccw) {
        zzbp.zzu(zzccw);
        this.zzikh = zzccw;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.zzikh.zzwk();
        String action = intent.getAction();
        this.zzikh.zzaum().zzayk().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzyx = this.zzikh.zzazb().zzyx();
            if (this.zzdtj != zzyx) {
                this.zzdtj = zzyx;
                this.zzikh.zzaul().zzg(new zzccg(this, zzyx));
                return;
            }
            return;
        }
        this.zzikh.zzaum().zzayg().zzj("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void unregister() {
        this.zzikh.zzwk();
        this.zzikh.zzaul().zzuj();
        this.zzikh.zzaul().zzuj();
        if (this.mRegistered) {
            this.zzikh.zzaum().zzayk().log("Unregistering connectivity change receiver");
            this.mRegistered = false;
            this.zzdtj = false;
            try {
                this.zzikh.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzikh.zzaum().zzaye().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public final void zzyu() {
        this.zzikh.zzwk();
        this.zzikh.zzaul().zzuj();
        if (!this.mRegistered) {
            this.zzikh.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzdtj = this.zzikh.zzazb().zzyx();
            this.zzikh.zzaum().zzayk().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzdtj));
            this.mRegistered = true;
        }
    }
}
