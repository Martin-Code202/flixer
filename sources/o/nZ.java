package o;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.util.Iterator;
import java.util.List;
public class nZ extends BroadcastReceiver {

    /* renamed from: ʻ  reason: contains not printable characters */
    private BluetoothDevice f9089;

    /* renamed from: ʼ  reason: contains not printable characters */
    private BluetoothHeadset f9090;

    /* renamed from: ʽ  reason: contains not printable characters */
    private BluetoothProfile.ServiceListener f9091;

    /* renamed from: ˊ  reason: contains not printable characters */
    private AudioManager f9092 = ((AudioManager) this.f9095.getSystemService("audio"));

    /* renamed from: ˋ  reason: contains not printable characters */
    private If f9093;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f9094;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Context f9095;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f9096 = false;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private BluetoothAdapter f9097;

    public interface If {
        void M_();
    }

    public nZ(Context context, If r4) {
        this.f9095 = context;
        this.f9093 = r4;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9261() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        this.f9095.registerReceiver(this, intentFilter);
        C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] broadcast receiver started");
        m9254();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m9254() {
        if (this.f9096) {
            C1283.m16865("nf_voip_bluetooth", "[BluetoothAudioManager] Already started, skipping...");
            return;
        }
        this.f9097 = BluetoothAdapter.getDefaultAdapter();
        if (this.f9097 == null || !this.f9097.isEnabled()) {
            C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] Interface disabled on device");
            return;
        }
        if (this.f9091 != null) {
            C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] Headset profile was already opened, let's close it");
            this.f9097.closeProfileProxy(1, this.f9090);
        }
        this.f9091 = new BluetoothProfile.ServiceListener() { // from class: o.nZ.5
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                if (i == 1) {
                    C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] Headset connected");
                    nZ.this.f9090 = (BluetoothHeadset) bluetoothProfile;
                    nZ.this.f9096 = true;
                }
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
                if (i == 1) {
                    nZ.this.f9090 = null;
                    nZ.this.f9096 = false;
                    C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] Headset disconnected");
                    nZ.this.f9093.M_();
                }
            }
        };
        if (!this.f9097.getProfileProxy(this.f9095, this.f9091, 1)) {
            C1283.m16865("nf_voip_bluetooth", "[BluetoothAudioManager] getProfileProxy failed !");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m9260() {
        if (this.f9097 == null || !this.f9097.isEnabled() || this.f9092 == null || !this.f9092.isBluetoothScoAvailableOffCall() || !m9263()) {
            return false;
        }
        if (this.f9092 != null && !this.f9092.isBluetoothScoOn()) {
            C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] SCO off, let's start it");
            this.f9092.setBluetoothScoOn(true);
            this.f9092.startBluetoothSco();
        }
        boolean r2 = m9262();
        if (r2) {
            C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] Audio route ok");
        } else {
            C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] Audio route not ok.");
        }
        return r2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m9262() {
        return this.f9090 != null && this.f9090.isAudioConnected(this.f9089) && this.f9094 && this.f9092 != null && this.f9092.isBluetoothScoOn();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m9263() {
        if (this.f9097 == null || !this.f9097.isEnabled() || this.f9092 == null || !this.f9092.isBluetoothScoAvailableOffCall()) {
            return false;
        }
        boolean z = false;
        if (this.f9090 != null) {
            List<BluetoothDevice> connectedDevices = this.f9090.getConnectedDevices();
            this.f9089 = null;
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BluetoothDevice next = it.next();
                if (this.f9090.getConnectionState(next) == 2) {
                    this.f9089 = next;
                    z = true;
                    break;
                }
            }
            C1283.m16854("nf_voip_bluetooth", z ? "[BluetoothAudioManager] Headset found, bluetooth audio route available" : "[BluetoothAudioManager] No headset found, bluetooth audio route unavailable");
        }
        return z;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9259() {
        if (this.f9092 != null) {
            this.f9092.stopBluetoothSco();
            this.f9092.setBluetoothScoOn(false);
            C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] SCO disconnected!");
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m9264() {
        C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] Stopping...");
        this.f9096 = false;
        m9259();
        if (!(this.f9097 == null || this.f9091 == null || this.f9090 == null)) {
            this.f9097.closeProfileProxy(1, this.f9090);
            this.f9091 = null;
        }
        this.f9089 = null;
        C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] Stopped!");
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m9258() {
        try {
            m9264();
            this.f9095.unregisterReceiver(this);
        } catch (Exception e) {
            C1283.m16850("nf_voip_bluetooth", e.getMessage());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(action)) {
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
            if (intExtra == 1) {
                C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] SCO state: connected");
                this.f9094 = true;
            } else if (intExtra == 0) {
                C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] SCO state: disconnected");
                this.f9094 = false;
            }
        } else if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0);
            if (intExtra2 == 0) {
                C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] State: disconnected, stopping Blutooth");
                m9264();
            } else if (intExtra2 == 2) {
                C1283.m16854("nf_voip_bluetooth", "[BluetoothAudioManager] State: connected, starting Bluetooth");
                m9254();
            }
        }
    }
}
