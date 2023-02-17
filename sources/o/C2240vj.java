package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.ui.mdx.RemotePlayer$1;
import java.util.Set;
/* renamed from: o.vj  reason: case insensitive filesystem */
public class C2240vj extends BroadcastReceiver implements AbstractC2238vh {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Set<String> f11328 = new RemotePlayer$1();

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f11329;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f11330 = "PLAY";

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f11331;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final NetflixActivity f11332;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f11333;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C2244vn f11334 = new C2244vn();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f11335;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f11336;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final Cif f11337;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f11338;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Language f11339;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1702eO f11340;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f11341;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f11342;

    /* renamed from: o.vj$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˊ */
        void mo11504();

        /* renamed from: ˊ */
        void mo11505(C1702eO eOVar);

        /* renamed from: ˊ */
        void mo11506(C2232vb vbVar);

        /* renamed from: ˋ */
        void mo11507();

        /* renamed from: ˋ */
        void mo11508(int i, String str);

        /* renamed from: ˋ */
        void mo11509(C0247 v);

        /* renamed from: ˎ */
        void mo11510();

        /* renamed from: ˎ */
        void mo11511(int i);

        /* renamed from: ˎ */
        void mo11512(Language language);

        /* renamed from: ˏ */
        void mo11513(boolean z);

        /* renamed from: ॱ */
        void mo11515();

        /* renamed from: ॱ */
        void mo11516(boolean z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m12155() {
        return this.f11333 || this.f11335;
    }

    public C2240vj(NetflixActivity netflixActivity, Cif ifVar) {
        C1283.m16846("mdx_remote_player", "Remote player created");
        if (netflixActivity == null) {
            throw new IllegalArgumentException("activity can not be null!");
        } else if (ifVar == null) {
            throw new IllegalArgumentException("owner can not be null!");
        } else {
            this.f11332 = netflixActivity;
            this.f11337 = ifVar;
            m12149();
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m12149() {
        IntentFilter intentFilter = new IntentFilter("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_READY");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_NOTREADY");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_AUDIOSUB");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_CAPABILITY");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_DIALOGCANCEL");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_DIALOGSHOW");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_ERROR");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_MOVIEMETADATA_AVAILABLE");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDXUPDATE_MOVIEMETADA");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_TARGETLIST");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION__NETWORK_CONNECTIVITY_CHANGE");
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.MDX");
        intentFilter.setPriority(999);
        try {
            this.f11332.registerReceiver(this, intentFilter);
            this.f11338 = true;
        } catch (Throwable th) {
            C1283.m16847("mdx_remote_player", "Failed to register ", th);
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m12148() {
        try {
            if (this.f11338) {
                this.f11338 = false;
                this.f11332.unregisterReceiver(this);
            }
        } catch (Throwable th) {
            C1283.m16847("mdx_remote_player", "Failed to unregister ", th);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12159() {
        this.f11332.sendIntentToNetflixService(m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_GETCAPABILITY"));
        this.f11332.sendIntentToNetflixService(m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_GETSTATE"));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12154(Language language) {
        if (language == null) {
            C1283.m16850("mdx_remote_player", "Language is null!");
        } else if (language.getSelectedAudio() == null) {
            C1283.m16850("mdx_remote_player", "Language selected audio is null!");
        } else if (language.getSelectedSubtitle() == null) {
            C1283.m16850("mdx_remote_player", "Language selected subtitle is null!");
        } else {
            m12145();
            Intent r2 = m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_SETAUDIOSUB");
            if (r2 != null) {
                r2.putExtra("audioTrackId", language.getSelectedAudio().getId());
                r2.putExtra("subtitleTrackId", language.getSelectedSubtitle().getId());
                this.f11332.sendIntentToNetflixService(r2);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12161(boolean z) {
        C1283.m16854("mdx_remote_player", "stop sending...");
        this.f11332.sendIntentToNetflixService(m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_STOP"));
        C1283.m16854("mdx_remote_player", "stop sent");
        this.f11330 = "STOP";
        if (z) {
            this.f11332.finish();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m12153() {
        this.f11332.sendIntentToNetflixService(m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_RESUME"));
        this.f11330 = "PLAYING";
        this.f11333 = true;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m12167() {
        this.f11332.sendIntentToNetflixService(m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_PAUSE"));
        this.f11330 = "PAUSE";
        this.f11333 = true;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m12169() {
        this.f11332.sendIntentToNetflixService(m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_SKIP_INTRO"));
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m12152() {
        m12147(-30);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12147(int i) {
        Intent r1 = m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_SKIP");
        if (r1 != null) {
            r1.putExtra("time", i);
            this.f11332.sendIntentToNetflixService(r1);
        }
        this.f11330 = "PLAY";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12157(int i) {
        Intent r1 = m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_SEEK");
        if (r1 != null) {
            r1.putExtra("time", i);
            this.f11332.sendIntentToNetflixService(r1);
        }
        this.f11330 = "PLAY";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12160(String str) {
        Intent r1 = m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_DIALOGRESP");
        if (r1 != null) {
            r1.putExtra(Event.DATA, str);
            this.f11332.sendIntentToNetflixService(r1);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12164(int i) {
        if (this.f11329 <= 0 && i <= 0) {
            C1283.m16854("mdx_remote_player", "Volume is already less than 0 and it can not be turned down more. Do nothing.");
        } else if (this.f11329 < 100 || i < 100) {
            if (i > 100) {
                i = 100;
            }
            if (i < 0) {
                i = 0;
            }
            this.f11329 = i;
            Intent r2 = m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_SETVOLUME");
            if (r2 != null) {
                r2.putExtra("volume", this.f11329);
                this.f11332.sendIntentToNetflixService(r2);
            }
        } else {
            C1283.m16854("mdx_remote_player", "Volume is already more than 100 and it can not be turned up more. Do nothing.");
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m12150() {
        return this.f11329;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public int m12156() {
        return this.f11342;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m12163() {
        m12148();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean m12165() {
        return "PLAYING".equalsIgnoreCase(this.f11330) || "preplay".equalsIgnoreCase(this.f11330);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean m12158() {
        return "PLAYING".equalsIgnoreCase(this.f11330);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean m12162() {
        return "PAUSE".equalsIgnoreCase(this.f11330) || "prepause".equalsIgnoreCase(this.f11330);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Intent m12146(String str) {
        C2059ph serviceManager = this.f11332.getServiceManager();
        if (C1298Aa.m3504(serviceManager)) {
            return uT.m11652(this.f11332, str, serviceManager.m9811().mo6171());
        }
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1348Bu.m4093();
        AbstractC2245vo r3 = this.f11334.m12170(intent.getAction());
        if (r3 != null) {
            r3.mo12131(this, intent);
        } else {
            C1283.m16850("mdx_remote_player", "Event not supported " + intent.getAction());
        }
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ॱ */
    public void mo12142() {
        this.f11337.mo11515();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public C1702eO m12151() {
        return this.f11340;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public Language m12166() {
        return this.f11339;
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ˊ */
    public void mo12134(C1702eO eOVar) {
        this.f11340 = eOVar;
        this.f11337.mo11505(eOVar);
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ॱ */
    public void mo12143(Language language) {
        this.f11339 = language;
        this.f11337.mo11512(language);
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ˊ */
    public void mo12135(C2232vb vbVar) {
        this.f11337.mo11506(vbVar);
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ˏ */
    public void mo12141(boolean z) {
        this.f11341 = z;
        this.f11337.mo11513(z);
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ˎ */
    public void mo12138(int i) {
        this.f11331 = i;
        this.f11337.mo11511(i);
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ˎ */
    public void mo12139(int i, String str) {
        m12145();
        this.f11337.mo11508(i, str);
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ˋ */
    public void mo12136() {
        this.f11337.mo11507();
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ˋ */
    public void mo12137(String str, int i, int i2, boolean z, String str2) {
        if ("END_PLAYBACK".equalsIgnoreCase(str)) {
            C1283.m16854("mdx_remote_player", "DESTROY: end of playback");
            m12145();
            this.f11337.mo11510();
        } else if ("PLAYING".equalsIgnoreCase(str)) {
            if (m12155()) {
                C1283.m16854("mdx_remote_player", "PLAYING: Do nothing, user just did trickplay");
                return;
            } else if (!this.f11336) {
                m12168();
            } else {
                C1283.m16854("mdx_remote_player", "Video is playing");
            }
        } else if ("PAUSE".equalsIgnoreCase(str)) {
            if (m12155()) {
                C1283.m16854("mdx_remote_player", "PAUSE: Do nothing, user just did trickplay");
                return;
            }
            C1283.m16854("mdx_remote_player", "Paused...");
        } else if ("prepause".equalsIgnoreCase(str)) {
            C1283.m16854("mdx_remote_player", "PREPAUSE: Start listening to play/pause from target again");
            this.f11333 = false;
            return;
        } else if ("preplay".equalsIgnoreCase(str)) {
            C1283.m16854("mdx_remote_player", "PREPLAY: Start listening to play/pause from target again");
            this.f11333 = false;
        } else if ("preseek".equalsIgnoreCase(str)) {
            C1283.m16854("mdx_remote_player", "PRESEEK: Start listening to video position updates from target again");
            this.f11335 = false;
            return;
        } else if ("PLAY".equalsIgnoreCase(str)) {
            C1283.m16854("mdx_remote_player", "Play, do nothing...");
        } else if ("PROGRESS".equalsIgnoreCase(str)) {
            C1283.m16854("mdx_remote_player", "Progress...");
        } else if ("STALLED".equalsIgnoreCase(str)) {
            C1283.m16854("mdx_remote_player", "Stalled...");
        } else {
            return;
        }
        this.f11330 = str;
        this.f11342 = i;
        this.f11329 = i2;
        f11328.add("END_PLAYBACK");
        this.f11337.mo11509(new C0247(this, m12162(), !m12158() && !m12162(), i, this.f11331, i2, z, str2, f11328.contains(str), null));
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void m12168() {
        C1283.m16854("mdx_remote_player", "Sending request for subtitle/audio data...");
        this.f11332.sendIntentToNetflixService(m12146("com.netflix.mediaclient.intent.action.MDX_ACTION_GETAUDIOSUB"));
        this.f11336 = true;
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ˏ */
    public void mo12140() {
        this.f11337.mo11504();
    }

    @Override // o.AbstractC2238vh
    /* renamed from: ॱ */
    public void mo12144(boolean z) {
        this.f11337.mo11516(z);
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    private void m12145() {
        C1283.m16846("mdx_remote_player", "Resetting language data...");
        this.f11336 = false;
        this.f11339 = null;
    }

    /* renamed from: o.vj$ˊ  reason: contains not printable characters */
    public class C0247 {

        /* renamed from: ʼ  reason: contains not printable characters */
        public final String f11343;

        /* renamed from: ʽ  reason: contains not printable characters */
        public final boolean f11344;

        /* renamed from: ˊ  reason: contains not printable characters */
        public final boolean f11345;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final int f11346;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final int f11347;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean f11348;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final int f11349;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public final boolean f11351;

        /* synthetic */ C0247(C2240vj vjVar, boolean z, boolean z2, int i, int i2, int i3, boolean z3, String str, boolean z4, RemotePlayer$1 remotePlayer$1) {
            this(z, z2, i, i2, i3, z3, str, z4);
        }

        private C0247(boolean z, boolean z2, int i, int i2, int i3, boolean z3, String str, boolean z4) {
            this.f11345 = z;
            this.f11348 = z2;
            this.f11349 = i;
            this.f11346 = i2;
            this.f11347 = i3;
            this.f11351 = z3;
            this.f11343 = str;
            this.f11344 = z4;
        }

        public String toString() {
            return "RemoteTargetState [paused=" + this.f11345 + ", buffering=" + this.f11348 + ", position(seconds)=" + this.f11349 + ", duration=" + this.f11346 + ", volume=" + this.f11347 + ", isInSkipIntroWindow=" + this.f11351 + ", skipIntroText=" + this.f11343 + ", showCastPlayer=" + this.f11344 + "]";
        }
    }
}
