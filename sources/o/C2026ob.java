package o;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.PowerManager;
import com.netflix.mediaclient.util.DeviceCategory;
/* renamed from: o.ob  reason: case insensitive filesystem */
public class C2026ob {

    /* renamed from: ʼ  reason: contains not printable characters */
    private AbstractC1052 f9286;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f9287;

    /* renamed from: ˊ  reason: contains not printable characters */
    private PowerManager.WakeLock f9288;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Context f9289;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f9290;

    /* renamed from: ˏ  reason: contains not printable characters */
    private PowerManager.WakeLock f9291;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f9292;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0163 f9293 = new C0163();

    public C2026ob(Context context, AbstractC1052 r4) {
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        this.f9289 = context;
        this.f9286 = r4;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m9610() {
        this.f9290 = true;
        m9601();
        m9606();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            this.f9289.registerReceiver(this.f9293, intentFilter);
        } catch (Throwable th) {
            C1283.m16847("nf_voip", "Failed to register audio jack receiver", th);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m9603() {
        AudioManager audioManager = (AudioManager) this.f9289.getSystemService("audio");
        if (audioManager != null) {
            this.f9292 = audioManager.isWiredHeadsetOn() || audioManager.isBluetoothA2dpOn();
            this.f9287 = audioManager.isSpeakerphoneOn();
            return;
        }
        this.f9292 = false;
        this.f9287 = false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m9608() {
        this.f9290 = false;
        m9602();
        m9607();
        try {
            this.f9289.unregisterReceiver(this.f9293);
        } catch (Throwable th) {
        }
    }

    @TargetApi(21)
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9604() {
        if (this.f9291 != null && this.f9291.isHeld()) {
            this.f9291.release();
        }
        if (this.f9286.m16101().mo16541() != DeviceCategory.PHONE) {
            C1283.m16854("nf_voip", "Device is tablet (like), do NOT acquire screen lock!");
            return;
        }
        C1283.m16854("nf_voip", "Device is phone, do acquire screen lock!");
        PowerManager powerManager = (PowerManager) this.f9289.getSystemService("power");
        if (powerManager == null) {
            C1283.m16865("nf_voip", "Power manager is not available!");
            return;
        }
        try {
            this.f9291 = powerManager.newWakeLock(32, "nf_voip");
        } catch (Throwable th) {
            C1283.m16847("nf_voip", "Failed to created new wake lock for promixity!", th);
        }
        if (this.f9291 != null) {
            C1283.m16854("nf_voip", "Proximity screen wake off is supported on this device. Aquiring...");
            this.f9291.acquire();
            C1283.m16854("nf_voip", "Proximity sensor aquired.");
            return;
        }
        C1283.m16854("nf_voip", "Proximity screen wake off is not supported on this device");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9602() {
        if (this.f9291 != null) {
            if (this.f9291.isHeld()) {
                C1283.m16854("nf_voip", "releaseScreenLock: releasing...");
                this.f9291.release();
            } else {
                C1283.m16865("nf_voip", "releaseScreenLock: lock already released!");
            }
            this.f9291 = null;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m9601() {
        if (this.f9288 != null && this.f9288.isHeld()) {
            this.f9288.release();
        }
        PowerManager powerManager = (PowerManager) this.f9289.getSystemService("power");
        if (powerManager == null) {
            C1283.m16865("nf_voip", "Power manager is not available!");
            return;
        }
        try {
            this.f9288 = powerManager.newWakeLock(1, "nf_voip");
        } catch (Throwable th) {
            C1283.m16850("nf_voip", "Failed to created new wake lock for promixity!");
        }
        if (this.f9288 != null) {
            C1283.m16854("nf_voip", "acquireCpuLock: acquiring...");
            this.f9288.acquire();
            C1283.m16854("nf_voip", "acquireCpuLock: acquired.");
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m9607() {
        if (this.f9288 != null) {
            if (this.f9288.isHeld()) {
                C1283.m16854("nf_voip", "releaseCpuLock: releasing...");
                this.f9288.release();
            } else {
                C1283.m16865("nf_voip", "releaseCpuLock: lock already released!");
            }
            this.f9288 = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m9606() {
        m9603();
        if (this.f9290) {
            boolean z = false;
            if (this.f9287) {
                C1283.m16854("nf_voip", "Speaker is on, release proximity lock.");
                z = true;
            } else if (this.f9292) {
                C1283.m16854("nf_voip", "Headphones are used for call, release proximity lock.");
                z = true;
            } else {
                C1283.m16854("nf_voip", "Internal speaker is used, acquire proximity lock.");
            }
            if (z) {
                C1283.m16854("nf_voip", "Release proximity lock...");
                m9602();
                return;
            }
            C1283.m16854("nf_voip", "Acquire proximity lock...");
            m9604();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9609(boolean z) {
        m9606();
    }

    /* renamed from: o.ob$ˋ  reason: contains not printable characters */
    class C0163 extends BroadcastReceiver {
        private C0163() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                C1283.m16854("nf_voip", "Wired headset state changed...");
                C2026ob.this.m9606();
            } else if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action) || "android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                C1283.m16854("nf_voip", "Bluetooth headset state changed...");
                C2026ob.this.m9606();
            }
        }
    }
}
