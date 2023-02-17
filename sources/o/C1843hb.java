package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import o.C2058pg;
/* access modifiers changed from: package-private */
/* renamed from: o.hb  reason: case insensitive filesystem */
public class C1843hb {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f7206;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f7207;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final BroadcastReceiver f7208 = new BroadcastReceiver() { // from class: o.hb.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1843hb.this.m7031(intent);
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    private final If f7209;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Handler f7210;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final BroadcastReceiver f7211 = new BroadcastReceiver() { // from class: o.hb.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1843hb.this.m7030(intent);
        }
    };

    /* access modifiers changed from: package-private */
    /* renamed from: o.hb$If */
    public interface If {
        void C_();

        /* renamed from: ˊ  reason: contains not printable characters */
        void mo7037();

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo7038();

        /* renamed from: ˎ  reason: contains not printable characters */
        void mo7039();

        /* renamed from: ॱ  reason: contains not printable characters */
        void mo7040();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7031(Intent intent) {
        if (intent != null) {
            final C2058pg.If r2 = C2058pg.m9731(intent);
            if (r2.f9384 != null && r2.f9388 != null) {
                this.f7210.post(new Runnable() { // from class: o.hb.4
                    @Override // java.lang.Runnable
                    public void run() {
                        String str = r2.f9388;
                        char c = 65535;
                        switch (str.hashCode()) {
                            case -817292239:
                                if (str.equals("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 433731059:
                                if (str.equals("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_START")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                switch (r2.f9384) {
                                    case StreamingPlayback:
                                        C1283.m16862("nf_offlineBroadcast", "onStreamingPlayStartReceived");
                                        C1843hb.this.f7209.mo7039();
                                        return;
                                    case OfflinePlayback:
                                        C1283.m16862("nf_offlineBroadcast", "onOfflinePlayStartReceived");
                                        return;
                                    default:
                                        return;
                                }
                            case 1:
                                switch (r2.f9384) {
                                    case StreamingPlayback:
                                        C1283.m16862("nf_offlineBroadcast", "onStreamingPlayStopReceived");
                                        C1843hb.this.f7209.mo7037();
                                        return;
                                    case OfflinePlayback:
                                        C1283.m16862("nf_offlineBroadcast", "onOfflinePlayStopReceived");
                                        return;
                                    default:
                                        return;
                                }
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7030(Intent intent) {
        final String r2 = AG.m3332(intent);
        if (r2 != null) {
            this.f7210.post(new Runnable() { // from class: o.hb.5
                @Override // java.lang.Runnable
                public void run() {
                    String str = r2;
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -1141868828:
                            if (str.equals("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_ACTIVE")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 39639845:
                            if (str.equals("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 748271876:
                            if (str.equals("com.netflix.mediaclient.intent.action.ACCOUNT_DATA_FETCHED")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            C1843hb.this.f7209.C_();
                            return;
                        case 1:
                            C1843hb.this.f7209.mo7040();
                            return;
                        case 2:
                            C1843hb.this.f7209.mo7038();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    public C1843hb(Context context, If r3, Looper looper) {
        this.f7207 = context;
        this.f7210 = new Handler(looper);
        this.f7209 = r3;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7036() {
        this.f7206 = true;
        AG.m3331(this.f7207, this.f7208, null, "com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_START", "com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP");
        AG.m3334(this.f7207, this.f7211, null, "com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_ACTIVE", "com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE", "com.netflix.mediaclient.intent.action.ACCOUNT_DATA_FETCHED");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7035() {
        if (this.f7206) {
            AG.m3336(this.f7207, this.f7208);
            AG.m3329(this.f7207, this.f7211);
        }
        this.f7206 = false;
        this.f7210.removeCallbacksAndMessages(null);
    }
}
