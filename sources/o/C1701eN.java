package o;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Handler;
import android.view.KeyEvent;
@TargetApi(21)
/* renamed from: o.eN  reason: case insensitive filesystem */
public class C1701eN implements AbstractC0358 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f6548;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6549 = "";

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1698eK f6550;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f6551;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f6552;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f6553;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Context f6554;

    /* renamed from: ˏ  reason: contains not printable characters */
    private MediaSession f6555;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f6556 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private VolumeProvider f6557;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private BroadcastReceiver f6558;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC0346 f6559;

    public C1701eN(C1698eK eKVar, AbstractC0346 r5) {
        C1283.m16862("nf_media_session_controller", "Initializing MediaSessionController");
        this.f6554 = eKVar.m16093();
        this.f6550 = eKVar;
        this.f6559 = r5;
        if (this.f6555 != null) {
            C1283.m16865("nf_media_session_controller", "MediaSession was not destroyed correctly! Destroying it now.");
            m6246();
        }
        this.f6555 = new MediaSession(this.f6554.getApplicationContext(), "Netflix media session");
        m6229();
    }

    @Override // o.AbstractC0358
    /* renamed from: ˋ  reason: contains not printable characters */
    public MediaSession.Token mo6242() {
        return this.f6555.getSessionToken();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6247(String str, boolean z) {
        if (C1349Bv.m4107(str)) {
            this.f6549 = str;
        }
        this.f6548 = z;
        MediaMetadata metadata = this.f6555.getController().getMetadata();
        MediaMetadata.Builder builder = metadata == null ? new MediaMetadata.Builder() : new MediaMetadata.Builder(metadata);
        builder.putText("android.media.metadata.TITLE", this.f6549);
        builder.putText("android.media.metadata.ALBUM", this.f6554.getText(((AbstractC2097qq) C1281.m16832(AbstractC2097qq.class)).mo10112(this.f6548)));
        this.f6555.setMetadata(builder.build());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6243(Bitmap bitmap) {
        MediaMetadata metadata = this.f6555.getController().getMetadata();
        MediaMetadata.Builder builder = metadata == null ? new MediaMetadata.Builder() : new MediaMetadata.Builder(metadata);
        builder.putBitmap("android.media.metadata.ALBUM_ART", bitmap);
        this.f6555.setMetadata(builder.build());
        if (this.f6556 > 0) {
            new Handler().post(new Runnable() { // from class: o.eN.4
                @Override // java.lang.Runnable
                public void run() {
                    C1701eN.this.m6232(C1701eN.this.f6556);
                }
            });
            this.f6556 = 0;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6244() {
        C1283.m16862("nf_media_session_controller", "startMediaSession");
        this.f6553 = true;
        this.f6555.setActive(true);
        this.f6555.setFlags(1);
        if (this.f6552 && this.f6557 == null) {
            m6228();
            this.f6555.setPlaybackToRemote(this.f6557);
        }
        this.f6555.setCallback(new MediaSession.Callback() { // from class: o.eN.1
            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                C1283.m16849("nf_media_session_controller", intent);
                KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent.getAction() == 1) {
                    if (keyEvent.getKeyCode() == 126) {
                        try {
                            if (C1701eN.this.f6548) {
                                PendingIntent B_ = C1701eN.this.f6550.B_();
                                if (B_ != null) {
                                    B_.send();
                                }
                            } else {
                                PendingIntent r3 = C1701eN.this.f6550.mo6175();
                                if (r3 != null) {
                                    r3.send();
                                }
                            }
                        } catch (PendingIntent.CanceledException e) {
                        }
                    } else if (keyEvent.getKeyCode() == 127) {
                        try {
                            if (C1701eN.this.f6548) {
                                PendingIntent B_2 = C1701eN.this.f6550.B_();
                                if (B_2 != null) {
                                    B_2.send();
                                }
                            } else {
                                PendingIntent r32 = C1701eN.this.f6550.mo6168();
                                if (r32 != null) {
                                    r32.send();
                                }
                            }
                        } catch (PendingIntent.CanceledException e2) {
                        }
                    } else {
                        C1276.m16820().mo5731(new Throwable("SPY-7597 - MediaSession::onMediaButtonEvent() got weird code: " + keyEvent.getKeyCode()));
                    }
                }
                return super.onMediaButtonEvent(intent);
            }
        });
        m6245(false, false);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6248() {
        C1283.m16862("nf_media_session_controller", "stopMediaSession");
        this.f6553 = false;
        m6232(1);
        this.f6555.setActive(false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6245(boolean z, boolean z2) {
        this.f6548 = z2;
        if (this.f6548) {
            this.f6556 = 2;
        } else {
            m6232(z ? 2 : 3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6232(int i) {
        if (this.f6555 != null) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            if (this.f6548) {
                builder.setActions(4);
            } else {
                builder.setActions(512);
            }
            builder.setState(i, -1, 1.0f);
            this.f6555.setPlaybackState(builder.build());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6241(int i, boolean z) {
        this.f6551 = AT.m3413(i, 0, 100);
        if (!m6233()) {
            if (this.f6557 != null) {
                C1283.m16863("nf_media_session_controller", "setCurrentVolume:%d", Integer.valueOf(this.f6551));
                if (!(this.f6557 == null || this.f6555 == null)) {
                    this.f6557.setCurrentVolume(this.f6551 / 10);
                }
            }
            if (z) {
                this.f6550.m6166(m6231(this.f6554, this.f6550.mo6171(), this.f6551));
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m6233() {
        if (this.f6559.mo13900()) {
            return false;
        }
        if (!this.f6553) {
            return true;
        }
        C1283.m16865("nf_media_session_controller", "Lock screen is visible and lock screen is NOT enabled! Remove it!");
        m6248();
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6246() {
        C1283.m16854("nf_media_session_controller", "destroy");
        m6239();
        this.f6555.release();
        this.f6555 = null;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m6228() {
        this.f6557 = new VolumeProvider(2, 10, this.f6551 / 10) { // from class: o.eN.5
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i) {
                if (i == 1 || i == -1) {
                    C1283.m16863("nf_media_session_controller", "onAdjustVolume: %d", Integer.valueOf(i));
                    C1701eN.this.m6241(C1701eN.this.m6240() + (i * 10), true);
                    return;
                }
                C1283.m16844("nf_media_session_controller", "onAdjustVolume strange direction %d, skipping", Integer.valueOf(i));
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i) {
                C1283.m16863("nf_media_session_controller", "onSetVolumeTo:%d", Integer.valueOf(i));
                C1701eN.this.m6241(i * 10, true);
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private int m6240() {
        return this.f6551;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m6229() {
        m6239();
        this.f6558 = new BroadcastReceiver() { // from class: o.eN.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                C1283.m16849("nf_media_session_controller", intent);
                String stringExtra = intent.getStringExtra("stringBlob");
                C1701eN.this.f6552 = false;
                try {
                    C1702eO eOVar = new C1702eO(stringExtra);
                    if (eOVar != null) {
                        C1701eN.this.f6552 = eOVar.m6249();
                    }
                } catch (Exception e) {
                    C1283.m16847("nf_media_session_controller", "Failed to extract capability data: ", e);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_CAPABILITY");
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.MDX");
        this.f6554.getApplicationContext().registerReceiver(this.f6558, intentFilter);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m6239() {
        if (this.f6558 != null) {
            this.f6554.getApplicationContext().unregisterReceiver(this.f6558);
            this.f6558 = null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m6231(Context context, String str, int i) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_SETVOLUME");
        intent.putExtra("uuid", str);
        intent.putExtra("volume", i);
        intent.setClass(context, ServiceC0966.class);
        intent.addCategory("com.netflix.mediaclient.intent.category.MDX");
        return intent;
    }
}
