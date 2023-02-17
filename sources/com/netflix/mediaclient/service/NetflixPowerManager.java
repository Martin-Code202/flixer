package com.netflix.mediaclient.service;

import android.content.Context;
import android.os.PowerManager;
import java.util.HashSet;
import java.util.Set;
public class NetflixPowerManager {

    /* renamed from: ˊ  reason: contains not printable characters */
    private PowerManager.WakeLock f1060;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f1061;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Set<PartialWakeLockReason> f1062 = new HashSet();

    public enum PartialWakeLockReason {
        DownloadGoingOn
    }

    public NetflixPowerManager(Context context) {
        this.f1061 = context;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m495(PartialWakeLockReason partialWakeLockReason) {
        if (!this.f1062.contains(partialWakeLockReason)) {
            this.f1062.add(partialWakeLockReason);
            PowerManager powerManager = (PowerManager) this.f1061.getSystemService("power");
            if (powerManager != null) {
                if (this.f1060 == null) {
                    this.f1060 = powerManager.newWakeLock(1, "nf_power_manager");
                }
                if (this.f1060 != null && !this.f1060.isHeld()) {
                    this.f1060.acquire();
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m493(PartialWakeLockReason partialWakeLockReason) {
        this.f1062.remove(partialWakeLockReason);
        if (this.f1062.isEmpty() && this.f1060 != null && this.f1060.isHeld()) {
            this.f1060.release();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m494() {
        this.f1062.clear();
        if (this.f1060 != null && this.f1060.isHeld()) {
            this.f1060.release();
            this.f1060 = null;
        }
    }
}
